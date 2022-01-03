package com.clubhouse.android.ui.events;

import com.clubhouse.app.R;
/* compiled from: EventsFilteringType.kt */
/* loaded from: classes3.dex */
public enum EventsFilteringType {
    UpcomingForYou(R.string.upcoming_for_you, R.string.we_couldnt_find_any_upcoming),
    MyEvents(R.string.my_events, R.string.there_are_no_upcoming_events);
    
    private final int emptyTitle;
    private final int title;

    EventsFilteringType(int i, int i2) {
        this.title = i;
        this.emptyTitle = i2;
    }

    public final int getEmptyTitle() {
        return this.emptyTitle;
    }

    public final int getTitle() {
        return this.title;
    }
}
