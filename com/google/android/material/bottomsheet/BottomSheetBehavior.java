package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import h0.i.i.g0.b;
import h0.i.i.q;
import h0.k.a.e;
import i0.h.a.c.q.l;
import i0.h.a.c.q.n;
import i0.h.a.c.w.g;
import i0.h.a.c.w.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {
    public static final int a = R.style.Widget_Design_BottomSheet_Modal;
    public e A;
    public boolean B;
    public int C;
    public boolean D;
    public int E;
    public int F;
    public int G;
    public WeakReference<V> H;
    public WeakReference<View> I;
    public final ArrayList<c> J;
    public VelocityTracker K;
    public int L;
    public int M;
    public boolean N;
    public Map<View, Integer> O;
    public int P;
    public final e.c Q;
    public int b;
    public boolean c;
    public float d;
    public int e;
    public boolean f;
    public int g;
    public int h;
    public boolean i;
    public g j;
    public int k;
    public boolean l;
    public k m;
    public boolean n;
    public BottomSheetBehavior<V>.d o;
    public ValueAnimator p;
    public int q;
    public int r;
    public int s;
    public float t;
    public int u;
    public float v;
    public boolean w;
    public boolean x;
    public boolean y;
    public int z;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public final /* synthetic */ View c;
        public final /* synthetic */ int d;

        public a(View view, int i) {
            this.c = view;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.P(this.c, this.d);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends e.c {
        public b() {
        }

        @Override // h0.k.a.e.c
        public int a(View view, int i, int i2) {
            return view.getLeft();
        }

        @Override // h0.k.a.e.c
        public int b(View view, int i, int i2) {
            int I = BottomSheetBehavior.this.I();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return g0.a.b.b.a.o(i, I, bottomSheetBehavior.w ? bottomSheetBehavior.G : bottomSheetBehavior.u);
        }

        @Override // h0.k.a.e.c
        public int d(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (bottomSheetBehavior.w) {
                return bottomSheetBehavior.G;
            }
            return bottomSheetBehavior.u;
        }

        @Override // h0.k.a.e.c
        public void f(int i) {
            if (i == 1) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.y) {
                    bottomSheetBehavior.O(1);
                }
            }
        }

        @Override // h0.k.a.e.c
        public void g(View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.F(i2);
        }

        @Override // h0.k.a.e.c
        public void h(View view, float f, float f2) {
            int i;
            int i2 = 4;
            if (f2 < 0.0f) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (bottomSheetBehavior.c) {
                    i = bottomSheetBehavior.r;
                } else {
                    int top = view.getTop();
                    BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                    int i3 = bottomSheetBehavior2.s;
                    if (top > i3) {
                        i = i3;
                        i2 = 6;
                    } else {
                        i = bottomSheetBehavior2.q;
                    }
                }
                i2 = 3;
            } else {
                BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                if (bottomSheetBehavior3.w && bottomSheetBehavior3.R(view, f2)) {
                    if (Math.abs(f) >= Math.abs(f2) || f2 <= 500.0f) {
                        int top2 = view.getTop();
                        BottomSheetBehavior bottomSheetBehavior4 = BottomSheetBehavior.this;
                        if (!(top2 > (bottomSheetBehavior4.I() + bottomSheetBehavior4.G) / 2)) {
                            BottomSheetBehavior bottomSheetBehavior5 = BottomSheetBehavior.this;
                            if (bottomSheetBehavior5.c) {
                                i = bottomSheetBehavior5.r;
                            } else if (Math.abs(view.getTop() - BottomSheetBehavior.this.q) < Math.abs(view.getTop() - BottomSheetBehavior.this.s)) {
                                i = BottomSheetBehavior.this.q;
                            } else {
                                i = BottomSheetBehavior.this.s;
                                i2 = 6;
                            }
                            i2 = 3;
                        }
                    }
                    i = BottomSheetBehavior.this.G;
                    i2 = 5;
                } else if (f2 == 0.0f || Math.abs(f) > Math.abs(f2)) {
                    int top3 = view.getTop();
                    BottomSheetBehavior bottomSheetBehavior6 = BottomSheetBehavior.this;
                    if (!bottomSheetBehavior6.c) {
                        int i4 = bottomSheetBehavior6.s;
                        if (top3 < i4) {
                            if (top3 < Math.abs(top3 - bottomSheetBehavior6.u)) {
                                i = BottomSheetBehavior.this.q;
                                i2 = 3;
                            } else {
                                i = BottomSheetBehavior.this.s;
                            }
                        } else if (Math.abs(top3 - i4) < Math.abs(top3 - BottomSheetBehavior.this.u)) {
                            i = BottomSheetBehavior.this.s;
                        } else {
                            i = BottomSheetBehavior.this.u;
                        }
                        i2 = 6;
                    } else if (Math.abs(top3 - bottomSheetBehavior6.r) < Math.abs(top3 - BottomSheetBehavior.this.u)) {
                        i = BottomSheetBehavior.this.r;
                        i2 = 3;
                    } else {
                        i = BottomSheetBehavior.this.u;
                    }
                } else {
                    BottomSheetBehavior bottomSheetBehavior7 = BottomSheetBehavior.this;
                    if (bottomSheetBehavior7.c) {
                        i = bottomSheetBehavior7.u;
                    } else {
                        int top4 = view.getTop();
                        if (Math.abs(top4 - BottomSheetBehavior.this.s) < Math.abs(top4 - BottomSheetBehavior.this.u)) {
                            i = BottomSheetBehavior.this.s;
                            i2 = 6;
                        } else {
                            i = BottomSheetBehavior.this.u;
                        }
                    }
                }
            }
            BottomSheetBehavior.this.S(view, i2, i, true);
        }

        @Override // h0.k.a.e.c
        public boolean i(View view, int i) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i2 = bottomSheetBehavior.z;
            if (i2 == 1 || bottomSheetBehavior.N) {
                return false;
            }
            if (i2 == 3 && bottomSheetBehavior.L == i) {
                WeakReference<View> weakReference = bottomSheetBehavior.I;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.H;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class c {
        public abstract void onSlide(View view, float f);

        public abstract void onStateChanged(View view, int i);
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public final View c;
        public boolean d;
        public int q;

        public d(View view, int i) {
            this.c = view;
            this.q = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = BottomSheetBehavior.this.A;
            if (eVar == null || !eVar.i(true)) {
                BottomSheetBehavior.this.O(this.q);
            } else {
                View view = this.c;
                AtomicInteger atomicInteger = q.a;
                view.postOnAnimation(this);
            }
            this.d = false;
        }
    }

    public BottomSheetBehavior() {
        this.b = 0;
        this.c = true;
        this.o = null;
        this.t = 0.5f;
        this.v = -1.0f;
        this.y = true;
        this.z = 4;
        this.J = new ArrayList<>();
        this.P = -1;
        this.Q = new b();
    }

    public static <V extends View> BottomSheetBehavior<V> H(V v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.f) {
            CoordinatorLayout.c cVar = ((CoordinatorLayout.f) layoutParams).a;
            if (cVar instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) cVar;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.z == 1 && actionMasked == 0) {
            return true;
        }
        e eVar = this.A;
        if (eVar != null) {
            eVar.n(motionEvent);
        }
        if (actionMasked == 0) {
            this.L = -1;
            VelocityTracker velocityTracker = this.K;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.K = null;
            }
        }
        if (this.K == null) {
            this.K = VelocityTracker.obtain();
        }
        this.K.addMovement(motionEvent);
        if (this.A != null && actionMasked == 2 && !this.B) {
            float abs = Math.abs(((float) this.M) - motionEvent.getY());
            e eVar2 = this.A;
            if (abs > ((float) eVar2.c)) {
                eVar2.b(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.B;
    }

    public void B(c cVar) {
        if (!this.J.contains(cVar)) {
            this.J.add(cVar);
        }
    }

    public final void C() {
        int D = D();
        if (this.c) {
            this.u = Math.max(this.G - D, this.r);
        } else {
            this.u = this.G - D;
        }
    }

    public final int D() {
        int i;
        if (this.f) {
            return Math.min(Math.max(this.g, this.G - ((this.F * 9) / 16)), this.E);
        }
        if (this.l || (i = this.k) <= 0) {
            return this.e;
        }
        return Math.max(this.e, i + this.h);
    }

    public final void E(Context context, AttributeSet attributeSet, boolean z, ColorStateList colorStateList) {
        if (this.i) {
            this.m = k.b(context, attributeSet, R.attr.bottomSheetStyle, a, new i0.h.a.c.w.a((float) 0)).a();
            g gVar = new g(this.m);
            this.j = gVar;
            gVar.q.b = new i0.h.a.c.n.a(context);
            gVar.B();
            if (!z || colorStateList == null) {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16842801, typedValue, true);
                this.j.setTint(typedValue.data);
                return;
            }
            this.j.t(colorStateList);
        }
    }

    public void F(int i) {
        float f;
        float f2;
        V v = this.H.get();
        if (!(v == null || this.J.isEmpty())) {
            int i2 = this.u;
            if (i > i2 || i2 == I()) {
                int i3 = this.u;
                f = (float) (i3 - i);
                f2 = (float) (this.G - i3);
            } else {
                int i4 = this.u;
                f = (float) (i4 - i);
                f2 = (float) (i4 - I());
            }
            float f3 = f / f2;
            for (int i5 = 0; i5 < this.J.size(); i5++) {
                this.J.get(i5).onSlide(v, f3);
            }
        }
    }

    public View G(View view) {
        AtomicInteger atomicInteger = q.a;
        if (view.isNestedScrollingEnabled()) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View G = G(viewGroup.getChildAt(i));
            if (G != null) {
                return G;
            }
        }
        return null;
    }

    public int I() {
        return this.c ? this.r : this.q;
    }

    public final void J(V v, b.a aVar, int i) {
        q.n(v, aVar, null, new i0.h.a.c.g.c(this, i));
    }

    public void K(boolean z) {
        if (this.c != z) {
            this.c = z;
            if (this.H != null) {
                C();
            }
            O((!this.c || this.z != 6) ? this.z : 3);
            T();
        }
    }

    public void L(boolean z) {
        if (this.w != z) {
            this.w = z;
            if (!z && this.z == 5) {
                N(4);
            }
            T();
        }
    }

    public void M(int i) {
        boolean z = true;
        if (i == -1) {
            if (!this.f) {
                this.f = true;
            }
            z = false;
        } else {
            if (this.f || this.e != i) {
                this.f = false;
                this.e = Math.max(0, i);
            }
            z = false;
        }
        if (z) {
            W(false);
        }
    }

    public void N(int i) {
        if (i != this.z) {
            if (this.H != null) {
                Q(i);
            } else if (i == 4 || i == 3 || i == 6 || (this.w && i == 5)) {
                this.z = i;
            }
        }
    }

    public void O(int i) {
        V v;
        if (this.z != i) {
            this.z = i;
            WeakReference<V> weakReference = this.H;
            if (!(weakReference == null || (v = weakReference.get()) == null)) {
                if (i == 3) {
                    V(true);
                } else if (i == 6 || i == 5 || i == 4) {
                    V(false);
                }
                U(i);
                for (int i2 = 0; i2 < this.J.size(); i2++) {
                    this.J.get(i2).onStateChanged(v, i);
                }
                T();
            }
        }
    }

    public void P(View view, int i) {
        int i2;
        int i3;
        if (i == 4) {
            i2 = this.u;
        } else if (i == 6) {
            int i4 = this.s;
            if (!this.c || i4 > (i3 = this.r)) {
                i2 = i4;
            } else {
                i = 3;
                i2 = i3;
            }
        } else if (i == 3) {
            i2 = I();
        } else if (!this.w || i != 5) {
            throw new IllegalArgumentException(i0.d.a.a.a.e0("Illegal state argument: ", i));
        } else {
            i2 = this.G;
        }
        S(view, i, i2, false);
    }

    public final void Q(int i) {
        V v = this.H.get();
        if (v != null) {
            ViewParent parent = v.getParent();
            if (parent != null && parent.isLayoutRequested()) {
                AtomicInteger atomicInteger = q.a;
                if (v.isAttachedToWindow()) {
                    v.post(new a(v, i));
                    return;
                }
            }
            P(v, i);
        }
    }

    public boolean R(View view, float f) {
        if (this.x) {
            return true;
        }
        if (view.getTop() < this.u) {
            return false;
        }
        if (Math.abs(((f * 0.1f) + ((float) view.getTop())) - ((float) this.u)) / ((float) D()) > 0.5f) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        if (r7 != false) goto L_0x002f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0010, code lost:
        if (r0.t(r5.getLeft(), r7) != false) goto L_0x002f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void S(View view, int i, int i2, boolean z) {
        e eVar = this.A;
        boolean z2 = false;
        if (eVar != null) {
            if (!z) {
                int left = view.getLeft();
                eVar.t = view;
                eVar.d = -1;
                boolean l = eVar.l(left, i2, 0, 0);
                if (!l && eVar.b == 0 && eVar.t != null) {
                    eVar.t = null;
                }
            }
        }
        if (z2) {
            O(2);
            U(i);
            if (this.o == null) {
                this.o = new d(view, i);
            }
            BottomSheetBehavior<V>.d dVar = this.o;
            if (!dVar.d) {
                dVar.q = i;
                AtomicInteger atomicInteger = q.a;
                view.postOnAnimation(dVar);
                this.o.d = true;
                return;
            }
            dVar.q = i;
            return;
        }
        O(i);
    }

    public final void T() {
        V v;
        WeakReference<V> weakReference = this.H;
        if (weakReference != null && (v = weakReference.get()) != null) {
            q.m(524288, v);
            q.j(v, 0);
            q.m(262144, v);
            q.j(v, 0);
            q.m(1048576, v);
            q.j(v, 0);
            int i = this.P;
            if (i != -1) {
                q.m(i, v);
                q.j(v, 0);
            }
            int i2 = 6;
            if (this.z != 6) {
                this.P = q.a(v, v.getResources().getString(R.string.bottomsheet_action_expand_halfway), new i0.h.a.c.g.c(this, 6));
            }
            if (this.w && this.z != 5) {
                J(v, b.a.f, 5);
            }
            int i3 = this.z;
            if (i3 == 3) {
                if (this.c) {
                    i2 = 4;
                }
                J(v, b.a.e, i2);
            } else if (i3 == 4) {
                if (this.c) {
                    i2 = 3;
                }
                J(v, b.a.d, i2);
            } else if (i3 == 6) {
                J(v, b.a.e, 4);
                J(v, b.a.d, 3);
            }
        }
    }

    public final void U(int i) {
        ValueAnimator valueAnimator;
        if (i != 2) {
            boolean z = i == 3;
            if (this.n != z) {
                this.n = z;
                if (this.j != null && (valueAnimator = this.p) != null) {
                    if (valueAnimator.isRunning()) {
                        this.p.reverse();
                        return;
                    }
                    float f = z ? 0.0f : 1.0f;
                    this.p.setFloatValues(1.0f - f, f);
                    this.p.start();
                }
            }
        }
    }

    public final void V(boolean z) {
        WeakReference<V> weakReference = this.H;
        if (weakReference != null) {
            ViewParent parent = weakReference.get().getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (z) {
                    if (this.O == null) {
                        this.O = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i = 0; i < childCount; i++) {
                    View childAt = coordinatorLayout.getChildAt(i);
                    if (childAt != this.H.get() && z) {
                        this.O.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    }
                }
                if (!z) {
                    this.O = null;
                }
            }
        }
    }

    public final void W(boolean z) {
        V v;
        if (this.H != null) {
            C();
            if (this.z == 4 && (v = this.H.get()) != null) {
                if (z) {
                    Q(this.z);
                } else {
                    v.requestLayout();
                }
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void f(CoordinatorLayout.f fVar) {
        this.H = null;
        this.A = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void i() {
        this.H = null;
        this.A = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean j(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        e eVar;
        if (!v.isShown() || !this.y) {
            this.B = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        View view = null;
        if (actionMasked == 0) {
            this.L = -1;
            VelocityTracker velocityTracker = this.K;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.K = null;
            }
        }
        if (this.K == null) {
            this.K = VelocityTracker.obtain();
        }
        this.K.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.M = (int) motionEvent.getY();
            if (this.z != 2) {
                WeakReference<View> weakReference = this.I;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && coordinatorLayout.q(view2, x, this.M)) {
                    this.L = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.N = true;
                }
            }
            this.B = this.L == -1 && !coordinatorLayout.q(v, x, this.M);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.N = false;
            this.L = -1;
            if (this.B) {
                this.B = false;
                return false;
            }
        }
        if (!this.B && (eVar = this.A) != null && eVar.u(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.I;
        if (weakReference2 != null) {
            view = weakReference2.get();
        }
        return actionMasked == 2 && view != null && !this.B && this.z != 1 && !coordinatorLayout.q(view, (int) motionEvent.getX(), (int) motionEvent.getY()) && this.A != null && Math.abs(((float) this.M) - motionEvent.getY()) > ((float) this.A.c);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v, int i) {
        g gVar;
        AtomicInteger atomicInteger = q.a;
        if (coordinatorLayout.getFitsSystemWindows() && !v.getFitsSystemWindows()) {
            v.setFitsSystemWindows(true);
        }
        if (this.H == null) {
            this.g = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            if (Build.VERSION.SDK_INT >= 29 && !this.l && !this.f) {
                q.c.c(v, new i0.h.a.c.q.k(new i0.h.a.c.g.b(this), new n(v.getPaddingStart(), v.getPaddingTop(), v.getPaddingEnd(), v.getPaddingBottom())));
                if (v.isAttachedToWindow()) {
                    v.requestApplyInsets();
                } else {
                    v.addOnAttachStateChangeListener(new l());
                }
            }
            this.H = new WeakReference<>(v);
            if (this.i && (gVar = this.j) != null) {
                v.setBackground(gVar);
            }
            g gVar2 = this.j;
            if (gVar2 != null) {
                float f = this.v;
                if (f == -1.0f) {
                    f = v.getElevation();
                }
                gVar2.s(f);
                boolean z = this.z == 3;
                this.n = z;
                this.j.u(z ? 0.0f : 1.0f);
            }
            T();
            if (v.getImportantForAccessibility() == 0) {
                v.setImportantForAccessibility(1);
            }
        }
        if (this.A == null) {
            this.A = new e(coordinatorLayout.getContext(), coordinatorLayout, this.Q);
        }
        int top = v.getTop();
        coordinatorLayout.s(v, i);
        this.F = coordinatorLayout.getWidth();
        this.G = coordinatorLayout.getHeight();
        int height = v.getHeight();
        this.E = height;
        this.r = Math.max(0, this.G - height);
        this.s = (int) ((1.0f - this.t) * ((float) this.G));
        C();
        int i2 = this.z;
        if (i2 == 3) {
            v.offsetTopAndBottom(I());
        } else if (i2 == 6) {
            v.offsetTopAndBottom(this.s);
        } else if (this.w && i2 == 5) {
            v.offsetTopAndBottom(this.G);
        } else if (i2 == 4) {
            v.offsetTopAndBottom(this.u);
        } else if (i2 == 1 || i2 == 2) {
            v.offsetTopAndBottom(top - v.getTop());
        }
        this.I = new WeakReference<>(G(v));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean n(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        WeakReference<View> weakReference = this.I;
        if (weakReference == null || view != weakReference.get() || this.z == 3) {
            return false;
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void p(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
        if (i3 != 1) {
            WeakReference<View> weakReference = this.I;
            if (view == (weakReference != null ? weakReference.get() : null)) {
                int top = v.getTop();
                int i4 = top - i2;
                if (i2 > 0) {
                    if (i4 < I()) {
                        iArr[1] = top - I();
                        AtomicInteger atomicInteger = q.a;
                        v.offsetTopAndBottom(-iArr[1]);
                        O(3);
                    } else if (this.y) {
                        iArr[1] = i2;
                        AtomicInteger atomicInteger2 = q.a;
                        v.offsetTopAndBottom(-i2);
                        O(1);
                    } else {
                        return;
                    }
                } else if (i2 < 0 && !view.canScrollVertically(-1)) {
                    int i5 = this.u;
                    if (i4 > i5 && !this.w) {
                        iArr[1] = top - i5;
                        AtomicInteger atomicInteger3 = q.a;
                        v.offsetTopAndBottom(-iArr[1]);
                        O(4);
                    } else if (this.y) {
                        iArr[1] = i2;
                        AtomicInteger atomicInteger4 = q.a;
                        v.offsetTopAndBottom(-i2);
                        O(1);
                    } else {
                        return;
                    }
                }
                F(v.getTop());
                this.C = i2;
                this.D = true;
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void r(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void u(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        int i = this.b;
        if (i != 0) {
            if (i == -1 || (i & 1) == 1) {
                this.e = savedState.x;
            }
            if (i == -1 || (i & 2) == 2) {
                this.c = savedState.y;
            }
            if (i == -1 || (i & 4) == 4) {
                this.w = savedState.Y1;
            }
            if (i == -1 || (i & 8) == 8) {
                this.x = savedState.Z1;
            }
        }
        int i2 = savedState.q;
        if (i2 == 1 || i2 == 2) {
            this.z = 4;
        } else {
            this.z = i2;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable v(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState((Parcelable) View.BaseSavedState.EMPTY_STATE, (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean x(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        this.C = 0;
        this.D = false;
        if ((i & 2) != 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void z(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
        int i2;
        float f;
        int i3 = 3;
        if (v.getTop() == I()) {
            O(3);
            return;
        }
        WeakReference<View> weakReference = this.I;
        if (weakReference != null && view == weakReference.get() && this.D) {
            if (this.C > 0) {
                if (this.c) {
                    i2 = this.r;
                } else {
                    int top = v.getTop();
                    int i4 = this.s;
                    if (top > i4) {
                        i2 = i4;
                        i3 = 6;
                    } else {
                        i2 = this.q;
                    }
                }
                S(v, i3, i2, false);
                this.D = false;
            }
            if (this.w) {
                VelocityTracker velocityTracker = this.K;
                if (velocityTracker == null) {
                    f = 0.0f;
                } else {
                    velocityTracker.computeCurrentVelocity(1000, this.d);
                    f = this.K.getYVelocity(this.L);
                }
                if (R(v, f)) {
                    i2 = this.G;
                    i3 = 5;
                    S(v, i3, i2, false);
                    this.D = false;
                }
            }
            if (this.C == 0) {
                int top2 = v.getTop();
                if (!this.c) {
                    int i5 = this.s;
                    if (top2 < i5) {
                        if (top2 < Math.abs(top2 - this.u)) {
                            i2 = this.q;
                        } else {
                            i2 = this.s;
                        }
                    } else if (Math.abs(top2 - i5) < Math.abs(top2 - this.u)) {
                        i2 = this.s;
                    } else {
                        i2 = this.u;
                        i3 = 4;
                    }
                    i3 = 6;
                } else if (Math.abs(top2 - this.r) < Math.abs(top2 - this.u)) {
                    i2 = this.r;
                } else {
                    i2 = this.u;
                    i3 = 4;
                }
            } else {
                if (this.c) {
                    i2 = this.u;
                } else {
                    int top3 = v.getTop();
                    if (Math.abs(top3 - this.s) < Math.abs(top3 - this.u)) {
                        i2 = this.s;
                        i3 = 6;
                    } else {
                        i2 = this.u;
                    }
                }
                i3 = 4;
            }
            S(v, i3, i2, false);
            this.D = false;
        }
    }

    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public boolean Y1;
        public boolean Z1;
        public final int q;
        public int x;
        public boolean y;

        /* loaded from: classes2.dex */
        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.q = parcel.readInt();
            this.x = parcel.readInt();
            boolean z = false;
            this.y = parcel.readInt() == 1;
            this.Y1 = parcel.readInt() == 1;
            this.Z1 = parcel.readInt() == 1 ? true : z;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.d, i);
            parcel.writeInt(this.q);
            parcel.writeInt(this.x);
            parcel.writeInt(this.y ? 1 : 0);
            parcel.writeInt(this.Y1 ? 1 : 0);
            parcel.writeInt(this.Z1 ? 1 : 0);
        }

        public SavedState(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.q = bottomSheetBehavior.z;
            this.x = bottomSheetBehavior.e;
            this.y = bottomSheetBehavior.c;
            this.Y1 = bottomSheetBehavior.w;
            this.Z1 = bottomSheetBehavior.x;
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i;
        this.b = 0;
        this.c = true;
        this.o = null;
        this.t = 0.5f;
        this.v = -1.0f;
        this.y = true;
        this.z = 4;
        this.J = new ArrayList<>();
        this.P = -1;
        this.Q = new b();
        this.h = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        this.i = obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance);
        int i2 = R.styleable.BottomSheetBehavior_Layout_backgroundTint;
        boolean hasValue = obtainStyledAttributes.hasValue(i2);
        if (hasValue) {
            E(context, attributeSet, hasValue, i0.h.a.b.c.m.b.M(context, obtainStyledAttributes, i2));
        } else {
            E(context, attributeSet, hasValue, null);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.p = ofFloat;
        ofFloat.setDuration(500L);
        this.p.addUpdateListener(new i0.h.a.c.g.a(this));
        this.v = obtainStyledAttributes.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        int i3 = R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i3);
        if (peekValue == null || (i = peekValue.data) != -1) {
            M(obtainStyledAttributes.getDimensionPixelSize(i3, -1));
        } else {
            M(i);
        }
        L(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        this.l = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false);
        K(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        this.x = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false);
        this.y = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true);
        this.b = obtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0);
        float f = obtainStyledAttributes.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f);
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.t = f;
        if (this.H != null) {
            this.s = (int) ((1.0f - f) * ((float) this.G));
        }
        int i4 = R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(i4);
        if (peekValue2 == null || peekValue2.type != 16) {
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(i4, 0);
            if (dimensionPixelOffset >= 0) {
                this.q = dimensionPixelOffset;
            } else {
                throw new IllegalArgumentException("offset must be greater than or equal to 0");
            }
        } else {
            int i5 = peekValue2.data;
            if (i5 >= 0) {
                this.q = i5;
            } else {
                throw new IllegalArgumentException("offset must be greater than or equal to 0");
            }
        }
        obtainStyledAttributes.recycle();
        this.d = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
