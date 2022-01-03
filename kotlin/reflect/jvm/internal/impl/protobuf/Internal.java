package kotlin.reflect.jvm.internal.impl.protobuf;

import com.pubnub.api.vendor.FileEncryptionUtil;
import i0.j.f.p.h;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class Internal {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final ByteBuffer EMPTY_BYTE_BUFFER;

    /* loaded from: classes4.dex */
    public interface a {
        int getNumber();
    }

    /* loaded from: classes4.dex */
    public interface b<T extends a> {
        T a(int i);
    }

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(bArr);
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return h.A2(bArr, 0, bArr.length);
    }

    public static String toStringUtf8(byte[] bArr) {
        try {
            return new String(bArr, FileEncryptionUtil.ENCODING_UTF_8);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }
}
