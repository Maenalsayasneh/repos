package i0.h.a.b.d;

import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.RecentlyNonNull;
/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
/* loaded from: classes2.dex */
public interface b extends IInterface {

    /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
    /* loaded from: classes2.dex */
    public static abstract class a extends i0.h.a.b.g.e.a implements b {

        /* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
        /* renamed from: i0.h.a.b.d.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0148a extends i0.h.a.b.g.e.b implements b {
            public C0148a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IObjectWrapper");
            }
        }

        public a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        @RecentlyNonNull
        public static b d0(@RecentlyNonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            if (queryLocalInterface instanceof b) {
                return (b) queryLocalInterface;
            }
            return new C0148a(iBinder);
        }
    }
}
