package com.clubhouse.android.ui.onboarding;

import android.os.Bundle;
import android.text.Annotation;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.clubhouse.android.databinding.FragmentCollectPhoneNumberBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.ui.onboarding.CollectPhoneNumberFragment;
import com.clubhouse.app.R;
import h0.b.a.d;
import h0.b0.v;
import h0.q.p;
import h0.q.q;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.e.b.g3.r.d2;
import i0.e.b.g3.r.e;
import i0.e.b.g3.r.p0;
import i0.e.b.g3.r.q0;
import i0.e.b.g3.r.r0;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.c;
import m0.n.a.l;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
/* compiled from: CollectPhoneNumberFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nR\u001c\u0010\u0011\u001a\u00020\f8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0017\u001a\u00020\u00128B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001d\u001a\u00020\u00188B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/clubhouse/android/ui/onboarding/CollectPhoneNumberFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "P0", "", "c2", "Z", "K0", "()Z", "shouldShowKeyboard", "Lcom/clubhouse/android/ui/onboarding/CollectPhoneNumberViewModel;", "b2", "Lm0/c;", "O0", "()Lcom/clubhouse/android/ui/onboarding/CollectPhoneNumberViewModel;", "viewModel", "Lcom/clubhouse/android/databinding/FragmentCollectPhoneNumberBinding;", "a2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "N0", "()Lcom/clubhouse/android/databinding/FragmentCollectPhoneNumberBinding;", "binding", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class CollectPhoneNumberFragment extends Hilt_CollectPhoneNumberFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(CollectPhoneNumberFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentCollectPhoneNumberBinding;")), m.c(new PropertyReference1Impl(m.a(CollectPhoneNumberFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/onboarding/CollectPhoneNumberViewModel;"))};
    public final c b2;
    public final FragmentViewBindingDelegate a2 = new FragmentViewBindingDelegate(FragmentCollectPhoneNumberBinding.class, this);
    public final boolean c2 = true;

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<CollectPhoneNumberFragment, CollectPhoneNumberViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<CollectPhoneNumberViewModel> a(CollectPhoneNumberFragment collectPhoneNumberFragment, k kVar) {
            CollectPhoneNumberFragment collectPhoneNumberFragment2 = collectPhoneNumberFragment;
            i.e(collectPhoneNumberFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(collectPhoneNumberFragment2, kVar, this.a, new CollectPhoneNumberFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(p0.class), false, this.b);
        }
    }

    public CollectPhoneNumberFragment() {
        super(R.layout.fragment_collect_phone_number);
        d a2 = m.a(CollectPhoneNumberViewModel.class);
        this.b2 = new a(a2, false, new l<i0.b.b.k<CollectPhoneNumberViewModel, p0>, CollectPhoneNumberViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.onboarding.CollectPhoneNumberFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.airbnb.mvrx.MavericksViewModel, com.clubhouse.android.ui.onboarding.CollectPhoneNumberViewModel] */
            @Override // m0.n.a.l
            public CollectPhoneNumberViewModel invoke(i0.b.b.k<CollectPhoneNumberViewModel, p0> kVar) {
                i0.b.b.k<CollectPhoneNumberViewModel, p0> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, p0.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, Z1[1]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(O0(), new l<p0, m0.i>() { // from class: com.clubhouse.android.ui.onboarding.CollectPhoneNumberFragment$invalidate$1
            @Override // m0.n.a.l
            public m0.i invoke(p0 p0Var) {
                p0 p0Var2 = p0Var;
                i.e(p0Var2, "state");
                CollectPhoneNumberFragment collectPhoneNumberFragment = CollectPhoneNumberFragment.this;
                k<Object>[] kVarArr = CollectPhoneNumberFragment.Z1;
                ProgressBar progressBar = collectPhoneNumberFragment.N0().b;
                i.d(progressBar, "binding.loading");
                progressBar.setVisibility(p0Var2.a ? 0 : 8);
                return m0.i.a;
            }
        });
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment
    public boolean K0() {
        return this.c2;
    }

    public final FragmentCollectPhoneNumberBinding N0() {
        return (FragmentCollectPhoneNumberBinding) this.a2.getValue(this, Z1[0]);
    }

    public final CollectPhoneNumberViewModel O0() {
        return (CollectPhoneNumberViewModel) this.b2.getValue();
    }

    public final void P0() {
        String fullNumberWithPlus = N0().a.getFullNumberWithPlus();
        if (N0().a.f()) {
            CollectPhoneNumberViewModel O0 = O0();
            i.d(fullNumberWithPlus, "fullNumber");
            O0.p(new d2(fullNumberWithPlus));
            return;
        }
        CollectPhoneNumberFragment$validatePhoneNumber$1 collectPhoneNumberFragment$validatePhoneNumber$1 = new l<d.a, m0.i>(fullNumberWithPlus) { // from class: com.clubhouse.android.ui.onboarding.CollectPhoneNumberFragment$validatePhoneNumber$1
            public final /* synthetic */ String d;

            {
                this.d = r2;
            }

            @Override // m0.n.a.l
            public m0.i invoke(d.a aVar) {
                d.a aVar2 = aVar;
                i.e(aVar2, "$this$alertDialog");
                aVar2.e(R.string.confirm_phone_number);
                aVar2.a.f = CollectPhoneNumberFragment.this.getString(R.string.may_be_invalid, this.d);
                aVar2.d(R.string.continue_confirmation, 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002e: INVOKE  
                      (r5v1 'aVar2' h0.b.a.d$a)
                      (wrap: int : ?: SGET   com.clubhouse.app.R.string.continue_confirmation int)
                      (wrap: i0.e.b.g3.r.h : 0x002b: CONSTRUCTOR  (r3v1 i0.e.b.g3.r.h A[REMOVE]) = 
                      (wrap: com.clubhouse.android.ui.onboarding.CollectPhoneNumberFragment : 0x0025: IGET  (r1v3 com.clubhouse.android.ui.onboarding.CollectPhoneNumberFragment A[REMOVE]) = 
                      (r4v0 'this' com.clubhouse.android.ui.onboarding.CollectPhoneNumberFragment$validatePhoneNumber$1 A[IMMUTABLE_TYPE, THIS])
                     com.clubhouse.android.ui.onboarding.CollectPhoneNumberFragment$validatePhoneNumber$1.c com.clubhouse.android.ui.onboarding.CollectPhoneNumberFragment)
                      (wrap: java.lang.String : 0x0027: IGET  (r2v2 java.lang.String A[REMOVE]) = 
                      (r4v0 'this' com.clubhouse.android.ui.onboarding.CollectPhoneNumberFragment$validatePhoneNumber$1 A[IMMUTABLE_TYPE, THIS])
                     com.clubhouse.android.ui.onboarding.CollectPhoneNumberFragment$validatePhoneNumber$1.d java.lang.String)
                     call: i0.e.b.g3.r.h.<init>(com.clubhouse.android.ui.onboarding.CollectPhoneNumberFragment, java.lang.String):void type: CONSTRUCTOR)
                     type: VIRTUAL call: h0.b.a.d.a.d(int, android.content.DialogInterface$OnClickListener):h0.b.a.d$a in method: com.clubhouse.android.ui.onboarding.CollectPhoneNumberFragment$validatePhoneNumber$1.invoke(h0.b.a.d$a):m0.i, file: classes3.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: i0.e.b.g3.r.h, state: NOT_LOADED
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
                    h0.b.a.d$a r5 = (h0.b.a.d.a) r5
                    java.lang.String r0 = "$this$alertDialog"
                    m0.n.b.i.e(r5, r0)
                    r0 = 2131951971(0x7f130163, float:1.9540372E38)
                    r5.e(r0)
                    com.clubhouse.android.ui.onboarding.CollectPhoneNumberFragment r0 = com.clubhouse.android.ui.onboarding.CollectPhoneNumberFragment.this
                    r1 = 1
                    java.lang.Object[] r1 = new java.lang.Object[r1]
                    java.lang.String r2 = r4.d
                    r3 = 0
                    r1[r3] = r2
                    r2 = 2131952446(0x7f13033e, float:1.9541335E38)
                    java.lang.String r0 = r0.getString(r2, r1)
                    androidx.appcompat.app.AlertController$b r1 = r5.a
                    r1.f = r0
                    r0 = 2131951984(0x7f130170, float:1.9540398E38)
                    com.clubhouse.android.ui.onboarding.CollectPhoneNumberFragment r1 = com.clubhouse.android.ui.onboarding.CollectPhoneNumberFragment.this
                    java.lang.String r2 = r4.d
                    i0.e.b.g3.r.h r3 = new i0.e.b.g3.r.h
                    r3.<init>(r1, r2)
                    r5.d(r0, r3)
                    r0 = 2131951817(0x7f1300c9, float:1.954006E38)
                    i0.e.b.g3.r.g r1 = i0.e.b.g3.r.g.c
                    r5.c(r0, r1)
                    m0.i r5 = m0.i.a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.clubhouse.android.ui.onboarding.CollectPhoneNumberFragment$validatePhoneNumber$1.invoke(java.lang.Object):java.lang.Object");
            }
        };
        i.e(this, "<this>");
        i.e(collectPhoneNumberFragment$validatePhoneNumber$1, "f");
        d.a aVar = new d.a(requireContext(), com.clubhouse.core.ui.R.style.Clubhouse_AlertDialog_Rounded);
        collectPhoneNumberFragment$validatePhoneNumber$1.invoke(aVar);
        aVar.g();
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Annotation annotation;
        i.e(view, "view");
        super.onViewCreated(view, bundle);
        Annotation annotation2 = null;
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(O0().l, new CollectPhoneNumberFragment$onViewCreated$1(this, null));
        p viewLifecycleOwner = getViewLifecycleOwner();
        i.d(viewLifecycleOwner, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner));
        r0 r0Var = new r0(this);
        q0 q0Var = new q0(this);
        SpannedString spannedString = (SpannedString) getText(R.string.terms_privacy_message);
        SpannableString spannableString = new SpannableString(spannedString);
        int i = 0;
        Annotation[] annotationArr = (Annotation[]) spannedString.getSpans(0, spannedString.length(), Annotation.class);
        if (annotationArr != null) {
            int length = annotationArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    annotation = null;
                    break;
                }
                annotation = annotationArr[i2];
                if (i.a(annotation.getValue(), "terms_link")) {
                    break;
                }
                i2++;
            }
            if (annotation != null) {
                spannableString.setSpan(r0Var, spannedString.getSpanStart(annotation), spannedString.getSpanEnd(annotation), 33);
            }
        }
        if (annotationArr != null) {
            int length2 = annotationArr.length;
            while (true) {
                if (i >= length2) {
                    break;
                }
                Annotation annotation3 = annotationArr[i];
                if (i.a(annotation3.getValue(), "privacy_link")) {
                    annotation2 = annotation3;
                    break;
                }
                i++;
            }
            if (annotation2 != null) {
                spannableString.setSpan(q0Var, spannedString.getSpanStart(annotation2), spannedString.getSpanEnd(annotation2), 33);
            }
        }
        TextView textView = N0().e;
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        N0().a.setEditText_registeredCarrierNumber(N0().d);
        N0().a.setTypeFace(h0.i.b.d.h.a(requireContext(), R.font.nunito_regular));
        N0().a.setPhoneNumberValidityChangeListener(new e(this));
        N0().c.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.r.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CollectPhoneNumberFragment collectPhoneNumberFragment = CollectPhoneNumberFragment.this;
                k<Object>[] kVarArr = CollectPhoneNumberFragment.Z1;
                i.e(collectPhoneNumberFragment, "this$0");
                collectPhoneNumberFragment.P0();
            }
        });
        EditText editText = N0().d;
        i.d(editText, "binding.phoneNumber");
        i0.e.b.d3.k.B(editText, new m0.n.a.a<m0.i>() { // from class: com.clubhouse.android.ui.onboarding.CollectPhoneNumberFragment$onViewCreated$4
            @Override // m0.n.a.a
            public m0.i invoke() {
                CollectPhoneNumberFragment collectPhoneNumberFragment = CollectPhoneNumberFragment.this;
                k<Object>[] kVarArr = CollectPhoneNumberFragment.Z1;
                collectPhoneNumberFragment.P0();
                return m0.i.a;
            }
        });
    }
}
