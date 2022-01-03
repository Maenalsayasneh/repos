package com.instabug.library.internal.storage;

import android.net.Uri;
/* loaded from: classes2.dex */
public class ProcessedUri {
    private final boolean isUriEncrypted;
    private final Uri uri;

    public ProcessedUri(Uri uri, boolean z) {
        this.uri = uri;
        this.isUriEncrypted = z;
    }

    public Uri getUri() {
        return this.uri;
    }

    public boolean isUriEncrypted() {
        return this.isUriEncrypted;
    }
}
