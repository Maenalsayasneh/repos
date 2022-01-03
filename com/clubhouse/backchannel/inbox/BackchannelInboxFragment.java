package com.clubhouse.backchannel.inbox;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.clubhouse.android.data.models.local.user.SourceLocation;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.ui.backchannel.CreateChatArgs;
import com.clubhouse.backchannel.R;
import com.clubhouse.backchannel.chat.ChatArgs;
import com.clubhouse.backchannel.databinding.FragmentBackchannelInboxBinding;
import com.clubhouse.backchannel.inbox.BackchannelInboxFragment;
import com.clubhouse.pubsub.user.backchannel.models.remote.ChatDestination;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import h0.b0.v;
import h0.q.p;
import h0.q.q;
import i0.b.a.o;
import i0.b.b.c0;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.e.c.f.b.a.a;
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
import n0.a.f1;
/* compiled from: BackchannelInboxFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nR\u001d\u0010\u0011\u001a\u00020\f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u001d\u0010\u001d\u001a\u00020\u00188B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/clubhouse/backchannel/inbox/BackchannelInboxFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "J", "Lcom/clubhouse/backchannel/databinding/FragmentBackchannelInboxBinding;", "a2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "O0", "()Lcom/clubhouse/backchannel/databinding/FragmentBackchannelInboxBinding;", "binding", "Li0/b/a/o;", "d2", "Li0/b/a/o;", "requestsController", "c2", "chatsController", "Lcom/clubhouse/backchannel/inbox/BackchannelInboxViewModel;", "b2", "Lm0/c;", "P0", "()Lcom/clubhouse/backchannel/inbox/BackchannelInboxViewModel;", "viewModel", "<init>", "backchannel_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class BackchannelInboxFragment extends Hilt_BackchannelInboxFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(BackchannelInboxFragment.class), "binding", "getBinding()Lcom/clubhouse/backchannel/databinding/FragmentBackchannelInboxBinding;")), m.c(new PropertyReference1Impl(m.a(BackchannelInboxFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/backchannel/inbox/BackchannelInboxViewModel;"))};
    public final FragmentViewBindingDelegate a2 = new FragmentViewBindingDelegate(FragmentBackchannelInboxBinding.class, this);
    public final c b2;
    public o c2;
    public o d2;

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<BackchannelInboxFragment, BackchannelInboxViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<BackchannelInboxViewModel> a(BackchannelInboxFragment backchannelInboxFragment, k kVar) {
            BackchannelInboxFragment backchannelInboxFragment2 = backchannelInboxFragment;
            i.e(backchannelInboxFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(backchannelInboxFragment2, kVar, this.a, new BackchannelInboxFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(i0.e.c.h.k.class), false, this.b);
        }
    }

    public BackchannelInboxFragment() {
        super(R.layout.fragment_backchannel_inbox);
        d a2 = m.a(BackchannelInboxViewModel.class);
        this.b2 = new a(a2, false, new l<i0.b.b.k<BackchannelInboxViewModel, i0.e.c.h.k>, BackchannelInboxViewModel>(a2, a2) { // from class: com.clubhouse.backchannel.inbox.BackchannelInboxFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.clubhouse.backchannel.inbox.BackchannelInboxViewModel, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.l
            public BackchannelInboxViewModel invoke(i0.b.b.k<BackchannelInboxViewModel, i0.e.c.h.k> kVar) {
                i0.b.b.k<BackchannelInboxViewModel, i0.e.c.h.k> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, i0.e.c.h.k.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, Z1[1]);
    }

    public static final void N0(BackchannelInboxFragment backchannelInboxFragment, o oVar, i0.e.c.f.b.a.a aVar) {
        Objects.requireNonNull(backchannelInboxFragment);
        i0.e.c.h.p.c cVar = new i0.e.c.h.p.c();
        cVar.N(aVar.a);
        cVar.L(aVar);
        cVar.M(new View.OnClickListener(aVar) { // from class: i0.e.c.h.e
            public final /* synthetic */ a d;

            {
                this.d = r2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BackchannelInboxFragment backchannelInboxFragment2 = BackchannelInboxFragment.this;
                a aVar2 = this.d;
                k<Object>[] kVarArr = BackchannelInboxFragment.Z1;
                i.e(backchannelInboxFragment2, "this$0");
                i.e(aVar2, "$chat");
                ChatArgs chatArgs = new ChatArgs(aVar2.a);
                i.e(chatArgs, "mavericksArg");
                v.a1(backchannelInboxFragment2, new h(chatArgs), null, 2);
            }
        });
        cVar.O(new View.OnLongClickListener(aVar) { // from class: i0.e.c.h.d
            public final /* synthetic */ a d;

            {
                this.d = r2;
            }

            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                BackchannelInboxFragment backchannelInboxFragment2 = BackchannelInboxFragment.this;
                a aVar2 = this.d;
                k<Object>[] kVarArr = BackchannelInboxFragment.Z1;
                i.e(backchannelInboxFragment2, "this$0");
                i.e(aVar2, "$chat");
                v.e(backchannelInboxFragment2, 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0015: INVOKE  
                      (r3v1 'backchannelInboxFragment2' com.clubhouse.backchannel.inbox.BackchannelInboxFragment)
                      (wrap: com.clubhouse.backchannel.inbox.BackchannelInboxFragment$buildChatModel$1$2$1 : 0x0012: CONSTRUCTOR  (r1v3 com.clubhouse.backchannel.inbox.BackchannelInboxFragment$buildChatModel$1$2$1 A[REMOVE]) = 
                      (r0v0 'aVar2' i0.e.c.f.b.a.a)
                      (r3v1 'backchannelInboxFragment2' com.clubhouse.backchannel.inbox.BackchannelInboxFragment)
                     call: com.clubhouse.backchannel.inbox.BackchannelInboxFragment$buildChatModel$1$2$1.<init>(i0.e.c.f.b.a.a, com.clubhouse.backchannel.inbox.BackchannelInboxFragment):void type: CONSTRUCTOR)
                     type: STATIC call: h0.b0.v.e(androidx.fragment.app.Fragment, m0.n.a.l):void in method: i0.e.c.h.d.onLongClick(android.view.View):boolean, file: classes3.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.backchannel.inbox.BackchannelInboxFragment$buildChatModel$1$2$1, state: NOT_LOADED
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
                    com.clubhouse.backchannel.inbox.BackchannelInboxFragment r3 = com.clubhouse.backchannel.inbox.BackchannelInboxFragment.this
                    i0.e.c.f.b.a.a r0 = r2.d
                    m0.r.k<java.lang.Object>[] r1 = com.clubhouse.backchannel.inbox.BackchannelInboxFragment.Z1
                    java.lang.String r1 = "this$0"
                    m0.n.b.i.e(r3, r1)
                    java.lang.String r1 = "$chat"
                    m0.n.b.i.e(r0, r1)
                    com.clubhouse.backchannel.inbox.BackchannelInboxFragment$buildChatModel$1$2$1 r1 = new com.clubhouse.backchannel.inbox.BackchannelInboxFragment$buildChatModel$1$2$1
                    r1.<init>(r0, r3)
                    h0.b0.v.e(r3, r1)
                    r3 = 1
                    return r3
                */
                throw new UnsupportedOperationException("Method not decompiled: i0.e.c.h.d.onLongClick(android.view.View):boolean");
            }
        });
        oVar.add(cVar);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(P0(), new l<i0.e.c.h.k, m0.i>() { // from class: com.clubhouse.backchannel.inbox.BackchannelInboxFragment$invalidate$1
            @Override // m0.n.a.l
            public m0.i invoke(i0.e.c.h.k kVar) {
                int i;
                BackchannelInboxFragment backchannelInboxFragment;
                BadgeDrawable badgeDrawable;
                i0.e.c.h.k kVar2 = kVar;
                i.e(kVar2, "state");
                BackchannelInboxFragment backchannelInboxFragment2 = BackchannelInboxFragment.this;
                k<Object>[] kVarArr = BackchannelInboxFragment.Z1;
                backchannelInboxFragment2.O0().e.setRefreshing(kVar2.c);
                boolean z = !kVar2.c && !kVar2.d && ((kVar2.g == ChatDestination.CHATS && kVar2.a.isEmpty()) || (kVar2.g == ChatDestination.REQUESTS && kVar2.b.isEmpty()));
                TextView textView = BackchannelInboxFragment.this.O0().c;
                i.d(textView, "binding.emptyView");
                i0.e.b.d3.k.L(textView, Boolean.valueOf(z));
                TextView textView2 = BackchannelInboxFragment.this.O0().c;
                if (kVar2.g == ChatDestination.CHATS) {
                    backchannelInboxFragment = BackchannelInboxFragment.this;
                    i = R.string.inbox_empty;
                } else {
                    backchannelInboxFragment = BackchannelInboxFragment.this;
                    i = R.string.requests_empty;
                }
                textView2.setText(backchannelInboxFragment.getString(i));
                BackchannelInboxFragment.this.O0().d.g();
                TabLayout.g h = BackchannelInboxFragment.this.O0().g.h(ChatDestination.REQUESTS.getIndex());
                if (h == null) {
                    badgeDrawable = null;
                } else {
                    badgeDrawable = h.g.getBadge();
                }
                if (badgeDrawable != null) {
                    badgeDrawable.l(kVar2.e);
                }
                BackchannelInboxFragment.this.O0().g.l(BackchannelInboxFragment.this.O0().g.h(kVar2.g.getIndex()), true);
                return m0.i.a;
            }
        });
    }

    public final FragmentBackchannelInboxBinding O0() {
        return (FragmentBackchannelInboxBinding) this.a2.getValue(this, Z1[0]);
    }

    public final BackchannelInboxViewModel P0() {
        return (BackchannelInboxViewModel) this.b2.getValue();
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        P0().p(i0.e.c.h.l.a);
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.e(view, "view");
        super.onViewCreated(view, bundle);
        O0().h.setBackgroundColor(v.t0(this));
        O0().g.setBackgroundColor(v.t0(this));
        this.c2 = new BackchannelInboxFragment$onViewCreated$1(this);
        this.d2 = new BackchannelInboxFragment$onViewCreated$2(this);
        O0().a.setOnClickListener(new View.OnClickListener() { // from class: i0.e.c.h.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BackchannelInboxFragment backchannelInboxFragment = BackchannelInboxFragment.this;
                k<Object>[] kVarArr = BackchannelInboxFragment.Z1;
                i.e(backchannelInboxFragment, "this$0");
                h0.o.a.k activity = backchannelInboxFragment.getActivity();
                if (activity != null) {
                    activity.onBackPressed();
                }
            }
        });
        O0().e.setNestedScrollingEnabled(false);
        O0().e.setOnRefreshListener(new SwipeRefreshLayout.h() { // from class: i0.e.c.h.c
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.h
            public final void q0() {
                BackchannelInboxFragment backchannelInboxFragment = BackchannelInboxFragment.this;
                k<Object>[] kVarArr = BackchannelInboxFragment.Z1;
                i.e(backchannelInboxFragment, "this$0");
                backchannelInboxFragment.P0().p(l.a);
            }
        });
        ImageView imageView = O0().b;
        i.d(imageView, "binding.createChat");
        p viewLifecycleOwner = getViewLifecycleOwner();
        i.d(viewLifecycleOwner, "viewLifecycleOwner");
        i0.e.b.d3.k.H(imageView, q.a(viewLifecycleOwner), new View.OnClickListener() { // from class: i0.e.c.h.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BackchannelInboxFragment backchannelInboxFragment = BackchannelInboxFragment.this;
                k<Object>[] kVarArr = BackchannelInboxFragment.Z1;
                i.e(backchannelInboxFragment, "this$0");
                CreateChatArgs createChatArgs = new CreateChatArgs(SourceLocation.BACKCHANNEL, null);
                i.e(createChatArgs, "mavericksArg");
                v.a1(backchannelInboxFragment, new i(createChatArgs), null, 2);
            }
        });
        ImageView imageView2 = O0().f;
        i.d(imageView2, "binding.settings");
        p viewLifecycleOwner2 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner2, "viewLifecycleOwner");
        i0.e.b.d3.k.H(imageView2, q.a(viewLifecycleOwner2), new View.OnClickListener() { // from class: i0.e.c.h.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BackchannelInboxFragment backchannelInboxFragment = BackchannelInboxFragment.this;
                k<Object>[] kVarArr = BackchannelInboxFragment.Z1;
                i.e(backchannelInboxFragment, "this$0");
                v.v2(backchannelInboxFragment.P0(), 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: INVOKE  
                      (wrap: com.clubhouse.backchannel.inbox.BackchannelInboxViewModel : 0x0009: INVOKE  (r0v2 com.clubhouse.backchannel.inbox.BackchannelInboxViewModel A[REMOVE]) = (r3v1 'backchannelInboxFragment' com.clubhouse.backchannel.inbox.BackchannelInboxFragment) type: VIRTUAL call: com.clubhouse.backchannel.inbox.BackchannelInboxFragment.P0():com.clubhouse.backchannel.inbox.BackchannelInboxViewModel)
                      (wrap: com.clubhouse.backchannel.inbox.BackchannelInboxFragment$showSettings$1 : 0x000f: CONSTRUCTOR  (r1v0 com.clubhouse.backchannel.inbox.BackchannelInboxFragment$showSettings$1 A[REMOVE]) = (r3v1 'backchannelInboxFragment' com.clubhouse.backchannel.inbox.BackchannelInboxFragment) call: com.clubhouse.backchannel.inbox.BackchannelInboxFragment$showSettings$1.<init>(com.clubhouse.backchannel.inbox.BackchannelInboxFragment):void type: CONSTRUCTOR)
                     type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: i0.e.c.h.a.onClick(android.view.View):void, file: classes3.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.backchannel.inbox.BackchannelInboxFragment$showSettings$1, state: NOT_LOADED
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
                    com.clubhouse.backchannel.inbox.BackchannelInboxFragment r3 = com.clubhouse.backchannel.inbox.BackchannelInboxFragment.this
                    m0.r.k<java.lang.Object>[] r0 = com.clubhouse.backchannel.inbox.BackchannelInboxFragment.Z1
                    java.lang.String r0 = "this$0"
                    m0.n.b.i.e(r3, r0)
                    com.clubhouse.backchannel.inbox.BackchannelInboxViewModel r0 = r3.P0()
                    com.clubhouse.backchannel.inbox.BackchannelInboxFragment$showSettings$1 r1 = new com.clubhouse.backchannel.inbox.BackchannelInboxFragment$showSettings$1
                    r1.<init>(r3)
                    h0.b0.v.v2(r0, r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: i0.e.c.h.a.onClick(android.view.View):void");
            }
        });
        f1 unused = x0(P0(), BackchannelInboxFragment$onViewCreated$7.c, (r5 & 2) != 0 ? c0.a : null, new BackchannelInboxFragment$onViewCreated$8(this, null));
        f1 unused2 = x0(P0(), BackchannelInboxFragment$onViewCreated$9.c, (r5 & 2) != 0 ? c0.a : null, new BackchannelInboxFragment$onViewCreated$10(this, null));
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(P0().l, new BackchannelInboxFragment$onViewCreated$11(this, null));
        p viewLifecycleOwner3 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner3, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner3));
    }
}
