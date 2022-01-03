package i0.h.a.c.z;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import h0.i.i.q;
import i0.h.a.c.q.i;
import i0.h.a.c.w.g;
import i0.h.a.c.w.k;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: DropdownMenuEndIconDelegate.java */
/* loaded from: classes2.dex */
public class h extends m {
    public final TextWatcher d = new a();
    public final View.OnFocusChangeListener e = new b();
    public final TextInputLayout.e f = new c(this.a);
    public final TextInputLayout.f g = new d();
    @SuppressLint({"ClickableViewAccessibility"})
    public final TextInputLayout.g h = new e();
    public boolean i = false;
    public boolean j = false;
    public long k = RecyclerView.FOREVER_NS;
    public StateListDrawable l;
    public g m;
    public AccessibilityManager n;
    public ValueAnimator o;
    public ValueAnimator p;

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes2.dex */
    public class a extends i {

        /* compiled from: DropdownMenuEndIconDelegate.java */
        /* renamed from: i0.h.a.c.z.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0159a implements Runnable {
            public final /* synthetic */ AutoCompleteTextView c;

            public RunnableC0159a(AutoCompleteTextView autoCompleteTextView) {
                this.c = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean isPopupShowing = this.c.isPopupShowing();
                h.f(h.this, isPopupShowing);
                h.this.i = isPopupShowing;
            }
        }

        public a() {
        }

