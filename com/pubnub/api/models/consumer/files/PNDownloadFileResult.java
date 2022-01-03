package com.pubnub.api.models.consumer.files;

import i0.d.a.a.a;
import java.io.InputStream;
import java.util.Objects;
import lombok.NonNull;
/* loaded from: classes2.dex */
public class PNDownloadFileResult {
    private final InputStream byteStream;
    @NonNull
    private final String fileName;

    public PNDownloadFileResult(@NonNull String str, InputStream inputStream) {
        Objects.requireNonNull(str, "fileName is marked @NonNull but is null");
        this.fileName = str;
        this.byteStream = inputStream;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof PNDownloadFileResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PNDownloadFileResult)) {
            return false;
        }
        PNDownloadFileResult pNDownloadFileResult = (PNDownloadFileResult) obj;
        if (!pNDownloadFileResult.canEqual(this)) {
            return false;
        }
        String fileName = getFileName();
        String fileName2 = pNDownloadFileResult.getFileName();
        if (fileName != null ? !fileName.equals(fileName2) : fileName2 != null) {
            return false;
        }
        InputStream byteStream = getByteStream();
        InputStream byteStream2 = pNDownloadFileResult.getByteStream();
        return byteStream != null ? byteStream.equals(byteStream2) : byteStream2 == null;
    }

    public InputStream getByteStream() {
        return this.byteStream;
    }

    @NonNull
    public String getFileName() {
        return this.fileName;
    }

    public int hashCode() {
        String fileName = getFileName();
        int i = 43;
        int hashCode = fileName == null ? 43 : fileName.hashCode();
        InputStream byteStream = getByteStream();
        int i2 = (hashCode + 59) * 59;
        if (byteStream != null) {
            i = byteStream.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        StringBuilder P0 = a.P0("PNDownloadFileResult(fileName=");
        P0.append(getFileName());
        P0.append(", byteStream=");
        P0.append(getByteStream());
        P0.append(")");
        return P0.toString();
    }
}
