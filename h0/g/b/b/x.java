package h0.g.b.b;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import h0.g.a.g.a.d;
import h0.g.b.b.r;
import h0.g.c.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: ViewTransition.java */
/* loaded from: classes.dex */
public class x {
    public int a;
    public int e;
    public g f;
    public c.a g;
    public int j;
    public String k;
    public Context o;
    public int b = -1;
    public boolean c = false;
    public int d = 0;
    public int h = -1;
    public int i = -1;
    public int l = 0;
    public String m = null;
    public int n = -1;
    public int p = -1;
    public int q = -1;
    public int r = -1;
    public int s = -1;
    public int t = -1;
    public int u = -1;

    /* compiled from: ViewTransition.java */
    /* loaded from: classes.dex */
    public static class a {
        public final int a;
        public final int b;
        public long c;
        public n d;
        public int e;
        public y g;
        public Interpolator h;
        public float j;
        public float k;
        public long l;
        public boolean n;
        public d f = new d();
        public boolean i = false;
        public Rect m = new Rect();

        public a(y yVar, n nVar, int i, int i2, int i3, Interpolator interpolator, int i4, int i5) {
            this.n = false;
            this.g = yVar;
            this.d = nVar;
            this.e = i2;
            long nanoTime = System.nanoTime();
            this.c = nanoTime;
            this.l = nanoTime;
            y yVar2 = this.g;
            if (yVar2.e == null) {
                yVar2.e = new ArrayList<>();
            }
            yVar2.e.add(this);
            this.h = interpolator;
            this.a = i4;
            this.b = i5;
            if (i3 == 3) {
                this.n = true;
            }
            this.k = i == 0 ? Float.MAX_VALUE : 1.0f / ((float) i);
            a();
        }

        public void a() {
            if (this.i) {
                long nanoTime = System.nanoTime();
                this.l = nanoTime;
                float f = this.j - (((float) (((double) (nanoTime - this.l)) * 1.0E-6d)) * this.k);
                this.j = f;
                if (f < 0.0f) {
                    this.j = 0.0f;
                }
                Interpolator interpolator = this.h;
                float interpolation = interpolator == null ? this.j : interpolator.getInterpolation(this.j);
                n nVar = this.d;
                boolean c = nVar.c(nVar.b, interpolation, nanoTime, this.f);
                if (this.j <= 0.0f) {
                    int i = this.a;
                    if (i != -1) {
                        this.d.b.setTag(i, Long.valueOf(System.nanoTime()));
                    }
                    int i2 = this.b;
                    if (i2 != -1) {
                        this.d.b.setTag(i2, null);
                    }
                    this.g.f.add(this);
                }
                if (this.j > 0.0f || c) {
                    this.g.a.invalidate();
                    return;
                }
                return;
            }
            long nanoTime2 = System.nanoTime();
            this.l = nanoTime2;
            float f2 = (((float) (((double) (nanoTime2 - this.l)) * 1.0E-6d)) * this.k) + this.j;
            this.j = f2;
            if (f2 >= 1.0f) {
                this.j = 1.0f;
            }
            Interpolator interpolator2 = this.h;
            float interpolation2 = interpolator2 == null ? this.j : interpolator2.getInterpolation(this.j);
            n nVar2 = this.d;
            boolean c2 = nVar2.c(nVar2.b, interpolation2, nanoTime2, this.f);
            if (this.j >= 1.0f) {
                int i3 = this.a;
                if (i3 != -1) {
                    this.d.b.setTag(i3, Long.valueOf(System.nanoTime()));
                }
                int i4 = this.b;
                if (i4 != -1) {
                    this.d.b.setTag(i4, null);
                }
                if (!this.n) {
                    this.g.f.add(this);
                }
            }
            if (this.j < 1.0f || c2) {
                this.g.a.invalidate();
            }
        }

        public void b(boolean z) {
            int i;
            this.i = z;
            if (z && (i = this.e) != -1) {
                this.k = i == 0 ? Float.MAX_VALUE : 1.0f / ((float) i);
            }
            this.g.a.invalidate();
            this.l = System.nanoTime();
        }
    }

