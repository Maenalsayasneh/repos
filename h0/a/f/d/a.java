package h0.a.f.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
/* compiled from: ActivityResultContract.java */
/* loaded from: classes.dex */
public abstract class a<I, O> {

    /* compiled from: ActivityResultContract.java */
    /* renamed from: h0.a.f.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0043a<T> {
        @SuppressLint({"UnknownNullness"})
        public final T a;

        public C0043a(@SuppressLint({"UnknownNullness"}) T t) {
            this.a = t;
        }
    }

    public abstract Intent createIntent(Context context, @SuppressLint({"UnknownNullness"}) I i);

    public C0043a<O> getSynchronousResult(Context context, @SuppressLint({"UnknownNullness"}) I i) {
        return null;
    }

    @SuppressLint({"UnknownNullness"})
    public abstract O parseResult(int i, Intent intent);
}
