package io.agora.rtc.internal;
/* loaded from: classes4.dex */
public interface AudioRoutingListener {
    void onAudioRoutingChanged(int i);

    void onAudioRoutingDestroyed();

    void onAudioRoutingError(int i);
}
