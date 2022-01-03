package com.clubhouse.android.ui.payments;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.airbnb.epoxy.paging3.PagingDataEpoxyController;
import com.clubhouse.android.data.models.local.payment.RecentPayment;
import com.clubhouse.android.data.models.local.user.SourceLocation;
import com.clubhouse.android.databinding.FragmentRecentPaymentsBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.ui.payments.RecentPaymentsFragment;
import com.clubhouse.android.ui.profile.ProfileArgs;
import com.clubhouse.core.ui.R;
import h0.b.a.d;
import h0.b0.v;
import i0.b.a.t;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.e.b.g3.s.e0;
import i0.e.b.g3.s.i1.b;
import i0.e.b.g3.s.o;
import i0.e.b.g3.s.p;
import i0.e.b.g3.s.q;
import i0.e.b.g3.s.u0;
import i0.e.b.g3.s.v0;
import j$.time.OffsetDateTime;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.c;
import m0.n.a.l;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.k;
import m0.r.t.a.r.m.a1.a;
import n0.a.f0;
import n0.a.f1;
/* compiled from: RecentPaymentsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001b\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u000e\u001a\u00060\u000bR\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001d\u0010\u0014\u001a\u00020\u000f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u001a\u001a\u00020\u00158B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/clubhouse/android/ui/payments/RecentPaymentsFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lcom/clubhouse/android/ui/payments/RecentPaymentsFragment$RecentPaymentItemContoller;", "c2", "Lcom/clubhouse/android/ui/payments/RecentPaymentsFragment$RecentPaymentItemContoller;", "pagedController", "Lcom/clubhouse/android/databinding/FragmentRecentPaymentsBinding;", "a2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "N0", "()Lcom/clubhouse/android/databinding/FragmentRecentPaymentsBinding;", "binding", "Lcom/clubhouse/android/ui/payments/RecentPaymentsViewModel;", "b2", "Lm0/c;", "O0", "()Lcom/clubhouse/android/ui/payments/RecentPaymentsViewModel;", "viewModel", "<init>", "RecentPaymentItemContoller", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class RecentPaymentsFragment extends Hilt_RecentPaymentsFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(RecentPaymentsFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentRecentPaymentsBinding;")), m.c(new PropertyReference1Impl(m.a(RecentPaymentsFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/payments/RecentPaymentsViewModel;"))};
    public final c b2;
    public final FragmentViewBindingDelegate a2 = new FragmentViewBindingDelegate(FragmentRecentPaymentsBinding.class, this);
    public final RecentPaymentItemContoller c2 = new RecentPaymentItemContoller(this);

    /* compiled from: RecentPaymentsFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ%\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/clubhouse/android/ui/payments/RecentPaymentsFragment$RecentPaymentItemContoller;", "Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;", "Li0/e/b/b3/b/e/k;", "", "currentPosition", "item", "Li0/b/a/t;", "buildItemModel", "(ILi0/e/b/b3/b/e/k;)Li0/b/a/t;", "<init>", "(Lcom/clubhouse/android/ui/payments/RecentPaymentsFragment;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public final class RecentPaymentItemContoller extends PagingDataEpoxyController<i0.e.b.b3.b.e.k> {
        public final /* synthetic */ RecentPaymentsFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RecentPaymentItemContoller(RecentPaymentsFragment recentPaymentsFragment) {
            super(null, null, null, 7, null);
            i.e(recentPaymentsFragment, "this$0");
            this.this$0 = recentPaymentsFragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: buildItemModel$lambda-0  reason: not valid java name */
        public static final void m12buildItemModel$lambda0(RecentPaymentsFragment recentPaymentsFragment, RecentPayment recentPayment, View view) {
            i.e(recentPaymentsFragment, "this$0");
            i.e(recentPayment, "$recentPayment");
            ProfileArgs profileArgs = new ProfileArgs(Integer.valueOf(recentPayment.q), null, null, false, null, SourceLocation.UNKNOWN, null, 94);
            i.e(profileArgs, "mavericksArg");
            v.a1(recentPaymentsFragment, new u0(profileArgs, null), null, 2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: buildItemModel$lambda-1  reason: not valid java name */
        public static final void m13buildItemModel$lambda1(RecentPaymentsFragment recentPaymentsFragment, RecentPayment recentPayment, View view) {
            i.e(recentPaymentsFragment, "this$0");
            i.e(recentPayment, "$recentPayment");
            AcknowledgePaymentArgs acknowledgePaymentArgs = new AcknowledgePaymentArgs(recentPayment);
            i.e(acknowledgePaymentArgs, "mavericksArg");
            v.a1(recentPaymentsFragment, new v0(acknowledgePaymentArgs), null, 2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: buildItemModel$lambda-2  reason: not valid java name */
        public static final void m14buildItemModel$lambda2(RecentPaymentsFragment recentPaymentsFragment, RecentPayment recentPayment, View view) {
            i.e(recentPaymentsFragment, "this$0");
            i.e(recentPayment, "$recentPayment");
            RecentPaymentsFragment$RecentPaymentItemContoller$buildItemModel$3$1 recentPaymentsFragment$RecentPaymentItemContoller$buildItemModel$3$1 = new RecentPaymentsFragment$RecentPaymentItemContoller$buildItemModel$3$1(recentPaymentsFragment, recentPayment);
            i.e(recentPaymentsFragment, "<this>");
            i.e(recentPaymentsFragment$RecentPaymentItemContoller$buildItemModel$3$1, "f");
            d.a aVar = new d.a(recentPaymentsFragment.requireContext(), R.style.Clubhouse_AlertDialog_Rounded);
            recentPaymentsFragment$RecentPaymentItemContoller$buildItemModel$3$1.invoke(aVar);
            aVar.g();
        }

        public t<?> buildItemModel(int i, i0.e.b.b3.b.e.k kVar) {
            if (kVar != null) {
                RecentPayment recentPayment = kVar.b;
                b bVar = new b();
                bVar.t(Integer.valueOf(recentPayment.c));
                String string = this.this$0.getString(com.clubhouse.app.R.string.amount_dollars, Integer.valueOf(recentPayment.d / 100));
                bVar.w();
                bVar.l = string;
                String str = recentPayment.y;
                bVar.w();
                bVar.j = str;
                String str2 = recentPayment.x;
                bVar.w();
                bVar.k = str2;
                OffsetDateTime offsetDateTime = recentPayment.Z1;
                bVar.w();
                bVar.n = offsetDateTime;
                Boolean valueOf = Boolean.valueOf(recentPayment.Y1);
                bVar.w();
                bVar.m = valueOf;
                p pVar = new p(this.this$0, recentPayment);
                bVar.w();
                bVar.o = pVar;
                o oVar = new o(this.this$0, recentPayment);
                bVar.w();
                bVar.q = oVar;
                q qVar = new q(this.this$0, recentPayment);
                bVar.w();
                bVar.p = qVar;
                i.d(bVar, "RecentPaymentItem_()\n                .id(recentPayment.id)\n                .amount(getString(R.string.amount_dollars, recentPayment.amountCents / 100))\n                .photoUrl(recentPayment.fromPhotoUrl)\n                .name(recentPayment.fromName)\n                .timeCreated(recentPayment.timeCreated)\n                .acknowledged(recentPayment.isAcknowledged)\n                .avatarClickListener { _ ->\n                    navigateSafe(\n                        RecentPaymentsFragmentDirections.actionRecentPaymentsFragmentToProfileFragment(\n                            ProfileArgs(\n                                userId = recentPayment.fromId,\n                                source = SourceLocation.UNKNOWN)\n                        )\n                    )\n                }\n                .unAcknowledgedClickListener { _ ->\n                    navigateSafe(\n                        RecentPaymentsFragmentDirections\n                            .actionRecentPaymentsFragmentToSayThanksDialog(\n                                AcknowledgePaymentArgs(recentPayment)\n                            )\n                    )\n                }\n                .acknowledgedClickListener { _ ->\n                    alertDialog {\n                        setTitle(R.string.all_set)\n                        setMessage(\n                            getString(\n                                R.string.already_thanked,\n                                recentPayment.fromName,\n                                recentPayment.amountCents / 100\n                            )\n                        )\n                        setPositiveButton(R.string.ok) { dialog, _ ->\n                            dialog.dismiss()\n                        }\n                    }\n                }");
                return bVar;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<RecentPaymentsFragment, RecentPaymentsViewModel> {
        public final /* synthetic */ m0.r.d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ m0.r.d c;

        public a(m0.r.d dVar, boolean z, l lVar, m0.r.d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<RecentPaymentsViewModel> a(RecentPaymentsFragment recentPaymentsFragment, k kVar) {
            RecentPaymentsFragment recentPaymentsFragment2 = recentPaymentsFragment;
            i.e(recentPaymentsFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(recentPaymentsFragment2, kVar, this.a, new RecentPaymentsFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(GetRecentPaymentsState.class), false, this.b);
        }
    }

    public RecentPaymentsFragment() {
        super(com.clubhouse.app.R.layout.fragment_recent_payments);
        m0.r.d a2 = m.a(RecentPaymentsViewModel.class);
        this.b2 = new a(a2, false, new l<i0.b.b.k<RecentPaymentsViewModel, GetRecentPaymentsState>, RecentPaymentsViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.payments.RecentPaymentsFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ m0.r.d d;
            public final /* synthetic */ m0.r.d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.clubhouse.android.ui.payments.RecentPaymentsViewModel, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.l
            public RecentPaymentsViewModel invoke(i0.b.b.k<RecentPaymentsViewModel, GetRecentPaymentsState> kVar) {
                i0.b.b.k<RecentPaymentsViewModel, GetRecentPaymentsState> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, GetRecentPaymentsState.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, Z1[1]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(O0(), new l<GetRecentPaymentsState, f1>() { // from class: com.clubhouse.android.ui.payments.RecentPaymentsFragment$invalidate$1
            @Override // m0.n.a.l
            public f1 invoke(GetRecentPaymentsState getRecentPaymentsState) {
                final GetRecentPaymentsState getRecentPaymentsState2 = getRecentPaymentsState;
                i.e(getRecentPaymentsState2, "state");
                h0.q.p viewLifecycleOwner = RecentPaymentsFragment.this.getViewLifecycleOwner();
                i.d(viewLifecycleOwner, "viewLifecycleOwner");
                LifecycleCoroutineScope a2 = h0.q.q.a(viewLifecycleOwner);
                final RecentPaymentsFragment recentPaymentsFragment = RecentPaymentsFragment.this;
                return a.E2(a2, null, null, new m0.n.a.p<f0, m0.l.c<? super m0.i>, Object>(null) { // from class: com.clubhouse.android.ui.payments.RecentPaymentsFragment$invalidate$1.1
                    public int c;

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final m0.l.c<m0.i> create(Object obj, m0.l.c<?> cVar) {
                        return 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0009: INVOKE  
                              (wrap: com.clubhouse.android.ui.payments.RecentPaymentsViewModel : 0x0000: INVOKE  (r0v0 com.clubhouse.android.ui.payments.RecentPaymentsViewModel A[REMOVE]) = (r2v0 'this' com.clubhouse.android.ui.payments.RecentPaymentsFragment A[IMMUTABLE_TYPE, THIS]) type: VIRTUAL call: com.clubhouse.android.ui.payments.RecentPaymentsFragment.O0():com.clubhouse.android.ui.payments.RecentPaymentsViewModel)
                              (wrap: com.clubhouse.android.ui.payments.RecentPaymentsFragment$invalidate$1 : 0x0006: CONSTRUCTOR  (r1v0 com.clubhouse.android.ui.payments.RecentPaymentsFragment$invalidate$1 A[REMOVE]) = (r2v0 'this' com.clubhouse.android.ui.payments.RecentPaymentsFragment A[IMMUTABLE_TYPE, THIS]) call: com.clubhouse.android.ui.payments.RecentPaymentsFragment$invalidate$1.<init>(com.clubhouse.android.ui.payments.RecentPaymentsFragment):void type: CONSTRUCTOR)
                             type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: com.clubhouse.android.ui.payments.RecentPaymentsFragment.J():void, file: classes3.dex
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
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method generation error
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:307)
                            	... 5 more
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0026: RETURN  
                              (wrap: n0.a.f1 : 0x0022: INVOKE  (r9v2 n0.a.f1 A[REMOVE]) = 
                              (r2v0 'a2' androidx.lifecycle.LifecycleCoroutineScope)
                              (null m0.l.e)
                              (null kotlinx.coroutines.CoroutineStart)
                              (wrap: com.clubhouse.android.ui.payments.RecentPaymentsFragment$invalidate$1$1 : 0x001b: CONSTRUCTOR  (r5v0 com.clubhouse.android.ui.payments.RecentPaymentsFragment$invalidate$1$1 A[REMOVE]) = 
                              (r0v3 'recentPaymentsFragment' com.clubhouse.android.ui.payments.RecentPaymentsFragment A[DONT_INLINE, SKIP_ARG])
                              (r9v1 'getRecentPaymentsState2' com.clubhouse.android.ui.payments.GetRecentPaymentsState A[DONT_INLINE, SKIP_ARG])
                              (null m0.l.c)
                             call: com.clubhouse.android.ui.payments.RecentPaymentsFragment$invalidate$1.1.<init>(com.clubhouse.android.ui.payments.RecentPaymentsFragment, com.clubhouse.android.ui.payments.GetRecentPaymentsState, m0.l.c):void type: CONSTRUCTOR)
                              (3 int)
                              (null java.lang.Object)
                             type: STATIC call: m0.r.t.a.r.m.a1.a.E2(n0.a.f0, m0.l.e, kotlinx.coroutines.CoroutineStart, m0.n.a.p, int, java.lang.Object):n0.a.f1)
                             in method: com.clubhouse.android.ui.payments.RecentPaymentsFragment$invalidate$1.invoke(com.clubhouse.android.ui.payments.GetRecentPaymentsState):n0.a.f1, file: classes3.dex
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
                            	... 5 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method generation error
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:307)
                            	... 5 more
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0009: RETURN  
                              (wrap: com.clubhouse.android.ui.payments.RecentPaymentsFragment$invalidate$1$1 : 0x0006: CONSTRUCTOR  (r3v1 com.clubhouse.android.ui.payments.RecentPaymentsFragment$invalidate$1$1 A[REMOVE]) = 
                              (wrap: com.clubhouse.android.ui.payments.RecentPaymentsFragment : 0x0002: IGET  (r0v0 com.clubhouse.android.ui.payments.RecentPaymentsFragment A[REMOVE]) = (r2v0 'this' com.clubhouse.android.ui.payments.RecentPaymentsFragment$invalidate$1$1 A[IMMUTABLE_TYPE, THIS]) com.clubhouse.android.ui.payments.RecentPaymentsFragment$invalidate$1.1.d com.clubhouse.android.ui.payments.RecentPaymentsFragment)
                              (wrap: com.clubhouse.android.ui.payments.GetRecentPaymentsState : 0x0004: IGET  (r1v0 com.clubhouse.android.ui.payments.GetRecentPaymentsState A[REMOVE]) = (r2v0 'this' com.clubhouse.android.ui.payments.RecentPaymentsFragment$invalidate$1$1 A[IMMUTABLE_TYPE, THIS]) com.clubhouse.android.ui.payments.RecentPaymentsFragment$invalidate$1.1.q com.clubhouse.android.ui.payments.GetRecentPaymentsState)
                              (r4v0 'cVar' m0.l.c<?>)
                             call: com.clubhouse.android.ui.payments.RecentPaymentsFragment$invalidate$1.1.<init>(com.clubhouse.android.ui.payments.RecentPaymentsFragment, com.clubhouse.android.ui.payments.GetRecentPaymentsState, m0.l.c):void type: CONSTRUCTOR)
                             in method: com.clubhouse.android.ui.payments.RecentPaymentsFragment$invalidate$1.1.create(java.lang.Object, m0.l.c<?>):m0.l.c<m0.i>, file: classes3.dex
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
                            	... 5 more
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: com.clubhouse.android.ui.payments.RecentPaymentsFragment$invalidate$1.1
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:718)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:669)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:328)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                            	... 15 more
                            */
                        /*
                            this = this;
                            com.clubhouse.android.ui.payments.RecentPaymentsViewModel r0 = r2.O0()
                            com.clubhouse.android.ui.payments.RecentPaymentsFragment$invalidate$1 r1 = new com.clubhouse.android.ui.payments.RecentPaymentsFragment$invalidate$1
                            r1.<init>()
                            h0.b0.v.v2(r0, r1)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.clubhouse.android.ui.payments.RecentPaymentsFragment.J():void");
                    }

                    public final FragmentRecentPaymentsBinding N0() {
                        return (FragmentRecentPaymentsBinding) this.a2.getValue(this, Z1[0]);
                    }

                    public final RecentPaymentsViewModel O0() {
                        return (RecentPaymentsViewModel) this.b2.getValue();
                    }

                    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
                    public void onViewCreated(View view, Bundle bundle) {
                        i.e(view, "view");
                        super.onViewCreated(view, bundle);
                        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(O0().l, new RecentPaymentsFragment$onViewCreated$1(this, null));
                        h0.q.p viewLifecycleOwner = getViewLifecycleOwner();
                        i.d(viewLifecycleOwner, "viewLifecycleOwner");
                        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, h0.q.q.a(viewLifecycleOwner));
                        N0().a.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.s.n
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                RecentPaymentsFragment recentPaymentsFragment = RecentPaymentsFragment.this;
                                k<Object>[] kVarArr = RecentPaymentsFragment.Z1;
                                i.e(recentPaymentsFragment, "this$0");
                                v.c1(recentPaymentsFragment);
                            }
                        });
                        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$12 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(v.f1(this.c2), new RecentPaymentsFragment$configurePagingController$1(this, null));
                        h0.q.p viewLifecycleOwner2 = getViewLifecycleOwner();
                        i.d(viewLifecycleOwner2, "viewLifecycleOwner");
                        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$12, h0.q.q.a(viewLifecycleOwner2));
                        N0().c.setController(this.c2);
                        v.p0(this, "thank_you_message", new l<Pair<? extends Integer, ? extends String>, m0.i>() { // from class: com.clubhouse.android.ui.payments.RecentPaymentsFragment$onViewCreated$3
                            @Override // m0.n.a.l
                            public m0.i invoke(Pair<? extends Integer, ? extends String> pair) {
                                Pair<? extends Integer, ? extends String> pair2 = pair;
                                if (pair2 != null) {
                                    RecentPaymentsFragment recentPaymentsFragment = RecentPaymentsFragment.this;
                                    k<Object>[] kVarArr = RecentPaymentsFragment.Z1;
                                    recentPaymentsFragment.O0().p(new e0(pair2));
                                }
                                return m0.i.a;
                            }
                        });
                    }
                }
