package com.instabug.library.internal.storage.operation;

import java.io.IOException;
/* loaded from: classes2.dex */
public interface DiskOperation<T, N> {
    T execute(N n) throws IOException;

    void executeAsync(N n, DiskOperationCallback<T> diskOperationCallback);
}
