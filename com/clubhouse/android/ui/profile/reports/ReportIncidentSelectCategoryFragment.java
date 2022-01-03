package com.clubhouse.android.ui.profile.reports;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.airbnb.epoxy.EpoxyRecyclerView;
import com.airbnb.mvrx.ViewModelDoesNotExistException;
import com.clubhouse.android.data.models.local.channel.Channel;
import com.clubhouse.android.databinding.FragmentReportIncidentSelectCategoryBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.shared.ui.AvatarView;
import com.clubhouse.android.ui.profile.reports.ReportIncidentSelectCategoryContainerViewModel;
import com.clubhouse.android.ui.profile.reports.ReportIncidentSelectCategoryFragment;
import com.clubhouse.android.user.model.User;
import com.clubhouse.app.R;
import h0.b0.v;
import i0.b.a.o;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.d.a.a.a;
import i0.e.b.g3.u.y5.l0;
import i0.e.b.g3.u.y5.p0;
import i0.e.b.g3.u.y5.q0;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import m0.c;
import m0.n.a.l;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
/* compiled from: ReportIncidentSelectCategoryFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u00020\u000b8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0016\u001a\u00020\u00118F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001b\u001a\u00020\u00178B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/clubhouse/android/ui/profile/reports/ReportIncidentSelectCategoryFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Li0/e/b/g3/u/y5/q0;", "b2", "Lm0/c;", "O0", "()Li0/e/b/g3/u/y5/q0;", "viewModel", "Lcom/clubhouse/android/databinding/FragmentReportIncidentSelectCategoryBinding;", "a2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "N0", "()Lcom/clubhouse/android/databinding/FragmentReportIncidentSelectCategoryBinding;", "binding", "Lcom/clubhouse/android/ui/profile/reports/ReportIncidentSelectCategoryContainerViewModel;", "c2", "getContainerViewModel", "()Lcom/clubhouse/android/ui/profile/reports/ReportIncidentSelectCategoryContainerViewModel;", "containerViewModel", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class ReportIncidentSelectCategoryFragment extends Hilt_ReportIncidentSelectCategoryFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(ReportIncidentSelectCategoryFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentReportIncidentSelectCategoryBinding;")), m.c(new PropertyReference1Impl(m.a(ReportIncidentSelectCategoryFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/profile/reports/ReportIncidentSelectCategoryViewModel;")), m.c(new PropertyReference1Impl(m.a(ReportIncidentSelectCategoryFragment.class), "containerViewModel", "getContainerViewModel()Lcom/clubhouse/android/ui/profile/reports/ReportIncidentSelectCategoryContainerViewModel;"))};
    public final FragmentViewBindingDelegate a2 = new FragmentViewBindingDelegate(FragmentReportIncidentSelectCategoryBinding.class, this);
    public final c b2;
    public final c c2;

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<ReportIncidentSelectCategoryFragment, q0> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<q0> a(ReportIncidentSelectCategoryFragment reportIncidentSelectCategoryFragment, k kVar) {
            ReportIncidentSelectCategoryFragment reportIncidentSelectCategoryFragment2 = reportIncidentSelectCategoryFragment;
            i.e(reportIncidentSelectCategoryFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(reportIncidentSelectCategoryFragment2, kVar, this.a, new ReportIncidentSelectCategoryFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(p0.class), false, this.b);
        }
    }

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class b extends h<ReportIncidentSelectCategoryFragment, ReportIncidentSelectCategoryContainerViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public b(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<ReportIncidentSelectCategoryContainerViewModel> a(ReportIncidentSelectCategoryFragment reportIncidentSelectCategoryFragment, k kVar) {
            ReportIncidentSelectCategoryFragment reportIncidentSelectCategoryFragment2 = reportIncidentSelectCategoryFragment;
            i.e(reportIncidentSelectCategoryFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(reportIncidentSelectCategoryFragment2, kVar, this.a, new ReportIncidentSelectCategoryFragment$special$$inlined$parentFragmentViewModel$default$2$1(this), m.a(l0.class), true, this.b);
        }
    }

    public ReportIncidentSelectCategoryFragment() {
        super(R.layout.fragment_report_incident_select_category);
        d a2 = m.a(q0.class);
        a aVar = new a(a2, false, new l<i0.b.b.k<q0, p0>, q0>(a2, a2) { // from class: com.clubhouse.android.ui.profile.reports.ReportIncidentSelectCategoryFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [i0.e.b.g3.u.y5.q0, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.l
            public q0 invoke(i0.b.b.k<q0, p0> kVar) {
                i0.b.b.k<q0, p0> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, p0.class, dVar, name, false, kVar2, 16);
            }
        }, a2);
        k<?>[] kVarArr = Z1;
        this.b2 = aVar.a(this, kVarArr[1]);
        d a3 = m.a(ReportIncidentSelectCategoryContainerViewModel.class);
        this.c2 = new b(a3, true, new l<i0.b.b.k<ReportIncidentSelectCategoryContainerViewModel, l0>, ReportIncidentSelectCategoryContainerViewModel>(a3, a3) { // from class: com.clubhouse.android.ui.profile.reports.ReportIncidentSelectCategoryFragment$special$$inlined$parentFragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r1v14, types: [com.clubhouse.android.ui.profile.reports.ReportIncidentSelectCategoryContainerViewModel, com.airbnb.mvrx.MavericksViewModel] */
            /* JADX WARN: Type inference failed for: r1v19, types: [com.clubhouse.android.ui.profile.reports.ReportIncidentSelectCategoryContainerViewModel, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.l
            public ReportIncidentSelectCategoryContainerViewModel invoke(i0.b.b.k<ReportIncidentSelectCategoryContainerViewModel, l0> kVar) {
                i0.b.b.k<ReportIncidentSelectCategoryContainerViewModel, l0> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                if (Fragment.this.getParentFragment() != null) {
                    String G0 = a.G0(this.q, "viewModelClass.java.name");
                    for (Fragment parentFragment = Fragment.this.getParentFragment(); parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
                        try {
                            x xVar = x.a;
                            Class l1 = i0.j.f.p.h.l1(this.d);
                            h0.o.a.k requireActivity = Fragment.this.requireActivity();
                            i.d(requireActivity, "this.requireActivity()");
                            return x.a(xVar, l1, l0.class, new i0.b.b.d(requireActivity, v.a(Fragment.this), parentFragment, null, null, 24), G0, true, null, 32);
                        } catch (ViewModelDoesNotExistException unused) {
                        }
                    }
                    Fragment parentFragment2 = Fragment.this.getParentFragment();
                    while (true) {
                        if ((parentFragment2 != null ? parentFragment2.getParentFragment() : null) != null) {
                            parentFragment2 = parentFragment2.getParentFragment();
                        } else {
                            h0.o.a.k requireActivity2 = Fragment.this.requireActivity();
                            i.d(requireActivity2, "requireActivity()");
                            Object a4 = v.a(Fragment.this);
                            i.c(parentFragment2);
                            return x.a(x.a, i0.j.f.p.h.l1(this.d), l0.class, new i0.b.b.d(requireActivity2, a4, parentFragment2, null, null, 24), a.G0(this.q, "viewModelClass.java.name"), false, kVar2, 16);
                        }
                    }
                } else {
                    StringBuilder P0 = a.P0("There is no parent fragment for ");
                    a.k(Fragment.this, P0, " so view model ");
                    throw new ViewModelDoesNotExistException(a.H0(this.d, P0, " could not be found."));
                }
            }
        }, a3).a(this, kVarArr[2]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(O0(), new l<p0, m0.i>() { // from class: com.clubhouse.android.ui.profile.reports.ReportIncidentSelectCategoryFragment$invalidate$1
            @Override // m0.n.a.l
            public m0.i invoke(p0 p0Var) {
                m0.i iVar;
                String str;
                String str2;
                p0 p0Var2 = p0Var;
                i.e(p0Var2, "state");
                User user = p0Var2.a;
                String str3 = null;
                if (user == null) {
                    iVar = null;
                } else {
                    ReportIncidentSelectCategoryFragment reportIncidentSelectCategoryFragment = ReportIncidentSelectCategoryFragment.this;
                    AvatarView avatarView = reportIncidentSelectCategoryFragment.N0().a;
                    i.d(avatarView, "binding.avatar");
                    i0.e.b.d3.k.u(avatarView, user);
                    reportIncidentSelectCategoryFragment.N0().c.setText(user.getName());
                    iVar = m0.i.a;
                }
                if (iVar == null) {
                    ReportIncidentSelectCategoryFragment reportIncidentSelectCategoryFragment2 = ReportIncidentSelectCategoryFragment.this;
                    AvatarView avatarView2 = reportIncidentSelectCategoryFragment2.N0().a;
                    i.d(avatarView2, "binding.avatar");
                    i0.e.b.d3.k.p(avatarView2);
                    TextView textView = reportIncidentSelectCategoryFragment2.N0().c;
                    Channel channel = p0Var2.d;
                    if (channel == null || (str2 = channel.u0()) == null) {
                        str2 = "";
                    }
                    textView.setText(str2);
                }
                TextView textView2 = ReportIncidentSelectCategoryFragment.this.N0().e;
                int ordinal = p0Var2.h.ordinal();
                if (ordinal == 0) {
                    ReportIncidentSelectCategoryFragment reportIncidentSelectCategoryFragment3 = ReportIncidentSelectCategoryFragment.this;
                    Object[] objArr = new Object[1];
                    if (user != null) {
                        str3 = user.F();
                    }
                    objArr[0] = str3;
                    str = reportIncidentSelectCategoryFragment3.getString(R.string.what_did_say_was_wrong, objArr);
                } else if (ordinal == 1) {
                    ReportIncidentSelectCategoryFragment reportIncidentSelectCategoryFragment4 = ReportIncidentSelectCategoryFragment.this;
                    Object[] objArr2 = new Object[1];
                    if (user != null) {
                        str3 = user.F();
                    }
                    objArr2[0] = str3;
                    str = reportIncidentSelectCategoryFragment4.getString(R.string.what_is_wrong_on_profile, objArr2);
                } else if (ordinal != 2) {
                    ReportIncidentSelectCategoryFragment reportIncidentSelectCategoryFragment5 = ReportIncidentSelectCategoryFragment.this;
                    Object[] objArr3 = new Object[1];
                    if (user != null) {
                        str3 = user.F();
                    }
                    objArr3[0] = str3;
                    str = reportIncidentSelectCategoryFragment5.getString(R.string.what_did_do_wrong, objArr3);
                } else {
                    str = ReportIncidentSelectCategoryFragment.this.getString(R.string.what_is_wrong_with_the_room_title);
                }
                textView2.setText(str);
                ReportIncidentSelectCategoryFragment.this.N0().d.g();
                return m0.i.a;
            }
        });
    }

    public final FragmentReportIncidentSelectCategoryBinding N0() {
        return (FragmentReportIncidentSelectCategoryBinding) this.a2.getValue(this, Z1[0]);
    }

    public final q0 O0() {
        return (q0) this.b2.getValue();
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.e(view, "view");
        super.onViewCreated(view, bundle);
        N0().b.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.u.y5.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReportIncidentSelectCategoryFragment reportIncidentSelectCategoryFragment = ReportIncidentSelectCategoryFragment.this;
                k<Object>[] kVarArr = ReportIncidentSelectCategoryFragment.Z1;
                i.e(reportIncidentSelectCategoryFragment, "this$0");
                v.c1(reportIncidentSelectCategoryFragment);
                ((ReportIncidentSelectCategoryContainerViewModel) reportIncidentSelectCategoryFragment.c2.getValue()).p(e0.a);
            }
        });
        N0().d.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        EpoxyRecyclerView epoxyRecyclerView = N0().d;
        i.d(epoxyRecyclerView, "binding.reportReasonsList");
        i0.e.b.d3.k.E(epoxyRecyclerView, new l<o, m0.i>() { // from class: com.clubhouse.android.ui.profile.reports.ReportIncidentSelectCategoryFragment$onViewCreated$2
            @Override // m0.n.a.l
            public m0.i invoke(o oVar) {
                o oVar2 = oVar;
                i.e(oVar2, "$this$safeWithModels");
                ReportIncidentSelectCategoryFragment reportIncidentSelectCategoryFragment = ReportIncidentSelectCategoryFragment.this;
                k<Object>[] kVarArr = ReportIncidentSelectCategoryFragment.Z1;
                v.v2(reportIncidentSelectCategoryFragment.O0(), 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0014: INVOKE  
                      (wrap: i0.e.b.g3.u.y5.q0 : 0x000b: INVOKE  (r1v1 i0.e.b.g3.u.y5.q0 A[REMOVE]) = 
                      (r0v1 'reportIncidentSelectCategoryFragment' com.clubhouse.android.ui.profile.reports.ReportIncidentSelectCategoryFragment)
                     type: VIRTUAL call: com.clubhouse.android.ui.profile.reports.ReportIncidentSelectCategoryFragment.O0():i0.e.b.g3.u.y5.q0)
                      (wrap: com.clubhouse.android.ui.profile.reports.ReportIncidentSelectCategoryFragment$buildReportReasonsModels$1 : 0x0011: CONSTRUCTOR  (r2v0 com.clubhouse.android.ui.profile.reports.ReportIncidentSelectCategoryFragment$buildReportReasonsModels$1 A[REMOVE]) = 
                      (r4v1 'oVar2' i0.b.a.o)
                      (r0v1 'reportIncidentSelectCategoryFragment' com.clubhouse.android.ui.profile.reports.ReportIncidentSelectCategoryFragment)
                     call: com.clubhouse.android.ui.profile.reports.ReportIncidentSelectCategoryFragment$buildReportReasonsModels$1.<init>(i0.b.a.o, com.clubhouse.android.ui.profile.reports.ReportIncidentSelectCategoryFragment):void type: CONSTRUCTOR)
                     type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: com.clubhouse.android.ui.profile.reports.ReportIncidentSelectCategoryFragment$onViewCreated$2.invoke(i0.b.a.o):m0.i, file: classes3.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.profile.reports.ReportIncidentSelectCategoryFragment$buildReportReasonsModels$1, state: NOT_LOADED
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
                    com.clubhouse.android.ui.profile.reports.ReportIncidentSelectCategoryFragment r0 = com.clubhouse.android.ui.profile.reports.ReportIncidentSelectCategoryFragment.this
                    m0.r.k<java.lang.Object>[] r1 = com.clubhouse.android.ui.profile.reports.ReportIncidentSelectCategoryFragment.Z1
                    i0.e.b.g3.u.y5.q0 r1 = r0.O0()
                    com.clubhouse.android.ui.profile.reports.ReportIncidentSelectCategoryFragment$buildReportReasonsModels$1 r2 = new com.clubhouse.android.ui.profile.reports.ReportIncidentSelectCategoryFragment$buildReportReasonsModels$1
                    r2.<init>(r4, r0)
                    h0.b0.v.v2(r1, r2)
                    m0.i r4 = m0.i.a
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.clubhouse.android.ui.profile.reports.ReportIncidentSelectCategoryFragment$onViewCreated$2.invoke(java.lang.Object):java.lang.Object");
            }
        });
    }
}
