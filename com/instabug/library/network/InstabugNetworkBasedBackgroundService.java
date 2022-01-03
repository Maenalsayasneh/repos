package com.instabug.library.network;

import androidx.core.app.InstabugBackgroundService;
/* loaded from: classes2.dex */
public abstract class InstabugNetworkBasedBackgroundService extends InstabugBackgroundService {
    @Override // androidx.core.app.InstabugBackgroundService
    public boolean mustHaveNetworkConnection() {
        return true;
    }
}
