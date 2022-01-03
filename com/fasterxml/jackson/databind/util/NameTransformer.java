package com.fasterxml.jackson.databind.util;

import i0.d.a.a.a;
import java.io.Serializable;
/* loaded from: classes2.dex */
public abstract class NameTransformer {
    public static final NameTransformer c = new NopTransformer();

    /* loaded from: classes2.dex */
    public static class Chained extends NameTransformer implements Serializable {
        public final NameTransformer d;
        public final NameTransformer q;

        public Chained(NameTransformer nameTransformer, NameTransformer nameTransformer2) {
            this.d = nameTransformer;
            this.q = nameTransformer2;
        }

        @Override // com.fasterxml.jackson.databind.util.NameTransformer
        public String a(String str) {
            return this.d.a(this.q.a(str));
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder P0 = a.P0("[ChainedTransformer(");
            P0.append(this.d);
            P0.append(", ");
            P0.append(this.q);
            P0.append(")]");
            return P0.toString();
        }
    }

    /* loaded from: classes2.dex */
    public static final class NopTransformer extends NameTransformer implements Serializable {
        @Override // com.fasterxml.jackson.databind.util.NameTransformer
        public String a(String str) {
            return str;
        }
    }

    public abstract String a(String str);
}
