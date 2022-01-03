package q0;

import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.model.State;
import com.instabug.library.networkv2.request.RequestMethod;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Pair;
import kotlin.text.StringsKt__IndentKt;
import m0.j.g;
import m0.n.b.i;
import q0.h0.c;
import q0.h0.h.f;
import q0.v;
import q0.w;
/* compiled from: Request.kt */
/* loaded from: classes4.dex */
public final class b0 {
    public e a;
    public final w b;
    public final String c;
    public final v d;
    public final d0 e;
    public final Map<Class<?>, Object> f;

    public b0(w wVar, String str, v vVar, d0 d0Var, Map<Class<?>, ? extends Object> map) {
        i.e(wVar, "url");
        i.e(str, "method");
        i.e(vVar, InstabugDbContract.NetworkLogEntry.COLUMN_HEADERS);
        i.e(map, State.KEY_TAGS);
        this.b = wVar;
        this.c = str;
        this.d = vVar;
        this.e = d0Var;
        this.f = map;
    }

    public final e a() {
        e eVar = this.a;
        if (eVar != null) {
            return eVar;
        }
        e b = e.b.b(this.d);
        this.a = b;
        return b;
    }

    public final String b(String str) {
        i.e(str, "name");
        return this.d.b(str);
    }

    public String toString() {
        StringBuilder P0 = i0.d.a.a.a.P0("Request{method=");
        P0.append(this.c);
        P0.append(", url=");
        P0.append(this.b);
        if (this.d.size() != 0) {
            P0.append(", headers=[");
            int i = 0;
            for (Pair<? extends String, ? extends String> pair : this.d) {
                int i2 = i + 1;
                if (i >= 0) {
                    Pair<? extends String, ? extends String> pair2 = pair;
                    String str = (String) pair2.c;
                    String str2 = (String) pair2.d;
                    if (i > 0) {
                        P0.append(", ");
                    }
                    i0.d.a.a.a.r(P0, str, ':', str2);
                    i = i2;
                } else {
                    g.r0();
                    throw null;
                }
            }
            P0.append(']');
        }
        if (!this.f.isEmpty()) {
            P0.append(", tags=");
            P0.append(this.f);
        }
        P0.append('}');
        String sb = P0.toString();
        i.d(sb, "StringBuilder().apply(builderAction).toString()");
        return sb;
    }

    /* compiled from: Request.kt */
    /* loaded from: classes4.dex */
    public static class a {
        public w a;
        public String b;
        public v.a c;
        public d0 d;
        public Map<Class<?>, Object> e;

        public a() {
            this.e = new LinkedHashMap();
            this.b = RequestMethod.GET;
            this.c = new v.a();
        }

        public a a(String str, String str2) {
            i.e(str, "name");
            i.e(str2, InstabugDbContract.UserAttributesEntry.COLUMN_VALUE);
            this.c.a(str, str2);
            return this;
        }

        public b0 b() {
            Map map;
            w wVar = this.a;
            if (wVar != null) {
                String str = this.b;
                v d = this.c.d();
                d0 d0Var = this.d;
                Map<Class<?>, Object> map2 = this.e;
                byte[] bArr = c.a;
                i.e(map2, "$this$toImmutableMap");
                if (map2.isEmpty()) {
                    map = g.o();
                } else {
                    map = Collections.unmodifiableMap(new LinkedHashMap(map2));
                    i.d(map, "Collections.unmodifiableMap(LinkedHashMap(this))");
                }
                return new b0(wVar, str, d, d0Var, map);
            }
            throw new IllegalStateException("url == null".toString());
        }

        public a c(String str, String str2) {
            i.e(str, "name");
            i.e(str2, InstabugDbContract.UserAttributesEntry.COLUMN_VALUE);
            v.a aVar = this.c;
            Objects.requireNonNull(aVar);
            i.e(str, "name");
            i.e(str2, InstabugDbContract.UserAttributesEntry.COLUMN_VALUE);
            v.b bVar = v.c;
            bVar.a(str);
            bVar.b(str2, str);
            aVar.f(str);
            aVar.c(str, str2);
            return this;
        }

        public a d(v vVar) {
            i.e(vVar, InstabugDbContract.NetworkLogEntry.COLUMN_HEADERS);
            this.c = vVar.j();
            return this;
        }

        public a e(String str, d0 d0Var) {
            i.e(str, "method");
            boolean z = false;
            if (str.length() > 0) {
                if (d0Var == null) {
                    i.e(str, "method");
                    if (i.a(str, RequestMethod.POST) || i.a(str, RequestMethod.PUT) || i.a(str, "PATCH") || i.a(str, "PROPPATCH") || i.a(str, "REPORT")) {
                        z = true;
                    }
                    if (!(!z)) {
                        throw new IllegalArgumentException(i0.d.a.a.a.o0("method ", str, " must have a request body.").toString());
                    }
                } else if (!f.a(str)) {
                    throw new IllegalArgumentException(i0.d.a.a.a.o0("method ", str, " must not have a request body.").toString());
                }
                this.b = str;
                this.d = d0Var;
                return this;
            }
            throw new IllegalArgumentException("method.isEmpty() == true".toString());
        }

        public a f(String str) {
            i.e(str, "name");
            this.c.f(str);
            return this;
        }

        public <T> a g(Class<? super T> cls, T t) {
            i.e(cls, "type");
            if (t == null) {
                this.e.remove(cls);
            } else {
                if (this.e.isEmpty()) {
                    this.e = new LinkedHashMap();
                }
                Map<Class<?>, Object> map = this.e;
                Object cast = cls.cast(t);
                i.c(cast);
                map.put(cls, cast);
            }
            return this;
        }

        public a h(String str) {
            i.e(str, "url");
            if (StringsKt__IndentKt.G(str, "ws:", true)) {
                StringBuilder P0 = i0.d.a.a.a.P0("http:");
                String substring = str.substring(3);
                i.d(substring, "(this as java.lang.String).substring(startIndex)");
                P0.append(substring);
                str = P0.toString();
            } else if (StringsKt__IndentKt.G(str, "wss:", true)) {
                StringBuilder P02 = i0.d.a.a.a.P0("https:");
                String substring2 = str.substring(4);
                i.d(substring2, "(this as java.lang.String).substring(startIndex)");
                P02.append(substring2);
                str = P02.toString();
            }
            i.e(str, "$this$toHttpUrl");
            w.a aVar = new w.a();
            aVar.d(null, str);
            i(aVar.b());
            return this;
        }

        public a i(w wVar) {
            i.e(wVar, "url");
            this.a = wVar;
            return this;
        }

        public a(b0 b0Var) {
            Map<Class<?>, Object> map;
            i.e(b0Var, InstabugDbContract.NetworkLogEntry.COLUMN_REQUEST);
            this.e = new LinkedHashMap();
            this.a = b0Var.b;
            this.b = b0Var.c;
            this.d = b0Var.e;
            if (b0Var.f.isEmpty()) {
                map = new LinkedHashMap<>();
            } else {
                map = g.B0(b0Var.f);
            }
            this.e = map;
            this.c = b0Var.d.j();
        }
    }
}
