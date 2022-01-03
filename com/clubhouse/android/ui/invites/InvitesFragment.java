package com.clubhouse.android.ui.invites;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.airbnb.epoxy.EpoxyRecyclerView;
import com.clubhouse.android.databinding.FragmentInvitesBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.ui.invites.InvitesFragment;
import com.clubhouse.android.ui.invites.InvitesFragment$onViewCreated$4$1;
import com.clubhouse.app.R;
import h0.b0.v;
import h0.q.p;
import h0.q.q;
import i0.b.a.o;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
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
/* compiled from: InvitesFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u00020\u000b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0016\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/clubhouse/android/ui/invites/InvitesFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lcom/clubhouse/android/ui/invites/InvitesViewModel;", "b2", "Lm0/c;", "O0", "()Lcom/clubhouse/android/ui/invites/InvitesViewModel;", "viewModel", "Lcom/clubhouse/android/databinding/FragmentInvitesBinding;", "a2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "N0", "()Lcom/clubhouse/android/databinding/FragmentInvitesBinding;", "binding", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class InvitesFragment extends Hilt_InvitesFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(InvitesFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentInvitesBinding;")), m.c(new PropertyReference1Impl(m.a(InvitesFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/invites/InvitesViewModel;"))};
    public final FragmentViewBindingDelegate a2 = new FragmentViewBindingDelegate(FragmentInvitesBinding.class, this);
    public final c b2;

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<InvitesFragment, InvitesViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<InvitesViewModel> a(InvitesFragment invitesFragment, k kVar) {
            InvitesFragment invitesFragment2 = invitesFragment;
            i.e(invitesFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(invitesFragment2, kVar, this.a, new InvitesFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(i0.e.b.g3.q.m.class), false, this.b);
        }
    }

    public InvitesFragment() {
        super(R.layout.fragment_invites);
        d a2 = m.a(InvitesViewModel.class);
        this.b2 = new a(a2, false, new l<i0.b.b.k<InvitesViewModel, i0.e.b.g3.q.m>, InvitesViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.invites.InvitesFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.airbnb.mvrx.MavericksViewModel, com.clubhouse.android.ui.invites.InvitesViewModel] */
            @Override // m0.n.a.l
            public InvitesViewModel invoke(i0.b.b.k<InvitesViewModel, i0.e.b.g3.q.m> kVar) {
                i0.b.b.k<InvitesViewModel, i0.e.b.g3.q.m> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, i0.e.b.g3.q.m.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, Z1[1]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(O0(), new l<i0.e.b.g3.q.m, m0.i>() { // from class: com.clubhouse.android.ui.invites.InvitesFragment$invalidate$1
            @Override // m0.n.a.l
            public m0.i invoke(i0.e.b.g3.q.m mVar) {
                i0.e.b.g3.q.m mVar2 = mVar;
                i.e(mVar2, "state");
                if (mVar2.b) {
                    InvitesFragment invitesFragment = InvitesFragment.this;
                    k<Object>[] kVarArr = InvitesFragment.Z1;
                    ProgressBar progressBar = invitesFragment.N0().d;
                    i.d(progressBar, "binding.loading");
                    i0.e.b.d3.k.L(progressBar, Boolean.valueOf(mVar2.c));
                    CardView cardView = InvitesFragment.this.N0().c;
                    i.d(cardView, "binding.letsFind");
                    i0.e.b.d3.k.p(cardView);
                    InvitesFragment.this.N0().e.setHint(InvitesFragment.this.getString(R.string.search_or_invite_a_phone));
                } else {
                    InvitesFragment invitesFragment2 = InvitesFragment.this;
                    k<Object>[] kVarArr2 = InvitesFragment.Z1;
                    ProgressBar progressBar2 = invitesFragment2.N0().d;
                    i.d(progressBar2, "binding.loading");
                    i0.e.b.d3.k.p(progressBar2);
                    CardView cardView2 = InvitesFragment.this.N0().c;
                    i.d(cardView2, "binding.letsFind");
                    i0.e.b.d3.k.L(cardView2, Boolean.valueOf(mVar2.f));
                    InvitesFragment.this.N0().e.setHint(InvitesFragment.this.getString(R.string.invite_a_phone));
                }
                InvitesFragment.this.N0().b.g();
                return m0.i.a;
            }
        });
    }

    public final FragmentInvitesBinding N0() {
        return (FragmentInvitesBinding) this.a2.getValue(this, Z1[0]);
    }

    public final InvitesViewModel O0() {
        return (InvitesViewModel) this.b2.getValue();
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.e(view, "view");
        super.onViewCreated(view, bundle);
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(O0().l, new InvitesFragment$onViewCreated$1(this, null));
        p viewLifecycleOwner = getViewLifecycleOwner();
        i.d(viewLifecycleOwner, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner));
        EditText editText = N0().e;
        i.d(editText, "binding.search");
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$12 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(i0.e.b.d3.k.f(editText), new InvitesFragment$onViewCreated$2(this, null));
        p viewLifecycleOwner2 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner2, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$12, q.a(viewLifecycleOwner2));
        N0().a.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.q.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                InvitesFragment invitesFragment = InvitesFragment.this;
                k<Object>[] kVarArr = InvitesFragment.Z1;
                i.e(invitesFragment, "this$0");
                v.c1(invitesFragment);
            }
        });
        N0().c.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.q.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                InvitesFragment invitesFragment = InvitesFragment.this;
                k<Object>[] kVarArr = InvitesFragment.Z1;
                i.e(invitesFragment, "this$0");
                InvitesFragment$onViewCreated$4$1 invitesFragment$onViewCreated$4$1 = 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: CONSTRUCTOR  (r7v3 'invitesFragment$onViewCreated$4$1' com.clubhouse.android.ui.invites.InvitesFragment$onViewCreated$4$1) = (r0v0 'invitesFragment' com.clubhouse.android.ui.invites.InvitesFragment) call: com.clubhouse.android.ui.invites.InvitesFragment$onViewCreated$4$1.<init>(com.clubhouse.android.ui.invites.InvitesFragment):void type: CONSTRUCTOR in method: i0.e.b.g3.q.a.onClick(android.view.View):void, file: classes3.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.invites.InvitesFragment$onViewCreated$4$1, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                    	... 15 more
                    */
                /*
                    this = this;
                    com.clubhouse.android.ui.invites.InvitesFragment r0 = com.clubhouse.android.ui.invites.InvitesFragment.this
                    m0.r.k<java.lang.Object>[] r7 = com.clubhouse.android.ui.invites.InvitesFragment.Z1
                    java.lang.String r7 = "this$0"
                    m0.n.b.i.e(r0, r7)
                    com.clubhouse.android.ui.invites.InvitesFragment$onViewCreated$4$1 r7 = new com.clubhouse.android.ui.invites.InvitesFragment$onViewCreated$4$1
                    r7.<init>(r0)
                    java.lang.String r1 = "<this>"
                    m0.n.b.i.e(r0, r1)
                    java.lang.String r1 = "action"
                    m0.n.b.i.e(r7, r1)
                    r1 = 1
                    com.afollestad.assent.Permission[] r1 = new com.afollestad.assent.Permission[r1]
                    com.afollestad.assent.Permission r2 = com.afollestad.assent.Permission.READ_CONTACTS
                    r3 = 0
                    r1[r3] = r2
                    com.clubhouse.android.shared.PermissionUtil$withContactsPermissions$1 r4 = new com.clubhouse.android.shared.PermissionUtil$withContactsPermissions$1
                    r4.<init>(r7, r0)
                    r2 = 0
                    r3 = 0
                    r5 = 6
                    i0.a.a.b.a(r0, r1, r2, r3, r4, r5)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.q.a.onClick(android.view.View):void");
            }
        });
        v.g(this, new m0.n.a.p<Boolean, Integer, m0.i>() { // from class: com.clubhouse.android.ui.invites.InvitesFragment$onViewCreated$5
            @Override // m0.n.a.p
            public m0.i invoke(Boolean bool, Integer num) {
                boolean booleanValue = bool.booleanValue();
                num.intValue();
                InvitesFragment invitesFragment = InvitesFragment.this;
                k<Object>[] kVarArr = InvitesFragment.Z1;
                InvitesViewModel O0 = invitesFragment.O0();
                Objects.requireNonNull(O0);
                O0.m(new InvitesViewModel$setKeyboardOpened$1(booleanValue));
                if (booleanValue) {
                    CardView cardView = InvitesFragment.this.N0().c;
                    i.d(cardView, "binding.letsFind");
                    i0.e.b.d3.k.p(cardView);
                }
                return m0.i.a;
            }
        });
        InvitesViewModel O0 = O0();
        Objects.requireNonNull(O0);
        O0.m(new InvitesViewModel$setKeyboardOpened$1(false));
        N0().b.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        EpoxyRecyclerView epoxyRecyclerView = N0().b;
        i.d(epoxyRecyclerView, "binding.invitesList");
        i0.e.b.d3.k.E(epoxyRecyclerView, new l<o, m0.i>() { // from class: com.clubhouse.android.ui.invites.InvitesFragment$onViewCreated$6
            @Override // m0.n.a.l
            public m0.i invoke(o oVar) {
                o oVar2 = oVar;
                i.e(oVar2, "$this$safeWithModels");
                InvitesFragment invitesFragment = InvitesFragment.this;
                k<Object>[] kVarArr = InvitesFragment.Z1;
                EpoxyRecyclerView epoxyRecyclerView2 = invitesFragment.N0().b;
                i.d(epoxyRecyclerView2, "binding.invitesList");
                v.T1(oVar2, epoxyRecyclerView2);
                InvitesFragment invitesFragment2 = InvitesFragment.this;
                v.v2(invitesFragment2.O0(), 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0024: INVOKE  
                      (wrap: com.clubhouse.android.ui.invites.InvitesViewModel : 0x001b: INVOKE  (r1v2 com.clubhouse.android.ui.invites.InvitesViewModel A[REMOVE]) = (r0v4 'invitesFragment2' com.clubhouse.android.ui.invites.InvitesFragment) type: VIRTUAL call: com.clubhouse.android.ui.invites.InvitesFragment.O0():com.clubhouse.android.ui.invites.InvitesViewModel)
                      (wrap: com.clubhouse.android.ui.invites.InvitesFragment$buildInvitesModels$1 : 0x0021: CONSTRUCTOR  (r2v0 com.clubhouse.android.ui.invites.InvitesFragment$buildInvitesModels$1 A[REMOVE]) = (r0v4 'invitesFragment2' com.clubhouse.android.ui.invites.InvitesFragment), (r4v1 'oVar2' i0.b.a.o) call: com.clubhouse.android.ui.invites.InvitesFragment$buildInvitesModels$1.<init>(com.clubhouse.android.ui.invites.InvitesFragment, i0.b.a.o):void type: CONSTRUCTOR)
                     type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: com.clubhouse.android.ui.invites.InvitesFragment$onViewCreated$6.invoke(i0.b.a.o):m0.i, file: classes3.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.invites.InvitesFragment$buildInvitesModels$1, state: NOT_LOADED
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
                    i0.b.a.o r4 = (i0.b.a.o) r4
                    java.lang.String r0 = "$this$safeWithModels"
                    m0.n.b.i.e(r4, r0)
                    com.clubhouse.android.ui.invites.InvitesFragment r0 = com.clubhouse.android.ui.invites.InvitesFragment.this
                    m0.r.k<java.lang.Object>[] r1 = com.clubhouse.android.ui.invites.InvitesFragment.Z1
                    com.clubhouse.android.databinding.FragmentInvitesBinding r0 = r0.N0()
                    com.airbnb.epoxy.EpoxyRecyclerView r0 = r0.b
                    java.lang.String r1 = "binding.invitesList"
                    m0.n.b.i.d(r0, r1)
                    h0.b0.v.T1(r4, r0)
                    com.clubhouse.android.ui.invites.InvitesFragment r0 = com.clubhouse.android.ui.invites.InvitesFragment.this
                    com.clubhouse.android.ui.invites.InvitesViewModel r1 = r0.O0()
                    com.clubhouse.android.ui.invites.InvitesFragment$buildInvitesModels$1 r2 = new com.clubhouse.android.ui.invites.InvitesFragment$buildInvitesModels$1
                    r2.<init>(r0, r4)
                    h0.b0.v.v2(r1, r2)
                    m0.i r4 = m0.i.a
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.clubhouse.android.ui.invites.InvitesFragment$onViewCreated$6.invoke(java.lang.Object):java.lang.Object");
            }
        });
    }
}
