package g0.a.a;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: ICustomTabsCallback.java */
/* loaded from: classes.dex */
public interface a extends IInterface {

    /* compiled from: ICustomTabsCallback.java */
    /* renamed from: g0.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0036a extends Binder implements a {
        public AbstractBinderC0036a() {
            attachInterface(this, "android.support.customtabs.ICustomTabsCallback");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 2:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                        parcel.readInt();
                        if (parcel.readInt() != 0) {
                            Bundle bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                        parcel.readString();
                        if (parcel.readInt() != 0) {
                            Bundle bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                        if (parcel.readInt() != 0) {
                            Bundle bundle3 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                        parcel.readString();
                        if (parcel.readInt() != 0) {
                            Bundle bundle4 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                        parcel.readInt();
                        if (parcel.readInt() != 0) {
                            Uri uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
                        }
                        parcel.readInt();
                        if (parcel.readInt() != 0) {
                            Bundle bundle5 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                        parcel.readString();
                        if (parcel.readInt() != 0) {
                            Bundle bundle6 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        parcel2.writeNoException();
                        parcel2.writeInt(0);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString("android.support.customtabs.ICustomTabsCallback");
                return true;
            }
        }
    }
}
