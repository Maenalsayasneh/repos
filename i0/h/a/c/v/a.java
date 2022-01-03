package i0.h.a.c.v;

import android.graphics.Paint;
import android.graphics.Path;
/* compiled from: ShadowRenderer.java */
/* loaded from: classes2.dex */
public class a {
    public static final int[] a = new int[3];
    public static final float[] b = {0.0f, 0.5f, 1.0f};
    public static final int[] c = new int[4];
    public static final float[] d = {0.0f, 0.0f, 0.5f, 1.0f};
    public final Paint f;
    public final Paint g;
    public int h;
    public int i;
    public int j;
    public final Path k = new Path();
    public Paint l = new Paint();
    public final Paint e = new Paint();

    public a() {
        a(-16777216);
        this.l.setColor(0);
        Paint paint = new Paint(4);
        this.f = paint;
        paint.setStyle(Paint.Style.FILL);
        this.g = new Paint(paint);
    }

    public void a(int i) {
        this.h = h0.i.c.a.c(i, 68);
        this.i = h0.i.c.a.c(i, 20);
        this.j = h0.i.c.a.c(i, 0);
        this.e.setColor(this.h);
    }
}
