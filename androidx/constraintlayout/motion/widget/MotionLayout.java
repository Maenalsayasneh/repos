package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.core.widget.NestedScrollView;
import h0.g.a.h.j;
import h0.g.b.b.m;
import h0.g.b.b.n;
import h0.g.b.b.o;
import h0.g.b.b.p;
import h0.g.b.b.q;
import h0.g.b.b.r;
import h0.g.b.b.s;
import h0.g.b.b.t;
import h0.g.b.b.u;
import h0.g.b.b.x;
import h0.g.b.b.y;
import h0.g.c.b;
import h0.g.c.c;
import h0.g.c.d;
import h0.g.c.h;
import h0.i.i.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class MotionLayout extends ConstraintLayout implements k {
    public static boolean n2;
    public long D2;
    public float E2;
    public boolean F2;
    public boolean G2;
    public i H2;
    public float I2;
    public float J2;
    public int K2;
    public d L2;
    public h0.g.b.b.b P2;
    public int Q2;
    public int R2;
    public float T2;
    public float U2;
    public long V2;
    public float W2;
    public int h3;
    public int i3;
    public int j3;
    public int k3;
    public int l3;
    public int m3;
    public float n3;
    public r o2;
    public Interpolator p2;
    public h q3;
    public int s2;
    public int t2;
    public int u2;
    public Interpolator q2 = null;
    public float r2 = 0.0f;
    public int v2 = 0;
    public int w2 = 0;
    public boolean x2 = true;
    public HashMap<View, n> y2 = new HashMap<>();
    public long z2 = 0;
    public float A2 = 1.0f;
    public float B2 = 0.0f;
    public float C2 = 0.0f;
    public boolean M2 = false;
    public h0.g.b.a.a N2 = new h0.g.b.a.a();
    public c O2 = new c();
    public boolean S2 = false;
    public boolean X2 = false;
    public ArrayList<o> Y2 = null;
    public ArrayList<o> Z2 = null;
    public CopyOnWriteArrayList<i> a3 = null;
    public int b3 = 0;
    public long c3 = -1;
    public float d3 = 0.0f;
    public int e3 = 0;
    public float f3 = 0.0f;
    public boolean g3 = false;
    public h0.g.a.g.a.d o3 = new h0.g.a.g.a.d();
    public boolean p3 = false;
    public Runnable r3 = null;
    public HashMap<View, ?> s3 = new HashMap<>();
    public Rect t3 = new Rect();
    public boolean u3 = false;
    public TransitionState v3 = TransitionState.UNDEFINED;
    public e w3 = new e();
    public boolean x3 = false;
    public RectF y3 = new RectF();
    public View z3 = null;
    public Matrix A3 = null;
    public ArrayList<Integer> B3 = new ArrayList<>();

    /* loaded from: classes.dex */
    public enum TransitionState {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ View c;

        public a(MotionLayout motionLayout, View view) {
            this.c = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.setNestedScrollingEnabled(true);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MotionLayout.this.q3.a();
        }
    }

    /* loaded from: classes.dex */
    public class c extends p {
        public float a = 0.0f;
        public float b = 0.0f;
        public float c;

        public c() {
        }

        @Override // h0.g.b.b.p
        public float a() {
            return MotionLayout.this.r2;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = this.a;
            if (f2 > 0.0f) {
                float f3 = this.c;
                if (f2 / f3 < f) {
                    f = f2 / f3;
                }
                MotionLayout.this.r2 = f2 - (f3 * f);
                return ((f2 * f) - (((f3 * f) * f) / 2.0f)) + this.b;
            }
            float f4 = this.c;
            if ((-f2) / f4 < f) {
                f = (-f2) / f4;
            }
            MotionLayout.this.r2 = (f4 * f) + f2;
            return (((f4 * f) * f) / 2.0f) + (f2 * f) + this.b;
        }
    }

    /* loaded from: classes.dex */
    public class d {
        public float[] a;
        public Path d;
        public Paint e;
        public Paint f;
        public Paint g;
        public Paint h;
        public Paint i;
        public DashPathEffect k;
        public int l;
        public Rect m = new Rect();
        public int n = 1;
        public float[] j = new float[8];
        public float[] c = new float[100];
        public int[] b = new int[50];

        public d() {
            Paint paint = new Paint();
            this.e = paint;
            paint.setAntiAlias(true);
            this.e.setColor(-21965);
            this.e.setStrokeWidth(2.0f);
            this.e.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint();
            this.f = paint2;
            paint2.setAntiAlias(true);
            this.f.setColor(-2067046);
            this.f.setStrokeWidth(2.0f);
            this.f.setStyle(Paint.Style.STROKE);
            Paint paint3 = new Paint();
            this.g = paint3;
            paint3.setAntiAlias(true);
            this.g.setColor(-13391360);
            this.g.setStrokeWidth(2.0f);
            this.g.setStyle(Paint.Style.STROKE);
            Paint paint4 = new Paint();
            this.h = paint4;
            paint4.setAntiAlias(true);
            this.h.setColor(-13391360);
            this.h.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            Paint paint5 = new Paint();
            this.i = paint5;
            paint5.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.k = dashPathEffect;
            this.g.setPathEffect(dashPathEffect);
        }

        public void a(Canvas canvas, int i, int i2, n nVar) {
            int i3;
            int i4;
            int i5;
            float f;
            float f2;
            if (i == 4) {
                boolean z = false;
                boolean z2 = false;
                for (int i6 = 0; i6 < this.l; i6++) {
                    int[] iArr = this.b;
                    if (iArr[i6] == 1) {
                        z = true;
                    }
                    if (iArr[i6] == 0) {
                        z2 = true;
                    }
                }
                if (z) {
                    d(canvas);
                }
                if (z2) {
                    b(canvas);
                }
            }
            if (i == 2) {
                d(canvas);
            }
            if (i == 3) {
                b(canvas);
            }
            canvas.drawLines(this.a, this.e);
            View view = nVar.b;
            if (view != null) {
                int width = view.getWidth();
                i3 = nVar.b.getHeight();
                i4 = width;
            } else {
                i4 = 0;
                i3 = 0;
            }
            int i7 = 1;
            while (i7 < i2 - 1) {
                if (i == 4 && this.b[i7 - 1] == 0) {
                    i5 = i7;
                } else {
                    float[] fArr = this.c;
                    int i8 = i7 * 2;
                    float f3 = fArr[i8];
                    float f4 = fArr[i8 + 1];
                    this.d.reset();
                    this.d.moveTo(f3, f4 + 10.0f);
                    this.d.lineTo(f3 + 10.0f, f4);
                    this.d.lineTo(f3, f4 - 10.0f);
                    this.d.lineTo(f3 - 10.0f, f4);
                    this.d.close();
                    int i9 = i7 - 1;
                    nVar.u.get(i9);
                    if (i == 4) {
                        int[] iArr2 = this.b;
                        if (iArr2[i9] == 1) {
                            e(canvas, f3 - 0.0f, f4 - 0.0f);
                        } else if (iArr2[i9] == 0) {
                            c(canvas, f3 - 0.0f, f4 - 0.0f);
                        } else if (iArr2[i9] == 2) {
                            f = f4;
                            f2 = f3;
                            i5 = i7;
                            f(canvas, f3 - 0.0f, f4 - 0.0f, i4, i3);
                            canvas.drawPath(this.d, this.i);
                        }
                        f = f4;
                        f2 = f3;
                        i5 = i7;
                        canvas.drawPath(this.d, this.i);
                    } else {
                        f = f4;
                        f2 = f3;
                        i5 = i7;
                    }
                    if (i == 2) {
                        e(canvas, f2 - 0.0f, f - 0.0f);
                    }
                    if (i == 3) {
                        c(canvas, f2 - 0.0f, f - 0.0f);
                    }
                    if (i == 6) {
                        f(canvas, f2 - 0.0f, f - 0.0f, i4, i3);
                    }
                    canvas.drawPath(this.d, this.i);
                }
                i7 = i5 + 1;
            }
            float[] fArr2 = this.a;
            if (fArr2.length > 1) {
                canvas.drawCircle(fArr2[0], fArr2[1], 8.0f, this.f);
                float[] fArr3 = this.a;
                canvas.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.f);
            }
        }

        public final void b(Canvas canvas) {
            float[] fArr = this.a;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[fArr.length - 2];
            float f4 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f, f3), Math.max(f2, f4), Math.max(f, f3), Math.max(f2, f4), this.g);
            canvas.drawLine(Math.min(f, f3), Math.min(f2, f4), Math.min(f, f3), Math.max(f2, f4), this.g);
        }

        public final void c(Canvas canvas, float f, float f2) {
            float[] fArr = this.a;
            float f3 = fArr[0];
            float f4 = fArr[1];
            float f5 = fArr[fArr.length - 2];
            float f6 = fArr[fArr.length - 1];
            float min = Math.min(f3, f5);
            float max = Math.max(f4, f6);
            float min2 = f - Math.min(f3, f5);
            float max2 = Math.max(f4, f6) - f2;
            StringBuilder P0 = i0.d.a.a.a.P0("");
            P0.append(((float) ((int) (((double) ((min2 * 100.0f) / Math.abs(f5 - f3))) + 0.5d))) / 100.0f);
            String sb = P0.toString();
            g(sb, this.h);
            canvas.drawText(sb, ((min2 / 2.0f) - ((float) (this.m.width() / 2))) + min, f2 - 20.0f, this.h);
            canvas.drawLine(f, f2, Math.min(f3, f5), f2, this.g);
            StringBuilder P02 = i0.d.a.a.a.P0("");
            P02.append(((float) ((int) (((double) ((max2 * 100.0f) / Math.abs(f6 - f4))) + 0.5d))) / 100.0f);
            String sb2 = P02.toString();
            g(sb2, this.h);
            canvas.drawText(sb2, f + 5.0f, max - ((max2 / 2.0f) - ((float) (this.m.height() / 2))), this.h);
            canvas.drawLine(f, f2, f, Math.max(f4, f6), this.g);
        }

        public final void d(Canvas canvas) {
            float[] fArr = this.a;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.g);
        }

        public final void e(Canvas canvas, float f, float f2) {
            float[] fArr = this.a;
            float f3 = fArr[0];
            float f4 = fArr[1];
            float f5 = fArr[fArr.length - 2];
            float f6 = fArr[fArr.length - 1];
            float hypot = (float) Math.hypot((double) (f3 - f5), (double) (f4 - f6));
            float f7 = f5 - f3;
            float f8 = f6 - f4;
            float f9 = (((f2 - f4) * f8) + ((f - f3) * f7)) / (hypot * hypot);
            float f10 = f3 + (f7 * f9);
            float f11 = f4 + (f9 * f8);
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f10, f11);
            float hypot2 = (float) Math.hypot((double) (f10 - f), (double) (f11 - f2));
            StringBuilder P0 = i0.d.a.a.a.P0("");
            P0.append(((float) ((int) ((hypot2 * 100.0f) / hypot))) / 100.0f);
            String sb = P0.toString();
            g(sb, this.h);
            canvas.drawTextOnPath(sb, path, (hypot2 / 2.0f) - ((float) (this.m.width() / 2)), -20.0f, this.h);
            canvas.drawLine(f, f2, f10, f11, this.g);
        }

        public final void f(Canvas canvas, float f, float f2, int i, int i2) {
            StringBuilder P0 = i0.d.a.a.a.P0("");
            P0.append(((float) ((int) (((double) (((f - ((float) (i / 2))) * 100.0f) / ((float) (MotionLayout.this.getWidth() - i)))) + 0.5d))) / 100.0f);
            String sb = P0.toString();
            g(sb, this.h);
            canvas.drawText(sb, ((f / 2.0f) - ((float) (this.m.width() / 2))) + 0.0f, f2 - 20.0f, this.h);
            canvas.drawLine(f, f2, Math.min(0.0f, 1.0f), f2, this.g);
            StringBuilder P02 = i0.d.a.a.a.P0("");
            P02.append(((float) ((int) (((double) (((f2 - ((float) (i2 / 2))) * 100.0f) / ((float) (MotionLayout.this.getHeight() - i2)))) + 0.5d))) / 100.0f);
            String sb2 = P02.toString();
            g(sb2, this.h);
            canvas.drawText(sb2, f + 5.0f, 0.0f - ((f2 / 2.0f) - ((float) (this.m.height() / 2))), this.h);
            canvas.drawLine(f, f2, f, Math.max(0.0f, 1.0f), this.g);
        }

        public void g(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.m);
        }
    }

    /* loaded from: classes.dex */
    public class e {
        public h0.g.a.h.c a = new h0.g.a.h.c();
        public h0.g.a.h.c b = new h0.g.a.h.c();
        public h0.g.c.c c = null;
        public h0.g.c.c d = null;
        public int e;
        public int f;

        public e() {
        }

        public void a() {
            int[] iArr;
            SparseArray sparseArray;
            int i;
            String str;
            String str2;
            String str3;
            int i2;
            h0.g.c.c cVar;
            Rect rect;
            Interpolator interpolator;
            int childCount = MotionLayout.this.getChildCount();
            MotionLayout.this.y2.clear();
            SparseArray sparseArray2 = new SparseArray();
            int[] iArr2 = new int[childCount];
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = MotionLayout.this.getChildAt(i3);
                n nVar = new n(childAt);
                int id = childAt.getId();
                iArr2[i3] = id;
                sparseArray2.put(id, nVar);
                MotionLayout.this.y2.put(childAt, nVar);
            }
            int i4 = 0;
            while (i4 < childCount) {
                View childAt2 = MotionLayout.this.getChildAt(i4);
                n nVar2 = MotionLayout.this.y2.get(childAt2);
                if (nVar2 == null) {
                    i = childCount;
                    sparseArray = sparseArray2;
                    iArr = iArr2;
                } else {
                    if (this.c != null) {
                        ConstraintWidget c = c(this.a, childAt2);
                        if (c != null) {
                            Rect t = MotionLayout.t(MotionLayout.this, c);
                            h0.g.c.c cVar2 = this.c;
                            int width = MotionLayout.this.getWidth();
                            int height = MotionLayout.this.getHeight();
                            int i5 = cVar2.f;
                            if (i5 != 0) {
                                i2 = i5;
                                cVar = cVar2;
                                sparseArray = sparseArray2;
                                rect = t;
                                str = "MotionLayout";
                                iArr = iArr2;
                                str2 = "no widget for  ";
                                i = childCount;
                                str3 = " (";
                                nVar2.e(t, nVar2.a, i2, width, height);
                            } else {
                                i = childCount;
                                sparseArray = sparseArray2;
                                iArr = iArr2;
                                i2 = i5;
                                cVar = cVar2;
                                rect = t;
                                str = "MotionLayout";
                                str2 = "no widget for  ";
                                str3 = " (";
                            }
                            q qVar = nVar2.e;
                            qVar.x = 0.0f;
                            qVar.y = 0.0f;
                            nVar2.d(qVar);
                            nVar2.e.f((float) rect.left, (float) rect.top, (float) rect.width(), (float) rect.height());
                            c.a h = cVar.h(nVar2.c);
                            nVar2.e.a(h);
                            nVar2.k = h.d.h;
                            nVar2.g.f(rect, cVar, i2, nVar2.c);
                            nVar2.C = h.f.j;
                            c.C0065c cVar3 = h.d;
                            nVar2.E = cVar3.l;
                            nVar2.F = cVar3.k;
                            Context context = nVar2.b.getContext();
                            c.C0065c cVar4 = h.d;
                            int i6 = cVar4.n;
                            String str4 = cVar4.m;
                            int i7 = cVar4.o;
                            if (i6 == -2) {
                                interpolator = AnimationUtils.loadInterpolator(context, i7);
                            } else if (i6 == -1) {
                                interpolator = new m(h0.g.a.g.a.c.c(str4));
                            } else if (i6 == 0) {
                                interpolator = new AccelerateDecelerateInterpolator();
                            } else if (i6 == 1) {
                                interpolator = new AccelerateInterpolator();
                            } else if (i6 == 2) {
                                interpolator = new DecelerateInterpolator();
                            } else if (i6 == 4) {
                                interpolator = new BounceInterpolator();
                            } else if (i6 != 5) {
                                interpolator = null;
                            } else {
                                interpolator = new OvershootInterpolator();
                            }
                            nVar2.G = interpolator;
                        } else {
                            i = childCount;
                            sparseArray = sparseArray2;
                            iArr = iArr2;
                            str = "MotionLayout";
                            str2 = "no widget for  ";
                            str3 = " (";
                            if (MotionLayout.this.K2 != 0) {
                                Log.e(str, g0.a.b.b.a.M() + str2 + g0.a.b.b.a.O(childAt2) + str3 + childAt2.getClass().getName() + ")");
                            }
                        }
                    } else {
                        i = childCount;
                        sparseArray = sparseArray2;
                        iArr = iArr2;
                        str = "MotionLayout";
                        str2 = "no widget for  ";
                        str3 = " (";
                        Objects.requireNonNull(MotionLayout.this);
                    }
                    if (this.d != null) {
                        ConstraintWidget c2 = c(this.b, childAt2);
                        if (c2 != null) {
                            Rect t2 = MotionLayout.t(MotionLayout.this, c2);
                            h0.g.c.c cVar5 = this.d;
                            int width2 = MotionLayout.this.getWidth();
                            int height2 = MotionLayout.this.getHeight();
                            int i8 = cVar5.f;
                            if (i8 != 0) {
                                nVar2.e(t2, nVar2.a, i8, width2, height2);
                                t2 = nVar2.a;
                            }
                            q qVar2 = nVar2.f;
                            qVar2.x = 1.0f;
                            qVar2.y = 1.0f;
                            nVar2.d(qVar2);
                            nVar2.f.f((float) t2.left, (float) t2.top, (float) t2.width(), (float) t2.height());
                            nVar2.f.a(cVar5.h(nVar2.c));
                            nVar2.h.f(t2, cVar5, i8, nVar2.c);
                        } else if (MotionLayout.this.K2 != 0) {
                            Log.e(str, g0.a.b.b.a.M() + str2 + g0.a.b.b.a.O(childAt2) + str3 + childAt2.getClass().getName() + ")");
                        }
                    }
                }
                i4++;
                childCount = i;
                sparseArray2 = sparseArray;
                iArr2 = iArr;
            }
            SparseArray sparseArray3 = sparseArray2;
            int i9 = 0;
            while (i9 < childCount) {
                n nVar3 = (n) sparseArray3.get(iArr2[i9]);
                int i10 = nVar3.e.e2;
                if (i10 != -1) {
                    n nVar4 = (n) sparseArray3.get(i10);
                    nVar3.e.i(nVar4, nVar4.e);
                    nVar3.f.i(nVar4, nVar4.f);
                }
                i9++;
                sparseArray3 = sparseArray3;
            }
        }

        public void b(h0.g.a.h.c cVar, h0.g.a.h.c cVar2) {
            ConstraintWidget constraintWidget;
            ArrayList<ConstraintWidget> arrayList = cVar.M0;
            HashMap<ConstraintWidget, ConstraintWidget> hashMap = new HashMap<>();
            hashMap.put(cVar, cVar2);
            cVar2.M0.clear();
            cVar2.k(cVar, hashMap);
            Iterator<ConstraintWidget> it = arrayList.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                if (next instanceof h0.g.a.h.a) {
                    constraintWidget = new h0.g.a.h.a();
                } else if (next instanceof h0.g.a.h.e) {
                    constraintWidget = new h0.g.a.h.e();
                } else if (next instanceof h0.g.a.h.d) {
                    constraintWidget = new h0.g.a.h.d();
                } else if (next instanceof h0.g.a.h.f) {
                    constraintWidget = new h0.g.a.h.g();
                } else {
                    constraintWidget = new ConstraintWidget();
                }
                cVar2.M0.add(constraintWidget);
                ConstraintWidget constraintWidget2 = constraintWidget.W;
                if (constraintWidget2 != null) {
                    ((j) constraintWidget2).M0.remove(constraintWidget);
                    constraintWidget.I();
                }
                constraintWidget.W = cVar2;
                hashMap.put(next, constraintWidget);
            }
            Iterator<ConstraintWidget> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ConstraintWidget next2 = it2.next();
                hashMap.get(next2).k(next2, hashMap);
            }
        }

        public ConstraintWidget c(h0.g.a.h.c cVar, View view) {
            if (cVar.f6m0 == view) {
                return cVar;
            }
            ArrayList<ConstraintWidget> arrayList = cVar.M0;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = arrayList.get(i);
                if (constraintWidget.f6m0 == view) {
                    return constraintWidget;
                }
            }
            return null;
        }

        public void d(h0.g.c.c cVar, h0.g.c.c cVar2) {
            this.c = cVar;
            this.d = cVar2;
            this.a = new h0.g.a.h.c();
            this.b = new h0.g.a.h.c();
            this.a.i0(MotionLayout.this.x.Q0);
            this.b.i0(MotionLayout.this.x.Q0);
            this.a.M0.clear();
            this.b.M0.clear();
            b(MotionLayout.this.x, this.a);
            b(MotionLayout.this.x, this.b);
            if (((double) MotionLayout.this.C2) > 0.5d) {
                if (cVar != null) {
                    f(this.a, cVar);
                }
                f(this.b, cVar2);
            } else {
                f(this.b, cVar2);
                if (cVar != null) {
                    f(this.a, cVar);
                }
            }
            this.a.R0 = MotionLayout.this.i();
            h0.g.a.h.c cVar3 = this.a;
            cVar3.N0.c(cVar3);
            this.b.R0 = MotionLayout.this.i();
            h0.g.a.h.c cVar4 = this.b;
            cVar4.N0.c(cVar4);
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    h0.g.a.h.c cVar5 = this.a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    cVar5.Q(dimensionBehaviour);
                    this.b.Q(dimensionBehaviour);
                }
                if (layoutParams.height == -2) {
                    h0.g.a.h.c cVar6 = this.a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    cVar6.T(dimensionBehaviour2);
                    this.b.T(dimensionBehaviour2);
                }
            }
        }

        public void e() {
            MotionLayout motionLayout = MotionLayout.this;
            int i = motionLayout.v2;
            int i2 = motionLayout.w2;
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            MotionLayout motionLayout2 = MotionLayout.this;
            motionLayout2.l3 = mode;
            motionLayout2.m3 = mode2;
            int optimizationLevel = motionLayout2.getOptimizationLevel();
            MotionLayout motionLayout3 = MotionLayout.this;
            if (motionLayout3.t2 == motionLayout3.getStartState()) {
                MotionLayout motionLayout4 = MotionLayout.this;
                h0.g.a.h.c cVar = this.b;
                h0.g.c.c cVar2 = this.d;
                motionLayout4.q(cVar, optimizationLevel, (cVar2 == null || cVar2.f == 0) ? i : i2, (cVar2 == null || cVar2.f == 0) ? i2 : i);
                h0.g.c.c cVar3 = this.c;
                if (cVar3 != null) {
                    MotionLayout motionLayout5 = MotionLayout.this;
                    h0.g.a.h.c cVar4 = this.a;
                    int i3 = cVar3.f;
                    motionLayout5.q(cVar4, optimizationLevel, i3 == 0 ? i : i2, i3 == 0 ? i2 : i);
                }
            } else {
                h0.g.c.c cVar5 = this.c;
                if (cVar5 != null) {
                    MotionLayout motionLayout6 = MotionLayout.this;
                    h0.g.a.h.c cVar6 = this.a;
                    int i4 = cVar5.f;
                    motionLayout6.q(cVar6, optimizationLevel, i4 == 0 ? i : i2, i4 == 0 ? i2 : i);
                }
                MotionLayout motionLayout7 = MotionLayout.this;
                h0.g.a.h.c cVar7 = this.b;
                h0.g.c.c cVar8 = this.d;
                motionLayout7.q(cVar7, optimizationLevel, (cVar8 == null || cVar8.f == 0) ? i : i2, (cVar8 == null || cVar8.f == 0) ? i2 : i);
            }
            int i5 = 0;
            boolean z = true;
            if (((MotionLayout.this.getParent() instanceof MotionLayout) && mode == 1073741824 && mode2 == 1073741824) ? false : true) {
                MotionLayout motionLayout8 = MotionLayout.this;
                motionLayout8.l3 = mode;
                motionLayout8.m3 = mode2;
                if (motionLayout8.t2 == motionLayout8.getStartState()) {
                    MotionLayout motionLayout9 = MotionLayout.this;
                    h0.g.a.h.c cVar9 = this.b;
                    int i6 = this.d.f;
                    motionLayout9.q(cVar9, optimizationLevel, i6 == 0 ? i : i2, i6 == 0 ? i2 : i);
                    h0.g.c.c cVar10 = this.c;
                    if (cVar10 != null) {
                        MotionLayout motionLayout10 = MotionLayout.this;
                        h0.g.a.h.c cVar11 = this.a;
                        int i7 = cVar10.f;
                        motionLayout10.q(cVar11, optimizationLevel, i7 == 0 ? i : i2, i7 == 0 ? i2 : i);
                    }
                } else {
                    h0.g.c.c cVar12 = this.c;
                    if (cVar12 != null) {
                        MotionLayout motionLayout11 = MotionLayout.this;
                        h0.g.a.h.c cVar13 = this.a;
                        int i8 = cVar12.f;
                        motionLayout11.q(cVar13, optimizationLevel, i8 == 0 ? i : i2, i8 == 0 ? i2 : i);
                    }
                    MotionLayout motionLayout12 = MotionLayout.this;
                    h0.g.a.h.c cVar14 = this.b;
                    int i9 = this.d.f;
                    motionLayout12.q(cVar14, optimizationLevel, i9 == 0 ? i : i2, i9 == 0 ? i2 : i);
                }
                MotionLayout.this.h3 = this.a.w();
                MotionLayout.this.i3 = this.a.q();
                MotionLayout.this.j3 = this.b.w();
                MotionLayout.this.k3 = this.b.q();
                MotionLayout motionLayout13 = MotionLayout.this;
                motionLayout13.g3 = (motionLayout13.h3 == motionLayout13.j3 && motionLayout13.i3 == motionLayout13.k3) ? false : true;
            }
            MotionLayout motionLayout14 = MotionLayout.this;
            int i10 = motionLayout14.h3;
            int i11 = motionLayout14.i3;
            int i12 = motionLayout14.l3;
            if (i12 == Integer.MIN_VALUE || i12 == 0) {
                i10 = (int) ((motionLayout14.n3 * ((float) (motionLayout14.j3 - i10))) + ((float) i10));
            }
            int i13 = motionLayout14.m3;
            if (i13 == Integer.MIN_VALUE || i13 == 0) {
                i11 = (int) ((motionLayout14.n3 * ((float) (motionLayout14.k3 - i11))) + ((float) i11));
            }
            h0.g.a.h.c cVar15 = this.a;
            motionLayout14.p(i, i2, i10, i11, cVar15.a1 || this.b.a1, cVar15.b1 || this.b.b1);
            MotionLayout motionLayout15 = MotionLayout.this;
            int childCount = motionLayout15.getChildCount();
            motionLayout15.w3.a();
            motionLayout15.G2 = true;
            SparseArray sparseArray = new SparseArray();
            for (int i14 = 0; i14 < childCount; i14++) {
                View childAt = motionLayout15.getChildAt(i14);
                sparseArray.put(childAt.getId(), motionLayout15.y2.get(childAt));
            }
            int width = motionLayout15.getWidth();
            int height = motionLayout15.getHeight();
            r.b bVar = motionLayout15.o2.c;
            int i15 = bVar != null ? bVar.p : -1;
            if (i15 != -1) {
                for (int i16 = 0; i16 < childCount; i16++) {
                    n nVar = motionLayout15.y2.get(motionLayout15.getChildAt(i16));
                    if (nVar != null) {
                        nVar.B = i15;
                    }
                }
            }
            SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
            int[] iArr = new int[motionLayout15.y2.size()];
            int i17 = 0;
            for (int i18 = 0; i18 < childCount; i18++) {
                n nVar2 = motionLayout15.y2.get(motionLayout15.getChildAt(i18));
                int i19 = nVar2.e.e2;
                if (i19 != -1) {
                    sparseBooleanArray.put(i19, true);
                    iArr[i17] = nVar2.e.e2;
                    i17++;
                }
            }
            for (int i20 = 0; i20 < i17; i20++) {
                n nVar3 = motionLayout15.y2.get(motionLayout15.findViewById(iArr[i20]));
                if (nVar3 != null) {
                    motionLayout15.o2.g(nVar3);
                    nVar3.f(width, height, motionLayout15.getNanoTime());
                }
            }
            for (int i21 = 0; i21 < childCount; i21++) {
                View childAt2 = motionLayout15.getChildAt(i21);
                n nVar4 = motionLayout15.y2.get(childAt2);
                if (!sparseBooleanArray.get(childAt2.getId()) && nVar4 != null) {
                    motionLayout15.o2.g(nVar4);
                    nVar4.f(width, height, motionLayout15.getNanoTime());
                }
            }
            r.b bVar2 = motionLayout15.o2.c;
            float f = bVar2 != null ? bVar2.i : 0.0f;
            if (f != 0.0f) {
                boolean z2 = ((double) f) < 0.0d;
                float abs = Math.abs(f);
                float f2 = -3.4028235E38f;
                float f3 = Float.MAX_VALUE;
                float f4 = -3.4028235E38f;
                float f5 = Float.MAX_VALUE;
                int i22 = 0;
                while (true) {
                    if (i22 >= childCount) {
                        z = false;
                        break;
                    }
                    n nVar5 = motionLayout15.y2.get(motionLayout15.getChildAt(i22));
                    if (!Float.isNaN(nVar5.k)) {
                        break;
                    }
                    q qVar = nVar5.f;
                    float f6 = qVar.Y1;
                    float f7 = qVar.Z1;
                    float f8 = z2 ? f7 - f6 : f7 + f6;
                    f5 = Math.min(f5, f8);
                    f4 = Math.max(f4, f8);
                    i22++;
                }
                if (z) {
                    for (int i23 = 0; i23 < childCount; i23++) {
                        n nVar6 = motionLayout15.y2.get(motionLayout15.getChildAt(i23));
                        if (!Float.isNaN(nVar6.k)) {
                            f3 = Math.min(f3, nVar6.k);
                            f2 = Math.max(f2, nVar6.k);
                        }
                    }
                    while (i5 < childCount) {
                        n nVar7 = motionLayout15.y2.get(motionLayout15.getChildAt(i5));
                        if (!Float.isNaN(nVar7.k)) {
                            nVar7.m = 1.0f / (1.0f - abs);
                            if (z2) {
                                nVar7.l = abs - (((f2 - nVar7.k) / (f2 - f3)) * abs);
                            } else {
                                nVar7.l = abs - (((nVar7.k - f3) * abs) / (f2 - f3));
                            }
                        }
                        i5++;
                    }
                    return;
                }
                while (i5 < childCount) {
                    n nVar8 = motionLayout15.y2.get(motionLayout15.getChildAt(i5));
                    q qVar2 = nVar8.f;
                    float f9 = qVar2.Y1;
                    float f10 = qVar2.Z1;
                    float f11 = z2 ? f10 - f9 : f10 + f9;
                    nVar8.m = 1.0f / (1.0f - abs);
                    nVar8.l = abs - (((f11 - f5) * abs) / (f4 - f5));
                    i5++;
                }
            }
        }

        public final void f(h0.g.a.h.c cVar, h0.g.c.c cVar2) {
            c.a aVar;
            c.a aVar2;
            SparseArray<ConstraintWidget> sparseArray = new SparseArray<>();
            d.a aVar3 = new d.a(-2, -2);
            sparseArray.clear();
            sparseArray.put(0, cVar);
            sparseArray.put(MotionLayout.this.getId(), cVar);
            if (!(cVar2 == null || cVar2.f == 0)) {
                MotionLayout motionLayout = MotionLayout.this;
                motionLayout.q(this.b, motionLayout.getOptimizationLevel(), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getHeight(), 1073741824), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getWidth(), 1073741824));
            }
            Iterator<ConstraintWidget> it = cVar.M0.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                sparseArray.put(((View) next.f6m0).getId(), next);
            }
            Iterator<ConstraintWidget> it2 = cVar.M0.iterator();
            while (it2.hasNext()) {
                ConstraintWidget next2 = it2.next();
                View view = (View) next2.f6m0;
                int id = view.getId();
                if (cVar2.i.containsKey(Integer.valueOf(id)) && (aVar2 = cVar2.i.get(Integer.valueOf(id))) != null) {
                    aVar2.a(aVar3);
                }
                next2.U(cVar2.h(view.getId()).e.d);
                next2.P(cVar2.h(view.getId()).e.e);
                if (view instanceof h0.g.c.a) {
                    h0.g.c.a aVar4 = (h0.g.c.a) view;
                    int id2 = aVar4.getId();
                    if (cVar2.i.containsKey(Integer.valueOf(id2)) && (aVar = cVar2.i.get(Integer.valueOf(id2))) != null && (next2 instanceof h0.g.a.h.g)) {
                        aVar4.m(aVar, (h0.g.a.h.g) next2, aVar3, sparseArray);
                    }
                    if (view instanceof Barrier) {
                        ((Barrier) view).s();
                    }
                }
                aVar3.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                MotionLayout.this.a(false, view, next2, aVar3, sparseArray);
                if (cVar2.h(view.getId()).c.c == 1) {
                    next2.f8o0 = view.getVisibility();
                } else {
                    next2.f8o0 = cVar2.h(view.getId()).c.b;
                }
            }
            Iterator<ConstraintWidget> it3 = cVar.M0.iterator();
            while (it3.hasNext()) {
                ConstraintWidget next3 = it3.next();
                if (next3 instanceof h0.g.a.h.i) {
                    h0.g.a.h.f fVar = (h0.g.a.h.f) next3;
                    ((h0.g.c.a) next3.f6m0).r(fVar, sparseArray);
                    ((h0.g.a.h.i) fVar).Y();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface f {
    }

    /* loaded from: classes.dex */
    public static class g implements f {
        public static g a = new g();
        public VelocityTracker b;

        public void a(int i) {
            VelocityTracker velocityTracker = this.b;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i);
            }
        }

        public float b() {
            VelocityTracker velocityTracker = this.b;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity();
            }
            return 0.0f;
        }

        public float c() {
            VelocityTracker velocityTracker = this.b;
            if (velocityTracker != null) {
                return velocityTracker.getYVelocity();
            }
            return 0.0f;
        }
    }

    /* loaded from: classes.dex */
    public class h {
        public float a = Float.NaN;
        public float b = Float.NaN;
        public int c = -1;
        public int d = -1;

        public h() {
        }

        public void a() {
            int i = this.c;
            if (!(i == -1 && this.d == -1)) {
                if (i == -1) {
                    MotionLayout.this.J(this.d);
                } else {
                    int i2 = this.d;
                    if (i2 == -1) {
                        MotionLayout.this.F(i, -1, -1);
                    } else {
                        MotionLayout.this.G(i, i2);
                    }
                }
                MotionLayout.this.setState(TransitionState.SETUP);
            }
            if (!Float.isNaN(this.b)) {
                MotionLayout motionLayout = MotionLayout.this;
                float f = this.a;
                float f2 = this.b;
                if (!motionLayout.isAttachedToWindow()) {
                    if (motionLayout.q3 == null) {
                        motionLayout.q3 = new h();
                    }
                    h hVar = motionLayout.q3;
                    hVar.a = f;
                    hVar.b = f2;
                } else {
                    motionLayout.setProgress(f);
                    motionLayout.setState(TransitionState.MOVING);
                    motionLayout.r2 = f2;
                    motionLayout.u(1.0f);
                }
                this.a = Float.NaN;
                this.b = Float.NaN;
                this.c = -1;
                this.d = -1;
            } else if (!Float.isNaN(this.a)) {
                MotionLayout.this.setProgress(this.a);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface i {
        void a(MotionLayout motionLayout, int i, int i2, float f);

        void b(MotionLayout motionLayout, int i, int i2);

        void c(MotionLayout motionLayout, int i, boolean z, float f);

        void d(MotionLayout motionLayout, int i);
    }

    public MotionLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        r rVar;
        this.s2 = -1;
        this.t2 = -1;
        this.u2 = -1;
        this.E2 = 0.0f;
        this.G2 = false;
        this.K2 = 0;
        n2 = isInEditMode();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionLayout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            boolean z = true;
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.MotionLayout_layoutDescription) {
                    this.o2 = new r(getContext(), this, obtainStyledAttributes.getResourceId(index, -1));
                } else if (index == R.styleable.MotionLayout_currentState) {
                    this.t2 = obtainStyledAttributes.getResourceId(index, -1);
                } else if (index == R.styleable.MotionLayout_motionProgress) {
                    this.E2 = obtainStyledAttributes.getFloat(index, 0.0f);
                    this.G2 = true;
                } else if (index == R.styleable.MotionLayout_applyMotionScene) {
                    z = obtainStyledAttributes.getBoolean(index, z);
                } else if (index == R.styleable.MotionLayout_showPaths) {
                    if (this.K2 == 0) {
                        this.K2 = obtainStyledAttributes.getBoolean(index, false) ? 2 : 0;
                    }
                } else if (index == R.styleable.MotionLayout_motionDebug) {
                    this.K2 = obtainStyledAttributes.getInt(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
            if (this.o2 == null) {
                Log.e("MotionLayout", "WARNING NO app:layoutDescription tag");
            }
            if (!z) {
                this.o2 = null;
            }
        }
        if (this.K2 != 0) {
            r rVar2 = this.o2;
            if (rVar2 == null) {
                Log.e("MotionLayout", "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            } else {
                int i3 = rVar2.i();
                r rVar3 = this.o2;
                h0.g.c.c b2 = rVar3.b(rVar3.i());
                String N = g0.a.b.b.a.N(getContext(), i3);
                int childCount = getChildCount();
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = getChildAt(i4);
                    int id = childAt.getId();
                    if (id == -1) {
                        StringBuilder T0 = i0.d.a.a.a.T0("CHECK: ", N, " ALL VIEWS SHOULD HAVE ID's ");
                        T0.append(childAt.getClass().getName());
                        T0.append(" does not!");
                        Log.w("MotionLayout", T0.toString());
                    }
                    if (b2.i(id) == null) {
                        StringBuilder T02 = i0.d.a.a.a.T0("CHECK: ", N, " NO CONSTRAINTS for ");
                        T02.append(g0.a.b.b.a.O(childAt));
                        Log.w("MotionLayout", T02.toString());
                    }
                }
                Integer[] numArr = (Integer[]) b2.i.keySet().toArray(new Integer[0]);
                int length = numArr.length;
                int[] iArr = new int[length];
                for (int i5 = 0; i5 < length; i5++) {
                    iArr[i5] = numArr[i5].intValue();
                }
                for (int i6 = 0; i6 < length; i6++) {
                    int i7 = iArr[i6];
                    String N2 = g0.a.b.b.a.N(getContext(), i7);
                    if (findViewById(iArr[i6]) == null) {
                        Log.w("MotionLayout", "CHECK: " + N + " NO View matches id " + N2);
                    }
                    if (b2.h(i7).e.e == -1) {
                        Log.w("MotionLayout", "CHECK: " + N + "(" + N2 + ") no LAYOUT_HEIGHT");
                    }
                    if (b2.h(i7).e.d == -1) {
                        Log.w("MotionLayout", "CHECK: " + N + "(" + N2 + ") no LAYOUT_HEIGHT");
                    }
                }
                SparseIntArray sparseIntArray = new SparseIntArray();
                SparseIntArray sparseIntArray2 = new SparseIntArray();
                Iterator<r.b> it = this.o2.d.iterator();
                while (it.hasNext()) {
                    r.b next = it.next();
                    if (next == this.o2.c) {
                        Log.v("MotionLayout", "CHECK: CURRENT");
                    }
                    if (next.d == next.c) {
                        Log.e("MotionLayout", "CHECK: start and end constraint set should not be the same!");
                    }
                    int i8 = next.d;
                    int i9 = next.c;
                    String N3 = g0.a.b.b.a.N(getContext(), i8);
                    String N4 = g0.a.b.b.a.N(getContext(), i9);
                    if (sparseIntArray.get(i8) == i9) {
                        Log.e("MotionLayout", "CHECK: two transitions with the same start and end " + N3 + "->" + N4);
                    }
                    if (sparseIntArray2.get(i9) == i8) {
                        Log.e("MotionLayout", "CHECK: you can't have reverse transitions" + N3 + "->" + N4);
                    }
                    sparseIntArray.put(i8, i9);
                    sparseIntArray2.put(i9, i8);
                    if (this.o2.b(i8) == null) {
                        Log.e("MotionLayout", " no such constraintSetStart " + N3);
                    }
                    if (this.o2.b(i9) == null) {
                        Log.e("MotionLayout", " no such constraintSetEnd " + N3);
                    }
                }
            }
        }
        if (this.t2 == -1 && (rVar = this.o2) != null) {
            this.t2 = rVar.i();
            this.s2 = this.o2.i();
            this.u2 = this.o2.d();
        }
    }

    public static Rect t(MotionLayout motionLayout, ConstraintWidget constraintWidget) {
        motionLayout.t3.top = constraintWidget.y();
        motionLayout.t3.left = constraintWidget.x();
        Rect rect = motionLayout.t3;
        int w = constraintWidget.w();
        Rect rect2 = motionLayout.t3;
        rect.right = w + rect2.left;
        int q = constraintWidget.q();
        Rect rect3 = motionLayout.t3;
        rect2.bottom = q + rect3.top;
        return rect3;
    }

    public h0.g.c.c A(int i2) {
        r rVar = this.o2;
        if (rVar == null) {
            return null;
        }
        return rVar.b(i2);
    }

    public final boolean B(float f2, float f3, View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (B((((float) childAt.getLeft()) + f2) - ((float) view.getScrollX()), (((float) childAt.getTop()) + f3) - ((float) view.getScrollY()), childAt, motionEvent)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (!z) {
            this.y3.set(f2, f3, (((float) view.getRight()) + f2) - ((float) view.getLeft()), (((float) view.getBottom()) + f3) - ((float) view.getTop()));
            if (motionEvent.getAction() != 0 || this.y3.contains(motionEvent.getX(), motionEvent.getY())) {
                float f4 = -f2;
                float f5 = -f3;
                Matrix matrix = view.getMatrix();
                if (matrix.isIdentity()) {
                    motionEvent.offsetLocation(f4, f5);
                    z2 = view.onTouchEvent(motionEvent);
                    motionEvent.offsetLocation(-f4, -f5);
                } else {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.offsetLocation(f4, f5);
                    if (this.A3 == null) {
                        this.A3 = new Matrix();
                    }
                    matrix.invert(this.A3);
                    obtain.transform(this.A3);
                    z2 = view.onTouchEvent(obtain);
                    obtain.recycle();
                }
                if (z2) {
                    return true;
                }
            }
        }
        return z;
    }

    public void C() {
        r.b bVar;
        u uVar;
        View view;
        r rVar = this.o2;
        if (rVar != null) {
            if (rVar.a(this, this.t2)) {
                requestLayout();
                return;
            }
            int i2 = this.t2;
            if (i2 != -1) {
                r rVar2 = this.o2;
                Iterator<r.b> it = rVar2.d.iterator();
                while (it.hasNext()) {
                    r.b next = it.next();
                    if (next.m.size() > 0) {
                        Iterator<r.b.a> it2 = next.m.iterator();
                        while (it2.hasNext()) {
                            it2.next().b(this);
                        }
                    }
                }
                Iterator<r.b> it3 = rVar2.f.iterator();
                while (it3.hasNext()) {
                    r.b next2 = it3.next();
                    if (next2.m.size() > 0) {
                        Iterator<r.b.a> it4 = next2.m.iterator();
                        while (it4.hasNext()) {
                            it4.next().b(this);
                        }
                    }
                }
                Iterator<r.b> it5 = rVar2.d.iterator();
                while (it5.hasNext()) {
                    r.b next3 = it5.next();
                    if (next3.m.size() > 0) {
                        Iterator<r.b.a> it6 = next3.m.iterator();
                        while (it6.hasNext()) {
                            it6.next().a(this, i2, next3);
                        }
                    }
                }
                Iterator<r.b> it7 = rVar2.f.iterator();
                while (it7.hasNext()) {
                    r.b next4 = it7.next();
                    if (next4.m.size() > 0) {
                        Iterator<r.b.a> it8 = next4.m.iterator();
                        while (it8.hasNext()) {
                            it8.next().a(this, i2, next4);
                        }
                    }
                }
            }
            if (this.o2.p() && (bVar = this.o2.c) != null && (uVar = bVar.l) != null) {
                int i3 = uVar.f;
                if (i3 != -1) {
                    view = uVar.t.findViewById(i3);
                    if (view == null) {
                        StringBuilder P0 = i0.d.a.a.a.P0("cannot find TouchAnchorId @id/");
                        P0.append(g0.a.b.b.a.N(uVar.t.getContext(), uVar.f));
                        Log.e("TouchResponse", P0.toString());
                    }
                } else {
                    view = null;
                }
                if (view instanceof NestedScrollView) {
                    NestedScrollView nestedScrollView = (NestedScrollView) view;
                    nestedScrollView.setOnTouchListener(new s(uVar));
                    nestedScrollView.setOnScrollChangeListener(new t(uVar));
                }
            }
        }
    }

    public final void D() {
        CopyOnWriteArrayList<i> copyOnWriteArrayList;
        if (this.H2 != null || ((copyOnWriteArrayList = this.a3) != null && !copyOnWriteArrayList.isEmpty())) {
            Iterator<Integer> it = this.B3.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                i iVar = this.H2;
                if (iVar != null) {
                    iVar.d(this, next.intValue());
                }
                CopyOnWriteArrayList<i> copyOnWriteArrayList2 = this.a3;
                if (copyOnWriteArrayList2 != null) {
                    Iterator<i> it2 = copyOnWriteArrayList2.iterator();
                    while (it2.hasNext()) {
                        it2.next().d(this, next.intValue());
                    }
                }
            }
            this.B3.clear();
        }
    }

    public void E() {
        this.w3.e();
        invalidate();
    }

    public void F(int i2, int i3, int i4) {
        h0.g.c.c cVar;
        b.a aVar;
        int a2;
        setState(TransitionState.SETUP);
        this.t2 = i2;
        this.s2 = -1;
        this.u2 = -1;
        h0.g.c.b bVar = this.e2;
        h0.g.c.c cVar2 = null;
        if (bVar != null) {
            float f2 = (float) i3;
            float f3 = (float) i4;
            int i5 = bVar.b;
            if (i5 == i2) {
                if (i2 == -1) {
                    aVar = bVar.d.valueAt(0);
                } else {
                    aVar = bVar.d.get(i5);
                }
                int i6 = bVar.c;
                if ((i6 == -1 || !aVar.b.get(i6).a(f2, f3)) && bVar.c != (a2 = aVar.a(f2, f3))) {
                    if (a2 != -1) {
                        cVar2 = aVar.b.get(a2).f;
                    }
                    if (a2 != -1) {
                        int i7 = aVar.b.get(a2).e;
                    }
                    if (cVar2 != null) {
                        bVar.c = a2;
                        cVar2.b(bVar.a);
                        return;
                    }
                    return;
                }
                return;
            }
            bVar.b = i2;
            b.a aVar2 = bVar.d.get(i2);
            int a3 = aVar2.a(f2, f3);
            if (a3 == -1) {
                cVar = aVar2.d;
            } else {
                cVar = aVar2.b.get(a3).f;
            }
            if (a3 != -1) {
                int i8 = aVar2.b.get(a3).e;
            }
            if (cVar == null) {
                Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i2 + ", dim =" + f2 + ", " + f3);
                return;
            }
            bVar.c = a3;
            cVar.b(bVar.a);
            return;
        }
        r rVar = this.o2;
        if (rVar != null) {
            rVar.b(i2).c(this, true);
            setConstraintSet(null);
            requestLayout();
        }
    }

    public void G(int i2, int i3) {
        if (!isAttachedToWindow()) {
            if (this.q3 == null) {
                this.q3 = new h();
            }
            h hVar = this.q3;
            hVar.c = i2;
            hVar.d = i3;
            return;
        }
        r rVar = this.o2;
        if (rVar != null) {
            this.s2 = i2;
            this.u2 = i3;
            rVar.o(i2, i3);
            this.w3.d(this.o2.b(i2), this.o2.b(i3));
            E();
            this.C2 = 0.0f;
            u(0.0f);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0041, code lost:
        if (r15 != 7) goto L_0x016c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
        if ((((r17 * r6) - (((r5 * r6) * r6) / 2.0f)) + r1) > 1.0f) goto L_0x0070;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006c, code lost:
        if ((((((r5 * r3) * r3) / 2.0f) + (r17 * r3)) + r1) < 0.0f) goto L_0x0070;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006f, code lost:
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0070, code lost:
        if (r2 == false) goto L_0x0088;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0072, code lost:
        r1 = r14.O2;
        r2 = r14.C2;
        r3 = r14.o2.h();
        r1.a = r17;
        r1.b = r2;
        r1.c = r3;
        r14.p2 = r14.O2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0088, code lost:
        r1 = r14.N2;
        r2 = r14.C2;
        r5 = r14.A2;
        r6 = r14.o2.h();
        r3 = r14.o2.c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0098, code lost:
        if (r3 == null) goto L_0x00a2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009a, code lost:
        r3 = r3.l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009c, code lost:
        if (r3 == null) goto L_0x00a2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x009e, code lost:
        r7 = r3.u;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a2, code lost:
        r7 = 0.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a3, code lost:
        r1.b(r2, r16, r17, r5, r6, r7);
        r14.r2 = 0.0f;
        r1 = r14.t2;
        r14.E2 = r8;
        r14.t2 = r1;
        r14.p2 = r14.N2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void H(int i2, float f2, float f3) {
        u uVar;
        u uVar2;
        u uVar3;
        u uVar4;
        u uVar5;
        u uVar6;
        u uVar7;
        float f4 = f2;
        if (this.o2 != null && this.C2 != f4) {
            boolean z = true;
            this.M2 = true;
            this.z2 = getNanoTime();
            float c2 = ((float) this.o2.c()) / 1000.0f;
            this.A2 = c2;
            this.E2 = f4;
            this.G2 = true;
            if (!(i2 == 0 || i2 == 1 || i2 == 2)) {
                if (i2 == 4) {
                    c cVar = this.O2;
                    float f5 = this.C2;
                    float h2 = this.o2.h();
                    cVar.a = f3;
                    cVar.b = f5;
                    cVar.c = h2;
                    this.p2 = this.O2;
                } else if (i2 == 5) {
                    float f6 = this.C2;
                    float h3 = this.o2.h();
                    if (f3 > 0.0f) {
                        float f7 = f3 / h3;
                    } else {
                        float f8 = (-f3) / h3;
                    }
                } else if (i2 != 6) {
                }
                this.F2 = false;
                this.z2 = getNanoTime();
                invalidate();
            }
            if (i2 == 1 || i2 == 7) {
                f4 = 0.0f;
            } else if (i2 == 2 || i2 == 6) {
                f4 = 1.0f;
            }
            r rVar = this.o2;
            r.b bVar = rVar.c;
            if (((bVar == null || (uVar7 = bVar.l) == null) ? 0 : uVar7.F) == 0) {
                h0.g.b.a.a aVar = this.N2;
                float f9 = this.C2;
                float h4 = rVar.h();
                r.b bVar2 = this.o2.c;
                aVar.b(f9, f4, f3, c2, h4, (bVar2 == null || (uVar6 = bVar2.l) == null) ? 0.0f : uVar6.u);
            } else {
                h0.g.b.a.a aVar2 = this.N2;
                float f10 = this.C2;
                float f11 = (bVar == null || (uVar5 = bVar.l) == null) ? 0.0f : uVar5.B;
                float f12 = (bVar == null || (uVar4 = bVar.l) == null) ? 0.0f : uVar4.C;
                float f13 = (bVar == null || (uVar3 = bVar.l) == null) ? 0.0f : uVar3.A;
                float f14 = (bVar == null || (uVar2 = bVar.l) == null) ? 0.0f : uVar2.D;
                int i3 = (bVar == null || (uVar = bVar.l) == null) ? 0 : uVar.E;
                if (aVar2.b == null) {
                    aVar2.b = new h0.g.a.g.a.k();
                }
                h0.g.a.g.a.k kVar = aVar2.b;
                aVar2.c = kVar;
                kVar.c = (double) f4;
                kVar.a = (double) f13;
                kVar.e = f10;
                kVar.b = (double) f12;
                kVar.g = f11;
                kVar.h = f14;
                kVar.i = i3;
                kVar.d = 0.0f;
            }
            int i4 = this.t2;
            this.E2 = f4;
            this.t2 = i4;
            this.p2 = this.N2;
            this.F2 = false;
            this.z2 = getNanoTime();
            invalidate();
        }
    }

    public void I() {
        u(1.0f);
        this.r3 = null;
    }

    public void J(int i2) {
        h0.g.c.h hVar;
        if (!isAttachedToWindow()) {
            if (this.q3 == null) {
                this.q3 = new h();
            }
            this.q3.d = i2;
            return;
        }
        r rVar = this.o2;
        if (!(rVar == null || (hVar = rVar.b) == null)) {
            int i3 = this.t2;
            float f2 = (float) -1;
            h.a aVar = hVar.b.get(i2);
            if (aVar == null) {
                i3 = i2;
            } else {
                int i4 = (f2 > -1.0f ? 1 : (f2 == -1.0f ? 0 : -1));
                if (i4 != 0 && i4 != 0) {
                    Iterator<h.b> it = aVar.b.iterator();
                    h.b bVar = null;
                    while (true) {
                        if (it.hasNext()) {
                            h.b next = it.next();
                            if (next.a(f2, f2)) {
                                if (i3 == next.e) {
                                    break;
                                }
                                bVar = next;
                            }
                        } else {
                            i3 = bVar != null ? bVar.e : aVar.c;
                        }
                    }
                } else if (aVar.c != i3) {
                    Iterator<h.b> it2 = aVar.b.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (i3 == it2.next().e) {
                                break;
                            }
                        } else {
                            i3 = aVar.c;
                            break;
                        }
                    }
                }
            }
            if (i3 != -1) {
                i2 = i3;
            }
        }
        int i5 = this.t2;
        if (i5 != i2) {
            if (this.s2 == i2) {
                u(0.0f);
            } else if (this.u2 == i2) {
                u(1.0f);
            } else {
                this.u2 = i2;
                if (i5 != -1) {
                    G(i5, i2);
                    u(1.0f);
                    this.C2 = 0.0f;
                    I();
                    return;
                }
                this.M2 = false;
                this.E2 = 1.0f;
                this.B2 = 0.0f;
                this.C2 = 0.0f;
                this.D2 = getNanoTime();
                this.z2 = getNanoTime();
                this.F2 = false;
                this.p2 = null;
                this.A2 = ((float) this.o2.c()) / 1000.0f;
                this.s2 = -1;
                this.o2.o(-1, this.u2);
                SparseArray sparseArray = new SparseArray();
                int childCount = getChildCount();
                this.y2.clear();
                for (int i6 = 0; i6 < childCount; i6++) {
                    View childAt = getChildAt(i6);
                    this.y2.put(childAt, new n(childAt));
                    sparseArray.put(childAt.getId(), this.y2.get(childAt));
                }
                this.G2 = true;
                this.w3.d(null, this.o2.b(i2));
                E();
                this.w3.a();
                int childCount2 = getChildCount();
                for (int i7 = 0; i7 < childCount2; i7++) {
                    View childAt2 = getChildAt(i7);
                    n nVar = this.y2.get(childAt2);
                    if (nVar != null) {
                        q qVar = nVar.e;
                        qVar.x = 0.0f;
                        qVar.y = 0.0f;
                        qVar.f(childAt2.getX(), childAt2.getY(), (float) childAt2.getWidth(), (float) childAt2.getHeight());
                        nVar.g.g(childAt2);
                    }
                }
                int width = getWidth();
                int height = getHeight();
                for (int i8 = 0; i8 < childCount; i8++) {
                    n nVar2 = this.y2.get(getChildAt(i8));
                    if (nVar2 != null) {
                        this.o2.g(nVar2);
                        nVar2.f(width, height, getNanoTime());
                    }
                }
                r.b bVar2 = this.o2.c;
                float f3 = bVar2 != null ? bVar2.i : 0.0f;
                if (f3 != 0.0f) {
                    float f4 = Float.MAX_VALUE;
                    float f5 = -3.4028235E38f;
                    for (int i9 = 0; i9 < childCount; i9++) {
                        q qVar2 = this.y2.get(getChildAt(i9)).f;
                        float f6 = qVar2.Z1 + qVar2.Y1;
                        f4 = Math.min(f4, f6);
                        f5 = Math.max(f5, f6);
                    }
                    for (int i10 = 0; i10 < childCount; i10++) {
                        n nVar3 = this.y2.get(getChildAt(i10));
                        q qVar3 = nVar3.f;
                        float f7 = qVar3.Y1;
                        float f8 = qVar3.Z1;
                        nVar3.m = 1.0f / (1.0f - f3);
                        nVar3.l = f3 - ((((f7 + f8) - f4) * f3) / (f5 - f4));
                    }
                }
                this.B2 = 0.0f;
                this.C2 = 0.0f;
                this.G2 = true;
                invalidate();
            }
        }
    }

    public void K(int i2, h0.g.c.c cVar) {
        r rVar = this.o2;
        if (rVar != null) {
            rVar.g.put(i2, cVar);
        }
        this.w3.d(this.o2.b(this.s2), this.o2.b(this.u2));
        E();
        if (this.t2 == i2) {
            cVar.c(this, true);
            setConstraintSet(null);
            requestLayout();
        }
    }

    public void L(int i2, View... viewArr) {
        r rVar = this.o2;
        if (rVar != null) {
            y yVar = rVar.q;
            Objects.requireNonNull(yVar);
            ArrayList arrayList = new ArrayList();
            Iterator<x> it = yVar.b.iterator();
            x xVar = null;
            while (it.hasNext()) {
                x next = it.next();
                if (next.a == i2) {
                    for (View view : viewArr) {
                        if (next.b(view)) {
                            arrayList.add(view);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        View[] viewArr2 = (View[]) arrayList.toArray(new View[0]);
                        int currentState = yVar.a.getCurrentState();
                        if (next.e == 2) {
                            next.a(yVar, yVar.a, currentState, null, viewArr2);
                        } else if (currentState == -1) {
                            String str = yVar.d;
                            StringBuilder P0 = i0.d.a.a.a.P0("No support for ViewTransition within transition yet. Currently: ");
                            P0.append(yVar.a.toString());
                            Log.w(str, P0.toString());
                        } else {
                            h0.g.c.c A = yVar.a.A(currentState);
                            if (A != null) {
                                next.a(yVar, yVar.a, currentState, A, viewArr2);
                            }
                        }
                        arrayList.clear();
                    }
                    xVar = next;
                }
            }
            if (xVar == null) {
                Log.e(yVar.d, " Could not find ViewTransition");
                return;
            }
            return;
        }
        Log.e("MotionLayout", " no motionScene");
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x038d  */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void dispatchDraw(Canvas canvas) {
        int i2;
        Iterator<n> it;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        h0.g.a.g.a.c cVar;
        Iterator<q> it2;
        double d2;
        h0.g.a.g.a.b bVar;
        y yVar;
        ArrayList<x.a> arrayList;
        int i9 = 0;
        w(false);
        r rVar = this.o2;
        if (!(rVar == null || (yVar = rVar.q) == null || (arrayList = yVar.e) == null)) {
            Iterator<x.a> it3 = arrayList.iterator();
            while (it3.hasNext()) {
                it3.next().a();
            }
            yVar.e.removeAll(yVar.f);
            yVar.f.clear();
            if (yVar.e.isEmpty()) {
                yVar.e = null;
            }
        }
        super.dispatchDraw(canvas);
        if (this.o2 != null) {
            int i10 = 1;
            if ((this.K2 & 1) == 1 && !isInEditMode()) {
                this.b3++;
                long nanoTime = getNanoTime();
                long j = this.c3;
                if (j != -1) {
                    long j2 = nanoTime - j;
                    if (j2 > 200000000) {
                        this.d3 = ((float) ((int) ((((float) this.b3) / (((float) j2) * 1.0E-9f)) * 100.0f))) / 100.0f;
                        this.b3 = 0;
                        this.c3 = nanoTime;
                    }
                } else {
                    this.c3 = nanoTime;
                }
                Paint paint = new Paint();
                paint.setTextSize(42.0f);
                StringBuilder P0 = i0.d.a.a.a.P0(this.d3 + " fps " + g0.a.b.b.a.Q(this, this.s2) + " -> ");
                P0.append(g0.a.b.b.a.Q(this, this.u2));
                P0.append(" (progress: ");
                P0.append(((float) ((int) (getProgress() * 1000.0f))) / 10.0f);
                P0.append(" ) state=");
                int i11 = this.t2;
                P0.append(i11 == -1 ? "undefined" : g0.a.b.b.a.Q(this, i11));
                String sb = P0.toString();
                paint.setColor(-16777216);
                canvas.drawText(sb, 11.0f, (float) (getHeight() - 29), paint);
                paint.setColor(-7864184);
                canvas.drawText(sb, 10.0f, (float) (getHeight() - 30), paint);
            }
            if (this.K2 > 1) {
                if (this.L2 == null) {
                    this.L2 = new d();
                }
                d dVar = this.L2;
                HashMap<View, n> hashMap = this.y2;
                int c2 = this.o2.c();
                int i12 = this.K2;
                Objects.requireNonNull(dVar);
                if (!(hashMap == null || hashMap.size() == 0)) {
                    canvas.save();
                    if (!MotionLayout.this.isInEditMode() && (i12 & 1) == 2) {
                        String str = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.u2) + ":" + MotionLayout.this.getProgress();
                        canvas.drawText(str, 10.0f, (float) (MotionLayout.this.getHeight() - 30), dVar.h);
                        canvas.drawText(str, 11.0f, (float) (MotionLayout.this.getHeight() - 29), dVar.e);
                    }
                    Iterator<n> it4 = hashMap.values().iterator();
                    Canvas canvas2 = canvas;
                    while (it4.hasNext()) {
                        n next = it4.next();
                        int i13 = next.e.q;
                        Iterator<q> it5 = next.u.iterator();
                        while (it5.hasNext()) {
                            i13 = Math.max(i13, it5.next().q);
                        }
                        int max = Math.max(i13, next.f.q);
                        if (i12 > 0 && max == 0) {
                            max = i10;
                        }
                        if (max != 0) {
                            float[] fArr = dVar.c;
                            int[] iArr = dVar.b;
                            if (fArr != null) {
                                if (iArr != null) {
                                    Iterator<q> it6 = next.u.iterator();
                                    int i14 = i9;
                                    while (it6.hasNext()) {
                                        iArr[i14] = it6.next().i2;
                                        i14++;
                                    }
                                }
                                int i15 = i9;
                                int i16 = i15;
                                for (double[] f2 = next.i[i9].f(); i9 < f2.length; f2 = f2) {
                                    next.i[i15].c(f2[i9], next.o);
                                    next.e.e(f2[i9], next.n, next.o, fArr, i16);
                                    i16 += 2;
                                    i9++;
                                    i15 = 0;
                                }
                                i2 = i16 / 2;
                            } else {
                                i2 = 0;
                            }
                            dVar.l = i2;
                            if (max >= 1) {
                                int i17 = c2 / 16;
                                float[] fArr2 = dVar.a;
                                if (fArr2 == null || fArr2.length != i17 * 2) {
                                    dVar.a = new float[i17 * 2];
                                    dVar.d = new Path();
                                }
                                float f3 = (float) dVar.n;
                                canvas2.translate(f3, f3);
                                dVar.e.setColor(1996488704);
                                dVar.i.setColor(1996488704);
                                dVar.f.setColor(1996488704);
                                dVar.g.setColor(1996488704);
                                float[] fArr3 = dVar.a;
                                float f4 = 1.0f;
                                float f5 = 1.0f / ((float) (i17 - 1));
                                HashMap<String, h0.g.b.a.c> hashMap2 = next.y;
                                h0.g.b.a.c cVar2 = hashMap2 == null ? null : hashMap2.get("translationX");
                                HashMap<String, h0.g.b.a.c> hashMap3 = next.y;
                                h0.g.b.a.c cVar3 = hashMap3 == null ? null : hashMap3.get("translationY");
                                HashMap<String, h0.g.b.a.b> hashMap4 = next.z;
                                h0.g.b.a.b bVar2 = hashMap4 == null ? null : hashMap4.get("translationX");
                                HashMap<String, h0.g.b.a.b> hashMap5 = next.z;
                                h0.g.b.a.b bVar3 = hashMap5 == null ? null : hashMap5.get("translationY");
                                int i18 = 0;
                                while (i18 < i17) {
                                    float f6 = ((float) i18) * f5;
                                    float f7 = next.m;
                                    if (f7 != f4) {
                                        float f8 = next.l;
                                        if (f6 < f8) {
                                            f6 = 0.0f;
                                        }
                                        if (f6 > f8) {
                                            i8 = c2;
                                            i7 = i12;
                                            if (((double) f6) < 1.0d) {
                                                f6 = Math.min((f6 - f8) * f7, 1.0f);
                                            }
                                            double d3 = (double) f6;
                                            cVar = next.e.d;
                                            it2 = next.u.iterator();
                                            float f9 = Float.NaN;
                                            float f10 = 0.0f;
                                            while (it2.hasNext()) {
                                                q next2 = it2.next();
                                                h0.g.a.g.a.c cVar4 = next2.d;
                                                if (cVar4 != null) {
                                                    float f11 = next2.x;
                                                    if (f11 < f6) {
                                                        f10 = f11;
                                                        cVar = cVar4;
                                                    } else if (Float.isNaN(f9)) {
                                                        f9 = next2.x;
                                                    }
                                                }
                                                it2 = it2;
                                                it4 = it4;
                                            }
                                            if (cVar == null) {
                                                if (Float.isNaN(f9)) {
                                                    f9 = 1.0f;
                                                }
                                                float f12 = f9 - f10;
                                                d2 = (double) ((((float) cVar.a((double) ((f6 - f10) / f12))) * f12) + f10);
                                            } else {
                                                d2 = d3;
                                            }
                                            next.i[0].c(d2, next.o);
                                            bVar = next.j;
                                            if (bVar != null) {
                                                double[] dArr = next.o;
                                                if (dArr.length > 0) {
                                                    bVar.c(d2, dArr);
                                                }
                                            }
                                            int i19 = i18 * 2;
                                            next.e.e(d2, next.n, next.o, fArr3, i19);
                                            if (bVar2 == null) {
                                                fArr3[i19] = bVar2.a(f6) + fArr3[i19];
                                            } else if (cVar2 != null) {
                                                fArr3[i19] = cVar2.a(f6) + fArr3[i19];
                                            }
                                            if (bVar3 == null) {
                                                int i20 = i19 + 1;
                                                fArr3[i20] = bVar3.a(f6) + fArr3[i20];
                                            } else if (cVar3 != null) {
                                                int i21 = i19 + 1;
                                                fArr3[i21] = cVar3.a(f6) + fArr3[i21];
                                            }
                                            i18++;
                                            f4 = 1.0f;
                                            bVar3 = bVar3;
                                            cVar3 = cVar3;
                                            cVar2 = cVar2;
                                            bVar2 = bVar2;
                                            f5 = f5;
                                            c2 = i8;
                                            i12 = i7;
                                            it4 = it4;
                                            i17 = i17;
                                        }
                                    }
                                    i8 = c2;
                                    i7 = i12;
                                    double d32 = (double) f6;
                                    cVar = next.e.d;
                                    it2 = next.u.iterator();
                                    float f92 = Float.NaN;
                                    float f102 = 0.0f;
                                    while (it2.hasNext()) {
                                    }
                                    if (cVar == null) {
                                    }
                                    next.i[0].c(d2, next.o);
                                    bVar = next.j;
                                    if (bVar != null) {
                                    }
                                    int i192 = i18 * 2;
                                    next.e.e(d2, next.n, next.o, fArr3, i192);
                                    if (bVar2 == null) {
                                    }
                                    if (bVar3 == null) {
                                    }
                                    i18++;
                                    f4 = 1.0f;
                                    bVar3 = bVar3;
                                    cVar3 = cVar3;
                                    cVar2 = cVar2;
                                    bVar2 = bVar2;
                                    f5 = f5;
                                    c2 = i8;
                                    i12 = i7;
                                    it4 = it4;
                                    i17 = i17;
                                }
                                it = it4;
                                i4 = c2;
                                i3 = i12;
                                dVar.a(canvas, max, dVar.l, next);
                                dVar.e.setColor(-21965);
                                dVar.f.setColor(-2067046);
                                dVar.i.setColor(-2067046);
                                dVar.g.setColor(-13391360);
                                float f13 = (float) (-dVar.n);
                                canvas.translate(f13, f13);
                                dVar.a(canvas, max, dVar.l, next);
                                if (max == 5) {
                                    dVar.d.reset();
                                    for (int i22 = 0; i22 <= 50; i22++) {
                                        float[] fArr4 = dVar.j;
                                        next.i[0].c((double) next.a(((float) i22) / ((float) 50), null), next.o);
                                        q qVar = next.e;
                                        int[] iArr2 = next.n;
                                        double[] dArr2 = next.o;
                                        float f14 = qVar.Y1;
                                        float f15 = qVar.Z1;
                                        float f16 = qVar.a2;
                                        float f17 = qVar.b2;
                                        for (int i23 = 0; i23 < iArr2.length; i23++) {
                                            float f18 = (float) dArr2[i23];
                                            int i24 = iArr2[i23];
                                            if (i24 == 1) {
                                                f14 = f18;
                                            } else if (i24 == 2) {
                                                f15 = f18;
                                            } else if (i24 == 3) {
                                                f16 = f18;
                                            } else if (i24 == 4) {
                                                f17 = f18;
                                            }
                                        }
                                        if (qVar.g2 != null) {
                                            double d4 = (double) 0.0f;
                                            double d5 = (double) f14;
                                            double d6 = (double) f15;
                                            f15 = (float) ((d4 - (Math.cos(d6) * d5)) - ((double) (f17 / 2.0f)));
                                            f14 = (float) (((Math.sin(d6) * d5) + d4) - ((double) (f16 / 2.0f)));
                                        }
                                        float f19 = f16 + f14;
                                        float f20 = f17 + f15;
                                        Float.isNaN(Float.NaN);
                                        Float.isNaN(Float.NaN);
                                        float f21 = f14 + 0.0f;
                                        float f22 = f15 + 0.0f;
                                        float f23 = f19 + 0.0f;
                                        float f24 = f20 + 0.0f;
                                        fArr4[0] = f21;
                                        fArr4[1] = f22;
                                        fArr4[2] = f23;
                                        fArr4[3] = f22;
                                        fArr4[4] = f23;
                                        fArr4[5] = f24;
                                        fArr4[6] = f21;
                                        fArr4[7] = f24;
                                        Path path = dVar.d;
                                        float[] fArr5 = dVar.j;
                                        path.moveTo(fArr5[0], fArr5[1]);
                                        Path path2 = dVar.d;
                                        float[] fArr6 = dVar.j;
                                        path2.lineTo(fArr6[2], fArr6[3]);
                                        Path path3 = dVar.d;
                                        float[] fArr7 = dVar.j;
                                        path3.lineTo(fArr7[4], fArr7[5]);
                                        Path path4 = dVar.d;
                                        float[] fArr8 = dVar.j;
                                        path4.lineTo(fArr8[6], fArr8[7]);
                                        dVar.d.close();
                                    }
                                    i6 = 0;
                                    i5 = 1;
                                    dVar.e.setColor(1140850688);
                                    canvas.translate(2.0f, 2.0f);
                                    canvas.drawPath(dVar.d, dVar.e);
                                    canvas.translate(-2.0f, -2.0f);
                                    dVar.e.setColor(-65536);
                                    canvas.drawPath(dVar.d, dVar.e);
                                } else {
                                    i6 = 0;
                                    i5 = 1;
                                }
                                canvas2 = canvas;
                                i10 = i5;
                                i9 = i6;
                            } else {
                                it = it4;
                                i4 = c2;
                                i3 = i12;
                                i9 = 0;
                                i10 = 1;
                            }
                            c2 = i4;
                            i12 = i3;
                            it4 = it;
                        }
                    }
                    canvas.restore();
                }
            }
        }
    }

    @Override // h0.i.i.k
    public void e(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        if (!(!this.S2 && i2 == 0 && i3 == 0)) {
            iArr[0] = iArr[0] + i4;
            iArr[1] = iArr[1] + i5;
        }
        this.S2 = false;
    }

    public int[] getConstraintSetIds() {
        r rVar = this.o2;
        if (rVar == null) {
            return null;
        }
        int size = rVar.g.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = rVar.g.keyAt(i2);
        }
        return iArr;
    }

    public int getCurrentState() {
        return this.t2;
    }

    public ArrayList<r.b> getDefinedTransitions() {
        r rVar = this.o2;
        if (rVar == null) {
            return null;
        }
        return rVar.d;
    }

    public h0.g.b.b.b getDesignTool() {
        if (this.P2 == null) {
            this.P2 = new h0.g.b.b.b(this);
        }
        return this.P2;
    }

    public int getEndState() {
        return this.u2;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.C2;
    }

    public int getStartState() {
        return this.s2;
    }

    public float getTargetPosition() {
        return this.E2;
    }

    public Bundle getTransitionState() {
        if (this.q3 == null) {
            this.q3 = new h();
        }
        h hVar = this.q3;
        MotionLayout motionLayout = MotionLayout.this;
        hVar.d = motionLayout.u2;
        hVar.c = motionLayout.s2;
        hVar.b = motionLayout.getVelocity();
        hVar.a = MotionLayout.this.getProgress();
        h hVar2 = this.q3;
        Objects.requireNonNull(hVar2);
        Bundle bundle = new Bundle();
        bundle.putFloat("motion.progress", hVar2.a);
        bundle.putFloat("motion.velocity", hVar2.b);
        bundle.putInt("motion.StartState", hVar2.c);
        bundle.putInt("motion.EndState", hVar2.d);
        return bundle;
    }

    public long getTransitionTimeMs() {
        r rVar = this.o2;
        if (rVar != null) {
            this.A2 = ((float) rVar.c()) / 1000.0f;
        }
        return (long) (this.A2 * 1000.0f);
    }

    public float getVelocity() {
        return this.r2;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void j(int i2) {
        this.e2 = null;
    }

    @Override // h0.i.i.j
    public void k(View view, int i2, int i3, int i4, int i5, int i6) {
    }

    @Override // h0.i.i.j
    public boolean l(View view, View view2, int i2, int i3) {
        r.b bVar;
        u uVar;
        r rVar = this.o2;
        return (rVar == null || (bVar = rVar.c) == null || (uVar = bVar.l) == null || (uVar.y & 2) != 0) ? false : true;
    }

    @Override // h0.i.i.j
    public void m(View view, View view2, int i2, int i3) {
        this.V2 = getNanoTime();
        this.W2 = 0.0f;
        this.T2 = 0.0f;
        this.U2 = 0.0f;
    }

    @Override // h0.i.i.j
    public void n(View view, int i2) {
        u uVar;
        float f2;
        r rVar = this.o2;
        if (rVar != null) {
            float f3 = this.W2;
            float f4 = 0.0f;
            if (f3 != 0.0f) {
                float f5 = this.T2 / f3;
                float f6 = this.U2 / f3;
                r.b bVar = rVar.c;
                if (bVar != null && (uVar = bVar.l) != null) {
                    boolean z = false;
                    uVar.o = false;
                    float progress = uVar.t.getProgress();
                    uVar.t.z(uVar.f, progress, uVar.j, uVar.i, uVar.p);
                    float f7 = uVar.m;
                    float[] fArr = uVar.p;
                    float f8 = fArr[0];
                    float f9 = uVar.n;
                    float f10 = fArr[1];
                    if (f7 != 0.0f) {
                        f2 = (f5 * f7) / fArr[0];
                    } else {
                        f2 = (f6 * f9) / fArr[1];
                    }
                    if (!Float.isNaN(f2)) {
                        progress += f2 / 3.0f;
                    }
                    if (progress != 0.0f) {
                        boolean z2 = progress != 1.0f;
                        int i3 = uVar.e;
                        if (i3 != 3) {
                            z = true;
                        }
                        if (z && z2) {
                            MotionLayout motionLayout = uVar.t;
                            if (((double) progress) >= 0.5d) {
                                f4 = 1.0f;
                            }
                            motionLayout.H(i3, f4, f2);
                        }
                    }
                }
            }
        }
    }

    @Override // h0.i.i.j
    public void o(View view, int i2, int i3, int[] iArr, int i4) {
        r.b bVar;
        boolean z;
        boolean z2;
        u uVar;
        float f2;
        float f3;
        u uVar2;
        u uVar3;
        u uVar4;
        int i5;
        r rVar = this.o2;
        if (rVar != null && (bVar = rVar.c) != null && (!bVar.o)) {
            int i6 = -1;
            if (!z || (uVar4 = bVar.l) == null || (i5 = uVar4.g) == -1 || view.getId() == i5) {
                r.b bVar2 = rVar.c;
                if ((bVar2 == null || (uVar3 = bVar2.l) == null) ? false : uVar3.w) {
                    u uVar5 = bVar.l;
                    if (!(uVar5 == null || (uVar5.y & 4) == 0)) {
                        i6 = i3;
                    }
                    float f4 = this.B2;
                    if ((f4 == 1.0f || f4 == 0.0f) && view.canScrollVertically(i6)) {
                        return;
                    }
                }
                u uVar6 = bVar.l;
                if (!(uVar6 == null || (uVar6.y & 1) == 0)) {
                    float f5 = (float) i2;
                    float f6 = (float) i3;
                    r.b bVar3 = rVar.c;
                    if (bVar3 == null || (uVar2 = bVar3.l) == null) {
                        f3 = 0.0f;
                    } else {
                        uVar2.t.z(uVar2.f, uVar2.t.getProgress(), uVar2.j, uVar2.i, uVar2.p);
                        float f7 = uVar2.m;
                        if (f7 != 0.0f) {
                            float[] fArr = uVar2.p;
                            if (fArr[0] == 0.0f) {
                                fArr[0] = 1.0E-7f;
                            }
                            f3 = (f5 * f7) / fArr[0];
                        } else {
                            float[] fArr2 = uVar2.p;
                            if (fArr2[1] == 0.0f) {
                                fArr2[1] = 1.0E-7f;
                            }
                            f3 = (f6 * uVar2.n) / fArr2[1];
                        }
                    }
                    float f8 = this.C2;
                    if ((f8 <= 0.0f && f3 < 0.0f) || (f8 >= 1.0f && f3 > 0.0f)) {
                        view.setNestedScrollingEnabled(false);
                        view.post(new a(this, view));
                        return;
                    }
                }
                float f9 = this.B2;
                long nanoTime = getNanoTime();
                float f10 = (float) i2;
                this.T2 = f10;
                float f11 = (float) i3;
                this.U2 = f11;
                this.W2 = (float) (((double) (nanoTime - this.V2)) * 1.0E-9d);
                this.V2 = nanoTime;
                r.b bVar4 = rVar.c;
                if (!(bVar4 == null || (uVar = bVar4.l) == null)) {
                    float progress = uVar.t.getProgress();
                    if (!uVar.o) {
                        uVar.o = true;
                        uVar.t.setProgress(progress);
                    }
                    uVar.t.z(uVar.f, progress, uVar.j, uVar.i, uVar.p);
                    float f12 = uVar.m;
                    float[] fArr3 = uVar.p;
                    if (((double) Math.abs((uVar.n * fArr3[1]) + (f12 * fArr3[0]))) < 0.01d) {
                        float[] fArr4 = uVar.p;
                        fArr4[0] = 0.01f;
                        fArr4[1] = 0.01f;
                    }
                    float f13 = uVar.m;
                    if (f13 != 0.0f) {
                        f2 = (f10 * f13) / uVar.p[0];
                    } else {
                        f2 = (f11 * uVar.n) / uVar.p[1];
                    }
                    float max = Math.max(Math.min(progress + f2, 1.0f), 0.0f);
                    if (max != uVar.t.getProgress()) {
                        uVar.t.setProgress(max);
                    }
                }
                if (f9 != this.B2) {
                    iArr[0] = i2;
                    z2 = true;
                    iArr[1] = i3;
                } else {
                    z2 = true;
                }
                w(false);
                if (iArr[0] == 0) {
                    char c2 = z2 ? 1 : 0;
                    char c3 = z2 ? 1 : 0;
                    char c4 = z2 ? 1 : 0;
                    if (iArr[c2] == 0) {
                        return;
                    }
                }
                this.S2 = z2;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        r.b bVar;
        int i2;
        boolean z;
        super.onAttachedToWindow();
        Display display = getDisplay();
        if (display != null) {
            display.getRotation();
        }
        r rVar = this.o2;
        if (!(rVar == null || (i2 = this.t2) == -1)) {
            h0.g.c.c b2 = rVar.b(i2);
            r rVar2 = this.o2;
            int i3 = 0;
            while (true) {
                if (i3 >= rVar2.g.size()) {
                    break;
                }
                int keyAt = rVar2.g.keyAt(i3);
                int i4 = rVar2.i.get(keyAt);
                int size = rVar2.i.size();
                while (i4 > 0) {
                    if (i4 != keyAt) {
                        int i5 = size - 1;
                        if (size >= 0) {
                            i4 = rVar2.i.get(i4);
                            size = i5;
                        }
                    }
                    z = true;
                    break;
                }
                z = false;
                if (z) {
                    Log.e("MotionScene", "Cannot be derived from yourself");
                    break;
                } else {
                    rVar2.n(keyAt, this);
                    i3++;
                }
            }
            if (b2 != null) {
                b2.c(this, true);
                setConstraintSet(null);
                requestLayout();
            }
            this.s2 = this.t2;
        }
        C();
        h hVar = this.q3;
        if (hVar == null) {
            r rVar3 = this.o2;
            if (rVar3 != null && (bVar = rVar3.c) != null && bVar.n == 4) {
                I();
                setState(TransitionState.SETUP);
                setState(TransitionState.MOVING);
            }
        } else if (this.u3) {
            post(new b());
        } else {
            hVar.a();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        u uVar;
        int i2;
        RectF b2;
        int currentState;
        int i3;
        x xVar;
        r rVar = this.o2;
        if (rVar != null && this.x2) {
            y yVar = rVar.q;
            if (!(yVar == null || (currentState = yVar.a.getCurrentState()) == -1)) {
                if (yVar.c == null) {
                    yVar.c = new HashSet<>();
                    Iterator<x> it = yVar.b.iterator();
                    while (it.hasNext()) {
                        x next = it.next();
                        int childCount = yVar.a.getChildCount();
                        for (int i4 = 0; i4 < childCount; i4++) {
                            View childAt = yVar.a.getChildAt(i4);
                            if (next.c(childAt)) {
                                childAt.getId();
                                yVar.c.add(childAt);
                            }
                        }
                    }
                }
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                Rect rect = new Rect();
                int action = motionEvent.getAction();
                ArrayList<x.a> arrayList = yVar.e;
                int i5 = 2;
                if (arrayList != null && !arrayList.isEmpty()) {
                    Iterator<x.a> it2 = yVar.e.iterator();
                    while (it2.hasNext()) {
                        x.a next2 = it2.next();
                        Objects.requireNonNull(next2);
                        if (action != 1) {
                            if (action == 2) {
                                next2.d.b.getHitRect(next2.m);
                                if (!next2.m.contains((int) x, (int) y) && !next2.i) {
                                    next2.b(true);
                                }
                            }
                        } else if (!next2.i) {
                            next2.b(true);
                        }
                    }
                }
                if (action == 0 || action == 1) {
                    h0.g.c.c A = yVar.a.A(currentState);
                    Iterator<x> it3 = yVar.b.iterator();
                    while (it3.hasNext()) {
                        x next3 = it3.next();
                        int i6 = next3.b;
                        if (i6 != 1 ? !(i6 != i5 ? !(i6 == 3 && action == 0) : action != 1) : action == 0) {
                            Iterator<View> it4 = yVar.c.iterator();
                            while (it4.hasNext()) {
                                View next4 = it4.next();
                                if (next3.c(next4)) {
                                    next4.getHitRect(rect);
                                    if (rect.contains((int) x, (int) y)) {
                                        xVar = next3;
                                        i3 = i5;
                                        next3.a(yVar, yVar.a, currentState, A, next4);
                                    } else {
                                        xVar = next3;
                                        i3 = i5;
                                    }
                                    next3 = xVar;
                                    i5 = i3;
                                }
                            }
                        }
                    }
                }
            }
            r.b bVar = this.o2.c;
            if (bVar != null && (!bVar.o) && (uVar = bVar.l) != null && ((motionEvent.getAction() != 0 || (b2 = uVar.b(this, new RectF())) == null || b2.contains(motionEvent.getX(), motionEvent.getY())) && (i2 = uVar.g) != -1)) {
                View view = this.z3;
                if (view == null || view.getId() != i2) {
                    this.z3 = findViewById(i2);
                }
                View view2 = this.z3;
                if (view2 != null) {
                    this.y3.set((float) view2.getLeft(), (float) this.z3.getTop(), (float) this.z3.getRight(), (float) this.z3.getBottom());
                    if (this.y3.contains(motionEvent.getX(), motionEvent.getY()) && !B((float) this.z3.getLeft(), (float) this.z3.getTop(), this.z3, motionEvent)) {
                        return onTouchEvent(motionEvent);
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.p3 = true;
        try {
            if (this.o2 == null) {
                super.onLayout(z, i2, i3, i4, i5);
                return;
            }
            int i6 = i4 - i2;
            int i7 = i5 - i3;
            if (!(this.Q2 == i6 && this.R2 == i7)) {
                E();
                w(true);
            }
            this.Q2 = i6;
            this.R2 = i7;
        } finally {
            this.p3 = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x004e, code lost:
        if (((r6 == r8.e && r7 == r8.f) ? false : true) != false) goto L_0x0050;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void onMeasure(int i2, int i3) {
        boolean z;
        Interpolator interpolator;
        float f2;
        int i4;
        int childCount;
        Interpolator interpolator2;
        int i5;
        int i6;
        if (this.o2 == null) {
            super.onMeasure(i2, i3);
            return;
        }
        boolean z2 = true;
        boolean z3 = (this.v2 == i2 && this.w2 == i3) ? false : true;
        if (this.x3) {
            this.x3 = false;
            C();
            D();
            z3 = true;
        }
        if (this.b2) {
            z3 = true;
        }
        this.v2 = i2;
        this.w2 = i3;
        int i7 = this.o2.i();
        int d2 = this.o2.d();
        if (!z3) {
            e eVar = this.w3;
        }
        if (this.s2 != -1) {
            super.onMeasure(i2, i3);
            this.w3.d(this.o2.b(i7), this.o2.b(d2));
            this.w3.e();
            e eVar2 = this.w3;
            eVar2.e = i7;
            eVar2.f = d2;
            z = false;
            if (!this.g3 || z) {
                int paddingBottom = getPaddingBottom() + getPaddingTop();
                int w = this.x.w() + getPaddingRight() + getPaddingLeft();
                int q = this.x.q() + paddingBottom;
                i5 = this.l3;
                if (i5 != Integer.MIN_VALUE || i5 == 0) {
                    int i8 = this.h3;
                    w = (int) ((this.n3 * ((float) (this.j3 - i8))) + ((float) i8));
                    requestLayout();
                }
                i6 = this.m3;
                if (i6 != Integer.MIN_VALUE || i6 == 0) {
                    int i9 = this.i3;
                    q = (int) ((this.n3 * ((float) (this.k3 - i9))) + ((float) i9));
                    requestLayout();
                }
                setMeasuredDimension(w, q);
            }
            float signum = Math.signum(this.E2 - this.C2);
            long nanoTime = getNanoTime();
            interpolator = this.p2;
            f2 = this.C2 + (interpolator instanceof h0.g.b.a.a ? ((((float) (nanoTime - this.D2)) * signum) * 1.0E-9f) / this.A2 : 0.0f);
            if (this.F2) {
                f2 = this.E2;
            }
            i4 = (signum > 0.0f ? 1 : (signum == 0.0f ? 0 : -1));
            if ((i4 > 0 || f2 < this.E2) && (signum > 0.0f || f2 > this.E2)) {
                z2 = false;
            } else {
                f2 = this.E2;
            }
            if (interpolator != null && !z2) {
                if (!this.M2) {
                    f2 = interpolator.getInterpolation(((float) (nanoTime - this.z2)) * 1.0E-9f);
                } else {
                    f2 = interpolator.getInterpolation(f2);
                }
            }
            if ((i4 > 0 && f2 >= this.E2) || (signum <= 0.0f && f2 <= this.E2)) {
                f2 = this.E2;
            }
            this.n3 = f2;
            childCount = getChildCount();
            long nanoTime2 = getNanoTime();
            interpolator2 = this.q2;
            if (interpolator2 != null) {
                f2 = interpolator2.getInterpolation(f2);
            }
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                n nVar = this.y2.get(childAt);
                if (nVar != null) {
                    nVar.c(childAt, f2, nanoTime2, this.o3);
                }
            }
            if (this.g3) {
                requestLayout();
                return;
            }
            return;
        }
        if (z3) {
            super.onMeasure(i2, i3);
        }
        z = true;
        if (!this.g3) {
        }
        int paddingBottom2 = getPaddingBottom() + getPaddingTop();
        int w2 = this.x.w() + getPaddingRight() + getPaddingLeft();
        int q2 = this.x.q() + paddingBottom2;
        i5 = this.l3;
        if (i5 != Integer.MIN_VALUE) {
        }
        int i82 = this.h3;
        w2 = (int) ((this.n3 * ((float) (this.j3 - i82))) + ((float) i82));
        requestLayout();
        i6 = this.m3;
        if (i6 != Integer.MIN_VALUE) {
        }
        int i92 = this.i3;
        q2 = (int) ((this.n3 * ((float) (this.k3 - i92))) + ((float) i92));
        requestLayout();
        setMeasuredDimension(w2, q2);
        float signum2 = Math.signum(this.E2 - this.C2);
        long nanoTime3 = getNanoTime();
        interpolator = this.p2;
        f2 = this.C2 + (interpolator instanceof h0.g.b.a.a ? ((((float) (nanoTime3 - this.D2)) * signum2) * 1.0E-9f) / this.A2 : 0.0f);
        if (this.F2) {
        }
        i4 = (signum2 > 0.0f ? 1 : (signum2 == 0.0f ? 0 : -1));
        if (i4 > 0) {
        }
        z2 = false;
        if (interpolator != null) {
            if (!this.M2) {
            }
        }
        if (i4 > 0) {
            f2 = this.E2;
            this.n3 = f2;
            childCount = getChildCount();
            long nanoTime22 = getNanoTime();
            interpolator2 = this.q2;
            if (interpolator2 != null) {
            }
            while (i10 < childCount) {
            }
            if (this.g3) {
            }
        }
        f2 = this.E2;
        this.n3 = f2;
        childCount = getChildCount();
        long nanoTime222 = getNanoTime();
        interpolator2 = this.q2;
        if (interpolator2 != null) {
        }
        while (i10 < childCount) {
        }
        if (this.g3) {
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f2, float f3, boolean z) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i2) {
        u uVar;
        r rVar = this.o2;
        if (rVar != null) {
            boolean i3 = i();
            rVar.p = i3;
            r.b bVar = rVar.c;
            if (bVar != null && (uVar = bVar.l) != null) {
                uVar.c(i3);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:169:0x04df  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0504  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0520  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x052f  */
    @Override // android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        f fVar;
        f fVar2;
        u uVar;
        char c2;
        char c3;
        float f2;
        int i2;
        char c4;
        char c5;
        char c6;
        char c7;
        float f3;
        int i3;
        float f4;
        int i4;
        int i5;
        float f5;
        float f6;
        int i6;
        char c8;
        MotionEvent motionEvent2;
        r.b bVar;
        int i7;
        float f7;
        float f8;
        Iterator it;
        RectF rectF;
        MotionEvent motionEvent3;
        r.b bVar2;
        u uVar2;
        RectF a2;
        r rVar = this.o2;
        if (rVar == null || !this.x2 || !rVar.p()) {
            return super.onTouchEvent(motionEvent);
        }
        r rVar2 = this.o2;
        r.b bVar3 = rVar2.c;
        if (bVar3 != null && !(!bVar3.o)) {
            return super.onTouchEvent(motionEvent);
        }
        int currentState = getCurrentState();
        Objects.requireNonNull(rVar2);
        RectF rectF2 = new RectF();
        if (rVar2.o == null) {
            Objects.requireNonNull(rVar2.a);
            g.a.b = VelocityTracker.obtain();
            rVar2.o = g.a;
        }
        VelocityTracker velocityTracker = ((g) rVar2.o).b;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        if (currentState != -1) {
            int action = motionEvent.getAction();
            if (action == 0) {
                rVar2.r = motionEvent.getRawX();
                rVar2.s = motionEvent.getRawY();
                rVar2.l = motionEvent;
                rVar2.m = false;
                u uVar3 = rVar2.c.l;
                if (uVar3 == null) {
                    return true;
                }
                RectF a3 = uVar3.a(rVar2.a, rectF2);
                if (a3 == null || a3.contains(rVar2.l.getX(), rVar2.l.getY())) {
                    RectF b2 = rVar2.c.l.b(rVar2.a, rectF2);
                    if (b2 == null || b2.contains(rVar2.l.getX(), rVar2.l.getY())) {
                        rVar2.n = false;
                    } else {
                        rVar2.n = true;
                    }
                    u uVar4 = rVar2.c.l;
                    float f9 = rVar2.r;
                    float f10 = rVar2.s;
                    uVar4.r = f9;
                    uVar4.s = f10;
                    return true;
                }
                rVar2.l = null;
                rVar2.m = true;
                return true;
            } else if (action == 2 && !rVar2.m) {
                float rawY = motionEvent.getRawY() - rVar2.s;
                float rawX = motionEvent.getRawX() - rVar2.r;
                if ((((double) rawX) == 0.0d && ((double) rawY) == 0.0d) || (motionEvent2 = rVar2.l) == null) {
                    return true;
                }
                if (currentState != -1) {
                    h0.g.c.h hVar = rVar2.b;
                    if (hVar == null || (i7 = hVar.a(currentState, -1, -1)) == -1) {
                        i7 = currentState;
                    }
                    ArrayList arrayList = new ArrayList();
                    Iterator<r.b> it2 = rVar2.d.iterator();
                    while (it2.hasNext()) {
                        r.b next = it2.next();
                        if (next.d == i7 || next.c == i7) {
                            arrayList.add(next);
                        }
                    }
                    RectF rectF3 = new RectF();
                    Iterator it3 = arrayList.iterator();
                    float f11 = 0.0f;
                    bVar = null;
                    while (it3.hasNext()) {
                        r.b bVar4 = (r.b) it3.next();
                        if (!bVar4.o && (uVar2 = bVar4.l) != null) {
                            uVar2.c(rVar2.p);
                            RectF b3 = bVar4.l.b(rVar2.a, rectF3);
                            if ((b3 == null || b3.contains(motionEvent2.getX(), motionEvent2.getY())) && ((a2 = bVar4.l.a(rVar2.a, rectF3)) == null || a2.contains(motionEvent2.getX(), motionEvent2.getY()))) {
                                u uVar5 = bVar4.l;
                                float f12 = (uVar5.n * rawY) + (uVar5.m * rawX);
                                if (uVar5.l) {
                                    float x = motionEvent2.getX();
                                    Objects.requireNonNull(bVar4.l);
                                    float f13 = x - 0.5f;
                                    float y = motionEvent2.getY();
                                    rectF = rectF3;
                                    Objects.requireNonNull(bVar4.l);
                                    float f14 = y - 0.5f;
                                    it = it3;
                                    f8 = rawY;
                                    f7 = rawX;
                                    double atan2 = Math.atan2((double) (rawY + f14), (double) (rawX + f13));
                                    double d2 = (double) f13;
                                    motionEvent3 = motionEvent2;
                                    bVar2 = bVar;
                                    f12 = ((float) (atan2 - Math.atan2(d2, (double) f14))) * 10.0f;
                                } else {
                                    rectF = rectF3;
                                    it = it3;
                                    f8 = rawY;
                                    f7 = rawX;
                                    motionEvent3 = motionEvent2;
                                    bVar2 = bVar;
                                }
                                float f15 = (bVar4.c == currentState ? -1.0f : 1.1f) * f12;
                                if (f15 > f11) {
                                    f11 = f15;
                                    bVar = bVar4;
                                    motionEvent2 = motionEvent3;
                                    rectF3 = rectF;
                                    it3 = it;
                                    rawY = f8;
                                    rawX = f7;
                                }
                                bVar = bVar2;
                                motionEvent2 = motionEvent3;
                                rectF3 = rectF;
                                it3 = it;
                                rawY = f8;
                                rawX = f7;
                            }
                        }
                        rectF = rectF3;
                        it = it3;
                        f8 = rawY;
                        f7 = rawX;
                        motionEvent3 = motionEvent2;
                        bVar2 = bVar;
                        bVar = bVar2;
                        motionEvent2 = motionEvent3;
                        rectF3 = rectF;
                        it3 = it;
                        rawY = f8;
                        rawX = f7;
                    }
                } else {
                    bVar = rVar2.c;
                }
                if (bVar != null) {
                    setTransition(bVar);
                    RectF b4 = rVar2.c.l.b(rVar2.a, rectF2);
                    rVar2.n = b4 != null && !b4.contains(rVar2.l.getX(), rVar2.l.getY());
                    u uVar6 = rVar2.c.l;
                    float f16 = rVar2.r;
                    float f17 = rVar2.s;
                    uVar6.r = f16;
                    uVar6.s = f17;
                    uVar6.o = false;
                }
            }
        }
        if (rVar2.m) {
            return true;
        }
        r.b bVar5 = rVar2.c;
        if (!(bVar5 == null || (uVar = bVar5.l) == null || rVar2.n)) {
            f fVar3 = rVar2.o;
            if (uVar.l) {
                g gVar = (g) fVar3;
                VelocityTracker velocityTracker2 = gVar.b;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                }
                int action2 = motionEvent.getAction();
                if (action2 == 0) {
                    uVar.r = motionEvent.getRawX();
                    uVar.s = motionEvent.getRawY();
                    uVar.o = false;
                } else if (action2 == 1) {
                    uVar.o = false;
                    gVar.a(16);
                    float b5 = gVar.b();
                    float c9 = gVar.c();
                    float progress = uVar.t.getProgress();
                    float width = ((float) uVar.t.getWidth()) / 2.0f;
                    float height = ((float) uVar.t.getHeight()) / 2.0f;
                    int i8 = uVar.k;
                    if (i8 != -1) {
                        View findViewById = uVar.t.findViewById(i8);
                        uVar.t.getLocationOnScreen(uVar.q);
                        f5 = (((float) (findViewById.getRight() + findViewById.getLeft())) / 2.0f) + ((float) uVar.q[0]);
                        f6 = (float) uVar.q[1];
                        i5 = findViewById.getTop();
                        i6 = findViewById.getBottom();
                    } else {
                        int i9 = uVar.f;
                        if (i9 != -1) {
                            MotionLayout motionLayout = uVar.t;
                            View findViewById2 = uVar.t.findViewById(motionLayout.y2.get(motionLayout.findViewById(i9)).e.e2);
                            uVar.t.getLocationOnScreen(uVar.q);
                            f5 = (((float) (findViewById2.getRight() + findViewById2.getLeft())) / 2.0f) + ((float) uVar.q[0]);
                            f6 = (float) uVar.q[1];
                            i5 = findViewById2.getTop();
                            i6 = findViewById2.getBottom();
                        }
                        float rawX2 = motionEvent.getRawX() - width;
                        float rawY2 = motionEvent.getRawY() - height;
                        double degrees = Math.toDegrees(Math.atan2((double) rawY2, (double) rawX2));
                        i3 = uVar.f;
                        if (i3 == -1) {
                            uVar.t.z(i3, progress, uVar.j, uVar.i, uVar.p);
                            float[] fArr = uVar.p;
                            fArr[1] = (float) Math.toDegrees((double) fArr[1]);
                        } else {
                            uVar.p[1] = 360.0f;
                        }
                        float degrees2 = ((float) (Math.toDegrees(Math.atan2((double) (c9 + rawY2), (double) (b5 + rawX2))) - degrees)) * 62.5f;
                        f4 = Float.isNaN(degrees2) ? (((degrees2 * 3.0f) * uVar.x) / uVar.p[1]) + progress : progress;
                        if (f4 == 0.0f && f4 != 1.0f && (i4 = uVar.e) != 3) {
                            float f18 = (degrees2 * uVar.x) / uVar.p[1];
                            float f19 = ((double) f4) < 0.5d ? 0.0f : 1.0f;
                            if (i4 == 6) {
                                if (progress + f18 < 0.0f) {
                                    f18 = Math.abs(f18);
                                }
                                f19 = 1.0f;
                            }
                            if (uVar.e == 7) {
                                if (progress + f18 > 1.0f) {
                                    f18 = -Math.abs(f18);
                                }
                                f19 = 0.0f;
                            }
                            uVar.t.H(uVar.e, f19, f18 * 3.0f);
                            if (0.0f >= progress || 1.0f <= progress) {
                                uVar.t.setState(TransitionState.FINISHED);
                            }
                        } else if (0.0f < f4 || 1.0f <= f4) {
                            uVar.t.setState(TransitionState.FINISHED);
                        }
                    }
                    height = f6 + (((float) (i6 + i5)) / 2.0f);
                    width = f5;
                    float rawX22 = motionEvent.getRawX() - width;
                    float rawY22 = motionEvent.getRawY() - height;
                    double degrees3 = Math.toDegrees(Math.atan2((double) rawY22, (double) rawX22));
                    i3 = uVar.f;
                    if (i3 == -1) {
                    }
                    float degrees22 = ((float) (Math.toDegrees(Math.atan2((double) (c9 + rawY22), (double) (b5 + rawX22))) - degrees3)) * 62.5f;
                    if (Float.isNaN(degrees22)) {
                    }
                    if (f4 == 0.0f) {
                    }
                    if (0.0f < f4) {
                    }
                    uVar.t.setState(TransitionState.FINISHED);
                } else if (action2 == 2) {
                    motionEvent.getRawY();
                    motionEvent.getRawX();
                    float width2 = ((float) uVar.t.getWidth()) / 2.0f;
                    float height2 = ((float) uVar.t.getHeight()) / 2.0f;
                    int i10 = uVar.k;
                    if (i10 != -1) {
                        View findViewById3 = uVar.t.findViewById(i10);
                        uVar.t.getLocationOnScreen(uVar.q);
                        float right = ((float) uVar.q[0]) + (((float) (findViewById3.getRight() + findViewById3.getLeft())) / 2.0f);
                        height2 = (((float) (findViewById3.getBottom() + findViewById3.getTop())) / 2.0f) + ((float) uVar.q[1]);
                        width2 = right;
                    } else {
                        int i11 = uVar.f;
                        if (i11 != -1) {
                            MotionLayout motionLayout2 = uVar.t;
                            View findViewById4 = uVar.t.findViewById(motionLayout2.y2.get(motionLayout2.findViewById(i11)).e.e2);
                            if (findViewById4 == null) {
                                Log.e("TouchResponse", "could not find view to animate to");
                            } else {
                                uVar.t.getLocationOnScreen(uVar.q);
                                width2 = ((float) uVar.q[0]) + (((float) (findViewById4.getRight() + findViewById4.getLeft())) / 2.0f);
                                height2 = ((float) uVar.q[1]) + (((float) (findViewById4.getBottom() + findViewById4.getTop())) / 2.0f);
                            }
                        }
                    }
                    float rawX3 = motionEvent.getRawX() - width2;
                    float rawY3 = motionEvent.getRawY() - height2;
                    double atan22 = Math.atan2((double) (motionEvent.getRawY() - height2), (double) (motionEvent.getRawX() - width2));
                    float atan23 = (float) (((atan22 - Math.atan2((double) (uVar.s - height2), (double) (uVar.r - width2))) * 180.0d) / 3.141592653589793d);
                    if (atan23 > 330.0f) {
                        atan23 -= 360.0f;
                    } else if (atan23 < -330.0f) {
                        atan23 += 360.0f;
                    }
                    if (((double) Math.abs(atan23)) > 0.01d || uVar.o) {
                        float progress2 = uVar.t.getProgress();
                        if (!uVar.o) {
                            uVar.o = true;
                            uVar.t.setProgress(progress2);
                        }
                        int i12 = uVar.f;
                        if (i12 != -1) {
                            uVar.t.z(i12, progress2, uVar.j, uVar.i, uVar.p);
                            float[] fArr2 = uVar.p;
                            c8 = 1;
                            fArr2[1] = (float) Math.toDegrees((double) fArr2[1]);
                        } else {
                            c8 = 1;
                            uVar.p[1] = 360.0f;
                        }
                        float max = Math.max(Math.min(((atan23 * uVar.x) / uVar.p[c8]) + progress2, 1.0f), 0.0f);
                        float progress3 = uVar.t.getProgress();
                        if (max != progress3) {
                            int i13 = (progress3 > 0.0f ? 1 : (progress3 == 0.0f ? 0 : -1));
                            if (i13 == 0 || progress3 == 1.0f) {
                                uVar.t.v(i13 == 0);
                            }
                            uVar.t.setProgress(max);
                            gVar.a(1000);
                            float b6 = gVar.b();
                            double c10 = (double) gVar.c();
                            double d3 = (double) b6;
                            uVar.t.r2 = (float) Math.toDegrees((double) ((float) ((Math.sin(Math.atan2(c10, d3) - atan22) * Math.hypot(c10, d3)) / Math.hypot((double) rawX3, (double) rawY3))));
                        } else {
                            uVar.t.r2 = 0.0f;
                        }
                        uVar.r = motionEvent.getRawX();
                        uVar.s = motionEvent.getRawY();
                    }
                }
            } else {
                g gVar2 = (g) fVar3;
                VelocityTracker velocityTracker3 = gVar2.b;
                if (velocityTracker3 != null) {
                    velocityTracker3.addMovement(motionEvent);
                }
                int action3 = motionEvent.getAction();
                if (action3 == 0) {
                    uVar.r = motionEvent.getRawX();
                    uVar.s = motionEvent.getRawY();
                    uVar.o = false;
                } else if (action3 == 1) {
                    uVar.o = false;
                    gVar2.a(1000);
                    float b7 = gVar2.b();
                    float c11 = gVar2.c();
                    float progress4 = uVar.t.getProgress();
                    int i14 = uVar.f;
                    if (i14 != -1) {
                        uVar.t.z(i14, progress4, uVar.j, uVar.i, uVar.p);
                        c3 = 0;
                        c2 = 1;
                    } else {
                        float min = (float) Math.min(uVar.t.getWidth(), uVar.t.getHeight());
                        float[] fArr3 = uVar.p;
                        c2 = 1;
                        fArr3[1] = uVar.n * min;
                        c3 = 0;
                        fArr3[0] = min * uVar.m;
                    }
                    float f20 = uVar.m;
                    float[] fArr4 = uVar.p;
                    float f21 = fArr4[c3];
                    float f22 = fArr4[c2];
                    if (f20 != 0.0f) {
                        f2 = b7 / fArr4[c3];
                    } else {
                        f2 = c11 / fArr4[c2];
                    }
                    float f23 = !Float.isNaN(f2) ? (f2 / 3.0f) + progress4 : progress4;
                    if (f23 != 0.0f && f23 != 1.0f && (i2 = uVar.e) != 3) {
                        float f24 = ((double) f23) < 0.5d ? 0.0f : 1.0f;
                        if (i2 == 6) {
                            if (progress4 + f2 < 0.0f) {
                                f2 = Math.abs(f2);
                            }
                            f24 = 1.0f;
                        }
                        if (uVar.e == 7) {
                            if (progress4 + f2 > 1.0f) {
                                f2 = -Math.abs(f2);
                            }
                            f24 = 0.0f;
                        }
                        uVar.t.H(uVar.e, f24, f2);
                        if (0.0f >= progress4 || 1.0f <= progress4) {
                            uVar.t.setState(TransitionState.FINISHED);
                        }
                    } else if (0.0f >= f23 || 1.0f <= f23) {
                        uVar.t.setState(TransitionState.FINISHED);
                    }
                } else if (action3 == 2) {
                    float rawY4 = motionEvent.getRawY() - uVar.s;
                    float rawX4 = motionEvent.getRawX() - uVar.r;
                    if (Math.abs((uVar.n * rawY4) + (uVar.m * rawX4)) > uVar.z || uVar.o) {
                        float progress5 = uVar.t.getProgress();
                        if (!uVar.o) {
                            uVar.o = true;
                            uVar.t.setProgress(progress5);
                        }
                        int i15 = uVar.f;
                        if (i15 != -1) {
                            uVar.t.z(i15, progress5, uVar.j, uVar.i, uVar.p);
                            c5 = 0;
                            c4 = 1;
                        } else {
                            float min2 = (float) Math.min(uVar.t.getWidth(), uVar.t.getHeight());
                            float[] fArr5 = uVar.p;
                            c4 = 1;
                            fArr5[1] = uVar.n * min2;
                            c5 = 0;
                            fArr5[0] = min2 * uVar.m;
                        }
                        float f25 = uVar.m;
                        float[] fArr6 = uVar.p;
                        if (((double) Math.abs(((uVar.n * fArr6[c4]) + (f25 * fArr6[c5])) * uVar.x)) < 0.01d) {
                            float[] fArr7 = uVar.p;
                            c7 = 0;
                            fArr7[0] = 0.01f;
                            c6 = 1;
                            fArr7[1] = 0.01f;
                        } else {
                            c7 = 0;
                            c6 = 1;
                        }
                        if (uVar.m != 0.0f) {
                            f3 = rawX4 / uVar.p[c7];
                        } else {
                            f3 = rawY4 / uVar.p[c6];
                        }
                        float max2 = Math.max(Math.min(progress5 + f3, 1.0f), 0.0f);
                        if (uVar.e == 6) {
                            max2 = Math.max(max2, 0.01f);
                        }
                        if (uVar.e == 7) {
                            max2 = Math.min(max2, 0.99f);
                        }
                        float progress6 = uVar.t.getProgress();
                        if (max2 != progress6) {
                            int i16 = (progress6 > 0.0f ? 1 : (progress6 == 0.0f ? 0 : -1));
                            if (i16 == 0 || progress6 == 1.0f) {
                                uVar.t.v(i16 == 0);
                            }
                            uVar.t.setProgress(max2);
                            gVar2.a(1000);
                            uVar.t.r2 = uVar.m != 0.0f ? gVar2.b() / uVar.p[0] : gVar2.c() / uVar.p[1];
                        } else {
                            uVar.t.r2 = 0.0f;
                        }
                        uVar.r = motionEvent.getRawX();
                        uVar.s = motionEvent.getRawY();
                    }
                }
            }
        }
        rVar2.r = motionEvent.getRawX();
        rVar2.s = motionEvent.getRawY();
        if (motionEvent.getAction() != 1 || (fVar = rVar2.o) == null) {
            return true;
        }
        g gVar3 = (g) fVar;
        VelocityTracker velocityTracker4 = gVar3.b;
        if (velocityTracker4 != null) {
            velocityTracker4.recycle();
            fVar2 = null;
            gVar3.b = null;
        } else {
            fVar2 = null;
        }
        rVar2.o = fVar2;
        int i17 = this.t2;
        if (i17 == -1) {
            return true;
        }
        rVar2.a(this, i17);
        return true;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof o) {
            o oVar = (o) view;
            if (this.a3 == null) {
                this.a3 = new CopyOnWriteArrayList<>();
            }
            this.a3.add(oVar);
            if (oVar.b2) {
                if (this.Y2 == null) {
                    this.Y2 = new ArrayList<>();
                }
                this.Y2.add(oVar);
            }
            if (oVar.c2) {
                if (this.Z2 == null) {
                    this.Z2 = new ArrayList<>();
                }
                this.Z2.add(oVar);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<o> arrayList = this.Y2;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<o> arrayList2 = this.Z2;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewParent, android.view.View
    public void requestLayout() {
        r rVar;
        r.b bVar;
        if (this.g3 || this.t2 != -1 || (rVar = this.o2) == null || (bVar = rVar.c) == null || bVar.q != 0) {
            super.requestLayout();
        }
    }

    public void setDebugMode(int i2) {
        this.K2 = i2;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z) {
        this.u3 = z;
    }

    public void setInteractionEnabled(boolean z) {
        this.x2 = z;
    }

    public void setInterpolatedProgress(float f2) {
        if (this.o2 != null) {
            setState(TransitionState.MOVING);
            Interpolator f3 = this.o2.f();
            if (f3 != null) {
                setProgress(f3.getInterpolation(f2));
                return;
            }
        }
        setProgress(f2);
    }

    public void setOnHide(float f2) {
        ArrayList<o> arrayList = this.Z2;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.Z2.get(i2).setProgress(f2);
            }
        }
    }

    public void setOnShow(float f2) {
        ArrayList<o> arrayList = this.Y2;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.Y2.get(i2).setProgress(f2);
            }
        }
    }

    public void setProgress(float f2) {
        int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (i2 < 0 || f2 > 1.0f) {
            Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!isAttachedToWindow()) {
            if (this.q3 == null) {
                this.q3 = new h();
            }
            this.q3.a = f2;
            return;
        }
        if (i2 <= 0) {
            if (this.C2 == 1.0f && this.t2 == this.u2) {
                setState(TransitionState.MOVING);
            }
            this.t2 = this.s2;
            if (this.C2 == 0.0f) {
                setState(TransitionState.FINISHED);
            }
        } else if (f2 >= 1.0f) {
            if (this.C2 == 0.0f && this.t2 == this.s2) {
                setState(TransitionState.MOVING);
            }
            this.t2 = this.u2;
            if (this.C2 == 1.0f) {
                setState(TransitionState.FINISHED);
            }
        } else {
            this.t2 = -1;
            setState(TransitionState.MOVING);
        }
        if (this.o2 != null) {
            this.F2 = true;
            this.E2 = f2;
            this.B2 = f2;
            this.D2 = -1;
            this.z2 = -1;
            this.p2 = null;
            this.G2 = true;
            invalidate();
        }
    }

    public void setScene(r rVar) {
        u uVar;
        this.o2 = rVar;
        boolean i2 = i();
        rVar.p = i2;
        r.b bVar = rVar.c;
        if (!(bVar == null || (uVar = bVar.l) == null)) {
            uVar.c(i2);
        }
        E();
    }

    public void setStartState(int i2) {
        if (!isAttachedToWindow()) {
            if (this.q3 == null) {
                this.q3 = new h();
            }
            h hVar = this.q3;
            hVar.c = i2;
            hVar.d = i2;
            return;
        }
        this.t2 = i2;
    }

    public void setState(TransitionState transitionState) {
        TransitionState transitionState2 = TransitionState.FINISHED;
        if (transitionState != transitionState2 || this.t2 != -1) {
            TransitionState transitionState3 = this.v3;
            this.v3 = transitionState;
            TransitionState transitionState4 = TransitionState.MOVING;
            if (transitionState3 == transitionState4 && transitionState == transitionState4) {
                x();
            }
            int ordinal = transitionState3.ordinal();
            if (ordinal == 0 || ordinal == 1) {
                if (transitionState == transitionState4) {
                    x();
                }
                if (transitionState == transitionState2) {
                    y();
                }
            } else if (ordinal == 2 && transitionState == transitionState2) {
                y();
            }
        }
    }

    public void setTransition(int i2) {
        r.b bVar;
        r rVar = this.o2;
        if (rVar != null) {
            Iterator<r.b> it = rVar.d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bVar = null;
                    break;
                }
                bVar = it.next();
                if (bVar.a == i2) {
                    break;
                }
            }
            this.s2 = bVar.d;
            this.u2 = bVar.c;
            if (!isAttachedToWindow()) {
                if (this.q3 == null) {
                    this.q3 = new h();
                }
                h hVar = this.q3;
                hVar.c = this.s2;
                hVar.d = this.u2;
                return;
            }
            float f2 = Float.NaN;
            int i3 = this.t2;
            if (i3 == this.s2) {
                f2 = 0.0f;
            } else if (i3 == this.u2) {
                f2 = 1.0f;
            }
            r rVar2 = this.o2;
            rVar2.c = bVar;
            u uVar = bVar.l;
            if (uVar != null) {
                uVar.c(rVar2.p);
            }
            this.w3.d(this.o2.b(this.s2), this.o2.b(this.u2));
            E();
            if (this.C2 != f2) {
                if (f2 == 0.0f) {
                    v(true);
                    this.o2.b(this.s2).c(this, true);
                    setConstraintSet(null);
                    requestLayout();
                } else if (f2 == 1.0f) {
                    v(false);
                    this.o2.b(this.u2).c(this, true);
                    setConstraintSet(null);
                    requestLayout();
                }
            }
            this.C2 = Float.isNaN(f2) ? 0.0f : f2;
            if (Float.isNaN(f2)) {
                Log.v("MotionLayout", g0.a.b.b.a.M() + " transitionToStart ");
                u(0.0f);
                return;
            }
            setProgress(f2);
        }
    }

    public void setTransitionDuration(int i2) {
        r rVar = this.o2;
        if (rVar == null) {
            Log.e("MotionLayout", "MotionScene not defined");
            return;
        }
        r.b bVar = rVar.c;
        if (bVar != null) {
            bVar.h = Math.max(i2, 8);
        } else {
            rVar.j = i2;
        }
    }

    public void setTransitionListener(i iVar) {
        this.H2 = iVar;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.q3 == null) {
            this.q3 = new h();
        }
        h hVar = this.q3;
        Objects.requireNonNull(hVar);
        hVar.a = bundle.getFloat("motion.progress");
        hVar.b = bundle.getFloat("motion.velocity");
        hVar.c = bundle.getInt("motion.StartState");
        hVar.d = bundle.getInt("motion.EndState");
        if (isAttachedToWindow()) {
            this.q3.a();
        }
    }

    @Override // android.view.View, java.lang.Object
    public String toString() {
        Context context = getContext();
        return g0.a.b.b.a.N(context, this.s2) + "->" + g0.a.b.b.a.N(context, this.u2) + " (pos:" + this.C2 + " Dpos/Dt:" + this.r2;
    }

    public void u(float f2) {
        r rVar = this.o2;
        if (rVar != null) {
            float f3 = this.C2;
            float f4 = this.B2;
            if (f3 != f4 && this.F2) {
                this.C2 = f4;
            }
            float f5 = this.C2;
            if (f5 != f2) {
                this.M2 = false;
                this.E2 = f2;
                this.A2 = ((float) rVar.c()) / 1000.0f;
                setProgress(this.E2);
                this.p2 = null;
                this.q2 = this.o2.f();
                this.F2 = false;
                this.z2 = getNanoTime();
                this.G2 = true;
                this.B2 = f5;
                this.C2 = f5;
                invalidate();
            }
        }
    }

    public void v(boolean z) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            n nVar = this.y2.get(getChildAt(i2));
            if (!(nVar == null || !"button".equals(g0.a.b.b.a.O(nVar.b)) || nVar.A == null)) {
                int i3 = 0;
                while (true) {
                    h0.g.b.b.k[] kVarArr = nVar.A;
                    if (i3 < kVarArr.length) {
                        kVarArr[i3].g(z ? -100.0f : 100.0f, nVar.b);
                        i3++;
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0171  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void w(boolean z) {
        boolean z2;
        boolean z3;
        int childCount;
        Interpolator interpolator;
        int i2;
        int i3;
        int i4;
        if (this.D2 == -1) {
            this.D2 = getNanoTime();
        }
        float f2 = this.C2;
        if (f2 > 0.0f && f2 < 1.0f) {
            this.t2 = -1;
        }
        boolean z4 = true;
        boolean z5 = false;
        if (this.X2 || (this.G2 && (z || this.E2 != f2))) {
            float signum = Math.signum(this.E2 - f2);
            long nanoTime = getNanoTime();
            Interpolator interpolator2 = this.p2;
            float f3 = !(interpolator2 instanceof p) ? ((((float) (nanoTime - this.D2)) * signum) * 1.0E-9f) / this.A2 : 0.0f;
            float f4 = this.C2 + f3;
            if (this.F2) {
                f4 = this.E2;
            }
            int i5 = (signum > 0.0f ? 1 : (signum == 0.0f ? 0 : -1));
            if ((i5 <= 0 || f4 < this.E2) && (signum > 0.0f || f4 > this.E2)) {
                z2 = false;
            } else {
                f4 = this.E2;
                this.G2 = false;
                z2 = true;
            }
            this.C2 = f4;
            this.B2 = f4;
            this.D2 = nanoTime;
            if (interpolator2 == null || z2) {
                this.r2 = f3;
            } else if (this.M2) {
                float interpolation = interpolator2.getInterpolation(((float) (nanoTime - this.z2)) * 1.0E-9f);
                Interpolator interpolator3 = this.p2;
                h0.g.b.a.a aVar = this.N2;
                z3 = interpolator3 == aVar ? aVar.c.a() ? true : true : false;
                this.C2 = interpolation;
                this.D2 = nanoTime;
                Interpolator interpolator4 = this.p2;
                if (interpolator4 instanceof p) {
                    float a2 = ((p) interpolator4).a();
                    this.r2 = a2;
                    if (Math.abs(a2) * this.A2 <= 1.0E-5f && z3) {
                        this.G2 = false;
                    }
                    if (a2 > 0.0f && interpolation >= 1.0f) {
                        this.C2 = 1.0f;
                        this.G2 = false;
                        interpolation = 1.0f;
                    }
                    if (a2 < 0.0f && interpolation <= 0.0f) {
                        this.C2 = 0.0f;
                        this.G2 = false;
                        f4 = 0.0f;
                        if (Math.abs(this.r2) > 1.0E-5f) {
                            setState(TransitionState.MOVING);
                        }
                        if (!z3) {
                            if ((i5 > 0 && f4 >= this.E2) || (signum <= 0.0f && f4 <= this.E2)) {
                                f4 = this.E2;
                                this.G2 = false;
                            }
                            if (f4 >= 1.0f || f4 <= 0.0f) {
                                this.G2 = false;
                                setState(TransitionState.FINISHED);
                            }
                        }
                        childCount = getChildCount();
                        this.X2 = false;
                        long nanoTime2 = getNanoTime();
                        this.n3 = f4;
                        Interpolator interpolator5 = this.q2;
                        float interpolation2 = interpolator5 == null ? f4 : interpolator5.getInterpolation(f4);
                        interpolator = this.q2;
                        if (interpolator != null) {
                            float interpolation3 = interpolator.getInterpolation((signum / this.A2) + f4);
                            this.r2 = interpolation3;
                            this.r2 = interpolation3 - this.q2.getInterpolation(f4);
                        }
                        for (i2 = 0; i2 < childCount; i2++) {
                            View childAt = getChildAt(i2);
                            n nVar = this.y2.get(childAt);
                            if (nVar != null) {
                                this.X2 = nVar.c(childAt, interpolation2, nanoTime2, this.o3) | this.X2;
                            }
                        }
                        boolean z6 = (i5 <= 0 && f4 >= this.E2) || (signum <= 0.0f && f4 <= this.E2);
                        if (!this.X2 && !this.G2 && z6) {
                            setState(TransitionState.FINISHED);
                        }
                        if (this.g3) {
                            requestLayout();
                        }
                        this.X2 = (!z6) | this.X2;
                        if (!(f4 > 0.0f || (i4 = this.s2) == -1 || this.t2 == i4)) {
                            this.t2 = i4;
                            this.o2.b(i4).a(this);
                            setState(TransitionState.FINISHED);
                            z5 = true;
                        }
                        if (((double) f4) >= 1.0d && this.t2 != (i3 = this.u2)) {
                            this.t2 = i3;
                            this.o2.b(i3).a(this);
                            setState(TransitionState.FINISHED);
                            z5 = true;
                        }
                        if (!this.X2 || this.G2) {
                            invalidate();
                        } else if ((i5 > 0 && f4 == 1.0f) || (signum < 0.0f && f4 == 0.0f)) {
                            setState(TransitionState.FINISHED);
                        }
                        if (!this.X2 && !this.G2 && ((i5 > 0 && f4 == 1.0f) || (signum < 0.0f && f4 == 0.0f))) {
                            C();
                        }
                    }
                }
                f4 = interpolation;
                if (Math.abs(this.r2) > 1.0E-5f) {
                }
                if (!z3) {
                }
                childCount = getChildCount();
                this.X2 = false;
                long nanoTime22 = getNanoTime();
                this.n3 = f4;
                Interpolator interpolator52 = this.q2;
                if (interpolator52 == null) {
                }
                interpolator = this.q2;
                if (interpolator != null) {
                }
                while (i2 < childCount) {
                }
                if (i5 <= 0) {
                }
                if (!this.X2) {
                    setState(TransitionState.FINISHED);
                }
                if (this.g3) {
                }
                this.X2 = (!z6) | this.X2;
                if (f4 > 0.0f) {
                    this.t2 = i4;
                    this.o2.b(i4).a(this);
                    setState(TransitionState.FINISHED);
                    z5 = true;
                }
                if (((double) f4) >= 1.0d) {
                    this.t2 = i3;
                    this.o2.b(i3).a(this);
                    setState(TransitionState.FINISHED);
                    z5 = true;
                }
                if (!this.X2) {
                }
                invalidate();
                if (!this.X2) {
                    C();
                }
            } else {
                float interpolation4 = interpolator2.getInterpolation(f4);
                Interpolator interpolator6 = this.p2;
                if (interpolator6 instanceof p) {
                    this.r2 = ((p) interpolator6).a();
                } else {
                    this.r2 = ((interpolator6.getInterpolation(f4 + f3) - interpolation4) * signum) / f3;
                }
                f4 = interpolation4;
            }
            z3 = false;
            if (Math.abs(this.r2) > 1.0E-5f) {
            }
            if (!z3) {
            }
            childCount = getChildCount();
            this.X2 = false;
            long nanoTime222 = getNanoTime();
            this.n3 = f4;
            Interpolator interpolator522 = this.q2;
            if (interpolator522 == null) {
            }
            interpolator = this.q2;
            if (interpolator != null) {
            }
            while (i2 < childCount) {
            }
            if (i5 <= 0) {
            }
            if (!this.X2) {
            }
            if (this.g3) {
            }
            this.X2 = (!z6) | this.X2;
            if (f4 > 0.0f) {
            }
            if (((double) f4) >= 1.0d) {
            }
            if (!this.X2) {
            }
            invalidate();
            if (!this.X2) {
            }
        }
        float f5 = this.C2;
        if (f5 >= 1.0f) {
            int i6 = this.t2;
            int i7 = this.u2;
            if (i6 == i7) {
                z4 = z5;
            }
            this.t2 = i7;
        } else {
            if (f5 <= 0.0f) {
                int i8 = this.t2;
                int i9 = this.s2;
                if (i8 == i9) {
                    z4 = z5;
                }
                this.t2 = i9;
            }
            this.x3 |= z5;
            if (z5 && !this.p3) {
                requestLayout();
            }
            this.B2 = this.C2;
        }
        z5 = z4;
        this.x3 |= z5;
        if (z5) {
            requestLayout();
        }
        this.B2 = this.C2;
    }

    public final void x() {
        CopyOnWriteArrayList<i> copyOnWriteArrayList;
        if ((this.H2 != null || ((copyOnWriteArrayList = this.a3) != null && !copyOnWriteArrayList.isEmpty())) && this.f3 != this.B2) {
            if (this.e3 != -1) {
                i iVar = this.H2;
                if (iVar != null) {
                    iVar.b(this, this.s2, this.u2);
                }
                CopyOnWriteArrayList<i> copyOnWriteArrayList2 = this.a3;
                if (copyOnWriteArrayList2 != null) {
                    Iterator<i> it = copyOnWriteArrayList2.iterator();
                    while (it.hasNext()) {
                        it.next().b(this, this.s2, this.u2);
                    }
                }
            }
            this.e3 = -1;
            float f2 = this.B2;
            this.f3 = f2;
            i iVar2 = this.H2;
            if (iVar2 != null) {
                iVar2.a(this, this.s2, this.u2, f2);
            }
            CopyOnWriteArrayList<i> copyOnWriteArrayList3 = this.a3;
            if (copyOnWriteArrayList3 != null) {
                Iterator<i> it2 = copyOnWriteArrayList3.iterator();
                while (it2.hasNext()) {
                    it2.next().a(this, this.s2, this.u2, this.B2);
                }
            }
        }
    }

    public void y() {
        int i2;
        CopyOnWriteArrayList<i> copyOnWriteArrayList;
        if ((this.H2 != null || ((copyOnWriteArrayList = this.a3) != null && !copyOnWriteArrayList.isEmpty())) && this.e3 == -1) {
            this.e3 = this.t2;
            if (!this.B3.isEmpty()) {
                ArrayList<Integer> arrayList = this.B3;
                i2 = arrayList.get(arrayList.size() - 1).intValue();
            } else {
                i2 = -1;
            }
            int i3 = this.t2;
            if (!(i2 == i3 || i3 == -1)) {
                this.B3.add(Integer.valueOf(i3));
            }
        }
        D();
        Runnable runnable = this.r3;
        if (runnable != null) {
            runnable.run();
        }
    }

    public void z(int i2, float f2, float f3, float f4, float[] fArr) {
        String str;
        double[] dArr;
        HashMap<View, n> hashMap = this.y2;
        View view = this.d.get(i2);
        n nVar = hashMap.get(view);
        if (nVar != null) {
            float a2 = nVar.a(f2, nVar.v);
            h0.g.a.g.a.b[] bVarArr = nVar.i;
            int i3 = 0;
            if (bVarArr != null) {
                double d2 = (double) a2;
                bVarArr[0].e(d2, nVar.p);
                nVar.i[0].c(d2, nVar.o);
                float f5 = nVar.v[0];
                while (true) {
                    dArr = nVar.p;
                    if (i3 >= dArr.length) {
                        break;
                    }
                    dArr[i3] = dArr[i3] * ((double) f5);
                    i3++;
                }
                h0.g.a.g.a.b bVar = nVar.j;
                if (bVar != null) {
                    double[] dArr2 = nVar.o;
                    if (dArr2.length > 0) {
                        bVar.c(d2, dArr2);
                        nVar.j.e(d2, nVar.p);
                        nVar.e.g(f3, f4, fArr, nVar.n, nVar.p, nVar.o);
                    }
                } else {
                    nVar.e.g(f3, f4, fArr, nVar.n, dArr, nVar.o);
                }
            } else {
                q qVar = nVar.f;
                float f6 = qVar.Y1;
                q qVar2 = nVar.e;
                float f7 = f6 - qVar2.Y1;
                float f8 = qVar.Z1 - qVar2.Z1;
                fArr[0] = (((qVar.a2 - qVar2.a2) + f7) * f3) + ((1.0f - f3) * f7);
                fArr[1] = (((qVar.b2 - qVar2.b2) + f8) * f4) + ((1.0f - f4) * f8);
            }
            float y = view.getY();
            this.I2 = f2;
            this.J2 = y;
            return;
        }
        if (view == null) {
            str = i0.d.a.a.a.e0("", i2);
        } else {
            str = view.getContext().getResources().getResourceName(i2);
        }
        Log.w("MotionLayout", "WARNING could not find view id " + str);
    }

    public void setTransition(r.b bVar) {
        long j;
        u uVar;
        r rVar = this.o2;
        rVar.c = bVar;
        if (!(bVar == null || (uVar = bVar.l) == null)) {
            uVar.c(rVar.p);
        }
        setState(TransitionState.SETUP);
        if (this.t2 == this.o2.d()) {
            this.C2 = 1.0f;
            this.B2 = 1.0f;
            this.E2 = 1.0f;
        } else {
            this.C2 = 0.0f;
            this.B2 = 0.0f;
            this.E2 = 0.0f;
        }
        boolean z = true;
        if ((bVar.r & 1) == 0) {
            z = false;
        }
        if (z) {
            j = -1;
        } else {
            j = getNanoTime();
        }
        this.D2 = j;
        int i2 = this.o2.i();
        int d2 = this.o2.d();
        if (i2 != this.s2 || d2 != this.u2) {
            this.s2 = i2;
            this.u2 = d2;
            this.o2.o(i2, d2);
            this.w3.d(this.o2.b(this.s2), this.o2.b(this.u2));
            e eVar = this.w3;
            int i3 = this.s2;
            int i4 = this.u2;
            eVar.e = i3;
            eVar.f = i4;
            eVar.e();
            E();
        }
    }
}
