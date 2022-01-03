package com.stripe.android.view;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.util.Objects;
import kotlin.Metadata;
import m0.n.b.i;
/* compiled from: KeyboardController.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/view/KeyboardController;", "", "Lm0/i;", "hide$payments_core_release", "()V", "hide", "Landroid/app/Activity;", "activity", "Landroid/app/Activity;", "Landroid/view/inputmethod/InputMethodManager;", "inputMethodManager", "Landroid/view/inputmethod/InputMethodManager;", "<init>", "(Landroid/app/Activity;)V", "payments-core_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public final class KeyboardController {
    private final Activity activity;
    private final InputMethodManager inputMethodManager;

    public KeyboardController(Activity activity) {
        i.e(activity, "activity");
        this.activity = activity;
        Object systemService = activity.getSystemService("input_method");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        this.inputMethodManager = (InputMethodManager) systemService;
    }

    public final /* synthetic */ void hide$payments_core_release() {
        if (this.inputMethodManager.isAcceptingText()) {
            InputMethodManager inputMethodManager = this.inputMethodManager;
            View currentFocus = this.activity.getCurrentFocus();
            inputMethodManager.hideSoftInputFromWindow(currentFocus != null ? currentFocus.getWindowToken() : null, 0);
        }
    }
}
