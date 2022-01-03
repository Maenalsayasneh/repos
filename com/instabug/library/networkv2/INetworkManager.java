package com.instabug.library.networkv2;

import com.instabug.library.network.RequestResponse;
import com.instabug.library.networkv2.request.Request;
/* loaded from: classes2.dex */
public interface INetworkManager {
    void doRequest(int i, Request request, Request.Callbacks<RequestResponse, Throwable> callbacks);
}
