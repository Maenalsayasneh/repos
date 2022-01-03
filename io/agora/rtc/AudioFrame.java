package io.agora.rtc;

import i0.d.a.a.a;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class AudioFrame {
    public int bytesPerSample;
    public int channels;
    public int numOfSamples;
    public ByteBuffer samples;
    public int samplesPerSec;

    public AudioFrame(ByteBuffer byteBuffer, int i, int i2, int i3, int i4) {
        this.samples = byteBuffer;
        this.numOfSamples = i;
        this.bytesPerSample = i2;
        this.channels = i3;
        this.samplesPerSec = i4;
    }

    public String toString() {
        StringBuilder P0 = a.P0("AgoraAudioFrame{samples=");
        P0.append(this.samples);
        P0.append(", numOfSamples=");
        P0.append(this.numOfSamples);
        P0.append(", bytesPerSample=");
        P0.append(this.bytesPerSample);
        P0.append(", channels=");
        P0.append(this.channels);
        P0.append(", samplesPerSec=");
        return a.s0(P0, this.samplesPerSec, '}');
    }
}
