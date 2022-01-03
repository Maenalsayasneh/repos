package com.clubhouse.android.ui.profile.settings;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import androidx.fragment.app.Fragment;
import com.clubhouse.android.databinding.FragmentNotificationSettingsBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.ui.profile.settings.NotificationSettingsFragment;
import com.clubhouse.app.R;
import com.google.android.material.switchmaterial.SwitchMaterial;
import h0.b0.v;
import h0.q.p;
import h0.q.q;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.e.b.g3.u.z5.y0;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.c;
import m0.n.a.l;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
/* compiled from: NotificationSettingsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u00020\u000b8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0016\u001a\u00020\u00118F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/clubhouse/android/ui/profile/settings/NotificationSettingsFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lcom/clubhouse/android/ui/profile/settings/NotificationSettingsViewModel;", "b2", "Lm0/c;", "O0", "()Lcom/clubhouse/android/ui/profile/settings/NotificationSettingsViewModel;", "viewModel", "Lcom/clubhouse/android/databinding/FragmentNotificationSettingsBinding;", "a2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "N0", "()Lcom/clubhouse/android/databinding/FragmentNotificationSettingsBinding;", "binding", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class NotificationSettingsFragment extends Hilt_NotificationSettingsFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(NotificationSettingsFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentNotificationSettingsBinding;")), m.c(new PropertyReference1Impl(m.a(NotificationSettingsFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/profile/settings/NotificationSettingsViewModel;"))};
    public final FragmentViewBindingDelegate a2 = new FragmentViewBindingDelegate(FragmentNotificationSettingsBinding.class, this);
    public final c b2;

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<NotificationSettingsFragment, NotificationSettingsViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<NotificationSettingsViewModel> a(NotificationSettingsFragment notificationSettingsFragment, k kVar) {
            NotificationSettingsFragment notificationSettingsFragment2 = notificationSettingsFragment;
            i.e(notificationSettingsFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(notificationSettingsFragment2, kVar, this.a, new NotificationSettingsFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(y0.class), false, this.b);
        }
    }

    public NotificationSettingsFragment() {
        super(R.layout.fragment_notification_settings);
        d a2 = m.a(NotificationSettingsViewModel.class);
        this.b2 = new a(a2, false, new l<i0.b.b.k<NotificationSettingsViewModel, y0>, NotificationSettingsViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.profile.settings.NotificationSettingsFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.airbnb.mvrx.MavericksViewModel, com.clubhouse.android.ui.profile.settings.NotificationSettingsViewModel] */
            @Override // m0.n.a.l
            public NotificationSettingsViewModel invoke(i0.b.b.k<NotificationSettingsViewModel, y0> kVar) {
                i0.b.b.k<NotificationSettingsViewModel, y0> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, y0.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, Z1[1]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(O0(), new l<y0, SwitchMaterial>() { // from class: com.clubhouse.android.ui.profile.settings.NotificationSettingsFragment$invalidate$1
            @Override // m0.n.a.l
            public SwitchMaterial invoke(y0 y0Var) {
                y0 y0Var2 = y0Var;
                i.e(y0Var2, "state");
                if (y0Var2.e) {
                    NotificationSettingsFragment.this.N0().b.setText(NotificationSettingsFragment.this.getString(R.string.backchannel_wave_notifications_desc));
                } else {
                    NotificationSettingsFragment.this.N0().b.setText(NotificationSettingsFragment.this.getString(R.string.backchannel_notifications_desc));
                }
                SwitchMaterial switchMaterial = NotificationSettingsFragment.this.N0().e;
                switchMaterial.setChecked(y0Var2.a);
                switchMaterial.jumpDrawablesToCurrentState();
                SwitchMaterial switchMaterial2 = NotificationSettingsFragment.this.N0().c;
                switchMaterial2.setChecked(y0Var2.b);
                switchMaterial2.jumpDrawablesToCurrentState();
                SwitchMaterial switchMaterial3 = NotificationSettingsFragment.this.N0().f;
                switchMaterial3.setChecked(y0Var2.c);
                switchMaterial3.jumpDrawablesToCurrentState();
                SwitchMaterial switchMaterial4 = NotificationSettingsFragment.this.N0().d;
                switchMaterial4.setChecked(y0Var2.d);
                switchMaterial4.jumpDrawablesToCurrentState();
                return switchMaterial4;
            }
        });
    }

    public final FragmentNotificationSettingsBinding N0() {
        return (FragmentNotificationSettingsBinding) this.a2.getValue(this, Z1[0]);
    }

    public final NotificationSettingsViewModel O0() {
        return (NotificationSettingsViewModel) this.b2.getValue();
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.e(view, "view");
        super.onViewCreated(view, bundle);
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(O0().l, new NotificationSettingsFragment$onViewCreated$1(this, null));
        p viewLifecycleOwner = getViewLifecycleOwner();
        i.d(viewLifecycleOwner, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner));
        N0().a.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.u.z5.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                NotificationSettingsFragment notificationSettingsFragment = NotificationSettingsFragment.this;
                k<Object>[] kVarArr = NotificationSettingsFragment.Z1;
                i.e(notificationSettingsFragment, "this$0");
                v.c1(notificationSettingsFragment);
            }
        });
        N0().e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: i0.e.b.g3.u.z5.o
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                NotificationSettingsFragment notificationSettingsFragment = NotificationSettingsFragment.this;
                k<Object>[] kVarArr = NotificationSettingsFragment.Z1;
                i.e(notificationSettingsFragment, "this$0");
                if (compoundButton.isPressed()) {
                    notificationSettingsFragment.O0().p(new t1(z));
                }
            }
        });
        N0().c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: i0.e.b.g3.u.z5.k
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                NotificationSettingsFragment notificationSettingsFragment = NotificationSettingsFragment.this;
                m0.r.k<Object>[] kVarArr = NotificationSettingsFragment.Z1;
                i.e(notificationSettingsFragment, "this$0");
                if (compoundButton.isPressed()) {
                    notificationSettingsFragment.O0().p(new r1(z));
                }
            }
        });
        N0().f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: i0.e.b.g3.u.z5.n
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                NotificationSettingsFragment notificationSettingsFragment = NotificationSettingsFragment.this;
                k<Object>[] kVarArr = NotificationSettingsFragment.Z1;
                i.e(notificationSettingsFragment, "this$0");
                if (compoundButton.isPressed()) {
                    notificationSettingsFragment.O0().p(new u1(z));
                }
            }
        });
        N0().d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: i0.e.b.g3.u.z5.l
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                NotificationSettingsFragment notificationSettingsFragment = NotificationSettingsFragment.this;
                k<Object>[] kVarArr = NotificationSettingsFragment.Z1;
                i.e(notificationSettingsFragment, "this$0");
                if (compoundButton.isPressed()) {
                    notificationSettingsFragment.O0().p(new s1(z));
                }
            }
        });
    }
}
