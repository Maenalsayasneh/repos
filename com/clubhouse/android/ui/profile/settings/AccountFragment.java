package com.clubhouse.android.ui.profile.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.clubhouse.android.databinding.FragmentAccountBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.ui.profile.settings.AccountFragment;
import com.clubhouse.app.R;
import h0.a.f.b;
import h0.b0.v;
import h0.q.p;
import h0.q.q;
import h0.t.a;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
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
/* compiled from: AccountFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010\fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\u00020\r8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0018\u001a\u00020\u00138F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001c¨\u0006!"}, d2 = {"Lcom/clubhouse/android/ui/profile/settings/AccountFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lcom/clubhouse/android/databinding/FragmentAccountBinding;", "a2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "N0", "()Lcom/clubhouse/android/databinding/FragmentAccountBinding;", "binding", "Lcom/clubhouse/android/ui/profile/settings/AccountViewModel;", "b2", "Lm0/c;", "O0", "()Lcom/clubhouse/android/ui/profile/settings/AccountViewModel;", "viewModel", "Lh0/a/f/b;", "Landroid/content/Intent;", "c2", "Lh0/a/f/b;", "getInstagramOAuthToken", "d2", "getTwitterOAuthToken", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class AccountFragment extends Hilt_AccountFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(AccountFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentAccountBinding;")), m.c(new PropertyReference1Impl(m.a(AccountFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/profile/settings/AccountViewModel;"))};
    public final FragmentViewBindingDelegate a2 = new FragmentViewBindingDelegate(FragmentAccountBinding.class, this);
    public final c b2;
    public b<Intent> c2;
    public b<Intent> d2;

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<AccountFragment, AccountViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<AccountViewModel> a(AccountFragment accountFragment, k kVar) {
            AccountFragment accountFragment2 = accountFragment;
            i.e(accountFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(accountFragment2, kVar, this.a, new AccountFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(n0.class), false, this.b);
        }
    }

    public AccountFragment() {
        super(R.layout.fragment_account);
        d a2 = m.a(AccountViewModel.class);
        this.b2 = new a(a2, false, new l<i0.b.b.k<AccountViewModel, n0>, AccountViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.profile.settings.AccountFragment$special$$inlined$fragmentViewModel$default$1
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
        }, a2).a(this, Z1[1]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(O0(), new l<n0, m0.i>() { // from class: com.clubhouse.android.ui.profile.settings.AccountFragment$invalidate$1
            @Override // m0.n.a.l
            public m0.i invoke(n0 n0Var) {
                String str;
                String str2;
                n0 n0Var2 = n0Var;
                i.e(n0Var2, "state");
                FrameLayout frameLayout = AccountFragment.this.N0().d;
                i.d(frameLayout, "binding.loading");
                i0.e.b.d3.k.L(frameLayout, Boolean.valueOf(n0Var2.e));
                TextView textView = AccountFragment.this.N0().c;
                if (n0Var2.c) {
                    str = AccountFragment.this.getString(R.string.disconnect_instagram);
                } else {
                    str = AccountFragment.this.getString(R.string.connect_instagram);
                }
                textView.setText(str);
                TextView textView2 = AccountFragment.this.N0().e;
                if (n0Var2.a) {
                    str2 = AccountFragment.this.getString(R.string.disconnect_twitter);
                } else {
                    str2 = AccountFragment.this.getString(R.string.connect_twitter);
                }
                textView2.setText(str2);
                return m0.i.a;
            }
        });
    }

    public final FragmentAccountBinding N0() {
        return (FragmentAccountBinding) this.a2.getValue(this, Z1[0]);
    }

    public final AccountViewModel O0() {
        return (AccountViewModel) this.b2.getValue();
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
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
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(O0().l, new AccountFragment$onViewCreated$1(this, null));
        p viewLifecycleOwner = getViewLifecycleOwner();
        i.d(viewLifecycleOwner, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner));
        ImageView imageView = N0().a;
        i.d(imageView, "binding.back");
        p viewLifecycleOwner2 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner2, "viewLifecycleOwner");
        i0.e.b.d3.k.H(imageView, q.a(viewLifecycleOwner2), new View.OnClickListener() { // from class: i0.e.b.g3.u.z5.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AccountFragment accountFragment = AccountFragment.this;
                k<Object>[] kVarArr = AccountFragment.Z1;
                i.e(accountFragment, "this$0");
                v.c1(accountFragment);
            }
        });
        TextView textView = N0().b;
        i.d(textView, "binding.deactivate");
        p viewLifecycleOwner3 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner3, "viewLifecycleOwner");
        i0.e.b.d3.k.H(textView, q.a(viewLifecycleOwner3), new View.OnClickListener() { // from class: i0.e.b.g3.u.z5.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AccountFragment accountFragment = AccountFragment.this;
                k<Object>[] kVarArr = AccountFragment.Z1;
                i.e(accountFragment, "this$0");
                v.a1(accountFragment, new a(R.id.action_accountFragment_to_deactivateFragment), null, 2);
            }
        });
        TextView textView2 = N0().c;
        i.d(textView2, "binding.instagram");
        p viewLifecycleOwner4 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner4, "viewLifecycleOwner");
        i0.e.b.d3.k.H(textView2, q.a(viewLifecycleOwner4), new View.OnClickListener() { // from class: i0.e.b.g3.u.z5.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AccountFragment accountFragment = AccountFragment.this;
                k<Object>[] kVarArr = AccountFragment.Z1;
                i.e(accountFragment, "this$0");
                v.v2(accountFragment.O0(), 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: INVOKE  
                      (wrap: com.clubhouse.android.ui.profile.settings.AccountViewModel : 0x0009: INVOKE  (r0v2 com.clubhouse.android.ui.profile.settings.AccountViewModel A[REMOVE]) = (r3v1 'accountFragment' com.clubhouse.android.ui.profile.settings.AccountFragment) type: VIRTUAL call: com.clubhouse.android.ui.profile.settings.AccountFragment.O0():com.clubhouse.android.ui.profile.settings.AccountViewModel)
                      (wrap: com.clubhouse.android.ui.profile.settings.AccountFragment$onViewCreated$4$1 : 0x000f: CONSTRUCTOR  (r1v0 com.clubhouse.android.ui.profile.settings.AccountFragment$onViewCreated$4$1 A[REMOVE]) = (r3v1 'accountFragment' com.clubhouse.android.ui.profile.settings.AccountFragment) call: com.clubhouse.android.ui.profile.settings.AccountFragment$onViewCreated$4$1.<init>(com.clubhouse.android.ui.profile.settings.AccountFragment):void type: CONSTRUCTOR)
                     type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: i0.e.b.g3.u.z5.a.onClick(android.view.View):void, file: classes3.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.profile.settings.AccountFragment$onViewCreated$4$1, state: NOT_LOADED
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
                    com.clubhouse.android.ui.profile.settings.AccountFragment r3 = com.clubhouse.android.ui.profile.settings.AccountFragment.this
                    m0.r.k<java.lang.Object>[] r0 = com.clubhouse.android.ui.profile.settings.AccountFragment.Z1
                    java.lang.String r0 = "this$0"
                    m0.n.b.i.e(r3, r0)
                    com.clubhouse.android.ui.profile.settings.AccountViewModel r0 = r3.O0()
                    com.clubhouse.android.ui.profile.settings.AccountFragment$onViewCreated$4$1 r1 = new com.clubhouse.android.ui.profile.settings.AccountFragment$onViewCreated$4$1
                    r1.<init>(r3)
                    h0.b0.v.v2(r0, r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.u.z5.a.onClick(android.view.View):void");
            }
        });
        TextView textView3 = N0().e;
        i.d(textView3, "binding.twitter");
        p viewLifecycleOwner5 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner5, "viewLifecycleOwner");
        i0.e.b.d3.k.H(textView3, q.a(viewLifecycleOwner5), new View.OnClickListener() { // from class: i0.e.b.g3.u.z5.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AccountFragment accountFragment = AccountFragment.this;
                k<Object>[] kVarArr = AccountFragment.Z1;
                i.e(accountFragment, "this$0");
                v.v2(accountFragment.O0(), 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: INVOKE  
                      (wrap: com.clubhouse.android.ui.profile.settings.AccountViewModel : 0x0009: INVOKE  (r0v2 com.clubhouse.android.ui.profile.settings.AccountViewModel A[REMOVE]) = (r3v1 'accountFragment' com.clubhouse.android.ui.profile.settings.AccountFragment) type: VIRTUAL call: com.clubhouse.android.ui.profile.settings.AccountFragment.O0():com.clubhouse.android.ui.profile.settings.AccountViewModel)
                      (wrap: com.clubhouse.android.ui.profile.settings.AccountFragment$onViewCreated$5$1 : 0x000f: CONSTRUCTOR  (r1v0 com.clubhouse.android.ui.profile.settings.AccountFragment$onViewCreated$5$1 A[REMOVE]) = (r3v1 'accountFragment' com.clubhouse.android.ui.profile.settings.AccountFragment) call: com.clubhouse.android.ui.profile.settings.AccountFragment$onViewCreated$5$1.<init>(com.clubhouse.android.ui.profile.settings.AccountFragment):void type: CONSTRUCTOR)
                     type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: i0.e.b.g3.u.z5.c.onClick(android.view.View):void, file: classes3.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.profile.settings.AccountFragment$onViewCreated$5$1, state: NOT_LOADED
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
                    com.clubhouse.android.ui.profile.settings.AccountFragment r3 = com.clubhouse.android.ui.profile.settings.AccountFragment.this
                    m0.r.k<java.lang.Object>[] r0 = com.clubhouse.android.ui.profile.settings.AccountFragment.Z1
                    java.lang.String r0 = "this$0"
                    m0.n.b.i.e(r3, r0)
                    com.clubhouse.android.ui.profile.settings.AccountViewModel r0 = r3.O0()
                    com.clubhouse.android.ui.profile.settings.AccountFragment$onViewCreated$5$1 r1 = new com.clubhouse.android.ui.profile.settings.AccountFragment$onViewCreated$5$1
                    r1.<init>(r3)
                    h0.b0.v.v2(r0, r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.u.z5.c.onClick(android.view.View):void");
            }
        });
    }
}
