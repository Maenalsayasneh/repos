package com.clubhouse.android.ui.channels.users.ping;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.GridLayoutManager;
import com.airbnb.epoxy.paging3.PagingDataEpoxyController;
import com.clubhouse.android.data.models.local.user.UserInList;
import com.clubhouse.android.shared.ui.AbstractUserFragment;
import com.clubhouse.android.ui.channels.users.ping.PingUserFragment;
import com.clubhouse.app.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import h0.b0.v;
import h0.q.p;
import h0.q.q;
import i0.b.a.t;
import i0.b.b.h;
import i0.b.b.x;
import i0.e.b.b3.b.e.m;
import i0.e.b.g3.k.w0.b.f;
import i0.e.b.g3.k.w0.b.g;
import i0.e.b.g3.k.w0.b.j;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.c;
import m0.n.a.l;
import m0.n.b.i;
import m0.r.d;
import m0.r.k;
import m0.r.t.a.r.m.a1.a;
import n0.a.f0;
/* compiled from: PingUserFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b'\u0010\fJ!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\fR.\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00118\u0014@\u0014X\u0094\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001e\u001a\u00020\u00198B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/clubhouse/android/ui/channels/users/ping/PingUserFragment;", "Lcom/clubhouse/android/shared/ui/AbstractUserFragment;", "Li0/e/b/a3/d/a;", "Li0/e/b/b3/b/e/m;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "U0", "()V", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior$c;", "Q0", "()Lcom/google/android/material/bottomsheet/BottomSheetBehavior$c;", "J", "Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;", "u2", "Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;", "T0", "()Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;", "setPagedController", "(Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;)V", "pagedController", "Lcom/clubhouse/android/ui/channels/users/ping/PingUserViewModel;", "t2", "Lm0/c;", "Y0", "()Lcom/clubhouse/android/ui/channels/users/ping/PingUserViewModel;", "viewModel", "Li0/e/a/b/a;", "s2", "Li0/e/a/b/a;", "getActionTrailRecorder", "()Li0/e/a/b/a;", "setActionTrailRecorder", "(Li0/e/a/b/a;)V", "actionTrailRecorder", "<init>", "UserController", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class PingUserFragment extends AbstractUserFragment<i0.e.b.a3.d.a<m>> {
    public static final /* synthetic */ k<Object>[] r2 = {m0.n.b.m.c(new PropertyReference1Impl(m0.n.b.m.a(PingUserFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/channels/users/ping/PingUserViewModel;"))};
    public i0.e.a.b.a s2;
    public final c t2;
    public PagingDataEpoxyController<i0.e.b.a3.d.a<m>> u2 = new UserController(this);

    /* compiled from: PingUserFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/clubhouse/android/ui/channels/users/ping/PingUserFragment$UserController;", "Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;", "Li0/e/b/a3/d/a;", "Li0/e/b/b3/b/e/m;", "", "currentPosition", "item", "Li0/b/a/t;", "buildItemModel", "(ILi0/e/b/a3/d/a;)Li0/b/a/t;", "<init>", "(Lcom/clubhouse/android/ui/channels/users/ping/PingUserFragment;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public final class UserController extends PagingDataEpoxyController<i0.e.b.a3.d.a<m>> {
        public final /* synthetic */ PingUserFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserController(PingUserFragment pingUserFragment) {
            super(null, null, null, 7, null);
            i.e(pingUserFragment, "this$0");
            this.this$0 = pingUserFragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: buildItemModel$lambda-0  reason: not valid java name */
        public static final void m4buildItemModel$lambda0(i0.e.b.a3.d.a aVar, PingUserFragment pingUserFragment, View view) {
            i.e(pingUserFragment, "this$0");
            if (!aVar.b) {
                k<Object>[] kVarArr = PingUserFragment.r2;
                pingUserFragment.Y0().p(new g((m) aVar.a));
            }
        }

        public t<?> buildItemModel(int i, i0.e.b.a3.d.a<m> aVar) {
            if (aVar != null) {
                j jVar = new j();
                jVar.t(aVar.a.g.getId());
                UserInList userInList = aVar.a.g;
                jVar.w();
                jVar.j = userInList;
                boolean z = aVar.b;
                jVar.w();
                jVar.k = z;
                i0.e.b.g3.k.w0.b.a aVar2 = new i0.e.b.g3.k.w0.b.a(aVar, this.this$0);
                jVar.w();
                jVar.m = aVar2;
                i.d(jVar, "SelectableUser_()\n                .id(item.item.user.id)\n                .user(item.item.user)\n                .selected(item.selected)\n                .clickListener { _ ->\n                    if (!item.selected) {\n                        viewModel.processIntent(SelectUser(item.item))\n                    }\n                }");
                return jVar;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    /* compiled from: PingUserFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a extends BottomSheetBehavior.c {
        public a() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.c
        public void onSlide(View view, float f) {
            i.e(view, "bottomSheet");
            PingUserFragment.X0(PingUserFragment.this, view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.c
        public void onStateChanged(View view, int i) {
            i.e(view, "bottomSheet");
        }
    }

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class b extends h<PingUserFragment, PingUserViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public b(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<PingUserViewModel> a(PingUserFragment pingUserFragment, k kVar) {
            PingUserFragment pingUserFragment2 = pingUserFragment;
            i.e(pingUserFragment2, "thisRef");
            i.e(kVar, "property");
            return i0.b.b.g.a.b(pingUserFragment2, kVar, this.a, new PingUserFragment$special$$inlined$fragmentViewModel$default$2$1(this), m0.n.b.m.a(f.class), false, this.b);
        }
    }

    public PingUserFragment() {
        d a2 = m0.n.b.m.a(PingUserViewModel.class);
        this.t2 = new b(a2, false, new l<i0.b.b.k<PingUserViewModel, f>, PingUserViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.channels.users.ping.PingUserFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.clubhouse.android.ui.channels.users.ping.PingUserViewModel, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.l
            public PingUserViewModel invoke(i0.b.b.k<PingUserViewModel, f> kVar) {
                i0.b.b.k<PingUserViewModel, f> kVar2 = kVar;
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
        }, a2).a(this, r2[0]);
    }

    public static final void X0(PingUserFragment pingUserFragment, View view) {
        Objects.requireNonNull(pingUserFragment);
        Rect rect = new Rect();
        view.getLocalVisibleRect(rect);
        pingUserFragment.S0().b.setY((float) (rect.bottom - pingUserFragment.S0().b.getHeight()));
        pingUserFragment.S0().c.setY(pingUserFragment.S0().b.getY() - ((float) pingUserFragment.S0().c.getHeight()));
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(Y0(), new l<f, m0.i>() { // from class: com.clubhouse.android.ui.channels.users.ping.PingUserFragment$invalidate$1
            /* JADX WARN: Code restructure failed: missing block: B:25:0x00e9, code lost:
                if ((r9.length() == 0) != false) goto L_0x00ed;
             */
            /* JADX WARN: Removed duplicated region for block: B:21:0x00d1  */
            @Override // m0.n.a.l
            /* Code decompiled incorrectly, please refer to instructions dump */
            public m0.i invoke(f fVar) {
                boolean z;
                final f fVar2 = fVar;
                i.e(fVar2, "state");
                PingUserFragment pingUserFragment = PingUserFragment.this;
                k<Object>[] kVarArr = PingUserFragment.r2;
                pingUserFragment.S0().i.setText(PingUserFragment.this.getString(fVar2.a.T() ? R.string.invite_someone_into_closed : R.string.ping_sheet_title));
                PingUserFragment.this.S0().d.setText(PingUserFragment.this.getString(R.string.ping_search_empty));
                p viewLifecycleOwner = PingUserFragment.this.getViewLifecycleOwner();
                i.d(viewLifecycleOwner, "viewLifecycleOwner");
                LifecycleCoroutineScope a2 = q.a(viewLifecycleOwner);
                final PingUserFragment pingUserFragment2 = PingUserFragment.this;
                a.E2(a2, null, null, new m0.n.a.p<f0, m0.l.c<? super m0.i>, Object>(null) { // from class: com.clubhouse.android.ui.channels.users.ping.PingUserFragment$invalidate$1.1
                    public int c;

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final m0.l.c<m0.i> create(Object obj, m0.l.c<?> cVar) {
                        return 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0009: INVOKE  
                              (wrap: com.clubhouse.android.ui.channels.users.ping.PingUserViewModel : 0x0000: INVOKE  (r0v0 com.clubhouse.android.ui.channels.users.ping.PingUserViewModel A[REMOVE]) = (r2v0 'this' com.clubhouse.android.ui.channels.users.ping.PingUserFragment A[IMMUTABLE_TYPE, THIS]) type: VIRTUAL call: com.clubhouse.android.ui.channels.users.ping.PingUserFragment.Y0():com.clubhouse.android.ui.channels.users.ping.PingUserViewModel)
                              (wrap: com.clubhouse.android.ui.channels.users.ping.PingUserFragment$invalidate$1 : 0x0006: CONSTRUCTOR  (r1v0 com.clubhouse.android.ui.channels.users.ping.PingUserFragment$invalidate$1 A[REMOVE]) = (r2v0 'this' com.clubhouse.android.ui.channels.users.ping.PingUserFragment A[IMMUTABLE_TYPE, THIS]) call: com.clubhouse.android.ui.channels.users.ping.PingUserFragment$invalidate$1.<init>(com.clubhouse.android.ui.channels.users.ping.PingUserFragment):void type: CONSTRUCTOR)
                             type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: com.clubhouse.android.ui.channels.users.ping.PingUserFragment.J():void, file: classes3.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0058: INVOKE  
                              (r2v4 'a2' androidx.lifecycle.LifecycleCoroutineScope)
                              (null m0.l.e)
                              (null kotlinx.coroutines.CoroutineStart)
                              (wrap: com.clubhouse.android.ui.channels.users.ping.PingUserFragment$invalidate$1$1 : 0x0053: CONSTRUCTOR  (r5v0 com.clubhouse.android.ui.channels.users.ping.PingUserFragment$invalidate$1$1 A[REMOVE]) = 
                              (r0v9 'pingUserFragment2' com.clubhouse.android.ui.channels.users.ping.PingUserFragment A[DONT_INLINE, SKIP_ARG])
                              (r9v1 'fVar2' i0.e.b.g3.k.w0.b.f A[DONT_INLINE, SKIP_ARG])
                              (null m0.l.c)
                             call: com.clubhouse.android.ui.channels.users.ping.PingUserFragment$invalidate$1.1.<init>(com.clubhouse.android.ui.channels.users.ping.PingUserFragment, i0.e.b.g3.k.w0.b.f, m0.l.c):void type: CONSTRUCTOR)
                              (3 int)
                              (null java.lang.Object)
                             type: STATIC call: m0.r.t.a.r.m.a1.a.E2(n0.a.f0, m0.l.e, kotlinx.coroutines.CoroutineStart, m0.n.a.p, int, java.lang.Object):n0.a.f1 in method: com.clubhouse.android.ui.channels.users.ping.PingUserFragment$invalidate$1.invoke(i0.e.b.g3.k.w0.b.f):m0.i, file: classes3.dex
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
                              (wrap: com.clubhouse.android.ui.channels.users.ping.PingUserFragment$invalidate$1$1 : 0x0006: CONSTRUCTOR  (r3v1 com.clubhouse.android.ui.channels.users.ping.PingUserFragment$invalidate$1$1 A[REMOVE]) = 
                              (wrap: com.clubhouse.android.ui.channels.users.ping.PingUserFragment : 0x0002: IGET  (r0v0 com.clubhouse.android.ui.channels.users.ping.PingUserFragment A[REMOVE]) = (r2v0 'this' com.clubhouse.android.ui.channels.users.ping.PingUserFragment$invalidate$1$1 A[IMMUTABLE_TYPE, THIS]) com.clubhouse.android.ui.channels.users.ping.PingUserFragment$invalidate$1.1.d com.clubhouse.android.ui.channels.users.ping.PingUserFragment)
                              (wrap: i0.e.b.g3.k.w0.b.f : 0x0004: IGET  (r1v0 i0.e.b.g3.k.w0.b.f A[REMOVE]) = (r2v0 'this' com.clubhouse.android.ui.channels.users.ping.PingUserFragment$invalidate$1$1 A[IMMUTABLE_TYPE, THIS]) com.clubhouse.android.ui.channels.users.ping.PingUserFragment$invalidate$1.1.q i0.e.b.g3.k.w0.b.f)
                              (r4v0 'cVar' m0.l.c<?>)
                             call: com.clubhouse.android.ui.channels.users.ping.PingUserFragment$invalidate$1.1.<init>(com.clubhouse.android.ui.channels.users.ping.PingUserFragment, i0.e.b.g3.k.w0.b.f, m0.l.c):void type: CONSTRUCTOR)
                             in method: com.clubhouse.android.ui.channels.users.ping.PingUserFragment$invalidate$1.1.create(java.lang.Object, m0.l.c<?>):m0.l.c<m0.i>, file: classes3.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: com.clubhouse.android.ui.channels.users.ping.PingUserFragment$invalidate$1.1
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
                            com.clubhouse.android.ui.channels.users.ping.PingUserViewModel r0 = r2.Y0()
                            com.clubhouse.android.ui.channels.users.ping.PingUserFragment$invalidate$1 r1 = new com.clubhouse.android.ui.channels.users.ping.PingUserFragment$invalidate$1
                            r1.<init>()
                            h0.b0.v.v2(r0, r1)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.clubhouse.android.ui.channels.users.ping.PingUserFragment.J():void");
                    }

                    @Override // com.clubhouse.android.core.ui.BaseBottomSheetFragment
                    public BottomSheetBehavior.c Q0() {
                        return new a();
                    }

                    @Override // com.clubhouse.android.shared.ui.AbstractUserFragment
                    public PagingDataEpoxyController<i0.e.b.a3.d.a<m>> T0() {
                        return this.u2;
                    }

                    @Override // com.clubhouse.android.shared.ui.AbstractUserFragment
                    public void U0() {
                        S0().j.post(new Runnable() { // from class: i0.e.b.g3.k.w0.b.d
                            @Override // java.lang.Runnable
                            public final void run() {
                                PingUserFragment pingUserFragment = PingUserFragment.this;
                                k<Object>[] kVarArr = PingUserFragment.r2;
                                i.e(pingUserFragment, "this$0");
                                pingUserFragment.S0().j.setLayoutManager(new GridLayoutManager(pingUserFragment.getContext(), 12));
                                pingUserFragment.S0().j.requestLayout();
                            }
                        });
                    }

                    public final PingUserViewModel Y0() {
                        return (PingUserViewModel) this.t2.getValue();
                    }

                    @Override // com.clubhouse.android.shared.ui.AbstractUserFragment, com.clubhouse.android.core.ui.BaseBottomSheetFragment, androidx.fragment.app.Fragment
                    public void onViewCreated(View view, Bundle bundle) {
                        i.e(view, "view");
                        super.onViewCreated(view, bundle);
                        EditText editText = S0().h;
                        i.d(editText, "binding.search");
                        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(i0.e.b.d3.k.f(editText), new PingUserFragment$onViewCreated$1(this, null));
                        p viewLifecycleOwner = getViewLifecycleOwner();
                        i.d(viewLifecycleOwner, "viewLifecycleOwner");
                        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner));
                        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$12 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(Y0().l, new PingUserFragment$onViewCreated$2(this, null));
                        p viewLifecycleOwner2 = getViewLifecycleOwner();
                        i.d(viewLifecycleOwner2, "viewLifecycleOwner");
                        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$12, q.a(viewLifecycleOwner2));
                        S0().b.setLayoutManager(new GridLayoutManager(getContext(), 32));
                    }
                }
