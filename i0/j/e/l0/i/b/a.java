package i0.j.e.l0.i.b;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
/* compiled from: FloatingActionButton.java */
/* loaded from: classes2.dex */
public class a extends ShapeDrawable.ShaderFactory {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;

    public a(int i, int i2, int i3, int i4, int i5) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
    }

    @Override // android.graphics.drawable.ShapeDrawable.ShaderFactory
    public Shader resize(int i, int i2) {
        float f = ((float) i) / 2.0f;
        return new LinearGradient(f, 0.0f, f, (float) i2, new int[]{this.a, this.b, this.c, this.d, this.e}, new float[]{0.0f, 0.2f, 0.5f, 0.8f, 1.0f}, Shader.TileMode.CLAMP);
    }
}
