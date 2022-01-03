package com.clubhouse.android.ui.selection;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.airbnb.epoxy.EpoxyRecyclerView;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.ui.selection.SelectionFragment;
import com.clubhouse.core.ui.R;
import com.clubhouse.core.ui.databinding.FragmentSelectionBinding;
import h0.b0.v;
import i0.b.a.o;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.e.b.g3.x.f;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import m0.c;
import m0.n.a.l;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
/* compiled from: SelectionFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u00020\u000b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0016\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/clubhouse/android/ui/selection/SelectionFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lcom/clubhouse/android/ui/selection/SelectionViewModel;", "b2", "Lm0/c;", "O0", "()Lcom/clubhouse/android/ui/selection/SelectionViewModel;", "viewModel", "Lcom/clubhouse/core/ui/databinding/FragmentSelectionBinding;", "a2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "N0", "()Lcom/clubhouse/core/ui/databinding/FragmentSelectionBinding;", "binding", "<init>", "core-ui_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class SelectionFragment extends Hilt_SelectionFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(SelectionFragment.class), "binding", "getBinding()Lcom/clubhouse/core/ui/databinding/FragmentSelectionBinding;")), m.c(new PropertyReference1Impl(m.a(SelectionFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/selection/SelectionViewModel;"))};
    public final FragmentViewBindingDelegate a2 = new FragmentViewBindingDelegate(FragmentSelectionBinding.class, this);
    public final c b2;

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<SelectionFragment, SelectionViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<SelectionViewModel> a(SelectionFragment selectionFragment, k kVar) {
            SelectionFragment selectionFragment2 = selectionFragment;
            i.e(selectionFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(selectionFragment2, kVar, this.a, new SelectionFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(f.class), false, this.b);
        }
    }

    public SelectionFragment() {
        super(R.layout.fragment_selection);
        d a2 = m.a(SelectionViewModel.class);
        this.b2 = new a(a2, false, new l<i0.b.b.k<SelectionViewModel, f>, SelectionViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.selection.SelectionFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.clubhouse.android.ui.selection.SelectionViewModel, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.l
            public SelectionViewModel invoke(i0.b.b.k<SelectionViewModel, f> kVar) {
                i0.b.b.k<SelectionViewModel, f> kVar2 = kVar;
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
        v.v2(O0(), new l<f, m0.i>() { // from class: com.clubhouse.android.ui.selection.SelectionFragment$invalidate$1
            @Override // m0.n.a.l
            public m0.i invoke(f fVar) {
                f fVar2 = fVar;
                i.e(fVar2, "state");
                SelectionFragment selectionFragment = SelectionFragment.this;
                k<Object>[] kVarArr = SelectionFragment.Z1;
                selectionFragment.N0().d.g();
                String str = fVar2.a;
                if (str != null) {
                    SelectionFragment.this.N0().g.setText(str);
                }
                String str2 = fVar2.d;
                if (str2 != null) {
                    SelectionFragment selectionFragment2 = SelectionFragment.this;
                    selectionFragment2.N0().f.setText(str2);
                    TextView textView = selectionFragment2.N0().f;
                    i.d(textView, "binding.selectionListHeader");
                    i0.e.b.d3.k.K(textView);
                }
                String str3 = fVar2.e;
                if (str3 == null) {
                    return null;
                }
                SelectionFragment selectionFragment3 = SelectionFragment.this;
                selectionFragment3.N0().e.setText(str3);
                TextView textView2 = selectionFragment3.N0().e;
                i.d(textView2, "binding.selectionListFooter");
                i0.e.b.d3.k.K(textView2);
                return m0.i.a;
            }
        });
    }

    public final FragmentSelectionBinding N0() {
        return (FragmentSelectionBinding) this.a2.getValue(this, Z1[0]);
    }

    public final SelectionViewModel O0() {
        return (SelectionViewModel) this.b2.getValue();
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.e(view, "view");
        super.onViewCreated(view, bundle);
        N0().a.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.x.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SelectionFragment selectionFragment = SelectionFragment.this;
                k<Object>[] kVarArr = SelectionFragment.Z1;
                i.e(selectionFragment, "this$0");
                v.c1(selectionFragment);
            }
        });
        N0().d.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        EpoxyRecyclerView epoxyRecyclerView = N0().d;
        i.d(epoxyRecyclerView, "binding.selectionList");
        i0.e.b.d3.k.E(epoxyRecyclerView, new l<o, m0.i>() { // from class: com.clubhouse.android.ui.selection.SelectionFragment$initSelection$1
            @Override // m0.n.a.l
            public m0.i invoke(o oVar) {
                o oVar2 = oVar;
                i.e(oVar2, "$this$safeWithModels");
                SelectionFragment selectionFragment = SelectionFragment.this;
                k<Object>[] kVarArr = SelectionFragment.Z1;
                v.v2(selectionFragment.O0(), 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0014: INVOKE  
                      (wrap: com.clubhouse.android.ui.selection.SelectionViewModel : 0x000b: INVOKE  (r1v1 com.clubhouse.android.ui.selection.SelectionViewModel A[REMOVE]) = (r0v1 'selectionFragment' com.clubhouse.android.ui.selection.SelectionFragment) type: VIRTUAL call: com.clubhouse.android.ui.selection.SelectionFragment.O0():com.clubhouse.android.ui.selection.SelectionViewModel)
                      (wrap: com.clubhouse.android.ui.selection.SelectionFragment$buildSelectableModels$1 : 0x0011: CONSTRUCTOR  (r2v0 com.clubhouse.android.ui.selection.SelectionFragment$buildSelectableModels$1 A[REMOVE]) = (r4v1 'oVar2' i0.b.a.o), (r0v1 'selectionFragment' com.clubhouse.android.ui.selection.SelectionFragment) call: com.clubhouse.android.ui.selection.SelectionFragment$buildSelectableModels$1.<init>(i0.b.a.o, com.clubhouse.android.ui.selection.SelectionFragment):void type: CONSTRUCTOR)
                     type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: com.clubhouse.android.ui.selection.SelectionFragment$initSelection$1.invoke(i0.b.a.o):m0.i, file: classes3.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.selection.SelectionFragment$buildSelectableModels$1, state: NOT_LOADED
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
                    java.lang.String r0 = "$this$safeWithModels"
                    m0.n.b.i.e(r4, r0)
                    com.clubhouse.android.ui.selection.SelectionFragment r0 = com.clubhouse.android.ui.selection.SelectionFragment.this
                    m0.r.k<java.lang.Object>[] r1 = com.clubhouse.android.ui.selection.SelectionFragment.Z1
                    com.clubhouse.android.ui.selection.SelectionViewModel r1 = r0.O0()
                    com.clubhouse.android.ui.selection.SelectionFragment$buildSelectableModels$1 r2 = new com.clubhouse.android.ui.selection.SelectionFragment$buildSelectableModels$1
                    r2.<init>(r4, r0)
                    h0.b0.v.v2(r1, r2)
                    m0.i r4 = m0.i.a
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.clubhouse.android.ui.selection.SelectionFragment$initSelection$1.invoke(java.lang.Object):java.lang.Object");
            }
        });
    }
}
