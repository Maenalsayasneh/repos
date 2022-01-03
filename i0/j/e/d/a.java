package i0.j.e.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.instabug.library.util.InstabugSDKLogger;
/* compiled from: SDKInvokedBroadcast.java */
/* loaded from: classes2.dex */
public class a extends BroadcastReceiver {
    public AbstractC0190a a;

    /* compiled from: SDKInvokedBroadcast.java */
    /* renamed from: i0.j.e.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface AbstractC0190a {
        void onSDKInvoked(boolean z);
    }

    public a(AbstractC0190a aVar) {
        this.a = aVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        InstabugSDKLogger.d("SDKInvokedBroadcast", "onReceive");
        if (intent.getExtras() != null) {
            this.a.onSDKInvoked(intent.getExtras().getBoolean("SDK invoking state"));
        }
    }
}
