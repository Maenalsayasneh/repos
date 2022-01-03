package com.clubhouse.android.ui.events;

import com.clubhouse.app.R;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import kotlin.Metadata;
/* compiled from: EventActionType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B1\b\u0002\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\t\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006j\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/clubhouse/android/ui/events/EventActionType;", "", "", InstabugDbContract.FeatureRequestEntry.COLUMN_TITLE, "I", "getTitle", "()I", "body", "getBody", "titleFull", "getTitleFull", "icon", "getIcon", "<init>", "(Ljava/lang/String;IIIII)V", "Share", "Tweet", "CopyLink", "AddToCal", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public enum EventActionType {
    Share(R.string.share, R.string.share, R.string.share, R.drawable.ic_share),
    Tweet(R.string.tweet, R.string.post_on_twitter, R.string.bring_your_tweeps, R.drawable.ic_tweet),
    CopyLink(R.string.copy_link, R.string.copy_link, R.string.reach_email_whatsapp, R.drawable.ic_copy_link),
    AddToCal(R.string.add_to_cal, R.string.add_to_calendar, R.string.bring_co_workers, R.drawable.ic_add_to_cal);
    
    private final int body;
    private final int icon;
    private final int title;
    private final int titleFull;

    EventActionType(int i, int i2, int i3, int i4) {
        this.title = i;
        this.titleFull = i2;
        this.body = i3;
        this.icon = i4;
    }

    public final int getBody() {
        return this.body;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final int getTitle() {
        return this.title;
    }

    public final int getTitleFull() {
        return this.titleFull;
    }
}
