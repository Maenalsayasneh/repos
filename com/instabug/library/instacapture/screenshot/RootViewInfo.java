package com.instabug.library.instacapture.screenshot;

import android.graphics.Rect;
import android.view.View;
import android.view.WindowManager;
/* loaded from: classes2.dex */
public class RootViewInfo {
    private final WindowManager.LayoutParams layoutParams;
    private final int left;
    private final Rect rect;
    private final int top;
    private final View view;

    public RootViewInfo(View view, Rect rect, WindowManager.LayoutParams layoutParams) {
        this.view = view;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.left = iArr[0];
        this.top = iArr[1];
        this.rect = rect;
        this.layoutParams = layoutParams;
    }

    public WindowManager.LayoutParams getLayoutParams() {
        return this.layoutParams;
    }

    public int getLeft() {
        return this.left;
    }

    public Rect getRect() {
        return this.rect;
    }

    public int getTop() {
        return this.top;
    }

    public View getView() {
        return this.view;
    }

    public boolean isDialog() {
        return this.layoutParams.type == 2;
    }
}
