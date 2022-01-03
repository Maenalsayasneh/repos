package i0.h.c.j;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
/* compiled from: Component.java */
/* loaded from: classes2.dex */
public final class d<T> {
    public final Set<Class<? super T>> a;
    public final Set<r> b;
    public final int c;
    public final int d;
    public final g<T> e;
    public final Set<Class<?>> f;

    /* compiled from: Component.java */
    /* loaded from: classes2.dex */
    public static class b<T> {
        public final Set<Class<? super T>> a;
        public g<T> e;
        public final Set<r> b = new HashSet();
        public int c = 0;
        public int d = 0;
        public Set<Class<?>> f = new HashSet();

        public b(Class cls, Class[] clsArr, a aVar) {
            HashSet hashSet = new HashSet();
            this.a = hashSet;
            Objects.requireNonNull(cls, "Null interface");
            hashSet.add(cls);
            for (Class cls2 : clsArr) {
                Objects.requireNonNull(cls2, "Null interface");
            }
            Collections.addAll(this.a, clsArr);
        }

        public b<T> a(r rVar) {
            if (!this.a.contains(rVar.a)) {
                this.b.add(rVar);
                return this;
            }
            throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
        }

        public b<T> b() {
            if (this.c == 0) {
                this.c = 1;
                return this;
            }
            throw new IllegalStateException("Instantiation type has already been set.");
        }

        public d<T> c() {
            if (this.e != null) {
                return new d<>(new HashSet(this.a), new HashSet(this.b), this.c, this.d, this.e, this.f, null);
            }
            throw new IllegalStateException("Missing required property: factory.");
        }

        public b<T> d(g<T> gVar) {
            this.e = gVar;
            return this;
        }
    }

    public d(Set set, Set set2, int i, int i2, g gVar, Set set3, a aVar) {
        this.a = Collections.unmodifiableSet(set);
        this.b = Collections.unmodifiableSet(set2);
        this.c = i;
        this.d = i2;
        this.e = gVar;
        this.f = Collections.unmodifiableSet(set3);
    }

    public static <T> b<T> a(Class<T> cls) {
        return new b<>(cls, new Class[0], null);
    }

    @SafeVarargs
    public static <T> d<T> c(T t, Class<T> cls, Class<? super T>... clsArr) {
        b bVar = new b(cls, clsArr, null);
        bVar.d(new g(t) { // from class: i0.h.c.j.b
            public final Object a;

            {
                this.a = r1;
            }

            @Override // i0.h.c.j.g
            public Object a(e eVar) {
                return this.a;
            }
        });
        return bVar.c();
    }

    public boolean b() {
        return this.d == 0;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.a.toArray()) + ">{" + this.c + ", type=" + this.d + ", deps=" + Arrays.toString(this.b.toArray()) + "}";
    }
}
