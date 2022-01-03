package io.sentry.android.core;
/* loaded from: classes4.dex */
public interface IHandler {
    Thread getThread();

    void post(Runnable runnable);
}
