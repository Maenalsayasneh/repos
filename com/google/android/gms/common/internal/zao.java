package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import h0.b0.v;
import i0.h.a.b.c.i.w;
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
/* loaded from: classes2.dex */
public final class zao extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zao> CREATOR = new w();
    public final int c;
    public final int d;
    public final int q;
    public final long x;
    public final long y;

    public zao(int i, int i2, int i3, long j, long j2) {
        this.c = i;
        this.d = i2;
        this.q = i3;
        this.x = j;
        this.y = j2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int G2 = v.G2(parcel, 20293);
        int i2 = this.c;
        v.J2(parcel, 1, 4);
        parcel.writeInt(i2);
        int i3 = this.d;
        v.J2(parcel, 2, 4);
        parcel.writeInt(i3);
        int i4 = this.q;
        v.J2(parcel, 3, 4);
        parcel.writeInt(i4);
        long j = this.x;
        v.J2(parcel, 4, 8);
        parcel.writeLong(j);
        long j2 = this.y;
        v.J2(parcel, 5, 8);
        parcel.writeLong(j2);
        v.L2(parcel, G2);
    }
}
