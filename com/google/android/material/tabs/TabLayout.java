package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import h0.i.i.g0.b;
import h0.i.i.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
@ViewPager.e
/* loaded from: classes2.dex */
public class TabLayout extends HorizontalScrollView {
    public static final int c = R.style.Widget_Design_TabLayout;
    public static final h0.i.h.d<g> d = new h0.i.h.e(16);
    public c A2;
    public c C2;
    public ValueAnimator D2;
    public ViewPager E2;
    public h0.f0.a.a F2;
    public DataSetObserver G2;
    public h H2;
    public b I2;
    public boolean J2;
    public int Y1;
    public int Z1;
    public int a2;
    public int b2;
    public int c2;
    public ColorStateList d2;
    public ColorStateList e2;
    public ColorStateList f2;
    public PorterDuff.Mode i2;
    public float j2;
    public float k2;
    public final int l2;
    public final int n2;
    public final int o2;
    public final int p2;
    public int q2;
    public int r2;
    public int s2;
    public int t2;
    public int u2;
    public boolean v2;
    public boolean w2;
    public g x;
    public int x2;
    public final f y;
    public boolean y2;
    public i0.h.a.c.y.b z2;
    public final ArrayList<g> q = new ArrayList<>();
    public Drawable g2 = new GradientDrawable();
    public int h2 = 0;
    public int m2 = Integer.MAX_VALUE;
    public final ArrayList<c> B2 = new ArrayList<>();
    public final h0.i.h.d<i> K2 = new h0.i.h.d<>(12);

    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements ViewPager.i {
        public boolean a;

        public b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(ViewPager viewPager, h0.f0.a.a aVar, h0.f0.a.a aVar2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.E2 == viewPager) {
                tabLayout.m(aVar2, this.a);
            }
        }
    }

    @Deprecated
    /* loaded from: classes2.dex */
    public interface c<T extends g> {
        void a(T t);

        void b(T t);

        void c(T t);
    }

    /* loaded from: classes2.dex */
    public interface d extends c<g> {
    }

    /* loaded from: classes2.dex */
    public class e extends DataSetObserver {
        public e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.j();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.j();
        }
    }

    /* loaded from: classes2.dex */
    public class f extends LinearLayout {
        public ValueAnimator c;
        public float q;
        public int d = -1;
        public int x = -1;

        /* loaded from: classes2.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {
            public final /* synthetic */ View a;
            public final /* synthetic */ View b;

            public a(View view, View view2) {
                this.a = view;
                this.b = view2;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.c(this.a, this.b, valueAnimator.getAnimatedFraction());
            }
        }

        /* loaded from: classes2.dex */
        public class b extends AnimatorListenerAdapter {
            public final /* synthetic */ int a;

            public b(int i) {
                this.a = i;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.d = this.a;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                f.this.d = this.a;
            }
        }

        public f(Context context) {
            super(context);
            setWillNotDraw(false);
        }

        public final void a() {
            View childAt = getChildAt(this.d);
            TabLayout tabLayout = TabLayout.this;
            i0.h.a.c.y.b bVar = tabLayout.z2;
            Drawable drawable = tabLayout.g2;
            Objects.requireNonNull(bVar);
            RectF a2 = i0.h.a.c.y.b.a(tabLayout, childAt);
            drawable.setBounds((int) a2.left, drawable.getBounds().top, (int) a2.right, drawable.getBounds().bottom);
        }

        public void b(int i) {
            Rect bounds = TabLayout.this.g2.getBounds();
            TabLayout.this.g2.setBounds(bounds.left, 0, bounds.right, i);
            requestLayout();
        }

        public final void c(View view, View view2, float f) {
            if (view != null && view.getWidth() > 0) {
                TabLayout tabLayout = TabLayout.this;
                tabLayout.z2.b(tabLayout, view, view2, f, tabLayout.g2);
            } else {
                Drawable drawable = TabLayout.this.g2;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.g2.getBounds().bottom);
            }
            AtomicInteger atomicInteger = q.a;
            postInvalidateOnAnimation();
        }

        public final void d(boolean z, int i, int i2) {
            View childAt = getChildAt(this.d);
            View childAt2 = getChildAt(i);
            if (childAt2 == null) {
                a();
                return;
            }
            a aVar = new a(childAt, childAt2);
            if (z) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.c = valueAnimator;
                valueAnimator.setInterpolator(i0.h.a.c.a.a.b);
                valueAnimator.setDuration((long) i2);
                valueAnimator.setFloatValues(0.0f, 1.0f);
                valueAnimator.addUpdateListener(aVar);
                valueAnimator.addListener(new b(i));
                valueAnimator.start();
                return;
            }
            this.c.removeAllUpdateListeners();
            this.c.addUpdateListener(aVar);
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            int height = TabLayout.this.g2.getBounds().height();
            if (height < 0) {
                height = TabLayout.this.g2.getIntrinsicHeight();
            }
            int i = TabLayout.this.t2;
            int i2 = 0;
            if (i == 0) {
                i2 = getHeight() - height;
                height = getHeight();
            } else if (i == 1) {
                i2 = (getHeight() - height) / 2;
                height = (getHeight() + height) / 2;
            } else if (i != 2) {
                if (i != 3) {
                    height = 0;
                } else {
                    height = getHeight();
                }
            }
            if (TabLayout.this.g2.getBounds().width() > 0) {
                Rect bounds = TabLayout.this.g2.getBounds();
                TabLayout.this.g2.setBounds(bounds.left, i2, bounds.right, height);
                TabLayout tabLayout = TabLayout.this;
                Drawable drawable = tabLayout.g2;
                int i3 = tabLayout.h2;
                if (i3 != 0) {
                    drawable.setTint(i3);
                }
                drawable.draw(canvas);
            }
            super.draw(canvas);
        }

        @Override // android.widget.LinearLayout, android.view.View, android.view.ViewGroup
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            ValueAnimator valueAnimator = this.c;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                a();
            } else {
                d(false, this.d, -1);
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) == 1073741824) {
                TabLayout tabLayout = TabLayout.this;
                boolean z = true;
                if (tabLayout.r2 == 1 || tabLayout.u2 == 2) {
                    int childCount = getChildCount();
                    int i3 = 0;
                    for (int i4 = 0; i4 < childCount; i4++) {
                        View childAt = getChildAt(i4);
                        if (childAt.getVisibility() == 0) {
                            i3 = Math.max(i3, childAt.getMeasuredWidth());
                        }
                    }
                    if (i3 > 0) {
                        if (i3 * childCount <= getMeasuredWidth() - (((int) i0.h.a.b.c.m.b.E(getContext(), 16)) * 2)) {
                            boolean z2 = false;
                            for (int i5 = 0; i5 < childCount; i5++) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i5).getLayoutParams();
                                if (layoutParams.width != i3 || layoutParams.weight != 0.0f) {
                                    layoutParams.width = i3;
                                    layoutParams.weight = 0.0f;
                                    z2 = true;
                                }
                            }
                            z = z2;
                        } else {
                            TabLayout tabLayout2 = TabLayout.this;
                            tabLayout2.r2 = 0;
                            tabLayout2.r(false);
                        }
                        if (z) {
                            super.onMeasure(i, i2);
                        }
                    }
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
        }
    }

    /* loaded from: classes2.dex */
    public static class g {
        public Drawable a;
        public CharSequence b;
        public CharSequence c;
        public View e;
        public TabLayout f;
        public i g;
        public int d = -1;
        public int h = -1;

        public g a(int i) {
            TabLayout tabLayout = this.f;
            if (tabLayout != null) {
                b(tabLayout.getResources().getText(i));
                return this;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public g b(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(charSequence)) {
                this.g.setContentDescription(charSequence);
            }
            this.b = charSequence;
            c();
            return this;
        }

        public void c() {
            i iVar = this.g;
            if (iVar != null) {
                iVar.h();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class h implements ViewPager.j {
        public final WeakReference<TabLayout> c;
        public int d;
        public int q;

        public h(TabLayout tabLayout) {
            this.c = new WeakReference<>(tabLayout);
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrollStateChanged(int i) {
            this.d = this.q;
            this.q = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrolled(int i, float f, int i2) {
            TabLayout tabLayout = this.c.get();
            if (tabLayout != null) {
                int i3 = this.q;
                boolean z = false;
                boolean z2 = i3 != 2 || this.d == 1;
                if (!(i3 == 2 && this.d == 0)) {
                    z = true;
                }
                tabLayout.n(i, f, z2, z);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageSelected(int i) {
            TabLayout tabLayout = this.c.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i && i < tabLayout.getTabCount()) {
                int i2 = this.q;
                tabLayout.l(tabLayout.h(i), i2 == 0 || (i2 == 2 && this.d == 0));
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class i extends LinearLayout {
        public static final /* synthetic */ int c = 0;
        public BadgeDrawable Y1;
        public View Z1;
        public TextView a2;
        public ImageView b2;
        public Drawable c2;
        public g d;
        public int d2 = 2;
        public TextView q;
        public ImageView x;
        public View y;

        public i(Context context) {
            super(context);
            i(context);
            int i = TabLayout.this.Y1;
            int i2 = TabLayout.this.Z1;
            int i3 = TabLayout.this.a2;
            int i4 = TabLayout.this.b2;
            AtomicInteger atomicInteger = q.a;
            setPaddingRelative(i, i2, i3, i4);
            setGravity(17);
            setOrientation(!TabLayout.this.v2 ? 1 : 0);
            setClickable(true);
            setPointerIcon(PointerIcon.getSystemIcon(getContext(), 1002));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public BadgeDrawable getBadge() {
            return this.Y1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public BadgeDrawable getOrCreateBadge() {
            if (this.Y1 == null) {
                this.Y1 = BadgeDrawable.b(getContext());
            }
            f();
            BadgeDrawable badgeDrawable = this.Y1;
            if (badgeDrawable != null) {
                return badgeDrawable;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        public final boolean c() {
            return this.Y1 != null;
        }

        public final void d(View view) {
            if (c() && view != null) {
                setClipChildren(false);
                setClipToPadding(false);
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup != null) {
                    viewGroup.setClipChildren(false);
                    viewGroup.setClipToPadding(false);
                }
                i0.h.a.c.c.a.a(this.Y1, view, null);
                this.y = view;
            }
        }

        @Override // android.view.View, android.view.ViewGroup
        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.c2;
            boolean z = false;
            if (drawable != null && drawable.isStateful()) {
                z = false | this.c2.setState(drawableState);
            }
            if (z) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        public final void e() {
            if (c()) {
                setClipChildren(true);
                setClipToPadding(true);
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup != null) {
                    viewGroup.setClipChildren(true);
                    viewGroup.setClipToPadding(true);
                }
                View view = this.y;
                if (view != null) {
                    i0.h.a.c.c.a.b(this.Y1, view);
                    this.y = null;
                }
            }
        }

        public final void f() {
            g gVar;
            g gVar2;
            if (c()) {
                if (this.Z1 != null) {
                    e();
                    return;
                }
                ImageView imageView = this.x;
                if (imageView == null || (gVar2 = this.d) == null || gVar2.a == null) {
                    if (this.q == null || (gVar = this.d) == null) {
                        e();
                        return;
                    }
                    Objects.requireNonNull(gVar);
                    View view = this.y;
                    TextView textView = this.q;
                    if (view != textView) {
                        e();
                        d(this.q);
                        return;
                    }
                    g(textView);
                } else if (this.y != imageView) {
                    e();
                    d(this.x);
                } else {
                    g(imageView);
                }
            }
        }

        public final void g(View view) {
            if (c() && view == this.y) {
                BadgeDrawable badgeDrawable = this.Y1;
                Rect rect = new Rect();
                view.getDrawingRect(rect);
                badgeDrawable.setBounds(rect);
                badgeDrawable.m(view, null);
            }
        }

        public int getContentHeight() {
            View[] viewArr = {this.q, this.x, this.Z1};
            int i = 0;
            int i2 = 0;
            boolean z = false;
            for (int i3 = 0; i3 < 3; i3++) {
                View view = viewArr[i3];
                if (view != null && view.getVisibility() == 0) {
                    i2 = z ? Math.min(i2, view.getTop()) : view.getTop();
                    i = z ? Math.max(i, view.getBottom()) : view.getBottom();
                    z = true;
                }
            }
            return i - i2;
        }

        public int getContentWidth() {
            View[] viewArr = {this.q, this.x, this.Z1};
            int i = 0;
            int i2 = 0;
            boolean z = false;
            for (int i3 = 0; i3 < 3; i3++) {
                View view = viewArr[i3];
                if (view != null && view.getVisibility() == 0) {
                    i2 = z ? Math.min(i2, view.getLeft()) : view.getLeft();
                    i = z ? Math.max(i, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return i - i2;
        }

        public g getTab() {
            return this.d;
        }

        public final void h() {
            Drawable drawable;
            g gVar = this.d;
            Drawable drawable2 = null;
            View view = gVar != null ? gVar.e : null;
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(view);
                    }
                    addView(view);
                }
                this.Z1 = view;
                TextView textView = this.q;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.x;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.x.setImageDrawable(null);
                }
                TextView textView2 = (TextView) view.findViewById(16908308);
                this.a2 = textView2;
                if (textView2 != null) {
                    this.d2 = textView2.getMaxLines();
                }
                this.b2 = (ImageView) view.findViewById(16908294);
            } else {
                View view2 = this.Z1;
                if (view2 != null) {
                    removeView(view2);
                    this.Z1 = null;
                }
                this.a2 = null;
                this.b2 = null;
            }
            boolean z = false;
            if (this.Z1 == null) {
                if (this.x == null) {
                    ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, (ViewGroup) this, false);
                    this.x = imageView2;
                    addView(imageView2, 0);
                }
                if (!(gVar == null || (drawable = gVar.a) == null)) {
                    drawable2 = drawable.mutate();
                }
                if (drawable2 != null) {
                    drawable2.setTintList(TabLayout.this.e2);
                    PorterDuff.Mode mode = TabLayout.this.i2;
                    if (mode != null) {
                        drawable2.setTintMode(mode);
                    }
                }
                if (this.q == null) {
                    TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, (ViewGroup) this, false);
                    this.q = textView3;
                    addView(textView3);
                    this.d2 = this.q.getMaxLines();
                }
                this.q.setTextAppearance(TabLayout.this.c2);
                ColorStateList colorStateList = TabLayout.this.d2;
                if (colorStateList != null) {
                    this.q.setTextColor(colorStateList);
                }
                j(this.q, this.x);
                f();
                ImageView imageView3 = this.x;
                if (imageView3 != null) {
                    imageView3.addOnLayoutChangeListener(new i0.h.a.c.y.d(this, imageView3));
                }
                TextView textView4 = this.q;
                if (textView4 != null) {
                    textView4.addOnLayoutChangeListener(new i0.h.a.c.y.d(this, textView4));
                }
            } else {
                TextView textView5 = this.a2;
                if (!(textView5 == null && this.b2 == null)) {
                    j(textView5, this.b2);
                }
            }
            if (gVar != null && !TextUtils.isEmpty(gVar.c)) {
                setContentDescription(gVar.c);
            }
            if (gVar != null) {
                TabLayout tabLayout = gVar.f;
                if (tabLayout != null) {
                    if (tabLayout.getSelectedTabPosition() == gVar.d) {
                        z = true;
                    }
                } else {
                    throw new IllegalArgumentException("Tab not attached to a TabLayout");
                }
            }
            setSelected(z);
        }

        public final void i(Context context) {
            int i = TabLayout.this.l2;
            GradientDrawable gradientDrawable = null;
            if (i != 0) {
                Drawable a = h0.b.b.a.a.a(context, i);
                this.c2 = a;
                if (a != null && a.isStateful()) {
                    this.c2.setState(getDrawableState());
                }
            } else {
                this.c2 = null;
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setColor(0);
            RippleDrawable rippleDrawable = gradientDrawable2;
            if (TabLayout.this.f2 != null) {
                GradientDrawable gradientDrawable3 = new GradientDrawable();
                gradientDrawable3.setCornerRadius(1.0E-5f);
                gradientDrawable3.setColor(-1);
                ColorStateList colorStateList = TabLayout.this.f2;
                ColorStateList colorStateList2 = new ColorStateList(new int[][]{i0.h.a.c.u.a.i, StateSet.NOTHING}, new int[]{i0.h.a.c.u.a.a(colorStateList, i0.h.a.c.u.a.e), i0.h.a.c.u.a.a(colorStateList, i0.h.a.c.u.a.a)});
                boolean z = TabLayout.this.y2;
                GradientDrawable gradientDrawable4 = gradientDrawable2;
                if (z) {
                    gradientDrawable4 = null;
                }
                if (!z) {
                    gradientDrawable = gradientDrawable3;
                }
                rippleDrawable = new RippleDrawable(colorStateList2, gradientDrawable4, gradientDrawable);
            }
            AtomicInteger atomicInteger = q.a;
            setBackground(rippleDrawable);
            TabLayout.this.invalidate();
        }

        public final void j(TextView textView, ImageView imageView) {
            Drawable drawable;
            g gVar = this.d;
            CharSequence charSequence = null;
            Drawable mutate = (gVar == null || (drawable = gVar.a) == null) ? null : drawable.mutate();
            g gVar2 = this.d;
            CharSequence charSequence2 = gVar2 != null ? gVar2.b : null;
            if (imageView != null) {
                if (mutate != null) {
                    imageView.setImageDrawable(mutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(charSequence2);
            if (textView != null) {
                if (z) {
                    textView.setText(charSequence2);
                    Objects.requireNonNull(this.d);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int E = (!z || imageView.getVisibility() != 0) ? 0 : (int) i0.h.a.b.c.m.b.E(getContext(), 8);
                if (TabLayout.this.v2) {
                    if (E != marginLayoutParams.getMarginEnd()) {
                        marginLayoutParams.setMarginEnd(E);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (E != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = E;
                    marginLayoutParams.setMarginEnd(0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            g gVar3 = this.d;
            if (gVar3 != null) {
                charSequence = gVar3.c;
            }
            if (!z) {
                charSequence2 = charSequence;
            }
            g0.a.b.b.a.y0(this, charSequence2);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            BadgeDrawable badgeDrawable = this.Y1;
            if (badgeDrawable != null && badgeDrawable.isVisible()) {
                CharSequence contentDescription = getContentDescription();
                accessibilityNodeInfo.setContentDescription(((Object) contentDescription) + ", " + ((Object) this.Y1.f()));
            }
            accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) b.c.a(0, 1, this.d.d, 1, false, isSelected()).a);
            if (isSelected()) {
                accessibilityNodeInfo.setClickable(false);
                accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) b.a.a.i);
            }
            accessibilityNodeInfo.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", getResources().getString(R.string.item_view_role_description));
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x0093, code lost:
            if (((r0 / r2.getPaint().getTextSize()) * r2.getLineWidth(0)) > ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()))) goto L_0x0095;
         */
        @Override // android.widget.LinearLayout, android.view.View
        /* Code decompiled incorrectly, please refer to instructions dump */
        public void onMeasure(int i, int i2) {
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = View.MeasureSpec.makeMeasureSpec(TabLayout.this.m2, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.q != null) {
                float f = TabLayout.this.j2;
                int i3 = this.d2;
                ImageView imageView = this.x;
                boolean z = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.q;
                    if (textView != null && textView.getLineCount() > 1) {
                        f = TabLayout.this.k2;
                    }
                } else {
                    i3 = 1;
                }
                float textSize = this.q.getTextSize();
                int lineCount = this.q.getLineCount();
                int maxLines = this.q.getMaxLines();
                int i4 = (f > textSize ? 1 : (f == textSize ? 0 : -1));
                if (i4 != 0 || (maxLines >= 0 && i3 != maxLines)) {
                    if (TabLayout.this.u2 == 1 && i4 > 0 && lineCount == 1) {
                        Layout layout = this.q.getLayout();
                        if (layout != null) {
                        }
                        z = false;
                    }
                    if (z) {
                        this.q.setTextSize(0, f);
                        this.q.setMaxLines(i3);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.d == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            g gVar = this.d;
            TabLayout tabLayout = gVar.f;
            if (tabLayout != null) {
                tabLayout.l(gVar, true);
                return true;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            if (isSelected() != z) {
            }
            super.setSelected(z);
            TextView textView = this.q;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.x;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.Z1;
            if (view != null) {
                view.setSelected(z);
            }
        }

        public void setTab(g gVar) {
            if (gVar != this.d) {
                this.d = gVar;
                h();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class j implements d {
        public final ViewPager a;

        public j(ViewPager viewPager) {
            this.a = viewPager;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(g gVar) {
            this.a.setCurrentItem(gVar.d);
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(g gVar) {
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public TabLayout(Context context, AttributeSet attributeSet) {
        super(i0.h.a.c.a0.a.a.a(context, attributeSet, r3, r4), attributeSet, r3);
        int i2 = R.attr.tabStyle;
        int i3 = c;
        Context context2 = getContext();
        setHorizontalScrollBarEnabled(false);
        f fVar = new f(context2);
        this.y = fVar;
        super.addView(fVar, 0, new FrameLayout.LayoutParams(-2, -1));
        int[] iArr = R.styleable.TabLayout;
        int i4 = R.styleable.TabLayout_tabTextAppearance;
        TypedArray d2 = i0.h.a.c.q.j.d(context2, attributeSet, iArr, i2, i3, i4);
        if (getBackground() instanceof ColorDrawable) {
            i0.h.a.c.w.g gVar = new i0.h.a.c.w.g();
            gVar.t(ColorStateList.valueOf(((ColorDrawable) getBackground()).getColor()));
            gVar.q.b = new i0.h.a.c.n.a(context2);
            gVar.B();
            AtomicInteger atomicInteger = q.a;
            gVar.s(getElevation());
            setBackground(gVar);
        }
        setSelectedTabIndicator(i0.h.a.b.c.m.b.P(context2, d2, R.styleable.TabLayout_tabIndicator));
        setSelectedTabIndicatorColor(d2.getColor(R.styleable.TabLayout_tabIndicatorColor, 0));
        fVar.b(d2.getDimensionPixelSize(R.styleable.TabLayout_tabIndicatorHeight, -1));
        setSelectedTabIndicatorGravity(d2.getInt(R.styleable.TabLayout_tabIndicatorGravity, 0));
        setTabIndicatorFullWidth(d2.getBoolean(R.styleable.TabLayout_tabIndicatorFullWidth, true));
        setTabIndicatorAnimationMode(d2.getInt(R.styleable.TabLayout_tabIndicatorAnimationMode, 0));
        int dimensionPixelSize = d2.getDimensionPixelSize(R.styleable.TabLayout_tabPadding, 0);
        this.b2 = dimensionPixelSize;
        this.a2 = dimensionPixelSize;
        this.Z1 = dimensionPixelSize;
        this.Y1 = dimensionPixelSize;
        this.Y1 = d2.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingStart, dimensionPixelSize);
        this.Z1 = d2.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingTop, this.Z1);
        this.a2 = d2.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingEnd, this.a2);
        this.b2 = d2.getDimensionPixelSize(R.styleable.TabLayout_tabPaddingBottom, this.b2);
        int resourceId = d2.getResourceId(i4, R.style.TextAppearance_Design_Tab);
        this.c2 = resourceId;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(resourceId, androidx.appcompat.R.styleable.TextAppearance);
        try {
            this.j2 = (float) obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);
            this.d2 = i0.h.a.b.c.m.b.M(context2, obtainStyledAttributes, androidx.appcompat.R.styleable.TextAppearance_android_textColor);
            obtainStyledAttributes.recycle();
            int i5 = R.styleable.TabLayout_tabTextColor;
            if (d2.hasValue(i5)) {
                this.d2 = i0.h.a.b.c.m.b.M(context2, d2, i5);
            }
            int i6 = R.styleable.TabLayout_tabSelectedTextColor;
            if (d2.hasValue(i6)) {
                this.d2 = new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{d2.getColor(i6, 0), this.d2.getDefaultColor()});
            }
            this.e2 = i0.h.a.b.c.m.b.M(context2, d2, R.styleable.TabLayout_tabIconTint);
            this.i2 = i0.h.a.b.c.m.b.f0(d2.getInt(R.styleable.TabLayout_tabIconTintMode, -1), null);
            this.f2 = i0.h.a.b.c.m.b.M(context2, d2, R.styleable.TabLayout_tabRippleColor);
            this.s2 = d2.getInt(R.styleable.TabLayout_tabIndicatorAnimationDuration, 300);
            this.n2 = d2.getDimensionPixelSize(R.styleable.TabLayout_tabMinWidth, -1);
            this.o2 = d2.getDimensionPixelSize(R.styleable.TabLayout_tabMaxWidth, -1);
            this.l2 = d2.getResourceId(R.styleable.TabLayout_tabBackground, 0);
            this.q2 = d2.getDimensionPixelSize(R.styleable.TabLayout_tabContentStart, 0);
            this.u2 = d2.getInt(R.styleable.TabLayout_tabMode, 1);
            this.r2 = d2.getInt(R.styleable.TabLayout_tabGravity, 0);
            this.v2 = d2.getBoolean(R.styleable.TabLayout_tabInlineLabel, false);
            this.y2 = d2.getBoolean(R.styleable.TabLayout_tabUnboundedRipple, false);
            d2.recycle();
            Resources resources = getResources();
            this.k2 = (float) resources.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
            this.p2 = resources.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
            e();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    private int getDefaultHeight() {
        int size = this.q.size();
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                g gVar = this.q.get(i2);
                if (gVar != null && gVar.a != null && !TextUtils.isEmpty(gVar.b)) {
                    z = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        return (!z || this.v2) ? 48 : 72;
    }

    private int getTabMinWidth() {
        int i2 = this.n2;
        if (i2 != -1) {
            return i2;
        }
        int i3 = this.u2;
        if (i3 == 0 || i3 == 2) {
            return this.p2;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.y.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int i2) {
        int childCount = this.y.getChildCount();
        if (i2 < childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.y.getChildAt(i3);
                boolean z = true;
                childAt.setSelected(i3 == i2);
                if (i3 != i2) {
                    z = false;
                }
                childAt.setActivated(z);
                i3++;
            }
        }
    }

    public void a(g gVar) {
        b(gVar, this.q.size(), this.q.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        c(view);
    }

    public void b(g gVar, int i2, boolean z) {
        if (gVar.f == this) {
            gVar.d = i2;
            this.q.add(i2, gVar);
            int size = this.q.size();
            while (true) {
                i2++;
                if (i2 >= size) {
                    break;
                }
                this.q.get(i2).d = i2;
            }
            i iVar = gVar.g;
            iVar.setSelected(false);
            iVar.setActivated(false);
            f fVar = this.y;
            int i3 = gVar.d;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            q(layoutParams);
            fVar.addView(iVar, i3, layoutParams);
            if (z) {
                TabLayout tabLayout = gVar.f;
                if (tabLayout != null) {
                    tabLayout.l(gVar, true);
                    return;
                }
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public final void c(View view) {
        if (view instanceof i0.h.a.c.y.c) {
            i0.h.a.c.y.c cVar = (i0.h.a.c.y.c) view;
            g i2 = i();
            Objects.requireNonNull(cVar);
            if (!TextUtils.isEmpty(cVar.getContentDescription())) {
                i2.c = cVar.getContentDescription();
                i2.c();
            }
            a(i2);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    public final void d(int i2) {
        boolean z;
        if (i2 != -1) {
            if (getWindowToken() != null) {
                AtomicInteger atomicInteger = q.a;
                if (isLaidOut()) {
                    f fVar = this.y;
                    int childCount = fVar.getChildCount();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= childCount) {
                            z = false;
                            break;
                        } else if (fVar.getChildAt(i3).getWidth() <= 0) {
                            z = true;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (!z) {
                        int scrollX = getScrollX();
                        int f2 = f(i2, 0.0f);
                        if (scrollX != f2) {
                            g();
                            this.D2.setIntValues(scrollX, f2);
                            this.D2.start();
                        }
                        f fVar2 = this.y;
                        int i4 = this.s2;
                        ValueAnimator valueAnimator = fVar2.c;
                        if (valueAnimator != null && valueAnimator.isRunning()) {
                            fVar2.c.cancel();
                        }
                        fVar2.d(true, i2, i4);
                        return;
                    }
                }
            }
            n(i2, 0.0f, true, true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003c, code lost:
        if (r0 != 2) goto L_0x0052;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void e() {
        int i2;
        int i3 = this.u2;
        if (i3 == 0 || i3 == 2) {
            i2 = Math.max(0, this.q2 - this.Y1);
        } else {
            i2 = 0;
        }
        f fVar = this.y;
        AtomicInteger atomicInteger = q.a;
        fVar.setPaddingRelative(i2, 0, 0, 0);
        int i4 = this.u2;
        if (i4 == 0) {
            int i5 = this.r2;
            if (i5 == 0) {
                Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
            } else if (i5 == 1) {
                this.y.setGravity(1);
            }
            this.y.setGravity(8388611);
        } else if (i4 == 1 || i4 == 2) {
            if (this.r2 == 2) {
                Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            this.y.setGravity(1);
        }
        r(true);
    }

    public final int f(int i2, float f2) {
        int i3 = this.u2;
        int i4 = 0;
        if (i3 != 0 && i3 != 2) {
            return 0;
        }
        View childAt = this.y.getChildAt(i2);
        int i5 = i2 + 1;
        View childAt2 = i5 < this.y.getChildCount() ? this.y.getChildAt(i5) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        if (childAt2 != null) {
            i4 = childAt2.getWidth();
        }
        int left = ((width / 2) + childAt.getLeft()) - (getWidth() / 2);
        int i6 = (int) (((float) (width + i4)) * 0.5f * f2);
        AtomicInteger atomicInteger = q.a;
        return getLayoutDirection() == 0 ? left + i6 : left - i6;
    }

    public final void g() {
        if (this.D2 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.D2 = valueAnimator;
            valueAnimator.setInterpolator(i0.h.a.c.a.a.b);
            this.D2.setDuration((long) this.s2);
            this.D2.addUpdateListener(new a());
        }
    }

    public int getSelectedTabPosition() {
        g gVar = this.x;
        if (gVar != null) {
            return gVar.d;
        }
        return -1;
    }

    public int getTabCount() {
        return this.q.size();
    }

    public int getTabGravity() {
        return this.r2;
    }

    public ColorStateList getTabIconTint() {
        return this.e2;
    }

    public int getTabIndicatorAnimationMode() {
        return this.x2;
    }

    public int getTabIndicatorGravity() {
        return this.t2;
    }

    public int getTabMaxWidth() {
        return this.m2;
    }

    public int getTabMode() {
        return this.u2;
    }

    public ColorStateList getTabRippleColor() {
        return this.f2;
    }

    public Drawable getTabSelectedIndicator() {
        return this.g2;
    }

    public ColorStateList getTabTextColors() {
        return this.d2;
    }

    public g h(int i2) {
        if (i2 < 0 || i2 >= getTabCount()) {
            return null;
        }
        return this.q.get(i2);
    }

    public g i() {
        g a2 = d.a();
        if (a2 == null) {
            a2 = new g();
        }
        a2.f = this;
        h0.i.h.d<i> dVar = this.K2;
        i a3 = dVar != null ? dVar.a() : null;
        if (a3 == null) {
            a3 = new i(getContext());
        }
        a3.setTab(a2);
        a3.setFocusable(true);
        a3.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(a2.c)) {
            a3.setContentDescription(a2.b);
        } else {
            a3.setContentDescription(a2.c);
        }
        a2.g = a3;
        int i2 = a2.h;
        if (i2 != -1) {
            a3.setId(i2);
        }
        return a2;
    }

    public void j() {
        int currentItem;
        k();
        h0.f0.a.a aVar = this.F2;
        if (aVar != null) {
            int count = aVar.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                g i3 = i();
                i3.b(this.F2.getPageTitle(i2));
                b(i3, this.q.size(), false);
            }
            ViewPager viewPager = this.E2;
            if (viewPager != null && count > 0 && (currentItem = viewPager.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                l(h(currentItem), true);
            }
        }
    }

    public void k() {
        int childCount = this.y.getChildCount();
        while (true) {
            childCount--;
            if (childCount < 0) {
                break;
            }
            i iVar = (i) this.y.getChildAt(childCount);
            this.y.removeViewAt(childCount);
            if (iVar != null) {
                iVar.setTab(null);
                iVar.setSelected(false);
                this.K2.b(iVar);
            }
            requestLayout();
        }
        Iterator<g> it = this.q.iterator();
        while (it.hasNext()) {
            g next = it.next();
            it.remove();
            next.f = null;
            next.g = null;
            next.a = null;
            next.h = -1;
            next.b = null;
            next.c = null;
            next.d = -1;
            next.e = null;
            d.b(next);
        }
        this.x = null;
    }

    public void l(g gVar, boolean z) {
        g gVar2 = this.x;
        if (gVar2 != gVar) {
            int i2 = gVar != null ? gVar.d : -1;
            if (z) {
                if ((gVar2 == null || gVar2.d == -1) && i2 != -1) {
                    n(i2, 0.0f, true, true);
                } else {
                    d(i2);
                }
                if (i2 != -1) {
                    setSelectedTabView(i2);
                }
            }
            this.x = gVar;
            if (gVar2 != null) {
                for (int size = this.B2.size() - 1; size >= 0; size--) {
                    this.B2.get(size).c(gVar2);
                }
            }
            if (gVar != null) {
                for (int size2 = this.B2.size() - 1; size2 >= 0; size2--) {
                    this.B2.get(size2).b(gVar);
                }
            }
        } else if (gVar2 != null) {
            for (int size3 = this.B2.size() - 1; size3 >= 0; size3--) {
                this.B2.get(size3).a(gVar);
            }
            d(gVar.d);
        }
    }

    public void m(h0.f0.a.a aVar, boolean z) {
        DataSetObserver dataSetObserver;
        h0.f0.a.a aVar2 = this.F2;
        if (!(aVar2 == null || (dataSetObserver = this.G2) == null)) {
            aVar2.unregisterDataSetObserver(dataSetObserver);
        }
        this.F2 = aVar;
        if (z && aVar != null) {
            if (this.G2 == null) {
                this.G2 = new e();
            }
            aVar.registerDataSetObserver(this.G2);
        }
        j();
    }

    public void n(int i2, float f2, boolean z, boolean z2) {
        int round = Math.round(((float) i2) + f2);
        if (round >= 0 && round < this.y.getChildCount()) {
            if (z2) {
                f fVar = this.y;
                ValueAnimator valueAnimator = fVar.c;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    fVar.c.cancel();
                }
                fVar.d = i2;
                fVar.q = f2;
                fVar.c(fVar.getChildAt(i2), fVar.getChildAt(fVar.d + 1), fVar.q);
            }
            ValueAnimator valueAnimator2 = this.D2;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.D2.cancel();
            }
            scrollTo(f(i2, f2), 0);
            if (z) {
                setSelectedTabView(round);
            }
        }
    }

    public final void o(ViewPager viewPager, boolean z, boolean z2) {
        ViewPager viewPager2 = this.E2;
        if (viewPager2 != null) {
            h hVar = this.H2;
            if (hVar != null) {
                viewPager2.removeOnPageChangeListener(hVar);
            }
            b bVar = this.I2;
            if (bVar != null) {
                this.E2.removeOnAdapterChangeListener(bVar);
            }
        }
        c cVar = this.C2;
        if (cVar != null) {
            this.B2.remove(cVar);
            this.C2 = null;
        }
        if (viewPager != null) {
            this.E2 = viewPager;
            if (this.H2 == null) {
                this.H2 = new h(this);
            }
            h hVar2 = this.H2;
            hVar2.q = 0;
            hVar2.d = 0;
            viewPager.addOnPageChangeListener(hVar2);
            j jVar = new j(viewPager);
            this.C2 = jVar;
            if (!this.B2.contains(jVar)) {
                this.B2.add(jVar);
            }
            h0.f0.a.a adapter = viewPager.getAdapter();
            if (adapter != null) {
                m(adapter, z);
            }
            if (this.I2 == null) {
                this.I2 = new b();
            }
            b bVar2 = this.I2;
            bVar2.a = z;
            viewPager.addOnAdapterChangeListener(bVar2);
            n(viewPager.getCurrentItem(), 0.0f, true, true);
        } else {
            this.E2 = null;
            m(null, false);
        }
        this.J2 = z2;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof i0.h.a.c.w.g) {
            i0.h.a.b.c.m.b.m0(this, (i0.h.a.c.w.g) background);
        }
        if (this.E2 == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                o((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.J2) {
            setupWithViewPager(null);
            this.J2 = false;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        i iVar;
        Drawable drawable;
        for (int i2 = 0; i2 < this.y.getChildCount(); i2++) {
            View childAt = this.y.getChildAt(i2);
            if ((childAt instanceof i) && (drawable = (iVar = (i) childAt).c2) != null) {
                drawable.setBounds(iVar.getLeft(), iVar.getTop(), iVar.getRight(), iVar.getBottom());
                iVar.c2.draw(canvas);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) b.C0077b.a(1, getTabCount(), false, 1).a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0073, code lost:
        if (r0 != 2) goto L_0x008d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007e, code lost:
        if (r7.getMeasuredWidth() != getMeasuredWidth()) goto L_0x0080;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0080, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008a, code lost:
        if (r7.getMeasuredWidth() < getMeasuredWidth()) goto L_0x0080;
     */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void onMeasure(int i2, int i3) {
        int round = Math.round(i0.h.a.b.c.m.b.E(getContext(), getDefaultHeight()));
        int mode = View.MeasureSpec.getMode(i3);
        boolean z = false;
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i3 = View.MeasureSpec.makeMeasureSpec(getPaddingBottom() + getPaddingTop() + round, 1073741824);
            }
        } else if (getChildCount() == 1 && View.MeasureSpec.getSize(i3) >= round) {
            getChildAt(0).setMinimumHeight(round);
        }
        int size = View.MeasureSpec.getSize(i2);
        if (View.MeasureSpec.getMode(i2) != 0) {
            int i4 = this.o2;
            if (i4 <= 0) {
                i4 = (int) (((float) size) - i0.h.a.b.c.m.b.E(getContext(), 56));
            }
            this.m2 = i4;
        }
        super.onMeasure(i2, i3);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            int i5 = this.u2;
            if (i5 != 0) {
                if (i5 != 1) {
                }
                if (z) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), HorizontalScrollView.getChildMeasureSpec(i3, getPaddingBottom() + getPaddingTop(), childAt.getLayoutParams().height));
                }
            }
        }
    }

    public final void p() {
        int size = this.q.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.q.get(i2).c();
        }
    }

    public final void q(LinearLayout.LayoutParams layoutParams) {
        if (this.u2 == 1 && this.r2 == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    public void r(boolean z) {
        for (int i2 = 0; i2 < this.y.getChildCount(); i2++) {
            View childAt = this.y.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            q((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        i0.h.a.b.c.m.b.l0(this, f2);
    }

    public void setInlineLabel(boolean z) {
        if (this.v2 != z) {
            this.v2 = z;
            for (int i2 = 0; i2 < this.y.getChildCount(); i2++) {
                View childAt = this.y.getChildAt(i2);
                if (childAt instanceof i) {
                    i iVar = (i) childAt;
                    iVar.setOrientation(!TabLayout.this.v2 ? 1 : 0);
                    TextView textView = iVar.a2;
                    if (textView == null && iVar.b2 == null) {
                        iVar.j(iVar.q, iVar.x);
                    } else {
                        iVar.j(textView, iVar.b2);
                    }
                }
            }
            e();
        }
    }

    public void setInlineLabelResource(int i2) {
        setInlineLabel(getResources().getBoolean(i2));
    }

    @Deprecated
    public void setOnTabSelectedListener(d dVar) {
        setOnTabSelectedListener((c) dVar);
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        g();
        this.D2.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (this.g2 != drawable) {
            if (drawable == null) {
                drawable = new GradientDrawable();
            }
            this.g2 = drawable;
        }
    }

    public void setSelectedTabIndicatorColor(int i2) {
        this.h2 = i2;
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.t2 != i2) {
            this.t2 = i2;
            f fVar = this.y;
            AtomicInteger atomicInteger = q.a;
            fVar.postInvalidateOnAnimation();
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        this.y.b(i2);
    }

    public void setTabGravity(int i2) {
        if (this.r2 != i2) {
            this.r2 = i2;
            e();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.e2 != colorStateList) {
            this.e2 = colorStateList;
            p();
        }
    }

    public void setTabIconTintResource(int i2) {
        Context context = getContext();
        ThreadLocal<TypedValue> threadLocal = h0.b.b.a.a.a;
        setTabIconTint(context.getColorStateList(i2));
    }

    public void setTabIndicatorAnimationMode(int i2) {
        this.x2 = i2;
        if (i2 == 0) {
            this.z2 = new i0.h.a.c.y.b();
        } else if (i2 == 1) {
            this.z2 = new i0.h.a.c.y.a();
        } else {
            throw new IllegalArgumentException(i2 + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.w2 = z;
        f fVar = this.y;
        AtomicInteger atomicInteger = q.a;
        fVar.postInvalidateOnAnimation();
    }

    public void setTabMode(int i2) {
        if (i2 != this.u2) {
            this.u2 = i2;
            e();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.f2 != colorStateList) {
            this.f2 = colorStateList;
            for (int i2 = 0; i2 < this.y.getChildCount(); i2++) {
                View childAt = this.y.getChildAt(i2);
                if (childAt instanceof i) {
                    Context context = getContext();
                    int i3 = i.c;
                    ((i) childAt).i(context);
                }
            }
        }
    }

    public void setTabRippleColorResource(int i2) {
        Context context = getContext();
        ThreadLocal<TypedValue> threadLocal = h0.b.b.a.a.a;
        setTabRippleColor(context.getColorStateList(i2));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.d2 != colorStateList) {
            this.d2 = colorStateList;
            p();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(h0.f0.a.a aVar) {
        m(aVar, false);
    }

    public void setUnboundedRipple(boolean z) {
        if (this.y2 != z) {
            this.y2 = z;
            for (int i2 = 0; i2 < this.y.getChildCount(); i2++) {
                View childAt = this.y.getChildAt(i2);
                if (childAt instanceof i) {
                    Context context = getContext();
                    int i3 = i.c;
                    ((i) childAt).i(context);
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i2) {
        setUnboundedRipple(getResources().getBoolean(i2));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        o(viewPager, true, false);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2) {
        c(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(c cVar) {
        c cVar2 = this.A2;
        if (cVar2 != null) {
            this.B2.remove(cVar2);
        }
        this.A2 = cVar;
        if (cVar != null && !this.B2.contains(cVar)) {
            this.B2.add(cVar);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        c(view);
    }

    public void setSelectedTabIndicator(int i2) {
        if (i2 != 0) {
            setSelectedTabIndicator(h0.b.b.a.a.a(getContext(), i2));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        c(view);
    }
}
