package com.fasterxml.jackson.core.type;

import com.fasterxml.jackson.core.JsonToken;
/* loaded from: classes2.dex */
public class WritableTypeId {
    public Object a;
    public Class<?> b;
    public Object c = null;
    public String d;
    public Inclusion e;
    public JsonToken f;
    public boolean g;

    /* loaded from: classes2.dex */
    public enum Inclusion {
        WRAPPER_ARRAY,
        WRAPPER_OBJECT,
        METADATA_PROPERTY,
        PAYLOAD_PROPERTY,
        PARENT_PROPERTY;

        public boolean requiresObjectContext() {
            return this == METADATA_PROPERTY || this == PAYLOAD_PROPERTY;
        }
    }

    public WritableTypeId(Object obj, JsonToken jsonToken) {
        this.a = obj;
        this.f = jsonToken;
    }
}
