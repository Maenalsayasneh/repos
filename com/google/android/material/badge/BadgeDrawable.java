package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.material.R;
import h0.i.i.q;
import i0.d.a.a.a;
import i0.h.a.c.q.h;
import i0.h.a.c.q.j;
import i0.h.a.c.t.b;
import i0.h.a.c.w.g;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import java.util.concurrent.atomic.AtomicInteger;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes2.dex */
public class BadgeDrawable extends Drawable implements h.b {
    private static final int BADGE_NUMBER_NONE = -1;
    private static final int DEFAULT_MAX_BADGE_CHARACTER_COUNT = 4;
    private static final int DEFAULT_STYLE = R.style.Widget_MaterialComponents_Badge;
    private static final int DEFAULT_THEME_ATTR = R.attr.badgeStyle;
    private static final int MAX_CIRCULAR_BADGE_NUMBER_COUNT = 9;
    public float Y1;
    public WeakReference<View> Z1;
    public WeakReference<FrameLayout> a2;
    private final float badgeRadius;
    private final float badgeWidePadding;
    private final float badgeWithTextRadius;
    public float c;
    private final WeakReference<Context> contextRef;
    public float d;
    public int q;
    private final SavedState savedState;
    private final h textDrawableHelper;
    public float x;
    public float y;
    private final Rect badgeBounds = new Rect();
    private final g shapeDrawable = new g();

