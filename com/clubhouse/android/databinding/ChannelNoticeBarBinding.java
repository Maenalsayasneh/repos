package com.clubhouse.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.clubhouse.app.R;
import h0.e0.a;
/* loaded from: classes3.dex */
public final class ChannelNoticeBarBinding implements a {
    public final FrameLayout a;
    public final TextView b;

    public ChannelNoticeBarBinding(FrameLayout frameLayout, TextView textView) {
        this.a = frameLayout;
        this.b = textView;
    }

    public static ChannelNoticeBarBinding bind(View view) {
        TextView textView = (TextView) view.findViewById(R.id.notice_text);
        if (textView != null) {
            return new ChannelNoticeBarBinding((FrameLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.notice_text)));
    }

    public static ChannelNoticeBarBinding inflate(LayoutInflater layoutInflater) {
        return bind(layoutInflater.inflate(R.layout.channel_notice_bar, (ViewGroup) null, false));
    }
}
