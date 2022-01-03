package com.clubhouse.android.ui.profile.reports;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import com.clubhouse.android.data.models.local.user.ReportReason;
import com.clubhouse.android.databinding.FragmentReportProfileLegacyBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.shared.ui.AvatarView;
import com.clubhouse.android.ui.profile.reports.ReportProfileLegacyFragment;
import com.clubhouse.android.ui.profile.reports.ReportProfileLegacyFragment$onViewCreated$5$1;
import com.clubhouse.android.user.model.User;
import com.clubhouse.app.R;
import h0.b0.v;
import h0.q.p;
import h0.q.q;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.e.b.g3.u.y5.e1;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.c;
import m0.n.a.l;
import m0.n.b.f;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
/* compiled from: ReportProfileLegacyFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001d\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR$\u0010\u0010\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0016\u001a\u00020\u00118F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001c\u001a\u00020\u00178F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lcom/clubhouse/android/ui/profile/reports/ReportProfileLegacyFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lh0/a/f/b;", "", "kotlin.jvm.PlatformType", "e2", "Lh0/a/f/b;", "getGalleryImage", "Lcom/clubhouse/android/ui/profile/reports/ReportProfileLegacyViewModel;", "d2", "Lm0/c;", "O0", "()Lcom/clubhouse/android/ui/profile/reports/ReportProfileLegacyViewModel;", "viewModel", "Lcom/clubhouse/android/databinding/FragmentReportProfileLegacyBinding;", "c2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "N0", "()Lcom/clubhouse/android/databinding/FragmentReportProfileLegacyBinding;", "binding", "<init>", "Z1", "a", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class ReportProfileLegacyFragment extends Hilt_ReportProfileLegacyFragment {
    public final FragmentViewBindingDelegate c2 = new FragmentViewBindingDelegate(FragmentReportProfileLegacyBinding.class, this);
    public final c d2;
    public final h0.a.f.b<String> e2;
    public static final /* synthetic */ k<Object>[] a2 = {m.c(new PropertyReference1Impl(m.a(ReportProfileLegacyFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentReportProfileLegacyBinding;")), m.c(new PropertyReference1Impl(m.a(ReportProfileLegacyFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/profile/reports/ReportProfileLegacyViewModel;"))};
    public static final a Z1 = new a(null);
    public static final String b2 = "ShowBlockUser";

    /* compiled from: ReportProfileLegacyFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a(f fVar) {
        }
    }

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class b extends h<ReportProfileLegacyFragment, ReportProfileLegacyViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public b(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<ReportProfileLegacyViewModel> a(ReportProfileLegacyFragment reportProfileLegacyFragment, k kVar) {
            ReportProfileLegacyFragment reportProfileLegacyFragment2 = reportProfileLegacyFragment;
            i.e(reportProfileLegacyFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(reportProfileLegacyFragment2, kVar, this.a, new ReportProfileLegacyFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(e1.class), false, this.b);
        }
    }

    public ReportProfileLegacyFragment() {
        super(R.layout.fragment_report_profile_legacy);
        d a3 = m.a(ReportProfileLegacyViewModel.class);
        this.d2 = new b(a3, false, new l<i0.b.b.k<ReportProfileLegacyViewModel, e1>, ReportProfileLegacyViewModel>(a3, a3) { // from class: com.clubhouse.android.ui.profile.reports.ReportProfileLegacyFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.clubhouse.android.ui.profile.reports.ReportProfileLegacyViewModel, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.l
            public ReportProfileLegacyViewModel invoke(i0.b.b.k<ReportProfileLegacyViewModel, e1> kVar) {
                i0.b.b.k<ReportProfileLegacyViewModel, e1> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, e1.class, dVar, name, false, kVar2, 16);
            }
        }, a3).a(this, a2[1]);
        h0.a.f.b<String> registerForActivityResult = registerForActivityResult(new h0.a.f.d.b(), new h0.a.f.a() { // from class: i0.e.b.g3.u.y5.x
            @Override // h0.a.f.a
            public final void onActivityResult(Object obj) {
                ReportProfileLegacyFragment reportProfileLegacyFragment = ReportProfileLegacyFragment.this;
                Uri uri = (Uri) obj;
                ReportProfileLegacyFragment.a aVar = ReportProfileLegacyFragment.Z1;
                i.e(reportProfileLegacyFragment, "this$0");
                if (uri != null) {
                    CardView cardView = reportProfileLegacyFragment.N0().a;
                    i.d(cardView, "binding.attachImage");
                    i0.e.b.d3.k.p(cardView);
                    ImageView imageView = reportProfileLegacyFragment.N0().b;
                    i.d(imageView, "binding.attachedImage");
                    i0.e.b.d3.k.K(imageView);
                    ImageView imageView2 = reportProfileLegacyFragment.N0().b;
                    i.d(imageView2, "binding.attachedImage");
                    v.P0(imageView2, uri);
                    reportProfileLegacyFragment.O0().p(new d0(uri));
                }
            }
        });
        i.d(registerForActivityResult, "registerForActivityResult(ActivityResultContracts.GetContent()) {\n            it?.let {\n                binding.attachImage.hide()\n                binding.attachedImage.show()\n                binding.attachedImage.load(it)\n                viewModel.processIntent(AddPhoto(it))\n            }\n        }");
        this.e2 = registerForActivityResult;
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(O0(), new l<e1, m0.i>() { // from class: com.clubhouse.android.ui.profile.reports.ReportProfileLegacyFragment$invalidate$1
            @Override // m0.n.a.l
            public m0.i invoke(e1 e1Var) {
                e1 e1Var2 = e1Var;
                i.e(e1Var2, "state");
                User user = e1Var2.a;
                AvatarView avatarView = ReportProfileLegacyFragment.this.N0().c;
                i.d(avatarView, "binding.avatar");
                i0.e.b.d3.k.u(avatarView, user);
                ReportProfileLegacyFragment.this.N0().k.setText(user.getName());
                ReportProfileLegacyFragment.this.N0().o.setText(user.C());
                if (e1Var2.d) {
                    ReportProfileLegacyFragment.this.N0().e.setText(ReportProfileLegacyFragment.this.getString(R.string.speaker));
                } else if (e1Var2.c) {
                    ReportProfileLegacyFragment.this.N0().e.setText(ReportProfileLegacyFragment.this.getString(R.string.moderator));
                } else {
                    TextView textView = ReportProfileLegacyFragment.this.N0().e;
                    i.d(textView, "binding.channelRole");
                    i0.e.b.d3.k.p(textView);
                }
                ReportProfileLegacyFragment.this.N0().p.setText(ReportProfileLegacyFragment.this.getString(R.string.why_are_you_reporting, user.getName()));
                return m0.i.a;
            }
        });
    }

    public final FragmentReportProfileLegacyBinding N0() {
        return (FragmentReportProfileLegacyBinding) this.c2.getValue(this, a2[0]);
    }

    public final ReportProfileLegacyViewModel O0() {
        return (ReportProfileLegacyViewModel) this.d2.getValue();
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.e(view, "view");
        super.onViewCreated(view, bundle);
        Context requireContext = requireContext();
        ReportReason[] values = ReportReason.values();
        ArrayList arrayList = new ArrayList(19);
        for (int i = 0; i < 19; i++) {
            arrayList.add(getString(values[i].getDisplayName()));
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(requireContext, 17367048, arrayList);
        arrayAdapter.setDropDownViewResource(17367049);
        N0().l.setAdapter((SpinnerAdapter) arrayAdapter);
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(O0().l, new ReportProfileLegacyFragment$onViewCreated$1(this, null));
        p viewLifecycleOwner = getViewLifecycleOwner();
        i.d(viewLifecycleOwner, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner));
        N0().d.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.u.y5.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReportProfileLegacyFragment reportProfileLegacyFragment = ReportProfileLegacyFragment.this;
                ReportProfileLegacyFragment.a aVar = ReportProfileLegacyFragment.Z1;
                i.e(reportProfileLegacyFragment, "this$0");
                v.c1(reportProfileLegacyFragment);
            }
        });
        N0().f.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.u.y5.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReportProfileLegacyFragment reportProfileLegacyFragment = ReportProfileLegacyFragment.this;
                ReportProfileLegacyFragment.a aVar = ReportProfileLegacyFragment.Z1;
                i.e(reportProfileLegacyFragment, "this$0");
                v.c1(reportProfileLegacyFragment);
            }
        });
        Button button = N0().m;
        i.d(button, "binding.submit");
        p viewLifecycleOwner2 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner2, "viewLifecycleOwner");
        i0.e.b.d3.k.H(button, q.a(viewLifecycleOwner2), new View.OnClickListener(arrayAdapter) { // from class: i0.e.b.g3.u.y5.w
            public final /* synthetic */ ArrayAdapter d;

            {
                this.d = r2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReportReason reportReason;
                ReportProfileLegacyFragment reportProfileLegacyFragment = ReportProfileLegacyFragment.this;
                ArrayAdapter arrayAdapter2 = this.d;
                ReportProfileLegacyFragment.a aVar = ReportProfileLegacyFragment.Z1;
                i.e(reportProfileLegacyFragment, "this$0");
                i.e(arrayAdapter2, "$spinnerAdapter");
                FrameLayout frameLayout = reportProfileLegacyFragment.N0().j;
                i.d(frameLayout, "binding.loading");
                i0.e.b.d3.k.K(frameLayout);
                String str = (String) arrayAdapter2.getItem(reportProfileLegacyFragment.N0().l.getSelectedItemPosition());
                ReportReason[] values2 = ReportReason.values();
                int i2 = 0;
                while (true) {
                    if (i2 >= 19) {
                        reportReason = null;
                        break;
                    }
                    reportReason = values2[i2];
                    if (i.a(reportProfileLegacyFragment.getString(reportReason.getDisplayName()), str)) {
                        break;
                    }
                    i2++;
                }
                v.V1(reportProfileLegacyFragment, ReportProfileLegacyFragment.b2, Boolean.TRUE);
                reportProfileLegacyFragment.O0().p(new h0(reportReason, reportProfileLegacyFragment.N0().i.getText().toString(), reportProfileLegacyFragment.N0().h.getText().toString()));
            }
        });
        N0().b.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.u.y5.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReportProfileLegacyFragment reportProfileLegacyFragment = ReportProfileLegacyFragment.this;
                ReportProfileLegacyFragment.a aVar = ReportProfileLegacyFragment.Z1;
                i.e(reportProfileLegacyFragment, "this$0");
                ImageView imageView = reportProfileLegacyFragment.N0().b;
                i.d(imageView, "binding.attachedImage");
                ReportProfileLegacyFragment$onViewCreated$5$1 reportProfileLegacyFragment$onViewCreated$5$1 = 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0016: CONSTRUCTOR  (r1v1 'reportProfileLegacyFragment$onViewCreated$5$1' com.clubhouse.android.ui.profile.reports.ReportProfileLegacyFragment$onViewCreated$5$1) = (r4v1 'reportProfileLegacyFragment' com.clubhouse.android.ui.profile.reports.ReportProfileLegacyFragment) call: com.clubhouse.android.ui.profile.reports.ReportProfileLegacyFragment$onViewCreated$5$1.<init>(com.clubhouse.android.ui.profile.reports.ReportProfileLegacyFragment):void type: CONSTRUCTOR in method: i0.e.b.g3.u.y5.y.onClick(android.view.View):void, file: classes3.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.profile.reports.ReportProfileLegacyFragment$onViewCreated$5$1, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                    	... 15 more
                    */
                /*
                    this = this;
                    com.clubhouse.android.ui.profile.reports.ReportProfileLegacyFragment r4 = com.clubhouse.android.ui.profile.reports.ReportProfileLegacyFragment.this
                    com.clubhouse.android.ui.profile.reports.ReportProfileLegacyFragment$a r0 = com.clubhouse.android.ui.profile.reports.ReportProfileLegacyFragment.Z1
                    java.lang.String r0 = "this$0"
                    m0.n.b.i.e(r4, r0)
                    com.clubhouse.android.databinding.FragmentReportProfileLegacyBinding r0 = r4.N0()
                    android.widget.ImageView r0 = r0.b
                    java.lang.String r1 = "binding.attachedImage"
                    m0.n.b.i.d(r0, r1)
                    com.clubhouse.android.ui.profile.reports.ReportProfileLegacyFragment$onViewCreated$5$1 r1 = new com.clubhouse.android.ui.profile.reports.ReportProfileLegacyFragment$onViewCreated$5$1
                    r1.<init>(r4)
                    java.lang.String r2 = "<this>"
                    m0.n.b.i.e(r4, r2)
                    java.lang.String r2 = "anchor"
                    m0.n.b.i.e(r0, r2)
                    java.lang.String r2 = "f"
                    m0.n.b.i.e(r1, r2)
                    h0.b.f.m0 r2 = new h0.b.f.m0
                    android.content.Context r4 = r4.requireContext()
                    r2.<init>(r4, r0)
                    r1.invoke(r2)
                    h0.b.e.i.l r4 = r2.d
                    boolean r4 = r4.f()
                    if (r4 == 0) goto L_0x003d
                    return
                L_0x003d:
                    java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                    java.lang.String r0 = "MenuPopupHelper cannot be used without an anchor"
                    r4.<init>(r0)
                    throw r4
                */
                throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.u.y5.y.onClick(android.view.View):void");
            }
        });
        CardView cardView = N0().a;
        i.d(cardView, "binding.attachImage");
        p viewLifecycleOwner3 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner3, "viewLifecycleOwner");
        i0.e.b.d3.k.H(cardView, q.a(viewLifecycleOwner3), new View.OnClickListener() { // from class: i0.e.b.g3.u.y5.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReportProfileLegacyFragment reportProfileLegacyFragment = ReportProfileLegacyFragment.this;
                ReportProfileLegacyFragment.a aVar = ReportProfileLegacyFragment.Z1;
                i.e(reportProfileLegacyFragment, "this$0");
                reportProfileLegacyFragment.e2.a("image/*", null);
            }
        });
    }
}
