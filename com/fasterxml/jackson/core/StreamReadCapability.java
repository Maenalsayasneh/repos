package com.fasterxml.jackson.core;

import i0.f.a.b.m.e;
/* loaded from: classes2.dex */
public enum StreamReadCapability implements e {
    DUPLICATE_PROPERTIES(false),
    SCALARS_AS_OBJECTS(false),
    UNTYPED_SCALARS(false);
    
    private final boolean _defaultState;
    private final int _mask = 1 << ordinal();

    StreamReadCapability(boolean z) {
        this._defaultState = z;
    }

    @Override // i0.f.a.b.m.e
    public boolean enabledByDefault() {
        return this._defaultState;
    }

    public boolean enabledIn(int i) {
        return (i & this._mask) != 0;
    }

    @Override // i0.f.a.b.m.e
    public int getMask() {
        return this._mask;
    }
}
