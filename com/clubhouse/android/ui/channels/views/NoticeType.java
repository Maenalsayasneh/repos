package com.clubhouse.android.ui.channels.views;

import com.clubhouse.app.R;
/* compiled from: NoticeBar.kt */
/* loaded from: classes3.dex */
public enum NoticeType {
    FirstTimeAudience(R.color.clubhouse_light_gray, R.color.clubhouse_dark_gray, Integer.valueOf((int) R.drawable.ic_mute_notice), Integer.valueOf((int) R.string.notice_bar_muted)),
    BlockedUsers(R.color.clubhouse_red, R.color.white, Integer.valueOf((int) R.drawable.ic_blocked), null),
    BadNetwork(R.color.clubhouse_red, R.color.white, Integer.valueOf((int) R.drawable.ic_wifi), Integer.valueOf((int) R.string.poor_connection));
    
    private final int background;
    private final Integer defaultMessage;
    private final Integer icon;
    private final int textColor;

    NoticeType(int i, int i2, Integer num, Integer num2) {
        this.background = i;
        this.textColor = i2;
        this.icon = num;
        this.defaultMessage = num2;
    }

    public final int getBackground() {
        return this.background;
    }

    public final Integer getDefaultMessage() {
        return this.defaultMessage;
    }

    public final Integer getIcon() {
        return this.icon;
    }

    public final int getTextColor() {
        return this.textColor;
    }
}
