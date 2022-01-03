package i0.h.a.b.g.i;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class b {
    public static final /* synthetic */ int a = 0;

    static {
        b.class.getClassLoader();
    }

    public static <T extends Parcelable> T a(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }
}
