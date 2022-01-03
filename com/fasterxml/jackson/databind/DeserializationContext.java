package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionConfigs;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.cfg.MutableCoercionConfig;
import com.fasterxml.jackson.databind.deser.BasicDeserializerFactory;
import com.fasterxml.jackson.databind.deser.DeserializerCache;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.TypeWrappedDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.EnumResolver;
import i0.d.a.a.a;
import i0.f.a.a.z;
import i0.f.a.c.c;
import i0.f.a.c.d;
import i0.f.a.c.l.e;
import i0.f.a.c.l.f;
import i0.f.a.c.l.j;
import i0.f.a.c.n.i;
import i0.f.a.c.t.b;
import i0.f.a.c.t.h;
import i0.f.a.c.t.n;
import java.io.IOException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
/* loaded from: classes2.dex */
public abstract class DeserializationContext extends c implements Serializable {
    public final Class<?> Y1;
    public transient JsonParser Z1;
    public transient b a2;
    public transient n b2;
    public final DeserializerCache c;
    public transient DateFormat c2;
    public final f d;
    public h<JavaType> d2;
    public final DeserializationConfig q;
    public final int x;
    public final i0.f.a.b.m.f<StreamReadCapability> y;

    public DeserializationContext(f fVar, DeserializerCache deserializerCache) {
        Objects.requireNonNull(fVar, "Cannot pass null DeserializerFactory");
        this.d = fVar;
        this.c = deserializerCache == null ? new DeserializerCache() : deserializerCache;
        this.x = 0;
        this.y = null;
        this.q = null;
        this.Y1 = null;
    }

