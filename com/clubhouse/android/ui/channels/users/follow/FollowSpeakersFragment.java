package com.clubhouse.android.ui.channels.users.follow;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.airbnb.epoxy.paging3.PagingDataEpoxyController;
import com.clubhouse.android.data.models.local.channel.UserInChannel;
import com.clubhouse.android.data.models.local.user.SourceLocation;
import com.clubhouse.android.di.FragmentName;
import com.clubhouse.android.shared.ui.AbstractUserFragment;
import com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment;
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
import i0.e.b.b3.b.e.d;
import i0.e.b.g3.k.w0.a.b;
import i0.e.b.g3.k.w0.a.e;
import i0.e.b.g3.k.w0.a.f;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import m0.c;
import m0.n.a.l;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.k;
import m0.r.t.a.r.m.a1.a;
import n0.a.f0;
import n0.a.f1;
/* compiled from: FollowSpeakersFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001b\u0010\u000bJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000bR\u001d\u0010\u0012\u001a\u00020\r8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R(\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00138\u0014@\u0014X\u0094\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/clubhouse/android/ui/channels/users/follow/FollowSpeakersFragment;", "Lcom/clubhouse/android/shared/ui/AbstractUserFragment;", "Li0/e/b/b3/b/e/d;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "U0", "()V", "J", "Lcom/clubhouse/android/ui/channels/users/follow/FollowSpeakersViewModel;", "s2", "Lm0/c;", "getViewModel", "()Lcom/clubhouse/android/ui/channels/users/follow/FollowSpeakersViewModel;", "viewModel", "Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;", "t2", "Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;", "T0", "()Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;", "setPagedController", "(Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;)V", "pagedController", "<init>", "UserController", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class FollowSpeakersFragment extends AbstractUserFragment<d> {
    public static final /* synthetic */ k<Object>[] r2 = {m.c(new PropertyReference1Impl(m.a(FollowSpeakersFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/channels/users/follow/FollowSpeakersViewModel;"))};
    public final c s2;
    public PagingDataEpoxyController<d> t2 = new UserController(this);

    /* compiled from: FollowSpeakersFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ%\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/clubhouse/android/ui/channels/users/follow/FollowSpeakersFragment$UserController;", "Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;", "Li0/e/b/b3/b/e/d;", "", "currentPosition", "item", "Li0/b/a/t;", "buildItemModel", "(ILi0/e/b/b3/b/e/d;)Li0/b/a/t;", "<init>", "(Lcom/clubhouse/android/ui/channels/users/follow/FollowSpeakersFragment;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public final class UserController extends PagingDataEpoxyController<d> {
        public final /* synthetic */ FollowSpeakersFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserController(FollowSpeakersFragment followSpeakersFragment) {
            super(null, null, null, 7, null);
            i.e(followSpeakersFragment, "this$0");
            this.this$0 = followSpeakersFragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: buildItemModel$lambda-0  reason: not valid java name */
        public static final void m2buildItemModel$lambda0(FollowSpeakersFragment followSpeakersFragment, d dVar, View view) {
            i.e(followSpeakersFragment, "this$0");
            UserInChannel userInChannel = dVar.g;
            SourceLocation sourceLocation = SourceLocation.SUGGESTED_SPEAKERS;
            boolean z = true & true;
            boolean z2 = true & true;
            i.e(followSpeakersFragment, "<this>");
            i.e(userInChannel, "user");
            i.e(sourceLocation, Stripe3ds2AuthParams.FIELD_SOURCE);
            v.f(followSpeakersFragment, FragmentName.HALF_PROFILE, new HalfProfileArgs(userInChannel, sourceLocation, false, false, false, 16));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: buildItemModel$lambda-1  reason: not valid java name */
        public static final void m3buildItemModel$lambda1(FollowSpeakersFragment followSpeakersFragment, d dVar, View view) {
            i.e(followSpeakersFragment, "this$0");
            ((FollowSpeakersViewModel) followSpeakersFragment.s2.getValue()).p(new f(dVar.g.getId().intValue()));
        }

        public t<?> buildItemModel(int i, d dVar) {
            if (dVar != null) {
                i0.e.b.f3.m.b.c cVar = new i0.e.b.f3.m.b.c();
                cVar.t(dVar.g.getId());
                UserInChannel userInChannel = dVar.g;
                cVar.w();
                cVar.j = userInChannel;
                String k = i.k("@", dVar.g.f2);
                cVar.w();
                cVar.k = k;
                boolean z = dVar.i;
                cVar.w();
                cVar.n = z;
                cVar.w();
                cVar.m = true;
                cVar.w();
                cVar.r = true;
                b bVar = new b(this.this$0, dVar);
                cVar.w();
                cVar.l = bVar;
                i0.e.b.g3.k.w0.a.a aVar = new i0.e.b.g3.k.w0.a.a(this.this$0, dVar);
                cVar.w();
                cVar.o = aVar;
                i.d(cVar, "FollowableListUser_()\n                .id(item.user.id)\n                .user(item.user)\n                .userBio(\"@${item.user.username}\")\n                .following( item.followedBySelf)\n                .showFollowButton(true)\n                .compactMode(true)\n                .clickListener { _ ->\n                    showHalfProfile(item.user, SourceLocation.SUGGESTED_SPEAKERS)\n                }\n                .followClickListener { _ ->\n                    viewModel.processIntent(ToggleFollowUser(item.user.id))\n                }");
                return cVar;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<FollowSpeakersFragment, FollowSpeakersViewModel> {
        public final /* synthetic */ m0.r.d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ m0.r.d c;

        public a(m0.r.d dVar, boolean z, l lVar, m0.r.d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<FollowSpeakersViewModel> a(FollowSpeakersFragment followSpeakersFragment, k kVar) {
            FollowSpeakersFragment followSpeakersFragment2 = followSpeakersFragment;
            i.e(followSpeakersFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(followSpeakersFragment2, kVar, this.a, new FollowSpeakersFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(e.class), false, this.b);
        }
    }

    public FollowSpeakersFragment() {
        m0.r.d a2 = m.a(FollowSpeakersViewModel.class);
        this.s2 = new a(a2, false, new l<i0.b.b.k<FollowSpeakersViewModel, e>, FollowSpeakersViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ m0.r.d d;
            public final /* synthetic */ m0.r.d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.clubhouse.android.ui.channels.users.follow.FollowSpeakersViewModel, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.l
            public FollowSpeakersViewModel invoke(i0.b.b.k<FollowSpeakersViewModel, e> kVar) {
                i0.b.b.k<FollowSpeakersViewModel, e> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, e.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, r2[0]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2((FollowSpeakersViewModel) this.s2.getValue(), new l<e, f1>() { // from class: com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment$invalidate$1
            @Override // m0.n.a.l
            public f1 invoke(e eVar) {
                final e eVar2 = eVar;
                i.e(eVar2, "state");
                p viewLifecycleOwner = FollowSpeakersFragment.this.getViewLifecycleOwner();
                i.d(viewLifecycleOwner, "viewLifecycleOwner");
                LifecycleCoroutineScope a2 = q.a(viewLifecycleOwner);
                final FollowSpeakersFragment followSpeakersFragment = FollowSpeakersFragment.this;
                return a.E2(a2, null, null, new m0.n.a.p<f0, m0.l.c<? super m0.i>, Object>(null) { // from class: com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment$invalidate$1.1
                    public int c;

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final m0.l.c<m0.i> create(Object obj, m0.l.c<?> cVar) {
                        return 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000d: INVOKE  
                              (wrap: com.clubhouse.android.ui.channels.users.follow.FollowSpeakersViewModel : 0x0006: CHECK_CAST (r0v2 com.clubhouse.android.ui.channels.users.follow.FollowSpeakersViewModel A[REMOVE]) = (com.clubhouse.android.ui.channels.users.follow.FollowSpeakersViewModel) (wrap: java.lang.Object : 0x0002: INVOKE  (r0v1 java.lang.Object A[REMOVE]) = 
                              (wrap: m0.c : 0x0000: IGET  (r0v0 m0.c A[REMOVE]) = (r2v0 'this' com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment A[IMMUTABLE_TYPE, THIS]) com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment.s2 m0.c)
                             type: INTERFACE call: m0.c.getValue():java.lang.Object))
                              (wrap: com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment$invalidate$1 : 0x000a: CONSTRUCTOR  (r1v0 com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment$invalidate$1 A[REMOVE]) = (r2v0 'this' com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment A[IMMUTABLE_TYPE, THIS]) call: com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment$invalidate$1.<init>(com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment):void type: CONSTRUCTOR)
                             type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment.J():void, file: classes3.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0026: RETURN  
                              (wrap: n0.a.f1 : 0x0022: INVOKE  (r9v2 n0.a.f1 A[REMOVE]) = 
                              (r2v0 'a2' androidx.lifecycle.LifecycleCoroutineScope)
                              (null m0.l.e)
                              (null kotlinx.coroutines.CoroutineStart)
                              (wrap: com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment$invalidate$1$1 : 0x001b: CONSTRUCTOR  (r5v0 com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment$invalidate$1$1 A[REMOVE]) = 
                              (r0v3 'followSpeakersFragment' com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment A[DONT_INLINE, SKIP_ARG])
                              (r9v1 'eVar2' i0.e.b.g3.k.w0.a.e A[DONT_INLINE, SKIP_ARG])
                              (null m0.l.c)
                             call: com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment$invalidate$1.1.<init>(com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment, i0.e.b.g3.k.w0.a.e, m0.l.c):void type: CONSTRUCTOR)
                              (3 int)
                              (null java.lang.Object)
                             type: STATIC call: m0.r.t.a.r.m.a1.a.E2(n0.a.f0, m0.l.e, kotlinx.coroutines.CoroutineStart, m0.n.a.p, int, java.lang.Object):n0.a.f1)
                             in method: com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment$invalidate$1.invoke(i0.e.b.g3.k.w0.a.e):n0.a.f1, file: classes3.dex
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
                              (wrap: com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment$invalidate$1$1 : 0x0006: CONSTRUCTOR  (r3v1 com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment$invalidate$1$1 A[REMOVE]) = 
                              (wrap: com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment : 0x0002: IGET  (r0v0 com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment A[REMOVE]) = 
                              (r2v0 'this' com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment$invalidate$1$1 A[IMMUTABLE_TYPE, THIS])
                             com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment$invalidate$1.1.d com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment)
                              (wrap: i0.e.b.g3.k.w0.a.e : 0x0004: IGET  (r1v0 i0.e.b.g3.k.w0.a.e A[REMOVE]) = 
                              (r2v0 'this' com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment$invalidate$1$1 A[IMMUTABLE_TYPE, THIS])
                             com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment$invalidate$1.1.q i0.e.b.g3.k.w0.a.e)
                              (r4v0 'cVar' m0.l.c<?>)
                             call: com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment$invalidate$1.1.<init>(com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment, i0.e.b.g3.k.w0.a.e, m0.l.c):void type: CONSTRUCTOR)
                             in method: com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment$invalidate$1.1.create(java.lang.Object, m0.l.c<?>):m0.l.c<m0.i>, file: classes3.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment$invalidate$1.1
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
                            com.clubhouse.android.ui.channels.users.follow.FollowSpeakersViewModel r0 = (com.clubhouse.android.ui.channels.users.follow.FollowSpeakersViewModel) r0
                            com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment$invalidate$1 r1 = new com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment$invalidate$1
                            r1.<init>()
                            h0.b0.v.v2(r0, r1)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.clubhouse.android.ui.channels.users.follow.FollowSpeakersFragment.J():void");
                    }

                    @Override // com.clubhouse.android.shared.ui.AbstractUserFragment
                    public PagingDataEpoxyController<d> T0() {
                        return this.t2;
                    }

                    @Override // com.clubhouse.android.shared.ui.AbstractUserFragment
                    public void U0() {
                        S0().j.post(new Runnable() { // from class: i0.e.b.g3.k.w0.a.c
                            @Override // java.lang.Runnable
                            public final void run() {
                                FollowSpeakersFragment followSpeakersFragment = FollowSpeakersFragment.this;
                                k<Object>[] kVarArr = FollowSpeakersFragment.r2;
                                i.e(followSpeakersFragment, "this$0");
                                followSpeakersFragment.S0().j.setLayoutManager(new LinearLayoutManager(followSpeakersFragment.getContext(), 1, false));
                                followSpeakersFragment.S0().j.requestLayout();
                            }
                        });
                    }

                    @Override // com.clubhouse.android.shared.ui.AbstractUserFragment, com.clubhouse.android.core.ui.BaseBottomSheetFragment, androidx.fragment.app.Fragment
                    public void onViewCreated(View view, Bundle bundle) {
                        i.e(view, "view");
                        super.onViewCreated(view, bundle);
                        v.U1(this);
                        LinearLayout linearLayout = S0().g;
                        i.d(linearLayout, "binding.root");
                        linearLayout.setPadding(0, 0, 0, linearLayout.getPaddingBottom());
                        FrameLayout frameLayout = S0().e.b;
                        i.d(frameLayout, "binding.grabHandle.grabHandleRoot");
                        i0.e.b.d3.k.K(frameLayout);
                        EditText editText = S0().h;
                        i.d(editText, "binding.search");
                        i0.e.b.d3.k.p(editText);
                        S0().i.setText(getString(R.string.current_speakers));
                        TextView textView = S0().i;
                        i.d(textView, "binding.title");
                        textView.setPadding(getResources().getDimensionPixelSize(R.dimen.user_grid_horizontal_margin), textView.getPaddingTop(), textView.getPaddingRight(), textView.getPaddingBottom());
                        S0().j.setItemSpacingRes(R.dimen.list_item_spacing);
                        S0().j.setController(this.t2);
                    }
                }
