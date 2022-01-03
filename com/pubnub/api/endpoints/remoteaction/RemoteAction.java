package com.pubnub.api.endpoints.remoteaction;

import com.pubnub.api.PubNubException;
import com.pubnub.api.callbacks.PNCallback;
/* loaded from: classes2.dex */
public interface RemoteAction<Output> {
    void async(PNCallback<Output> pNCallback);

    void retry();

    void silentCancel();

    Output sync() throws PubNubException;
}
