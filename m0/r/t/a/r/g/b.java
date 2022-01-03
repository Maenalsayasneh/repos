package m0.r.t.a.r.g;

import java.util.List;
import java.util.Objects;
/* compiled from: FqName.java */
/* loaded from: classes4.dex */
public final class b {
    public static final b a = new b("");
    public final c b;
    public transient b c;

    public b(String str) {
        if (str != null) {
            this.b = new c(str, this);
        } else {
            a(1);
            throw null;
        }
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 8:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                i2 = 2;
                break;
            case 8:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "fqName";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
            case 8:
                objArr[0] = "name";
                break;
            case 12:
                objArr[0] = "segment";
                break;
            case 13:
                objArr[0] = "shortName";
                break;
            default:
                objArr[0] = "names";
                break;
        }
        switch (i) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
                objArr[1] = "toUnsafe";
                break;
            case 6:
            case 7:
                objArr[1] = "parent";
                break;
            case 8:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqName";
                break;
            case 9:
                objArr[1] = "shortName";
                break;
            case 10:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 11:
                objArr[1] = "pathSegments";
                break;
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
                objArr[2] = "<init>";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                break;
            case 8:
                objArr[2] = "child";
                break;
            case 12:
                objArr[2] = "startsWith";
                break;
            case 13:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "fromSegments";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
                throw new IllegalStateException(format);
            case 8:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public static b k(d dVar) {
        if (dVar == null) {
            a(13);
            throw null;
        } else if (dVar != null) {
            return new b(new c(dVar.b(), a.j(), dVar));
        } else {
            c.a(16);
            throw null;
        }
    }

    public String b() {
        String b = this.b.b();
        if (b != null) {
            return b;
        }
        a(4);
        throw null;
    }

    public b c(d dVar) {
        if (dVar != null) {
            return new b(this.b.c(dVar), this);
        }
        a(8);
        throw null;
    }

    public boolean d() {
        return this.b.e();
    }

    public b e() {
        b bVar = this.c;
        if (bVar != null) {
            if (bVar != null) {
                return bVar;
            }
            a(6);
            throw null;
        } else if (!d()) {
            c cVar = this.b;
            c cVar2 = cVar.f;
            if (cVar2 == null) {
                if (!cVar.e()) {
                    cVar.d();
                    cVar2 = cVar.f;
                    if (cVar2 == null) {
                        c.a(8);
                        throw null;
                    }
                } else {
                    throw new IllegalStateException("root");
                }
            }
            b bVar2 = new b(cVar2);
            this.c = bVar2;
            if (bVar2 != null) {
                return bVar2;
            }
            a(7);
            throw null;
        } else {
            throw new IllegalStateException("root");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && this.b.equals(((b) obj).b);
    }

    public List<d> f() {
        List<d> g = this.b.g();
        if (g != null) {
            return g;
        }
        a(11);
        throw null;
    }

    public d g() {
        d h = this.b.h();
        if (h != null) {
            return h;
        }
        a(9);
        throw null;
    }

    public d h() {
        d dVar;
        c cVar = this.b;
        if (cVar.e()) {
            dVar = c.a;
            if (dVar == null) {
                c.a(12);
                throw null;
            }
        } else {
            dVar = cVar.h();
            if (dVar == null) {
                c.a(13);
                throw null;
            }
        }
        return dVar;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public boolean i(d dVar) {
        if (dVar != null) {
            c cVar = this.b;
            Objects.requireNonNull(cVar);
            if (dVar == null) {
                c.a(15);
                throw null;
            } else if (cVar.e()) {
                return false;
            } else {
                int indexOf = cVar.d.indexOf(46);
                String str = cVar.d;
                String b = dVar.b();
                if (indexOf == -1) {
                    indexOf = cVar.d.length();
                }
                return str.regionMatches(0, b, 0, indexOf);
            }
        } else {
            a(12);
            throw null;
        }
    }

    public c j() {
        c cVar = this.b;
        if (cVar != null) {
            return cVar;
        }
        a(5);
        throw null;
    }

    public String toString() {
        return this.b.toString();
    }

    public b(c cVar) {
        this.b = cVar;
    }

    public b(c cVar, b bVar) {
        this.b = cVar;
        this.c = bVar;
    }
}
