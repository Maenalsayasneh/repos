package i0.h.a.c.w;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/* compiled from: ShapePath.java */
/* loaded from: classes2.dex */
public class n {
    @Deprecated
    public float a;
    @Deprecated
    public float b;
    @Deprecated
    public float c;
    @Deprecated
    public float d;
    @Deprecated
    public float e;
    @Deprecated
    public float f;
    public final List<e> g = new ArrayList();
    public final List<f> h = new ArrayList();

    /* compiled from: ShapePath.java */
    /* loaded from: classes2.dex */
    public static class a extends f {
        public final c b;

        public a(c cVar) {
            this.b = cVar;
        }

        @Override // i0.h.a.c.w.n.f
        public void a(Matrix matrix, i0.h.a.c.v.a aVar, int i, Canvas canvas) {
            c cVar = this.b;
            float f = cVar.g;
            float f2 = cVar.h;
            c cVar2 = this.b;
            RectF rectF = new RectF(cVar2.c, cVar2.d, cVar2.e, cVar2.f);
            boolean z = f2 < 0.0f;
            Path path = aVar.k;
            if (z) {
                int[] iArr = i0.h.a.c.v.a.c;
                iArr[0] = 0;
                iArr[1] = aVar.j;
                iArr[2] = aVar.i;
                iArr[3] = aVar.h;
            } else {
                path.rewind();
                path.moveTo(rectF.centerX(), rectF.centerY());
                path.arcTo(rectF, f, f2);
                path.close();
                float f3 = (float) (-i);
                rectF.inset(f3, f3);
                int[] iArr2 = i0.h.a.c.v.a.c;
                iArr2[0] = 0;
                iArr2[1] = aVar.h;
                iArr2[2] = aVar.i;
                iArr2[3] = aVar.j;
            }
            float width = rectF.width() / 2.0f;
            if (width > 0.0f) {
                float f4 = 1.0f - (((float) i) / width);
                float[] fArr = i0.h.a.c.v.a.d;
                fArr[1] = f4;
                fArr[2] = ((1.0f - f4) / 2.0f) + f4;
                aVar.f.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, i0.h.a.c.v.a.c, fArr, Shader.TileMode.CLAMP));
                canvas.save();
                canvas.concat(matrix);
                if (!z) {
                    canvas.clipPath(path, Region.Op.DIFFERENCE);
                    canvas.drawPath(path, aVar.l);
                }
                canvas.drawArc(rectF, f, f2, true, aVar.f);
                canvas.restore();
            }
        }
    }

    /* compiled from: ShapePath.java */
    /* loaded from: classes2.dex */
    public static class b extends f {
        public final d b;
        public final float c;
        public final float d;

        public b(d dVar, float f, float f2) {
            this.b = dVar;
            this.c = f;
            this.d = f2;
        }

        @Override // i0.h.a.c.w.n.f
        public void a(Matrix matrix, i0.h.a.c.v.a aVar, int i, Canvas canvas) {
            d dVar = this.b;
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot((double) (dVar.c - this.d), (double) (dVar.b - this.c)), 0.0f);
            Matrix matrix2 = new Matrix(matrix);
            matrix2.preTranslate(this.c, this.d);
            matrix2.preRotate(b());
            Objects.requireNonNull(aVar);
            rectF.bottom += (float) i;
            rectF.offset(0.0f, (float) (-i));
            int[] iArr = i0.h.a.c.v.a.a;
            iArr[0] = aVar.j;
            iArr[1] = aVar.i;
            iArr[2] = aVar.h;
            Paint paint = aVar.g;
            float f = rectF.left;
            paint.setShader(new LinearGradient(f, rectF.top, f, rectF.bottom, iArr, i0.h.a.c.v.a.b, Shader.TileMode.CLAMP));
            canvas.save();
            canvas.concat(matrix2);
            canvas.drawRect(rectF, aVar.g);
            canvas.restore();
        }

        public float b() {
            d dVar = this.b;
            return (float) Math.toDegrees(Math.atan((double) ((dVar.c - this.d) / (dVar.b - this.c))));
        }
    }

    /* compiled from: ShapePath.java */
    /* loaded from: classes2.dex */
    public static class c extends e {
        public static final RectF b = new RectF();
        @Deprecated
        public float c;
        @Deprecated
        public float d;
        @Deprecated
        public float e;
        @Deprecated
        public float f;
        @Deprecated
        public float g;
        @Deprecated
        public float h;

        public c(float f, float f2, float f3, float f4) {
            this.c = f;
            this.d = f2;
            this.e = f3;
            this.f = f4;
        }

        @Override // i0.h.a.c.w.n.e
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = b;
            rectF.set(this.c, this.d, this.e, this.f);
            path.arcTo(rectF, this.g, this.h, false);
            path.transform(matrix);
        }
    }

    /* compiled from: ShapePath.java */
    /* loaded from: classes2.dex */
    public static class d extends e {
        public float b;
        public float c;

        @Override // i0.h.a.c.w.n.e
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.b, this.c);
            path.transform(matrix);
        }
    }

    /* compiled from: ShapePath.java */
    /* loaded from: classes2.dex */
    public static abstract class e {
        public final Matrix a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    /* compiled from: ShapePath.java */
    /* loaded from: classes2.dex */
    public static abstract class f {
        public static final Matrix a = new Matrix();

        public abstract void a(Matrix matrix, i0.h.a.c.v.a aVar, int i, Canvas canvas);
    }

    public n() {
        e(0.0f, 0.0f, 270.0f, 0.0f);
    }

    public void a(float f2, float f3, float f4, float f5, float f6, float f7) {
        c cVar = new c(f2, f3, f4, f5);
        cVar.g = f6;
        cVar.h = f7;
        this.g.add(cVar);
        a aVar = new a(cVar);
        float f8 = f6 + f7;
        boolean z = f7 < 0.0f;
        if (z) {
            f6 = (f6 + 180.0f) % 360.0f;
        }
        float f9 = z ? (180.0f + f8) % 360.0f : f8;
        b(f6);
        this.h.add(aVar);
        this.e = f9;
        double d2 = (double) f8;
        this.c = (((f4 - f2) / 2.0f) * ((float) Math.cos(Math.toRadians(d2)))) + ((f2 + f4) * 0.5f);
        this.d = (((f5 - f3) / 2.0f) * ((float) Math.sin(Math.toRadians(d2)))) + ((f3 + f5) * 0.5f);
    }

    public final void b(float f2) {
        float f3 = this.e;
        if (f3 != f2) {
            float f4 = ((f2 - f3) + 360.0f) % 360.0f;
            if (f4 <= 180.0f) {
                float f5 = this.c;
                float f6 = this.d;
                c cVar = new c(f5, f6, f5, f6);
                cVar.g = this.e;
                cVar.h = f4;
                this.h.add(new a(cVar));
                this.e = f2;
            }
        }
    }

    public void c(Matrix matrix, Path path) {
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            this.g.get(i).a(matrix, path);
        }
    }

    public void d(float f2, float f3) {
        d dVar = new d();
        dVar.b = f2;
        dVar.c = f3;
        this.g.add(dVar);
        b bVar = new b(dVar, this.c, this.d);
        b(bVar.b() + 270.0f);
        this.h.add(bVar);
        this.e = bVar.b() + 270.0f;
        this.c = f2;
        this.d = f3;
    }

    public void e(float f2, float f3, float f4, float f5) {
        this.a = f2;
        this.b = f3;
        this.c = f2;
        this.d = f3;
        this.e = f4;
        this.f = (f4 + f5) % 360.0f;
        this.g.clear();
        this.h.clear();
    }
}
