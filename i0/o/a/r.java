package i0.o.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
/* compiled from: PicassoDrawable.java */
/* loaded from: classes3.dex */
public final class r extends BitmapDrawable {
    public static final Paint a = new Paint();
    public final boolean b;
    public final float c;
    public final Picasso.LoadedFrom d;
    public Drawable e;
    public long f;
    public boolean g;
    public int h = 255;

    public r(Context context, Bitmap bitmap, Drawable drawable, Picasso.LoadedFrom loadedFrom, boolean z, boolean z2) {
        super(context.getResources(), bitmap);
        this.b = z2;
        this.c = context.getResources().getDisplayMetrics().density;
        this.d = loadedFrom;
        if (loadedFrom != Picasso.LoadedFrom.MEMORY && !z) {
            this.e = drawable;
            this.g = true;
            this.f = SystemClock.uptimeMillis();
        }
    }

    public static Path a(int i, int i2, int i3) {
        Path path = new Path();
        float f = (float) i;
        float f2 = (float) i2;
        path.moveTo(f, f2);
        path.lineTo((float) (i + i3), f2);
        path.lineTo(f, (float) (i2 + i3));
        return path;
    }

    public static void b(ImageView imageView, Context context, Bitmap bitmap, Picasso.LoadedFrom loadedFrom, boolean z, boolean z2) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
        imageView.setImageDrawable(new r(context, bitmap, drawable, loadedFrom, z, z2));
    }

    public static void c(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(null);
        if (imageView.getDrawable() instanceof Animatable) {
            ((Animatable) imageView.getDrawable()).start();
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.g) {
            super.draw(canvas);
        } else {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f)) / 200.0f;
            if (uptimeMillis >= 1.0f) {
                this.g = false;
                this.e = null;
                super.draw(canvas);
            } else {
                Drawable drawable = this.e;
                if (drawable != null) {
                    drawable.draw(canvas);
                }
                super.setAlpha((int) (((float) this.h) * uptimeMillis));
                super.draw(canvas);
                super.setAlpha(this.h);
            }
        }
        if (this.b) {
            Paint paint = a;
            paint.setColor(-1);
            canvas.drawPath(a(0, 0, (int) (this.c * 16.0f)), paint);
            paint.setColor(this.d.debugColor);
            canvas.drawPath(a(0, 0, (int) (this.c * 15.0f)), paint);
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.h = i;
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
        super.setAlpha(i);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }
}
