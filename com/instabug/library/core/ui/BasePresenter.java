package com.instabug.library.core.ui;

import com.instabug.library.core.ui.BaseContract;
import com.instabug.library.core.ui.BaseContract.View;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public abstract class BasePresenter<V extends BaseContract.View> implements BaseContract.Presenter {
    public WeakReference<V> view;

    public BasePresenter(V v) {
        this.view = new WeakReference<>(v);
    }

    public void onDestroy() {
        this.view = null;
    }
}
