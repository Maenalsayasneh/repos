package com.clubhouse.android.ui.clubs.invites;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import com.airbnb.epoxy.EpoxyRecyclerView;
import com.airbnb.epoxy.paging3.PagingDataEpoxyController;
import com.clubhouse.android.data.models.local.user.UserInList;
import com.clubhouse.android.databinding.FragmentGrowClubBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.ui.clubs.ClubViewModel;
import com.clubhouse.android.ui.clubs.invites.AddableListUser;
import com.clubhouse.android.ui.clubs.invites.GrowClubFragment;
import com.clubhouse.android.ui.clubs.invites.GrowClubFragment$handleBackNavigation$1;
import com.clubhouse.app.R;
import h0.a.b;
import h0.b0.v;
import h0.q.q;
import h0.u.w;
import i0.b.a.t;
import i0.b.b.c0;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.i;
import i0.b.b.x;
import i0.e.b.b3.b.e.j;
import i0.e.b.g3.l.v1;
import i0.e.b.g3.l.x2.f;
import i0.e.b.g3.l.x2.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.n.a.l;
import m0.n.a.p;
import m0.n.b.m;
import m0.o.c;
import m0.r.d;
import m0.r.k;
import m0.r.t.a.r.m.a1.a;
import n0.a.f1;
/* compiled from: GrowClubFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u000234B\u0007¢\u0006\u0004\b2\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u00020\u000b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0016\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001a\u001a\u00060\u0017R\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001e\u001a\u00060\u001bR\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001d\u0010#\u001a\u00020\u001f8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\r\u001a\u0004\b!\u0010\"R\"\u0010+\u001a\u00020$8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001d\u00101\u001a\u00020,8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100¨\u00065"}, d2 = {"Lcom/clubhouse/android/ui/clubs/invites/GrowClubFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lcom/clubhouse/android/ui/clubs/invites/GrowClubViewModel;", "f2", "Lm0/c;", "R0", "()Lcom/clubhouse/android/ui/clubs/invites/GrowClubViewModel;", "viewModel", "Lcom/clubhouse/android/databinding/FragmentGrowClubBinding;", "c2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "P0", "()Lcom/clubhouse/android/databinding/FragmentGrowClubBinding;", "binding", "Lcom/clubhouse/android/ui/clubs/invites/GrowClubFragment$SearchPagingController;", "e2", "Lcom/clubhouse/android/ui/clubs/invites/GrowClubFragment$SearchPagingController;", "searchController", "Lcom/clubhouse/android/ui/clubs/invites/GrowClubFragment$RecommendationPagingController;", "d2", "Lcom/clubhouse/android/ui/clubs/invites/GrowClubFragment$RecommendationPagingController;", "recommendationController", "Lcom/clubhouse/android/ui/clubs/ClubViewModel;", "g2", "Q0", "()Lcom/clubhouse/android/ui/clubs/ClubViewModel;", "clubViewModel", "Li0/e/a/b/a;", "a2", "Li0/e/a/b/a;", "getActionTrailRecorder", "()Li0/e/a/b/a;", "setActionTrailRecorder", "(Li0/e/a/b/a;)V", "actionTrailRecorder", "Lcom/clubhouse/android/ui/clubs/invites/GrowClubArgs;", "b2", "Lm0/o/c;", "O0", "()Lcom/clubhouse/android/ui/clubs/invites/GrowClubArgs;", "args", "<init>", "RecommendationPagingController", "SearchPagingController", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class GrowClubFragment extends Hilt_GrowClubFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(GrowClubFragment.class), "args", "getArgs()Lcom/clubhouse/android/ui/clubs/invites/GrowClubArgs;")), m.c(new PropertyReference1Impl(m.a(GrowClubFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentGrowClubBinding;")), m.c(new PropertyReference1Impl(m.a(GrowClubFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/clubs/invites/GrowClubViewModel;")), m.c(new PropertyReference1Impl(m.a(GrowClubFragment.class), "clubViewModel", "getClubViewModel()Lcom/clubhouse/android/ui/clubs/ClubViewModel;"))};
    public i0.e.a.b.a a2;
    public final c b2 = new i();
    public final FragmentViewBindingDelegate c2 = new FragmentViewBindingDelegate(FragmentGrowClubBinding.class, this);
    public final RecommendationPagingController d2 = new RecommendationPagingController(this);
    public final SearchPagingController e2 = new SearchPagingController(this);
    public final m0.c f2;
    public final m0.c g2;

    /* compiled from: GrowClubFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0007\u001a\u00020\u00062\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/clubhouse/android/ui/clubs/invites/GrowClubFragment$RecommendationPagingController;", "Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;", "Li0/e/b/b3/b/e/j;", "", "Li0/b/a/t;", "models", "Lm0/i;", "addModels", "(Ljava/util/List;)V", "", "currentPosition", "item", "buildItemModel", "(ILi0/e/b/b3/b/e/j;)Li0/b/a/t;", "<init>", "(Lcom/clubhouse/android/ui/clubs/invites/GrowClubFragment;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public final class RecommendationPagingController extends PagingDataEpoxyController<j> {
        public final /* synthetic */ GrowClubFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RecommendationPagingController(GrowClubFragment growClubFragment) {
            super(null, null, null, 7, null);
            m0.n.b.i.e(growClubFragment, "this$0");
            this.this$0 = growClubFragment;
        }

        @Override // com.airbnb.epoxy.paging3.PagingDataEpoxyController
        public void addModels(List<? extends t<?>> list) {
            m0.n.b.i.e(list, "models");
            GrowClubFragment growClubFragment = this.this$0;
            k<Object>[] kVarArr = GrowClubFragment.Z1;
            v.u2(growClubFragment.Q0(), this.this$0.R0(), new GrowClubFragment$RecommendationPagingController$addModels$1(this, this.this$0));
            super.addModels(list);
        }

        public t<?> buildItemModel(int i, j jVar) {
            GrowClubFragment growClubFragment = this.this$0;
            Objects.requireNonNull(jVar, "null cannot be cast to non-null type com.clubhouse.android.data.network.paging.UserItem");
            i0.e.b.g3.l.x2.j N0 = GrowClubFragment.N0(growClubFragment, (i0.e.b.b3.b.e.m) jVar);
            m0.n.b.i.d(N0, "buildUser(item as UserItem)");
            return N0;
        }
    }

    /* compiled from: GrowClubFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ%\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/clubhouse/android/ui/clubs/invites/GrowClubFragment$SearchPagingController;", "Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;", "Li0/e/b/b3/b/e/j;", "", "currentPosition", "item", "Li0/b/a/t;", "buildItemModel", "(ILi0/e/b/b3/b/e/j;)Li0/b/a/t;", "<init>", "(Lcom/clubhouse/android/ui/clubs/invites/GrowClubFragment;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public final class SearchPagingController extends PagingDataEpoxyController<j> {
        public final /* synthetic */ GrowClubFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SearchPagingController(GrowClubFragment growClubFragment) {
            super(null, null, null, 7, null);
            m0.n.b.i.e(growClubFragment, "this$0");
            this.this$0 = growClubFragment;
        }

        public t<?> buildItemModel(int i, j jVar) {
            GrowClubFragment growClubFragment = this.this$0;
            Objects.requireNonNull(jVar, "null cannot be cast to non-null type com.clubhouse.android.data.network.paging.UserItem");
            i0.e.b.g3.l.x2.j N0 = GrowClubFragment.N0(growClubFragment, (i0.e.b.b3.b.e.m) jVar);
            m0.n.b.i.d(N0, "buildUser(item as UserItem)");
            return N0;
        }
    }

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<GrowClubFragment, GrowClubViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public m0.c<GrowClubViewModel> a(GrowClubFragment growClubFragment, k kVar) {
            GrowClubFragment growClubFragment2 = growClubFragment;
            m0.n.b.i.e(growClubFragment2, "thisRef");
            m0.n.b.i.e(kVar, "property");
            return g.a.b(growClubFragment2, kVar, this.a, new GrowClubFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(i0.e.b.g3.l.x2.t.class), false, this.b);
        }
    }

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class b extends h<GrowClubFragment, ClubViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public b(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public m0.c<ClubViewModel> a(GrowClubFragment growClubFragment, k kVar) {
            GrowClubFragment growClubFragment2 = growClubFragment;
            m0.n.b.i.e(growClubFragment2, "thisRef");
            m0.n.b.i.e(kVar, "property");
            return g.a.b(growClubFragment2, kVar, this.a, new GrowClubFragment$special$$inlined$fragmentViewModel$default$4$1(this), m.a(v1.class), false, this.b);
        }
    }

    public GrowClubFragment() {
        super(R.layout.fragment_grow_club);
        d a2 = m.a(GrowClubViewModel.class);
        a aVar = new a(a2, false, new l<i0.b.b.k<GrowClubViewModel, i0.e.b.g3.l.x2.t>, GrowClubViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.clubs.invites.GrowClubFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.airbnb.mvrx.MavericksViewModel, com.clubhouse.android.ui.clubs.invites.GrowClubViewModel] */
            @Override // m0.n.a.l
            public GrowClubViewModel invoke(i0.b.b.k<GrowClubViewModel, i0.e.b.g3.l.x2.t> kVar) {
                i0.b.b.k<GrowClubViewModel, i0.e.b.g3.l.x2.t> kVar2 = kVar;
                m0.n.b.i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                m0.n.b.i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                m0.n.b.i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, i0.e.b.g3.l.x2.t.class, dVar, name, false, kVar2, 16);
            }
        }, a2);
        k<?>[] kVarArr = Z1;
        this.f2 = aVar.a(this, kVarArr[2]);
        d a3 = m.a(ClubViewModel.class);
        this.g2 = new b(a3, false, new l<i0.b.b.k<ClubViewModel, v1>, ClubViewModel>(a3, a3) { // from class: com.clubhouse.android.ui.clubs.invites.GrowClubFragment$special$$inlined$fragmentViewModel$default$3
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.clubhouse.android.ui.clubs.ClubViewModel, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.l
            public ClubViewModel invoke(i0.b.b.k<ClubViewModel, v1> kVar) {
                i0.b.b.k<ClubViewModel, v1> kVar2 = kVar;
                m0.n.b.i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                m0.n.b.i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                m0.n.b.i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, v1.class, dVar, name, false, kVar2, 16);
            }
        }, a3).a(this, kVarArr[3]);
    }

    public static final i0.e.b.g3.l.x2.j N0(GrowClubFragment growClubFragment, i0.e.b.b3.b.e.m mVar) {
        int ordinal = growClubFragment.O0().d.ordinal();
        if (ordinal == 0) {
            return (i0.e.b.g3.l.x2.j) v.v2(growClubFragment.R0(), new l<i0.e.b.g3.l.x2.t, i0.e.b.g3.l.x2.j>(growClubFragment) { // from class: com.clubhouse.android.ui.clubs.invites.GrowClubFragment$buildUser$1
                public final /* synthetic */ GrowClubFragment d;

                {
                    this.d = r2;
                }

                @Override // m0.n.a.l
                public i0.e.b.g3.l.x2.j invoke(i0.e.b.g3.l.x2.t tVar) {
                    i0.e.b.g3.l.x2.t tVar2 = tVar;
                    m0.n.b.i.e(tVar2, "state");
                    i0.e.b.g3.l.x2.j jVar = new i0.e.b.g3.l.x2.j();
                    jVar.t(i0.e.b.b3.b.e.m.this.g.getId());
                    UserInList userInList = i0.e.b.b3.b.e.m.this.g;
                    jVar.w();
                    jVar.j = userInList;
                    String str = i0.e.b.b3.b.e.m.this.g.c;
                    jVar.w();
                    jVar.k = str;
                    boolean contains = tVar2.e.contains(i0.e.b.b3.b.e.m.this.g.getId());
                    jVar.w();
                    jVar.o = contains;
                    AddableListUser.AddMethod addMethod = AddableListUser.AddMethod.INVITE;
                    jVar.w();
                    jVar.m = addMethod;
                    boolean contains2 = tVar2.f.contains(i0.e.b.b3.b.e.m.this.g.getId());
                    jVar.w();
                    jVar.n = contains2;
                    i0.e.b.g3.l.x2.c cVar = 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0064: CONSTRUCTOR  (r2v6 'cVar' i0.e.b.g3.l.x2.c) = 
                          (wrap: com.clubhouse.android.ui.clubs.invites.GrowClubFragment : 0x005e: IGET  (r5v4 com.clubhouse.android.ui.clubs.invites.GrowClubFragment A[REMOVE]) = (r4v0 'this' com.clubhouse.android.ui.clubs.invites.GrowClubFragment$buildUser$1 A[IMMUTABLE_TYPE, THIS]) com.clubhouse.android.ui.clubs.invites.GrowClubFragment$buildUser$1.d com.clubhouse.android.ui.clubs.invites.GrowClubFragment)
                          (wrap: i0.e.b.b3.b.e.m : 0x0060: IGET  (r1v13 i0.e.b.b3.b.e.m A[REMOVE]) = (r4v0 'this' com.clubhouse.android.ui.clubs.invites.GrowClubFragment$buildUser$1 A[IMMUTABLE_TYPE, THIS]) com.clubhouse.android.ui.clubs.invites.GrowClubFragment$buildUser$1.c i0.e.b.b3.b.e.m)
                         call: i0.e.b.g3.l.x2.c.<init>(com.clubhouse.android.ui.clubs.invites.GrowClubFragment, i0.e.b.b3.b.e.m):void type: CONSTRUCTOR in method: com.clubhouse.android.ui.clubs.invites.GrowClubFragment$buildUser$1.invoke(i0.e.b.g3.l.x2.t):i0.e.b.g3.l.x2.j, file: classes3.dex
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
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: i0.e.b.g3.l.x2.c, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                        	... 15 more
                        */
                    /*
                        this = this;
                        i0.e.b.g3.l.x2.t r5 = (i0.e.b.g3.l.x2.t) r5
                        java.lang.String r0 = "state"
                        m0.n.b.i.e(r5, r0)
                        i0.e.b.g3.l.x2.j r0 = new i0.e.b.g3.l.x2.j
                        r0.<init>()
                        r1 = 1
                        java.lang.Number[] r1 = new java.lang.Number[r1]
                        i0.e.b.b3.b.e.m r2 = i0.e.b.b3.b.e.m.this
                        com.clubhouse.android.data.models.local.user.UserInList r2 = r2.g
                        java.lang.Integer r2 = r2.getId()
                        r3 = 0
                        r1[r3] = r2
                        r0.t(r1)
                        i0.e.b.b3.b.e.m r1 = i0.e.b.b3.b.e.m.this
                        com.clubhouse.android.data.models.local.user.UserInList r1 = r1.g
                        r0.w()
                        r0.j = r1
                        i0.e.b.b3.b.e.m r1 = i0.e.b.b3.b.e.m.this
                        com.clubhouse.android.data.models.local.user.UserInList r1 = r1.g
                        java.lang.String r1 = r1.c
                        r0.w()
                        r0.k = r1
                        java.util.Set<java.lang.Integer> r1 = r5.e
                        i0.e.b.b3.b.e.m r2 = i0.e.b.b3.b.e.m.this
                        com.clubhouse.android.data.models.local.user.UserInList r2 = r2.g
                        java.lang.Integer r2 = r2.getId()
                        boolean r1 = r1.contains(r2)
                        r0.w()
                        r0.o = r1
                        com.clubhouse.android.ui.clubs.invites.AddableListUser$AddMethod r1 = com.clubhouse.android.ui.clubs.invites.AddableListUser.AddMethod.INVITE
                        r0.w()
                        r0.m = r1
                        java.util.Set<java.lang.Integer> r5 = r5.f
                        i0.e.b.b3.b.e.m r1 = i0.e.b.b3.b.e.m.this
                        com.clubhouse.android.data.models.local.user.UserInList r1 = r1.g
                        java.lang.Integer r1 = r1.getId()
                        boolean r5 = r5.contains(r1)
                        r0.w()
                        r0.n = r5
                        com.clubhouse.android.ui.clubs.invites.GrowClubFragment r5 = r4.d
                        i0.e.b.b3.b.e.m r1 = i0.e.b.b3.b.e.m.this
                        i0.e.b.g3.l.x2.c r2 = new i0.e.b.g3.l.x2.c
                        r2.<init>(r5, r1)
                        r0.w()
                        r0.p = r2
                        com.clubhouse.android.ui.clubs.invites.GrowClubFragment r5 = r4.d
                        i0.e.b.b3.b.e.m r1 = i0.e.b.b3.b.e.m.this
                        i0.e.b.g3.l.x2.d r2 = new i0.e.b.g3.l.x2.d
                        r2.<init>(r5, r1)
                        r0.w()
                        r0.l = r2
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.clubhouse.android.ui.clubs.invites.GrowClubFragment$buildUser$1.invoke(java.lang.Object):java.lang.Object");
                }
            });
        }
        if (ordinal == 1) {
            return (i0.e.b.g3.l.x2.j) v.u2(growClubFragment.Q0(), growClubFragment.R0(), new p<v1, i0.e.b.g3.l.x2.t, i0.e.b.g3.l.x2.j>(growClubFragment) { // from class: com.clubhouse.android.ui.clubs.invites.GrowClubFragment$buildUser$2
                public final /* synthetic */ GrowClubFragment d;

                {
                    this.d = r2;
                }

                @Override // m0.n.a.p
                public i0.e.b.g3.l.x2.j invoke(v1 v1Var, i0.e.b.g3.l.x2.t tVar) {
                    v1 v1Var2 = v1Var;
                    i0.e.b.g3.l.x2.t tVar2 = tVar;
                    m0.n.b.i.e(v1Var2, "clubState");
                    m0.n.b.i.e(tVar2, "state");
                    i0.e.b.g3.l.x2.j jVar = new i0.e.b.g3.l.x2.j();
                    jVar.t(i0.e.b.b3.b.e.m.this.g.getId());
                    UserInList userInList = i0.e.b.b3.b.e.m.this.g;
                    jVar.w();
                    jVar.j = userInList;
                    String str = i0.e.b.b3.b.e.m.this.g.c;
                    jVar.w();
                    jVar.k = str;
                    boolean contains = tVar2.e.contains(i0.e.b.b3.b.e.m.this.g.getId());
                    jVar.w();
                    jVar.o = contains;
                    AddableListUser.AddMethod addMethod = AddableListUser.AddMethod.NOMINATE;
                    jVar.w();
                    jVar.m = addMethod;
                    boolean contains2 = tVar2.f.contains(i0.e.b.b3.b.e.m.this.g.getId());
                    jVar.w();
                    jVar.n = contains2;
                    f fVar = 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x006b: CONSTRUCTOR  (r2v6 'fVar' i0.e.b.g3.l.x2.f) = 
                          (wrap: com.clubhouse.android.ui.clubs.invites.GrowClubFragment : 0x0065: IGET  (r6v4 com.clubhouse.android.ui.clubs.invites.GrowClubFragment A[REMOVE]) = (r4v0 'this' com.clubhouse.android.ui.clubs.invites.GrowClubFragment$buildUser$2 A[IMMUTABLE_TYPE, THIS]) com.clubhouse.android.ui.clubs.invites.GrowClubFragment$buildUser$2.d com.clubhouse.android.ui.clubs.invites.GrowClubFragment)
                          (wrap: i0.e.b.b3.b.e.m : 0x0067: IGET  (r1v13 i0.e.b.b3.b.e.m A[REMOVE]) = (r4v0 'this' com.clubhouse.android.ui.clubs.invites.GrowClubFragment$buildUser$2 A[IMMUTABLE_TYPE, THIS]) com.clubhouse.android.ui.clubs.invites.GrowClubFragment$buildUser$2.c i0.e.b.b3.b.e.m)
                          (r5v1 'v1Var2' i0.e.b.g3.l.v1)
                         call: i0.e.b.g3.l.x2.f.<init>(com.clubhouse.android.ui.clubs.invites.GrowClubFragment, i0.e.b.b3.b.e.m, i0.e.b.g3.l.v1):void type: CONSTRUCTOR in method: com.clubhouse.android.ui.clubs.invites.GrowClubFragment$buildUser$2.invoke(i0.e.b.g3.l.v1, i0.e.b.g3.l.x2.t):i0.e.b.g3.l.x2.j, file: classes3.dex
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
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: i0.e.b.g3.l.x2.f, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                        	... 15 more
                        */
                    /*
                        this = this;
                        i0.e.b.g3.l.v1 r5 = (i0.e.b.g3.l.v1) r5
                        i0.e.b.g3.l.x2.t r6 = (i0.e.b.g3.l.x2.t) r6
                        java.lang.String r0 = "clubState"
                        m0.n.b.i.e(r5, r0)
                        java.lang.String r0 = "state"
                        m0.n.b.i.e(r6, r0)
                        i0.e.b.g3.l.x2.j r0 = new i0.e.b.g3.l.x2.j
                        r0.<init>()
                        r1 = 1
                        java.lang.Number[] r1 = new java.lang.Number[r1]
                        i0.e.b.b3.b.e.m r2 = i0.e.b.b3.b.e.m.this
                        com.clubhouse.android.data.models.local.user.UserInList r2 = r2.g
                        java.lang.Integer r2 = r2.getId()
                        r3 = 0
                        r1[r3] = r2
                        r0.t(r1)
                        i0.e.b.b3.b.e.m r1 = i0.e.b.b3.b.e.m.this
                        com.clubhouse.android.data.models.local.user.UserInList r1 = r1.g
                        r0.w()
                        r0.j = r1
                        i0.e.b.b3.b.e.m r1 = i0.e.b.b3.b.e.m.this
                        com.clubhouse.android.data.models.local.user.UserInList r1 = r1.g
                        java.lang.String r1 = r1.c
                        r0.w()
                        r0.k = r1
                        java.util.Set<java.lang.Integer> r1 = r6.e
                        i0.e.b.b3.b.e.m r2 = i0.e.b.b3.b.e.m.this
                        com.clubhouse.android.data.models.local.user.UserInList r2 = r2.g
                        java.lang.Integer r2 = r2.getId()
                        boolean r1 = r1.contains(r2)
                        r0.w()
                        r0.o = r1
                        com.clubhouse.android.ui.clubs.invites.AddableListUser$AddMethod r1 = com.clubhouse.android.ui.clubs.invites.AddableListUser.AddMethod.NOMINATE
                        r0.w()
                        r0.m = r1
                        java.util.Set<java.lang.Integer> r6 = r6.f
                        i0.e.b.b3.b.e.m r1 = i0.e.b.b3.b.e.m.this
                        com.clubhouse.android.data.models.local.user.UserInList r1 = r1.g
                        java.lang.Integer r1 = r1.getId()
                        boolean r6 = r6.contains(r1)
                        r0.w()
                        r0.n = r6
                        com.clubhouse.android.ui.clubs.invites.GrowClubFragment r6 = r4.d
                        i0.e.b.b3.b.e.m r1 = i0.e.b.b3.b.e.m.this
                        i0.e.b.g3.l.x2.f r2 = new i0.e.b.g3.l.x2.f
                        r2.<init>(r6, r1, r5)
                        r0.w()
                        r0.p = r2
                        com.clubhouse.android.ui.clubs.invites.GrowClubFragment r5 = r4.d
                        i0.e.b.b3.b.e.m r6 = i0.e.b.b3.b.e.m.this
                        i0.e.b.g3.l.x2.e r1 = new i0.e.b.g3.l.x2.e
                        r1.<init>(r5, r6)
                        r0.w()
                        r0.l = r1
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.clubhouse.android.ui.clubs.invites.GrowClubFragment$buildUser$2.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
                }
            });
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // i0.b.b.q
    public void J() {
        v.u2(Q0(), R0(), new p<v1, i0.e.b.g3.l.x2.t, f1>() { // from class: com.clubhouse.android.ui.clubs.invites.GrowClubFragment$invalidate$1
            @Override // m0.n.a.p
            public f1 invoke(v1 v1Var, i0.e.b.g3.l.x2.t tVar) {
                v1 v1Var2 = v1Var;
                i0.e.b.g3.l.x2.t tVar2 = tVar;
                m0.n.b.i.e(v1Var2, "clubState");
                m0.n.b.i.e(tVar2, "state");
                GrowClubFragment.this.d2.requestModelBuild();
                ProgressBar progressBar = GrowClubFragment.this.P0().e;
                m0.n.b.i.d(progressBar, "binding.loading");
                i0.e.b.d3.k.L(progressBar, Boolean.valueOf((v1Var2.c instanceof i0.b.b.f) || (v1Var2.d instanceof i0.b.b.f) || (tVar2.h instanceof i0.b.b.f)));
                if (v1Var2.d.a() != null) {
                    GrowClubFragment growClubFragment = GrowClubFragment.this;
                    w<j> wVar = tVar2.c;
                    if (wVar != null) {
                        h0.q.p viewLifecycleOwner = growClubFragment.getViewLifecycleOwner();
                        m0.n.b.i.d(viewLifecycleOwner, "viewLifecycleOwner");
                        a.E2(q.a(viewLifecycleOwner), null, null, new GrowClubFragment$invalidate$1$1$1$1(growClubFragment, wVar, v1Var2, tVar2, null), 3, null);
                    }
                }
                w<j> wVar2 = tVar2.d;
                if (wVar2 == null) {
                    return null;
                }
                GrowClubFragment growClubFragment2 = GrowClubFragment.this;
                h0.q.p viewLifecycleOwner2 = growClubFragment2.getViewLifecycleOwner();
                m0.n.b.i.d(viewLifecycleOwner2, "viewLifecycleOwner");
                return a.E2(q.a(viewLifecycleOwner2), null, null, new GrowClubFragment$invalidate$1$2$1(growClubFragment2, wVar2, v1Var2, tVar2, null), 3, null);
            }
        });
    }

    public final GrowClubArgs O0() {
        return (GrowClubArgs) this.b2.getValue(this, Z1[0]);
    }

    public final FragmentGrowClubBinding P0() {
        return (FragmentGrowClubBinding) this.c2.getValue(this, Z1[1]);
    }

    public final ClubViewModel Q0() {
        return (ClubViewModel) this.g2.getValue();
    }

    public final GrowClubViewModel R0() {
        return (GrowClubViewModel) this.f2.getValue();
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m0.n.b.i.e(view, "view");
        super.onViewCreated(view, bundle);
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        m0.n.b.i.d(onBackPressedDispatcher, "requireActivity().onBackPressedDispatcher");
        g0.a.b.b.a.a(onBackPressedDispatcher, this, false, new l<h0.a.b, m0.i>() { // from class: com.clubhouse.android.ui.clubs.invites.GrowClubFragment$onViewCreated$1
            @Override // m0.n.a.l
            public m0.i invoke(b bVar) {
                m0.n.b.i.e(bVar, "$this$addCallback");
                GrowClubFragment growClubFragment = GrowClubFragment.this;
                k<Object>[] kVarArr = GrowClubFragment.Z1;
                v.v2(growClubFragment.R0(), new GrowClubFragment$handleBackNavigation$1(growClubFragment));
                return m0.i.a;
            }
        }, 2);
        P0().a.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.l.x2.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GrowClubFragment growClubFragment = GrowClubFragment.this;
                k<Object>[] kVarArr = GrowClubFragment.Z1;
                m0.n.b.i.e(growClubFragment, "this$0");
                v.v2(growClubFragment.R0(), new GrowClubFragment$handleBackNavigation$1(growClubFragment));
            }
        });
        TextView textView = P0().b;
        m0.n.b.i.d(textView, "binding.done");
        GrowClubSource growClubSource = O0().q;
        GrowClubSource growClubSource2 = GrowClubSource.CLUB_CREATION;
        i0.e.b.d3.k.L(textView, Boolean.valueOf(growClubSource == growClubSource2));
        P0().b.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.l.x2.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GrowClubFragment growClubFragment = GrowClubFragment.this;
                k<Object>[] kVarArr = GrowClubFragment.Z1;
                m0.n.b.i.e(growClubFragment, "this$0");
                v.V1(growClubFragment, "club_update_result", Boolean.TRUE);
                v.c1(growClubFragment);
            }
        });
        if (O0().q == growClubSource2) {
            TextView textView2 = P0().d;
            m0.n.b.i.d(textView2, "binding.inviteMessage");
            i0.e.b.d3.k.K(textView2);
            TextView textView3 = P0().d;
            Resources resources = getResources();
            m0.n.b.i.d(resources, "resources");
            ArrayList i1 = i0.d.a.a.a.i1(resources, "<this>", new Object[0], "rawArgs", 0);
            String string = resources.getString(R.string.club_invite_message);
            m0.n.b.i.d(string, "getString(id)");
            Object[] array = i1.toArray(new Object[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            Object[] copyOf = Arrays.copyOf(array, array.length);
            String format = String.format(string, Arrays.copyOf(copyOf, copyOf.length));
            m0.n.b.i.d(format, "java.lang.String.format(format, *args)");
            Spanned fromHtml = Html.fromHtml(format, 63);
            m0.n.b.i.d(fromHtml, "fromHtml(\n            String.format(getString(id), *args.toTypedArray()),\n            HtmlCompat.FROM_HTML_MODE_COMPACT\n        )");
            textView3.setText(fromHtml);
        }
        P0().f.setController(this.d2);
        EditText editText = P0().g;
        m0.n.b.i.d(editText, "binding.search");
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(i0.e.b.d3.k.f(editText), new GrowClubFragment$onViewCreated$4(this, null));
        h0.q.p viewLifecycleOwner = getViewLifecycleOwner();
        m0.n.b.i.d(viewLifecycleOwner, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner));
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$12 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(R0().l, new GrowClubFragment$onViewCreated$5(this, null));
        h0.q.p viewLifecycleOwner2 = getViewLifecycleOwner();
        m0.n.b.i.d(viewLifecycleOwner2, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$12, q.a(viewLifecycleOwner2));
        f1 unused = x0(R0(), GrowClubFragment$onViewCreated$6.c, (r5 & 2) != 0 ? c0.a : null, new GrowClubFragment$onViewCreated$7(this, null));
        f1 unused2 = x0(R0(), GrowClubFragment$onViewCreated$8.c, (r5 & 2) != 0 ? c0.a : null, new GrowClubFragment$onViewCreated$9(this, null));
        SearchPagingController searchPagingController = this.e2;
        EpoxyRecyclerView epoxyRecyclerView = P0().f;
        m0.n.b.i.d(epoxyRecyclerView, "binding.resultsList");
        v.S1(searchPagingController, epoxyRecyclerView);
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$13 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(v.f1(this.e2), new GrowClubFragment$onViewCreated$10(this, null));
        h0.q.p viewLifecycleOwner3 = getViewLifecycleOwner();
        m0.n.b.i.d(viewLifecycleOwner3, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$13, q.a(viewLifecycleOwner3));
        R0().p(u.a);
    }
}
