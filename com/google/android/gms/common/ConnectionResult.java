package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.model.StepType;
import h0.b0.v;
import i0.h.a.b.c.i.k;
import i0.h.a.b.c.o;
import java.util.Arrays;
/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
/* loaded from: classes2.dex */
public final class ConnectionResult extends AbstractSafeParcelable {
    public final int d;
    public final int q;
    public final PendingIntent x;
    public final String y;
    @RecentlyNonNull
    public static final ConnectionResult c = new ConnectionResult(0);
    @RecentlyNonNull
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new o();

    public ConnectionResult(int i) {
        this.d = 1;
        this.q = i;
        this.x = null;
        this.y = null;
    }

    public static String J0(int i) {
        if (i == 99) {
            return "UNFINISHED";
        }
        if (i == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i) {
            case -1:
                return StepType.UNKNOWN;
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    default:
                        StringBuilder sb = new StringBuilder(31);
                        sb.append("UNKNOWN_ERROR_CODE(");
                        sb.append(i);
                        sb.append(")");
                        return sb.toString();
                }
        }
    }

    public final boolean I0() {
        return this.q == 0;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.q == connectionResult.q && v.c0(this.x, connectionResult.x) && v.c0(this.y, connectionResult.y);
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.q), this.x, this.y});
    }

    @Override // java.lang.Object
    @RecentlyNonNull
    public final String toString() {
        k kVar = new k(this, null);
        kVar.a("statusCode", J0(this.q));
        kVar.a("resolution", this.x);
        kVar.a(InstabugDbContract.BugEntry.COLUMN_MESSAGE, this.y);
        return kVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int G2 = v.G2(parcel, 20293);
        int i2 = this.d;
        v.J2(parcel, 1, 4);
        parcel.writeInt(i2);
        int i3 = this.q;
        v.J2(parcel, 2, 4);
        parcel.writeInt(i3);
        v.A2(parcel, 3, this.x, i, false);
        v.B2(parcel, 4, this.y, false);
        v.L2(parcel, G2);
    }

    public ConnectionResult(int i, int i2, PendingIntent pendingIntent, String str) {
        this.d = i;
        this.q = i2;
        this.x = pendingIntent;
        this.y = str;
    }

    public ConnectionResult(int i, PendingIntent pendingIntent) {
        this.d = 1;
        this.q = i;
        this.x = pendingIntent;
        this.y = null;
    }
}
