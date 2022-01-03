package i0.o.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* compiled from: Utils.java */
/* loaded from: classes3.dex */
public final class a0 extends Handler {
    public a0(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        sendMessageDelayed(obtainMessage(), 1000);
    }
}