    public x(Context context, XmlPullParser xmlPullParser) {
        boolean z;
        this.o = context;
        try {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    switch (name.hashCode()) {
                        case -1962203927:
                            if (name.equals("ConstraintOverride")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case -1239391468:
                            if (name.equals("KeyFrameSet")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 61998586:
                            if (name.equals("ViewTransition")) {
                                z = false;
                                break;
                            }
                            z = true;
                            break;
                        case 366511058:
                            if (name.equals("CustomMethod")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 1791837707:
                            if (name.equals("CustomAttribute")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        default:
                            z = true;
                            break;
                    }
                    if (!z) {
                        d(context, xmlPullParser);
                    } else if (z) {
                        this.f = new g(context, xmlPullParser);
                    } else if (z) {
                        this.g = c.d(context, xmlPullParser);
                    } else if (z || z) {
                        ConstraintAttribute.f(context, xmlPullParser, this.g.g);
                    } else {
                        Log.e("ViewTransition", g0.a.b.b.a.K() + " unknown tag " + name);
                        StringBuilder sb = new StringBuilder();
                        sb.append(".xml:");
                        sb.append(xmlPullParser.getLineNumber());
                        Log.e("ViewTransition", sb.toString());
                    }
                } else if (eventType != 3) {
                    continue;
                } else if ("ViewTransition".equals(xmlPullParser.getName())) {
                    return;
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    public void a(y yVar, MotionLayout motionLayout, int i, c cVar, View... viewArr) {
        Interpolator interpolator;
        Interpolator interpolator2;
        if (!this.c) {
            int i2 = this.e;
            if (i2 == 2) {
                View view = viewArr[0];
                n nVar = new n(view);
                q qVar = nVar.e;
                qVar.x = 0.0f;
                qVar.y = 0.0f;
                nVar.H = true;
                qVar.f(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
                nVar.f.f(view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
                nVar.g.g(view);
                nVar.h.g(view);
                ArrayList<d> arrayList = this.f.b.get(-1);
                if (arrayList != null) {
                    nVar.w.addAll(arrayList);
                }
                nVar.f(motionLayout.getWidth(), motionLayout.getHeight(), System.nanoTime());
                int i3 = this.h;
                int i4 = this.i;
                int i5 = this.b;
                Context context = motionLayout.getContext();
                int i6 = this.l;
                if (i6 == -2) {
                    interpolator2 = AnimationUtils.loadInterpolator(context, this.n);
                } else if (i6 == -1) {
                    interpolator = new w(this, h0.g.a.g.a.c.c(this.m));
                    new a(yVar, nVar, i3, i4, i5, interpolator, this.p, this.q);
                    return;
                } else if (i6 == 0) {
                    interpolator2 = new AccelerateDecelerateInterpolator();
                } else if (i6 == 1) {
                    interpolator2 = new AccelerateInterpolator();
                } else if (i6 == 2) {
                    interpolator2 = new DecelerateInterpolator();
                } else if (i6 == 4) {
                    interpolator2 = new BounceInterpolator();
                } else if (i6 == 5) {
                    interpolator2 = new OvershootInterpolator();
                } else if (i6 != 6) {
                    interpolator2 = null;
                } else {
                    interpolator2 = new AnticipateInterpolator();
                }
                interpolator = interpolator2;
                new a(yVar, nVar, i3, i4, i5, interpolator, this.p, this.q);
                return;
            }
            if (i2 == 1) {
                int[] constraintSetIds = motionLayout.getConstraintSetIds();
                for (int i7 : constraintSetIds) {
                    if (i7 != i) {
                        c A = motionLayout.A(i7);
                        for (View view2 : viewArr) {
                            c.a i8 = A.i(view2.getId());
                            c.a aVar = this.g;
                            if (aVar != null) {
                                c.a.C0064a aVar2 = aVar.h;
                                if (aVar2 != null) {
                                    aVar2.e(i8);
                                }
                                i8.g.putAll(this.g.g);
                            }
                        }
                    }
                }
            }
            c cVar2 = new c();
            cVar2.i.clear();
            for (Integer num : cVar.i.keySet()) {
                c.a aVar3 = cVar.i.get(num);
                if (aVar3 != null) {
                    cVar2.i.put(num, aVar3.clone());
                }
            }
            for (View view3 : viewArr) {
                c.a i9 = cVar2.i(view3.getId());
                c.a aVar4 = this.g;
                if (aVar4 != null) {
                    c.a.C0064a aVar5 = aVar4.h;
                    if (aVar5 != null) {
                        aVar5.e(i9);
                    }
                    i9.g.putAll(this.g.g);
                }
            }
            motionLayout.K(i, cVar2);
            int i10 = R.id.view_transition;
            motionLayout.K(i10, cVar);
            motionLayout.F(i10, -1, -1);
            r.b bVar = new r.b(-1, motionLayout.o2, i10, i);
            for (View view4 : viewArr) {
                int i11 = this.h;
                if (i11 != -1) {
                    bVar.h = Math.max(i11, 8);
                }
                bVar.p = this.d;
                int i12 = this.l;
                String str = this.m;
                int i13 = this.n;
                bVar.e = i12;
                bVar.f = str;
                bVar.g = i13;
                int id = view4.getId();
                g gVar = this.f;
                if (gVar != null) {
                    g gVar2 = new g();
                    Iterator<d> it = gVar.b.get(-1).iterator();
                    while (it.hasNext()) {
                        d b = it.next().clone();
                        b.b = id;
                        gVar2.b(b);
                    }
                    bVar.k.add(gVar2);
                }
            }
            motionLayout.setTransition(bVar);
            a aVar6 = new Runnable(viewArr) { // from class: h0.g.b.b.a
                public final /* synthetic */ View[] d;

                {
                    this.d = r2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    x xVar = x.this;
                    View[] viewArr2 = this.d;
                    if (xVar.p != -1) {
                        for (View view5 : viewArr2) {
                            view5.setTag(xVar.p, Long.valueOf(System.nanoTime()));
                        }
                    }
                    if (xVar.q != -1) {
                        for (View view6 : viewArr2) {
                            view6.setTag(xVar.q, null);
                        }
                    }
                }
            };
            motionLayout.u(1.0f);
            motionLayout.r3 = aVar6;
        }
    }

    public boolean b(View view) {
        int i = this.r;
        boolean z = i == -1 || view.getTag(i) != null;
        int i2 = this.s;
        return z && (i2 == -1 || view.getTag(i2) == null);
    }

    public boolean c(View view) {
        String str;
        if (view == null) {
            return false;
        }
        if ((this.j == -1 && this.k == null) || !b(view)) {
            return false;
        }
        if (view.getId() == this.j) {
            return true;
        }
        if (this.k != null && (view.getLayoutParams() instanceof ConstraintLayout.a) && (str = ((ConstraintLayout.a) view.getLayoutParams()).X) != null && str.matches(this.k)) {
            return true;
        }
        return false;
    }

    public final void d(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.ViewTransition);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.ViewTransition_android_id) {
                this.a = obtainStyledAttributes.getResourceId(index, this.a);
            } else if (index == R.styleable.ViewTransition_motionTarget) {
                if (MotionLayout.n2) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, this.j);
                    this.j = resourceId;
                    if (resourceId == -1) {
                        this.k = obtainStyledAttributes.getString(index);
                    }
                } else if (obtainStyledAttributes.peekValue(index).type == 3) {
                    this.k = obtainStyledAttributes.getString(index);
                } else {
                    this.j = obtainStyledAttributes.getResourceId(index, this.j);
                }
            } else if (index == R.styleable.ViewTransition_onStateTransition) {
                this.b = obtainStyledAttributes.getInt(index, this.b);
            } else if (index == R.styleable.ViewTransition_transitionDisable) {
                this.c = obtainStyledAttributes.getBoolean(index, this.c);
            } else if (index == R.styleable.ViewTransition_pathMotionArc) {
                this.d = obtainStyledAttributes.getInt(index, this.d);
            } else if (index == R.styleable.ViewTransition_duration) {
                this.h = obtainStyledAttributes.getInt(index, this.h);
            } else if (index == R.styleable.ViewTransition_upDuration) {
                this.i = obtainStyledAttributes.getInt(index, this.i);
            } else if (index == R.styleable.ViewTransition_viewTransitionMode) {
                this.e = obtainStyledAttributes.getInt(index, this.e);
            } else if (index == R.styleable.ViewTransition_motionInterpolator) {
                int i2 = obtainStyledAttributes.peekValue(index).type;
                if (i2 == 1) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, -1);
                    this.n = resourceId2;
                    if (resourceId2 != -1) {
                        this.l = -2;
                    }
                } else if (i2 == 3) {
                    String string = obtainStyledAttributes.getString(index);
                    this.m = string;
                    if (string == null || string.indexOf("/") <= 0) {
                        this.l = -1;
                    } else {
                        this.n = obtainStyledAttributes.getResourceId(index, -1);
                        this.l = -2;
                    }
                } else {
                    this.l = obtainStyledAttributes.getInteger(index, this.l);
                }
            } else if (index == R.styleable.ViewTransition_setsTag) {
                this.p = obtainStyledAttributes.getResourceId(index, this.p);
            } else if (index == R.styleable.ViewTransition_clearsTag) {
                this.q = obtainStyledAttributes.getResourceId(index, this.q);
            } else if (index == R.styleable.ViewTransition_ifTagSet) {
                this.r = obtainStyledAttributes.getResourceId(index, this.r);
            } else if (index == R.styleable.ViewTransition_ifTagNotSet) {
                this.s = obtainStyledAttributes.getResourceId(index, this.s);
            } else if (index == R.styleable.ViewTransition_SharedValueId) {
                this.u = obtainStyledAttributes.getResourceId(index, this.u);
            } else if (index == R.styleable.ViewTransition_SharedValue) {
                this.t = obtainStyledAttributes.getInteger(index, this.t);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public String toString() {
        StringBuilder P0 = i0.d.a.a.a.P0("ViewTransition(");
        P0.append(g0.a.b.b.a.N(this.o, this.a));
        P0.append(")");
        return P0.toString();
    }
}
