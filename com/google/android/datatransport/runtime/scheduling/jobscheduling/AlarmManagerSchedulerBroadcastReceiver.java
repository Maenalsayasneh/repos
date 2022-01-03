package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import i0.h.a.a.i.b;
import i0.h.a.a.i.h;
import i0.h.a.a.i.m;
import i0.h.a.a.i.s.h.f;
import i0.h.a.a.i.s.h.k;
import i0.h.a.a.i.v.a;
/* loaded from: classes2.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {
    public static final /* synthetic */ int a = 0;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter(NotificationCompat.MessagingStyle.Message.KEY_EXTRAS_BUNDLE);
        int intValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i = intent.getExtras().getInt("attemptNumber");
        m.b(context);
        h.a a2 = h.a();
        a2.b(queryParameter);
        a2.c(a.b(intValue));
        if (queryParameter2 != null) {
            ((b.C0137b) a2).b = Base64.decode(queryParameter2, 0);
        }
        k kVar = m.a().e;
        kVar.e.execute(new f(kVar, a2.a(), i, i0.h.a.a.i.s.h.a.c));
    }
}
