package com.instabug.library.invocation.invocationdialog;

import android.net.Uri;
/* loaded from: classes2.dex */
public class InstabugDialogListener {
    private static InstabugDialogListener INSTANCE;
    private InstabugDialogCallbacks callbacks;

    /* loaded from: classes2.dex */
    public interface InstabugDialogCallbacks {
        void onClick(int i, String str, Uri uri);
    }

    private InstabugDialogListener() {
    }

    public static InstabugDialogListener getInstance() {
        InstabugDialogListener instabugDialogListener = INSTANCE;
        if (instabugDialogListener != null) {
            return instabugDialogListener;
        }
        InstabugDialogListener instabugDialogListener2 = new InstabugDialogListener();
        INSTANCE = instabugDialogListener2;
        return instabugDialogListener2;
    }

    public void onDialogItemClick(int i, String str, Uri uri) {
        InstabugDialogCallbacks instabugDialogCallbacks = this.callbacks;
        if (instabugDialogCallbacks != null) {
            instabugDialogCallbacks.onClick(i, str, uri);
        }
    }

    public void setListener(InstabugDialogCallbacks instabugDialogCallbacks) {
        this.callbacks = instabugDialogCallbacks;
    }
}
