package com.clubhouse.android.ui.actionsheet;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.airbnb.epoxy.EpoxyRecyclerView;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.core.ui.R;
import com.clubhouse.core.ui.databinding.FragmentActionSheetBinding;
import h0.b0.v;
import i0.b.a.o;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.e.b.g3.i.a;
import i0.e.b.g3.i.f;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.PropertyReference1Impl;
import m0.c;
import m0.i;
import m0.n.a.l;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
/* compiled from: ActionSheetFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010\u000eJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0014\u001a\u00020\u000f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R(\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR(\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001d\u0010+\u001a\u00020&8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/clubhouse/android/ui/actionsheet/ActionSheetFragment;", "Lcom/clubhouse/android/core/ui/BaseBottomSheetFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/DialogInterface;", "dialog", "onCancel", "(Landroid/content/DialogInterface;)V", "J", "()V", "Lcom/clubhouse/core/ui/databinding/FragmentActionSheetBinding;", "r2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "getBinding", "()Lcom/clubhouse/core/ui/databinding/FragmentActionSheetBinding;", "binding", "", "Li0/e/b/g3/i/c;", "s2", "Ljava/util/List;", "getActions$core_ui_release", "()Ljava/util/List;", "setActions$core_ui_release", "(Ljava/util/List;)V", "actions", "Lkotlin/Function0;", "t2", "Lm0/n/a/a;", "getCancelListener$core_ui_release", "()Lm0/n/a/a;", "setCancelListener$core_ui_release", "(Lm0/n/a/a;)V", "cancelListener", "Lcom/clubhouse/android/ui/actionsheet/ActionSheetViewModel;", "q2", "Lm0/c;", "V0", "()Lcom/clubhouse/android/ui/actionsheet/ActionSheetViewModel;", "viewModel", "<init>", "core-ui_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class ActionSheetFragment extends Hilt_ActionSheetFragment {
    public static final /* synthetic */ k<Object>[] p2 = {m.c(new PropertyReference1Impl(m.a(ActionSheetFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/actionsheet/ActionSheetViewModel;")), m.c(new PropertyReference1Impl(m.a(ActionSheetFragment.class), "binding", "getBinding()Lcom/clubhouse/core/ui/databinding/FragmentActionSheetBinding;"))};
    public final c q2;
    public final FragmentViewBindingDelegate r2 = new FragmentViewBindingDelegate(FragmentActionSheetBinding.class, this);
    public List<i0.e.b.g3.i.c> s2 = EmptyList.c;
    public m0.n.a.a<i> t2 = ActionSheetFragment$cancelListener$1.c;

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<ActionSheetFragment, ActionSheetViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<ActionSheetViewModel> a(ActionSheetFragment actionSheetFragment, k kVar) {
            ActionSheetFragment actionSheetFragment2 = actionSheetFragment;
            m0.n.b.i.e(actionSheetFragment2, "thisRef");
            m0.n.b.i.e(kVar, "property");
            return g.a.b(actionSheetFragment2, kVar, this.a, new ActionSheetFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(i0.e.b.g3.i.h.class), false, this.b);
        }
    }

    public ActionSheetFragment() {
        super(R.layout.fragment_action_sheet);
        d a2 = m.a(ActionSheetViewModel.class);
        this.q2 = new a(a2, false, new l<i0.b.b.k<ActionSheetViewModel, i0.e.b.g3.i.h>, ActionSheetViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.actionsheet.ActionSheetFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.airbnb.mvrx.MavericksViewModel, com.clubhouse.android.ui.actionsheet.ActionSheetViewModel] */
            @Override // m0.n.a.l
            public ActionSheetViewModel invoke(i0.b.b.k<ActionSheetViewModel, i0.e.b.g3.i.h> kVar) {
                i0.b.b.k<ActionSheetViewModel, i0.e.b.g3.i.h> kVar2 = kVar;
                m0.n.b.i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                m0.n.b.i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                m0.n.b.i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, i0.e.b.g3.i.h.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, p2[0]);
    }

    public static final FragmentActionSheetBinding U0(ActionSheetFragment actionSheetFragment) {
        return (FragmentActionSheetBinding) actionSheetFragment.r2.getValue(actionSheetFragment, p2[1]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(V0(), new l<i0.e.b.g3.i.h, i>() { // from class: com.clubhouse.android.ui.actionsheet.ActionSheetFragment$invalidate$1
            @Override // m0.n.a.l
            public i invoke(i0.e.b.g3.i.h hVar) {
                i0.e.b.g3.i.h hVar2 = hVar;
                m0.n.b.i.e(hVar2, "state");
                String str = hVar2.a;
                if (str != null) {
                    ActionSheetFragment actionSheetFragment = ActionSheetFragment.this;
                    ActionSheetFragment.U0(actionSheetFragment).c.setText(str);
                    ActionSheetFragment.U0(actionSheetFragment).c.setVisibility(0);
                }
                String str2 = hVar2.b;
                if (str2 != null) {
                    ActionSheetFragment actionSheetFragment2 = ActionSheetFragment.this;
                    ActionSheetFragment.U0(actionSheetFragment2).b.setText(str2);
                    ActionSheetFragment.U0(actionSheetFragment2).b.setVisibility(0);
                }
                ActionSheetFragment.U0(ActionSheetFragment.this).a.g();
                return i.a;
            }
        });
    }

    public final ActionSheetViewModel V0() {
        return (ActionSheetViewModel) this.q2.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        m0.n.b.i.e(dialogInterface, "dialog");
        this.t2.invoke();
    }

    @Override // com.clubhouse.android.core.ui.BaseBottomSheetFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Object obj;
        m0.n.b.i.e(view, "view");
        super.onViewCreated(view, bundle);
        if (this.s2.isEmpty()) {
            I0();
            return;
        }
        v.U1(this);
        Iterator<T> it = this.s2.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((i0.e.b.g3.i.c) obj).f) {
                break;
            }
        }
        i0.e.b.g3.i.c cVar = (i0.e.b.g3.i.c) obj;
        if (cVar != null) {
            V0().p(new i0.e.b.g3.i.i(cVar));
        }
        EpoxyRecyclerView epoxyRecyclerView = ((FragmentActionSheetBinding) this.r2.getValue(this, p2[1])).a;
        m0.n.b.i.d(epoxyRecyclerView, "binding.actionList");
        i0.e.b.d3.k.E(epoxyRecyclerView, new l<o, i>(view) { // from class: com.clubhouse.android.ui.actionsheet.ActionSheetFragment$onViewCreated$3
            public final /* synthetic */ View d;

            {
                this.d = r2;
            }

            @Override // m0.n.a.l
            public i invoke(o oVar) {
                final o oVar2 = oVar;
                m0.n.b.i.e(oVar2, "$this$safeWithModels");
                ActionSheetFragment actionSheetFragment = ActionSheetFragment.this;
                k<Object>[] kVarArr = ActionSheetFragment.p2;
                ActionSheetViewModel V0 = actionSheetFragment.V0();
                final ActionSheetFragment actionSheetFragment2 = ActionSheetFragment.this;
                final View view2 = this.d;
                v.v2(V0, new l<i0.e.b.g3.i.h, i>() { // from class: com.clubhouse.android.ui.actionsheet.ActionSheetFragment$onViewCreated$3.1
                    @Override // m0.n.a.l
                    public i invoke(i0.e.b.g3.i.h hVar) {
                        i0.e.b.g3.i.h hVar2 = hVar;
                        m0.n.b.i.e(hVar2, "state");
                        ActionSheetFragment actionSheetFragment3 = ActionSheetFragment.this;
                        List<i0.e.b.g3.i.c> list = actionSheetFragment3.s2;
                        o oVar3 = oVar2;
                        View view3 = view2;
                        for (i0.e.b.g3.i.c cVar2 : list) {
                            f fVar = new f();
                            fVar.M(cVar2.d);
                            fVar.L(cVar2);
                            fVar.O(m0.n.b.i.a(cVar2, hVar2.d));
                            fVar.N(new a(actionSheetFragment3, cVar2, view3));
                            oVar3.add(fVar);
                        }
                        return i.a;
                    }
                });
                return i.a;
            }
        });
    }
}
