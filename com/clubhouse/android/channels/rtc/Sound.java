package com.clubhouse.android.channels.rtc;

import com.clubhouse.android.channels.R;
/* compiled from: Sounds.kt */
/* loaded from: classes3.dex */
public enum Sound {
    CHIME_POP(R.raw.chime_pop, "chime_pop.wav"),
    CHIME_ENTER(R.raw.chime_enter, "chime_enter.wav"),
    CHIME_WAVE_ROOM(R.raw.chime_wave_room, "chime_wave_room.wav");
    
    private final String fileName;
    private final int res;

    Sound(int i, String str) {
        this.res = i;
        this.fileName = str;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final int getRes() {
        return this.res;
    }
}
