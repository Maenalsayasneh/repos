package com.sinch.verification.utils.permission;

import kotlin.NoWhenBranchMatchedException;
/* compiled from: Permission.kt */
/* loaded from: classes3.dex */
public enum Permission {
    ACCESS_NETWORK_STATE,
    CHANGE_NETWORK_STATE,
    READ_PHONE_STATE,
    READ_CALL_LOG,
    CALL_PHONE,
    READ_SMS,
    RECEIVE_SMS,
    ACCESS_COARSE_LOCATION,
    ACCESS_FINE_LOCATION;

    public final String getAndroidValue() {
        switch (ordinal()) {
            case 0:
                return "android.permission.ACCESS_NETWORK_STATE";
            case 1:
                return "android.permission.CHANGE_NETWORK_STATE";
            case 2:
                return "android.permission.READ_PHONE_STATE";
            case 3:
                return "android.permission.READ_CALL_LOG";
            case 4:
                return "android.permission.CALL_PHONE";
            case 5:
                return "android.permission.READ_SMS";
            case 6:
                return "android.permission.RECEIVE_SMS";
            case 7:
                return "android.permission.ACCESS_COARSE_LOCATION";
            case 8:
                return "android.permission.ACCESS_FINE_LOCATION";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
