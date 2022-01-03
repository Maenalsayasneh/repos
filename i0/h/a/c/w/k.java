package i0.h.a.c.w;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.google.android.material.R;
import java.util.Objects;
/* compiled from: ShapeAppearanceModel.java */
/* loaded from: classes2.dex */
public class k {
    public static final c a = new i(0.5f);
    public d b;
    public d c;
    public d d;
    public d e;
    public c f;
    public c g;
    public c h;
    public c i;
    public f j;
    public f k;
    public f l;
    public f m;

    public k(b bVar, a aVar) {
        this.b = bVar.a;
        this.c = bVar.b;
        this.d = bVar.c;
        this.e = bVar.d;
        this.f = bVar.e;
        this.g = bVar.f;
        this.h = bVar.g;
        this.i = bVar.h;
        this.j = bVar.i;
        this.k = bVar.j;
        this.l = bVar.k;
        this.m = bVar.l;
    }

    public static b a(Context context, int i, int i2, c cVar) {
        if (i2 != 0) {
            context = new ContextThemeWrapper(context, i);
            i = i2;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.ShapeAppearance);
        try {
            int i3 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamily, 0);
            int i4 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopLeft, i3);
            int i5 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopRight, i3);
            int i6 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomRight, i3);
            int i7 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomLeft, i3);
            c c = c(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSize, cVar);
            c c2 = c(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopLeft, c);
            c c3 = c(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopRight, c);
            c c4 = c(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomRight, c);
            c c5 = c(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomLeft, c);
            b bVar = new b();
            d z = i0.h.a.b.c.m.b.z(i4);
            bVar.a = z;
            b.b(z);
            bVar.e = c2;
            d z2 = i0.h.a.b.c.m.b.z(i5);
            bVar.b = z2;
            b.b(z2);
            bVar.f = c3;
            d z3 = i0.h.a.b.c.m.b.z(i6);
            bVar.c = z3;
            b.b(z3);
            bVar.g = c4;
            d z4 = i0.h.a.b.c.m.b.z(i7);
            bVar.d = z4;
            b.b(z4);
            bVar.h = c5;
            return bVar;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static b b(Context context, AttributeSet attributeSet, int i, int i2, c cVar) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialShape, i, i2);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearanceOverlay, 0);
        obtainStyledAttributes.recycle();
        return a(context, resourceId, resourceId2, cVar);
    }

    public static c c(TypedArray typedArray, int i, c cVar) {
        TypedValue peekValue = typedArray.peekValue(i);
        if (peekValue == null) {
            return cVar;
        }
        int i2 = peekValue.type;
        if (i2 == 5) {
            return new a((float) TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        return i2 == 6 ? new i(peekValue.getFraction(1.0f, 1.0f)) : cVar;
    }

    public boolean d(RectF rectF) {
        boolean z = this.m.getClass().equals(f.class) && this.k.getClass().equals(f.class) && this.j.getClass().equals(f.class) && this.l.getClass().equals(f.class);
        float a2 = this.f.a(rectF);
        return z && ((this.g.a(rectF) > a2 ? 1 : (this.g.a(rectF) == a2 ? 0 : -1)) == 0 && (this.i.a(rectF) > a2 ? 1 : (this.i.a(rectF) == a2 ? 0 : -1)) == 0 && (this.h.a(rectF) > a2 ? 1 : (this.h.a(rectF) == a2 ? 0 : -1)) == 0) && ((this.c instanceof j) && (this.b instanceof j) && (this.d instanceof j) && (this.e instanceof j));
    }

    public k e(float f) {
        b bVar = new b(this);
        bVar.c(f);
        return bVar.a();
    }

    /* compiled from: ShapeAppearanceModel.java */
    /* loaded from: classes2.dex */
    public static final class b {
        public d a;
        public d b;
        public d c;
        public d d;
        public c e;
        public c f;
        public c g;
        public c h;
        public f i;
        public f j;
        public f k;
        public f l;

        public b() {
            this.a = new j();
            this.b = new j();
            this.c = new j();
            this.d = new j();
            this.e = new a(0.0f);
            this.f = new a(0.0f);
            this.g = new a(0.0f);
            this.h = new a(0.0f);
            this.i = new f();
            this.j = new f();
            this.k = new f();
            this.l = new f();
        }

        public static float b(d dVar) {
            if (dVar instanceof j) {
                Objects.requireNonNull((j) dVar);
                return -1.0f;
            }
            if (dVar instanceof e) {
                Objects.requireNonNull((e) dVar);
            }
            return -1.0f;
        }

        public k a() {
            return new k(this, null);
        }

        public b c(float f) {
            this.e = new a(f);
            this.f = new a(f);
            this.g = new a(f);
            this.h = new a(f);
            return this;
        }

        public b d(float f) {
            this.h = new a(f);
            return this;
        }

        public b e(float f) {
            this.g = new a(f);
            return this;
        }

        public b f(float f) {
            this.e = new a(f);
            return this;
        }

        public b g(float f) {
            this.f = new a(f);
            return this;
        }

        public b(k kVar) {
            this.a = new j();
            this.b = new j();
            this.c = new j();
            this.d = new j();
            this.e = new a(0.0f);
            this.f = new a(0.0f);
            this.g = new a(0.0f);
            this.h = new a(0.0f);
            this.i = new f();
            this.j = new f();
            this.k = new f();
            this.l = new f();
            this.a = kVar.b;
            this.b = kVar.c;
            this.c = kVar.d;
            this.d = kVar.e;
            this.e = kVar.f;
            this.f = kVar.g;
            this.g = kVar.h;
            this.h = kVar.i;
            this.i = kVar.j;
            this.j = kVar.k;
            this.k = kVar.l;
            this.l = kVar.m;
        }
    }

    public k() {
        this.b = new j();
        this.c = new j();
        this.d = new j();
        this.e = new j();
        this.f = new a(0.0f);
        this.g = new a(0.0f);
        this.h = new a(0.0f);
        this.i = new a(0.0f);
        this.j = new f();
        this.k = new f();
        this.l = new f();
        this.m = new f();
    }
}
