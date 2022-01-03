package com.clubhouse.android.ui.clubs.create;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import com.clubhouse.android.data.models.local.Topic;
import com.clubhouse.android.databinding.FragmentCreateClubBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.shared.ui.AvatarView;
import com.clubhouse.android.ui.clubs.create.CreateClubFragment;
import com.clubhouse.android.ui.selection.Selection;
import com.clubhouse.app.R;
import h0.b0.v;
import h0.q.p;
import i0.b.b.f;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.e.b.d3.e;
import i0.e.b.g3.l.v2.q;
import i0.e.b.g3.l.v2.t;
import i0.e.b.g3.l.v2.y;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.PropertyReference1Impl;
import m0.c;
import m0.n.a.l;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
/* compiled from: CreateClubFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u000eJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0014\u001a\u00020\u000f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u001a\u001a\u00020\u00158B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/clubhouse/android/ui/clubs/create/CreateClubFragment;", "Lcom/clubhouse/android/ui/common/PhotoCreationFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "M0", "(Landroid/net/Uri;)V", "J", "()V", "Lcom/clubhouse/android/ui/clubs/create/CreateClubViewModel;", "g2", "Lm0/c;", "S0", "()Lcom/clubhouse/android/ui/clubs/create/CreateClubViewModel;", "viewModel", "Lcom/clubhouse/android/databinding/FragmentCreateClubBinding;", "f2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "R0", "()Lcom/clubhouse/android/databinding/FragmentCreateClubBinding;", "binding", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class CreateClubFragment extends Hilt_CreateClubFragment {
    public static final /* synthetic */ k<Object>[] e2 = {m.c(new PropertyReference1Impl(m.a(CreateClubFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentCreateClubBinding;")), m.c(new PropertyReference1Impl(m.a(CreateClubFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/clubs/create/CreateClubViewModel;"))};
    public final FragmentViewBindingDelegate f2 = new FragmentViewBindingDelegate(FragmentCreateClubBinding.class, this);
    public final c g2;

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<CreateClubFragment, CreateClubViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<CreateClubViewModel> a(CreateClubFragment createClubFragment, k kVar) {
            CreateClubFragment createClubFragment2 = createClubFragment;
            i.e(createClubFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(createClubFragment2, kVar, this.a, new CreateClubFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(q.class), false, this.b);
        }
    }

    public CreateClubFragment() {
        super(R.layout.fragment_create_club);
        d a2 = m.a(CreateClubViewModel.class);
        this.g2 = new a(a2, false, new l<i0.b.b.k<CreateClubViewModel, q>, CreateClubViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.clubs.create.CreateClubFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.airbnb.mvrx.MavericksViewModel, com.clubhouse.android.ui.clubs.create.CreateClubViewModel] */
            @Override // m0.n.a.l
            public CreateClubViewModel invoke(i0.b.b.k<CreateClubViewModel, q> kVar) {
                i0.b.b.k<CreateClubViewModel, q> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, q.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, e2[1]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(S0(), new l<q, m0.i>() { // from class: com.clubhouse.android.ui.clubs.create.CreateClubFragment$invalidate$1
            @Override // m0.n.a.l
            public m0.i invoke(q qVar) {
                int i;
                CreateClubFragment createClubFragment;
                int i2;
                CreateClubFragment createClubFragment2;
                q qVar2 = qVar;
                i.e(qVar2, "state");
                CreateClubFragment createClubFragment3 = CreateClubFragment.this;
                k<Object>[] kVarArr = CreateClubFragment.e2;
                ProgressBar progressBar = createClubFragment3.R0().i;
                i.d(progressBar, "binding.loading");
                i0.e.b.d3.k.L(progressBar, Boolean.valueOf(qVar2.a instanceof f));
                CreateClubFragment.this.R0().h.setEnabled(qVar2.k);
                Uri uri = qVar2.h;
                if (uri != null) {
                    AvatarView avatarView = CreateClubFragment.this.R0().a;
                    i.d(avatarView, "binding.addPhotoButton");
                    v.P0(avatarView, uri);
                }
                if (qVar2.j.isEmpty()) {
                    CreateClubFragment.this.R0().p.setText(CreateClubFragment.this.getString(R.string.add));
                } else {
                    CreateClubFragment.this.R0().p.setText(m0.j.g.E(qVar2.j, null, null, null, 0, null, AnonymousClass2.c, 31));
                }
                TextView textView = CreateClubFragment.this.R0().m;
                if (qVar2.e) {
                    createClubFragment = CreateClubFragment.this;
                    i = R.string.open_to_all;
                } else {
                    createClubFragment = CreateClubFragment.this;
                    i = R.string.by_approval;
                }
                textView.setText(createClubFragment.getString(i));
                TextView textView2 = CreateClubFragment.this.R0().s;
                if (qVar2.g) {
                    createClubFragment2 = CreateClubFragment.this;
                    i2 = R.string.any_member;
                } else {
                    createClubFragment2 = CreateClubFragment.this;
                    i2 = R.string.leaders_only;
                }
                textView2.setText(createClubFragment2.getString(i2));
                CardView cardView = CreateClubFragment.this.R0().d;
                i.d(cardView, "binding.byApprovalSettings");
                i0.e.b.d3.k.L(cardView, Boolean.valueOf(!qVar2.e));
                CreateClubFragment.this.R0().c.setChecked(qVar2.d);
                CreateClubFragment.this.R0().j.setChecked(!qVar2.f);
                return m0.i.a;
            }
        });
    }

    @Override // com.clubhouse.android.ui.common.PhotoCreationFragment
    public void M0(Uri uri) {
        i.e(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        S0().p(new i0.e.b.g3.l.v2.x(uri));
    }

    public final FragmentCreateClubBinding R0() {
        return (FragmentCreateClubBinding) this.f2.getValue(this, e2[0]);
    }

    public final CreateClubViewModel S0() {
        return (CreateClubViewModel) this.g2.getValue();
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.e(view, "view");
        super.onViewCreated(view, bundle);
        v.g1(this, S0(), CreateClubFragment$onViewCreated$1.c, v.q2(this, null, 1, null), new CreateClubFragment$onViewCreated$2(this, null), new CreateClubFragment$onViewCreated$3(this, null));
        R0().e.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.l.v2.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CreateClubFragment createClubFragment = CreateClubFragment.this;
                k<Object>[] kVarArr = CreateClubFragment.e2;
                i.e(createClubFragment, "this$0");
                v.c1(createClubFragment);
            }
        });
        TextView textView = R0().h;
        i.d(textView, "binding.create");
        p viewLifecycleOwner = getViewLifecycleOwner();
        i.d(viewLifecycleOwner, "viewLifecycleOwner");
        i0.e.b.d3.k.H(textView, h0.q.q.a(viewLifecycleOwner), new View.OnClickListener() { // from class: i0.e.b.g3.l.v2.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CreateClubFragment createClubFragment = CreateClubFragment.this;
                k<Object>[] kVarArr = CreateClubFragment.e2;
                m0.n.b.i.e(createClubFragment, "this$0");
                v.x0(createClubFragment);
                createClubFragment.S0().p(j.a);
            }
        });
        v.p0(this, "selected_item_result", new l<Pair<? extends String, ? extends Selection>, m0.i>() { // from class: com.clubhouse.android.ui.clubs.create.CreateClubFragment$onViewCreated$6
            @Override // m0.n.a.l
            public m0.i invoke(Pair<? extends String, ? extends Selection> pair) {
                Pair<? extends String, ? extends Selection> pair2 = pair;
                i.e(pair2, "selectedItem");
                Selection selection = (Selection) pair2.d;
                if (selection instanceof MembershipSelection) {
                    CreateClubFragment createClubFragment = CreateClubFragment.this;
                    k<Object>[] kVarArr = CreateClubFragment.e2;
                    createClubFragment.S0().p(new i0.e.b.g3.l.v2.v(i.a(pair2.d, MembershipSelection.d)));
                } else if (selection instanceof WhoCanStartSelection) {
                    CreateClubFragment createClubFragment2 = CreateClubFragment.this;
                    k<Object>[] kVarArr2 = CreateClubFragment.e2;
                    createClubFragment2.S0().p(new t(i.a(pair2.d, WhoCanStartSelection.d)));
                }
                return m0.i.a;
            }
        });
        ConstraintLayout constraintLayout = R0().k;
        i.d(constraintLayout, "binding.membership");
        p viewLifecycleOwner2 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner2, "viewLifecycleOwner");
        i0.e.b.d3.k.H(constraintLayout, h0.q.q.a(viewLifecycleOwner2), new View.OnClickListener() { // from class: i0.e.b.g3.l.v2.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CreateClubFragment createClubFragment = CreateClubFragment.this;
                k<Object>[] kVarArr = CreateClubFragment.e2;
                i.e(createClubFragment, "this$0");
                v.v2(createClubFragment.S0(), 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: INVOKE  
                      (wrap: com.clubhouse.android.ui.clubs.create.CreateClubViewModel : 0x0009: INVOKE  (r0v2 com.clubhouse.android.ui.clubs.create.CreateClubViewModel A[REMOVE]) = (r3v1 'createClubFragment' com.clubhouse.android.ui.clubs.create.CreateClubFragment) type: VIRTUAL call: com.clubhouse.android.ui.clubs.create.CreateClubFragment.S0():com.clubhouse.android.ui.clubs.create.CreateClubViewModel)
                      (wrap: com.clubhouse.android.ui.clubs.create.CreateClubFragment$onViewCreated$7$1 : 0x000f: CONSTRUCTOR  (r1v0 com.clubhouse.android.ui.clubs.create.CreateClubFragment$onViewCreated$7$1 A[REMOVE]) = (r3v1 'createClubFragment' com.clubhouse.android.ui.clubs.create.CreateClubFragment) call: com.clubhouse.android.ui.clubs.create.CreateClubFragment$onViewCreated$7$1.<init>(com.clubhouse.android.ui.clubs.create.CreateClubFragment):void type: CONSTRUCTOR)
                     type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: i0.e.b.g3.l.v2.h.onClick(android.view.View):void, file: classes3.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.clubs.create.CreateClubFragment$onViewCreated$7$1, state: NOT_LOADED
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
                    com.clubhouse.android.ui.clubs.create.CreateClubFragment r3 = com.clubhouse.android.ui.clubs.create.CreateClubFragment.this
                    m0.r.k<java.lang.Object>[] r0 = com.clubhouse.android.ui.clubs.create.CreateClubFragment.e2
                    java.lang.String r0 = "this$0"
                    m0.n.b.i.e(r3, r0)
                    com.clubhouse.android.ui.clubs.create.CreateClubViewModel r0 = r3.S0()
                    com.clubhouse.android.ui.clubs.create.CreateClubFragment$onViewCreated$7$1 r1 = new com.clubhouse.android.ui.clubs.create.CreateClubFragment$onViewCreated$7$1
                    r1.<init>(r3)
                    h0.b0.v.v2(r0, r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.l.v2.h.onClick(android.view.View):void");
            }
        });
        ConstraintLayout constraintLayout2 = R0().q;
        i.d(constraintLayout2, "binding.whoCanStart");
        p viewLifecycleOwner3 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner3, "viewLifecycleOwner");
        i0.e.b.d3.k.H(constraintLayout2, h0.q.q.a(viewLifecycleOwner3), new View.OnClickListener() { // from class: i0.e.b.g3.l.v2.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CreateClubFragment createClubFragment = CreateClubFragment.this;
                k<Object>[] kVarArr = CreateClubFragment.e2;
                i.e(createClubFragment, "this$0");
                v.v2(createClubFragment.S0(), 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: INVOKE  
                      (wrap: com.clubhouse.android.ui.clubs.create.CreateClubViewModel : 0x0009: INVOKE  (r0v2 com.clubhouse.android.ui.clubs.create.CreateClubViewModel A[REMOVE]) = (r3v1 'createClubFragment' com.clubhouse.android.ui.clubs.create.CreateClubFragment) type: VIRTUAL call: com.clubhouse.android.ui.clubs.create.CreateClubFragment.S0():com.clubhouse.android.ui.clubs.create.CreateClubViewModel)
                      (wrap: com.clubhouse.android.ui.clubs.create.CreateClubFragment$onViewCreated$8$1 : 0x000f: CONSTRUCTOR  (r1v0 com.clubhouse.android.ui.clubs.create.CreateClubFragment$onViewCreated$8$1 A[REMOVE]) = (r3v1 'createClubFragment' com.clubhouse.android.ui.clubs.create.CreateClubFragment) call: com.clubhouse.android.ui.clubs.create.CreateClubFragment$onViewCreated$8$1.<init>(com.clubhouse.android.ui.clubs.create.CreateClubFragment):void type: CONSTRUCTOR)
                     type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: i0.e.b.g3.l.v2.d.onClick(android.view.View):void, file: classes3.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.clubs.create.CreateClubFragment$onViewCreated$8$1, state: NOT_LOADED
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
                    com.clubhouse.android.ui.clubs.create.CreateClubFragment r3 = com.clubhouse.android.ui.clubs.create.CreateClubFragment.this
                    m0.r.k<java.lang.Object>[] r0 = com.clubhouse.android.ui.clubs.create.CreateClubFragment.e2
                    java.lang.String r0 = "this$0"
                    m0.n.b.i.e(r3, r0)
                    com.clubhouse.android.ui.clubs.create.CreateClubViewModel r0 = r3.S0()
                    com.clubhouse.android.ui.clubs.create.CreateClubFragment$onViewCreated$8$1 r1 = new com.clubhouse.android.ui.clubs.create.CreateClubFragment$onViewCreated$8$1
                    r1.<init>(r3)
                    h0.b0.v.v2(r0, r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.l.v2.d.onClick(android.view.View):void");
            }
        });
        v.p0(this, "selected_topics_result", new l<List<? extends Topic>, m0.i>() { // from class: com.clubhouse.android.ui.clubs.create.CreateClubFragment$onViewCreated$9
            @Override // m0.n.a.l
            public m0.i invoke(List<? extends Topic> list) {
                List<? extends Topic> list2 = list;
                i.e(list2, "topics");
                CreateClubFragment createClubFragment = CreateClubFragment.this;
                k<Object>[] kVarArr = CreateClubFragment.e2;
                createClubFragment.S0().p(new y(list2));
                return m0.i.a;
            }
        });
        ConstraintLayout constraintLayout3 = R0().o;
        i.d(constraintLayout3, "binding.topics");
        p viewLifecycleOwner4 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner4, "viewLifecycleOwner");
        i0.e.b.d3.k.H(constraintLayout3, h0.q.q.a(viewLifecycleOwner4), new View.OnClickListener() { // from class: i0.e.b.g3.l.v2.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CreateClubFragment createClubFragment = CreateClubFragment.this;
                k<Object>[] kVarArr = CreateClubFragment.e2;
                i.e(createClubFragment, "this$0");
                v.v2(createClubFragment.S0(), 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: INVOKE  
                      (wrap: com.clubhouse.android.ui.clubs.create.CreateClubViewModel : 0x0009: INVOKE  (r0v2 com.clubhouse.android.ui.clubs.create.CreateClubViewModel A[REMOVE]) = (r3v1 'createClubFragment' com.clubhouse.android.ui.clubs.create.CreateClubFragment) type: VIRTUAL call: com.clubhouse.android.ui.clubs.create.CreateClubFragment.S0():com.clubhouse.android.ui.clubs.create.CreateClubViewModel)
                      (wrap: com.clubhouse.android.ui.clubs.create.CreateClubFragment$onViewCreated$10$1 : 0x000f: CONSTRUCTOR  (r1v0 com.clubhouse.android.ui.clubs.create.CreateClubFragment$onViewCreated$10$1 A[REMOVE]) = (r3v1 'createClubFragment' com.clubhouse.android.ui.clubs.create.CreateClubFragment) call: com.clubhouse.android.ui.clubs.create.CreateClubFragment$onViewCreated$10$1.<init>(com.clubhouse.android.ui.clubs.create.CreateClubFragment):void type: CONSTRUCTOR)
                     type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: i0.e.b.g3.l.v2.a.onClick(android.view.View):void, file: classes3.dex
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.clubs.create.CreateClubFragment$onViewCreated$10$1, state: NOT_LOADED
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
                    com.clubhouse.android.ui.clubs.create.CreateClubFragment r3 = com.clubhouse.android.ui.clubs.create.CreateClubFragment.this
                    m0.r.k<java.lang.Object>[] r0 = com.clubhouse.android.ui.clubs.create.CreateClubFragment.e2
                    java.lang.String r0 = "this$0"
                    m0.n.b.i.e(r3, r0)
                    com.clubhouse.android.ui.clubs.create.CreateClubViewModel r0 = r3.S0()
                    com.clubhouse.android.ui.clubs.create.CreateClubFragment$onViewCreated$10$1 r1 = new com.clubhouse.android.ui.clubs.create.CreateClubFragment$onViewCreated$10$1
                    r1.<init>(r3)
                    h0.b0.v.v2(r0, r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.l.v2.a.onClick(android.view.View):void");
            }
        });
        R0().a.setSquareness(0.88f);
        AvatarView avatarView = R0().a;
        i.d(avatarView, "binding.addPhotoButton");
        p viewLifecycleOwner5 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner5, "viewLifecycleOwner");
        i0.e.b.d3.k.H(avatarView, h0.q.q.a(viewLifecycleOwner5), new View.OnClickListener() { // from class: i0.e.b.g3.l.v2.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CreateClubFragment createClubFragment = CreateClubFragment.this;
                k<Object>[] kVarArr = CreateClubFragment.e2;
                i.e(createClubFragment, "this$0");
                createClubFragment.N0();
            }
        });
        EditText editText = R0().g;
        i.d(editText, "binding.clubName");
        editText.addTextChangedListener(new i0.e.b.g3.l.v2.l(this));
        R0().c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: i0.e.b.g3.l.v2.g
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                CreateClubFragment createClubFragment = CreateClubFragment.this;
                k<Object>[] kVarArr = CreateClubFragment.e2;
                i.e(createClubFragment, "this$0");
                createClubFragment.S0().p(new s(z));
            }
        });
        R0().j.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: i0.e.b.g3.l.v2.e
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                CreateClubFragment createClubFragment = CreateClubFragment.this;
                k<Object>[] kVarArr = CreateClubFragment.e2;
                i.e(createClubFragment, "this$0");
                createClubFragment.S0().p(new u(!z));
            }
        });
        EditText editText2 = R0().f;
        i.d(editText2, "binding.clubDescription");
        editText2.addTextChangedListener(new i0.e.b.g3.l.v2.k(this));
        R0().f.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: i0.e.b.g3.l.v2.f
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z) {
                CreateClubFragment createClubFragment = CreateClubFragment.this;
                k<Object>[] kVarArr = CreateClubFragment.e2;
                i.e(createClubFragment, "this$0");
                if (z) {
                    ScrollView scrollView = createClubFragment.R0().n;
                    i.d(scrollView, "binding.scroll");
                    i.e(scrollView, "<this>");
                    e eVar = 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001d: CONSTRUCTOR  (r4v3 'eVar' i0.e.b.d3.e) = (r3v3 'scrollView' android.widget.ScrollView) call: i0.e.b.d3.e.<init>(android.widget.ScrollView):void type: CONSTRUCTOR in method: i0.e.b.g3.l.v2.f.onFocusChange(android.view.View, boolean):void, file: classes3.dex
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
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: i0.e.b.d3.e, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                        	... 23 more
                        */
                    /*
                        this = this;
                        com.clubhouse.android.ui.clubs.create.CreateClubFragment r3 = com.clubhouse.android.ui.clubs.create.CreateClubFragment.this
                        m0.r.k<java.lang.Object>[] r0 = com.clubhouse.android.ui.clubs.create.CreateClubFragment.e2
                        java.lang.String r0 = "this$0"
                        m0.n.b.i.e(r3, r0)
                        if (r4 == 0) goto L_0x0030
                        com.clubhouse.android.databinding.FragmentCreateClubBinding r3 = r3.R0()
                        android.widget.ScrollView r3 = r3.n
                        java.lang.String r4 = "binding.scroll"
                        m0.n.b.i.d(r3, r4)
                        java.lang.String r4 = "<this>"
                        m0.n.b.i.e(r3, r4)
                        i0.e.b.d3.e r4 = new i0.e.b.d3.e
                        r4.<init>(r3)
                        android.content.res.Resources r0 = r3.getResources()
                        java.lang.String r1 = "resources"
                        m0.n.b.i.d(r0, r1)
                        long r0 = h0.b0.v.Y1(r0)
                        r3.postDelayed(r4, r0)
                    L_0x0030:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.l.v2.f.onFocusChange(android.view.View, boolean):void");
                }
            });
            v.v2(S0(), new l<q, m0.i>() { // from class: com.clubhouse.android.ui.clubs.create.CreateClubFragment$initDescription$3
                @Override // m0.n.a.l
                public m0.i invoke(q qVar) {
                    q qVar2 = qVar;
                    i.e(qVar2, "state");
                    String str = qVar2.c;
                    CreateClubFragment createClubFragment = CreateClubFragment.this;
                    k<Object>[] kVarArr = CreateClubFragment.e2;
                    createClubFragment.R0().f.setText(str);
                    return m0.i.a;
                }
            });
        }
    }
