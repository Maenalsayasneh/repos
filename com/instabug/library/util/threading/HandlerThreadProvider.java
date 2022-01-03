package com.instabug.library.util.threading;

import android.os.Handler;
import android.os.HandlerThread;
/* loaded from: classes2.dex */
public class HandlerThreadProvider {
    public static void run(String str, Runnable runnable) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        new Handler(handlerThread.getLooper()).post(runnable);
    }
}
