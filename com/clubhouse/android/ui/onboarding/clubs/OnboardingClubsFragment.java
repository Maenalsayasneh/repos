package com.clubhouse.android.ui.onboarding.clubs;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.airbnb.epoxy.EpoxyRecyclerView;
import com.clubhouse.android.data.models.local.club.Club;
import com.clubhouse.android.databinding.FragmentOnboardingSuggestionsBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.ui.onboarding.clubs.OnboardingClubsFragment;
import com.clubhouse.app.R;
import h0.b0.v;
import h0.q.p;
import h0.q.q;
import i0.b.a.o;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.e.b.g3.r.k0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.c;
import m0.n.a.l;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
/* compiled from: OnboardingClubsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u00020\u000b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0016\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/clubhouse/android/ui/onboarding/clubs/OnboardingClubsFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lcom/clubhouse/android/ui/onboarding/clubs/OnboardingClubsViewModel;", "a2", "Lm0/c;", "O0", "()Lcom/clubhouse/android/ui/onboarding/clubs/OnboardingClubsViewModel;", "viewModel", "Lcom/clubhouse/android/databinding/FragmentOnboardingSuggestionsBinding;", "b2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "N0", "()Lcom/clubhouse/android/databinding/FragmentOnboardingSuggestionsBinding;", "binding", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class OnboardingClubsFragment extends Hilt_OnboardingClubsFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(OnboardingClubsFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/onboarding/clubs/OnboardingClubsViewModel;")), m.c(new PropertyReference1Impl(m.a(OnboardingClubsFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentOnboardingSuggestionsBinding;"))};
    public final c a2;
    public final FragmentViewBindingDelegate b2 = new FragmentViewBindingDelegate(FragmentOnboardingSuggestionsBinding.class, this);

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<OnboardingClubsFragment, OnboardingClubsViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<OnboardingClubsViewModel> a(OnboardingClubsFragment onboardingClubsFragment, k kVar) {
            OnboardingClubsFragment onboardingClubsFragment2 = onboardingClubsFragment;
            i.e(onboardingClubsFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(onboardingClubsFragment2, kVar, this.a, new OnboardingClubsFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(i0.e.b.g3.r.z2.h.class), false, this.b);
        }
    }

    public OnboardingClubsFragment() {
        super(R.layout.fragment_onboarding_suggestions);
        d a2 = m.a(OnboardingClubsViewModel.class);
        this.a2 = new a(a2, false, new l<i0.b.b.k<OnboardingClubsViewModel, i0.e.b.g3.r.z2.h>, OnboardingClubsViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.onboarding.clubs.OnboardingClubsFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.clubhouse.android.ui.onboarding.clubs.OnboardingClubsViewModel, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.l
            public OnboardingClubsViewModel invoke(i0.b.b.k<OnboardingClubsViewModel, i0.e.b.g3.r.z2.h> kVar) {
                i0.b.b.k<OnboardingClubsViewModel, i0.e.b.g3.r.z2.h> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, i0.e.b.g3.r.z2.h.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, Z1[0]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(O0(), new l<i0.e.b.g3.r.z2.h, m0.i>() { // from class: com.clubhouse.android.ui.onboarding.clubs.OnboardingClubsFragment$invalidate$1
            @Override // m0.n.a.l
            public m0.i invoke(i0.e.b.g3.r.z2.h hVar) {
                i0.e.b.g3.r.z2.h hVar2 = hVar;
                i.e(hVar2, "state");
                OnboardingClubsFragment onboardingClubsFragment = OnboardingClubsFragment.this;
                k<Object>[] kVarArr = OnboardingClubsFragment.Z1;
                FrameLayout frameLayout = onboardingClubsFragment.N0().c;
                i.d(frameLayout, "binding.loading");
                i0.e.b.d3.k.L(frameLayout, Boolean.valueOf(hVar2.a));
                OnboardingClubsFragment.this.N0().g.setText(hVar2.c);
                Button button = OnboardingClubsFragment.this.N0().b;
                i.d(button, "binding.chooseButton");
                i0.e.b.d3.k.L(button, Boolean.valueOf(hVar2.e));
                OnboardingClubsFragment.this.N0().b.setText(OnboardingClubsFragment.this.getResources().getString(R.string.onboarding_clubs_join, Integer.valueOf(hVar2.d.size())));
                Button button2 = OnboardingClubsFragment.this.N0().d;
                i.d(button2, "binding.nextButton");
                i0.e.b.d3.k.L(button2, Boolean.valueOf(!hVar2.e));
                Button button3 = OnboardingClubsFragment.this.N0().e;
                i.d(button3, "binding.skipButton");
                i0.e.b.d3.k.L(button3, Boolean.valueOf(hVar2.f));
                OnboardingClubsFragment.this.N0().f.g();
                return m0.i.a;
            }
        });
    }

    public final FragmentOnboardingSuggestionsBinding N0() {
        return (FragmentOnboardingSuggestionsBinding) this.b2.getValue(this, Z1[1]);
    }

    public final OnboardingClubsViewModel O0() {
        return (OnboardingClubsViewModel) this.a2.getValue();
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.e(view, "view");
        super.onViewCreated(view, bundle);
        v.V(this);
        EpoxyRecyclerView epoxyRecyclerView = N0().f;
        i.d(epoxyRecyclerView, "binding.suggestionList");
        i0.e.b.d3.k.D(epoxyRecyclerView, this, new l<o, m0.i>() { // from class: com.clubhouse.android.ui.onboarding.clubs.OnboardingClubsFragment$buildModels$1
            @Override // m0.n.a.l
            public m0.i invoke(o oVar) {
                final o oVar2 = oVar;
                i.e(oVar2, "$this$null");
                OnboardingClubsFragment onboardingClubsFragment = OnboardingClubsFragment.this;
                k<Object>[] kVarArr = OnboardingClubsFragment.Z1;
                OnboardingClubsViewModel O0 = onboardingClubsFragment.O0();
                final OnboardingClubsFragment onboardingClubsFragment2 = OnboardingClubsFragment.this;
                v.v2(O0, new l<i0.e.b.g3.r.z2.h, m0.i>() { // from class: com.clubhouse.android.ui.onboarding.clubs.OnboardingClubsFragment$buildModels$1.1
                    @Override // m0.n.a.l
                    public m0.i invoke(i0.e.b.g3.r.z2.h hVar) {
                        i0.e.b.g3.r.z2.h hVar2 = hVar;
                        i.e(hVar2, "state");
                        List<Club> list = hVar2.b;
                        if (list != null) {
                            o oVar3 = o.this;
                            OnboardingClubsFragment onboardingClubsFragment3 = onboardingClubsFragment2;
                            for (Club club : list) {
                                i0.e.b.f3.m.b.h hVar3 = new i0.e.b.f3.m.b.h();
                                hVar3.N(new Number[]{Integer.valueOf(club.getId())});
                                hVar3.M(club);
                                hVar3.O(hVar2.d.contains(Integer.valueOf(club.getId())));
                                hVar3.P(true);
                                hVar3.L(new i0.e.b.g3.r.z2.d(onboardingClubsFragment3, club));
                                oVar3.add(hVar3);
                            }
                        }
                        return m0.i.a;
                    }
                });
                return m0.i.a;
            }
        });
        N0().f.setItemSpacingDp(10);
        Button button = N0().b;
        i.d(button, "binding.chooseButton");
        i0.e.b.d3.k.j(button);
        Button button2 = N0().d;
        i.d(button2, "binding.nextButton");
        i0.e.b.d3.k.h(button2);
        N0().b.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.r.z2.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OnboardingClubsFragment onboardingClubsFragment = OnboardingClubsFragment.this;
                k<Object>[] kVarArr = OnboardingClubsFragment.Z1;
                i.e(onboardingClubsFragment, "this$0");
                onboardingClubsFragment.O0().p(k0.a);
            }
        });
        N0().d.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.r.z2.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OnboardingClubsFragment onboardingClubsFragment = OnboardingClubsFragment.this;
                k<Object>[] kVarArr = OnboardingClubsFragment.Z1;
                i.e(onboardingClubsFragment, "this$0");
                onboardingClubsFragment.O0().p(k0.a);
            }
        });
        N0().e.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.r.z2.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OnboardingClubsFragment onboardingClubsFragment = OnboardingClubsFragment.this;
                k<Object>[] kVarArr = OnboardingClubsFragment.Z1;
                i.e(onboardingClubsFragment, "this$0");
                onboardingClubsFragment.O0().p(k0.a);
            }
        });
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(O0().l, new OnboardingClubsFragment$onViewCreated$4(this, null));
        p viewLifecycleOwner = getViewLifecycleOwner();
        i.d(viewLifecycleOwner, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner));
    }
}
