package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import i0.d.a.a.a;
import i0.f.a.c.n.h;
import i0.f.a.c.n.q;
import i0.f.a.c.t.f;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public final class AnnotatedMethod extends AnnotatedWithParams implements Serializable {
    public final transient Method x;
    public Class<?>[] y;

    public AnnotatedMethod(q qVar, Method method, h hVar, h[] hVarArr) {
        super(qVar, hVar, hVarArr);
        if (method != null) {
            this.x = method;
            return;
        }
        throw new IllegalArgumentException("Cannot construct AnnotatedMethod with null Method");
    }

    public Class<?> A() {
        return this.x.getReturnType();
    }

    @Override // i0.f.a.c.n.a
    public AnnotatedElement b() {
        return this.x;
    }

    @Override // i0.f.a.c.n.a
    public String d() {
        return this.x.getName();
    }

    @Override // i0.f.a.c.n.a
    public Class<?> e() {
        return this.x.getReturnType();
    }

    @Override // i0.f.a.c.n.a, java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return f.u(obj, AnnotatedMethod.class) && ((AnnotatedMethod) obj).x == this.x;
    }

    @Override // i0.f.a.c.n.a
    public JavaType f() {
        return this.c.a(this.x.getGenericReturnType());
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedMember
    public Class<?> h() {
        return this.x.getDeclaringClass();
    }

    @Override // i0.f.a.c.n.a, java.lang.Object
    public int hashCode() {
        return this.x.getName().hashCode();
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedMember
    public String i() {
        String i = super.i();
        int x = x();
        if (x == 0) {
            return a.n0(i, "()");
        }
        if (x != 1) {
            return String.format("%s(%d params)", super.i(), Integer.valueOf(x()));
        }
        StringBuilder S0 = a.S0(i, "(");
        S0.append(z(0).getName());
        S0.append(")");
        return S0.toString();
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedMember
    public Member k() {
        return this.x;
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedMember
    public Object l(Object obj) throws IllegalArgumentException {
        try {
            return this.x.invoke(obj, null);
        } catch (IllegalAccessException | InvocationTargetException e) {
            StringBuilder P0 = a.P0("Failed to getValue() with method ");
            P0.append(i());
            P0.append(": ");
            P0.append(e.getMessage());
            throw new IllegalArgumentException(P0.toString(), e);
        }
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedMember
    public i0.f.a.c.n.a n(h hVar) {
        return new AnnotatedMethod(this.c, this.x, hVar, this.q);
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedWithParams
    public final Object p() throws Exception {
        return this.x.invoke(null, new Object[0]);
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedWithParams
    public final Object q(Object[] objArr) throws Exception {
        return this.x.invoke(null, objArr);
    }

    @Override // i0.f.a.c.n.a, java.lang.Object
    public String toString() {
        StringBuilder P0 = a.P0("[method ");
        P0.append(i());
        P0.append("]");
        return P0.toString();
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedWithParams
    public final Object v(Object obj) throws Exception {
        return this.x.invoke(null, obj);
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedWithParams
    public int x() {
        if (this.y == null) {
            this.y = this.x.getParameterTypes();
        }
        return this.y.length;
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedWithParams
    public JavaType y(int i) {
        Type[] genericParameterTypes = this.x.getGenericParameterTypes();
        if (i >= genericParameterTypes.length) {
            return null;
        }
        return this.c.a(genericParameterTypes[i]);
    }

    @Override // com.fasterxml.jackson.databind.introspect.AnnotatedWithParams
    public Class<?> z(int i) {
        if (this.y == null) {
            this.y = this.x.getParameterTypes();
        }
        Class<?>[] clsArr = this.y;
        if (i >= clsArr.length) {
            return null;
        }
        return clsArr[i];
    }
}
