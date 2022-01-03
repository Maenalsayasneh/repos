package kotlinx.serialization.json.internal;

import m0.r.t.a.r.m.a1.a;
/* compiled from: WriteMode.kt */
/* loaded from: classes4.dex */
public enum WriteMode {
    OBJ('{', '}'),
    LIST('[', ']'),
    MAP('{', '}'),
    POLY_OBJ('[', ']');
    
    public final char begin;
    public final byte beginTc;
    public final char end;
    public final byte endTc;

    WriteMode(char c, char c2) {
        this.begin = c;
        this.end = c2;
        this.beginTc = a.v0(c);
        this.endTc = a.v0(c2);
    }
}
