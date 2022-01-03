package io.sentry;

import java.util.concurrent.Future;
/* loaded from: classes4.dex */
public interface ISentryExecutorService {
    void close(long j);

    Future<?> submit(Runnable runnable);
}
