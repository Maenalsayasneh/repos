package h0.v.a;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
/* compiled from: DiffUtil.java */
/* loaded from: classes.dex */
public class g {
    public static final Comparator<c> a = new a();

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public class a implements Comparator<c> {
        @Override // java.util.Comparator
        public int compare(c cVar, c cVar2) {
            return cVar.a - cVar2.a;
        }
    }

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract boolean a(int i, int i2);

        public abstract boolean b(int i, int i2);

        public Object c(int i, int i2) {
            return null;
        }

        public abstract int d();

        public abstract int e();
    }

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static class c {
        public final int a;
        public final int b;
        public final int c;

        public c(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }
    }

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static class d {
        public final List<c> a;
        public final int[] b;
        public final int[] c;
        public final b d;
        public final int e;
        public final int f;
        public final boolean g;

        public d(b bVar, List<c> list, int[] iArr, int[] iArr2, boolean z) {
            int i;
            c cVar;
            int i2;
            this.a = list;
            this.b = iArr;
            this.c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.d = bVar;
            int e = bVar.e();
            this.e = e;
            int d = bVar.d();
            this.f = d;
            this.g = z;
            c cVar2 = list.isEmpty() ? null : list.get(0);
            if (!(cVar2 != null && cVar2.a == 0 && cVar2.b == 0)) {
                list.add(0, new c(0, 0, 0));
            }
            list.add(new c(e, d, 0));
            for (c cVar3 : list) {
                for (int i3 = 0; i3 < cVar3.c; i3++) {
                    int i4 = cVar3.a + i3;
                    int i5 = cVar3.b + i3;
                    int i6 = this.d.a(i4, i5) ? 1 : 2;
                    this.b[i4] = (i5 << 4) | i6;
                    this.c[i5] = (i4 << 4) | i6;
                }
            }
            if (this.g) {
                int i7 = 0;
                for (c cVar4 : this.a) {
                    while (true) {
                        i = cVar4.a;
                        if (i7 < i) {
                            if (this.b[i7] == 0) {
                                int size = this.a.size();
                                int i8 = 0;
                                int i9 = 0;
                                while (true) {
                                    if (i8 < size) {
                                        cVar = this.a.get(i8);
                                        while (true) {
                                            i2 = cVar.b;
                                            if (i9 < i2) {
                                                if (this.c[i9] != 0 || !this.d.b(i7, i9)) {
                                                    i9++;
                                                } else {
                                                    int i10 = this.d.a(i7, i9) ? 8 : 4;
                                                    this.b[i7] = (i9 << 4) | i10;
                                                    this.c[i9] = i10 | (i7 << 4);
                                                }
                                            }
                                        }
                                    }
                                    i9 = cVar.c + i2;
                                    i8++;
                                }
                            }
                            i7++;
                        }
                    }
                    i7 = cVar4.c + i;
                }
            }
        }

        public static f c(Collection<f> collection, int i, boolean z) {
            f fVar;
            Iterator<f> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    fVar = null;
                    break;
                }
                fVar = it.next();
                if (fVar.a == i && fVar.c == z) {
                    it.remove();
                    break;
                }
            }
            while (it.hasNext()) {
                f next = it.next();
                if (z) {
                    next.b--;
                } else {
                    next.b++;
                }
            }
            return fVar;
        }

        public int a(int i) {
            if (i < 0 || i >= this.e) {
                StringBuilder Q0 = i0.d.a.a.a.Q0("Index out of bounds - passed position = ", i, ", old list size = ");
                Q0.append(this.e);
                throw new IndexOutOfBoundsException(Q0.toString());
            }
            int i2 = this.b[i];
            if ((i2 & 15) == 0) {
                return -1;
            }
            return i2 >> 4;
        }

        public void b(r rVar) {
            d dVar;
            int i;
            if (rVar instanceof d) {
                dVar = (d) rVar;
            } else {
                dVar = new d(rVar);
            }
            int i2 = this.e;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i3 = this.e;
            int i4 = this.f;
            for (int size = this.a.size() - 1; size >= 0; size--) {
                c cVar = this.a.get(size);
                int i5 = cVar.a;
                int i6 = cVar.c;
                int i7 = i5 + i6;
                int i8 = cVar.b + i6;
                while (true) {
                    if (i3 > i7) {
                        i3--;
                        int i9 = this.b[i3];
                        if ((i9 & 12) != 0) {
                            int i10 = i9 >> 4;
                            f c = c(arrayDeque, i10, false);
                            if (c != null) {
                                int i11 = (i2 - c.b) - 1;
                                dVar.c(i3, i11);
                                if ((i9 & 4) != 0) {
                                    dVar.d(i11, 1, this.d.c(i3, i10));
                                }
                            } else {
                                arrayDeque.add(new f(i3, (i2 - i3) - 1, true));
                            }
                        } else {
                            dVar.b(i3, 1);
                            i2--;
                        }
                    }
                }
                while (i4 > i8) {
                    i4--;
                    int i12 = this.c[i4];
                    if ((i12 & 12) != 0) {
                        int i13 = i12 >> 4;
                        f c2 = c(arrayDeque, i13, true);
                        if (c2 == null) {
                            arrayDeque.add(new f(i4, i2 - i3, false));
                        } else {
                            dVar.c((i2 - c2.b) - 1, i3);
                            if ((i12 & 4) != 0) {
                                dVar.d(i3, 1, this.d.c(i13, i4));
                            }
                        }
                    } else {
                        dVar.a(i3, 1);
                        i2++;
                    }
                }
                int i14 = cVar.a;
                int i15 = cVar.b;
                for (i = 0; i < cVar.c; i++) {
                    if ((this.b[i14] & 15) == 2) {
                        dVar.d(i14, 1, this.d.c(i14, i15));
                    }
                    i14++;
                    i15++;
                }
                i3 = cVar.a;
                i4 = cVar.b;
            }
            dVar.e();
        }
    }

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static abstract class e<T> {
        public abstract boolean a(T t, T t2);

        public abstract boolean b(T t, T t2);

        public Object c(T t, T t2) {
            return null;
        }
    }

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static class f {
        public int a;
        public int b;
        public boolean c;

        public f(int i, int i2, boolean z) {
            this.a = i;
            this.b = i2;
            this.c = z;
        }
    }

    /* compiled from: DiffUtil.java */
    /* renamed from: h0.v.a.g$g  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0101g {
        public int a;
        public int b;
        public int c;
        public int d;

        public C0101g() {
        }

        public int a() {
            return this.d - this.c;
        }

        public int b() {
            return this.b - this.a;
        }

        public C0101g(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }
    }

    /* compiled from: DiffUtil.java */
    /* loaded from: classes.dex */
    public static class h {
        public int a;
        public int b;
        public int c;
        public int d;
        public boolean e;

        public int a() {
            return Math.min(this.c - this.a, this.d - this.b);
        }
    }

    public static d a(b bVar, boolean z) {
        C0101g gVar;
        ArrayList arrayList;
        ArrayList arrayList2;
        h hVar;
        ArrayList arrayList3;
        ArrayList arrayList4;
        C0101g gVar2;
        C0101g gVar3;
        c cVar;
        int i;
        int i2;
        h hVar2;
        h hVar3;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int e2 = bVar.e();
        int d2 = bVar.d();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        int i10 = 0;
        arrayList6.add(new C0101g(0, e2, 0, d2));
        int i11 = e2 + d2;
        int i12 = 1;
        int i13 = (((i11 + 1) / 2) * 2) + 1;
        int[] iArr = new int[i13];
        int i14 = i13 / 2;
        int[] iArr2 = new int[i13];
        ArrayList arrayList7 = new ArrayList();
        while (!arrayList6.isEmpty()) {
            C0101g gVar4 = (C0101g) arrayList6.remove(arrayList6.size() - i12);
            if (gVar4.b() >= i12 && gVar4.a() >= i12) {
                int a2 = ((gVar4.a() + gVar4.b()) + i12) / 2;
                int i15 = i12 + i14;
                iArr[i15] = gVar4.a;
                iArr2[i15] = gVar4.b;
                int i16 = i10;
                while (i16 < a2) {
                    int i17 = Math.abs(gVar4.b() - gVar4.a()) % 2 == i12 ? i12 : i10;
                    int b2 = gVar4.b() - gVar4.a();
                    int i18 = -i16;
                    int i19 = i18;
                    while (true) {
                        if (i19 > i16) {
                            arrayList = arrayList7;
                            arrayList2 = arrayList6;
                            i = i10;
                            i2 = a2;
                            hVar2 = null;
                            break;
                        }
                        if (i19 == i18 || (i19 != i16 && iArr[i19 + 1 + i14] > iArr[(i19 - 1) + i14])) {
                            i7 = iArr[i19 + 1 + i14];
                            i6 = i7;
                        } else {
                            i7 = iArr[(i19 - 1) + i14];
                            i6 = i7 + 1;
                        }
                        i2 = a2;
                        arrayList2 = arrayList6;
                        int i20 = ((i6 - gVar4.a) + gVar4.c) - i19;
                        if (i16 == 0 || i6 != i7) {
                            arrayList = arrayList7;
                            i8 = i20;
                        } else {
                            i8 = i20 - 1;
                            arrayList = arrayList7;
                        }
                        while (i6 < gVar4.b && i20 < gVar4.d && bVar.b(i6, i20)) {
                            i6++;
                            i20++;
                        }
                        iArr[i19 + i14] = i6;
                        if (i17 != 0) {
                            int i21 = b2 - i19;
                            i9 = i17;
                            if (i21 >= i18 + 1 && i21 <= i16 - 1 && iArr2[i21 + i14] <= i6) {
                                hVar2 = new h();
                                hVar2.a = i7;
                                hVar2.b = i8;
                                hVar2.c = i6;
                                hVar2.d = i20;
                                i = 0;
                                hVar2.e = false;
                                break;
                            }
                        } else {
                            i9 = i17;
                        }
                        i10 = 0;
                        i19 += 2;
                        a2 = i2;
                        arrayList6 = arrayList2;
                        arrayList7 = arrayList;
                        i17 = i9;
                    }
                    if (hVar2 != null) {
                        hVar = hVar2;
                        gVar = gVar4;
                        break;
                    }
                    int i22 = (gVar4.b() - gVar4.a()) % 2 == 0 ? 1 : i;
                    int b3 = gVar4.b() - gVar4.a();
                    int i23 = i18;
                    while (true) {
                        if (i23 > i16) {
                            gVar = gVar4;
                            hVar3 = null;
                            break;
                        }
                        if (i23 == i18 || (i23 != i16 && iArr2[i23 + 1 + i14] < iArr2[(i23 - 1) + i14])) {
                            i4 = iArr2[i23 + 1 + i14];
                            i3 = i4;
                        } else {
                            i4 = iArr2[(i23 - 1) + i14];
                            i3 = i4 - 1;
                        }
                        int i24 = gVar4.d - ((gVar4.b - i3) - i23);
                        int i25 = (i16 == 0 || i3 != i4) ? i24 : i24 + 1;
                        while (i3 > gVar4.a && i24 > gVar4.c) {
                            int i26 = i3 - 1;
                            gVar = gVar4;
                            int i27 = i24 - 1;
                            if (!bVar.b(i26, i27)) {
                                break;
                            }
                            i3 = i26;
                            i24 = i27;
                            gVar4 = gVar;
                        }
                        gVar = gVar4;
                        iArr2[i23 + i14] = i3;
                        if (i22 != 0 && (i5 = b3 - i23) >= i18 && i5 <= i16 && iArr[i5 + i14] >= i3) {
                            hVar3 = new h();
                            hVar3.a = i3;
                            hVar3.b = i24;
                            hVar3.c = i4;
                            hVar3.d = i25;
                            hVar3.e = true;
                            break;
                        }
                        i23 += 2;
                        gVar4 = gVar;
                    }
                    if (hVar3 != null) {
                        hVar = hVar3;
                        break;
                    }
                    i16++;
                    a2 = i2;
                    arrayList6 = arrayList2;
                    arrayList7 = arrayList;
                    gVar4 = gVar;
                    i12 = 1;
                    i10 = 0;
                }
            }
            arrayList = arrayList7;
            arrayList2 = arrayList6;
            gVar = gVar4;
            hVar = null;
            if (hVar != null) {
                if (hVar.a() > 0) {
                    int i28 = hVar.d;
                    int i29 = hVar.b;
                    int i30 = i28 - i29;
                    int i31 = hVar.c;
                    int i32 = hVar.a;
                    int i33 = i31 - i32;
                    if (!(i30 != i33)) {
                        cVar = new c(i32, i29, i33);
                    } else if (hVar.e) {
                        cVar = new c(i32, i29, hVar.a());
                    } else {
                        if (i30 > i33) {
                            cVar = new c(i32, i29 + 1, hVar.a());
                        } else {
                            cVar = new c(i32 + 1, i29, hVar.a());
                        }
                    }
                    arrayList5.add(cVar);
                }
                if (arrayList.isEmpty()) {
                    gVar3 = new C0101g();
                    arrayList4 = arrayList;
                    gVar2 = gVar;
                    i12 = 1;
                } else {
                    i12 = 1;
                    arrayList4 = arrayList;
                    gVar3 = (C0101g) arrayList4.remove(arrayList.size() - 1);
                    gVar2 = gVar;
                }
                gVar3.a = gVar2.a;
                gVar3.c = gVar2.c;
                gVar3.b = hVar.a;
                gVar3.d = hVar.b;
                arrayList3 = arrayList2;
                arrayList3.add(gVar3);
                gVar2.b = gVar2.b;
                gVar2.d = gVar2.d;
                gVar2.a = hVar.c;
                gVar2.c = hVar.d;
                arrayList3.add(gVar2);
            } else {
                arrayList3 = arrayList2;
                arrayList4 = arrayList;
                i12 = 1;
                arrayList4.add(gVar);
            }
            arrayList7 = arrayList4;
            arrayList6 = arrayList3;
            i10 = 0;
        }
        Collections.sort(arrayList5, a);
        return new d(bVar, arrayList5, iArr, iArr2, z);
    }
}
