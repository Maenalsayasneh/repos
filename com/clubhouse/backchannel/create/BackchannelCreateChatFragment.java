package com.clubhouse.backchannel.create;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import com.airbnb.epoxy.EpoxyRecyclerView;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.ui.backchannel.CreateChatArgs;
import com.clubhouse.backchannel.R;
import com.clubhouse.backchannel.create.BackchannelCreateChatFragment;
import com.clubhouse.backchannel.databinding.FragmentBackchannelCreateChatBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import h0.b0.v;
import h0.q.p;
import h0.q.q;
import i0.b.a.o;
import i0.b.b.f;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.i;
import i0.b.b.x;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.c;
import m0.n.a.l;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
/* compiled from: BackchannelCreateChatFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u00020\u000b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0016\u001a\u00020\u00118\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001c\u001a\u00020\u00178B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\"\u001a\u00020\u001d8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/clubhouse/backchannel/create/BackchannelCreateChatFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lcom/clubhouse/android/ui/backchannel/CreateChatArgs;", "c2", "Lm0/o/c;", "getArgs", "()Lcom/clubhouse/android/ui/backchannel/CreateChatArgs;", "args", "", "d2", "Z", "K0", "()Z", "shouldShowKeyboard", "Lcom/clubhouse/backchannel/databinding/FragmentBackchannelCreateChatBinding;", "a2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "N0", "()Lcom/clubhouse/backchannel/databinding/FragmentBackchannelCreateChatBinding;", "binding", "Lcom/clubhouse/backchannel/create/BackchannelCreateChatViewModel;", "b2", "Lm0/c;", "O0", "()Lcom/clubhouse/backchannel/create/BackchannelCreateChatViewModel;", "viewModel", "<init>", "backchannel_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class BackchannelCreateChatFragment extends Hilt_BackchannelCreateChatFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(BackchannelCreateChatFragment.class), "binding", "getBinding()Lcom/clubhouse/backchannel/databinding/FragmentBackchannelCreateChatBinding;")), m.c(new PropertyReference1Impl(m.a(BackchannelCreateChatFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/backchannel/create/BackchannelCreateChatViewModel;")), m.c(new PropertyReference1Impl(m.a(BackchannelCreateChatFragment.class), "args", "getArgs()Lcom/clubhouse/android/ui/backchannel/CreateChatArgs;"))};
    public final c b2;
    public final FragmentViewBindingDelegate a2 = new FragmentViewBindingDelegate(FragmentBackchannelCreateChatBinding.class, this);
    public final m0.o.c c2 = new i();
    public final boolean d2 = true;

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<BackchannelCreateChatFragment, BackchannelCreateChatViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<BackchannelCreateChatViewModel> a(BackchannelCreateChatFragment backchannelCreateChatFragment, k kVar) {
            BackchannelCreateChatFragment backchannelCreateChatFragment2 = backchannelCreateChatFragment;
            m0.n.b.i.e(backchannelCreateChatFragment2, "thisRef");
            m0.n.b.i.e(kVar, "property");
            return g.a.b(backchannelCreateChatFragment2, kVar, this.a, new BackchannelCreateChatFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(i0.e.c.e.h.class), false, this.b);
        }
    }

    public BackchannelCreateChatFragment() {
        super(R.layout.fragment_backchannel_create_chat);
        d a2 = m.a(BackchannelCreateChatViewModel.class);
        this.b2 = new a(a2, false, new l<i0.b.b.k<BackchannelCreateChatViewModel, i0.e.c.e.h>, BackchannelCreateChatViewModel>(a2, a2) { // from class: com.clubhouse.backchannel.create.BackchannelCreateChatFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.clubhouse.backchannel.create.BackchannelCreateChatViewModel, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.l
            public BackchannelCreateChatViewModel invoke(i0.b.b.k<BackchannelCreateChatViewModel, i0.e.c.e.h> kVar) {
                i0.b.b.k<BackchannelCreateChatViewModel, i0.e.c.e.h> kVar2 = kVar;
                m0.n.b.i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                m0.n.b.i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                m0.n.b.i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, i0.e.c.e.h.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, Z1[1]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(O0(), new l<i0.e.c.e.h, m0.i>() { // from class: com.clubhouse.backchannel.create.BackchannelCreateChatFragment$invalidate$1
            @Override // m0.n.a.l
            public m0.i invoke(i0.e.c.e.h hVar) {
                Integer num;
                i0.e.c.e.h hVar2 = hVar;
                m0.n.b.i.e(hVar2, "state");
                BackchannelCreateChatFragment backchannelCreateChatFragment = BackchannelCreateChatFragment.this;
                k<Object>[] kVarArr = BackchannelCreateChatFragment.Z1;
                backchannelCreateChatFragment.N0().f.g();
                ProgressBar progressBar = BackchannelCreateChatFragment.this.N0().e;
                m0.n.b.i.d(progressBar, "binding.loading");
                i0.e.b.d3.k.L(progressBar, Boolean.valueOf(hVar2.c instanceof f));
                FloatingActionButton floatingActionButton = BackchannelCreateChatFragment.this.N0().c;
                m0.n.b.i.d(floatingActionButton, "binding.create");
                i0.e.b.d3.k.L(floatingActionButton, Boolean.valueOf(hVar2.e));
                FrameLayout frameLayout = BackchannelCreateChatFragment.this.N0().d;
                m0.n.b.i.d(frameLayout, "binding.fullScreenLoading");
                CreateChatArgs createChatArgs = hVar2.a;
                if (createChatArgs == null) {
                    num = null;
                } else {
                    num = createChatArgs.d;
                }
                i0.e.b.d3.k.q(frameLayout, Boolean.valueOf(num == null));
                return m0.i.a;
            }
        });
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment
    public boolean K0() {
        return this.d2;
    }

    public final FragmentBackchannelCreateChatBinding N0() {
        return (FragmentBackchannelCreateChatBinding) this.a2.getValue(this, Z1[0]);
    }

    public final BackchannelCreateChatViewModel O0() {
        return (BackchannelCreateChatViewModel) this.b2.getValue();
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m0.n.b.i.e(view, "view");
        super.onViewCreated(view, bundle);
        N0().a.setBackgroundColor(v.t0(this));
        N0().h.setBackgroundColor(v.t0(this));
        N0().b.setOnClickListener(new View.OnClickListener() { // from class: i0.e.c.e.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BackchannelCreateChatFragment backchannelCreateChatFragment = BackchannelCreateChatFragment.this;
                k<Object>[] kVarArr = BackchannelCreateChatFragment.Z1;
                m0.n.b.i.e(backchannelCreateChatFragment, "this$0");
                h0.o.a.k activity = backchannelCreateChatFragment.getActivity();
                if (activity != null) {
                    activity.onBackPressed();
                }
            }
        });
        EpoxyRecyclerView epoxyRecyclerView = N0().f;
        m0.n.b.i.d(epoxyRecyclerView, "binding.results");
        i0.e.b.d3.k.D(epoxyRecyclerView, this, new l<o, m0.i>() { // from class: com.clubhouse.backchannel.create.BackchannelCreateChatFragment$onViewCreated$2
            @Override // m0.n.a.l
            public m0.i invoke(o oVar) {
                o oVar2 = oVar;
                m0.n.b.i.e(oVar2, "$this$safeBuildModelsWith");
                BackchannelCreateChatFragment backchannelCreateChatFragment = BackchannelCreateChatFragment.this;
                k<Object>[] kVarArr = BackchannelCreateChatFragment.Z1;
                EpoxyRecyclerView epoxyRecyclerView2 = backchannelCreateChatFragment.N0().f;
                m0.n.b.i.d(epoxyRecyclerView2, "binding.results");
                v.T1(oVar2, epoxyRecyclerView2);
                BackchannelCreateChatFragment backchannelCreateChatFragment2 = BackchannelCreateChatFragment.this;
                v.v2(backchannelCreateChatFragment2.O0(), 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0024: INVOKE  
                      (wrap: com.clubhouse.backchannel.create.BackchannelCreateChatViewModel : 0x001b: INVOKE  (r1v2 com.clubhouse.backchannel.create.BackchannelCreateChatViewModel A[REMOVE]) = (r0v4 'backchannelCreateChatFragment2' com.clubhouse.backchannel.create.BackchannelCreateChatFragment) type: VIRTUAL call: com.clubhouse.backchannel.create.BackchannelCreateChatFragment.O0():com.clubhouse.backchannel.create.BackchannelCreateChatViewModel)
                      (wrap: com.clubhouse.backchannel.create.BackchannelCreateChatFragment$buildModels$1 : 0x0021: CONSTRUCTOR  (r2v0 com.clubhouse.backchannel.create.BackchannelCreateChatFragment$buildModels$1 A[REMOVE]) = 
                      (r4v1 'oVar2' i0.b.a.o)
                      (r0v4 'backchannelCreateChatFragment2' com.clubhouse.backchannel.create.BackchannelCreateChatFragment)
                     call: com.clubhouse.backchannel.create.BackchannelCreateChatFragment$buildModels$1.<init>(i0.b.a.o, com.clubhouse.backchannel.create.BackchannelCreateChatFragment):void type: CONSTRUCTOR)
                     type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: com.clubhouse.backchannel.create.BackchannelCreateChatFragment$onViewCreated$2.invoke(i0.b.a.o):m0.i, file: classes3.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.backchannel.create.BackchannelCreateChatFragment$buildModels$1, state: NOT_LOADED
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
                    java.lang.String r0 = "$this$safeBuildModelsWith"
                    m0.n.b.i.e(r4, r0)
                    com.clubhouse.backchannel.create.BackchannelCreateChatFragment r0 = com.clubhouse.backchannel.create.BackchannelCreateChatFragment.this
                    m0.r.k<java.lang.Object>[] r1 = com.clubhouse.backchannel.create.BackchannelCreateChatFragment.Z1
                    com.clubhouse.backchannel.databinding.FragmentBackchannelCreateChatBinding r0 = r0.N0()
                    com.airbnb.epoxy.EpoxyRecyclerView r0 = r0.f
                    java.lang.String r1 = "binding.results"
                    m0.n.b.i.d(r0, r1)
                    h0.b0.v.T1(r4, r0)
                    com.clubhouse.backchannel.create.BackchannelCreateChatFragment r0 = com.clubhouse.backchannel.create.BackchannelCreateChatFragment.this
                    com.clubhouse.backchannel.create.BackchannelCreateChatViewModel r1 = r0.O0()
                    com.clubhouse.backchannel.create.BackchannelCreateChatFragment$buildModels$1 r2 = new com.clubhouse.backchannel.create.BackchannelCreateChatFragment$buildModels$1
                    r2.<init>(r4, r0)
                    h0.b0.v.v2(r1, r2)
                    m0.i r4 = m0.i.a
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.clubhouse.backchannel.create.BackchannelCreateChatFragment$onViewCreated$2.invoke(java.lang.Object):java.lang.Object");
            }
        });
        N0().f.setItemAnimator(null);
        EditText editText = N0().g;
        m0.n.b.i.d(editText, "binding.search");
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(i0.e.b.d3.k.f(editText), new BackchannelCreateChatFragment$onViewCreated$3(this, null));
        p viewLifecycleOwner = getViewLifecycleOwner();
        m0.n.b.i.d(viewLifecycleOwner, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner));
        FloatingActionButton floatingActionButton = N0().c;
        m0.n.b.i.d(floatingActionButton, "binding.create");
        p viewLifecycleOwner2 = getViewLifecycleOwner();
        m0.n.b.i.d(viewLifecycleOwner2, "viewLifecycleOwner");
        i0.e.b.d3.k.H(floatingActionButton, q.a(viewLifecycleOwner2), new View.OnClickListener() { // from class: i0.e.c.e.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BackchannelCreateChatFragment backchannelCreateChatFragment = BackchannelCreateChatFragment.this;
                k<Object>[] kVarArr = BackchannelCreateChatFragment.Z1;
                m0.n.b.i.e(backchannelCreateChatFragment, "this$0");
                backchannelCreateChatFragment.O0().p(new g(((CreateChatArgs) backchannelCreateChatFragment.c2.getValue(backchannelCreateChatFragment, BackchannelCreateChatFragment.Z1[2])).c));
            }
        });
        v.g(this, new m0.n.a.p<Boolean, Integer, m0.i>() { // from class: com.clubhouse.backchannel.create.BackchannelCreateChatFragment$onViewCreated$5
            @Override // m0.n.a.p
            public m0.i invoke(Boolean bool, Integer num) {
                bool.booleanValue();
                int intValue = num.intValue();
                BackchannelCreateChatFragment backchannelCreateChatFragment = BackchannelCreateChatFragment.this;
                k<Object>[] kVarArr = BackchannelCreateChatFragment.Z1;
                FloatingActionButton floatingActionButton2 = backchannelCreateChatFragment.N0().c;
                m0.n.b.i.d(floatingActionButton2, "binding.create");
                i0.e.b.d3.k.G(floatingActionButton2, intValue);
                EpoxyRecyclerView epoxyRecyclerView2 = BackchannelCreateChatFragment.this.N0().f;
                m0.n.b.i.d(epoxyRecyclerView2, "binding.results");
                v.W1(epoxyRecyclerView2, intValue);
                return m0.i.a;
            }
        });
        v.h1(this, O0(), BackchannelCreateChatFragment$onViewCreated$6.c, null, new BackchannelCreateChatFragment$onViewCreated$7(this, null), new BackchannelCreateChatFragment$onViewCreated$8(this, null), 2, null);
    }
}
