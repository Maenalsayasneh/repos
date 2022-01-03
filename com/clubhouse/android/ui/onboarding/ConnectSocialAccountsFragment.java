package com.clubhouse.android.ui.onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.clubhouse.analytics.AmplitudeAnalytics;
import com.clubhouse.android.databinding.FragmentConnectSocialAccountsBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.ui.onboarding.ConnectSocialAccountsFragment;
import com.clubhouse.android.ui.onboarding.ConnectSocialAccountsFragment$onViewCreated$2$1;
import com.clubhouse.android.ui.profile.settings.AccountViewModel;
import com.clubhouse.app.R;
import h0.a.f.b;
import h0.b0.v;
import h0.i.b.a;
import h0.q.p;
import h0.q.q;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.e.b.g3.u.w4;
import i0.e.b.g3.u.z5.n0;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.c;
import m0.n.a.l;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
/* compiled from: ConnectSocialAccountsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010\fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\u00020\r8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001d\u001a\u00020\u00188B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010\u0016¨\u0006!"}, d2 = {"Lcom/clubhouse/android/ui/onboarding/ConnectSocialAccountsFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lcom/clubhouse/android/databinding/FragmentConnectSocialAccountsBinding;", "b2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "N0", "()Lcom/clubhouse/android/databinding/FragmentConnectSocialAccountsBinding;", "binding", "Lh0/a/f/b;", "Landroid/content/Intent;", "d2", "Lh0/a/f/b;", "getTwitterOAuthToken", "Lcom/clubhouse/android/ui/profile/settings/AccountViewModel;", "a2", "Lm0/c;", "O0", "()Lcom/clubhouse/android/ui/profile/settings/AccountViewModel;", "viewModel", "c2", "getInstagramOAuthToken", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class ConnectSocialAccountsFragment extends Hilt_ConnectSocialAccountsFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(ConnectSocialAccountsFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/profile/settings/AccountViewModel;")), m.c(new PropertyReference1Impl(m.a(ConnectSocialAccountsFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentConnectSocialAccountsBinding;"))};
    public final c a2;
    public final FragmentViewBindingDelegate b2 = new FragmentViewBindingDelegate(FragmentConnectSocialAccountsBinding.class, this);
    public b<Intent> c2;
    public b<Intent> d2;

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<ConnectSocialAccountsFragment, AccountViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<AccountViewModel> a(ConnectSocialAccountsFragment connectSocialAccountsFragment, k kVar) {
            ConnectSocialAccountsFragment connectSocialAccountsFragment2 = connectSocialAccountsFragment;
            i.e(connectSocialAccountsFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(connectSocialAccountsFragment2, kVar, this.a, new ConnectSocialAccountsFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(n0.class), false, this.b);
        }
    }

    public ConnectSocialAccountsFragment() {
        super(R.layout.fragment_connect_social_accounts);
        d a2 = m.a(AccountViewModel.class);
        this.a2 = new a(a2, false, new l<i0.b.b.k<AccountViewModel, n0>, AccountViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.onboarding.ConnectSocialAccountsFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.clubhouse.android.ui.profile.settings.AccountViewModel, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.l
            public AccountViewModel invoke(i0.b.b.k<AccountViewModel, n0> kVar) {
                i0.b.b.k<AccountViewModel, n0> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, n0.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, Z1[0]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(O0(), new l<n0, Button>() { // from class: com.clubhouse.android.ui.onboarding.ConnectSocialAccountsFragment$invalidate$1
            @Override // m0.n.a.l
            public Button invoke(n0 n0Var) {
                n0 n0Var2 = n0Var;
                i.e(n0Var2, "state");
                ConnectSocialAccountsFragment connectSocialAccountsFragment = ConnectSocialAccountsFragment.this;
                k<Object>[] kVarArr = ConnectSocialAccountsFragment.Z1;
                FrameLayout frameLayout = connectSocialAccountsFragment.N0().b;
                i.d(frameLayout, "binding.loading");
                i0.e.b.d3.k.L(frameLayout, Boolean.valueOf(n0Var2.e));
                ConnectSocialAccountsFragment.this.N0().c.setText(n0Var2.f);
                ConnectSocialAccountsFragment.this.N0().a.setEnabled(!n0Var2.c);
                ConnectSocialAccountsFragment.this.N0().d.setEnabled(!n0Var2.a);
                String str = n0Var2.d;
                if (str != null) {
                    ConnectSocialAccountsFragment connectSocialAccountsFragment2 = ConnectSocialAccountsFragment.this;
                    Button button = connectSocialAccountsFragment2.N0().a;
                    button.setText(str);
                    button.setTextColor(a.getColor(connectSocialAccountsFragment2.requireContext(), R.color.black));
                }
                String str2 = n0Var2.b;
                if (str2 == null) {
                    return null;
                }
                ConnectSocialAccountsFragment connectSocialAccountsFragment3 = ConnectSocialAccountsFragment.this;
                Button button2 = connectSocialAccountsFragment3.N0().d;
                button2.setText(str2);
                button2.setTextColor(a.getColor(connectSocialAccountsFragment3.requireContext(), R.color.black));
                return button2;
            }
        });
    }

    public final FragmentConnectSocialAccountsBinding N0() {
        return (FragmentConnectSocialAccountsBinding) this.b2.getValue(this, Z1[1]);
    }

    public final AccountViewModel O0() {
        return (AccountViewModel) this.a2.getValue();
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.V(this);
        AccountViewModel O0 = O0();
        i.e(this, "<this>");
        i.e(O0, "viewModel");
        b<Intent> registerForActivityResult = registerForActivityResult(new h0.a.f.d.d(), new i0.e.b.d3.c(O0, this));
        i.d(registerForActivityResult, "registerForActivityResult(\n            ActivityResultContracts.StartActivityForResult()\n        ) { result ->\n            viewModel.processIntent(OAuthReturned)\n            if (result.resultCode == Activity.RESULT_OK) {\n                val intent = result.data\n                if (intent == null) {\n                    showInstagramConnectError()\n                } else {\n                    try {\n                        val authResponse = AuthorizationResponse.fromIntent(intent)\n                        val authCode: String? = authResponse?.authorizationCode\n                        if (authCode.isNullOrBlank()) {\n                            showInstagramConnectError()\n                        } else {\n                            viewModel.processIntent(UpdateInstagramProfile(authCode))\n                        }\n                    } catch (exception: Exception) {\n                        showInstagramConnectError(exception)\n                    }\n                }\n            } else if (result.resultCode != Activity.RESULT_CANCELED) {\n                showInstagramConnectError()\n            }\n        }");
        this.c2 = registerForActivityResult;
        AccountViewModel O02 = O0();
        i.e(this, "<this>");
        i.e(O02, "viewModel");
        b<Intent> registerForActivityResult2 = registerForActivityResult(new h0.a.f.d.d(), new i0.e.b.d3.b(O02, this));
        i.d(registerForActivityResult2, "registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->\n            viewModel.processIntent(OAuthReturned)\n            if (result.resultCode == Activity.RESULT_OK) {\n                val intent = result.data\n                if (intent == null) {\n                    showTwitterConnectError()\n                } else {\n                    try {\n                        val verifier: String? =\n                            intent.data?.getQueryParameters(\"oauth_verifier\")?.firstOrNull()\n                        if (verifier.isNullOrBlank()) {\n                            showTwitterConnectError()\n                        } else {\n                            viewModel.processIntent(UpdateTwitterProfile(verifier))\n                        }\n                    } catch (exception: Exception) {\n                        showTwitterConnectError(exception)\n                    }\n                }\n            } else if (result.resultCode != Activity.RESULT_CANCELED) {\n                showTwitterConnectError()\n            }\n        }");
        this.d2 = registerForActivityResult2;
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.e(view, "view");
        super.onViewCreated(view, bundle);
        N0().c.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.r.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ConnectSocialAccountsFragment connectSocialAccountsFragment = ConnectSocialAccountsFragment.this;
                k<Object>[] kVarArr = ConnectSocialAccountsFragment.Z1;
                i.e(connectSocialAccountsFragment, "this$0");
                ((AmplitudeAnalytics) v.l(connectSocialAccountsFragment)).a("Onboarding-Social-Done");
                v.v2(connectSocialAccountsFragment.O0(), 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001d: INVOKE  
                      (wrap: com.clubhouse.android.ui.profile.settings.AccountViewModel : 0x0014: INVOKE  (r0v4 com.clubhouse.android.ui.profile.settings.AccountViewModel A[REMOVE]) = (r3v1 'connectSocialAccountsFragment' com.clubhouse.android.ui.onboarding.ConnectSocialAccountsFragment) type: VIRTUAL call: com.clubhouse.android.ui.onboarding.ConnectSocialAccountsFragment.O0():com.clubhouse.android.ui.profile.settings.AccountViewModel)
                      (wrap: com.clubhouse.android.ui.onboarding.ConnectSocialAccountsFragment$advance$1 : 0x001a: CONSTRUCTOR  (r1v1 com.clubhouse.android.ui.onboarding.ConnectSocialAccountsFragment$advance$1 A[REMOVE]) = (r3v1 'connectSocialAccountsFragment' com.clubhouse.android.ui.onboarding.ConnectSocialAccountsFragment) call: com.clubhouse.android.ui.onboarding.ConnectSocialAccountsFragment$advance$1.<init>(com.clubhouse.android.ui.onboarding.ConnectSocialAccountsFragment):void type: CONSTRUCTOR)
                     type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: i0.e.b.g3.r.n.onClick(android.view.View):void, file: classes3.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.onboarding.ConnectSocialAccountsFragment$advance$1, state: NOT_LOADED
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
                    com.clubhouse.android.ui.onboarding.ConnectSocialAccountsFragment r3 = com.clubhouse.android.ui.onboarding.ConnectSocialAccountsFragment.this
                    m0.r.k<java.lang.Object>[] r0 = com.clubhouse.android.ui.onboarding.ConnectSocialAccountsFragment.Z1
                    java.lang.String r0 = "this$0"
                    m0.n.b.i.e(r3, r0)
                    i0.e.a.a r0 = h0.b0.v.l(r3)
                    com.clubhouse.analytics.AmplitudeAnalytics r0 = (com.clubhouse.analytics.AmplitudeAnalytics) r0
                    java.lang.String r1 = "Onboarding-Social-Done"
                    r0.a(r1)
                    com.clubhouse.android.ui.profile.settings.AccountViewModel r0 = r3.O0()
                    com.clubhouse.android.ui.onboarding.ConnectSocialAccountsFragment$advance$1 r1 = new com.clubhouse.android.ui.onboarding.ConnectSocialAccountsFragment$advance$1
                    r1.<init>(r3)
                    h0.b0.v.v2(r0, r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.r.n.onClick(android.view.View):void");
            }
        });
        Button button = N0().d;
        i.d(button, "binding.twitter");
        p viewLifecycleOwner = getViewLifecycleOwner();
        i.d(viewLifecycleOwner, "viewLifecycleOwner");
        i0.e.b.d3.k.H(button, q.a(viewLifecycleOwner), new View.OnClickListener() { // from class: i0.e.b.g3.r.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ConnectSocialAccountsFragment connectSocialAccountsFragment = ConnectSocialAccountsFragment.this;
                k<Object>[] kVarArr = ConnectSocialAccountsFragment.Z1;
                i.e(connectSocialAccountsFragment, "this$0");
                ((AmplitudeAnalytics) v.l(connectSocialAccountsFragment)).a("Onboarding-Social-Twitter-Tap");
                p viewLifecycleOwner2 = connectSocialAccountsFragment.getViewLifecycleOwner();
                i.d(viewLifecycleOwner2, "viewLifecycleOwner");
                m0.r.t.a.r.m.a1.a.E2(q.a(viewLifecycleOwner2), null, null, new ConnectSocialAccountsFragment$onViewCreated$2$1(connectSocialAccountsFragment, null), 3, null);
            }
        });
        Button button2 = N0().a;
        i.d(button2, "binding.instagram");
        p viewLifecycleOwner2 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner2, "viewLifecycleOwner");
        i0.e.b.d3.k.H(button2, q.a(viewLifecycleOwner2), new View.OnClickListener() { // from class: i0.e.b.g3.r.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ConnectSocialAccountsFragment connectSocialAccountsFragment = ConnectSocialAccountsFragment.this;
                k<Object>[] kVarArr = ConnectSocialAccountsFragment.Z1;
                i.e(connectSocialAccountsFragment, "this$0");
                ((AmplitudeAnalytics) v.l(connectSocialAccountsFragment)).a("Onboarding-Social-Instagram-Tap");
                connectSocialAccountsFragment.O0().p(w4.a);
                b<Intent> bVar = connectSocialAccountsFragment.c2;
                if (bVar != null) {
                    bVar.a(connectSocialAccountsFragment.O0().o.a(), null);
                } else {
                    i.m("getInstagramOAuthToken");
                    throw null;
                }
            }
        });
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(O0().l, new ConnectSocialAccountsFragment$onViewCreated$4(this, null));
        p viewLifecycleOwner3 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner3, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner3));
    }
}
