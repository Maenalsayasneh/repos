package h0.b.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.ResourceManagerInternal;
import h0.i.b.d.h;
import h0.i.i.q;
import h0.i.j.b;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: AppCompatTextHelper.java */
/* loaded from: classes.dex */
public class v {
    public final TextView a;
    public u0 b;
    public u0 c;
    public u0 d;
    public u0 e;
    public u0 f;
    public u0 g;
    public u0 h;
    public final x i;
    public int j = 0;
    public int k = -1;
    public Typeface l;
    public boolean m;

    /* compiled from: AppCompatTextHelper.java */
    /* loaded from: classes.dex */
    public class a extends h.a {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ WeakReference c;

        public a(int i, int i2, WeakReference weakReference) {
            this.a = i;
            this.b = i2;
            this.c = weakReference;
        }

        @Override // h0.i.b.d.h.a
        public void d(int i) {
        }

        @Override // h0.i.b.d.h.a
        public void e(Typeface typeface) {
            int i;
            if (Build.VERSION.SDK_INT >= 28 && (i = this.a) != -1) {
                typeface = Typeface.create(typeface, i, (this.b & 2) != 0);
            }
            v vVar = v.this;
            WeakReference weakReference = this.c;
            if (vVar.m) {
                vVar.l = typeface;
                TextView textView = (TextView) weakReference.get();
                if (textView != null) {
                    AtomicInteger atomicInteger = q.a;
                    if (textView.isAttachedToWindow()) {
                        textView.post(new w(vVar, textView, typeface, vVar.j));
                    } else {
                        textView.setTypeface(typeface, vVar.j);
                    }
                }
            }
        }
    }

    public v(TextView textView) {
        this.a = textView;
        this.i = new x(textView);
    }

    public static u0 c(Context context, j jVar, int i) {
        ColorStateList d = jVar.d(context, i);
        if (d == null) {
            return null;
        }
        u0 u0Var = new u0();
        u0Var.d = true;
        u0Var.a = d;
        return u0Var;
    }

    public final void a(Drawable drawable, u0 u0Var) {
        if (drawable != null && u0Var != null) {
            int[] drawableState = this.a.getDrawableState();
            PorterDuff.Mode mode = j.a;
            ResourceManagerInternal.tintDrawable(drawable, u0Var, drawableState);
        }
    }

    public void b() {
        if (!(this.b == null && this.c == null && this.d == null && this.e == null)) {
            Drawable[] compoundDrawables = this.a.getCompoundDrawables();
            a(compoundDrawables[0], this.b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
        if (this.f != null || this.g != null) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f);
            a(compoundDrawablesRelative[2], this.g);
        }
    }

