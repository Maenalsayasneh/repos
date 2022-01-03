package com.clubhouse.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.clubhouse.app.R;
import h0.e0.a;
import java.util.Objects;
/* loaded from: classes3.dex */
public final class EventActionDividerBinding implements a {
    public EventActionDividerBinding(FrameLayout frameLayout) {
    }

    public static EventActionDividerBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        return new EventActionDividerBinding((FrameLayout) view);
    }

    public static EventActionDividerBinding inflate(LayoutInflater layoutInflater) {
        return bind(layoutInflater.inflate(R.layout.event_action_divider, (ViewGroup) null, false));
    }
}
