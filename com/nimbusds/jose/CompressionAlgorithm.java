package com.nimbusds.jose;

import java.io.Serializable;
/* loaded from: classes2.dex */
public final class CompressionAlgorithm implements Serializable {
    public static final CompressionAlgorithm c = new CompressionAlgorithm("DEF");
    public final String d;

    public CompressionAlgorithm(String str) {
        this.d = str;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        return (obj instanceof CompressionAlgorithm) && this.d.equals(obj.toString());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.d.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        return this.d;
    }
}
