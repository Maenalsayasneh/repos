package com.instabug.library.ui.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
/* loaded from: classes2.dex */
public class InstabugScrollView extends ScrollView {
    public OnScrollListener onScrollListener;

    /* loaded from: classes2.dex */
    public interface OnScrollListener {
        void onBottomReached();

        void onScrolling();

        void onTopReached();
    }

    public InstabugScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        OnScrollListener onScrollListener;
        OnScrollListener onScrollListener2;
        OnScrollListener onScrollListener3;
        int bottom = getChildAt(getChildCount() - 1).getBottom() - (getScrollY() + getHeight());
        if (bottom == 0 && (onScrollListener3 = this.onScrollListener) != null) {
            onScrollListener3.onBottomReached();
        } else if (getScrollY() == 0 && (onScrollListener2 = this.onScrollListener) != null) {
            onScrollListener2.onTopReached();
        } else if (bottom > 0 && (onScrollListener = this.onScrollListener) != null) {
            onScrollListener.onScrolling();
        }
        super.onScrollChanged(i, i2, i3, i4);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.onScrollListener = onScrollListener;
    }

    public InstabugScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InstabugScrollView(Context context) {
        super(context);
    }
}
