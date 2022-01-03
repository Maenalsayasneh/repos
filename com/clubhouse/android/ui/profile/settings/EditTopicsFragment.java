package com.clubhouse.android.ui.profile.settings;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.clubhouse.android.data.models.local.Topic;
import com.clubhouse.android.databinding.FragmentInterestsBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.ui.profile.settings.EditTopicsFragment;
import com.clubhouse.app.R;
import h0.b0.v;
import i0.b.b.i;
import i0.e.b.g3.m.g.a;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import m0.n.b.m;
import m0.o.c;
import m0.r.k;
/* compiled from: EditTopicsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0018\u001a\u00020\u00138B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001e\u001a\u00020\u00198B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/clubhouse/android/ui/profile/settings/EditTopicsFragment;", "Lcom/clubhouse/android/ui/common/topics/TopicsFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "R0", "()V", "", "O0", "()I", "Landroid/view/ViewGroup;", "Q0", "()Landroid/view/ViewGroup;", "P0", "()Landroid/view/View;", "Lcom/clubhouse/android/databinding/FragmentInterestsBinding;", "e2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "S0", "()Lcom/clubhouse/android/databinding/FragmentInterestsBinding;", "binding", "Lcom/clubhouse/android/ui/profile/settings/EditTopicsArgs;", "f2", "Lm0/o/c;", "getArgs", "()Lcom/clubhouse/android/ui/profile/settings/EditTopicsArgs;", "args", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class EditTopicsFragment extends Hilt_EditTopicsFragment {
    public static final /* synthetic */ k<Object>[] d2 = {m.c(new PropertyReference1Impl(m.a(EditTopicsFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentInterestsBinding;")), m.c(new PropertyReference1Impl(m.a(EditTopicsFragment.class), "args", "getArgs()Lcom/clubhouse/android/ui/profile/settings/EditTopicsArgs;"))};
    public final FragmentViewBindingDelegate e2 = new FragmentViewBindingDelegate(FragmentInterestsBinding.class, this);
    public final c f2 = new i();

    public EditTopicsFragment() {
        super(R.layout.fragment_interests);
    }

    @Override // com.clubhouse.android.ui.common.topics.TopicsFragment
    public int O0() {
        return R.layout.interests_header;
    }

    @Override // com.clubhouse.android.ui.common.topics.TopicsFragment
    public View P0() {
        ProgressBar progressBar = S0().c;
        m0.n.b.i.d(progressBar, "binding.loading");
        return progressBar;
    }

    @Override // com.clubhouse.android.ui.common.topics.TopicsFragment
    public ViewGroup Q0() {
        LinearLayout linearLayout = S0().d;
        m0.n.b.i.d(linearLayout, "binding.mainTopicsList");
        return linearLayout;
    }

    @Override // com.clubhouse.android.ui.common.topics.TopicsFragment
    public void R0() {
        Topic topic = ((EditTopicsArgs) this.f2.getValue(this, d2[1])).c;
        if (topic != null) {
            String str = topic.d;
            ViewGroup Q0 = Q0();
            m0.n.b.i.e(this, "<this>");
            m0.n.b.i.e(str, "topicName");
            m0.n.b.i.e(Q0, "mainTopicsListView");
            ConstraintLayout constraintLayout = (ConstraintLayout) Q0.findViewById(R.id.header_root);
            TextView textView = (TextView) constraintLayout.findViewById(R.id.topic_added);
            ((TextView) textView.findViewById(R.id.topic_added)).setText(getResources().getString(R.string.topic_added, str));
            m0.n.b.i.d(textView, "congratsTitle");
            i0.e.b.d3.k.K(textView);
            TextView textView2 = (TextView) constraintLayout.findViewById(R.id.topic_great_choice);
            m0.n.b.i.d(textView2, "greatChoice");
            i0.e.b.d3.k.K(textView2);
        }
    }

    public final FragmentInterestsBinding S0() {
        return (FragmentInterestsBinding) this.e2.getValue(this, d2[0]);
    }

    @Override // com.clubhouse.android.ui.common.topics.TopicsFragment, com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m0.n.b.i.e(view, "view");
        super.onViewCreated(view, bundle);
        S0().a.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.u.z5.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EditTopicsFragment editTopicsFragment = EditTopicsFragment.this;
                k<Object>[] kVarArr = EditTopicsFragment.d2;
                m0.n.b.i.e(editTopicsFragment, "this$0");
                v.c1(editTopicsFragment);
            }
        });
        Topic topic = ((EditTopicsArgs) this.f2.getValue(this, d2[1])).c;
        if (topic != null) {
            N0().p(new a(topic));
        }
    }
}