        @Override // i0.h.a.c.q.i, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AutoCompleteTextView d = h.d(h.this.a.getEditText());
            if (h.this.n.isTouchExplorationEnabled() && h.e(d) && !h.this.c.hasFocus()) {
                d.dismissDropDown();
            }
            d.post(new RunnableC0159a(d));
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes2.dex */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            h.this.a.setEndIconActivated(z);
            if (!z) {
                h.f(h.this, false);
                h.this.i = false;
            }
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes2.dex */
    public class c extends TextInputLayout.e {
        public c(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.e, h0.i.i.a
        public void onInitializeAccessibilityNodeInfo(View view, h0.i.i.g0.b bVar) {
            boolean z;
            super.onInitializeAccessibilityNodeInfo(view, bVar);
            if (!h.e(h.this.a.getEditText())) {
                bVar.b.setClassName(Spinner.class.getName());
            }
            if (Build.VERSION.SDK_INT >= 26) {
                z = bVar.b.isShowingHintText();
            } else {
                Bundle f = bVar.f();
                z = f != null && (f.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & 4) == 4;
            }
            if (z) {
                bVar.k(null);
            }
        }

        @Override // h0.i.i.a
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            AutoCompleteTextView d = h.d(h.this.a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && h.this.n.isTouchExplorationEnabled() && !h.e(h.this.a.getEditText())) {
                h.g(h.this, d);
            }
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes2.dex */
    public class d implements TextInputLayout.f {
        public d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            AutoCompleteTextView d = h.d(textInputLayout.getEditText());
            h hVar = h.this;
            int boxBackgroundMode = hVar.a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                d.setDropDownBackgroundDrawable(hVar.m);
            } else if (boxBackgroundMode == 1) {
                d.setDropDownBackgroundDrawable(hVar.l);
            }
            h hVar2 = h.this;
            Objects.requireNonNull(hVar2);
            boolean z = false;
            if (!(d.getKeyListener() != null)) {
                int boxBackgroundMode2 = hVar2.a.getBoxBackgroundMode();
                g boxBackground = hVar2.a.getBoxBackground();
                int L = i0.h.a.b.c.m.b.L(d, R.attr.colorControlHighlight);
                int[][] iArr = {new int[]{16842919}, new int[0]};
                if (boxBackgroundMode2 == 2) {
                    int L2 = i0.h.a.b.c.m.b.L(d, R.attr.colorSurface);
                    g gVar = new g(boxBackground.q.a);
                    int b0 = i0.h.a.b.c.m.b.b0(L, L2, 0.1f);
                    gVar.t(new ColorStateList(iArr, new int[]{b0, 0}));
                    gVar.setTint(L2);
                    ColorStateList colorStateList = new ColorStateList(iArr, new int[]{b0, L2});
                    g gVar2 = new g(boxBackground.q.a);
                    gVar2.setTint(-1);
                    LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, gVar, gVar2), boxBackground});
                    AtomicInteger atomicInteger = q.a;
                    d.setBackground(layerDrawable);
                } else if (boxBackgroundMode2 == 1) {
                    int boxBackgroundColor = hVar2.a.getBoxBackgroundColor();
                    RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(iArr, new int[]{i0.h.a.b.c.m.b.b0(L, boxBackgroundColor, 0.1f), boxBackgroundColor}), boxBackground, boxBackground);
                    AtomicInteger atomicInteger2 = q.a;
                    d.setBackground(rippleDrawable);
                }
            }
            h hVar3 = h.this;
            Objects.requireNonNull(hVar3);
            d.setOnTouchListener(new j(hVar3, d));
            d.setOnFocusChangeListener(hVar3.e);
            d.setOnDismissListener(new k(hVar3));
            d.setThreshold(0);
            d.removeTextChangedListener(h.this.d);
            d.addTextChangedListener(h.this.d);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (d.getKeyListener() != null) {
                z = true;
            }
            if (!z) {
                CheckableImageButton checkableImageButton = h.this.c;
                AtomicInteger atomicInteger3 = q.a;
                checkableImageButton.setImportantForAccessibility(2);
            }
            textInputLayout.setTextInputAccessibilityDelegate(h.this.f);
            textInputLayout.setEndIconVisible(true);
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes2.dex */
    public class e implements TextInputLayout.g {

        /* compiled from: DropdownMenuEndIconDelegate.java */
        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public final /* synthetic */ AutoCompleteTextView c;

            public a(AutoCompleteTextView autoCompleteTextView) {
                this.c = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.c.removeTextChangedListener(h.this.d);
            }
        }

        public e() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView != null && i == 3) {
                autoCompleteTextView.post(new a(autoCompleteTextView));
                if (autoCompleteTextView.getOnFocusChangeListener() == h.this.e) {
                    autoCompleteTextView.setOnFocusChangeListener(null);
                }
                autoCompleteTextView.setOnTouchListener(null);
                autoCompleteTextView.setOnDismissListener(null);
            }
        }
    }

    /* compiled from: DropdownMenuEndIconDelegate.java */
    /* loaded from: classes2.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.g(h.this, (AutoCompleteTextView) h.this.a.getEditText());
        }
    }

    public h(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    public static AutoCompleteTextView d(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    public static boolean e(EditText editText) {
        return editText.getKeyListener() != null;
    }

    public static void f(h hVar, boolean z) {
        if (hVar.j != z) {
            hVar.j = z;
            hVar.p.cancel();
            hVar.o.start();
        }
    }

    public static void g(h hVar, AutoCompleteTextView autoCompleteTextView) {
        Objects.requireNonNull(hVar);
        if (autoCompleteTextView != null) {
            if (hVar.i()) {
                hVar.i = false;
            }
            if (!hVar.i) {
                boolean z = hVar.j;
                boolean z2 = !z;
                if (z != z2) {
                    hVar.j = z2;
                    hVar.p.cancel();
                    hVar.o.start();
                }
                if (hVar.j) {
                    autoCompleteTextView.requestFocus();
                    autoCompleteTextView.showDropDown();
                    return;
                }
                autoCompleteTextView.dismissDropDown();
                return;
            }
            hVar.i = false;
        }
    }

    @Override // i0.h.a.c.z.m
    public void a() {
        float dimensionPixelOffset = (float) this.b.getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = (float) this.b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        g h = h(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        g h2 = h(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.m = h;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.l = stateListDrawable;
        stateListDrawable.addState(new int[]{16842922}, h);
        this.l.addState(new int[0], h2);
        this.a.setEndIconDrawable(h0.b.b.a.a.a(this.b, R.drawable.mtrl_dropdown_arrow));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.exposed_dropdown_menu_content_description));
        this.a.setEndIconOnClickListener(new f());
        this.a.addOnEditTextAttachedListener(this.g);
        this.a.addOnEndIconChangedListener(this.h);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = i0.h.a.c.a.a.a;
        ofFloat.setInterpolator(timeInterpolator);
        ofFloat.setDuration((long) 67);
        ofFloat.addUpdateListener(new i(this));
        this.p = ofFloat;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat2.setInterpolator(timeInterpolator);
        ofFloat2.setDuration((long) 50);
        ofFloat2.addUpdateListener(new i(this));
        this.o = ofFloat2;
        ofFloat2.addListener(new l(this));
        this.n = (AccessibilityManager) this.b.getSystemService("accessibility");
    }

    @Override // i0.h.a.c.z.m
    public boolean b(int i) {
        return i != 0;
    }

    public final g h(float f2, float f3, float f4, int i) {
        k.b bVar = new k.b();
        bVar.e = new i0.h.a.c.w.a(f2);
        bVar.f = new i0.h.a.c.w.a(f2);
        bVar.h = new i0.h.a.c.w.a(f3);
        bVar.g = new i0.h.a.c.w.a(f3);
        k a2 = bVar.a();
        Context context = this.b;
        String str = g.c;
        int k02 = i0.h.a.b.c.m.b.k0(context, R.attr.colorSurface, g.class.getSimpleName());
        g gVar = new g();
        gVar.q.b = new i0.h.a.c.n.a(context);
        gVar.B();
        gVar.t(ColorStateList.valueOf(k02));
        g.b bVar2 = gVar.q;
        if (bVar2.o != f4) {
            bVar2.o = f4;
            gVar.B();
        }
        gVar.q.a = a2;
        gVar.invalidateSelf();
        g.b bVar3 = gVar.q;
        if (bVar3.i == null) {
            bVar3.i = new Rect();
        }
        gVar.q.i.set(0, i, 0, i);
        gVar.invalidateSelf();
        return gVar;
    }

    public final boolean i() {
        long currentTimeMillis = System.currentTimeMillis() - this.k;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }
}
