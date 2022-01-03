package h0.g.b.b;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;
import org.xmlpull.v1.XmlPullParser;
/* compiled from: TouchResponse.java */
/* loaded from: classes.dex */
public class u {
    public static final float[][] a = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
    public static final float[][] b = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    public float A;
    public float B;
    public float C;
    public float D;
    public int E;
    public int F;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public float i;
    public float j;
    public int k;
    public boolean l;
    public float m;
    public float n;
    public boolean o = false;
    public float[] p = new float[2];
    public int[] q = new int[2];
    public float r;
    public float s;
    public final MotionLayout t;
    public float u;
    public float v;
    public boolean w;
    public float x;
    public int y;
    public float z;

    public u(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = 0.5f;
        this.j = 0.5f;
        this.k = -1;
        this.l = false;
        this.m = 0.0f;
        this.n = 1.0f;
        this.u = 4.0f;
        this.v = 1.2f;
        this.w = true;
        this.x = 1.0f;
        this.y = 0;
        this.z = 10.0f;
        this.A = 10.0f;
        this.B = 1.0f;
        this.C = Float.NaN;
        this.D = Float.NaN;
        this.E = 0;
        this.F = 0;
        this.t = motionLayout;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.OnSwipe);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.OnSwipe_touchAnchorId) {
                this.f = obtainStyledAttributes.getResourceId(index, this.f);
            } else if (index == R.styleable.OnSwipe_touchAnchorSide) {
                int i2 = obtainStyledAttributes.getInt(index, this.c);
                this.c = i2;
                float[][] fArr = a;
                this.j = fArr[i2][0];
                this.i = fArr[i2][1];
            } else if (index == R.styleable.OnSwipe_dragDirection) {
                int i3 = obtainStyledAttributes.getInt(index, this.d);
                this.d = i3;
                float[][] fArr2 = b;
                if (i3 < fArr2.length) {
                    this.m = fArr2[i3][0];
                    this.n = fArr2[i3][1];
                } else {
                    this.n = Float.NaN;
                    this.m = Float.NaN;
                    this.l = true;
                }
            } else if (index == R.styleable.OnSwipe_maxVelocity) {
                this.u = obtainStyledAttributes.getFloat(index, this.u);
            } else if (index == R.styleable.OnSwipe_maxAcceleration) {
                this.v = obtainStyledAttributes.getFloat(index, this.v);
            } else if (index == R.styleable.OnSwipe_moveWhenScrollAtTop) {
                this.w = obtainStyledAttributes.getBoolean(index, this.w);
            } else if (index == R.styleable.OnSwipe_dragScale) {
                this.x = obtainStyledAttributes.getFloat(index, this.x);
            } else if (index == R.styleable.OnSwipe_dragThreshold) {
                this.z = obtainStyledAttributes.getFloat(index, this.z);
            } else if (index == R.styleable.OnSwipe_touchRegionId) {
                this.g = obtainStyledAttributes.getResourceId(index, this.g);
            } else if (index == R.styleable.OnSwipe_onTouchUp) {
                this.e = obtainStyledAttributes.getInt(index, this.e);
            } else if (index == R.styleable.OnSwipe_nestedScrollFlags) {
                this.y = obtainStyledAttributes.getInteger(index, 0);
            } else if (index == R.styleable.OnSwipe_limitBoundsTo) {
                this.h = obtainStyledAttributes.getResourceId(index, 0);
            } else if (index == R.styleable.OnSwipe_rotationCenterId) {
                this.k = obtainStyledAttributes.getResourceId(index, this.k);
            } else if (index == R.styleable.OnSwipe_springDamping) {
                this.A = obtainStyledAttributes.getFloat(index, this.A);
            } else if (index == R.styleable.OnSwipe_springMass) {
                this.B = obtainStyledAttributes.getFloat(index, this.B);
            } else if (index == R.styleable.OnSwipe_springStiffness) {
                this.C = obtainStyledAttributes.getFloat(index, this.C);
            } else if (index == R.styleable.OnSwipe_springStopThreshold) {
                this.D = obtainStyledAttributes.getFloat(index, this.D);
            } else if (index == R.styleable.OnSwipe_springBoundary) {
                this.E = obtainStyledAttributes.getInt(index, this.E);
            } else if (index == R.styleable.OnSwipe_autoCompleteMode) {
                this.F = obtainStyledAttributes.getInt(index, this.F);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public RectF a(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i = this.h;
        if (i == -1 || (findViewById = viewGroup.findViewById(i)) == null) {
            return null;
        }
        rectF.set((float) findViewById.getLeft(), (float) findViewById.getTop(), (float) findViewById.getRight(), (float) findViewById.getBottom());
        return rectF;
    }

    public RectF b(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i = this.g;
        if (i == -1 || (findViewById = viewGroup.findViewById(i)) == null) {
            return null;
        }
        rectF.set((float) findViewById.getLeft(), (float) findViewById.getTop(), (float) findViewById.getRight(), (float) findViewById.getBottom());
        return rectF;
    }

    public void c(boolean z) {
        if (z) {
            float[][] fArr = b;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = a;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = b;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = a;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[][] fArr5 = a;
        int i = this.c;
        this.j = fArr5[i][0];
        this.i = fArr5[i][1];
        int i2 = this.d;
        float[][] fArr6 = b;
        if (i2 < fArr6.length) {
            this.m = fArr6[i2][0];
            this.n = fArr6[i2][1];
        }
    }

    public String toString() {
        if (Float.isNaN(this.m)) {
            return "rotation";
        }
        return this.m + " , " + this.n;
    }
}
