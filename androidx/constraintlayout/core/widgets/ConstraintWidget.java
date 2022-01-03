package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import h0.g.a.b;
import h0.g.a.d;
import h0.g.a.h.a;
import h0.g.a.h.e;
import h0.g.a.h.h;
import h0.g.a.h.i;
import h0.g.a.h.k.c;
import h0.g.a.h.k.j;
import h0.g.a.h.k.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
/* loaded from: classes.dex */
public class ConstraintWidget {
    public boolean A;
    public boolean A0;
    public boolean D0;
    public boolean E0;
    public boolean G;
    public ConstraintAnchor K;
    public ConstraintAnchor L;
    public ConstraintAnchor M;
    public ConstraintAnchor N;
    public ConstraintAnchor O;
    public ConstraintAnchor R;
    public ConstraintAnchor[] S;
    public DimensionBehaviour[] V;
    public c b;
    public c c;

    /* renamed from: i0  reason: collision with root package name */
    public int f2i0;

    /* renamed from: j0  reason: collision with root package name */
    public int f3j0;

    /* renamed from: m0  reason: collision with root package name */
    public Object f6m0;

    /* renamed from: r0  reason: collision with root package name */
    public int f11r0;

    /* renamed from: s0  reason: collision with root package name */
    public int f12s0;

    /* renamed from: t0  reason: collision with root package name */
    public int f13t0;

    /* renamed from: u0  reason: collision with root package name */
    public int f14u0;

    /* renamed from: v0  reason: collision with root package name */
    public boolean f15v0;
    public boolean w0;
    public boolean x0;
    public boolean y0;
    public boolean z;
    public boolean z0;
    public boolean a = false;
    public j d = null;
    public l e = null;
    public boolean[] f = {true, true};
    public boolean g = true;
    public int h = -1;
    public int i = -1;
    public boolean j = false;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;
    public int n = -1;
    public int o = -1;
    public int p = 0;
    public int q = 0;
    public int r = 0;
    public int[] s = new int[2];
    public int t = 0;
    public int u = 0;
    public float v = 1.0f;
    public int w = 0;
    public int x = 0;
    public float y = 1.0f;
    public int B = -1;
    public float C = 1.0f;
    public int[] D = {Integer.MAX_VALUE, Integer.MAX_VALUE};
    public float E = 0.0f;
    public boolean F = false;
    public boolean H = false;
    public int I = 0;
    public int J = 0;
    public ConstraintAnchor P = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
    public ConstraintAnchor Q = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
    public ArrayList<ConstraintAnchor> T = new ArrayList<>();
    public boolean[] U = new boolean[2];
    public ConstraintWidget W = null;
    public int X = 0;
    public int Y = 0;
    public float Z = 0.0f;
    public int a0 = -1;
    public int b0 = 0;
    public int c0 = 0;
    public int d0 = 0;
    public int e0 = 0;
    public int f0 = 0;

    /* renamed from: g0  reason: collision with root package name */
    public int f0g0 = 0;

    /* renamed from: h0  reason: collision with root package name */
    public int f1h0 = 0;

    /* renamed from: k0  reason: collision with root package name */
    public float f4k0 = 0.5f;

    /* renamed from: l0  reason: collision with root package name */
    public float f5l0 = 0.5f;

    /* renamed from: n0  reason: collision with root package name */
    public int f7n0 = 0;

    /* renamed from: o0  reason: collision with root package name */
    public int f8o0 = 0;

    /* renamed from: p0  reason: collision with root package name */
    public String f9p0 = null;

    /* renamed from: q0  reason: collision with root package name */
    public String f10q0 = null;
    public int B0 = 0;
    public int C0 = 0;
    public float[] F0 = {-1.0f, -1.0f};
    public ConstraintWidget[] G0 = {null, null};
    public ConstraintWidget[] H0 = {null, null};
    public ConstraintWidget I0 = null;
    public ConstraintWidget J0 = null;
    public int K0 = -1;
    public int L0 = -1;

