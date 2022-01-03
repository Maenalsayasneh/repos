package com.instabug.library.util;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class VideoManipulationUtils {
    private static final String TAG = "VideoManipulationUtils";

    public static Bitmap extractFirstVideoFrame(String str) throws IllegalArgumentException {
        return extractVideoFrame(str);
    }

    @SuppressLint({"RESOURCE_LEAK"})
    public static long extractVideoDuration(String str) throws IllegalArgumentException {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        long j = -1;
        try {
            mediaMetadataRetriever.setDataSource(str);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
            if (!TextUtils.isEmpty(extractMetadata)) {
                j = Long.parseLong(extractMetadata);
            }
        } catch (Exception e) {
            InstabugSDKLogger.e(TAG, e.getClass().getSimpleName(), e);
        } finally {
            mediaMetadataRetriever.release();
        }
        return j;
    }

    @SuppressLint({"RESOURCE_LEAK"})
    public static Bitmap extractVideoFrame(String str) throws IllegalArgumentException {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            return mediaMetadataRetriever.getFrameAtTime();
        } finally {
            mediaMetadataRetriever.release();
        }
    }
}
