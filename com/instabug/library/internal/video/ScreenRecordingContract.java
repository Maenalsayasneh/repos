package com.instabug.library.internal.video;

import android.net.Uri;
/* loaded from: classes2.dex */
public interface ScreenRecordingContract {
    void clear();

    void delete();

    Uri getAutoScreenRecordingFileUri();

    boolean isEnabled();
}
