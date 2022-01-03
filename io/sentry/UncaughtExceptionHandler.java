package io.sentry;

import java.lang.Thread;
/* loaded from: classes4.dex */
public interface UncaughtExceptionHandler {

    /* loaded from: classes4.dex */
    public static final class Adapter implements UncaughtExceptionHandler {
        private static final Adapter INSTANCE = new Adapter();

        private Adapter() {
        }

        public static UncaughtExceptionHandler getInstance() {
            return INSTANCE;
        }

        @Override // io.sentry.UncaughtExceptionHandler
        public Thread.UncaughtExceptionHandler getDefaultUncaughtExceptionHandler() {
            return Thread.getDefaultUncaughtExceptionHandler();
        }

        @Override // io.sentry.UncaughtExceptionHandler
        public void setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
    }

    Thread.UncaughtExceptionHandler getDefaultUncaughtExceptionHandler();

    void setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler);
}