    /* loaded from: classes.dex */
    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        new HashMap();
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.K = constraintAnchor;
        ConstraintAnchor constraintAnchor2 = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.L = constraintAnchor2;
        ConstraintAnchor constraintAnchor3 = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.M = constraintAnchor3;
        ConstraintAnchor constraintAnchor4 = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.N = constraintAnchor4;
        ConstraintAnchor constraintAnchor5 = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.O = constraintAnchor5;
        ConstraintAnchor constraintAnchor6 = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.R = constraintAnchor6;
        this.S = new ConstraintAnchor[]{constraintAnchor, constraintAnchor3, constraintAnchor2, constraintAnchor4, constraintAnchor5, constraintAnchor6};
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.V = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.T.add(this.K);
        this.T.add(this.L);
        this.T.add(this.M);
        this.T.add(this.N);
        this.T.add(this.P);
        this.T.add(this.Q);
        this.T.add(this.R);
        this.T.add(this.O);
    }

    public boolean A(int i, int i2) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i == 0) {
            ConstraintAnchor constraintAnchor3 = this.K.f;
            if (constraintAnchor3 != null && constraintAnchor3.c && (constraintAnchor2 = this.M.f) != null && constraintAnchor2.c) {
                return (constraintAnchor2.d() - this.M.e()) - (this.K.e() + this.K.f.d()) >= i2;
            }
        } else {
            ConstraintAnchor constraintAnchor4 = this.L.f;
            if (constraintAnchor4 != null && constraintAnchor4.c && (constraintAnchor = this.N.f) != null && constraintAnchor.c) {
                return (constraintAnchor.d() - this.N.e()) - (this.L.e() + this.L.f.d()) >= i2;
            }
        }
        return false;
    }

    public void B(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i, int i2) {
        n(type).b(constraintWidget.n(type2), i, i2, true);
    }

    public final boolean C(int i) {
        int i2 = i * 2;
        ConstraintAnchor[] constraintAnchorArr = this.S;
        if (!(constraintAnchorArr[i2].f == null || constraintAnchorArr[i2].f.f == constraintAnchorArr[i2])) {
            int i3 = i2 + 1;
            if (constraintAnchorArr[i3].f != null && constraintAnchorArr[i3].f.f == constraintAnchorArr[i3]) {
                return true;
            }
        }
        return false;
    }

    public boolean D() {
        ConstraintAnchor constraintAnchor = this.K;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f;
        if (constraintAnchor2 != null && constraintAnchor2.f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.M;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f;
        return constraintAnchor4 != null && constraintAnchor4.f == constraintAnchor3;
    }

    public boolean E() {
        ConstraintAnchor constraintAnchor = this.L;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f;
        if (constraintAnchor2 != null && constraintAnchor2.f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.N;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f;
        return constraintAnchor4 != null && constraintAnchor4.f == constraintAnchor3;
    }

    public boolean F() {
        return this.g && this.f8o0 != 8;
    }

    public boolean G() {
        return this.j || (this.K.c && this.M.c);
    }

    public boolean H() {
        return this.k || (this.L.c && this.N.c);
    }

    public void I() {
        this.K.k();
        this.L.k();
        this.M.k();
        this.N.k();
        this.O.k();
        this.P.k();
        this.Q.k();
        this.R.k();
        this.W = null;
        this.E = 0.0f;
        this.X = 0;
        this.Y = 0;
        this.Z = 0.0f;
        this.a0 = -1;
        this.b0 = 0;
        this.c0 = 0;
        this.f0 = 0;
        this.f0g0 = 0;
        this.f1h0 = 0;
        this.f2i0 = 0;
        this.f3j0 = 0;
        this.f4k0 = 0.5f;
        this.f5l0 = 0.5f;
        DimensionBehaviour[] dimensionBehaviourArr = this.V;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.f6m0 = null;
        this.f7n0 = 0;
        this.f8o0 = 0;
        this.f10q0 = null;
        this.z0 = false;
        this.A0 = false;
        this.B0 = 0;
        this.C0 = 0;
        this.D0 = false;
        this.E0 = false;
        float[] fArr = this.F0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.n = -1;
        this.o = -1;
        int[] iArr = this.D;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.q = 0;
        this.r = 0;
        this.v = 1.0f;
        this.y = 1.0f;
        this.u = Integer.MAX_VALUE;
        this.x = Integer.MAX_VALUE;
        this.t = 0;
        this.w = 0;
        this.B = -1;
        this.C = 1.0f;
        boolean[] zArr = this.f;
        zArr[0] = true;
        zArr[1] = true;
        this.H = false;
        boolean[] zArr2 = this.U;
        zArr2[0] = false;
        zArr2[1] = false;
        this.g = true;
        int[] iArr2 = this.s;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.h = -1;
        this.i = -1;
    }

    public void J() {
        ConstraintWidget constraintWidget = this.W;
        if (constraintWidget != null && (constraintWidget instanceof h0.g.a.h.c)) {
            Objects.requireNonNull((h0.g.a.h.c) constraintWidget);
        }
        int size = this.T.size();
        for (int i = 0; i < size; i++) {
            this.T.get(i).k();
        }
    }

    public void K() {
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        int size = this.T.size();
        for (int i = 0; i < size; i++) {
            ConstraintAnchor constraintAnchor = this.T.get(i);
            constraintAnchor.c = false;
            constraintAnchor.b = 0;
        }
    }

    public void L(h0.g.a.c cVar) {
        this.K.l();
        this.L.l();
        this.M.l();
        this.N.l();
        this.O.l();
        this.R.l();
        this.P.l();
        this.Q.l();
    }

    public void M(int i) {
        this.f1h0 = i;
        this.F = i > 0;
    }

    public void N(int i, int i2) {
        if (!this.j) {
            ConstraintAnchor constraintAnchor = this.K;
            constraintAnchor.b = i;
            constraintAnchor.c = true;
            ConstraintAnchor constraintAnchor2 = this.M;
            constraintAnchor2.b = i2;
            constraintAnchor2.c = true;
            this.b0 = i;
            this.X = i2 - i;
            this.j = true;
        }
    }

    public void O(int i, int i2) {
        if (!this.k) {
            ConstraintAnchor constraintAnchor = this.L;
            constraintAnchor.b = i;
            constraintAnchor.c = true;
            ConstraintAnchor constraintAnchor2 = this.N;
            constraintAnchor2.b = i2;
            constraintAnchor2.c = true;
            this.c0 = i;
            this.Y = i2 - i;
            if (this.F) {
                this.O.m(i + this.f1h0);
            }
            this.k = true;
        }
    }

    public void P(int i) {
        this.Y = i;
        int i2 = this.f3j0;
        if (i < i2) {
            this.Y = i2;
        }
    }

    public void Q(DimensionBehaviour dimensionBehaviour) {
        this.V[0] = dimensionBehaviour;
    }

    public void R(int i) {
        if (i < 0) {
            this.f3j0 = 0;
        } else {
            this.f3j0 = i;
        }
    }

    public void S(int i) {
        if (i < 0) {
            this.f2i0 = 0;
        } else {
            this.f2i0 = i;
        }
    }

    public void T(DimensionBehaviour dimensionBehaviour) {
        this.V[1] = dimensionBehaviour;
    }

    public void U(int i) {
        this.X = i;
        int i2 = this.f2i0;
        if (i < i2) {
            this.X = i2;
        }
    }

    public void V(boolean z, boolean z2) {
        int i;
        int i2;
        j jVar = this.d;
        boolean z3 = z & jVar.g;
        l lVar = this.e;
        boolean z4 = z2 & lVar.g;
        int i3 = jVar.h.g;
        int i4 = lVar.h.g;
        int i5 = jVar.i.g;
        int i6 = lVar.i.g;
        int i7 = i6 - i4;
        if (i5 - i3 < 0 || i7 < 0 || i3 == Integer.MIN_VALUE || i3 == Integer.MAX_VALUE || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE) {
            i5 = 0;
            i6 = 0;
            i3 = 0;
            i4 = 0;
        }
        int i8 = i5 - i3;
        int i9 = i6 - i4;
        if (z3) {
            this.b0 = i3;
        }
        if (z4) {
            this.c0 = i4;
        }
        if (this.f8o0 == 8) {
            this.X = 0;
            this.Y = 0;
            return;
        }
        if (z3) {
            if (this.V[0] == DimensionBehaviour.FIXED && i8 < (i2 = this.X)) {
                i8 = i2;
            }
            this.X = i8;
            int i10 = this.f2i0;
            if (i8 < i10) {
                this.X = i10;
            }
        }
        if (z4) {
            if (this.V[1] == DimensionBehaviour.FIXED && i9 < (i = this.Y)) {
                i9 = i;
            }
            this.Y = i9;
            int i11 = this.f3j0;
            if (i9 < i11) {
                this.Y = i11;
            }
        }
    }

    public void W(d dVar, boolean z) {
        int i;
        int i2;
        l lVar;
        j jVar;
        int o = dVar.o(this.K);
        int o2 = dVar.o(this.L);
        int o3 = dVar.o(this.M);
        int o4 = dVar.o(this.N);
        if (z && (jVar = this.d) != null) {
            DependencyNode dependencyNode = jVar.h;
            if (dependencyNode.j) {
                DependencyNode dependencyNode2 = jVar.i;
                if (dependencyNode2.j) {
                    o = dependencyNode.g;
                    o3 = dependencyNode2.g;
                }
            }
        }
        if (z && (lVar = this.e) != null) {
            DependencyNode dependencyNode3 = lVar.h;
            if (dependencyNode3.j) {
                DependencyNode dependencyNode4 = lVar.i;
                if (dependencyNode4.j) {
                    o2 = dependencyNode3.g;
                    o4 = dependencyNode4.g;
                }
            }
        }
        int i3 = o4 - o2;
        if (o3 - o < 0 || i3 < 0 || o == Integer.MIN_VALUE || o == Integer.MAX_VALUE || o2 == Integer.MIN_VALUE || o2 == Integer.MAX_VALUE || o3 == Integer.MIN_VALUE || o3 == Integer.MAX_VALUE || o4 == Integer.MIN_VALUE || o4 == Integer.MAX_VALUE) {
            o4 = 0;
            o = 0;
            o2 = 0;
            o3 = 0;
        }
        int i4 = o3 - o;
        int i5 = o4 - o2;
        this.b0 = o;
        this.c0 = o2;
        if (this.f8o0 == 8) {
            this.X = 0;
            this.Y = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.V;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        if (dimensionBehaviour == dimensionBehaviour2 && i4 < (i2 = this.X)) {
            i4 = i2;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && i5 < (i = this.Y)) {
            i5 = i;
        }
        this.X = i4;
        this.Y = i5;
        int i6 = this.f3j0;
        if (i5 < i6) {
            this.Y = i6;
        }
        int i7 = this.f2i0;
        if (i4 < i7) {
            this.X = i7;
        }
        int i8 = this.u;
        if (i8 > 0 && dimensionBehaviourArr[0] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.X = Math.min(this.X, i8);
        }
        int i9 = this.x;
        if (i9 > 0 && this.V[1] == DimensionBehaviour.MATCH_CONSTRAINT) {
            this.Y = Math.min(this.Y, i9);
        }
        int i10 = this.X;
        if (i4 != i10) {
            this.h = i10;
        }
        int i11 = this.Y;
        if (i5 != i11) {
            this.i = i11;
        }
    }

    public void d(h0.g.a.h.c cVar, d dVar, HashSet<ConstraintWidget> hashSet, int i, boolean z) {
        if (z) {
            if (hashSet.contains(this)) {
                h.a(cVar, dVar, this);
                hashSet.remove(this);
                f(dVar, cVar.h0(64));
            } else {
                return;
            }
        }
        if (i == 0) {
            HashSet<ConstraintAnchor> hashSet2 = this.K.a;
            if (hashSet2 != null) {
                Iterator<ConstraintAnchor> it = hashSet2.iterator();
                while (it.hasNext()) {
                    it.next().d.d(cVar, dVar, hashSet, i, true);
                }
            }
            HashSet<ConstraintAnchor> hashSet3 = this.M.a;
            if (hashSet3 != null) {
                Iterator<ConstraintAnchor> it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    it2.next().d.d(cVar, dVar, hashSet, i, true);
                }
                return;
            }
            return;
        }
        HashSet<ConstraintAnchor> hashSet4 = this.L.a;
        if (hashSet4 != null) {
            Iterator<ConstraintAnchor> it3 = hashSet4.iterator();
            while (it3.hasNext()) {
                it3.next().d.d(cVar, dVar, hashSet, i, true);
            }
        }
        HashSet<ConstraintAnchor> hashSet5 = this.N.a;
        if (hashSet5 != null) {
            Iterator<ConstraintAnchor> it4 = hashSet5.iterator();
            while (it4.hasNext()) {
                it4.next().d.d(cVar, dVar, hashSet, i, true);
            }
        }
        HashSet<ConstraintAnchor> hashSet6 = this.O.a;
        if (hashSet6 != null) {
            Iterator<ConstraintAnchor> it5 = hashSet6.iterator();
            while (it5.hasNext()) {
                it5.next().d.d(cVar, dVar, hashSet, i, true);
            }
        }
    }

    public boolean e() {
        return (this instanceof i) || (this instanceof e);
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x042d  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0435  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x04b6  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x051a  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x052e  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0530  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0533  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x05c6  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x05c9  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x060f  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x063a  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x0644  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0182  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void f(d dVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i;
        int i2;
        int i3;
        int i4;
        float f;
        int i5;
        int i6;
        boolean z7;
        int i7;
        SolverVariable solverVariable;
        char c;
        boolean z8;
        int i8;
        DimensionBehaviour dimensionBehaviour;
        boolean z9;
        boolean z10;
        boolean z11;
        DimensionBehaviour dimensionBehaviour2;
        SolverVariable solverVariable2;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        DimensionBehaviour dimensionBehaviour3;
        SolverVariable solverVariable5;
        SolverVariable solverVariable6;
        ConstraintWidget constraintWidget;
        d dVar2;
        SolverVariable solverVariable7;
        SolverVariable solverVariable8;
        int i9;
        int i10;
        int i11;
        int i12;
        SolverVariable solverVariable9;
        SolverVariable solverVariable10;
        SolverVariable solverVariable11;
        ConstraintWidget constraintWidget2;
        boolean z12;
        j jVar;
        DependencyNode dependencyNode;
        int i13;
        int i14;
        boolean z13;
        boolean z14;
        j jVar2;
        l lVar;
        DependencyNode dependencyNode2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        boolean z15;
        SolverVariable l = dVar.l(this.K);
        SolverVariable l2 = dVar.l(this.M);
        SolverVariable l3 = dVar.l(this.L);
        SolverVariable l4 = dVar.l(this.N);
        SolverVariable l5 = dVar.l(this.O);
        ConstraintWidget constraintWidget5 = this.W;
        if (constraintWidget5 != null) {
            boolean z16 = constraintWidget5 != null && constraintWidget5.V[0] == DimensionBehaviour.WRAP_CONTENT;
            boolean z17 = constraintWidget5 != null && constraintWidget5.V[1] == DimensionBehaviour.WRAP_CONTENT;
            int i15 = this.p;
            if (i15 == 1) {
                z2 = z16;
                z3 = false;
            } else if (i15 == 2) {
                z3 = z17;
                z2 = false;
            } else if (i15 != 3) {
                z3 = z17;
                z2 = z16;
            }
            if (this.f8o0 == 8) {
                int size = this.T.size();
                int i16 = 0;
                while (true) {
                    if (i16 >= size) {
                        z15 = false;
                        break;
                    } else if (this.T.get(i16).h()) {
                        z15 = true;
                        break;
                    } else {
                        i16++;
                    }
                }
                if (!z15) {
                    boolean[] zArr = this.U;
                    if (!zArr[0] && !zArr[1]) {
                        return;
                    }
                }
            }
            z4 = this.j;
            if (!z4 || this.k) {
                if (z4) {
                    dVar.e(l, this.b0);
                    dVar.e(l2, this.b0 + this.X);
                    if (z2 && (constraintWidget4 = this.W) != null) {
                        h0.g.a.h.c cVar = (h0.g.a.h.c) constraintWidget4;
                        cVar.b0(this.K);
                        cVar.a0(this.M);
                    }
                }
                if (this.k) {
                    dVar.e(l3, this.c0);
                    dVar.e(l4, this.c0 + this.Y);
                    if (this.O.h()) {
                        dVar.e(l5, this.c0 + this.f1h0);
                    }
                    if (z3 && (constraintWidget3 = this.W) != null) {
                        h0.g.a.h.c cVar2 = (h0.g.a.h.c) constraintWidget3;
                        cVar2.d0(this.L);
                        cVar2.c0(this.N);
                    }
                }
                if (this.j && this.k) {
                    this.j = false;
                    this.k = false;
                    return;
                }
            }
            if (!(!z || (jVar2 = this.d) == null || (lVar = this.e) == null)) {
                dependencyNode2 = jVar2.h;
                if (dependencyNode2.j && jVar2.i.j && lVar.h.j && lVar.i.j) {
                    dVar.e(l, dependencyNode2.g);
                    dVar.e(l2, this.d.i.g);
                    dVar.e(l3, this.e.h.g);
                    dVar.e(l4, this.e.i.g);
                    dVar.e(l5, this.e.k.g);
                    if (this.W != null) {
                        if (z2 && this.f[0] && !D()) {
                            dVar.f(dVar.l(this.W.M), l2, 0, 8);
                        }
                        if (z3 && this.f[1] && !E()) {
                            dVar.f(dVar.l(this.W.N), l4, 0, 8);
                        }
                    }
                    this.j = false;
                    this.k = false;
                    return;
                }
            }
            if (this.W == null) {
                if (C(0)) {
                    ((h0.g.a.h.c) this.W).Y(this, 0);
                    z13 = true;
                } else {
                    z13 = D();
                }
                if (C(1)) {
                    ((h0.g.a.h.c) this.W).Y(this, 1);
                    z14 = true;
                } else {
                    z14 = E();
                }
                if (!z13 && z2 && this.f8o0 != 8 && this.K.f == null && this.M.f == null) {
                    dVar.f(dVar.l(this.W.M), l2, 0, 1);
                }
                if (!z14 && z3 && this.f8o0 != 8 && this.L.f == null && this.N.f == null && this.O == null) {
                    dVar.f(dVar.l(this.W.N), l4, 0, 1);
                }
                z5 = z13;
                z6 = z14;
            } else {
                z6 = false;
                z5 = false;
            }
            i = this.X;
            i2 = this.f2i0;
            if (i >= i2) {
                i2 = i;
            }
            i3 = this.Y;
            i4 = this.f3j0;
            if (i3 >= i4) {
                i4 = i3;
            }
            DimensionBehaviour[] dimensionBehaviourArr = this.V;
            DimensionBehaviour dimensionBehaviour4 = dimensionBehaviourArr[0];
            int i17 = i2;
            DimensionBehaviour dimensionBehaviour5 = DimensionBehaviour.MATCH_CONSTRAINT;
            boolean z18 = dimensionBehaviour4 == dimensionBehaviour5;
            boolean z19 = dimensionBehaviourArr[1] == dimensionBehaviour5;
            int i18 = this.a0;
            this.B = i18;
            f = this.Z;
            this.C = f;
            int i19 = this.q;
            int i20 = this.r;
            if (f <= 0.0f) {
                solverVariable = l3;
                if (this.f8o0 != 8) {
                    if (dimensionBehaviourArr[0] == dimensionBehaviour5 && i19 == 0) {
                        i19 = 3;
                    }
                    if (dimensionBehaviourArr[1] == dimensionBehaviour5 && i20 == 0) {
                        i20 = 3;
                    }
                    if (dimensionBehaviourArr[0] != dimensionBehaviour5) {
                        i14 = 0;
                    } else if (dimensionBehaviourArr[1] == dimensionBehaviour5 && i19 == 3 && i20 == 3) {
                        if (i18 == -1) {
                            if (z18 && !z19) {
                                this.B = 0;
                            } else if (!z18 && z19) {
                                this.B = 1;
                                if (i18 == -1) {
                                    this.C = 1.0f / f;
                                }
                            }
                        }
                        if (this.B == 0 && (!this.L.i() || !this.N.i())) {
                            this.B = 1;
                        } else if (this.B == 1 && (!this.K.i() || !this.M.i())) {
                            this.B = 0;
                        }
                        if (this.B == -1 && (!this.L.i() || !this.N.i() || !this.K.i() || !this.M.i())) {
                            if (this.L.i() && this.N.i()) {
                                this.B = 0;
                            } else if (this.K.i() && this.M.i()) {
                                this.C = 1.0f / this.C;
                                this.B = 1;
                            }
                        }
                        if (this.B == -1) {
                            int i21 = this.t;
                            if (i21 > 0 && this.w == 0) {
                                this.B = 0;
                            } else if (i21 == 0 && this.w > 0) {
                                this.C = 1.0f / this.C;
                                this.B = 1;
                            }
                        }
                        c = 0;
                        i5 = i19;
                        i6 = i20;
                        i7 = i4;
                        z7 = true;
                        int[] iArr = this.s;
                        iArr[c] = i5;
                        iArr[1] = i6;
                        if (!z7) {
                            int i22 = this.B;
                            i8 = -1;
                            if (i22 == 0 || i22 == -1) {
                                z8 = true;
                                boolean z20 = !z7 && ((i13 = this.B) == 1 || i13 == i8);
                                DimensionBehaviour dimensionBehaviour6 = this.V[0];
                                dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
                                z9 = dimensionBehaviour6 != dimensionBehaviour && (this instanceof h0.g.a.h.c);
                                if (z9) {
                                    i17 = 0;
                                }
                                z10 = !this.R.i();
                                boolean[] zArr2 = this.U;
                                z11 = zArr2[0];
                                boolean z21 = zArr2[1];
                                if (this.n != 2 && !this.j) {
                                    if (z && (jVar = this.d) != null) {
                                        dependencyNode = jVar.h;
                                        if (dependencyNode.j && jVar.i.j) {
                                            if (z) {
                                                dVar.e(l, dependencyNode.g);
                                                dVar.e(l2, this.d.i.g);
                                                if (this.W != null && z2 && this.f[0] && !D()) {
                                                    dVar.f(dVar.l(this.W.M), l2, 0, 8);
                                                }
                                            }
                                        }
                                    }
                                    ConstraintWidget constraintWidget6 = this.W;
                                    SolverVariable l6 = constraintWidget6 == null ? dVar.l(constraintWidget6.M) : null;
                                    ConstraintWidget constraintWidget7 = this.W;
                                    SolverVariable l7 = constraintWidget7 == null ? dVar.l(constraintWidget7.K) : null;
                                    boolean z22 = this.f[0];
                                    DimensionBehaviour[] dimensionBehaviourArr2 = this.V;
                                    dimensionBehaviour3 = dimensionBehaviour5;
                                    solverVariable4 = l5;
                                    solverVariable3 = l4;
                                    dimensionBehaviour2 = dimensionBehaviour;
                                    solverVariable2 = solverVariable;
                                    solverVariable6 = l2;
                                    solverVariable5 = l;
                                    h(dVar, true, z2, z3, z22, l7, l6, dimensionBehaviourArr2[0], z9, this.K, this.M, this.b0, i17, this.f2i0, this.D[0], this.f4k0, z8, dimensionBehaviourArr2[1] != dimensionBehaviour5, z5, z6, z11, i5, i6, this.t, this.u, this.v, z10);
                                    if (z) {
                                        constraintWidget = this;
                                        l lVar2 = constraintWidget.e;
                                        if (lVar2 != null) {
                                            DependencyNode dependencyNode3 = lVar2.h;
                                            if (dependencyNode3.j && lVar2.i.j) {
                                                dVar2 = dVar;
                                                solverVariable7 = solverVariable2;
                                                dVar2.e(solverVariable7, dependencyNode3.g);
                                                solverVariable8 = solverVariable3;
                                                dVar2.e(solverVariable8, constraintWidget.e.i.g);
                                                solverVariable9 = solverVariable4;
                                                dVar2.e(solverVariable9, constraintWidget.e.k.g);
                                                ConstraintWidget constraintWidget8 = constraintWidget.W;
                                                if (constraintWidget8 == null || z6 || !z3) {
                                                    i12 = 8;
                                                    i10 = 0;
                                                    i9 = 1;
                                                } else {
                                                    i9 = 1;
                                                    if (constraintWidget.f[1]) {
                                                        i12 = 8;
                                                        i10 = 0;
                                                        dVar2.f(dVar2.l(constraintWidget8.N), solverVariable8, 0, 8);
                                                    } else {
                                                        i12 = 8;
                                                        i10 = 0;
                                                    }
                                                }
                                                i11 = i10;
                                                if ((constraintWidget.o != 2 ? i10 : i11) != 0 || constraintWidget.k) {
                                                    solverVariable11 = solverVariable8;
                                                    solverVariable10 = solverVariable7;
                                                } else {
                                                    boolean z23 = (constraintWidget.V[i9] != dimensionBehaviour2 || !(constraintWidget instanceof h0.g.a.h.c)) ? i10 : i9;
                                                    if (z23) {
                                                        i7 = i10;
                                                    }
                                                    ConstraintWidget constraintWidget9 = constraintWidget.W;
                                                    SolverVariable l8 = constraintWidget9 != null ? dVar2.l(constraintWidget9.N) : null;
                                                    ConstraintWidget constraintWidget10 = constraintWidget.W;
                                                    SolverVariable l9 = constraintWidget10 != null ? dVar2.l(constraintWidget10.L) : null;
                                                    int i23 = constraintWidget.f1h0;
                                                    if (i23 > 0 || constraintWidget.f8o0 == i12) {
                                                        ConstraintAnchor constraintAnchor = constraintWidget.O;
                                                        if (constraintAnchor.f != null) {
                                                            dVar2.d(solverVariable9, solverVariable7, i23, i12);
                                                            dVar2.d(solverVariable9, dVar2.l(constraintWidget.O.f), constraintWidget.O.e(), i12);
                                                            if (z3) {
                                                                dVar2.f(l8, dVar2.l(constraintWidget.N), i10, 5);
                                                            }
                                                            z12 = i10;
                                                            boolean z24 = constraintWidget.f[i9];
                                                            DimensionBehaviour[] dimensionBehaviourArr3 = constraintWidget.V;
                                                            solverVariable11 = solverVariable8;
                                                            solverVariable10 = solverVariable7;
                                                            h(dVar, false, z3, z2, z24, l9, l8, dimensionBehaviourArr3[i9], z23, constraintWidget.L, constraintWidget.N, constraintWidget.c0, i7, constraintWidget.f3j0, constraintWidget.D[i9], constraintWidget.f5l0, z20, dimensionBehaviourArr3[0] != dimensionBehaviour3, z6, z5, z21, i6, i5, constraintWidget.w, constraintWidget.x, constraintWidget.y, z12);
                                                        } else if (constraintWidget.f8o0 == i12) {
                                                            dVar2.d(solverVariable9, solverVariable7, constraintAnchor.e(), i12);
                                                        } else {
                                                            dVar2.d(solverVariable9, solverVariable7, i23, i12);
                                                        }
                                                    }
                                                    z12 = z10;
                                                    boolean z242 = constraintWidget.f[i9];
                                                    DimensionBehaviour[] dimensionBehaviourArr32 = constraintWidget.V;
                                                    solverVariable11 = solverVariable8;
                                                    solverVariable10 = solverVariable7;
                                                    h(dVar, false, z3, z2, z242, l9, l8, dimensionBehaviourArr32[i9], z23, constraintWidget.L, constraintWidget.N, constraintWidget.c0, i7, constraintWidget.f3j0, constraintWidget.D[i9], constraintWidget.f5l0, z20, dimensionBehaviourArr32[0] != dimensionBehaviour3, z6, z5, z21, i6, i5, constraintWidget.w, constraintWidget.x, constraintWidget.y, z12);
                                                }
                                                if (!z7) {
                                                    constraintWidget2 = this;
                                                    if (constraintWidget2.B == 1) {
                                                        dVar.h(solverVariable11, solverVariable10, solverVariable6, solverVariable5, constraintWidget2.C, 8);
                                                    } else {
                                                        dVar.h(solverVariable6, solverVariable5, solverVariable11, solverVariable10, constraintWidget2.C, 8);
                                                    }
                                                } else {
                                                    constraintWidget2 = this;
                                                }
                                                if (constraintWidget2.R.i()) {
                                                    ConstraintWidget constraintWidget11 = constraintWidget2.R.f.d;
                                                    int e = constraintWidget2.R.e();
                                                    ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
                                                    SolverVariable l10 = dVar.l(constraintWidget2.n(type));
                                                    ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
                                                    SolverVariable l11 = dVar.l(constraintWidget2.n(type2));
                                                    ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
                                                    SolverVariable l12 = dVar.l(constraintWidget2.n(type3));
                                                    ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
                                                    SolverVariable l13 = dVar.l(constraintWidget2.n(type4));
                                                    SolverVariable l14 = dVar.l(constraintWidget11.n(type));
                                                    SolverVariable l15 = dVar.l(constraintWidget11.n(type2));
                                                    SolverVariable l16 = dVar.l(constraintWidget11.n(type3));
                                                    SolverVariable l17 = dVar.l(constraintWidget11.n(type4));
                                                    b m = dVar.m();
                                                    double radians = (double) ((float) Math.toRadians((double) (constraintWidget2.E + 90.0f)));
                                                    double d = (double) e;
                                                    m.g(l11, l13, l15, l17, (float) (Math.sin(radians) * d));
                                                    dVar.c(m);
                                                    b m2 = dVar.m();
                                                    m2.g(l10, l12, l14, l16, (float) (Math.cos(radians) * d));
                                                    dVar.c(m2);
                                                }
                                                this.j = false;
                                                this.k = false;
                                            }
                                        }
                                        dVar2 = dVar;
                                        solverVariable9 = solverVariable4;
                                        solverVariable8 = solverVariable3;
                                        solverVariable7 = solverVariable2;
                                        i12 = 8;
                                        i10 = 0;
                                        i9 = 1;
                                    } else {
                                        i12 = 8;
                                        i10 = 0;
                                        i9 = 1;
                                        constraintWidget = this;
                                        dVar2 = dVar;
                                        solverVariable9 = solverVariable4;
                                        solverVariable8 = solverVariable3;
                                        solverVariable7 = solverVariable2;
                                    }
                                    i11 = i9;
                                    if ((constraintWidget.o != 2 ? i10 : i11) != 0) {
                                    }
                                    solverVariable11 = solverVariable8;
                                    solverVariable10 = solverVariable7;
                                    if (!z7) {
                                    }
                                    if (constraintWidget2.R.i()) {
                                    }
                                    this.j = false;
                                    this.k = false;
                                }
                                dimensionBehaviour3 = dimensionBehaviour5;
                                dimensionBehaviour2 = dimensionBehaviour;
                                solverVariable5 = l;
                                solverVariable4 = l5;
                                solverVariable3 = l4;
                                solverVariable2 = solverVariable;
                                solverVariable6 = l2;
                                if (z) {
                                }
                                i11 = i9;
                                if ((constraintWidget.o != 2 ? i10 : i11) != 0) {
                                }
                                solverVariable11 = solverVariable8;
                                solverVariable10 = solverVariable7;
                                if (!z7) {
                                }
                                if (constraintWidget2.R.i()) {
                                }
                                this.j = false;
                                this.k = false;
                            }
                        } else {
                            i8 = -1;
                        }
                        z8 = false;
                        if (!z7) {
                        }
                        DimensionBehaviour dimensionBehaviour62 = this.V[0];
                        dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
                        if (dimensionBehaviour62 != dimensionBehaviour) {
                        }
                        if (z9) {
                        }
                        z10 = !this.R.i();
                        boolean[] zArr22 = this.U;
                        z11 = zArr22[0];
                        boolean z212 = zArr22[1];
                        if (this.n != 2) {
                            if (z) {
                                dependencyNode = jVar.h;
                                if (dependencyNode.j) {
                                    if (z) {
                                    }
                                }
                            }
                            ConstraintWidget constraintWidget62 = this.W;
                            if (constraintWidget62 == null) {
                            }
                            ConstraintWidget constraintWidget72 = this.W;
                            if (constraintWidget72 == null) {
                            }
                            boolean z222 = this.f[0];
                            DimensionBehaviour[] dimensionBehaviourArr22 = this.V;
                            dimensionBehaviour3 = dimensionBehaviour5;
                            solverVariable4 = l5;
                            solverVariable3 = l4;
                            dimensionBehaviour2 = dimensionBehaviour;
                            solverVariable2 = solverVariable;
                            solverVariable6 = l2;
                            solverVariable5 = l;
                            h(dVar, true, z2, z3, z222, l7, l6, dimensionBehaviourArr22[0], z9, this.K, this.M, this.b0, i17, this.f2i0, this.D[0], this.f4k0, z8, dimensionBehaviourArr22[1] != dimensionBehaviour5, z5, z6, z11, i5, i6, this.t, this.u, this.v, z10);
                            if (z) {
                            }
                            i11 = i9;
                            if ((constraintWidget.o != 2 ? i10 : i11) != 0) {
                            }
                            solverVariable11 = solverVariable8;
                            solverVariable10 = solverVariable7;
                            if (!z7) {
                            }
                            if (constraintWidget2.R.i()) {
                            }
                            this.j = false;
                            this.k = false;
                        }
                        dimensionBehaviour3 = dimensionBehaviour5;
                        dimensionBehaviour2 = dimensionBehaviour;
                        solverVariable5 = l;
                        solverVariable4 = l5;
                        solverVariable3 = l4;
                        solverVariable2 = solverVariable;
                        solverVariable6 = l2;
                        if (z) {
                        }
                        i11 = i9;
                        if ((constraintWidget.o != 2 ? i10 : i11) != 0) {
                        }
                        solverVariable11 = solverVariable8;
                        solverVariable10 = solverVariable7;
                        if (!z7) {
                        }
                        if (constraintWidget2.R.i()) {
                        }
                        this.j = false;
                        this.k = false;
                    } else {
                        i14 = 0;
                    }
                    if (dimensionBehaviourArr[i14] == dimensionBehaviour5 && i19 == 3) {
                        this.B = i14;
                        i17 = (int) (f * ((float) i3));
                        if (dimensionBehaviourArr[1] != dimensionBehaviour5) {
                            i6 = i20;
                            i7 = i4;
                            i5 = 4;
                            c = 0;
                            z7 = false;
                        } else {
                            z7 = true;
                            i5 = i19;
                            i6 = i20;
                            i7 = i4;
                            c = 0;
                        }
                    } else {
                        if (dimensionBehaviourArr[1] == dimensionBehaviour5 && i20 == 3) {
                            this.B = 1;
                            if (i18 == -1) {
                                this.C = 1.0f / f;
                            }
                            c = 0;
                            i7 = (int) (this.C * ((float) i));
                            i5 = i19;
                            if (dimensionBehaviourArr[0] != dimensionBehaviour5) {
                                z7 = false;
                                i6 = 4;
                            } else {
                                i6 = i20;
                                z7 = true;
                            }
                        }
                        c = 0;
                        i5 = i19;
                        i6 = i20;
                        i7 = i4;
                        z7 = true;
                    }
                    int[] iArr2 = this.s;
                    iArr2[c] = i5;
                    iArr2[1] = i6;
                    if (!z7) {
                    }
                    z8 = false;
                    if (!z7) {
                    }
                    DimensionBehaviour dimensionBehaviour622 = this.V[0];
                    dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour622 != dimensionBehaviour) {
                    }
                    if (z9) {
                    }
                    z10 = !this.R.i();
                    boolean[] zArr222 = this.U;
                    z11 = zArr222[0];
                    boolean z2122 = zArr222[1];
                    if (this.n != 2) {
                    }
                    dimensionBehaviour3 = dimensionBehaviour5;
                    dimensionBehaviour2 = dimensionBehaviour;
                    solverVariable5 = l;
                    solverVariable4 = l5;
                    solverVariable3 = l4;
                    solverVariable2 = solverVariable;
                    solverVariable6 = l2;
                    if (z) {
                    }
                    i11 = i9;
                    if ((constraintWidget.o != 2 ? i10 : i11) != 0) {
                    }
                    solverVariable11 = solverVariable8;
                    solverVariable10 = solverVariable7;
                    if (!z7) {
                    }
                    if (constraintWidget2.R.i()) {
                    }
                    this.j = false;
                    this.k = false;
                }
            } else {
                solverVariable = l3;
            }
            c = 0;
            i5 = i19;
            i6 = i20;
            z7 = false;
            i7 = i4;
            int[] iArr22 = this.s;
            iArr22[c] = i5;
            iArr22[1] = i6;
            if (!z7) {
            }
            z8 = false;
            if (!z7) {
            }
            DimensionBehaviour dimensionBehaviour6222 = this.V[0];
            dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
            if (dimensionBehaviour6222 != dimensionBehaviour) {
            }
            if (z9) {
            }
            z10 = !this.R.i();
            boolean[] zArr2222 = this.U;
            z11 = zArr2222[0];
            boolean z21222 = zArr2222[1];
            if (this.n != 2) {
            }
            dimensionBehaviour3 = dimensionBehaviour5;
            dimensionBehaviour2 = dimensionBehaviour;
            solverVariable5 = l;
            solverVariable4 = l5;
            solverVariable3 = l4;
            solverVariable2 = solverVariable;
            solverVariable6 = l2;
            if (z) {
            }
            i11 = i9;
            if ((constraintWidget.o != 2 ? i10 : i11) != 0) {
            }
            solverVariable11 = solverVariable8;
            solverVariable10 = solverVariable7;
            if (!z7) {
            }
            if (constraintWidget2.R.i()) {
            }
            this.j = false;
            this.k = false;
        }
        z3 = false;
        z2 = false;
        if (this.f8o0 == 8) {
        }
        z4 = this.j;
        if (!z4) {
        }
        if (z4) {
        }
        if (this.k) {
        }
        if (this.j) {
            this.j = false;
            this.k = false;
            return;
        }
        if (!z) {
            dependencyNode2 = jVar2.h;
            if (dependencyNode2.j) {
                dVar.e(l, dependencyNode2.g);
                dVar.e(l2, this.d.i.g);
                dVar.e(l3, this.e.h.g);
                dVar.e(l4, this.e.i.g);
                dVar.e(l5, this.e.k.g);
                if (this.W != null) {
                }
                this.j = false;
                this.k = false;
                return;
            }
        }
        if (this.W == null) {
        }
        i = this.X;
        i2 = this.f2i0;
        if (i >= i2) {
        }
        i3 = this.Y;
        i4 = this.f3j0;
        if (i3 >= i4) {
        }
        DimensionBehaviour[] dimensionBehaviourArr4 = this.V;
        DimensionBehaviour dimensionBehaviour42 = dimensionBehaviourArr4[0];
        int i172 = i2;
        DimensionBehaviour dimensionBehaviour52 = DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour42 == dimensionBehaviour52) {
        }
        if (dimensionBehaviourArr4[1] == dimensionBehaviour52) {
        }
        int i182 = this.a0;
        this.B = i182;
        f = this.Z;
        this.C = f;
        int i192 = this.q;
        int i202 = this.r;
        if (f <= 0.0f) {
        }
        c = 0;
        i5 = i192;
        i6 = i202;
        z7 = false;
        i7 = i4;
        int[] iArr222 = this.s;
        iArr222[c] = i5;
        iArr222[1] = i6;
        if (!z7) {
        }
        z8 = false;
        if (!z7) {
        }
        DimensionBehaviour dimensionBehaviour62222 = this.V[0];
        dimensionBehaviour = DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour62222 != dimensionBehaviour) {
        }
        if (z9) {
        }
        z10 = !this.R.i();
        boolean[] zArr22222 = this.U;
        z11 = zArr22222[0];
        boolean z212222 = zArr22222[1];
        if (this.n != 2) {
        }
        dimensionBehaviour3 = dimensionBehaviour52;
        dimensionBehaviour2 = dimensionBehaviour;
        solverVariable5 = l;
        solverVariable4 = l5;
        solverVariable3 = l4;
        solverVariable2 = solverVariable;
        solverVariable6 = l2;
        if (z) {
        }
        i11 = i9;
        if ((constraintWidget.o != 2 ? i10 : i11) != 0) {
        }
        solverVariable11 = solverVariable8;
        solverVariable10 = solverVariable7;
        if (!z7) {
        }
        if (constraintWidget2.R.i()) {
        }
        this.j = false;
        this.k = false;
    }

    public boolean g() {
        return this.f8o0 != 8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:248:0x03fa, code lost:
        if ((r3 instanceof h0.g.a.h.a) != false) goto L_0x03ff;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01bc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x049f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:317:0x04bb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:327:0x04dc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:352:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:355:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c7  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void h(d dVar, boolean z, boolean z2, boolean z3, boolean z4, SolverVariable solverVariable, SolverVariable solverVariable2, DimensionBehaviour dimensionBehaviour, boolean z5, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i, int i2, int i3, int i4, float f, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i5, int i6, int i7, int i8, float f2, boolean z11) {
        SolverVariable solverVariable3;
        int i9;
        boolean z12;
        int i10;
        int i11;
        boolean z13;
        int i12;
        int i13;
        boolean z14;
        int i14;
        boolean z15;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        SolverVariable solverVariable6;
        int i15;
        int i16;
        ConstraintAnchor constraintAnchor3;
        DimensionBehaviour[] dimensionBehaviourArr;
        DimensionBehaviour dimensionBehaviour2;
        boolean z16;
        int i17;
        int i18;
        int i19;
        int i20;
        boolean z17;
        int i21;
        boolean z18;
        boolean z19;
        int i22;
        int i23;
        int i24;
        int i25;
        boolean z20;
        SolverVariable solverVariable7;
        boolean z21;
        boolean z22;
        SolverVariable solverVariable8;
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        boolean z23;
        int i26;
        int i27;
        boolean z24;
        SolverVariable solverVariable9;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5;
        int i28;
        int i29;
        ConstraintWidget constraintWidget6;
        int i30;
        int i31;
        int i32;
        boolean z25;
        boolean z26;
        int i33;
        SolverVariable solverVariable10;
        int i34;
        int i35;
        int i36;
        boolean z27;
        int i37;
        int i38;
        boolean z28;
        boolean z29;
        int i39;
        int i40;
        int i41;
        int i42;
        int i43;
        int i44;
        SolverVariable solverVariable11;
        SolverVariable solverVariable12;
        int i45 = i8;
        SolverVariable l = dVar.l(constraintAnchor);
        SolverVariable l2 = dVar.l(constraintAnchor2);
        SolverVariable l3 = dVar.l(constraintAnchor.f);
        SolverVariable l4 = dVar.l(constraintAnchor2.f);
        boolean i46 = constraintAnchor.i();
        boolean i47 = constraintAnchor2.i();
        boolean i48 = this.R.i();
        int i49 = i47 ? (i46 ? 1 : 0) + 1 : i46 ? 1 : 0;
        if (i48) {
            i49++;
        }
        if (z6) {
            solverVariable3 = l4;
            i9 = 3;
        } else {
            i9 = i5;
            solverVariable3 = l4;
        }
        int ordinal = dimensionBehaviour.ordinal();
        if (ordinal != 0 && ordinal != 1 && ordinal == 2) {
            if (i9 != 4) {
                z12 = true;
                i10 = this.h;
                if (i10 != -1 && z) {
                    this.h = -1;
                    i2 = i10;
                    z12 = false;
                }
                i11 = this.i;
                if (i11 != -1 || z) {
                    i11 = i2;
                } else {
                    this.i = -1;
                    z12 = false;
                }
                if (this.f8o0 != 8) {
                    i12 = 0;
                    z13 = false;
                } else {
                    z13 = z12;
                    i12 = i11;
                }
                if (!z11) {
                    if (!i46 && !i47 && !i48) {
                        dVar.e(l, i);
                    } else if (i46 && !i47) {
                        i13 = 8;
                        dVar.d(l, l3, constraintAnchor.e(), 8);
                    }
                    i13 = 8;
                } else {
                    i13 = 8;
                }
                if (z13) {
                    if (z5) {
                        dVar.d(l2, l, 0, 3);
                        if (i3 > 0) {
                            dVar.f(l2, l, i3, 8);
                        }
                        if (i4 < Integer.MAX_VALUE) {
                            dVar.g(l2, l, i4, 8);
                        }
                    } else {
                        dVar.d(l2, l, i12, i13);
                    }
                    i42 = i7;
                } else if (i49 == 2 || z6 || !(i9 == 1 || i9 == 0)) {
                    i42 = i7 == -2 ? i12 : i7;
                    i16 = i45 == -2 ? i12 : i45;
                    if (i12 > 0 && i9 != 1) {
                        i12 = 0;
                    }
                    if (i42 > 0) {
                        dVar.f(l2, l, i42, 8);
                        i12 = Math.max(i12, i42);
                    }
                    if (i16 > 0) {
                        if (!z2 || i9 != 1) {
                            i43 = 8;
                            dVar.g(l2, l, i16, 8);
                        } else {
                            i43 = 8;
                        }
                        i12 = Math.min(i12, i16);
                    } else {
                        i43 = 8;
                    }
                    if (i9 == 1) {
                        if (z2) {
                            dVar.d(l2, l, i12, i43);
                        } else if (z8) {
                            dVar.d(l2, l, i12, 5);
                            dVar.g(l2, l, i12, i43);
                        } else {
                            dVar.d(l2, l, i12, 5);
                            dVar.g(l2, l, i12, i43);
                        }
                        i45 = i16;
                    } else {
                        if (i9 == 2) {
                            ConstraintAnchor.Type type = constraintAnchor.e;
                            ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
                            if (type == type2 || type == ConstraintAnchor.Type.BOTTOM) {
                                solverVariable12 = dVar.l(this.W.n(type2));
                                solverVariable11 = dVar.l(this.W.n(ConstraintAnchor.Type.BOTTOM));
                            } else {
                                solverVariable12 = dVar.l(this.W.n(ConstraintAnchor.Type.LEFT));
                                solverVariable11 = dVar.l(this.W.n(ConstraintAnchor.Type.RIGHT));
                            }
                            b m = dVar.m();
                            i44 = i42;
                            i15 = i49;
                            boolean z30 = z13;
                            solverVariable5 = solverVariable3;
                            solverVariable4 = l3;
                            solverVariable6 = l2;
                            m.d(l2, l, solverVariable11, solverVariable12, f2);
                            dVar.c(m);
                            if (z2) {
                                z30 = false;
                            }
                            z15 = z4;
                            i16 = i16;
                            z14 = z30;
                        } else {
                            i44 = i42;
                            i15 = i49;
                            solverVariable4 = l3;
                            solverVariable6 = l2;
                            solverVariable5 = solverVariable3;
                            z14 = z13;
                            z15 = true;
                        }
                        i14 = i44;
                        if (!z11 && !z8) {
                            if (i46 || i47 || i48) {
                                if (i46 && !i47) {
                                    i17 = (!z2 || !(constraintAnchor.f.d instanceof a)) ? 5 : 8;
                                    z16 = z2;
                                    i18 = 0;
                                    if (z16) {
                                    }
                                } else if (i46 || !i47) {
                                    i20 = 0;
                                    if (i46 && i47) {
                                        ConstraintWidget constraintWidget7 = constraintAnchor.f.d;
                                        ConstraintWidget constraintWidget8 = constraintAnchor2.f.d;
                                        ConstraintWidget constraintWidget9 = this.W;
                                        if (z14) {
                                            if (i9 == 0) {
                                                if (i16 != 0 || i14 != 0) {
                                                    i40 = 8;
                                                    z28 = false;
                                                    i41 = 5;
                                                    i39 = 5;
                                                    z29 = true;
                                                    z18 = true;
                                                } else if (!solverVariable4.Z1 || !solverVariable5.Z1) {
                                                    i40 = 8;
                                                    z29 = false;
                                                    z18 = false;
                                                    i41 = 8;
                                                    i39 = 8;
                                                    z28 = true;
                                                } else {
                                                    dVar.d(l, solverVariable4, constraintAnchor.e(), 8);
                                                    dVar.d(solverVariable6, solverVariable5, -constraintAnchor2.e(), 8);
                                                    return;
                                                }
                                                if ((constraintWidget7 instanceof a) || (constraintWidget8 instanceof a)) {
                                                    i41 = 4;
                                                }
                                                i23 = 6;
                                                i21 = i39;
                                                z19 = z29;
                                                z17 = z28;
                                                i24 = 5;
                                                i22 = i41;
                                                i25 = i40;
                                                z20 = true;
                                            } else {
                                                i25 = 8;
                                                if (i9 == 2) {
                                                    i35 = ((constraintWidget7 instanceof a) || (constraintWidget8 instanceof a)) ? 4 : 5;
                                                    i34 = 5;
                                                } else if (i9 == 1) {
                                                    i34 = 8;
                                                    i35 = 4;
                                                } else if (i9 != 3) {
                                                    z20 = true;
                                                    solverVariable7 = solverVariable2;
                                                    i24 = 5;
                                                    z26 = false;
                                                    z25 = false;
                                                } else if (this.B == -1) {
                                                    i23 = z9 ? z2 ? 5 : 4 : 8;
                                                    i21 = 8;
                                                    z20 = true;
                                                    i24 = 5;
                                                    i22 = 5;
                                                    z19 = true;
                                                    z18 = true;
                                                    z17 = true;
                                                } else if (z6) {
                                                    if (i6 != 2) {
                                                        z20 = true;
                                                        if (i6 != 1) {
                                                            z27 = false;
                                                            if (z27) {
                                                                i37 = 8;
                                                                i38 = 5;
                                                            } else {
                                                                i38 = 4;
                                                                i37 = 5;
                                                            }
                                                            i22 = i38;
                                                            i21 = i37;
                                                            z19 = z20;
                                                            z18 = z19;
                                                            z17 = z18;
                                                            i23 = 6;
                                                            i24 = 5;
                                                        }
                                                    } else {
                                                        z20 = true;
                                                    }
                                                    z27 = z20;
                                                    if (z27) {
                                                    }
                                                    i22 = i38;
                                                    i21 = i37;
                                                    z19 = z20;
                                                    z18 = z19;
                                                    z17 = z18;
                                                    i23 = 6;
                                                    i24 = 5;
                                                } else {
                                                    z20 = true;
                                                    if (i16 > 0) {
                                                        i36 = 5;
                                                    } else if (i16 != 0 || i14 != 0) {
                                                        i36 = 4;
                                                    } else if (!z9) {
                                                        i36 = 8;
                                                    } else {
                                                        i21 = (constraintWidget7 == constraintWidget9 || constraintWidget8 == constraintWidget9) ? 5 : 4;
                                                        z19 = true;
                                                        z18 = true;
                                                        z17 = true;
                                                        i23 = 6;
                                                        i24 = 5;
                                                        i22 = 4;
                                                    }
                                                    i22 = i36;
                                                    z19 = true;
                                                    z18 = true;
                                                    z17 = true;
                                                    i23 = 6;
                                                    i24 = 5;
                                                    i21 = 5;
                                                }
                                                i22 = i35;
                                                i21 = i34;
                                                i23 = 6;
                                                z20 = true;
                                                i24 = 5;
                                                z19 = true;
                                                z18 = true;
                                                z17 = false;
                                            }
                                            solverVariable7 = solverVariable2;
                                            if (z18 || solverVariable4 != solverVariable5 || constraintWidget7 == constraintWidget9) {
                                                z21 = z18;
                                                z22 = z20;
                                            } else {
                                                z22 = false;
                                                z21 = false;
                                            }
                                            if (!z19) {
                                                if (z14 || z7 || z9 || solverVariable4 != solverVariable || solverVariable5 != solverVariable7) {
                                                    i32 = i23;
                                                    z16 = z2;
                                                } else {
                                                    i32 = i25;
                                                    i21 = i32;
                                                    z16 = false;
                                                    z22 = false;
                                                }
                                                i27 = i25;
                                                i26 = 4;
                                                z23 = z20;
                                                constraintWidget3 = constraintWidget9;
                                                constraintWidget2 = constraintWidget8;
                                                constraintWidget = constraintWidget7;
                                                solverVariable8 = l;
                                                dVar.b(l, solverVariable4, constraintAnchor.e(), f, solverVariable5, solverVariable6, constraintAnchor2.e(), i32);
                                            } else {
                                                z23 = z20;
                                                constraintWidget3 = constraintWidget9;
                                                constraintWidget2 = constraintWidget8;
                                                constraintWidget = constraintWidget7;
                                                solverVariable8 = l;
                                                i27 = i25;
                                                i26 = 4;
                                                z16 = z2;
                                            }
                                            z24 = z22;
                                            if (this.f8o0 == i27 || constraintAnchor2.h()) {
                                                if (!z21) {
                                                    if (!z16 || solverVariable4 == solverVariable5 || z14) {
                                                        constraintWidget4 = constraintWidget2;
                                                        constraintWidget5 = constraintWidget;
                                                    } else {
                                                        constraintWidget5 = constraintWidget;
                                                        if (!(constraintWidget5 instanceof a)) {
                                                            constraintWidget4 = constraintWidget2;
                                                        } else {
                                                            constraintWidget4 = constraintWidget2;
                                                        }
                                                        i31 = 6;
                                                        solverVariable9 = solverVariable8;
                                                        dVar.f(solverVariable9, solverVariable4, constraintAnchor.e(), i31);
                                                        dVar.g(solverVariable6, solverVariable5, -constraintAnchor2.e(), i31);
                                                        i21 = i31;
                                                    }
                                                    i31 = i21;
                                                    solverVariable9 = solverVariable8;
                                                    dVar.f(solverVariable9, solverVariable4, constraintAnchor.e(), i31);
                                                    dVar.g(solverVariable6, solverVariable5, -constraintAnchor2.e(), i31);
                                                    i21 = i31;
                                                } else {
                                                    constraintWidget4 = constraintWidget2;
                                                    constraintWidget5 = constraintWidget;
                                                    solverVariable9 = solverVariable8;
                                                }
                                                if (z16 || !z10 || (constraintWidget5 instanceof a) || (constraintWidget4 instanceof a)) {
                                                    constraintWidget6 = constraintWidget3;
                                                } else {
                                                    constraintWidget6 = constraintWidget3;
                                                    if (constraintWidget4 != constraintWidget6) {
                                                        i29 = 6;
                                                        i28 = 6;
                                                        z24 = z23;
                                                        if (z24) {
                                                            if (!z17 || (z9 && !z3)) {
                                                                i30 = i29;
                                                            } else {
                                                                int i50 = (constraintWidget5 == constraintWidget6 || constraintWidget4 == constraintWidget6) ? 6 : i29;
                                                                if ((constraintWidget5 instanceof e) || (constraintWidget4 instanceof e)) {
                                                                    i50 = 5;
                                                                }
                                                                if ((constraintWidget5 instanceof a) || (constraintWidget4 instanceof a)) {
                                                                    i50 = 5;
                                                                }
                                                                if (z9) {
                                                                    i50 = 5;
                                                                }
                                                                i30 = Math.max(i50, i29);
                                                            }
                                                            if (z16) {
                                                                i30 = Math.min(i28, i30);
                                                                if (z6 && !z9 && (constraintWidget5 == constraintWidget6 || constraintWidget4 == constraintWidget6)) {
                                                                    i30 = i26;
                                                                }
                                                            }
                                                            dVar.d(solverVariable9, solverVariable4, constraintAnchor.e(), i30);
                                                            dVar.d(solverVariable6, solverVariable5, -constraintAnchor2.e(), i30);
                                                        }
                                                        if (z16) {
                                                            int e = solverVariable == solverVariable4 ? constraintAnchor.e() : 0;
                                                            if (solverVariable4 != solverVariable) {
                                                                i19 = 5;
                                                                dVar.f(solverVariable9, solverVariable, e, 5);
                                                                if (z16 || !z14 || i3 != 0 || i14 != 0) {
                                                                    i18 = 0;
                                                                } else if (!z14 || i9 != 3) {
                                                                    i18 = 0;
                                                                    dVar.f(solverVariable6, solverVariable9, 0, i19);
                                                                } else {
                                                                    i18 = 0;
                                                                    dVar.f(solverVariable6, solverVariable9, 0, i27);
                                                                }
                                                                i17 = i19;
                                                                if (z16 && z15) {
                                                                    if (constraintAnchor2.f != null) {
                                                                        i18 = constraintAnchor2.e();
                                                                    }
                                                                    if (solverVariable5 != solverVariable2) {
                                                                        dVar.f(solverVariable2, solverVariable6, i18, i17);
                                                                        return;
                                                                    }
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                        }
                                                        i19 = 5;
                                                        if (z16) {
                                                        }
                                                        i18 = 0;
                                                        i17 = i19;
                                                        if (z16) {
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                }
                                                i29 = i22;
                                                i28 = i21;
                                                if (z24) {
                                                }
                                                if (z16) {
                                                }
                                                i19 = 5;
                                                if (z16) {
                                                }
                                                i18 = 0;
                                                i17 = i19;
                                                if (z16) {
                                                }
                                            } else {
                                                return;
                                            }
                                        } else {
                                            z20 = true;
                                            i25 = 8;
                                            if (!solverVariable4.Z1 || !solverVariable5.Z1) {
                                                solverVariable7 = solverVariable2;
                                                i24 = 5;
                                                z26 = true;
                                                z25 = true;
                                            } else {
                                                dVar.b(l, solverVariable4, constraintAnchor.e(), f, solverVariable5, solverVariable6, constraintAnchor2.e(), 8);
                                                if (z2 && z15) {
                                                    if (constraintAnchor2.f != null) {
                                                        i33 = constraintAnchor2.e();
                                                        solverVariable10 = solverVariable2;
                                                    } else {
                                                        solverVariable10 = solverVariable2;
                                                        i33 = 0;
                                                    }
                                                    if (solverVariable5 != solverVariable10) {
                                                        dVar.f(solverVariable10, solverVariable6, i33, 5);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        i21 = i24;
                                        z18 = z26;
                                        z19 = z25;
                                        i22 = 4;
                                        z17 = false;
                                        i23 = 6;
                                        if (z18) {
                                        }
                                        z21 = z18;
                                        z22 = z20;
                                        if (!z19) {
                                        }
                                        z24 = z22;
                                        if (this.f8o0 == i27) {
                                        }
                                        if (!z21) {
                                        }
                                        if (z16) {
                                        }
                                        constraintWidget6 = constraintWidget3;
                                        i29 = i22;
                                        i28 = i21;
                                        if (z24) {
                                        }
                                        if (z16) {
                                        }
                                        i19 = 5;
                                        if (z16) {
                                        }
                                        i18 = 0;
                                        i17 = i19;
                                        if (z16) {
                                        }
                                    }
                                    i18 = i20;
                                    i19 = 5;
                                    z16 = z2;
                                    i17 = i19;
                                    if (z16) {
                                    }
                                } else {
                                    dVar.d(solverVariable6, solverVariable5, -constraintAnchor2.e(), 8);
                                    if (z2) {
                                        dVar.f(l, solverVariable, 0, 5);
                                        i19 = 5;
                                        i18 = 0;
                                        z16 = z2;
                                        i17 = i19;
                                        if (z16) {
                                        }
                                    }
                                }
                            }
                            i20 = 0;
                            i18 = i20;
                            i19 = 5;
                            z16 = z2;
                            i17 = i19;
                            if (z16) {
                            }
                        } else if (i15 >= 2 && z2 && z15) {
                            dVar.f(l, solverVariable, 0, 8);
                            Object[] objArr = (z || this.O.f == null) ? 1 : null;
                            if (!z && (constraintAnchor3 = this.O.f) != null) {
                                ConstraintWidget constraintWidget10 = constraintAnchor3.d;
                                objArr = (constraintWidget10.Z != 0.0f && (dimensionBehaviourArr = constraintWidget10.V)[0] == (dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT) && dimensionBehaviourArr[1] == dimensionBehaviour2) ? 1 : null;
                            }
                            if (objArr != null) {
                                dVar.f(solverVariable2, solverVariable6, 0, 8);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                } else {
                    int max = Math.max(i7, i12);
                    if (i45 > 0) {
                        max = Math.min(i45, max);
                    }
                    dVar.d(l2, l, max, 8);
                    i42 = i7;
                    z13 = false;
                }
                i14 = i42;
                i16 = i45;
                i15 = i49;
                solverVariable4 = l3;
                solverVariable6 = l2;
                z14 = z13;
                solverVariable5 = solverVariable3;
                z15 = z4;
                if (!z11) {
                }
                if (i15 >= 2) {
                    return;
                }
                return;
            }
        }
        z12 = false;
        i10 = this.h;
        if (i10 != -1) {
            this.h = -1;
            i2 = i10;
            z12 = false;
        }
        i11 = this.i;
        if (i11 != -1) {
        }
        i11 = i2;
        if (this.f8o0 != 8) {
        }
        if (!z11) {
        }
        if (z13) {
        }
        i14 = i42;
        i16 = i45;
        i15 = i49;
        solverVariable4 = l3;
        solverVariable6 = l2;
        z14 = z13;
        solverVariable5 = solverVariable3;
        z15 = z4;
        if (!z11) {
        }
        if (i15 >= 2) {
        }
    }

    public void i(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i) {
        ConstraintAnchor.Type type3;
        ConstraintAnchor.Type type4;
        boolean z;
        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.CENTER;
        if (type != type5) {
            ConstraintAnchor.Type type6 = ConstraintAnchor.Type.CENTER_X;
            if (type == type6 && (type2 == (type4 = ConstraintAnchor.Type.LEFT) || type2 == ConstraintAnchor.Type.RIGHT)) {
                ConstraintAnchor n = n(type4);
                ConstraintAnchor n2 = constraintWidget.n(type2);
                ConstraintAnchor n3 = n(ConstraintAnchor.Type.RIGHT);
                n.a(n2, 0);
                n3.a(n2, 0);
                n(type6).a(n2, 0);
                return;
            }
            ConstraintAnchor.Type type7 = ConstraintAnchor.Type.CENTER_Y;
            if (type == type7 && (type2 == (type3 = ConstraintAnchor.Type.TOP) || type2 == ConstraintAnchor.Type.BOTTOM)) {
                ConstraintAnchor n4 = constraintWidget.n(type2);
                n(type3).a(n4, 0);
                n(ConstraintAnchor.Type.BOTTOM).a(n4, 0);
                n(type7).a(n4, 0);
            } else if (type == type6 && type2 == type6) {
                ConstraintAnchor.Type type8 = ConstraintAnchor.Type.LEFT;
                n(type8).a(constraintWidget.n(type8), 0);
                ConstraintAnchor.Type type9 = ConstraintAnchor.Type.RIGHT;
                n(type9).a(constraintWidget.n(type9), 0);
                n(type6).a(constraintWidget.n(type2), 0);
            } else if (type == type7 && type2 == type7) {
                ConstraintAnchor.Type type10 = ConstraintAnchor.Type.TOP;
                n(type10).a(constraintWidget.n(type10), 0);
                ConstraintAnchor.Type type11 = ConstraintAnchor.Type.BOTTOM;
                n(type11).a(constraintWidget.n(type11), 0);
                n(type7).a(constraintWidget.n(type2), 0);
            } else {
                ConstraintAnchor n5 = n(type);
                ConstraintAnchor n6 = constraintWidget.n(type2);
                if (n5.j(n6)) {
                    ConstraintAnchor.Type type12 = ConstraintAnchor.Type.BASELINE;
                    if (type == type12) {
                        ConstraintAnchor n7 = n(ConstraintAnchor.Type.TOP);
                        ConstraintAnchor n8 = n(ConstraintAnchor.Type.BOTTOM);
                        if (n7 != null) {
                            n7.k();
                        }
                        if (n8 != null) {
                            n8.k();
                        }
                    } else if (type == ConstraintAnchor.Type.TOP || type == ConstraintAnchor.Type.BOTTOM) {
                        ConstraintAnchor n9 = n(type12);
                        if (n9 != null) {
                            n9.k();
                        }
                        ConstraintAnchor n10 = n(type5);
                        if (n10.f != n6) {
                            n10.k();
                        }
                        ConstraintAnchor f = n(type).f();
                        ConstraintAnchor n11 = n(type7);
                        if (n11.i()) {
                            f.k();
                            n11.k();
                        }
                    } else if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                        ConstraintAnchor n12 = n(type5);
                        if (n12.f != n6) {
                            n12.k();
                        }
                        ConstraintAnchor f2 = n(type).f();
                        ConstraintAnchor n13 = n(type6);
                        if (n13.i()) {
                            f2.k();
                            n13.k();
                        }
                    }
                    n5.a(n6, i);
                }
            }
        } else if (type2 == type5) {
            ConstraintAnchor.Type type13 = ConstraintAnchor.Type.LEFT;
            ConstraintAnchor n14 = n(type13);
            ConstraintAnchor.Type type14 = ConstraintAnchor.Type.RIGHT;
            ConstraintAnchor n15 = n(type14);
            ConstraintAnchor.Type type15 = ConstraintAnchor.Type.TOP;
            ConstraintAnchor n16 = n(type15);
            ConstraintAnchor.Type type16 = ConstraintAnchor.Type.BOTTOM;
            ConstraintAnchor n17 = n(type16);
            boolean z2 = true;
            if ((n14 == null || !n14.i()) && (n15 == null || !n15.i())) {
                i(type13, constraintWidget, type13, 0);
                i(type14, constraintWidget, type14, 0);
                z = true;
            } else {
                z = false;
            }
            if ((n16 == null || !n16.i()) && (n17 == null || !n17.i())) {
                i(type15, constraintWidget, type15, 0);
                i(type16, constraintWidget, type16, 0);
            } else {
                z2 = false;
            }
            if (z && z2) {
                n(type5).a(constraintWidget.n(type5), 0);
            } else if (z) {
                ConstraintAnchor.Type type17 = ConstraintAnchor.Type.CENTER_X;
                n(type17).a(constraintWidget.n(type17), 0);
            } else if (z2) {
                ConstraintAnchor.Type type18 = ConstraintAnchor.Type.CENTER_Y;
                n(type18).a(constraintWidget.n(type18), 0);
            }
        } else {
            ConstraintAnchor.Type type19 = ConstraintAnchor.Type.LEFT;
            if (type2 == type19 || type2 == ConstraintAnchor.Type.RIGHT) {
                i(type19, constraintWidget, type2, 0);
                i(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
                n(type5).a(constraintWidget.n(type2), 0);
                return;
            }
            ConstraintAnchor.Type type20 = ConstraintAnchor.Type.TOP;
            if (type2 == type20 || type2 == ConstraintAnchor.Type.BOTTOM) {
                i(type20, constraintWidget, type2, 0);
                i(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                n(type5).a(constraintWidget.n(type2), 0);
            }
        }
    }

    public void j(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i) {
        if (constraintAnchor.d == this) {
            i(constraintAnchor.e, constraintAnchor2.d, constraintAnchor2.e, i);
        }
    }

    public void k(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        this.n = constraintWidget.n;
        this.o = constraintWidget.o;
        this.q = constraintWidget.q;
        this.r = constraintWidget.r;
        int[] iArr = this.s;
        int[] iArr2 = constraintWidget.s;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.t = constraintWidget.t;
        this.u = constraintWidget.u;
        this.w = constraintWidget.w;
        this.x = constraintWidget.x;
        this.y = constraintWidget.y;
        this.z = constraintWidget.z;
        this.A = constraintWidget.A;
        this.B = constraintWidget.B;
        this.C = constraintWidget.C;
        int[] iArr3 = constraintWidget.D;
        this.D = Arrays.copyOf(iArr3, iArr3.length);
        this.E = constraintWidget.E;
        this.F = constraintWidget.F;
        this.G = constraintWidget.G;
        this.K.k();
        this.L.k();
        this.M.k();
        this.N.k();
        this.O.k();
        this.P.k();
        this.Q.k();
        this.R.k();
        this.V = (DimensionBehaviour[]) Arrays.copyOf(this.V, 2);
        ConstraintWidget constraintWidget2 = null;
        this.W = this.W == null ? null : hashMap.get(constraintWidget.W);
        this.X = constraintWidget.X;
        this.Y = constraintWidget.Y;
        this.Z = constraintWidget.Z;
        this.a0 = constraintWidget.a0;
        this.b0 = constraintWidget.b0;
        this.c0 = constraintWidget.c0;
        this.d0 = constraintWidget.d0;
        this.e0 = constraintWidget.e0;
        this.f0 = constraintWidget.f0;
        this.f0g0 = constraintWidget.f0g0;
        this.f1h0 = constraintWidget.f1h0;
        this.f2i0 = constraintWidget.f2i0;
        this.f3j0 = constraintWidget.f3j0;
        this.f4k0 = constraintWidget.f4k0;
        this.f5l0 = constraintWidget.f5l0;
        this.f6m0 = constraintWidget.f6m0;
        this.f7n0 = constraintWidget.f7n0;
        this.f8o0 = constraintWidget.f8o0;
        this.f9p0 = constraintWidget.f9p0;
        this.f10q0 = constraintWidget.f10q0;
        this.f11r0 = constraintWidget.f11r0;
        this.f12s0 = constraintWidget.f12s0;
        this.f13t0 = constraintWidget.f13t0;
        this.f14u0 = constraintWidget.f14u0;
        this.f15v0 = constraintWidget.f15v0;
        this.w0 = constraintWidget.w0;
        this.x0 = constraintWidget.x0;
        this.y0 = constraintWidget.y0;
        this.z0 = constraintWidget.z0;
        this.A0 = constraintWidget.A0;
        this.B0 = constraintWidget.B0;
        this.C0 = constraintWidget.C0;
        this.D0 = constraintWidget.D0;
        this.E0 = constraintWidget.E0;
        float[] fArr = this.F0;
        float[] fArr2 = constraintWidget.F0;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.G0;
        ConstraintWidget[] constraintWidgetArr2 = constraintWidget.G0;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.H0;
        ConstraintWidget[] constraintWidgetArr4 = constraintWidget.H0;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget3 = constraintWidget.I0;
        this.I0 = constraintWidget3 == null ? null : hashMap.get(constraintWidget3);
        ConstraintWidget constraintWidget4 = constraintWidget.J0;
        if (constraintWidget4 != null) {
            constraintWidget2 = hashMap.get(constraintWidget4);
        }
        this.J0 = constraintWidget2;
    }

    public void l(d dVar) {
        dVar.l(this.K);
        dVar.l(this.L);
        dVar.l(this.M);
        dVar.l(this.N);
        if (this.f1h0 > 0) {
            dVar.l(this.O);
        }
    }

    public void m() {
        if (this.d == null) {
            this.d = new j(this);
        }
        if (this.e == null) {
            this.e = new l(this);
        }
    }

    public ConstraintAnchor n(ConstraintAnchor.Type type) {
        switch (type.ordinal()) {
            case 0:
                return null;
            case 1:
                return this.K;
            case 2:
                return this.L;
            case 3:
                return this.M;
            case 4:
                return this.N;
            case 5:
                return this.O;
            case 6:
                return this.R;
            case 7:
                return this.P;
            case 8:
                return this.Q;
            default:
                throw new AssertionError(type.name());
        }
    }

    public int o() {
        return y() + this.Y;
    }

    public DimensionBehaviour p(int i) {
        if (i == 0) {
            return r();
        }
        if (i == 1) {
            return v();
        }
        return null;
    }

    public int q() {
        if (this.f8o0 == 8) {
            return 0;
        }
        return this.Y;
    }

    public DimensionBehaviour r() {
        return this.V[0];
    }

    public ConstraintWidget s(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i == 0) {
            ConstraintAnchor constraintAnchor3 = this.M;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.f;
            if (constraintAnchor4 == null || constraintAnchor4.f != constraintAnchor3) {
                return null;
            }
            return constraintAnchor4.d;
        } else if (i == 1 && (constraintAnchor2 = (constraintAnchor = this.N).f) != null && constraintAnchor2.f == constraintAnchor) {
            return constraintAnchor2.d;
        } else {
            return null;
        }
    }

    public ConstraintWidget t(int i) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i == 0) {
            ConstraintAnchor constraintAnchor3 = this.K;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.f;
            if (constraintAnchor4 == null || constraintAnchor4.f != constraintAnchor3) {
                return null;
            }
            return constraintAnchor4.d;
        } else if (i == 1 && (constraintAnchor2 = (constraintAnchor = this.L).f) != null && constraintAnchor2.f == constraintAnchor) {
            return constraintAnchor2.d;
        } else {
            return null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = "";
        sb.append(this.f10q0 != null ? i0.d.a.a.a.y0(i0.d.a.a.a.P0("type: "), this.f10q0, " ") : str);
        if (this.f9p0 != null) {
            str = i0.d.a.a.a.y0(i0.d.a.a.a.P0("id: "), this.f9p0, " ");
        }
        sb.append(str);
        sb.append("(");
        sb.append(this.b0);
        sb.append(", ");
        sb.append(this.c0);
        sb.append(") - (");
        sb.append(this.X);
        sb.append(" x ");
        return i0.d.a.a.a.u0(sb, this.Y, ")");
    }

    public int u() {
        return x() + this.X;
    }

    public DimensionBehaviour v() {
        return this.V[1];
    }

    public int w() {
        if (this.f8o0 == 8) {
            return 0;
        }
        return this.X;
    }

    public int x() {
        ConstraintWidget constraintWidget = this.W;
        if (constraintWidget == null || !(constraintWidget instanceof h0.g.a.h.c)) {
            return this.b0;
        }
        return ((h0.g.a.h.c) constraintWidget).T0 + this.b0;
    }

    public int y() {
        ConstraintWidget constraintWidget = this.W;
        if (constraintWidget == null || !(constraintWidget instanceof h0.g.a.h.c)) {
            return this.c0;
        }
        return ((h0.g.a.h.c) constraintWidget).U0 + this.c0;
    }

    public boolean z(int i) {
        if (i == 0) {
            return (this.K.f != null ? 1 : 0) + (this.M.f != null ? 1 : 0) < 2;
        }
        return ((this.L.f != null ? 1 : 0) + (this.N.f != null ? 1 : 0)) + (this.O.f != null ? 1 : 0) < 2;
    }
}
