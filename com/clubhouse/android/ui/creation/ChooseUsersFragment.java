package com.clubhouse.android.ui.creation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.recyclerview.widget.GridLayoutManager;
import com.airbnb.epoxy.paging3.PagingDataEpoxyController;
import com.clubhouse.android.data.models.local.user.UserInList;
import com.clubhouse.android.shared.ui.AbstractUserFragment;
import com.clubhouse.android.ui.creation.ChooseUsersFragment;
import com.clubhouse.app.R;
import h0.b0.v;
import h0.q.p;
import i0.b.a.t;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.e.b.b3.b.e.m;
import i0.e.b.g3.k.w0.b.j;
import i0.e.b.g3.n.q;
import i0.e.b.g3.n.w;
import java.util.List;
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
import n0.a.f1;
/* compiled from: ChooseUsersFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002\u001d\u001eB\u0007¢\u0006\u0004\b\u001c\u0010\fJ!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\fR.\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u000e8\u0014@\u0014X\u0094\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001b\u001a\u00020\u00168B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/clubhouse/android/ui/creation/ChooseUsersFragment;", "Lcom/clubhouse/android/shared/ui/AbstractUserFragment;", "Li0/e/b/a3/d/a;", "Li0/e/b/b3/b/e/m;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "U0", "()V", "J", "Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;", "t2", "Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;", "T0", "()Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;", "setPagedController", "(Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;)V", "pagedController", "Lcom/clubhouse/android/ui/creation/ChooseUsersViewModel;", "s2", "Lm0/c;", "X0", "()Lcom/clubhouse/android/ui/creation/ChooseUsersViewModel;", "viewModel", "<init>", "a", "UserController", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class ChooseUsersFragment extends AbstractUserFragment<i0.e.b.a3.d.a<m>> {
    public static final /* synthetic */ k<Object>[] r2 = {m0.n.b.m.c(new PropertyReference1Impl(m0.n.b.m.a(ChooseUsersFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/creation/ChooseUsersViewModel;"))};
    public final c s2;
    public PagingDataEpoxyController<i0.e.b.a3.d.a<m>> t2 = new UserController(this);

    /* compiled from: ChooseUsersFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/clubhouse/android/ui/creation/ChooseUsersFragment$UserController;", "Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;", "Li0/e/b/a3/d/a;", "Li0/e/b/b3/b/e/m;", "", "currentPosition", "item", "Li0/b/a/t;", "buildItemModel", "(ILi0/e/b/a3/d/a;)Li0/b/a/t;", "<init>", "(Lcom/clubhouse/android/ui/creation/ChooseUsersFragment;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public final class UserController extends PagingDataEpoxyController<i0.e.b.a3.d.a<m>> {
        public final /* synthetic */ ChooseUsersFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserController(ChooseUsersFragment chooseUsersFragment) {
            super(null, null, null, 7, null);
            i.e(chooseUsersFragment, "this$0");
            this.this$0 = chooseUsersFragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: buildItemModel$lambda-0  reason: not valid java name */
        public static final void m10buildItemModel$lambda0(ChooseUsersFragment chooseUsersFragment, i0.e.b.a3.d.a aVar, View view) {
            i.e(chooseUsersFragment, "this$0");
            k<Object>[] kVarArr = ChooseUsersFragment.r2;
            chooseUsersFragment.X0().p(new w((m) aVar.a));
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
                i0.e.b.g3.n.b bVar = new i0.e.b.g3.n.b(this.this$0, aVar);
                jVar.w();
                jVar.m = bVar;
                i.d(jVar, "SelectableUser_()\n                .id(item.item.user.id)\n                .user(item.item.user)\n                .selected(item.selected)\n                .clickListener { _ -> viewModel.processIntent(ToggleUser(item.item)) }");
                return jVar;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    /* compiled from: ChooseUsersFragment.kt */
    /* loaded from: classes3.dex */
    public interface a {
        void v(List<UserInList> list);
    }

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class b extends h<ChooseUsersFragment, ChooseUsersViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public b(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<ChooseUsersViewModel> a(ChooseUsersFragment chooseUsersFragment, k kVar) {
            ChooseUsersFragment chooseUsersFragment2 = chooseUsersFragment;
            i.e(chooseUsersFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(chooseUsersFragment2, kVar, this.a, new ChooseUsersFragment$special$$inlined$fragmentViewModel$default$2$1(this), m0.n.b.m.a(q.class), false, this.b);
        }
    }

    public ChooseUsersFragment() {
        d a2 = m0.n.b.m.a(ChooseUsersViewModel.class);
        this.s2 = new b(a2, false, new l<i0.b.b.k<ChooseUsersViewModel, q>, ChooseUsersViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.creation.ChooseUsersFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.airbnb.mvrx.MavericksViewModel, com.clubhouse.android.ui.creation.ChooseUsersViewModel] */
            @Override // m0.n.a.l
            public ChooseUsersViewModel invoke(i0.b.b.k<ChooseUsersViewModel, q> kVar) {
                i0.b.b.k<ChooseUsersViewModel, q> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, q.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, r2[0]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(X0(), new l<q, f1>() { // from class: com.clubhouse.android.ui.creation.ChooseUsersFragment$invalidate$1
            @Override // m0.n.a.l
            public f1 invoke(q qVar) {
                final q qVar2 = qVar;
                i.e(qVar2, "state");
                p viewLifecycleOwner = ChooseUsersFragment.this.getViewLifecycleOwner();
                i.d(viewLifecycleOwner, "viewLifecycleOwner");
                LifecycleCoroutineScope a2 = h0.q.q.a(viewLifecycleOwner);
                final ChooseUsersFragment chooseUsersFragment = ChooseUsersFragment.this;
                return a.E2(a2, null, null, new m0.n.a.p<f0, m0.l.c<? super m0.i>, Object>(null) { // from class: com.clubhouse.android.ui.creation.ChooseUsersFragment$invalidate$1.1
                    public int c;

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final m0.l.c<m0.i> create(Object obj, m0.l.c<?> cVar) {
                        return 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0009: INVOKE  
                              (wrap: com.clubhouse.android.ui.creation.ChooseUsersViewModel : 0x0000: INVOKE  (r0v0 com.clubhouse.android.ui.creation.ChooseUsersViewModel A[REMOVE]) = (r2v0 'this' com.clubhouse.android.ui.creation.ChooseUsersFragment A[IMMUTABLE_TYPE, THIS]) type: VIRTUAL call: com.clubhouse.android.ui.creation.ChooseUsersFragment.X0():com.clubhouse.android.ui.creation.ChooseUsersViewModel)
                              (wrap: com.clubhouse.android.ui.creation.ChooseUsersFragment$invalidate$1 : 0x0006: CONSTRUCTOR  (r1v0 com.clubhouse.android.ui.creation.ChooseUsersFragment$invalidate$1 A[REMOVE]) = (r2v0 'this' com.clubhouse.android.ui.creation.ChooseUsersFragment A[IMMUTABLE_TYPE, THIS]) call: com.clubhouse.android.ui.creation.ChooseUsersFragment$invalidate$1.<init>(com.clubhouse.android.ui.creation.ChooseUsersFragment):void type: CONSTRUCTOR)
                             type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: com.clubhouse.android.ui.creation.ChooseUsersFragment.J():void, file: classes3.dex
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
                              (wrap: com.clubhouse.android.ui.creation.ChooseUsersFragment$invalidate$1$1 : 0x001b: CONSTRUCTOR  (r5v0 com.clubhouse.android.ui.creation.ChooseUsersFragment$invalidate$1$1 A[REMOVE]) = 
                              (r0v3 'chooseUsersFragment' com.clubhouse.android.ui.creation.ChooseUsersFragment A[DONT_INLINE, SKIP_ARG])
                              (r9v1 'qVar2' i0.e.b.g3.n.q A[DONT_INLINE, SKIP_ARG])
                              (null m0.l.c)
                             call: com.clubhouse.android.ui.creation.ChooseUsersFragment$invalidate$1.1.<init>(com.clubhouse.android.ui.creation.ChooseUsersFragment, i0.e.b.g3.n.q, m0.l.c):void type: CONSTRUCTOR)
                              (3 int)
                              (null java.lang.Object)
                             type: STATIC call: m0.r.t.a.r.m.a1.a.E2(n0.a.f0, m0.l.e, kotlinx.coroutines.CoroutineStart, m0.n.a.p, int, java.lang.Object):n0.a.f1)
                             in method: com.clubhouse.android.ui.creation.ChooseUsersFragment$invalidate$1.invoke(i0.e.b.g3.n.q):n0.a.f1, file: classes3.dex
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
                              (wrap: com.clubhouse.android.ui.creation.ChooseUsersFragment$invalidate$1$1 : 0x0006: CONSTRUCTOR  (r3v1 com.clubhouse.android.ui.creation.ChooseUsersFragment$invalidate$1$1 A[REMOVE]) = 
                              (wrap: com.clubhouse.android.ui.creation.ChooseUsersFragment : 0x0002: IGET  (r0v0 com.clubhouse.android.ui.creation.ChooseUsersFragment A[REMOVE]) = (r2v0 'this' com.clubhouse.android.ui.creation.ChooseUsersFragment$invalidate$1$1 A[IMMUTABLE_TYPE, THIS]) com.clubhouse.android.ui.creation.ChooseUsersFragment$invalidate$1.1.d com.clubhouse.android.ui.creation.ChooseUsersFragment)
                              (wrap: i0.e.b.g3.n.q : 0x0004: IGET  (r1v0 i0.e.b.g3.n.q A[REMOVE]) = (r2v0 'this' com.clubhouse.android.ui.creation.ChooseUsersFragment$invalidate$1$1 A[IMMUTABLE_TYPE, THIS]) com.clubhouse.android.ui.creation.ChooseUsersFragment$invalidate$1.1.q i0.e.b.g3.n.q)
                              (r4v0 'cVar' m0.l.c<?>)
                             call: com.clubhouse.android.ui.creation.ChooseUsersFragment$invalidate$1.1.<init>(com.clubhouse.android.ui.creation.ChooseUsersFragment, i0.e.b.g3.n.q, m0.l.c):void type: CONSTRUCTOR)
                             in method: com.clubhouse.android.ui.creation.ChooseUsersFragment$invalidate$1.1.create(java.lang.Object, m0.l.c<?>):m0.l.c<m0.i>, file: classes3.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: com.clubhouse.android.ui.creation.ChooseUsersFragment$invalidate$1.1
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
                            com.clubhouse.android.ui.creation.ChooseUsersViewModel r0 = r2.X0()
                            com.clubhouse.android.ui.creation.ChooseUsersFragment$invalidate$1 r1 = new com.clubhouse.android.ui.creation.ChooseUsersFragment$invalidate$1
                            r1.<init>()
                            h0.b0.v.v2(r0, r1)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.clubhouse.android.ui.creation.ChooseUsersFragment.J():void");
                    }

                    @Override // com.clubhouse.android.shared.ui.AbstractUserFragment
                    public PagingDataEpoxyController<i0.e.b.a3.d.a<m>> T0() {
                        return this.t2;
                    }

                    @Override // com.clubhouse.android.shared.ui.AbstractUserFragment
                    public void U0() {
                        S0().j.post(new Runnable() { // from class: i0.e.b.g3.n.c
                            @Override // java.lang.Runnable
                            public final void run() {
                                ChooseUsersFragment chooseUsersFragment = ChooseUsersFragment.this;
                                k<Object>[] kVarArr = ChooseUsersFragment.r2;
                                i.e(chooseUsersFragment, "this$0");
                                chooseUsersFragment.S0().j.setLayoutManager(new GridLayoutManager(chooseUsersFragment.getContext(), 12));
                                chooseUsersFragment.S0().j.requestLayout();
                            }
                        });
                    }

                    public final ChooseUsersViewModel X0() {
                        return (ChooseUsersViewModel) this.s2.getValue();
                    }

                    @Override // com.clubhouse.android.shared.ui.AbstractUserFragment, com.clubhouse.android.core.ui.BaseBottomSheetFragment, androidx.fragment.app.Fragment
                    public void onViewCreated(View view, Bundle bundle) {
                        i.e(view, "view");
                        super.onViewCreated(view, bundle);
                        EditText editText = S0().h;
                        i.d(editText, "binding.search");
                        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(i0.e.b.d3.k.f(editText), new ChooseUsersFragment$onViewCreated$1(this, null));
                        p viewLifecycleOwner = getViewLifecycleOwner();
                        i.d(viewLifecycleOwner, "viewLifecycleOwner");
                        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, h0.q.q.a(viewLifecycleOwner));
                        S0().i.setText(getString(R.string.choose_users_sheet_title));
                        S0().d.setText(getString(R.string.search_room_empty));
                        Button button = S0().a;
                        i.d(button, "binding.actionButton");
                        i0.e.b.d3.k.K(button);
                        S0().a.setText(getString(R.string.choose_users_done));
                        S0().a.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.n.a
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                ChooseUsersFragment chooseUsersFragment = ChooseUsersFragment.this;
                                k<Object>[] kVarArr = ChooseUsersFragment.r2;
                                i.e(chooseUsersFragment, "this$0");
                                if (chooseUsersFragment.getParentFragment() instanceof ChooseUsersFragment.a) {
                                    v.v2(chooseUsersFragment.X0(), 
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001a: INVOKE  
                                          (wrap: com.clubhouse.android.ui.creation.ChooseUsersViewModel : 0x0011: INVOKE  (r0v4 com.clubhouse.android.ui.creation.ChooseUsersViewModel A[REMOVE]) = (r3v1 'chooseUsersFragment' com.clubhouse.android.ui.creation.ChooseUsersFragment) type: VIRTUAL call: com.clubhouse.android.ui.creation.ChooseUsersFragment.X0():com.clubhouse.android.ui.creation.ChooseUsersViewModel)
                                          (wrap: com.clubhouse.android.ui.creation.ChooseUsersFragment$onViewCreated$2$1 : 0x0017: CONSTRUCTOR  (r1v0 com.clubhouse.android.ui.creation.ChooseUsersFragment$onViewCreated$2$1 A[REMOVE]) = (r3v1 'chooseUsersFragment' com.clubhouse.android.ui.creation.ChooseUsersFragment) call: com.clubhouse.android.ui.creation.ChooseUsersFragment$onViewCreated$2$1.<init>(com.clubhouse.android.ui.creation.ChooseUsersFragment):void type: CONSTRUCTOR)
                                         type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: i0.e.b.g3.n.a.onClick(android.view.View):void, file: classes3.dex
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
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:270)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.creation.ChooseUsersFragment$onViewCreated$2$1, state: NOT_LOADED
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
                                        	... 21 more
                                        */
                                    /*
                                        this = this;
                                        com.clubhouse.android.ui.creation.ChooseUsersFragment r3 = com.clubhouse.android.ui.creation.ChooseUsersFragment.this
                                        m0.r.k<java.lang.Object>[] r0 = com.clubhouse.android.ui.creation.ChooseUsersFragment.r2
                                        java.lang.String r0 = "this$0"
                                        m0.n.b.i.e(r3, r0)
                                        androidx.fragment.app.Fragment r0 = r3.getParentFragment()
                                        boolean r0 = r0 instanceof com.clubhouse.android.ui.creation.ChooseUsersFragment.a
                                        if (r0 == 0) goto L_0x001d
                                        com.clubhouse.android.ui.creation.ChooseUsersViewModel r0 = r3.X0()
                                        com.clubhouse.android.ui.creation.ChooseUsersFragment$onViewCreated$2$1 r1 = new com.clubhouse.android.ui.creation.ChooseUsersFragment$onViewCreated$2$1
                                        r1.<init>(r3)
                                        h0.b0.v.v2(r0, r1)
                                    L_0x001d:
                                        r3.dismiss()
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.n.a.onClick(android.view.View):void");
                                }
                            });
                        }
                    }
