package com.clubhouse.android.ui.onboarding;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Annotation;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.clubhouse.android.databinding.FragmentWaitlistBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.ui.onboarding.WaitlistFragment;
import com.clubhouse.app.R;
import h0.b0.v;
import h0.q.p;
import h0.q.q;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.d.a.a.a;
import i0.e.b.g3.r.q2;
import i0.e.b.g3.r.u2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.c;
import m0.n.a.l;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
/* compiled from: WaitlistFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u00020\u000b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0016\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/clubhouse/android/ui/onboarding/WaitlistFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lcom/clubhouse/android/databinding/FragmentWaitlistBinding;", "a2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "N0", "()Lcom/clubhouse/android/databinding/FragmentWaitlistBinding;", "binding", "Lcom/clubhouse/android/ui/onboarding/WaitlistViewModel;", "b2", "Lm0/c;", "getViewModel", "()Lcom/clubhouse/android/ui/onboarding/WaitlistViewModel;", "viewModel", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class WaitlistFragment extends Hilt_WaitlistFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(WaitlistFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentWaitlistBinding;")), m.c(new PropertyReference1Impl(m.a(WaitlistFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/onboarding/WaitlistViewModel;"))};
    public final FragmentViewBindingDelegate a2 = new FragmentViewBindingDelegate(FragmentWaitlistBinding.class, this);
    public final c b2;

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<WaitlistFragment, WaitlistViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<WaitlistViewModel> a(WaitlistFragment waitlistFragment, k kVar) {
            WaitlistFragment waitlistFragment2 = waitlistFragment;
            i.e(waitlistFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(waitlistFragment2, kVar, this.a, new WaitlistFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(u2.class), false, this.b);
        }
    }

    public WaitlistFragment() {
        super(R.layout.fragment_waitlist);
        d a2 = m.a(WaitlistViewModel.class);
        this.b2 = new a(a2, false, new l<i0.b.b.k<WaitlistViewModel, u2>, WaitlistViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.onboarding.WaitlistFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.clubhouse.android.ui.onboarding.WaitlistViewModel, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.l
            public WaitlistViewModel invoke(i0.b.b.k<WaitlistViewModel, u2> kVar) {
                i0.b.b.k<WaitlistViewModel, u2> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, u2.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, Z1[1]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2((WaitlistViewModel) this.b2.getValue(), new l<u2, m0.i>() { // from class: com.clubhouse.android.ui.onboarding.WaitlistFragment$invalidate$1
            @Override // m0.n.a.l
            public m0.i invoke(u2 u2Var) {
                u2 u2Var2 = u2Var;
                i.e(u2Var2, "state");
                WaitlistFragment waitlistFragment = WaitlistFragment.this;
                k<Object>[] kVarArr = WaitlistFragment.Z1;
                FrameLayout frameLayout = waitlistFragment.N0().b;
                i.d(frameLayout, "binding.loading");
                frameLayout.setVisibility(u2Var2.b ? 0 : 8);
                String str = u2Var2.a;
                if (str == null || StringsKt__IndentKt.o(str)) {
                    WaitlistFragment.this.N0().d.setText(WaitlistFragment.this.getString(R.string.spot_reserved));
                } else {
                    TextView textView = WaitlistFragment.this.N0().d;
                    Resources resources = WaitlistFragment.this.getResources();
                    i.d(resources, "resources");
                    Object[] objArr = {u2Var2.a};
                    ArrayList i1 = a.i1(resources, "<this>", objArr, "rawArgs", 1);
                    for (int i = 0; i < 1; i++) {
                        Object obj = objArr[i];
                        if (obj instanceof String) {
                            String str2 = (String) obj;
                            obj = a.p0(str2, "<this>", str2, 63);
                        }
                        i1.add(obj);
                    }
                    String string = resources.getString(R.string.username_reserved);
                    i.d(string, "getString(id)");
                    Object[] array = i1.toArray(new Object[0]);
                    Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                    Object[] copyOf = Arrays.copyOf(array, array.length);
                    String format = String.format(string, Arrays.copyOf(copyOf, copyOf.length));
                    i.d(format, "java.lang.String.format(format, *args)");
                    Spanned fromHtml = Html.fromHtml(format, 63);
                    i.d(fromHtml, "fromHtml(\n            String.format(getString(id), *args.toTypedArray()),\n            HtmlCompat.FROM_HTML_MODE_COMPACT\n        )");
                    textView.setText(fromHtml);
                }
                return m0.i.a;
            }
        });
    }

    public final FragmentWaitlistBinding N0() {
        return (FragmentWaitlistBinding) this.a2.getValue(this, Z1[0]);
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.e(view, "view");
        super.onViewCreated(view, bundle);
        Annotation annotation = null;
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(((WaitlistViewModel) this.b2.getValue()).l, new WaitlistFragment$onViewCreated$1(this, null));
        p viewLifecycleOwner = getViewLifecycleOwner();
        i.d(viewLifecycleOwner, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner));
        q2 q2Var = new q2(this);
        SpannedString spannedString = (SpannedString) getText(R.string.learn_more_blog_post);
        SpannableString spannableString = new SpannableString(spannedString);
        int i = 0;
        Annotation[] annotationArr = (Annotation[]) spannedString.getSpans(0, spannedString.length(), Annotation.class);
        if (annotationArr != null) {
            int length = annotationArr.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                Annotation annotation2 = annotationArr[i];
                if (i.a(annotation2.getValue(), "blog_link")) {
                    annotation = annotation2;
                    break;
                }
                i++;
            }
            if (annotation != null) {
                spannableString.setSpan(q2Var, spannedString.getSpanStart(annotation), spannedString.getSpanEnd(annotation), 33);
            }
        }
        TextView textView = N0().a;
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        N0().c.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.r.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WaitlistFragment waitlistFragment = WaitlistFragment.this;
                k<Object>[] kVarArr = WaitlistFragment.Z1;
                i.e(waitlistFragment, "this$0");
                v.a1(waitlistFragment, new h0.t.a(R.id.action_waitlistFragment_to_collectPhoneNumberFragment), null, 2);
            }
        });
    }
}
