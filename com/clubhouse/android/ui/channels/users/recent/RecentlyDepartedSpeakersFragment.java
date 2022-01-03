package com.clubhouse.android.ui.channels.users.recent;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.airbnb.epoxy.paging3.PagingDataEpoxyController;
import com.clubhouse.android.data.models.local.ReportTarget;
import com.clubhouse.android.data.models.local.channel.Channel;
import com.clubhouse.android.data.models.local.channel.UserInChannel;
import com.clubhouse.android.di.FragmentName;
import com.clubhouse.android.shared.ui.AbstractUserFragment;
import com.clubhouse.android.ui.channels.users.recent.RecentlyDepartedSpeakersFragment;
import com.clubhouse.android.ui.profile.reports.ReportIncidentSelectCategoryArgs;
import com.clubhouse.app.R;
import com.pubnub.api.endpoints.objects_api.utils.Include;
import h0.b0.v;
import h0.q.p;
import h0.q.q;
import i0.b.a.t;
import i0.b.b.i;
import i0.e.b.b3.b.e.d;
import i0.e.b.g3.k.w0.c.b;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import m0.n.b.m;
import m0.o.c;
import m0.r.k;
import m0.r.t.a.r.m.a1.a;
/* compiled from: RecentlyDepartedSpeakersFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001b\u0010\u000bJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000bR(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0014@\u0014X\u0094\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001d\u0010\u001a\u001a\u00020\u00158B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/clubhouse/android/ui/channels/users/recent/RecentlyDepartedSpeakersFragment;", "Lcom/clubhouse/android/shared/ui/AbstractUserFragment;", "Li0/e/b/b3/b/e/d;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "U0", "()V", "J", "Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;", "t2", "Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;", "T0", "()Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;", "setPagedController", "(Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;)V", "pagedController", "Lcom/clubhouse/android/ui/channels/users/recent/RecentlyDepartedSpeakersArgs;", "s2", "Lm0/o/c;", "getArgs", "()Lcom/clubhouse/android/ui/channels/users/recent/RecentlyDepartedSpeakersArgs;", "args", "<init>", "UserController", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class RecentlyDepartedSpeakersFragment extends AbstractUserFragment<d> {
    public static final /* synthetic */ k<Object>[] r2 = {m.c(new PropertyReference1Impl(m.a(RecentlyDepartedSpeakersFragment.class), "args", "getArgs()Lcom/clubhouse/android/ui/channels/users/recent/RecentlyDepartedSpeakersArgs;"))};
    public final c s2 = new i();
    public PagingDataEpoxyController<d> t2 = new UserController(this);

    /* compiled from: RecentlyDepartedSpeakersFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ%\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/clubhouse/android/ui/channels/users/recent/RecentlyDepartedSpeakersFragment$UserController;", "Lcom/airbnb/epoxy/paging3/PagingDataEpoxyController;", "Li0/e/b/b3/b/e/d;", "", "currentPosition", "item", "Li0/b/a/t;", "buildItemModel", "(ILi0/e/b/b3/b/e/d;)Li0/b/a/t;", "<init>", "(Lcom/clubhouse/android/ui/channels/users/recent/RecentlyDepartedSpeakersFragment;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public final class UserController extends PagingDataEpoxyController<d> {
        public final /* synthetic */ RecentlyDepartedSpeakersFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserController(RecentlyDepartedSpeakersFragment recentlyDepartedSpeakersFragment) {
            super(null, null, null, 7, null);
            m0.n.b.i.e(recentlyDepartedSpeakersFragment, "this$0");
            this.this$0 = recentlyDepartedSpeakersFragment;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: buildItemModel$lambda-0  reason: not valid java name */
        public static final void m5buildItemModel$lambda0(RecentlyDepartedSpeakersFragment recentlyDepartedSpeakersFragment, d dVar, View view) {
            m0.n.b.i.e(recentlyDepartedSpeakersFragment, "this$0");
            Fragment parentFragment = recentlyDepartedSpeakersFragment.getParentFragment();
            if (parentFragment != null) {
                UserInChannel userInChannel = dVar.g;
                Channel channel = RecentlyDepartedSpeakersFragment.X0(recentlyDepartedSpeakersFragment).d;
                Uri uri = RecentlyDepartedSpeakersFragment.X0(recentlyDepartedSpeakersFragment).q;
                m0.n.b.i.e(parentFragment, "<this>");
                m0.n.b.i.e(userInChannel, "user");
                m0.n.b.i.e(channel, Include.INCLUDE_CHANNEL_PARAM_VALUE);
                v.f(parentFragment, FragmentName.REPORT_INCIDENT_SELECT_CATEGORY, new ReportIncidentSelectCategoryArgs(userInChannel, channel.e(), channel, null, null, uri, ReportTarget.USER_SPOKEN, 24));
            }
            recentlyDepartedSpeakersFragment.dismiss();
        }

        public t<?> buildItemModel(int i, d dVar) {
            if (dVar != null) {
                i0.e.b.f3.m.b.c cVar = new i0.e.b.f3.m.b.c();
                cVar.t(dVar.g.getId());
                UserInChannel userInChannel = dVar.g;
                cVar.w();
                cVar.j = userInChannel;
                cVar.w();
                cVar.m = false;
                cVar.w();
                cVar.r = false;
                cVar.w();
                cVar.s = true;
                b bVar = new b(this.this$0, dVar);
                cVar.w();
                cVar.l = bVar;
                m0.n.b.i.d(cVar, "FollowableListUser_()\n                .id(item.user.id)\n                .user(item.user)\n                .showFollowButton(false)\n                .compactMode(false)\n                .hideBio(true)\n                .clickListener { _ ->\n                    parentFragment?.showReportChannelIncidentSelectCategoryFragment(\n                        item.user,\n                        args.channel,\n                        args.reportImageUri\n                    )\n                    dismiss()\n                }");
                return cVar;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    public static final RecentlyDepartedSpeakersArgs X0(RecentlyDepartedSpeakersFragment recentlyDepartedSpeakersFragment) {
        return (RecentlyDepartedSpeakersArgs) recentlyDepartedSpeakersFragment.s2.getValue(recentlyDepartedSpeakersFragment, r2[0]);
    }

    @Override // i0.b.b.q
    public void J() {
    }

    @Override // com.clubhouse.android.shared.ui.AbstractUserFragment
    public PagingDataEpoxyController<d> T0() {
        return this.t2;
    }

    @Override // com.clubhouse.android.shared.ui.AbstractUserFragment
    public void U0() {
        S0().j.post(new Runnable() { // from class: i0.e.b.g3.k.w0.c.a
            @Override // java.lang.Runnable
            public final void run() {
                RecentlyDepartedSpeakersFragment recentlyDepartedSpeakersFragment = RecentlyDepartedSpeakersFragment.this;
                k<Object>[] kVarArr = RecentlyDepartedSpeakersFragment.r2;
                m0.n.b.i.e(recentlyDepartedSpeakersFragment, "this$0");
                recentlyDepartedSpeakersFragment.S0().j.setLayoutManager(new LinearLayoutManager(recentlyDepartedSpeakersFragment.getContext(), 1, false));
                recentlyDepartedSpeakersFragment.S0().j.requestLayout();
            }
        });
    }

    @Override // com.clubhouse.android.shared.ui.AbstractUserFragment, com.clubhouse.android.core.ui.BaseBottomSheetFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m0.n.b.i.e(view, "view");
        super.onViewCreated(view, bundle);
        v.U1(this);
        LinearLayout linearLayout = S0().g;
        m0.n.b.i.d(linearLayout, "binding.root");
        linearLayout.setPadding(0, 0, 0, linearLayout.getPaddingBottom());
        FrameLayout frameLayout = S0().e.b;
        m0.n.b.i.d(frameLayout, "binding.grabHandle.grabHandleRoot");
        i0.e.b.d3.k.K(frameLayout);
        EditText editText = S0().h;
        m0.n.b.i.d(editText, "binding.search");
        i0.e.b.d3.k.p(editText);
        S0().i.setText(getString(R.string.recently_left_the_stage));
        TextView textView = S0().i;
        m0.n.b.i.d(textView, "binding.title");
        textView.setPadding(getResources().getDimensionPixelSize(R.dimen.user_grid_horizontal_margin), textView.getPaddingTop(), textView.getPaddingRight(), textView.getPaddingBottom());
        S0().j.setItemSpacingRes(R.dimen.list_item_spacing);
        S0().j.setController(this.t2);
        p viewLifecycleOwner = getViewLifecycleOwner();
        m0.n.b.i.d(viewLifecycleOwner, "viewLifecycleOwner");
        a.E2(q.a(viewLifecycleOwner), null, null, new RecentlyDepartedSpeakersFragment$onViewCreated$1(this, null), 3, null);
    }
}
