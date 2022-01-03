package com.clubhouse.android.ui.clubs.nominations;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import com.airbnb.epoxy.EpoxyRecyclerView;
import com.clubhouse.android.data.models.local.club.ClubNominationUser;
import com.clubhouse.android.databinding.FragmentClubNominationsBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.ui.clubs.nominations.ClubNominationsFragment;
import com.clubhouse.android.ui.clubs.nominations.ClubNominationsFragment$showApproveAllConfirmation$1;
import com.clubhouse.android.ui.clubs.nominations.ClubNominationsFragment$showRejectAllConfirmation$1;
import com.clubhouse.android.ui.clubs.nominations.viewholder.ApprovalStatus;
import com.clubhouse.app.R;
import h0.b0.v;
import h0.q.p;
import i0.b.a.o;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.e.b.g3.l.a3.b;
import i0.e.b.g3.l.a3.q;
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
/* compiled from: ClubNominationsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u00020\u000b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0016\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/clubhouse/android/ui/clubs/nominations/ClubNominationsFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lcom/clubhouse/android/ui/clubs/nominations/ClubNominationsViewModel;", "b2", "Lm0/c;", "O0", "()Lcom/clubhouse/android/ui/clubs/nominations/ClubNominationsViewModel;", "viewModel", "Lcom/clubhouse/android/databinding/FragmentClubNominationsBinding;", "a2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "N0", "()Lcom/clubhouse/android/databinding/FragmentClubNominationsBinding;", "binding", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class ClubNominationsFragment extends Hilt_ClubNominationsFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(ClubNominationsFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentClubNominationsBinding;")), m.c(new PropertyReference1Impl(m.a(ClubNominationsFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/clubs/nominations/ClubNominationsViewModel;"))};
    public final FragmentViewBindingDelegate a2 = new FragmentViewBindingDelegate(FragmentClubNominationsBinding.class, this);
    public final c b2;

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<ClubNominationsFragment, ClubNominationsViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<ClubNominationsViewModel> a(ClubNominationsFragment clubNominationsFragment, k kVar) {
            ClubNominationsFragment clubNominationsFragment2 = clubNominationsFragment;
            i.e(clubNominationsFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(clubNominationsFragment2, kVar, this.a, new ClubNominationsFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(q.class), false, this.b);
        }
    }

    public ClubNominationsFragment() {
        super(R.layout.fragment_club_nominations);
        d a2 = m.a(ClubNominationsViewModel.class);
        this.b2 = new a(a2, false, new l<i0.b.b.k<ClubNominationsViewModel, q>, ClubNominationsViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.clubs.nominations.ClubNominationsFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.clubhouse.android.ui.clubs.nominations.ClubNominationsViewModel, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.l
            public ClubNominationsViewModel invoke(i0.b.b.k<ClubNominationsViewModel, q> kVar) {
                i0.b.b.k<ClubNominationsViewModel, q> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, q.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, Z1[1]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(O0(), new l<q, m0.i>() { // from class: com.clubhouse.android.ui.clubs.nominations.ClubNominationsFragment$invalidate$1
            @Override // m0.n.a.l
            public m0.i invoke(q qVar) {
                q qVar2 = qVar;
                i.e(qVar2, "state");
                ClubNominationsFragment clubNominationsFragment = ClubNominationsFragment.this;
                k<Object>[] kVarArr = ClubNominationsFragment.Z1;
                clubNominationsFragment.N0().e.g();
                ProgressBar progressBar = ClubNominationsFragment.this.N0().d;
                i.d(progressBar, "binding.loading");
                i0.e.b.d3.k.L(progressBar, Boolean.valueOf(qVar2.e));
                Button button = ClubNominationsFragment.this.N0().a;
                i.d(button, "binding.approveAll");
                i0.e.b.d3.k.L(button, Boolean.valueOf(!qVar2.b.isEmpty()));
                Button button2 = ClubNominationsFragment.this.N0().f;
                i.d(button2, "binding.rejectAll");
                i0.e.b.d3.k.L(button2, Boolean.valueOf(!qVar2.b.isEmpty()));
                return m0.i.a;
            }
        });
    }

    public final FragmentClubNominationsBinding N0() {
        return (FragmentClubNominationsBinding) this.a2.getValue(this, Z1[0]);
    }

    public final ClubNominationsViewModel O0() {
        return (ClubNominationsViewModel) this.b2.getValue();
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.e(view, "view");
        super.onViewCreated(view, bundle);
        N0().b.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.l.a3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ClubNominationsFragment clubNominationsFragment = ClubNominationsFragment.this;
                k<Object>[] kVarArr = ClubNominationsFragment.Z1;
                i.e(clubNominationsFragment, "this$0");
                v.c1(clubNominationsFragment);
            }
        });
        Button button = N0().a;
        i.d(button, "binding.approveAll");
        p viewLifecycleOwner = getViewLifecycleOwner();
        i.d(viewLifecycleOwner, "viewLifecycleOwner");
        i0.e.b.d3.k.H(button, h0.q.q.a(viewLifecycleOwner), new View.OnClickListener() { // from class: i0.e.b.g3.l.a3.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ClubNominationsFragment clubNominationsFragment = ClubNominationsFragment.this;
                k<Object>[] kVarArr = ClubNominationsFragment.Z1;
                i.e(clubNominationsFragment, "this$0");
                ClubNominationsFragment$showApproveAllConfirmation$1 clubNominationsFragment$showApproveAllConfirmation$1 = 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: CONSTRUCTOR  (r0v2 'clubNominationsFragment$showApproveAllConfirmation$1' com.clubhouse.android.ui.clubs.nominations.ClubNominationsFragment$showApproveAllConfirmation$1) = (r4v1 'clubNominationsFragment' com.clubhouse.android.ui.clubs.nominations.ClubNominationsFragment) call: com.clubhouse.android.ui.clubs.nominations.ClubNominationsFragment$showApproveAllConfirmation$1.<init>(com.clubhouse.android.ui.clubs.nominations.ClubNominationsFragment):void type: CONSTRUCTOR in method: i0.e.b.g3.l.a3.e.onClick(android.view.View):void, file: classes3.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.clubs.nominations.ClubNominationsFragment$showApproveAllConfirmation$1, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                    	... 15 more
                    */
                /*
                    this = this;
                    com.clubhouse.android.ui.clubs.nominations.ClubNominationsFragment r4 = com.clubhouse.android.ui.clubs.nominations.ClubNominationsFragment.this
                    m0.r.k<java.lang.Object>[] r0 = com.clubhouse.android.ui.clubs.nominations.ClubNominationsFragment.Z1
                    java.lang.String r0 = "this$0"
                    m0.n.b.i.e(r4, r0)
                    com.clubhouse.android.ui.clubs.nominations.ClubNominationsFragment$showApproveAllConfirmation$1 r0 = new com.clubhouse.android.ui.clubs.nominations.ClubNominationsFragment$showApproveAllConfirmation$1
                    r0.<init>(r4)
                    java.lang.String r1 = "<this>"
                    m0.n.b.i.e(r4, r1)
                    java.lang.String r1 = "f"
                    m0.n.b.i.e(r0, r1)
                    h0.b.a.d$a r1 = new h0.b.a.d$a
                    android.content.Context r4 = r4.requireContext()
                    int r2 = com.clubhouse.core.ui.R.style.Clubhouse_AlertDialog_Rounded
                    r1.<init>(r4, r2)
                    r0.invoke(r1)
                    r1.g()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.l.a3.e.onClick(android.view.View):void");
            }
        });
        Button button2 = N0().f;
        i.d(button2, "binding.rejectAll");
        p viewLifecycleOwner2 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner2, "viewLifecycleOwner");
        i0.e.b.d3.k.H(button2, h0.q.q.a(viewLifecycleOwner2), new View.OnClickListener() { // from class: i0.e.b.g3.l.a3.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ClubNominationsFragment clubNominationsFragment = ClubNominationsFragment.this;
                k<Object>[] kVarArr = ClubNominationsFragment.Z1;
                i.e(clubNominationsFragment, "this$0");
                ClubNominationsFragment$showRejectAllConfirmation$1 clubNominationsFragment$showRejectAllConfirmation$1 = 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: CONSTRUCTOR  (r0v2 'clubNominationsFragment$showRejectAllConfirmation$1' com.clubhouse.android.ui.clubs.nominations.ClubNominationsFragment$showRejectAllConfirmation$1) = (r4v1 'clubNominationsFragment' com.clubhouse.android.ui.clubs.nominations.ClubNominationsFragment) call: com.clubhouse.android.ui.clubs.nominations.ClubNominationsFragment$showRejectAllConfirmation$1.<init>(com.clubhouse.android.ui.clubs.nominations.ClubNominationsFragment):void type: CONSTRUCTOR in method: i0.e.b.g3.l.a3.f.onClick(android.view.View):void, file: classes3.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.clubs.nominations.ClubNominationsFragment$showRejectAllConfirmation$1, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                    	... 15 more
                    */
                /*
                    this = this;
                    com.clubhouse.android.ui.clubs.nominations.ClubNominationsFragment r4 = com.clubhouse.android.ui.clubs.nominations.ClubNominationsFragment.this
                    m0.r.k<java.lang.Object>[] r0 = com.clubhouse.android.ui.clubs.nominations.ClubNominationsFragment.Z1
                    java.lang.String r0 = "this$0"
                    m0.n.b.i.e(r4, r0)
                    com.clubhouse.android.ui.clubs.nominations.ClubNominationsFragment$showRejectAllConfirmation$1 r0 = new com.clubhouse.android.ui.clubs.nominations.ClubNominationsFragment$showRejectAllConfirmation$1
                    r0.<init>(r4)
                    java.lang.String r1 = "<this>"
                    m0.n.b.i.e(r4, r1)
                    java.lang.String r1 = "f"
                    m0.n.b.i.e(r0, r1)
                    h0.b.a.d$a r1 = new h0.b.a.d$a
                    android.content.Context r4 = r4.requireContext()
                    int r2 = com.clubhouse.core.ui.R.style.Clubhouse_AlertDialog_Rounded
                    r1.<init>(r4, r2)
                    r0.invoke(r1)
                    r1.g()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.l.a3.f.onClick(android.view.View):void");
            }
        });
        EpoxyRecyclerView epoxyRecyclerView = N0().e;
        i.d(epoxyRecyclerView, "binding.nominationsList");
        i0.e.b.d3.k.D(epoxyRecyclerView, this, new l<o, m0.i>() { // from class: com.clubhouse.android.ui.clubs.nominations.ClubNominationsFragment$buildModels$1
            @Override // m0.n.a.l
            public m0.i invoke(o oVar) {
                final o oVar2 = oVar;
                i.e(oVar2, "$this$null");
                ClubNominationsFragment clubNominationsFragment = ClubNominationsFragment.this;
                k<Object>[] kVarArr = ClubNominationsFragment.Z1;
                ClubNominationsViewModel O0 = clubNominationsFragment.O0();
                final ClubNominationsFragment clubNominationsFragment2 = ClubNominationsFragment.this;
                v.v2(O0, new l<q, m0.i>() { // from class: com.clubhouse.android.ui.clubs.nominations.ClubNominationsFragment$buildModels$1.1
                    @Override // m0.n.a.l
                    public m0.i invoke(q qVar) {
                        ApprovalStatus approvalStatus;
                        q qVar2 = qVar;
                        i.e(qVar2, "state");
                        List<ClubNominationUser> list = qVar2.b;
                        o oVar3 = o.this;
                        ClubNominationsFragment clubNominationsFragment3 = clubNominationsFragment2;
                        for (ClubNominationUser clubNominationUser : list) {
                            i0.e.b.g3.l.a3.v.c cVar = new i0.e.b.g3.l.a3.v.c();
                            cVar.G(new Number[]{clubNominationUser.getId()});
                            cVar.H(clubNominationUser);
                            int intValue = clubNominationUser.getId().intValue();
                            if (qVar2.c.contains(Integer.valueOf(intValue))) {
                                approvalStatus = ApprovalStatus.APPROVED;
                            } else if (qVar2.d.contains(Integer.valueOf(intValue))) {
                                approvalStatus = ApprovalStatus.REJECTED;
                            } else {
                                approvalStatus = ApprovalStatus.DEFAULT;
                            }
                            cVar.D(approvalStatus);
                            cVar.J(new i0.e.b.g3.l.a3.c(clubNominationsFragment3, clubNominationUser));
                            cVar.E(new b(clubNominationsFragment3, clubNominationUser));
                            cVar.I(new i0.e.b.g3.l.a3.d(clubNominationsFragment3, clubNominationUser));
                            oVar3.add(cVar);
                        }
                        return m0.i.a;
                    }
                });
                return m0.i.a;
            }
        });
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(O0().l, new ClubNominationsFragment$onViewCreated$4(this, null));
        p viewLifecycleOwner3 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner3, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, h0.q.q.a(viewLifecycleOwner3));
    }
}
