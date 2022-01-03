package com.instabug.library;

import com.google.android.gms.recaptcha.RecaptchaActionType;
/* loaded from: classes2.dex */
public interface OnSdkDismissCallback {

    /* loaded from: classes2.dex */
    public enum DismissType {
        SUBMIT,
        CANCEL,
        ADD_ATTACHMENT
    }

    /* loaded from: classes2.dex */
    public enum ReportType {
        BUG("bug"),
        FEEDBACK("feedback"),
        QUESTION("question"),
        OTHER(RecaptchaActionType.OTHER);
        
        private final String name;

        ReportType(String str) {
            this.name = str;
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return this.name;
        }
    }

    void call(DismissType dismissType, ReportType reportType);
}
