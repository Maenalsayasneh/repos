package com.clubhouse.android.ui.onboarding.topics;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import com.airbnb.epoxy.EpoxyRecyclerView;
import com.clubhouse.android.data.models.local.Topic;
import com.clubhouse.android.databinding.FragmentOnboardingSuggestionsBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.ui.onboarding.topics.OnboardingTopicsFragment;
import com.clubhouse.app.R;
import h0.b0.v;
import h0.q.p;
import h0.q.q;
import i0.b.a.o;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.e.b.g3.r.a3.f;
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
/* compiled from: OnboardingTopicsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u00020\u000b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0016\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/clubhouse/android/ui/onboarding/topics/OnboardingTopicsFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lcom/clubhouse/android/ui/onboarding/topics/OnboardingTopicsViewModel;", "a2", "Lm0/c;", "O0", "()Lcom/clubhouse/android/ui/onboarding/topics/OnboardingTopicsViewModel;", "viewModel", "Lcom/clubhouse/android/databinding/FragmentOnboardingSuggestionsBinding;", "b2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "N0", "()Lcom/clubhouse/android/databinding/FragmentOnboardingSuggestionsBinding;", "binding", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class OnboardingTopicsFragment extends Hilt_OnboardingTopicsFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(OnboardingTopicsFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/onboarding/topics/OnboardingTopicsViewModel;")), m.c(new PropertyReference1Impl(m.a(OnboardingTopicsFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentOnboardingSuggestionsBinding;"))};
    public final c a2;
    public final FragmentViewBindingDelegate b2 = new FragmentViewBindingDelegate(FragmentOnboardingSuggestionsBinding.class, this);

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<OnboardingTopicsFragment, OnboardingTopicsViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<OnboardingTopicsViewModel> a(OnboardingTopicsFragment onboardingTopicsFragment, k kVar) {
            OnboardingTopicsFragment onboardingTopicsFragment2 = onboardingTopicsFragment;
            i.e(onboardingTopicsFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(onboardingTopicsFragment2, kVar, this.a, new OnboardingTopicsFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(f.class), false, this.b);
        }
    }

    public OnboardingTopicsFragment() {
        super(R.layout.fragment_onboarding_suggestions);
        d a2 = m.a(OnboardingTopicsViewModel.class);
        this.a2 = new a(a2, false, new l<i0.b.b.k<OnboardingTopicsViewModel, f>, OnboardingTopicsViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.onboarding.topics.OnboardingTopicsFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.airbnb.mvrx.MavericksViewModel, com.clubhouse.android.ui.onboarding.topics.OnboardingTopicsViewModel] */
            @Override // m0.n.a.l
            public OnboardingTopicsViewModel invoke(i0.b.b.k<OnboardingTopicsViewModel, f> kVar) {
                i0.b.b.k<OnboardingTopicsViewModel, f> kVar2 = kVar;
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
        }, a2).a(this, Z1[0]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(O0(), new l<f, m0.i>() { // from class: com.clubhouse.android.ui.onboarding.topics.OnboardingTopicsFragment$invalidate$1
            @Override // m0.n.a.l
            public m0.i invoke(f fVar) {
                f fVar2 = fVar;
                i.e(fVar2, "state");
                OnboardingTopicsFragment onboardingTopicsFragment = OnboardingTopicsFragment.this;
                k<Object>[] kVarArr = OnboardingTopicsFragment.Z1;
                FrameLayout frameLayout = onboardingTopicsFragment.N0().c;
                i.d(frameLayout, "binding.loading");
                i0.e.b.d3.k.L(frameLayout, Boolean.valueOf(fVar2.a));
                OnboardingTopicsFragment.this.N0().g.setText(fVar2.b);
                Button button = OnboardingTopicsFragment.this.N0().b;
                i.d(button, "binding.chooseButton");
                i0.e.b.d3.k.L(button, Boolean.valueOf(!fVar2.f));
                OnboardingTopicsFragment.this.N0().b.setText(OnboardingTopicsFragment.this.getResources().getString(R.string.onboarding_topics_choose, Integer.valueOf(fVar2.e - fVar2.d.size())));
                Button button2 = OnboardingTopicsFragment.this.N0().d;
                i.d(button2, "binding.nextButton");
                i0.e.b.d3.k.L(button2, Boolean.valueOf(fVar2.f));
                Button button3 = OnboardingTopicsFragment.this.N0().e;
                i.d(button3, "binding.skipButton");
                i0.e.b.d3.k.L(button3, Boolean.valueOf(fVar2.g));
                OnboardingTopicsFragment.this.N0().f.g();
                return m0.i.a;
            }
        });
    }

    public final FragmentOnboardingSuggestionsBinding N0() {
        return (FragmentOnboardingSuggestionsBinding) this.b2.getValue(this, Z1[1]);
    }

    public final OnboardingTopicsViewModel O0() {
        return (OnboardingTopicsViewModel) this.a2.getValue();
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.e(view, "view");
        super.onViewCreated(view, bundle);
        v.V(this);
        EpoxyRecyclerView epoxyRecyclerView = N0().f;
        i.d(epoxyRecyclerView, "binding.suggestionList");
        i0.e.b.d3.k.D(epoxyRecyclerView, this, new l<o, m0.i>() { // from class: com.clubhouse.android.ui.onboarding.topics.OnboardingTopicsFragment$buildModels$1
            @Override // m0.n.a.l
            public m0.i invoke(o oVar) {
                final o oVar2 = oVar;
                i.e(oVar2, "$this$null");
                OnboardingTopicsFragment onboardingTopicsFragment = OnboardingTopicsFragment.this;
                k<Object>[] kVarArr = OnboardingTopicsFragment.Z1;
                OnboardingTopicsViewModel O0 = onboardingTopicsFragment.O0();
                final OnboardingTopicsFragment onboardingTopicsFragment2 = OnboardingTopicsFragment.this;
                v.v2(O0, new l<f, m0.i>() { // from class: com.clubhouse.android.ui.onboarding.topics.OnboardingTopicsFragment$buildModels$1.1
                    @Override // m0.n.a.l
                    public m0.i invoke(f fVar) {
                        f fVar2 = fVar;
                        i.e(fVar2, "state");
                        List<Topic> list = fVar2.c;
                        if (list != null) {
                            o oVar3 = o.this;
                            OnboardingTopicsFragment onboardingTopicsFragment3 = onboardingTopicsFragment2;
                            for (Topic topic : list) {
                                i0.e.b.g3.r.b3.g gVar = new i0.e.b.g3.r.b3.g();
                                gVar.L(new Number[]{Integer.valueOf(topic.c)});
                                gVar.P(topic.d);
                                gVar.O(fVar2.d.contains(Integer.valueOf(topic.c)));
                                gVar.M(new OnboardingTopicsFragment$buildModels$1$1$1$1$1(onboardingTopicsFragment3, topic));
                                gVar.N(new OnboardingTopicsFragment$buildModels$1$1$1$1$2(onboardingTopicsFragment3, topic));
                                oVar3.add(gVar);
                            }
                        }
                        return m0.i.a;
                    }
                });
                return m0.i.a;
            }
        });
        N0().f.setLayoutManager(new GridLayoutManager(getContext(), 2));
        Button button = N0().b;
        i.d(button, "binding.chooseButton");
        i0.e.b.d3.k.h(button);
        Button button2 = N0().d;
        i.d(button2, "binding.nextButton");
        i0.e.b.d3.k.j(button2);
        N0().b.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.r.a3.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OnboardingTopicsFragment onboardingTopicsFragment = OnboardingTopicsFragment.this;
                k<Object>[] kVarArr = OnboardingTopicsFragment.Z1;
                i.e(onboardingTopicsFragment, "this$0");
                onboardingTopicsFragment.O0().p(k0.a);
            }
        });
        N0().d.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.r.a3.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OnboardingTopicsFragment onboardingTopicsFragment = OnboardingTopicsFragment.this;
                k<Object>[] kVarArr = OnboardingTopicsFragment.Z1;
                i.e(onboardingTopicsFragment, "this$0");
                onboardingTopicsFragment.O0().p(k0.a);
            }
        });
        N0().e.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.r.a3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OnboardingTopicsFragment onboardingTopicsFragment = OnboardingTopicsFragment.this;
                k<Object>[] kVarArr = OnboardingTopicsFragment.Z1;
                i.e(onboardingTopicsFragment, "this$0");
                onboardingTopicsFragment.O0().p(k0.a);
            }
        });
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(O0().l, new OnboardingTopicsFragment$onViewCreated$4(this, null));
        p viewLifecycleOwner = getViewLifecycleOwner();
        i.d(viewLifecycleOwner, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner));
    }
}
