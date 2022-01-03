package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import h0.b0.v;
import i0.d.a.a.a;
import i0.h.a.b.c.g.h;
import i0.h.a.b.c.g.m;
import i0.h.a.b.c.i.k;
import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
/* loaded from: classes2.dex */
public final class Status extends AbstractSafeParcelable implements h, ReflectedParcelable {
    public final int Z1;
    public final int a2;
    public final String b2;
    public final PendingIntent c2;
    public final ConnectionResult d2;
    @RecentlyNonNull
    public static final Status c = new Status(0, null);
    @RecentlyNonNull
    public static final Status d = new Status(14, null);
    @RecentlyNonNull
    public static final Status q = new Status(8, null);
    @RecentlyNonNull
    public static final Status x = new Status(15, null);
    @RecentlyNonNull
    public static final Status y = new Status(16, null);
    @RecentlyNonNull
    public static final Status Y1 = new Status(18, null);
    @RecentlyNonNull
    public static final Parcelable.Creator<Status> CREATOR = new m();

    static {
        new Status(17, null);
    }

    public Status(int i, int i2, String str, PendingIntent pendingIntent, ConnectionResult connectionResult) {
        this.Z1 = i;
        this.a2 = i2;
        this.b2 = str;
        this.c2 = pendingIntent;
        this.d2 = connectionResult;
    }

    public final boolean I0() {
        return this.a2 <= 0;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        if (this.Z1 != status.Z1 || this.a2 != status.a2 || !v.c0(this.b2, status.b2) || !v.c0(this.c2, status.c2) || !v.c0(this.d2, status.d2)) {
            return false;
        }
        return true;
    }

    @Override // i0.h.a.b.c.g.h
    @RecentlyNonNull
    public final Status getStatus() {
        return this;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.Z1), Integer.valueOf(this.a2), this.b2, this.c2, this.d2});
    }

    @Override // java.lang.Object
    @RecentlyNonNull
    public final String toString() {
        k kVar = new k(this, null);
        String str = this.b2;
        if (str == null) {
            int i = this.a2;
            switch (i) {
                case -1:
                    str = "SUCCESS_CACHE";
                    break;
                case 0:
                    str = "SUCCESS";
                    break;
                case 1:
                case 9:
                case 11:
                case 12:
                default:
                    str = a.Q(32, "unknown status code: ", i);
                    break;
                case 2:
                    str = "SERVICE_VERSION_UPDATE_REQUIRED";
                    break;
                case 3:
                    str = "SERVICE_DISABLED";
                    break;
                case 4:
                    str = "SIGN_IN_REQUIRED";
                    break;
                case 5:
                    str = "INVALID_ACCOUNT";
                    break;
                case 6:
                    str = "RESOLUTION_REQUIRED";
                    break;
                case 7:
                    str = "NETWORK_ERROR";
                    break;
                case 8:
                    str = "INTERNAL_ERROR";
                    break;
                case 10:
                    str = "DEVELOPER_ERROR";
                    break;
                case 13:
                    str = "ERROR";
                    break;
                case 14:
                    str = "INTERRUPTED";
                    break;
                case 15:
                    str = "TIMEOUT";
                    break;
                case 16:
                    str = "CANCELED";
                    break;
                case 17:
                    str = "API_NOT_CONNECTED";
                    break;
                case 18:
                    str = "DEAD_CLIENT";
                    break;
                case 19:
                    str = "REMOTE_EXCEPTION";
                    break;
                case 20:
                    str = "CONNECTION_SUSPENDED_DURING_CALL";
                    break;
                case 21:
                    str = "RECONNECTION_TIMED_OUT_DURING_UPDATE";
                    break;
                case 22:
                    str = "RECONNECTION_TIMED_OUT";
                    break;
            }
        }
        kVar.a("statusCode", str);
        kVar.a("resolution", this.c2);
        return kVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int G2 = v.G2(parcel, 20293);
        int i2 = this.a2;
        v.J2(parcel, 1, 4);
        parcel.writeInt(i2);
        v.B2(parcel, 2, this.b2, false);
        v.A2(parcel, 3, this.c2, i, false);
        v.A2(parcel, 4, this.d2, i, false);
        int i3 = this.Z1;
        v.J2(parcel, 1000, 4);
        parcel.writeInt(i3);
        v.L2(parcel, G2);
    }

    public Status(int i, String str) {
        this.Z1 = 1;
        this.a2 = i;
        this.b2 = str;
        this.c2 = null;
        this.d2 = null;
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this.Z1 = 1;
        this.a2 = i;
        this.b2 = str;
        this.c2 = null;
        this.d2 = null;
    }
}
