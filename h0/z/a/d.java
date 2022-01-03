package h0.z.a;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import h0.p.a.a.b;
import java.util.Objects;
/* compiled from: CircularProgressDrawable.java */
/* loaded from: classes.dex */
public class d extends Drawable implements Animatable {
    public static final Interpolator c = new LinearInterpolator();
    public static final Interpolator d = new b();
    public static final int[] q = {-16777216};
    public Resources Y1;
    public Animator Z1;
    public float a2;
    public boolean b2;
    public final a x;
    public float y;

    /* compiled from: CircularProgressDrawable.java */
    /* loaded from: classes.dex */
    public static class a {
        public final Paint b;
        public final Paint c;
        public final Paint d;
        public int[] i;
        public int j;
        public float k;
        public float l;
        public float m;
        public boolean n;
        public Path o;
        public float q;
        public int r;
        public int s;
        public int u;
        public final RectF a = new RectF();
        public float e = 0.0f;
        public float f = 0.0f;
        public float g = 0.0f;
        public float h = 5.0f;
        public float p = 1.0f;
        public int t = 255;

        public a() {
            Paint paint = new Paint();
            this.b = paint;
            Paint paint2 = new Paint();
            this.c = paint2;
            Paint paint3 = new Paint();
            this.d = paint3;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        public void a(int i) {
            this.j = i;
            this.u = this.i[i];
        }

        public void b(boolean z) {
            if (this.n != z) {
                this.n = z;
            }
        }
    }

    public d(Context context) {
        Objects.requireNonNull(context);
        this.Y1 = context.getResources();
        a aVar = new a();
        this.x = aVar;
        aVar.i = q;
        aVar.a(0);
        aVar.h = 2.5f;
        aVar.b.setStrokeWidth(2.5f);
        invalidateSelf();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new b(this, aVar));
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(c);
        ofFloat.addListener(new c(this, aVar));
        this.Z1 = ofFloat;
    }

