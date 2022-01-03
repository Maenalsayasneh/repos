package com.clubhouse.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.clubhouse.app.R;
import h0.e0.a;
import java.util.Objects;
/* loaded from: classes3.dex */
public final class EventClubActionDividerBinding implements a {
    public final View a;

    public EventClubActionDividerBinding(View view) {
        this.a = view;
    }

    public static EventClubActionDividerBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new EventClubActionDividerBinding(view);
    }

    public static EventClubActionDividerBinding inflate(LayoutInflater layoutInflater) {
        return bind(layoutInflater.inflate(R.layout.event_club_action_divider, (ViewGroup) null, false));
    }
}
