package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.core.app.TaskStackBuilder;
import androidx.lifecycle.Lifecycle;
import h0.q.n;
import h0.q.n0;
import h0.q.o;
import h0.t.c;
import h0.t.d;
import h0.t.f;
import h0.t.g;
import h0.t.i;
import h0.t.j;
import h0.t.k;
import h0.t.m;
import h0.t.p;
import h0.t.q;
import h0.t.s;
import h0.t.t;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class NavController {
    public final Context a;
    public Activity b;
    public p c;
    public m d;
    public Bundle e;
    public Parcelable[] f;
    public boolean g;
    public h0.q.p i;
    public g j;
    public final Deque<f> h = new ArrayDeque();
    public t k = new t();
    public final CopyOnWriteArrayList<b> l = new CopyOnWriteArrayList<>();
    public final o m = new n() { // from class: androidx.navigation.NavController.1
        @Override // h0.q.n
        public void a(h0.q.p pVar, Lifecycle.Event event) {
            Lifecycle.State state;
            NavController navController = NavController.this;
            if (navController.d != null) {
                for (f fVar : navController.h) {
                    Objects.requireNonNull(fVar);
                    int ordinal = event.ordinal();
                    if (ordinal != 0) {
                        if (ordinal != 1) {
                            if (ordinal == 2) {
                                state = Lifecycle.State.RESUMED;
                            } else if (ordinal != 3) {
                                if (ordinal != 4) {
                                    if (ordinal == 5) {
                                        state = Lifecycle.State.DESTROYED;
                                    } else {
                                        throw new IllegalArgumentException("Unexpected event value " + event);
                                    }
                                }
                            }
                            fVar.Z1 = state;
                            fVar.b();
                        }
                        state = Lifecycle.State.STARTED;
                        fVar.Z1 = state;
                        fVar.b();
                    }
                    state = Lifecycle.State.CREATED;
                    fVar.Z1 = state;
                    fVar.b();
                }
            }
        }
    };
    public final h0.a.b n = new a(false);
    public boolean o = true;

    /* loaded from: classes.dex */
    public class a extends h0.a.b {
        public a(boolean z) {
            super(z);
        }

        @Override // h0.a.b
        public void a() {
            NavController.this.l();
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(NavController navController, k kVar, Bundle bundle);
    }

    public NavController(Context context) {
        this.a = context;
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                break;
            } else if (context instanceof Activity) {
                this.b = (Activity) context;
                break;
            } else {
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        t tVar = this.k;
        tVar.a(new h0.t.n(tVar));
        this.k.a(new h0.t.b(this.a));
    }

    public final boolean a() {
        while (!this.h.isEmpty() && (this.h.peekLast().d instanceof m) && n(this.h.peekLast().d.q, true)) {
        }
        if (this.h.isEmpty()) {
            return false;
        }
        k kVar = this.h.peekLast().d;
        k kVar2 = null;
        if (kVar instanceof c) {
            Iterator<f> descendingIterator = this.h.descendingIterator();
            while (true) {
                if (!descendingIterator.hasNext()) {
                    break;
                }
                k kVar3 = descendingIterator.next().d;
                if (!((kVar3 instanceof m) || (kVar3 instanceof c))) {
                    kVar2 = kVar3;
                    break;
                }
            }
        }
        HashMap hashMap = new HashMap();
        Iterator<f> descendingIterator2 = this.h.descendingIterator();
        while (descendingIterator2.hasNext()) {
            f next = descendingIterator2.next();
            Lifecycle.State state = next.a2;
            k kVar4 = next.d;
            if (kVar != null && kVar4.q == kVar.q) {
                Lifecycle.State state2 = Lifecycle.State.RESUMED;
                if (state != state2) {
                    hashMap.put(next, state2);
                }
                kVar = kVar.d;
            } else if (kVar2 == null || kVar4.q != kVar2.q) {
                next.a2 = Lifecycle.State.CREATED;
                next.b();
            } else {
                if (state == Lifecycle.State.RESUMED) {
                    next.a2 = Lifecycle.State.STARTED;
                    next.b();
                } else {
                    Lifecycle.State state3 = Lifecycle.State.STARTED;
                    if (state != state3) {
                        hashMap.put(next, state3);
                    }
                }
                kVar2 = kVar2.d;
            }
        }
        for (f fVar : this.h) {
            Lifecycle.State state4 = (Lifecycle.State) hashMap.get(fVar);
            if (state4 != null) {
                fVar.a2 = state4;
                fVar.b();
            } else {
                fVar.b();
            }
        }
        f peekLast = this.h.peekLast();
        Iterator<b> it = this.l.iterator();
        while (it.hasNext()) {
            it.next().a(this, peekLast.d, peekLast.q);
        }
        return true;
    }

    public k b(int i) {
        k kVar;
        m mVar;
        m mVar2 = this.d;
        if (mVar2 == null) {
            return null;
        }
        if (mVar2.q == i) {
            return mVar2;
        }
        if (this.h.isEmpty()) {
            kVar = this.d;
        } else {
            kVar = this.h.getLast().d;
        }
        if (kVar instanceof m) {
            mVar = (m) kVar;
        } else {
            mVar = kVar.d;
        }
        return mVar.t(i, true);
    }

    public f c() {
        if (this.h.isEmpty()) {
            return null;
        }
        return this.h.getLast();
    }

    public k d() {
        f c = c();
        if (c != null) {
            return c.d;
        }
        return null;
    }

    public final int e() {
        int i = 0;
        for (f fVar : this.h) {
            if (!(fVar.d instanceof m)) {
                i++;
            }
        }
        return i;
    }

    public p f() {
        if (this.c == null) {
            this.c = new p(this.a, this.k);
        }
        return this.c;
    }

    public boolean g(Intent intent) {
        String str;
        m mVar;
        k kVar;
        m mVar2;
        k.a k;
        int i = 0;
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        int[] intArray = extras != null ? extras.getIntArray("android-support-nav:controller:deepLinkIds") : null;
        Bundle bundle = new Bundle();
        Bundle bundle2 = extras != null ? extras.getBundle("android-support-nav:controller:deepLinkExtras") : null;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (!((intArray != null && intArray.length != 0) || intent.getData() == null || (k = this.d.k(new j(intent.getData(), intent.getAction(), intent.getType()))) == null)) {
            k kVar2 = k.c;
            int[] c = kVar2.c();
            bundle.putAll(kVar2.b(k.d));
            intArray = c;
        }
        if (intArray == null || intArray.length == 0) {
            return false;
        }
        m mVar3 = this.d;
        int i2 = 0;
        while (true) {
            if (i2 >= intArray.length) {
                str = null;
                break;
            }
            int i3 = intArray[i2];
            if (i2 == 0) {
                kVar = this.d;
                if (kVar.q != i3) {
                    kVar = null;
                }
            } else {
                kVar = mVar3.s(i3);
            }
            if (kVar == null) {
                str = k.j(this.a, i3);
                break;
            }
            if (i2 != intArray.length - 1) {
                while (true) {
                    mVar2 = (m) kVar;
                    if (!(mVar2.s(mVar2.c2) instanceof m)) {
                        break;
                    }
                    kVar = mVar2.s(mVar2.c2);
                }
                mVar3 = mVar2;
            }
            i2++;
        }
        if (str != null) {
            Log.i("NavController", "Could not find destination " + str + " in the navigation graph, ignoring the deep link from " + intent);
            return false;
        }
        bundle.putParcelable("android-support-nav:controller:deepLinkIntent", intent);
        int flags = intent.getFlags();
        int i4 = 268435456 & flags;
        if (i4 != 0 && (flags & 32768) == 0) {
            intent.addFlags(32768);
            TaskStackBuilder.create(this.a).addNextIntentWithParentStack(intent).startActivities();
            Activity activity = this.b;
            if (activity != null) {
                activity.finish();
                this.b.overridePendingTransition(0, 0);
            }
            return true;
        } else if (i4 != 0) {
            if (!this.h.isEmpty()) {
                n(this.d.q, true);
            }
            while (i < intArray.length) {
                int i5 = i + 1;
                int i6 = intArray[i];
                k b2 = b(i6);
                if (b2 != null) {
                    j(b2, bundle, new q(false, -1, false, 0, 0, -1, -1), null);
                    i = i5;
                } else {
                    StringBuilder T0 = i0.d.a.a.a.T0("Deep Linking failed: destination ", k.j(this.a, i6), " cannot be found from the current destination ");
                    T0.append(d());
                    throw new IllegalStateException(T0.toString());
                }
            }
            return true;
        } else {
            m mVar4 = this.d;
            while (i < intArray.length) {
                int i7 = intArray[i];
                k s = i == 0 ? this.d : mVar4.s(i7);
                if (s != null) {
                    if (i != intArray.length - 1) {
                        while (true) {
                            mVar = (m) s;
                            if (!(mVar.s(mVar.c2) instanceof m)) {
                                break;
                            }
                            s = mVar.s(mVar.c2);
                        }
                        mVar4 = mVar;
                    } else {
                        j(s, s.b(bundle), new q(false, this.d.q, true, 0, 0, -1, -1), null);
                    }
                    i++;
                } else {
                    throw new IllegalStateException("Deep Linking failed: destination " + k.j(this.a, i7) + " cannot be found in graph " + mVar4);
                }
            }
            this.g = true;
            return true;
        }
    }

    public void h(int i, Bundle bundle, q qVar, s.a aVar) {
        k kVar;
        int i2;
        int i3;
        if (this.h.isEmpty()) {
            kVar = this.d;
        } else {
            kVar = this.h.getLast().d;
        }
        if (kVar != null) {
            d e = kVar.e(i);
            Bundle bundle2 = null;
            if (e != null) {
                if (qVar == null) {
                    qVar = e.b;
                }
                i2 = e.a;
                Bundle bundle3 = e.c;
                if (bundle3 != null) {
                    bundle2 = new Bundle();
                    bundle2.putAll(bundle3);
                }
            } else {
                i2 = i;
            }
            if (bundle != null) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                bundle2.putAll(bundle);
            }
            if (i2 == 0 && qVar != null && (i3 = qVar.b) != -1) {
                m(i3, qVar.c);
            } else if (i2 != 0) {
                k b2 = b(i2);
                if (b2 == null) {
                    String j = k.j(this.a, i2);
                    if (e != null) {
                        StringBuilder T0 = i0.d.a.a.a.T0("Navigation destination ", j, " referenced from action ");
                        T0.append(k.j(this.a, i));
                        T0.append(" cannot be found from the current destination ");
                        T0.append(kVar);
                        throw new IllegalArgumentException(T0.toString());
                    }
                    throw new IllegalArgumentException("Navigation action/destination " + j + " cannot be found from the current destination " + kVar);
                }
                j(b2, bundle2, qVar, aVar);
            } else {
                throw new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo");
            }
        } else {
            throw new IllegalStateException("no current navigation node");
        }
    }

    public void i(j jVar, q qVar, s.a aVar) {
        k.a k = this.d.k(jVar);
        if (k != null) {
            j(k.c, k.c.b(k.d), qVar, aVar);
            return;
        }
        throw new IllegalArgumentException("Navigation destination that matches request " + jVar + " cannot be found in the navigation graph " + this.d);
    }

    public final void j(k kVar, Bundle bundle, q qVar, s.a aVar) {
        k kVar2;
        k kVar3;
        int i;
        boolean z = false;
        boolean n = (qVar == null || (i = qVar.b) == -1) ? false : n(i, qVar.c);
        s c = this.k.c(kVar.c);
        Bundle b2 = kVar.b(bundle);
        k b3 = c.b(kVar, b2, qVar, aVar);
        if (b3 != null) {
            if (!(b3 instanceof c)) {
                while (!this.h.isEmpty() && (this.h.peekLast().d instanceof c) && n(this.h.peekLast().d.q, true)) {
                }
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            if (kVar instanceof m) {
                m mVar = b3;
                while (true) {
                    m mVar2 = mVar.d;
                    if (mVar2 != null) {
                        arrayDeque.addFirst(new f(this.a, mVar2, b2, this.i, this.j));
                        if (!this.h.isEmpty() && this.h.getLast().d == mVar2) {
                            n(mVar2.q, true);
                        }
                    }
                    if (mVar2 == null || mVar2 == kVar) {
                        break;
                    }
                    mVar = mVar2;
                }
            }
            if (arrayDeque.isEmpty()) {
                kVar2 = b3;
            } else {
                kVar2 = ((f) arrayDeque.getFirst()).d;
            }
            while (kVar2 != null && b(kVar2.q) == null) {
                kVar2 = kVar2.d;
                if (kVar2 != null) {
                    arrayDeque.addFirst(new f(this.a, kVar2, b2, this.i, this.j));
                }
            }
            if (arrayDeque.isEmpty()) {
                kVar3 = b3;
            } else {
                kVar3 = ((f) arrayDeque.getLast()).d;
            }
            while (!this.h.isEmpty() && (this.h.getLast().d instanceof m) && ((m) this.h.getLast().d).t(kVar3.q, false) == null && n(this.h.getLast().d.q, true)) {
            }
            this.h.addAll(arrayDeque);
            if (this.h.isEmpty() || this.h.getFirst().d != this.d) {
                this.h.addFirst(new f(this.a, this.d, b2, this.i, this.j));
            }
            this.h.add(new f(this.a, b3, b3.b(b2), this.i, this.j));
        } else if (qVar != null && qVar.a) {
            f peekLast = this.h.peekLast();
            if (peekLast != null) {
                peekLast.q = b2;
            }
            z = true;
        }
        p();
        if (n || b3 != null || z) {
            a();
        }
    }

    public boolean k() {
        if (e() != 1) {
            return l();
        }
        k d = d();
        int i = d.q;
        for (m mVar = d.d; mVar != null; mVar = mVar.d) {
            if (mVar.c2 != i) {
                Bundle bundle = new Bundle();
                Activity activity = this.b;
                if (!(activity == null || activity.getIntent() == null || this.b.getIntent().getData() == null)) {
                    bundle.putParcelable("android-support-nav:controller:deepLinkIntent", this.b.getIntent());
                    m mVar2 = this.d;
                    Intent intent = this.b.getIntent();
                    k.a k = mVar2.k(new j(intent.getData(), intent.getAction(), intent.getType()));
                    if (k != null) {
                        bundle.putAll(k.c.b(k.d));
                    }
                }
                i iVar = new i(this.a);
                m mVar3 = this.d;
                if (mVar3 != null) {
                    iVar.c = mVar3;
                    iVar.d(mVar.q);
                    iVar.e = bundle;
                    iVar.b.putExtra("android-support-nav:controller:deepLinkExtras", bundle);
                    iVar.b().startActivities();
                    Activity activity2 = this.b;
                    if (activity2 != null) {
                        activity2.finish();
                    }
                    return true;
                }
                throw new IllegalStateException("You must call setGraph() before calling getGraph()");
            }
            i = mVar.q;
        }
        return false;
    }

    public boolean l() {
        if (this.h.isEmpty()) {
            return false;
        }
        return m(d().q, true);
    }

    public boolean m(int i, boolean z) {
        return n(i, z) && a();
    }

    public boolean n(int i, boolean z) {
        boolean z2;
        n0 remove;
        boolean z3 = false;
        if (this.h.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<f> descendingIterator = this.h.descendingIterator();
        while (true) {
            if (!descendingIterator.hasNext()) {
                z2 = false;
                break;
            }
            k kVar = descendingIterator.next().d;
            s c = this.k.c(kVar.c);
            if (z || kVar.q != i) {
                arrayList.add(c);
            }
            if (kVar.q == i) {
                z2 = true;
                break;
            }
        }
        if (!z2) {
            Log.i("NavController", "Ignoring popBackStack to destination " + k.j(this.a, i) + " as it was not found on the current back stack");
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext() && ((s) it.next()).e()) {
            f removeLast = this.h.removeLast();
            if (removeLast.x.c.isAtLeast(Lifecycle.State.CREATED)) {
                removeLast.a2 = Lifecycle.State.DESTROYED;
                removeLast.b();
            }
            g gVar = this.j;
            if (!(gVar == null || (remove = gVar.b.remove(removeLast.Y1)) == null)) {
                remove.a();
            }
            z3 = true;
        }
        p();
        return z3;
    }

    public void o(m mVar, Bundle bundle) {
        Activity activity;
        ArrayList<String> stringArrayList;
        m mVar2 = this.d;
        boolean z = true;
        if (mVar2 != null) {
            n(mVar2.q, true);
        }
        this.d = mVar;
        Bundle bundle2 = this.e;
        if (!(bundle2 == null || (stringArrayList = bundle2.getStringArrayList("android-support-nav:controller:navigatorState:names")) == null)) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                s c = this.k.c(next);
                Bundle bundle3 = this.e.getBundle(next);
                if (bundle3 != null) {
                    c.c(bundle3);
                }
            }
        }
        Parcelable[] parcelableArr = this.f;
        if (parcelableArr != null) {
            for (Parcelable parcelable : parcelableArr) {
                NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) parcelable;
                k b2 = b(navBackStackEntryState.d);
                if (b2 != null) {
                    Bundle bundle4 = navBackStackEntryState.q;
                    if (bundle4 != null) {
                        bundle4.setClassLoader(this.a.getClassLoader());
                    }
                    this.h.add(new f(this.a, b2, bundle4, this.i, this.j, navBackStackEntryState.c, navBackStackEntryState.x));
                } else {
                    StringBuilder T0 = i0.d.a.a.a.T0("Restoring the Navigation back stack failed: destination ", k.j(this.a, navBackStackEntryState.d), " cannot be found from the current destination ");
                    T0.append(d());
                    throw new IllegalStateException(T0.toString());
                }
            }
            p();
            this.f = null;
        }
        if (this.d == null || !this.h.isEmpty()) {
            a();
            return;
        }
        if (this.g || (activity = this.b) == null || !g(activity.getIntent())) {
            z = false;
        }
        if (!z) {
            j(this.d, bundle, null, null);
        }
    }

    public final void p() {
        h0.a.b bVar = this.n;
        boolean z = true;
        if (!this.o || e() <= 1) {
            z = false;
        }
        bVar.a = z;
    }
}
