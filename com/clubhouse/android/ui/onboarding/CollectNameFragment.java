package com.clubhouse.android.ui.onboarding;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.clubhouse.android.databinding.FragmentCollectNameBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.app.R;
import h0.b0.v;
import h0.q.p;
import h0.q.q;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.e.b.g3.r.o0;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.c;
import m0.n.a.l;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
/* compiled from: CollectNameFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0018\u001a\u00020\u00138@@\u0000X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001e\u001a\u00020\u00198@@\u0000X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010$\u001a\u00020\u001f8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/clubhouse/android/ui/onboarding/CollectNameFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lcom/clubhouse/android/ui/onboarding/CollectNameUtil;", "c2", "Lcom/clubhouse/android/ui/onboarding/CollectNameUtil;", "getCollectNameUtil", "()Lcom/clubhouse/android/ui/onboarding/CollectNameUtil;", "setCollectNameUtil", "(Lcom/clubhouse/android/ui/onboarding/CollectNameUtil;)V", "collectNameUtil", "Lcom/clubhouse/android/databinding/FragmentCollectNameBinding;", "a2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "getBinding$app_productionRelease", "()Lcom/clubhouse/android/databinding/FragmentCollectNameBinding;", "binding", "Lcom/clubhouse/android/ui/onboarding/CollectNameViewModel;", "b2", "Lm0/c;", "N0", "()Lcom/clubhouse/android/ui/onboarding/CollectNameViewModel;", "viewModel", "", "d2", "Z", "K0", "()Z", "shouldShowKeyboard", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class CollectNameFragment extends Hilt_CollectNameFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(CollectNameFragment.class), "binding", "getBinding$app_productionRelease()Lcom/clubhouse/android/databinding/FragmentCollectNameBinding;")), m.c(new PropertyReference1Impl(m.a(CollectNameFragment.class), "viewModel", "getViewModel$app_productionRelease()Lcom/clubhouse/android/ui/onboarding/CollectNameViewModel;"))};
    public final c b2;
    public CollectNameUtil c2;
    public final FragmentViewBindingDelegate a2 = new FragmentViewBindingDelegate(FragmentCollectNameBinding.class, this);
    public final boolean d2 = true;

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<CollectNameFragment, CollectNameViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<CollectNameViewModel> a(CollectNameFragment collectNameFragment, k kVar) {
            CollectNameFragment collectNameFragment2 = collectNameFragment;
            i.e(collectNameFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(collectNameFragment2, kVar, this.a, new CollectNameFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(o0.class), false, this.b);
        }
    }

    public CollectNameFragment() {
        super(R.layout.fragment_collect_name);
        d a2 = m.a(CollectNameViewModel.class);
        this.b2 = new a(a2, false, new l<i0.b.b.k<CollectNameViewModel, o0>, CollectNameViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.onboarding.CollectNameFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.clubhouse.android.ui.onboarding.CollectNameViewModel, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.l
            public CollectNameViewModel invoke(i0.b.b.k<CollectNameViewModel, o0> kVar) {
                i0.b.b.k<CollectNameViewModel, o0> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, o0.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, Z1[1]);
    }

    @Override // i0.b.b.q
    public void J() {
        CollectNameUtil collectNameUtil = this.c2;
        if (collectNameUtil != null) {
            v.v2(collectNameUtil.c, new CollectNameUtil$invalidateViews$1(collectNameUtil));
        } else {
            i.m("collectNameUtil");
            throw null;
        }
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment
    public boolean K0() {
        return this.d2;
    }

    public final CollectNameViewModel N0() {
        return (CollectNameViewModel) this.b2.getValue();
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.e(view, "view");
        super.onViewCreated(view, bundle);
        v.V(this);
        CollectNameUtil collectNameUtil = new CollectNameUtil(this, (FragmentCollectNameBinding) this.a2.getValue(this, Z1[0]), N0());
        i.e(collectNameUtil, "<set-?>");
        this.c2 = collectNameUtil;
        collectNameUtil.b();
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(N0().l, new CollectNameFragment$initEffectsHandler$1(this, null));
        p viewLifecycleOwner = getViewLifecycleOwner();
        i.d(viewLifecycleOwner, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner));
    }
}
