package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import h0.b0.v;
import i0.h.a.b.c.i.k;
import i0.h.a.b.c.p;
import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
/* loaded from: classes2.dex */
public class Feature extends AbstractSafeParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<Feature> CREATOR = new p();
    public final String c;
    @Deprecated
    public final int d;
    public final long q;

    public Feature(@RecentlyNonNull String str, long j) {
        this.c = str;
        this.q = j;
        this.d = -1;
    }

    public long I0() {
        long j = this.q;
        return j == -1 ? (long) this.d : j;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            String str = this.c;
            if (((str != null && str.equals(feature.c)) || (this.c == null && feature.c == null)) && I0() == feature.I0()) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.c, Long.valueOf(I0())});
    }

    @Override // java.lang.Object
    @RecentlyNonNull
    public String toString() {
        k kVar = new k(this, null);
        kVar.a("name", this.c);
        kVar.a("version", Long.valueOf(I0()));
        return kVar.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int G2 = v.G2(parcel, 20293);
        v.B2(parcel, 1, this.c, false);
        int i2 = this.d;
        v.J2(parcel, 2, 4);
        parcel.writeInt(i2);
        long I0 = I0();
        v.J2(parcel, 3, 8);
        parcel.writeLong(I0);
        v.L2(parcel, G2);
    }

    public Feature(@RecentlyNonNull String str, int i, long j) {
        this.c = str;
        this.d = i;
        this.q = j;
    }
}
