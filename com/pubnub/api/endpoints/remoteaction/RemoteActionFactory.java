package com.pubnub.api.endpoints.remoteaction;

import com.pubnub.api.PubNubException;
/* loaded from: classes2.dex */
public interface RemoteActionFactory<T, U> {
    RemoteAction<U> create(T t) throws PubNubException;
}
