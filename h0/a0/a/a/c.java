package h0.a0.a.a;

import com.pubnub.api.vendor.FileEncryptionUtil;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
/* compiled from: Table.java */
/* loaded from: classes.dex */
public class c {
    public int a;
    public ByteBuffer b;

    /* compiled from: Table.java */
    /* loaded from: classes.dex */
    public static class a extends ThreadLocal<CharsetDecoder> {
        @Override // java.lang.ThreadLocal
        public CharsetDecoder initialValue() {
            return Charset.forName(FileEncryptionUtil.ENCODING_UTF_8).newDecoder();
        }
    }

    /* compiled from: Table.java */
    /* loaded from: classes.dex */
    public static class b extends ThreadLocal<Charset> {
        @Override // java.lang.ThreadLocal
        public Charset initialValue() {
            return Charset.forName(FileEncryptionUtil.ENCODING_UTF_8);
        }
    }

    static {
        new a();
        new b();
        new ThreadLocal();
    }

    public int a(int i) {
        int i2 = this.a;
        int i3 = i2 - this.b.getInt(i2);
        if (i < this.b.getShort(i3)) {
            return this.b.getShort(i3 + i);
        }
        return 0;
    }
}