    public BadgeDrawable(Context context) {
        b bVar;
        Context context2;
        WeakReference<Context> weakReference = new WeakReference<>(context);
        this.contextRef = weakReference;
        j.c(context, j.b, "Theme.MaterialComponents");
        Resources resources = context.getResources();
        this.badgeRadius = (float) resources.getDimensionPixelSize(R.dimen.mtrl_badge_radius);
        this.badgeWidePadding = (float) resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding);
        this.badgeWithTextRadius = (float) resources.getDimensionPixelSize(R.dimen.mtrl_badge_with_text_radius);
        h hVar = new h(this);
        this.textDrawableHelper = hVar;
        hVar.a.setTextAlign(Paint.Align.CENTER);
        this.savedState = new SavedState(context);
        int i = R.style.TextAppearance_MaterialComponents_Badge;
        Context context3 = weakReference.get();
        if (context3 != null && hVar.f != (bVar = new b(context3, i)) && (context2 = weakReference.get()) != null) {
            hVar.b(bVar, context2);
            n();
        }
    }

    public static BadgeDrawable b(Context context) {
        return c(context, null, DEFAULT_THEME_ATTR, DEFAULT_STYLE);
    }

    public static BadgeDrawable c(Context context, AttributeSet attributeSet, int i, int i2) {
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        int[] iArr = R.styleable.Badge;
        j.a(context, attributeSet, i, i2);
        j.b(context, attributeSet, iArr, i, i2, new int[0]);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, i2);
        int i3 = obtainStyledAttributes.getInt(R.styleable.Badge_maxCharacterCount, 4);
        SavedState savedState = badgeDrawable.savedState;
        if (savedState.y != i3) {
            savedState.y = i3;
            badgeDrawable.q = ((int) Math.pow(10.0d, ((double) i3) - 1.0d)) - 1;
            badgeDrawable.textDrawableHelper.d = true;
            badgeDrawable.n();
            badgeDrawable.invalidateSelf();
        }
        int i4 = R.styleable.Badge_number;
        if (obtainStyledAttributes.hasValue(i4)) {
            badgeDrawable.k(obtainStyledAttributes.getInt(i4, 0));
        }
        badgeDrawable.j(i0.h.a.b.c.m.b.M(context, obtainStyledAttributes, R.styleable.Badge_backgroundColor).getDefaultColor());
        int i5 = R.styleable.Badge_badgeTextColor;
        if (obtainStyledAttributes.hasValue(i5)) {
            int defaultColor = i0.h.a.b.c.m.b.M(context, obtainStyledAttributes, i5).getDefaultColor();
            badgeDrawable.savedState.d = defaultColor;
            if (badgeDrawable.textDrawableHelper.a.getColor() != defaultColor) {
                badgeDrawable.textDrawableHelper.a.setColor(defaultColor);
                badgeDrawable.invalidateSelf();
            }
        }
        int i6 = obtainStyledAttributes.getInt(R.styleable.Badge_badgeGravity, 8388661);
        SavedState savedState2 = badgeDrawable.savedState;
        if (savedState2.b2 != i6) {
            savedState2.b2 = i6;
            WeakReference<View> weakReference = badgeDrawable.Z1;
            if (!(weakReference == null || weakReference.get() == null)) {
                View view = badgeDrawable.Z1.get();
                WeakReference<FrameLayout> weakReference2 = badgeDrawable.a2;
                badgeDrawable.m(view, weakReference2 != null ? weakReference2.get() : null);
            }
        }
        badgeDrawable.savedState.d2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Badge_horizontalOffset, 0);
        badgeDrawable.n();
        badgeDrawable.savedState.e2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Badge_verticalOffset, 0);
        badgeDrawable.n();
        obtainStyledAttributes.recycle();
        return badgeDrawable;
    }

    public static BadgeDrawable d(Context context, int i) {
        int next;
        try {
            XmlResourceParser xml = context.getResources().getXml(i);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next != 2) {
                throw new XmlPullParserException("No start tag found");
            } else if (TextUtils.equals(xml.getName(), "badge")) {
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                int styleAttribute = asAttributeSet.getStyleAttribute();
                if (styleAttribute == 0) {
                    styleAttribute = DEFAULT_STYLE;
                }
                return c(context, asAttributeSet, DEFAULT_THEME_ATTR, styleAttribute);
            } else {
                throw new XmlPullParserException("Must have a <badge> start tag");
            }
        } catch (IOException | XmlPullParserException e) {
            Resources.NotFoundException notFoundException = new Resources.NotFoundException(a.R(i, a.P0("Can't load badge resource ID #0x")));
            notFoundException.initCause(e);
            throw notFoundException;
        }
    }

    @Override // i0.h.a.c.q.h.b
    public void a() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!getBounds().isEmpty() && getAlpha() != 0 && isVisible()) {
            this.shapeDrawable.draw(canvas);
            if (i()) {
                Rect rect = new Rect();
                String e = e();
                this.textDrawableHelper.a.getTextBounds(e, 0, e.length(), rect);
                canvas.drawText(e, this.c, this.d + ((float) (rect.height() / 2)), this.textDrawableHelper.a);
            }
        }
    }

    public final String e() {
        if (h() <= this.q) {
            return NumberFormat.getInstance().format((long) h());
        }
        Context context = this.contextRef.get();
        if (context == null) {
            return "";
        }
        return context.getString(R.string.mtrl_exceed_max_badge_number_suffix, Integer.valueOf(this.q), "+");
    }

    public CharSequence f() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        if (!i()) {
            return this.savedState.Y1;
        }
        if (this.savedState.Z1 <= 0 || (context = this.contextRef.get()) == null) {
            return null;
        }
        int h = h();
        int i = this.q;
        if (h <= i) {
            return context.getResources().getQuantityString(this.savedState.Z1, h(), Integer.valueOf(h()));
        }
        return context.getString(this.savedState.a2, Integer.valueOf(i));
    }

    public FrameLayout g() {
        WeakReference<FrameLayout> weakReference = this.a2;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.savedState.q;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.badgeBounds.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.badgeBounds.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public int h() {
        if (!i()) {
            return 0;
        }
        return this.savedState.x;
    }

    public boolean i() {
        return this.savedState.x != -1;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    public void j(int i) {
        this.savedState.c = i;
        ColorStateList valueOf = ColorStateList.valueOf(i);
        g gVar = this.shapeDrawable;
        if (gVar.q.d != valueOf) {
            gVar.t(valueOf);
            invalidateSelf();
        }
    }

    public void k(int i) {
        int max = Math.max(0, i);
        SavedState savedState = this.savedState;
        if (savedState.x != max) {
            savedState.x = max;
            this.textDrawableHelper.d = true;
            n();
            invalidateSelf();
        }
    }

    public void l(boolean z) {
        setVisible(z, false);
        this.savedState.c2 = z;
    }

    public void m(View view, FrameLayout frameLayout) {
        this.Z1 = new WeakReference<>(view);
        this.a2 = new WeakReference<>(frameLayout);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
        n();
        invalidateSelf();
    }

    public final void n() {
        float f;
        float f2;
        Context context = this.contextRef.get();
        WeakReference<View> weakReference = this.Z1;
        FrameLayout frameLayout = null;
        View view = weakReference != null ? weakReference.get() : null;
        if (context != null && view != null) {
            Rect rect = new Rect();
            rect.set(this.badgeBounds);
            Rect rect2 = new Rect();
            view.getDrawingRect(rect2);
            WeakReference<FrameLayout> weakReference2 = this.a2;
            if (weakReference2 != null) {
                frameLayout = weakReference2.get();
            }
            if (frameLayout != null) {
                if (frameLayout == null) {
                    frameLayout = (ViewGroup) view.getParent();
                }
                frameLayout.offsetDescendantRectToMyCoords(view, rect2);
            }
            SavedState savedState = this.savedState;
            int i = savedState.b2;
            if (i == 8388691 || i == 8388693) {
                this.d = (float) (rect2.bottom - savedState.e2);
            } else {
                this.d = (float) (rect2.top + savedState.e2);
            }
            if (h() <= 9) {
                float f3 = !i() ? this.badgeRadius : this.badgeWithTextRadius;
                this.x = f3;
                this.Y1 = f3;
                this.y = f3;
            } else {
                float f4 = this.badgeWithTextRadius;
                this.x = f4;
                this.Y1 = f4;
                this.y = (this.textDrawableHelper.a(e()) / 2.0f) + this.badgeWidePadding;
            }
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i() ? R.dimen.mtrl_badge_text_horizontal_edge_offset : R.dimen.mtrl_badge_horizontal_edge_offset);
            int i2 = this.savedState.b2;
            if (i2 == 8388659 || i2 == 8388691) {
                AtomicInteger atomicInteger = q.a;
                if (view.getLayoutDirection() == 0) {
                    f = (((float) rect2.left) - this.y) + ((float) dimensionPixelSize) + ((float) this.savedState.d2);
                } else {
                    f = ((((float) rect2.right) + this.y) - ((float) dimensionPixelSize)) - ((float) this.savedState.d2);
                }
                this.c = f;
            } else {
                AtomicInteger atomicInteger2 = q.a;
                if (view.getLayoutDirection() == 0) {
                    f2 = ((((float) rect2.right) + this.y) - ((float) dimensionPixelSize)) - ((float) this.savedState.d2);
                } else {
                    f2 = (((float) rect2.left) - this.y) + ((float) dimensionPixelSize) + ((float) this.savedState.d2);
                }
                this.c = f2;
            }
            Rect rect3 = this.badgeBounds;
            float f5 = this.c;
            float f6 = this.d;
            float f7 = this.y;
            float f8 = this.Y1;
            rect3.set((int) (f5 - f7), (int) (f6 - f8), (int) (f5 + f7), (int) (f6 + f8));
            g gVar = this.shapeDrawable;
            gVar.q.a = gVar.q.a.e(this.x);
            gVar.invalidateSelf();
            if (!rect.equals(this.badgeBounds)) {
                this.shapeDrawable.setBounds(this.badgeBounds);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable, i0.h.a.c.q.h.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.savedState.q = i;
        this.textDrawableHelper.a.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    /* loaded from: classes2.dex */
    public static final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public CharSequence Y1;
        public int Z1;
        public int a2;
        public int b2;
        public int c;
        public boolean c2;
        public int d;
        public int d2;
        public int e2;
        public int q;
        public int x;
        public int y;

        /* loaded from: classes2.dex */
        public static class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Context context) {
            this.q = 255;
            this.x = -1;
            int i = R.style.TextAppearance_MaterialComponents_Badge;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.TextAppearance);
            obtainStyledAttributes.getDimension(R.styleable.TextAppearance_android_textSize, 0.0f);
            ColorStateList M = i0.h.a.b.c.m.b.M(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColor);
            i0.h.a.b.c.m.b.M(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorHint);
            i0.h.a.b.c.m.b.M(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorLink);
            obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_textStyle, 0);
            obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_typeface, 1);
            int i2 = R.styleable.TextAppearance_fontFamily;
            i2 = !obtainStyledAttributes.hasValue(i2) ? R.styleable.TextAppearance_android_fontFamily : i2;
            obtainStyledAttributes.getResourceId(i2, 0);
            obtainStyledAttributes.getString(i2);
            obtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
            i0.h.a.b.c.m.b.M(context, obtainStyledAttributes, R.styleable.TextAppearance_android_shadowColor);
            obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
            obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
            obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
            obtainStyledAttributes.recycle();
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i, R.styleable.MaterialTextAppearance);
            int i3 = R.styleable.MaterialTextAppearance_android_letterSpacing;
            obtainStyledAttributes2.hasValue(i3);
            obtainStyledAttributes2.getFloat(i3, 0.0f);
            obtainStyledAttributes2.recycle();
            this.d = M.getDefaultColor();
            this.Y1 = context.getString(R.string.mtrl_badge_numberless_content_description);
            this.Z1 = R.plurals.mtrl_badge_content_description;
            this.a2 = R.string.mtrl_exceed_max_badge_number_content_description;
            this.c2 = true;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.q);
            parcel.writeInt(this.x);
            parcel.writeInt(this.y);
            parcel.writeString(this.Y1.toString());
            parcel.writeInt(this.Z1);
            parcel.writeInt(this.b2);
            parcel.writeInt(this.d2);
            parcel.writeInt(this.e2);
            parcel.writeInt(this.c2 ? 1 : 0);
        }

        public SavedState(Parcel parcel) {
            this.q = 255;
            this.x = -1;
            this.c = parcel.readInt();
            this.d = parcel.readInt();
            this.q = parcel.readInt();
            this.x = parcel.readInt();
            this.y = parcel.readInt();
            this.Y1 = parcel.readString();
            this.Z1 = parcel.readInt();
            this.b2 = parcel.readInt();
            this.d2 = parcel.readInt();
            this.e2 = parcel.readInt();
            this.c2 = parcel.readInt() != 0;
        }
    }
}
