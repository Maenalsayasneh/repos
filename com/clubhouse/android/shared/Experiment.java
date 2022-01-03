package com.clubhouse.android.shared;
/* compiled from: Experimentation.kt */
/* loaded from: classes3.dex */
public enum Experiment {
    UniversalSearch("auto-exp-universal-search");
    
    private final String key;

    Experiment(String str) {
        this.key = str;
    }

    public final String getKey() {
        return this.key;
    }
}
