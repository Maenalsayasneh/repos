package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import h0.o.a.a0;
import h0.o.a.b0;
import h0.o.a.c0;
import h0.o.a.j0;
import h0.o.a.p0;
import h0.o.a.q;
import h0.o.a.q0;
import h0.o.a.s;
import h0.o.a.t;
import h0.o.a.u;
import h0.o.a.v;
import h0.o.a.x;
import h0.o.a.y;
import h0.q.k0;
import h0.q.m0;
import h0.q.n0;
import h0.q.o0;
import h0.q.p;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public abstract class FragmentManager {
    public h0.a.f.b<String[]> A;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public ArrayList<h0.o.a.a> H;
    public ArrayList<Boolean> I;
    public ArrayList<Fragment> J;
    public ArrayList<o> K;
    public x L;
    public boolean b;
    public ArrayList<h0.o.a.a> d;
    public ArrayList<Fragment> e;
    public OnBackPressedDispatcher g;
    public ArrayList<l> l;
    public t<?> r;
    public q s;
    public Fragment t;
    public Fragment u;
    public h0.a.f.b<Intent> y;
    public h0.a.f.b<IntentSenderRequest> z;
    public final ArrayList<m> a = new ArrayList<>();
    public final b0 c = new b0();
    public final u f = new u(this);
    public final h0.a.b h = new c(false);
    public final AtomicInteger i = new AtomicInteger();
    public final Map<String, Bundle> j = Collections.synchronizedMap(new HashMap());
    public final Map<String, ?> k = Collections.synchronizedMap(new HashMap());
    public Map<Fragment, HashSet<h0.i.e.a>> m = Collections.synchronizedMap(new HashMap());
    public final j0.a n = new d();
    public final v o = new v(this);
    public final CopyOnWriteArrayList<y> p = new CopyOnWriteArrayList<>();
    public int q = -1;
    public s v = null;
    public s w = new e();
    public q0 x = new f(this);
    public ArrayDeque<LaunchedFragmentInfo> B = new ArrayDeque<>();
    public Runnable M = new g();

    /* renamed from: androidx.fragment.app.FragmentManager$6  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass6 implements h0.q.n {
        @Override // h0.q.n
        public void a(p pVar, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_START) {
                throw null;
            } else if (event == Lifecycle.Event.ON_DESTROY) {
                throw null;
            }
        }
    }

    /* loaded from: classes.dex */
    public class a implements h0.a.f.a<ActivityResult> {
        public a() {
        }

        @Override // h0.a.f.a
        public void onActivityResult(ActivityResult activityResult) {
            ActivityResult activityResult2 = activityResult;
            LaunchedFragmentInfo pollFirst = FragmentManager.this.B.pollFirst();
            if (pollFirst == null) {
                Log.w("FragmentManager", "No IntentSenders were started for " + this);
                return;
            }
            String str = pollFirst.c;
            int i = pollFirst.d;
            Fragment e = FragmentManager.this.c.e(str);
            if (e == null) {
                Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
                return;
            }
            e.onActivityResult(i, activityResult2.c, activityResult2.d);
        }
    }

    /* loaded from: classes.dex */
    public class b implements h0.a.f.a<Map<String, Boolean>> {
        public b() {
        }

        @Override // h0.a.f.a
        @SuppressLint({"SyntheticAccessor"})
        public void onActivityResult(Map<String, Boolean> map) {
            Map<String, Boolean> map2 = map;
            String[] strArr = (String[]) map2.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map2.values());
            int[] iArr = new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                iArr[i] = ((Boolean) arrayList.get(i)).booleanValue() ? 0 : -1;
            }
            LaunchedFragmentInfo pollFirst = FragmentManager.this.B.pollFirst();
            if (pollFirst == null) {
                Log.w("FragmentManager", "No permissions were requested for " + this);
                return;
            }
            String str = pollFirst.c;
            int i2 = pollFirst.d;
            Fragment e = FragmentManager.this.c.e(str);
            if (e == null) {
                Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
                return;
            }
            e.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    /* loaded from: classes.dex */
    public class c extends h0.a.b {
        public c(boolean z) {
            super(z);
        }

        @Override // h0.a.b
        public void a() {
            FragmentManager fragmentManager = FragmentManager.this;
            fragmentManager.C(true);
            if (fragmentManager.h.a) {
                fragmentManager.b0();
            } else {
                fragmentManager.g.b();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements j0.a {
        public d() {
        }

        public void a(Fragment fragment, h0.i.e.a aVar) {
            boolean z;
            synchronized (aVar) {
                z = aVar.a;
            }
            if (!z) {
                FragmentManager fragmentManager = FragmentManager.this;
                HashSet<h0.i.e.a> hashSet = fragmentManager.m.get(fragment);
                if (hashSet != null && hashSet.remove(aVar) && hashSet.isEmpty()) {
                    fragmentManager.m.remove(fragment);
                    if (fragment.mState < 5) {
                        fragmentManager.i(fragment);
                        fragmentManager.X(fragment, fragmentManager.q);
                    }
                }
            }
        }

        public void b(Fragment fragment, h0.i.e.a aVar) {
            FragmentManager fragmentManager = FragmentManager.this;
            if (fragmentManager.m.get(fragment) == null) {
                fragmentManager.m.put(fragment, new HashSet<>());
            }
            fragmentManager.m.get(fragment).add(aVar);
        }
    }

    /* loaded from: classes.dex */
    public class e extends s {
        public e() {
        }

        @Override // h0.o.a.s
        public Fragment instantiate(ClassLoader classLoader, String str) {
            t<?> tVar = FragmentManager.this.r;
            Context context = tVar.d;
            Objects.requireNonNull(tVar);
            return Fragment.instantiate(context, str, null);
        }
    }

    /* loaded from: classes.dex */
    public class f implements q0 {
        public f(FragmentManager fragmentManager) {
        }
    }

    /* loaded from: classes.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentManager.this.C(true);
        }
    }

    /* loaded from: classes.dex */
    public class h implements y {
        public final /* synthetic */ Fragment c;

        public h(FragmentManager fragmentManager, Fragment fragment) {
            this.c = fragment;
        }

        @Override // h0.o.a.y
        public void a(FragmentManager fragmentManager, Fragment fragment) {
            this.c.onAttachFragment(fragment);
        }
    }

    /* loaded from: classes.dex */
    public class i implements h0.a.f.a<ActivityResult> {
        public i() {
        }

        @Override // h0.a.f.a
        public void onActivityResult(ActivityResult activityResult) {
            ActivityResult activityResult2 = activityResult;
            LaunchedFragmentInfo pollFirst = FragmentManager.this.B.pollFirst();
            if (pollFirst == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = pollFirst.c;
            int i = pollFirst.d;
            Fragment e = FragmentManager.this.c.e(str);
            if (e == null) {
                Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
                return;
            }
            e.onActivityResult(i, activityResult2.c, activityResult2.d);
        }
    }

    /* loaded from: classes.dex */
    public static class j extends h0.a.f.d.a<IntentSenderRequest, ActivityResult> {
        @Override // h0.a.f.d.a
        public Intent createIntent(Context context, IntentSenderRequest intentSenderRequest) {
            Bundle bundleExtra;
            IntentSenderRequest intentSenderRequest2 = intentSenderRequest;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent intent2 = intentSenderRequest2.d;
            if (!(intent2 == null || (bundleExtra = intent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) == null)) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                intent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (intent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    intentSenderRequest2 = new IntentSenderRequest(intentSenderRequest2.c, null, intentSenderRequest2.q, intentSenderRequest2.x);
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest2);
            if (FragmentManager.R(2)) {
                Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
            }
            return intent;
        }

        @Override // h0.a.f.d.a
        public ActivityResult parseResult(int i, Intent intent) {
            return new ActivityResult(i, intent);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class k {
        @Deprecated
        public void onFragmentActivityCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentDetached(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentPaused(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentPreAttached(FragmentManager fragmentManager, Fragment fragment, Context context) {
        }

        public void onFragmentPreCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentResumed(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentSaveInstanceState(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        }

        public void onFragmentStarted(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentStopped(FragmentManager fragmentManager, Fragment fragment) {
        }

        public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
        }

        public void onFragmentViewDestroyed(FragmentManager fragmentManager, Fragment fragment) {
        }
    }

    /* loaded from: classes.dex */
    public interface l {
        void onBackStackChanged();
    }

    /* loaded from: classes.dex */
    public interface m {
        boolean a(ArrayList<h0.o.a.a> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* loaded from: classes.dex */
    public class n implements m {
        public final String a;
        public final int b;
        public final int c;

        public n(String str, int i, int i2) {
            this.a = str;
            this.b = i;
            this.c = i2;
        }

        @Override // androidx.fragment.app.FragmentManager.m
        public boolean a(ArrayList<h0.o.a.a> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = FragmentManager.this.u;
            if (fragment == null || this.b >= 0 || this.a != null || !fragment.getChildFragmentManager().b0()) {
                return FragmentManager.this.c0(arrayList, arrayList2, this.a, this.b, this.c);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class o implements Fragment.k {
        public final boolean a;
        public final h0.o.a.a b;
        public int c;

        public void a() {
            boolean z = this.c > 0;
            for (Fragment fragment : this.b.s.O()) {
                fragment.setOnStartEnterTransitionListener(null);
                if (z && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            h0.o.a.a aVar = this.b;
            aVar.s.g(aVar, this.a, !z, true);
        }
    }

    public static boolean R(int i2) {
        return Log.isLoggable("FragmentManager", i2);
    }

    public void A(m mVar, boolean z) {
        if (!z) {
            if (this.r == null) {
                if (this.F) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            } else if (V()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.a) {
            if (this.r != null) {
                this.a.add(mVar);
                h0();
            } else if (!z) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    public final void B(boolean z) {
        if (this.b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.r == null) {
            if (this.F) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        } else if (Looper.myLooper() != this.r.q.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else if (z || !V()) {
            if (this.H == null) {
                this.H = new ArrayList<>();
                this.I = new ArrayList<>();
            }
            this.b = true;
            try {
                G(null, null);
            } finally {
                this.b = false;
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    /* JADX WARN: Finally extract failed */
    public boolean C(boolean z) {
        boolean z2;
        B(z);
        boolean z3 = false;
        while (true) {
            ArrayList<h0.o.a.a> arrayList = this.H;
            ArrayList<Boolean> arrayList2 = this.I;
            synchronized (this.a) {
                if (this.a.isEmpty()) {
                    z2 = false;
                } else {
                    int size = this.a.size();
                    z2 = false;
                    for (int i2 = 0; i2 < size; i2++) {
                        z2 |= this.a.get(i2).a(arrayList, arrayList2);
                    }
                    this.a.clear();
                    this.r.q.removeCallbacks(this.M);
                }
            }
            if (z2) {
                this.b = true;
                try {
                    e0(this.H, this.I);
                    e();
                    z3 = true;
                } catch (Throwable th) {
                    e();
                    throw th;
                }
            } else {
                o0();
                x();
                this.c.b();
                return z3;
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    public void D(m mVar, boolean z) {
        if (!z || (this.r != null && !this.F)) {
            B(z);
            ((h0.o.a.a) mVar).a(this.H, this.I);
            this.b = true;
            try {
                e0(this.H, this.I);
                e();
                o0();
                x();
                this.c.b();
            } catch (Throwable th) {
                e();
                throw th;
            }
        }
    }

    public final void E(ArrayList<h0.o.a.a> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ViewGroup viewGroup;
        int i4;
        int i5;
        ArrayList<Boolean> arrayList3 = arrayList2;
        boolean z = arrayList.get(i2).r;
        ArrayList<Fragment> arrayList4 = this.J;
        if (arrayList4 == null) {
            this.J = new ArrayList<>();
        } else {
            arrayList4.clear();
        }
        this.J.addAll(this.c.i());
        Fragment fragment = this.u;
        int i6 = i2;
        boolean z2 = false;
        while (true) {
            int i7 = 1;
            if (i6 < i3) {
                h0.o.a.a aVar = arrayList.get(i6);
                int i8 = 3;
                if (!arrayList3.get(i6).booleanValue()) {
                    ArrayList<Fragment> arrayList5 = this.J;
                    int i9 = 0;
                    while (i9 < aVar.c.size()) {
                        c0.a aVar2 = aVar.c.get(i9);
                        int i10 = aVar2.a;
                        if (i10 == i7) {
                            i4 = i7;
                        } else if (i10 != 2) {
                            if (i10 == i8 || i10 == 6) {
                                arrayList5.remove(aVar2.b);
                                Fragment fragment2 = aVar2.b;
                                if (fragment2 == fragment) {
                                    aVar.c.add(i9, new c0.a(9, fragment2));
                                    i9++;
                                    i4 = 1;
                                    fragment = null;
                                    i9 += i4;
                                    i7 = i4;
                                    i8 = 3;
                                }
                            } else if (i10 == 7) {
                                i4 = 1;
                            } else if (i10 == 8) {
                                aVar.c.add(i9, new c0.a(9, fragment));
                                i9++;
                                fragment = aVar2.b;
                            }
                            i4 = 1;
                            i9 += i4;
                            i7 = i4;
                            i8 = 3;
                        } else {
                            Fragment fragment3 = aVar2.b;
                            int i11 = fragment3.mContainerId;
                            int size = arrayList5.size() - 1;
                            boolean z3 = false;
                            while (size >= 0) {
                                Fragment fragment4 = arrayList5.get(size);
                                if (fragment4.mContainerId != i11) {
                                    i5 = i11;
                                } else if (fragment4 == fragment3) {
                                    i5 = i11;
                                    z3 = true;
                                } else {
                                    if (fragment4 == fragment) {
                                        i5 = i11;
                                        aVar.c.add(i9, new c0.a(9, fragment4));
                                        i9++;
                                        fragment = null;
                                    } else {
                                        i5 = i11;
                                    }
                                    c0.a aVar3 = new c0.a(3, fragment4);
                                    aVar3.c = aVar2.c;
                                    aVar3.e = aVar2.e;
                                    aVar3.d = aVar2.d;
                                    aVar3.f = aVar2.f;
                                    aVar.c.add(i9, aVar3);
                                    arrayList5.remove(fragment4);
                                    i9++;
                                }
                                size--;
                                i11 = i5;
                            }
                            if (z3) {
                                aVar.c.remove(i9);
                                i9--;
                                i4 = 1;
                                i9 += i4;
                                i7 = i4;
                                i8 = 3;
                            } else {
                                i4 = 1;
                                aVar2.a = 1;
                                arrayList5.add(fragment3);
                                i9 += i4;
                                i7 = i4;
                                i8 = 3;
                            }
                        }
                        arrayList5.add(aVar2.b);
                        i9 += i4;
                        i7 = i4;
                        i8 = 3;
                    }
                } else {
                    int i12 = 1;
                    ArrayList<Fragment> arrayList6 = this.J;
                    int size2 = aVar.c.size() - 1;
                    while (size2 >= 0) {
                        c0.a aVar4 = aVar.c.get(size2);
                        int i13 = aVar4.a;
                        if (i13 != i12) {
                            if (i13 != 3) {
                                switch (i13) {
                                    case 8:
                                        fragment = null;
                                        break;
                                    case 9:
                                        fragment = aVar4.b;
                                        break;
                                    case 10:
                                        aVar4.h = aVar4.g;
                                        break;
                                }
                                size2--;
                                i12 = 1;
                            }
                            arrayList6.add(aVar4.b);
                            size2--;
                            i12 = 1;
                        }
                        arrayList6.remove(aVar4.b);
                        size2--;
                        i12 = 1;
                    }
                }
                z2 = z2 || aVar.i;
                i6++;
                arrayList3 = arrayList2;
            } else {
                this.J.clear();
                if (!z && this.q >= 1) {
                    for (int i14 = i2; i14 < i3; i14++) {
                        Iterator<c0.a> it = arrayList.get(i14).c.iterator();
                        while (it.hasNext()) {
                            Fragment fragment5 = it.next().b;
                            if (!(fragment5 == null || fragment5.mFragmentManager == null)) {
                                this.c.j(h(fragment5));
                            }
                        }
                    }
                }
                int i15 = i2;
                while (i15 < i3) {
                    h0.o.a.a aVar5 = arrayList.get(i15);
                    if (arrayList2.get(i15).booleanValue()) {
                        aVar5.u(-1);
                        aVar5.y(i15 == i3 + -1);
                    } else {
                        aVar5.u(1);
                        aVar5.x();
                    }
                    i15++;
                }
                boolean booleanValue = arrayList2.get(i3 - 1).booleanValue();
                for (int i16 = i2; i16 < i3; i16++) {
                    h0.o.a.a aVar6 = arrayList.get(i16);
                    if (booleanValue) {
                        for (int size3 = aVar6.c.size() - 1; size3 >= 0; size3--) {
                            Fragment fragment6 = aVar6.c.get(size3).b;
                            if (fragment6 != null) {
                                h(fragment6).k();
                            }
                        }
                    } else {
                        Iterator<c0.a> it2 = aVar6.c.iterator();
                        while (it2.hasNext()) {
                            Fragment fragment7 = it2.next().b;
                            if (fragment7 != null) {
                                h(fragment7).k();
                            }
                        }
                    }
                }
                W(this.q, true);
                HashSet hashSet = new HashSet();
                for (int i17 = i2; i17 < i3; i17++) {
                    Iterator<c0.a> it3 = arrayList.get(i17).c.iterator();
                    while (it3.hasNext()) {
                        Fragment fragment8 = it3.next().b;
                        if (!(fragment8 == null || (viewGroup = fragment8.mContainer) == null)) {
                            hashSet.add(SpecialEffectsController.g(viewGroup, P()));
                        }
                    }
                }
                Iterator it4 = hashSet.iterator();
                while (it4.hasNext()) {
                    SpecialEffectsController specialEffectsController = (SpecialEffectsController) it4.next();
                    specialEffectsController.d = booleanValue;
                    specialEffectsController.h();
                    specialEffectsController.c();
                }
                for (int i18 = i2; i18 < i3; i18++) {
                    h0.o.a.a aVar7 = arrayList.get(i18);
                    if (arrayList2.get(i18).booleanValue() && aVar7.u >= 0) {
                        aVar7.u = -1;
                    }
                    Objects.requireNonNull(aVar7);
                }
                if (z2 && this.l != null) {
                    for (int i19 = 0; i19 < this.l.size(); i19++) {
                        this.l.get(i19).onBackStackChanged();
                    }
                    return;
                }
                return;
            }
        }
    }

    public boolean F() {
        boolean C = C(true);
        K();
        return C;
    }

    public final void G(ArrayList<h0.o.a.a> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<o> arrayList3 = this.K;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            o oVar = this.K.get(i2);
            if (arrayList == null || oVar.a || (indexOf2 = arrayList.indexOf(oVar.b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf2).booleanValue()) {
                if ((oVar.c == 0) || (arrayList != null && oVar.b.A(arrayList, 0, arrayList.size()))) {
                    this.K.remove(i2);
                    i2--;
                    size--;
                    if (arrayList == null || oVar.a || (indexOf = arrayList.indexOf(oVar.b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf).booleanValue()) {
                        oVar.a();
                    } else {
                        h0.o.a.a aVar = oVar.b;
                        aVar.s.g(aVar, oVar.a, false, false);
                    }
                }
            } else {
                this.K.remove(i2);
                i2--;
                size--;
                h0.o.a.a aVar2 = oVar.b;
                aVar2.s.g(aVar2, oVar.a, false, false);
            }
            i2++;
        }
    }

    public Fragment H(String str) {
        return this.c.d(str);
    }

    public Fragment I(int i2) {
        b0 b0Var = this.c;
        int size = b0Var.a.size();
        while (true) {
            size--;
            if (size >= 0) {
                Fragment fragment = b0Var.a.get(size);
                if (fragment != null && fragment.mFragmentId == i2) {
                    return fragment;
                }
            } else {
                for (a0 a0Var : b0Var.b.values()) {
                    if (a0Var != null) {
                        Fragment fragment2 = a0Var.c;
                        if (fragment2.mFragmentId == i2) {
                            return fragment2;
                        }
                    }
                }
                return null;
            }
        }
    }

    public Fragment J(String str) {
        b0 b0Var = this.c;
        Objects.requireNonNull(b0Var);
        if (str != null) {
            int size = b0Var.a.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                Fragment fragment = b0Var.a.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str != null) {
            for (a0 a0Var : b0Var.b.values()) {
                if (a0Var != null) {
                    Fragment fragment2 = a0Var.c;
                    if (str.equals(fragment2.mTag)) {
                        return fragment2;
                    }
                }
            }
        }
        return null;
    }

    public final void K() {
        Iterator it = ((HashSet) f()).iterator();
        while (it.hasNext()) {
            SpecialEffectsController specialEffectsController = (SpecialEffectsController) it.next();
            if (specialEffectsController.e) {
                specialEffectsController.e = false;
                specialEffectsController.c();
            }
        }
    }

    public int L() {
        ArrayList<h0.o.a.a> arrayList = this.d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public final ViewGroup M(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.s.c()) {
            View b2 = this.s.b(fragment.mContainerId);
            if (b2 instanceof ViewGroup) {
                return (ViewGroup) b2;
            }
        }
        return null;
    }

    public s N() {
        s sVar = this.v;
        if (sVar != null) {
            return sVar;
        }
        Fragment fragment = this.t;
        if (fragment != null) {
            return fragment.mFragmentManager.N();
        }
        return this.w;
    }

    public List<Fragment> O() {
        return this.c.i();
    }

    public q0 P() {
        Fragment fragment = this.t;
        if (fragment != null) {
            return fragment.mFragmentManager.P();
        }
        return this.x;
    }

    public void Q(Fragment fragment) {
        if (R(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
            l0(fragment);
        }
    }

    public final boolean S(Fragment fragment) {
        boolean z;
        if (fragment.mHasMenu && fragment.mMenuVisible) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mChildFragmentManager;
        Iterator it = ((ArrayList) fragmentManager.c.g()).iterator();
        boolean z2 = false;
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            Fragment fragment2 = (Fragment) it.next();
            if (fragment2 != null) {
                z2 = fragmentManager.S(fragment2);
                continue;
            }
            if (z2) {
                z = true;
                break;
            }
        }
        return z;
    }

    public boolean T(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    public boolean U(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (!fragment.equals(fragmentManager.u) || !U(fragmentManager.t)) {
            return false;
        }
        return true;
    }

    public boolean V() {
        return this.D || this.E;
    }

    public void W(int i2, boolean z) {
        t<?> tVar;
        if (this.r == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        } else if (z || i2 != this.q) {
            this.q = i2;
            b0 b0Var = this.c;
            Iterator<Fragment> it = b0Var.a.iterator();
            while (it.hasNext()) {
                a0 a0Var = b0Var.b.get(it.next().mWho);
                if (a0Var != null) {
                    a0Var.k();
                }
            }
            Iterator<a0> it2 = b0Var.b.values().iterator();
            while (true) {
                boolean z2 = false;
                if (!it2.hasNext()) {
                    break;
                }
                a0 next = it2.next();
                if (next != null) {
                    next.k();
                    Fragment fragment = next.c;
                    if (fragment.mRemoving && !fragment.isInBackStack()) {
                        z2 = true;
                    }
                    if (z2) {
                        b0Var.k(next);
                    }
                }
            }
            n0();
            if (this.C && (tVar = this.r) != null && this.q == 7) {
                tVar.h();
                this.C = false;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
        if (r1 != 5) goto L_0x01bc;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01a8  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void X(Fragment fragment, int i2) {
        int i3;
        int i4;
        ViewGroup viewGroup;
        a0 h2 = this.c.h(fragment.mWho);
        if (h2 == null) {
            h2 = new a0(this.o, this.c, fragment);
            h2.e = 1;
        }
        int min = Math.min((!fragment.mFromLayout || !fragment.mInLayout || fragment.mState != 2) ? i2 : Math.max(i2, 2), h2.d());
        int i5 = fragment.mState;
        if (i5 <= min) {
            if (i5 < min && !this.m.isEmpty()) {
                d(fragment);
            }
            int i6 = fragment.mState;
            if (i6 != -1) {
                if (i6 != 0) {
                    if (i6 != 1) {
                        if (i6 != 2) {
                            if (i6 != 4) {
                            }
                            if (min > 4) {
                                h2.p();
                            }
                            if (min > 5) {
                                h2.n();
                            }
                        }
                        if (min > 2) {
                            h2.a();
                        }
                        if (min > 4) {
                        }
                        if (min > 5) {
                        }
                    }
                    if (min > -1) {
                        h2.j();
                    }
                    if (min > 1) {
                        h2.f();
                    }
                    if (min > 2) {
                    }
                    if (min > 4) {
                    }
                    if (min > 5) {
                    }
                }
            } else if (min > -1) {
                h2.c();
            }
            if (min > 0) {
                h2.e();
            }
            if (min > -1) {
            }
            if (min > 1) {
            }
            if (min > 2) {
            }
            if (min > 4) {
            }
            if (min > 5) {
            }
        } else if (i5 > min) {
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 4) {
                            if (i5 != 5) {
                                if (i5 == 7) {
                                    if (min < 7) {
                                        h2.l();
                                    }
                                }
                            }
                            if (min < 5) {
                                h2.q();
                            }
                        }
                        if (min < 4) {
                            if (R(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + fragment);
                            }
                            if (fragment.mView != null && this.r.f(fragment) && fragment.mSavedViewState == null) {
                                h2.o();
                            }
                        }
                    }
                    if (min < 2) {
                        h0.o.a.o oVar = null;
                        View view = fragment.mView;
                        if (!(view == null || (viewGroup = fragment.mContainer) == null)) {
                            viewGroup.endViewTransition(view);
                            fragment.mView.clearAnimation();
                            if (!fragment.isRemovingParent()) {
                                if (this.q > -1 && !this.F && fragment.mView.getVisibility() == 0 && fragment.mPostponedAlpha >= 0.0f) {
                                    oVar = g0.a.b.b.a.b0(this.r.d, fragment, false, fragment.getPopDirection());
                                }
                                fragment.mPostponedAlpha = 0.0f;
                                ViewGroup viewGroup2 = fragment.mContainer;
                                View view2 = fragment.mView;
                                if (oVar != null) {
                                    j0.a aVar = this.n;
                                    viewGroup2.startViewTransition(view2);
                                    h0.i.e.a aVar2 = new h0.i.e.a();
                                    aVar2.b(new h0.o.a.l(fragment));
                                    d dVar = (d) aVar;
                                    dVar.b(fragment, aVar2);
                                    if (oVar.a != null) {
                                        h0.o.a.p pVar = new h0.o.a.p(oVar.a, viewGroup2, view2);
                                        fragment.setAnimatingAway(fragment.mView);
                                        pVar.setAnimationListener(new h0.o.a.m(viewGroup2, fragment, dVar, aVar2));
                                        fragment.mView.startAnimation(pVar);
                                    } else {
                                        Animator animator = oVar.b;
                                        fragment.setAnimator(animator);
                                        animator.addListener(new h0.o.a.n(viewGroup2, view2, fragment, dVar, aVar2));
                                        animator.setTarget(fragment.mView);
                                        animator.start();
                                    }
                                }
                                viewGroup2.removeView(view2);
                                if (R(2)) {
                                    Log.v("FragmentManager", "Removing view " + view2 + " for fragment " + fragment + " from container " + viewGroup2);
                                }
                                if (viewGroup2 != fragment.mContainer) {
                                    return;
                                }
                            }
                        }
                        if (this.m.get(fragment) == null) {
                            h2.h();
                        }
                        i4 = 1;
                        if (min < i4) {
                            if (this.m.get(fragment) != null) {
                                i3 = i4;
                                if (i3 < 0) {
                                    h2.i();
                                }
                                min = i3;
                            } else {
                                h2.g();
                            }
                        }
                    }
                }
                i4 = 1;
                if (min < i4) {
                }
            }
            i3 = min;
            if (i3 < 0) {
            }
            min = i3;
        }
        if (fragment.mState != min) {
            if (R(3)) {
                Log.d("FragmentManager", "moveToState: Fragment state for " + fragment + " not updated inline; expected state " + min + " found " + fragment.mState);
            }
            fragment.mState = min;
        }
    }

    public void Y() {
        if (this.r != null) {
            this.D = false;
            this.E = false;
            this.L.g = false;
            for (Fragment fragment : this.c.i()) {
                if (fragment != null) {
                    fragment.noteStateNotSaved();
                }
            }
        }
    }

    public void Z(a0 a0Var) {
        Fragment fragment = a0Var.c;
        if (!fragment.mDeferStart) {
            return;
        }
        if (this.b) {
            this.G = true;
            return;
        }
        fragment.mDeferStart = false;
        a0Var.k();
    }

    public a0 a(Fragment fragment) {
        if (R(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        a0 h2 = h(fragment);
        fragment.mFragmentManager = this;
        this.c.j(h2);
        if (!fragment.mDetached) {
            this.c.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (S(fragment)) {
                this.C = true;
            }
        }
        return h2;
    }

    public void a0(String str, int i2) {
        A(new n(str, -1, i2), false);
    }

    @SuppressLint({"SyntheticAccessor"})
    public void b(t<?> tVar, q qVar, Fragment fragment) {
        k0 k0Var;
        if (this.r == null) {
            this.r = tVar;
            this.s = qVar;
            this.t = fragment;
            if (fragment != null) {
                this.p.add(new h(this, fragment));
            } else if (tVar instanceof y) {
                this.p.add((y) tVar);
            }
            if (this.t != null) {
                o0();
            }
            if (tVar instanceof h0.a.d) {
                h0.a.d dVar = (h0.a.d) tVar;
                OnBackPressedDispatcher onBackPressedDispatcher = dVar.getOnBackPressedDispatcher();
                this.g = onBackPressedDispatcher;
                p pVar = dVar;
                if (fragment != null) {
                    pVar = fragment;
                }
                onBackPressedDispatcher.a(pVar, this.h);
            }
            if (fragment != null) {
                x xVar = fragment.mFragmentManager.L;
                x xVar2 = xVar.c.get(fragment.mWho);
                if (xVar2 == null) {
                    xVar2 = new x(xVar.e);
                    xVar.c.put(fragment.mWho, xVar2);
                }
                this.L = xVar2;
            } else if (tVar instanceof o0) {
                n0 viewModelStore = ((o0) tVar).getViewModelStore();
                m0.b bVar = x.a;
                String canonicalName = x.class.getCanonicalName();
                if (canonicalName != null) {
                    String n02 = i0.d.a.a.a.n0("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
                    k0 k0Var2 = viewModelStore.a.get(n02);
                    if (!x.class.isInstance(k0Var2)) {
                        if (bVar instanceof m0.c) {
                            k0Var = ((m0.c) bVar).create(n02, x.class);
                        } else {
                            k0Var = ((x.a) bVar).create(x.class);
                        }
                        k0Var2 = k0Var;
                        k0 put = viewModelStore.a.put(n02, k0Var2);
                        if (put != null) {
                            put.onCleared();
                        }
                    } else if (bVar instanceof m0.e) {
                        ((m0.e) bVar).onRequery(k0Var2);
                    }
                    this.L = (x) k0Var2;
                } else {
                    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
                }
            } else {
                this.L = new x(false);
            }
            this.L.g = V();
            this.c.c = this.L;
            t<?> tVar2 = this.r;
            if (tVar2 instanceof h0.a.f.c) {
                ActivityResultRegistry activityResultRegistry = ((h0.a.f.c) tVar2).getActivityResultRegistry();
                String n03 = i0.d.a.a.a.n0("FragmentManager:", fragment != null ? i0.d.a.a.a.y0(new StringBuilder(), fragment.mWho, ":") : "");
                this.y = activityResultRegistry.c(i0.d.a.a.a.n0(n03, "StartActivityForResult"), new h0.a.f.d.d(), new i());
                this.z = activityResultRegistry.c(i0.d.a.a.a.n0(n03, "StartIntentSenderForResult"), new j(), new a());
                this.A = activityResultRegistry.c(i0.d.a.a.a.n0(n03, "RequestPermissions"), new h0.a.f.d.c(), new b());
                return;
            }
            return;
        }
        throw new IllegalStateException("Already attached");
    }

    public boolean b0() {
        C(false);
        B(true);
        Fragment fragment = this.u;
        if (fragment != null && fragment.getChildFragmentManager().b0()) {
            return true;
        }
        boolean c0 = c0(this.H, this.I, null, -1, 0);
        if (c0) {
            this.b = true;
            try {
                e0(this.H, this.I);
            } finally {
                e();
            }
        }
        o0();
        x();
        this.c.b();
        return c0;
    }

    public void c(Fragment fragment) {
        if (R(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                this.c.a(fragment);
                if (R(2)) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                if (S(fragment)) {
                    this.C = true;
                }
            }
        }
    }

    public boolean c0(ArrayList<h0.o.a.a> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        ArrayList<h0.o.a.a> arrayList3 = this.d;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.d.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            int i4 = -1;
            if (str != null || i2 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    h0.o.a.a aVar = this.d.get(size2);
                    if ((str != null && str.equals(aVar.k)) || (i2 >= 0 && i2 == aVar.u)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        h0.o.a.a aVar2 = this.d.get(size2);
                        if (str == null || !str.equals(aVar2.k)) {
                            if (i2 < 0 || i2 != aVar2.u) {
                                break;
                            }
                        }
                    }
                }
                i4 = size2;
            }
            if (i4 == this.d.size() - 1) {
                return false;
            }
            for (int size3 = this.d.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.d.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    public final void d(Fragment fragment) {
        HashSet<h0.i.e.a> hashSet = this.m.get(fragment);
        if (hashSet != null) {
            Iterator<h0.i.e.a> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            hashSet.clear();
            i(fragment);
            this.m.remove(fragment);
        }
    }

    public void d0(Fragment fragment) {
        if (R(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        }
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            this.c.l(fragment);
            if (S(fragment)) {
                this.C = true;
            }
            fragment.mRemoving = true;
            l0(fragment);
        }
    }

    public final void e() {
        this.b = false;
        this.I.clear();
        this.H.clear();
    }

    public final void e0(ArrayList<h0.o.a.a> arrayList, ArrayList<Boolean> arrayList2) {
        if (!arrayList.isEmpty()) {
            if (arrayList.size() == arrayList2.size()) {
                G(arrayList, arrayList2);
                int size = arrayList.size();
                int i2 = 0;
                int i3 = 0;
                while (i2 < size) {
                    if (!arrayList.get(i2).r) {
                        if (i3 != i2) {
                            E(arrayList, arrayList2, i3, i2);
                        }
                        i3 = i2 + 1;
                        if (arrayList2.get(i2).booleanValue()) {
                            while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).r) {
                                i3++;
                            }
                        }
                        E(arrayList, arrayList2, i2, i3);
                        i2 = i3 - 1;
                    }
                    i2++;
                }
                if (i3 != size) {
                    E(arrayList, arrayList2, i3, size);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error with the back stack records");
        }
    }

    public final Set<SpecialEffectsController> f() {
        HashSet hashSet = new HashSet();
        Iterator it = ((ArrayList) this.c.f()).iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((a0) it.next()).c.mContainer;
            if (viewGroup != null) {
                hashSet.add(SpecialEffectsController.g(viewGroup, P()));
            }
        }
        return hashSet;
    }

    public void f0(Parcelable parcelable) {
        a0 a0Var;
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.c != null) {
                this.c.b.clear();
                Iterator<FragmentState> it = fragmentManagerState.c.iterator();
                while (it.hasNext()) {
                    FragmentState next = it.next();
                    if (next != null) {
                        Fragment fragment = this.L.b.get(next.d);
                        if (fragment != null) {
                            if (R(2)) {
                                Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragment);
                            }
                            a0Var = new a0(this.o, this.c, fragment, next);
                        } else {
                            a0Var = new a0(this.o, this.c, this.r.d.getClassLoader(), N(), next);
                        }
                        Fragment fragment2 = a0Var.c;
                        fragment2.mFragmentManager = this;
                        if (R(2)) {
                            StringBuilder P0 = i0.d.a.a.a.P0("restoreSaveState: active (");
                            P0.append(fragment2.mWho);
                            P0.append("): ");
                            P0.append(fragment2);
                            Log.v("FragmentManager", P0.toString());
                        }
                        a0Var.m(this.r.d.getClassLoader());
                        this.c.j(a0Var);
                        a0Var.e = this.q;
                    }
                }
                x xVar = this.L;
                Objects.requireNonNull(xVar);
                Iterator it2 = new ArrayList(xVar.b.values()).iterator();
                while (it2.hasNext()) {
                    Fragment fragment3 = (Fragment) it2.next();
                    if (!this.c.c(fragment3.mWho)) {
                        if (R(2)) {
                            Log.v("FragmentManager", "Discarding retained Fragment " + fragment3 + " that was not found in the set of active Fragments " + fragmentManagerState.c);
                        }
                        this.L.b(fragment3);
                        fragment3.mFragmentManager = this;
                        a0 a0Var2 = new a0(this.o, this.c, fragment3);
                        a0Var2.e = 1;
                        a0Var2.k();
                        fragment3.mRemoving = true;
                        a0Var2.k();
                    }
                }
                b0 b0Var = this.c;
                ArrayList<String> arrayList = fragmentManagerState.d;
                b0Var.a.clear();
                if (arrayList != null) {
                    for (String str : arrayList) {
                        Fragment d2 = b0Var.d(str);
                        if (d2 != null) {
                            if (R(2)) {
                                Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + d2);
                            }
                            b0Var.a(d2);
                        } else {
                            throw new IllegalStateException(i0.d.a.a.a.o0("No instantiated fragment for (", str, ")"));
                        }
                    }
                }
                Fragment fragment4 = null;
                if (fragmentManagerState.q != null) {
                    this.d = new ArrayList<>(fragmentManagerState.q.length);
                    int i2 = 0;
                    while (true) {
                        BackStackState[] backStackStateArr = fragmentManagerState.q;
                        if (i2 >= backStackStateArr.length) {
                            break;
                        }
                        BackStackState backStackState = backStackStateArr[i2];
                        Objects.requireNonNull(backStackState);
                        h0.o.a.a aVar = new h0.o.a.a(this);
                        int i3 = 0;
                        int i4 = 0;
                        while (true) {
                            int[] iArr = backStackState.c;
                            if (i3 >= iArr.length) {
                                break;
                            }
                            c0.a aVar2 = new c0.a();
                            int i5 = i3 + 1;
                            aVar2.a = iArr[i3];
                            if (R(2)) {
                                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i4 + " base fragment #" + backStackState.c[i5]);
                            }
                            String str2 = backStackState.d.get(i4);
                            if (str2 != null) {
                                aVar2.b = this.c.d(str2);
                            } else {
                                aVar2.b = fragment4;
                            }
                            aVar2.g = Lifecycle.State.values()[backStackState.q[i4]];
                            aVar2.h = Lifecycle.State.values()[backStackState.x[i4]];
                            int[] iArr2 = backStackState.c;
                            int i6 = i5 + 1;
                            int i7 = iArr2[i5];
                            aVar2.c = i7;
                            int i8 = i6 + 1;
                            int i9 = iArr2[i6];
                            aVar2.d = i9;
                            int i10 = i8 + 1;
                            int i11 = iArr2[i8];
                            aVar2.e = i11;
                            int i12 = iArr2[i10];
                            aVar2.f = i12;
                            aVar.d = i7;
                            aVar.e = i9;
                            aVar.f = i11;
                            aVar.g = i12;
                            aVar.e(aVar2);
                            i4++;
                            fragment4 = null;
                            i3 = i10 + 1;
                        }
                        aVar.h = backStackState.y;
                        aVar.k = backStackState.Y1;
                        aVar.u = backStackState.Z1;
                        aVar.i = true;
                        aVar.l = backStackState.a2;
                        aVar.m = backStackState.b2;
                        aVar.n = backStackState.c2;
                        aVar.o = backStackState.d2;
                        aVar.p = backStackState.e2;
                        aVar.q = backStackState.f2;
                        aVar.r = backStackState.g2;
                        aVar.u(1);
                        if (R(2)) {
                            StringBuilder Q0 = i0.d.a.a.a.Q0("restoreAllState: back stack #", i2, " (index ");
                            Q0.append(aVar.u);
                            Q0.append("): ");
                            Q0.append(aVar);
                            Log.v("FragmentManager", Q0.toString());
                            PrintWriter printWriter = new PrintWriter(new p0("FragmentManager"));
                            aVar.w("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.d.add(aVar);
                        i2++;
                        fragment4 = null;
                    }
                } else {
                    this.d = null;
                }
                this.i.set(fragmentManagerState.x);
                String str3 = fragmentManagerState.y;
                if (str3 != null) {
                    Fragment H = H(str3);
                    this.u = H;
                    t(H);
                }
                ArrayList<String> arrayList2 = fragmentManagerState.Y1;
                if (arrayList2 != null) {
                    for (int i13 = 0; i13 < arrayList2.size(); i13++) {
                        Bundle bundle = fragmentManagerState.Z1.get(i13);
                        bundle.setClassLoader(this.r.d.getClassLoader());
                        this.j.put(arrayList2.get(i13), bundle);
                    }
                }
                this.B = new ArrayDeque<>(fragmentManagerState.a2);
            }
        }
    }

    public void g(h0.o.a.a aVar, boolean z, boolean z2, boolean z3) {
        if (z) {
            aVar.y(z3);
        } else {
            aVar.x();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(aVar);
        arrayList2.add(Boolean.valueOf(z));
        if (z2 && this.q >= 1) {
            j0.r(this.r.d, this.s, arrayList, arrayList2, 0, 1, true, this.n);
        }
        if (z3) {
            W(this.q, true);
        }
        Iterator it = ((ArrayList) this.c.g()).iterator();
        while (it.hasNext()) {
            Fragment fragment = (Fragment) it.next();
            if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && aVar.z(fragment.mContainerId)) {
                float f2 = fragment.mPostponedAlpha;
                if (f2 > 0.0f) {
                    fragment.mView.setAlpha(f2);
                }
                if (z3) {
                    fragment.mPostponedAlpha = 0.0f;
                } else {
                    fragment.mPostponedAlpha = -1.0f;
                    fragment.mIsNewlyAdded = false;
                }
            }
        }
    }

    public Parcelable g0() {
        int i2;
        BackStackState[] backStackStateArr;
        ArrayList<String> arrayList;
        int size;
        K();
        z();
        C(true);
        this.D = true;
        this.L.g = true;
        b0 b0Var = this.c;
        Objects.requireNonNull(b0Var);
        ArrayList<FragmentState> arrayList2 = new ArrayList<>(b0Var.b.size());
        Iterator<a0> it = b0Var.b.values().iterator();
        while (true) {
            backStackStateArr = null;
            Bundle bundle = null;
            backStackStateArr = null;
            if (!it.hasNext()) {
                break;
            }
            a0 next = it.next();
            if (next != null) {
                Fragment fragment = next.c;
                FragmentState fragmentState = new FragmentState(fragment);
                Fragment fragment2 = next.c;
                if (fragment2.mState <= -1 || fragmentState.f2 != null) {
                    fragmentState.f2 = fragment2.mSavedFragmentState;
                } else {
                    Bundle bundle2 = new Bundle();
                    next.c.performSaveInstanceState(bundle2);
                    next.a.j(next.c, bundle2, false);
                    if (!bundle2.isEmpty()) {
                        bundle = bundle2;
                    }
                    if (next.c.mView != null) {
                        next.o();
                    }
                    if (next.c.mSavedViewState != null) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putSparseParcelableArray("android:view_state", next.c.mSavedViewState);
                    }
                    if (next.c.mSavedViewRegistryState != null) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putBundle("android:view_registry_state", next.c.mSavedViewRegistryState);
                    }
                    if (!next.c.mUserVisibleHint) {
                        if (bundle == null) {
                            bundle = new Bundle();
                        }
                        bundle.putBoolean("android:user_visible_hint", next.c.mUserVisibleHint);
                    }
                    fragmentState.f2 = bundle;
                    if (next.c.mTargetWho != null) {
                        if (bundle == null) {
                            fragmentState.f2 = new Bundle();
                        }
                        fragmentState.f2.putString("android:target_state", next.c.mTargetWho);
                        int i3 = next.c.mTargetRequestCode;
                        if (i3 != 0) {
                            fragmentState.f2.putInt("android:target_req_state", i3);
                        }
                    }
                }
                arrayList2.add(fragmentState);
                if (R(2)) {
                    Log.v("FragmentManager", "Saved state of " + fragment + ": " + fragmentState.f2);
                }
            }
        }
        if (arrayList2.isEmpty()) {
            if (R(2)) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        b0 b0Var2 = this.c;
        synchronized (b0Var2.a) {
            if (b0Var2.a.isEmpty()) {
                arrayList = null;
            } else {
                arrayList = new ArrayList<>(b0Var2.a.size());
                Iterator<Fragment> it2 = b0Var2.a.iterator();
                while (it2.hasNext()) {
                    Fragment next2 = it2.next();
                    arrayList.add(next2.mWho);
                    if (R(2)) {
                        Log.v("FragmentManager", "saveAllState: adding fragment (" + next2.mWho + "): " + next2);
                    }
                }
            }
        }
        ArrayList<h0.o.a.a> arrayList3 = this.d;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (i2 = 0; i2 < size; i2++) {
                backStackStateArr[i2] = new BackStackState(this.d.get(i2));
                if (R(2)) {
                    StringBuilder Q0 = i0.d.a.a.a.Q0("saveAllState: adding back stack #", i2, ": ");
                    Q0.append(this.d.get(i2));
                    Log.v("FragmentManager", Q0.toString());
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.c = arrayList2;
        fragmentManagerState.d = arrayList;
        fragmentManagerState.q = backStackStateArr;
        fragmentManagerState.x = this.i.get();
        Fragment fragment3 = this.u;
        if (fragment3 != null) {
            fragmentManagerState.y = fragment3.mWho;
        }
        fragmentManagerState.Y1.addAll(this.j.keySet());
        fragmentManagerState.Z1.addAll(this.j.values());
        fragmentManagerState.a2 = new ArrayList<>(this.B);
        return fragmentManagerState;
    }

    public a0 h(Fragment fragment) {
        a0 h2 = this.c.h(fragment.mWho);
        if (h2 != null) {
            return h2;
        }
        a0 a0Var = new a0(this.o, this.c, fragment);
        a0Var.m(this.r.d.getClassLoader());
        a0Var.e = this.q;
        return a0Var;
    }

    public void h0() {
        synchronized (this.a) {
            ArrayList<o> arrayList = this.K;
            boolean z = false;
            boolean z2 = arrayList != null && !arrayList.isEmpty();
            if (this.a.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.r.q.removeCallbacks(this.M);
                this.r.q.post(this.M);
                o0();
            }
        }
    }

    public final void i(Fragment fragment) {
        fragment.performDestroyView();
        this.o.n(fragment, false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.setValue(null);
        fragment.mInLayout = false;
    }

    public void i0(Fragment fragment, boolean z) {
        ViewGroup M = M(fragment);
        if (M != null && (M instanceof FragmentContainerView)) {
            ((FragmentContainerView) M).setDrawDisappearingViewsLast(!z);
        }
    }

    public void j(Fragment fragment) {
        if (R(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (R(2)) {
                    Log.v("FragmentManager", "remove from detach: " + fragment);
                }
                this.c.l(fragment);
                if (S(fragment)) {
                    this.C = true;
                }
                l0(fragment);
            }
        }
    }

    public void j0(Fragment fragment, Lifecycle.State state) {
        if (!fragment.equals(H(fragment.mWho)) || !(fragment.mHost == null || fragment.mFragmentManager == this)) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        fragment.mMaxState = state;
    }

    public void k(Configuration configuration) {
        for (Fragment fragment : this.c.i()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    public void k0(Fragment fragment) {
        if (fragment == null || (fragment.equals(H(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.u;
            this.u = fragment;
            t(fragment2);
            t(this.u);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public boolean l(MenuItem menuItem) {
        if (this.q < 1) {
            return false;
        }
        for (Fragment fragment : this.c.i()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void l0(Fragment fragment) {
        ViewGroup M = M(fragment);
        if (M != null) {
            if (fragment.getPopExitAnim() + fragment.getPopEnterAnim() + fragment.getExitAnim() + fragment.getEnterAnim() > 0) {
                int i2 = R.id.visible_removing_fragment_view_tag;
                if (M.getTag(i2) == null) {
                    M.setTag(i2, fragment);
                }
                ((Fragment) M.getTag(i2)).setPopDirection(fragment.getPopDirection());
            }
        }
    }

    public void m() {
        this.D = false;
        this.E = false;
        this.L.g = false;
        w(1);
    }

    public void m0(Fragment fragment) {
        if (R(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public boolean n(Menu menu, MenuInflater menuInflater) {
        if (this.q < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (Fragment fragment : this.c.i()) {
            if (fragment != null && T(fragment) && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.e != null) {
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                Fragment fragment2 = this.e.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.e = arrayList;
        return z;
    }

    public final void n0() {
        Iterator it = ((ArrayList) this.c.f()).iterator();
        while (it.hasNext()) {
            Z((a0) it.next());
        }
    }

    public void o() {
        this.F = true;
        C(true);
        z();
        w(-1);
        this.r = null;
        this.s = null;
        this.t = null;
        if (this.g != null) {
            this.h.b();
            this.g = null;
        }
        h0.a.f.b<Intent> bVar = this.y;
        if (bVar != null) {
            bVar.b();
            this.z.b();
            this.A.b();
        }
    }

    public final void o0() {
        synchronized (this.a) {
            boolean z = true;
            if (!this.a.isEmpty()) {
                this.h.a = true;
                return;
            }
            h0.a.b bVar = this.h;
            if (L() <= 0 || !U(this.t)) {
                z = false;
            }
            bVar.a = z;
        }
    }

    public void p() {
        for (Fragment fragment : this.c.i()) {
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    public void q(boolean z) {
        for (Fragment fragment : this.c.i()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
            }
        }
    }

    public boolean r(MenuItem menuItem) {
        if (this.q < 1) {
            return false;
        }
        for (Fragment fragment : this.c.i()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void s(Menu menu) {
        if (this.q >= 1) {
            for (Fragment fragment : this.c.i()) {
                if (fragment != null) {
                    fragment.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    public final void t(Fragment fragment) {
        if (fragment != null && fragment.equals(H(fragment.mWho))) {
            fragment.performPrimaryNavigationFragmentChanged();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.t;
        if (fragment != null) {
            i0.d.a.a.a.k(fragment, sb, "{");
            sb.append(Integer.toHexString(System.identityHashCode(this.t)));
            sb.append("}");
        } else {
            t<?> tVar = this.r;
            if (tVar != null) {
                sb.append(tVar.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.r)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public void u(boolean z) {
        for (Fragment fragment : this.c.i()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
            }
        }
    }

    public boolean v(Menu menu) {
        boolean z = false;
        if (this.q < 1) {
            return false;
        }
        for (Fragment fragment : this.c.i()) {
            if (fragment != null && T(fragment) && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    /* JADX WARN: Finally extract failed */
    public final void w(int i2) {
        try {
            this.b = true;
            for (a0 a0Var : this.c.b.values()) {
                if (a0Var != null) {
                    a0Var.e = i2;
                }
            }
            W(i2, false);
            Iterator it = ((HashSet) f()).iterator();
            while (it.hasNext()) {
                ((SpecialEffectsController) it.next()).e();
            }
            this.b = false;
            C(true);
        } catch (Throwable th) {
            this.b = false;
            throw th;
        }
    }

    public final void x() {
        if (this.G) {
            this.G = false;
            n0();
        }
    }

    public void y(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String n02 = i0.d.a.a.a.n0(str, "    ");
        b0 b0Var = this.c;
        Objects.requireNonNull(b0Var);
        String str2 = str + "    ";
        if (!b0Var.b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (a0 a0Var : b0Var.b.values()) {
                printWriter.print(str);
                if (a0Var != null) {
                    Fragment fragment = a0Var.c;
                    printWriter.println(fragment);
                    fragment.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size3 = b0Var.a.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size3; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(b0Var.a.get(i2).toString());
            }
        }
        ArrayList<Fragment> arrayList = this.e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size2; i3++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(this.e.get(i3).toString());
            }
        }
        ArrayList<h0.o.a.a> arrayList2 = this.d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size; i4++) {
                h0.o.a.a aVar = this.d.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.w(n02, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.i.get());
        synchronized (this.a) {
            int size4 = this.a.size();
            if (size4 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i5 = 0; i5 < size4; i5++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println((m) this.a.get(i5));
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.r);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.s);
        if (this.t != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.t);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.q);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.D);
        printWriter.print(" mStopped=");
        printWriter.print(this.E);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.F);
        if (this.C) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.C);
        }
    }

    public final void z() {
        Iterator it = ((HashSet) f()).iterator();
        while (it.hasNext()) {
            ((SpecialEffectsController) it.next()).e();
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new a();
        public String c;
        public int d;

        /* loaded from: classes.dex */
        public class a implements Parcelable.Creator<LaunchedFragmentInfo> {
            @Override // android.os.Parcelable.Creator
            public LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public LaunchedFragmentInfo[] newArray(int i) {
                return new LaunchedFragmentInfo[i];
            }
        }

        public LaunchedFragmentInfo(String str, int i) {
            this.c = str;
            this.d = i;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.c);
            parcel.writeInt(this.d);
        }

        public LaunchedFragmentInfo(Parcel parcel) {
            this.c = parcel.readString();
            this.d = parcel.readInt();
        }
    }
}
