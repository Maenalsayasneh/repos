package com.clubhouse.backchannel.chat.style;

import com.clubhouse.backchannel.R;
/* JADX WARN: Init of enum REQUEST can be incorrect */
/* JADX WARN: Init of enum SELF can be incorrect */
/* compiled from: MessageColor.kt */
/* loaded from: classes3.dex */
public enum MessageColor {
    SELF(r1, r2),
    REQUEST(R.color.clubhouse_eggshell_bright, r2),
    BLUE(R.color.message_background_blue, R.color.message_foreground_blue),
    ORANGE(R.color.message_background_orange, R.color.message_foreground_orange),
    GREEN(R.color.message_background_green, R.color.message_foreground_green),
    YELLOW(R.color.message_background_yellow, R.color.message_foreground_yellow),
    PURPLE(R.color.message_background_purple, R.color.message_foreground_purple),
    RED(R.color.message_background_red, R.color.message_foreground_red);
    
    private final int background;
    private final int foreground;

    static {
        int i = R.color.clubhouse_light_gray_wash;
        int i2 = R.color.black;
    }

    MessageColor(int i, int i2) {
        this.background = i;
        this.foreground = i2;
    }

    public final int getBackground() {
        return this.background;
    }

    public final int getForeground() {
        return this.foreground;
    }
}
