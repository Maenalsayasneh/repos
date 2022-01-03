package com.clubhouse.android.ui.clubs.rules;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.clubhouse.android.data.models.local.club.ClubRule;
import com.clubhouse.android.databinding.ClubRuleTitleDescriptionBinding;
import com.clubhouse.android.databinding.FragmentEditClubRulesBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.ui.clubs.rules.EditClubRulesFragment;
import com.clubhouse.app.R;
import h0.b0.v;
import h0.q.p;
import h0.q.q;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.i;
import i0.b.b.x;
import i0.e.b.g3.l.b3.e;
import i0.e.b.g3.l.b3.f;
import i0.e.b.g3.l.b3.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.c;
import m0.n.a.l;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
/* compiled from: EditClubRulesFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b)\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000f\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001c\u001a\u00020\u00178B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\"\u001a\u00020\u001d8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010(\u001a\u00020#8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/clubhouse/android/ui/clubs/rules/EditClubRulesFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lcom/clubhouse/android/data/models/local/club/ClubRule;", "rule", "Lcom/clubhouse/android/databinding/ClubRuleTitleDescriptionBinding;", "ruleBinding", "Q0", "(Lcom/clubhouse/android/data/models/local/club/ClubRule;Lcom/clubhouse/android/databinding/ClubRuleTitleDescriptionBinding;)V", "Landroid/widget/TextView;", "clubExplanationRemainingView", "", "explanation", "R0", "(Landroid/widget/TextView;Ljava/lang/String;)V", "Lcom/clubhouse/android/ui/clubs/rules/EditClubRulesViewModel;", "a2", "Lm0/c;", "P0", "()Lcom/clubhouse/android/ui/clubs/rules/EditClubRulesViewModel;", "viewModel", "Lcom/clubhouse/android/ui/clubs/rules/EditClubRulesArgs;", "c2", "Lm0/o/c;", "N0", "()Lcom/clubhouse/android/ui/clubs/rules/EditClubRulesArgs;", "args", "Lcom/clubhouse/android/databinding/FragmentEditClubRulesBinding;", "b2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "O0", "()Lcom/clubhouse/android/databinding/FragmentEditClubRulesBinding;", "binding", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class EditClubRulesFragment extends Hilt_EditClubRulesFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(EditClubRulesFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/clubs/rules/EditClubRulesViewModel;")), m.c(new PropertyReference1Impl(m.a(EditClubRulesFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentEditClubRulesBinding;")), m.c(new PropertyReference1Impl(m.a(EditClubRulesFragment.class), "args", "getArgs()Lcom/clubhouse/android/ui/clubs/rules/EditClubRulesArgs;"))};
    public final c a2;
    public final FragmentViewBindingDelegate b2 = new FragmentViewBindingDelegate(FragmentEditClubRulesBinding.class, this);
    public final m0.o.c c2 = new i();

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<EditClubRulesFragment, EditClubRulesViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<EditClubRulesViewModel> a(EditClubRulesFragment editClubRulesFragment, k kVar) {
            EditClubRulesFragment editClubRulesFragment2 = editClubRulesFragment;
            m0.n.b.i.e(editClubRulesFragment2, "thisRef");
            m0.n.b.i.e(kVar, "property");
            return g.a.b(editClubRulesFragment2, kVar, this.a, new EditClubRulesFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(j.class), false, this.b);
        }
    }

    public EditClubRulesFragment() {
        super(R.layout.fragment_edit_club_rules);
        d a2 = m.a(EditClubRulesViewModel.class);
        this.a2 = new a(a2, false, new l<i0.b.b.k<EditClubRulesViewModel, j>, EditClubRulesViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.clubs.rules.EditClubRulesFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.airbnb.mvrx.MavericksViewModel, com.clubhouse.android.ui.clubs.rules.EditClubRulesViewModel] */
            @Override // m0.n.a.l
            public EditClubRulesViewModel invoke(i0.b.b.k<EditClubRulesViewModel, j> kVar) {
                i0.b.b.k<EditClubRulesViewModel, j> kVar2 = kVar;
                m0.n.b.i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                m0.n.b.i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                m0.n.b.i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, j.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, Z1[0]);
    }

    @Override // i0.b.b.q
    public void J() {
    }

    public final EditClubRulesArgs N0() {
        return (EditClubRulesArgs) this.c2.getValue(this, Z1[2]);
    }

    public final FragmentEditClubRulesBinding O0() {
        return (FragmentEditClubRulesBinding) this.b2.getValue(this, Z1[1]);
    }

    public final EditClubRulesViewModel P0() {
        return (EditClubRulesViewModel) this.a2.getValue();
    }

    public final void Q0(ClubRule clubRule, ClubRuleTitleDescriptionBinding clubRuleTitleDescriptionBinding) {
        m0.i iVar;
        if (clubRule == null) {
            iVar = null;
        } else {
            clubRuleTitleDescriptionBinding.c.setText(clubRule.c);
            clubRuleTitleDescriptionBinding.a.setText(clubRule.d);
            TextView textView = clubRuleTitleDescriptionBinding.b;
            m0.n.b.i.d(textView, "ruleBinding.remaining");
            R0(textView, clubRule.d);
            iVar = m0.i.a;
        }
        if (iVar == null) {
            TextView textView2 = clubRuleTitleDescriptionBinding.b;
            m0.n.b.i.d(textView2, "ruleBinding.remaining");
            R0(textView2, "");
        }
    }

    public final void R0(TextView textView, String str) {
        int integer = getResources().getInteger(R.integer.max_club_rule_description_length) - str.length();
        textView.setText(getResources().getQuantityString(R.plurals.characters_remaining, integer, Integer.valueOf(integer)));
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        ClubRule clubRule;
        ClubRule clubRule2;
        m0.n.b.i.e(view, "view");
        super.onViewCreated(view, bundle);
        ClubRule clubRule3 = null;
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(P0().l, new EditClubRulesFragment$onViewCreated$1(this, null));
        p viewLifecycleOwner = getViewLifecycleOwner();
        m0.n.b.i.d(viewLifecycleOwner, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner));
        O0().a.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.l.b3.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EditClubRulesFragment editClubRulesFragment = EditClubRulesFragment.this;
                k<Object>[] kVarArr = EditClubRulesFragment.Z1;
                m0.n.b.i.e(editClubRulesFragment, "this$0");
                v.c1(editClubRulesFragment);
            }
        });
        O0().f.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.l.b3.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EditClubRulesFragment editClubRulesFragment = EditClubRulesFragment.this;
                k<Object>[] kVarArr = EditClubRulesFragment.Z1;
                m0.n.b.i.e(editClubRulesFragment, "this$0");
                editClubRulesFragment.P0().p(k.a);
            }
        });
        O0().e.setText(getString(R.string.club_rules_message, N0().c));
        EditText editText = O0().b.a;
        m0.n.b.i.d(editText, "binding.clubRuleOne.description");
        i0.e.b.d3.k.g(editText);
        EditText editText2 = O0().d.a;
        m0.n.b.i.d(editText2, "binding.clubRuleTwo.description");
        i0.e.b.d3.k.g(editText2);
        EditText editText3 = O0().c.a;
        m0.n.b.i.d(editText3, "binding.clubRuleThree.description");
        i0.e.b.d3.k.g(editText3);
        List<ClubRule> list = N0().d;
        if (list == null) {
            clubRule = null;
        } else {
            clubRule = (ClubRule) m0.j.g.z(list, 0);
        }
        ClubRuleTitleDescriptionBinding clubRuleTitleDescriptionBinding = O0().b;
        m0.n.b.i.d(clubRuleTitleDescriptionBinding, "binding.clubRuleOne");
        Q0(clubRule, clubRuleTitleDescriptionBinding);
        EditText editText4 = O0().b.c;
        m0.n.b.i.d(editText4, "binding.clubRuleOne.title");
        editText4.addTextChangedListener(new i0.e.b.g3.l.b3.c(this));
        EditText editText5 = O0().b.a;
        m0.n.b.i.d(editText5, "binding.clubRuleOne.description");
        editText5.addTextChangedListener(new i0.e.b.g3.l.b3.d(this));
        List<ClubRule> list2 = N0().d;
        if (list2 == null) {
            clubRule2 = null;
        } else {
            clubRule2 = (ClubRule) m0.j.g.z(list2, 1);
        }
        ClubRuleTitleDescriptionBinding clubRuleTitleDescriptionBinding2 = O0().d;
        m0.n.b.i.d(clubRuleTitleDescriptionBinding2, "binding.clubRuleTwo");
        Q0(clubRule2, clubRuleTitleDescriptionBinding2);
        EditText editText6 = O0().d.c;
        m0.n.b.i.d(editText6, "binding.clubRuleTwo.title");
        editText6.addTextChangedListener(new i0.e.b.g3.l.b3.g(this));
        EditText editText7 = O0().d.a;
        m0.n.b.i.d(editText7, "binding.clubRuleTwo.description");
        editText7.addTextChangedListener(new i0.e.b.g3.l.b3.h(this));
        List<ClubRule> list3 = N0().d;
        if (list3 != null) {
            clubRule3 = (ClubRule) m0.j.g.z(list3, 2);
        }
        ClubRuleTitleDescriptionBinding clubRuleTitleDescriptionBinding3 = O0().c;
        m0.n.b.i.d(clubRuleTitleDescriptionBinding3, "binding.clubRuleThree");
        Q0(clubRule3, clubRuleTitleDescriptionBinding3);
        EditText editText8 = O0().c.c;
        m0.n.b.i.d(editText8, "binding.clubRuleThree.title");
        editText8.addTextChangedListener(new e(this));
        EditText editText9 = O0().c.a;
        m0.n.b.i.d(editText9, "binding.clubRuleThree.description");
        editText9.addTextChangedListener(new f(this));
    }
}
