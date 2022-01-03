package io.sentry.cache;

import io.sentry.DateUtils;
import io.sentry.ISerializer;
import io.sentry.SentryEnvelope;
import io.sentry.SentryEnvelopeItem;
import io.sentry.SentryItemType;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.Session;
import io.sentry.hints.SessionEnd;
import io.sentry.hints.SessionStart;
import io.sentry.util.Objects;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import k0.c.x.b;
import org.jetbrains.annotations.ApiStatus;
@ApiStatus.Internal
/* loaded from: classes4.dex */
public final class EnvelopeCache extends CacheStrategy implements IEnvelopeCache {
    public static final String CRASH_MARKER_FILE = ".sentry-native/last_crash";
    public static final String PREFIX_CURRENT_SESSION_FILE = "session";
    public static final String SUFFIX_CURRENT_SESSION_FILE = ".json";
    public static final String SUFFIX_ENVELOPE_FILE = ".envelope";
    private final Map<SentryEnvelope, String> fileNameMap = new WeakHashMap();

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

    public EnvelopeCache(SentryOptions sentryOptions) {
        super(sentryOptions, sentryOptions.getCacheDirPath(), sentryOptions.getCacheDirSize());
    }

    private File[] allEnvelopeFiles() {
        File[] listFiles;
        return (!isDirectoryValid() || (listFiles = this.directory.listFiles(b.a)) == null) ? new File[0] : listFiles;
    }

    private File getCurrentSessionFile() {
        return new File(this.directory.getAbsolutePath(), "session.json");
    }

    private synchronized File getEnvelopeFile(SentryEnvelope sentryEnvelope) {
        String str;
        String str2;
        if (this.fileNameMap.containsKey(sentryEnvelope)) {
            str = this.fileNameMap.get(sentryEnvelope);
        } else {
            if (sentryEnvelope.getHeader().getEventId() != null) {
                str2 = sentryEnvelope.getHeader().getEventId().toString();
            } else {
                str2 = UUID.randomUUID().toString();
            }
            String str3 = str2 + SUFFIX_ENVELOPE_FILE;
            this.fileNameMap.put(sentryEnvelope, str3);
            str = str3;
        }
        return new File(this.directory.getAbsolutePath(), str);
    }

