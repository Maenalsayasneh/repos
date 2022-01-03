package h0.v.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: DividerItemDecoration.java */
/* loaded from: classes.dex */
public class h extends RecyclerView.m {
    public static final int[] a = {16843284};
    public Drawable b;
    public int c;
    public final Rect d = new Rect();

    public h(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(a);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        this.b = drawable;
        if (drawable == null) {
            Log.w("DividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        obtainStyledAttributes.recycle();
        if (i == 0 || i == 1) {
            this.c = i;
            return;
        }
        throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void f(Rect rect, View view, RecyclerView recyclerView, RecyclerView.y yVar) {
        Drawable drawable = this.b;
        if (drawable == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.c == 1) {
            rect.set(0, 0, 0, drawable.getIntrinsicHeight());
        } else {
            rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void g(Canvas canvas, RecyclerView recyclerView, RecyclerView.y yVar) {
        int i;
        int i2;
        int i3;
        int i4;
        if (recyclerView.getLayoutManager() != null && this.b != null) {
            int i5 = 0;
            if (this.c == 1) {
                canvas.save();
                if (recyclerView.getClipToPadding()) {
                    i3 = recyclerView.getPaddingLeft();
                    i4 = recyclerView.getWidth() - recyclerView.getPaddingRight();
                    canvas.clipRect(i3, recyclerView.getPaddingTop(), i4, recyclerView.getHeight() - recyclerView.getPaddingBottom());
                } else {
                    i4 = recyclerView.getWidth();
                    i3 = 0;
                }
                int childCount = recyclerView.getChildCount();
                while (i5 < childCount) {
                    View childAt = recyclerView.getChildAt(i5);
                    recyclerView.getDecoratedBoundsWithMargins(childAt, this.d);
                    int round = Math.round(childAt.getTranslationY()) + this.d.bottom;
                    this.b.setBounds(i3, round - this.b.getIntrinsicHeight(), i4, round);
                    this.b.draw(canvas);
                    i5++;
                }
                canvas.restore();
                return;
            }
            canvas.save();
            if (recyclerView.getClipToPadding()) {
                i = recyclerView.getPaddingTop();
                i2 = recyclerView.getHeight() - recyclerView.getPaddingBottom();
                canvas.clipRect(recyclerView.getPaddingLeft(), i, recyclerView.getWidth() - recyclerView.getPaddingRight(), i2);
            } else {
                i2 = recyclerView.getHeight();
                i = 0;
            }
            int childCount2 = recyclerView.getChildCount();
            while (i5 < childCount2) {
                View childAt2 = recyclerView.getChildAt(i5);
                recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt2, this.d);
                int round2 = Math.round(childAt2.getTranslationX()) + this.d.right;
                this.b.setBounds(round2 - this.b.getIntrinsicWidth(), i, round2, i2);
                this.b.draw(canvas);
                i5++;
            }
            canvas.restore();
        }
    }
}
