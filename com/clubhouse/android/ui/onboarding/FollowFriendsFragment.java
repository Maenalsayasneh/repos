package com.clubhouse.android.ui.onboarding;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import com.clubhouse.android.databinding.FragmentFollowFriendsBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.shared.ui.ImpressionTrackingEpoxyRecyclerView;
import com.clubhouse.android.ui.onboarding.FollowFriendsFragment;
import com.clubhouse.app.R;
import h0.b0.v;
import h0.q.p;
import h0.q.q;
import i0.b.a.o;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.e.b.a3.d.a;
import i0.e.b.g3.k.w0.b.j;
import i0.e.b.g3.r.e1;
import java.util.Iterator;
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
/* compiled from: FollowFriendsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001d\u0010\u001a\u001a\u00020\u00158B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010 \u001a\u00020\u001b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/clubhouse/android/ui/onboarding/FollowFriendsFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Li0/e/a/b/a;", "a2", "Li0/e/a/b/a;", "getActionTrailRecorder", "()Li0/e/a/b/a;", "setActionTrailRecorder", "(Li0/e/a/b/a;)V", "actionTrailRecorder", "Lcom/clubhouse/android/ui/onboarding/FollowFriendsViewModel;", "c2", "Lm0/c;", "O0", "()Lcom/clubhouse/android/ui/onboarding/FollowFriendsViewModel;", "viewModel", "Lcom/clubhouse/android/databinding/FragmentFollowFriendsBinding;", "b2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "N0", "()Lcom/clubhouse/android/databinding/FragmentFollowFriendsBinding;", "binding", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class FollowFriendsFragment extends Hilt_FollowFriendsFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(FollowFriendsFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentFollowFriendsBinding;")), m.c(new PropertyReference1Impl(m.a(FollowFriendsFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/onboarding/FollowFriendsViewModel;"))};
    public i0.e.a.b.a a2;
    public final FragmentViewBindingDelegate b2 = new FragmentViewBindingDelegate(FragmentFollowFriendsBinding.class, this);
    public final c c2;

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<FollowFriendsFragment, FollowFriendsViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<FollowFriendsViewModel> a(FollowFriendsFragment followFriendsFragment, k kVar) {
            FollowFriendsFragment followFriendsFragment2 = followFriendsFragment;
            i.e(followFriendsFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(followFriendsFragment2, kVar, this.a, new FollowFriendsFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(e1.class), false, this.b);
        }
    }

    public FollowFriendsFragment() {
        super(R.layout.fragment_follow_friends);
        d a2 = m.a(FollowFriendsViewModel.class);
        this.c2 = new a(a2, false, new l<i0.b.b.k<FollowFriendsViewModel, e1>, FollowFriendsViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.onboarding.FollowFriendsFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.clubhouse.android.ui.onboarding.FollowFriendsViewModel, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.l
            public FollowFriendsViewModel invoke(i0.b.b.k<FollowFriendsViewModel, e1> kVar) {
                i0.b.b.k<FollowFriendsViewModel, e1> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, e1.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, Z1[1]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(O0(), new l<e1, m0.i>() { // from class: com.clubhouse.android.ui.onboarding.FollowFriendsFragment$invalidate$1
            @Override // m0.n.a.l
            public m0.i invoke(e1 e1Var) {
                e1 e1Var2 = e1Var;
                i.e(e1Var2, "state");
                FollowFriendsFragment followFriendsFragment = FollowFriendsFragment.this;
                k<Object>[] kVarArr = FollowFriendsFragment.Z1;
                FrameLayout frameLayout = followFriendsFragment.N0().d;
                i.d(frameLayout, "binding.loading");
                i0.e.b.d3.k.L(frameLayout, Boolean.valueOf(e1Var2.d));
                FollowFriendsFragment.this.N0().e.setText(FollowFriendsFragment.this.getString(e1Var2.b.size() == e1Var2.c.size() ? R.string.select_individually : R.string.use_suggestions));
                FollowFriendsFragment.this.N0().c.g();
                return m0.i.a;
            }
        });
    }

    public final FragmentFollowFriendsBinding N0() {
        return (FragmentFollowFriendsBinding) this.b2.getValue(this, Z1[0]);
    }

    public final FollowFriendsViewModel O0() {
        return (FollowFriendsViewModel) this.c2.getValue();
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.V(this);
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.e(view, "view");
        super.onViewCreated(view, bundle);
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(O0().l, new FollowFriendsFragment$onViewCreated$1(this, null));
        p viewLifecycleOwner = getViewLifecycleOwner();
        i.d(viewLifecycleOwner, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner));
        N0().b.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.r.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FollowFriendsFragment followFriendsFragment = FollowFriendsFragment.this;
                k<Object>[] kVarArr = FollowFriendsFragment.Z1;
                i.e(followFriendsFragment, "this$0");
                followFriendsFragment.O0().p(c1.a);
            }
        });
        N0().e.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.r.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FollowFriendsFragment followFriendsFragment = FollowFriendsFragment.this;
                k<Object>[] kVarArr = FollowFriendsFragment.Z1;
                i.e(followFriendsFragment, "this$0");
                followFriendsFragment.O0().p(a2.a);
            }
        });
        N0().c.setLayoutManager(new GridLayoutManager(getContext(), 3));
        ImpressionTrackingEpoxyRecyclerView impressionTrackingEpoxyRecyclerView = N0().c;
        i.d(impressionTrackingEpoxyRecyclerView, "binding.friendSuggestions");
        i0.e.b.d3.k.D(impressionTrackingEpoxyRecyclerView, this, new l<o, m0.i>() { // from class: com.clubhouse.android.ui.onboarding.FollowFriendsFragment$buildModels$1
            @Override // m0.n.a.l
            public m0.i invoke(o oVar) {
                final o oVar2 = oVar;
                i.e(oVar2, "$this$null");
                FollowFriendsFragment followFriendsFragment = FollowFriendsFragment.this;
                k<Object>[] kVarArr = FollowFriendsFragment.Z1;
                FollowFriendsViewModel O0 = followFriendsFragment.O0();
                final FollowFriendsFragment followFriendsFragment2 = FollowFriendsFragment.this;
                v.v2(O0, new l<e1, m0.i>() { // from class: com.clubhouse.android.ui.onboarding.FollowFriendsFragment$buildModels$1.1
                    @Override // m0.n.a.l
                    public m0.i invoke(e1 e1Var) {
                        e1 e1Var2 = e1Var;
                        i.e(e1Var2, "state");
                        List<a<i0.e.b.b3.b.e.m>> list = e1Var2.e;
                        o oVar3 = o.this;
                        FollowFriendsFragment followFriendsFragment3 = followFriendsFragment2;
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            a aVar = (a) it.next();
                            j jVar = new j();
                            jVar.N(new Number[]{((i0.e.b.b3.b.e.m) aVar.a).g.getId()});
                            jVar.O(new FollowFriendsFragment$buildModels$1$1$1$1$1(followFriendsFragment3, aVar));
                            jVar.Q(((i0.e.b.b3.b.e.m) aVar.a).g);
                            jVar.P(aVar.b);
                            jVar.M(true);
                            jVar.L(new i0.e.b.g3.r.q(followFriendsFragment3, aVar));
                            oVar3.add(jVar);
                        }
                        return m0.i.a;
                    }
                });
                return m0.i.a;
            }
        });
    }
}
