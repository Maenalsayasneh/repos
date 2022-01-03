package com.clubhouse.android.ui.channels;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleCoroutineScope$launchWhenStarted$1;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.airbnb.epoxy.EpoxyRecyclerView;
import com.clubhouse.android.channels.model.AudienceType;
import com.clubhouse.android.channels.mvi.ChannelViewModel;
import com.clubhouse.android.channels.repos.SpeakerStateDataSource;
import com.clubhouse.android.channels.repos.SpeakerStateDataSource$speakingSignalForUser$$inlined$map$1;
import com.clubhouse.android.core.ui.SafeMotionLayout;
import com.clubhouse.android.data.models.local.channel.Channel;
import com.clubhouse.android.data.models.local.channel.UserInChannel;
import com.clubhouse.android.data.models.local.club.Club;
import com.clubhouse.android.databinding.FragmentChannelBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.shared.ui.AvatarView;
import com.clubhouse.android.ui.ChannelDisplayState;
import com.clubhouse.android.ui.NavigationViewModel;
import com.clubhouse.android.ui.actionsheet.ActionSheetBuilder;
import com.clubhouse.android.ui.channels.ChannelFragment;
import com.clubhouse.android.ui.channels.ChannelFragment$onViewCreated$13$1;
import com.clubhouse.android.ui.channels.ChannelNavigation$showRaisedHandsQueue$1;
import com.clubhouse.android.ui.channels.views.ChannelCtaBar;
import com.clubhouse.android.ui.channels.views.FacePile;
import com.clubhouse.android.user.model.User;
import com.clubhouse.app.R;
import h0.a.b;
import h0.b0.v;
import h0.q.a0;
import h0.t.f;
import h0.x.a;
import i0.b.a.o;
import i0.b.b.c0;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.k0;
import i0.b.b.x;
import i0.e.b.a3.f.e;
import i0.e.b.a3.f.q;
import i0.e.b.g3.k.n;
import i0.e.b.z2.g.g0;
import i0.e.b.z2.g.h0;
import i0.e.b.z2.g.j1;
import i0.e.b.z2.g.o0;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.c;
import m0.n.a.l;
import m0.n.a.p;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
import n0.a.f1;
/* compiled from: ChannelFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b/\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0004J\r\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\u0004R\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0016\u001a\u00020\u00158\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001f\u001a\u00020\u001a8@@\u0000X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010%\u001a\u00020 8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b'\u0010(R\u001d\u0010.\u001a\u00020*8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u001c\u001a\u0004\b,\u0010-¨\u00060"}, d2 = {"Lcom/clubhouse/android/ui/channels/ChannelFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Lm0/i;", "O0", "()V", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "P0", "Li0/e/a/b/a;", "a2", "Li0/e/a/b/a;", "getActionTrailRecorder", "()Li0/e/a/b/a;", "setActionTrailRecorder", "(Li0/e/a/b/a;)V", "actionTrailRecorder", "", "shouldAdjustResize", "Z", "J0", "()Z", "Lcom/clubhouse/android/channels/mvi/ChannelViewModel;", "d2", "Lm0/c;", "S0", "()Lcom/clubhouse/android/channels/mvi/ChannelViewModel;", "viewModel", "Lcom/clubhouse/android/databinding/FragmentChannelBinding;", "b2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "Q0", "()Lcom/clubhouse/android/databinding/FragmentChannelBinding;", "binding", "Lh0/a/b;", "e2", "Lh0/a/b;", "collapseOnBackPress", "Lcom/clubhouse/android/ui/NavigationViewModel;", "c2", "R0", "()Lcom/clubhouse/android/ui/NavigationViewModel;", "navigationViewModel", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class ChannelFragment extends Hilt_ChannelFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(ChannelFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentChannelBinding;")), m.c(new PropertyReference1Impl(m.a(ChannelFragment.class), "navigationViewModel", "getNavigationViewModel()Lcom/clubhouse/android/ui/NavigationViewModel;")), m.c(new PropertyReference1Impl(m.a(ChannelFragment.class), "viewModel", "getViewModel$app_productionRelease()Lcom/clubhouse/android/channels/mvi/ChannelViewModel;"))};
    public i0.e.a.b.a a2;
    public final FragmentViewBindingDelegate b2 = new FragmentViewBindingDelegate(FragmentChannelBinding.class, this);
    public final c c2;
    public final c d2;
    public h0.a.b e2;

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<ChannelFragment, ChannelViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<ChannelViewModel> a(ChannelFragment channelFragment, k kVar) {
            ChannelFragment channelFragment2 = channelFragment;
            i.e(channelFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(channelFragment2, kVar, this.a, new ChannelFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(i0.e.b.z2.g.l.class), false, this.b);
        }
    }

    /* compiled from: MavericksExtensions.kt */
    /* loaded from: classes3.dex */
    public static final class b extends h<ChannelFragment, NavigationViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ p b;
        public final /* synthetic */ d c;

        public b(d dVar, int i, p pVar, d dVar2) {
            this.a = dVar;
            this.b = pVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<NavigationViewModel> a(ChannelFragment channelFragment, k kVar) {
            ChannelFragment channelFragment2 = channelFragment;
            i.e(channelFragment2, "thisRef");
            i.e(kVar, "property");
            k0 k0Var = g.a;
            if (k0Var instanceof i0.b.b.l0.a) {
                return ((i0.b.b.l0.a) k0Var).a(channelFragment2, kVar, this.a, new ChannelFragment$special$$inlined$navGraphViewModel$default$2$1(this), m.a(i0.e.b.g3.h.class), R.id.main_graph, this.b);
            }
            throw new IllegalStateException("Navigation ViewModels require that Mavericks.viewModelDelegateFactory have an implementation of NavigationViewModelDelegateFactory.\n \n To setup the default factory configuration, you can use the default factory DefaultNavigationViewModelDelegateFactory.\n DefaultNavigationViewModelDelegateFactory also implements DefaultViewModelDelegateFactory by default.\n \n Mavericks.viewModelDelegateFactory = DefaultNavigationViewModelDelegateFactory()");
        }
    }

    public ChannelFragment() {
        super(R.layout.fragment_channel);
        d a2 = m.a(NavigationViewModel.class);
        b bVar = new b(a2, R.id.main_graph, new p<i0.b.b.k<NavigationViewModel, i0.e.b.g3.h>, f, NavigationViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.channels.ChannelFragment$special$$inlined$navGraphViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r11v4, types: [com.clubhouse.android.ui.NavigationViewModel, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.p
            public NavigationViewModel invoke(i0.b.b.k<NavigationViewModel, i0.e.b.g3.h> kVar, f fVar) {
                i0.b.b.k<NavigationViewModel, i0.e.b.g3.h> kVar2 = kVar;
                f fVar2 = fVar;
                i.e(kVar2, "stateFactory");
                i.e(fVar2, "backStackEntry");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                Object a3 = v.a(Fragment.this);
                Fragment fragment = Fragment.this;
                a aVar = fVar2.y.b;
                i.d(aVar, "backStackEntry.savedStateRegistry");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, a3, fragment, fVar2, aVar);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, i0.e.b.g3.h.class, dVar, name, false, kVar2, 16);
            }
        }, a2);
        k<?>[] kVarArr = Z1;
        this.c2 = bVar.a(this, kVarArr[1]);
        d a3 = m.a(ChannelViewModel.class);
        this.d2 = new a(a3, false, new l<i0.b.b.k<ChannelViewModel, i0.e.b.z2.g.l>, ChannelViewModel>(a3, a3) { // from class: com.clubhouse.android.ui.channels.ChannelFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.clubhouse.android.channels.mvi.ChannelViewModel, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.l
            public ChannelViewModel invoke(i0.b.b.k<ChannelViewModel, i0.e.b.z2.g.l> kVar) {
                i0.b.b.k<ChannelViewModel, i0.e.b.z2.g.l> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, i0.e.b.z2.g.l.class, dVar, name, false, kVar2, 16);
            }
        }, a3).a(this, kVarArr[2]);
    }

    public static final void N0(ChannelFragment channelFragment, ActionSheetBuilder actionSheetBuilder, AudienceType audienceType, boolean z) {
        Objects.requireNonNull(channelFragment);
        actionSheetBuilder.a(new l<i0.e.b.g3.i.c, m0.i>(channelFragment, z) { // from class: com.clubhouse.android.ui.channels.ChannelFragment$audienceOption$1
            public final /* synthetic */ ChannelFragment d;
            public final /* synthetic */ boolean q;

            {
                this.d = r2;
                this.q = r3;
            }

            @Override // m0.n.a.l
            public m0.i invoke(i0.e.b.g3.i.c cVar) {
                i0.e.b.g3.i.c cVar2 = cVar;
                i.e(cVar2, "$this$action");
                cVar2.a = Integer.valueOf(AudienceType.this.getActionIcon());
                cVar2.c = Integer.valueOf((int) R.color.clubhouse_green);
                String string = this.d.getString(AudienceType.this.getActionTitle());
                i.d(string, "getString(type.actionTitle)");
                cVar2.b(string);
                cVar2.e = this.d.getString(AudienceType.this.getExplanation());
                cVar2.f = this.q;
                final ChannelFragment channelFragment2 = this.d;
                final AudienceType audienceType2 = AudienceType.this;
                cVar2.a(new m0.n.a.a<m0.i>() { // from class: com.clubhouse.android.ui.channels.ChannelFragment$audienceOption$1.1
                    @Override // m0.n.a.a
                    public m0.i invoke() {
                        ChannelFragment.this.S0().p(new i0.e.b.z2.g.i(audienceType2));
                        return m0.i.a;
                    }
                });
                return m0.i.a;
            }
        });
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(S0(), new l<i0.e.b.z2.g.l, m0.i>() { // from class: com.clubhouse.android.ui.channels.ChannelFragment$invalidate$1
            /* JADX WARN: Removed duplicated region for block: B:106:0x0343  */
            /* JADX WARN: Removed duplicated region for block: B:107:0x034b  */
            /* JADX WARN: Removed duplicated region for block: B:120:0x03cc  */
            @Override // m0.n.a.l
            /* Code decompiled incorrectly, please refer to instructions dump */
            public m0.i invoke(i0.e.b.z2.g.l lVar) {
                UserInChannel userInChannel;
                String str;
                boolean z;
                Club i;
                String name;
                String str2;
                Club i2;
                String name2;
                AudienceType audienceType;
                i0.e.b.z2.g.l lVar2 = lVar;
                i.e(lVar2, "state");
                ChannelFragment channelFragment = ChannelFragment.this;
                k<Object>[] kVarArr = ChannelFragment.Z1;
                channelFragment.Q0().e.g();
                ChannelFragment.this.Q0().w.setRefreshing(lVar2.c);
                FacePile facePile = ChannelFragment.this.Q0().m;
                List v02 = m0.j.g.v0(lVar2.p.k);
                int d = lVar2.p.d();
                Objects.requireNonNull(facePile);
                i.e(v02, "users");
                boolean z2 = false;
                AvatarView avatarView = facePile.c.b;
                i.d(avatarView, "binding.face1");
                facePile.a(avatarView, (User) m0.j.g.z(v02, 0));
                AvatarView avatarView2 = facePile.c.c;
                i.d(avatarView2, "binding.face2");
                facePile.a(avatarView2, (User) m0.j.g.z(v02, 1));
                int i3 = 8;
                if (d > 2) {
                    facePile.c.d.setVisibility(0);
                    facePile.c.d.setText(i.k("+", i0.e.b.f3.d.a(d - 2)));
                } else {
                    facePile.c.d.setVisibility(8);
                }
                ImageView imageView = ChannelFragment.this.Q0().r;
                i.d(imageView, "binding.iconRaiseHand");
                i.e(imageView, "<this>");
                i.e(lVar2, "state");
                imageView.setVisibility(lVar2.p.h() ? 8 : 0);
                if (lVar2.d) {
                    imageView.setImageResource(com.clubhouse.android.channels.R.drawable.ic_raise_hand_nux);
                } else if (lVar2.G) {
                    imageView.setImageResource(com.clubhouse.android.channels.R.drawable.ic_raise_hand);
                } else {
                    imageView.setImageResource(com.clubhouse.android.channels.R.drawable.ic_raise_hand_disabled);
                }
                ImageView imageView2 = ChannelFragment.this.Q0().s;
                i.d(imageView2, "binding.iconRaisedHandsQueue");
                i.e(imageView2, "<this>");
                i.e(lVar2, "state");
                if (lVar2.q) {
                    i3 = 0;
                }
                imageView2.setVisibility(i3);
                q qVar = q.a;
                qVar.a(imageView2, lVar2.C.c(), com.clubhouse.android.core.R.xml.badge_style);
                imageView2.setContentDescription(imageView2.getResources().getQuantityString(com.clubhouse.android.channels.R.plurals.cd_raised_hands_count, lVar2.C.c()));
                ImageView imageView3 = ChannelFragment.this.Q0().p;
                i.d(imageView3, "binding.iconMute");
                i0.e.b.d3.k.L(imageView3, Boolean.valueOf(lVar2.p.h()));
                ImageView imageView4 = ChannelFragment.this.Q0().n;
                i.d(imageView4, "binding.iconClip");
                i0.e.b.d3.k.L(imageView4, Boolean.valueOf(lVar2.U));
                ChannelFragment.this.Q0().t.setText(lVar2.W);
                ChannelFragment channelFragment2 = ChannelFragment.this;
                ChannelCtaBar channelCtaBar = channelFragment2.Q0().d;
                i.d(channelCtaBar, "binding.channelCtaBar");
                i.e(channelFragment2, "<this>");
                i.e(channelCtaBar, "ctaBar");
                i.e(lVar2, "state");
                if (lVar2.q) {
                    Channel channel = lVar2.u;
                    if (channel == null) {
                        audienceType = null;
                    } else {
                        audienceType = v.o(channel);
                    }
                    if (audienceType == AudienceType.Closed && !lVar2.J) {
                        channelCtaBar.t(i0.d.a.a.a.T(channelFragment2, R.string.closed_room_description, "resources.getString(R.string.closed_room_description)"), i0.d.a.a.a.T(channelFragment2, R.string.closed_room_open_up, "resources.getString(R.string.closed_room_open_up)"), 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0185: INVOKE  
                              (r6v19 'channelCtaBar' com.clubhouse.android.ui.channels.views.ChannelCtaBar)
                              (wrap: java.lang.String : 0x0173: INVOKE  (r4v16 java.lang.String A[REMOVE]) = 
                              (r1v24 'channelFragment2' com.clubhouse.android.ui.channels.ChannelFragment)
                              (wrap: ?? : ?: SGET   com.clubhouse.app.R.string.closed_room_description int)
                              ("resources.getString(R.string.closed_room_description)")
                             type: STATIC call: i0.d.a.a.a.T(com.clubhouse.android.ui.channels.ChannelFragment, int, java.lang.String):java.lang.String)
                              (wrap: java.lang.String : 0x017c: INVOKE  (r7v44 java.lang.String A[REMOVE]) = 
                              (r1v24 'channelFragment2' com.clubhouse.android.ui.channels.ChannelFragment)
                              (wrap: ?? : ?: SGET   com.clubhouse.app.R.string.closed_room_open_up int)
                              ("resources.getString(R.string.closed_room_open_up)")
                             type: STATIC call: i0.d.a.a.a.T(com.clubhouse.android.ui.channels.ChannelFragment, int, java.lang.String):java.lang.String)
                              (wrap: i0.e.b.g3.k.y0.d : 0x0182: CONSTRUCTOR  (r9v21 i0.e.b.g3.k.y0.d A[REMOVE]) = (r1v24 'channelFragment2' com.clubhouse.android.ui.channels.ChannelFragment) call: i0.e.b.g3.k.y0.d.<init>(com.clubhouse.android.ui.channels.ChannelFragment):void type: CONSTRUCTOR)
                             type: VIRTUAL call: com.clubhouse.android.ui.channels.views.ChannelCtaBar.t(java.lang.String, java.lang.String, android.view.View$OnClickListener):void in method: com.clubhouse.android.ui.channels.ChannelFragment$invalidate$1.invoke(i0.e.b.z2.g.l):m0.i, file: classes3.dex
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
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:122)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
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
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: i0.e.b.g3.k.y0.d, state: NOT_LOADED
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
                            	... 27 more
                            */
                        /*
                        // Method dump skipped, instructions count: 1118
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.clubhouse.android.ui.channels.ChannelFragment$invalidate$1.invoke(java.lang.Object):java.lang.Object");
                    }
                });
            }

            @Override // com.clubhouse.android.core.ui.BaseFragment
            public boolean J0() {
                return false;
            }

            public final void O0() {
                R0().q(ChannelDisplayState.COLLAPSED);
                SafeMotionLayout safeMotionLayout = Q0().a;
                i.d(safeMotionLayout, "binding.root");
                int endState = Q0().a.getEndState();
                ChannelFragment$collapse$1 channelFragment$collapse$1 = new m0.n.a.a<m0.i>() { // from class: com.clubhouse.android.ui.channels.ChannelFragment$collapse$1
                    @Override // m0.n.a.a
                    public m0.i invoke() {
                        ChannelFragment channelFragment = ChannelFragment.this;
                        k<Object>[] kVarArr = ChannelFragment.Z1;
                        Toolbar toolbar = channelFragment.Q0().x;
                        i.d(toolbar, "binding.toolbar");
                        i0.e.b.d3.k.p(toolbar);
                        ImageView imageView = ChannelFragment.this.Q0().b;
                        i.d(imageView, "binding.backchannel");
                        i0.e.b.d3.k.p(imageView);
                        ChannelFragment.this.Q0().c.requestLayout();
                        return m0.i.a;
                    }
                };
                i.e(safeMotionLayout, "<this>");
                i.e(channelFragment$collapse$1, "f");
                safeMotionLayout.setTransitionListener(new i0.e.b.a3.f.p(endState, channelFragment$collapse$1));
                Button button = Q0().o;
                i.d(button, "binding.iconLeave");
                i0.e.b.d3.k.K(button);
                View view = Q0().g;
                i.d(view, "binding.collapsedVirtualBackground");
                i0.e.b.d3.k.K(view);
                Q0().a.I();
                h0.a.b bVar = this.e2;
                if (bVar != null) {
                    bVar.a = false;
                } else {
                    i.m("collapseOnBackPress");
                    throw null;
                }
            }

            public final void P0() {
                LifecycleCoroutineScope a2 = h0.q.q.a(this);
                ChannelFragment$expand$1 channelFragment$expand$1 = new ChannelFragment$expand$1(this, null);
                i.e(channelFragment$expand$1, "block");
                m0.r.t.a.r.m.a1.a.E2(a2, null, null, new LifecycleCoroutineScope$launchWhenStarted$1(a2, channelFragment$expand$1, null), 3, null);
            }

            public final FragmentChannelBinding Q0() {
                return (FragmentChannelBinding) this.b2.getValue(this, Z1[0]);
            }

            public final NavigationViewModel R0() {
                return (NavigationViewModel) this.c2.getValue();
            }

            public final ChannelViewModel S0() {
                return (ChannelViewModel) this.d2.getValue();
            }

            @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
            public void onViewCreated(View view, Bundle bundle) {
                i.e(view, "view");
                super.onViewCreated(view, bundle);
                OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
                i.d(onBackPressedDispatcher, "requireActivity().onBackPressedDispatcher");
                this.e2 = g0.a.b.b.a.a(onBackPressedDispatcher, this, false, new l<h0.a.b, m0.i>() { // from class: com.clubhouse.android.ui.channels.ChannelFragment$onViewCreated$1
                    @Override // m0.n.a.l
                    public m0.i invoke(b bVar) {
                        i.e(bVar, "$this$addCallback");
                        ChannelFragment channelFragment = ChannelFragment.this;
                        k<Object>[] kVarArr = ChannelFragment.Z1;
                        channelFragment.O0();
                        return m0.i.a;
                    }
                }, 2);
                R0().q(ChannelDisplayState.EXPANDED);
                FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(S0().l, new ChannelFragment$onViewCreated$2(this, null));
                h0.q.p viewLifecycleOwner = getViewLifecycleOwner();
                i.d(viewLifecycleOwner, "viewLifecycleOwner");
                m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, h0.q.q.a(viewLifecycleOwner));
                f1 unused = x0(R0(), ChannelFragment$onViewCreated$3.c, (r5 & 2) != 0 ? c0.a : null, new ChannelFragment$onViewCreated$4(this, null));
                Q0().w.setOnRefreshListener(new SwipeRefreshLayout.h() { // from class: i0.e.b.g3.k.c
                    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.h
                    public final void q0() {
                        ChannelFragment channelFragment = ChannelFragment.this;
                        k<Object>[] kVarArr = ChannelFragment.Z1;
                        i.e(channelFragment, "this$0");
                        channelFragment.S0().p(g0.a);
                    }
                });
                Q0().f.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.k.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        ChannelFragment channelFragment = ChannelFragment.this;
                        k<Object>[] kVarArr = ChannelFragment.Z1;
                        i.e(channelFragment, "this$0");
                        channelFragment.O0();
                    }
                });
                Q0().g.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.k.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        ChannelFragment channelFragment = ChannelFragment.this;
                        k<Object>[] kVarArr = ChannelFragment.Z1;
                        i.e(channelFragment, "this$0");
                        channelFragment.P0();
                    }
                });
                Button button = Q0().t;
                i.d(button, "binding.leaveButton");
                h0.q.p viewLifecycleOwner2 = getViewLifecycleOwner();
                i.d(viewLifecycleOwner2, "viewLifecycleOwner");
                i0.e.b.d3.k.H(button, h0.q.q.a(viewLifecycleOwner2), new View.OnClickListener() { // from class: i0.e.b.g3.k.y
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        ChannelFragment channelFragment = ChannelFragment.this;
                        k<Object>[] kVarArr = ChannelFragment.Z1;
                        i.e(channelFragment, "this$0");
                        channelFragment.S0().p(o0.a);
                    }
                });
                Button button2 = Q0().o;
                i.d(button2, "binding.iconLeave");
                h0.q.p viewLifecycleOwner3 = getViewLifecycleOwner();
                i.d(viewLifecycleOwner3, "viewLifecycleOwner");
                i0.e.b.d3.k.H(button2, h0.q.q.a(viewLifecycleOwner3), new View.OnClickListener() { // from class: i0.e.b.g3.k.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        ChannelFragment channelFragment = ChannelFragment.this;
                        k<Object>[] kVarArr = ChannelFragment.Z1;
                        i.e(channelFragment, "this$0");
                        channelFragment.S0().p(o0.a);
                    }
                });
                ImageView imageView = Q0().r;
                i.d(imageView, "binding.iconRaiseHand");
                h0.q.p viewLifecycleOwner4 = getViewLifecycleOwner();
                i.d(viewLifecycleOwner4, "viewLifecycleOwner");
                i0.e.b.d3.k.H(imageView, h0.q.q.a(viewLifecycleOwner4), new View.OnClickListener() { // from class: i0.e.b.g3.k.q
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        ChannelFragment channelFragment = ChannelFragment.this;
                        k<Object>[] kVarArr = ChannelFragment.Z1;
                        i.e(channelFragment, "this$0");
                        channelFragment.S0().p(j1.a);
                    }
                });
                Q0().n.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.k.s0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        ChannelFragment channelFragment = ChannelFragment.this;
                        k<Object>[] kVarArr = ChannelFragment.Z1;
                        i.e(channelFragment, "this$0");
                        channelFragment.S0().p(i0.e.b.z2.g.g.a);
                    }
                });
                Q0().s.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.k.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        ChannelFragment channelFragment = ChannelFragment.this;
                        k<Object>[] kVarArr = ChannelFragment.Z1;
                        i.e(channelFragment, "this$0");
                        i.e(channelFragment, "<this>");
                        v.G(channelFragment, ChannelNavigation$showRaisedHandsQueue$1.c);
                    }
                });
                Q0().p.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.k.i
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        ChannelFragment channelFragment = ChannelFragment.this;
                        k<Object>[] kVarArr = ChannelFragment.Z1;
                        m0.n.b.i.e(channelFragment, "this$0");
                        ChannelFragment$onViewCreated$13$1 channelFragment$onViewCreated$13$1 = 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: CONSTRUCTOR  (r7v3 'channelFragment$onViewCreated$13$1' com.clubhouse.android.ui.channels.ChannelFragment$onViewCreated$13$1) = (r0v0 'channelFragment' com.clubhouse.android.ui.channels.ChannelFragment) call: com.clubhouse.android.ui.channels.ChannelFragment$onViewCreated$13$1.<init>(com.clubhouse.android.ui.channels.ChannelFragment):void type: CONSTRUCTOR in method: i0.e.b.g3.k.i.onClick(android.view.View):void, file: classes3.dex
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
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.channels.ChannelFragment$onViewCreated$13$1, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                            	... 15 more
                            */
                        /*
                            this = this;
                            com.clubhouse.android.ui.channels.ChannelFragment r0 = com.clubhouse.android.ui.channels.ChannelFragment.this
                            m0.r.k<java.lang.Object>[] r7 = com.clubhouse.android.ui.channels.ChannelFragment.Z1
                            java.lang.String r7 = "this$0"
                            m0.n.b.i.e(r0, r7)
                            com.clubhouse.android.ui.channels.ChannelFragment$onViewCreated$13$1 r7 = new com.clubhouse.android.ui.channels.ChannelFragment$onViewCreated$13$1
                            r7.<init>(r0)
                            java.lang.String r1 = "<this>"
                            m0.n.b.i.e(r0, r1)
                            java.lang.String r1 = "action"
                            m0.n.b.i.e(r7, r1)
                            h0.o.a.k r1 = r0.getActivity()
                            if (r1 != 0) goto L_0x001f
                            goto L_0x0052
                        L_0x001f:
                            r2 = 2131952461(0x7f13034d, float:1.9541365E38)
                            com.clubhouse.android.shared.PermissionUtil$withAudioPermissions$1$rationaleHandler$1 r3 = new com.clubhouse.android.shared.PermissionUtil$withAudioPermissions$1$rationaleHandler$1
                            r3.<init>(r0)
                            java.lang.String r4 = "$this$createDialogRationale"
                            m0.n.b.i.f(r1, r4)
                            java.lang.String r4 = "block"
                            m0.n.b.i.f(r3, r4)
                            i0.a.a.f.b r4 = new i0.a.a.f.b
                            com.afollestad.assent.rationale.AlertDialogRationaleHandlerKt$createDialogRationale$2 r5 = new com.afollestad.assent.rationale.AlertDialogRationaleHandlerKt$createDialogRationale$2
                            r5.<init>(r1)
                            r4.<init>(r1, r2, r5)
                            r3.invoke(r4)
                            r1 = 1
                            com.afollestad.assent.Permission[] r1 = new com.afollestad.assent.Permission[r1]
                            r2 = 0
                            com.afollestad.assent.Permission r3 = com.afollestad.assent.Permission.RECORD_AUDIO
                            r1[r2] = r3
                            com.clubhouse.android.shared.PermissionUtil$withAudioPermissions$1$1 r5 = new com.clubhouse.android.shared.PermissionUtil$withAudioPermissions$1$1
                            r5.<init>(r0, r7)
                            r7 = 2
                            r3 = r4
                            r4 = r5
                            r5 = r7
                            i0.a.a.b.a(r0, r1, r2, r3, r4, r5)
                        L_0x0052:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.k.i.onClick(android.view.View):void");
                    }
                });
                Q0().q.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.k.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        ChannelFragment channelFragment = ChannelFragment.this;
                        k<Object>[] kVarArr = ChannelFragment.Z1;
                        i.e(channelFragment, "this$0");
                        v.v2(channelFragment.S0(), 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: INVOKE  
                              (wrap: com.clubhouse.android.channels.mvi.ChannelViewModel : 0x0009: INVOKE  (r0v2 com.clubhouse.android.channels.mvi.ChannelViewModel A[REMOVE]) = (r3v1 'channelFragment' com.clubhouse.android.ui.channels.ChannelFragment) type: VIRTUAL call: com.clubhouse.android.ui.channels.ChannelFragment.S0():com.clubhouse.android.channels.mvi.ChannelViewModel)
                              (wrap: com.clubhouse.android.ui.channels.ChannelFragment$onViewCreated$14$1 : 0x000f: CONSTRUCTOR  (r1v0 com.clubhouse.android.ui.channels.ChannelFragment$onViewCreated$14$1 A[REMOVE]) = (r3v1 'channelFragment' com.clubhouse.android.ui.channels.ChannelFragment) call: com.clubhouse.android.ui.channels.ChannelFragment$onViewCreated$14$1.<init>(com.clubhouse.android.ui.channels.ChannelFragment):void type: CONSTRUCTOR)
                             type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: i0.e.b.g3.k.a.onClick(android.view.View):void, file: classes3.dex
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
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.channels.ChannelFragment$onViewCreated$14$1, state: NOT_LOADED
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
                            com.clubhouse.android.ui.channels.ChannelFragment r3 = com.clubhouse.android.ui.channels.ChannelFragment.this
                            m0.r.k<java.lang.Object>[] r0 = com.clubhouse.android.ui.channels.ChannelFragment.Z1
                            java.lang.String r0 = "this$0"
                            m0.n.b.i.e(r3, r0)
                            com.clubhouse.android.channels.mvi.ChannelViewModel r0 = r3.S0()
                            com.clubhouse.android.ui.channels.ChannelFragment$onViewCreated$14$1 r1 = new com.clubhouse.android.ui.channels.ChannelFragment$onViewCreated$14$1
                            r1.<init>(r3)
                            h0.b0.v.v2(r0, r1)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.k.a.onClick(android.view.View):void");
                    }
                });
                Q0().h.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.k.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        ChannelFragment channelFragment = ChannelFragment.this;
                        k<Object>[] kVarArr = ChannelFragment.Z1;
                        i.e(channelFragment, "this$0");
                        e.b(channelFragment, channelFragment.getString(R.string.clubhouse_guidelines));
                    }
                });
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 12);
                Q0().e.setLayoutManager(gridLayoutManager);
                EpoxyRecyclerView epoxyRecyclerView = Q0().e;
                i.d(epoxyRecyclerView, "binding.channelUserList");
                i0.e.b.d3.k.D(epoxyRecyclerView, this, new l<o, m0.i>(this) { // from class: com.clubhouse.android.ui.channels.ChannelFragment$buildModels$1
                    public final /* synthetic */ ChannelFragment d;

                    {
                        this.d = r2;
                    }

                    @Override // m0.n.a.l
                    public m0.i invoke(o oVar) {
                        final o oVar2 = oVar;
                        i.e(oVar2, "$this$null");
                        GridLayoutManager.this.g = oVar2.getSpanSizeLookup();
                        ChannelViewModel S0 = this.d.S0();
                        final ChannelFragment channelFragment = this.d;
                        v.v2(S0, new l<i0.e.b.z2.g.l, m0.i>() { // from class: com.clubhouse.android.ui.channels.ChannelFragment$buildModels$1.1
                            @Override // m0.n.a.l
                            public m0.i invoke(i0.e.b.z2.g.l lVar) {
                                i0.e.b.z2.g.l lVar2 = lVar;
                                i.e(lVar2, "state");
                                o oVar3 = o.this;
                                ChannelFragment channelFragment2 = channelFragment;
                                i0.e.b.g3.k.x0.g gVar = new i0.e.b.g3.k.x0.g();
                                gVar.N("header");
                                gVar.L(lVar2.u);
                                gVar.O(new i0.e.b.g3.k.m(channelFragment2));
                                gVar.M(new i0.e.b.g3.k.o(channelFragment2, lVar2));
                                oVar3.add(gVar);
                                List<UserInChannel> list = lVar2.p.k;
                                o oVar4 = o.this;
                                ChannelFragment channelFragment3 = channelFragment;
                                for (UserInChannel userInChannel : list) {
                                    i0.e.b.g3.k.x0.i iVar = new i0.e.b.g3.k.x0.i();
                                    iVar.M(new Number[]{userInChannel.getId()});
                                    iVar.Q(userInChannel);
                                    iVar.N(lVar2.p.e(userInChannel.getId().intValue()));
                                    iVar.P(m0.r.t.a.r.m.a1.a.f1(new SpeakerStateDataSource$speakingSignalForUser$$inlined$map$1(channelFragment3.S0().A.a.o, userInChannel.getId().intValue())));
                                    iVar.O(channelFragment3.S0().A.b(userInChannel.getId()));
                                    iVar.L(new i0.e.b.g3.k.p(channelFragment3, userInChannel));
                                    oVar4.add(iVar);
                                }
                                if (!lVar2.p.l.isEmpty()) {
                                    o oVar5 = o.this;
                                    ChannelFragment channelFragment4 = channelFragment;
                                    i0.e.b.g3.k.x0.d dVar = new i0.e.b.g3.k.x0.d();
                                    dVar.L("friends");
                                    dVar.M(channelFragment4.getString(R.string.followed_by_speakers));
                                    oVar5.add(dVar);
                                }
                                List<UserInChannel> list2 = lVar2.p.l;
                                o oVar6 = o.this;
                                ChannelFragment channelFragment5 = channelFragment;
                                for (UserInChannel userInChannel2 : list2) {
                                    i0.e.b.g3.k.x0.l lVar3 = new i0.e.b.g3.k.x0.l();
                                    lVar3.M(new Number[]{userInChannel2.getId()});
                                    lVar3.O(userInChannel2);
                                    lVar3.N(lVar2.C.a.contains(Integer.valueOf(userInChannel2.getId().intValue())) && lVar2.q);
                                    lVar3.L(new i0.e.b.g3.k.l(channelFragment5, userInChannel2));
                                    oVar6.add(lVar3);
                                }
                                if (!lVar2.p.m.isEmpty()) {
                                    o oVar7 = o.this;
                                    ChannelFragment channelFragment6 = channelFragment;
                                    i0.e.b.g3.k.x0.d dVar2 = new i0.e.b.g3.k.x0.d();
                                    dVar2.L("lurkers");
                                    dVar2.M(channelFragment6.getString(R.string.others_in_room));
                                    oVar7.add(dVar2);
                                }
                                List<UserInChannel> list3 = lVar2.p.m;
                                o oVar8 = o.this;
                                ChannelFragment channelFragment7 = channelFragment;
                                for (UserInChannel userInChannel3 : list3) {
                                    i0.e.b.g3.k.x0.l lVar4 = new i0.e.b.g3.k.x0.l();
                                    lVar4.M(new Number[]{userInChannel3.getId()});
                                    lVar4.O(userInChannel3);
                                    lVar4.N(lVar2.C.a.contains(Integer.valueOf(userInChannel3.getId().intValue())) && lVar2.q);
                                    lVar4.L(new n(channelFragment7, userInChannel3));
                                    oVar8.add(lVar4);
                                }
                                return m0.i.a;
                            }
                        });
                        return m0.i.a;
                    }
                });
                SpeakerStateDataSource speakerStateDataSource = S0().A;
                FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$12 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(speakerStateDataSource.b(speakerStateDataSource.b.b()), new ChannelFragment$onViewCreated$16(this, null));
                h0.q.p viewLifecycleOwner5 = getViewLifecycleOwner();
                i.d(viewLifecycleOwner5, "viewLifecycleOwner");
                m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$12, h0.q.q.a(viewLifecycleOwner5));
                h0.q.p viewLifecycleOwner6 = getViewLifecycleOwner();
                i.d(viewLifecycleOwner6, "viewLifecycleOwner");
                viewLifecycleOwner6.getLifecycle().a(new h0.q.o() { // from class: com.clubhouse.android.ui.channels.ChannelFragment$onViewCreated$$inlined$observeResume$1
                    @a0(Lifecycle.Event.ON_RESUME)
                    public final void onResume() {
                        ChannelFragment.this.S0().p(h0.a);
                    }
                });
                Q0().k.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.k.v
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        ChannelFragment channelFragment = ChannelFragment.this;
                        k<Object>[] kVarArr = ChannelFragment.Z1;
                        i.e(channelFragment, "this$0");
                        i.e(channelFragment, "<this>");
                        h0.t.i iVar = new h0.t.i(channelFragment.requireContext());
                        iVar.e(R.navigation.main_graph);
                        iVar.d(R.id.exploreFragment);
                        iVar.a().send();
                    }
                });
            }
        }
