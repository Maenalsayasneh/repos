package com.clubhouse.android.ui.payments;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.app.BundleCompat;
import androidx.fragment.app.Fragment;
import com.clubhouse.analytics.AmplitudeAnalytics;
import com.clubhouse.android.data.models.remote.response.GetPaymentRegistrationResponse;
import com.clubhouse.android.databinding.DialogEditTextBinding;
import com.clubhouse.android.databinding.FragmentPaymentsRegistrationBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.ui.payments.PaymentsRegistrationFragment;
import com.clubhouse.android.ui.payments.PaymentsRegistrationFragment$showVerifyEmailPromptDialog$1;
import com.clubhouse.app.R;
import com.google.android.material.switchmaterial.SwitchMaterial;
import h0.b0.v;
import h0.q.p;
import h0.q.q;
import i0.b.b.b;
import i0.b.b.e;
import i0.b.b.f;
import i0.b.b.f0;
import i0.b.b.g;
import i0.b.b.g0;
import i0.b.b.h;
import i0.b.b.x;
import i0.e.a.a;
import i0.e.b.g3.s.r0;
import i0.e.b.g3.s.x0;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.c;
import m0.n.a.l;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
/* compiled from: PaymentsRegistrationFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\nR\u001d\u0010\u0012\u001a\u00020\r8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0018\u001a\u00020\u00138F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/clubhouse/android/ui/payments/PaymentsRegistrationFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "J", "P0", "Lcom/clubhouse/android/databinding/FragmentPaymentsRegistrationBinding;", "a2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "N0", "()Lcom/clubhouse/android/databinding/FragmentPaymentsRegistrationBinding;", "binding", "Lcom/clubhouse/android/ui/payments/PaymentsRegistrationViewModel;", "b2", "Lm0/c;", "O0", "()Lcom/clubhouse/android/ui/payments/PaymentsRegistrationViewModel;", "viewModel", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class PaymentsRegistrationFragment extends Hilt_PaymentsRegistrationFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(PaymentsRegistrationFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentPaymentsRegistrationBinding;")), m.c(new PropertyReference1Impl(m.a(PaymentsRegistrationFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/payments/PaymentsRegistrationViewModel;"))};
    public final FragmentViewBindingDelegate a2 = new FragmentViewBindingDelegate(FragmentPaymentsRegistrationBinding.class, this);
    public final c b2;

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<PaymentsRegistrationFragment, PaymentsRegistrationViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<PaymentsRegistrationViewModel> a(PaymentsRegistrationFragment paymentsRegistrationFragment, k kVar) {
            PaymentsRegistrationFragment paymentsRegistrationFragment2 = paymentsRegistrationFragment;
            i.e(paymentsRegistrationFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(paymentsRegistrationFragment2, kVar, this.a, new PaymentsRegistrationFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(r0.class), false, this.b);
        }
    }

    public PaymentsRegistrationFragment() {
        super(R.layout.fragment_payments_registration);
        d a2 = m.a(PaymentsRegistrationViewModel.class);
        this.b2 = new a(a2, false, new l<i0.b.b.k<PaymentsRegistrationViewModel, r0>, PaymentsRegistrationViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.payments.PaymentsRegistrationFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.clubhouse.android.ui.payments.PaymentsRegistrationViewModel, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.l
            public PaymentsRegistrationViewModel invoke(i0.b.b.k<PaymentsRegistrationViewModel, r0> kVar) {
                i0.b.b.k<PaymentsRegistrationViewModel, r0> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, r0.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, Z1[1]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(O0(), new l<r0, m0.i>() { // from class: com.clubhouse.android.ui.payments.PaymentsRegistrationFragment$invalidate$1
            @Override // m0.n.a.l
            public m0.i invoke(r0 r0Var) {
                r0 r0Var2 = r0Var;
                i.e(r0Var2, "state");
                FrameLayout frameLayout = PaymentsRegistrationFragment.this.N0().c;
                i.d(frameLayout, "binding.loading");
                i0.e.b.d3.k.L(frameLayout, Boolean.valueOf(r0Var2.e instanceof e));
                FrameLayout frameLayout2 = PaymentsRegistrationFragment.this.N0().i;
                i.d(frameLayout2, "binding.retry");
                i0.e.b.d3.k.L(frameLayout2, Boolean.valueOf(r0Var2.e instanceof i0.b.b.c));
                SwitchMaterial switchMaterial = PaymentsRegistrationFragment.this.N0().a;
                switchMaterial.setChecked(r0Var2.c);
                switchMaterial.jumpDrawablesToCurrentState();
                if (r0Var2.e instanceof f0) {
                    LinearLayout linearLayout = PaymentsRegistrationFragment.this.N0().o;
                    i.d(linearLayout, "binding.stateVerifyEmail");
                    boolean z = true;
                    i0.e.b.d3.k.L(linearLayout, Boolean.valueOf(r0Var2.a == RegistrationStatus.NeedsEmailVerification));
                    LinearLayout linearLayout2 = PaymentsRegistrationFragment.this.N0().n;
                    i.d(linearLayout2, "binding.stateRegistrationNotStarted");
                    i0.e.b.d3.k.L(linearLayout2, Boolean.valueOf(r0Var2.a == RegistrationStatus.NotStarted));
                    LinearLayout linearLayout3 = PaymentsRegistrationFragment.this.N0().l;
                    i.d(linearLayout3, "binding.stateRegistrationActionNeeded");
                    i0.e.b.d3.k.L(linearLayout3, Boolean.valueOf(r0Var2.a == RegistrationStatus.NeedsAction));
                    LinearLayout linearLayout4 = PaymentsRegistrationFragment.this.N0().m;
                    i.d(linearLayout4, "binding.stateRegistrationInReview");
                    i0.e.b.d3.k.L(linearLayout4, Boolean.valueOf(r0Var2.a == RegistrationStatus.NeedsReview));
                    LinearLayout linearLayout5 = PaymentsRegistrationFragment.this.N0().k;
                    i.d(linearLayout5, "binding.statePaymentsActive");
                    if (r0Var2.a != RegistrationStatus.Active) {
                        z = false;
                    }
                    i0.e.b.d3.k.L(linearLayout5, Boolean.valueOf(z));
                }
                return m0.i.a;
            }
        });
    }

    public final FragmentPaymentsRegistrationBinding N0() {
        return (FragmentPaymentsRegistrationBinding) this.a2.getValue(this, Z1[0]);
    }

    public final PaymentsRegistrationViewModel O0() {
        return (PaymentsRegistrationViewModel) this.b2.getValue();
    }

    public final void P0() {
        v.v2(O0(), new l<r0, m0.i>() { // from class: com.clubhouse.android.ui.payments.PaymentsRegistrationFragment$trackAnalyticsAndNavigateToStripe$1
            @Override // m0.n.a.l
            public m0.i invoke(r0 r0Var) {
                Map<String, ? extends Object> map;
                RegistrationStatus registrationStatus;
                r0 r0Var2 = r0Var;
                i.e(r0Var2, "state");
                a l = v.l(PaymentsRegistrationFragment.this);
                PaymentsRegistrationFragment paymentsRegistrationFragment = PaymentsRegistrationFragment.this;
                k<Object>[] kVarArr = PaymentsRegistrationFragment.Z1;
                Objects.requireNonNull(paymentsRegistrationFragment);
                b<GetPaymentRegistrationResponse> bVar = r0Var2.e;
                if ((bVar instanceof g0) || (bVar instanceof i0.b.b.c) || (bVar instanceof f) || (registrationStatus = r0Var2.a) == RegistrationStatus.NeedsEmailVerification) {
                    map = m0.j.g.o();
                } else {
                    Pair[] pairArr = new Pair[4];
                    pairArr[0] = new Pair("is_active", Boolean.valueOf(registrationStatus == RegistrationStatus.Active));
                    pairArr[1] = new Pair("needs_action", Boolean.valueOf(r0Var2.a == RegistrationStatus.NeedsAction));
                    pairArr[2] = new Pair("is_registered", Boolean.valueOf(r0Var2.b));
                    pairArr[3] = new Pair("is_enabled", Boolean.valueOf(r0Var2.c));
                    map = m0.j.g.N(pairArr);
                }
                ((AmplitudeAnalytics) l).b("DirectPayments-NavigateToStripe", map);
                PaymentsRegistrationFragment paymentsRegistrationFragment2 = PaymentsRegistrationFragment.this;
                String str = r0Var2.d;
                Objects.requireNonNull(paymentsRegistrationFragment2);
                if (str != null) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        if (!intent.hasExtra("android.support.customtabs.extra.SESSION")) {
                            Bundle bundle = new Bundle();
                            BundleCompat.putBinder(bundle, "android.support.customtabs.extra.SESSION", null);
                            intent.putExtras(bundle);
                        }
                        intent.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", true);
                        intent.putExtras(new Bundle());
                        intent.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", 0);
                        Context requireContext = paymentsRegistrationFragment2.requireContext();
                        intent.setData(Uri.parse(str));
                        h0.i.b.a.startActivity(requireContext, intent, null);
                    } catch (ActivityNotFoundException unused) {
                        i.e(paymentsRegistrationFragment2, "<this>");
                        Context requireContext2 = paymentsRegistrationFragment2.requireContext();
                        i.d(requireContext2, "requireContext()");
                        i.e(requireContext2, "<this>");
                        requireContext2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    }
                }
                return m0.i.a;
            }
        });
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        O0().p(x0.a);
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.e(view, "view");
        super.onViewCreated(view, bundle);
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(O0().l, new PaymentsRegistrationFragment$onViewCreated$1(this, null));
        p viewLifecycleOwner = getViewLifecycleOwner();
        i.d(viewLifecycleOwner, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner));
        N0().b.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.s.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PaymentsRegistrationFragment paymentsRegistrationFragment = PaymentsRegistrationFragment.this;
                k<Object>[] kVarArr = PaymentsRegistrationFragment.Z1;
                i.e(paymentsRegistrationFragment, "this$0");
                v.c1(paymentsRegistrationFragment);
            }
        });
        Button button = N0().j;
        i.d(button, "binding.retryButton");
        p viewLifecycleOwner2 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner2, "viewLifecycleOwner");
        i0.e.b.d3.k.H(button, q.a(viewLifecycleOwner2), new View.OnClickListener() { // from class: i0.e.b.g3.s.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PaymentsRegistrationFragment paymentsRegistrationFragment = PaymentsRegistrationFragment.this;
                k<Object>[] kVarArr = PaymentsRegistrationFragment.Z1;
                i.e(paymentsRegistrationFragment, "this$0");
                paymentsRegistrationFragment.O0().p(x0.a);
            }
        });
        N0().a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: i0.e.b.g3.s.e
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                PaymentsRegistrationFragment paymentsRegistrationFragment = PaymentsRegistrationFragment.this;
                k<Object>[] kVarArr = PaymentsRegistrationFragment.Z1;
                i.e(paymentsRegistrationFragment, "this$0");
                if (compoundButton.isPressed()) {
                    paymentsRegistrationFragment.O0().p(new f1(z));
                }
            }
        });
        N0().h.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.s.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PaymentsRegistrationFragment paymentsRegistrationFragment = PaymentsRegistrationFragment.this;
                k<Object>[] kVarArr = PaymentsRegistrationFragment.Z1;
                i.e(paymentsRegistrationFragment, "this$0");
                v.a1(paymentsRegistrationFragment, new h0.t.a(R.id.action_paymentsRegistrationFragment_to_recentPaymentsFragment), null, 2);
            }
        });
        N0().p.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.s.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PaymentsRegistrationFragment paymentsRegistrationFragment = PaymentsRegistrationFragment.this;
                k<Object>[] kVarArr = PaymentsRegistrationFragment.Z1;
                i.e(paymentsRegistrationFragment, "this$0");
                DialogEditTextBinding inflate = DialogEditTextBinding.inflate(paymentsRegistrationFragment.getLayoutInflater());
                i.d(inflate, "inflate(layoutInflater)");
                PaymentsRegistrationFragment$showVerifyEmailPromptDialog$1 paymentsRegistrationFragment$showVerifyEmailPromptDialog$1 = 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0018: CONSTRUCTOR  (r1v1 'paymentsRegistrationFragment$showVerifyEmailPromptDialog$1' com.clubhouse.android.ui.payments.PaymentsRegistrationFragment$showVerifyEmailPromptDialog$1) = 
                      (r0v3 'inflate' com.clubhouse.android.databinding.DialogEditTextBinding)
                      (r4v1 'paymentsRegistrationFragment' com.clubhouse.android.ui.payments.PaymentsRegistrationFragment)
                     call: com.clubhouse.android.ui.payments.PaymentsRegistrationFragment$showVerifyEmailPromptDialog$1.<init>(com.clubhouse.android.databinding.DialogEditTextBinding, com.clubhouse.android.ui.payments.PaymentsRegistrationFragment):void type: CONSTRUCTOR in method: i0.e.b.g3.s.b.onClick(android.view.View):void, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:270)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.payments.PaymentsRegistrationFragment$showVerifyEmailPromptDialog$1, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                    	... 15 more
                    */
                /*
                    this = this;
                    com.clubhouse.android.ui.payments.PaymentsRegistrationFragment r4 = com.clubhouse.android.ui.payments.PaymentsRegistrationFragment.this
                    m0.r.k<java.lang.Object>[] r0 = com.clubhouse.android.ui.payments.PaymentsRegistrationFragment.Z1
                    java.lang.String r0 = "this$0"
                    m0.n.b.i.e(r4, r0)
                    android.view.LayoutInflater r0 = r4.getLayoutInflater()
                    com.clubhouse.android.databinding.DialogEditTextBinding r0 = com.clubhouse.android.databinding.DialogEditTextBinding.inflate(r0)
                    java.lang.String r1 = "inflate(layoutInflater)"
                    m0.n.b.i.d(r0, r1)
                    com.clubhouse.android.ui.payments.PaymentsRegistrationFragment$showVerifyEmailPromptDialog$1 r1 = new com.clubhouse.android.ui.payments.PaymentsRegistrationFragment$showVerifyEmailPromptDialog$1
                    r1.<init>(r0, r4)
                    java.lang.String r0 = "<this>"
                    m0.n.b.i.e(r4, r0)
                    java.lang.String r0 = "f"
                    m0.n.b.i.e(r1, r0)
                    h0.b.a.d$a r0 = new h0.b.a.d$a
                    android.content.Context r4 = r4.requireContext()
                    int r2 = com.clubhouse.core.ui.R.style.Clubhouse_AlertDialog_Rounded
                    r0.<init>(r4, r2)
                    r1.invoke(r0)
                    r0.g()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.s.b.onClick(android.view.View):void");
            }
        });
        N0().e.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.s.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PaymentsRegistrationFragment paymentsRegistrationFragment = PaymentsRegistrationFragment.this;
                k<Object>[] kVarArr = PaymentsRegistrationFragment.Z1;
                i.e(paymentsRegistrationFragment, "this$0");
                paymentsRegistrationFragment.P0();
            }
        });
        N0().f.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.s.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PaymentsRegistrationFragment paymentsRegistrationFragment = PaymentsRegistrationFragment.this;
                k<Object>[] kVarArr = PaymentsRegistrationFragment.Z1;
                i.e(paymentsRegistrationFragment, "this$0");
                paymentsRegistrationFragment.P0();
            }
        });
        N0().g.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.s.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PaymentsRegistrationFragment paymentsRegistrationFragment = PaymentsRegistrationFragment.this;
                k<Object>[] kVarArr = PaymentsRegistrationFragment.Z1;
                i.e(paymentsRegistrationFragment, "this$0");
                paymentsRegistrationFragment.P0();
            }
        });
        N0().d.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.s.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PaymentsRegistrationFragment paymentsRegistrationFragment = PaymentsRegistrationFragment.this;
                k<Object>[] kVarArr = PaymentsRegistrationFragment.Z1;
                i.e(paymentsRegistrationFragment, "this$0");
                paymentsRegistrationFragment.P0();
            }
        });
    }
}
