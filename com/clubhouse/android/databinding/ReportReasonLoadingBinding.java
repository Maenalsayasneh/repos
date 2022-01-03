package com.clubhouse.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.clubhouse.app.R;
import h0.e0.a;
/* loaded from: classes3.dex */
public final class ReportReasonLoadingBinding implements a {
    public ReportReasonLoadingBinding(FrameLayout frameLayout, ProgressBar progressBar) {
    }

    public static ReportReasonLoadingBinding bind(View view) {
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.loading);
        if (progressBar != null) {
            return new ReportReasonLoadingBinding((FrameLayout) view, progressBar);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.loading)));
    }

    public static ReportReasonLoadingBinding inflate(LayoutInflater layoutInflater) {
        return bind(layoutInflater.inflate(R.layout.report_reason_loading, (ViewGroup) null, false));
    }
}
