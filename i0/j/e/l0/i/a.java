package i0.j.e.l0.i;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.TypedValue;
import android.widget.TextView;
/* compiled from: BubbleTextView.java */
/* loaded from: classes2.dex */
public class a extends TextView {
    public float a2;
    public Paint d;
    public float q;
    public RectF c = new RectF();
    public PointF x = new PointF();
    public PointF y = new PointF();
    public PointF Y1 = new PointF();
    public Path Z1 = new Path();

    public a(Context context) {
        super(context);
        setTextColor(-1);
        Paint paint = new Paint(1);
        this.d = paint;
        paint.setColor(-12303292);
        this.d.setStyle(Paint.Style.FILL);
        float applyDimension = TypedValue.applyDimension(1, 7.0f, getContext().getResources().getDisplayMetrics());
        this.q = applyDimension;
        this.a2 = applyDimension / 2.0f;
        int i = (int) applyDimension;
        double d = (double) applyDimension;
        double d2 = 1.5d * d;
        setPadding((int) d2, i, (int) (d2 + d), i);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF = this.c;
        float f = this.a2;
        canvas.drawRoundRect(rectF, f, f, this.d);
        canvas.drawPath(this.Z1, this.d);
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        setMeasuredDimension(measuredWidth, measuredHeight);
        RectF rectF = this.c;
        float f = (float) measuredWidth;
        rectF.right = f - this.q;
        rectF.bottom = (float) measuredHeight;
        PointF pointF = this.x;
        pointF.x = f;
        pointF.y = rectF.centerY();
        float cos = (float) (((double) this.q) / Math.cos(45.0d));
        i0.j.c.l.a.s(cos, 225.0f, this.x, this.y);
        i0.j.c.l.a.s(cos, 135.0f, this.x, this.Y1);
        Path path = this.Z1;
        PointF pointF2 = this.y;
        path.moveTo(pointF2.x, pointF2.y);
        Path path2 = this.Z1;
        PointF pointF3 = this.x;
        path2.lineTo(pointF3.x, pointF3.y);
        Path path3 = this.Z1;
        PointF pointF4 = this.Y1;
        path3.lineTo(pointF4.x, pointF4.y);
        this.Z1.close();
    }
}