    public final i0.f.a.c.h A(JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        i0.f.a.c.h hVar;
        i0.f.a.c.b bVar;
        Constructor<?> constructor;
        Method method;
        i0.f.a.c.h enumKD;
        AnnotatedMethod next;
        DeserializerCache deserializerCache = this.c;
        f fVar = this.d;
        Objects.requireNonNull(deserializerCache);
        BasicDeserializerFactory basicDeserializerFactory = (BasicDeserializerFactory) fVar;
        Objects.requireNonNull(basicDeserializerFactory);
        DeserializationConfig deserializationConfig = this.q;
        i0.f.a.c.h hVar2 = null;
        if (basicDeserializerFactory.y.Z1.length > 0) {
            bVar = deserializationConfig.m(javaType);
            i0.f.a.c.t.c cVar = new i0.f.a.c.t.c(basicDeserializerFactory.y.Z1);
            hVar = null;
            while (cVar.hasNext() && (hVar = ((i0.f.a.c.l.h) cVar.next()).a(javaType, deserializationConfig, bVar)) == null) {
            }
        } else {
            bVar = null;
            hVar = null;
        }
        if (hVar == null) {
            if (bVar == null) {
                bVar = deserializationConfig.n(javaType.c);
            }
            hVar = basicDeserializerFactory.x(this, ((i) bVar).f);
            if (hVar == null) {
                if (javaType.I()) {
                    DeserializationConfig deserializationConfig2 = this.q;
                    Class<?> cls = javaType.c;
                    i0.f.a.c.b C = deserializationConfig2.C(javaType);
                    i iVar = (i) C;
                    i0.f.a.c.h x = basicDeserializerFactory.x(this, iVar.f);
                    if (x != null) {
                        hVar = x;
                    } else {
                        d<?> i = basicDeserializerFactory.i(cls, deserializationConfig2, C);
                        if (i != null) {
                            enumKD = new StdKeyDeserializer.DelegatingKD(javaType.c, i);
                        } else {
                            d<Object> w = basicDeserializerFactory.w(this, iVar.f);
                            if (w != null) {
                                enumKD = new StdKeyDeserializer.DelegatingKD(javaType.c, w);
                            } else {
                                EnumResolver v = basicDeserializerFactory.v(cls, deserializationConfig2, C.c());
                                Iterator<AnnotatedMethod> it = C.f().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        enumKD = new StdKeyDeserializer.EnumKD(v, null);
                                        break;
                                    }
                                    next = it.next();
                                    if (basicDeserializerFactory.m(this, next)) {
                                        if (next.x() != 1 || !next.A().isAssignableFrom(cls)) {
                                            break;
                                        } else if (next.z(0) == String.class) {
                                            if (deserializationConfig2.b()) {
                                                i0.f.a.c.t.f.e(next.x, e0(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                                            }
                                            enumKD = new StdKeyDeserializer.EnumKD(v, next);
                                        }
                                    }
                                }
                                StringBuilder sb = new StringBuilder();
                                sb.append("Unsuitable method (");
                                sb.append(next);
                                sb.append(") decorated with @JsonCreator (for Enum type ");
                                throw new IllegalArgumentException(a.Y(cls, sb, ")"));
                            }
                        }
                        hVar = enumKD;
                    }
                } else {
                    Class<?>[] clsArr = {String.class};
                    i iVar2 = (i) deserializationConfig.C(javaType);
                    Iterator<AnnotatedConstructor> it2 = iVar2.f.k().iterator();
                    loop2: while (true) {
                        if (!it2.hasNext()) {
                            constructor = null;
                            break;
                        }
                        AnnotatedConstructor next2 = it2.next();
                        if (next2.x() == 1) {
                            Class<?> z = next2.z(0);
                            for (int i2 = 0; i2 < 1; i2++) {
                                if (clsArr[i2] == z) {
                                    constructor = next2.x;
                                    break loop2;
                                }
                            }
                            continue;
                        }
                    }
                    if (constructor != null) {
                        if (deserializationConfig.b()) {
                            i0.f.a.c.t.f.e(constructor, deserializationConfig.q(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                        }
                        hVar2 = new StdKeyDeserializer.StringCtorKeyDeserializer(constructor);
                    } else {
                        Class<?>[] clsArr2 = {String.class};
                        Iterator<AnnotatedMethod> it3 = iVar2.f.l().iterator();
                        loop4: while (true) {
                            if (!it3.hasNext()) {
                                method = null;
                                break;
                            }
                            AnnotatedMethod next3 = it3.next();
                            if (iVar2.k(next3) && next3.x() == 1) {
                                Class<?> z2 = next3.z(0);
                                for (int i3 = 0; i3 < 1; i3++) {
                                    if (z2.isAssignableFrom(clsArr2[i3])) {
                                        method = next3.x;
                                        break loop4;
                                    }
                                }
                                continue;
                            }
                        }
                        if (method != null) {
                            if (deserializationConfig.b()) {
                                i0.f.a.c.t.f.e(method, deserializationConfig.q(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
                            }
                            hVar2 = new StdKeyDeserializer.StringFactoryKeyDeserializer(method);
                        }
                    }
                    hVar = hVar2;
                }
            }
        }
        if (hVar != null && basicDeserializerFactory.y.c()) {
            i0.f.a.c.t.c cVar2 = (i0.f.a.c.t.c) basicDeserializerFactory.y.a();
            while (cVar2.hasNext()) {
                Objects.requireNonNull((i0.f.a.c.l.b) cVar2.next());
            }
        }
        if (hVar != null) {
            if (hVar instanceof j) {
                ((j) hVar).c(this);
            }
            return hVar instanceof i0.f.a.c.l.d ? ((i0.f.a.c.l.d) hVar).a(this, beanProperty) : hVar;
        }
        throw new InvalidDefinitionException(this.Z1, "Cannot find a (Map) Key deserializer for type " + javaType, javaType);
    }

    public final d<Object> C(JavaType javaType) throws JsonMappingException {
        return this.c.f(this, this.d, javaType);
    }

    public abstract i0.f.a.c.l.m.h E(Object obj, ObjectIdGenerator<?> objectIdGenerator, z zVar);

    public final d<Object> F(JavaType javaType) throws JsonMappingException {
        d<?> R = R(this.c.f(this, this.d, javaType), null, javaType);
        i0.f.a.c.p.b b = this.d.b(this.q, javaType);
        return b != null ? new TypeWrappedDeserializer(b.f(null), R) : R;
    }

    public final AnnotationIntrospector G() {
        return this.q.e();
    }

    public final b H() {
        if (this.a2 == null) {
            this.a2 = new b();
        }
        return this.a2;
    }

    public final Base64Variant I() {
        return this.q.d.e2;
    }

    public TimeZone J() {
        TimeZone timeZone = this.q.d.d2;
        return timeZone == null ? BaseSettings.c : timeZone;
    }

    public void M(d<?> dVar) throws JsonMappingException {
        if (!e0(MapperFeature.IGNORE_MERGE_FOR_UNMERGEABLE)) {
            JavaType q = q(dVar.n());
            throw new InvalidDefinitionException(this.Z1, String.format("Invalid configuration: values of type %s cannot be merged", i0.f.a.c.t.f.t(q)), q);
        }
    }

    public Object N(Class<?> cls, Object obj, Throwable th) throws IOException {
        for (h hVar = this.q.g2; hVar != null; hVar = hVar.b) {
            Objects.requireNonNull((e) hVar.a);
            Object obj2 = e.a;
        }
        i0.f.a.c.t.f.J(th);
        if (!d0(DeserializationFeature.WRAP_EXCEPTIONS)) {
            i0.f.a.c.t.f.K(th);
        }
        throw b0(cls, th);
    }

    public Object O(Class<?> cls, ValueInstantiator valueInstantiator, JsonParser jsonParser, String str, Object... objArr) throws IOException {
        String b = b(str, objArr);
        for (h hVar = this.q.g2; hVar != null; hVar = hVar.b) {
            Objects.requireNonNull((e) hVar.a);
            Object obj = e.a;
        }
        if (valueInstantiator == null) {
            n(f(cls), String.format("Cannot construct instance of %s: %s", i0.f.a.c.t.f.E(cls), b));
            throw null;
        } else if (!valueInstantiator.m()) {
            n(f(cls), String.format("Cannot construct instance of %s (no Creators, like default constructor, exist): %s", i0.f.a.c.t.f.E(cls), b));
            throw null;
        } else {
            throw new MismatchedInputException(this.Z1, b(String.format("Cannot construct instance of %s (although at least one Creator exists): %s", i0.f.a.c.t.f.E(cls), b), new Object[0]), cls);
        }
    }

    public d<?> Q(d<?> dVar, BeanProperty beanProperty, JavaType javaType) throws JsonMappingException {
        if (dVar instanceof i0.f.a.c.l.c) {
            this.d2 = new h<>(javaType, this.d2);
            try {
                dVar = ((i0.f.a.c.l.c) dVar).a(this, beanProperty);
            } finally {
                this.d2 = this.d2.b;
            }
        }
        return dVar;
    }

    public d<?> R(d<?> dVar, BeanProperty beanProperty, JavaType javaType) throws JsonMappingException {
        if (dVar instanceof i0.f.a.c.l.c) {
            this.d2 = new h<>(javaType, this.d2);
            try {
                dVar = ((i0.f.a.c.l.c) dVar).a(this, beanProperty);
            } finally {
                this.d2 = this.d2.b;
            }
        }
        return dVar;
    }

    public Object T(JavaType javaType, JsonParser jsonParser) throws IOException {
        U(javaType, jsonParser.i(), jsonParser, null, new Object[0]);
        throw null;
    }

    public Object U(JavaType javaType, JsonToken jsonToken, JsonParser jsonParser, String str, Object... objArr) throws IOException {
        String str2;
        String b = b(str, objArr);
        for (h hVar = this.q.g2; hVar != null; hVar = hVar.b) {
            Objects.requireNonNull((e) hVar.a);
            Class<?> cls = javaType.c;
            Object obj = e.a;
        }
        if (b == null) {
            String t = i0.f.a.c.t.f.t(javaType);
            if (jsonToken == null) {
                b = String.format("Unexpected end-of-input when trying read value of type %s", t);
            } else {
                Object[] objArr2 = new Object[3];
                objArr2[0] = t;
                switch (jsonToken.ordinal()) {
                    case 1:
                    case 2:
                    case 5:
                        str2 = "Object value";
                        break;
                    case 3:
                    case 4:
                        str2 = "Array value";
                        break;
                    case 6:
                        str2 = "Embedded Object";
                        break;
                    case 7:
                        str2 = "String value";
                        break;
                    case 8:
                        str2 = "Integer value";
                        break;
                    case 9:
                        str2 = "Floating-point value";
                        break;
                    case 10:
                    case 11:
                        str2 = "Boolean value";
                        break;
                    case 12:
                        str2 = "Null value";
                        break;
                    default:
                        str2 = "[Unavailable value]";
                        break;
                }
                objArr2[1] = str2;
                objArr2[2] = jsonToken;
                b = String.format("Cannot deserialize value of type %s from %s (token `JsonToken.%s`)", objArr2);
            }
        }
        if (jsonToken != null && jsonToken.isScalarValue()) {
            jsonParser.Z();
        }
        throw new MismatchedInputException(this.Z1, b(b, new Object[0]), javaType);
    }

    public Object V(Class<?> cls, JsonParser jsonParser) throws IOException {
        U(q(cls), jsonParser.i(), jsonParser, null, new Object[0]);
        throw null;
    }

    public JavaType W(JavaType javaType, String str, i0.f.a.c.p.c cVar, String str2) throws IOException {
        for (h hVar = this.q.g2; hVar != null; hVar = hVar.b) {
            Objects.requireNonNull((e) hVar.a);
        }
        if (!d0(DeserializationFeature.FAIL_ON_INVALID_SUBTYPE)) {
            return null;
        }
        throw k(javaType, str, str2);
    }

    public Object X(Class<?> cls, String str, String str2, Object... objArr) throws IOException {
        String b = b(str2, objArr);
        for (h hVar = this.q.g2; hVar != null; hVar = hVar.b) {
            Objects.requireNonNull((e) hVar.a);
            Object obj = e.a;
        }
        throw new InvalidFormatException(this.Z1, String.format("Cannot deserialize Map key of type %s from String %s: %s", i0.f.a.c.t.f.E(cls), c(str), b), str, cls);
    }

    public Object Y(Class<?> cls, Number number, String str, Object... objArr) throws IOException {
        String b = b(str, objArr);
        for (h hVar = this.q.g2; hVar != null; hVar = hVar.b) {
            Objects.requireNonNull((e) hVar.a);
            Object obj = e.a;
        }
        throw s0(number, cls, b);
    }

    public Object Z(Class<?> cls, String str, String str2, Object... objArr) throws IOException {
        String b = b(str2, objArr);
        for (h hVar = this.q.g2; hVar != null; hVar = hVar.b) {
            Objects.requireNonNull((e) hVar.a);
            Object obj = e.a;
        }
        throw t0(str, cls, b);
    }

    public final boolean a0(int i) {
        return (i & this.x) != 0;
    }

    public JsonMappingException b0(Class<?> cls, Throwable th) {
        String str;
        if (th == null) {
            str = "N/A";
        } else {
            str = i0.f.a.c.t.f.j(th);
            if (str == null) {
                str = i0.f.a.c.t.f.E(th.getClass());
            }
        }
        return new ValueInstantiationException(this.Z1, String.format("Cannot construct instance of %s, problem: %s", i0.f.a.c.t.f.E(cls), str), q(cls), th);
    }

    public final boolean c0(StreamReadCapability streamReadCapability) {
        i0.f.a.b.m.f<StreamReadCapability> fVar = this.y;
        Objects.requireNonNull(fVar);
        return (streamReadCapability.getMask() & fVar.a) != 0;
    }

    public final boolean d0(DeserializationFeature deserializationFeature) {
        return (deserializationFeature.getMask() & this.x) != 0;
    }

    public final boolean e0(MapperFeature mapperFeature) {
        return mapperFeature.enabledIn(this.q.c);
    }

    public abstract i0.f.a.c.h f0(i0.f.a.c.n.a aVar, Object obj) throws JsonMappingException;

    public final n g0() {
        n nVar = this.b2;
        if (nVar == null) {
            return new n();
        }
        this.b2 = null;
        return nVar;
    }

    @Override // i0.f.a.c.c
    public MapperConfig h() {
        return this.q;
    }

    public Date h0(String str) throws IllegalArgumentException {
        try {
            DateFormat dateFormat = this.c2;
            if (dateFormat == null) {
                dateFormat = (DateFormat) this.q.d.b2.clone();
                this.c2 = dateFormat;
            }
            return dateFormat.parse(str);
        } catch (ParseException e) {
            throw new IllegalArgumentException(String.format("Failed to parse Date value '%s': %s", str, i0.f.a.c.t.f.j(e)));
        }
    }

    @Override // i0.f.a.c.c
    public final TypeFactory i() {
        return this.q.d.d;
    }

    public <T> T i0(i0.f.a.c.b bVar, i0.f.a.c.n.j jVar, String str, Object... objArr) throws JsonMappingException {
        String b = b(str, objArr);
        Annotation[] annotationArr = i0.f.a.c.t.f.a;
        throw new InvalidDefinitionException(this.Z1, String.format("Invalid definition for property %s (of type %s): %s", i0.f.a.c.t.f.c(jVar.getName()), i0.f.a.c.t.f.E(bVar.a.c), b), bVar, jVar);
    }

    public <T> T j0(i0.f.a.c.b bVar, String str, Object... objArr) throws JsonMappingException {
        throw new InvalidDefinitionException(this.Z1, String.format("Invalid type definition for type %s: %s", i0.f.a.c.t.f.E(bVar.a.c), b(str, objArr)), bVar, (i0.f.a.c.n.j) null);
    }

    @Override // i0.f.a.c.c
    public JsonMappingException k(JavaType javaType, String str, String str2) {
        return new InvalidTypeIdException(this.Z1, a(String.format("Could not resolve type id '%s' as a subtype of %s", str, i0.f.a.c.t.f.t(javaType)), str2), javaType, str);
    }

    public <T> T k0(BeanProperty beanProperty, String str, Object... objArr) throws JsonMappingException {
        JavaType javaType;
        AnnotatedMember a;
        String b = b(str, objArr);
        if (beanProperty == null) {
            javaType = null;
        } else {
            javaType = ((SettableBeanProperty) beanProperty).y;
        }
        MismatchedInputException mismatchedInputException = new MismatchedInputException(this.Z1, b, javaType);
        if (!(beanProperty == null || (a = beanProperty.a()) == null)) {
            mismatchedInputException.g(a.h(), ((SettableBeanProperty) beanProperty).x.q);
        }
        throw mismatchedInputException;
    }

    public <T> T l0(JavaType javaType, String str, Object... objArr) throws JsonMappingException {
        throw new MismatchedInputException(this.Z1, b(str, objArr), javaType);
    }

    public <T> T m0(d<?> dVar, String str, Object... objArr) throws JsonMappingException {
        throw new MismatchedInputException(this.Z1, b(str, objArr), dVar.n());
    }

    @Override // i0.f.a.c.c
    public <T> T n(JavaType javaType, String str) throws JsonMappingException {
        throw new InvalidDefinitionException(this.Z1, str, javaType);
    }

    public <T> T n0(Class<?> cls, String str, Object... objArr) throws JsonMappingException {
        throw new MismatchedInputException(this.Z1, b(str, objArr), cls);
    }

    public <T> T o0(JavaType javaType, String str, String str2, Object... objArr) throws JsonMappingException {
        Class<?> cls = javaType.c;
        MismatchedInputException mismatchedInputException = new MismatchedInputException(this.Z1, b(str2, objArr), cls);
        if (str != null) {
            mismatchedInputException.g(cls, str);
        }
        throw mismatchedInputException;
    }

    public void p0(JavaType javaType, JsonToken jsonToken, String str, Object... objArr) throws JsonMappingException {
        String b = b(str, objArr);
        JsonParser jsonParser = this.Z1;
        throw new MismatchedInputException(jsonParser, a(String.format("Unexpected token (%s), expected %s", jsonParser.i(), jsonToken), b), javaType);
    }

    public final JavaType q(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        return this.q.d.d.b(null, cls, TypeFactory.q);
    }

    public void q0(d<?> dVar, JsonToken jsonToken, String str, Object... objArr) throws JsonMappingException {
        throw u0(this.Z1, dVar.n(), jsonToken, b(str, objArr));
    }

    public final void r0(n nVar) {
        n nVar2 = this.b2;
        if (nVar2 != null) {
            Object[] objArr = nVar.d;
            int i = 0;
            int length = objArr == null ? 0 : objArr.length;
            Object[] objArr2 = nVar2.d;
            if (objArr2 != null) {
                i = objArr2.length;
            }
            if (length < i) {
                return;
            }
        }
        this.b2 = nVar;
    }

    public JsonMappingException s0(Number number, Class<?> cls, String str) {
        return new InvalidFormatException(this.Z1, String.format("Cannot deserialize value of type %s from number %s: %s", i0.f.a.c.t.f.E(cls), String.valueOf(number), str), number, cls);
    }

    public JsonMappingException t0(String str, Class<?> cls, String str2) {
        return new InvalidFormatException(this.Z1, String.format("Cannot deserialize value of type %s from String %s: %s", i0.f.a.c.t.f.E(cls), c(str), str2), str, cls);
    }

    public JsonMappingException u0(JsonParser jsonParser, Class<?> cls, JsonToken jsonToken, String str) {
        return new MismatchedInputException(jsonParser, a(String.format("Unexpected token (%s), expected %s", jsonParser.i(), jsonToken), str), cls);
    }

    public abstract d<Object> v(i0.f.a.c.n.a aVar, Object obj) throws JsonMappingException;

    public CoercionAction w(LogicalType logicalType, Class<?> cls, CoercionInputShape coercionInputShape) {
        CoercionAction coercionAction;
        MutableCoercionConfig mutableCoercionConfig;
        CoercionAction coercionAction2;
        MutableCoercionConfig mutableCoercionConfig2;
        CoercionAction coercionAction3;
        DeserializationConfig deserializationConfig = this.q;
        CoercionConfigs coercionConfigs = deserializationConfig.i2;
        Map<Class<?>, MutableCoercionConfig> map = coercionConfigs.x;
        if (map != null && cls != null && (mutableCoercionConfig2 = map.get(cls)) != null && (coercionAction3 = mutableCoercionConfig2.q[coercionInputShape.ordinal()]) != null) {
            return coercionAction3;
        }
        MutableCoercionConfig[] mutableCoercionConfigArr = coercionConfigs.q;
        if (mutableCoercionConfigArr != null && logicalType != null && (mutableCoercionConfig = mutableCoercionConfigArr[logicalType.ordinal()]) != null && (coercionAction2 = mutableCoercionConfig.q[coercionInputShape.ordinal()]) != null) {
            return coercionAction2;
        }
        CoercionAction coercionAction4 = coercionConfigs.d.q[coercionInputShape.ordinal()];
        if (coercionAction4 != null) {
            return coercionAction4;
        }
        int ordinal = coercionInputShape.ordinal();
        if (ordinal != 2) {
            if (ordinal != 3) {
                if (ordinal == 7) {
                    coercionAction = deserializationConfig.F(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT) ? CoercionAction.AsNull : CoercionAction.Fail;
                    return coercionAction;
                }
            } else if (logicalType == LogicalType.Integer) {
                coercionAction = deserializationConfig.F(DeserializationFeature.ACCEPT_FLOAT_AS_INT) ? CoercionAction.TryConvert : CoercionAction.Fail;
                return coercionAction;
            }
        } else if (logicalType == LogicalType.Enum && deserializationConfig.F(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS)) {
            return CoercionAction.Fail;
        }
        boolean z = logicalType == LogicalType.Float || logicalType == LogicalType.Integer || logicalType == LogicalType.Boolean || logicalType == LogicalType.DateTime;
        if (z && !deserializationConfig.q(MapperFeature.ALLOW_COERCION_OF_SCALARS)) {
            return CoercionAction.Fail;
        }
        if (coercionInputShape != CoercionInputShape.EmptyString) {
            return coercionConfigs.c;
        }
        if (z || deserializationConfig.F(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) {
            return CoercionAction.AsNull;
        }
        if (logicalType == LogicalType.OtherScalar) {
            return CoercionAction.TryConvert;
        }
        return CoercionAction.Fail;
    }

    public CoercionAction x(LogicalType logicalType, Class<?> cls, CoercionAction coercionAction) {
        CoercionAction coercionAction2;
        MutableCoercionConfig mutableCoercionConfig;
        MutableCoercionConfig mutableCoercionConfig2;
        DeserializationConfig deserializationConfig = this.q;
        CoercionConfigs coercionConfigs = deserializationConfig.i2;
        Map<Class<?>, MutableCoercionConfig> map = coercionConfigs.x;
        Boolean bool = null;
        if (map == null || cls == null || (mutableCoercionConfig2 = map.get(cls)) == null) {
            coercionAction2 = null;
        } else {
            bool = mutableCoercionConfig2.d;
            coercionAction2 = mutableCoercionConfig2.a(CoercionInputShape.EmptyString);
        }
        MutableCoercionConfig[] mutableCoercionConfigArr = coercionConfigs.q;
        if (!(mutableCoercionConfigArr == null || logicalType == null || (mutableCoercionConfig = mutableCoercionConfigArr[logicalType.ordinal()]) == null)) {
            if (bool == null) {
                bool = mutableCoercionConfig.d;
            }
            if (coercionAction2 == null) {
                coercionAction2 = mutableCoercionConfig.a(CoercionInputShape.EmptyString);
            }
        }
        if (bool == null) {
            bool = coercionConfigs.d.d;
        }
        if (coercionAction2 == null) {
            coercionAction2 = coercionConfigs.d.a(CoercionInputShape.EmptyString);
        }
        if (!Boolean.TRUE.equals(bool)) {
            return coercionAction;
        }
        if (coercionAction2 != null) {
            return coercionAction2;
        }
        return deserializationConfig.F(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) ? CoercionAction.AsNull : CoercionAction.Fail;
    }

    public final d<Object> y(JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        return R(this.c.f(this, this.d, javaType), beanProperty, javaType);
    }

    public final Object z(Object obj, BeanProperty beanProperty, Object obj2) throws JsonMappingException {
        Class<?> cls;
        Annotation[] annotationArr = i0.f.a.c.t.f.a;
        if (obj == null) {
            cls = null;
        } else {
            cls = obj.getClass();
        }
        p(cls, String.format("No 'injectableValues' configured, cannot inject value with id [%s]", obj));
        throw null;
    }

    public DeserializationContext(DeserializationContext deserializationContext, DeserializationConfig deserializationConfig, JsonParser jsonParser) {
        i0.f.a.b.m.f<StreamReadCapability> fVar;
        this.c = deserializationContext.c;
        this.d = deserializationContext.d;
        if (jsonParser == null) {
            fVar = null;
        } else {
            fVar = jsonParser.U();
        }
        this.y = fVar;
        this.q = deserializationConfig;
        this.x = deserializationConfig.k2;
        this.Y1 = deserializationConfig.b2;
        this.Z1 = jsonParser;
    }

    public DeserializationContext(DeserializationContext deserializationContext, DeserializationConfig deserializationConfig) {
        this.c = deserializationContext.c;
        this.d = deserializationContext.d;
        this.y = null;
        this.q = deserializationConfig;
        this.x = deserializationConfig.k2;
        this.Y1 = null;
        this.Z1 = null;
    }
}