    public boolean d() {
        x xVar = this.i;
        return xVar.i() && xVar.d != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:195:0x0366, code lost:
        if (r3 != null) goto L_0x036d;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00dd  */
    @SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void e(AttributeSet attributeSet, int i) {
        String str;
        boolean z;
        String str2;
        boolean z2;
        int i2;
        ColorStateList colorStateList;
        int resourceId;
        int resourceId2;
        Context context = this.a.getContext();
        j a2 = j.a();
        int[] iArr = R.styleable.AppCompatTextHelper;
        w0 q = w0.q(context, attributeSet, iArr, i, 0);
        TextView textView = this.a;
        q.o(textView, textView.getContext(), iArr, attributeSet, q.b, i, 0);
        int l = q.l(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
        int i3 = R.styleable.AppCompatTextHelper_android_drawableLeft;
        if (q.o(i3)) {
            this.b = c(context, a2, q.l(i3, 0));
        }
        int i4 = R.styleable.AppCompatTextHelper_android_drawableTop;
        if (q.o(i4)) {
            this.c = c(context, a2, q.l(i4, 0));
        }
        int i5 = R.styleable.AppCompatTextHelper_android_drawableRight;
        if (q.o(i5)) {
            this.d = c(context, a2, q.l(i5, 0));
        }
        int i6 = R.styleable.AppCompatTextHelper_android_drawableBottom;
        if (q.o(i6)) {
            this.e = c(context, a2, q.l(i6, 0));
        }
        int i7 = Build.VERSION.SDK_INT;
        int i8 = R.styleable.AppCompatTextHelper_android_drawableStart;
        if (q.o(i8)) {
            this.f = c(context, a2, q.l(i8, 0));
        }
        int i9 = R.styleable.AppCompatTextHelper_android_drawableEnd;
        if (q.o(i9)) {
            this.g = c(context, a2, q.l(i9, 0));
        }
        q.b.recycle();
        boolean z3 = this.a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (l != -1) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(l, R.styleable.TextAppearance);
            w0 w0Var = new w0(context, obtainStyledAttributes);
            if (!z3) {
                int i10 = R.styleable.TextAppearance_textAllCaps;
                if (w0Var.o(i10)) {
                    z2 = w0Var.a(i10, false);
                    z = true;
                    m(context, w0Var);
                    int i11 = R.styleable.TextAppearance_textLocale;
                    str = !w0Var.o(i11) ? w0Var.m(i11) : null;
                    if (i7 >= 26) {
                        int i12 = R.styleable.TextAppearance_fontVariationSettings;
                        if (w0Var.o(i12)) {
                            str2 = w0Var.m(i12);
                            obtainStyledAttributes.recycle();
                        }
                    }
                    str2 = null;
                    obtainStyledAttributes.recycle();
                }
            }
            z2 = false;
            z = false;
            m(context, w0Var);
            int i112 = R.styleable.TextAppearance_textLocale;
            if (!w0Var.o(i112)) {
            }
            if (i7 >= 26) {
            }
            str2 = null;
            obtainStyledAttributes.recycle();
        } else {
            z2 = false;
            z = false;
            str2 = null;
            str = null;
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.TextAppearance, i, 0);
        w0 w0Var2 = new w0(context, obtainStyledAttributes2);
        if (!z3) {
            int i13 = R.styleable.TextAppearance_textAllCaps;
            if (w0Var2.o(i13)) {
                z2 = w0Var2.a(i13, false);
                z = true;
            }
        }
        int i14 = R.styleable.TextAppearance_textLocale;
        if (w0Var2.o(i14)) {
            str = w0Var2.m(i14);
        }
        if (i7 >= 26) {
            int i15 = R.styleable.TextAppearance_fontVariationSettings;
            if (w0Var2.o(i15)) {
                str2 = w0Var2.m(i15);
            }
        }
        if (i7 >= 28) {
            int i16 = R.styleable.TextAppearance_android_textSize;
            if (w0Var2.o(i16) && w0Var2.f(i16, -1) == 0) {
                this.a.setTextSize(0, 0.0f);
            }
        }
        m(context, w0Var2);
        obtainStyledAttributes2.recycle();
        if (!z3 && z) {
            this.a.setAllCaps(z2);
        }
        Typeface typeface = this.l;
        if (typeface != null) {
            if (this.k == -1) {
                this.a.setTypeface(typeface, this.j);
            } else {
                this.a.setTypeface(typeface);
            }
        }
        if (str2 != null) {
            this.a.setFontVariationSettings(str2);
        }
        if (str != null) {
            this.a.setTextLocales(LocaleList.forLanguageTags(str));
        }
        x xVar = this.i;
        Context context2 = xVar.m;
        int[] iArr2 = R.styleable.AppCompatTextView;
        TypedArray obtainStyledAttributes3 = context2.obtainStyledAttributes(attributeSet, iArr2, i, 0);
        TextView textView2 = xVar.l;
        q.o(textView2, textView2.getContext(), iArr2, attributeSet, obtainStyledAttributes3, i, 0);
        int i17 = R.styleable.AppCompatTextView_autoSizeTextType;
        if (obtainStyledAttributes3.hasValue(i17)) {
            xVar.d = obtainStyledAttributes3.getInt(i17, 0);
        }
        int i18 = R.styleable.AppCompatTextView_autoSizeStepGranularity;
        float dimension = obtainStyledAttributes3.hasValue(i18) ? obtainStyledAttributes3.getDimension(i18, -1.0f) : -1.0f;
        int i19 = R.styleable.AppCompatTextView_autoSizeMinTextSize;
        float dimension2 = obtainStyledAttributes3.hasValue(i19) ? obtainStyledAttributes3.getDimension(i19, -1.0f) : -1.0f;
        int i20 = R.styleable.AppCompatTextView_autoSizeMaxTextSize;
        float dimension3 = obtainStyledAttributes3.hasValue(i20) ? obtainStyledAttributes3.getDimension(i20, -1.0f) : -1.0f;
        int i21 = R.styleable.AppCompatTextView_autoSizePresetSizes;
        if (obtainStyledAttributes3.hasValue(i21) && (resourceId2 = obtainStyledAttributes3.getResourceId(i21, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes3.getResources().obtainTypedArray(resourceId2);
            int length = obtainTypedArray.length();
            int[] iArr3 = new int[length];
            if (length > 0) {
                for (int i22 = 0; i22 < length; i22++) {
                    iArr3[i22] = obtainTypedArray.getDimensionPixelSize(i22, -1);
                }
                xVar.i = xVar.b(iArr3);
                xVar.h();
            }
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes3.recycle();
        if (!xVar.i()) {
            xVar.d = 0;
        } else if (xVar.d == 1) {
            if (!xVar.j) {
                DisplayMetrics displayMetrics = xVar.m.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                xVar.j(dimension2, dimension3, dimension);
            }
            xVar.g();
        }
        if (b.a) {
            x xVar2 = this.i;
            if (xVar2.d != 0) {
                int[] iArr4 = xVar2.i;
                if (iArr4.length > 0) {
                    if (((float) this.a.getAutoSizeStepGranularity()) != -1.0f) {
                        this.a.setAutoSizeTextTypeUniformWithConfiguration(Math.round(this.i.g), Math.round(this.i.h), Math.round(this.i.f), 0);
                    } else {
                        this.a.setAutoSizeTextTypeUniformWithPresetSizes(iArr4, 0);
                    }
                }
            }
        }
        TypedArray obtainStyledAttributes4 = context.obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView);
        int resourceId3 = obtainStyledAttributes4.getResourceId(R.styleable.AppCompatTextView_drawableLeftCompat, -1);
        Drawable b = resourceId3 != -1 ? a2.b(context, resourceId3) : null;
        int resourceId4 = obtainStyledAttributes4.getResourceId(R.styleable.AppCompatTextView_drawableTopCompat, -1);
        Drawable b2 = resourceId4 != -1 ? a2.b(context, resourceId4) : null;
        int resourceId5 = obtainStyledAttributes4.getResourceId(R.styleable.AppCompatTextView_drawableRightCompat, -1);
        Drawable b3 = resourceId5 != -1 ? a2.b(context, resourceId5) : null;
        int resourceId6 = obtainStyledAttributes4.getResourceId(R.styleable.AppCompatTextView_drawableBottomCompat, -1);
        Drawable b4 = resourceId6 != -1 ? a2.b(context, resourceId6) : null;
        int resourceId7 = obtainStyledAttributes4.getResourceId(R.styleable.AppCompatTextView_drawableStartCompat, -1);
        Drawable b5 = resourceId7 != -1 ? a2.b(context, resourceId7) : null;
        int resourceId8 = obtainStyledAttributes4.getResourceId(R.styleable.AppCompatTextView_drawableEndCompat, -1);
        Drawable b6 = resourceId8 != -1 ? a2.b(context, resourceId8) : null;
        if (b5 != null || b6 != null) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            TextView textView3 = this.a;
            if (b5 == null) {
                b5 = compoundDrawablesRelative[0];
            }
            if (b2 == null) {
                b2 = compoundDrawablesRelative[1];
            }
            if (b6 == null) {
                b6 = compoundDrawablesRelative[2];
            }
            if (b4 == null) {
                b4 = compoundDrawablesRelative[3];
            }
            textView3.setCompoundDrawablesRelativeWithIntrinsicBounds(b5, b2, b6, b4);
        } else if (!(b == null && b2 == null && b3 == null && b4 == null)) {
            Drawable[] compoundDrawablesRelative2 = this.a.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative2[0] == null && compoundDrawablesRelative2[2] == null) {
                Drawable[] compoundDrawables = this.a.getCompoundDrawables();
                TextView textView4 = this.a;
                if (b == null) {
                    b = compoundDrawables[0];
                }
                if (b2 == null) {
                    b2 = compoundDrawables[1];
                }
                if (b3 == null) {
                    b3 = compoundDrawables[2];
                }
                if (b4 == null) {
                    b4 = compoundDrawables[3];
                }
                textView4.setCompoundDrawablesWithIntrinsicBounds(b, b2, b3, b4);
            } else {
                TextView textView5 = this.a;
                Drawable drawable = compoundDrawablesRelative2[0];
                if (b2 == null) {
                    b2 = compoundDrawablesRelative2[1];
                }
                Drawable drawable2 = compoundDrawablesRelative2[2];
                if (b4 == null) {
                    b4 = compoundDrawablesRelative2[3];
                }
                textView5.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, b2, drawable2, b4);
            }
        }
        int i23 = R.styleable.AppCompatTextView_drawableTint;
        if (obtainStyledAttributes4.hasValue(i23)) {
            if (obtainStyledAttributes4.hasValue(i23) && (resourceId = obtainStyledAttributes4.getResourceId(i23, 0)) != 0) {
                ThreadLocal<TypedValue> threadLocal = h0.b.b.a.a.a;
                colorStateList = context.getColorStateList(resourceId);
            }
            colorStateList = obtainStyledAttributes4.getColorStateList(i23);
            TextView textView6 = this.a;
            Objects.requireNonNull(textView6);
            textView6.setCompoundDrawableTintList(colorStateList);
        }
        int i24 = R.styleable.AppCompatTextView_drawableTintMode;
        if (obtainStyledAttributes4.hasValue(i24)) {
            i2 = -1;
            PorterDuff.Mode c = b0.c(obtainStyledAttributes4.getInt(i24, -1), null);
            TextView textView7 = this.a;
            Objects.requireNonNull(textView7);
            textView7.setCompoundDrawableTintMode(c);
        } else {
            i2 = -1;
        }
        int dimensionPixelSize = obtainStyledAttributes4.getDimensionPixelSize(R.styleable.AppCompatTextView_firstBaselineToTopHeight, i2);
        int dimensionPixelSize2 = obtainStyledAttributes4.getDimensionPixelSize(R.styleable.AppCompatTextView_lastBaselineToBottomHeight, i2);
        int dimensionPixelSize3 = obtainStyledAttributes4.getDimensionPixelSize(R.styleable.AppCompatTextView_lineHeight, i2);
        obtainStyledAttributes4.recycle();
        if (dimensionPixelSize != i2) {
            g0.a.b.b.a.r0(this.a, dimensionPixelSize);
        }
        if (dimensionPixelSize2 != i2) {
            g0.a.b.b.a.s0(this.a, dimensionPixelSize2);
        }
        if (dimensionPixelSize3 != i2) {
            g0.a.b.b.a.t0(this.a, dimensionPixelSize3);
        }
    }

