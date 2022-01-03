package com.instabug.library.util;

import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes2.dex */
public class DrawableUtils {

    /* loaded from: classes2.dex */
    public static class a extends LayerDrawable {
        public final /* synthetic */ float c;
        public final /* synthetic */ Drawable d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Drawable[] drawableArr, float f, Drawable drawable) {
            super(drawableArr);
            this.c = f;
            this.d = drawable;
        }

        @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            canvas.save();
            canvas.rotate(this.c, ((float) this.d.getBounds().width()) / 2.0f, ((float) this.d.getBounds().height()) / 2.0f);
            super.draw(canvas);
            canvas.restore();
        }
    }

    public static Drawable getRotateDrawable(Drawable drawable, float f) {
        return new a(new Drawable[]{drawable}, f, drawable);
    }

    public static void setColor(View view, int i) {
        Drawable background = view.getBackground();
        if (background instanceof ShapeDrawable) {
            ((ShapeDrawable) background).getPaint().setColor(i);
        } else if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(i);
        } else if (background instanceof ColorDrawable) {
            ((ColorDrawable) background).setColor(i);
        }
    }

    public static void setDrawableTintColor(ImageView imageView, int i) {
        imageView.setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
    }
}
