package com.instabug.library.internal.storage.operation;
/* loaded from: classes2.dex */
public interface DiskOperationCallback<T> {
    void onFailure(Throwable th);

    void onSuccess(T t);
}
