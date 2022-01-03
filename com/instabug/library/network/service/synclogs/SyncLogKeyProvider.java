package com.instabug.library.network.service.synclogs;

import i0.j.e.v0.g.a.a;
/* loaded from: classes2.dex */
public class SyncLogKeyProvider implements a {
    static {
        try {
            System.loadLibrary("ibg-native");
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public static native String getNativeMatchingEmailPrefix();

    public static native String getNativeMatchingEmailSuffix();

    public static native String getNativeMatchingUuidPrefix();

    public static native String getNativeMatchingUuidSuffix();

    public static native String getNativeSyncingEmailPrefix();

    public static native String getNativeSyncingEmailSuffix();

    public static native String getNativeSyncingUuidPrefix();

    public static native String getNativeSyncingUuidSuffix();
}
