package com.pubnub.api.callbacks;

import com.pubnub.api.models.consumer.PNStatus;
/* loaded from: classes2.dex */
public interface PNCallback<X> {
    void onResponse(X x, PNStatus pNStatus);
}
