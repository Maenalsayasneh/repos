package io.sentry;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class SentryExecutorService implements ISentryExecutorService {
    private final ExecutorService executorService;

    public SentryExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override // io.sentry.ISentryExecutorService
    public void close(long j) {
        synchronized (this.executorService) {
            if (!this.executorService.isShutdown()) {
                this.executorService.shutdown();
                try {
                    if (!this.executorService.awaitTermination(j, TimeUnit.MILLISECONDS)) {
                        this.executorService.shutdownNow();
                    }
                } catch (InterruptedException unused) {
                    this.executorService.shutdownNow();
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    @Override // io.sentry.ISentryExecutorService
    public Future<?> submit(Runnable runnable) {
        return this.executorService.submit(runnable);
    }

    public SentryExecutorService() {
        this(Executors.newSingleThreadExecutor());
    }
}
