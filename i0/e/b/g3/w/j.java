package i0.e.b.g3.w;

import android.view.View;
import com.clubhouse.android.ui.search.ExploreV2Fragment;
/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class j implements View.OnClickListener {
    public final /* synthetic */ ExploreV2Fragment c;

    public /* synthetic */ j(ExploreV2Fragment exploreV2Fragment) {
        this.c = exploreV2Fragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ExploreV2Fragment.PagingController.m21buildItemModel$lambda0(this.c, view);
    }
}
