package io.agora.rtc.video;

import android.graphics.SurfaceTexture;
/* loaded from: classes4.dex */
public interface GLRendererController extends SurfaceTexture.OnFrameAvailableListener {
    int GetAPILevel();

    void ReDraw();
}
