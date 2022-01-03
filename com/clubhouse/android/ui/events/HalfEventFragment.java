package com.clubhouse.android.ui.events;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.airbnb.epoxy.EpoxyRecyclerView;
import com.airbnb.mvrx.ViewModelDoesNotExistException;
import com.clubhouse.android.data.models.local.EventInClub;
import com.clubhouse.android.databinding.FragmentHalfEventBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.ui.events.HalfEventFragment;
import com.clubhouse.app.R;
import h0.b0.v;
import h0.q.p;
import h0.q.q;
import i0.b.a.o;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.d.a.a.a;
import i0.e.b.g3.o.l0;
import i0.e.b.g3.o.x0.e;
import i0.e.b.g3.o.x0.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.i;
import m0.n.a.l;
import m0.n.b.f;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
/* compiled from: HalfEventFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b$\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u00020\u000b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001e\u001a\u00020\u00198B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010#\u001a\u00020\u001f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\r\u001a\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lcom/clubhouse/android/ui/events/HalfEventFragment;", "Lcom/clubhouse/android/core/ui/BaseBottomSheetFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lcom/clubhouse/android/ui/events/HalfEventViewModel;", "u2", "Lm0/c;", "V0", "()Lcom/clubhouse/android/ui/events/HalfEventViewModel;", "viewModel", "Li0/e/a/b/a;", "s2", "Li0/e/a/b/a;", "getActionTrailRecorder", "()Li0/e/a/b/a;", "setActionTrailRecorder", "(Li0/e/a/b/a;)V", "actionTrailRecorder", "Lcom/clubhouse/android/databinding/FragmentHalfEventBinding;", "t2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "U0", "()Lcom/clubhouse/android/databinding/FragmentHalfEventBinding;", "binding", "Lcom/clubhouse/android/ui/events/EventsViewModel;", "v2", "getEventsViewModel", "()Lcom/clubhouse/android/ui/events/EventsViewModel;", "eventsViewModel", "<init>", "p2", "b", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class HalfEventFragment extends Hilt_HalfEventFragment {
    public i0.e.a.b.a s2;
    public final FragmentViewBindingDelegate t2 = new FragmentViewBindingDelegate(FragmentHalfEventBinding.class, this);
    public final m0.c u2;
    public final m0.c v2;
    public static final /* synthetic */ k<Object>[] q2 = {m.c(new PropertyReference1Impl(m.a(HalfEventFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentHalfEventBinding;")), m.c(new PropertyReference1Impl(m.a(HalfEventFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/events/HalfEventViewModel;")), m.c(new PropertyReference1Impl(m.a(HalfEventFragment.class), "eventsViewModel", "getEventsViewModel()Lcom/clubhouse/android/ui/events/EventsViewModel;"))};
    public static final b p2 = new b(null);
    public static final String r2 = "event_following_result";

    /* compiled from: kotlin-style lambda group */
    /* loaded from: classes.dex */
    public static final class a extends Lambda implements l<o, i> {
        public final /* synthetic */ int c;
        public final /* synthetic */ Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(1);
            this.c = i;
            this.d = obj;
        }

        @Override // m0.n.a.l
        public final i invoke(o oVar) {
            int i = this.c;
            if (i == 0) {
                o oVar2 = oVar;
                m0.n.b.i.e(oVar2, "$this$safeWithModels");
                HalfEventFragment halfEventFragment = (HalfEventFragment) this.d;
                b bVar = HalfEventFragment.p2;
                v.v2(halfEventFragment.V0(), new HalfEventFragment$buildEventsModels$1(oVar2, halfEventFragment));
                return i.a;
            } else if (i == 1) {
                o oVar3 = oVar;
                m0.n.b.i.e(oVar3, "$this$safeWithModels");
                HalfEventFragment halfEventFragment2 = (HalfEventFragment) this.d;
                b bVar2 = HalfEventFragment.p2;
                v.v2(halfEventFragment2.V0(), new HalfEventFragment$buildEventClubActionModels$1(oVar3, halfEventFragment2));
                return i.a;
            } else {
                throw null;
            }
        }
    }

    /* compiled from: HalfEventFragment.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        public b(f fVar) {
        }
    }

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class c extends h<HalfEventFragment, HalfEventViewModel> {
        public final /* synthetic */ m0.r.d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ m0.r.d c;

        public c(m0.r.d dVar, boolean z, l lVar, m0.r.d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public m0.c<HalfEventViewModel> a(HalfEventFragment halfEventFragment, k kVar) {
            HalfEventFragment halfEventFragment2 = halfEventFragment;
            m0.n.b.i.e(halfEventFragment2, "thisRef");
            m0.n.b.i.e(kVar, "property");
            return g.a.b(halfEventFragment2, kVar, this.a, new HalfEventFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(l0.class), false, this.b);
        }
    }

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class d extends h<HalfEventFragment, EventsViewModel> {
        public final /* synthetic */ m0.r.d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ m0.r.d c;

        public d(m0.r.d dVar, boolean z, l lVar, m0.r.d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public m0.c<EventsViewModel> a(HalfEventFragment halfEventFragment, k kVar) {
            HalfEventFragment halfEventFragment2 = halfEventFragment;
            m0.n.b.i.e(halfEventFragment2, "thisRef");
            m0.n.b.i.e(kVar, "property");
            return g.a.b(halfEventFragment2, kVar, this.a, new HalfEventFragment$special$$inlined$parentFragmentViewModel$default$2$1(this), m.a(EventsViewState.class), true, this.b);
        }
    }

    public HalfEventFragment() {
        super(R.layout.fragment_half_event);
        m0.r.d a2 = m.a(HalfEventViewModel.class);
        c cVar = new c(a2, false, new l<i0.b.b.k<HalfEventViewModel, l0>, HalfEventViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.events.HalfEventFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.airbnb.mvrx.MavericksViewModel, com.clubhouse.android.ui.events.HalfEventViewModel] */
            @Override // m0.n.a.l
            public HalfEventViewModel invoke(i0.b.b.k<HalfEventViewModel, l0> kVar) {
                i0.b.b.k<HalfEventViewModel, l0> kVar2 = kVar;
                m0.n.b.i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                m0.n.b.i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                m0.n.b.i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, l0.class, dVar, name, false, kVar2, 16);
            }
        }, a2);
        k<?>[] kVarArr = q2;
        this.u2 = cVar.a(this, kVarArr[1]);
        m0.r.d a3 = m.a(EventsViewModel.class);
        this.v2 = new d(a3, true, new l<i0.b.b.k<EventsViewModel, EventsViewState>, EventsViewModel>(a3, a3) { // from class: com.clubhouse.android.ui.events.HalfEventFragment$special$$inlined$parentFragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r1v14, types: [com.airbnb.mvrx.MavericksViewModel, com.clubhouse.android.ui.events.EventsViewModel] */
            /* JADX WARN: Type inference failed for: r1v19, types: [com.airbnb.mvrx.MavericksViewModel, com.clubhouse.android.ui.events.EventsViewModel] */
            @Override // m0.n.a.l
            public EventsViewModel invoke(i0.b.b.k<EventsViewModel, EventsViewState> kVar) {
                i0.b.b.k<EventsViewModel, EventsViewState> kVar2 = kVar;
                m0.n.b.i.e(kVar2, "stateFactory");
                if (Fragment.this.getParentFragment() != null) {
                    String G0 = a.G0(this.q, "viewModelClass.java.name");
                    for (Fragment parentFragment = Fragment.this.getParentFragment(); parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
                        try {
                            x xVar = x.a;
                            Class l1 = i0.j.f.p.h.l1(this.d);
                            h0.o.a.k requireActivity = Fragment.this.requireActivity();
                            m0.n.b.i.d(requireActivity, "this.requireActivity()");
                            return x.a(xVar, l1, EventsViewState.class, new i0.b.b.d(requireActivity, v.a(Fragment.this), parentFragment, null, null, 24), G0, true, null, 32);
                        } catch (ViewModelDoesNotExistException unused) {
                        }
                    }
                    Fragment parentFragment2 = Fragment.this.getParentFragment();
                    while (true) {
                        if ((parentFragment2 != null ? parentFragment2.getParentFragment() : null) != null) {
                            parentFragment2 = parentFragment2.getParentFragment();
                        } else {
                            h0.o.a.k requireActivity2 = Fragment.this.requireActivity();
                            m0.n.b.i.d(requireActivity2, "requireActivity()");
                            Object a4 = v.a(Fragment.this);
                            m0.n.b.i.c(parentFragment2);
                            return x.a(x.a, i0.j.f.p.h.l1(this.d), EventsViewState.class, new i0.b.b.d(requireActivity2, a4, parentFragment2, null, null, 24), a.G0(this.q, "viewModelClass.java.name"), false, kVar2, 16);
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
        v.v2(V0(), new l<l0, i>() { // from class: com.clubhouse.android.ui.events.HalfEventFragment$invalidate$1
            @Override // m0.n.a.l
            public i invoke(l0 l0Var) {
                String str;
                l0 l0Var2 = l0Var;
                m0.n.b.i.e(l0Var2, "state");
                EventInClub eventInClub = l0Var2.c;
                if (eventInClub == null) {
                    return null;
                }
                HalfEventFragment halfEventFragment = HalfEventFragment.this;
                HalfEventFragment.b bVar = HalfEventFragment.p2;
                halfEventFragment.U0().e.g();
                halfEventFragment.U0().b.g();
                halfEventFragment.U0().c.g();
                Button button = halfEventFragment.U0().d;
                if (l0Var2.e) {
                    str = halfEventFragment.getString(R.string.join_the_room_in_progress);
                } else {
                    str = halfEventFragment.getString(R.string.start_the_room);
                }
                button.setText(str);
                Button button2 = halfEventFragment.U0().d;
                m0.n.b.i.d(button2, "binding.joinCreateRoomButton");
                i0.e.b.d3.k.L(button2, Boolean.valueOf(l0Var2.e || l0Var2.f));
                Button button3 = halfEventFragment.U0().a;
                m0.n.b.i.d(button3, "binding.endedConversation");
                i0.e.b.d3.k.L(button3, Boolean.valueOf(eventInClub.g2));
                EpoxyRecyclerView epoxyRecyclerView = halfEventFragment.U0().b;
                m0.n.b.i.d(epoxyRecyclerView, "binding.eventActionsList");
                i0.e.b.d3.k.q(epoxyRecyclerView, Boolean.valueOf(l0Var2.g));
                EpoxyRecyclerView epoxyRecyclerView2 = halfEventFragment.U0().c;
                m0.n.b.i.d(epoxyRecyclerView2, "binding.eventClubActionsList");
                i0.e.b.d3.k.L(epoxyRecyclerView2, Boolean.valueOf(l0Var2.g));
                return i.a;
            }
        });
    }

    public final FragmentHalfEventBinding U0() {
        return (FragmentHalfEventBinding) this.t2.getValue(this, q2[0]);
    }

    public final HalfEventViewModel V0() {
        return (HalfEventViewModel) this.u2.getValue();
    }

    @Override // com.clubhouse.android.core.ui.BaseBottomSheetFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m0.n.b.i.e(view, "view");
        super.onViewCreated(view, bundle);
        v.U1(this);
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(V0().l, new HalfEventFragment$onViewCreated$1(this, null));
        p viewLifecycleOwner = getViewLifecycleOwner();
        m0.n.b.i.d(viewLifecycleOwner, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner));
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$12 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(((EventsViewModel) this.v2.getValue()).l, new HalfEventFragment$onViewCreated$2(this, null));
        p viewLifecycleOwner2 = getViewLifecycleOwner();
        m0.n.b.i.d(viewLifecycleOwner2, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$12, q.a(viewLifecycleOwner2));
        v.h1(this, V0(), HalfEventFragment$onViewCreated$3.c, null, new HalfEventFragment$onViewCreated$4(this, null), new HalfEventFragment$onViewCreated$5(this, null), 2, null);
        Button button = U0().d;
        m0.n.b.i.d(button, "binding.joinCreateRoomButton");
        p viewLifecycleOwner3 = getViewLifecycleOwner();
        m0.n.b.i.d(viewLifecycleOwner3, "viewLifecycleOwner");
        i0.e.b.d3.k.H(button, q.a(viewLifecycleOwner3), new View.OnClickListener() { // from class: i0.e.b.g3.o.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                HalfEventFragment halfEventFragment = HalfEventFragment.this;
                HalfEventFragment.b bVar = HalfEventFragment.p2;
                m0.n.b.i.e(halfEventFragment, "this$0");
                v.v2(halfEventFragment.V0(), 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: INVOKE  
                      (wrap: com.clubhouse.android.ui.events.HalfEventViewModel : 0x0009: INVOKE  (r0v2 com.clubhouse.android.ui.events.HalfEventViewModel A[REMOVE]) = (r3v1 'halfEventFragment' com.clubhouse.android.ui.events.HalfEventFragment) type: VIRTUAL call: com.clubhouse.android.ui.events.HalfEventFragment.V0():com.clubhouse.android.ui.events.HalfEventViewModel)
                      (wrap: com.clubhouse.android.ui.events.HalfEventFragment$onViewCreated$6$1 : 0x000f: CONSTRUCTOR  (r1v0 com.clubhouse.android.ui.events.HalfEventFragment$onViewCreated$6$1 A[REMOVE]) = (r3v1 'halfEventFragment' com.clubhouse.android.ui.events.HalfEventFragment) call: com.clubhouse.android.ui.events.HalfEventFragment$onViewCreated$6$1.<init>(com.clubhouse.android.ui.events.HalfEventFragment):void type: CONSTRUCTOR)
                     type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: i0.e.b.g3.o.u.onClick(android.view.View):void, file: classes3.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.events.HalfEventFragment$onViewCreated$6$1, state: NOT_LOADED
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
                    com.clubhouse.android.ui.events.HalfEventFragment r3 = com.clubhouse.android.ui.events.HalfEventFragment.this
                    com.clubhouse.android.ui.events.HalfEventFragment$b r0 = com.clubhouse.android.ui.events.HalfEventFragment.p2
                    java.lang.String r0 = "this$0"
                    m0.n.b.i.e(r3, r0)
                    com.clubhouse.android.ui.events.HalfEventViewModel r0 = r3.V0()
                    com.clubhouse.android.ui.events.HalfEventFragment$onViewCreated$6$1 r1 = new com.clubhouse.android.ui.events.HalfEventFragment$onViewCreated$6$1
                    r1.<init>(r3)
                    h0.b0.v.v2(r0, r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.o.u.onClick(android.view.View):void");
            }
        });
        U0().e.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        EpoxyRecyclerView epoxyRecyclerView = U0().e;
        m0.n.b.i.d(epoxyRecyclerView, "binding.singleEventList");
        i0.e.b.d3.k.E(epoxyRecyclerView, new a(0, this));
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 43);
        U0().b.setLayoutManager(gridLayoutManager);
        EpoxyRecyclerView epoxyRecyclerView2 = U0().b;
        m0.n.b.i.d(epoxyRecyclerView2, "binding.eventActionsList");
        i0.e.b.d3.k.D(epoxyRecyclerView2, this, new l<o, i>(this) { // from class: com.clubhouse.android.ui.events.HalfEventFragment$buildEventActionModels$1
            public final /* synthetic */ HalfEventFragment d;

            {
                this.d = r2;
            }

            @Override // m0.n.a.l
            public i invoke(o oVar) {
                final o oVar2 = oVar;
                m0.n.b.i.e(oVar2, "$this$null");
                GridLayoutManager.this.g = oVar2.getSpanSizeLookup();
                HalfEventFragment halfEventFragment = this.d;
                HalfEventFragment.b bVar = HalfEventFragment.p2;
                HalfEventViewModel V0 = halfEventFragment.V0();
                final HalfEventFragment halfEventFragment2 = this.d;
                v.v2(V0, new l<l0, i>() { // from class: com.clubhouse.android.ui.events.HalfEventFragment$buildEventActionModels$1.1
                    @Override // m0.n.a.l
                    public i invoke(l0 l0Var) {
                        l0 l0Var2 = l0Var;
                        m0.n.b.i.e(l0Var2, "state");
                        if (l0Var2.c != null) {
                            o oVar3 = o.this;
                            HalfEventFragment halfEventFragment3 = halfEventFragment2;
                            EventActionType[] values = EventActionType.values();
                            for (int i = 0; i < 4; i++) {
                                EventActionType eventActionType = values[i];
                                e eVar = new e();
                                eVar.P(new Number[]{Integer.valueOf(eventActionType.ordinal())});
                                eVar.Q(halfEventFragment3.getString(eventActionType.getTitle()));
                                eVar.O(Integer.valueOf(eventActionType.getIcon()));
                                eVar.M(l0Var2.c.g2);
                                eVar.L(new i0.e.b.g3.o.m(halfEventFragment3, eventActionType, l0Var2));
                                oVar3.add(eVar);
                                int ordinal = eventActionType.ordinal();
                                EventActionType.values();
                                if (ordinal != 3) {
                                    t tVar = new t();
                                    tVar.K(m0.n.b.i.k("divider", Integer.valueOf(eventActionType.ordinal())));
                                    oVar3.add(tVar);
                                }
                            }
                        }
                        return i.a;
                    }
                });
                return i.a;
            }
        });
        U0().c.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        EpoxyRecyclerView epoxyRecyclerView3 = U0().c;
        m0.n.b.i.d(epoxyRecyclerView3, "binding.eventClubActionsList");
        i0.e.b.d3.k.E(epoxyRecyclerView3, new a(1, this));
    }
}
