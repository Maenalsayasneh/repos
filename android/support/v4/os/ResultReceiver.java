package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import g0.a.b.c.a;
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new a();
    public g0.a.b.c.a c;

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<ResultReceiver> {
        @Override // android.os.Parcelable.Creator
        public ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ResultReceiver[] newArray(int i) {
            return new ResultReceiver[i];
        }
    }

    /* loaded from: classes.dex */
    public class b extends a.AbstractBinderC0040a {
        public b() {
        }
    }

    public ResultReceiver(Parcel parcel) {
        g0.a.b.c.a aVar;
        IBinder readStrongBinder = parcel.readStrongBinder();
        int i = a.AbstractBinderC0040a.a;
        if (readStrongBinder == null) {
            aVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof g0.a.b.c.a)) {
                aVar = new a.AbstractBinderC0040a.C0041a(readStrongBinder);
            } else {
                aVar = (g0.a.b.c.a) queryLocalInterface;
            }
        }
        this.c = aVar;
    }

    public void a(int i, Bundle bundle) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.c == null) {
                this.c = new b();
            }
            parcel.writeStrongBinder(this.c.asBinder());
        }
    }
}
