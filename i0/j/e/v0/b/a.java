package i0.j.e.v0.b;

import android.util.Base64;
import com.instabug.library.util.InstabugSDKLogger;
import com.pubnub.api.vendor.FileEncryptionUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
/* compiled from: DataManipulationUtility.java */
/* loaded from: classes2.dex */
public final class a {
    public static String a(String str) {
        try {
            return URLEncoder.encode(str, FileEncryptionUtil.ENCODING_UTF_8);
        } catch (UnsupportedEncodingException e) {
            InstabugSDKLogger.e("a", e.getMessage(), e);
            return null;
        }
    }

    public static String b(String str, String str2) throws Exception {
        Charset forName = Charset.forName("US-ASCII");
        Mac instance = Mac.getInstance("HmacSHA256");
        instance.init(new SecretKeySpec(forName.encode(str).array(), "HmacSHA256"));
        return Base64.encodeToString(instance.doFinal(forName.encode(str2).array()), 2);
    }

    public static byte[] c(String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes(FileEncryptionUtil.ENCODING_UTF_8));
        gZIPOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return byteArray;
    }

    public static String d(String str) throws UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(str.getBytes(FileEncryptionUtil.ENCODING_UTF_8), 0, str.length());
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            int length = digest.length;
            for (int i = 0; i < length; i++) {
                sb.append(String.format("%02x", Integer.valueOf(digest[i] & 255)));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            if (e.getMessage() != null) {
                InstabugSDKLogger.e("a", e.getMessage(), e);
            }
            return null;
        }
    }
}
