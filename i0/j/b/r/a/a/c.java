package i0.j.b.r.a.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.PixelCopy;
/* compiled from: BitmapUtils.java */
/* loaded from: classes2.dex */
public final class c implements PixelCopy.OnPixelCopyFinishedListener {
    public final /* synthetic */ Canvas a;
    public final /* synthetic */ Bitmap b;
    public final /* synthetic */ int[] c;

    public c(Canvas canvas, Bitmap bitmap, int[] iArr) {
        this.a = canvas;
        this.b = bitmap;
        this.c = iArr;
    }

    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public void onPixelCopyFinished(int i) {
        if (i == 0) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
            paint.setDither(true);
            Canvas canvas = this.a;
            Bitmap bitmap = this.b;
            int[] iArr = this.c;
            canvas.drawBitmap(bitmap, (float) iArr[0], (float) iArr[1], paint);
        }
    }
}
