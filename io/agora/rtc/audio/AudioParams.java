package io.agora.rtc.audio;

import androidx.recyclerview.widget.RecyclerView;
import i0.d.a.a.a;
/* loaded from: classes4.dex */
public class AudioParams {
    public int channel;
    public int mode;
    public int sampleRate;
    public int samplesPerCall;

    public AudioParams(int i, int i2, int i3, int i4) {
        this.sampleRate = 16000;
        this.channel = 1;
        this.mode = 0;
        this.samplesPerCall = RecyclerView.b0.FLAG_ADAPTER_FULLUPDATE;
        this.sampleRate = i;
        this.channel = i2;
        this.mode = i3;
        this.samplesPerCall = i4;
    }

    public String toString() {
        StringBuilder P0 = a.P0("AudioParams{sampleRate=");
        P0.append(this.sampleRate);
        P0.append(", channel=");
        P0.append(this.channel);
        P0.append(", mode=");
        P0.append(this.mode);
        P0.append(", samplesPerCall=");
        return a.s0(P0, this.samplesPerCall, '}');
    }
}
