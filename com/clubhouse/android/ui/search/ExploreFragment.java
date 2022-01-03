package com.clubhouse.android.ui.search;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import com.airbnb.epoxy.paging3.PagingDataEpoxyController;
import com.clubhouse.android.data.models.local.club.ClubWithAdmin;
import com.clubhouse.android.data.models.local.user.SourceLocation;
import com.clubhouse.android.databinding.FragmentExploreBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.shared.ui.ImpressionTrackingEpoxyRecyclerView;
import com.clubhouse.android.ui.clubs.ClubArgs;
import com.clubhouse.android.ui.search.ExploreFragment;
import com.clubhouse.android.ui.search.Mode;
import com.clubhouse.app.R;
import com.google.android.material.tabs.TabLayout;
import h0.b0.v;
import h0.q.p;
import h0.u.w;
import i0.b.a.t;
import i0.b.b.g;
import i0.b.b.x;
import i0.e.b.b3.b.e.e;
import i0.e.b.b3.b.e.h;
import i0.e.b.b3.b.e.j;
import i0.e.b.g3.w.d;
import i0.e.b.g3.w.f0;
import i0.e.b.g3.w.q;
import i0.e.b.g3.w.z;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.c;
import m0.n.a.l;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.k;
import m0.r.t.a.r.m.a1.a;
import n0.a.f1;
/* compiled from: ExploreFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b)\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u00020\u000b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010 \u001a\u00060\u001dR\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00118\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b!\u0010\u0013R\u001d\u0010(\u001a\u00020#8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/clubhouse/android/ui/search/ExploreFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lcom/clubhouse/android/databinding/FragmentExploreBinding;", "b2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "N0", "()Lcom/clubhouse/android/databinding/FragmentExploreBinding;", "binding", "Lcom/google/android/material/tabs/TabLayout$g;", "e2", "Lcom/google/android/material/tabs/TabLayout$g;", "peopleTab", "Li0/e/a/b/a;", "a2", "Li0/e/a/b/a;", "getActionTrailRecorder", "()Li0/e/a/b/a;", "setActionTrailRecorder", "(Li0/e/a/b/a;)V", "actionTrailRecorder", "Lcom/clubhouse/android/ui/search/ExploreFragment$PagingController;", "d2", "Lcom/clubhouse/android/ui/search/ExploreFragment$PagingController;", "pagedController", "f2", "clubTab", "Lcom/clubhouse/android/ui/search/ExploreViewModel;", "c2", "Lm0/c;", "O0", "()Lcom/clubhouse/android/ui/search/ExploreViewModel;", "viewModel", "<init>", "PagingController", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class ExploreFragment extends Hilt_ExploreFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(ExploreFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentExploreBinding;")), m.c(new PropertyReference1Impl(m.a(ExploreFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/search/ExploreViewModel;"))};
    public i0.e.a.b.a a2;
    public final c c2;
    public TabLayout.g e2;
    public TabLayout.g f2;
    public final FragmentViewBindingDelegate b2 = new FragmentViewBindingDelegate(FragmentExploreBinding.class, this);
    public final PagingController d2 = new PagingController(this);

    /* compiled from: ExploreFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ%\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/clubhouse/android/ui/search/ExploreFragment$PagingController;", "Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;", "Li0/e/b/b3/b/e/j;", "", "currentPosition", "item", "Li0/b/a/t;", "buildItemModel", "(ILi0/e/b/b3/b/e/j;)Li0/b/a/t;", "<init>", "(Lcom/clubhouse/android/ui/search/ExploreFragment;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public final class PagingController extends PagingDataEpoxyController<j> {
        public final /* synthetic */ ExploreFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PagingController(ExploreFragment exploreFragment) {
            super(null, null, null, 7, null);
            i.e(exploreFragment, "this$0");
            this.this$0 = exploreFragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: buildItemModel$lambda-0  reason: not valid java name */
        public static final void m20buildItemModel$lambda0(ExploreFragment exploreFragment, j jVar, View view) {
            i.e(exploreFragment, "this$0");
            ClubArgs clubArgs = new ClubArgs(Integer.valueOf(((e) jVar).b.x), null, null, false, false, SourceLocation.EXPLORE, null, 94);
            i.e(clubArgs, "mavericksArg");
            v.a1(exploreFragment, new q(clubArgs), null, 2);
        }

        public t<?> buildItemModel(int i, j jVar) {
            if (jVar == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            } else if (jVar instanceof h) {
                i0.e.b.g3.w.j0.j jVar2 = new i0.e.b.g3.w.j0.j();
                h hVar = (h) jVar;
                jVar2.s(hVar.b);
                String str = hVar.b;
                jVar2.w();
                jVar2.j = str;
                i.d(jVar2, "ExploreHeader_()\n                        .id(item.title)\n                        .header(item.title)");
                return jVar2;
            } else if (jVar instanceof e) {
                i0.e.b.f3.m.b.h hVar2 = new i0.e.b.f3.m.b.h();
                e eVar = (e) jVar;
                hVar2.t(Integer.valueOf(eVar.b.x));
                ClubWithAdmin clubWithAdmin = eVar.b;
                hVar2.w();
                hVar2.j = clubWithAdmin;
                hVar2.w();
                hVar2.k = true;
                d dVar = new d(this.this$0, jVar);
                hVar2.w();
                hVar2.n = dVar;
                i.d(hVar2, "ListClub_()\n                        .id(item.club.id)\n                        .club(item.club)\n                        .showSocialProof(true)\n                        .clickListener { _ ->\n                            navigateSafe(\n                                ExploreFragmentDirections\n                                    .actionExploreFragmentToClubFragment(\n                                        ClubArgs(item.club.id, source = SourceLocation.EXPLORE))\n                            )\n                        }");
                return hVar2;
            } else if (jVar instanceof i0.e.b.b3.b.e.m) {
                ExploreFragment exploreFragment = this.this$0;
                k<Object>[] kVarArr = ExploreFragment.Z1;
                Object v2 = v.v2(exploreFragment.O0(), new ExploreFragment$PagingController$buildItemModel$2(jVar, this.this$0));
                i.d(v2, "@AndroidEntryPoint\nclass ExploreFragment : BaseFragment(R.layout.fragment_explore) {\n    @Inject\n    lateinit var actionTrailRecorder: ActionTrailRecorder\n\n    private val binding: FragmentExploreBinding by viewBinding()\n    private val viewModel: ExploreViewModel by fragmentViewModel()\n    private val pagedController = PagingController()\n    private lateinit var peopleTab: TabLayout.Tab\n    private lateinit var clubTab: TabLayout.Tab\n\n    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {\n        super.onViewCreated(view, savedInstanceState)\n\n        configurePagingController()\n        binding.back.setOnClickListener {\n            navigateUpSafe()\n        }\n        peopleTab = binding.resultTabs.newTab().setText(R.string.explore_tab_people).apply {\n            binding.resultTabs.addTab(this)\n        }\n        clubTab = binding.resultTabs.newTab().setText(R.string.explore_tab_clubs).apply {\n            binding.resultTabs.addTab(this)\n        }\n        binding.resultTabs.onTabSelected { tab ->\n            if (tab?.position == 0) {\n                viewModel.processIntent(SetMode(Mode.PEOPLE))\n            } else if (tab?.position == 1) {\n                viewModel.processIntent(SetMode(Mode.CLUBS))\n            }\n        }\n        binding.search.debouncedTextChanges()\n            .onEach { viewModel.processIntent(UpdateQuery(it)) }\n            .launchIn(viewLifecycleOwner.lifecycleScope)\n        binding.search.setOnFocusChangeListener { _, hasFocus ->\n            if (hasFocus) {\n                viewModel.processIntent(SearchTapped)\n            }\n        }\n        binding.cancel.setOnClickListener {\n            binding.search.text = null\n            hideSoftKeyBoard()\n            binding.root.requestFocus()\n            viewModel.processIntent(SetMode(Mode.SUGGESTED))\n        }\n\n        binding.recentSpeakers.setOnClickListener {\n            navigateSafe(ExploreFragmentDirections.actionExploreFragmentToRecentSpeakersFragment())\n        }\n\n        viewModel.effectFlow.onEach {\n            when (it) {\n                Invalidate -> pagedController.requestForcedModelBuild()\n                NavigateToUniversalSearch ->\n                    navigateSafe(\n                        ExploreFragmentDirections.actionExploreFragmentToExploreV2Fragment(),\n                        FragmentNavigatorExtras(binding.search to \"search\")\n                    )\n            }\n        }.launchIn(viewLifecycleOwner.lifecycleScope)\n    }\n\n    private fun configurePagingController() {\n        pagedController.apply {\n            scrollToTopOnChange(binding.resultsList)\n            observeState().onEach { state ->\n                withState(viewModel) {\n                    binding.empty.showIf(state is PagingState.Empty && it.query?.isNotBlank() == true)\n                    binding.loading.showIf(state is PagingState.Loading)\n                }\n            }.launchIn(viewLifecycleOwner.lifecycleScope)\n        }\n        binding.resultsList.setController(pagedController)\n        // Disable animations, which are distracting as items change and move between results\n        binding.resultsList.itemAnimator = null\n    }\n\n    override fun invalidate() {\n        withState(viewModel) { state ->\n            binding.resultTabs.hideIf(state.mode == Mode.SUGGESTED)\n            binding.cancel.hideIf(state.mode == Mode.SUGGESTED)\n            binding.empty.text = getString(state.mode.emptyText)\n            if (state.mode == Mode.CLUBS) {\n                binding.resultTabs.selectTab(clubTab)\n            } else if (state.mode == Mode.PEOPLE) {\n                binding.resultTabs.selectTab(peopleTab)\n            }\n\n            state.data?.let {\n                viewLifecycleOwner.lifecycleScope.launch {\n                    if (state.mode == Mode.SUGGESTED) {\n                        pagedController.submitData(\n                            it.insertHeaderItem(\n                                item = HeaderItem(getString(R.string.people_to_follow))\n                            )\n                        )\n                    } else {\n                        pagedController.submitData(it)\n                    }\n                }\n            }\n        }\n    }\n\n    inner class PagingController : PagingDataEpoxyController<PagingItem>() {\n        override fun buildItemModel(currentPosition: Int, item: PagingItem?): EpoxyModel<*> {\n            requireNotNull(item)\n            return when (item) {\n                is HeaderItem ->\n                    ExploreHeader_()\n                        .id(item.title)\n                        .header(item.title)\n                is ClubItem ->\n                    ListClub_()\n                        .id(item.club.id)\n                        .club(item.club)\n                        .showSocialProof(true)\n                        .clickListener { _ ->\n                            navigateSafe(\n                                ExploreFragmentDirections\n                                    .actionExploreFragmentToClubFragment(\n                                        ClubArgs(item.club.id, source = SourceLocation.EXPLORE))\n                            )\n                        }\n                is UserItem ->\n                    withState(viewModel) { state ->\n                        FollowableListUser_()\n                            .id(item.user.id)\n                            .impressionLoggingAction {\n                                if (state.mode == Mode.SUGGESTED) {\n                                    actionTrailRecorder.recommendationImpression(\n                                        SourceLocation.EXPLORE,\n                                        item.user.loggingContext\n                                    )\n                                }\n                            }\n                            .user(item.user)\n                            .userBio(item.user.bio)\n                            .following(item.followedBySelf)\n                            .blocked(item.blockedBySelf)\n                            .self(item.isSelf)\n                            .showFollowButton(state.mode == Mode.SUGGESTED)\n                            .clickListener { _ ->\n                                navigateSafe(\n                                    ExploreFragmentDirections.actionExploreFragmentToProfileFragment(\n                                        item.user.toProfileArgs(SourceLocation.EXPLORE)\n                                    )\n                                )\n                            }\n                            .followClickListener { _ ->\n                                viewModel.processIntent(ToggleFollowUser(item.user))\n                            }\n                    }\n                else -> throw Throwable(\"Invalid item type\")\n            }\n        }\n    }\n}");
                return (t) v2;
            } else {
                throw new Throwable("Invalid item type");
            }
        }
    }

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends i0.b.b.h<ExploreFragment, ExploreViewModel> {
        public final /* synthetic */ m0.r.d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ m0.r.d c;

        public a(m0.r.d dVar, boolean z, l lVar, m0.r.d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<ExploreViewModel> a(ExploreFragment exploreFragment, k kVar) {
            ExploreFragment exploreFragment2 = exploreFragment;
            i.e(exploreFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(exploreFragment2, kVar, this.a, new ExploreFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(z.class), false, this.b);
        }
    }

    public ExploreFragment() {
        super(R.layout.fragment_explore);
        m0.r.d a2 = m.a(ExploreViewModel.class);
        this.c2 = new a(a2, false, new l<i0.b.b.k<ExploreViewModel, z>, ExploreViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.search.ExploreFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ m0.r.d d;
            public final /* synthetic */ m0.r.d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.clubhouse.android.ui.search.ExploreViewModel, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.l
            public ExploreViewModel invoke(i0.b.b.k<ExploreViewModel, z> kVar) {
                i0.b.b.k<ExploreViewModel, z> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, z.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, Z1[1]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(O0(), new l<z, f1>() { // from class: com.clubhouse.android.ui.search.ExploreFragment$invalidate$1
            @Override // m0.n.a.l
            public f1 invoke(z zVar) {
                z zVar2 = zVar;
                i.e(zVar2, "state");
                ExploreFragment exploreFragment = ExploreFragment.this;
                k<Object>[] kVarArr = ExploreFragment.Z1;
                TabLayout tabLayout = exploreFragment.N0().g;
                i.d(tabLayout, "binding.resultTabs");
                Mode mode = zVar2.b;
                Mode mode2 = Mode.SUGGESTED;
                boolean z = false;
                i0.e.b.d3.k.q(tabLayout, Boolean.valueOf(mode == mode2));
                Button button = ExploreFragment.this.N0().c;
                i.d(button, "binding.cancel");
                if (zVar2.b == mode2) {
                    z = true;
                }
                i0.e.b.d3.k.q(button, Boolean.valueOf(z));
                ExploreFragment.this.N0().d.setText(ExploreFragment.this.getString(zVar2.b.getEmptyText()));
                Mode mode3 = zVar2.b;
                if (mode3 == Mode.CLUBS) {
                    TabLayout tabLayout2 = ExploreFragment.this.N0().g;
                    TabLayout.g gVar = ExploreFragment.this.f2;
                    if (gVar != null) {
                        tabLayout2.l(gVar, true);
                    } else {
                        i.m("clubTab");
                        throw null;
                    }
                } else if (mode3 == Mode.PEOPLE) {
                    TabLayout tabLayout3 = ExploreFragment.this.N0().g;
                    TabLayout.g gVar2 = ExploreFragment.this.e2;
                    if (gVar2 != null) {
                        tabLayout3.l(gVar2, true);
                    } else {
                        i.m("peopleTab");
                        throw null;
                    }
                }
                w<j> wVar = zVar2.a;
                if (wVar == null) {
                    return null;
                }
                ExploreFragment exploreFragment2 = ExploreFragment.this;
                p viewLifecycleOwner = exploreFragment2.getViewLifecycleOwner();
                i.d(viewLifecycleOwner, "viewLifecycleOwner");
                return a.E2(h0.q.q.a(viewLifecycleOwner), null, null, new ExploreFragment$invalidate$1$1$1(zVar2, exploreFragment2, wVar, null), 3, null);
            }
        });
    }

    public final FragmentExploreBinding N0() {
        return (FragmentExploreBinding) this.b2.getValue(this, Z1[0]);
    }

    public final ExploreViewModel O0() {
        return (ExploreViewModel) this.c2.getValue();
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.e(view, "view");
        super.onViewCreated(view, bundle);
        PagingController pagingController = this.d2;
        ImpressionTrackingEpoxyRecyclerView impressionTrackingEpoxyRecyclerView = N0().h;
        i.d(impressionTrackingEpoxyRecyclerView, "binding.resultsList");
        v.S1(pagingController, impressionTrackingEpoxyRecyclerView);
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(v.f1(pagingController), new ExploreFragment$configurePagingController$1$1(this, null));
        p viewLifecycleOwner = getViewLifecycleOwner();
        i.d(viewLifecycleOwner, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, h0.q.q.a(viewLifecycleOwner));
        N0().h.setController(this.d2);
        N0().h.setItemAnimator(null);
        N0().b.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.w.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ExploreFragment exploreFragment = ExploreFragment.this;
                k<Object>[] kVarArr = ExploreFragment.Z1;
                i.e(exploreFragment, "this$0");
                v.c1(exploreFragment);
            }
        });
        TabLayout.g i = N0().g.i();
        i.a(R.string.explore_tab_people);
        i.d(i, "binding.resultTabs.newTab().setText(R.string.explore_tab_people)");
        N0().g.a(i);
        this.e2 = i;
        TabLayout.g i2 = N0().g.i();
        i2.a(R.string.explore_tab_clubs);
        i.d(i2, "binding.resultTabs.newTab().setText(R.string.explore_tab_clubs)");
        N0().g.a(i2);
        this.f2 = i2;
        TabLayout tabLayout = N0().g;
        i.d(tabLayout, "binding.resultTabs");
        i0.e.b.d3.k.C(tabLayout, new l<TabLayout.g, m0.i>() { // from class: com.clubhouse.android.ui.search.ExploreFragment$onViewCreated$4
            @Override // m0.n.a.l
            public m0.i invoke(TabLayout.g gVar) {
                TabLayout.g gVar2 = gVar;
                boolean z = true;
                if (gVar2 != null && gVar2.d == 0) {
                    ExploreFragment exploreFragment = ExploreFragment.this;
                    k<Object>[] kVarArr = ExploreFragment.Z1;
                    exploreFragment.O0().p(new f0(Mode.PEOPLE));
                } else {
                    if (gVar2 == null || gVar2.d != 1) {
                        z = false;
                    }
                    if (z) {
                        ExploreFragment exploreFragment2 = ExploreFragment.this;
                        k<Object>[] kVarArr2 = ExploreFragment.Z1;
                        exploreFragment2.O0().p(new f0(Mode.CLUBS));
                    }
                }
                return m0.i.a;
            }
        });
        EditText editText = N0().i;
        i.d(editText, "binding.search");
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$12 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(i0.e.b.d3.k.f(editText), new ExploreFragment$onViewCreated$5(this, null));
        p viewLifecycleOwner2 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner2, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$12, h0.q.q.a(viewLifecycleOwner2));
        N0().i.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: i0.e.b.g3.w.g
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z) {
                ExploreFragment exploreFragment = ExploreFragment.this;
                k<Object>[] kVarArr = ExploreFragment.Z1;
                i.e(exploreFragment, "this$0");
                if (z) {
                    exploreFragment.O0().p(e0.a);
                }
            }
        });
        N0().c.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.w.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ExploreFragment exploreFragment = ExploreFragment.this;
                k<Object>[] kVarArr = ExploreFragment.Z1;
                i.e(exploreFragment, "this$0");
                exploreFragment.N0().i.setText((CharSequence) null);
                v.x0(exploreFragment);
                exploreFragment.N0().a.requestFocus();
                exploreFragment.O0().p(new f0(Mode.SUGGESTED));
            }
        });
        N0().f.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.w.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ExploreFragment exploreFragment = ExploreFragment.this;
                k<Object>[] kVarArr = ExploreFragment.Z1;
                i.e(exploreFragment, "this$0");
                v.a1(exploreFragment, new h0.t.a(R.id.action_exploreFragment_to_recentSpeakersFragment), null, 2);
            }
        });
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$13 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(O0().l, new ExploreFragment$onViewCreated$9(this, null));
        p viewLifecycleOwner3 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner3, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$13, h0.q.q.a(viewLifecycleOwner3));
    }
}
