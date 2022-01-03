package com.nimbusds.jose;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class Algorithm implements Serializable {
    public static final Algorithm c = new Algorithm("none", Requirement.REQUIRED);
    public final String d;

    public Algorithm(String str, Requirement requirement) {
        if (str != null) {
            this.d = str;
            return;
        }
        throw new IllegalArgumentException("The algorithm name must not be null");
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        return (obj instanceof Algorithm) && this.d.equals(obj.toString());
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return this.d.hashCode();
    }

    @Override // java.lang.Object
    public final String toString() {
        return this.d;
    }
}
