package com.clubhouse.android.ui.onboarding;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.clubhouse.android.databinding.FragmentCollectUsernameWithSuggestionsBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.ui.onboarding.CollectUsernameWithSuggestionsFragment;
import com.clubhouse.app.R;
import h0.b0.v;
import h0.i.b.a;
import h0.q.p;
import h0.q.q;
import i0.b.b.e;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.e.b.g3.r.c2;
import i0.e.b.g3.r.w0;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.c;
import m0.n.a.l;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
/* compiled from: CollectUsernameWithSuggestionsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0014\u001a\u00020\u000f8@@\u0000X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u001a\u001a\u00020\u00158\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010 \u001a\u00020\u001b8@@\u0000X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/clubhouse/android/ui/onboarding/CollectUsernameWithSuggestionsFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "", "displayedText", "P0", "(Ljava/lang/String;)V", "Lcom/clubhouse/android/databinding/FragmentCollectUsernameWithSuggestionsBinding;", "a2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "N0", "()Lcom/clubhouse/android/databinding/FragmentCollectUsernameWithSuggestionsBinding;", "binding", "", "c2", "Z", "K0", "()Z", "shouldShowKeyboard", "Lcom/clubhouse/android/ui/onboarding/CollectUsernameViewModel;", "b2", "Lm0/c;", "O0", "()Lcom/clubhouse/android/ui/onboarding/CollectUsernameViewModel;", "viewModel", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class CollectUsernameWithSuggestionsFragment extends Hilt_CollectUsernameWithSuggestionsFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(CollectUsernameWithSuggestionsFragment.class), "binding", "getBinding$app_productionRelease()Lcom/clubhouse/android/databinding/FragmentCollectUsernameWithSuggestionsBinding;")), m.c(new PropertyReference1Impl(m.a(CollectUsernameWithSuggestionsFragment.class), "viewModel", "getViewModel$app_productionRelease()Lcom/clubhouse/android/ui/onboarding/CollectUsernameViewModel;"))};
    public final c b2;
    public final FragmentViewBindingDelegate a2 = new FragmentViewBindingDelegate(FragmentCollectUsernameWithSuggestionsBinding.class, this);
    public final boolean c2 = true;

    /* compiled from: CollectUsernameWithSuggestionsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x0028, code lost:
            if (kotlin.text.StringsKt__IndentKt.H(r2, "@", false, 2) == false) goto L_0x002a;
         */
        @Override // android.text.TextWatcher
        /* Code decompiled incorrectly, please refer to instructions dump */
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            boolean z = false;
            if (CollectUsernameWithSuggestionsFragment.this.N0().h.length() >= 1) {
                Editable text = CollectUsernameWithSuggestionsFragment.this.N0().h.getText();
                i.d(text, "binding.username.text");
            }
            CollectUsernameWithSuggestionsFragment.this.N0().h.setText("@");
            CollectUsernameWithSuggestionsFragment.this.N0().h.setSelection(CollectUsernameWithSuggestionsFragment.this.N0().h.length());
            Button button = CollectUsernameWithSuggestionsFragment.this.N0().e;
            i.d(button, "binding.nextButton");
            if (CollectUsernameWithSuggestionsFragment.this.N0().h.length() > 1) {
                z = true;
            }
            i0.e.b.d3.k.k(button, Boolean.valueOf(z));
        }
    }

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class b extends h<CollectUsernameWithSuggestionsFragment, CollectUsernameViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public b(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<CollectUsernameViewModel> a(CollectUsernameWithSuggestionsFragment collectUsernameWithSuggestionsFragment, k kVar) {
            CollectUsernameWithSuggestionsFragment collectUsernameWithSuggestionsFragment2 = collectUsernameWithSuggestionsFragment;
            i.e(collectUsernameWithSuggestionsFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(collectUsernameWithSuggestionsFragment2, kVar, this.a, new CollectUsernameWithSuggestionsFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(w0.class), false, this.b);
        }
    }

    public CollectUsernameWithSuggestionsFragment() {
        super(R.layout.fragment_collect_username_with_suggestions);
        d a2 = m.a(CollectUsernameViewModel.class);
        this.b2 = new b(a2, false, new l<i0.b.b.k<CollectUsernameViewModel, w0>, CollectUsernameViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.onboarding.CollectUsernameWithSuggestionsFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.airbnb.mvrx.MavericksViewModel, com.clubhouse.android.ui.onboarding.CollectUsernameViewModel] */
            @Override // m0.n.a.l
            public CollectUsernameViewModel invoke(i0.b.b.k<CollectUsernameViewModel, w0> kVar) {
                i0.b.b.k<CollectUsernameViewModel, w0> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, w0.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, Z1[1]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(O0(), new l<w0, m0.i>() { // from class: com.clubhouse.android.ui.onboarding.CollectUsernameWithSuggestionsFragment$invalidate$1
            @Override // m0.n.a.l
            public m0.i invoke(w0 w0Var) {
                w0 w0Var2 = w0Var;
                i.e(w0Var2, "state");
                Button button = CollectUsernameWithSuggestionsFragment.this.N0().e;
                i.d(button, "binding.nextButton");
                i0.e.b.d3.k.k(button, Boolean.valueOf(CollectUsernameWithSuggestionsFragment.this.N0().h.length() > 1));
                ProgressBar progressBar = CollectUsernameWithSuggestionsFragment.this.N0().d;
                i.d(progressBar, "binding.loading");
                i0.e.b.d3.k.L(progressBar, Boolean.valueOf(w0Var2.f));
                FrameLayout frameLayout = CollectUsernameWithSuggestionsFragment.this.N0().c;
                i.d(frameLayout, "binding.fullscreenLoading");
                i0.e.b.d3.k.L(frameLayout, Boolean.valueOf(w0Var2.g instanceof e));
                TextView textView = CollectUsernameWithSuggestionsFragment.this.N0().b;
                i.d(textView, "binding.defaultSuggestion");
                i0.e.b.d3.k.L(textView, Boolean.valueOf(!w0Var2.e));
                Button button2 = CollectUsernameWithSuggestionsFragment.this.N0().a;
                i.d(button2, "binding.changeUsernameButton");
                i0.e.b.d3.k.L(button2, Boolean.valueOf(!w0Var2.e));
                TextView textView2 = CollectUsernameWithSuggestionsFragment.this.N0().g;
                i.d(textView2, "binding.titleHint");
                i0.e.b.d3.k.L(textView2, Boolean.valueOf(w0Var2.e));
                EditText editText = CollectUsernameWithSuggestionsFragment.this.N0().h;
                i.d(editText, "binding.username");
                i0.e.b.d3.k.L(editText, Boolean.valueOf(w0Var2.e));
                TextView textView3 = CollectUsernameWithSuggestionsFragment.this.N0().f;
                i.d(textView3, "binding.suggestions");
                i0.e.b.d3.k.L(textView3, Boolean.valueOf(w0Var2.e && w0Var2.h));
                CollectUsernameWithSuggestionsFragment collectUsernameWithSuggestionsFragment = CollectUsernameWithSuggestionsFragment.this;
                Objects.requireNonNull(collectUsernameWithSuggestionsFragment);
                List<String> list = w0Var2.d;
                ArrayList arrayList = new ArrayList(i0.j.f.p.h.K(list, 10));
                for (String str : list) {
                    Context requireContext = collectUsernameWithSuggestionsFragment.requireContext();
                    i.d(requireContext, "requireContext()");
                    int length = str.length();
                    i.e(str, "<this>");
                    i.e(requireContext, "context");
                    new SpannableString(str).setSpan(new ForegroundColorSpan(a.getColor(requireContext, R.color.clubhouse_blue)), 0, length, 33);
                    CollectUsernameWithSuggestionsFragment$updateUsernameSuggestions$formattedSuggestions$1$1 collectUsernameWithSuggestionsFragment$updateUsernameSuggestions$formattedSuggestions$1$1 = 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x012a: CONSTRUCTOR  (r9v3 'collectUsernameWithSuggestionsFragment$updateUsernameSuggestions$formattedSuggestions$1$1' com.clubhouse.android.ui.onboarding.CollectUsernameWithSuggestionsFragment$updateUsernameSuggestions$formattedSuggestions$1$1) = 
                          (r2v25 'collectUsernameWithSuggestionsFragment' com.clubhouse.android.ui.onboarding.CollectUsernameWithSuggestionsFragment)
                          (r7v7 'str' java.lang.String)
                         call: com.clubhouse.android.ui.onboarding.CollectUsernameWithSuggestionsFragment$updateUsernameSuggestions$formattedSuggestions$1$1.<init>(com.clubhouse.android.ui.onboarding.CollectUsernameWithSuggestionsFragment, java.lang.String):void type: CONSTRUCTOR in method: com.clubhouse.android.ui.onboarding.CollectUsernameWithSuggestionsFragment$invalidate$1.invoke(i0.e.b.g3.r.w0):m0.i, file: classes3.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:206)
                        	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:173)
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
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.onboarding.CollectUsernameWithSuggestionsFragment$updateUsernameSuggestions$formattedSuggestions$1$1, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                        	... 21 more
                        */
                    /*
                    // Method dump skipped, instructions count: 450
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.clubhouse.android.ui.onboarding.CollectUsernameWithSuggestionsFragment$invalidate$1.invoke(java.lang.Object):java.lang.Object");
                }
            });
        }

        @Override // com.clubhouse.android.core.ui.BaseFragment
        public boolean K0() {
            return this.c2;
        }

        public final FragmentCollectUsernameWithSuggestionsBinding N0() {
            return (FragmentCollectUsernameWithSuggestionsBinding) this.a2.getValue(this, Z1[0]);
        }

        public final CollectUsernameViewModel O0() {
            return (CollectUsernameViewModel) this.b2.getValue();
        }

        public final void P0(String str) {
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            String substring = str.substring(1);
            i.d(substring, "(this as java.lang.String).substring(startIndex)");
            O0().p(new c2(substring));
        }

        @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
        public void onViewCreated(View view, Bundle bundle) {
            i.e(view, "view");
            super.onViewCreated(view, bundle);
            v.V(this);
            N0().e.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.r.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CollectUsernameWithSuggestionsFragment collectUsernameWithSuggestionsFragment = CollectUsernameWithSuggestionsFragment.this;
                    k<Object>[] kVarArr = CollectUsernameWithSuggestionsFragment.Z1;
                    i.e(collectUsernameWithSuggestionsFragment, "this$0");
                    collectUsernameWithSuggestionsFragment.P0(collectUsernameWithSuggestionsFragment.N0().h.getText().toString());
                }
            });
            N0().a.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.r.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    CollectUsernameWithSuggestionsFragment collectUsernameWithSuggestionsFragment = CollectUsernameWithSuggestionsFragment.this;
                    m0.r.k<Object>[] kVarArr = CollectUsernameWithSuggestionsFragment.Z1;
                    i.e(collectUsernameWithSuggestionsFragment, "this$0");
                    collectUsernameWithSuggestionsFragment.O0().p(w1.a);
                }
            });
            EditText editText = N0().h;
            i.d(editText, "binding.username");
            i0.e.b.d3.k.B(editText, new m0.n.a.a<m0.i>() { // from class: com.clubhouse.android.ui.onboarding.CollectUsernameWithSuggestionsFragment$onViewCreated$3
                @Override // m0.n.a.a
                public m0.i invoke() {
                    CollectUsernameWithSuggestionsFragment collectUsernameWithSuggestionsFragment = CollectUsernameWithSuggestionsFragment.this;
                    collectUsernameWithSuggestionsFragment.P0(collectUsernameWithSuggestionsFragment.N0().h.getText().toString());
                    return m0.i.a;
                }
            });
            N0().h.addTextChangedListener(new a());
            FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(O0().l, new CollectUsernameWithSuggestionsFragment$handleEffects$1(this, null));
            p viewLifecycleOwner = getViewLifecycleOwner();
            i.d(viewLifecycleOwner, "viewLifecycleOwner");
            m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner));
        }
    }
