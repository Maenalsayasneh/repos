package i0.h.a.b.b;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.stripe.android.model.Stripe3ds2AuthParams;
import i0.h.a.b.c.m.b;
import i0.h.a.b.m.g;
import i0.h.c.c;
import i0.h.c.t.e0;
import i0.h.c.t.o;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* loaded from: classes2.dex */
public abstract class a extends BroadcastReceiver {
    public final ExecutorService a;

    public a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new i0.h.a.b.c.m.f.a("firebase-iid-executor"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.a = Executors.unconfigurableExecutorService(threadPoolExecutor);
    }

    public final int a(Context context, Intent intent) {
        PendingIntent pendingIntent = (PendingIntent) intent.getParcelableExtra("pending_intent");
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                Log.e("CloudMessagingReceiver", "Notification pending intent canceled");
            }
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            extras.remove("pending_intent");
        } else {
            extras = new Bundle();
        }
        if ("com.google.firebase.messaging.NOTIFICATION_OPEN".equals(intent.getAction())) {
            Intent putExtras = new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN").putExtras(extras);
            if (!e0.c(putExtras)) {
                return -1;
            }
            if (putExtras != null) {
                if ("1".equals(putExtras.getStringExtra("google.c.a.tc"))) {
                    c b = c.b();
                    b.a();
                    i0.h.c.i.a.a aVar = (i0.h.c.i.a.a) b.g.a(i0.h.c.i.a.a.class);
                    if (Log.isLoggable("FirebaseMessaging", 3)) {
                        Log.d("FirebaseMessaging", "Received event with track-conversion=true. Setting user property and reengagement event");
                    }
                    if (aVar != null) {
                        String stringExtra = putExtras.getStringExtra("google.c.a.c_id");
                        aVar.b("fcm", "_ln", stringExtra);
                        Bundle bundle = new Bundle();
                        bundle.putString(Stripe3ds2AuthParams.FIELD_SOURCE, "Firebase");
                        bundle.putString("medium", "notification");
                        bundle.putString("campaign", stringExtra);
                        aVar.a("fcm", "_cmp", bundle);
                    } else {
                        Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
                    }
                } else if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Received event with track-conversion=false. Do not set user property");
                }
            }
            e0.b("_no", putExtras);
            return -1;
        } else if ("com.google.firebase.messaging.NOTIFICATION_DISMISS".equals(intent.getAction())) {
            Intent putExtras2 = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS").putExtras(extras);
            if (!e0.c(putExtras2)) {
                return -1;
            }
            e0.b("_nd", putExtras2);
            return -1;
        } else {
            Log.e("CloudMessagingReceiver", "Unknown notification action");
            return 500;
        }
    }

    public final int b(Context context, Intent intent) {
        g gVar;
        int i;
        int i2 = 500;
        if (intent.getExtras() == null) {
            return 500;
        }
        String stringExtra = intent.getStringExtra("google.message_id");
        if (TextUtils.isEmpty(stringExtra)) {
            gVar = b.H(null);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("google.message_id", stringExtra);
            f a = f.a(context);
            synchronized (a) {
                i = a.e;
                a.e = i + 1;
            }
            gVar = a.b(new o(i, bundle));
        }
        try {
            i2 = ((Integer) b.j(new o(context).b(new CloudMessage(intent).c))).intValue();
        } catch (InterruptedException | ExecutionException e) {
            Log.e("FirebaseMessaging", "Failed to send message to service.", e);
        }
        try {
            b.k(gVar, TimeUnit.SECONDS.toMillis(1), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(valueOf.length() + 20);
            sb.append("Message ack failed: ");
            sb.append(valueOf);
            Log.w("CloudMessagingReceiver", sb.toString());
        }
        return i2;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            this.a.execute(new Runnable(this, intent, context, isOrderedBroadcast(), goAsync()) { // from class: i0.h.a.b.b.e
                public final a c;
                public final Intent d;
                public final Context q;
                public final boolean x;
                public final BroadcastReceiver.PendingResult y;

                {
                    this.c = r1;
                    this.d = r2;
                    this.q = r3;
                    this.x = r4;
                    this.y = r5;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    int i;
                    a aVar = this.c;
                    Intent intent2 = this.d;
                    Context context2 = this.q;
                    boolean z = this.x;
                    BroadcastReceiver.PendingResult pendingResult = this.y;
                    Objects.requireNonNull(aVar);
                    try {
                        Parcelable parcelableExtra = intent2.getParcelableExtra("wrapped_intent");
                        Intent intent3 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
                        if (intent3 != null) {
                            i = aVar.a(context2, intent3);
                        } else {
                            i = aVar.b(context2, intent2);
                        }
                        if (z) {
                            pendingResult.setResultCode(i);
                        }
                    } finally {
                        pendingResult.finish();
                    }
                }
            });
        }
    }
}
