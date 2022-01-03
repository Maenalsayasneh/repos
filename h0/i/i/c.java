package h0.i.i;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import com.stripe.android.model.Stripe3ds2AuthParams;
import java.util.Locale;
import java.util.Objects;
/* compiled from: ContentInfoCompat.java */
/* loaded from: classes.dex */
public final class c {
    public final ClipData a;
    public final int b;
    public final int c;
    public final Uri d;
    public final Bundle e;

    /* compiled from: ContentInfoCompat.java */
    /* loaded from: classes.dex */
    public static final class a {
        public ClipData a;
        public int b;
        public int c;
        public Uri d;
        public Bundle e;

        public a(ClipData clipData, int i) {
            this.a = clipData;
            this.b = i;
        }
    }

    public c(a aVar) {
        ClipData clipData = aVar.a;
        Objects.requireNonNull(clipData);
        this.a = clipData;
        int i = aVar.b;
        if (i < 0) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", Stripe3ds2AuthParams.FIELD_SOURCE, 0, 3));
        } else if (i <= 3) {
            this.b = i;
            int i2 = aVar.c;
            if ((i2 & 1) == i2) {
                this.c = i2;
                this.d = aVar.d;
                this.e = aVar.e;
                return;
            }
            StringBuilder P0 = i0.d.a.a.a.P0("Requested flags 0x");
            P0.append(Integer.toHexString(i2));
            P0.append(", but only 0x");
            P0.append(Integer.toHexString(1));
            P0.append(" are allowed");
            throw new IllegalArgumentException(P0.toString());
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", Stripe3ds2AuthParams.FIELD_SOURCE, 0, 3));
        }
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder P0 = i0.d.a.a.a.P0("ContentInfoCompat{clip=");
        P0.append(this.a.getDescription());
        P0.append(", source=");
        int i = this.b;
        P0.append(i != 0 ? i != 1 ? i != 2 ? i != 3 ? String.valueOf(i) : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP");
        P0.append(", flags=");
        int i2 = this.c;
        if ((i2 & 1) != 0) {
            str = "FLAG_CONVERT_TO_PLAIN_TEXT";
        } else {
            str = String.valueOf(i2);
        }
        P0.append(str);
        String str3 = "";
        if (this.d == null) {
            str2 = str3;
        } else {
            StringBuilder P02 = i0.d.a.a.a.P0(", hasLinkUri(");
            P02.append(this.d.toString().length());
            P02.append(")");
            str2 = P02.toString();
        }
        P0.append(str2);
        if (this.e != null) {
            str3 = ", hasExtras";
        }
        return i0.d.a.a.a.y0(P0, str3, "}");
    }
}
