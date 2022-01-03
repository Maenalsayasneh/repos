package com.instabug.library.internal.layer;

import android.graphics.Bitmap;
/* loaded from: classes2.dex */
public interface CapturableView {

    /* loaded from: classes2.dex */
    public interface SnapshotPreparationCallback {
        void onSnapshotFailed();

        void onSnapshotReady(Bitmap bitmap);
    }

    void getLocationOnScreen(int[] iArr);

    boolean isVisible();

    void snapshot(SnapshotPreparationCallback snapshotPreparationCallback);
}
