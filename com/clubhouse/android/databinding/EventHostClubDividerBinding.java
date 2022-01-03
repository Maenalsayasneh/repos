package com.clubhouse.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.clubhouse.app.R;
import h0.e0.a;
import java.util.Objects;
/* loaded from: classes3.dex */
public final class EventHostClubDividerBinding implements a {
    public final View a;
    public final View b;

    public EventHostClubDividerBinding(View view, View view2) {
        this.a = view;
        this.b = view2;
    }

    public static EventHostClubDividerBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new EventHostClubDividerBinding(view, view);
    }

    public static EventHostClubDividerBinding inflate(LayoutInflater layoutInflater) {
        return bind(layoutInflater.inflate(R.layout.event_host_club_divider, (ViewGroup) null, false));
    }
}
