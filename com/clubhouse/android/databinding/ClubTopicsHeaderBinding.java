package com.clubhouse.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.clubhouse.app.R;
import h0.e0.a;
import java.util.Objects;
/* loaded from: classes3.dex */
public final class ClubTopicsHeaderBinding implements a {
    public final TextView a;

    public ClubTopicsHeaderBinding(TextView textView, TextView textView2) {
        this.a = textView2;
    }

    public static ClubTopicsHeaderBinding bind(View view) {
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        return new ClubTopicsHeaderBinding(textView, textView);
    }

    public static ClubTopicsHeaderBinding inflate(LayoutInflater layoutInflater) {
        return bind(layoutInflater.inflate(R.layout.club_topics_header, (ViewGroup) null, false));
    }
}
