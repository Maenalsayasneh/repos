package com.clubhouse.android.ui.onboarding;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.clubhouse.android.databinding.FragmentCollectUsernameBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.app.R;
import h0.b0.v;
import h0.q.p;
import h0.q.q;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.e.b.g3.r.w0;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.c;
import m0.n.a.l;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
/* compiled from: CollectUsernameFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u00020\u000b8@@\u0000X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0016\u001a\u00020\u00118@@\u0000X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010$\u001a\u00020\u001f8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/clubhouse/android/ui/onboarding/CollectUsernameFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lcom/clubhouse/android/databinding/FragmentCollectUsernameBinding;", "a2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "getBinding$app_productionRelease", "()Lcom/clubhouse/android/databinding/FragmentCollectUsernameBinding;", "binding", "Lcom/clubhouse/android/ui/onboarding/CollectUsernameViewModel;", "b2", "Lm0/c;", "getViewModel$app_productionRelease", "()Lcom/clubhouse/android/ui/onboarding/CollectUsernameViewModel;", "viewModel", "Lcom/clubhouse/android/ui/onboarding/CollectUsernameHelper;", "d2", "Lcom/clubhouse/android/ui/onboarding/CollectUsernameHelper;", "getCollectUsernameHelper", "()Lcom/clubhouse/android/ui/onboarding/CollectUsernameHelper;", "setCollectUsernameHelper", "(Lcom/clubhouse/android/ui/onboarding/CollectUsernameHelper;)V", "collectUsernameHelper", "", "c2", "Z", "K0", "()Z", "shouldShowKeyboard", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class CollectUsernameFragment extends Hilt_CollectUsernameFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(CollectUsernameFragment.class), "binding", "getBinding$app_productionRelease()Lcom/clubhouse/android/databinding/FragmentCollectUsernameBinding;")), m.c(new PropertyReference1Impl(m.a(CollectUsernameFragment.class), "viewModel", "getViewModel$app_productionRelease()Lcom/clubhouse/android/ui/onboarding/CollectUsernameViewModel;"))};
    public final c b2;
    public CollectUsernameHelper d2;
    public final FragmentViewBindingDelegate a2 = new FragmentViewBindingDelegate(FragmentCollectUsernameBinding.class, this);
    public final boolean c2 = true;

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<CollectUsernameFragment, CollectUsernameViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<CollectUsernameViewModel> a(CollectUsernameFragment collectUsernameFragment, k kVar) {
            CollectUsernameFragment collectUsernameFragment2 = collectUsernameFragment;
            i.e(collectUsernameFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(collectUsernameFragment2, kVar, this.a, new CollectUsernameFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(w0.class), false, this.b);
        }
    }

    public CollectUsernameFragment() {
        super(R.layout.fragment_collect_username);
        d a2 = m.a(CollectUsernameViewModel.class);
        this.b2 = new a(a2, false, new l<i0.b.b.k<CollectUsernameViewModel, w0>, CollectUsernameViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.onboarding.CollectUsernameFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.airbnb.mvrx.MavericksViewModel, com.clubhouse.android.ui.onboarding.CollectUsernameViewModel] */
            @Override // m0.n.a.l
            public CollectUsernameViewModel invoke(i0.b.b.k<CollectUsernameViewModel, w0> kVar) {
                i0.b.b.k<CollectUsernameViewModel, w0> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, w0.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, Z1[1]);
    }

    @Override // i0.b.b.q
    @SuppressLint({"SetTextI18n"})
    public void J() {
        CollectUsernameHelper collectUsernameHelper = this.d2;
        if (collectUsernameHelper != null) {
            v.v2(collectUsernameHelper.c, new CollectUsernameHelper$invalidateViews$1(collectUsernameHelper));
        } else {
            i.m("collectUsernameHelper");
            throw null;
        }
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment
    public boolean K0() {
        return this.c2;
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.e(view, "view");
        super.onViewCreated(view, bundle);
        v.V(this);
        CollectUsernameHelper collectUsernameHelper = new CollectUsernameHelper(this, (FragmentCollectUsernameBinding) this.a2.getValue(this, Z1[0]), (CollectUsernameViewModel) this.b2.getValue());
        i.e(collectUsernameHelper, "<set-?>");
        this.d2 = collectUsernameHelper;
        collectUsernameHelper.a();
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(((CollectUsernameViewModel) this.b2.getValue()).l, new CollectUsernameFragment$initEffectsHandler$1(this, null));
        p viewLifecycleOwner = getViewLifecycleOwner();
        i.d(viewLifecycleOwner, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner));
    }
}
