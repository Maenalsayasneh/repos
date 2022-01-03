package com.clubhouse.android.ui.clubs;

import com.clubhouse.app.R;
/* compiled from: ClubViewModel.kt */
/* loaded from: classes3.dex */
public enum ClubRole {
    ADMIN(R.string.club_member_role_admin),
    LEADER(R.string.club_member_role_leader),
    MEMBER(R.string.club_member_role_member);
    
    private final int label;

    ClubRole(int i) {
        this.label = i;
    }

    public final int getLabel() {
        return this.label;
    }
}
