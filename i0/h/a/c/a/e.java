package i0.h.a.c.a;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;
/* compiled from: ImageMatrixProperty.java */
/* loaded from: classes2.dex */
public class e extends Property<ImageView, Matrix> {
    public final Matrix a = new Matrix();

    public e() {
        super(Matrix.class, "imageMatrixProperty");
    }

    @Override // android.util.Property
    public Matrix get(ImageView imageView) {
        this.a.set(imageView.getImageMatrix());
        return this.a;
    }

    @Override // android.util.Property
    public void set(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }
}
