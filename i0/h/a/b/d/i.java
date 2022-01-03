package i0.h.a.b.d;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
/* loaded from: classes2.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ Context c;
    public final /* synthetic */ Intent d;

    public i(Context context, Intent intent) {
        this.c = context;
        this.d = intent;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            this.c.startActivity(this.d);
        } catch (ActivityNotFoundException e) {
            Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", e);
        }
    }
}
