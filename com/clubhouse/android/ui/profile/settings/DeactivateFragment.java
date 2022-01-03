package com.clubhouse.android.ui.profile.settings;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.clubhouse.android.databinding.FragmentDeactivateBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.ui.profile.settings.DeactivateFragment;
import com.clubhouse.app.R;
import h0.b0.v;
import h0.q.p;
import h0.q.q;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.e.b.g3.u.z5.q0;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.c;
import m0.n.a.l;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
/* compiled from: DeactivateFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u00020\u000b8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0016\u001a\u00020\u00118F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/clubhouse/android/ui/profile/settings/DeactivateFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lcom/clubhouse/android/ui/profile/settings/DeactivateViewModel;", "b2", "Lm0/c;", "O0", "()Lcom/clubhouse/android/ui/profile/settings/DeactivateViewModel;", "viewModel", "Lcom/clubhouse/android/databinding/FragmentDeactivateBinding;", "a2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "N0", "()Lcom/clubhouse/android/databinding/FragmentDeactivateBinding;", "binding", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class DeactivateFragment extends Hilt_DeactivateFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(DeactivateFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentDeactivateBinding;")), m.c(new PropertyReference1Impl(m.a(DeactivateFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/profile/settings/DeactivateViewModel;"))};
    public final FragmentViewBindingDelegate a2 = new FragmentViewBindingDelegate(FragmentDeactivateBinding.class, this);
    public final c b2;

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<DeactivateFragment, DeactivateViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<DeactivateViewModel> a(DeactivateFragment deactivateFragment, k kVar) {
            DeactivateFragment deactivateFragment2 = deactivateFragment;
            i.e(deactivateFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(deactivateFragment2, kVar, this.a, new DeactivateFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(q0.class), false, this.b);
        }
    }

    public DeactivateFragment() {
        super(R.layout.fragment_deactivate);
        d a2 = m.a(DeactivateViewModel.class);
        this.b2 = new a(a2, false, new l<i0.b.b.k<DeactivateViewModel, q0>, DeactivateViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.profile.settings.DeactivateFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.clubhouse.android.ui.profile.settings.DeactivateViewModel, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.l
            public DeactivateViewModel invoke(i0.b.b.k<DeactivateViewModel, q0> kVar) {
                i0.b.b.k<DeactivateViewModel, q0> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, q0.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, Z1[1]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(O0(), new l<q0, m0.i>() { // from class: com.clubhouse.android.ui.profile.settings.DeactivateFragment$invalidate$1
            @Override // m0.n.a.l
            public m0.i invoke(q0 q0Var) {
                q0 q0Var2 = q0Var;
                i.e(q0Var2, "state");
                ProgressBar progressBar = DeactivateFragment.this.N0().c;
                i.d(progressBar, "binding.loading");
                i0.e.b.d3.k.L(progressBar, Boolean.valueOf(q0Var2.a));
                return m0.i.a;
            }
        });
    }

    public final FragmentDeactivateBinding N0() {
        return (FragmentDeactivateBinding) this.a2.getValue(this, Z1[0]);
    }

    public final DeactivateViewModel O0() {
        return (DeactivateViewModel) this.b2.getValue();
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.e(view, "view");
        super.onViewCreated(view, bundle);
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(O0().l, new DeactivateFragment$onViewCreated$1(this, null));
        p viewLifecycleOwner = getViewLifecycleOwner();
        i.d(viewLifecycleOwner, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner));
        ImageView imageView = N0().a;
        i.d(imageView, "binding.back");
        p viewLifecycleOwner2 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner2, "viewLifecycleOwner");
        i0.e.b.d3.k.H(imageView, q.a(viewLifecycleOwner2), new View.OnClickListener() { // from class: i0.e.b.g3.u.z5.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeactivateFragment deactivateFragment = DeactivateFragment.this;
                k<Object>[] kVarArr = DeactivateFragment.Z1;
                i.e(deactivateFragment, "this$0");
                v.c1(deactivateFragment);
            }
        });
        TextView textView = N0().b;
        i.d(textView, "binding.deactivate");
        p viewLifecycleOwner3 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner3, "viewLifecycleOwner");
        i0.e.b.d3.k.H(textView, q.a(viewLifecycleOwner3), new View.OnClickListener() { // from class: i0.e.b.g3.u.z5.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                DeactivateFragment deactivateFragment = DeactivateFragment.this;
                k<Object>[] kVarArr = DeactivateFragment.Z1;
                i.e(deactivateFragment, "this$0");
                deactivateFragment.O0().p(o0.a);
            }
        });
    }
}
