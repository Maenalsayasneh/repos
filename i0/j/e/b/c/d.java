package i0.j.e.b.c;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
/* compiled from: Utility.java */
/* loaded from: classes2.dex */
public class d {
    public static final RectF a = new RectF(0.0f, 0.0f, 28.0f, 28.0f);

    public static Path a(Path path) {
        Path path2 = new Path(path);
        RectF rectF = new RectF();
        path2.computeBounds(rectF, true);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(rectF, a, Matrix.ScaleToFit.CENTER);
        path2.transform(matrix);
        return path2;
    }

    public static Path b(Path path, int i) {
        Path path2 = new Path(path);
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i, 14.0f, 14.0f);
        path2.transform(matrix);
        return a(path2);
    }
}
