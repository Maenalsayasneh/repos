package i0.f.a.c;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.impl.FailingSerializer;
import com.fasterxml.jackson.databind.ser.impl.UnknownSerializer;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;
import com.fasterxml.jackson.databind.ser.std.StdDelegatingSerializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import i0.f.a.c.n.a;
import i0.f.a.c.n.j;
import i0.f.a.c.r.g;
import i0.f.a.c.r.h;
import i0.f.a.c.r.k.c;
import i0.f.a.c.r.k.d;
import i0.f.a.c.r.k.e;
import i0.f.a.c.t.f;
import i0.f.a.c.t.t;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Map;
import java.util.Objects;
/* compiled from: SerializerProvider.java */
/* loaded from: classes2.dex */
public abstract class i extends c {
    public static final g<Object> c = new FailingSerializer("Null key for a Map not allowed in JSON (use a converting NullKeySerializer?)");
    public static final g<Object> d = new UnknownSerializer();
    public final h Y1;
    public transient ContextAttributes Z1;
    public g<Object> a2;
    public g<Object> b2;
    public g<Object> c2;
    public g<Object> d2;
    public final c e2;
    public DateFormat f2;
    public final boolean g2;
    public final SerializationConfig q;
    public final Class<?> x;
    public final i0.f.a.c.r.i y;

    public i() {
        this.a2 = d;
        this.c2 = NullSerializer.q;
        this.d2 = c;
        this.q = null;
        this.y = null;
        this.Y1 = new h();
        this.e2 = null;
        this.x = null;
        this.Z1 = null;
        this.g2 = true;
    }

    public g<Object> A(JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        g<Object> a = this.e2.a(javaType);
        if (a == null && (a = this.Y1.a(javaType)) == null && (a = q(javaType)) == null) {
            return R(javaType.c);
        }
        return U(a, beanProperty);
    }

    public g<Object> C(Class<?> cls, BeanProperty beanProperty) throws JsonMappingException {
        g<Object> b = this.e2.b(cls);
        if (b == null && (b = this.Y1.b(cls)) == null && (b = this.Y1.a(this.q.d.d.b(null, cls, TypeFactory.q))) == null && (b = v(cls)) == null) {
            return R(cls);
        }
        return U(b, beanProperty);
    }

    public g<Object> E(JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        g<Object> a = this.y.a(this, javaType, this.b2);
        if (a instanceof g) {
            ((g) a).b(this);
        }
        return U(a, beanProperty);
    }

    public abstract e F(Object obj, ObjectIdGenerator<?> objectIdGenerator);

    public g<Object> G(JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        g<Object> a = this.e2.a(javaType);
        if (a == null && (a = this.Y1.a(javaType)) == null && (a = q(javaType)) == null) {
            return R(javaType.c);
        }
        return T(a, beanProperty);
    }

