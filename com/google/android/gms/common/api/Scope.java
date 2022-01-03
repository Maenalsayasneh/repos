package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import h0.b0.v;
import i0.h.a.b.c.g.l;
/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
/* loaded from: classes2.dex */
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<Scope> CREATOR = new l();
    public final int c;
    public final String d;

    public Scope(int i, String str) {
        v.y(str, "scopeUri must not be null or empty");
        this.c = i;
        this.d = str;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.d.equals(((Scope) obj).d);
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return this.d.hashCode();
    }

    @Override // java.lang.Object
    @RecentlyNonNull
    public final String toString() {
        return this.d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int G2 = v.G2(parcel, 20293);
        int i2 = this.c;
        v.J2(parcel, 1, 4);
        parcel.writeInt(i2);
        v.B2(parcel, 2, this.d, false);
        v.L2(parcel, G2);
    }

    public Scope(@RecentlyNonNull String str) {
        v.y(str, "scopeUri must not be null or empty");
        this.c = 1;
        this.d = str;
    }
}
