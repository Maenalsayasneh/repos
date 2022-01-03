package com.instabug.library.internal.video;

import android.net.Uri;
/* loaded from: classes2.dex */
public class ScreenRecordingEvent {
    public static final int RECORDING_CANCELED = 3;
    public static final int RECORDING_ERROR = 4;
    public static final int RECORDING_FILE_READY = 2;
    public static final int RECORDING_FINISHED = 1;
    public static final int RECORDING_PERMISSION_DENIED = 0;
    private int status;
    private Uri videoUri;

    public ScreenRecordingEvent(int i, Uri uri) {
        this.status = i;
        this.videoUri = uri;
    }

    public int getStatus() {
        return this.status;
    }

    public Uri getVideoUri() {
        return this.videoUri;
    }
}
