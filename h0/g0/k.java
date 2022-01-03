package h0.g0;

import android.annotation.SuppressLint;
/* compiled from: Operation.java */
/* loaded from: classes.dex */
public interface k {
    @SuppressLint({"SyntheticAccessor"})
    public static final b.c a = new b.c(null);
    @SuppressLint({"SyntheticAccessor"})
    public static final b.C0067b b = new b.C0067b(null);

    /* compiled from: Operation.java */
    /* loaded from: classes.dex */
    public static abstract class b {

        /* compiled from: Operation.java */
        /* loaded from: classes.dex */
        public static final class a extends b {
            public final Throwable a;

            public a(Throwable th) {
                this.a = th;
            }

            public String toString() {
                return String.format("FAILURE (%s)", this.a.getMessage());
            }
        }

        /* compiled from: Operation.java */
        /* renamed from: h0.g0.k$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0067b extends b {
            public C0067b(a aVar) {
            }

            public String toString() {
                return "IN_PROGRESS";
            }
        }

        /* compiled from: Operation.java */
        /* loaded from: classes.dex */
        public static final class c extends b {
            public c() {
            }

            public String toString() {
                return "SUCCESS";
            }

            public c(a aVar) {
            }
        }
    }
}
