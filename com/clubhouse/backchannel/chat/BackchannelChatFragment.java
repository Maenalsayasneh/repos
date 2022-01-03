package com.clubhouse.backchannel.chat;

import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.shared.ui.ImpressionTrackingEpoxyRecyclerView;
import com.clubhouse.backchannel.R;
import com.clubhouse.backchannel.chat.BackchannelChatFragment;
import com.clubhouse.backchannel.databinding.FragmentBackchannelChatBinding;
import com.clubhouse.backchannel.ui.FadingEdgeCarousel;
import com.clubhouse.pubsub.user.backchannel.models.remote.ChatMember;
import h0.b0.v;
import h0.q.p;
import h0.q.q;
import i0.b.a.o;
import i0.b.b.c0;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.e.c.c.d0;
import i0.e.c.c.k0.c;
import i0.e.c.c.y;
import i0.e.c.f.b.a.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.n.a.l;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
import n0.a.f1;
/* compiled from: BackchannelChatFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u00020\u000b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0016\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {"Lcom/clubhouse/backchannel/chat/BackchannelChatFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lcom/clubhouse/backchannel/chat/BackchannelChatViewModel;", "c2", "Lm0/c;", "P0", "()Lcom/clubhouse/backchannel/chat/BackchannelChatViewModel;", "viewModel", "Lcom/clubhouse/backchannel/databinding/FragmentBackchannelChatBinding;", "b2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "O0", "()Lcom/clubhouse/backchannel/databinding/FragmentBackchannelChatBinding;", "binding", "Li0/e/b/z2/f/c;", "a2", "Li0/e/b/z2/f/c;", "getChannelNavigator", "()Li0/e/b/z2/f/c;", "setChannelNavigator", "(Li0/e/b/z2/f/c;)V", "channelNavigator", "<init>", "backchannel_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class BackchannelChatFragment extends Hilt_BackchannelChatFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(BackchannelChatFragment.class), "binding", "getBinding()Lcom/clubhouse/backchannel/databinding/FragmentBackchannelChatBinding;")), m.c(new PropertyReference1Impl(m.a(BackchannelChatFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/backchannel/chat/BackchannelChatViewModel;"))};
    public i0.e.b.z2.f.c a2;
    public final FragmentViewBindingDelegate b2 = new FragmentViewBindingDelegate(FragmentBackchannelChatBinding.class, this);
    public final m0.c c2;

    /* compiled from: ViewUtil.kt */
    /* loaded from: classes3.dex */
    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ View c;
        public final /* synthetic */ BackchannelChatFragment d;

        public a(View view, BackchannelChatFragment backchannelChatFragment) {
            this.c = view;
            this.d = backchannelChatFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (this.c.getMeasuredWidth() > 0 && this.c.getMeasuredHeight() > 0) {
                this.c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                BackchannelChatFragment backchannelChatFragment = this.d;
                k<Object>[] kVarArr = BackchannelChatFragment.Z1;
                backchannelChatFragment.O0().e.post(new b());
            }
        }
    }

    /* compiled from: BackchannelChatFragment.kt */
    /* loaded from: classes3.dex */
    public static final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (i0.e.b.d3.k.s(BackchannelChatFragment.this)) {
                BackchannelChatFragment backchannelChatFragment = BackchannelChatFragment.this;
                k<Object>[] kVarArr = BackchannelChatFragment.Z1;
                backchannelChatFragment.O0().e.scrollToPosition(0);
            }
        }
    }

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class c extends h<BackchannelChatFragment, BackchannelChatViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public c(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public m0.c<BackchannelChatViewModel> a(BackchannelChatFragment backchannelChatFragment, k kVar) {
            BackchannelChatFragment backchannelChatFragment2 = backchannelChatFragment;
            i.e(backchannelChatFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(backchannelChatFragment2, kVar, this.a, new BackchannelChatFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(y.class), false, this.b);
        }
    }

    public BackchannelChatFragment() {
        super(R.layout.fragment_backchannel_chat);
        d a2 = m.a(BackchannelChatViewModel.class);
        this.c2 = new c(a2, false, new l<i0.b.b.k<BackchannelChatViewModel, y>, BackchannelChatViewModel>(a2, a2) { // from class: com.clubhouse.backchannel.chat.BackchannelChatFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.airbnb.mvrx.MavericksViewModel, com.clubhouse.backchannel.chat.BackchannelChatViewModel] */
            @Override // m0.n.a.l
            public BackchannelChatViewModel invoke(i0.b.b.k<BackchannelChatViewModel, y> kVar) {
                i0.b.b.k<BackchannelChatViewModel, y> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, y.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, Z1[1]);
    }

    public static final void N0(BackchannelChatFragment backchannelChatFragment, i0.e.c.f.b.a.c cVar, int i) {
        Integer e;
        if (i == 4 && (e = cVar.e()) != null) {
            backchannelChatFragment.P0().p(new d0(e.intValue()));
        }
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(P0(), new l<y, m0.i>() { // from class: com.clubhouse.backchannel.chat.BackchannelChatFragment$invalidate$1
            @Override // m0.n.a.l
            public m0.i invoke(y yVar) {
                String str;
                ChatMember chatMember;
                List<ChatMember> list;
                List<ChatMember> list2;
                y yVar2 = yVar;
                i.e(yVar2, "state");
                BackchannelChatFragment backchannelChatFragment = BackchannelChatFragment.this;
                k<Object>[] kVarArr = BackchannelChatFragment.Z1;
                backchannelChatFragment.O0().h.setEnabled(yVar2.d);
                Button button = BackchannelChatFragment.this.O0().h;
                i.d(button, "binding.send");
                int i = 8;
                button.setVisibility(yVar2.k ? 0 : 8);
                Button button2 = BackchannelChatFragment.this.O0().i;
                i.d(button2, "binding.startRoom");
                if (yVar2.j) {
                    i = 0;
                }
                button2.setVisibility(i);
                TextView textView = BackchannelChatFragment.this.O0().j;
                a aVar = yVar2.b;
                m0.i iVar = null;
                if (aVar == null) {
                    str = null;
                } else {
                    str = aVar.u;
                }
                textView.setText(str);
                BackchannelChatFragment.this.O0().a.g();
                BackchannelChatFragment.this.O0().e.setVisibility(yVar2.l ? 0 : 4);
                LinearLayout linearLayout = BackchannelChatFragment.this.O0().d;
                i.d(linearLayout, "binding.blockRequest");
                i0.e.b.d3.k.L(linearLayout, Boolean.valueOf(yVar2.m));
                if (yVar2.m) {
                    a aVar2 = yVar2.b;
                    if (aVar2 == null || (list2 = aVar2.l) == null) {
                        chatMember = null;
                    } else {
                        chatMember = (ChatMember) m0.j.g.w(list2);
                    }
                    if (chatMember == null) {
                        a aVar3 = yVar2.b;
                        if (aVar3 == null || (list = aVar3.n) == null) {
                            chatMember = null;
                        } else {
                            chatMember = (ChatMember) m0.j.g.w(list);
                        }
                    }
                    if (chatMember != null) {
                        BackchannelChatFragment backchannelChatFragment2 = BackchannelChatFragment.this;
                        backchannelChatFragment2.O0().c.setText(backchannelChatFragment2.getString(R.string.block_button_label, v.f0(chatMember)));
                        backchannelChatFragment2.O0().c.setOnClickListener(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00dc: INVOKE  
                              (wrap: android.widget.Button : 0x00d5: IGET  (r3v3 android.widget.Button A[REMOVE]) = 
                              (wrap: com.clubhouse.backchannel.databinding.FragmentBackchannelChatBinding : 0x00d1: INVOKE  (r3v2 com.clubhouse.backchannel.databinding.FragmentBackchannelChatBinding A[REMOVE]) = (r2v4 'backchannelChatFragment2' com.clubhouse.backchannel.chat.BackchannelChatFragment) type: VIRTUAL call: com.clubhouse.backchannel.chat.BackchannelChatFragment.O0():com.clubhouse.backchannel.databinding.FragmentBackchannelChatBinding)
                             com.clubhouse.backchannel.databinding.FragmentBackchannelChatBinding.c android.widget.Button)
                              (wrap: i0.e.c.c.l : 0x00d9: CONSTRUCTOR  (r4v4 i0.e.c.c.l A[REMOVE]) = 
                              (r2v4 'backchannelChatFragment2' com.clubhouse.backchannel.chat.BackchannelChatFragment)
                              (r0v28 'chatMember' com.clubhouse.pubsub.user.backchannel.models.remote.ChatMember)
                             call: i0.e.c.c.l.<init>(com.clubhouse.backchannel.chat.BackchannelChatFragment, com.clubhouse.pubsub.user.backchannel.models.remote.ChatMember):void type: CONSTRUCTOR)
                             type: VIRTUAL call: android.widget.Button.setOnClickListener(android.view.View$OnClickListener):void in method: com.clubhouse.backchannel.chat.BackchannelChatFragment$invalidate$1.invoke(i0.e.c.c.y):m0.i, file: classes3.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:122)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:122)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
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
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: i0.e.c.c.l, state: NOT_LOADED
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
                            	... 27 more
                            */
                        /*
                        // Method dump skipped, instructions count: 266
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.clubhouse.backchannel.chat.BackchannelChatFragment$invalidate$1.invoke(java.lang.Object):java.lang.Object");
                    }
                });
            }

            public final FragmentBackchannelChatBinding O0() {
                return (FragmentBackchannelChatBinding) this.b2.getValue(this, Z1[0]);
            }

            public final BackchannelChatViewModel P0() {
                return (BackchannelChatViewModel) this.c2.getValue();
            }

            @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
            public void onViewCreated(View view, Bundle bundle) {
                i.e(view, "view");
                super.onViewCreated(view, bundle);
                O0().k.setBackgroundColor(v.t0(this));
                ImpressionTrackingEpoxyRecyclerView impressionTrackingEpoxyRecyclerView = O0().e;
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, true);
                linearLayoutManager.setStackFromEnd(true);
                impressionTrackingEpoxyRecyclerView.setLayoutManager(linearLayoutManager);
                ImpressionTrackingEpoxyRecyclerView impressionTrackingEpoxyRecyclerView2 = O0().e;
                i.d(impressionTrackingEpoxyRecyclerView2, "binding.chatList");
                i0.e.b.d3.k.D(impressionTrackingEpoxyRecyclerView2, this, new l<o, m0.i>() { // from class: com.clubhouse.backchannel.chat.BackchannelChatFragment$onViewCreated$2
                    @Override // m0.n.a.l
                    public m0.i invoke(o oVar) {
                        o oVar2 = oVar;
                        i.e(oVar2, "$this$safeBuildModelsWith");
                        BackchannelChatFragment backchannelChatFragment = BackchannelChatFragment.this;
                        k<Object>[] kVarArr = BackchannelChatFragment.Z1;
                        ImpressionTrackingEpoxyRecyclerView impressionTrackingEpoxyRecyclerView3 = backchannelChatFragment.O0().e;
                        i.d(impressionTrackingEpoxyRecyclerView3, "binding.chatList");
                        v.T1(oVar2, impressionTrackingEpoxyRecyclerView3);
                        BackchannelChatFragment backchannelChatFragment2 = BackchannelChatFragment.this;
                        v.v2(backchannelChatFragment2.P0(), 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0024: INVOKE  
                              (wrap: com.clubhouse.backchannel.chat.BackchannelChatViewModel : 0x001b: INVOKE  (r1v2 com.clubhouse.backchannel.chat.BackchannelChatViewModel A[REMOVE]) = (r0v4 'backchannelChatFragment2' com.clubhouse.backchannel.chat.BackchannelChatFragment) type: VIRTUAL call: com.clubhouse.backchannel.chat.BackchannelChatFragment.P0():com.clubhouse.backchannel.chat.BackchannelChatViewModel)
                              (wrap: com.clubhouse.backchannel.chat.BackchannelChatFragment$buildModels$1 : 0x0021: CONSTRUCTOR  (r2v0 com.clubhouse.backchannel.chat.BackchannelChatFragment$buildModels$1 A[REMOVE]) = (r0v4 'backchannelChatFragment2' com.clubhouse.backchannel.chat.BackchannelChatFragment), (r4v1 'oVar2' i0.b.a.o) call: com.clubhouse.backchannel.chat.BackchannelChatFragment$buildModels$1.<init>(com.clubhouse.backchannel.chat.BackchannelChatFragment, i0.b.a.o):void type: CONSTRUCTOR)
                             type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: com.clubhouse.backchannel.chat.BackchannelChatFragment$onViewCreated$2.invoke(i0.b.a.o):m0.i, file: classes3.dex
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
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.backchannel.chat.BackchannelChatFragment$buildModels$1, state: NOT_LOADED
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
                            com.clubhouse.backchannel.chat.BackchannelChatFragment r0 = com.clubhouse.backchannel.chat.BackchannelChatFragment.this
                            m0.r.k<java.lang.Object>[] r1 = com.clubhouse.backchannel.chat.BackchannelChatFragment.Z1
                            com.clubhouse.backchannel.databinding.FragmentBackchannelChatBinding r0 = r0.O0()
                            com.clubhouse.android.shared.ui.ImpressionTrackingEpoxyRecyclerView r0 = r0.e
                            java.lang.String r1 = "binding.chatList"
                            m0.n.b.i.d(r0, r1)
                            h0.b0.v.T1(r4, r0)
                            com.clubhouse.backchannel.chat.BackchannelChatFragment r0 = com.clubhouse.backchannel.chat.BackchannelChatFragment.this
                            com.clubhouse.backchannel.chat.BackchannelChatViewModel r1 = r0.P0()
                            com.clubhouse.backchannel.chat.BackchannelChatFragment$buildModels$1 r2 = new com.clubhouse.backchannel.chat.BackchannelChatFragment$buildModels$1
                            r2.<init>(r0, r4)
                            h0.b0.v.v2(r1, r2)
                            m0.i r4 = m0.i.a
                            return r4
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.clubhouse.backchannel.chat.BackchannelChatFragment$onViewCreated$2.invoke(java.lang.Object):java.lang.Object");
                    }
                });
                O0().b.setOnClickListener(new View.OnClickListener() { // from class: i0.e.c.c.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        BackchannelChatFragment backchannelChatFragment = BackchannelChatFragment.this;
                        k<Object>[] kVarArr = BackchannelChatFragment.Z1;
                        i.e(backchannelChatFragment, "this$0");
                        h0.o.a.k activity = backchannelChatFragment.getActivity();
                        if (activity != null) {
                            activity.onBackPressed();
                        }
                    }
                });
                Button button = O0().h;
                i.d(button, "binding.send");
                p viewLifecycleOwner = getViewLifecycleOwner();
                i.d(viewLifecycleOwner, "viewLifecycleOwner");
                i0.e.b.d3.k.H(button, q.a(viewLifecycleOwner), new View.OnClickListener() { // from class: i0.e.c.c.n
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        BackchannelChatFragment backchannelChatFragment = BackchannelChatFragment.this;
                        k<Object>[] kVarArr = BackchannelChatFragment.Z1;
                        i.e(backchannelChatFragment, "this$0");
                        backchannelChatFragment.P0().p(new f0(backchannelChatFragment.O0().f.getText().toString()));
                        backchannelChatFragment.O0().f.getText().clear();
                    }
                });
                Button button2 = O0().i;
                i.d(button2, "binding.startRoom");
                p viewLifecycleOwner2 = getViewLifecycleOwner();
                i.d(viewLifecycleOwner2, "viewLifecycleOwner");
                i0.e.b.d3.k.H(button2, q.a(viewLifecycleOwner2), new View.OnClickListener() { // from class: i0.e.c.c.m
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        BackchannelChatFragment backchannelChatFragment = BackchannelChatFragment.this;
                        k<Object>[] kVarArr = BackchannelChatFragment.Z1;
                        i.e(backchannelChatFragment, "this$0");
                        backchannelChatFragment.P0().p(h0.a);
                        FrameLayout frameLayout = backchannelChatFragment.O0().g;
                        i.d(frameLayout, "binding.roomLoading");
                        i0.e.b.d3.k.K(frameLayout);
                    }
                });
                EditText editText = O0().f;
                i.d(editText, "binding.composer");
                FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(i0.e.b.d3.k.M(editText), new BackchannelChatFragment$onViewCreated$6(this, null));
                p viewLifecycleOwner3 = getViewLifecycleOwner();
                i.d(viewLifecycleOwner3, "viewLifecycleOwner");
                m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner3));
                Toolbar toolbar = O0().k;
                i.d(toolbar, "binding.toolbar");
                p viewLifecycleOwner4 = getViewLifecycleOwner();
                i.d(viewLifecycleOwner4, "viewLifecycleOwner");
                i0.e.b.d3.k.H(toolbar, q.a(viewLifecycleOwner4), new View.OnClickListener() { // from class: i0.e.c.c.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        BackchannelChatFragment backchannelChatFragment = BackchannelChatFragment.this;
                        k<Object>[] kVarArr = BackchannelChatFragment.Z1;
                        i.e(backchannelChatFragment, "this$0");
                        v.v2(backchannelChatFragment.P0(), 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: INVOKE  
                              (wrap: com.clubhouse.backchannel.chat.BackchannelChatViewModel : 0x0009: INVOKE  (r0v2 com.clubhouse.backchannel.chat.BackchannelChatViewModel A[REMOVE]) = (r3v1 'backchannelChatFragment' com.clubhouse.backchannel.chat.BackchannelChatFragment) type: VIRTUAL call: com.clubhouse.backchannel.chat.BackchannelChatFragment.P0():com.clubhouse.backchannel.chat.BackchannelChatViewModel)
                              (wrap: com.clubhouse.backchannel.chat.BackchannelChatFragment$onViewCreated$7$1 : 0x000f: CONSTRUCTOR  (r1v0 com.clubhouse.backchannel.chat.BackchannelChatFragment$onViewCreated$7$1 A[REMOVE]) = (r3v1 'backchannelChatFragment' com.clubhouse.backchannel.chat.BackchannelChatFragment) call: com.clubhouse.backchannel.chat.BackchannelChatFragment$onViewCreated$7$1.<init>(com.clubhouse.backchannel.chat.BackchannelChatFragment):void type: CONSTRUCTOR)
                             type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: i0.e.c.c.a.onClick(android.view.View):void, file: classes3.dex
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
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.backchannel.chat.BackchannelChatFragment$onViewCreated$7$1, state: NOT_LOADED
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
                            com.clubhouse.backchannel.chat.BackchannelChatFragment r3 = com.clubhouse.backchannel.chat.BackchannelChatFragment.this
                            m0.r.k<java.lang.Object>[] r0 = com.clubhouse.backchannel.chat.BackchannelChatFragment.Z1
                            java.lang.String r0 = "this$0"
                            m0.n.b.i.e(r3, r0)
                            com.clubhouse.backchannel.chat.BackchannelChatViewModel r0 = r3.P0()
                            com.clubhouse.backchannel.chat.BackchannelChatFragment$onViewCreated$7$1 r1 = new com.clubhouse.backchannel.chat.BackchannelChatFragment$onViewCreated$7$1
                            r1.<init>(r3)
                            h0.b0.v.v2(r0, r1)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: i0.e.c.c.a.onClick(android.view.View):void");
                    }
                });
                FadingEdgeCarousel fadingEdgeCarousel = O0().a;
                i.d(fadingEdgeCarousel, "binding.avatars");
                i0.e.b.d3.k.D(fadingEdgeCarousel, this, new l<o, m0.i>() { // from class: com.clubhouse.backchannel.chat.BackchannelChatFragment$buildHeaderAvatars$1
                    @Override // m0.n.a.l
                    public m0.i invoke(o oVar) {
                        final o oVar2 = oVar;
                        i.e(oVar2, "$this$null");
                        BackchannelChatFragment backchannelChatFragment = BackchannelChatFragment.this;
                        k<Object>[] kVarArr = BackchannelChatFragment.Z1;
                        BackchannelChatViewModel P0 = backchannelChatFragment.P0();
                        final BackchannelChatFragment backchannelChatFragment2 = BackchannelChatFragment.this;
                        v.v2(P0, new l<y, m0.i>() { // from class: com.clubhouse.backchannel.chat.BackchannelChatFragment$buildHeaderAvatars$1.1
                            @Override // m0.n.a.l
                            public m0.i invoke(y yVar) {
                                List<ChatMember> list;
                                y yVar2 = yVar;
                                i.e(yVar2, "state");
                                a aVar = yVar2.b;
                                if (!(aVar == null || (list = aVar.n) == null)) {
                                    o oVar3 = o.this;
                                    BackchannelChatFragment backchannelChatFragment3 = backchannelChatFragment2;
                                    for (ChatMember chatMember : list) {
                                        c cVar = new c();
                                        cVar.F(new Number[]{chatMember.getId()});
                                        cVar.H(v.f0(chatMember));
                                        cVar.D(chatMember.Z1);
                                        cVar.G(chatMember.c2);
                                        cVar.E(new i0.e.c.c.c(backchannelChatFragment3, chatMember));
                                        oVar3.add(cVar);
                                    }
                                }
                                return m0.i.a;
                            }
                        });
                        return m0.i.a;
                    }
                });
                O0().a.setItemSpacingDp(0);
                f1 unused = x0(P0(), BackchannelChatFragment$onViewCreated$8.c, (r5 & 2) != 0 ? c0.a : null, new BackchannelChatFragment$onViewCreated$9(this, null));
                v.g(this, new m0.n.a.p<Boolean, Integer, m0.i>() { // from class: com.clubhouse.backchannel.chat.BackchannelChatFragment$onViewCreated$10
                    @Override // m0.n.a.p
                    public m0.i invoke(Boolean bool, Integer num) {
                        boolean booleanValue = bool.booleanValue();
                        int intValue = num.intValue();
                        if (booleanValue) {
                            BackchannelChatFragment backchannelChatFragment = BackchannelChatFragment.this;
                            k<Object>[] kVarArr = BackchannelChatFragment.Z1;
                            EditText editText2 = backchannelChatFragment.O0().f;
                            i.d(editText2, "binding.composer");
                            i0.e.b.d3.k.G(editText2, intValue);
                            BackchannelChatFragment.this.O0().e.scrollToPosition(0);
                        } else {
                            BackchannelChatFragment backchannelChatFragment2 = BackchannelChatFragment.this;
                            k<Object>[] kVarArr2 = BackchannelChatFragment.Z1;
                            EditText editText3 = backchannelChatFragment2.O0().f;
                            i.d(editText3, "binding.composer");
                            i0.e.b.d3.k.G(editText3, BackchannelChatFragment.this.getResources().getDimensionPixelSize(R.dimen.composer_bottom_margin));
                        }
                        return m0.i.a;
                    }
                });
                ImpressionTrackingEpoxyRecyclerView impressionTrackingEpoxyRecyclerView3 = O0().e;
                i.d(impressionTrackingEpoxyRecyclerView3, "binding.chatList");
                impressionTrackingEpoxyRecyclerView3.getViewTreeObserver().addOnGlobalLayoutListener(new a(impressionTrackingEpoxyRecyclerView3, this));
                FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$12 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(P0().l, new BackchannelChatFragment$onViewCreated$12(this, null));
                p viewLifecycleOwner5 = getViewLifecycleOwner();
                i.d(viewLifecycleOwner5, "viewLifecycleOwner");
                m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$12, q.a(viewLifecycleOwner5));
                v.v2(P0(), new l<y, m0.i>() { // from class: com.clubhouse.backchannel.chat.BackchannelChatFragment$onViewCreated$13
                    @Override // m0.n.a.l
                    public m0.i invoke(y yVar) {
                        y yVar2 = yVar;
                        i.e(yVar2, "state");
                        NotificationManagerCompat.from(BackchannelChatFragment.this.requireContext()).cancel(yVar2.a, 6534);
                        return m0.i.a;
                    }
                });
            }
        }
