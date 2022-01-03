package com.instabug.bug.settings;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class AttachmentsTypesParams implements Serializable {
    private boolean allowAttachImageFromGallery;
    private boolean allowScreenRecording;
    private boolean allowTakeExtraScreenshot;
    private boolean shouldTakesInitialScreenshot;

    public AttachmentsTypesParams() {
        this.shouldTakesInitialScreenshot = true;
        this.allowTakeExtraScreenshot = true;
        this.allowAttachImageFromGallery = true;
        this.allowScreenRecording = true;
    }

    public boolean isAllowAttachImageFromGallery() {
        return this.allowAttachImageFromGallery;
    }

    public boolean isAllowScreenRecording() {
        return this.allowScreenRecording;
    }

    public boolean isAllowTakeExtraScreenshot() {
        return this.allowTakeExtraScreenshot;
    }

    public boolean isShouldTakesInitialScreenshot() {
        return this.shouldTakesInitialScreenshot;
    }

    public AttachmentsTypesParams setAllowAttachImageFromGallery(boolean z) {
        this.allowAttachImageFromGallery = z;
        return this;
    }

    public AttachmentsTypesParams setAllowScreenRecording(boolean z) {
        this.allowScreenRecording = z;
        return this;
    }

    public AttachmentsTypesParams setAllowTakeExtraScreenshot(boolean z) {
        this.allowTakeExtraScreenshot = z;
        return this;
    }

    public AttachmentsTypesParams setShouldTakesInitialScreenshot(boolean z) {
        this.shouldTakesInitialScreenshot = z;
        return this;
    }

    @Override // java.lang.Object
    public String toString() {
        return this.shouldTakesInitialScreenshot + ", " + this.allowTakeExtraScreenshot + ", " + this.allowAttachImageFromGallery + ", " + this.allowScreenRecording;
    }

    public AttachmentsTypesParams(boolean z, boolean z2, boolean z3, boolean z4) {
        this.shouldTakesInitialScreenshot = z;
        this.allowTakeExtraScreenshot = z2;
        this.allowAttachImageFromGallery = z3;
        this.allowScreenRecording = z4;
    }
}
