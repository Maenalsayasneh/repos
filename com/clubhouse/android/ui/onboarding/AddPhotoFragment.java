package com.clubhouse.android.ui.onboarding;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import com.clubhouse.analytics.AmplitudeAnalytics;
import com.clubhouse.android.databinding.FragmentAddPhotoBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.shared.ui.AvatarView;
import com.clubhouse.android.ui.onboarding.AddPhotoFragment;
import com.clubhouse.app.R;
import h0.b0.v;
import i0.b.b.f;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.e.b.g3.r.i0;
import i0.e.b.g3.r.j0;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.PropertyReference1Impl;
import m0.c;
import m0.n.a.l;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
/* compiled from: AddPhotoFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\fR\u001d\u0010\u0017\u001a\u00020\u00128B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001d\u001a\u00020\u00188B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/clubhouse/android/ui/onboarding/AddPhotoFragment;", "Lcom/clubhouse/android/ui/common/PhotoCreationFragment;", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "M0", "(Landroid/net/Uri;)V", "finish", "Li0/e/b/g3/r/j0;", "g2", "Lm0/c;", "S0", "()Li0/e/b/g3/r/j0;", "viewModel", "Lcom/clubhouse/android/databinding/FragmentAddPhotoBinding;", "f2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "R0", "()Lcom/clubhouse/android/databinding/FragmentAddPhotoBinding;", "binding", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class AddPhotoFragment extends Hilt_AddPhotoFragment {
    public static final /* synthetic */ k<Object>[] e2 = {m.c(new PropertyReference1Impl(m.a(AddPhotoFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentAddPhotoBinding;")), m.c(new PropertyReference1Impl(m.a(AddPhotoFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/onboarding/AddPhotoViewModel;"))};
    public final FragmentViewBindingDelegate f2 = new FragmentViewBindingDelegate(FragmentAddPhotoBinding.class, this);
    public final c g2;

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<AddPhotoFragment, j0> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<j0> a(AddPhotoFragment addPhotoFragment, k kVar) {
            AddPhotoFragment addPhotoFragment2 = addPhotoFragment;
            i.e(addPhotoFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(addPhotoFragment2, kVar, this.a, new AddPhotoFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(i0.class), false, this.b);
        }
    }

    public AddPhotoFragment() {
        super(R.layout.fragment_add_photo);
        d a2 = m.a(j0.class);
        this.g2 = new a(a2, false, new l<i0.b.b.k<j0, i0>, j0>(a2, a2) { // from class: com.clubhouse.android.ui.onboarding.AddPhotoFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [i0.e.b.g3.r.j0, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.l
            public j0 invoke(i0.b.b.k<j0, i0> kVar) {
                i0.b.b.k<j0, i0> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, i0.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, e2[1]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(S0(), new l<i0, m0.i>() { // from class: com.clubhouse.android.ui.onboarding.AddPhotoFragment$invalidate$1
            @Override // m0.n.a.l
            public m0.i invoke(i0 i0Var) {
                i0 i0Var2 = i0Var;
                i.e(i0Var2, "state");
                AddPhotoFragment addPhotoFragment = AddPhotoFragment.this;
                k<Object>[] kVarArr = AddPhotoFragment.e2;
                ProgressBar progressBar = addPhotoFragment.R0().b;
                i.d(progressBar, "binding.loading");
                boolean z = false;
                progressBar.setVisibility(i0Var2.b instanceof f ? 0 : 8);
                Button button = AddPhotoFragment.this.R0().c;
                i.d(button, "binding.nextButton");
                if (i0Var2.c != null) {
                    z = true;
                }
                i0.e.b.d3.k.k(button, Boolean.valueOf(z));
                return m0.i.a;
            }
        });
    }

    @Override // com.clubhouse.android.ui.common.PhotoCreationFragment
    public void M0(Uri uri) {
        i.e(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        AvatarView avatarView = R0().a;
        i.d(avatarView, "binding.addPhotoButton");
        v.P0(avatarView, uri);
        j0 S0 = S0();
        Objects.requireNonNull(S0);
        i.e(uri, "contentUri");
        S0.m(new l<i0, i0>(uri) { // from class: com.clubhouse.android.ui.onboarding.AddPhotoViewModel$addPhoto$1
            public final /* synthetic */ Uri c;

            {
                this.c = r1;
            }

            @Override // m0.n.a.l
            public i0 invoke(i0 i0Var) {
                i0 i0Var2 = i0Var;
                i.e(i0Var2, "$this$setState");
                return i0.copy$default(i0Var2, null, null, this.c, false, 11, null);
            }
        });
    }

    public final FragmentAddPhotoBinding R0() {
        return (FragmentAddPhotoBinding) this.f2.getValue(this, e2[0]);
    }

    public final j0 S0() {
        return (j0) this.g2.getValue();
    }

    public final void finish() {
        v.a1(this, (h0.t.l) v.v2(S0(), new l<i0, h0.t.l>() { // from class: com.clubhouse.android.ui.onboarding.AddPhotoFragment$finish$1
            @Override // m0.n.a.l
            public h0.t.l invoke(i0 i0Var) {
                i0 i0Var2 = i0Var;
                i.e(i0Var2, "state");
                ((AmplitudeAnalytics) v.l(AddPhotoFragment.this)).b("Onboarding-Photo-Done", i0.j.f.p.h.S2(new Pair("WithPhoto", Boolean.valueOf(i0Var2.d))));
                return i0Var2.a;
            }
        }), null, 2);
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.V(this);
        v.g1(this, S0(), AddPhotoFragment$onCreate$1.c, v.q2(this, null, 1, null), new AddPhotoFragment$onCreate$2(this, null), new AddPhotoFragment$onCreate$3(this, null));
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.e(view, "view");
        super.onViewCreated(view, bundle);
        R0().c.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.r.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AddPhotoFragment addPhotoFragment = AddPhotoFragment.this;
                k<Object>[] kVarArr = AddPhotoFragment.e2;
                i.e(addPhotoFragment, "this$0");
                j0 S0 = addPhotoFragment.S0();
                Objects.requireNonNull(S0);
                S0.n(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0015: INVOKE  
                      (r0v2 'S0' i0.e.b.g3.r.j0)
                      (wrap: com.clubhouse.android.ui.onboarding.AddPhotoViewModel$savePhoto$1 : 0x0012: CONSTRUCTOR  (r1v0 com.clubhouse.android.ui.onboarding.AddPhotoViewModel$savePhoto$1 A[REMOVE]) = (r0v2 'S0' i0.e.b.g3.r.j0) call: com.clubhouse.android.ui.onboarding.AddPhotoViewModel$savePhoto$1.<init>(i0.e.b.g3.r.j0):void type: CONSTRUCTOR)
                     type: VIRTUAL call: com.airbnb.mvrx.MavericksViewModel.n(m0.n.a.l):void in method: i0.e.b.g3.r.b.onClick(android.view.View):void, file: classes3.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.onboarding.AddPhotoViewModel$savePhoto$1, state: NOT_LOADED
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
                    com.clubhouse.android.ui.onboarding.AddPhotoFragment r3 = com.clubhouse.android.ui.onboarding.AddPhotoFragment.this
                    m0.r.k<java.lang.Object>[] r0 = com.clubhouse.android.ui.onboarding.AddPhotoFragment.e2
                    java.lang.String r0 = "this$0"
                    m0.n.b.i.e(r3, r0)
                    i0.e.b.g3.r.j0 r0 = r3.S0()
                    java.util.Objects.requireNonNull(r0)
                    com.clubhouse.android.ui.onboarding.AddPhotoViewModel$savePhoto$1 r1 = new com.clubhouse.android.ui.onboarding.AddPhotoViewModel$savePhoto$1
                    r1.<init>(r0)
                    r0.n(r1)
                    r3.finish()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.r.b.onClick(android.view.View):void");
            }
        });
        R0().a.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.r.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AddPhotoFragment addPhotoFragment = AddPhotoFragment.this;
                k<Object>[] kVarArr = AddPhotoFragment.e2;
                i.e(addPhotoFragment, "this$0");
                addPhotoFragment.N0();
            }
        });
        R0().d.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.r.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AddPhotoFragment addPhotoFragment = AddPhotoFragment.this;
                k<Object>[] kVarArr = AddPhotoFragment.e2;
                i.e(addPhotoFragment, "this$0");
                addPhotoFragment.finish();
            }
        });
    }
}
