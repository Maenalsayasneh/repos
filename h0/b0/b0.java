package h0.b0;

import android.graphics.Matrix;
import android.view.View;
/* compiled from: ViewUtilsApi29.java */
/* loaded from: classes.dex */
public class b0 extends a0 {
    @Override // h0.b0.x, h0.b0.c0
    public float b(View view) {
        return view.getTransitionAlpha();
    }

    @Override // h0.b0.z, h0.b0.c0
    public void d(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    @Override // h0.b0.x, h0.b0.c0
    public void e(View view, float f) {
        view.setTransitionAlpha(f);
    }

    @Override // h0.b0.a0, h0.b0.c0
    public void f(View view, int i) {
        view.setTransitionVisibility(i);
    }

    @Override // h0.b0.y, h0.b0.c0
    public void g(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // h0.b0.y, h0.b0.c0
    public void h(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
