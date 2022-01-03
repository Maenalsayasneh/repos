package h0.v.a;

import i0.d.a.a.a;
/* compiled from: LayoutState.java */
/* loaded from: classes.dex */
public class o {
    public int b;
    public int c;
    public int d;
    public int e;
    public boolean h;
    public boolean i;
    public boolean a = true;
    public int f = 0;
    public int g = 0;

    public String toString() {
        StringBuilder P0 = a.P0("LayoutState{mAvailable=");
        P0.append(this.b);
        P0.append(", mCurrentPosition=");
        P0.append(this.c);
        P0.append(", mItemDirection=");
        P0.append(this.d);
        P0.append(", mLayoutDirection=");
        P0.append(this.e);
        P0.append(", mStartLine=");
        P0.append(this.f);
        P0.append(", mEndLine=");
        return a.s0(P0, this.g, '}');
    }
}
