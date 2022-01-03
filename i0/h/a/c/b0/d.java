package i0.h.a.c.b0;

import android.text.InputFilter;
import android.text.Spanned;
/* compiled from: MaxInputValidator.java */
/* loaded from: classes2.dex */
public class d implements InputFilter {
    public int c;

    public d(int i) {
        this.c = i;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        try {
            StringBuilder sb = new StringBuilder(spanned);
            sb.replace(i3, i4, charSequence.subSequence(i, i2).toString());
            if (Integer.parseInt(sb.toString()) <= this.c) {
                return null;
            }
            return "";
        } catch (NumberFormatException unused) {
            return "";
        }
    }
}
