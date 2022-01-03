package com.fasterxml.jackson.databind.cfg;

import java.io.Serializable;
/* loaded from: classes2.dex */
public final class ConstructorDetector implements Serializable {
    public static final ConstructorDetector c = new ConstructorDetector(SingleArgConstructor.HEURISTIC);
    public final SingleArgConstructor d;

    /* loaded from: classes2.dex */
    public enum SingleArgConstructor {
        DELEGATING,
        PROPERTIES,
        HEURISTIC,
        REQUIRE_MODE
    }

    static {
        SingleArgConstructor singleArgConstructor = SingleArgConstructor.PROPERTIES;
        SingleArgConstructor singleArgConstructor2 = SingleArgConstructor.DELEGATING;
        SingleArgConstructor singleArgConstructor3 = SingleArgConstructor.REQUIRE_MODE;
    }

    public ConstructorDetector(SingleArgConstructor singleArgConstructor) {
        this.d = singleArgConstructor;
    }
}
