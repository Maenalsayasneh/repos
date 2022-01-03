package com.clubhouse.android.ui.profile.reports;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.clubhouse.analytics.AmplitudeAnalytics;
import com.clubhouse.android.data.models.local.ReportTarget;
import com.clubhouse.android.databinding.FragmentReportProfileBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.shared.ui.AvatarView;
import com.clubhouse.android.ui.profile.reports.ReportIncidentSelectCategoryArgs;
import com.clubhouse.android.ui.profile.reports.ReportIncidentSelectChannelArgs;
import com.clubhouse.android.ui.profile.reports.ReportProfileFragment;
import com.clubhouse.android.user.model.User;
import com.clubhouse.app.R;
import h0.b0.v;
import h0.q.p;
import h0.q.q;
import i0.b.b.i;
import i0.e.b.a3.f.e;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import m0.n.b.m;
import m0.o.c;
import m0.r.k;
/* compiled from: ReportProfileFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u00020\u000b8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0016\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/clubhouse/android/ui/profile/reports/ReportProfileFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lcom/clubhouse/android/databinding/FragmentReportProfileBinding;", "a2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "O0", "()Lcom/clubhouse/android/databinding/FragmentReportProfileBinding;", "binding", "Lcom/clubhouse/android/ui/profile/reports/ReportProfileArgs;", "b2", "Lm0/o/c;", "N0", "()Lcom/clubhouse/android/ui/profile/reports/ReportProfileArgs;", "args", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class ReportProfileFragment extends Hilt_ReportProfileFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(ReportProfileFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentReportProfileBinding;")), m.c(new PropertyReference1Impl(m.a(ReportProfileFragment.class), "args", "getArgs()Lcom/clubhouse/android/ui/profile/reports/ReportProfileArgs;"))};
    public final FragmentViewBindingDelegate a2 = new FragmentViewBindingDelegate(FragmentReportProfileBinding.class, this);
    public final c b2 = new i();

    public ReportProfileFragment() {
        super(R.layout.fragment_report_profile);
    }

    @Override // i0.b.b.q
    public void J() {
    }

    public final ReportProfileArgs N0() {
        return (ReportProfileArgs) this.b2.getValue(this, Z1[1]);
    }

    public final FragmentReportProfileBinding O0() {
        return (FragmentReportProfileBinding) this.a2.getValue(this, Z1[0]);
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m0.n.b.i.e(view, "view");
        super.onViewCreated(view, bundle);
        O0().b.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.u.y5.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReportProfileFragment reportProfileFragment = ReportProfileFragment.this;
                k<Object>[] kVarArr = ReportProfileFragment.Z1;
                m0.n.b.i.e(reportProfileFragment, "this$0");
                h0.b0.v.c1(reportProfileFragment);
            }
        });
        TextView textView = O0().e;
        m0.n.b.i.d(textView, "binding.reportChannel");
        p viewLifecycleOwner = getViewLifecycleOwner();
        m0.n.b.i.d(viewLifecycleOwner, "viewLifecycleOwner");
        i0.e.b.d3.k.H(textView, q.a(viewLifecycleOwner), new View.OnClickListener() { // from class: i0.e.b.g3.u.y5.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReportProfileFragment reportProfileFragment = ReportProfileFragment.this;
                k<Object>[] kVarArr = ReportProfileFragment.Z1;
                m0.n.b.i.e(reportProfileFragment, "this$0");
                ReportIncidentSelectChannelArgs reportIncidentSelectChannelArgs = new ReportIncidentSelectChannelArgs(reportProfileFragment.N0().c, reportProfileFragment.N0().y);
                m0.n.b.i.e(reportIncidentSelectChannelArgs, "mavericksArg");
                v.a1(reportProfileFragment, new b1(reportIncidentSelectChannelArgs), null, 2);
            }
        });
        TextView textView2 = O0().h;
        m0.n.b.i.d(textView2, "binding.reportProfile");
        p viewLifecycleOwner2 = getViewLifecycleOwner();
        m0.n.b.i.d(viewLifecycleOwner2, "viewLifecycleOwner");
        i0.e.b.d3.k.H(textView2, q.a(viewLifecycleOwner2), new View.OnClickListener() { // from class: i0.e.b.g3.u.y5.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReportProfileFragment reportProfileFragment = ReportProfileFragment.this;
                k<Object>[] kVarArr = ReportProfileFragment.Z1;
                m0.n.b.i.e(reportProfileFragment, "this$0");
                ReportIncidentSelectCategoryArgs reportIncidentSelectCategoryArgs = new ReportIncidentSelectCategoryArgs(reportProfileFragment.N0().c, reportProfileFragment.N0().d, null, null, null, reportProfileFragment.N0().y, ReportTarget.USER_PROFILE, 28);
                m0.n.b.i.e(reportIncidentSelectCategoryArgs, "mavericksArg");
                v.a1(reportProfileFragment, new a1(reportIncidentSelectCategoryArgs), null, 2);
            }
        });
        TextView textView3 = O0().f;
        m0.n.b.i.d(textView3, "binding.reportCommunityGuidelines");
        p viewLifecycleOwner3 = getViewLifecycleOwner();
        m0.n.b.i.d(viewLifecycleOwner3, "viewLifecycleOwner");
        i0.e.b.d3.k.H(textView3, q.a(viewLifecycleOwner3), new View.OnClickListener() { // from class: i0.e.b.g3.u.y5.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReportProfileFragment reportProfileFragment = ReportProfileFragment.this;
                k<Object>[] kVarArr = ReportProfileFragment.Z1;
                m0.n.b.i.e(reportProfileFragment, "this$0");
                e.b(reportProfileFragment, reportProfileFragment.getString(R.string.clubhouse_guidelines));
            }
        });
        TextView textView4 = O0().g;
        m0.n.b.i.d(textView4, "binding.reportGetHelp");
        p viewLifecycleOwner4 = getViewLifecycleOwner();
        m0.n.b.i.d(viewLifecycleOwner4, "viewLifecycleOwner");
        i0.e.b.d3.k.H(textView4, q.a(viewLifecycleOwner4), new View.OnClickListener() { // from class: i0.e.b.g3.u.y5.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReportProfileFragment reportProfileFragment = ReportProfileFragment.this;
                k<Object>[] kVarArr = ReportProfileFragment.Z1;
                m0.n.b.i.e(reportProfileFragment, "this$0");
                e.b(reportProfileFragment, reportProfileFragment.getString(R.string.clubhouse_contact));
            }
        });
        ((AmplitudeAnalytics) v.l(this)).a("Channel-ReportIncident");
        User user = N0().c;
        AvatarView avatarView = O0().a;
        m0.n.b.i.d(avatarView, "binding.avatar");
        i0.e.b.d3.k.u(avatarView, user);
        O0().d.setText(user.getName());
        O0().i.setText(user.C());
        if (N0().x) {
            O0().c.setText(getString(R.string.speaker));
        } else if (N0().q) {
            O0().c.setText(getString(R.string.moderator));
        } else {
            TextView textView5 = O0().c;
            m0.n.b.i.d(textView5, "binding.channelRole");
            i0.e.b.d3.k.p(textView5);
        }
        O0().j.setText(getString(R.string.why_are_you_reporting, user.F()));
    }
}
