package h0.i.i;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: WindowInsetsControllerCompat.java */
/* loaded from: classes.dex */
public final class f0 {
    public final e a;

    /* compiled from: WindowInsetsControllerCompat.java */
    /* loaded from: classes.dex */
    public static class a extends e {
        public final Window a;
        public final View b;

        public a(Window window, View view) {
            this.a = window;
            this.b = view;
        }

        @Override // h0.i.i.f0.e
        public void b(int i) {
            for (int i2 = 1; i2 <= 256; i2 <<= 1) {
                if ((i & i2) != 0) {
                    if (i2 == 1) {
                        c(4);
                        this.a.clearFlags(RecyclerView.b0.FLAG_ADAPTER_FULLUPDATE);
                    } else if (i2 == 2) {
                        c(2);
                    } else if (i2 == 8) {
                        View view = this.b;
                        if (view == null || (!view.isInEditMode() && !view.onCheckIsTextEditor())) {
                            view = this.a.getCurrentFocus();
                        } else {
                            view.requestFocus();
                        }
                        if (view == null) {
                            view = this.a.findViewById(16908290);
                        }
                        if (view != null && view.hasWindowFocus()) {
                            view.post(new e0(this, view));
                        }
                    }
                }
            }
        }

        public void c(int i) {
            View decorView = this.a.getDecorView();
            decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
        }
    }

    /* compiled from: WindowInsetsControllerCompat.java */
    /* loaded from: classes.dex */
    public static class b extends a {
        public b(Window window, View view) {
            super(window, view);
        }
    }

    /* compiled from: WindowInsetsControllerCompat.java */
    /* loaded from: classes.dex */
    public static class c extends b {
        public c(Window window, View view) {
            super(window, view);
        }

        @Override // h0.i.i.f0.e
        public void a(boolean z) {
            if (z) {
                this.a.clearFlags(134217728);
                this.a.addFlags(Integer.MIN_VALUE);
                View decorView = this.a.getDecorView();
                decorView.setSystemUiVisibility(16 | decorView.getSystemUiVisibility());
                return;
            }
            c(16);
        }
    }

    /* compiled from: WindowInsetsControllerCompat.java */
    /* loaded from: classes.dex */
    public static class e {
        public void a(boolean z) {
        }

        public void b(int i) {
        }
    }

    public f0(WindowInsetsController windowInsetsController) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.a = new d(windowInsetsController, this);
        } else {
            this.a = new e();
        }
    }

    /* compiled from: WindowInsetsControllerCompat.java */
    /* loaded from: classes.dex */
    public static class d extends e {
        public final WindowInsetsController a;

        public d(Window window, f0 f0Var) {
            this.a = window.getInsetsController();
        }

        @Override // h0.i.i.f0.e
        public void a(boolean z) {
            if (z) {
                this.a.setSystemBarsAppearance(16, 16);
            } else {
                this.a.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // h0.i.i.f0.e
        public void b(int i) {
            this.a.show(i);
        }

        public d(WindowInsetsController windowInsetsController, f0 f0Var) {
            this.a = windowInsetsController;
        }
    }

    public f0(Window window, View view) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            this.a = new d(window, this);
        } else if (i >= 26) {
            this.a = new c(window, view);
        } else {
            this.a = new b(window, view);
        }
    }
}
