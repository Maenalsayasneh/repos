package i0.h.a.d.a.e;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public final class g0 {
    public static final /* synthetic */ int a = 0;

    static {
        g0.class.getClassLoader();
    }

    public static <T extends Parcelable> T a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }
}
