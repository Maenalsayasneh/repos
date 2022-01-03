package com.instabug.library.internal.storage;

import java.util.Arrays;
/* loaded from: classes2.dex */
public class ProcessedBytes {
    private final byte[] fileBytes;
    private final boolean isProcessSuccessful;

    public ProcessedBytes(byte[] bArr, boolean z) {
        this.fileBytes = Arrays.copyOf(bArr, bArr.length);
        this.isProcessSuccessful = z;
    }

    public byte[] getFileBytes() {
        byte[] bArr = this.fileBytes;
        return Arrays.copyOf(bArr, bArr.length);
    }

    public boolean isProcessSuccessful() {
        return this.isProcessSuccessful;
    }
}
