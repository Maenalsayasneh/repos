package com.clubhouse.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.clubhouse.app.R;
import h0.e0.a;
/* loaded from: classes3.dex */
public final class TooltipCreateClipNuxBinding implements a {
    public TooltipCreateClipNuxBinding(LinearLayout linearLayout, TextView textView, ImageView imageView, TextView textView2) {
    }

    public static TooltipCreateClipNuxBinding bind(View view) {
        int i = R.id.body;
        TextView textView = (TextView) view.findViewById(R.id.body);
        if (textView != null) {
            i = R.id.header_image;
            ImageView imageView = (ImageView) view.findViewById(R.id.header_image);
            if (imageView != null) {
                i = R.id.title;
                TextView textView2 = (TextView) view.findViewById(R.id.title);
                if (textView2 != null) {
                    return new TooltipCreateClipNuxBinding((LinearLayout) view, textView, imageView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static TooltipCreateClipNuxBinding inflate(LayoutInflater layoutInflater) {
        return bind(layoutInflater.inflate(R.layout.tooltip_create_clip_nux, (ViewGroup) null, false));
    }
}
