package i0.j.e.b;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
/* compiled from: ControlButton.java */
/* loaded from: classes2.dex */
public class b {
    public int c;
    public PointF b = new PointF();
    public final Paint a = new Paint(1);

    public void a(float f, float f2) {
        this.b = new PointF(f, f2);
    }

    public void b(Canvas canvas) {
        this.a.setColor(this.c);
        this.a.setStyle(Paint.Style.FILL);
        PointF pointF = this.b;
        canvas.drawCircle(pointF.x, pointF.y, 12.0f, this.a);
        this.a.setColor(-1);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(2.0f);
        PointF pointF2 = this.b;
        canvas.drawCircle(pointF2.x, pointF2.y, 12.0f, this.a);
    }

    public boolean c(PointF pointF) {
        PointF pointF2 = this.b;
        float f = pointF2.x - pointF.x;
        float f2 = pointF2.y - pointF.y;
        return (f2 * f2) + (f * f) <= 1764.0f;
    }
}
