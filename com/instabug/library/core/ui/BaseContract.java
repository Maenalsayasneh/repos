package com.instabug.library.core.ui;
/* loaded from: classes2.dex */
public interface BaseContract {

    /* loaded from: classes2.dex */
    public interface Presenter {
    }

    /* loaded from: classes2.dex */
    public interface View<C> {
        void finishActivity();

        C getViewContext();
    }
}
