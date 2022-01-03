package i0.j.d.h.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.instabug.featuresrequest.R;
import com.instabug.featuresrequest.ui.custom.SnackbarLayout;
import com.instabug.library.settings.SettingsManager;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import h0.i.i.a0;
import h0.i.i.q;
import h0.i.i.y;
import h0.k.a.e;
import i0.j.d.h.d.j;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: InstaToast.java */
@SuppressFBWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NONNULL_VALUE"})
/* loaded from: classes2.dex */
public final class d {
    public static final Interpolator a = new h0.p.a.a.b();
    public static final Handler b = new Handler(Looper.getMainLooper(), new a());
    public final ViewGroup c;
    public final Context d;
    public final SnackbarLayout e;
    public int f;
    public final j.b g = new b();

    /* compiled from: InstaToast.java */
    /* loaded from: classes2.dex */
    public static class a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            boolean z = false;
            if (i == 0) {
                d dVar = (d) message.obj;
                if (dVar.e.getParent() == null) {
                    ViewGroup.LayoutParams layoutParams = dVar.e.getLayoutParams();
                    if (layoutParams instanceof CoordinatorLayout.f) {
                        b bVar = new b(dVar.g);
                        bVar.f = SwipeDismissBehavior.C(0.0f, 0.1f, 1.0f);
                        bVar.g = SwipeDismissBehavior.C(0.0f, 0.6f, 1.0f);
                        bVar.d = 0;
                        bVar.b = new f(dVar);
                        ((CoordinatorLayout.f) layoutParams).b(bVar);
                    }
                    dVar.c.addView(dVar.e);
                }
                dVar.e.setOnAttachStateChangeListener(new h(dVar));
                SnackbarLayout snackbarLayout = dVar.e;
                AtomicInteger atomicInteger = q.a;
                if (snackbarLayout.isLaidOut()) {
                    dVar.c();
                } else {
                    dVar.e.setOnLayoutChangeListener(new i(dVar));
                }
                return true;
            } else if (i != 1) {
                return false;
            } else {
                d dVar2 = (d) message.obj;
                int i2 = message.arg1;
                if (dVar2.e.getVisibility() == 0) {
                    ViewGroup.LayoutParams layoutParams2 = dVar2.e.getLayoutParams();
                    if (layoutParams2 instanceof CoordinatorLayout.f) {
                        CoordinatorLayout.c cVar = ((CoordinatorLayout.f) layoutParams2).a;
                        if (cVar instanceof SwipeDismissBehavior) {
                            e eVar = ((SwipeDismissBehavior) cVar).a;
                            if ((eVar != null ? eVar.b : 0) != 0) {
                                z = true;
                            }
                        }
                    }
                    if (!z) {
                        y b = q.b(dVar2.e);
                        b.j((float) (-dVar2.e.getHeight()));
                        b.d(d.a);
                        b.c(250);
                        c cVar2 = new c(dVar2, i2);
                        View view = b.a.get();
                        if (view != null) {
                            b.f(view, cVar2);
                        }
                        b.i();
                        return true;
                    }
                }
                dVar2.d(i2);
                return true;
            }
        }
    }

    /* compiled from: InstaToast.java */
    /* loaded from: classes2.dex */
    public class b implements j.b {
        public b() {
        }

        @Override // i0.j.d.h.d.j.b
        public void a() {
            Handler handler = d.b;
            handler.sendMessage(handler.obtainMessage(0, d.this));
        }

        @Override // i0.j.d.h.d.j.b
        public void e(int i) {
            Handler handler = d.b;
            handler.sendMessage(handler.obtainMessage(1, i, 0, d.this));
        }
    }

    /* compiled from: InstaToast.java */
    /* loaded from: classes2.dex */
    public class c extends a0 {
        public c() {
        }

        @Override // h0.i.i.z
        public void b(View view) {
            Objects.requireNonNull(d.this);
            j.a().f(d.this.g);
        }

        @Override // h0.i.i.a0, h0.i.i.z
        public void c(View view) {
            SnackbarLayout snackbarLayout = d.this.e;
            TextView textView = snackbarLayout.c;
            AtomicInteger atomicInteger = q.a;
            textView.setAlpha(0.0f);
            y b = q.b(snackbarLayout.c);
            b.a(1.0f);
            long j = (long) SettingsManager.MAX_ASR_DURATION_IN_SECONDS;
            b.c(j);
            long j2 = (long) 70;
            b.g(j2);
            b.i();
            if (snackbarLayout.d.getVisibility() == 0) {
                snackbarLayout.d.setAlpha(0.0f);
                y b2 = q.b(snackbarLayout.d);
                b2.a(1.0f);
                b2.c(j);
                b2.g(j2);
                b2.i();
            }
        }
    }

    public d(ViewGroup viewGroup) {
        this.c = viewGroup;
        Context context = viewGroup.getContext();
        this.d = context;
        this.e = (SnackbarLayout) LayoutInflater.from(context).inflate(R.layout.ib_fr_insta_toast_layout, viewGroup, false);
    }

    public final Drawable a(Drawable drawable, int i) {
        boolean z;
        Bitmap bitmap;
        if (!(drawable.getIntrinsicWidth() == i && drawable.getIntrinsicHeight() == i) && ((z = drawable instanceof BitmapDrawable))) {
            Resources resources = this.d.getResources();
            if (z) {
                bitmap = ((BitmapDrawable) drawable).getBitmap();
            } else if (drawable instanceof VectorDrawable) {
                VectorDrawable vectorDrawable = (VectorDrawable) drawable;
                Bitmap createBitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                vectorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                vectorDrawable.draw(canvas);
                bitmap = createBitmap;
            } else {
                throw new IllegalArgumentException("unsupported drawable type");
            }
            drawable = new BitmapDrawable(resources, Bitmap.createScaledBitmap(bitmap, i, i, true));
        }
        drawable.setBounds(0, 0, i, i);
        return drawable;
    }

    public final void b(int i) {
        j a2 = j.a();
        j.b bVar = this.g;
        synchronized (a2.b) {
            if (!(a2.d == null || a2.e == null)) {
                if (a2.h(bVar)) {
                    a2.c(a2.d, i);
                } else if (a2.i(bVar)) {
                    a2.c(a2.e, i);
                }
            }
        }
    }

    public final void c() {
        SnackbarLayout snackbarLayout = this.e;
        AtomicInteger atomicInteger = q.a;
        snackbarLayout.setTranslationY((float) (-snackbarLayout.getHeight()));
        y b2 = q.b(this.e);
        b2.j(0.0f);
        b2.d(a);
        b2.c(250);
        c cVar = new c();
        View view = b2.a.get();
        if (view != null) {
            b2.f(view, cVar);
        }
        b2.i();
    }

    public final void d(int i) {
        j a2 = j.a();
        j.b bVar = this.g;
        synchronized (a2.b) {
            if (a2.h(bVar)) {
                a2.d = null;
                if (a2.e != null) {
                    a2.d();
                }
            }
        }
        ViewParent parent = this.e.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.e);
        }
    }
}
