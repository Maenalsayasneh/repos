package io.agora.rtc.audio;
/* loaded from: classes4.dex */
public interface IHardwareEarback {
    void destroy();

    int enableEarbackFeature(boolean z);

    void initialize();

    boolean isHardwareEarbackSupported();

    int setHardwareEarbackVolume(int i);
}
