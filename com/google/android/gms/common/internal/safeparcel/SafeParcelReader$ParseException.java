package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcel;
import androidx.annotation.RecentlyNonNull;
/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
/* loaded from: classes2.dex */
public class SafeParcelReader$ParseException extends RuntimeException {
    /* JADX WARN: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public SafeParcelReader$ParseException(@RecentlyNonNull String str, @RecentlyNonNull Parcel parcel) {
        super(r2.toString());
        int dataPosition = parcel.dataPosition();
        int dataSize = parcel.dataSize();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 41);
        sb.append(str);
        sb.append(" Parcel: pos=");
        sb.append(dataPosition);
        sb.append(" size=");
        sb.append(dataSize);
    }
}
