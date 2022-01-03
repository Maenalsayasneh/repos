package io.agora.rtc.mediaio;

import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class AgoraDefaultRender implements IVideoSink {
    @Override // io.agora.rtc.mediaio.IVideoFrameConsumer
    public void consumeByteArrayFrame(byte[] bArr, int i, int i2, int i3, int i4, long j) {
    }

    @Override // io.agora.rtc.mediaio.IVideoFrameConsumer
    public void consumeByteBufferFrame(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, long j) {
    }

    @Override // io.agora.rtc.mediaio.IVideoFrameConsumer
    public void consumeTextureFrame(int i, int i2, int i3, int i4, int i5, long j, float[] fArr) {
    }

    @Override // io.agora.rtc.mediaio.IVideoSink
    public int getBufferType() {
        return 0;
    }

    @Override // io.agora.rtc.mediaio.IVideoSink
    public long getEGLContextHandle() {
        return 0;
    }

    @Override // io.agora.rtc.mediaio.IVideoSink
    public int getPixelFormat() {
        return 0;
    }

    @Override // io.agora.rtc.mediaio.IVideoSink
    public void onDispose() {
    }

    @Override // io.agora.rtc.mediaio.IVideoSink
    public boolean onInitialize() {
        return true;
    }

    @Override // io.agora.rtc.mediaio.IVideoSink
    public boolean onStart() {
        return true;
    }

    @Override // io.agora.rtc.mediaio.IVideoSink
    public void onStop() {
    }
}
