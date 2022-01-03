package com.clubhouse.android.ui.onboarding;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.epoxy.EpoxyViewBinder;
import com.airbnb.epoxy.EpoxyViewBinderExtensionsKt$epoxyView$3;
import com.airbnb.epoxy.EpoxyViewStub;
import com.airbnb.epoxy.LifecycleAwareEpoxyViewBinder;
import com.airbnb.epoxy.LifecycleAwareEpoxyViewBinder$view$$inlined$maybeFindViewByIdName$1;
import com.airbnb.epoxy.ViewExtensionsKt$allRecursiveChildren$1;
import com.clubhouse.android.data.models.local.channel.ChannelInRoom;
import com.clubhouse.android.databinding.FragmentWelcomeRoomBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.ui.onboarding.WelcomeRoomFragment;
import com.clubhouse.android.ui.onboarding.WelcomeRoomFragment$onViewCreated$3$1;
import com.clubhouse.app.R;
import h0.b0.v;
import h0.q.q;
import i0.b.a.e0;
import i0.b.a.o0;
import i0.b.a.t;
import i0.b.a.v;
import i0.b.a.w;
import i0.b.b.f;
import i0.b.b.f0;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.d.a.a.a;
import i0.e.b.g3.r.y2;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.sequences.SequencesKt___SequencesKt;
import m0.c;
import m0.n.a.l;
import m0.n.a.p;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
import m0.s.e;
/* compiled from: WelcomeRoomFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u00020\u000b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0015\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001b\u001a\u00020\u00168B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/clubhouse/android/ui/onboarding/WelcomeRoomFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lcom/airbnb/epoxy/LifecycleAwareEpoxyViewBinder;", "c2", "Lm0/c;", "getWelcomeChannelViewBinder", "()Lcom/airbnb/epoxy/LifecycleAwareEpoxyViewBinder;", "welcomeChannelViewBinder", "Lcom/clubhouse/android/ui/onboarding/WelcomeRoomViewModel;", "a2", "O0", "()Lcom/clubhouse/android/ui/onboarding/WelcomeRoomViewModel;", "viewModel", "Lcom/clubhouse/android/databinding/FragmentWelcomeRoomBinding;", "b2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "getBinding", "()Lcom/clubhouse/android/databinding/FragmentWelcomeRoomBinding;", "binding", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class WelcomeRoomFragment extends Hilt_WelcomeRoomFragment {
    public static final /* synthetic */ k<Object>[] Z1;
    public final c a2;
    public final FragmentViewBindingDelegate b2 = new FragmentViewBindingDelegate(FragmentWelcomeRoomBinding.class, this);
    public final c c2;

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<WelcomeRoomFragment, WelcomeRoomViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<WelcomeRoomViewModel> a(WelcomeRoomFragment welcomeRoomFragment, k kVar) {
            WelcomeRoomFragment welcomeRoomFragment2 = welcomeRoomFragment;
            i.e(welcomeRoomFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(welcomeRoomFragment2, kVar, this.a, new WelcomeRoomFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(y2.class), false, this.b);
        }
    }

    static {
        k<Object>[] kVarArr = new k[3];
        kVarArr[0] = m.c(new PropertyReference1Impl(m.a(WelcomeRoomFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/onboarding/WelcomeRoomViewModel;"));
        kVarArr[1] = m.c(new PropertyReference1Impl(m.a(WelcomeRoomFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentWelcomeRoomBinding;"));
        Z1 = kVarArr;
    }

    public WelcomeRoomFragment() {
        super(R.layout.fragment_welcome_room);
        d a2 = m.a(WelcomeRoomViewModel.class);
        this.a2 = new a(a2, false, new l<i0.b.b.k<WelcomeRoomViewModel, y2>, WelcomeRoomViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.onboarding.WelcomeRoomFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.airbnb.mvrx.MavericksViewModel, com.clubhouse.android.ui.onboarding.WelcomeRoomViewModel] */
            @Override // m0.n.a.l
            public WelcomeRoomViewModel invoke(i0.b.b.k<WelcomeRoomViewModel, y2> kVar) {
                i0.b.b.k<WelcomeRoomViewModel, y2> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, y2.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, Z1[0]);
        WelcomeRoomFragment$welcomeChannelViewBinder$2 welcomeRoomFragment$welcomeChannelViewBinder$2 = new p<e0, Context, m0.i>() { // from class: com.clubhouse.android.ui.onboarding.WelcomeRoomFragment$welcomeChannelViewBinder$2
            @Override // m0.n.a.p
            public m0.i invoke(e0 e0Var, Context context) {
                e0 e0Var2 = e0Var;
                i.e(e0Var2, "$this$epoxyView");
                i.e(context, "it");
                WelcomeRoomFragment welcomeRoomFragment = WelcomeRoomFragment.this;
                k<Object>[] kVarArr = WelcomeRoomFragment.Z1;
                m0.i iVar = (m0.i) v.v2(welcomeRoomFragment.O0(), 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001f: CHECK_CAST (r3v3 'iVar' m0.i) = (m0.i) (wrap: java.lang.Object : 0x001b: INVOKE  (r3v2 java.lang.Object A[REMOVE]) = 
                      (wrap: com.clubhouse.android.ui.onboarding.WelcomeRoomViewModel : 0x0012: INVOKE  (r0v3 com.clubhouse.android.ui.onboarding.WelcomeRoomViewModel A[REMOVE]) = (r4v2 'welcomeRoomFragment' com.clubhouse.android.ui.onboarding.WelcomeRoomFragment) type: VIRTUAL call: com.clubhouse.android.ui.onboarding.WelcomeRoomFragment.O0():com.clubhouse.android.ui.onboarding.WelcomeRoomViewModel)
                      (wrap: com.clubhouse.android.ui.onboarding.WelcomeRoomFragment$buildChannel$1 : 0x0018: CONSTRUCTOR  (r1v0 com.clubhouse.android.ui.onboarding.WelcomeRoomFragment$buildChannel$1 A[REMOVE]) = (r3v1 'e0Var2' i0.b.a.e0), (r4v2 'welcomeRoomFragment' com.clubhouse.android.ui.onboarding.WelcomeRoomFragment) call: com.clubhouse.android.ui.onboarding.WelcomeRoomFragment$buildChannel$1.<init>(i0.b.a.e0, com.clubhouse.android.ui.onboarding.WelcomeRoomFragment):void type: CONSTRUCTOR)
                     type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object) in method: com.clubhouse.android.ui.onboarding.WelcomeRoomFragment$welcomeChannelViewBinder$2.invoke(i0.b.a.e0, android.content.Context):m0.i, file: classes3.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.onboarding.WelcomeRoomFragment$buildChannel$1, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:974)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:799)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:305)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                    	... 15 more
                    */
                /*
                    this = this;
                    i0.b.a.e0 r3 = (i0.b.a.e0) r3
                    android.content.Context r4 = (android.content.Context) r4
                    java.lang.String r0 = "$this$epoxyView"
                    m0.n.b.i.e(r3, r0)
                    java.lang.String r0 = "it"
                    m0.n.b.i.e(r4, r0)
                    com.clubhouse.android.ui.onboarding.WelcomeRoomFragment r4 = com.clubhouse.android.ui.onboarding.WelcomeRoomFragment.this
                    m0.r.k<java.lang.Object>[] r0 = com.clubhouse.android.ui.onboarding.WelcomeRoomFragment.Z1
                    com.clubhouse.android.ui.onboarding.WelcomeRoomViewModel r0 = r4.O0()
                    com.clubhouse.android.ui.onboarding.WelcomeRoomFragment$buildChannel$1 r1 = new com.clubhouse.android.ui.onboarding.WelcomeRoomFragment$buildChannel$1
                    r1.<init>(r3, r4)
                    java.lang.Object r3 = h0.b0.v.v2(r0, r1)
                    m0.i r3 = (m0.i) r3
                    m0.i r3 = m0.i.a
                    return r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.clubhouse.android.ui.onboarding.WelcomeRoomFragment$welcomeChannelViewBinder$2.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
            }
        };
        EpoxyViewBinderExtensionsKt$epoxyView$3 epoxyViewBinderExtensionsKt$epoxyView$3 = EpoxyViewBinderExtensionsKt$epoxyView$3.c;
        i.e(this, "$this$epoxyView");
        i.e(epoxyViewBinderExtensionsKt$epoxyView$3, "initializer");
        i.e(welcomeRoomFragment$welcomeChannelViewBinder$2, "modelProvider");
        this.c2 = i0.j.f.p.h.H2(new m0.n.a.a<LifecycleAwareEpoxyViewBinder>(R.id.welcome_channel, false, false, epoxyViewBinderExtensionsKt$epoxyView$3, welcomeRoomFragment$welcomeChannelViewBinder$2) { // from class: com.airbnb.epoxy.EpoxyViewBinderExtensionsKt$epoxyView$4
            public final /* synthetic */ p Y1;
            public final /* synthetic */ int d;
            public final /* synthetic */ boolean q;
            public final /* synthetic */ boolean x;
            public final /* synthetic */ l y;

            {
                this.d = r2;
                this.q = r3;
                this.x = r4;
                this.y = r5;
                this.Y1 = r6;
            }

            @Override // m0.n.a.a
            public LifecycleAwareEpoxyViewBinder invoke() {
                Fragment fragment = Fragment.this;
                int i = this.d;
                boolean z = this.q;
                boolean z2 = this.x;
                l lVar = this.y;
                p pVar = this.Y1;
                h0.q.p viewLifecycleOwner = fragment.getViewLifecycleOwner();
                i.d(viewLifecycleOwner, "viewLifecycleOwner");
                LifecycleAwareEpoxyViewBinder lifecycleAwareEpoxyViewBinder = new LifecycleAwareEpoxyViewBinder(viewLifecycleOwner, 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001d: CONSTRUCTOR  (r9v0 'lifecycleAwareEpoxyViewBinder' com.airbnb.epoxy.LifecycleAwareEpoxyViewBinder) = 
                      (r2v0 'viewLifecycleOwner' h0.q.p)
                      (wrap: com.airbnb.epoxy.EpoxyViewBinderExtensionsKt$epoxyViewInternal$2 : 0x0019: CONSTRUCTOR  (r3v0 com.airbnb.epoxy.EpoxyViewBinderExtensionsKt$epoxyViewInternal$2 A[REMOVE]) = (r0v0 'fragment' androidx.fragment.app.Fragment) call: com.airbnb.epoxy.EpoxyViewBinderExtensionsKt$epoxyViewInternal$2.<init>(androidx.fragment.app.Fragment):void type: CONSTRUCTOR)
                      (r4v0 'i' int)
                      (r5v0 'z' boolean)
                      (r6v0 'z2' boolean)
                      (r7v0 'pVar' m0.n.a.p)
                     call: com.airbnb.epoxy.LifecycleAwareEpoxyViewBinder.<init>(h0.q.p, m0.n.a.a, int, boolean, boolean, m0.n.a.p):void type: CONSTRUCTOR in method: com.airbnb.epoxy.EpoxyViewBinderExtensionsKt$epoxyView$4.invoke():com.airbnb.epoxy.LifecycleAwareEpoxyViewBinder, file: classes.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.airbnb.epoxy.EpoxyViewBinderExtensionsKt$epoxyViewInternal$2, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:974)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:709)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                    	... 15 more
                    */
                /*
                    this = this;
                    androidx.fragment.app.Fragment r0 = androidx.fragment.app.Fragment.this
                    int r4 = r10.d
                    boolean r5 = r10.q
                    boolean r6 = r10.x
                    m0.n.a.l r8 = r10.y
                    m0.n.a.p r7 = r10.Y1
                    com.airbnb.epoxy.LifecycleAwareEpoxyViewBinder r9 = new com.airbnb.epoxy.LifecycleAwareEpoxyViewBinder
                    h0.q.p r2 = r0.getViewLifecycleOwner()
                    java.lang.String r1 = "viewLifecycleOwner"
                    m0.n.b.i.d(r2, r1)
                    com.airbnb.epoxy.EpoxyViewBinderExtensionsKt$epoxyViewInternal$2 r3 = new com.airbnb.epoxy.EpoxyViewBinderExtensionsKt$epoxyViewInternal$2
                    r3.<init>(r0)
                    r1 = r9
                    r1.<init>(r2, r3, r4, r5, r6, r7)
                    r8.invoke(r9)
                    return r9
                */
                throw new UnsupportedOperationException("Method not decompiled: com.airbnb.epoxy.EpoxyViewBinderExtensionsKt$epoxyView$4.invoke():java.lang.Object");
            }
        });
    }

    public static final FragmentWelcomeRoomBinding N0(WelcomeRoomFragment welcomeRoomFragment) {
        return (FragmentWelcomeRoomBinding) welcomeRoomFragment.b2.getValue(welcomeRoomFragment, Z1[1]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(O0(), new l<y2, m0.i>() { // from class: com.clubhouse.android.ui.onboarding.WelcomeRoomFragment$invalidate$1
            /* JADX WARN: Removed duplicated region for block: B:30:0x0160  */
            /* JADX WARN: Removed duplicated region for block: B:67:0x02c1  */
            /* JADX WARN: Removed duplicated region for block: B:68:0x02c7  */
            /* JADX WARN: Removed duplicated region for block: B:71:0x02cf  */
            @Override // m0.n.a.l
            /* Code decompiled incorrectly, please refer to instructions dump */
            public m0.i invoke(y2 y2Var) {
                String str;
                w wVar;
                t<?> tVar;
                String str2;
                String str3;
                Object obj;
                Resources resources;
                y2 y2Var2 = y2Var;
                i.e(y2Var2, "state");
                ProgressBar progressBar = WelcomeRoomFragment.N0(WelcomeRoomFragment.this).c;
                i.d(progressBar, "binding.loading");
                i0.e.b.d3.k.L(progressBar, Boolean.valueOf(y2Var2.a instanceof f));
                if (y2Var2.a instanceof f0) {
                    LinearLayout linearLayout = WelcomeRoomFragment.N0(WelcomeRoomFragment.this).b;
                    i.d(linearLayout, "binding.channelViews");
                    i0.e.b.d3.k.l(linearLayout);
                    Button button = WelcomeRoomFragment.N0(WelcomeRoomFragment.this).d;
                    i.d(button, "binding.noThanks");
                    i0.e.b.d3.k.l(button);
                    TextView textView = WelcomeRoomFragment.N0(WelcomeRoomFragment.this).e;
                    WelcomeRoomFragment welcomeRoomFragment = WelcomeRoomFragment.this;
                    ChannelInRoom channelInRoom = (ChannelInRoom) ((f0) y2Var2.a).b;
                    Objects.requireNonNull(welcomeRoomFragment);
                    if (channelInRoom.y().isEmpty()) {
                        str = welcomeRoomFragment.getString(R.string.welcome_room_title_empty);
                    } else if (channelInRoom.y().size() == 1) {
                        str = welcomeRoomFragment.getString(R.string.welcome_room_title_one_friend, channelInRoom.y().get(0).c);
                    } else if (channelInRoom.y().size() == 2) {
                        str = welcomeRoomFragment.getString(R.string.welcome_room_title_two_friends, channelInRoom.y().get(0).c, channelInRoom.y().get(1).c);
                    } else {
                        str = welcomeRoomFragment.getString(R.string.welcome_room_title_more_friends, channelInRoom.y().get(0).c, Integer.valueOf(channelInRoom.y().size() - 1));
                    }
                    i.d(str, "when {\n            users.isEmpty() -> {\n                getString(R.string.welcome_room_title_empty)\n            }\n            users.size == 1 -> {\n                getString(R.string.welcome_room_title_one_friend, users[0].firstName)\n            }\n            users.size == 2 -> {\n                getString(\n                    R.string.welcome_room_title_two_friends, users[0].firstName, users[1].firstName\n                )\n            }\n            else -> {\n                getString(\n                    R.string.welcome_room_title_more_friends, users[0].firstName, users.size - 1\n                )\n            }\n        }");
                    textView.setText(str);
                    LifecycleAwareEpoxyViewBinder lifecycleAwareEpoxyViewBinder = (LifecycleAwareEpoxyViewBinder) WelcomeRoomFragment.this.c2.getValue();
                    EpoxyViewBinder epoxyViewBinder = lifecycleAwareEpoxyViewBinder.c;
                    RecyclerView recyclerView = null;
                    if (lifecycleAwareEpoxyViewBinder.d == null) {
                        View invoke = lifecycleAwareEpoxyViewBinder.y.invoke();
                        if (invoke != null) {
                            int i = lifecycleAwareEpoxyViewBinder.Y1;
                            boolean z = lifecycleAwareEpoxyViewBinder.a2;
                            View findViewById = invoke.findViewById(i);
                            if (findViewById == null) {
                                if (z && i != -1) {
                                    try {
                                        resources = invoke.getResources();
                                    } catch (Resources.NotFoundException e) {
                                        StringBuilder P0 = a.P0("Id not found in ");
                                        P0.append(m.a(invoke.getClass()));
                                        P0.append(", fallbackToNameLookup: ");
                                        P0.append(z);
                                        P0.append(", ");
                                        P0.append("error message: ");
                                        P0.append(e.getLocalizedMessage());
                                        Log.e("ViewBinderViewExt", P0.toString());
                                    }
                                    if (resources != null) {
                                        str3 = resources.getResourceEntryName(i);
                                        if (str3 != null) {
                                            if (i.a(v.n0(invoke), str3)) {
                                                findViewById = invoke;
                                            } else if (invoke instanceof ViewGroup) {
                                                ViewGroup viewGroup = (ViewGroup) invoke;
                                                i.e(viewGroup, "$this$allRecursiveChildren");
                                                i.e(viewGroup, "$this$children");
                                                e.a aVar = new e.a((e) SequencesKt___SequencesKt.d(SequencesKt___SequencesKt.f(new h0.i.i.w(viewGroup), ViewExtensionsKt$allRecursiveChildren$1.c), LifecycleAwareEpoxyViewBinder$view$$inlined$maybeFindViewByIdName$1.c));
                                                while (true) {
                                                    if (!aVar.hasNext()) {
                                                        obj = null;
                                                        break;
                                                    }
                                                    obj = aVar.next();
                                                    if (i.a(v.n0((View) obj), str3)) {
                                                        break;
                                                    }
                                                }
                                                findViewById = (View) obj;
                                            }
                                        }
                                    }
                                    str3 = null;
                                    if (str3 != null) {
                                    }
                                }
                                findViewById = null;
                            }
                            if (findViewById != null) {
                                lifecycleAwareEpoxyViewBinder.d = findViewById;
                                if (!(findViewById instanceof EpoxyViewStub)) {
                                    try {
                                        str2 = invoke.getResources().getResourceName(lifecycleAwareEpoxyViewBinder.Y1);
                                    } catch (Resources.NotFoundException unused) {
                                        str2 = a.u0(new StringBuilder(), lifecycleAwareEpoxyViewBinder.Y1, " (name not found)");
                                    }
                                    EpoxyViewBinder epoxyViewBinder2 = lifecycleAwareEpoxyViewBinder.c;
                                    IllegalStateException illegalStateException = new IllegalStateException(a.o0("View binder should be using EpoxyViewStub. ", "View ID: ", str2));
                                    Objects.requireNonNull(epoxyViewBinder2);
                                    i.e(illegalStateException, "exception");
                                    EpoxyViewBinder.a.invoke(epoxyViewBinder2, illegalStateException);
                                }
                                lifecycleAwareEpoxyViewBinder.x.getLifecycle().a(lifecycleAwareEpoxyViewBinder);
                            } else {
                                StringBuilder P02 = a.P0("View could not be found, fallbackToNameLookup: ");
                                P02.append(lifecycleAwareEpoxyViewBinder.a2);
                                P02.append(',');
                                P02.append(" view id name: ");
                                P02.append(invoke.getResources().getResourceEntryName(lifecycleAwareEpoxyViewBinder.Y1));
                                throw new IllegalStateException(P02.toString().toString());
                            }
                        } else {
                            throw new IllegalStateException("Root view is not created".toString());
                        }
                    }
                    View view = lifecycleAwareEpoxyViewBinder.d;
                    i.c(view);
                    p<e0, Context, m0.i> pVar = lifecycleAwareEpoxyViewBinder.b2;
                    Objects.requireNonNull(epoxyViewBinder);
                    i.e(view, "previousView");
                    i.e(pVar, "modelProvider");
                    Context context = view.getContext();
                    i.d(context, "previousView.context");
                    pVar.invoke(epoxyViewBinder, context);
                    t<?> tVar2 = epoxyViewBinder.b;
                    epoxyViewBinder.b = null;
                    i.e(view, "previousView");
                    if (tVar2 != null) {
                        w v02 = v.v0(view);
                        if (v02 != null) {
                            v02.a();
                            t tVar3 = v02.a;
                            i.d(tVar3, "existingHolder.model");
                            if (o0.a(tVar2) == o0.a(tVar3)) {
                                wVar = v02;
                                View view2 = wVar.itemView;
                                view2.setVisibility(0);
                                view2.setId(view.getId());
                                i.d(view2, "viewHolder.itemView.appl…previousView.id\n        }");
                                if (v02 == null) {
                                    v02.a();
                                    tVar = v02.a;
                                } else {
                                    tVar = null;
                                }
                                if (!i.a(tVar, tVar2)) {
                                    wVar.b(tVar2, tVar, EmptyList.c, 0);
                                    View view3 = wVar.itemView;
                                    i.d(view3, "viewHolder.itemView");
                                    i.e(view3, "$this$viewHolder");
                                    view3.setTag(com.airbnb.epoxy.viewbinder.R.id.epoxy_view_binder, wVar);
                                }
                                view = view2;
                            }
                        }
                        ViewParent parent = view.getParent();
                        Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                        ViewGroup viewGroup2 = (ViewGroup) parent;
                        View n = tVar2.n(viewGroup2);
                        i.d(n, "newView");
                        n.setId(view.getId());
                        int indexOfChild = viewGroup2.indexOfChild(view);
                        viewGroup2.removeViewInLayout(view);
                        viewGroup2.addView(n, indexOfChild, view.getLayoutParams());
                        wVar = new w(viewGroup2, n, false);
                        View view22 = wVar.itemView;
                        view22.setVisibility(0);
                        view22.setId(view.getId());
                        i.d(view22, "viewHolder.itemView.appl…previousView.id\n        }");
                        if (v02 == null) {
                        }
                        if (!i.a(tVar, tVar2)) {
                        }
                        view = view22;
                    } else {
                        view.setVisibility(8);
                    }
                    if (lifecycleAwareEpoxyViewBinder.Z1) {
                        i0.b.a.v vVar = (i0.b.a.v) lifecycleAwareEpoxyViewBinder.q.getValue();
                        Objects.requireNonNull(vVar);
                        i.e(view, "view");
                        if (vVar.e != view) {
                            vVar.a();
                        }
                        vVar.e = view;
                        vVar.f = new v.b(vVar, view);
                        vVar.b(view, false, "attach");
                        if (view instanceof RecyclerView) {
                            recyclerView = view;
                        }
                        RecyclerView recyclerView2 = recyclerView;
                        if (recyclerView2 != null) {
                            vVar.d(recyclerView2);
                        }
                    }
                    lifecycleAwareEpoxyViewBinder.d = view;
                }
                return m0.i.a;
            }
        });
    }

    public final WelcomeRoomViewModel O0() {
        return (WelcomeRoomViewModel) this.a2.getValue();
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.e(view, "view");
        super.onViewCreated(view, bundle);
        h0.b0.v.h1(this, O0(), WelcomeRoomFragment$onViewCreated$1.c, h0.b0.v.q2(this, null, 1, null), null, new WelcomeRoomFragment$onViewCreated$2(this, null), 4, null);
        Button button = ((FragmentWelcomeRoomBinding) this.b2.getValue(this, Z1[1])).d;
        i.d(button, "binding.noThanks");
        h0.q.p viewLifecycleOwner = getViewLifecycleOwner();
        i.d(viewLifecycleOwner, "viewLifecycleOwner");
        i0.e.b.d3.k.H(button, q.a(viewLifecycleOwner), new View.OnClickListener() { // from class: i0.e.b.g3.r.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WelcomeRoomFragment welcomeRoomFragment = WelcomeRoomFragment.this;
                k<Object>[] kVarArr = WelcomeRoomFragment.Z1;
                i.e(welcomeRoomFragment, "this$0");
                WelcomeRoomFragment$onViewCreated$3$1 welcomeRoomFragment$onViewCreated$3$1 = 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: CONSTRUCTOR  (r0v2 'welcomeRoomFragment$onViewCreated$3$1' com.clubhouse.android.ui.onboarding.WelcomeRoomFragment$onViewCreated$3$1) = (r4v1 'welcomeRoomFragment' com.clubhouse.android.ui.onboarding.WelcomeRoomFragment) call: com.clubhouse.android.ui.onboarding.WelcomeRoomFragment$onViewCreated$3$1.<init>(com.clubhouse.android.ui.onboarding.WelcomeRoomFragment):void type: CONSTRUCTOR in method: i0.e.b.g3.r.d0.onClick(android.view.View):void, file: classes3.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.onboarding.WelcomeRoomFragment$onViewCreated$3$1, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                    	... 15 more
                    */
                /*
                    this = this;
                    com.clubhouse.android.ui.onboarding.WelcomeRoomFragment r4 = com.clubhouse.android.ui.onboarding.WelcomeRoomFragment.this
                    m0.r.k<java.lang.Object>[] r0 = com.clubhouse.android.ui.onboarding.WelcomeRoomFragment.Z1
                    java.lang.String r0 = "this$0"
                    m0.n.b.i.e(r4, r0)
                    com.clubhouse.android.ui.onboarding.WelcomeRoomFragment$onViewCreated$3$1 r0 = new com.clubhouse.android.ui.onboarding.WelcomeRoomFragment$onViewCreated$3$1
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
                throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.r.d0.onClick(android.view.View):void");
            }
        });
    }
}
