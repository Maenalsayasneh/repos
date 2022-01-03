package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import h0.i.i.q;
import i0.h.a.b.c.m.b;
import i0.h.a.c.e.a;
import i0.h.a.c.e.c;
import i0.h.a.c.e.d;
import i0.h.a.c.e.f;
import i0.h.a.c.e.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.b {
    public static final /* synthetic */ int I2 = 0;
    public Animator J2;
    public Animator K2;
    public int L2;
    public int M2;
    public boolean N2;
    public int O2;
    public int P2;
    public boolean Q2;
    public Behavior R2;

    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int q;
        public boolean x;

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
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.d, i);
            parcel.writeInt(this.q);
            parcel.writeInt(this.x ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.q = parcel.readInt();
            this.x = parcel.readInt() != 0;
        }
    }

    private ActionMenuView getActionMenuView() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return 0;
    }

    private float getFabTranslationX() {
        return D(this.L2);
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return 0;
    }

    private g getTopEdgeTreatment() {
        throw null;
    }

    public static void w(BottomAppBar bottomAppBar) {
        bottomAppBar.O2--;
    }

    public final FloatingActionButton A() {
        View B = B();
        if (B instanceof FloatingActionButton) {
            return (FloatingActionButton) B;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final View B() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).g(this)) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
            while (r0.hasNext()) {
            }
        }
        return null;
    }

    public int C(ActionMenuView actionMenuView, int i, boolean z) {
        if (i != 1 || !z) {
            return 0;
        }
        boolean X = b.X(this);
        int measuredWidth = X ? getMeasuredWidth() : 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if ((childAt.getLayoutParams() instanceof Toolbar.e) && (((Toolbar.e) childAt.getLayoutParams()).a & 8388615) == 8388611) {
                if (X) {
                    measuredWidth = Math.min(measuredWidth, childAt.getLeft());
                } else {
                    measuredWidth = Math.max(measuredWidth, childAt.getRight());
                }
            }
        }
        return measuredWidth - ((X ? actionMenuView.getRight() : actionMenuView.getLeft()) + 0);
    }

    public final float D(int i) {
        boolean X = b.X(this);
        int i2 = 1;
        if (i != 1) {
            return 0.0f;
        }
        int measuredWidth = (getMeasuredWidth() / 2) + 0;
        if (X) {
            i2 = -1;
        }
        return (float) (measuredWidth * i2);
    }

    public final boolean E() {
        FloatingActionButton A = A();
        return A != null && A.k();
    }

    public final void F() {
        getTopEdgeTreatment().y = getFabTranslationX();
        B();
        if (this.Q2) {
            E();
        }
        throw null;
    }

    public boolean G(int i) {
        float f = (float) i;
        if (f == getTopEdgeTreatment().q) {
            return false;
        }
        getTopEdgeTreatment().q = f;
        throw null;
    }

    public ColorStateList getBackgroundTint() {
        throw null;
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().x;
    }

    public int getFabAlignmentMode() {
        return this.L2;
    }

    public int getFabAnimationMode() {
        return this.M2;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().d;
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().c;
    }

    public boolean getHideOnScroll() {
        return this.N2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        b.m0(this, null);
        throw null;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            Animator animator = this.K2;
            if (animator != null) {
                animator.cancel();
            }
            Animator animator2 = this.J2;
            if (animator2 != null) {
                animator2.cancel();
            }
            F();
            throw null;
        }
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null && this.K2 == null) {
            actionMenuView.setAlpha(1.0f);
            if (!E()) {
                actionMenuView.setTranslationX((float) C(actionMenuView, 0, false));
            } else {
                actionMenuView.setTranslationX((float) C(actionMenuView, this.L2, this.Q2));
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.d);
        this.L2 = savedState.q;
        this.Q2 = savedState.x;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.q = this.L2;
        savedState.x = this.Q2;
        return savedState;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        throw null;
    }

    public void setCradleVerticalOffset(float f) {
        if (f != getCradleVerticalOffset()) {
            g topEdgeTreatment = getTopEdgeTreatment();
            Objects.requireNonNull(topEdgeTreatment);
            if (f >= 0.0f) {
                topEdgeTreatment.x = f;
                throw null;
            }
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        throw null;
    }

    public void setFabAlignmentMode(int i) {
        int i2;
        this.P2 = 0;
        boolean z = this.Q2;
        AtomicInteger atomicInteger = q.a;
        if (!isLaidOut()) {
            int i3 = this.P2;
            if (i3 != 0) {
                this.P2 = 0;
                getMenu().clear();
                n(i3);
            }
        } else {
            Animator animator = this.K2;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!E()) {
                z = false;
                i2 = 0;
            } else {
                i2 = i;
            }
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
                if (Math.abs(actionMenuView.getTranslationX() - ((float) C(actionMenuView, i2, z))) > 1.0f) {
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
                    ofFloat2.addListener(new d(this, actionMenuView, i2, z));
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.setDuration(150L);
                    animatorSet.playSequentially(ofFloat2, ofFloat);
                    arrayList.add(animatorSet);
                } else if (actionMenuView.getAlpha() < 1.0f) {
                    arrayList.add(ofFloat);
                }
            }
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(arrayList);
            this.K2 = animatorSet2;
            animatorSet2.addListener(new c(this));
            this.K2.start();
        }
        if (this.L2 != i && isLaidOut()) {
            Animator animator2 = this.J2;
            if (animator2 != null) {
                animator2.cancel();
            }
            ArrayList arrayList2 = new ArrayList();
            if (this.M2 == 1) {
                ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(A(), "translationX", D(i));
                ofFloat3.setDuration(300L);
                arrayList2.add(ofFloat3);
            } else {
                FloatingActionButton A = A();
                if (A != null && !A.j()) {
                    this.O2++;
                    A.i(new i0.h.a.c.e.b(this, i), true);
                }
            }
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.playTogether(arrayList2);
            this.J2 = animatorSet3;
            animatorSet3.addListener(new a(this));
            this.J2.start();
        }
        this.L2 = i;
    }

    public void setFabAnimationMode(int i) {
        this.M2 = i;
    }

    public void setFabCradleMargin(float f) {
        if (f != getFabCradleMargin()) {
            getTopEdgeTreatment().d = f;
            throw null;
        }
    }

    public void setFabCradleRoundedCornerRadius(float f) {
        if (f != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().c = f;
            throw null;
        }
    }

    public void setHideOnScroll(boolean z) {
        this.N2 = z;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public Behavior getBehavior() {
        if (this.R2 == null) {
            this.R2 = new Behavior();
        }
        return this.R2;
    }

    /* loaded from: classes2.dex */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        public WeakReference<BottomAppBar> f;
        public int g;
        public final View.OnLayoutChangeListener h = new a();
        public final Rect e = new Rect();

        /* loaded from: classes2.dex */
        public class a implements View.OnLayoutChangeListener {
            public a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                BottomAppBar bottomAppBar = Behavior.this.f.get();
                if (bottomAppBar == null || !(view instanceof FloatingActionButton)) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                Rect rect = Behavior.this.e;
                rect.set(0, 0, floatingActionButton.getMeasuredWidth(), floatingActionButton.getMeasuredHeight());
                floatingActionButton.l(rect);
                int height = Behavior.this.e.height();
                bottomAppBar.G(height);
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) view.getLayoutParams();
                if (Behavior.this.g == 0) {
                    ((ViewGroup.MarginLayoutParams) fVar).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fab_bottom_margin) - ((floatingActionButton.getMeasuredHeight() - height) / 2));
                    ((ViewGroup.MarginLayoutParams) fVar).leftMargin = bottomAppBar.getLeftInset();
                    ((ViewGroup.MarginLayoutParams) fVar).rightMargin = bottomAppBar.getRightInset();
                    if (b.X(floatingActionButton)) {
                        ((ViewGroup.MarginLayoutParams) fVar).leftMargin += 0;
                    } else {
                        ((ViewGroup.MarginLayoutParams) fVar).rightMargin += 0;
                    }
                }
            }
        }

        public Behavior() {
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean k(CoordinatorLayout coordinatorLayout, View view, int i) {
            BottomAppBar bottomAppBar = (BottomAppBar) view;
            this.f = new WeakReference<>(bottomAppBar);
            int i2 = BottomAppBar.I2;
            View B = bottomAppBar.B();
            if (B != null) {
                AtomicInteger atomicInteger = q.a;
                if (!B.isLaidOut()) {
                    CoordinatorLayout.f fVar = (CoordinatorLayout.f) B.getLayoutParams();
                    fVar.d = 49;
                    this.g = ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
                    if (B instanceof FloatingActionButton) {
                        FloatingActionButton floatingActionButton = (FloatingActionButton) B;
                        floatingActionButton.addOnLayoutChangeListener(this.h);
                        floatingActionButton.d(null);
                        floatingActionButton.e(new f(bottomAppBar));
                        floatingActionButton.f(null);
                    }
                    bottomAppBar.F();
                    throw null;
                }
            }
            coordinatorLayout.s(bottomAppBar, i);
            this.a = bottomAppBar.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) bottomAppBar.getLayoutParams()).bottomMargin;
            return false;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean x(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            if (((BottomAppBar) view).getHideOnScroll()) {
                if (i == 2) {
                    return true;
                }
            }
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }
}
