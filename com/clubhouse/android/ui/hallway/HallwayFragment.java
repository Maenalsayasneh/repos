package com.clubhouse.android.ui.hallway;

import android.os.Bundle;
import android.view.View;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.clubhouse.android.core.ui.CustomSwipeViewPager;
import com.clubhouse.android.databinding.FragmentHallwayBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.shared.update.UpdatesCoordinator;
import com.clubhouse.android.ui.NavigationViewModel;
import com.clubhouse.android.ui.hallway.HallwayFragment;
import com.clubhouse.android.ui.profile.reports.ReportIncidentThanksFragment;
import com.clubhouse.app.R;
import h0.a.b;
import h0.b0.v;
import h0.q.q;
import h0.t.f;
import h0.x.a;
import i0.b.b.c0;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.k0;
import i0.b.b.x;
import i0.e.b.g3.p.b0.s;
import i0.e.b.g3.p.r;
import i0.e.b.g3.p.w;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.c;
import m0.n.a.l;
import m0.n.a.p;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
import n0.a.f1;
/* compiled from: HallwayFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b2\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nR\u001c\u0010\r\u001a\u00020\f8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001e\u001a\u00020\u00198B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010$\u001a\u00020\u001f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\"\u0010,\u001a\u00020%8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001d\u00101\u001a\u00020-8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u001b\u001a\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/clubhouse/android/ui/hallway/HallwayFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "J", "", "shouldAdjustResize", "Z", "J0", "()Z", "Lcom/clubhouse/android/shared/update/UpdatesCoordinator;", "a2", "Lcom/clubhouse/android/shared/update/UpdatesCoordinator;", "getUpdatescoordinator", "()Lcom/clubhouse/android/shared/update/UpdatesCoordinator;", "setUpdatescoordinator", "(Lcom/clubhouse/android/shared/update/UpdatesCoordinator;)V", "updatescoordinator", "Lcom/clubhouse/android/ui/NavigationViewModel;", "e2", "Lm0/c;", "getNavigationViewModel", "()Lcom/clubhouse/android/ui/NavigationViewModel;", "navigationViewModel", "Lcom/clubhouse/android/databinding/FragmentHallwayBinding;", "c2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "N0", "()Lcom/clubhouse/android/databinding/FragmentHallwayBinding;", "binding", "Li0/e/b/f3/k/b;", "b2", "Li0/e/b/f3/k/b;", "O0", "()Li0/e/b/f3/k/b;", "setUserPrefs", "(Li0/e/b/f3/k/b;)V", "userPrefs", "Lcom/clubhouse/android/ui/hallway/HallwayViewModel;", "d2", "P0", "()Lcom/clubhouse/android/ui/hallway/HallwayViewModel;", "viewModel", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class HallwayFragment extends Hilt_HallwayFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(HallwayFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentHallwayBinding;")), m.c(new PropertyReference1Impl(m.a(HallwayFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/hallway/HallwayViewModel;")), m.c(new PropertyReference1Impl(m.a(HallwayFragment.class), "navigationViewModel", "getNavigationViewModel()Lcom/clubhouse/android/ui/NavigationViewModel;"))};
    public UpdatesCoordinator a2;
    public i0.e.b.f3.k.b b2;
    public final FragmentViewBindingDelegate c2 = new FragmentViewBindingDelegate(FragmentHallwayBinding.class, this);
    public final c d2;
    public final c e2;

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<HallwayFragment, HallwayViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<HallwayViewModel> a(HallwayFragment hallwayFragment, k kVar) {
            HallwayFragment hallwayFragment2 = hallwayFragment;
            i.e(hallwayFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(hallwayFragment2, kVar, this.a, new HallwayFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(r.class), false, this.b);
        }
    }

    /* compiled from: MavericksExtensions.kt */
    /* loaded from: classes3.dex */
    public static final class b extends h<HallwayFragment, NavigationViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ p b;
        public final /* synthetic */ d c;

        public b(d dVar, int i, p pVar, d dVar2) {
            this.a = dVar;
            this.b = pVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<NavigationViewModel> a(HallwayFragment hallwayFragment, k kVar) {
            HallwayFragment hallwayFragment2 = hallwayFragment;
            i.e(hallwayFragment2, "thisRef");
            i.e(kVar, "property");
            k0 k0Var = g.a;
            if (k0Var instanceof i0.b.b.l0.a) {
                return ((i0.b.b.l0.a) k0Var).a(hallwayFragment2, kVar, this.a, new HallwayFragment$special$$inlined$navGraphViewModel$default$2$1(this), m.a(i0.e.b.g3.h.class), R.id.main_graph, this.b);
            }
            throw new IllegalStateException("Navigation ViewModels require that Mavericks.viewModelDelegateFactory have an implementation of NavigationViewModelDelegateFactory.\n \n To setup the default factory configuration, you can use the default factory DefaultNavigationViewModelDelegateFactory.\n DefaultNavigationViewModelDelegateFactory also implements DefaultViewModelDelegateFactory by default.\n \n Mavericks.viewModelDelegateFactory = DefaultNavigationViewModelDelegateFactory()");
        }
    }

    public HallwayFragment() {
        super(R.layout.fragment_hallway);
        d a2 = m.a(HallwayViewModel.class);
        a aVar = new a(a2, false, new l<i0.b.b.k<HallwayViewModel, r>, HallwayViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.hallway.HallwayFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.airbnb.mvrx.MavericksViewModel, com.clubhouse.android.ui.hallway.HallwayViewModel] */
            @Override // m0.n.a.l
            public HallwayViewModel invoke(i0.b.b.k<HallwayViewModel, r> kVar) {
                i0.b.b.k<HallwayViewModel, r> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, r.class, dVar, name, false, kVar2, 16);
            }
        }, a2);
        k<?>[] kVarArr = Z1;
        this.d2 = aVar.a(this, kVarArr[1]);
        d a3 = m.a(NavigationViewModel.class);
        this.e2 = new b(a3, R.id.main_graph, new p<i0.b.b.k<NavigationViewModel, i0.e.b.g3.h>, f, NavigationViewModel>(a3, a3) { // from class: com.clubhouse.android.ui.hallway.HallwayFragment$special$$inlined$navGraphViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r11v4, types: [com.clubhouse.android.ui.NavigationViewModel, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.p
            public NavigationViewModel invoke(i0.b.b.k<NavigationViewModel, i0.e.b.g3.h> kVar, f fVar) {
                i0.b.b.k<NavigationViewModel, i0.e.b.g3.h> kVar2 = kVar;
                f fVar2 = fVar;
                i.e(kVar2, "stateFactory");
                i.e(fVar2, "backStackEntry");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                Object a4 = v.a(Fragment.this);
                Fragment fragment = Fragment.this;
                a aVar2 = fVar2.y.b;
                i.d(aVar2, "backStackEntry.savedStateRegistry");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, a4, fragment, fVar2, aVar2);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, i0.e.b.g3.h.class, dVar, name, false, kVar2, 16);
            }
        }, a3).a(this, kVarArr[2]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(P0(), new l<r, m0.i>() { // from class: com.clubhouse.android.ui.hallway.HallwayFragment$invalidate$1
            @Override // m0.n.a.l
            public m0.i invoke(r rVar) {
                r rVar2 = rVar;
                i.e(rVar2, "state");
                HallwayFragment hallwayFragment = HallwayFragment.this;
                k<Object>[] kVarArr = HallwayFragment.Z1;
                v.v2(hallwayFragment.P0(), 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0014: INVOKE  
                      (wrap: com.clubhouse.android.ui.hallway.HallwayViewModel : 0x000b: INVOKE  (r1v1 com.clubhouse.android.ui.hallway.HallwayViewModel A[REMOVE]) = (r0v1 'hallwayFragment' com.clubhouse.android.ui.hallway.HallwayFragment) type: VIRTUAL call: com.clubhouse.android.ui.hallway.HallwayFragment.P0():com.clubhouse.android.ui.hallway.HallwayViewModel)
                      (wrap: com.clubhouse.android.ui.hallway.HallwayFragment$setNotificationBadge$1 : 0x0011: CONSTRUCTOR  (r2v0 com.clubhouse.android.ui.hallway.HallwayFragment$setNotificationBadge$1 A[REMOVE]) = (r0v1 'hallwayFragment' com.clubhouse.android.ui.hallway.HallwayFragment) call: com.clubhouse.android.ui.hallway.HallwayFragment$setNotificationBadge$1.<init>(com.clubhouse.android.ui.hallway.HallwayFragment):void type: CONSTRUCTOR)
                     type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: com.clubhouse.android.ui.hallway.HallwayFragment$invalidate$1.invoke(i0.e.b.g3.p.r):m0.i, file: classes3.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.hallway.HallwayFragment$setNotificationBadge$1, state: NOT_LOADED
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
                    i0.e.b.g3.p.r r7 = (i0.e.b.g3.p.r) r7
                    java.lang.String r0 = "state"
                    m0.n.b.i.e(r7, r0)
                    com.clubhouse.android.ui.hallway.HallwayFragment r0 = com.clubhouse.android.ui.hallway.HallwayFragment.this
                    m0.r.k<java.lang.Object>[] r1 = com.clubhouse.android.ui.hallway.HallwayFragment.Z1
                    com.clubhouse.android.ui.hallway.HallwayViewModel r1 = r0.P0()
                    com.clubhouse.android.ui.hallway.HallwayFragment$setNotificationBadge$1 r2 = new com.clubhouse.android.ui.hallway.HallwayFragment$setNotificationBadge$1
                    r2.<init>(r0)
                    h0.b0.v.v2(r1, r2)
                    com.clubhouse.android.ui.hallway.HallwayFragment r0 = com.clubhouse.android.ui.hallway.HallwayFragment.this
                    com.clubhouse.android.databinding.FragmentHallwayBinding r0 = r0.N0()
                    android.widget.FrameLayout r0 = r0.d
                    java.lang.String r1 = "binding.loading"
                    m0.n.b.i.d(r0, r1)
                    boolean r1 = r7.b
                    java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
                    i0.e.b.d3.k.L(r0, r1)
                    i0.b.b.b<com.clubhouse.android.user.model.UserSelf> r7 = r7.d
                    java.lang.Object r7 = r7.a()
                    com.clubhouse.android.user.model.UserSelf r7 = (com.clubhouse.android.user.model.UserSelf) r7
                    if (r7 != 0) goto L_0x0039
                    r7 = 0
                    goto L_0x006d
                L_0x0039:
                    com.clubhouse.android.ui.hallway.HallwayFragment r0 = com.clubhouse.android.ui.hallway.HallwayFragment.this
                    com.clubhouse.android.databinding.FragmentHallwayBinding r1 = r0.N0()
                    com.clubhouse.android.shared.ui.AvatarView r1 = r1.e
                    java.lang.String r2 = "binding.me"
                    m0.n.b.i.d(r1, r2)
                    java.lang.String r2 = r7.d
                    java.lang.String r3 = r7.b
                    r4 = 0
                    r5 = 4
                    h0.b0.v.S0(r1, r2, r3, r4, r5)
                    com.clubhouse.android.databinding.FragmentHallwayBinding r1 = r0.N0()
                    com.clubhouse.android.shared.ui.AvatarView r1 = r1.e
                    i0.e.b.g3.p.d r2 = new i0.e.b.g3.p.d
                    r2.<init>(r0, r7)
                    r1.setOnClickListener(r2)
                    com.clubhouse.android.databinding.FragmentHallwayBinding r7 = r0.N0()
                    com.clubhouse.android.shared.ui.AvatarView r7 = r7.e
                    i0.e.b.g3.p.e r1 = new i0.e.b.g3.p.e
                    r1.<init>(r0)
                    r7.setOnLongClickListener(r1)
                    m0.i r7 = m0.i.a
                L_0x006d:
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: com.clubhouse.android.ui.hallway.HallwayFragment$invalidate$1.invoke(java.lang.Object):java.lang.Object");
            }
        });
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment
    public boolean J0() {
        return false;
    }

    public final FragmentHallwayBinding N0() {
        return (FragmentHallwayBinding) this.c2.getValue(this, Z1[0]);
    }

    public final i0.e.b.f3.k.b O0() {
        i0.e.b.f3.k.b bVar = this.b2;
        if (bVar != null) {
            return bVar;
        }
        i.m("userPrefs");
        throw null;
    }

    public final HallwayViewModel P0() {
        return (HallwayViewModel) this.d2.getValue();
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        P0().p(s.a);
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.e(view, "view");
        super.onViewCreated(view, bundle);
        f1 unused = x0((NavigationViewModel) this.e2.getValue(), HallwayFragment$onViewCreated$1.c, (r5 & 2) != 0 ? c0.a : null, new HallwayFragment$onViewCreated$2(this, null));
        Objects.requireNonNull(ReportIncidentThanksFragment.Z1);
        v.p0(this, ReportIncidentThanksFragment.c2, new l<String, m0.i>() { // from class: com.clubhouse.android.ui.hallway.HallwayFragment$onViewCreated$3
            @Override // m0.n.a.l
            public m0.i invoke(String str) {
                String str2 = str;
                if (str2 != null) {
                    HallwayFragment hallwayFragment = HallwayFragment.this;
                    k<Object>[] kVarArr = HallwayFragment.Z1;
                    hallwayFragment.P0().p(new i0.e.b.g3.p.v(str2));
                }
                return m0.i.a;
            }
        });
        boolean z = false;
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(m0.r.t.a.r.m.a1.a.K2(P0().l, ((NavigationViewModel) this.e2.getValue()).l), new HallwayFragment$onViewCreated$4(this, null));
        h0.q.p viewLifecycleOwner = getViewLifecycleOwner();
        i.d(viewLifecycleOwner, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner));
        CustomSwipeViewPager customSwipeViewPager = N0().g;
        FragmentManager childFragmentManager = getChildFragmentManager();
        i.d(childFragmentManager, "childFragmentManager");
        customSwipeViewPager.setAdapter(new w(childFragmentManager));
        N0().g.setOffscreenPageLimit(0);
        N0().g.setCurrentItem(1);
        N0().g.addOnPageChangeListener(new i0.e.b.g3.p.h(this));
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        i.d(onBackPressedDispatcher, "requireActivity().onBackPressedDispatcher");
        g0.a.b.b.a.a(onBackPressedDispatcher, this, false, new l<h0.a.b, m0.i>() { // from class: com.clubhouse.android.ui.hallway.HallwayFragment$setUpBuddyList$2
            @Override // m0.n.a.l
            public m0.i invoke(b bVar) {
                b bVar2 = bVar;
                i.e(bVar2, "$this$addCallback");
                HallwayFragment hallwayFragment = HallwayFragment.this;
                k<Object>[] kVarArr = HallwayFragment.Z1;
                if (hallwayFragment.N0().g.getCurrentItem() == 0) {
                    HallwayFragment.this.N0().g.setCurrentItem(1);
                } else {
                    bVar2.a = false;
                    HallwayFragment.this.requireActivity().onBackPressed();
                }
                return m0.i.a;
            }
        }, 2);
        N0().g.setPageTransformer(false, i0.e.b.g3.p.f.a);
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$12 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(N0().g.getSwipeFlow(), new HallwayFragment$onViewCreated$5(this, null));
        h0.q.p viewLifecycleOwner2 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner2, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$12, q.a(viewLifecycleOwner2));
        N0().c.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.p.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HallwayFragment hallwayFragment = HallwayFragment.this;
                k<Object>[] kVarArr = HallwayFragment.Z1;
                i.e(hallwayFragment, "this$0");
                v.a1(hallwayFragment, new h0.t.a(R.id.action_hallwayFragment_to_invitesFragment), null, 2);
            }
        });
        N0().b.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.p.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HallwayFragment hallwayFragment = HallwayFragment.this;
                k<Object>[] kVarArr = HallwayFragment.Z1;
                i.e(hallwayFragment, "this$0");
                v.a1(hallwayFragment, new h0.t.a(R.id.action_hallwayFragment_to_eventsFragment), null, 2);
            }
        });
        N0().h.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.p.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HallwayFragment hallwayFragment = HallwayFragment.this;
                k<Object>[] kVarArr = HallwayFragment.Z1;
                i.e(hallwayFragment, "this$0");
                v.a1(hallwayFragment, new h0.t.a(R.id.action_hallwayFragment_to_exploreFragment), null, 2);
            }
        });
        N0().f.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.p.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HallwayFragment hallwayFragment = HallwayFragment.this;
                k<Object>[] kVarArr = HallwayFragment.Z1;
                i.e(hallwayFragment, "this$0");
                v.a1(hallwayFragment, new h0.t.a(R.id.action_hallwayFragment_to_activityFragment), null, 2);
            }
        });
        UpdatesCoordinator updatesCoordinator = this.a2;
        if (updatesCoordinator != null) {
            if (updatesCoordinator.b.k() < 4734) {
                z = true;
            }
            if (z) {
                h0.q.p viewLifecycleOwner3 = getViewLifecycleOwner();
                i.d(viewLifecycleOwner3, "viewLifecycleOwner");
                m0.r.t.a.r.m.a1.a.E2(q.a(viewLifecycleOwner3), null, null, new HallwayFragment$onViewCreated$10(this, null), 3, null);
                return;
            }
            return;
        }
        i.m("updatescoordinator");
        throw null;
    }
}
