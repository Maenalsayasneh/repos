package h0.v.a;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: LinearSmoothScroller.java */
/* loaded from: classes.dex */
public class p extends RecyclerView.x {
    public PointF k;
    public final DisplayMetrics l;
    public float n;
    public final LinearInterpolator i = new LinearInterpolator();
    public final DecelerateInterpolator j = new DecelerateInterpolator();
    public boolean m = false;
    public int o = 0;
    public int p = 0;

    public p(Context context) {
        this.l = context.getResources().getDisplayMetrics();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.x
    public void c(View view, RecyclerView.y yVar, RecyclerView.x.a aVar) {
        int i;
        int i2;
        int i3;
        PointF pointF = this.k;
        int i4 = 0;
        int i5 = (pointF == null || pointF.x == 0.0f) ? 0 : i3 > 0 ? 1 : -1;
        RecyclerView.n nVar = this.c;
        if (nVar == null || !nVar.canScrollHorizontally()) {
            i = 0;
        } else {
            RecyclerView.o oVar = (RecyclerView.o) view.getLayoutParams();
            i = e(nVar.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) oVar).leftMargin, nVar.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) oVar).rightMargin, nVar.getPaddingLeft(), nVar.getWidth() - nVar.getPaddingRight(), i5);
        }
        PointF pointF2 = this.k;
        int i6 = (pointF2 == null || pointF2.y == 0.0f) ? 0 : i2 > 0 ? 1 : -1;
        RecyclerView.n nVar2 = this.c;
        if (nVar2 != null && nVar2.canScrollVertically()) {
            RecyclerView.o oVar2 = (RecyclerView.o) view.getLayoutParams();
            i4 = e(nVar2.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) oVar2).topMargin, nVar2.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) oVar2).bottomMargin, nVar2.getPaddingTop(), nVar2.getHeight() - nVar2.getPaddingBottom(), i6);
        }
        int g = g((int) Math.sqrt((double) ((i4 * i4) + (i * i))));
        if (g > 0) {
            aVar.b(-i, -i4, g, this.j);
        }
    }

    public int e(int i, int i2, int i3, int i4, int i5) {
        if (i5 == -1) {
            return i3 - i;
        }
        if (i5 == 0) {
            int i6 = i3 - i;
            if (i6 > 0) {
                return i6;
            }
            int i7 = i4 - i2;
            if (i7 < 0) {
                return i7;
            }
            return 0;
        } else if (i5 == 1) {
            return i4 - i2;
        } else {
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    public float f(DisplayMetrics displayMetrics) {
        return 25.0f / ((float) displayMetrics.densityDpi);
    }

    public int g(int i) {
        return (int) Math.ceil(((double) h(i)) / 0.3356d);
    }

    public int h(int i) {
        float abs = (float) Math.abs(i);
        if (!this.m) {
            this.n = f(this.l);
            this.m = true;
        }
        return (int) Math.ceil((double) (abs * this.n));
    }
}
