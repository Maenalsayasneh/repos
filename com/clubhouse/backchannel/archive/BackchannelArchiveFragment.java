package com.clubhouse.backchannel.archive;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.airbnb.epoxy.EpoxyRecyclerView;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.backchannel.R;
import com.clubhouse.backchannel.archive.BackchannelArchiveFragment;
import com.clubhouse.backchannel.databinding.FragmentBackchannelArchiveBinding;
import h0.b0.v;
import i0.b.a.o;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.e.c.b.b;
import i0.e.c.b.f;
import i0.e.c.f.b.a.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import m0.c;
import m0.n.a.l;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
/* compiled from: BackchannelArchiveFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u00020\u000b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0016\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/clubhouse/backchannel/archive/BackchannelArchiveFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lcom/clubhouse/backchannel/archive/BackchannelArchiveViewModel;", "b2", "Lm0/c;", "getViewModel", "()Lcom/clubhouse/backchannel/archive/BackchannelArchiveViewModel;", "viewModel", "Lcom/clubhouse/backchannel/databinding/FragmentBackchannelArchiveBinding;", "a2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "N0", "()Lcom/clubhouse/backchannel/databinding/FragmentBackchannelArchiveBinding;", "binding", "<init>", "backchannel_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class BackchannelArchiveFragment extends Hilt_BackchannelArchiveFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(BackchannelArchiveFragment.class), "binding", "getBinding()Lcom/clubhouse/backchannel/databinding/FragmentBackchannelArchiveBinding;")), m.c(new PropertyReference1Impl(m.a(BackchannelArchiveFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/backchannel/archive/BackchannelArchiveViewModel;"))};
    public final FragmentViewBindingDelegate a2 = new FragmentViewBindingDelegate(FragmentBackchannelArchiveBinding.class, this);
    public final c b2;

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<BackchannelArchiveFragment, BackchannelArchiveViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<BackchannelArchiveViewModel> a(BackchannelArchiveFragment backchannelArchiveFragment, k kVar) {
            BackchannelArchiveFragment backchannelArchiveFragment2 = backchannelArchiveFragment;
            i.e(backchannelArchiveFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(backchannelArchiveFragment2, kVar, this.a, new BackchannelArchiveFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(f.class), false, this.b);
        }
    }

    public BackchannelArchiveFragment() {
        super(R.layout.fragment_backchannel_archive);
        d a2 = m.a(BackchannelArchiveViewModel.class);
        this.b2 = new a(a2, false, new l<i0.b.b.k<BackchannelArchiveViewModel, f>, BackchannelArchiveViewModel>(a2, a2) { // from class: com.clubhouse.backchannel.archive.BackchannelArchiveFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.airbnb.mvrx.MavericksViewModel, com.clubhouse.backchannel.archive.BackchannelArchiveViewModel] */
            @Override // m0.n.a.l
            public BackchannelArchiveViewModel invoke(i0.b.b.k<BackchannelArchiveViewModel, f> kVar) {
                i0.b.b.k<BackchannelArchiveViewModel, f> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, f.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, Z1[1]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2((BackchannelArchiveViewModel) this.b2.getValue(), new l<f, m0.i>() { // from class: com.clubhouse.backchannel.archive.BackchannelArchiveFragment$invalidate$1
            @Override // m0.n.a.l
            public m0.i invoke(f fVar) {
                f fVar2 = fVar;
                i.e(fVar2, "state");
                BackchannelArchiveFragment backchannelArchiveFragment = BackchannelArchiveFragment.this;
                k<Object>[] kVarArr = BackchannelArchiveFragment.Z1;
                ProgressBar progressBar = backchannelArchiveFragment.N0().d;
                i.d(progressBar, "binding.loading");
                i0.e.b.d3.k.L(progressBar, Boolean.valueOf(fVar2.b));
                TextView textView = BackchannelArchiveFragment.this.N0().c;
                i.d(textView, "binding.emptyView");
                i0.e.b.d3.k.L(textView, Boolean.valueOf(!fVar2.b && fVar2.a.isEmpty()));
                BackchannelArchiveFragment.this.N0().b.g();
                return m0.i.a;
            }
        });
    }

    public final FragmentBackchannelArchiveBinding N0() {
        return (FragmentBackchannelArchiveBinding) this.a2.getValue(this, Z1[0]);
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.e(view, "view");
        super.onViewCreated(view, bundle);
        N0().e.setBackgroundColor(v.t0(this));
        EpoxyRecyclerView epoxyRecyclerView = N0().b;
        i.d(epoxyRecyclerView, "binding.chatsList");
        i0.e.b.d3.k.D(epoxyRecyclerView, this, new l<o, m0.i>() { // from class: com.clubhouse.backchannel.archive.BackchannelArchiveFragment$buildModels$1
            @Override // m0.n.a.l
            public m0.i invoke(o oVar) {
                final o oVar2 = oVar;
                i.e(oVar2, "$this$null");
                final BackchannelArchiveFragment backchannelArchiveFragment = BackchannelArchiveFragment.this;
                v.v2((BackchannelArchiveViewModel) BackchannelArchiveFragment.this.b2.getValue(), new l<f, m0.i>() { // from class: com.clubhouse.backchannel.archive.BackchannelArchiveFragment$buildModels$1.1
                    @Override // m0.n.a.l
                    public m0.i invoke(f fVar) {
                        f fVar2 = fVar;
                        i.e(fVar2, "state");
                        List<a> list = fVar2.a;
                        o oVar3 = o.this;
                        BackchannelArchiveFragment backchannelArchiveFragment2 = backchannelArchiveFragment;
                        for (a aVar : list) {
                            i0.e.c.h.p.c cVar = new i0.e.c.h.p.c();
                            cVar.N(aVar.a);
                            cVar.L(aVar);
                            cVar.M(new b(backchannelArchiveFragment2, aVar));
                            cVar.O(new i0.e.c.b.c(backchannelArchiveFragment2, aVar));
                            oVar3.add(cVar);
                        }
                        return m0.i.a;
                    }
                });
                return m0.i.a;
            }
        });
        N0().a.setOnClickListener(new View.OnClickListener() { // from class: i0.e.c.b.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BackchannelArchiveFragment backchannelArchiveFragment = BackchannelArchiveFragment.this;
                k<Object>[] kVarArr = BackchannelArchiveFragment.Z1;
                i.e(backchannelArchiveFragment, "this$0");
                h0.o.a.k activity = backchannelArchiveFragment.getActivity();
                if (activity != null) {
                    activity.onBackPressed();
                }
            }
        });
    }
}
