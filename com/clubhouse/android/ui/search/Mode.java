package com.clubhouse.android.ui.search;

import com.clubhouse.app.R;
/* compiled from: ExploreViewModel.kt */
/* loaded from: classes3.dex */
public enum Mode {
    SUGGESTED(R.string.people_search_empty),
    TOP(R.string.top_search_empty),
    PEOPLE(R.string.people_search_empty),
    CLUBS(R.string.club_search_empty),
    ROOMS(R.string.room_search_empty),
    EVENTS(R.string.event_search_empty);
    
    private final int emptyText;

    Mode(int i) {
        this.emptyText = i;
    }

    public final int getEmptyText() {
        return this.emptyText;
    }
}
