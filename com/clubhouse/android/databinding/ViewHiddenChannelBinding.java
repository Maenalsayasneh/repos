package com.clubhouse.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.clubhouse.app.R;
import h0.e0.a;
/* loaded from: classes3.dex */
public final class ViewHiddenChannelBinding implements a {
    public final TextView a;

    public ViewHiddenChannelBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView) {
        this.a = textView;
    }

    public static ViewHiddenChannelBinding bind(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        TextView textView = (TextView) view.findViewById(R.id.hidden_channel_undo);
        if (textView != null) {
            return new ViewHiddenChannelBinding((LinearLayout) view, linearLayout, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.hidden_channel_undo)));
    }

    public static ViewHiddenChannelBinding inflate(LayoutInflater layoutInflater) {
        return bind(layoutInflater.inflate(R.layout.view_hidden_channel, (ViewGroup) null, false));
    }
}
