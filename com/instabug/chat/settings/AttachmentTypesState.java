package com.instabug.chat.settings;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class AttachmentTypesState implements Serializable {
    private boolean imageFromGalleryEnabled;
    private boolean screenRecordingEnabled;
    private boolean screenshotEnabled;

    public AttachmentTypesState() {
        this.screenshotEnabled = true;
        this.imageFromGalleryEnabled = true;
        this.screenRecordingEnabled = true;
    }

    public boolean isImageFromGalleryEnabled() {
        return this.imageFromGalleryEnabled;
    }

    public boolean isScreenRecordingEnabled() {
        return this.screenRecordingEnabled;
    }

    public boolean isScreenshotEnabled() {
        return this.screenshotEnabled;
    }

    public AttachmentTypesState setImageFromGalleryEnabled(boolean z) {
        this.imageFromGalleryEnabled = z;
        return this;
    }

    public AttachmentTypesState setScreenRecordingEnabled(boolean z) {
        this.screenRecordingEnabled = z;
        return this;
    }

    public AttachmentTypesState setScreenshotEnabled(boolean z) {
        this.screenshotEnabled = z;
        return this;
    }

    @Override // java.lang.Object
    public String toString() {
        return this.screenshotEnabled + ", " + this.imageFromGalleryEnabled + ", " + this.screenRecordingEnabled;
    }

    public AttachmentTypesState(boolean z, boolean z2, boolean z3) {
        this.screenshotEnabled = z;
        this.imageFromGalleryEnabled = z2;
        this.screenRecordingEnabled = z3;
    }
}