    private Date getTimestampFromCrashMarkerFile(File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), CacheStrategy.UTF_8));
            String readLine = bufferedReader.readLine();
            this.options.getLogger().log(SentryLevel.DEBUG, "Crash marker file has %s timestamp.", readLine);
            Date dateTime = DateUtils.getDateTime(readLine);
            $closeResource(null, bufferedReader);
            return dateTime;
        } catch (IOException e) {
            this.options.getLogger().log(SentryLevel.ERROR, "Error reading the crash marker file.", e);
            return null;
        } catch (IllegalArgumentException e2) {
            this.options.getLogger().log(SentryLevel.ERROR, e2, "Error converting the crash timestamp.", new Object[0]);
            return null;
        }
    }

    private void updateCurrentSession(File file, SentryEnvelope sentryEnvelope) {
        Iterable<SentryEnvelopeItem> items = sentryEnvelope.getItems();
        if (items.iterator().hasNext()) {
            SentryEnvelopeItem next = items.iterator().next();
            if (SentryItemType.Session.equals(next.getHeader().getType())) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(next.getData()), CacheStrategy.UTF_8));
                    Session session = (Session) this.serializer.deserialize(bufferedReader, Session.class);
                    if (session == null) {
                        this.options.getLogger().log(SentryLevel.ERROR, "Item of type %s returned null by the parser.", next.getHeader().getType());
                    } else {
                        writeSessionToDisk(file, session);
                    }
                    $closeResource(null, bufferedReader);
                } catch (Exception e) {
                    this.options.getLogger().log(SentryLevel.ERROR, "Item failed to process.", e);
                }
            } else {
                this.options.getLogger().log(SentryLevel.INFO, "Current envelope has a different envelope type %s", next.getHeader().getType());
            }
        } else {
            this.options.getLogger().log(SentryLevel.INFO, "Current envelope %s is empty", file.getAbsolutePath());
        }
    }

    private void writeEnvelopeToDisk(File file, SentryEnvelope sentryEnvelope) {
        if (file.exists()) {
            this.options.getLogger().log(SentryLevel.DEBUG, "Overwriting envelope to offline storage: %s", file.getAbsolutePath());
            if (!file.delete()) {
                this.options.getLogger().log(SentryLevel.ERROR, "Failed to delete: %s", file.getAbsolutePath());
            }
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            this.serializer.serialize(sentryEnvelope, fileOutputStream);
            $closeResource(null, fileOutputStream);
        } catch (Exception e) {
            this.options.getLogger().log(SentryLevel.ERROR, e, "Error writing Envelope %s to offline storage", file.getAbsolutePath());
        }
    }

    private void writeSessionToDisk(File file, Session session) {
        if (file.exists()) {
            this.options.getLogger().log(SentryLevel.DEBUG, "Overwriting session to offline storage: %s", session.getSessionId());
            if (!file.delete()) {
                this.options.getLogger().log(SentryLevel.ERROR, "Failed to delete: %s", file.getAbsolutePath());
            }
        }
        try {
            BufferedWriter fileOutputStream = new FileOutputStream(file);
            fileOutputStream = new BufferedWriter(new OutputStreamWriter(fileOutputStream, CacheStrategy.UTF_8));
            try {
                this.serializer.serialize((ISerializer) session, (Writer) fileOutputStream);
                th = null;
                $closeResource(th, fileOutputStream);
            } catch (Throwable th) {
                try {
                    throw th;
                } finally {
                    $closeResource(th, fileOutputStream);
                }
            }
        } catch (Exception e) {
            this.options.getLogger().log(SentryLevel.ERROR, e, "Error writing Session to offline storage: %s", session.getSessionId());
        }
    }

    @Override // io.sentry.cache.IEnvelopeCache
    public void discard(SentryEnvelope sentryEnvelope) {
        Objects.requireNonNull(sentryEnvelope, "Envelope is required.");
        File envelopeFile = getEnvelopeFile(sentryEnvelope);
        if (envelopeFile.exists()) {
            this.options.getLogger().log(SentryLevel.DEBUG, "Discarding envelope from cache: %s", envelopeFile.getAbsolutePath());
            if (!envelopeFile.delete()) {
                this.options.getLogger().log(SentryLevel.ERROR, "Failed to delete envelope: %s", envelopeFile.getAbsolutePath());
                return;
            }
            return;
        }
        this.options.getLogger().log(SentryLevel.DEBUG, "Envelope was not cached: %s", envelopeFile.getAbsolutePath());
    }

    @Override // java.lang.Iterable
    public Iterator<SentryEnvelope> iterator() {
        File[] allEnvelopeFiles = allEnvelopeFiles();
        ArrayList arrayList = new ArrayList(allEnvelopeFiles.length);
        for (File file : allEnvelopeFiles) {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    arrayList.add(this.serializer.deserializeEnvelope(bufferedInputStream));
                    $closeResource(null, bufferedInputStream);
                } catch (Throwable th) {
                    try {
                        throw th;
                        break;
                    } catch (Throwable th2) {
                        $closeResource(th, bufferedInputStream);
                        throw th2;
                        break;
                    }
                }
            } catch (FileNotFoundException unused) {
                this.options.getLogger().log(SentryLevel.DEBUG, "Envelope file '%s' disappeared while converting all cached files to envelopes.", file.getAbsolutePath());
            } catch (IOException e) {
                this.options.getLogger().log(SentryLevel.ERROR, String.format("Error while reading cached envelope from file %s", file.getAbsolutePath()), e);
            }
        }
        return arrayList.iterator();
    }

    @Override // io.sentry.cache.IEnvelopeCache
    public void store(SentryEnvelope sentryEnvelope, Object obj) {
        Date date;
        Objects.requireNonNull(sentryEnvelope, "Envelope is required.");
        rotateCacheIfNeeded(allEnvelopeFiles());
        File currentSessionFile = getCurrentSessionFile();
        if ((obj instanceof SessionEnd) && !currentSessionFile.delete()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Current envelope doesn't exist.", new Object[0]);
        }
        if (obj instanceof SessionStart) {
            if (currentSessionFile.exists()) {
                this.options.getLogger().log(SentryLevel.WARNING, "Current session is not ended, we'd need to end it.", new Object[0]);
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(currentSessionFile), CacheStrategy.UTF_8));
                    Session session = (Session) this.serializer.deserialize(bufferedReader, Session.class);
                    if (session == null) {
                        this.options.getLogger().log(SentryLevel.ERROR, "Stream from path %s resulted in a null envelope.", currentSessionFile.getAbsolutePath());
                    } else {
                        File file = new File(this.options.getCacheDirPath(), CRASH_MARKER_FILE);
                        if (file.exists()) {
                            this.options.getLogger().log(SentryLevel.INFO, "Crash marker file exists, last Session is gonna be Crashed.", new Object[0]);
                            date = getTimestampFromCrashMarkerFile(file);
                            if (!file.delete()) {
                                this.options.getLogger().log(SentryLevel.ERROR, "Failed to delete the crash marker file. %s.", file.getAbsolutePath());
                            }
                            session.update(Session.State.Crashed, null, true);
                        } else {
                            date = null;
                        }
                        session.end(date);
                        SentryEnvelope from = SentryEnvelope.from(this.serializer, session, this.options.getSdkVersion());
                        writeEnvelopeToDisk(getEnvelopeFile(from), from);
                    }
                    $closeResource(null, bufferedReader);
                } catch (Exception e) {
                    this.options.getLogger().log(SentryLevel.ERROR, "Error processing session.", e);
                }
                if (!currentSessionFile.delete()) {
                    this.options.getLogger().log(SentryLevel.WARNING, "Failed to delete the current session file.", new Object[0]);
                }
            }
            updateCurrentSession(currentSessionFile, sentryEnvelope);
        }
        File envelopeFile = getEnvelopeFile(sentryEnvelope);
        if (envelopeFile.exists()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Not adding Envelope to offline storage because it already exists: %s", envelopeFile.getAbsolutePath());
            return;
        }
        this.options.getLogger().log(SentryLevel.DEBUG, "Adding Envelope to offline storage: %s", envelopeFile.getAbsolutePath());
        writeEnvelopeToDisk(envelopeFile, sentryEnvelope);
    }
}
