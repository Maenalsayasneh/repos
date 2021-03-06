package io.agora.rtc.mediaio;
/* loaded from: classes4.dex */
public interface IVideoSink extends IVideoFrameConsumer {
    int getBufferType();

    long getEGLContextHandle();

    int getPixelFormat();

    void onDispose();

    boolean onInitialize();

    boolean onStart();

    void onStop();
}
