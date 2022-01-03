package i0.f.a.b.j;

import com.fasterxml.jackson.core.JsonParseException;
import java.util.HashSet;
/* compiled from: DupDetector.java */
/* loaded from: classes2.dex */
public class b {
    public final Object a;
    public String b;
    public String c;
    public HashSet<String> d;

    public b(Object obj) {
        this.a = obj;
    }

    public b a() {
        return new b(this.a);
    }

    public boolean b(String str) throws JsonParseException {
        String str2 = this.b;
        if (str2 == null) {
            this.b = str;
            return false;
        } else if (str.equals(str2)) {
            return true;
        } else {
            String str3 = this.c;
            if (str3 == null) {
                this.c = str;
                return false;
            } else if (str.equals(str3)) {
                return true;
            } else {
                if (this.d == null) {
                    HashSet<String> hashSet = new HashSet<>(16);
                    this.d = hashSet;
                    hashSet.add(this.b);
                    this.d.add(this.c);
                }
                return !this.d.add(str);
            }
        }
    }

    public void c() {
        this.b = null;
        this.c = null;
        this.d = null;
    }
}
