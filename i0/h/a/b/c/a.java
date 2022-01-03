package i0.h.a.b.c;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
/* compiled from: com.google.android.gms:play-services-base@@17.5.0 */
/* loaded from: classes2.dex */
public class a extends DialogFragment {
    public Dialog c;
    public DialogInterface.OnCancelListener d;
    public Dialog q;

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@RecentlyNonNull DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.d;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = this.c;
        if (dialog != null) {
            return dialog;
        }
        setShowsDialog(false);
        if (this.q == null) {
            this.q = new AlertDialog.Builder(getActivity()).create();
        }
        return this.q;
    }

    @Override // android.app.DialogFragment
    public void show(@RecentlyNonNull FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
    }
}
