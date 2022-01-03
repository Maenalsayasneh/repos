package com.clubhouse.android.ui.recentSpeakers;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.airbnb.epoxy.paging3.PagingDataEpoxyController;
import com.clubhouse.android.data.models.local.user.BasicUser;
import com.clubhouse.android.data.models.local.user.SourceLocation;
import com.clubhouse.android.data.models.local.user.UserInList;
import com.clubhouse.android.databinding.FragmentRecentSpeakersBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.ui.profile.ProfileArgs;
import com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment;
import com.clubhouse.app.R;
import com.stripe.android.model.Stripe3ds2AuthParams;
import h0.b0.v;
import h0.q.p;
import h0.q.q;
import i0.b.a.t;
import i0.b.b.h;
import i0.b.b.x;
import i0.e.b.g3.v.b;
import i0.e.b.g3.v.d;
import i0.e.b.g3.v.f;
import i0.e.b.g3.v.g;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.c;
import m0.n.a.l;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.k;
import m0.r.t.a.r.m.a1.a;
import n0.a.f0;
import n0.a.f1;
/* compiled from: RecentSpeakersFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001b\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u00020\u000b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0016\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001a\u001a\u00060\u0017R\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/clubhouse/android/ui/recentSpeakers/RecentSpeakersFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lcom/clubhouse/android/databinding/FragmentRecentSpeakersBinding;", "a2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "N0", "()Lcom/clubhouse/android/databinding/FragmentRecentSpeakersBinding;", "binding", "Lcom/clubhouse/android/ui/recentSpeakers/RecentSpeakersViewModel;", "b2", "Lm0/c;", "getViewModel", "()Lcom/clubhouse/android/ui/recentSpeakers/RecentSpeakersViewModel;", "viewModel", "Lcom/clubhouse/android/ui/recentSpeakers/RecentSpeakersFragment$PagingController;", "c2", "Lcom/clubhouse/android/ui/recentSpeakers/RecentSpeakersFragment$PagingController;", "pagedController", "<init>", "PagingController", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class RecentSpeakersFragment extends Hilt_RecentSpeakersFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(RecentSpeakersFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentRecentSpeakersBinding;")), m.c(new PropertyReference1Impl(m.a(RecentSpeakersFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/recentSpeakers/RecentSpeakersViewModel;"))};
    public final c b2;
    public final FragmentViewBindingDelegate a2 = new FragmentViewBindingDelegate(FragmentRecentSpeakersBinding.class, this);
    public final PagingController c2 = new PagingController(this);

    /* compiled from: RecentSpeakersFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ%\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/clubhouse/android/ui/recentSpeakers/RecentSpeakersFragment$PagingController;", "Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;", "Li0/e/b/b3/b/e/m;", "", "currentPosition", "item", "Li0/b/a/t;", "buildItemModel", "(ILi0/e/b/b3/b/e/m;)Li0/b/a/t;", "<init>", "(Lcom/clubhouse/android/ui/recentSpeakers/RecentSpeakersFragment;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public final class PagingController extends PagingDataEpoxyController<i0.e.b.b3.b.e.m> {
        public final /* synthetic */ RecentSpeakersFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PagingController(RecentSpeakersFragment recentSpeakersFragment) {
            super(null, null, null, 7, null);
            i.e(recentSpeakersFragment, "this$0");
            this.this$0 = recentSpeakersFragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: buildItemModel$lambda-0  reason: not valid java name */
        public static final void m18buildItemModel$lambda0(RecentSpeakersFragment recentSpeakersFragment, i0.e.b.b3.b.e.m mVar, View view) {
            i.e(recentSpeakersFragment, "this$0");
            UserInList userInList = mVar.g;
            SourceLocation sourceLocation = SourceLocation.RECENT_CHANNELS_SPEAKERS;
            i.e(userInList, "<this>");
            i.e(sourceLocation, Stripe3ds2AuthParams.FIELD_SOURCE);
            ProfileArgs profileArgs = new ProfileArgs(userInList.getId(), null, new BasicUser(userInList.getId().intValue(), userInList.getName(), userInList.C(), userInList.b()), false, null, sourceLocation, null, 26);
            i.e(profileArgs, "mavericksArg");
            v.a1(recentSpeakersFragment, new d(profileArgs, null), null, 2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: buildItemModel$lambda-1  reason: not valid java name */
        public static final void m19buildItemModel$lambda1(RecentSpeakersFragment recentSpeakersFragment, i0.e.b.b3.b.e.m mVar, View view) {
            i.e(recentSpeakersFragment, "this$0");
            ((RecentSpeakersViewModel) recentSpeakersFragment.b2.getValue()).p(new g(mVar.g.getId().intValue()));
        }

        public t<?> buildItemModel(int i, i0.e.b.b3.b.e.m mVar) {
            if (mVar != null) {
                i0.e.b.f3.m.b.c cVar = new i0.e.b.f3.m.b.c();
                cVar.t(mVar.g.getId());
                UserInList userInList = mVar.g;
                cVar.w();
                cVar.j = userInList;
                boolean z = mVar.i;
                cVar.w();
                cVar.n = z;
                boolean z2 = mVar.j;
                cVar.w();
                cVar.p = z2;
                boolean z3 = mVar.h;
                cVar.w();
                cVar.q = z3;
                i0.e.b.g3.v.a aVar = new i0.e.b.g3.v.a(this.this$0, mVar);
                cVar.w();
                cVar.l = aVar;
                b bVar = new b(this.this$0, mVar);
                cVar.w();
                cVar.o = bVar;
                i.d(cVar, "FollowableListUser_()\n                .id(item.user.id)\n                .user(item.user)\n                .following(item.followedBySelf)\n                .blocked(item.blockedBySelf)\n                .self(item.isSelf)\n                .clickListener { _ ->\n                    navigateSafe(\n                        RecentSpeakersFragmentDirections.actionRecentSpeakersFragmentToProfileFragment(\n                            item.user.toProfileArgs(SourceLocation.RECENT_CHANNELS_SPEAKERS)\n                        )\n                    )\n                }\n                .followClickListener { _ ->\n                    viewModel.processIntent(ToggleFollowUser(item.user.id))\n                }");
                return cVar;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<RecentSpeakersFragment, RecentSpeakersViewModel> {
        public final /* synthetic */ m0.r.d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ m0.r.d c;

        public a(m0.r.d dVar, boolean z, l lVar, m0.r.d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<RecentSpeakersViewModel> a(RecentSpeakersFragment recentSpeakersFragment, k kVar) {
            RecentSpeakersFragment recentSpeakersFragment2 = recentSpeakersFragment;
            i.e(recentSpeakersFragment2, "thisRef");
            i.e(kVar, "property");
            return i0.b.b.g.a.b(recentSpeakersFragment2, kVar, this.a, new RecentSpeakersFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(f.class), false, this.b);
        }
    }

    public RecentSpeakersFragment() {
        super(R.layout.fragment_recent_speakers);
        m0.r.d a2 = m.a(RecentSpeakersViewModel.class);
        this.b2 = new a(a2, false, new l<i0.b.b.k<RecentSpeakersViewModel, f>, RecentSpeakersViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ m0.r.d d;
            public final /* synthetic */ m0.r.d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.clubhouse.android.ui.recentSpeakers.RecentSpeakersViewModel, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.l
            public RecentSpeakersViewModel invoke(i0.b.b.k<RecentSpeakersViewModel, f> kVar) {
                i0.b.b.k<RecentSpeakersViewModel, f> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, f.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, Z1[1]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2((RecentSpeakersViewModel) this.b2.getValue(), new l<f, f1>() { // from class: com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment$invalidate$1
            @Override // m0.n.a.l
            public f1 invoke(f fVar) {
                final f fVar2 = fVar;
                i.e(fVar2, "state");
                p viewLifecycleOwner = RecentSpeakersFragment.this.getViewLifecycleOwner();
                i.d(viewLifecycleOwner, "viewLifecycleOwner");
                LifecycleCoroutineScope a2 = q.a(viewLifecycleOwner);
                final RecentSpeakersFragment recentSpeakersFragment = RecentSpeakersFragment.this;
                return a.E2(a2, null, null, new m0.n.a.p<f0, m0.l.c<? super m0.i>, Object>(null) { // from class: com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment$invalidate$1.1
                    public int c;

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final m0.l.c<m0.i> create(Object obj, m0.l.c<?> cVar) {
                        return 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000d: INVOKE  
                              (wrap: com.clubhouse.android.ui.recentSpeakers.RecentSpeakersViewModel : 0x0006: CHECK_CAST (r0v2 com.clubhouse.android.ui.recentSpeakers.RecentSpeakersViewModel A[REMOVE]) = (com.clubhouse.android.ui.recentSpeakers.RecentSpeakersViewModel) (wrap: java.lang.Object : 0x0002: INVOKE  (r0v1 java.lang.Object A[REMOVE]) = 
                              (wrap: m0.c : 0x0000: IGET  (r0v0 m0.c A[REMOVE]) = (r2v0 'this' com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment A[IMMUTABLE_TYPE, THIS]) com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment.b2 m0.c)
                             type: INTERFACE call: m0.c.getValue():java.lang.Object))
                              (wrap: com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment$invalidate$1 : 0x000a: CONSTRUCTOR  (r1v0 com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment$invalidate$1 A[REMOVE]) = (r2v0 'this' com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment A[IMMUTABLE_TYPE, THIS]) call: com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment$invalidate$1.<init>(com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment):void type: CONSTRUCTOR)
                             type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment.J():void, file: classes3.dex
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
                              (wrap: com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment$invalidate$1$1 : 0x001b: CONSTRUCTOR  (r5v0 com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment$invalidate$1$1 A[REMOVE]) = 
                              (r0v3 'recentSpeakersFragment' com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment A[DONT_INLINE, SKIP_ARG])
                              (r9v1 'fVar2' i0.e.b.g3.v.f A[DONT_INLINE, SKIP_ARG])
                              (null m0.l.c)
                             call: com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment$invalidate$1.1.<init>(com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment, i0.e.b.g3.v.f, m0.l.c):void type: CONSTRUCTOR)
                              (3 int)
                              (null java.lang.Object)
                             type: STATIC call: m0.r.t.a.r.m.a1.a.E2(n0.a.f0, m0.l.e, kotlinx.coroutines.CoroutineStart, m0.n.a.p, int, java.lang.Object):n0.a.f1)
                             in method: com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment$invalidate$1.invoke(i0.e.b.g3.v.f):n0.a.f1, file: classes3.dex
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
                              (wrap: com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment$invalidate$1$1 : 0x0006: CONSTRUCTOR  (r3v1 com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment$invalidate$1$1 A[REMOVE]) = 
                              (wrap: com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment : 0x0002: IGET  (r0v0 com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment A[REMOVE]) = (r2v0 'this' com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment$invalidate$1$1 A[IMMUTABLE_TYPE, THIS]) com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment$invalidate$1.1.d com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment)
                              (wrap: i0.e.b.g3.v.f : 0x0004: IGET  (r1v0 i0.e.b.g3.v.f A[REMOVE]) = (r2v0 'this' com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment$invalidate$1$1 A[IMMUTABLE_TYPE, THIS]) com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment$invalidate$1.1.q i0.e.b.g3.v.f)
                              (r4v0 'cVar' m0.l.c<?>)
                             call: com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment$invalidate$1.1.<init>(com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment, i0.e.b.g3.v.f, m0.l.c):void type: CONSTRUCTOR)
                             in method: com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment$invalidate$1.1.create(java.lang.Object, m0.l.c<?>):m0.l.c<m0.i>, file: classes3.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment$invalidate$1.1
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
                            m0.c r0 = r2.b2
                            java.lang.Object r0 = r0.getValue()
                            com.clubhouse.android.ui.recentSpeakers.RecentSpeakersViewModel r0 = (com.clubhouse.android.ui.recentSpeakers.RecentSpeakersViewModel) r0
                            com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment$invalidate$1 r1 = new com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment$invalidate$1
                            r1.<init>()
                            h0.b0.v.v2(r0, r1)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.clubhouse.android.ui.recentSpeakers.RecentSpeakersFragment.J():void");
                    }

                    public final FragmentRecentSpeakersBinding N0() {
                        return (FragmentRecentSpeakersBinding) this.a2.getValue(this, Z1[0]);
                    }

                    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
                    public void onViewCreated(View view, Bundle bundle) {
                        i.e(view, "view");
                        super.onViewCreated(view, bundle);
                        N0().a.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.v.c
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                RecentSpeakersFragment recentSpeakersFragment = RecentSpeakersFragment.this;
                                k<Object>[] kVarArr = RecentSpeakersFragment.Z1;
                                i.e(recentSpeakersFragment, "this$0");
                                v.c1(recentSpeakersFragment);
                            }
                        });
                        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(v.f1(this.c2), new RecentSpeakersFragment$configurePagingController$1(this, null));
                        p viewLifecycleOwner = getViewLifecycleOwner();
                        i.d(viewLifecycleOwner, "viewLifecycleOwner");
                        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner));
                        N0().b.setController(this.c2);
                    }
                }
