package com.clubhouse.android.ui.payments;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import com.clubhouse.android.data.models.local.payment.RecentPayment;
import com.clubhouse.android.databinding.FragmentAcknowledgePaymentBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.shared.ui.AvatarView;
import com.clubhouse.android.ui.payments.AcknowledgePaymentFragment;
import com.clubhouse.app.R;
import com.google.android.material.textfield.TextInputEditText;
import h0.b0.v;
import h0.q.p;
import h0.q.q;
import i0.b.b.i;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.n.b.m;
import m0.o.c;
import m0.r.k;
import m0.r.t.a.r.m.a1.a;
/* compiled from: AcknowledgePaymentFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\u00020\r8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0018\u001a\u00020\u00138B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/clubhouse/android/ui/payments/AcknowledgePaymentFragment;", "Lcom/clubhouse/android/core/ui/BaseBottomSheetFragment;", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lcom/clubhouse/android/ui/payments/AcknowledgePaymentArgs;", "r2", "Lm0/o/c;", "getArgs", "()Lcom/clubhouse/android/ui/payments/AcknowledgePaymentArgs;", "args", "Lcom/clubhouse/android/databinding/FragmentAcknowledgePaymentBinding;", "q2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "U0", "()Lcom/clubhouse/android/databinding/FragmentAcknowledgePaymentBinding;", "binding", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class AcknowledgePaymentFragment extends Hilt_AcknowledgePaymentFragment {
    public static final /* synthetic */ k<Object>[] p2 = {m.c(new PropertyReference1Impl(m.a(AcknowledgePaymentFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentAcknowledgePaymentBinding;")), m.c(new PropertyReference1Impl(m.a(AcknowledgePaymentFragment.class), "args", "getArgs()Lcom/clubhouse/android/ui/payments/AcknowledgePaymentArgs;"))};
    public final FragmentViewBindingDelegate q2 = new FragmentViewBindingDelegate(FragmentAcknowledgePaymentBinding.class, this);
    public final c r2 = new i();

    public AcknowledgePaymentFragment() {
        super(R.layout.fragment_acknowledge_payment);
    }

    @Override // i0.b.b.q
    public void J() {
    }

    public final FragmentAcknowledgePaymentBinding U0() {
        return (FragmentAcknowledgePaymentBinding) this.q2.getValue(this, p2[0]);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        N0(0, 2132017459);
    }

    @Override // com.clubhouse.android.core.ui.BaseBottomSheetFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m0.n.b.i.e(view, "view");
        super.onViewCreated(view, bundle);
        v.U1(this);
        v.h2(this);
        RecentPayment recentPayment = ((AcknowledgePaymentArgs) this.r2.getValue(this, p2[1])).c;
        AvatarView avatarView = U0().b;
        m0.n.b.i.d(avatarView, "binding.avatar");
        v.S0(avatarView, recentPayment.y, recentPayment.x, 0.0f, 4);
        U0().c.setText(recentPayment.x);
        U0().f.setText(v.M1(recentPayment.Z1));
        U0().a.setText(getString(R.string.amount_dollars, Integer.valueOf(recentPayment.d / 100)));
        String string = getString(R.string.thank_you_default_message, StringsKt__IndentKt.D(recentPayment.x, new char[]{' '}, false, 0, 6).get(0));
        m0.n.b.i.d(string, "getString(R.string.thank_you_default_message, recentPayment.fromName.split(' ').get(0))");
        U0().e.setText(string);
        U0().e.setSelection(string.length());
        TextInputEditText textInputEditText = U0().e;
        m0.n.b.i.d(textInputEditText, "binding.text");
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(i0.e.b.d3.k.M(textInputEditText), new AcknowledgePaymentFragment$onViewCreated$1(this, null));
        p viewLifecycleOwner = getViewLifecycleOwner();
        m0.n.b.i.d(viewLifecycleOwner, "viewLifecycleOwner");
        a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner));
        U0().d.setOnClickListener(new View.OnClickListener(recentPayment) { // from class: i0.e.b.g3.s.a
            public final /* synthetic */ RecentPayment d;

            {
                this.d = r2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AcknowledgePaymentFragment acknowledgePaymentFragment = AcknowledgePaymentFragment.this;
                RecentPayment recentPayment2 = this.d;
                k<Object>[] kVarArr = AcknowledgePaymentFragment.p2;
                m0.n.b.i.e(acknowledgePaymentFragment, "this$0");
                m0.n.b.i.e(recentPayment2, "$recentPayment");
                Editable text = acknowledgePaymentFragment.U0().e.getText();
                boolean z = false;
                if (text != null && !StringsKt__IndentKt.o(text)) {
                    z = true;
                }
                if (z) {
                    v.V1(acknowledgePaymentFragment, "thank_you_message", new Pair(Integer.valueOf(recentPayment2.c), String.valueOf(acknowledgePaymentFragment.U0().e.getText())));
                    v.c1(acknowledgePaymentFragment);
                }
            }
        });
    }
}
