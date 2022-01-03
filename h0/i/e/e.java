package h0.i.e;

import android.os.LocaleList;
import java.util.Locale;
/* compiled from: LocaleListPlatformWrapper.java */
/* loaded from: classes.dex */
public final class e implements d {
    public final LocaleList a;

    public e(LocaleList localeList) {
        this.a = localeList;
    }

    @Override // h0.i.e.d
    public String a() {
        return this.a.toLanguageTags();
    }

    @Override // h0.i.e.d
    public Object b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return this.a.equals(((d) obj).b());
    }

    @Override // h0.i.e.d
    public Locale get(int i) {
        return this.a.get(i);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // h0.i.e.d
    public int size() {
        return this.a.size();
    }

    public String toString() {
        return this.a.toString();
    }
}
