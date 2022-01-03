package com.clubhouse.android.ui.search;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.airbnb.epoxy.paging3.PagingDataEpoxyController;
import com.clubhouse.android.channels.model.AudienceType;
import com.clubhouse.android.data.models.local.EventInClub;
import com.clubhouse.android.data.models.local.channel.ChannelInFeed;
import com.clubhouse.android.data.models.local.club.ClubWithAdmin;
import com.clubhouse.android.data.models.local.user.BasicUser;
import com.clubhouse.android.data.models.local.user.SourceLocation;
import com.clubhouse.android.data.models.local.user.UserInFeed;
import com.clubhouse.android.data.models.local.user.UserInList;
import com.clubhouse.android.databinding.FragmentExploreV2Binding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.shared.ui.ImpressionTrackingEpoxyRecyclerView;
import com.clubhouse.android.ui.channels.ChannelNavigation;
import com.clubhouse.android.ui.clubs.ClubArgs;
import com.clubhouse.android.ui.profile.ProfileArgs;
import com.clubhouse.android.ui.search.ExploreV2Fragment;
import com.clubhouse.android.user.model.UserInRoom;
import com.clubhouse.app.R;
import com.google.android.material.tabs.TabLayout;
import com.stripe.android.model.Stripe3ds2AuthParams;
import h0.b0.v;
import h0.q.q;
import i0.b.b.c0;
import i0.b.b.x;
import i0.e.b.b3.b.e.e;
import i0.e.b.b3.b.e.g;
import i0.e.b.b3.b.e.h;
import i0.e.b.b3.b.e.j;
import i0.e.b.b3.b.e.l;
import i0.e.b.g3.w.b0;
import i0.e.b.g3.w.f0;
import i0.e.b.g3.w.i0;
import i0.e.b.g3.w.j0.f;
import i0.e.b.g3.w.n;
import i0.e.b.g3.w.p;
import i0.e.b.g3.w.t;
import i0.e.b.g3.w.w;
import i0.e.b.g3.w.y;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.c;
import m0.i;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
import n0.a.f1;
/* compiled from: ExploreV2Fragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001:B\u0007¢\u0006\u0004\b9\u0010\fJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0018\u001a\u00060\u0015R\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b!\u0010\u000fR\u001a\u0010$\u001a\u00060\u0015R\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u0017R\u001c\u0010*\u001a\u00020%8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001d\u00100\u001a\u00020+8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\r8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b1\u0010\u000fR\u001d\u00108\u001a\u0002038B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107¨\u0006;"}, d2 = {"Lcom/clubhouse/android/ui/search/ExploreV2Fragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lcom/google/android/material/tabs/TabLayout$g;", "i2", "Lcom/google/android/material/tabs/TabLayout$g;", "clubTab", "j2", "roomTab", "k2", "eventTab", "Lcom/clubhouse/android/ui/search/ExploreV2Fragment$PagingController;", "f2", "Lcom/clubhouse/android/ui/search/ExploreV2Fragment$PagingController;", "recentSearchesController", "Li0/e/a/b/a;", "a2", "Li0/e/a/b/a;", "N0", "()Li0/e/a/b/a;", "setActionTrailRecorder", "(Li0/e/a/b/a;)V", "actionTrailRecorder", "g2", "topTab", "e2", "searchController", "", "b2", "Z", "K0", "()Z", "shouldShowKeyboard", "Lcom/clubhouse/android/databinding/FragmentExploreV2Binding;", "c2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "O0", "()Lcom/clubhouse/android/databinding/FragmentExploreV2Binding;", "binding", "h2", "peopleTab", "Lcom/clubhouse/android/ui/search/ExploreV2ViewModel;", "d2", "Lm0/c;", "P0", "()Lcom/clubhouse/android/ui/search/ExploreV2ViewModel;", "viewModel", "<init>", "PagingController", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class ExploreV2Fragment extends Hilt_ExploreV2Fragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(ExploreV2Fragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentExploreV2Binding;")), m.c(new PropertyReference1Impl(m.a(ExploreV2Fragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/search/ExploreV2ViewModel;"))};
    public i0.e.a.b.a a2;
    public final c d2;
    public TabLayout.g g2;
    public TabLayout.g h2;
    public TabLayout.g i2;
    public TabLayout.g j2;
    public TabLayout.g k2;
    public final boolean b2 = true;
    public final FragmentViewBindingDelegate c2 = new FragmentViewBindingDelegate(FragmentExploreV2Binding.class, this);
    public final PagingController e2 = new PagingController(this);
    public final PagingController f2 = new PagingController(this);

    /* compiled from: ExploreV2Fragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ%\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/clubhouse/android/ui/search/ExploreV2Fragment$PagingController;", "Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;", "Li0/e/b/b3/b/e/j;", "", "currentPosition", "item", "Li0/b/a/t;", "buildItemModel", "(ILi0/e/b/b3/b/e/j;)Li0/b/a/t;", "<init>", "(Lcom/clubhouse/android/ui/search/ExploreV2Fragment;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public final class PagingController extends PagingDataEpoxyController<j> {
        public final /* synthetic */ ExploreV2Fragment this$0;

        /* compiled from: kotlin-style lambda group */
        /* loaded from: classes.dex */
        public static final class a extends Lambda implements m0.n.a.a<i> {
            public final /* synthetic */ int c;
            public final /* synthetic */ Object d;
            public final /* synthetic */ Object q;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(int i, Object obj, Object obj2) {
                super(0);
                this.c = i;
                this.d = obj;
                this.q = obj2;
            }

            @Override // m0.n.a.a
            public final i invoke() {
                int i = this.c;
                if (i == 0) {
                    ((ExploreV2Fragment) this.d).N0().c(SourceLocation.SEARCH, ((g) ((j) this.q)).e);
                    return i.a;
                } else if (i == 1) {
                    ((ExploreV2Fragment) this.d).N0().c(SourceLocation.SEARCH, ((l) ((j) this.q)).c);
                    return i.a;
                } else if (i == 2) {
                    ((ExploreV2Fragment) this.d).N0().c(SourceLocation.SEARCH, ((e) ((j) this.q)).d);
                    return i.a;
                } else if (i == 3) {
                    ((ExploreV2Fragment) this.d).N0().c(SourceLocation.SEARCH, ((i0.e.b.b3.b.e.m) ((j) this.q)).k);
                    return i.a;
                } else if (i == 4) {
                    ((ExploreV2Fragment) this.d).N0().c(SourceLocation.SEARCH, ((i0.e.b.b3.b.e.c) ((j) this.q)).c);
                    return i.a;
                } else {
                    throw null;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PagingController(ExploreV2Fragment exploreV2Fragment) {
            super(null, null, null, 7, null);
            m0.n.b.i.e(exploreV2Fragment, "this$0");
            this.this$0 = exploreV2Fragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: buildItemModel$lambda-0  reason: not valid java name */
        public static final void m21buildItemModel$lambda0(ExploreV2Fragment exploreV2Fragment, View view) {
            m0.n.b.i.e(exploreV2Fragment, "this$0");
            k<Object>[] kVarArr = ExploreV2Fragment.Z1;
            exploreV2Fragment.P0().p(p.a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: buildItemModel$lambda-1  reason: not valid java name */
        public static final void m22buildItemModel$lambda1(ExploreV2Fragment exploreV2Fragment, j jVar, View view) {
            m0.n.b.i.e(exploreV2Fragment, "this$0");
            i0.e.a.b.a N0 = exploreV2Fragment.N0();
            SourceLocation sourceLocation = SourceLocation.SEARCH;
            e eVar = (e) jVar;
            N0.a(sourceLocation, eVar.d);
            ClubArgs clubArgs = new ClubArgs(Integer.valueOf(eVar.b.x), null, null, false, false, sourceLocation, eVar.d, 30);
            m0.n.b.i.e(clubArgs, "mavericksArg");
            v.a1(exploreV2Fragment, new t(clubArgs), null, 2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: buildItemModel$lambda-2  reason: not valid java name */
        public static final void m23buildItemModel$lambda2(ExploreV2Fragment exploreV2Fragment, j jVar, View view) {
            m0.n.b.i.e(exploreV2Fragment, "this$0");
            k<Object>[] kVarArr = ExploreV2Fragment.Z1;
            exploreV2Fragment.P0().p(new b0((e) jVar));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: buildItemModel$lambda-3  reason: not valid java name */
        public static final void m24buildItemModel$lambda3(ExploreV2Fragment exploreV2Fragment, j jVar, View view) {
            m0.n.b.i.e(exploreV2Fragment, "this$0");
            i0.e.a.b.a N0 = exploreV2Fragment.N0();
            SourceLocation sourceLocation = SourceLocation.SEARCH;
            i0.e.b.b3.b.e.m mVar = (i0.e.b.b3.b.e.m) jVar;
            N0.a(sourceLocation, mVar.k);
            UserInList userInList = mVar.g;
            Map<String, Object> map = mVar.k;
            m0.n.b.i.e(userInList, "<this>");
            m0.n.b.i.e(sourceLocation, Stripe3ds2AuthParams.FIELD_SOURCE);
            ProfileArgs profileArgs = new ProfileArgs(userInList.getId(), null, new BasicUser(userInList.getId().intValue(), userInList.getName(), userInList.C(), userInList.b()), false, null, sourceLocation, map, 26);
            m0.n.b.i.e(profileArgs, "mavericksArg");
            v.a1(exploreV2Fragment, new w(profileArgs, null), null, 2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: buildItemModel$lambda-4  reason: not valid java name */
        public static final void m25buildItemModel$lambda4(ExploreV2Fragment exploreV2Fragment, j jVar, View view) {
            m0.n.b.i.e(exploreV2Fragment, "this$0");
            k<Object>[] kVarArr = ExploreV2Fragment.Z1;
            exploreV2Fragment.P0().p(new i0((i0.e.b.b3.b.e.m) jVar));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: buildItemModel$lambda-6  reason: not valid java name */
        public static final void m26buildItemModel$lambda6(ExploreV2Fragment exploreV2Fragment, j jVar, View view) {
            m0.n.b.i.e(exploreV2Fragment, "this$0");
            i0.e.a.b.a N0 = exploreV2Fragment.N0();
            SourceLocation sourceLocation = SourceLocation.SEARCH;
            i0.e.b.b3.b.e.c cVar = (i0.e.b.b3.b.e.c) jVar;
            N0.a(sourceLocation, cVar.c);
            ChannelInFeed channelInFeed = cVar.b;
            ChannelNavigation.b(exploreV2Fragment, channelInFeed.a2, channelInFeed, sourceLocation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: buildItemModel$lambda-7  reason: not valid java name */
        public static final void m27buildItemModel$lambda7(ExploreV2Fragment exploreV2Fragment, j jVar, View view) {
            m0.n.b.i.e(exploreV2Fragment, "this$0");
            k<Object>[] kVarArr = ExploreV2Fragment.Z1;
            exploreV2Fragment.O0().g.setText(((l) jVar).b.a);
        }

        public i0.b.a.t<?> buildItemModel(int i, j jVar) {
            ArrayList arrayList;
            if (jVar == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            } else if (jVar instanceof h) {
                i0.e.b.g3.w.j0.l lVar = new i0.e.b.g3.w.j0.l();
                lVar.s(((h) jVar).b);
                i0.e.b.g3.w.j jVar2 = new i0.e.b.g3.w.j(this.this$0);
                lVar.w();
                lVar.j = jVar2;
                m0.n.b.i.d(lVar, "RecentSearchesHeader_()\n                        .id(item.title)\n                        .clearClickListener { _ ->\n                            viewModel.processIntent(ClearRecentSearches)\n                        }");
                return lVar;
            } else if (jVar instanceof e) {
                i0.e.b.f3.m.b.g gVar = new i0.e.b.f3.m.b.g();
                e eVar = (e) jVar;
                gVar.t(Integer.valueOf(eVar.b.x));
                a aVar = new a(2, this.this$0, jVar);
                gVar.w();
                gVar.i = aVar;
                ClubWithAdmin clubWithAdmin = eVar.b;
                gVar.w();
                gVar.j = clubWithAdmin;
                boolean z = eVar.b.q;
                gVar.w();
                gVar.k = z;
                i0.e.b.g3.w.k kVar = new i0.e.b.g3.w.k(this.this$0, jVar);
                gVar.w();
                gVar.l = kVar;
                n nVar = new n(this.this$0, jVar);
                gVar.w();
                gVar.m = nVar;
                m0.n.b.i.d(gVar, "@AndroidEntryPoint\nclass ExploreV2Fragment : BaseFragment(R.layout.fragment_explore_v2) {\n\n    @Inject\n    lateinit var actionTrailRecorder: ActionTrailRecorder\n\n    override val shouldShowKeyboard = true\n\n    private val binding: FragmentExploreV2Binding by viewBinding()\n    private val viewModel: ExploreV2ViewModel by fragmentViewModel()\n    private val searchController = PagingController()\n    private val recentSearchesController = PagingController()\n\n    private lateinit var topTab: TabLayout.Tab\n    private lateinit var peopleTab: TabLayout.Tab\n    private lateinit var clubTab: TabLayout.Tab\n    private lateinit var roomTab: TabLayout.Tab\n    private lateinit var eventTab: TabLayout.Tab\n\n    override fun onCreate(savedInstanceState: Bundle?) {\n        super.onCreate(savedInstanceState)\n        sharedElementEnterTransition = AutoTransition()\n    }\n\n    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {\n        super.onViewCreated(view, savedInstanceState)\n\n        // Disable animations, which are distracting as items change and move between results\n        binding.resultsList.itemAnimator = null\n        configurePagingControllers()\n\n        topTab = binding.resultTabs.newTab().setText(R.string.explore_tab_top).apply {\n            binding.resultTabs.addTab(this)\n        }\n        peopleTab = binding.resultTabs.newTab().setText(R.string.explore_tab_people).apply {\n            binding.resultTabs.addTab(this)\n        }\n        clubTab = binding.resultTabs.newTab().setText(R.string.explore_tab_clubs).apply {\n            binding.resultTabs.addTab(this)\n        }\n        roomTab = binding.resultTabs.newTab().setText(R.string.explore_tab_rooms).apply {\n            binding.resultTabs.addTab(this)\n        }\n        eventTab = binding.resultTabs.newTab().setText(R.string.explore_tab_events).apply {\n            binding.resultTabs.addTab(this)\n        }\n        binding.resultTabs.onTabSelected { tab ->\n            if (tab?.position == 0) {\n                viewModel.processIntent(SetMode(Mode.TOP))\n            } else if (tab?.position == 1) {\n                viewModel.processIntent(SetMode(Mode.PEOPLE))\n            } else if (tab?.position == 2) {\n                viewModel.processIntent(SetMode(Mode.CLUBS))\n            } else if (tab?.position == 3) {\n                viewModel.processIntent(SetMode(Mode.ROOMS))\n            } else if (tab?.position == 4) {\n                viewModel.processIntent(SetMode(Mode.EVENTS))\n            }\n        }\n\n        binding.search.debouncedTextChanges()\n            .onEach { viewModel.processIntent(UpdateQuery(it)) }\n            .launchIn(viewLifecycleOwner.lifecycleScope)\n        binding.cancel.setOnClickListener {\n            binding.search.text = null\n            hideSoftKeyBoard()\n            navigateUpSafe()\n        }\n\n        viewModel.onEach(ExploreV2ViewState::query) { query ->\n            if (query.isEmpty()) {\n                binding.resultsList.setController(recentSearchesController)\n            } else {\n                binding.resultsList.setController(searchController)\n            }\n        }\n\n        viewModel.onEach(ExploreV2ViewState::data) { data ->\n            data?.let {\n                viewLifecycleOwner.lifecycleScope.launch { searchController.submitData(it) }\n            }\n        }\n\n        viewModel.onEach(ExploreV2ViewState::recentSearches) { data ->\n            data?.let {\n                viewLifecycleOwner.lifecycleScope.launch {\n                    recentSearchesController.submitData(\n                        it.insertHeaderItem(item = HeaderItem(getString(R.string.recent)))\n                    )\n                }\n            }\n        }\n\n        viewModel.effectFlow.onEach {\n            when (it) {\n                is ShowClubRules -> showClubRules(it.club)\n                is ShowSuccess -> showBanner { message(it.message) }\n                is ShowError -> showNegativeBanner {\n                    message(it.message ?: getString(R.string.common_error_try_again))\n                }\n            }\n        }.launchIn(viewLifecycleOwner.lifecycleScope)\n    }\n\n    private fun configurePagingControllers() {\n        searchController.scrollToTopOnChange(binding.resultsList)\n        recentSearchesController.scrollToTopOnChange(binding.resultsList)\n\n        merge(\n            searchController.observeState(),\n            recentSearchesController.observeState()\n        ).onEach { state ->\n            withState(viewModel) {\n                binding.emptyIcon.showIf(state is PagingState.Empty && it.query.isEmpty())\n                binding.empty.showIf(state is PagingState.Empty)\n                binding.loading.showIf(state is PagingState.Loading)\n                binding.resultsList.hideIf(state is PagingState.Loading)\n            }\n        }.launchIn(viewLifecycleOwner.lifecycleScope)\n    }\n\n    override fun invalidate() {\n        withState(viewModel) { state ->\n            binding.resultTabs.hideIf(state.query.isEmpty())\n            binding.empty.setText(\n                if (state.query.isEmpty()) R.string.explore_v2_empty_state\n                else R.string.focused_search_empty\n            )\n\n            if (state.mode == Mode.TOP) {\n                binding.resultTabs.selectTab(topTab)\n            } else if (state.mode == Mode.PEOPLE) {\n                binding.resultTabs.selectTab(peopleTab)\n            } else if (state.mode == Mode.CLUBS) {\n                binding.resultTabs.selectTab(clubTab)\n            } else if (state.mode == Mode.ROOMS) {\n                binding.resultTabs.selectTab(roomTab)\n            } else if (state.mode == Mode.EVENTS) {\n                binding.resultTabs.selectTab(eventTab)\n            }\n        }\n    }\n\n    private fun showClubRules(item: ClubItem) {\n        navigateSafe(\n            ExploreV2FragmentDirections.actionExploreV2FragmentToClubRules(\n                HalfClubRulesArgs(\n                    item.club,\n                    true,\n                    sourceLocation = SourceLocation.SEARCH,\n                    loggingContext = item.loggingContext\n                )\n            )\n        )\n    }\n\n    inner class PagingController : PagingDataEpoxyController<PagingItem>() {\n        override fun buildItemModel(currentPosition: Int, item: PagingItem?): EpoxyModel<*> {\n            requireNotNull(item)\n            return when (item) {\n                is HeaderItem ->\n                    RecentSearchesHeader_()\n                        .id(item.title)\n                        .clearClickListener { _ ->\n                            viewModel.processIntent(ClearRecentSearches)\n                        }\n                is ClubItem ->\n                    ListClubWithMembership_()\n                        .id(item.club.id)\n                        .impressionLoggingAction {\n                            actionTrailRecorder.recommendationImpression(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                        }\n                        .club(item.club)\n                        .member(item.club.isMember)\n                        .clickListener { _ ->\n                            actionTrailRecorder.recommendationAccept(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                            navigateSafe(\n                                ExploreV2FragmentDirections.actionExploreV2FragmentToClubFragment(\n                                    ClubArgs(\n                                        item.club.id,\n                                        source = SourceLocation.SEARCH,\n                                        loggingContext = item.loggingContext\n                                    )\n                                )\n                            )\n                        }\n                        .joinClickListener { _ ->\n                            viewModel.processIntent(JoinClub(item))\n                        }\n                is UserItem ->\n                    FollowableListUser_()\n                        .id(item.user.id)\n                        .impressionLoggingAction {\n                            actionTrailRecorder.recommendationImpression(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                        }\n                        .user(item.user)\n                        .userBio(item.user.bio)\n                        .following(item.followedBySelf)\n                        .blocked(item.blockedBySelf)\n                        .self(item.isSelf)\n                        .showFollowButton(true)\n                        .clickListener { _ ->\n                            actionTrailRecorder.recommendationAccept(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                            navigateSafe(\n                                ExploreV2FragmentDirections.actionExploreV2FragmentToProfileFragment(\n                                    item.user.toProfileArgs(\n                                        SourceLocation.SEARCH,\n                                        item.loggingContext\n                                    )\n                                )\n                            )\n                        }\n                        .followClickListener { _ ->\n                            viewModel.processIntent(ToggleFollowUserItem(item))\n                        }\n                is ChannelItem -> {\n                    val speakers = item.channel.users?.filter { it.isSpeaker }\n                    ChannelInExplore_()\n                        .id(item.channel.id)\n                        .impressionLoggingAction {\n                            actionTrailRecorder.recommendationImpression(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                        }\n                        .clubName(item.channel.club?.name)\n                        .topic(item.channel.topic)\n                        .statsSpeakers(item.channel.numSpeakers.toString())\n                        .statsAll(item.channel.numAll.toString())\n                        .moderator1(speakers.getOrNull(0))\n                        .moderator2(speakers.getOrNull(1))\n                        .audienceType(item.channel.audienceType())\n                        .clickListener { _ ->\n                            actionTrailRecorder.recommendationAccept(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                            navigateToChannel(\n                                item.channel.channel,\n                                item.channel,\n                                SourceLocation.SEARCH\n                            )\n                        }\n                }\n                is EventItem ->\n                    EventInExplore_()\n                        .id(item.event.id)\n                        .impressionLoggingAction {\n                            actionTrailRecorder.recommendationImpression(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                        }\n                        .event(item.event)\n                        .rsvpClickListener { _, isAttending ->\n                            viewModel.processIntent(RSVPEvent(item, isAttending))\n                        }\n                        .eventClickListener { event ->\n                            actionTrailRecorder.recommendationAccept(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                            navigateSafe(\n                                ExploreV2FragmentDirections\n                                    .actionExploreV2FragmentToHalfEventDialog(\n                                        HalfEventArgs(\n                                            event = event,\n                                            loggingContext = item.loggingContext,\n                                            source = SourceLocation.SEARCH\n                                        )\n                                    )\n                            )\n                        }\n                is SearchQueryItem ->\n                    SearchQueryView_()\n                        .id(item.searchQuery.query)\n                        .impressionLoggingAction {\n                            actionTrailRecorder.recommendationImpression(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                        }\n                        .query(item.searchQuery.query)\n                        .clickListener { _ ->\n                            binding.search.setText(item.searchQuery.query)\n                        }\n                else -> throw Throwable(\"Invalid item type\")\n            }\n        }\n    }\n}");
                return gVar;
            } else if (jVar instanceof i0.e.b.b3.b.e.m) {
                i0.e.b.f3.m.b.c cVar = new i0.e.b.f3.m.b.c();
                i0.e.b.b3.b.e.m mVar = (i0.e.b.b3.b.e.m) jVar;
                cVar.t(mVar.g.getId());
                a aVar2 = new a(3, this.this$0, jVar);
                cVar.w();
                cVar.i = aVar2;
                UserInList userInList = mVar.g;
                cVar.w();
                cVar.j = userInList;
                String str = mVar.g.c;
                cVar.w();
                cVar.k = str;
                boolean z2 = mVar.i;
                cVar.w();
                cVar.n = z2;
                boolean z3 = mVar.j;
                cVar.w();
                cVar.p = z3;
                boolean z4 = mVar.h;
                cVar.w();
                cVar.q = z4;
                cVar.w();
                cVar.m = true;
                i0.e.b.g3.w.i iVar = new i0.e.b.g3.w.i(this.this$0, jVar);
                cVar.w();
                cVar.l = iVar;
                i0.e.b.g3.w.m mVar2 = new i0.e.b.g3.w.m(this.this$0, jVar);
                cVar.w();
                cVar.o = mVar2;
                m0.n.b.i.d(cVar, "@AndroidEntryPoint\nclass ExploreV2Fragment : BaseFragment(R.layout.fragment_explore_v2) {\n\n    @Inject\n    lateinit var actionTrailRecorder: ActionTrailRecorder\n\n    override val shouldShowKeyboard = true\n\n    private val binding: FragmentExploreV2Binding by viewBinding()\n    private val viewModel: ExploreV2ViewModel by fragmentViewModel()\n    private val searchController = PagingController()\n    private val recentSearchesController = PagingController()\n\n    private lateinit var topTab: TabLayout.Tab\n    private lateinit var peopleTab: TabLayout.Tab\n    private lateinit var clubTab: TabLayout.Tab\n    private lateinit var roomTab: TabLayout.Tab\n    private lateinit var eventTab: TabLayout.Tab\n\n    override fun onCreate(savedInstanceState: Bundle?) {\n        super.onCreate(savedInstanceState)\n        sharedElementEnterTransition = AutoTransition()\n    }\n\n    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {\n        super.onViewCreated(view, savedInstanceState)\n\n        // Disable animations, which are distracting as items change and move between results\n        binding.resultsList.itemAnimator = null\n        configurePagingControllers()\n\n        topTab = binding.resultTabs.newTab().setText(R.string.explore_tab_top).apply {\n            binding.resultTabs.addTab(this)\n        }\n        peopleTab = binding.resultTabs.newTab().setText(R.string.explore_tab_people).apply {\n            binding.resultTabs.addTab(this)\n        }\n        clubTab = binding.resultTabs.newTab().setText(R.string.explore_tab_clubs).apply {\n            binding.resultTabs.addTab(this)\n        }\n        roomTab = binding.resultTabs.newTab().setText(R.string.explore_tab_rooms).apply {\n            binding.resultTabs.addTab(this)\n        }\n        eventTab = binding.resultTabs.newTab().setText(R.string.explore_tab_events).apply {\n            binding.resultTabs.addTab(this)\n        }\n        binding.resultTabs.onTabSelected { tab ->\n            if (tab?.position == 0) {\n                viewModel.processIntent(SetMode(Mode.TOP))\n            } else if (tab?.position == 1) {\n                viewModel.processIntent(SetMode(Mode.PEOPLE))\n            } else if (tab?.position == 2) {\n                viewModel.processIntent(SetMode(Mode.CLUBS))\n            } else if (tab?.position == 3) {\n                viewModel.processIntent(SetMode(Mode.ROOMS))\n            } else if (tab?.position == 4) {\n                viewModel.processIntent(SetMode(Mode.EVENTS))\n            }\n        }\n\n        binding.search.debouncedTextChanges()\n            .onEach { viewModel.processIntent(UpdateQuery(it)) }\n            .launchIn(viewLifecycleOwner.lifecycleScope)\n        binding.cancel.setOnClickListener {\n            binding.search.text = null\n            hideSoftKeyBoard()\n            navigateUpSafe()\n        }\n\n        viewModel.onEach(ExploreV2ViewState::query) { query ->\n            if (query.isEmpty()) {\n                binding.resultsList.setController(recentSearchesController)\n            } else {\n                binding.resultsList.setController(searchController)\n            }\n        }\n\n        viewModel.onEach(ExploreV2ViewState::data) { data ->\n            data?.let {\n                viewLifecycleOwner.lifecycleScope.launch { searchController.submitData(it) }\n            }\n        }\n\n        viewModel.onEach(ExploreV2ViewState::recentSearches) { data ->\n            data?.let {\n                viewLifecycleOwner.lifecycleScope.launch {\n                    recentSearchesController.submitData(\n                        it.insertHeaderItem(item = HeaderItem(getString(R.string.recent)))\n                    )\n                }\n            }\n        }\n\n        viewModel.effectFlow.onEach {\n            when (it) {\n                is ShowClubRules -> showClubRules(it.club)\n                is ShowSuccess -> showBanner { message(it.message) }\n                is ShowError -> showNegativeBanner {\n                    message(it.message ?: getString(R.string.common_error_try_again))\n                }\n            }\n        }.launchIn(viewLifecycleOwner.lifecycleScope)\n    }\n\n    private fun configurePagingControllers() {\n        searchController.scrollToTopOnChange(binding.resultsList)\n        recentSearchesController.scrollToTopOnChange(binding.resultsList)\n\n        merge(\n            searchController.observeState(),\n            recentSearchesController.observeState()\n        ).onEach { state ->\n            withState(viewModel) {\n                binding.emptyIcon.showIf(state is PagingState.Empty && it.query.isEmpty())\n                binding.empty.showIf(state is PagingState.Empty)\n                binding.loading.showIf(state is PagingState.Loading)\n                binding.resultsList.hideIf(state is PagingState.Loading)\n            }\n        }.launchIn(viewLifecycleOwner.lifecycleScope)\n    }\n\n    override fun invalidate() {\n        withState(viewModel) { state ->\n            binding.resultTabs.hideIf(state.query.isEmpty())\n            binding.empty.setText(\n                if (state.query.isEmpty()) R.string.explore_v2_empty_state\n                else R.string.focused_search_empty\n            )\n\n            if (state.mode == Mode.TOP) {\n                binding.resultTabs.selectTab(topTab)\n            } else if (state.mode == Mode.PEOPLE) {\n                binding.resultTabs.selectTab(peopleTab)\n            } else if (state.mode == Mode.CLUBS) {\n                binding.resultTabs.selectTab(clubTab)\n            } else if (state.mode == Mode.ROOMS) {\n                binding.resultTabs.selectTab(roomTab)\n            } else if (state.mode == Mode.EVENTS) {\n                binding.resultTabs.selectTab(eventTab)\n            }\n        }\n    }\n\n    private fun showClubRules(item: ClubItem) {\n        navigateSafe(\n            ExploreV2FragmentDirections.actionExploreV2FragmentToClubRules(\n                HalfClubRulesArgs(\n                    item.club,\n                    true,\n                    sourceLocation = SourceLocation.SEARCH,\n                    loggingContext = item.loggingContext\n                )\n            )\n        )\n    }\n\n    inner class PagingController : PagingDataEpoxyController<PagingItem>() {\n        override fun buildItemModel(currentPosition: Int, item: PagingItem?): EpoxyModel<*> {\n            requireNotNull(item)\n            return when (item) {\n                is HeaderItem ->\n                    RecentSearchesHeader_()\n                        .id(item.title)\n                        .clearClickListener { _ ->\n                            viewModel.processIntent(ClearRecentSearches)\n                        }\n                is ClubItem ->\n                    ListClubWithMembership_()\n                        .id(item.club.id)\n                        .impressionLoggingAction {\n                            actionTrailRecorder.recommendationImpression(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                        }\n                        .club(item.club)\n                        .member(item.club.isMember)\n                        .clickListener { _ ->\n                            actionTrailRecorder.recommendationAccept(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                            navigateSafe(\n                                ExploreV2FragmentDirections.actionExploreV2FragmentToClubFragment(\n                                    ClubArgs(\n                                        item.club.id,\n                                        source = SourceLocation.SEARCH,\n                                        loggingContext = item.loggingContext\n                                    )\n                                )\n                            )\n                        }\n                        .joinClickListener { _ ->\n                            viewModel.processIntent(JoinClub(item))\n                        }\n                is UserItem ->\n                    FollowableListUser_()\n                        .id(item.user.id)\n                        .impressionLoggingAction {\n                            actionTrailRecorder.recommendationImpression(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                        }\n                        .user(item.user)\n                        .userBio(item.user.bio)\n                        .following(item.followedBySelf)\n                        .blocked(item.blockedBySelf)\n                        .self(item.isSelf)\n                        .showFollowButton(true)\n                        .clickListener { _ ->\n                            actionTrailRecorder.recommendationAccept(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                            navigateSafe(\n                                ExploreV2FragmentDirections.actionExploreV2FragmentToProfileFragment(\n                                    item.user.toProfileArgs(\n                                        SourceLocation.SEARCH,\n                                        item.loggingContext\n                                    )\n                                )\n                            )\n                        }\n                        .followClickListener { _ ->\n                            viewModel.processIntent(ToggleFollowUserItem(item))\n                        }\n                is ChannelItem -> {\n                    val speakers = item.channel.users?.filter { it.isSpeaker }\n                    ChannelInExplore_()\n                        .id(item.channel.id)\n                        .impressionLoggingAction {\n                            actionTrailRecorder.recommendationImpression(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                        }\n                        .clubName(item.channel.club?.name)\n                        .topic(item.channel.topic)\n                        .statsSpeakers(item.channel.numSpeakers.toString())\n                        .statsAll(item.channel.numAll.toString())\n                        .moderator1(speakers.getOrNull(0))\n                        .moderator2(speakers.getOrNull(1))\n                        .audienceType(item.channel.audienceType())\n                        .clickListener { _ ->\n                            actionTrailRecorder.recommendationAccept(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                            navigateToChannel(\n                                item.channel.channel,\n                                item.channel,\n                                SourceLocation.SEARCH\n                            )\n                        }\n                }\n                is EventItem ->\n                    EventInExplore_()\n                        .id(item.event.id)\n                        .impressionLoggingAction {\n                            actionTrailRecorder.recommendationImpression(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                        }\n                        .event(item.event)\n                        .rsvpClickListener { _, isAttending ->\n                            viewModel.processIntent(RSVPEvent(item, isAttending))\n                        }\n                        .eventClickListener { event ->\n                            actionTrailRecorder.recommendationAccept(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                            navigateSafe(\n                                ExploreV2FragmentDirections\n                                    .actionExploreV2FragmentToHalfEventDialog(\n                                        HalfEventArgs(\n                                            event = event,\n                                            loggingContext = item.loggingContext,\n                                            source = SourceLocation.SEARCH\n                                        )\n                                    )\n                            )\n                        }\n                is SearchQueryItem ->\n                    SearchQueryView_()\n                        .id(item.searchQuery.query)\n                        .impressionLoggingAction {\n                            actionTrailRecorder.recommendationImpression(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                        }\n                        .query(item.searchQuery.query)\n                        .clickListener { _ ->\n                            binding.search.setText(item.searchQuery.query)\n                        }\n                else -> throw Throwable(\"Invalid item type\")\n            }\n        }\n    }\n}");
                return cVar;
            } else if (jVar instanceof i0.e.b.b3.b.e.c) {
                i0.e.b.b3.b.e.c cVar2 = (i0.e.b.b3.b.e.c) jVar;
                List<UserInFeed> list = cVar2.b.c;
                String str2 = null;
                if (list == null) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList();
                    for (Object obj : list) {
                        if (((UserInFeed) obj).c) {
                            arrayList.add(obj);
                        }
                    }
                }
                f fVar = new f();
                fVar.t(Integer.valueOf(cVar2.b.i2));
                a aVar3 = new a(4, this.this$0, jVar);
                fVar.w();
                fVar.i = aVar3;
                ClubWithAdmin clubWithAdmin2 = cVar2.b.g2;
                if (clubWithAdmin2 != null) {
                    str2 = clubWithAdmin2.y;
                }
                fVar.w();
                fVar.j = str2;
                String str3 = cVar2.b.b2;
                fVar.w();
                fVar.k = str3;
                String valueOf = String.valueOf(cVar2.b.d);
                fVar.w();
                fVar.l = valueOf;
                String valueOf2 = String.valueOf(cVar2.b.q);
                fVar.w();
                fVar.m = valueOf2;
                fVar.w();
                fVar.n = (UserInRoom) m0.j.g.z(arrayList, 0);
                fVar.w();
                fVar.o = (UserInRoom) m0.j.g.z(arrayList, 1);
                AudienceType o = v.o(cVar2.b);
                fVar.w();
                fVar.p = o;
                i0.e.b.g3.w.h hVar = new i0.e.b.g3.w.h(this.this$0, jVar);
                fVar.w();
                fVar.q = hVar;
                m0.n.b.i.d(fVar, "@AndroidEntryPoint\nclass ExploreV2Fragment : BaseFragment(R.layout.fragment_explore_v2) {\n\n    @Inject\n    lateinit var actionTrailRecorder: ActionTrailRecorder\n\n    override val shouldShowKeyboard = true\n\n    private val binding: FragmentExploreV2Binding by viewBinding()\n    private val viewModel: ExploreV2ViewModel by fragmentViewModel()\n    private val searchController = PagingController()\n    private val recentSearchesController = PagingController()\n\n    private lateinit var topTab: TabLayout.Tab\n    private lateinit var peopleTab: TabLayout.Tab\n    private lateinit var clubTab: TabLayout.Tab\n    private lateinit var roomTab: TabLayout.Tab\n    private lateinit var eventTab: TabLayout.Tab\n\n    override fun onCreate(savedInstanceState: Bundle?) {\n        super.onCreate(savedInstanceState)\n        sharedElementEnterTransition = AutoTransition()\n    }\n\n    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {\n        super.onViewCreated(view, savedInstanceState)\n\n        // Disable animations, which are distracting as items change and move between results\n        binding.resultsList.itemAnimator = null\n        configurePagingControllers()\n\n        topTab = binding.resultTabs.newTab().setText(R.string.explore_tab_top).apply {\n            binding.resultTabs.addTab(this)\n        }\n        peopleTab = binding.resultTabs.newTab().setText(R.string.explore_tab_people).apply {\n            binding.resultTabs.addTab(this)\n        }\n        clubTab = binding.resultTabs.newTab().setText(R.string.explore_tab_clubs).apply {\n            binding.resultTabs.addTab(this)\n        }\n        roomTab = binding.resultTabs.newTab().setText(R.string.explore_tab_rooms).apply {\n            binding.resultTabs.addTab(this)\n        }\n        eventTab = binding.resultTabs.newTab().setText(R.string.explore_tab_events).apply {\n            binding.resultTabs.addTab(this)\n        }\n        binding.resultTabs.onTabSelected { tab ->\n            if (tab?.position == 0) {\n                viewModel.processIntent(SetMode(Mode.TOP))\n            } else if (tab?.position == 1) {\n                viewModel.processIntent(SetMode(Mode.PEOPLE))\n            } else if (tab?.position == 2) {\n                viewModel.processIntent(SetMode(Mode.CLUBS))\n            } else if (tab?.position == 3) {\n                viewModel.processIntent(SetMode(Mode.ROOMS))\n            } else if (tab?.position == 4) {\n                viewModel.processIntent(SetMode(Mode.EVENTS))\n            }\n        }\n\n        binding.search.debouncedTextChanges()\n            .onEach { viewModel.processIntent(UpdateQuery(it)) }\n            .launchIn(viewLifecycleOwner.lifecycleScope)\n        binding.cancel.setOnClickListener {\n            binding.search.text = null\n            hideSoftKeyBoard()\n            navigateUpSafe()\n        }\n\n        viewModel.onEach(ExploreV2ViewState::query) { query ->\n            if (query.isEmpty()) {\n                binding.resultsList.setController(recentSearchesController)\n            } else {\n                binding.resultsList.setController(searchController)\n            }\n        }\n\n        viewModel.onEach(ExploreV2ViewState::data) { data ->\n            data?.let {\n                viewLifecycleOwner.lifecycleScope.launch { searchController.submitData(it) }\n            }\n        }\n\n        viewModel.onEach(ExploreV2ViewState::recentSearches) { data ->\n            data?.let {\n                viewLifecycleOwner.lifecycleScope.launch {\n                    recentSearchesController.submitData(\n                        it.insertHeaderItem(item = HeaderItem(getString(R.string.recent)))\n                    )\n                }\n            }\n        }\n\n        viewModel.effectFlow.onEach {\n            when (it) {\n                is ShowClubRules -> showClubRules(it.club)\n                is ShowSuccess -> showBanner { message(it.message) }\n                is ShowError -> showNegativeBanner {\n                    message(it.message ?: getString(R.string.common_error_try_again))\n                }\n            }\n        }.launchIn(viewLifecycleOwner.lifecycleScope)\n    }\n\n    private fun configurePagingControllers() {\n        searchController.scrollToTopOnChange(binding.resultsList)\n        recentSearchesController.scrollToTopOnChange(binding.resultsList)\n\n        merge(\n            searchController.observeState(),\n            recentSearchesController.observeState()\n        ).onEach { state ->\n            withState(viewModel) {\n                binding.emptyIcon.showIf(state is PagingState.Empty && it.query.isEmpty())\n                binding.empty.showIf(state is PagingState.Empty)\n                binding.loading.showIf(state is PagingState.Loading)\n                binding.resultsList.hideIf(state is PagingState.Loading)\n            }\n        }.launchIn(viewLifecycleOwner.lifecycleScope)\n    }\n\n    override fun invalidate() {\n        withState(viewModel) { state ->\n            binding.resultTabs.hideIf(state.query.isEmpty())\n            binding.empty.setText(\n                if (state.query.isEmpty()) R.string.explore_v2_empty_state\n                else R.string.focused_search_empty\n            )\n\n            if (state.mode == Mode.TOP) {\n                binding.resultTabs.selectTab(topTab)\n            } else if (state.mode == Mode.PEOPLE) {\n                binding.resultTabs.selectTab(peopleTab)\n            } else if (state.mode == Mode.CLUBS) {\n                binding.resultTabs.selectTab(clubTab)\n            } else if (state.mode == Mode.ROOMS) {\n                binding.resultTabs.selectTab(roomTab)\n            } else if (state.mode == Mode.EVENTS) {\n                binding.resultTabs.selectTab(eventTab)\n            }\n        }\n    }\n\n    private fun showClubRules(item: ClubItem) {\n        navigateSafe(\n            ExploreV2FragmentDirections.actionExploreV2FragmentToClubRules(\n                HalfClubRulesArgs(\n                    item.club,\n                    true,\n                    sourceLocation = SourceLocation.SEARCH,\n                    loggingContext = item.loggingContext\n                )\n            )\n        )\n    }\n\n    inner class PagingController : PagingDataEpoxyController<PagingItem>() {\n        override fun buildItemModel(currentPosition: Int, item: PagingItem?): EpoxyModel<*> {\n            requireNotNull(item)\n            return when (item) {\n                is HeaderItem ->\n                    RecentSearchesHeader_()\n                        .id(item.title)\n                        .clearClickListener { _ ->\n                            viewModel.processIntent(ClearRecentSearches)\n                        }\n                is ClubItem ->\n                    ListClubWithMembership_()\n                        .id(item.club.id)\n                        .impressionLoggingAction {\n                            actionTrailRecorder.recommendationImpression(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                        }\n                        .club(item.club)\n                        .member(item.club.isMember)\n                        .clickListener { _ ->\n                            actionTrailRecorder.recommendationAccept(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                            navigateSafe(\n                                ExploreV2FragmentDirections.actionExploreV2FragmentToClubFragment(\n                                    ClubArgs(\n                                        item.club.id,\n                                        source = SourceLocation.SEARCH,\n                                        loggingContext = item.loggingContext\n                                    )\n                                )\n                            )\n                        }\n                        .joinClickListener { _ ->\n                            viewModel.processIntent(JoinClub(item))\n                        }\n                is UserItem ->\n                    FollowableListUser_()\n                        .id(item.user.id)\n                        .impressionLoggingAction {\n                            actionTrailRecorder.recommendationImpression(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                        }\n                        .user(item.user)\n                        .userBio(item.user.bio)\n                        .following(item.followedBySelf)\n                        .blocked(item.blockedBySelf)\n                        .self(item.isSelf)\n                        .showFollowButton(true)\n                        .clickListener { _ ->\n                            actionTrailRecorder.recommendationAccept(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                            navigateSafe(\n                                ExploreV2FragmentDirections.actionExploreV2FragmentToProfileFragment(\n                                    item.user.toProfileArgs(\n                                        SourceLocation.SEARCH,\n                                        item.loggingContext\n                                    )\n                                )\n                            )\n                        }\n                        .followClickListener { _ ->\n                            viewModel.processIntent(ToggleFollowUserItem(item))\n                        }\n                is ChannelItem -> {\n                    val speakers = item.channel.users?.filter { it.isSpeaker }\n                    ChannelInExplore_()\n                        .id(item.channel.id)\n                        .impressionLoggingAction {\n                            actionTrailRecorder.recommendationImpression(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                        }\n                        .clubName(item.channel.club?.name)\n                        .topic(item.channel.topic)\n                        .statsSpeakers(item.channel.numSpeakers.toString())\n                        .statsAll(item.channel.numAll.toString())\n                        .moderator1(speakers.getOrNull(0))\n                        .moderator2(speakers.getOrNull(1))\n                        .audienceType(item.channel.audienceType())\n                        .clickListener { _ ->\n                            actionTrailRecorder.recommendationAccept(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                            navigateToChannel(\n                                item.channel.channel,\n                                item.channel,\n                                SourceLocation.SEARCH\n                            )\n                        }\n                }\n                is EventItem ->\n                    EventInExplore_()\n                        .id(item.event.id)\n                        .impressionLoggingAction {\n                            actionTrailRecorder.recommendationImpression(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                        }\n                        .event(item.event)\n                        .rsvpClickListener { _, isAttending ->\n                            viewModel.processIntent(RSVPEvent(item, isAttending))\n                        }\n                        .eventClickListener { event ->\n                            actionTrailRecorder.recommendationAccept(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                            navigateSafe(\n                                ExploreV2FragmentDirections\n                                    .actionExploreV2FragmentToHalfEventDialog(\n                                        HalfEventArgs(\n                                            event = event,\n                                            loggingContext = item.loggingContext,\n                                            source = SourceLocation.SEARCH\n                                        )\n                                    )\n                            )\n                        }\n                is SearchQueryItem ->\n                    SearchQueryView_()\n                        .id(item.searchQuery.query)\n                        .impressionLoggingAction {\n                            actionTrailRecorder.recommendationImpression(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                        }\n                        .query(item.searchQuery.query)\n                        .clickListener { _ ->\n                            binding.search.setText(item.searchQuery.query)\n                        }\n                else -> throw Throwable(\"Invalid item type\")\n            }\n        }\n    }\n}");
                return fVar;
            } else if (jVar instanceof g) {
                i0.e.b.g3.w.j0.h hVar2 = new i0.e.b.g3.w.j0.h();
                g gVar2 = (g) jVar;
                hVar2.t(Integer.valueOf(gVar2.d.Y1));
                a aVar4 = new a(0, this.this$0, jVar);
                hVar2.w();
                hVar2.i = aVar4;
                EventInClub eventInClub = gVar2.d;
                hVar2.w();
                hVar2.j = eventInClub;
                ExploreV2Fragment$PagingController$buildItemModel$11 exploreV2Fragment$PagingController$buildItemModel$11 = new ExploreV2Fragment$PagingController$buildItemModel$11(this.this$0, jVar);
                hVar2.w();
                hVar2.k = exploreV2Fragment$PagingController$buildItemModel$11;
                ExploreV2Fragment$PagingController$buildItemModel$12 exploreV2Fragment$PagingController$buildItemModel$12 = new ExploreV2Fragment$PagingController$buildItemModel$12(this.this$0, jVar);
                hVar2.w();
                hVar2.l = exploreV2Fragment$PagingController$buildItemModel$12;
                m0.n.b.i.d(hVar2, "@AndroidEntryPoint\nclass ExploreV2Fragment : BaseFragment(R.layout.fragment_explore_v2) {\n\n    @Inject\n    lateinit var actionTrailRecorder: ActionTrailRecorder\n\n    override val shouldShowKeyboard = true\n\n    private val binding: FragmentExploreV2Binding by viewBinding()\n    private val viewModel: ExploreV2ViewModel by fragmentViewModel()\n    private val searchController = PagingController()\n    private val recentSearchesController = PagingController()\n\n    private lateinit var topTab: TabLayout.Tab\n    private lateinit var peopleTab: TabLayout.Tab\n    private lateinit var clubTab: TabLayout.Tab\n    private lateinit var roomTab: TabLayout.Tab\n    private lateinit var eventTab: TabLayout.Tab\n\n    override fun onCreate(savedInstanceState: Bundle?) {\n        super.onCreate(savedInstanceState)\n        sharedElementEnterTransition = AutoTransition()\n    }\n\n    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {\n        super.onViewCreated(view, savedInstanceState)\n\n        // Disable animations, which are distracting as items change and move between results\n        binding.resultsList.itemAnimator = null\n        configurePagingControllers()\n\n        topTab = binding.resultTabs.newTab().setText(R.string.explore_tab_top).apply {\n            binding.resultTabs.addTab(this)\n        }\n        peopleTab = binding.resultTabs.newTab().setText(R.string.explore_tab_people).apply {\n            binding.resultTabs.addTab(this)\n        }\n        clubTab = binding.resultTabs.newTab().setText(R.string.explore_tab_clubs).apply {\n            binding.resultTabs.addTab(this)\n        }\n        roomTab = binding.resultTabs.newTab().setText(R.string.explore_tab_rooms).apply {\n            binding.resultTabs.addTab(this)\n        }\n        eventTab = binding.resultTabs.newTab().setText(R.string.explore_tab_events).apply {\n            binding.resultTabs.addTab(this)\n        }\n        binding.resultTabs.onTabSelected { tab ->\n            if (tab?.position == 0) {\n                viewModel.processIntent(SetMode(Mode.TOP))\n            } else if (tab?.position == 1) {\n                viewModel.processIntent(SetMode(Mode.PEOPLE))\n            } else if (tab?.position == 2) {\n                viewModel.processIntent(SetMode(Mode.CLUBS))\n            } else if (tab?.position == 3) {\n                viewModel.processIntent(SetMode(Mode.ROOMS))\n            } else if (tab?.position == 4) {\n                viewModel.processIntent(SetMode(Mode.EVENTS))\n            }\n        }\n\n        binding.search.debouncedTextChanges()\n            .onEach { viewModel.processIntent(UpdateQuery(it)) }\n            .launchIn(viewLifecycleOwner.lifecycleScope)\n        binding.cancel.setOnClickListener {\n            binding.search.text = null\n            hideSoftKeyBoard()\n            navigateUpSafe()\n        }\n\n        viewModel.onEach(ExploreV2ViewState::query) { query ->\n            if (query.isEmpty()) {\n                binding.resultsList.setController(recentSearchesController)\n            } else {\n                binding.resultsList.setController(searchController)\n            }\n        }\n\n        viewModel.onEach(ExploreV2ViewState::data) { data ->\n            data?.let {\n                viewLifecycleOwner.lifecycleScope.launch { searchController.submitData(it) }\n            }\n        }\n\n        viewModel.onEach(ExploreV2ViewState::recentSearches) { data ->\n            data?.let {\n                viewLifecycleOwner.lifecycleScope.launch {\n                    recentSearchesController.submitData(\n                        it.insertHeaderItem(item = HeaderItem(getString(R.string.recent)))\n                    )\n                }\n            }\n        }\n\n        viewModel.effectFlow.onEach {\n            when (it) {\n                is ShowClubRules -> showClubRules(it.club)\n                is ShowSuccess -> showBanner { message(it.message) }\n                is ShowError -> showNegativeBanner {\n                    message(it.message ?: getString(R.string.common_error_try_again))\n                }\n            }\n        }.launchIn(viewLifecycleOwner.lifecycleScope)\n    }\n\n    private fun configurePagingControllers() {\n        searchController.scrollToTopOnChange(binding.resultsList)\n        recentSearchesController.scrollToTopOnChange(binding.resultsList)\n\n        merge(\n            searchController.observeState(),\n            recentSearchesController.observeState()\n        ).onEach { state ->\n            withState(viewModel) {\n                binding.emptyIcon.showIf(state is PagingState.Empty && it.query.isEmpty())\n                binding.empty.showIf(state is PagingState.Empty)\n                binding.loading.showIf(state is PagingState.Loading)\n                binding.resultsList.hideIf(state is PagingState.Loading)\n            }\n        }.launchIn(viewLifecycleOwner.lifecycleScope)\n    }\n\n    override fun invalidate() {\n        withState(viewModel) { state ->\n            binding.resultTabs.hideIf(state.query.isEmpty())\n            binding.empty.setText(\n                if (state.query.isEmpty()) R.string.explore_v2_empty_state\n                else R.string.focused_search_empty\n            )\n\n            if (state.mode == Mode.TOP) {\n                binding.resultTabs.selectTab(topTab)\n            } else if (state.mode == Mode.PEOPLE) {\n                binding.resultTabs.selectTab(peopleTab)\n            } else if (state.mode == Mode.CLUBS) {\n                binding.resultTabs.selectTab(clubTab)\n            } else if (state.mode == Mode.ROOMS) {\n                binding.resultTabs.selectTab(roomTab)\n            } else if (state.mode == Mode.EVENTS) {\n                binding.resultTabs.selectTab(eventTab)\n            }\n        }\n    }\n\n    private fun showClubRules(item: ClubItem) {\n        navigateSafe(\n            ExploreV2FragmentDirections.actionExploreV2FragmentToClubRules(\n                HalfClubRulesArgs(\n                    item.club,\n                    true,\n                    sourceLocation = SourceLocation.SEARCH,\n                    loggingContext = item.loggingContext\n                )\n            )\n        )\n    }\n\n    inner class PagingController : PagingDataEpoxyController<PagingItem>() {\n        override fun buildItemModel(currentPosition: Int, item: PagingItem?): EpoxyModel<*> {\n            requireNotNull(item)\n            return when (item) {\n                is HeaderItem ->\n                    RecentSearchesHeader_()\n                        .id(item.title)\n                        .clearClickListener { _ ->\n                            viewModel.processIntent(ClearRecentSearches)\n                        }\n                is ClubItem ->\n                    ListClubWithMembership_()\n                        .id(item.club.id)\n                        .impressionLoggingAction {\n                            actionTrailRecorder.recommendationImpression(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                        }\n                        .club(item.club)\n                        .member(item.club.isMember)\n                        .clickListener { _ ->\n                            actionTrailRecorder.recommendationAccept(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                            navigateSafe(\n                                ExploreV2FragmentDirections.actionExploreV2FragmentToClubFragment(\n                                    ClubArgs(\n                                        item.club.id,\n                                        source = SourceLocation.SEARCH,\n                                        loggingContext = item.loggingContext\n                                    )\n                                )\n                            )\n                        }\n                        .joinClickListener { _ ->\n                            viewModel.processIntent(JoinClub(item))\n                        }\n                is UserItem ->\n                    FollowableListUser_()\n                        .id(item.user.id)\n                        .impressionLoggingAction {\n                            actionTrailRecorder.recommendationImpression(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                        }\n                        .user(item.user)\n                        .userBio(item.user.bio)\n                        .following(item.followedBySelf)\n                        .blocked(item.blockedBySelf)\n                        .self(item.isSelf)\n                        .showFollowButton(true)\n                        .clickListener { _ ->\n                            actionTrailRecorder.recommendationAccept(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                            navigateSafe(\n                                ExploreV2FragmentDirections.actionExploreV2FragmentToProfileFragment(\n                                    item.user.toProfileArgs(\n                                        SourceLocation.SEARCH,\n                                        item.loggingContext\n                                    )\n                                )\n                            )\n                        }\n                        .followClickListener { _ ->\n                            viewModel.processIntent(ToggleFollowUserItem(item))\n                        }\n                is ChannelItem -> {\n                    val speakers = item.channel.users?.filter { it.isSpeaker }\n                    ChannelInExplore_()\n                        .id(item.channel.id)\n                        .impressionLoggingAction {\n                            actionTrailRecorder.recommendationImpression(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                        }\n                        .clubName(item.channel.club?.name)\n                        .topic(item.channel.topic)\n                        .statsSpeakers(item.channel.numSpeakers.toString())\n                        .statsAll(item.channel.numAll.toString())\n                        .moderator1(speakers.getOrNull(0))\n                        .moderator2(speakers.getOrNull(1))\n                        .audienceType(item.channel.audienceType())\n                        .clickListener { _ ->\n                            actionTrailRecorder.recommendationAccept(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                            navigateToChannel(\n                                item.channel.channel,\n                                item.channel,\n                                SourceLocation.SEARCH\n                            )\n                        }\n                }\n                is EventItem ->\n                    EventInExplore_()\n                        .id(item.event.id)\n                        .impressionLoggingAction {\n                            actionTrailRecorder.recommendationImpression(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                        }\n                        .event(item.event)\n                        .rsvpClickListener { _, isAttending ->\n                            viewModel.processIntent(RSVPEvent(item, isAttending))\n                        }\n                        .eventClickListener { event ->\n                            actionTrailRecorder.recommendationAccept(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                            navigateSafe(\n                                ExploreV2FragmentDirections\n                                    .actionExploreV2FragmentToHalfEventDialog(\n                                        HalfEventArgs(\n                                            event = event,\n                                            loggingContext = item.loggingContext,\n                                            source = SourceLocation.SEARCH\n                                        )\n                                    )\n                            )\n                        }\n                is SearchQueryItem ->\n                    SearchQueryView_()\n                        .id(item.searchQuery.query)\n                        .impressionLoggingAction {\n                            actionTrailRecorder.recommendationImpression(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                        }\n                        .query(item.searchQuery.query)\n                        .clickListener { _ ->\n                            binding.search.setText(item.searchQuery.query)\n                        }\n                else -> throw Throwable(\"Invalid item type\")\n            }\n        }\n    }\n}");
                return hVar2;
            } else if (jVar instanceof l) {
                i0.e.b.g3.w.j0.n nVar2 = new i0.e.b.g3.w.j0.n();
                l lVar2 = (l) jVar;
                nVar2.s(lVar2.b.a);
                a aVar5 = new a(1, this.this$0, jVar);
                nVar2.w();
                nVar2.i = aVar5;
                String str4 = lVar2.b.a;
                nVar2.w();
                nVar2.j = str4;
                i0.e.b.g3.w.l lVar3 = new i0.e.b.g3.w.l(this.this$0, jVar);
                nVar2.w();
                nVar2.k = lVar3;
                m0.n.b.i.d(nVar2, "@AndroidEntryPoint\nclass ExploreV2Fragment : BaseFragment(R.layout.fragment_explore_v2) {\n\n    @Inject\n    lateinit var actionTrailRecorder: ActionTrailRecorder\n\n    override val shouldShowKeyboard = true\n\n    private val binding: FragmentExploreV2Binding by viewBinding()\n    private val viewModel: ExploreV2ViewModel by fragmentViewModel()\n    private val searchController = PagingController()\n    private val recentSearchesController = PagingController()\n\n    private lateinit var topTab: TabLayout.Tab\n    private lateinit var peopleTab: TabLayout.Tab\n    private lateinit var clubTab: TabLayout.Tab\n    private lateinit var roomTab: TabLayout.Tab\n    private lateinit var eventTab: TabLayout.Tab\n\n    override fun onCreate(savedInstanceState: Bundle?) {\n        super.onCreate(savedInstanceState)\n        sharedElementEnterTransition = AutoTransition()\n    }\n\n    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {\n        super.onViewCreated(view, savedInstanceState)\n\n        // Disable animations, which are distracting as items change and move between results\n        binding.resultsList.itemAnimator = null\n        configurePagingControllers()\n\n        topTab = binding.resultTabs.newTab().setText(R.string.explore_tab_top).apply {\n            binding.resultTabs.addTab(this)\n        }\n        peopleTab = binding.resultTabs.newTab().setText(R.string.explore_tab_people).apply {\n            binding.resultTabs.addTab(this)\n        }\n        clubTab = binding.resultTabs.newTab().setText(R.string.explore_tab_clubs).apply {\n            binding.resultTabs.addTab(this)\n        }\n        roomTab = binding.resultTabs.newTab().setText(R.string.explore_tab_rooms).apply {\n            binding.resultTabs.addTab(this)\n        }\n        eventTab = binding.resultTabs.newTab().setText(R.string.explore_tab_events).apply {\n            binding.resultTabs.addTab(this)\n        }\n        binding.resultTabs.onTabSelected { tab ->\n            if (tab?.position == 0) {\n                viewModel.processIntent(SetMode(Mode.TOP))\n            } else if (tab?.position == 1) {\n                viewModel.processIntent(SetMode(Mode.PEOPLE))\n            } else if (tab?.position == 2) {\n                viewModel.processIntent(SetMode(Mode.CLUBS))\n            } else if (tab?.position == 3) {\n                viewModel.processIntent(SetMode(Mode.ROOMS))\n            } else if (tab?.position == 4) {\n                viewModel.processIntent(SetMode(Mode.EVENTS))\n            }\n        }\n\n        binding.search.debouncedTextChanges()\n            .onEach { viewModel.processIntent(UpdateQuery(it)) }\n            .launchIn(viewLifecycleOwner.lifecycleScope)\n        binding.cancel.setOnClickListener {\n            binding.search.text = null\n            hideSoftKeyBoard()\n            navigateUpSafe()\n        }\n\n        viewModel.onEach(ExploreV2ViewState::query) { query ->\n            if (query.isEmpty()) {\n                binding.resultsList.setController(recentSearchesController)\n            } else {\n                binding.resultsList.setController(searchController)\n            }\n        }\n\n        viewModel.onEach(ExploreV2ViewState::data) { data ->\n            data?.let {\n                viewLifecycleOwner.lifecycleScope.launch { searchController.submitData(it) }\n            }\n        }\n\n        viewModel.onEach(ExploreV2ViewState::recentSearches) { data ->\n            data?.let {\n                viewLifecycleOwner.lifecycleScope.launch {\n                    recentSearchesController.submitData(\n                        it.insertHeaderItem(item = HeaderItem(getString(R.string.recent)))\n                    )\n                }\n            }\n        }\n\n        viewModel.effectFlow.onEach {\n            when (it) {\n                is ShowClubRules -> showClubRules(it.club)\n                is ShowSuccess -> showBanner { message(it.message) }\n                is ShowError -> showNegativeBanner {\n                    message(it.message ?: getString(R.string.common_error_try_again))\n                }\n            }\n        }.launchIn(viewLifecycleOwner.lifecycleScope)\n    }\n\n    private fun configurePagingControllers() {\n        searchController.scrollToTopOnChange(binding.resultsList)\n        recentSearchesController.scrollToTopOnChange(binding.resultsList)\n\n        merge(\n            searchController.observeState(),\n            recentSearchesController.observeState()\n        ).onEach { state ->\n            withState(viewModel) {\n                binding.emptyIcon.showIf(state is PagingState.Empty && it.query.isEmpty())\n                binding.empty.showIf(state is PagingState.Empty)\n                binding.loading.showIf(state is PagingState.Loading)\n                binding.resultsList.hideIf(state is PagingState.Loading)\n            }\n        }.launchIn(viewLifecycleOwner.lifecycleScope)\n    }\n\n    override fun invalidate() {\n        withState(viewModel) { state ->\n            binding.resultTabs.hideIf(state.query.isEmpty())\n            binding.empty.setText(\n                if (state.query.isEmpty()) R.string.explore_v2_empty_state\n                else R.string.focused_search_empty\n            )\n\n            if (state.mode == Mode.TOP) {\n                binding.resultTabs.selectTab(topTab)\n            } else if (state.mode == Mode.PEOPLE) {\n                binding.resultTabs.selectTab(peopleTab)\n            } else if (state.mode == Mode.CLUBS) {\n                binding.resultTabs.selectTab(clubTab)\n            } else if (state.mode == Mode.ROOMS) {\n                binding.resultTabs.selectTab(roomTab)\n            } else if (state.mode == Mode.EVENTS) {\n                binding.resultTabs.selectTab(eventTab)\n            }\n        }\n    }\n\n    private fun showClubRules(item: ClubItem) {\n        navigateSafe(\n            ExploreV2FragmentDirections.actionExploreV2FragmentToClubRules(\n                HalfClubRulesArgs(\n                    item.club,\n                    true,\n                    sourceLocation = SourceLocation.SEARCH,\n                    loggingContext = item.loggingContext\n                )\n            )\n        )\n    }\n\n    inner class PagingController : PagingDataEpoxyController<PagingItem>() {\n        override fun buildItemModel(currentPosition: Int, item: PagingItem?): EpoxyModel<*> {\n            requireNotNull(item)\n            return when (item) {\n                is HeaderItem ->\n                    RecentSearchesHeader_()\n                        .id(item.title)\n                        .clearClickListener { _ ->\n                            viewModel.processIntent(ClearRecentSearches)\n                        }\n                is ClubItem ->\n                    ListClubWithMembership_()\n                        .id(item.club.id)\n                        .impressionLoggingAction {\n                            actionTrailRecorder.recommendationImpression(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                        }\n                        .club(item.club)\n                        .member(item.club.isMember)\n                        .clickListener { _ ->\n                            actionTrailRecorder.recommendationAccept(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                            navigateSafe(\n                                ExploreV2FragmentDirections.actionExploreV2FragmentToClubFragment(\n                                    ClubArgs(\n                                        item.club.id,\n                                        source = SourceLocation.SEARCH,\n                                        loggingContext = item.loggingContext\n                                    )\n                                )\n                            )\n                        }\n                        .joinClickListener { _ ->\n                            viewModel.processIntent(JoinClub(item))\n                        }\n                is UserItem ->\n                    FollowableListUser_()\n                        .id(item.user.id)\n                        .impressionLoggingAction {\n                            actionTrailRecorder.recommendationImpression(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                        }\n                        .user(item.user)\n                        .userBio(item.user.bio)\n                        .following(item.followedBySelf)\n                        .blocked(item.blockedBySelf)\n                        .self(item.isSelf)\n                        .showFollowButton(true)\n                        .clickListener { _ ->\n                            actionTrailRecorder.recommendationAccept(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                            navigateSafe(\n                                ExploreV2FragmentDirections.actionExploreV2FragmentToProfileFragment(\n                                    item.user.toProfileArgs(\n                                        SourceLocation.SEARCH,\n                                        item.loggingContext\n                                    )\n                                )\n                            )\n                        }\n                        .followClickListener { _ ->\n                            viewModel.processIntent(ToggleFollowUserItem(item))\n                        }\n                is ChannelItem -> {\n                    val speakers = item.channel.users?.filter { it.isSpeaker }\n                    ChannelInExplore_()\n                        .id(item.channel.id)\n                        .impressionLoggingAction {\n                            actionTrailRecorder.recommendationImpression(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                        }\n                        .clubName(item.channel.club?.name)\n                        .topic(item.channel.topic)\n                        .statsSpeakers(item.channel.numSpeakers.toString())\n                        .statsAll(item.channel.numAll.toString())\n                        .moderator1(speakers.getOrNull(0))\n                        .moderator2(speakers.getOrNull(1))\n                        .audienceType(item.channel.audienceType())\n                        .clickListener { _ ->\n                            actionTrailRecorder.recommendationAccept(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                            navigateToChannel(\n                                item.channel.channel,\n                                item.channel,\n                                SourceLocation.SEARCH\n                            )\n                        }\n                }\n                is EventItem ->\n                    EventInExplore_()\n                        .id(item.event.id)\n                        .impressionLoggingAction {\n                            actionTrailRecorder.recommendationImpression(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                        }\n                        .event(item.event)\n                        .rsvpClickListener { _, isAttending ->\n                            viewModel.processIntent(RSVPEvent(item, isAttending))\n                        }\n                        .eventClickListener { event ->\n                            actionTrailRecorder.recommendationAccept(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                            navigateSafe(\n                                ExploreV2FragmentDirections\n                                    .actionExploreV2FragmentToHalfEventDialog(\n                                        HalfEventArgs(\n                                            event = event,\n                                            loggingContext = item.loggingContext,\n                                            source = SourceLocation.SEARCH\n                                        )\n                                    )\n                            )\n                        }\n                is SearchQueryItem ->\n                    SearchQueryView_()\n                        .id(item.searchQuery.query)\n                        .impressionLoggingAction {\n                            actionTrailRecorder.recommendationImpression(\n                                SourceLocation.SEARCH,\n                                item.loggingContext\n                            )\n                        }\n                        .query(item.searchQuery.query)\n                        .clickListener { _ ->\n                            binding.search.setText(item.searchQuery.query)\n                        }\n                else -> throw Throwable(\"Invalid item type\")\n            }\n        }\n    }\n}");
                return nVar2;
            } else {
                throw new Throwable("Invalid item type");
            }
        }
    }

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends i0.b.b.h<ExploreV2Fragment, ExploreV2ViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ m0.n.a.l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, m0.n.a.l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<ExploreV2ViewModel> a(ExploreV2Fragment exploreV2Fragment, k kVar) {
            ExploreV2Fragment exploreV2Fragment2 = exploreV2Fragment;
            m0.n.b.i.e(exploreV2Fragment2, "thisRef");
            m0.n.b.i.e(kVar, "property");
            return i0.b.b.g.a.b(exploreV2Fragment2, kVar, this.a, new ExploreV2Fragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(y.class), false, this.b);
        }
    }

    public ExploreV2Fragment() {
        super(R.layout.fragment_explore_v2);
        d a2 = m.a(ExploreV2ViewModel.class);
        this.d2 = new a(a2, false, new m0.n.a.l<i0.b.b.k<ExploreV2ViewModel, y>, ExploreV2ViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.search.ExploreV2Fragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.clubhouse.android.ui.search.ExploreV2ViewModel, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.l
            public ExploreV2ViewModel invoke(i0.b.b.k<ExploreV2ViewModel, y> kVar) {
                i0.b.b.k<ExploreV2ViewModel, y> kVar2 = kVar;
                m0.n.b.i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                m0.n.b.i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                m0.n.b.i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, y.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, Z1[1]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(P0(), new m0.n.a.l<y, i>() { // from class: com.clubhouse.android.ui.search.ExploreV2Fragment$invalidate$1
            @Override // m0.n.a.l
            public i invoke(y yVar) {
                y yVar2 = yVar;
                m0.n.b.i.e(yVar2, "state");
                ExploreV2Fragment exploreV2Fragment = ExploreV2Fragment.this;
                k<Object>[] kVarArr = ExploreV2Fragment.Z1;
                TabLayout tabLayout = exploreV2Fragment.O0().e;
                m0.n.b.i.d(tabLayout, "binding.resultTabs");
                boolean z = false;
                i0.e.b.d3.k.q(tabLayout, Boolean.valueOf(yVar2.d.length() == 0));
                TextView textView = ExploreV2Fragment.this.O0().b;
                if (yVar2.d.length() == 0) {
                    z = true;
                }
                textView.setText(z ? R.string.explore_v2_empty_state : R.string.focused_search_empty);
                Mode mode = yVar2.c;
                if (mode == Mode.TOP) {
                    TabLayout tabLayout2 = ExploreV2Fragment.this.O0().e;
                    TabLayout.g gVar = ExploreV2Fragment.this.g2;
                    if (gVar != null) {
                        tabLayout2.l(gVar, true);
                    } else {
                        m0.n.b.i.m("topTab");
                        throw null;
                    }
                } else if (mode == Mode.PEOPLE) {
                    TabLayout tabLayout3 = ExploreV2Fragment.this.O0().e;
                    TabLayout.g gVar2 = ExploreV2Fragment.this.h2;
                    if (gVar2 != null) {
                        tabLayout3.l(gVar2, true);
                    } else {
                        m0.n.b.i.m("peopleTab");
                        throw null;
                    }
                } else if (mode == Mode.CLUBS) {
                    TabLayout tabLayout4 = ExploreV2Fragment.this.O0().e;
                    TabLayout.g gVar3 = ExploreV2Fragment.this.i2;
                    if (gVar3 != null) {
                        tabLayout4.l(gVar3, true);
                    } else {
                        m0.n.b.i.m("clubTab");
                        throw null;
                    }
                } else if (mode == Mode.ROOMS) {
                    TabLayout tabLayout5 = ExploreV2Fragment.this.O0().e;
                    TabLayout.g gVar4 = ExploreV2Fragment.this.j2;
                    if (gVar4 != null) {
                        tabLayout5.l(gVar4, true);
                    } else {
                        m0.n.b.i.m("roomTab");
                        throw null;
                    }
                } else if (mode == Mode.EVENTS) {
                    TabLayout tabLayout6 = ExploreV2Fragment.this.O0().e;
                    TabLayout.g gVar5 = ExploreV2Fragment.this.k2;
                    if (gVar5 != null) {
                        tabLayout6.l(gVar5, true);
                    } else {
                        m0.n.b.i.m("eventTab");
                        throw null;
                    }
                }
                return i.a;
            }
        });
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment
    public boolean K0() {
        return this.b2;
    }

    public final i0.e.a.b.a N0() {
        i0.e.a.b.a aVar = this.a2;
        if (aVar != null) {
            return aVar;
        }
        m0.n.b.i.m("actionTrailRecorder");
        throw null;
    }

    public final FragmentExploreV2Binding O0() {
        return (FragmentExploreV2Binding) this.c2.getValue(this, Z1[0]);
    }

    public final ExploreV2ViewModel P0() {
        return (ExploreV2ViewModel) this.d2.getValue();
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSharedElementEnterTransition(new h0.b0.a());
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m0.n.b.i.e(view, "view");
        super.onViewCreated(view, bundle);
        O0().f.setItemAnimator(null);
        PagingController pagingController = this.e2;
        ImpressionTrackingEpoxyRecyclerView impressionTrackingEpoxyRecyclerView = O0().f;
        m0.n.b.i.d(impressionTrackingEpoxyRecyclerView, "binding.resultsList");
        v.S1(pagingController, impressionTrackingEpoxyRecyclerView);
        PagingController pagingController2 = this.f2;
        ImpressionTrackingEpoxyRecyclerView impressionTrackingEpoxyRecyclerView2 = O0().f;
        m0.n.b.i.d(impressionTrackingEpoxyRecyclerView2, "binding.resultsList");
        v.S1(pagingController2, impressionTrackingEpoxyRecyclerView2);
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(m0.r.t.a.r.m.a1.a.K2(v.f1(this.e2), v.f1(this.f2)), new ExploreV2Fragment$configurePagingControllers$1(this, null));
        h0.q.p viewLifecycleOwner = getViewLifecycleOwner();
        m0.n.b.i.d(viewLifecycleOwner, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner));
        TabLayout.g i = O0().e.i();
        i.a(R.string.explore_tab_top);
        m0.n.b.i.d(i, "binding.resultTabs.newTab().setText(R.string.explore_tab_top)");
        O0().e.a(i);
        this.g2 = i;
        TabLayout.g i2 = O0().e.i();
        i2.a(R.string.explore_tab_people);
        m0.n.b.i.d(i2, "binding.resultTabs.newTab().setText(R.string.explore_tab_people)");
        O0().e.a(i2);
        this.h2 = i2;
        TabLayout.g i3 = O0().e.i();
        i3.a(R.string.explore_tab_clubs);
        m0.n.b.i.d(i3, "binding.resultTabs.newTab().setText(R.string.explore_tab_clubs)");
        O0().e.a(i3);
        this.i2 = i3;
        TabLayout.g i4 = O0().e.i();
        i4.a(R.string.explore_tab_rooms);
        m0.n.b.i.d(i4, "binding.resultTabs.newTab().setText(R.string.explore_tab_rooms)");
        O0().e.a(i4);
        this.j2 = i4;
        TabLayout.g i5 = O0().e.i();
        i5.a(R.string.explore_tab_events);
        m0.n.b.i.d(i5, "binding.resultTabs.newTab().setText(R.string.explore_tab_events)");
        O0().e.a(i5);
        this.k2 = i5;
        TabLayout tabLayout = O0().e;
        m0.n.b.i.d(tabLayout, "binding.resultTabs");
        i0.e.b.d3.k.C(tabLayout, new m0.n.a.l<TabLayout.g, i>() { // from class: com.clubhouse.android.ui.search.ExploreV2Fragment$onViewCreated$6
            @Override // m0.n.a.l
            public i invoke(TabLayout.g gVar) {
                TabLayout.g gVar2 = gVar;
                boolean z = true;
                if (gVar2 != null && gVar2.d == 0) {
                    ExploreV2Fragment exploreV2Fragment = ExploreV2Fragment.this;
                    k<Object>[] kVarArr = ExploreV2Fragment.Z1;
                    exploreV2Fragment.P0().p(new f0(Mode.TOP));
                } else {
                    if (gVar2 != null && gVar2.d == 1) {
                        ExploreV2Fragment exploreV2Fragment2 = ExploreV2Fragment.this;
                        k<Object>[] kVarArr2 = ExploreV2Fragment.Z1;
                        exploreV2Fragment2.P0().p(new f0(Mode.PEOPLE));
                    } else {
                        if (gVar2 != null && gVar2.d == 2) {
                            ExploreV2Fragment exploreV2Fragment3 = ExploreV2Fragment.this;
                            k<Object>[] kVarArr3 = ExploreV2Fragment.Z1;
                            exploreV2Fragment3.P0().p(new f0(Mode.CLUBS));
                        } else {
                            if (gVar2 != null && gVar2.d == 3) {
                                ExploreV2Fragment exploreV2Fragment4 = ExploreV2Fragment.this;
                                k<Object>[] kVarArr4 = ExploreV2Fragment.Z1;
                                exploreV2Fragment4.P0().p(new f0(Mode.ROOMS));
                            } else {
                                if (gVar2 == null || gVar2.d != 4) {
                                    z = false;
                                }
                                if (z) {
                                    ExploreV2Fragment exploreV2Fragment5 = ExploreV2Fragment.this;
                                    k<Object>[] kVarArr5 = ExploreV2Fragment.Z1;
                                    exploreV2Fragment5.P0().p(new f0(Mode.EVENTS));
                                }
                            }
                        }
                    }
                }
                return i.a;
            }
        });
        EditText editText = O0().g;
        m0.n.b.i.d(editText, "binding.search");
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$12 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(i0.e.b.d3.k.f(editText), new ExploreV2Fragment$onViewCreated$7(this, null));
        h0.q.p viewLifecycleOwner2 = getViewLifecycleOwner();
        m0.n.b.i.d(viewLifecycleOwner2, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$12, q.a(viewLifecycleOwner2));
        O0().a.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.w.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ExploreV2Fragment exploreV2Fragment = ExploreV2Fragment.this;
                k<Object>[] kVarArr = ExploreV2Fragment.Z1;
                m0.n.b.i.e(exploreV2Fragment, "this$0");
                exploreV2Fragment.O0().g.setText((CharSequence) null);
                v.x0(exploreV2Fragment);
                v.c1(exploreV2Fragment);
            }
        });
        f1 unused = x0(P0(), ExploreV2Fragment$onViewCreated$9.c, (r5 & 2) != 0 ? c0.a : null, new ExploreV2Fragment$onViewCreated$10(this, null));
        f1 unused2 = x0(P0(), ExploreV2Fragment$onViewCreated$11.c, (r5 & 2) != 0 ? c0.a : null, new ExploreV2Fragment$onViewCreated$12(this, null));
        f1 unused3 = x0(P0(), ExploreV2Fragment$onViewCreated$13.c, (r5 & 2) != 0 ? c0.a : null, new ExploreV2Fragment$onViewCreated$14(this, null));
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$13 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(P0().l, new ExploreV2Fragment$onViewCreated$15(this, null));
        h0.q.p viewLifecycleOwner3 = getViewLifecycleOwner();
        m0.n.b.i.d(viewLifecycleOwner3, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$13, q.a(viewLifecycleOwner3));
    }
}
