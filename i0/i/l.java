package i0.i;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import java.lang.reflect.Field;
/* compiled from: CountryCodeDialog.java */
/* loaded from: classes2.dex */
public class l {
    public static final Field a;
    public static final Field b;
    public static final Field c;
    public static Dialog d;
    public static Context e;

    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    static {
        Field field;
        Field field2;
        Field field3;
        boolean z = true;
        try {
            field3 = TextView.class.getDeclaredField("mCursorDrawableRes");
        } catch (Exception unused) {
            field3 = null;
            field2 = null;
        }
        try {
            field3.setAccessible(true);
            field2 = TextView.class.getDeclaredField("mEditor");
            try {
                field2.setAccessible(true);
                field = field2.getType().getDeclaredField("mCursorDrawable");
                try {
                    field.setAccessible(true);
                    z = false;
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                field = null;
            }
        } catch (Exception unused4) {
            field2 = null;
            field = field2;
            if (!z) {
            }
        }
        if (!z) {
            a = null;
            b = null;
            c = null;
            return;
        }
        a = field2;
        b = field;
        c = field3;
    }

    public static void a(Context context) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus == null) {
                currentFocus = new View(activity);
            }
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }
}
