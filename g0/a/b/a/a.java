package g0.a.b.a;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* compiled from: INotificationSideChannel.java */
/* loaded from: classes.dex */
public interface a extends IInterface {

    /* compiled from: INotificationSideChannel.java */
    /* renamed from: g0.a.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0038a extends Binder implements a {
        public static final /* synthetic */ int a = 0;

        /* compiled from: INotificationSideChannel.java */
        /* renamed from: g0.a.b.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0039a implements a {
            public IBinder a;

            public C0039a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }

            @Override // g0.a.b.a.a
            public void i0(String str, int i, String str2, Notification notification) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.a.transact(1, obtain, null, 1)) {
                        int i2 = AbstractBinderC0038a.a;
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }
    }

    void i0(String str, int i, String str2, Notification notification) throws RemoteException;
}
