package i0.j.e.y0;

import android.annotation.SuppressLint;
import android.hardware.display.VirtualDisplay;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
/* compiled from: ScreenshotCaptureService.java */
/* loaded from: classes2.dex */
public class a extends MediaProjection.Callback {
    public final /* synthetic */ VirtualDisplay a;
    public final /* synthetic */ ImageReader b;
    public final /* synthetic */ MediaProjection c;

    public a(VirtualDisplay virtualDisplay, ImageReader imageReader, MediaProjection mediaProjection) {
        this.a = virtualDisplay;
        this.b = imageReader;
        this.c = mediaProjection;
    }

    @Override // android.media.projection.MediaProjection.Callback
    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void onStop() {
        super.onStop();
        VirtualDisplay virtualDisplay = this.a;
        if (virtualDisplay != null) {
            virtualDisplay.release();
        }
        this.b.setOnImageAvailableListener(null, null);
        this.c.unregisterCallback(this);
    }
}
