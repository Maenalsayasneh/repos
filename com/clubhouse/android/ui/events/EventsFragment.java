package com.clubhouse.android.ui.events;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.airbnb.epoxy.paging3.PagingDataEpoxyController;
import com.airbnb.mvrx.ViewModelDoesNotExistException;
import com.clubhouse.analytics.AmplitudeAnalytics;
import com.clubhouse.android.core.ui.BaseEpoxyModelWithHolder;
import com.clubhouse.android.data.models.local.EventInClub;
import com.clubhouse.android.databinding.FragmentEventsBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.shared.preferences.Key;
import com.clubhouse.android.ui.events.EventsFragment;
import com.clubhouse.android.ui.events.creation.AddEditEventArgs;
import com.clubhouse.app.R;
import h0.b0.v;
import h0.q.p;
import h0.q.q;
import i0.b.a.r;
import i0.b.a.t;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.d.a.a.a;
import i0.e.b.g3.o.d0;
import i0.e.b.g3.o.e0;
import i0.e.b.g3.o.q0;
import i0.e.b.g3.o.v0;
import j$.time.OffsetDateTime;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.l.c;
import m0.n.a.l;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
import n0.a.f0;
import n0.a.f1;
/* compiled from: EventsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0002$%B\u0007¢\u0006\u0004\b#\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0018\u001a\u00020\u00138B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001e\u001a\u00020\u00198B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\"\u001a\u00060\u001fR\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006&"}, d2 = {"Lcom/clubhouse/android/ui/events/EventsFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Li0/e/b/f3/k/b;", "a2", "Li0/e/b/f3/k/b;", "O0", "()Li0/e/b/f3/k/b;", "setUserPrefs", "(Li0/e/b/f3/k/b;)V", "userPrefs", "Lcom/clubhouse/android/databinding/FragmentEventsBinding;", "b2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "N0", "()Lcom/clubhouse/android/databinding/FragmentEventsBinding;", "binding", "Lcom/clubhouse/android/ui/events/EventsViewModel;", "c2", "Lm0/c;", "P0", "()Lcom/clubhouse/android/ui/events/EventsViewModel;", "viewModel", "Lcom/clubhouse/android/ui/events/EventsFragment$PagingController;", "d2", "Lcom/clubhouse/android/ui/events/EventsFragment$PagingController;", "pagedController", "<init>", "b", "PagingController", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class EventsFragment extends Hilt_EventsFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(EventsFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentEventsBinding;")), m.c(new PropertyReference1Impl(m.a(EventsFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/events/EventsViewModel;"))};
    public i0.e.b.f3.k.b a2;
    public final m0.c c2;
    public final FragmentViewBindingDelegate b2 = new FragmentViewBindingDelegate(FragmentEventsBinding.class, this);
    public final PagingController d2 = new PagingController(this);

    /* compiled from: EventsFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\u000b\u001a\u00020\u00052\u0010\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/clubhouse/android/ui/events/EventsFragment$PagingController;", "Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;", "Lcom/clubhouse/android/data/models/local/EventInClub;", "Landroid/view/View;", "view", "Lm0/i;", "showTooltipIfNeeded", "(Landroid/view/View;)V", "", "Li0/b/a/t;", "models", "addModels", "(Ljava/util/List;)V", "", "currentPosition", "item", "buildItemModel", "(ILcom/clubhouse/android/data/models/local/EventInClub;)Li0/b/a/t;", "", "latestReadableDateFormat", "Ljava/lang/String;", "getLatestReadableDateFormat", "()Ljava/lang/String;", "setLatestReadableDateFormat", "(Ljava/lang/String;)V", "<init>", "(Lcom/clubhouse/android/ui/events/EventsFragment;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public final class PagingController extends PagingDataEpoxyController<EventInClub> {
        private String latestReadableDateFormat = "";
        public final /* synthetic */ EventsFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PagingController(EventsFragment eventsFragment) {
            super(null, null, null, 7, null);
            i.e(eventsFragment, "this$0");
            this.this$0 = eventsFragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void showTooltipIfNeeded(View view) {
            i0.e.b.f3.k.b O0 = this.this$0.O0();
            Key key = Key.KEY_SHOW_BELL_TOOLTIP;
            if (!O0.a(key, false)) {
                if (view != null) {
                    i.e(view, "<this>");
                    g0.a.b.b.a.y0(view, view.getResources().getString(R.string.great_we_ll_tell));
                    view.performLongClick();
                }
                this.this$0.O0().g(key, true);
            }
        }

        @Override // com.airbnb.epoxy.paging3.PagingDataEpoxyController
        public void addModels(List<? extends t<?>> list) {
            i.e(list, "models");
            EventsFragment eventsFragment = this.this$0;
            k<Object>[] kVarArr = EventsFragment.Z1;
            v.v2(eventsFragment.P0(), new EventsFragment$PagingController$addModels$1(list, this, this.this$0));
        }

        public final String getLatestReadableDateFormat() {
            return this.latestReadableDateFormat;
        }

        public final void setLatestReadableDateFormat(String str) {
            i.e(str, "<set-?>");
            this.latestReadableDateFormat = str;
        }

        public t<?> buildItemModel(int i, EventInClub eventInClub) {
            String str;
            OffsetDateTime offsetDateTime;
            String str2 = "";
            if (i == 0) {
                this.latestReadableDateFormat = str2;
            }
            if (eventInClub == null || (offsetDateTime = eventInClub.c2) == null) {
                str = null;
            } else {
                Context requireContext = this.this$0.requireContext();
                i.d(requireContext, "requireContext()");
                str = v.J1(offsetDateTime, requireContext);
            }
            if (i.a(this.latestReadableDateFormat, str)) {
                return new b(eventInClub, null, 2);
            }
            if (str != null) {
                str2 = str;
            }
            this.latestReadableDateFormat = str2;
            return new b(eventInClub, str);
        }
    }

    /* compiled from: kotlin-style lambda group */
    /* loaded from: classes.dex */
    public static final class a extends Lambda implements l<EventInClub, m0.i> {
        public final /* synthetic */ int c;
        public final /* synthetic */ Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(1);
            this.c = i;
            this.d = obj;
        }

        @Override // m0.n.a.l
        public final m0.i invoke(EventInClub eventInClub) {
            int i = this.c;
            if (i == 0) {
                EventInClub eventInClub2 = eventInClub;
                i.e(eventInClub2, "event");
                v.a1((EventsFragment) this.d, e0.a.a(new HalfEventArgs(null, Integer.valueOf(eventInClub2.Y1), null, null, null, null, null, 125)), null, 2);
                k<Object>[] kVarArr = EventsFragment.Z1;
                ((EventsFragment) this.d).P0().p(q0.a);
                return m0.i.a;
            } else if (i == 1) {
                EventInClub eventInClub3 = eventInClub;
                i.e(eventInClub3, "event");
                k<Object>[] kVarArr2 = EventsFragment.Z1;
                ((EventsFragment) this.d).P0().p(new v0(eventInClub3));
                return m0.i.a;
            } else {
                throw null;
            }
        }
    }

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class c extends h<EventsFragment, EventsViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public c(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public m0.c<EventsViewModel> a(EventsFragment eventsFragment, k kVar) {
            EventsFragment eventsFragment2 = eventsFragment;
            i.e(eventsFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(eventsFragment2, kVar, this.a, new EventsFragment$special$$inlined$parentFragmentViewModel$default$2$1(this), m.a(EventsViewState.class), true, this.b);
        }
    }

    public EventsFragment() {
        super(R.layout.fragment_events);
        d a2 = m.a(EventsViewModel.class);
        this.c2 = new c(a2, true, new l<i0.b.b.k<EventsViewModel, EventsViewState>, EventsViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.events.EventsFragment$special$$inlined$parentFragmentViewModel$default$1
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
                i.e(kVar2, "stateFactory");
                if (Fragment.this.getParentFragment() != null) {
                    String G0 = a.G0(this.q, "viewModelClass.java.name");
                    for (Fragment parentFragment = Fragment.this.getParentFragment(); parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
                        try {
                            x xVar = x.a;
                            Class l1 = i0.j.f.p.h.l1(this.d);
                            h0.o.a.k requireActivity = Fragment.this.requireActivity();
                            i.d(requireActivity, "this.requireActivity()");
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
                            i.d(requireActivity2, "requireActivity()");
                            Object a3 = v.a(Fragment.this);
                            i.c(parentFragment2);
                            return x.a(x.a, i0.j.f.p.h.l1(this.d), EventsViewState.class, new i0.b.b.d(requireActivity2, a3, parentFragment2, null, null, 24), a.G0(this.q, "viewModelClass.java.name"), false, kVar2, 16);
                        }
                    }
                } else {
                    StringBuilder P0 = a.P0("There is no parent fragment for ");
                    a.k(Fragment.this, P0, " so view model ");
                    throw new ViewModelDoesNotExistException(a.H0(this.d, P0, " could not be found."));
                }
            }
        }, a2).a(this, Z1[1]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(P0(), new l<EventsViewState, f1>() { // from class: com.clubhouse.android.ui.events.EventsFragment$invalidate$1
            @Override // m0.n.a.l
            public f1 invoke(EventsViewState eventsViewState) {
                final EventsViewState eventsViewState2 = eventsViewState;
                i.e(eventsViewState2, "state");
                EventsFragment eventsFragment = EventsFragment.this;
                k<Object>[] kVarArr = EventsFragment.Z1;
                eventsFragment.N0().f.setText(EventsFragment.this.getString(eventsViewState2.a.getTitle()));
                EventsFragment.this.N0().c.setText(EventsFragment.this.getString(eventsViewState2.a.getEmptyTitle()));
                p viewLifecycleOwner = EventsFragment.this.getViewLifecycleOwner();
                i.d(viewLifecycleOwner, "viewLifecycleOwner");
                LifecycleCoroutineScope a2 = q.a(viewLifecycleOwner);
                final EventsFragment eventsFragment2 = EventsFragment.this;
                return m0.r.t.a.r.m.a1.a.E2(a2, null, null, new m0.n.a.p<f0, c<? super m0.i>, Object>(null) { // from class: com.clubhouse.android.ui.events.EventsFragment$invalidate$1.1
                    public int c;

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final c<m0.i> create(Object obj, c<?> cVar) {
                        return 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0009: INVOKE  
                              (wrap: com.clubhouse.android.ui.events.EventsViewModel : 0x0000: INVOKE  (r0v0 com.clubhouse.android.ui.events.EventsViewModel A[REMOVE]) = (r2v0 'this' com.clubhouse.android.ui.events.EventsFragment A[IMMUTABLE_TYPE, THIS]) type: VIRTUAL call: com.clubhouse.android.ui.events.EventsFragment.P0():com.clubhouse.android.ui.events.EventsViewModel)
                              (wrap: com.clubhouse.android.ui.events.EventsFragment$invalidate$1 : 0x0006: CONSTRUCTOR  (r1v0 com.clubhouse.android.ui.events.EventsFragment$invalidate$1 A[REMOVE]) = (r2v0 'this' com.clubhouse.android.ui.events.EventsFragment A[IMMUTABLE_TYPE, THIS]) call: com.clubhouse.android.ui.events.EventsFragment$invalidate$1.<init>(com.clubhouse.android.ui.events.EventsFragment):void type: CONSTRUCTOR)
                             type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: com.clubhouse.android.ui.events.EventsFragment.J():void, file: classes3.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0056: RETURN  
                              (wrap: n0.a.f1 : 0x0052: INVOKE  (r9v2 n0.a.f1 A[REMOVE]) = 
                              (r2v4 'a2' androidx.lifecycle.LifecycleCoroutineScope)
                              (null m0.l.e)
                              (null kotlinx.coroutines.CoroutineStart)
                              (wrap: com.clubhouse.android.ui.events.EventsFragment$invalidate$1$1 : 0x004d: CONSTRUCTOR  (r5v0 com.clubhouse.android.ui.events.EventsFragment$invalidate$1$1 A[REMOVE]) = 
                              (r0v9 'eventsFragment2' com.clubhouse.android.ui.events.EventsFragment A[DONT_INLINE, SKIP_ARG])
                              (r9v1 'eventsViewState2' com.clubhouse.android.ui.events.EventsViewState A[DONT_INLINE, SKIP_ARG])
                              (null m0.l.c)
                             call: com.clubhouse.android.ui.events.EventsFragment$invalidate$1.1.<init>(com.clubhouse.android.ui.events.EventsFragment, com.clubhouse.android.ui.events.EventsViewState, m0.l.c):void type: CONSTRUCTOR)
                              (3 int)
                              (null java.lang.Object)
                             type: STATIC call: m0.r.t.a.r.m.a1.a.E2(n0.a.f0, m0.l.e, kotlinx.coroutines.CoroutineStart, m0.n.a.p, int, java.lang.Object):n0.a.f1)
                             in method: com.clubhouse.android.ui.events.EventsFragment$invalidate$1.invoke(com.clubhouse.android.ui.events.EventsViewState):n0.a.f1, file: classes3.dex
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
                              (wrap: com.clubhouse.android.ui.events.EventsFragment$invalidate$1$1 : 0x0006: CONSTRUCTOR  (r3v1 com.clubhouse.android.ui.events.EventsFragment$invalidate$1$1 A[REMOVE]) = 
                              (wrap: com.clubhouse.android.ui.events.EventsFragment : 0x0002: IGET  (r0v0 com.clubhouse.android.ui.events.EventsFragment A[REMOVE]) = (r2v0 'this' com.clubhouse.android.ui.events.EventsFragment$invalidate$1$1 A[IMMUTABLE_TYPE, THIS]) com.clubhouse.android.ui.events.EventsFragment$invalidate$1.1.d com.clubhouse.android.ui.events.EventsFragment)
                              (wrap: com.clubhouse.android.ui.events.EventsViewState : 0x0004: IGET  (r1v0 com.clubhouse.android.ui.events.EventsViewState A[REMOVE]) = (r2v0 'this' com.clubhouse.android.ui.events.EventsFragment$invalidate$1$1 A[IMMUTABLE_TYPE, THIS]) com.clubhouse.android.ui.events.EventsFragment$invalidate$1.1.q com.clubhouse.android.ui.events.EventsViewState)
                              (r4v0 'cVar' m0.l.c<?>)
                             call: com.clubhouse.android.ui.events.EventsFragment$invalidate$1.1.<init>(com.clubhouse.android.ui.events.EventsFragment, com.clubhouse.android.ui.events.EventsViewState, m0.l.c):void type: CONSTRUCTOR)
                             in method: com.clubhouse.android.ui.events.EventsFragment$invalidate$1.1.create(java.lang.Object, m0.l.c<?>):m0.l.c<m0.i>, file: classes3.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: com.clubhouse.android.ui.events.EventsFragment$invalidate$1.1
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
                            com.clubhouse.android.ui.events.EventsViewModel r0 = r2.P0()
                            com.clubhouse.android.ui.events.EventsFragment$invalidate$1 r1 = new com.clubhouse.android.ui.events.EventsFragment$invalidate$1
                            r1.<init>()
                            h0.b0.v.v2(r0, r1)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.clubhouse.android.ui.events.EventsFragment.J():void");
                    }

                    public final FragmentEventsBinding N0() {
                        return (FragmentEventsBinding) this.b2.getValue(this, Z1[0]);
                    }

                    public final i0.e.b.f3.k.b O0() {
                        i0.e.b.f3.k.b bVar = this.a2;
                        if (bVar != null) {
                            return bVar;
                        }
                        i.m("userPrefs");
                        throw null;
                    }

                    public final EventsViewModel P0() {
                        return (EventsViewModel) this.c2.getValue();
                    }

                    /* JADX WARN: Removed duplicated region for block: B:20:0x0035  */
                    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
                    /* Code decompiled incorrectly, please refer to instructions dump */
                    public void onViewCreated(View view, Bundle bundle) {
                        boolean z;
                        HalfEventArgs halfEventArgs;
                        String str;
                        String str2;
                        String str3;
                        i.e(view, "view");
                        super.onViewCreated(view, bundle);
                        Bundle arguments = getArguments();
                        if (!(arguments != null && arguments.containsKey("eventHashId"))) {
                            if (!(arguments != null && arguments.containsKey("mavericks:arg"))) {
                                z = false;
                                if (z) {
                                    v.d1(this, R.id.eventsFragment);
                                    Bundle arguments2 = getArguments();
                                    if (arguments2 == null) {
                                        halfEventArgs = null;
                                    } else {
                                        halfEventArgs = (HalfEventArgs) arguments2.getParcelable("mavericks:arg");
                                    }
                                    if (arguments2 == null) {
                                        str = null;
                                    } else {
                                        str = arguments2.getString("eventHashId");
                                    }
                                    if (arguments2 == null) {
                                        str2 = null;
                                    } else {
                                        str2 = arguments2.getString("clubSlug");
                                    }
                                    if (arguments2 == null) {
                                        str3 = null;
                                    } else {
                                        str3 = arguments2.getString("inviteCode");
                                    }
                                    if (halfEventArgs == null) {
                                        halfEventArgs = new HalfEventArgs(str, null, str2, str3, null, null, null, 114);
                                    }
                                    i.e(this, "<this>");
                                    i.e(halfEventArgs, "args");
                                    v.a1(this, e0.a.a(halfEventArgs), null, 2);
                                }
                                FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(P0().l, new EventsFragment$onViewCreated$1(this, null));
                                p viewLifecycleOwner = getViewLifecycleOwner();
                                i.d(viewLifecycleOwner, "viewLifecycleOwner");
                                m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner));
                                v.p0(this, "event_create_result", new a(0, this));
                                v.p0(this, "event_deletion_result", new l<Boolean, m0.i>() { // from class: com.clubhouse.android.ui.events.EventsFragment$onViewCreated$3
                                    @Override // m0.n.a.l
                                    public m0.i invoke(Boolean bool) {
                                        bool.booleanValue();
                                        EventsFragment eventsFragment = EventsFragment.this;
                                        k<Object>[] kVarArr = EventsFragment.Z1;
                                        eventsFragment.P0().p(q0.a);
                                        return m0.i.a;
                                    }
                                });
                                v.p0(this, "event_update_result", new a(1, this));
                                N0().b.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.o.l
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        EventsFragment eventsFragment = EventsFragment.this;
                                        k<Object>[] kVarArr = EventsFragment.Z1;
                                        i.e(eventsFragment, "this$0");
                                        i.e(eventsFragment, "<this>");
                                        v.c1(eventsFragment);
                                    }
                                });
                                N0().f.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.o.k
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        EventsFragment eventsFragment = EventsFragment.this;
                                        m0.r.k<Object>[] kVarArr = EventsFragment.Z1;
                                        i.e(eventsFragment, "this$0");
                                        v.v2(eventsFragment.P0(), 
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: INVOKE  
                                              (wrap: com.clubhouse.android.ui.events.EventsViewModel : 0x0009: INVOKE  (r0v2 com.clubhouse.android.ui.events.EventsViewModel A[REMOVE]) = (r3v1 'eventsFragment' com.clubhouse.android.ui.events.EventsFragment) type: VIRTUAL call: com.clubhouse.android.ui.events.EventsFragment.P0():com.clubhouse.android.ui.events.EventsViewModel)
                                              (wrap: com.clubhouse.android.ui.events.EventsFragment$showEventsOptions$1 : 0x000f: CONSTRUCTOR  (r1v0 com.clubhouse.android.ui.events.EventsFragment$showEventsOptions$1 A[REMOVE]) = (r3v1 'eventsFragment' com.clubhouse.android.ui.events.EventsFragment) call: com.clubhouse.android.ui.events.EventsFragment$showEventsOptions$1.<init>(com.clubhouse.android.ui.events.EventsFragment):void type: CONSTRUCTOR)
                                             type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: i0.e.b.g3.o.k.onClick(android.view.View):void, file: classes3.dex
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
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.events.EventsFragment$showEventsOptions$1, state: NOT_LOADED
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
                                            com.clubhouse.android.ui.events.EventsFragment r3 = com.clubhouse.android.ui.events.EventsFragment.this
                                            m0.r.k<java.lang.Object>[] r0 = com.clubhouse.android.ui.events.EventsFragment.Z1
                                            java.lang.String r0 = "this$0"
                                            m0.n.b.i.e(r3, r0)
                                            com.clubhouse.android.ui.events.EventsViewModel r0 = r3.P0()
                                            com.clubhouse.android.ui.events.EventsFragment$showEventsOptions$1 r1 = new com.clubhouse.android.ui.events.EventsFragment$showEventsOptions$1
                                            r1.<init>(r3)
                                            h0.b0.v.v2(r0, r1)
                                            return
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.o.k.onClick(android.view.View):void");
                                    }
                                });
                                ImageView imageView = N0().a;
                                i.d(imageView, "binding.addEditEvent");
                                p viewLifecycleOwner2 = getViewLifecycleOwner();
                                i.d(viewLifecycleOwner2, "viewLifecycleOwner");
                                i0.e.b.d3.k.H(imageView, q.a(viewLifecycleOwner2), new View.OnClickListener() { // from class: i0.e.b.g3.o.j
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view2) {
                                        EventsFragment eventsFragment = EventsFragment.this;
                                        k<Object>[] kVarArr = EventsFragment.Z1;
                                        i.e(eventsFragment, "this$0");
                                        ((AmplitudeAnalytics) v.l(eventsFragment)).a("Bulletin-Add-Event-Tapped");
                                        i.e(eventsFragment, "<this>");
                                        AddEditEventArgs addEditEventArgs = new AddEditEventArgs(null, 1);
                                        i.e(addEditEventArgs, "mavericksArg");
                                        v.a1(eventsFragment, new e0.a(addEditEventArgs), null, 2);
                                    }
                                });
                                N0().e.setProgressBackgroundColorSchemeColor(h0.i.b.a.getColor(requireContext(), R.color.clubhouse_eggshell));
                                N0().e.setOnRefreshListener(new SwipeRefreshLayout.h() { // from class: i0.e.b.g3.o.i
                                    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.h
                                    public final void q0() {
                                        EventsFragment eventsFragment = EventsFragment.this;
                                        k<Object>[] kVarArr = EventsFragment.Z1;
                                        m0.n.b.i.e(eventsFragment, "this$0");
                                        eventsFragment.P0().p(q0.a);
                                    }
                                });
                                SwipeRefreshLayout swipeRefreshLayout = N0().e;
                                int progressViewStartOffset = N0().e.getProgressViewStartOffset();
                                int progressViewEndOffset = N0().e.getProgressViewEndOffset();
                                swipeRefreshLayout.n2 = true;
                                swipeRefreshLayout.t2 = progressViewStartOffset;
                                swipeRefreshLayout.u2 = progressViewEndOffset;
                                swipeRefreshLayout.E2 = true;
                                swipeRefreshLayout.i();
                                swipeRefreshLayout.y = false;
                                N0().d.setController(this.d2);
                                N0().d.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
                                FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$12 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(v.f1(this.d2), new EventsFragment$onViewCreated$9(this, null));
                                p viewLifecycleOwner3 = getViewLifecycleOwner();
                                i.d(viewLifecycleOwner3, "viewLifecycleOwner");
                                m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$12, q.a(viewLifecycleOwner3));
                                P0().p(q0.a);
                            }
                        }
                        z = true;
                        if (z) {
                        }
                        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$13 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(P0().l, new EventsFragment$onViewCreated$1(this, null));
                        p viewLifecycleOwner4 = getViewLifecycleOwner();
                        i.d(viewLifecycleOwner4, "viewLifecycleOwner");
                        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$13, q.a(viewLifecycleOwner4));
                        v.p0(this, "event_create_result", new a(0, this));
                        v.p0(this, "event_deletion_result", new l<Boolean, m0.i>() { // from class: com.clubhouse.android.ui.events.EventsFragment$onViewCreated$3
                            @Override // m0.n.a.l
                            public m0.i invoke(Boolean bool) {
                                bool.booleanValue();
                                EventsFragment eventsFragment = EventsFragment.this;
                                k<Object>[] kVarArr = EventsFragment.Z1;
                                eventsFragment.P0().p(q0.a);
                                return m0.i.a;
                            }
                        });
                        v.p0(this, "event_update_result", new a(1, this));
                        N0().b.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.o.l
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                EventsFragment eventsFragment = EventsFragment.this;
                                k<Object>[] kVarArr = EventsFragment.Z1;
                                i.e(eventsFragment, "this$0");
                                i.e(eventsFragment, "<this>");
                                v.c1(eventsFragment);
                            }
                        });
                        N0().f.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.o.k
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: INVOKE  
                                  (wrap: com.clubhouse.android.ui.events.EventsViewModel : 0x0009: INVOKE  (r0v2 com.clubhouse.android.ui.events.EventsViewModel A[REMOVE]) = (r3v1 'eventsFragment' com.clubhouse.android.ui.events.EventsFragment) type: VIRTUAL call: com.clubhouse.android.ui.events.EventsFragment.P0():com.clubhouse.android.ui.events.EventsViewModel)
                                  (wrap: com.clubhouse.android.ui.events.EventsFragment$showEventsOptions$1 : 0x000f: CONSTRUCTOR  (r1v0 com.clubhouse.android.ui.events.EventsFragment$showEventsOptions$1 A[REMOVE]) = (r3v1 'eventsFragment' com.clubhouse.android.ui.events.EventsFragment) call: com.clubhouse.android.ui.events.EventsFragment$showEventsOptions$1.<init>(com.clubhouse.android.ui.events.EventsFragment):void type: CONSTRUCTOR)
                                 type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: i0.e.b.g3.o.k.onClick(android.view.View):void, file: classes3.dex
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
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.events.EventsFragment$showEventsOptions$1, state: NOT_LOADED
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
                                	... 10 more
                                */
                            @Override // android.view.View.OnClickListener
                            public final void onClick(android.view.View r3) {
                                /*
                                    r2 = this;
                                    com.clubhouse.android.ui.events.EventsFragment r3 = com.clubhouse.android.ui.events.EventsFragment.this
                                    m0.r.k<java.lang.Object>[] r0 = com.clubhouse.android.ui.events.EventsFragment.Z1
                                    java.lang.String r0 = "this$0"
                                    m0.n.b.i.e(r3, r0)
                                    com.clubhouse.android.ui.events.EventsViewModel r0 = r3.P0()
                                    com.clubhouse.android.ui.events.EventsFragment$showEventsOptions$1 r1 = new com.clubhouse.android.ui.events.EventsFragment$showEventsOptions$1
                                    r1.<init>(r3)
                                    h0.b0.v.v2(r0, r1)
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.o.k.onClick(android.view.View):void");
                            }
                        });
                        ImageView imageView2 = N0().a;
                        i.d(imageView2, "binding.addEditEvent");
                        p viewLifecycleOwner22 = getViewLifecycleOwner();
                        i.d(viewLifecycleOwner22, "viewLifecycleOwner");
                        i0.e.b.d3.k.H(imageView2, q.a(viewLifecycleOwner22), new View.OnClickListener() { // from class: i0.e.b.g3.o.j
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                EventsFragment eventsFragment = EventsFragment.this;
                                k<Object>[] kVarArr = EventsFragment.Z1;
                                i.e(eventsFragment, "this$0");
                                ((AmplitudeAnalytics) v.l(eventsFragment)).a("Bulletin-Add-Event-Tapped");
                                i.e(eventsFragment, "<this>");
                                AddEditEventArgs addEditEventArgs = new AddEditEventArgs(null, 1);
                                i.e(addEditEventArgs, "mavericksArg");
                                v.a1(eventsFragment, new e0.a(addEditEventArgs), null, 2);
                            }
                        });
                        N0().e.setProgressBackgroundColorSchemeColor(h0.i.b.a.getColor(requireContext(), R.color.clubhouse_eggshell));
                        N0().e.setOnRefreshListener(new SwipeRefreshLayout.h() { // from class: i0.e.b.g3.o.i
                            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.h
                            public final void q0() {
                                EventsFragment eventsFragment = EventsFragment.this;
                                k<Object>[] kVarArr = EventsFragment.Z1;
                                m0.n.b.i.e(eventsFragment, "this$0");
                                eventsFragment.P0().p(q0.a);
                            }
                        });
                        SwipeRefreshLayout swipeRefreshLayout2 = N0().e;
                        int progressViewStartOffset2 = N0().e.getProgressViewStartOffset();
                        int progressViewEndOffset2 = N0().e.getProgressViewEndOffset();
                        swipeRefreshLayout2.n2 = true;
                        swipeRefreshLayout2.t2 = progressViewStartOffset2;
                        swipeRefreshLayout2.u2 = progressViewEndOffset2;
                        swipeRefreshLayout2.E2 = true;
                        swipeRefreshLayout2.i();
                        swipeRefreshLayout2.y = false;
                        N0().d.setController(this.d2);
                        N0().d.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
                        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$122 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(v.f1(this.d2), new EventsFragment$onViewCreated$9(this, null));
                        p viewLifecycleOwner32 = getViewLifecycleOwner();
                        i.d(viewLifecycleOwner32, "viewLifecycleOwner");
                        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$122, q.a(viewLifecycleOwner32));
                        P0().p(q0.a);
                    }

                    /* compiled from: EventsFragment.kt */
                    /* loaded from: classes3.dex */
                    public static final class b extends BaseEpoxyModelWithHolder<i0.e.b.a3.f.d> {
                        public final EventInClub j;
                        public final String k;

                        public b(EventInClub eventInClub, String str) {
                            this.j = eventInClub;
                            this.k = str;
                        }

                        @Override // i0.b.a.u
                        public r E(ViewParent viewParent) {
                            i.e(viewParent, "parent");
                            return new d0();
                        }

                        @Override // i0.b.a.t
                        public int o() {
                            return 0;
                        }

                        public b(EventInClub eventInClub, String str, int i) {
                            int i2 = i & 2;
                            this.j = eventInClub;
                            this.k = null;
                        }
                    }
                }
