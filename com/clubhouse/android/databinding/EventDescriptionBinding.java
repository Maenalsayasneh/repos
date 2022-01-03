package com.clubhouse.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.clubhouse.app.R;
import h0.e0.a;
/* loaded from: classes3.dex */
public final class EventDescriptionBinding implements a {
    public final FrameLayout a;
    public final TextView b;
    public final FrameLayout c;

    public EventDescriptionBinding(FrameLayout frameLayout, TextView textView, FrameLayout frameLayout2) {
        this.a = frameLayout;
        this.b = textView;
        this.c = frameLayout2;
    }

    public static EventDescriptionBinding bind(View view) {
        TextView textView = (TextView) view.findViewById(R.id.desc);
        if (textView != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            return new EventDescriptionBinding(frameLayout, textView, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.desc)));
    }

    public static EventDescriptionBinding inflate(LayoutInflater layoutInflater) {
        return bind(layoutInflater.inflate(R.layout.event_description, (ViewGroup) null, false));
    }
}
