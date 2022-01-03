package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import h0.b0.v;
import i0.h.a.b.c.i.r0;
/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
/* loaded from: classes2.dex */
public class RootTelemetryConfiguration extends AbstractSafeParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new r0();
    public final int c;
    public final boolean d;
    public final boolean q;
    public final int x;
    public final int y;

    public RootTelemetryConfiguration(int i, boolean z, boolean z2, int i2, int i3) {
        this.c = i;
        this.d = z;
        this.q = z2;
        this.x = i2;
        this.y = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int G2 = v.G2(parcel, 20293);
        int i2 = this.c;
        v.J2(parcel, 1, 4);
        parcel.writeInt(i2);
        boolean z = this.d;
        v.J2(parcel, 2, 4);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.q;
        v.J2(parcel, 3, 4);
        parcel.writeInt(z2 ? 1 : 0);
        int i3 = this.x;
        v.J2(parcel, 4, 4);
        parcel.writeInt(i3);
        int i4 = this.y;
        v.J2(parcel, 5, 4);
        parcel.writeInt(i4);
        v.L2(parcel, G2);
    }
}
