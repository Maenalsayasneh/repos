package i0.h.a.b.b;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.cloudmessaging.zzp;
import h0.b0.v;
import i0.h.a.b.g.d.a;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* loaded from: classes2.dex */
public final class g implements ServiceConnection {
    public p c;
    public final /* synthetic */ f f;
    public int a = 0;
    public final Messenger b = new Messenger(new a(Looper.getMainLooper(), new Handler.Callback(this) { // from class: i0.h.a.b.b.j
        public final g a;

        {
            this.a = r1;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            g gVar = this.a;
            Objects.requireNonNull(gVar);
            int i = message.arg1;
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                StringBuilder sb = new StringBuilder(41);
                sb.append("Received response to request: ");
                sb.append(i);
                Log.d("MessengerIpcClient", sb.toString());
            }
            synchronized (gVar) {
                q<?> qVar = gVar.e.get(i);
                if (qVar == null) {
                    StringBuilder sb2 = new StringBuilder(50);
                    sb2.append("Received response for unknown request: ");
                    sb2.append(i);
                    Log.w("MessengerIpcClient", sb2.toString());
                    return true;
                }
                gVar.e.remove(i);
                gVar.c();
                Bundle data = message.getData();
                if (data.getBoolean("unsupported", false)) {
                    qVar.b(new zzp(4, "Not supported by GmsCore"));
                    return true;
                }
                qVar.a(data);
                return true;
            }
        }
    }));
    public final Queue<q<?>> d = new ArrayDeque();
    public final SparseArray<q<?>> e = new SparseArray<>();

    public g(f fVar, h hVar) {
        this.f = fVar;
    }

    public final synchronized void a(int i, String str) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(str);
            Log.d("MessengerIpcClient", valueOf.length() != 0 ? "Disconnected: ".concat(valueOf) : new String("Disconnected: "));
        }
        int i2 = this.a;
        if (i2 == 0) {
            throw new IllegalStateException();
        } else if (i2 == 1 || i2 == 2) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Unbinding service");
            }
            this.a = 4;
            i0.h.a.b.c.l.a.b().c(this.f.b, this);
            zzp zzp = new zzp(i, str);
            for (q<?> qVar : this.d) {
                qVar.b(zzp);
            }
            this.d.clear();
            for (int i3 = 0; i3 < this.e.size(); i3++) {
                this.e.valueAt(i3).b(zzp);
            }
            this.e.clear();
        } else if (i2 == 3) {
            this.a = 4;
        } else if (i2 != 4) {
            int i4 = this.a;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Unknown state: ");
            sb.append(i4);
            throw new IllegalStateException(sb.toString());
        }
    }

    public final synchronized boolean b(q<?> qVar) {
        int i = this.a;
        if (i == 0) {
            this.d.add(qVar);
            v.B(this.a == 0);
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Starting bind to GmsCore");
            }
            this.a = 1;
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            if (!i0.h.a.b.c.l.a.b().a(this.f.b, intent, this, 1)) {
                a(0, "Unable to bind to service");
            } else {
                this.f.c.schedule(new Runnable(this) { // from class: i0.h.a.b.b.i
                    public final g c;

                    {
                        this.c = r1;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        g gVar = this.c;
                        synchronized (gVar) {
                            if (gVar.a == 1) {
                                gVar.a(1, "Timed out while binding");
                            }
                        }
                    }
                }, 30, TimeUnit.SECONDS);
            }
            return true;
        } else if (i == 1) {
            this.d.add(qVar);
            return true;
        } else if (i != 2) {
            if (!(i == 3 || i == 4)) {
                int i2 = this.a;
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unknown state: ");
                sb.append(i2);
                throw new IllegalStateException(sb.toString());
            }
            return false;
        } else {
            this.d.add(qVar);
            this.f.c.execute(new k(this));
            return true;
        }
    }

    public final synchronized void c() {
        if (this.a == 2 && this.d.isEmpty() && this.e.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.a = 3;
            i0.h.a.b.c.l.a.b().c(this.f.b, this);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        this.f.c.execute(new Runnable(this, iBinder) { // from class: i0.h.a.b.b.l
            public final g c;
            public final IBinder d;

            {
                this.c = r1;
                this.d = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                g gVar = this.c;
                IBinder iBinder2 = this.d;
                synchronized (gVar) {
                    try {
                        if (iBinder2 == null) {
                            gVar.a(0, "Null service connection");
                            return;
                        }
                        try {
                            gVar.c = new p(iBinder2);
                            gVar.a = 2;
                            gVar.f.c.execute(new k(gVar));
                        } catch (RemoteException e) {
                            gVar.a(0, e.getMessage());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        this.f.c.execute(new Runnable(this) { // from class: i0.h.a.b.b.n
            public final g c;

            {
                this.c = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.c.a(2, "Service disconnected");
            }
        });
    }
}