    public void f(Context context, int i) {
        String m;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.TextAppearance);
        w0 w0Var = new w0(context, obtainStyledAttributes);
        int i2 = R.styleable.TextAppearance_textAllCaps;
        if (w0Var.o(i2)) {
            this.a.setAllCaps(w0Var.a(i2, false));
        }
        int i3 = Build.VERSION.SDK_INT;
        int i4 = R.styleable.TextAppearance_android_textSize;
        if (w0Var.o(i4) && w0Var.f(i4, -1) == 0) {
            this.a.setTextSize(0, 0.0f);
        }
        m(context, w0Var);
        if (i3 >= 26) {
            int i5 = R.styleable.TextAppearance_fontVariationSettings;
            if (w0Var.o(i5) && (m = w0Var.m(i5)) != null) {
                this.a.setFontVariationSettings(m);
            }
        }
        obtainStyledAttributes.recycle();
        Typeface typeface = this.l;
        if (typeface != null) {
            this.a.setTypeface(typeface, this.j);
        }
    }

    public void g(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        CharSequence charSequence;
        int i = Build.VERSION.SDK_INT;
        if (i < 30 && inputConnection != null) {
            CharSequence text = textView.getText();
            if (i >= 30) {
                editorInfo.setInitialSurroundingSubText(text, 0);
                return;
            }
            Objects.requireNonNull(text);
            if (i >= 30) {
                editorInfo.setInitialSurroundingSubText(text, 0);
                return;
            }
            int i2 = editorInfo.initialSelStart;
            int i3 = editorInfo.initialSelEnd;
            int i4 = i2 > i3 ? i3 + 0 : i2 + 0;
            int i5 = i2 > i3 ? i2 - 0 : i3 + 0;
            int length = text.length();
            if (i4 < 0 || i5 > length) {
                h0.i.i.h0.a.b(editorInfo, null, 0, 0);
                return;
            }
            int i6 = editorInfo.inputType & 4095;
            if (i6 == 129 || i6 == 225 || i6 == 18) {
                h0.i.i.h0.a.b(editorInfo, null, 0, 0);
            } else if (length <= 2048) {
                h0.i.i.h0.a.b(editorInfo, text, i4, i5);
            } else {
                int i7 = i5 - i4;
                int i8 = i7 > 1024 ? 0 : i7;
                int i9 = 2048 - i8;
                int min = Math.min(text.length() - i5, i9 - Math.min(i4, (int) (((double) i9) * 0.8d)));
                int min2 = Math.min(i4, i9 - min);
                int i10 = i4 - min2;
                if (h0.i.i.h0.a.a(text, i10, 0)) {
                    i10++;
                    min2--;
                }
                if (h0.i.i.h0.a.a(text, (i5 + min) - 1, 1)) {
                    min--;
                }
                int i11 = min2 + i8 + min;
                if (i8 != i7) {
                    charSequence = TextUtils.concat(text.subSequence(i10, i10 + min2), text.subSequence(i5, min + i5));
                } else {
                    charSequence = text.subSequence(i10, i11 + i10);
                }
                int i12 = min2 + 0;
                h0.i.i.h0.a.b(editorInfo, charSequence, i12, i8 + i12);
            }
        }
    }

    public void h(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        x xVar = this.i;
        if (xVar.i()) {
            DisplayMetrics displayMetrics = xVar.m.getResources().getDisplayMetrics();
            xVar.j(TypedValue.applyDimension(i4, (float) i, displayMetrics), TypedValue.applyDimension(i4, (float) i2, displayMetrics), TypedValue.applyDimension(i4, (float) i3, displayMetrics));
            if (xVar.g()) {
                xVar.a();
            }
        }
    }

    public void i(int[] iArr, int i) throws IllegalArgumentException {
        x xVar = this.i;
        if (xVar.i()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = xVar.m.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr2[i2] = Math.round(TypedValue.applyDimension(i, (float) iArr[i2], displayMetrics));
                    }
                }
                xVar.i = xVar.b(iArr2);
                if (!xVar.h()) {
                    StringBuilder P0 = i0.d.a.a.a.P0("None of the preset sizes is valid: ");
                    P0.append(Arrays.toString(iArr));
                    throw new IllegalArgumentException(P0.toString());
                }
            } else {
                xVar.j = false;
            }
            if (xVar.g()) {
                xVar.a();
            }
        }
    }

    public void j(int i) {
        x xVar = this.i;
        if (!xVar.i()) {
            return;
        }
        if (i == 0) {
            xVar.d = 0;
            xVar.g = -1.0f;
            xVar.h = -1.0f;
            xVar.f = -1.0f;
            xVar.i = new int[0];
            xVar.e = false;
        } else if (i == 1) {
            DisplayMetrics displayMetrics = xVar.m.getResources().getDisplayMetrics();
            xVar.j(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (xVar.g()) {
                xVar.a();
            }
        } else {
            throw new IllegalArgumentException(i0.d.a.a.a.e0("Unknown auto-size text type: ", i));
        }
    }

    public void k(ColorStateList colorStateList) {
        if (this.h == null) {
            this.h = new u0();
        }
        u0 u0Var = this.h;
        u0Var.a = colorStateList;
        u0Var.d = colorStateList != null;
        this.b = u0Var;
        this.c = u0Var;
        this.d = u0Var;
        this.e = u0Var;
        this.f = u0Var;
        this.g = u0Var;
    }

    public void l(PorterDuff.Mode mode) {
        if (this.h == null) {
            this.h = new u0();
        }
        u0 u0Var = this.h;
        u0Var.b = mode;
        u0Var.c = mode != null;
        this.b = u0Var;
        this.c = u0Var;
        this.d = u0Var;
        this.e = u0Var;
        this.f = u0Var;
        this.g = u0Var;
    }

    public final void m(Context context, w0 w0Var) {
        String m;
        this.j = w0Var.j(R.styleable.TextAppearance_android_textStyle, this.j);
        int i = Build.VERSION.SDK_INT;
        boolean z = false;
        if (i >= 28) {
            int j = w0Var.j(R.styleable.TextAppearance_android_textFontWeight, -1);
            this.k = j;
            if (j != -1) {
                this.j = (this.j & 2) | 0;
            }
        }
        int i2 = R.styleable.TextAppearance_android_fontFamily;
        if (w0Var.o(i2) || w0Var.o(R.styleable.TextAppearance_fontFamily)) {
            this.l = null;
            int i3 = R.styleable.TextAppearance_fontFamily;
            if (w0Var.o(i3)) {
                i2 = i3;
            }
            int i4 = this.k;
            int i5 = this.j;
            if (!context.isRestricted()) {
                try {
                    Typeface i6 = w0Var.i(i2, this.j, new a(i4, i5, new WeakReference(this.a)));
                    if (i6 != null) {
                        if (i < 28 || this.k == -1) {
                            this.l = i6;
                        } else {
                            this.l = Typeface.create(Typeface.create(i6, 0), this.k, (this.j & 2) != 0);
                        }
                    }
                    this.m = this.l == null;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.l == null && (m = w0Var.m(i2)) != null) {
                if (Build.VERSION.SDK_INT < 28 || this.k == -1) {
                    this.l = Typeface.create(m, this.j);
                    return;
                }
                Typeface create = Typeface.create(m, 0);
                int i7 = this.k;
                if ((this.j & 2) != 0) {
                    z = true;
                }
                this.l = Typeface.create(create, i7, z);
                return;
            }
            return;
        }
        int i8 = R.styleable.TextAppearance_android_typeface;
        if (w0Var.o(i8)) {
            this.m = false;
            int j2 = w0Var.j(i8, 1);
            if (j2 == 1) {
                this.l = Typeface.SANS_SERIF;
            } else if (j2 == 2) {
                this.l = Typeface.SERIF;
            } else if (j2 == 3) {
                this.l = Typeface.MONOSPACE;
            }
        }
    }
}
