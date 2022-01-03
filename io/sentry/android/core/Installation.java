package io.sentry.android.core;

import android.content.Context;
import com.pubnub.api.vendor.FileEncryptionUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.UUID;
/* loaded from: classes4.dex */
public final class Installation {
    public static final String INSTALLATION = "INSTALLATION";
    private static final Charset UTF_8 = Charset.forName(FileEncryptionUtil.ENCODING_UTF_8);
    public static String deviceId;

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

    private Installation() {
    }

    public static synchronized String id(Context context) throws RuntimeException {
        synchronized (Installation.class) {
            if (deviceId == null) {
                File file = new File(context.getFilesDir(), INSTALLATION);
                try {
                    if (!file.exists()) {
                        String writeInstallationFile = writeInstallationFile(file);
                        deviceId = writeInstallationFile;
                        return writeInstallationFile;
                    }
                    deviceId = readInstallationFile(file);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            return deviceId;
        }
    }

    public static String readInstallationFile(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            byte[] bArr = new byte[(int) randomAccessFile.length()];
            randomAccessFile.readFully(bArr);
            String str = new String(bArr, UTF_8);
            th = null;
            return str;
        } finally {
            try {
                throw th;
            } finally {
            }
        }
    }

    public static String writeInstallationFile(File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            String uuid = UUID.randomUUID().toString();
            fileOutputStream.write(uuid.getBytes(UTF_8));
            fileOutputStream.flush();
            th = null;
            return uuid;
        } finally {
            try {
                throw th;
            } finally {
            }
        }
    }
}
