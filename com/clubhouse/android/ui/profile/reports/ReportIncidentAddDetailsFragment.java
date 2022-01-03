package com.clubhouse.android.ui.profile.reports;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import com.clubhouse.android.data.models.local.channel.Channel;
import com.clubhouse.android.databinding.FragmentReportIncidentAddDetailsBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.shared.ui.AvatarView;
import com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsFragment;
import com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsFragment$onViewCreated$4$1;
import com.clubhouse.android.user.model.User;
import com.clubhouse.app.R;
import com.squareup.picasso.Picasso;
import h0.a.f.b;
import h0.b0.v;
import h0.q.p;
import h0.q.q;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.e.b.c3.e;
import i0.e.b.g3.u.y5.k0;
import i0.o.a.t;
import i0.o.a.u;
import java.util.ArrayList;
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
/* compiled from: ReportIncidentAddDetailsFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eR$\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001d\u0010\u001a\u001a\u00020\u00158F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010 \u001a\u00020\u001b8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/clubhouse/android/ui/profile/reports/ReportIncidentAddDetailsFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "P0", "(Landroid/net/Uri;)V", "Lh0/a/f/b;", "", "kotlin.jvm.PlatformType", "c2", "Lh0/a/f/b;", "getGalleryImage", "Lcom/clubhouse/android/ui/profile/reports/ReportIncidentAddDetailsViewModel;", "b2", "Lm0/c;", "O0", "()Lcom/clubhouse/android/ui/profile/reports/ReportIncidentAddDetailsViewModel;", "viewModel", "Lcom/clubhouse/android/databinding/FragmentReportIncidentAddDetailsBinding;", "a2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "N0", "()Lcom/clubhouse/android/databinding/FragmentReportIncidentAddDetailsBinding;", "binding", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class ReportIncidentAddDetailsFragment extends Hilt_ReportIncidentAddDetailsFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(ReportIncidentAddDetailsFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentReportIncidentAddDetailsBinding;")), m.c(new PropertyReference1Impl(m.a(ReportIncidentAddDetailsFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/profile/reports/ReportIncidentAddDetailsViewModel;"))};
    public final FragmentViewBindingDelegate a2 = new FragmentViewBindingDelegate(FragmentReportIncidentAddDetailsBinding.class, this);
    public final c b2;
    public final b<String> c2;

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<ReportIncidentAddDetailsFragment, ReportIncidentAddDetailsViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<ReportIncidentAddDetailsViewModel> a(ReportIncidentAddDetailsFragment reportIncidentAddDetailsFragment, k kVar) {
            ReportIncidentAddDetailsFragment reportIncidentAddDetailsFragment2 = reportIncidentAddDetailsFragment;
            i.e(reportIncidentAddDetailsFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(reportIncidentAddDetailsFragment2, kVar, this.a, new ReportIncidentAddDetailsFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(k0.class), false, this.b);
        }
    }

    public ReportIncidentAddDetailsFragment() {
        super(R.layout.fragment_report_incident_add_details);
        d a2 = m.a(ReportIncidentAddDetailsViewModel.class);
        this.b2 = new a(a2, false, new l<i0.b.b.k<ReportIncidentAddDetailsViewModel, k0>, ReportIncidentAddDetailsViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.airbnb.mvrx.MavericksViewModel, com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsViewModel] */
            @Override // m0.n.a.l
            public ReportIncidentAddDetailsViewModel invoke(i0.b.b.k<ReportIncidentAddDetailsViewModel, k0> kVar) {
                i0.b.b.k<ReportIncidentAddDetailsViewModel, k0> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, k0.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, Z1[1]);
        b<String> registerForActivityResult = registerForActivityResult(new h0.a.f.d.b(), new h0.a.f.a() { // from class: i0.e.b.g3.u.y5.c
            @Override // h0.a.f.a
            public final void onActivityResult(Object obj) {
                ReportIncidentAddDetailsFragment reportIncidentAddDetailsFragment = ReportIncidentAddDetailsFragment.this;
                Uri uri = (Uri) obj;
                k<Object>[] kVarArr = ReportIncidentAddDetailsFragment.Z1;
                i.e(reportIncidentAddDetailsFragment, "this$0");
                if (uri != null) {
                    reportIncidentAddDetailsFragment.P0(uri);
                    reportIncidentAddDetailsFragment.O0().p(new d0(uri));
                }
            }
        });
        i.d(registerForActivityResult, "registerForActivityResult(ActivityResultContracts.GetContent()) {\n            it?.let {\n                showScreenshot(it)\n                viewModel.processIntent(AddPhoto(it))\n            }\n        }");
        this.c2 = registerForActivityResult;
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(O0(), new l<k0, m0.i>() { // from class: com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsFragment$invalidate$1
            @Override // m0.n.a.l
            public m0.i invoke(k0 k0Var) {
                String str;
                m0.i iVar;
                String u02;
                k0 k0Var2 = k0Var;
                i.e(k0Var2, "state");
                User user = k0Var2.a;
                int size = k0Var2.b.size();
                String str2 = "";
                if (size == 0) {
                    str = str2;
                } else if (size != 1) {
                    str = k0Var2.b.get(0).c + ", " + k0Var2.b.get(1).c;
                } else {
                    str = k0Var2.b.get(0).c;
                }
                if (user == null) {
                    iVar = null;
                } else {
                    ReportIncidentAddDetailsFragment reportIncidentAddDetailsFragment = ReportIncidentAddDetailsFragment.this;
                    AvatarView avatarView = reportIncidentAddDetailsFragment.N0().c;
                    i.d(avatarView, "binding.avatar");
                    i0.e.b.d3.k.u(avatarView, user);
                    reportIncidentAddDetailsFragment.N0().g.setText(user.getName());
                    iVar = m0.i.a;
                }
                if (iVar == null) {
                    ReportIncidentAddDetailsFragment reportIncidentAddDetailsFragment2 = ReportIncidentAddDetailsFragment.this;
                    AvatarView avatarView2 = reportIncidentAddDetailsFragment2.N0().c;
                    i.d(avatarView2, "binding.avatar");
                    i0.e.b.d3.k.p(avatarView2);
                    TextView textView = reportIncidentAddDetailsFragment2.N0().g;
                    Channel channel = k0Var2.d;
                    if (!(channel == null || (u02 = channel.u0()) == null)) {
                        str2 = u02;
                    }
                    textView.setText(str2);
                }
                TextView textView2 = ReportIncidentAddDetailsFragment.this.N0().i;
                ReportIncidentAddDetailsFragment reportIncidentAddDetailsFragment3 = ReportIncidentAddDetailsFragment.this;
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                String lowerCase = str.toLowerCase();
                i.d(lowerCase, "(this as java.lang.String).toLowerCase()");
                textView2.setText(reportIncidentAddDetailsFragment3.getString(R.string.for_some, lowerCase));
                return m0.i.a;
            }
        });
    }

    public final FragmentReportIncidentAddDetailsBinding N0() {
        return (FragmentReportIncidentAddDetailsBinding) this.a2.getValue(this, Z1[0]);
    }

    public final ReportIncidentAddDetailsViewModel O0() {
        return (ReportIncidentAddDetailsViewModel) this.b2.getValue();
    }

    public final void P0(Uri uri) {
        m0.i iVar = null;
        if (uri != null) {
            Context requireContext = requireContext();
            i.d(requireContext, "requireContext()");
            i.e(requireContext, "<this>");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Object systemService = requireContext.getSystemService("window");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
            Context requireContext2 = requireContext();
            i.d(requireContext2, "requireContext()");
            i.e(requireContext2, "<this>");
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            Object systemService2 = requireContext2.getSystemService("window");
            Objects.requireNonNull(systemService2, "null cannot be cast to non-null type android.view.WindowManager");
            ((WindowManager) systemService2).getDefaultDisplay().getMetrics(displayMetrics2);
            ViewGroup.LayoutParams layoutParams = N0().k.getLayoutParams();
            layoutParams.width = (displayMetrics.widthPixels * 3) / 8;
            layoutParams.height = (displayMetrics2.heightPixels * 3) / 8;
            Button button = N0().b;
            i.d(button, "binding.attachImage");
            i0.e.b.d3.k.p(button);
            ImageView imageView = N0().j;
            i.d(imageView, "binding.screenshot");
            i0.e.b.g3.z.b bVar = new i0.e.b.g3.z.b(Float.valueOf(getResources().getDimension(R.dimen.roundable_rect_radius)), getResources().getDimension(R.dimen.roundable_rect_border_width));
            i.e(imageView, "<this>");
            i.e(bVar, "transformation");
            String valueOf = String.valueOf(uri);
            i.e(imageView, "<this>");
            i.e(bVar, "transformation");
            Picasso d = ((e) i0.j.f.p.h.K0(imageView.getContext().getApplicationContext(), e.class)).d();
            if (valueOf.length() == 0) {
                d.b(imageView);
                imageView.setImageDrawable(null);
            } else {
                u e = d.e(valueOf);
                e.d = true;
                t.b bVar2 = e.c;
                Objects.requireNonNull(bVar2);
                if (bVar.b() != null) {
                    if (bVar2.e == null) {
                        bVar2.e = new ArrayList(2);
                    }
                    bVar2.e.add(bVar);
                    e.b(imageView, null);
                } else {
                    throw new IllegalArgumentException("Transformation key must not be null.");
                }
            }
            FrameLayout frameLayout = N0().k;
            i.d(frameLayout, "binding.screenshotContainer");
            i0.e.b.d3.k.K(frameLayout);
            iVar = m0.i.a;
        }
        if (iVar == null) {
            Button button2 = N0().b;
            i.d(button2, "binding.attachImage");
            i0.e.b.d3.k.K(button2);
            FrameLayout frameLayout2 = N0().k;
            i.d(frameLayout2, "binding.screenshotContainer");
            i0.e.b.d3.k.p(frameLayout2);
            N0().m.setText(getResources().getString(R.string.if_the_incident_is_visible));
        }
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.e(view, "view");
        super.onViewCreated(view, bundle);
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(O0().l, new ReportIncidentAddDetailsFragment$onViewCreated$1(this, null));
        p viewLifecycleOwner = getViewLifecycleOwner();
        i.d(viewLifecycleOwner, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner));
        N0().d.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.u.y5.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReportIncidentAddDetailsFragment reportIncidentAddDetailsFragment = ReportIncidentAddDetailsFragment.this;
                k<Object>[] kVarArr = ReportIncidentAddDetailsFragment.Z1;
                i.e(reportIncidentAddDetailsFragment, "this$0");
                v.c1(reportIncidentAddDetailsFragment);
            }
        });
        TextView textView = N0().l;
        i.d(textView, "binding.submit");
        p viewLifecycleOwner2 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner2, "viewLifecycleOwner");
        i0.e.b.d3.k.H(textView, q.a(viewLifecycleOwner2), new View.OnClickListener() { // from class: i0.e.b.g3.u.y5.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReportIncidentAddDetailsFragment reportIncidentAddDetailsFragment = ReportIncidentAddDetailsFragment.this;
                k<Object>[] kVarArr = ReportIncidentAddDetailsFragment.Z1;
                i.e(reportIncidentAddDetailsFragment, "this$0");
                ScrollView scrollView = reportIncidentAddDetailsFragment.N0().e;
                i.d(scrollView, "binding.contentContainer");
                i0.e.b.d3.k.p(scrollView);
                FrameLayout frameLayout = reportIncidentAddDetailsFragment.N0().f;
                i.d(frameLayout, "binding.loading");
                i0.e.b.d3.k.K(frameLayout);
                v.x0(reportIncidentAddDetailsFragment);
                v.v2(reportIncidentAddDetailsFragment.O0(), 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0031: INVOKE  
                      (wrap: com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsViewModel : 0x0028: INVOKE  (r0v6 com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsViewModel A[REMOVE]) = (r3v1 'reportIncidentAddDetailsFragment' com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsFragment) type: VIRTUAL call: com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsFragment.O0():com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsViewModel)
                      (wrap: com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsFragment$onViewCreated$3$1 : 0x002e: CONSTRUCTOR  (r1v2 com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsFragment$onViewCreated$3$1 A[REMOVE]) = (r3v1 'reportIncidentAddDetailsFragment' com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsFragment) call: com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsFragment$onViewCreated$3$1.<init>(com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsFragment):void type: CONSTRUCTOR)
                     type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: i0.e.b.g3.u.y5.f.onClick(android.view.View):void, file: classes3.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsFragment$onViewCreated$3$1, state: NOT_LOADED
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
                    com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsFragment r3 = com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsFragment.this
                    m0.r.k<java.lang.Object>[] r0 = com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsFragment.Z1
                    java.lang.String r0 = "this$0"
                    m0.n.b.i.e(r3, r0)
                    com.clubhouse.android.databinding.FragmentReportIncidentAddDetailsBinding r0 = r3.N0()
                    android.widget.ScrollView r0 = r0.e
                    java.lang.String r1 = "binding.contentContainer"
                    m0.n.b.i.d(r0, r1)
                    i0.e.b.d3.k.p(r0)
                    com.clubhouse.android.databinding.FragmentReportIncidentAddDetailsBinding r0 = r3.N0()
                    android.widget.FrameLayout r0 = r0.f
                    java.lang.String r1 = "binding.loading"
                    m0.n.b.i.d(r0, r1)
                    i0.e.b.d3.k.K(r0)
                    h0.b0.v.x0(r3)
                    com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsViewModel r0 = r3.O0()
                    com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsFragment$onViewCreated$3$1 r1 = new com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsFragment$onViewCreated$3$1
                    r1.<init>(r3)
                    h0.b0.v.v2(r0, r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.u.y5.f.onClick(android.view.View):void");
            }
        });
        N0().k.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.u.y5.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReportIncidentAddDetailsFragment reportIncidentAddDetailsFragment = ReportIncidentAddDetailsFragment.this;
                k<Object>[] kVarArr = ReportIncidentAddDetailsFragment.Z1;
                i.e(reportIncidentAddDetailsFragment, "this$0");
                FrameLayout frameLayout = reportIncidentAddDetailsFragment.N0().k;
                i.d(frameLayout, "binding.screenshotContainer");
                ReportIncidentAddDetailsFragment$onViewCreated$4$1 reportIncidentAddDetailsFragment$onViewCreated$4$1 = 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0016: CONSTRUCTOR  (r1v1 'reportIncidentAddDetailsFragment$onViewCreated$4$1' com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsFragment$onViewCreated$4$1) = (r4v1 'reportIncidentAddDetailsFragment' com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsFragment) call: com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsFragment$onViewCreated$4$1.<init>(com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsFragment):void type: CONSTRUCTOR in method: i0.e.b.g3.u.y5.a.onClick(android.view.View):void, file: classes3.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsFragment$onViewCreated$4$1, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                    	... 15 more
                    */
                /*
                    this = this;
                    com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsFragment r4 = com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsFragment.this
                    m0.r.k<java.lang.Object>[] r0 = com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsFragment.Z1
                    java.lang.String r0 = "this$0"
                    m0.n.b.i.e(r4, r0)
                    com.clubhouse.android.databinding.FragmentReportIncidentAddDetailsBinding r0 = r4.N0()
                    android.widget.FrameLayout r0 = r0.k
                    java.lang.String r1 = "binding.screenshotContainer"
                    m0.n.b.i.d(r0, r1)
                    com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsFragment$onViewCreated$4$1 r1 = new com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsFragment$onViewCreated$4$1
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
                throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.u.y5.a.onClick(android.view.View):void");
            }
        });
        Button button = N0().b;
        i.d(button, "binding.attachImage");
        p viewLifecycleOwner3 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner3, "viewLifecycleOwner");
        i0.e.b.d3.k.H(button, q.a(viewLifecycleOwner3), new View.OnClickListener() { // from class: i0.e.b.g3.u.y5.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ReportIncidentAddDetailsFragment reportIncidentAddDetailsFragment = ReportIncidentAddDetailsFragment.this;
                k<Object>[] kVarArr = ReportIncidentAddDetailsFragment.Z1;
                i.e(reportIncidentAddDetailsFragment, "this$0");
                reportIncidentAddDetailsFragment.c2.a("image/*", null);
            }
        });
        v.v2(O0(), new l<k0, m0.i>() { // from class: com.clubhouse.android.ui.profile.reports.ReportIncidentAddDetailsFragment$onViewCreated$6
            @Override // m0.n.a.l
            public m0.i invoke(k0 k0Var) {
                k0 k0Var2 = k0Var;
                i.e(k0Var2, "state");
                ReportIncidentAddDetailsFragment reportIncidentAddDetailsFragment = ReportIncidentAddDetailsFragment.this;
                Uri uri = k0Var2.g;
                k<Object>[] kVarArr = ReportIncidentAddDetailsFragment.Z1;
                reportIncidentAddDetailsFragment.P0(uri);
                return m0.i.a;
            }
        });
    }
}
