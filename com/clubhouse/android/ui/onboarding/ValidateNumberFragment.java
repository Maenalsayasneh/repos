package com.clubhouse.android.ui.onboarding;

import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import com.airbnb.mvrx.MavericksViewModel;
import com.clubhouse.analytics.AmplitudeAnalytics;
import com.clubhouse.android.databinding.FragmentValidateNumberBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.ui.onboarding.ValidateNumberFragment;
import com.clubhouse.android.ui.onboarding.ValidateNumberViewModel;
import com.clubhouse.android.ui.onboarding.ValidateNumberViewModel$resendCode$3;
import com.clubhouse.android.ui.onboarding.ValidateNumberViewModel$resendCode$6;
import com.clubhouse.app.R;
import h0.b0.v;
import i0.b.b.b;
import i0.b.b.f;
import i0.b.b.g;
import i0.b.b.g0;
import i0.b.b.h;
import i0.b.b.i;
import i0.b.b.x;
import i0.e.b.g3.r.e2;
import i0.e.b.g3.r.p2;
import i0.e.b.g3.r.t1;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.text.StringsKt__IndentKt;
import m0.c;
import m0.n.a.l;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
/* compiled from: ValidateNumberFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010\fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\u00020\r8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0018\u001a\u00020\u00138\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001e\u001a\u00020\u00198B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010$\u001a\u00020\u001f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/clubhouse/android/ui/onboarding/ValidateNumberFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lcom/clubhouse/android/databinding/FragmentValidateNumberBinding;", "a2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "N0", "()Lcom/clubhouse/android/databinding/FragmentValidateNumberBinding;", "binding", "", "d2", "Z", "K0", "()Z", "shouldShowKeyboard", "Lcom/clubhouse/android/ui/onboarding/ValidateNumberViewModel;", "b2", "Lm0/c;", "O0", "()Lcom/clubhouse/android/ui/onboarding/ValidateNumberViewModel;", "viewModel", "Lcom/clubhouse/android/ui/onboarding/ValidateNumberArgs;", "c2", "Lm0/o/c;", "getArgs", "()Lcom/clubhouse/android/ui/onboarding/ValidateNumberArgs;", "args", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class ValidateNumberFragment extends Hilt_ValidateNumberFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(ValidateNumberFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentValidateNumberBinding;")), m.c(new PropertyReference1Impl(m.a(ValidateNumberFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/onboarding/ValidateNumberViewModel;")), m.c(new PropertyReference1Impl(m.a(ValidateNumberFragment.class), "args", "getArgs()Lcom/clubhouse/android/ui/onboarding/ValidateNumberArgs;"))};
    public final c b2;
    public final FragmentViewBindingDelegate a2 = new FragmentViewBindingDelegate(FragmentValidateNumberBinding.class, this);
    public final m0.o.c c2 = new i();
    public final boolean d2 = true;

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<ValidateNumberFragment, ValidateNumberViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<ValidateNumberViewModel> a(ValidateNumberFragment validateNumberFragment, k kVar) {
            ValidateNumberFragment validateNumberFragment2 = validateNumberFragment;
            m0.n.b.i.e(validateNumberFragment2, "thisRef");
            m0.n.b.i.e(kVar, "property");
            return g.a.b(validateNumberFragment2, kVar, this.a, new ValidateNumberFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(t1.class), false, this.b);
        }
    }

    public ValidateNumberFragment() {
        super(R.layout.fragment_validate_number);
        d a2 = m.a(ValidateNumberViewModel.class);
        this.b2 = new a(a2, false, new l<i0.b.b.k<ValidateNumberViewModel, t1>, ValidateNumberViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.onboarding.ValidateNumberFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.clubhouse.android.ui.onboarding.ValidateNumberViewModel, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.l
            public ValidateNumberViewModel invoke(i0.b.b.k<ValidateNumberViewModel, t1> kVar) {
                i0.b.b.k<ValidateNumberViewModel, t1> kVar2 = kVar;
                m0.n.b.i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                m0.n.b.i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                m0.n.b.i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, t1.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, Z1[1]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(O0(), new l<t1, m0.i>() { // from class: com.clubhouse.android.ui.onboarding.ValidateNumberFragment$invalidate$1
            @Override // m0.n.a.l
            public m0.i invoke(t1 t1Var) {
                t1 t1Var2 = t1Var;
                m0.n.b.i.e(t1Var2, "state");
                ValidateNumberFragment validateNumberFragment = ValidateNumberFragment.this;
                k<Object>[] kVarArr = ValidateNumberFragment.Z1;
                Button button = validateNumberFragment.N0().e;
                m0.n.b.i.d(button, "binding.resendButton");
                boolean z = true;
                int i = 0;
                boolean z2 = button.getVisibility() == 0;
                b<p2> bVar = t1Var2.b;
                if (z2 != (bVar instanceof g0)) {
                    boolean z3 = bVar instanceof i0.b.b.c;
                }
                ProgressBar progressBar = ValidateNumberFragment.this.N0().c;
                m0.n.b.i.d(progressBar, "binding.loading");
                if (!(t1Var2.b instanceof f) && !(t1Var2.c instanceof f) && !(t1Var2.d instanceof f)) {
                    z = false;
                }
                if (!z) {
                    i = 8;
                }
                progressBar.setVisibility(i);
                if (t1Var2.g) {
                    ValidateNumberFragment.this.N0().e.setText(ValidateNumberFragment.this.getString(R.string.phone_call));
                }
                return m0.i.a;
            }
        });
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment
    public boolean K0() {
        return this.d2;
    }

    public final FragmentValidateNumberBinding N0() {
        return (FragmentValidateNumberBinding) this.a2.getValue(this, Z1[0]);
    }

    public final ValidateNumberViewModel O0() {
        return (ValidateNumberViewModel) this.b2.getValue();
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.g1(this, O0(), ValidateNumberFragment$onCreate$1.c, v.q2(this, null, 1, null), new ValidateNumberFragment$onCreate$2(this, null), new ValidateNumberFragment$onCreate$3(this, null));
        v.g1(this, O0(), ValidateNumberFragment$onCreate$4.c, v.q2(this, null, 1, null), new ValidateNumberFragment$onCreate$5(this, null), new ValidateNumberFragment$onCreate$6(this, null));
        v.g1(this, O0(), ValidateNumberFragment$onCreate$7.c, v.q2(this, null, 1, null), new ValidateNumberFragment$onCreate$8(this, null), new ValidateNumberFragment$onCreate$9(this, null));
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        m0.n.b.i.d(onBackPressedDispatcher, "requireActivity().onBackPressedDispatcher");
        g0.a.b.b.a.a(onBackPressedDispatcher, this, false, new l<h0.a.b, m0.i>() { // from class: com.clubhouse.android.ui.onboarding.ValidateNumberFragment$onCreate$10
            @Override // m0.n.a.l
            public m0.i invoke(h0.a.b bVar) {
                m0.n.b.i.e(bVar, "$this$addCallback");
                ((AmplitudeAnalytics) v.l(ValidateNumberFragment.this)).a("Onboarding-PhoneVerify-GoBack");
                v.c1(ValidateNumberFragment.this);
                return m0.i.a;
            }
        }, 2);
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        int intValue;
        m0.n.b.i.e(view, "view");
        super.onViewCreated(view, bundle);
        N0().a.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.r.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ValidateNumberFragment validateNumberFragment = ValidateNumberFragment.this;
                k<Object>[] kVarArr = ValidateNumberFragment.Z1;
                m0.n.b.i.e(validateNumberFragment, "this$0");
                ((AmplitudeAnalytics) v.l(validateNumberFragment)).a("Onboarding-PhoneVerify-GoBack");
                v.c1(validateNumberFragment);
            }
        });
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.c = 4;
        Integer num = ((ValidateNumberArgs) this.c2.getValue(this, Z1[2])).d;
        if (num != null && (intValue = num.intValue()) > 0) {
            ref$IntRef.c = intValue;
        }
        N0().b.setHint(StringsKt__IndentKt.z("• ", ref$IntRef.c));
        EditText editText = N0().b;
        InputFilter[] filters = editText.getFilters();
        m0.n.b.i.d(filters, "binding.code.filters");
        InputFilter.LengthFilter lengthFilter = new InputFilter.LengthFilter(ref$IntRef.c);
        m0.n.b.i.e(filters, "$this$plus");
        int length = filters.length;
        Object[] copyOf = Arrays.copyOf(filters, length + 1);
        copyOf[length] = lengthFilter;
        m0.n.b.i.d(copyOf, "result");
        editText.setFilters((InputFilter[]) copyOf);
        EditText editText2 = N0().b;
        m0.n.b.i.d(editText2, "binding.code");
        editText2.addTextChangedListener(new e2(ref$IntRef, this));
        EditText editText3 = N0().b;
        m0.n.b.i.d(editText3, "binding.code");
        i0.e.b.d3.k.B(editText3, new m0.n.a.a<m0.i>() { // from class: com.clubhouse.android.ui.onboarding.ValidateNumberFragment$bindCode$3
            @Override // m0.n.a.a
            public m0.i invoke() {
                ValidateNumberFragment validateNumberFragment = ValidateNumberFragment.this;
                k<Object>[] kVarArr = ValidateNumberFragment.Z1;
                validateNumberFragment.O0().q(ValidateNumberFragment.this.N0().b.getText().toString());
                return m0.i.a;
            }
        });
        Button button = N0().d;
        m0.n.b.i.d(button, "binding.nextButton");
        i0.e.b.d3.k.h(button);
        N0().d.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.r.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ValidateNumberFragment validateNumberFragment = ValidateNumberFragment.this;
                k<Object>[] kVarArr = ValidateNumberFragment.Z1;
                m0.n.b.i.e(validateNumberFragment, "this$0");
                validateNumberFragment.O0().q(validateNumberFragment.N0().b.getText().toString());
            }
        });
        N0().e.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.r.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ValidateNumberFragment validateNumberFragment = ValidateNumberFragment.this;
                k<Object>[] kVarArr = ValidateNumberFragment.Z1;
                m0.n.b.i.e(validateNumberFragment, "this$0");
                ValidateNumberViewModel O0 = validateNumberFragment.O0();
                Objects.requireNonNull(O0);
                if (TimeUnit.SECONDS.convert(System.nanoTime() - O0.q, TimeUnit.NANOSECONDS) < 15) {
                    O0.m(x.c);
                } else {
                    O0.m(x.d);
                    O0.q = System.nanoTime();
                    int i = O0.r;
                    if (i <= 2) {
                        MavericksViewModel.f(O0, new ValidateNumberViewModel$resendCode$3(O0, null), null, null, d.c, 3, null);
                        if (O0.r == 2) {
                            O0.m(x.q);
                        }
                    } else if (i <= 4) {
                        MavericksViewModel.f(O0, new ValidateNumberViewModel$resendCode$6(O0, null), null, null, d.d, 3, null);
                    } else {
                        O0.m(x.x);
                    }
                    O0.r++;
                }
                v.v2(validateNumberFragment.O0(), 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0088: INVOKE  
                      (wrap: com.clubhouse.android.ui.onboarding.ValidateNumberViewModel : 0x007f: INVOKE  (r0v3 com.clubhouse.android.ui.onboarding.ValidateNumberViewModel A[REMOVE]) = (r11v1 'validateNumberFragment' com.clubhouse.android.ui.onboarding.ValidateNumberFragment) type: VIRTUAL call: com.clubhouse.android.ui.onboarding.ValidateNumberFragment.O0():com.clubhouse.android.ui.onboarding.ValidateNumberViewModel)
                      (wrap: com.clubhouse.android.ui.onboarding.ValidateNumberFragment$onViewCreated$3$1 : 0x0085: CONSTRUCTOR  (r1v4 com.clubhouse.android.ui.onboarding.ValidateNumberFragment$onViewCreated$3$1 A[REMOVE]) = (r11v1 'validateNumberFragment' com.clubhouse.android.ui.onboarding.ValidateNumberFragment) call: com.clubhouse.android.ui.onboarding.ValidateNumberFragment$onViewCreated$3$1.<init>(com.clubhouse.android.ui.onboarding.ValidateNumberFragment):void type: CONSTRUCTOR)
                     type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: i0.e.b.g3.r.y.onClick(android.view.View):void, file: classes3.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.onboarding.ValidateNumberFragment$onViewCreated$3$1, state: NOT_LOADED
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
                    com.clubhouse.android.ui.onboarding.ValidateNumberFragment r11 = com.clubhouse.android.ui.onboarding.ValidateNumberFragment.this
                    m0.r.k<java.lang.Object>[] r0 = com.clubhouse.android.ui.onboarding.ValidateNumberFragment.Z1
                    java.lang.String r0 = "this$0"
                    m0.n.b.i.e(r11, r0)
                    com.clubhouse.android.ui.onboarding.ValidateNumberViewModel r0 = r11.O0()
                    java.util.Objects.requireNonNull(r0)
                    long r1 = java.lang.System.nanoTime()
                    java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS
                    long r4 = r0.q
                    long r1 = r1 - r4
                    java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.NANOSECONDS
                    long r1 = r3.convert(r1, r4)
                    r3 = 15
                    int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                    if (r1 >= 0) goto L_0x002b
                    x r1 = defpackage.x.c
                    r0.m(r1)
                    goto L_0x007f
                L_0x002b:
                    x r1 = defpackage.x.d
                    r0.m(r1)
                    long r1 = java.lang.System.nanoTime()
                    r0.q = r1
                    int r1 = r0.r
                    r2 = 0
                    r8 = 2
                    if (r1 > r8) goto L_0x005b
                    com.clubhouse.android.ui.onboarding.ValidateNumberViewModel$resendCode$3 r3 = new com.clubhouse.android.ui.onboarding.ValidateNumberViewModel$resendCode$3
                    r3.<init>(r0, r2)
                    r4 = 0
                    r5 = 0
                    d r6 = defpackage.d.c
                    r7 = 3
                    r9 = 0
                    r1 = r0
                    r2 = r3
                    r3 = r4
                    r4 = r5
                    r5 = r6
                    r6 = r7
                    r7 = r9
                    com.airbnb.mvrx.MavericksViewModel.f(r1, r2, r3, r4, r5, r6, r7)
                    int r1 = r0.r
                    if (r1 != r8) goto L_0x0079
                    x r1 = defpackage.x.q
                    r0.m(r1)
                    goto L_0x0079
                L_0x005b:
                    r3 = 4
                    if (r1 > r3) goto L_0x0074
                    com.clubhouse.android.ui.onboarding.ValidateNumberViewModel$resendCode$6 r3 = new com.clubhouse.android.ui.onboarding.ValidateNumberViewModel$resendCode$6
                    r3.<init>(r0, r2)
                    r4 = 0
                    r5 = 0
                    d r6 = defpackage.d.d
                    r7 = 3
                    r8 = 0
                    r1 = r0
                    r2 = r3
                    r3 = r4
                    r4 = r5
                    r5 = r6
                    r6 = r7
                    r7 = r8
                    com.airbnb.mvrx.MavericksViewModel.f(r1, r2, r3, r4, r5, r6, r7)
                    goto L_0x0079
                L_0x0074:
                    x r1 = defpackage.x.x
                    r0.m(r1)
                L_0x0079:
                    int r1 = r0.r
                    int r1 = r1 + 1
                    r0.r = r1
                L_0x007f:
                    com.clubhouse.android.ui.onboarding.ValidateNumberViewModel r0 = r11.O0()
                    com.clubhouse.android.ui.onboarding.ValidateNumberFragment$onViewCreated$3$1 r1 = new com.clubhouse.android.ui.onboarding.ValidateNumberFragment$onViewCreated$3$1
                    r1.<init>(r11)
                    h0.b0.v.v2(r0, r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.r.y.onClick(android.view.View):void");
            }
        });
    }
}
