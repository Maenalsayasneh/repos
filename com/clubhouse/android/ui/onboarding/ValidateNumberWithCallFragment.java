package com.clubhouse.android.ui.onboarding;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.afollestad.assent.AssentResult;
import com.afollestad.assent.Permission;
import com.clubhouse.analytics.AmplitudeAnalytics;
import com.clubhouse.android.databinding.FragmentValidateNumberCallBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.ui.onboarding.ValidateNumberWithCallFragment;
import com.clubhouse.app.R;
import h0.b0.v;
import h0.q.p;
import h0.q.q;
import i0.a.a.b;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.i;
import i0.b.b.x;
import i0.e.b.g3.r.o2;
import i0.e.b.g3.r.u1;
import i0.e.b.g3.r.v1;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.c;
import m0.n.a.l;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
/* compiled from: ValidateNumberWithCallFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u00020\u000b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0016\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001c\u001a\u00020\u00178B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/clubhouse/android/ui/onboarding/ValidateNumberWithCallFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lcom/clubhouse/android/databinding/FragmentValidateNumberCallBinding;", "a2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "N0", "()Lcom/clubhouse/android/databinding/FragmentValidateNumberCallBinding;", "binding", "Lcom/clubhouse/android/ui/onboarding/ValidateNumberWithCallViewModel;", "b2", "Lm0/c;", "getViewModel", "()Lcom/clubhouse/android/ui/onboarding/ValidateNumberWithCallViewModel;", "viewModel", "Lcom/clubhouse/android/ui/onboarding/ValidateNumberArgs;", "c2", "Lm0/o/c;", "getArgs", "()Lcom/clubhouse/android/ui/onboarding/ValidateNumberArgs;", "args", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class ValidateNumberWithCallFragment extends Hilt_ValidateNumberWithCallFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(ValidateNumberWithCallFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentValidateNumberCallBinding;")), m.c(new PropertyReference1Impl(m.a(ValidateNumberWithCallFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/onboarding/ValidateNumberWithCallViewModel;")), m.c(new PropertyReference1Impl(m.a(ValidateNumberWithCallFragment.class), "args", "getArgs()Lcom/clubhouse/android/ui/onboarding/ValidateNumberArgs;"))};
    public final c b2;
    public final FragmentViewBindingDelegate a2 = new FragmentViewBindingDelegate(FragmentValidateNumberCallBinding.class, this);
    public final m0.o.c c2 = new i();

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<ValidateNumberWithCallFragment, ValidateNumberWithCallViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<ValidateNumberWithCallViewModel> a(ValidateNumberWithCallFragment validateNumberWithCallFragment, k kVar) {
            ValidateNumberWithCallFragment validateNumberWithCallFragment2 = validateNumberWithCallFragment;
            m0.n.b.i.e(validateNumberWithCallFragment2, "thisRef");
            m0.n.b.i.e(kVar, "property");
            return g.a.b(validateNumberWithCallFragment2, kVar, this.a, new ValidateNumberWithCallFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(o2.class), false, this.b);
        }
    }

    public ValidateNumberWithCallFragment() {
        super(R.layout.fragment_validate_number_call);
        d a2 = m.a(ValidateNumberWithCallViewModel.class);
        this.b2 = new a(a2, false, new l<i0.b.b.k<ValidateNumberWithCallViewModel, o2>, ValidateNumberWithCallViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.onboarding.ValidateNumberWithCallFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.clubhouse.android.ui.onboarding.ValidateNumberWithCallViewModel, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.l
            public ValidateNumberWithCallViewModel invoke(i0.b.b.k<ValidateNumberWithCallViewModel, o2> kVar) {
                i0.b.b.k<ValidateNumberWithCallViewModel, o2> kVar2 = kVar;
                m0.n.b.i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                m0.n.b.i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                m0.n.b.i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, o2.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, Z1[1]);
    }

    @Override // i0.b.b.q
    public void J() {
    }

    public final FragmentValidateNumberCallBinding N0() {
        return (FragmentValidateNumberCallBinding) this.a2.getValue(this, Z1[0]);
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m0.n.b.i.e(view, "view");
        super.onViewCreated(view, bundle);
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(((ValidateNumberWithCallViewModel) this.b2.getValue()).l, new ValidateNumberWithCallFragment$onViewCreated$1(this, null));
        p viewLifecycleOwner = getViewLifecycleOwner();
        m0.n.b.i.d(viewLifecycleOwner, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner));
        N0().a.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.r.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ValidateNumberWithCallFragment validateNumberWithCallFragment = ValidateNumberWithCallFragment.this;
                k<Object>[] kVarArr = ValidateNumberWithCallFragment.Z1;
                m0.n.b.i.e(validateNumberWithCallFragment, "this$0");
                v.c1(validateNumberWithCallFragment);
            }
        });
        ((AmplitudeAnalytics) v.l(this)).a("Onboarding-PhoneVerifyCall-Start");
        b.a(this, new Permission[]{Permission.READ_CALL_LOG}, 0, null, new l<AssentResult, m0.i>() { // from class: com.clubhouse.android.ui.onboarding.ValidateNumberWithCallFragment$onViewCreated$3
            @Override // m0.n.a.l
            public m0.i invoke(AssentResult assentResult) {
                AssentResult assentResult2 = assentResult;
                m0.n.b.i.e(assentResult2, "it");
                if (assentResult2.b().contains(Permission.READ_CALL_LOG)) {
                    ((AmplitudeAnalytics) v.l(ValidateNumberWithCallFragment.this)).a("Onboarding-PhoneVerifyCall-ReadCallPermissionAccepted");
                    ValidateNumberWithCallFragment validateNumberWithCallFragment = ValidateNumberWithCallFragment.this;
                    k<Object>[] kVarArr = ValidateNumberWithCallFragment.Z1;
                    TextView textView = validateNumberWithCallFragment.N0().d;
                    m0.n.b.i.d(textView, "binding.permissionTitle");
                    i0.e.b.d3.k.p(textView);
                    TextView textView2 = validateNumberWithCallFragment.N0().c;
                    m0.n.b.i.d(textView2, "binding.permissionBody");
                    i0.e.b.d3.k.p(textView2);
                    TextView textView3 = validateNumberWithCallFragment.N0().b;
                    m0.n.b.i.d(textView3, "binding.permissionBanner");
                    i0.e.b.d3.k.p(textView3);
                    validateNumberWithCallFragment.N0().f.setText(validateNumberWithCallFragment.getString(R.string.were_verifying_your_number, ((ValidateNumberArgs) validateNumberWithCallFragment.c2.getValue(validateNumberWithCallFragment, ValidateNumberWithCallFragment.Z1[2])).c));
                    TextView textView4 = validateNumberWithCallFragment.N0().g;
                    m0.n.b.i.d(textView4, "binding.waitingForCallTitle");
                    i0.e.b.d3.k.K(textView4);
                    TextView textView5 = validateNumberWithCallFragment.N0().f;
                    m0.n.b.i.d(textView5, "binding.verifyingYourNumber");
                    i0.e.b.d3.k.K(textView5);
                    TextView textView6 = validateNumberWithCallFragment.N0().e;
                    m0.n.b.i.d(textView6, "binding.processAutomatically");
                    i0.e.b.d3.k.K(textView6);
                    ((ValidateNumberWithCallViewModel) ValidateNumberWithCallFragment.this.b2.getValue()).p(v1.a);
                } else {
                    ((AmplitudeAnalytics) v.l(ValidateNumberWithCallFragment.this)).a("Onboarding-PhoneVerifyCall-ReadCallPermissionDenied");
                    ((ValidateNumberWithCallViewModel) ValidateNumberWithCallFragment.this.b2.getValue()).p(u1.a);
                }
                return m0.i.a;
            }
        }, 6);
    }
}
