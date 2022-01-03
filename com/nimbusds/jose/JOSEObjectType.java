package com.nimbusds.jose;

import java.io.Serializable;
/* loaded from: classes2.dex */
public final class JOSEObjectType implements Serializable {
    public final String c;

    public JOSEObjectType(String str) {
        this.c = str;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        return (obj instanceof JOSEObjectType) && this.c.equalsIgnoreCase(((JOSEObjectType) obj).c);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.c.toLowerCase().hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        return this.c;
    }
}
