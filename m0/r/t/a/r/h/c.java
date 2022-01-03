package m0.r.t.a.r.h;

import com.pubnub.api.vendor.FileEncryptionUtil;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import m0.r.t.a.r.h.o;
/* compiled from: ByteString.java */
/* loaded from: classes4.dex */
public abstract class c implements Iterable<Byte> {
    public static final c c = new k(new byte[0]);

    /* compiled from: ByteString.java */
    /* loaded from: classes4.dex */
    public interface a extends Iterator<Byte> {
        byte b();
    }

    public static c b(Iterator<c> it, int i) {
        if (i == 1) {
            return it.next();
        }
        int i2 = i >>> 1;
        return b(it, i2).c(b(it, i - i2));
    }

    public static c e(String str) {
        try {
            return new k(str.getBytes(FileEncryptionUtil.ENCODING_UTF_8));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    public static b u() {
        return new b(128);
    }

    public abstract void A(OutputStream outputStream, int i, int i2) throws IOException;

    public c c(c cVar) {
        int size = size();
        int size2 = cVar.size();
        if (((long) size) + ((long) size2) < 2147483647L) {
            int[] iArr = o.d;
            o oVar = this instanceof o ? (o) this : null;
            if (cVar.size() == 0) {
                return this;
            }
            if (size() == 0) {
                return cVar;
            }
            int size3 = cVar.size() + size();
            if (size3 < 128) {
                return o.B(this, cVar);
            }
            if (oVar != null) {
                if (cVar.size() + oVar.y.size() < 128) {
                    return new o(oVar.x, o.B(oVar.y, cVar));
                }
            }
            if (oVar == null || oVar.x.o() <= oVar.y.o() || oVar.Z1 <= cVar.o()) {
                if (size3 >= o.d[Math.max(o(), cVar.o()) + 1]) {
                    return new o(this, cVar);
                }
                o.b bVar = new o.b(null);
                bVar.a(this);
                bVar.a(cVar);
                c pop = bVar.a.pop();
                while (!bVar.a.isEmpty()) {
                    pop = new o(bVar.a.pop(), pop);
                }
                return pop;
            }
            return new o(oVar.x, new o(oVar.y, cVar));
        }
        StringBuilder sb = new StringBuilder(53);
        sb.append("ByteString would be too long: ");
        sb.append(size);
        sb.append("+");
        sb.append(size2);
        throw new IllegalArgumentException(sb.toString());
    }

    public void j(byte[] bArr, int i, int i2, int i3) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(i0.d.a.a.a.Q(30, "Source offset < 0: ", i));
        } else if (i2 < 0) {
            throw new IndexOutOfBoundsException(i0.d.a.a.a.Q(30, "Target offset < 0: ", i2));
        } else if (i3 >= 0) {
            int i4 = i + i3;
            if (i4 <= size()) {
                int i5 = i2 + i3;
                if (i5 > bArr.length) {
                    throw new IndexOutOfBoundsException(i0.d.a.a.a.Q(34, "Target end offset < 0: ", i5));
                } else if (i3 > 0) {
                    k(bArr, i, i2, i3);
                }
            } else {
                throw new IndexOutOfBoundsException(i0.d.a.a.a.Q(34, "Source end offset < 0: ", i4));
            }
        } else {
            throw new IndexOutOfBoundsException(i0.d.a.a.a.Q(23, "Length < 0: ", i3));
        }
    }

    public abstract void k(byte[] bArr, int i, int i2, int i3);

    public abstract int o();

    public abstract boolean r();

    public abstract boolean s();

    public abstract int size();

    /* renamed from: t */
    public abstract a iterator();

    @Override // java.lang.Object
    public String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    public abstract int v(int i, int i2, int i3);

    public abstract int w(int i, int i2, int i3);

    public abstract int x();

    public abstract String y(String str) throws UnsupportedEncodingException;

    public String z() {
        try {
            return y(FileEncryptionUtil.ENCODING_UTF_8);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    /* compiled from: ByteString.java */
    /* loaded from: classes4.dex */
    public static final class b extends OutputStream {
        public static final byte[] c = new byte[0];
        public int Y1;
        public final int d;
        public final ArrayList<c> q;
        public int x;
        public byte[] y;

        public b(int i) {
            if (i >= 0) {
                this.d = i;
                this.q = new ArrayList<>();
                this.y = new byte[i];
                return;
            }
            throw new IllegalArgumentException("Buffer size < 0");
        }

        public final void a(int i) {
            this.q.add(new k(this.y));
            int length = this.x + this.y.length;
            this.x = length;
            this.y = new byte[Math.max(this.d, Math.max(i, length >>> 1))];
            this.Y1 = 0;
        }

        public final void b() {
            int i = this.Y1;
            byte[] bArr = this.y;
            if (i >= bArr.length) {
                this.q.add(new k(this.y));
                this.y = c;
            } else if (i > 0) {
                byte[] bArr2 = new byte[i];
                System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i));
                this.q.add(new k(bArr2));
            }
            this.x += this.Y1;
            this.Y1 = 0;
        }

        public synchronized c e() {
            c cVar;
            b();
            ArrayList<c> arrayList = this.q;
            if (!(arrayList instanceof Collection)) {
                ArrayList<c> arrayList2 = new ArrayList<>();
                for (c cVar2 : arrayList) {
                    arrayList2.add(cVar2);
                }
                arrayList = arrayList2;
            }
            if (arrayList.isEmpty()) {
                cVar = c.c;
            } else {
                cVar = c.b(arrayList.iterator(), arrayList.size());
            }
            return cVar;
        }

        @Override // java.lang.Object
        public String toString() {
            int i;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.toHexString(System.identityHashCode(this));
            synchronized (this) {
                i = this.x + this.Y1;
            }
            objArr[1] = Integer.valueOf(i);
            return String.format("<ByteString.Output@%s size=%d>", objArr);
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i) {
            if (this.Y1 == this.y.length) {
                a(1);
            }
            byte[] bArr = this.y;
            int i2 = this.Y1;
            this.Y1 = i2 + 1;
            bArr[i2] = (byte) i;
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i, int i2) {
            byte[] bArr2 = this.y;
            int length = bArr2.length;
            int i3 = this.Y1;
            if (i2 <= length - i3) {
                System.arraycopy(bArr, i, bArr2, i3, i2);
                this.Y1 += i2;
            } else {
                int length2 = bArr2.length - i3;
                System.arraycopy(bArr, i, bArr2, i3, length2);
                int i4 = i2 - length2;
                a(i4);
                System.arraycopy(bArr, i + length2, this.y, 0, i4);
                this.Y1 = i4;
            }
        }
    }
}
