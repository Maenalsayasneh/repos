package com.clubhouse.android.ui.common.topics;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import h0.b0.v;
import i0.b.b.c0;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import m0.c;
import m0.n.a.l;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
import n0.a.f1;
/* compiled from: TopicsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b'\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u001a\u001a\u00020\u000e¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0012R\u001d\u0010\u0019\u001a\u00020\u00148D@\u0004X\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/clubhouse/android/ui/common/topics/TopicsFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/view/ViewGroup;", "Q0", "()Landroid/view/ViewGroup;", "P0", "()Landroid/view/View;", "", "O0", "()I", "R0", "()V", "J", "Lcom/clubhouse/android/ui/common/topics/TopicsViewModel;", "a2", "Lm0/c;", "N0", "()Lcom/clubhouse/android/ui/common/topics/TopicsViewModel;", "viewModel", "contentLayoutId", "<init>", "(I)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public abstract class TopicsFragment extends Hilt_TopicsFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(TopicsFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/common/topics/TopicsViewModel;"))};
    public final c a2;

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<TopicsFragment, TopicsViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<TopicsViewModel> a(TopicsFragment topicsFragment, k kVar) {
            TopicsFragment topicsFragment2 = topicsFragment;
            i.e(topicsFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(topicsFragment2, kVar, this.a, new TopicsFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(i0.e.b.g3.m.g.d.class), false, this.b);
        }
    }

    public TopicsFragment(int i) {
        super(i);
        d a2 = m.a(TopicsViewModel.class);
        this.a2 = new a(a2, false, new l<i0.b.b.k<TopicsViewModel, i0.e.b.g3.m.g.d>, TopicsViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.common.topics.TopicsFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.clubhouse.android.ui.common.topics.TopicsViewModel, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.l
            public TopicsViewModel invoke(i0.b.b.k<TopicsViewModel, i0.e.b.g3.m.g.d> kVar) {
                i0.b.b.k<TopicsViewModel, i0.e.b.g3.m.g.d> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, i0.e.b.g3.m.g.d.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, Z1[0]);
    }

    @Override // i0.b.b.q
    public void J() {
    }

    public final TopicsViewModel N0() {
        return (TopicsViewModel) this.a2.getValue();
    }

    public abstract int O0();

    public abstract View P0();

    public abstract ViewGroup Q0();

    public void R0() {
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.e(view, "view");
        super.onViewCreated(view, bundle);
        f1 unused = x0(N0(), TopicsFragment$onViewCreated$1.c, (r5 & 2) != 0 ? c0.a : null, new TopicsFragment$onViewCreated$2(this, null));
    }
}
