package com.instabug.library.bugreporting.model;
/* loaded from: classes2.dex */
public enum Bug$Type {
    BUG("bug"),
    FEEDBACK("feedback"),
    NOT_AVAILABLE("not-available");
    
    private final String name;

    Bug$Type(String str) {
        this.name = str;
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return this.name;
    }
}
