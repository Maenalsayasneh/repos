package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.R;
import h0.b.f.b;
import h0.b.f.p0;
import h0.i.i.q;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {
    public Drawable Y1;
    public Drawable Z1;
    public boolean a2;
    public boolean b2;
    public boolean c;
    public int c2;
    public View d;
    public View q;
    public View x;
    public Drawable y;

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b bVar = new b(this);
        AtomicInteger atomicInteger = q.a;
        setBackground(bVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBar);
        this.y = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_background);
        this.Y1 = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundStacked);
        this.c2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
        boolean z = true;
        if (getId() == R.id.split_action_bar) {
            this.a2 = true;
            this.Z1 = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        if (!this.a2 ? !(this.y == null && this.Y1 == null) : this.Z1 != null) {
            z = false;
        }
        setWillNotDraw(z);
    }

    public final int a(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public final boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.y;
        if (drawable != null && drawable.isStateful()) {
            this.y.setState(getDrawableState());
        }
        Drawable drawable2 = this.Y1;
        if (drawable2 != null && drawable2.isStateful()) {
            this.Y1.setState(getDrawableState());
        }
        Drawable drawable3 = this.Z1;
        if (drawable3 != null && drawable3.isStateful()) {
            this.Z1.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.d;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.y;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.Y1;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.Z1;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.q = findViewById(R.id.action_bar);
        this.x = findViewById(R.id.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.c || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.View, android.view.ViewGroup
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Drawable drawable;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.d;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            int i5 = ((FrameLayout.LayoutParams) view.getLayoutParams()).bottomMargin;
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - i5, i3, measuredHeight - i5);
        }
        if (this.a2) {
            Drawable drawable2 = this.Z1;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
            z2 = z3;
        } else {
            if (this.y != null) {
                if (this.q.getVisibility() == 0) {
                    this.y.setBounds(this.q.getLeft(), this.q.getTop(), this.q.getRight(), this.q.getBottom());
                } else {
                    View view2 = this.x;
                    if (view2 == null || view2.getVisibility() != 0) {
                        this.y.setBounds(0, 0, 0, 0);
                    } else {
                        this.y.setBounds(this.x.getLeft(), this.x.getTop(), this.x.getRight(), this.x.getBottom());
                    }
                }
                z3 = true;
            }
            this.b2 = z4;
            if (z4 && (drawable = this.Y1) != null) {
                drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
            z2 = z3;
        }
        if (z2) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        if (this.q == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && (i4 = this.c2) >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i4, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.q != null) {
            int mode = View.MeasureSpec.getMode(i2);
            View view = this.d;
            if (view != null && view.getVisibility() != 8 && mode != 1073741824) {
                if (!b(this.q)) {
                    i3 = a(this.q);
                } else {
                    i3 = !b(this.x) ? a(this.x) : 0;
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(a(this.d) + i3, mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.y;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.y);
        }
        this.y = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.q;
            if (view != null) {
                this.y.setBounds(view.getLeft(), this.q.getTop(), this.q.getRight(), this.q.getBottom());
            }
        }
        boolean z = true;
        if (!this.a2 ? !(this.y == null && this.Y1 == null) : this.Z1 != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.Z1;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.Z1);
        }
        this.Z1 = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.a2 && (drawable2 = this.Z1) != null) {
                drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        z = true;
        if (!this.a2 ? this.y == null && this.Y1 == null : this.Z1 == null) {
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.Y1;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            unscheduleDrawable(this.Y1);
        }
        this.Y1 = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.b2 && (drawable2 = this.Y1) != null) {
                drawable2.setBounds(this.d.getLeft(), this.d.getTop(), this.d.getRight(), this.d.getBottom());
            }
        }
        boolean z = true;
        if (!this.a2 ? !(this.y == null && this.Y1 == null) : this.Z1 != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
        invalidateOutline();
    }

    public void setTabContainer(p0 p0Var) {
        View view = this.d;
        if (view != null) {
            removeView(view);
        }
        this.d = p0Var;
        if (p0Var != null) {
            addView(p0Var);
            ViewGroup.LayoutParams layoutParams = p0Var.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            p0Var.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.c = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.y;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.Y1;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.Z1;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    @Override // android.view.ViewParent, android.view.ViewGroup
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewParent, android.view.ViewGroup
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.y && !this.a2) || (drawable == this.Y1 && this.b2) || ((drawable == this.Z1 && this.a2) || super.verifyDrawable(drawable));
    }
}
