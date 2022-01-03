package io.sentry.cache;

import com.pubnub.api.vendor.FileEncryptionUtil;
import io.sentry.ISerializer;
import io.sentry.SentryEnvelope;
import io.sentry.SentryEnvelopeItem;
import io.sentry.SentryItemType;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.Session;
import io.sentry.util.Objects;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import k0.c.x.a;
/* loaded from: classes4.dex */
public abstract class CacheStrategy {
    public static final Charset UTF_8 = Charset.forName(FileEncryptionUtil.ENCODING_UTF_8);
    public final File directory;
    private final int maxSize;
    public final SentryOptions options;
    public final ISerializer serializer;

    private static /* synthetic */ void $closeResource(Throwable th, AutoCloseable autoCloseable) {
        if (th != null) {
            try {
                autoCloseable.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            autoCloseable.close();
        }
    }

    public CacheStrategy(SentryOptions sentryOptions, String str, int i) {
        Objects.requireNonNull(str, "Directory is required.");
        this.options = (SentryOptions) Objects.requireNonNull(sentryOptions, "SentryOptions is required.");
        this.serializer = sentryOptions.getSerializer();
        this.directory = new File(str);
        this.maxSize = i;
    }

    private SentryEnvelope buildNewEnvelope(SentryEnvelope sentryEnvelope, SentryEnvelopeItem sentryEnvelopeItem) {
        ArrayList arrayList = new ArrayList();
        for (SentryEnvelopeItem sentryEnvelopeItem2 : sentryEnvelope.getItems()) {
            arrayList.add(sentryEnvelopeItem2);
        }
        arrayList.add(sentryEnvelopeItem);
        return new SentryEnvelope(sentryEnvelope.getHeader(), arrayList);
    }

    private Session getFirstSession(SentryEnvelope sentryEnvelope) {
        for (SentryEnvelopeItem sentryEnvelopeItem : sentryEnvelope.getItems()) {
            if (isSessionType(sentryEnvelopeItem)) {
                return readSession(sentryEnvelopeItem);
            }
        }
        return null;
    }

    private boolean isSessionType(SentryEnvelopeItem sentryEnvelopeItem) {
        if (sentryEnvelopeItem == null) {
            return false;
        }
        return sentryEnvelopeItem.getHeader().getType().equals(SentryItemType.Session);
    }

    private boolean isValidEnvelope(SentryEnvelope sentryEnvelope) {
        return sentryEnvelope != null && sentryEnvelope.getItems().iterator().hasNext();
    }

    private boolean isValidSession(Session session) {
        if (session == null || !session.getStatus().equals(Session.State.Ok) || session.getSessionId() == null) {
            return false;
        }
        return true;
    }

    private void moveInitFlagIfNecessary(File file, File[] fileArr) {
        Boolean init;
        SentryEnvelope readEnvelope = readEnvelope(file);
        if (isValidEnvelope(readEnvelope)) {
            Session firstSession = getFirstSession(readEnvelope);
            if (isValidSession(firstSession) && (init = firstSession.getInit()) != null && init.booleanValue()) {
                for (File file2 : fileArr) {
                    SentryEnvelope readEnvelope2 = readEnvelope(file2);
                    if (isValidEnvelope(readEnvelope2)) {
                        SentryEnvelopeItem sentryEnvelopeItem = null;
                        Iterator<SentryEnvelopeItem> it = readEnvelope2.getItems().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            SentryEnvelopeItem next = it.next();
                            if (isSessionType(next)) {
                                Session readSession = readSession(next);
                                if (isValidSession(readSession)) {
                                    Boolean init2 = readSession.getInit();
                                    if (init2 != null && init2.booleanValue()) {
                                        this.options.getLogger().log(SentryLevel.ERROR, "Session %s has 2 times the init flag.", firstSession.getSessionId());
                                        return;
                                    } else if (firstSession.getSessionId().equals(readSession.getSessionId())) {
                                        readSession.setInitAsTrue();
                                        try {
                                            sentryEnvelopeItem = SentryEnvelopeItem.fromSession(this.serializer, readSession);
                                            it.remove();
                                            break;
                                        } catch (IOException e) {
                                            this.options.getLogger().log(SentryLevel.ERROR, e, "Failed to create new envelope item for the session %s", firstSession.getSessionId());
                                        }
                                    }
                                } else {
                                    continue;
                                }
                            }
                        }
                        if (sentryEnvelopeItem != null) {
                            SentryEnvelope buildNewEnvelope = buildNewEnvelope(readEnvelope2, sentryEnvelopeItem);
                            long lastModified = file2.lastModified();
                            if (!file2.delete()) {
                                this.options.getLogger().log(SentryLevel.WARNING, "File can't be deleted: %s", file2.getAbsolutePath());
                            }
                            saveNewEnvelope(buildNewEnvelope, file2, lastModified);
                            return;
                        }
                    }
                }
            }
        }
    }

    private SentryEnvelope readEnvelope(File file) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            SentryEnvelope deserializeEnvelope = this.serializer.deserializeEnvelope(bufferedInputStream);
            $closeResource(null, bufferedInputStream);
            return deserializeEnvelope;
        } catch (IOException e) {
            this.options.getLogger().log(SentryLevel.ERROR, "Failed to deserialize the envelope.", e);
            return null;
        }
    }

    private Session readSession(SentryEnvelopeItem sentryEnvelopeItem) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(sentryEnvelopeItem.getData()), UTF_8));
            Session session = (Session) this.serializer.deserialize(bufferedReader, Session.class);
            $closeResource(null, bufferedReader);
            return session;
        } catch (Exception e) {
            this.options.getLogger().log(SentryLevel.ERROR, "Failed to deserialize the session.", e);
            return null;
        }
    }

    private void saveNewEnvelope(SentryEnvelope sentryEnvelope, File file, long j) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            this.serializer.serialize(sentryEnvelope, fileOutputStream);
            file.setLastModified(j);
            $closeResource(null, fileOutputStream);
        } catch (Exception e) {
            this.options.getLogger().log(SentryLevel.ERROR, "Failed to serialize the new envelope to the disk.", e);
        }
    }

    private void sortFilesOldestToNewest(File[] fileArr) {
        if (fileArr.length > 1) {
            Arrays.sort(fileArr, a.c);
        }
    }

    public boolean isDirectoryValid() {
        if (this.directory.isDirectory() && this.directory.canWrite() && this.directory.canRead()) {
            return true;
        }
        this.options.getLogger().log(SentryLevel.ERROR, "The directory for caching files is inaccessible.: %s", this.directory.getAbsolutePath());
        return false;
    }

    public void rotateCacheIfNeeded(File[] fileArr) {
        int length = fileArr.length;
        if (length >= this.maxSize) {
            this.options.getLogger().log(SentryLevel.WARNING, "Cache folder if full (respecting maxSize). Rotating files", new Object[0]);
            int i = (length - this.maxSize) + 1;
            sortFilesOldestToNewest(fileArr);
            File[] fileArr2 = (File[]) Arrays.copyOfRange(fileArr, i, length);
            for (int i2 = 0; i2 < i; i2++) {
                File file = fileArr[i2];
                moveInitFlagIfNecessary(file, fileArr2);
                if (!file.delete()) {
                    this.options.getLogger().log(SentryLevel.WARNING, "File can't be deleted: %s", file.getAbsolutePath());
                }
            }
        }
    }
}
