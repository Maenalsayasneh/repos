package h0.i.j;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ListView;
import h0.i.i.q;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: AutoScrollHelper.java */
/* loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {
    public static final int c = ViewConfiguration.getTapTimeout();
    public final C0079a d;
    public boolean f2;
    public boolean g2;
    public boolean h2;
    public boolean i2;
    public boolean j2;
    public final View x;
    public Runnable y;
    public final Interpolator q = new AccelerateInterpolator();
    public float[] Y1 = {0.0f, 0.0f};
    public float[] Z1 = {Float.MAX_VALUE, Float.MAX_VALUE};
    public float[] c2 = {0.0f, 0.0f};
    public float[] d2 = {0.0f, 0.0f};
    public float[] e2 = {Float.MAX_VALUE, Float.MAX_VALUE};
    public int a2 = 1;
    public int b2 = c;

    /* compiled from: AutoScrollHelper.java */
    /* renamed from: h0.i.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0079a {
        public int a;
        public int b;
        public float c;
        public float d;
        public float j;
        public int k;
        public long e = Long.MIN_VALUE;
        public long i = -1;
        public long f = 0;
        public int g = 0;
        public int h = 0;

        public final float a(long j) {
            long j2 = this.e;
            if (j < j2) {
                return 0.0f;
            }
            long j3 = this.i;
            if (j3 < 0 || j < j3) {
                return a.b(((float) (j - j2)) / ((float) this.a), 0.0f, 1.0f) * 0.5f;
            }
            float f = this.j;
            return (a.b(((float) (j - j3)) / ((float) this.k), 0.0f, 1.0f) * f) + (1.0f - f);
        }
    }

    /* compiled from: AutoScrollHelper.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (aVar.i2) {
                if (aVar.g2) {
                    aVar.g2 = false;
                    C0079a aVar2 = aVar.d;
                    Objects.requireNonNull(aVar2);
                    long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                    aVar2.e = currentAnimationTimeMillis;
                    aVar2.i = -1;
                    aVar2.f = currentAnimationTimeMillis;
                    aVar2.j = 0.5f;
                    aVar2.g = 0;
                    aVar2.h = 0;
                }
                C0079a aVar3 = a.this.d;
                if ((aVar3.i > 0 && AnimationUtils.currentAnimationTimeMillis() > aVar3.i + ((long) aVar3.k)) || !a.this.e()) {
                    a.this.i2 = false;
                    return;
                }
                a aVar4 = a.this;
                if (aVar4.h2) {
                    aVar4.h2 = false;
                    Objects.requireNonNull(aVar4);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    aVar4.x.onTouchEvent(obtain);
                    obtain.recycle();
                }
                if (aVar3.f != 0) {
                    long currentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                    float a = aVar3.a(currentAnimationTimeMillis2);
                    aVar3.f = currentAnimationTimeMillis2;
                    float f = ((float) (currentAnimationTimeMillis2 - aVar3.f)) * ((a * 4.0f) + (-4.0f * a * a));
                    aVar3.g = (int) (aVar3.c * f);
                    int i = (int) (f * aVar3.d);
                    aVar3.h = i;
                    ((c) a.this).k2.scrollListBy(i);
                    View view = a.this.x;
                    AtomicInteger atomicInteger = q.a;
                    view.postOnAnimation(this);
                    return;
                }
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
        }
    }

    public a(View view) {
        C0079a aVar = new C0079a();
        this.d = aVar;
        this.x = view;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float[] fArr = this.e2;
        float f2 = ((float) ((int) ((1575.0f * f) + 0.5f))) / 1000.0f;
        fArr[0] = f2;
        fArr[1] = f2;
        float[] fArr2 = this.d2;
        float f3 = ((float) ((int) ((f * 315.0f) + 0.5f))) / 1000.0f;
        fArr2[0] = f3;
        fArr2[1] = f3;
        float[] fArr3 = this.Z1;
        fArr3[0] = Float.MAX_VALUE;
        fArr3[1] = Float.MAX_VALUE;
        float[] fArr4 = this.Y1;
        fArr4[0] = 0.2f;
        fArr4[1] = 0.2f;
        float[] fArr5 = this.c2;
        fArr5[0] = 0.001f;
        fArr5[1] = 0.001f;
        aVar.a = 500;
        aVar.b = 500;
    }

    public static float b(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final float a(int i, float f, float f2, float f3) {
        float f4;
        int i2;
        float f5;
        float b2 = b(this.Y1[i] * f2, 0.0f, this.Z1[i]);
        float c2 = c(f2 - f, b2) - c(f, b2);
        if (c2 < 0.0f) {
            f5 = -this.q.getInterpolation(-c2);
        } else if (c2 > 0.0f) {
            f5 = this.q.getInterpolation(c2);
        } else {
            f4 = 0.0f;
            i2 = (f4 > 0.0f ? 1 : (f4 == 0.0f ? 0 : -1));
            if (i2 != 0) {
                return 0.0f;
            }
            float f6 = this.c2[i];
            float f7 = this.d2[i];
            float f8 = this.e2[i];
            float f9 = f6 * f3;
            if (i2 > 0) {
                return b(f4 * f9, f7, f8);
            }
            return -b((-f4) * f9, f7, f8);
        }
        f4 = b(f5, -1.0f, 1.0f);
        i2 = (f4 > 0.0f ? 1 : (f4 == 0.0f ? 0 : -1));
        if (i2 != 0) {
        }
    }

    public final float c(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        int i = this.a2;
        if (i == 0 || i == 1) {
            if (f < f2) {
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.i2 && i == 1) {
                    return 1.0f;
                }
            }
        } else if (i == 2 && f < 0.0f) {
            return f / (-f2);
        }
        return 0.0f;
    }

    public final void d() {
        int i = 0;
        if (this.g2) {
            this.i2 = false;
            return;
        }
        C0079a aVar = this.d;
        Objects.requireNonNull(aVar);
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i2 = (int) (currentAnimationTimeMillis - aVar.e);
        int i3 = aVar.b;
        if (i2 > i3) {
            i = i3;
        } else if (i2 >= 0) {
            i = i2;
        }
        aVar.k = i;
        aVar.j = aVar.a(currentAnimationTimeMillis);
        aVar.i = currentAnimationTimeMillis;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public boolean e() {
        boolean z;
        C0079a aVar = this.d;
        float f = aVar.d;
        int abs = (int) (f / Math.abs(f));
        float f2 = aVar.c;
        int abs2 = (int) (f2 / Math.abs(f2));
        if (abs != 0) {
            ListView listView = ((c) this).k2;
            int count = listView.getCount();
            if (count != 0) {
                int childCount = listView.getChildCount();
                int firstVisiblePosition = listView.getFirstVisiblePosition();
                int i = firstVisiblePosition + childCount;
                if (abs <= 0 ? !(abs >= 0 || (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0)) : !(i >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight())) {
                    z = true;
                    if (z) {
                        return true;
                    }
                }
            }
            z = false;
            if (z) {
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
        if (r0 != 3) goto L_0x007f;
     */
    @Override // android.view.View.OnTouchListener
    /* Code decompiled incorrectly, please refer to instructions dump */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i;
        if (!this.j2) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                }
            }
            d();
            return false;
        }
        this.h2 = true;
        this.f2 = false;
        float a = a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.x.getWidth());
        float a2 = a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.x.getHeight());
        C0079a aVar = this.d;
        aVar.c = a;
        aVar.d = a2;
        if (!this.i2 && e()) {
            if (this.y == null) {
                this.y = new b();
            }
            this.i2 = true;
            this.g2 = true;
            if (this.f2 || (i = this.b2) <= 0) {
                this.y.run();
            } else {
                View view2 = this.x;
                Runnable runnable = this.y;
                long j = (long) i;
                AtomicInteger atomicInteger = q.a;
                view2.postOnAnimationDelayed(runnable, j);
            }
            this.f2 = true;
        }
        return false;
    }
}
