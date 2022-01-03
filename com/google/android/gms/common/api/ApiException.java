package com.google.android.gms.common.api;

import androidx.annotation.RecentlyNonNull;
/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
/* loaded from: classes2.dex */
public class ApiException extends Exception {
    @RecentlyNonNull
    @Deprecated
    public final Status c;

    /* JADX WARN: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public ApiException(@RecentlyNonNull Status status) {
        super(r3.toString());
        int i = status.a2;
        String str = status.b2;
        str = str == null ? "" : str;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13);
        sb.append(i);
        sb.append(": ");
        sb.append(str);
        this.c = status;
    }
}
