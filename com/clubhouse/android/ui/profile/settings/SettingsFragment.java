package com.clubhouse.android.ui.profile.settings;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.clubhouse.analytics.AmplitudeAnalytics;
import com.clubhouse.android.data.models.local.notification.NotificationPause;
import com.clubhouse.android.databinding.FragmentSettingsBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.shared.preferences.DeviceSharedPreferences;
import com.clubhouse.android.ui.profile.settings.EditTopicsArgs;
import com.clubhouse.android.ui.profile.settings.SettingsFragment;
import com.clubhouse.android.ui.profile.settings.SettingsFragment$showLogoutConfirmationDialog$1;
import com.clubhouse.app.R;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import h0.b0.v;
import h0.q.p;
import h0.q.q;
import h0.t.a;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.e.b.a3.f.e;
import i0.e.b.g3.u.z5.d1;
import i0.e.b.g3.u.z5.z0;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.c;
import m0.n.a.l;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
/* compiled from: SettingsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010\u000fJ#\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001e\u001a\u00020\u00198F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010$\u001a\u00020\u001f8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/clubhouse/android/ui/profile/settings/SettingsFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "", "url", InstabugDbContract.FeatureRequestEntry.COLUMN_TITLE, "Lm0/i;", "P0", "(II)V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "()V", "J", "Lcom/clubhouse/android/shared/preferences/DeviceSharedPreferences;", "a2", "Lcom/clubhouse/android/shared/preferences/DeviceSharedPreferences;", "getDevicePreferences", "()Lcom/clubhouse/android/shared/preferences/DeviceSharedPreferences;", "setDevicePreferences", "(Lcom/clubhouse/android/shared/preferences/DeviceSharedPreferences;)V", "devicePreferences", "Lcom/clubhouse/android/ui/profile/settings/SettingsViewModel;", "c2", "Lm0/c;", "O0", "()Lcom/clubhouse/android/ui/profile/settings/SettingsViewModel;", "viewModel", "Lcom/clubhouse/android/databinding/FragmentSettingsBinding;", "b2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "N0", "()Lcom/clubhouse/android/databinding/FragmentSettingsBinding;", "binding", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class SettingsFragment extends Hilt_SettingsFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(SettingsFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentSettingsBinding;")), m.c(new PropertyReference1Impl(m.a(SettingsFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/profile/settings/SettingsViewModel;"))};
    public DeviceSharedPreferences a2;
    public final FragmentViewBindingDelegate b2 = new FragmentViewBindingDelegate(FragmentSettingsBinding.class, this);
    public final c c2;

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<SettingsFragment, SettingsViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<SettingsViewModel> a(SettingsFragment settingsFragment, k kVar) {
            SettingsFragment settingsFragment2 = settingsFragment;
            i.e(settingsFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(settingsFragment2, kVar, this.a, new SettingsFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(d1.class), false, this.b);
        }
    }

    public SettingsFragment() {
        super(R.layout.fragment_settings);
        d a2 = m.a(SettingsViewModel.class);
        this.c2 = new a(a2, false, new l<i0.b.b.k<SettingsViewModel, d1>, SettingsViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.profile.settings.SettingsFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.airbnb.mvrx.MavericksViewModel, com.clubhouse.android.ui.profile.settings.SettingsViewModel] */
            @Override // m0.n.a.l
            public SettingsViewModel invoke(i0.b.b.k<SettingsViewModel, d1> kVar) {
                i0.b.b.k<SettingsViewModel, d1> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, d1.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, Z1[1]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(O0(), new l<d1, m0.i>() { // from class: com.clubhouse.android.ui.profile.settings.SettingsFragment$invalidate$1
            @Override // m0.n.a.l
            public m0.i invoke(d1 d1Var) {
                d1 d1Var2 = d1Var;
                i.e(d1Var2, "state");
                SwitchMaterial switchMaterial = SettingsFragment.this.N0().t;
                NotificationPause notificationPause = d1Var2.d;
                boolean z = true;
                switchMaterial.setChecked((notificationPause == NotificationPause.NULL || notificationPause == NotificationPause.UNPAUSE) ? false : true);
                switchMaterial.jumpDrawablesToCurrentState();
                SwitchMaterial switchMaterial2 = SettingsFragment.this.N0().x;
                switchMaterial2.setChecked(d1Var2.i);
                switchMaterial2.jumpDrawablesToCurrentState();
                if (d1Var2.l) {
                    TextView textView = SettingsFragment.this.N0().u;
                    i.d(textView, "binding.payments");
                    i0.e.b.d3.k.K(textView);
                    View view = SettingsFragment.this.N0().v;
                    i.d(view, "binding.paymentsDivider");
                    i0.e.b.d3.k.K(view);
                    SettingsFragment.this.N0().u.setOnClickListener(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0067: INVOKE  
                          (wrap: android.widget.TextView : 0x005e: IGET  (r0v56 android.widget.TextView A[REMOVE]) = 
                          (wrap: com.clubhouse.android.databinding.FragmentSettingsBinding : 0x005a: INVOKE  (r0v55 com.clubhouse.android.databinding.FragmentSettingsBinding A[REMOVE]) = 
                          (wrap: com.clubhouse.android.ui.profile.settings.SettingsFragment : 0x0058: IGET  (r0v54 com.clubhouse.android.ui.profile.settings.SettingsFragment A[REMOVE]) = (r5v0 'this' com.clubhouse.android.ui.profile.settings.SettingsFragment$invalidate$1 A[IMMUTABLE_TYPE, THIS]) com.clubhouse.android.ui.profile.settings.SettingsFragment$invalidate$1.c com.clubhouse.android.ui.profile.settings.SettingsFragment)
                         type: VIRTUAL call: com.clubhouse.android.ui.profile.settings.SettingsFragment.N0():com.clubhouse.android.databinding.FragmentSettingsBinding)
                         com.clubhouse.android.databinding.FragmentSettingsBinding.u android.widget.TextView)
                          (wrap: i0.e.b.g3.u.z5.e0 : 0x0064: CONSTRUCTOR  (r2v7 i0.e.b.g3.u.z5.e0 A[REMOVE]) = 
                          (wrap: com.clubhouse.android.ui.profile.settings.SettingsFragment : 0x0060: IGET  (r1v22 com.clubhouse.android.ui.profile.settings.SettingsFragment A[REMOVE]) = (r5v0 'this' com.clubhouse.android.ui.profile.settings.SettingsFragment$invalidate$1 A[IMMUTABLE_TYPE, THIS]) com.clubhouse.android.ui.profile.settings.SettingsFragment$invalidate$1.c com.clubhouse.android.ui.profile.settings.SettingsFragment)
                         call: i0.e.b.g3.u.z5.e0.<init>(com.clubhouse.android.ui.profile.settings.SettingsFragment):void type: CONSTRUCTOR)
                         type: VIRTUAL call: android.widget.TextView.setOnClickListener(android.view.View$OnClickListener):void in method: com.clubhouse.android.ui.profile.settings.SettingsFragment$invalidate$1.invoke(i0.e.b.g3.u.z5.d1):m0.i, file: classes3.dex
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
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: i0.e.b.g3.u.z5.e0, state: NOT_LOADED
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
                    // Method dump skipped, instructions count: 368
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.clubhouse.android.ui.profile.settings.SettingsFragment$invalidate$1.invoke(java.lang.Object):java.lang.Object");
                }
            });
        }

        public final FragmentSettingsBinding N0() {
            return (FragmentSettingsBinding) this.b2.getValue(this, Z1[0]);
        }

        public final SettingsViewModel O0() {
            return (SettingsViewModel) this.c2.getValue();
        }

        public final void P0(int i, int i2) {
            e.b(this, getString(i));
            ((AmplitudeAnalytics) v.l(this)).b("Settings-Info-TappedInfo", i0.j.f.p.h.S2(new Pair(InstabugDbContract.FeatureRequestEntry.COLUMN_TITLE, getString(i2))));
        }

        @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
        public void onResume() {
            super.onResume();
            ConstraintLayout constraintLayout = N0().o;
            i.d(constraintLayout, "binding.notificationReactivateRoot");
            i0.e.b.e3.d dVar = i0.e.b.e3.d.a;
            Context requireContext = requireContext();
            i.d(requireContext, "requireContext()");
            i0.e.b.d3.k.L(constraintLayout, Boolean.valueOf(!dVar.a(requireContext)));
            O0().p(z0.a);
        }

        @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
        public void onViewCreated(View view, Bundle bundle) {
            i.e(view, "view");
            super.onViewCreated(view, bundle);
            FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(O0().l, new SettingsFragment$onViewCreated$1(this, null));
            p viewLifecycleOwner = getViewLifecycleOwner();
            i.d(viewLifecycleOwner, "viewLifecycleOwner");
            m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner));
            N0().d.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.u.z5.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SettingsFragment settingsFragment = SettingsFragment.this;
                    k<Object>[] kVarArr = SettingsFragment.Z1;
                    i.e(settingsFragment, "this$0");
                    h0.b0.v.c1(settingsFragment);
                }
            });
            ConstraintLayout constraintLayout = N0().a;
            i.d(constraintLayout, "binding.accountRoot");
            p viewLifecycleOwner2 = getViewLifecycleOwner();
            i.d(viewLifecycleOwner2, "viewLifecycleOwner");
            i0.e.b.d3.k.H(constraintLayout, q.a(viewLifecycleOwner2), new View.OnClickListener() { // from class: i0.e.b.g3.u.z5.l0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SettingsFragment settingsFragment = SettingsFragment.this;
                    k<Object>[] kVarArr = SettingsFragment.Z1;
                    i.e(settingsFragment, "this$0");
                    v.a1(settingsFragment, new a(R.id.action_settingsFragment_to_accountFragment), null, 2);
                }
            });
            N0().i.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.u.z5.x
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SettingsFragment settingsFragment = SettingsFragment.this;
                    k<Object>[] kVarArr = SettingsFragment.Z1;
                    i.e(settingsFragment, "this$0");
                    EditTopicsArgs editTopicsArgs = new EditTopicsArgs(null, 1);
                    i.e(editTopicsArgs, "mavericksArg");
                    v.a1(settingsFragment, new a1(editTopicsArgs), null, 2);
                }
            });
            N0().k.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.u.z5.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SettingsFragment settingsFragment = SettingsFragment.this;
                    k<Object>[] kVarArr = SettingsFragment.Z1;
                    i.e(settingsFragment, "this$0");
                    v.a1(settingsFragment, new a(R.id.action_settingsFragment_to_languagesFragment), null, 2);
                }
            });
            N0().C.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.u.z5.k0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SettingsFragment settingsFragment = SettingsFragment.this;
                    k<Object>[] kVarArr = SettingsFragment.Z1;
                    i.e(settingsFragment, "this$0");
                    settingsFragment.P0(R.string.clubhouse_whats_new, R.string.whats_new);
                }
            });
            N0().g.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.u.z5.b0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SettingsFragment settingsFragment = SettingsFragment.this;
                    k<Object>[] kVarArr = SettingsFragment.Z1;
                    i.e(settingsFragment, "this$0");
                    settingsFragment.P0(R.string.clubhouse_contact, R.string.faq);
                }
            });
            N0().h.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.u.z5.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SettingsFragment settingsFragment = SettingsFragment.this;
                    k<Object>[] kVarArr = SettingsFragment.Z1;
                    i.e(settingsFragment, "this$0");
                    settingsFragment.P0(R.string.clubhouse_guidelines, R.string.guidelines);
                }
            });
            N0().A.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.u.z5.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SettingsFragment settingsFragment = SettingsFragment.this;
                    k<Object>[] kVarArr = SettingsFragment.Z1;
                    i.e(settingsFragment, "this$0");
                    settingsFragment.P0(R.string.clubhouse_terms_of_service, R.string.tos);
                }
            });
            N0().w.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.u.z5.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SettingsFragment settingsFragment = SettingsFragment.this;
                    k<Object>[] kVarArr = SettingsFragment.Z1;
                    i.e(settingsFragment, "this$0");
                    settingsFragment.P0(R.string.clubhouse_privacy_policy, R.string.privacy_policy);
                }
            });
            N0().m.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.u.z5.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SettingsFragment settingsFragment = SettingsFragment.this;
                    k<Object>[] kVarArr = SettingsFragment.Z1;
                    i.e(settingsFragment, "this$0");
                    SettingsFragment$showLogoutConfirmationDialog$1 settingsFragment$showLogoutConfirmationDialog$1 = 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: CONSTRUCTOR  (r0v2 'settingsFragment$showLogoutConfirmationDialog$1' com.clubhouse.android.ui.profile.settings.SettingsFragment$showLogoutConfirmationDialog$1) = (r4v1 'settingsFragment' com.clubhouse.android.ui.profile.settings.SettingsFragment) call: com.clubhouse.android.ui.profile.settings.SettingsFragment$showLogoutConfirmationDialog$1.<init>(com.clubhouse.android.ui.profile.settings.SettingsFragment):void type: CONSTRUCTOR in method: i0.e.b.g3.u.z5.w.onClick(android.view.View):void, file: classes3.dex
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
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.profile.settings.SettingsFragment$showLogoutConfirmationDialog$1, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                        	... 15 more
                        */
                    /*
                        this = this;
                        com.clubhouse.android.ui.profile.settings.SettingsFragment r4 = com.clubhouse.android.ui.profile.settings.SettingsFragment.this
                        m0.r.k<java.lang.Object>[] r0 = com.clubhouse.android.ui.profile.settings.SettingsFragment.Z1
                        java.lang.String r0 = "this$0"
                        m0.n.b.i.e(r4, r0)
                        com.clubhouse.android.ui.profile.settings.SettingsFragment$showLogoutConfirmationDialog$1 r0 = new com.clubhouse.android.ui.profile.settings.SettingsFragment$showLogoutConfirmationDialog$1
                        r0.<init>(r4)
                        java.lang.String r1 = "<this>"
                        m0.n.b.i.e(r4, r1)
                        java.lang.String r1 = "f"
                        m0.n.b.i.e(r0, r1)
                        h0.b.a.d$a r1 = new h0.b.a.d$a
                        android.content.Context r4 = r4.requireContext()
                        int r2 = com.clubhouse.core.ui.R.style.Clubhouse_AlertDialog_Rounded
                        r1.<init>(r4, r2)
                        r0.invoke(r1)
                        r1.g()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.u.z5.w.onClick(android.view.View):void");
                }
            });
            N0().p.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.u.z5.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SettingsFragment settingsFragment = SettingsFragment.this;
                    k<Object>[] kVarArr = SettingsFragment.Z1;
                    i.e(settingsFragment, "this$0");
                    v.v2(settingsFragment.O0(), 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: INVOKE  
                          (wrap: com.clubhouse.android.ui.profile.settings.SettingsViewModel : 0x0009: INVOKE  (r0v2 com.clubhouse.android.ui.profile.settings.SettingsViewModel A[REMOVE]) = (r3v1 'settingsFragment' com.clubhouse.android.ui.profile.settings.SettingsFragment) type: VIRTUAL call: com.clubhouse.android.ui.profile.settings.SettingsFragment.O0():com.clubhouse.android.ui.profile.settings.SettingsViewModel)
                          (wrap: com.clubhouse.android.ui.profile.settings.SettingsFragment$onViewCreated$12$1 : 0x000f: CONSTRUCTOR  (r1v0 com.clubhouse.android.ui.profile.settings.SettingsFragment$onViewCreated$12$1 A[REMOVE]) = (r3v1 'settingsFragment' com.clubhouse.android.ui.profile.settings.SettingsFragment) call: com.clubhouse.android.ui.profile.settings.SettingsFragment$onViewCreated$12$1.<init>(com.clubhouse.android.ui.profile.settings.SettingsFragment):void type: CONSTRUCTOR)
                         type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: i0.e.b.g3.u.z5.a0.onClick(android.view.View):void, file: classes3.dex
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
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.profile.settings.SettingsFragment$onViewCreated$12$1, state: NOT_LOADED
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
                        com.clubhouse.android.ui.profile.settings.SettingsFragment r3 = com.clubhouse.android.ui.profile.settings.SettingsFragment.this
                        m0.r.k<java.lang.Object>[] r0 = com.clubhouse.android.ui.profile.settings.SettingsFragment.Z1
                        java.lang.String r0 = "this$0"
                        m0.n.b.i.e(r3, r0)
                        com.clubhouse.android.ui.profile.settings.SettingsViewModel r0 = r3.O0()
                        com.clubhouse.android.ui.profile.settings.SettingsFragment$onViewCreated$12$1 r1 = new com.clubhouse.android.ui.profile.settings.SettingsFragment$onViewCreated$12$1
                        r1.<init>(r3)
                        h0.b0.v.v2(r0, r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.u.z5.a0.onClick(android.view.View):void");
                }
            });
            N0().t.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: i0.e.b.g3.u.z5.y
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    SettingsFragment settingsFragment = SettingsFragment.this;
                    k<Object>[] kVarArr = SettingsFragment.Z1;
                    i.e(settingsFragment, "this$0");
                    if (compoundButton.isPressed() && z) {
                        v.e(settingsFragment, 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0016: INVOKE  
                              (r0v0 'settingsFragment' com.clubhouse.android.ui.profile.settings.SettingsFragment)
                              (wrap: com.clubhouse.android.ui.profile.settings.SettingsFragment$showNotificationsPauseOptions$1 : 0x0013: CONSTRUCTOR  (r3v3 com.clubhouse.android.ui.profile.settings.SettingsFragment$showNotificationsPauseOptions$1 A[REMOVE]) = (r0v0 'settingsFragment' com.clubhouse.android.ui.profile.settings.SettingsFragment) call: com.clubhouse.android.ui.profile.settings.SettingsFragment$showNotificationsPauseOptions$1.<init>(com.clubhouse.android.ui.profile.settings.SettingsFragment):void type: CONSTRUCTOR)
                             type: STATIC call: h0.b0.v.e(androidx.fragment.app.Fragment, m0.n.a.l):void in method: i0.e.b.g3.u.z5.y.onCheckedChanged(android.widget.CompoundButton, boolean):void, file: classes3.dex
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
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.profile.settings.SettingsFragment$showNotificationsPauseOptions$1, state: NOT_LOADED
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
                            com.clubhouse.android.ui.profile.settings.SettingsFragment r0 = com.clubhouse.android.ui.profile.settings.SettingsFragment.this
                            m0.r.k<java.lang.Object>[] r1 = com.clubhouse.android.ui.profile.settings.SettingsFragment.Z1
                            java.lang.String r1 = "this$0"
                            m0.n.b.i.e(r0, r1)
                            boolean r1 = r3.isPressed()
                            if (r1 == 0) goto L_0x001a
                            if (r4 == 0) goto L_0x001a
                            com.clubhouse.android.ui.profile.settings.SettingsFragment$showNotificationsPauseOptions$1 r3 = new com.clubhouse.android.ui.profile.settings.SettingsFragment$showNotificationsPauseOptions$1
                            r3.<init>(r0)
                            h0.b0.v.e(r0, r3)
                            goto L_0x002e
                        L_0x001a:
                            boolean r3 = r3.isPressed()
                            if (r3 == 0) goto L_0x002e
                            com.clubhouse.android.ui.profile.settings.SettingsViewModel r3 = r0.O0()
                            i0.e.b.g3.u.z5.w1 r4 = new i0.e.b.g3.u.z5.w1
                            com.clubhouse.android.data.models.local.notification.NotificationPause r0 = com.clubhouse.android.data.models.local.notification.NotificationPause.UNPAUSE
                            r4.<init>(r0)
                            r3.p(r4)
                        L_0x002e:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.u.z5.y.onCheckedChanged(android.widget.CompoundButton, boolean):void");
                    }
                });
                N0().x.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: i0.e.b.g3.u.z5.q
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        SettingsFragment settingsFragment = SettingsFragment.this;
                        k<Object>[] kVarArr = SettingsFragment.Z1;
                        i.e(settingsFragment, "this$0");
                        if (compoundButton.isPressed()) {
                            settingsFragment.O0().p(new x1(z));
                        }
                    }
                });
                N0().z.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: i0.e.b.g3.u.z5.t
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        SettingsFragment settingsFragment = SettingsFragment.this;
                        k<Object>[] kVarArr = SettingsFragment.Z1;
                        i.e(settingsFragment, "this$0");
                        if (compoundButton.isPressed()) {
                            settingsFragment.O0().p(new y1(z));
                        }
                    }
                });
                N0().e.setText(getString(R.string.build_string, "1.0.8", 4734));
                N0().q.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.u.z5.s
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        SettingsFragment settingsFragment = SettingsFragment.this;
                        k<Object>[] kVarArr = SettingsFragment.Z1;
                        i.e(settingsFragment, "this$0");
                        Context requireContext = settingsFragment.requireContext();
                        i.d(requireContext, "requireContext()");
                        i.e(requireContext, "<this>");
                        Intent intent = new Intent();
                        intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                        intent.putExtra("android.provider.extra.APP_PACKAGE", requireContext.getPackageName());
                        requireContext.startActivity(intent);
                    }
                });
                v.p0(this, "languages_updated_result", new l<Boolean, m0.i>() { // from class: com.clubhouse.android.ui.profile.settings.SettingsFragment$onViewCreated$17
                    @Override // m0.n.a.l
                    public m0.i invoke(Boolean bool) {
                        bool.booleanValue();
                        v.c2(SettingsFragment.this, AnonymousClass1.c);
                        return m0.i.a;
                    }
                });
            }
        }