    public void a(float f, a aVar, boolean z) {
        float f2;
        float f3;
        if (this.b2) {
            d(f, aVar);
            float floor = (float) (Math.floor((double) (aVar.m / 0.8f)) + 1.0d);
            float f4 = aVar.k;
            float f5 = aVar.l;
            aVar.e = (((f5 - 0.01f) - f4) * f) + f4;
            aVar.f = f5;
            float f6 = aVar.m;
            aVar.g = i0.d.a.a.a.a(floor, f6, f, f6);
        } else if (f != 1.0f || z) {
            float f7 = aVar.m;
            if (f < 0.5f) {
                f2 = aVar.k;
                f3 = (d.getInterpolation(f / 0.5f) * 0.79f) + 0.01f + f2;
            } else {
                float f8 = aVar.k + 0.79f;
                f2 = f8 - (((1.0f - d.getInterpolation((f - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                f3 = f8;
            }
            aVar.e = f2;
            aVar.f = f3;
            aVar.g = (0.20999998f * f) + f7;
            this.y = (f + this.a2) * 216.0f;
        }
    }

    public final void b(float f, float f2, float f3, float f4) {
        a aVar = this.x;
        float f5 = this.Y1.getDisplayMetrics().density;
        float f6 = f2 * f5;
        aVar.h = f6;
        aVar.b.setStrokeWidth(f6);
        aVar.q = f * f5;
        aVar.a(0);
        aVar.r = (int) (f3 * f5);
        aVar.s = (int) (f4 * f5);
    }

    public void c(int i) {
        if (i == 0) {
            b(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            b(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    public void d(float f, a aVar) {
        if (f > 0.75f) {
            float f2 = (f - 0.75f) / 0.25f;
            int[] iArr = aVar.i;
            int i = aVar.j;
            int i2 = iArr[i];
            int i3 = iArr[(i + 1) % iArr.length];
            int i4 = (i2 >> 24) & 255;
            int i5 = (i2 >> 16) & 255;
            int i6 = (i2 >> 8) & 255;
            int i7 = i2 & 255;
            aVar.u = ((i4 + ((int) (((float) (((i3 >> 24) & 255) - i4)) * f2))) << 24) | ((i5 + ((int) (((float) (((i3 >> 16) & 255) - i5)) * f2))) << 16) | ((i6 + ((int) (((float) (((i3 >> 8) & 255) - i6)) * f2))) << 8) | (i7 + ((int) (f2 * ((float) ((i3 & 255) - i7)))));
            return;
        }
        aVar.u = aVar.i[aVar.j];
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.y, bounds.exactCenterX(), bounds.exactCenterY());
        a aVar = this.x;
        RectF rectF = aVar.a;
        float f = aVar.q;
        float f2 = (aVar.h / 2.0f) + f;
        if (f <= 0.0f) {
            f2 = (((float) Math.min(bounds.width(), bounds.height())) / 2.0f) - Math.max((((float) aVar.r) * aVar.p) / 2.0f, aVar.h / 2.0f);
        }
        rectF.set(((float) bounds.centerX()) - f2, ((float) bounds.centerY()) - f2, ((float) bounds.centerX()) + f2, ((float) bounds.centerY()) + f2);
        float f3 = aVar.e;
        float f4 = aVar.g;
        float f5 = (f3 + f4) * 360.0f;
        float f6 = ((aVar.f + f4) * 360.0f) - f5;
        aVar.b.setColor(aVar.u);
        aVar.b.setAlpha(aVar.t);
        float f7 = aVar.h / 2.0f;
        rectF.inset(f7, f7);
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, aVar.d);
        float f8 = -f7;
        rectF.inset(f8, f8);
        canvas.drawArc(rectF, f5, f6, false, aVar.b);
        if (aVar.n) {
            Path path = aVar.o;
            if (path == null) {
                Path path2 = new Path();
                aVar.o = path2;
                path2.setFillType(Path.FillType.EVEN_ODD);
            } else {
                path.reset();
            }
            aVar.o.moveTo(0.0f, 0.0f);
            aVar.o.lineTo(((float) aVar.r) * aVar.p, 0.0f);
            Path path3 = aVar.o;
            float f9 = aVar.p;
            path3.lineTo((((float) aVar.r) * f9) / 2.0f, ((float) aVar.s) * f9);
            aVar.o.offset((rectF.centerX() + (Math.min(rectF.width(), rectF.height()) / 2.0f)) - ((((float) aVar.r) * aVar.p) / 2.0f), (aVar.h / 2.0f) + rectF.centerY());
            aVar.o.close();
            aVar.c.setColor(aVar.u);
            aVar.c.setAlpha(aVar.t);
            canvas.save();
            canvas.rotate(f5 + f6, rectF.centerX(), rectF.centerY());
            canvas.drawPath(aVar.o, aVar.c);
            canvas.restore();
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.x.t;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.Z1.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.x.t = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.x.b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.Z1.cancel();
        a aVar = this.x;
        float f = aVar.e;
        aVar.k = f;
        float f2 = aVar.f;
        aVar.l = f2;
        aVar.m = aVar.g;
        if (f2 != f) {
            this.b2 = true;
            this.Z1.setDuration(666);
            this.Z1.start();
            return;
        }
        aVar.a(0);
        a aVar2 = this.x;
        aVar2.k = 0.0f;
        aVar2.l = 0.0f;
        aVar2.m = 0.0f;
        aVar2.e = 0.0f;
        aVar2.f = 0.0f;
        aVar2.g = 0.0f;
        this.Z1.setDuration(1332);
        this.Z1.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.Z1.cancel();
        this.y = 0.0f;
        this.x.b(false);
        this.x.a(0);
        a aVar = this.x;
        aVar.k = 0.0f;
        aVar.l = 0.0f;
        aVar.m = 0.0f;
        aVar.e = 0.0f;
        aVar.f = 0.0f;
        aVar.g = 0.0f;
        invalidateSelf();
    }
}
