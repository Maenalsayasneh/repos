package com.fasterxml.jackson.databind.util;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;
/* loaded from: classes2.dex */
public final class IgnorePropertiesUtil$Checker implements Serializable {
    public final Set<String> c;
    public final Set<String> d;

    public IgnorePropertiesUtil$Checker(Set<String> set, Set<String> set2) {
        this.c = set == null ? Collections.emptySet() : set;
        this.d = set2;
    }

    public boolean a(Object obj) {
        Set<String> set = this.d;
        return (set != null && !set.contains(obj)) || this.c.contains(obj);
    }
}