    public g<Object> H(Class<?> cls, BeanProperty beanProperty) throws JsonMappingException {
        g<Object> b = this.e2.b(cls);
        if (b == null && (b = this.Y1.b(cls)) == null && (b = this.Y1.a(this.q.d.d.b(null, cls, TypeFactory.q))) == null && (b = v(cls)) == null) {
            return R(cls);
        }
        return T(b, beanProperty);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public g<Object> I(Class<?> cls, boolean z, BeanProperty beanProperty) throws JsonMappingException {
        g<Object> gVar;
        g<Object> gVar2;
        boolean z2;
        c cVar = this.e2;
        c.a aVar = cVar.a[cVar.b & (cls.getName().hashCode() + 1)];
        if (aVar != null) {
            if (aVar.c == cls && aVar.e) {
                gVar = aVar.a;
            } else {
                do {
                    aVar = aVar.b;
                    if (aVar != null) {
                        if (aVar.c != cls || !aVar.e) {
                            z2 = false;
                            continue;
                        } else {
                            z2 = true;
                            continue;
                        }
                    }
                } while (!z2);
                gVar = aVar.a;
            }
            if (gVar == null) {
                return gVar;
            }
            h hVar = this.Y1;
            synchronized (hVar) {
                gVar2 = hVar.a.get(new t(cls, true));
            }
            if (gVar2 != null) {
                return gVar2;
            }
            g<Object> N = N(cls, null);
            i0.f.a.c.r.i iVar = this.y;
            SerializationConfig serializationConfig = this.q;
            i0.f.a.c.p.e b = iVar.b(serializationConfig, serializationConfig.d.d.b(null, cls, TypeFactory.q));
            if (b != null) {
                N = new d(b.a(null), N);
            }
            if (z) {
                h hVar2 = this.Y1;
                synchronized (hVar2) {
                    if (hVar2.a.put(new t(cls, true), N) == null) {
                        hVar2.b.set(null);
                    }
                }
            }
            return N;
        }
        gVar = null;
        if (gVar == null) {
        }
    }

    public g<Object> J(JavaType javaType) throws JsonMappingException {
        g<Object> a = this.e2.a(javaType);
        if (a != null) {
            return a;
        }
        g<Object> a2 = this.Y1.a(javaType);
        if (a2 != null) {
            return a2;
        }
        g<Object> q = q(javaType);
        return q == null ? R(javaType.c) : q;
    }

    public g<Object> M(JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        if (javaType != null) {
            g<Object> a = this.e2.a(javaType);
            if (a == null && (a = this.Y1.a(javaType)) == null && (a = q(javaType)) == null) {
                return R(javaType.c);
            }
            return U(a, beanProperty);
        }
        b0("Null passed for `valueType` of `findValueSerializer()`", new Object[0]);
        throw null;
    }

    public g<Object> N(Class<?> cls, BeanProperty beanProperty) throws JsonMappingException {
        g<Object> b = this.e2.b(cls);
        if (b == null && (b = this.Y1.b(cls)) == null && (b = this.Y1.a(this.q.d.d.b(null, cls, TypeFactory.q))) == null && (b = v(cls)) == null) {
            return R(cls);
        }
        return U(b, beanProperty);
    }

    public final AnnotationIntrospector O() {
        return this.q.e();
    }

    public Object Q(Object obj) {
        Object obj2;
        ContextAttributes.Impl impl = (ContextAttributes.Impl) this.Z1;
        Map<Object, Object> map = impl.x;
        if (map == null || (obj2 = map.get(obj)) == null) {
            return impl.q.get(obj);
        }
        if (obj2 == ContextAttributes.Impl.d) {
            return null;
        }
        return obj2;
    }

    public g<Object> R(Class<?> cls) {
        if (cls == Object.class) {
            return this.a2;
        }
        return new UnknownSerializer(cls);
    }

    public g<?> T(g<?> gVar, BeanProperty beanProperty) throws JsonMappingException {
        return (gVar == null || !(gVar instanceof i0.f.a.c.r.d)) ? gVar : ((i0.f.a.c.r.d) gVar).a(this, beanProperty);
    }

    public g<?> U(g<?> gVar, BeanProperty beanProperty) throws JsonMappingException {
        return (gVar == null || !(gVar instanceof i0.f.a.c.r.d)) ? gVar : ((i0.f.a.c.r.d) gVar).a(this, beanProperty);
    }

    public abstract Object V(j jVar, Class<?> cls) throws JsonMappingException;

    public abstract boolean W(Object obj) throws JsonMappingException;

    public final boolean X(MapperFeature mapperFeature) {
        return mapperFeature.enabledIn(this.q.c);
    }

    public final boolean Y(SerializationFeature serializationFeature) {
        return this.q.E(serializationFeature);
    }

    public <T> T Z(b bVar, j jVar, String str, Object... objArr) throws JsonMappingException {
        String b = b(str, objArr);
        String str2 = "N/A";
        String c2 = jVar != null ? c(jVar.getName()) : str2;
        if (bVar != null) {
            str2 = f.E(bVar.a.c);
        }
        throw new InvalidDefinitionException(((DefaultSerializerProvider) this).j2, String.format("Invalid definition for property %s (of type %s): %s", c2, str2, b), bVar, jVar);
    }

    public <T> T a0(b bVar, String str, Object... objArr) throws JsonMappingException {
        throw new InvalidDefinitionException(((DefaultSerializerProvider) this).j2, String.format("Invalid type definition for type %s: %s", f.E(bVar.a.c), b(str, objArr)), bVar, (j) null);
    }

    public void b0(String str, Object... objArr) throws JsonMappingException {
        throw new JsonMappingException(((DefaultSerializerProvider) this).j2, b(str, objArr), (Throwable) null);
    }

    public abstract g<Object> c0(a aVar, Object obj) throws JsonMappingException;

    @Override // i0.f.a.c.c
    public MapperConfig h() {
        return this.q;
    }

    @Override // i0.f.a.c.c
    public final TypeFactory i() {
        return this.q.d.d;
    }

    @Override // i0.f.a.c.c
    public JsonMappingException k(JavaType javaType, String str, String str2) {
        return new InvalidTypeIdException(null, a(String.format("Could not resolve type id '%s' as a subtype of %s", str, f.t(javaType)), str2), javaType, str);
    }

    @Override // i0.f.a.c.c
    public <T> T n(JavaType javaType, String str) throws JsonMappingException {
        throw new InvalidDefinitionException(((DefaultSerializerProvider) this).j2, str, javaType);
    }

    public g<Object> q(JavaType javaType) throws JsonMappingException {
        try {
            g<Object> w = w(javaType);
            if (w != null) {
                h hVar = this.Y1;
                synchronized (hVar) {
                    if (hVar.a.put(new t(javaType, false), w) == null) {
                        hVar.b.set(null);
                    }
                    if (w instanceof g) {
                        ((g) w).b(this);
                    }
                }
            }
            return w;
        } catch (IllegalArgumentException e) {
            throw new JsonMappingException(((DefaultSerializerProvider) this).j2, b(f.j(e), new Object[0]), e);
        }
    }

    public g<Object> v(Class<?> cls) throws JsonMappingException {
        JavaType b = this.q.d.d.b(null, cls, TypeFactory.q);
        try {
            g<Object> w = w(b);
            if (w != null) {
                h hVar = this.Y1;
                synchronized (hVar) {
                    g<Object> put = hVar.a.put(new t(cls, false), w);
                    g<Object> put2 = hVar.a.put(new t(b, false), w);
                    if (put == null || put2 == null) {
                        hVar.b.set(null);
                    }
                    if (w instanceof g) {
                        ((g) w).b(this);
                    }
                }
            }
            return w;
        } catch (IllegalArgumentException e) {
            throw new JsonMappingException(((DefaultSerializerProvider) this).j2, b(f.j(e), new Object[0]), e);
        }
    }

    public g<Object> w(JavaType javaType) throws JsonMappingException {
        JavaType C0;
        BeanSerializerFactory beanSerializerFactory = (BeanSerializerFactory) this.y;
        Objects.requireNonNull(beanSerializerFactory);
        SerializationConfig serializationConfig = this.q;
        b C = serializationConfig.C(javaType);
        g<?> e = beanSerializerFactory.e(this, ((i0.f.a.c.n.i) C).f);
        if (e != null) {
            return e;
        }
        AnnotationIntrospector e2 = serializationConfig.e();
        boolean z = false;
        i0.f.a.c.t.g<Object, Object> gVar = null;
        if (e2 == null) {
            C0 = javaType;
        } else {
            try {
                C0 = e2.C0(serializationConfig, ((i0.f.a.c.n.i) C).f, javaType);
            } catch (JsonMappingException e3) {
                a0(C, e3.getMessage(), new Object[0]);
                throw null;
            }
        }
        if (C0 != javaType) {
            if (!C0.A(javaType.c)) {
                C = serializationConfig.C(C0);
            }
            z = true;
        }
        i0.f.a.c.n.i iVar = (i0.f.a.c.n.i) C;
        AnnotationIntrospector annotationIntrospector = iVar.e;
        if (annotationIntrospector != null) {
            gVar = iVar.g(annotationIntrospector.d0(iVar.f));
        }
        if (gVar == null) {
            return beanSerializerFactory.h(this, C0, C, z);
        }
        JavaType c2 = gVar.c(i());
        if (!c2.A(C0.c)) {
            C = serializationConfig.C(c2);
            e = beanSerializerFactory.e(this, ((i0.f.a.c.n.i) C).f);
        }
        if (e == null && !c2.N()) {
            e = beanSerializerFactory.h(this, c2, C, true);
        }
        return new StdDelegatingSerializer(gVar, c2, e);
    }

    public final DateFormat x() {
        DateFormat dateFormat = this.f2;
        if (dateFormat != null) {
            return dateFormat;
        }
        DateFormat dateFormat2 = (DateFormat) this.q.d.b2.clone();
        this.f2 = dateFormat2;
        return dateFormat2;
    }

    public JavaType y(JavaType javaType, Class<?> cls) throws IllegalArgumentException {
        if (javaType.c == cls) {
            return javaType;
        }
        return this.q.d.d.l(javaType, cls, true);
    }

    public final void z(JsonGenerator jsonGenerator) throws IOException {
        if (this.g2) {
            jsonGenerator.c0();
        } else {
            this.c2.f(null, jsonGenerator, this);
        }
    }

    public i(i iVar, SerializationConfig serializationConfig, i0.f.a.c.r.i iVar2) {
        this.a2 = d;
        this.c2 = NullSerializer.q;
        g<Object> gVar = c;
        this.d2 = gVar;
        this.y = iVar2;
        this.q = serializationConfig;
        h hVar = iVar.Y1;
        this.Y1 = hVar;
        this.a2 = iVar.a2;
        this.b2 = iVar.b2;
        g<Object> gVar2 = iVar.c2;
        this.c2 = gVar2;
        this.d2 = iVar.d2;
        this.g2 = gVar2 == gVar;
        this.x = serializationConfig.b2;
        this.Z1 = serializationConfig.c2;
        c cVar = hVar.b.get();
        if (cVar == null) {
            synchronized (hVar) {
                cVar = hVar.b.get();
                if (cVar == null) {
                    c cVar2 = new c(hVar.a);
                    hVar.b.set(cVar2);
                    cVar = cVar2;
                }
            }
        }
        this.e2 = cVar;
    }
}
