package io.agora.rtc.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class ThreadUtils {

    /* loaded from: classes4.dex */
    public interface BlockingOperation {
        void run() throws InterruptedException;
    }

    /* loaded from: classes4.dex */
    public static class ThreadChecker {
        private Thread thread = Thread.currentThread();

        public void checkIsOnValidThread() {
            if (this.thread == null) {
                this.thread = Thread.currentThread();
            }
            if (Thread.currentThread() != this.thread) {
                throw new IllegalStateException("Wrong thread");
            }
        }

        public void detachThread() {
            this.thread = null;
        }
    }

    public static void awaitUninterruptibly(final CountDownLatch countDownLatch) {
        executeUninterruptibly(new BlockingOperation() { // from class: io.agora.rtc.utils.ThreadUtils.2
            @Override // io.agora.rtc.utils.ThreadUtils.BlockingOperation
            public void run() throws InterruptedException {
                countDownLatch.await();
            }
        });
    }

    public static void checkIsOnMainThread() {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new IllegalStateException("Not on main thread!");
        }
    }

    public static StackTraceElement[] concatStackTraces(StackTraceElement[] stackTraceElementArr, StackTraceElement[] stackTraceElementArr2) {
        StackTraceElement[] stackTraceElementArr3 = new StackTraceElement[stackTraceElementArr.length + stackTraceElementArr2.length];
        System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr3, 0, stackTraceElementArr.length);
        System.arraycopy(stackTraceElementArr2, 0, stackTraceElementArr3, stackTraceElementArr.length, stackTraceElementArr2.length);
        return stackTraceElementArr3;
    }

    public static void executeUninterruptibly(BlockingOperation blockingOperation) {
        boolean z = false;
        while (true) {
            try {
                blockingOperation.run();
                break;
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public static <V> V invokeAtFrontUninterruptibly(Handler handler, final Callable<V> callable) {
        if (handler.getLooper().getThread() == Thread.currentThread()) {
            try {
                return callable.call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            final AnonymousClass1Result r02 = new Object() { // from class: io.agora.rtc.utils.ThreadUtils.1Result
                public V value;
            };
            final AnonymousClass1CaughtException r1 = new Object() { // from class: io.agora.rtc.utils.ThreadUtils.1CaughtException
                public Exception e;
            };
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            handler.post(new Runnable() { // from class: io.agora.rtc.utils.ThreadUtils.4
                /* JADX WARN: Type inference failed for: r1v2, types: [V, java.lang.Object] */
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AnonymousClass1Result.this.value = callable.call();
                    } catch (Exception e2) {
                        r1.e = e2;
                    }
                    countDownLatch.countDown();
                }
            });
            awaitUninterruptibly(countDownLatch);
            if (r1.e == null) {
                return r02.value;
            }
            RuntimeException runtimeException = new RuntimeException(r1.e);
            runtimeException.setStackTrace(concatStackTraces(r1.e.getStackTrace(), runtimeException.getStackTrace()));
            throw runtimeException;
        }
    }

    public static boolean joinUninterruptibly(Thread thread, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z = false;
        long j2 = j;
        while (j2 > 0) {
            try {
                thread.join(j2);
                break;
            } catch (InterruptedException unused) {
                j2 = j - (SystemClock.elapsedRealtime() - elapsedRealtime);
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return !thread.isAlive();
    }

    public static void waitUninterruptibly(final Object obj) {
        executeUninterruptibly(new BlockingOperation() { // from class: io.agora.rtc.utils.ThreadUtils.3
            @Override // io.agora.rtc.utils.ThreadUtils.BlockingOperation
            public void run() throws InterruptedException {
                obj.wait();
            }
        });
    }

    public static boolean awaitUninterruptibly(CountDownLatch countDownLatch, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean z = false;
        long j2 = j;
        boolean z2 = false;
        do {
            try {
                z = countDownLatch.await(j2, TimeUnit.MILLISECONDS);
                break;
            } catch (InterruptedException unused) {
                z2 = true;
                j2 = j - (SystemClock.elapsedRealtime() - elapsedRealtime);
                if (j2 <= 0) {
                }
            }
        } while (j2 <= 0);
        if (z2) {
            Thread.currentThread().interrupt();
        }
        return z;
    }

    public static void joinUninterruptibly(final Thread thread) {
        executeUninterruptibly(new BlockingOperation() { // from class: io.agora.rtc.utils.ThreadUtils.1
            @Override // io.agora.rtc.utils.ThreadUtils.BlockingOperation
            public void run() throws InterruptedException {
                thread.join();
            }
        });
    }

    public static void invokeAtFrontUninterruptibly(Handler handler, final Runnable runnable) {
        invokeAtFrontUninterruptibly(handler, new Callable<Void>() { // from class: io.agora.rtc.utils.ThreadUtils.5
            @Override // java.util.concurrent.Callable
            public Void call() {
                runnable.run();
                return null;
            }
        });
    }
}
