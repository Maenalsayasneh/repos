package com.instabug.library.internal;

import android.content.Intent;
/* loaded from: classes2.dex */
public class InstabugMediaProjectionIntent {
    private static Intent mediaProjectionIntent;
    private static int staticResultCode;

    public static Intent getMediaProjectionIntent() {
        return mediaProjectionIntent;
    }

    public static int getStaticResultCode() {
        return staticResultCode;
    }

    public static void release() {
        mediaProjectionIntent = null;
        staticResultCode = -1;
    }

    public static void setMediaProjectionIntent(Intent intent) {
        mediaProjectionIntent = intent;
    }

    public static void setStaticResultCode(int i) {
        staticResultCode = i;
    }
}
