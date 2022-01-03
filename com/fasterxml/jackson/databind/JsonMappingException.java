package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.instabug.library.model.StepType;
import i0.d.a.a.a;
import i0.f.a.a.k;
import i0.f.a.c.t.f;
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
/* loaded from: classes2.dex */
public class JsonMappingException extends JsonProcessingException {
    public LinkedList<Reference> d;
    public transient Closeable q;

    public JsonMappingException(Closeable closeable, String str) {
        super(str);
        this.q = closeable;
        if (closeable instanceof JsonParser) {
            this.c = ((JsonParser) closeable).f0();
        }
    }

    public static JsonMappingException e(IOException iOException) {
        return new JsonMappingException(null, String.format("Unexpected IOException (of type %s): %s", iOException.getClass().getName(), f.j(iOException)));
    }

    public static JsonMappingException h(Throwable th, Reference reference) {
        JsonMappingException jsonMappingException;
        if (th instanceof JsonMappingException) {
            jsonMappingException = (JsonMappingException) th;
        } else {
            String j = f.j(th);
            if (j == null || j.isEmpty()) {
                StringBuilder P0 = a.P0("(was ");
                P0.append(th.getClass().getName());
                P0.append(")");
                j = P0.toString();
            }
            Closeable closeable = null;
            if (th instanceof JsonProcessingException) {
                Object c = ((JsonProcessingException) th).c();
                if (c instanceof Closeable) {
                    closeable = (Closeable) c;
                }
            }
            jsonMappingException = new JsonMappingException(closeable, j, th);
        }
        jsonMappingException.f(reference);
        return jsonMappingException;
    }

    public static JsonMappingException i(Throwable th, Object obj, int i) {
        return h(th, new Reference(obj, i));
    }

    public static JsonMappingException k(Throwable th, Object obj, String str) {
        return h(th, new Reference(obj, str));
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException
    @k
    public Object c() {
        return this.q;
    }

    public String d() {
        String message = super.getMessage();
        if (this.d == null) {
            return message;
        }
        StringBuilder sb = message == null ? new StringBuilder() : new StringBuilder(message);
        sb.append(" (through reference chain: ");
        LinkedList<Reference> linkedList = this.d;
        if (linkedList != null) {
            Iterator<Reference> it = linkedList.iterator();
            while (it.hasNext()) {
                sb.append(it.next().toString());
                if (it.hasNext()) {
                    sb.append("->");
                }
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public void f(Reference reference) {
        if (this.d == null) {
            this.d = new LinkedList<>();
        }
        if (this.d.size() < 1000) {
            this.d.addFirst(reference);
        }
    }

    public void g(Object obj, String str) {
        f(new Reference(obj, str));
    }

    @Override // java.lang.Throwable
    public String getLocalizedMessage() {
        return d();
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException, java.lang.Throwable
    public String getMessage() {
        return d();
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException, java.lang.Throwable, java.lang.Object
    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }

    /* loaded from: classes2.dex */
    public static class Reference implements Serializable {
        public transient Object c;
        public String d;
        public int q;
        public String x;

        public Reference() {
            this.q = -1;
        }

        @Override // java.lang.Object
        public String toString() {
            if (this.x == null) {
                StringBuilder sb = new StringBuilder();
                Object obj = this.c;
                if (obj != null) {
                    Class<?> cls = obj instanceof Class ? (Class) obj : obj.getClass();
                    int i = 0;
                    while (cls.isArray()) {
                        cls = cls.getComponentType();
                        i++;
                    }
                    sb.append(cls.getName());
                    while (true) {
                        i--;
                        if (i < 0) {
                            break;
                        }
                        sb.append("[]");
                    }
                } else {
                    sb.append(StepType.UNKNOWN);
                }
                sb.append('[');
                if (this.d != null) {
                    sb.append('\"');
                    sb.append(this.d);
                    sb.append('\"');
                } else {
                    int i2 = this.q;
                    if (i2 >= 0) {
                        sb.append(i2);
                    } else {
                        sb.append('?');
                    }
                }
                sb.append(']');
                this.x = sb.toString();
            }
            return this.x;
        }

        public Reference(Object obj, String str) {
            this.q = -1;
            this.c = obj;
            Objects.requireNonNull(str, "Cannot pass null fieldName");
            this.d = str;
        }

        public Reference(Object obj, int i) {
            this.q = -1;
            this.c = obj;
            this.q = i;
        }
    }

    public JsonMappingException(Closeable closeable, String str, Throwable th) {
        super(str, th);
        this.q = closeable;
        if (th instanceof JsonProcessingException) {
            this.c = ((JsonProcessingException) th).c;
        } else if (closeable instanceof JsonParser) {
            this.c = ((JsonParser) closeable).f0();
        }
    }

    public JsonMappingException(Closeable closeable, String str, JsonLocation jsonLocation) {
        super(str, jsonLocation);
        this.q = closeable;
    }
}
