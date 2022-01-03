package k0.b.z.h;

import k0.b.y.f;
/* compiled from: AppendOnlyLinkedArrayList.java */
/* loaded from: classes4.dex */
public class a<T> {
    public final Object[] a;
    public Object[] b;
    public int c;

    /* compiled from: AppendOnlyLinkedArrayList.java */
    /* renamed from: k0.b.z.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface AbstractC0237a<T> extends f<T> {
        @Override // k0.b.y.f
        boolean test(T t);
    }

    public a(int i) {
        Object[] objArr = new Object[i + 1];
        this.a = objArr;
        this.b = objArr;
    }

    public void a(T t) {
        int i = this.c;
        if (i == 4) {
            Object[] objArr = new Object[5];
            this.b[4] = objArr;
            this.b = objArr;
            i = 0;
        }
        this.b[i] = t;
        this.c = i + 1;
    }

    public void b(AbstractC0237a<? super T> aVar) {
        Object obj;
        Object[] objArr = this.a;
        while (objArr != null) {
            int i = 0;
            while (i < 4 && (obj = objArr[i]) != null) {
                if (!aVar.test(obj)) {
                    i++;
                } else {
                    return;
                }
            }
            objArr = objArr[4];
        }
    }
}
