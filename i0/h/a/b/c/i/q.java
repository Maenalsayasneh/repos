package i0.h.a.b.c.i;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
/* loaded from: classes2.dex */
public abstract class q implements DialogInterface.OnClickListener {
    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            s sVar = (s) this;
            Intent intent = sVar.c;
            if (intent != null) {
                sVar.d.startActivityForResult(intent, sVar.q);
            }
        } catch (ActivityNotFoundException e) {
            String str = "Failed to start resolution intent.";
            if (Build.FINGERPRINT.contains("generic")) {
                str = str.concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
            }
            Log.e("DialogRedirect", str, e);
        } finally {
            dialogInterface.dismiss();
        }
    }
}
