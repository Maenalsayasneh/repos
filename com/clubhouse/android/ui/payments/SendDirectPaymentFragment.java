package com.clubhouse.android.ui.payments;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.clubhouse.android.data.models.local.user.UserProfile;
import com.clubhouse.android.databinding.DialogEditTextBinding;
import com.clubhouse.android.databinding.FragmentSendDirectPaymentBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.shared.ui.AvatarView;
import com.clubhouse.android.ui.payments.SendDirectPaymentFragment;
import com.clubhouse.android.ui.payments.SendDirectPaymentFragment$onViewCreated$6$1;
import com.clubhouse.app.R;
import com.stripe.android.CustomerSession;
import com.stripe.android.PaymentSession;
import com.stripe.android.PaymentSessionConfig;
import com.stripe.android.PaymentSessionData;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import h0.b0.v;
import h0.q.p;
import h0.q.q;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.e.b.d3.n;
import i0.e.b.g3.s.b1;
import i0.e.b.g3.s.j0;
import i0.e.b.g3.s.k0;
import i0.e.b.g3.s.m0;
import i0.e.b.g3.s.p0;
import java.text.NumberFormat;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.c;
import m0.n.a.l;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
/* compiled from: SendDirectPaymentFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010\u0016J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001d\u0010 \u001a\u00020\u001b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010&\u001a\u00020!8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/clubhouse/android/ui/payments/SendDirectPaymentFragment;", "Lcom/clubhouse/android/core/ui/BaseBottomSheetFragment;", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Li0/h/a/c/g/d;", "R0", "(Landroid/os/Bundle;)Li0/h/a/c/g/d;", "", "requestCode", "resultCode", "Landroid/content/Intent;", MessageExtension.FIELD_DATA, "onActivityResult", "(IILandroid/content/Intent;)V", "J", "()V", "Lcom/stripe/android/PaymentSession;", "s2", "Lcom/stripe/android/PaymentSession;", "paymentSession", "Lcom/clubhouse/android/ui/payments/SendDirectPaymentViewModel;", "r2", "Lm0/c;", "V0", "()Lcom/clubhouse/android/ui/payments/SendDirectPaymentViewModel;", "viewModel", "Lcom/clubhouse/android/databinding/FragmentSendDirectPaymentBinding;", "q2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "U0", "()Lcom/clubhouse/android/databinding/FragmentSendDirectPaymentBinding;", "binding", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class SendDirectPaymentFragment extends Hilt_SendDirectPaymentFragment {
    public static final /* synthetic */ k<Object>[] p2 = {m.c(new PropertyReference1Impl(m.a(SendDirectPaymentFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentSendDirectPaymentBinding;")), m.c(new PropertyReference1Impl(m.a(SendDirectPaymentFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/payments/SendDirectPaymentViewModel;"))};
    public final FragmentViewBindingDelegate q2 = new FragmentViewBindingDelegate(FragmentSendDirectPaymentBinding.class, this);
    public final c r2;
    public PaymentSession s2;

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<SendDirectPaymentFragment, SendDirectPaymentViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<SendDirectPaymentViewModel> a(SendDirectPaymentFragment sendDirectPaymentFragment, k kVar) {
            SendDirectPaymentFragment sendDirectPaymentFragment2 = sendDirectPaymentFragment;
            i.e(sendDirectPaymentFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(sendDirectPaymentFragment2, kVar, this.a, new SendDirectPaymentFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(b1.class), false, this.b);
        }
    }

    public SendDirectPaymentFragment() {
        super(R.layout.fragment_send_direct_payment);
        d a2 = m.a(SendDirectPaymentViewModel.class);
        this.r2 = new a(a2, false, new l<i0.b.b.k<SendDirectPaymentViewModel, b1>, SendDirectPaymentViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.payments.SendDirectPaymentFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.clubhouse.android.ui.payments.SendDirectPaymentViewModel, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.l
            public SendDirectPaymentViewModel invoke(i0.b.b.k<SendDirectPaymentViewModel, b1> kVar) {
                i0.b.b.k<SendDirectPaymentViewModel, b1> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, b1.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, p2[1]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(V0(), new l<b1, m0.i>() { // from class: com.clubhouse.android.ui.payments.SendDirectPaymentFragment$invalidate$1
            @Override // m0.n.a.l
            public m0.i invoke(b1 b1Var) {
                Integer num;
                b1 b1Var2 = b1Var;
                i.e(b1Var2, "state");
                SendDirectPaymentFragment sendDirectPaymentFragment = SendDirectPaymentFragment.this;
                k<Object>[] kVarArr = SendDirectPaymentFragment.p2;
                AvatarView avatarView = sendDirectPaymentFragment.U0().b;
                i.d(avatarView, "binding.avatar");
                i0.e.b.d3.k.u(avatarView, b1Var2.a);
                SendDirectPaymentFragment.this.U0().m.setText(b1Var2.a.u2);
                SendDirectPaymentFragment.this.U0().t.setText(SendDirectPaymentFragment.this.requireContext().getString(R.string.username, b1Var2.a.v2));
                Button button = SendDirectPaymentFragment.this.U0().c;
                i.d(button, "binding.backButton");
                Boolean valueOf = Boolean.valueOf(b1Var2.c instanceof k0.a);
                i.e(button, "<this>");
                if (i.a(valueOf, Boolean.TRUE)) {
                    i0.e.b.d3.k.l(button);
                } else {
                    i0.e.b.d3.k.m(button);
                }
                TextView textView = SendDirectPaymentFragment.this.U0().t;
                i.d(textView, "binding.username");
                i0.e.b.d3.k.L(textView, Boolean.valueOf(b1Var2.c instanceof k0.d));
                ConstraintLayout constraintLayout = SendDirectPaymentFragment.this.U0().s;
                i.d(constraintLayout, "binding.selectAmountState");
                i0.e.b.d3.k.L(constraintLayout, Boolean.valueOf(b1Var2.c instanceof k0.d));
                LinearLayout linearLayout = SendDirectPaymentFragment.this.U0().e;
                i.d(linearLayout, "binding.confirmAmountState");
                i0.e.b.d3.k.L(linearLayout, Boolean.valueOf(b1Var2.c instanceof k0.a));
                CardView cardView = SendDirectPaymentFragment.this.U0().q;
                i.d(cardView, "binding.paymentAmountLabel");
                i0.e.b.d3.k.L(cardView, Boolean.valueOf(b1Var2.c instanceof k0.a));
                FrameLayout frameLayout = SendDirectPaymentFragment.this.U0().l;
                i.d(frameLayout, "binding.loadingState");
                i0.e.b.d3.k.L(frameLayout, Boolean.valueOf(b1Var2.c instanceof k0.c));
                ConstraintLayout constraintLayout2 = SendDirectPaymentFragment.this.U0().k;
                i.d(constraintLayout2, "binding.finalizingState");
                i0.e.b.d3.k.L(constraintLayout2, Boolean.valueOf(b1Var2.c instanceof k0.b));
                k0 k0Var = b1Var2.c;
                if (k0Var instanceof k0.a) {
                    Button button2 = SendDirectPaymentFragment.this.U0().f;
                    Context requireContext = SendDirectPaymentFragment.this.requireContext();
                    UserProfile userProfile = b1Var2.a;
                    Objects.requireNonNull(userProfile);
                    k0.a aVar = (k0.a) k0Var;
                    button2.setText(requireContext.getString(R.string.send_amount_dollars, v.f0(userProfile), Integer.valueOf(aVar.a.b() / 100)));
                    SendDirectPaymentFragment.this.U0().d.setText(aVar.c.c);
                    UserProfile userProfile2 = b1Var2.a;
                    int a2 = aVar.a.a(userProfile2.k2, userProfile2.l2);
                    NumberFormat numberInstance = NumberFormat.getNumberInstance();
                    numberInstance.setMinimumIntegerDigits(1);
                    numberInstance.setMinimumFractionDigits(2);
                    numberInstance.setMaximumFractionDigits(2);
                    String format = numberInstance.format(((double) a2) / 100.0d);
                    SendDirectPaymentFragment.this.U0().g.setText(SendDirectPaymentFragment.this.requireContext().getString(R.string.fee_amount_dollars, format));
                    Button button3 = SendDirectPaymentFragment.this.U0().f;
                    Context requireContext2 = SendDirectPaymentFragment.this.requireContext();
                    UserProfile userProfile3 = b1Var2.a;
                    Objects.requireNonNull(userProfile3);
                    button3.setContentDescription(requireContext2.getString(R.string.cd_confirm_payment_dollars, v.f0(userProfile3), Integer.valueOf(aVar.a.b() / 100), format));
                    SendDirectPaymentFragment.this.U0().q.setContentDescription(SendDirectPaymentFragment.this.requireContext().getString(R.string.cd_selected_payment_method, aVar.c.c));
                }
                if (b1Var2.c instanceof k0.b) {
                    TextView textView2 = SendDirectPaymentFragment.this.U0().h;
                    Context requireContext3 = SendDirectPaymentFragment.this.requireContext();
                    Object[] objArr = new Object[1];
                    j0 j0Var = b1Var2.d;
                    if (j0Var == null) {
                        num = null;
                    } else {
                        num = Integer.valueOf(j0Var.b() / 100);
                    }
                    objArr[0] = num;
                    textView2.setText(requireContext3.getString(R.string.amount_dollars, objArr));
                }
                return m0.i.a;
            }
        });
    }

    @Override // com.clubhouse.android.core.ui.BaseBottomSheetFragment, com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog L0(Bundle bundle) {
        i0.h.a.c.g.d R0 = super.L0(bundle);
        R0.setOnKeyListener(new i0.e.b.g3.s.v(this));
        return R0;
    }

    @Override // com.clubhouse.android.core.ui.BaseBottomSheetFragment
    public i0.h.a.c.g.d R0(Bundle bundle) {
        i0.h.a.c.g.d R0 = super.L0(bundle);
        R0.setOnKeyListener(new i0.e.b.g3.s.v(this));
        return R0;
    }

    public final FragmentSendDirectPaymentBinding U0() {
        return (FragmentSendDirectPaymentBinding) this.q2.getValue(this, p2[0]);
    }

    public final SendDirectPaymentViewModel V0() {
        return (SendDirectPaymentViewModel) this.r2.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        V0().p(new m0(i, intent));
        PaymentSession paymentSession = this.s2;
        if (paymentSession != null) {
            paymentSession.handlePaymentData(i, i2, intent);
        } else {
            i.m("paymentSession");
            throw null;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CustomerSession.Companion companion = CustomerSession.Companion;
        Context requireContext = requireContext();
        i.d(requireContext, "requireContext()");
        CustomerSession.Companion.initCustomerSession$default(companion, requireContext, V0(), false, 4, null);
        PaymentSession paymentSession = new PaymentSession(this, new PaymentSessionConfig.Builder().setShippingInfoRequired(false).setShippingMethodsRequired(false).build());
        this.s2 = paymentSession;
        paymentSession.init(new PaymentSession.PaymentSessionListener() { // from class: com.clubhouse.android.ui.payments.SendDirectPaymentFragment$setUpStripe$1
            @Override // com.stripe.android.PaymentSession.PaymentSessionListener
            public void onCommunicatingStateChanged(boolean z) {
            }

            @Override // com.stripe.android.PaymentSession.PaymentSessionListener
            public void onError(int i, String str) {
                i.e(str, "errorMessage");
                SendDirectPaymentFragment sendDirectPaymentFragment = SendDirectPaymentFragment.this;
                k<Object>[] kVarArr = SendDirectPaymentFragment.p2;
                sendDirectPaymentFragment.V0().p(p0.a);
            }

            @Override // com.stripe.android.PaymentSession.PaymentSessionListener
            public void onPaymentSessionDataChanged(PaymentSessionData paymentSessionData) {
                i.e(paymentSessionData, MessageExtension.FIELD_DATA);
                PaymentMethod paymentMethod = paymentSessionData.getPaymentMethod();
                SendDirectPaymentFragment sendDirectPaymentFragment = SendDirectPaymentFragment.this;
                k<Object>[] kVarArr = SendDirectPaymentFragment.p2;
                v.v2(sendDirectPaymentFragment.V0(), 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0018: INVOKE  
                      (wrap: com.clubhouse.android.ui.payments.SendDirectPaymentViewModel : 0x000d: INVOKE  (r0v2 com.clubhouse.android.ui.payments.SendDirectPaymentViewModel A[REMOVE]) = (r0v1 'sendDirectPaymentFragment' com.clubhouse.android.ui.payments.SendDirectPaymentFragment) type: VIRTUAL call: com.clubhouse.android.ui.payments.SendDirectPaymentFragment.V0():com.clubhouse.android.ui.payments.SendDirectPaymentViewModel)
                      (wrap: com.clubhouse.android.ui.payments.SendDirectPaymentFragment$setUpStripe$1$onPaymentSessionDataChanged$1 : 0x0015: CONSTRUCTOR  (r1v1 com.clubhouse.android.ui.payments.SendDirectPaymentFragment$setUpStripe$1$onPaymentSessionDataChanged$1 A[REMOVE]) = 
                      (r4v1 'paymentMethod' com.stripe.android.model.PaymentMethod)
                      (wrap: com.clubhouse.android.ui.payments.SendDirectPaymentFragment : 0x0013: IGET  (r2v0 com.clubhouse.android.ui.payments.SendDirectPaymentFragment A[REMOVE]) = (r3v0 'this' com.clubhouse.android.ui.payments.SendDirectPaymentFragment$setUpStripe$1 A[IMMUTABLE_TYPE, THIS]) com.clubhouse.android.ui.payments.SendDirectPaymentFragment$setUpStripe$1.a com.clubhouse.android.ui.payments.SendDirectPaymentFragment)
                     call: com.clubhouse.android.ui.payments.SendDirectPaymentFragment$setUpStripe$1$onPaymentSessionDataChanged$1.<init>(com.stripe.android.model.PaymentMethod, com.clubhouse.android.ui.payments.SendDirectPaymentFragment):void type: CONSTRUCTOR)
                     type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: com.clubhouse.android.ui.payments.SendDirectPaymentFragment$setUpStripe$1.onPaymentSessionDataChanged(com.stripe.android.PaymentSessionData):void, file: classes3.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.payments.SendDirectPaymentFragment$setUpStripe$1$onPaymentSessionDataChanged$1, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:974)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:799)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                    	... 15 more
                    */
                /*
                    this = this;
                    java.lang.String r0 = "data"
                    m0.n.b.i.e(r4, r0)
                    com.stripe.android.model.PaymentMethod r4 = r4.getPaymentMethod()
                    com.clubhouse.android.ui.payments.SendDirectPaymentFragment r0 = com.clubhouse.android.ui.payments.SendDirectPaymentFragment.this
                    m0.r.k<java.lang.Object>[] r1 = com.clubhouse.android.ui.payments.SendDirectPaymentFragment.p2
                    com.clubhouse.android.ui.payments.SendDirectPaymentViewModel r0 = r0.V0()
                    com.clubhouse.android.ui.payments.SendDirectPaymentFragment$setUpStripe$1$onPaymentSessionDataChanged$1 r1 = new com.clubhouse.android.ui.payments.SendDirectPaymentFragment$setUpStripe$1$onPaymentSessionDataChanged$1
                    com.clubhouse.android.ui.payments.SendDirectPaymentFragment r2 = com.clubhouse.android.ui.payments.SendDirectPaymentFragment.this
                    r1.<init>(r4, r2)
                    h0.b0.v.v2(r0, r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.clubhouse.android.ui.payments.SendDirectPaymentFragment$setUpStripe$1.onPaymentSessionDataChanged(com.stripe.android.PaymentSessionData):void");
            }
        });
    }

    @Override // com.clubhouse.android.core.ui.BaseBottomSheetFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.e(view, "view");
        super.onViewCreated(view, bundle);
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(V0().l, new SendDirectPaymentFragment$onViewCreated$1(this, null));
        p viewLifecycleOwner = getViewLifecycleOwner();
        i.d(viewLifecycleOwner, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner));
        U0().b.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.s.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SendDirectPaymentFragment sendDirectPaymentFragment = SendDirectPaymentFragment.this;
                k<Object>[] kVarArr = SendDirectPaymentFragment.p2;
                i.e(sendDirectPaymentFragment, "this$0");
                v.v2(sendDirectPaymentFragment.V0(), 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: INVOKE  
                      (wrap: com.clubhouse.android.ui.payments.SendDirectPaymentViewModel : 0x0009: INVOKE  (r0v2 com.clubhouse.android.ui.payments.SendDirectPaymentViewModel A[REMOVE]) = (r3v1 'sendDirectPaymentFragment' com.clubhouse.android.ui.payments.SendDirectPaymentFragment) type: VIRTUAL call: com.clubhouse.android.ui.payments.SendDirectPaymentFragment.V0():com.clubhouse.android.ui.payments.SendDirectPaymentViewModel)
                      (wrap: com.clubhouse.android.ui.payments.SendDirectPaymentFragment$onViewCreated$2$1 : 0x000f: CONSTRUCTOR  (r1v0 com.clubhouse.android.ui.payments.SendDirectPaymentFragment$onViewCreated$2$1 A[REMOVE]) = (r3v1 'sendDirectPaymentFragment' com.clubhouse.android.ui.payments.SendDirectPaymentFragment) call: com.clubhouse.android.ui.payments.SendDirectPaymentFragment$onViewCreated$2$1.<init>(com.clubhouse.android.ui.payments.SendDirectPaymentFragment):void type: CONSTRUCTOR)
                     type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: i0.e.b.g3.s.z.onClick(android.view.View):void, file: classes3.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.payments.SendDirectPaymentFragment$onViewCreated$2$1, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:974)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:799)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                    	... 15 more
                    */
                /*
                    this = this;
                    com.clubhouse.android.ui.payments.SendDirectPaymentFragment r3 = com.clubhouse.android.ui.payments.SendDirectPaymentFragment.this
                    m0.r.k<java.lang.Object>[] r0 = com.clubhouse.android.ui.payments.SendDirectPaymentFragment.p2
                    java.lang.String r0 = "this$0"
                    m0.n.b.i.e(r3, r0)
                    com.clubhouse.android.ui.payments.SendDirectPaymentViewModel r0 = r3.V0()
                    com.clubhouse.android.ui.payments.SendDirectPaymentFragment$onViewCreated$2$1 r1 = new com.clubhouse.android.ui.payments.SendDirectPaymentFragment$onViewCreated$2$1
                    r1.<init>(r3)
                    h0.b0.v.v2(r0, r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.s.z.onClick(android.view.View):void");
            }
        });
        Button button = U0().p;
        i.d(button, "binding.paymentAmount5");
        p viewLifecycleOwner2 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner2, "viewLifecycleOwner");
        i0.e.b.d3.k.H(button, q.a(viewLifecycleOwner2), new View.OnClickListener() { // from class: i0.e.b.g3.s.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SendDirectPaymentFragment sendDirectPaymentFragment = SendDirectPaymentFragment.this;
                k<Object>[] kVarArr = SendDirectPaymentFragment.p2;
                i.e(sendDirectPaymentFragment, "this$0");
                sendDirectPaymentFragment.V0().p(new h0(j0.a.b));
            }
        });
        Button button2 = U0().n;
        i.d(button2, "binding.paymentAmount10");
        p viewLifecycleOwner3 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner3, "viewLifecycleOwner");
        i0.e.b.d3.k.H(button2, q.a(viewLifecycleOwner3), new View.OnClickListener() { // from class: i0.e.b.g3.s.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SendDirectPaymentFragment sendDirectPaymentFragment = SendDirectPaymentFragment.this;
                k<Object>[] kVarArr = SendDirectPaymentFragment.p2;
                i.e(sendDirectPaymentFragment, "this$0");
                sendDirectPaymentFragment.V0().p(new h0(j0.c.b));
            }
        });
        Button button3 = U0().o;
        i.d(button3, "binding.paymentAmount20");
        p viewLifecycleOwner4 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner4, "viewLifecycleOwner");
        i0.e.b.d3.k.H(button3, q.a(viewLifecycleOwner4), new View.OnClickListener() { // from class: i0.e.b.g3.s.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SendDirectPaymentFragment sendDirectPaymentFragment = SendDirectPaymentFragment.this;
                k<Object>[] kVarArr = SendDirectPaymentFragment.p2;
                i.e(sendDirectPaymentFragment, "this$0");
                sendDirectPaymentFragment.V0().p(new h0(j0.d.b));
            }
        });
        Button button4 = U0().r;
        i.d(button4, "binding.paymentAmountOther");
        p viewLifecycleOwner5 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner5, "viewLifecycleOwner");
        i0.e.b.d3.k.H(button4, q.a(viewLifecycleOwner5), new View.OnClickListener() { // from class: i0.e.b.g3.s.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SendDirectPaymentFragment sendDirectPaymentFragment = SendDirectPaymentFragment.this;
                k<Object>[] kVarArr = SendDirectPaymentFragment.p2;
                i.e(sendDirectPaymentFragment, "this$0");
                DialogEditTextBinding inflate = DialogEditTextBinding.inflate(sendDirectPaymentFragment.getLayoutInflater());
                i.d(inflate, "inflate(layoutInflater)");
                inflate.b.setHint(sendDirectPaymentFragment.requireContext().getString(R.string.enter_amount_hint_dollars));
                inflate.b.setInputType(2);
                inflate.b.setKeyListener(DigitsKeyListener.getInstance(sendDirectPaymentFragment.requireContext().getString(R.string.allowed_payment_amount_symbols)));
                inflate.b.setText("$");
                inflate.b.setSelection(1);
                EditText editText = inflate.b;
                i.d(editText, "binding.text");
                i.e(editText, "<this>");
                i.e("$", "prefix");
                editText.addTextChangedListener(new n(editText, "$"));
                SendDirectPaymentFragment$onViewCreated$6$1 sendDirectPaymentFragment$onViewCreated$6$1 = 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0068: CONSTRUCTOR  (r1v7 'sendDirectPaymentFragment$onViewCreated$6$1' com.clubhouse.android.ui.payments.SendDirectPaymentFragment$onViewCreated$6$1) = 
                      (r0v3 'inflate' com.clubhouse.android.databinding.DialogEditTextBinding)
                      (r6v1 'sendDirectPaymentFragment' com.clubhouse.android.ui.payments.SendDirectPaymentFragment)
                     call: com.clubhouse.android.ui.payments.SendDirectPaymentFragment$onViewCreated$6$1.<init>(com.clubhouse.android.databinding.DialogEditTextBinding, com.clubhouse.android.ui.payments.SendDirectPaymentFragment):void type: CONSTRUCTOR in method: i0.e.b.g3.s.u.onClick(android.view.View):void, file: classes3.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.payments.SendDirectPaymentFragment$onViewCreated$6$1, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                    	... 15 more
                    */
                /*
                    this = this;
                    com.clubhouse.android.ui.payments.SendDirectPaymentFragment r6 = com.clubhouse.android.ui.payments.SendDirectPaymentFragment.this
                    m0.r.k<java.lang.Object>[] r0 = com.clubhouse.android.ui.payments.SendDirectPaymentFragment.p2
                    java.lang.String r0 = "this$0"
                    m0.n.b.i.e(r6, r0)
                    android.view.LayoutInflater r0 = r6.getLayoutInflater()
                    com.clubhouse.android.databinding.DialogEditTextBinding r0 = com.clubhouse.android.databinding.DialogEditTextBinding.inflate(r0)
                    java.lang.String r1 = "inflate(layoutInflater)"
                    m0.n.b.i.d(r0, r1)
                    android.widget.EditText r1 = r0.b
                    android.content.Context r2 = r6.requireContext()
                    r3 = 2131952076(0x7f1301cc, float:1.9540585E38)
                    java.lang.String r2 = r2.getString(r3)
                    r1.setHint(r2)
                    android.widget.EditText r1 = r0.b
                    r2 = 2
                    r1.setInputType(r2)
                    android.widget.EditText r1 = r0.b
                    android.content.Context r2 = r6.requireContext()
                    r3 = 2131951740(0x7f13007c, float:1.9539903E38)
                    java.lang.String r2 = r2.getString(r3)
                    android.text.method.DigitsKeyListener r2 = android.text.method.DigitsKeyListener.getInstance(r2)
                    r1.setKeyListener(r2)
                    android.widget.EditText r1 = r0.b
                    java.lang.String r2 = "$"
                    r1.setText(r2)
                    android.widget.EditText r1 = r0.b
                    r3 = 1
                    r1.setSelection(r3)
                    android.widget.EditText r1 = r0.b
                    java.lang.String r3 = "binding.text"
                    m0.n.b.i.d(r1, r3)
                    java.lang.String r3 = "<this>"
                    m0.n.b.i.e(r1, r3)
                    java.lang.String r4 = "prefix"
                    m0.n.b.i.e(r2, r4)
                    i0.e.b.d3.n r4 = new i0.e.b.d3.n
                    r4.<init>(r1, r2)
                    r1.addTextChangedListener(r4)
                    com.clubhouse.android.ui.payments.SendDirectPaymentFragment$onViewCreated$6$1 r1 = new com.clubhouse.android.ui.payments.SendDirectPaymentFragment$onViewCreated$6$1
                    r1.<init>(r0, r6)
                    m0.n.b.i.e(r6, r3)
                    java.lang.String r0 = "f"
                    m0.n.b.i.e(r1, r0)
                    h0.b.a.d$a r0 = new h0.b.a.d$a
                    android.content.Context r6 = r6.requireContext()
                    int r2 = com.clubhouse.core.ui.R.style.Clubhouse_AlertDialog_Rounded
                    r0.<init>(r6, r2)
                    r1.invoke(r0)
                    r0.g()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.s.u.onClick(android.view.View):void");
            }
        });
        U0().q.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.s.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SendDirectPaymentFragment sendDirectPaymentFragment = SendDirectPaymentFragment.this;
                k<Object>[] kVarArr = SendDirectPaymentFragment.p2;
                i.e(sendDirectPaymentFragment, "this$0");
                PaymentSession paymentSession = sendDirectPaymentFragment.s2;
                if (paymentSession != null) {
                    PaymentSession.presentPaymentMethodSelection$default(paymentSession, null, 1, null);
                } else {
                    i.m("paymentSession");
                    throw null;
                }
            }
        });
        Button button5 = U0().f;
        i.d(button5, "binding.confirmButton");
        p viewLifecycleOwner6 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner6, "viewLifecycleOwner");
        i0.e.b.d3.k.H(button5, q.a(viewLifecycleOwner6), new View.OnClickListener() { // from class: i0.e.b.g3.s.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SendDirectPaymentFragment sendDirectPaymentFragment = SendDirectPaymentFragment.this;
                k<Object>[] kVarArr = SendDirectPaymentFragment.p2;
                i.e(sendDirectPaymentFragment, "this$0");
                sendDirectPaymentFragment.V0().p(i0.a);
            }
        });
        Button button6 = U0().c;
        i.d(button6, "binding.backButton");
        p viewLifecycleOwner7 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner7, "viewLifecycleOwner");
        i0.e.b.d3.k.H(button6, q.a(viewLifecycleOwner7), new View.OnClickListener() { // from class: i0.e.b.g3.s.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SendDirectPaymentFragment sendDirectPaymentFragment = SendDirectPaymentFragment.this;
                k<Object>[] kVarArr = SendDirectPaymentFragment.p2;
                i.e(sendDirectPaymentFragment, "this$0");
                sendDirectPaymentFragment.V0().p(y0.a);
            }
        });
    }
}
