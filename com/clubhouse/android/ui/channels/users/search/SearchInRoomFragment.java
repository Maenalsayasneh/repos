package com.clubhouse.android.ui.channels.users.search;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.GridLayoutManager;
import com.airbnb.epoxy.paging3.PagingDataEpoxyController;
import com.clubhouse.android.data.models.local.channel.UserInChannel;
import com.clubhouse.android.data.models.local.user.SourceLocation;
import com.clubhouse.android.di.FragmentName;
import com.clubhouse.android.shared.ui.AbstractUserFragment;
import com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment;
import com.clubhouse.android.ui.profile.HalfProfileArgs;
import com.clubhouse.app.R;
import com.stripe.android.model.Stripe3ds2AuthParams;
import h0.b0.v;
import h0.q.p;
import h0.q.q;
import i0.b.a.t;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.e.b.g3.k.x0.l;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.c;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
import m0.r.t.a.r.m.a1.a;
import n0.a.f0;
import n0.a.f1;
/* compiled from: SearchInRoomFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001b\u0010\u000bJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000bR(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0014@\u0014X\u0094\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001d\u0010\u001a\u001a\u00020\u00158B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/clubhouse/android/ui/channels/users/search/SearchInRoomFragment;", "Lcom/clubhouse/android/shared/ui/AbstractUserFragment;", "Lcom/clubhouse/android/data/models/local/channel/UserInChannel;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "U0", "()V", "J", "Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;", "t2", "Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;", "T0", "()Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;", "setPagedController", "(Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;)V", "pagedController", "Lcom/clubhouse/android/ui/channels/users/search/SearchInRoomViewModel;", "s2", "Lm0/c;", "getViewModel", "()Lcom/clubhouse/android/ui/channels/users/search/SearchInRoomViewModel;", "viewModel", "<init>", "UserController", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class SearchInRoomFragment extends AbstractUserFragment<UserInChannel> {
    public static final /* synthetic */ k<Object>[] r2 = {m.c(new PropertyReference1Impl(m.a(SearchInRoomFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/channels/users/search/SearchInRoomViewModel;"))};
    public final c s2;
    public PagingDataEpoxyController<UserInChannel> t2 = new UserController(this);

    /* compiled from: SearchInRoomFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ%\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/clubhouse/android/ui/channels/users/search/SearchInRoomFragment$UserController;", "Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;", "Lcom/clubhouse/android/data/models/local/channel/UserInChannel;", "", "currentPosition", "item", "Li0/b/a/t;", "buildItemModel", "(ILcom/clubhouse/android/data/models/local/channel/UserInChannel;)Li0/b/a/t;", "<init>", "(Lcom/clubhouse/android/ui/channels/users/search/SearchInRoomFragment;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public final class UserController extends PagingDataEpoxyController<UserInChannel> {
        public final /* synthetic */ SearchInRoomFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserController(SearchInRoomFragment searchInRoomFragment) {
            super(null, null, null, 7, null);
            i.e(searchInRoomFragment, "this$0");
            this.this$0 = searchInRoomFragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: buildItemModel$lambda-0  reason: not valid java name */
        public static final void m6buildItemModel$lambda0(SearchInRoomFragment searchInRoomFragment, UserInChannel userInChannel, View view) {
            i.e(searchInRoomFragment, "this$0");
            SourceLocation sourceLocation = SourceLocation.CHANNEL;
            boolean z = true & true;
            boolean z2 = true & true;
            i.e(searchInRoomFragment, "<this>");
            i.e(userInChannel, "user");
            i.e(sourceLocation, Stripe3ds2AuthParams.FIELD_SOURCE);
            v.f(searchInRoomFragment, FragmentName.HALF_PROFILE, new HalfProfileArgs(userInChannel, sourceLocation, false, false, false, 16));
        }

        public t<?> buildItemModel(int i, UserInChannel userInChannel) {
            if (userInChannel != null) {
                l lVar = new l();
                lVar.t(userInChannel.getId());
                lVar.w();
                lVar.j = userInChannel;
                i0.e.b.g3.k.w0.d.a aVar = new i0.e.b.g3.k.w0.d.a(this.this$0, userInChannel);
                lVar.w();
                lVar.l = aVar;
                i.d(lVar, "ChannelUser_()\n                .id(item.id)\n                .user(item)\n                .clickListener { _ -> showHalfProfile(item, SourceLocation.CHANNEL) }");
                return lVar;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<SearchInRoomFragment, SearchInRoomViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ m0.n.a.l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, m0.n.a.l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<SearchInRoomViewModel> a(SearchInRoomFragment searchInRoomFragment, k kVar) {
            SearchInRoomFragment searchInRoomFragment2 = searchInRoomFragment;
            i.e(searchInRoomFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(searchInRoomFragment2, kVar, this.a, new SearchInRoomFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(i0.e.b.g3.k.w0.d.d.class), false, this.b);
        }
    }

    public SearchInRoomFragment() {
        d a2 = m.a(SearchInRoomViewModel.class);
        this.s2 = new a(a2, false, new m0.n.a.l<i0.b.b.k<SearchInRoomViewModel, i0.e.b.g3.k.w0.d.d>, SearchInRoomViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.clubhouse.android.ui.channels.users.search.SearchInRoomViewModel, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.l
            public SearchInRoomViewModel invoke(i0.b.b.k<SearchInRoomViewModel, i0.e.b.g3.k.w0.d.d> kVar) {
                i0.b.b.k<SearchInRoomViewModel, i0.e.b.g3.k.w0.d.d> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, i0.e.b.g3.k.w0.d.d.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, r2[0]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2((SearchInRoomViewModel) this.s2.getValue(), new m0.n.a.l<i0.e.b.g3.k.w0.d.d, f1>() { // from class: com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment$invalidate$1
            @Override // m0.n.a.l
            public f1 invoke(i0.e.b.g3.k.w0.d.d dVar) {
                final i0.e.b.g3.k.w0.d.d dVar2 = dVar;
                i.e(dVar2, "state");
                SearchInRoomFragment searchInRoomFragment = SearchInRoomFragment.this;
                k<Object>[] kVarArr = SearchInRoomFragment.r2;
                searchInRoomFragment.S0().i.setText(SearchInRoomFragment.this.getString(R.string.search_room_title));
                SearchInRoomFragment.this.S0().d.setText(SearchInRoomFragment.this.getString(R.string.search_room_empty));
                p viewLifecycleOwner = SearchInRoomFragment.this.getViewLifecycleOwner();
                i.d(viewLifecycleOwner, "viewLifecycleOwner");
                LifecycleCoroutineScope a2 = q.a(viewLifecycleOwner);
                final SearchInRoomFragment searchInRoomFragment2 = SearchInRoomFragment.this;
                return a.E2(a2, null, null, new m0.n.a.p<f0, m0.l.c<? super m0.i>, Object>(null) { // from class: com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment$invalidate$1.1
                    public int c;

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final m0.l.c<m0.i> create(Object obj, m0.l.c<?> cVar) {
                        return 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000d: INVOKE  
                              (wrap: com.clubhouse.android.ui.channels.users.search.SearchInRoomViewModel : 0x0006: CHECK_CAST (r0v2 com.clubhouse.android.ui.channels.users.search.SearchInRoomViewModel A[REMOVE]) = (com.clubhouse.android.ui.channels.users.search.SearchInRoomViewModel) (wrap: java.lang.Object : 0x0002: INVOKE  (r0v1 java.lang.Object A[REMOVE]) = 
                              (wrap: m0.c : 0x0000: IGET  (r0v0 m0.c A[REMOVE]) = (r2v0 'this' com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment A[IMMUTABLE_TYPE, THIS]) com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment.s2 m0.c)
                             type: INTERFACE call: m0.c.getValue():java.lang.Object))
                              (wrap: com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment$invalidate$1 : 0x000a: CONSTRUCTOR  (r1v0 com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment$invalidate$1 A[REMOVE]) = (r2v0 'this' com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment A[IMMUTABLE_TYPE, THIS]) call: com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment$invalidate$1.<init>(com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment):void type: CONSTRUCTOR)
                             type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment.J():void, file: classes3.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0050: RETURN  
                              (wrap: n0.a.f1 : 0x004c: INVOKE  (r9v2 n0.a.f1 A[REMOVE]) = 
                              (r2v2 'a2' androidx.lifecycle.LifecycleCoroutineScope)
                              (null m0.l.e)
                              (null kotlinx.coroutines.CoroutineStart)
                              (wrap: com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment$invalidate$1$1 : 0x0047: CONSTRUCTOR  (r5v0 com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment$invalidate$1$1 A[REMOVE]) = 
                              (r0v9 'searchInRoomFragment2' com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment A[DONT_INLINE, SKIP_ARG])
                              (r9v1 'dVar2' i0.e.b.g3.k.w0.d.d A[DONT_INLINE, SKIP_ARG])
                              (null m0.l.c)
                             call: com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment$invalidate$1.1.<init>(com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment, i0.e.b.g3.k.w0.d.d, m0.l.c):void type: CONSTRUCTOR)
                              (3 int)
                              (null java.lang.Object)
                             type: STATIC call: m0.r.t.a.r.m.a1.a.E2(n0.a.f0, m0.l.e, kotlinx.coroutines.CoroutineStart, m0.n.a.p, int, java.lang.Object):n0.a.f1)
                             in method: com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment$invalidate$1.invoke(i0.e.b.g3.k.w0.d.d):n0.a.f1, file: classes3.dex
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
                              (wrap: com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment$invalidate$1$1 : 0x0006: CONSTRUCTOR  (r3v1 com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment$invalidate$1$1 A[REMOVE]) = 
                              (wrap: com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment : 0x0002: IGET  (r0v0 com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment A[REMOVE]) = 
                              (r2v0 'this' com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment$invalidate$1$1 A[IMMUTABLE_TYPE, THIS])
                             com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment$invalidate$1.1.d com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment)
                              (wrap: i0.e.b.g3.k.w0.d.d : 0x0004: IGET  (r1v0 i0.e.b.g3.k.w0.d.d A[REMOVE]) = 
                              (r2v0 'this' com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment$invalidate$1$1 A[IMMUTABLE_TYPE, THIS])
                             com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment$invalidate$1.1.q i0.e.b.g3.k.w0.d.d)
                              (r4v0 'cVar' m0.l.c<?>)
                             call: com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment$invalidate$1.1.<init>(com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment, i0.e.b.g3.k.w0.d.d, m0.l.c):void type: CONSTRUCTOR)
                             in method: com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment$invalidate$1.1.create(java.lang.Object, m0.l.c<?>):m0.l.c<m0.i>, file: classes3.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment$invalidate$1.1
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
                            m0.c r0 = r2.s2
                            java.lang.Object r0 = r0.getValue()
                            com.clubhouse.android.ui.channels.users.search.SearchInRoomViewModel r0 = (com.clubhouse.android.ui.channels.users.search.SearchInRoomViewModel) r0
                            com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment$invalidate$1 r1 = new com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment$invalidate$1
                            r1.<init>()
                            h0.b0.v.v2(r0, r1)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.clubhouse.android.ui.channels.users.search.SearchInRoomFragment.J():void");
                    }

                    @Override // com.clubhouse.android.shared.ui.AbstractUserFragment
                    public PagingDataEpoxyController<UserInChannel> T0() {
                        return this.t2;
                    }

                    @Override // com.clubhouse.android.shared.ui.AbstractUserFragment
                    public void U0() {
                        S0().j.post(new Runnable() { // from class: i0.e.b.g3.k.w0.d.b
                            @Override // java.lang.Runnable
                            public final void run() {
                                SearchInRoomFragment searchInRoomFragment = SearchInRoomFragment.this;
                                k<Object>[] kVarArr = SearchInRoomFragment.r2;
                                i.e(searchInRoomFragment, "this$0");
                                searchInRoomFragment.S0().j.setLayoutManager(new GridLayoutManager(searchInRoomFragment.getContext(), 12));
                                searchInRoomFragment.S0().j.requestLayout();
                            }
                        });
                    }

                    @Override // com.clubhouse.android.shared.ui.AbstractUserFragment, com.clubhouse.android.core.ui.BaseBottomSheetFragment, androidx.fragment.app.Fragment
                    public void onViewCreated(View view, Bundle bundle) {
                        i.e(view, "view");
                        super.onViewCreated(view, bundle);
                        EditText editText = S0().h;
                        i.d(editText, "binding.search");
                        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(i0.e.b.d3.k.f(editText), new SearchInRoomFragment$onViewCreated$1(this, null));
                        p viewLifecycleOwner = getViewLifecycleOwner();
                        i.d(viewLifecycleOwner, "viewLifecycleOwner");
                        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner));
                    }
                }
