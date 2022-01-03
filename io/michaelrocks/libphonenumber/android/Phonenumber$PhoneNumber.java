package io.michaelrocks.libphonenumber.android;

import i0.d.a.a.a;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class Phonenumber$PhoneNumber implements Serializable {
    public boolean Z1;
    public boolean b2;
    public boolean d2;
    public boolean f2;
    public boolean q;
    public boolean y;
    public int c = 0;
    public long d = 0;
    public String x = "";
    public boolean Y1 = false;
    public int a2 = 1;
    public String c2 = "";
    public String g2 = "";
    public CountryCodeSource e2 = CountryCodeSource.UNSPECIFIED;

    /* loaded from: classes4.dex */
    public enum CountryCodeSource {
        FROM_NUMBER_WITH_PLUS_SIGN,
        FROM_NUMBER_WITH_IDD,
        FROM_NUMBER_WITHOUT_PLUS_SIGN,
        FROM_DEFAULT_COUNTRY,
        UNSPECIFIED
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj instanceof Phonenumber$PhoneNumber) {
            Phonenumber$PhoneNumber phonenumber$PhoneNumber = (Phonenumber$PhoneNumber) obj;
            if (phonenumber$PhoneNumber != null && (this == phonenumber$PhoneNumber || (this.c == phonenumber$PhoneNumber.c && this.d == phonenumber$PhoneNumber.d && this.x.equals(phonenumber$PhoneNumber.x) && this.Y1 == phonenumber$PhoneNumber.Y1 && this.a2 == phonenumber$PhoneNumber.a2 && this.c2.equals(phonenumber$PhoneNumber.c2) && this.e2 == phonenumber$PhoneNumber.e2 && this.g2.equals(phonenumber$PhoneNumber.g2) && this.f2 == phonenumber$PhoneNumber.f2))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 1231;
        int F = a.F(this.g2, (this.e2.hashCode() + a.F(this.c2, (((a.F(this.x, (Long.valueOf(this.d).hashCode() + ((this.c + 2173) * 53)) * 53, 53) + (this.Y1 ? 1231 : 1237)) * 53) + this.a2) * 53, 53)) * 53, 53);
        if (!this.f2) {
            i = 1237;
        }
        return F + i;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder P0 = a.P0("Country Code: ");
        P0.append(this.c);
        P0.append(" National Number: ");
        P0.append(this.d);
        if (this.y && this.Y1) {
            P0.append(" Leading Zero(s): true");
        }
        if (this.Z1) {
            P0.append(" Number of leading zeros: ");
            P0.append(this.a2);
        }
        if (this.q) {
            P0.append(" Extension: ");
            P0.append(this.x);
        }
        if (this.d2) {
            P0.append(" Country Code Source: ");
            P0.append(this.e2);
        }
        if (this.f2) {
            P0.append(" Preferred Domestic Carrier Code: ");
            P0.append(this.g2);
        }
        return P0.toString();
    }
}
