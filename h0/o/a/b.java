package h0.o.a;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.transition.Transition;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.app.SharedElementCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.SpecialEffectsController;
import h0.f.g;
import h0.i.i.p;
import h0.i.i.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: DefaultSpecialEffectsController.java */
/* loaded from: classes.dex */
public class b extends SpecialEffectsController {

    /* compiled from: DefaultSpecialEffectsController.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ List c;
        public final /* synthetic */ SpecialEffectsController.Operation d;

        public a(List list, SpecialEffectsController.Operation operation) {
            this.c = list;
            this.d = operation;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.c.contains(this.d)) {
                this.c.remove(this.d);
                b bVar = b.this;
                SpecialEffectsController.Operation operation = this.d;
                Objects.requireNonNull(bVar);
                operation.a.applyState(operation.c.mView);
            }
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* renamed from: h0.o.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0089b extends c {
        public boolean c;
        public boolean d = false;
        public o e;

        public C0089b(SpecialEffectsController.Operation operation, h0.i.e.a aVar, boolean z) {
            super(operation, aVar);
            this.c = z;
        }

        public o c(Context context) {
            if (this.d) {
                return this.e;
            }
            SpecialEffectsController.Operation operation = this.a;
            o b0 = g0.a.b.b.a.b0(context, operation.c, operation.a == SpecialEffectsController.Operation.State.VISIBLE, this.c);
            this.e = b0;
            this.d = true;
            return b0;
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* loaded from: classes.dex */
    public static class c {
        public final SpecialEffectsController.Operation a;
        public final h0.i.e.a b;

        public c(SpecialEffectsController.Operation operation, h0.i.e.a aVar) {
            this.a = operation;
            this.b = aVar;
        }

        public void a() {
            SpecialEffectsController.Operation operation = this.a;
            if (operation.e.remove(this.b) && operation.e.isEmpty()) {
                operation.b();
            }
        }

        public boolean b() {
            SpecialEffectsController.Operation.State state;
            SpecialEffectsController.Operation.State from = SpecialEffectsController.Operation.State.from(this.a.c.mView);
            SpecialEffectsController.Operation.State state2 = this.a.a;
            return from == state2 || !(from == (state = SpecialEffectsController.Operation.State.VISIBLE) || state2 == state);
        }
    }

    /* compiled from: DefaultSpecialEffectsController.java */
    /* loaded from: classes.dex */
    public static class d extends c {
        public final Object c;
        public final boolean d;
        public final Object e;

        public d(SpecialEffectsController.Operation operation, h0.i.e.a aVar, boolean z, boolean z2) {
            super(operation, aVar);
            Object obj;
            Object obj2;
            boolean z3;
            if (operation.a == SpecialEffectsController.Operation.State.VISIBLE) {
                if (z) {
                    obj2 = operation.c.getReenterTransition();
                } else {
                    obj2 = operation.c.getEnterTransition();
                }
                this.c = obj2;
                if (z) {
                    z3 = operation.c.getAllowReturnTransitionOverlap();
                } else {
                    z3 = operation.c.getAllowEnterTransitionOverlap();
                }
                this.d = z3;
            } else {
                if (z) {
                    obj = operation.c.getReturnTransition();
                } else {
                    obj = operation.c.getExitTransition();
                }
                this.c = obj;
                this.d = true;
            }
            if (!z2) {
                this.e = null;
            } else if (z) {
                this.e = operation.c.getSharedElementReturnTransition();
            } else {
                this.e = operation.c.getSharedElementEnterTransition();
            }
        }

        public final l0 c(Object obj) {
            if (obj == null) {
                return null;
            }
            l0 l0Var = j0.b;
            if (obj instanceof Transition) {
                return l0Var;
            }
            l0 l0Var2 = j0.c;
            if (l0Var2 != null && l0Var2.e(obj)) {
                return l0Var2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + this.a.c + " is not a valid framework Transition or AndroidX Transition");
        }
    }

    public b(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:193:0x05fb  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x06a8  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0740 A[LOOP:13: B:236:0x073a->B:238:0x0740, LOOP_END] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r33v0, types: [h0.o.a.b, androidx.fragment.app.SpecialEffectsController] */
    @Override // androidx.fragment.app.SpecialEffectsController
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void b(List<SpecialEffectsController.Operation> list, boolean z) {
        ArrayList arrayList;
        HashMap hashMap;
        String str;
        ArrayList arrayList2;
        boolean z2;
        Iterator it;
        Iterator it2;
        Iterator it3;
        ArrayList arrayList3;
        String str2;
        View view;
        Object obj;
        String str3;
        ArrayList<View> arrayList4;
        View view2;
        SpecialEffectsController.Operation operation;
        Object obj2;
        SpecialEffectsController.Operation operation2;
        Object obj3;
        h0.f.a aVar;
        ArrayList arrayList5;
        ArrayList arrayList6;
        View view3;
        SpecialEffectsController.Operation operation3;
        SpecialEffectsController.Operation operation4;
        HashMap hashMap2;
        ArrayList<View> arrayList7;
        String str4;
        ArrayList<View> arrayList8;
        View view4;
        Rect rect;
        l0 l0Var;
        SharedElementCallback sharedElementCallback;
        SharedElementCallback sharedElementCallback2;
        ArrayList<String> arrayList9;
        Object obj4;
        int i;
        View view5;
        View view6;
        String i2;
        ArrayList<String> arrayList10;
        boolean z3 = z;
        SpecialEffectsController.Operation operation5 = null;
        SpecialEffectsController.Operation operation6 = null;
        for (SpecialEffectsController.Operation operation7 : list) {
            SpecialEffectsController.Operation.State from = SpecialEffectsController.Operation.State.from(operation7.c.mView);
            int ordinal = operation7.a.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (!(ordinal == 2 || ordinal == 3)) {
                    }
                } else if (from != SpecialEffectsController.Operation.State.VISIBLE) {
                    operation6 = operation7;
                }
            }
            if (from == SpecialEffectsController.Operation.State.VISIBLE && operation5 == null) {
                operation5 = operation7;
            }
        }
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = new ArrayList(list);
        Iterator<SpecialEffectsController.Operation> it4 = list.iterator();
        while (it4.hasNext()) {
            SpecialEffectsController.Operation next = it4.next();
            h0.i.e.a aVar2 = new h0.i.e.a();
            next.d();
            next.e.add(aVar2);
            arrayList11.add(new C0089b(next, aVar2, z3));
            h0.i.e.a aVar3 = new h0.i.e.a();
            next.d();
            next.e.add(aVar3);
            arrayList12.add(new d(next, aVar3, z3, !z3 ? next == operation6 : next == operation5));
            next.d.add(new a(arrayList13, next));
        }
        HashMap hashMap3 = new HashMap();
        Iterator it5 = arrayList12.iterator();
        l0 l0Var2 = 0;
        while (it5.hasNext()) {
            d dVar = (d) it5.next();
            if (!dVar.b()) {
                l0 c2 = dVar.c(dVar.c);
                l0 c3 = dVar.c(dVar.e);
                if (c2 == null || c3 == null || c2 == c3) {
                    if (c2 == null) {
                        c2 = c3;
                    }
                    if (l0Var2 == 0) {
                        l0Var2 = c2;
                    } else if (!(c2 == null || l0Var2 == c2)) {
                        StringBuilder P0 = i0.d.a.a.a.P0("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
                        P0.append(dVar.a.c);
                        P0.append(" returned Transition ");
                        P0.append(dVar.c);
                        P0.append(" which uses a different Transition  type than other Fragments.");
                        throw new IllegalArgumentException(P0.toString());
                    }
                } else {
                    StringBuilder P02 = i0.d.a.a.a.P0("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
                    P02.append(dVar.a.c);
                    P02.append(" returned Transition ");
                    P02.append(dVar.c);
                    P02.append(" which uses a different Transition  type than its shared element transition ");
                    P02.append(dVar.e);
                    throw new IllegalArgumentException(P02.toString());
                }
            }
        }
        String str5 = "FragmentManager";
        if (l0Var2 == null) {
            Iterator it6 = arrayList12.iterator();
            while (it6.hasNext()) {
                d dVar2 = (d) it6.next();
                hashMap3.put(dVar2.a, Boolean.FALSE);
                dVar2.a();
            }
            arrayList = arrayList11;
            arrayList3 = arrayList13;
            hashMap = hashMap3;
            str = str5;
        } else {
            View view7 = new View(this.a.getContext());
            Rect rect2 = new Rect();
            ArrayList<View> arrayList14 = new ArrayList<>();
            ArrayList<View> arrayList15 = new ArrayList<>();
            h0.f.a aVar4 = new h0.f.a();
            Iterator it7 = arrayList12.iterator();
            Object obj5 = null;
            View view8 = null;
            boolean z4 = false;
            Rect rect3 = rect2;
            SpecialEffectsController.Operation operation8 = operation5;
            arrayList = arrayList11;
            View view9 = view7;
            SpecialEffectsController.Operation operation9 = operation6;
            while (it7.hasNext()) {
                Object obj6 = ((d) it7.next()).e;
                if (!(obj6 != null) || operation8 == null || operation9 == null) {
                    rect = rect3;
                    aVar = aVar4;
                    view3 = view8;
                    arrayList5 = arrayList12;
                    arrayList6 = arrayList13;
                    hashMap2 = hashMap3;
                    str4 = str5;
                    arrayList7 = arrayList14;
                    operation4 = operation5;
                    view4 = view9;
                    arrayList8 = arrayList15;
                    l0Var = l0Var2;
                    operation3 = operation6;
                } else {
                    Object y = l0Var2.y(l0Var2.g(obj6));
                    ArrayList<String> sharedElementSourceNames = operation9.c.getSharedElementSourceNames();
                    view3 = view8;
                    ArrayList<String> sharedElementSourceNames2 = operation8.c.getSharedElementSourceNames();
                    arrayList6 = arrayList13;
                    int i3 = 0;
                    arrayList5 = arrayList12;
                    for (ArrayList<String> sharedElementTargetNames = operation8.c.getSharedElementTargetNames(); i3 < sharedElementTargetNames.size(); sharedElementTargetNames = sharedElementTargetNames) {
                        int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i3));
                        if (indexOf != -1) {
                            sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i3));
                        }
                        i3++;
                    }
                    ArrayList<String> sharedElementTargetNames2 = operation9.c.getSharedElementTargetNames();
                    if (!z3) {
                        sharedElementCallback2 = operation8.c.getExitTransitionCallback();
                        sharedElementCallback = operation9.c.getEnterTransitionCallback();
                    } else {
                        sharedElementCallback2 = operation8.c.getEnterTransitionCallback();
                        sharedElementCallback = operation9.c.getExitTransitionCallback();
                    }
                    int size = sharedElementSourceNames.size();
                    int i4 = 0;
                    while (i4 < size) {
                        aVar4.put(sharedElementSourceNames.get(i4), sharedElementTargetNames2.get(i4));
                        i4++;
                        size = size;
                        l0Var2 = l0Var2;
                    }
                    h0.f.a aVar5 = new h0.f.a();
                    k(aVar5, operation8.c.mView);
                    g.k(aVar5, sharedElementSourceNames);
                    if (sharedElementCallback2 != null) {
                        sharedElementCallback2.onMapSharedElements(sharedElementSourceNames, aVar5);
                        int size2 = sharedElementSourceNames.size() - 1;
                        while (size2 >= 0) {
                            String str6 = sharedElementSourceNames.get(size2);
                            View view10 = (View) aVar5.get(str6);
                            if (view10 == null) {
                                aVar4.remove(str6);
                                arrayList10 = sharedElementSourceNames;
                            } else {
                                AtomicInteger atomicInteger = q.a;
                                arrayList10 = sharedElementSourceNames;
                                if (!str6.equals(view10.getTransitionName())) {
                                    aVar4.put(view10.getTransitionName(), (String) aVar4.remove(str6));
                                }
                            }
                            size2--;
                            sharedElementSourceNames = arrayList10;
                        }
                        arrayList9 = sharedElementSourceNames;
                    } else {
                        arrayList9 = sharedElementSourceNames;
                        g.k(aVar4, aVar5.keySet());
                    }
                    h0.f.a aVar6 = new h0.f.a();
                    k(aVar6, operation9.c.mView);
                    g.k(aVar6, sharedElementTargetNames2);
                    g.k(aVar6, aVar4.values());
                    if (sharedElementCallback != null) {
                        sharedElementCallback.onMapSharedElements(sharedElementTargetNames2, aVar6);
                        for (int size3 = sharedElementTargetNames2.size() - 1; size3 >= 0; size3--) {
                            String str7 = sharedElementTargetNames2.get(size3);
                            View view11 = (View) aVar6.get(str7);
                            if (view11 == null) {
                                String i5 = j0.i(aVar4, str7);
                                if (i5 != null) {
                                    aVar4.remove(i5);
                                }
                            } else {
                                AtomicInteger atomicInteger2 = q.a;
                                if (!str7.equals(view11.getTransitionName()) && (i2 = j0.i(aVar4, str7)) != null) {
                                    aVar4.put(i2, view11.getTransitionName());
                                }
                            }
                        }
                    } else {
                        j0.o(aVar4, aVar6);
                    }
                    l(aVar5, aVar4.keySet());
                    l(aVar6, aVar4.values());
                    if (aVar4.isEmpty()) {
                        arrayList14.clear();
                        arrayList15.clear();
                        obj5 = null;
                        rect = rect3;
                        aVar = aVar4;
                        arrayList7 = arrayList14;
                        operation4 = operation5;
                        operation3 = operation6;
                        view4 = view9;
                        str4 = str5;
                        hashMap2 = hashMap3;
                        arrayList8 = arrayList15;
                        l0Var = l0Var2;
                    } else {
                        j0.c(operation9.c, operation8.c, z3, aVar5, true);
                        aVar = aVar4;
                        rect = rect3;
                        arrayList8 = arrayList15;
                        view4 = view9;
                        p.a(this.a, new g(this, operation6, operation5, z, aVar6));
                        arrayList14.addAll(aVar5.values());
                        if (!arrayList9.isEmpty()) {
                            i = 0;
                            view5 = (View) aVar5.get(arrayList9.get(0));
                            obj4 = y;
                            l0Var = l0Var2;
                            l0Var.t(obj4, view5);
                        } else {
                            obj4 = y;
                            l0Var = l0Var2;
                            i = 0;
                            view5 = view3;
                        }
                        arrayList8.addAll(aVar6.values());
                        if (!sharedElementTargetNames2.isEmpty() && (view6 = (View) aVar6.get(sharedElementTargetNames2.get(i))) != null) {
                            p.a(this.a, new h(this, l0Var, view6, rect));
                            z4 = true;
                        }
                        l0Var.w(obj4, view4, arrayList14);
                        str4 = str5;
                        arrayList7 = arrayList14;
                        l0Var.r(obj4, null, null, null, null, obj4, arrayList8);
                        Boolean bool = Boolean.TRUE;
                        hashMap2 = hashMap3;
                        operation4 = operation5;
                        hashMap2.put(operation4, bool);
                        operation3 = operation6;
                        hashMap2.put(operation3, bool);
                        view3 = view5;
                        obj5 = obj4;
                        operation8 = operation4;
                        operation9 = operation3;
                    }
                }
                rect3 = rect;
                view9 = view4;
                str5 = str4;
                arrayList14 = arrayList7;
                operation5 = operation4;
                view8 = view3;
                arrayList12 = arrayList5;
                aVar4 = aVar;
                z3 = z;
                hashMap3 = hashMap2;
                arrayList13 = arrayList6;
                l0Var2 = l0Var;
                arrayList15 = arrayList8;
                operation6 = operation3;
            }
            View view12 = view8;
            arrayList3 = arrayList13;
            hashMap = hashMap3;
            String str8 = str5;
            View view13 = view9;
            ArrayList<View> arrayList16 = arrayList14;
            SpecialEffectsController.Operation operation10 = operation6;
            ArrayList arrayList17 = new ArrayList();
            Iterator it8 = arrayList12.iterator();
            Object obj7 = null;
            Object obj8 = null;
            while (it8.hasNext()) {
                d dVar3 = (d) it8.next();
                if (dVar3.b()) {
                    hashMap.put(dVar3.a, Boolean.FALSE);
                    dVar3.a();
                    obj8 = obj8;
                    obj = obj5;
                    view = view13;
                    str3 = str8;
                    arrayList4 = arrayList16;
                    view2 = view12;
                    operation = operation10;
                } else {
                    Object g = l0Var2.g(dVar3.c);
                    SpecialEffectsController.Operation operation11 = dVar3.a;
                    boolean z5 = obj5 != null && (operation11 == operation8 || operation11 == operation9);
                    if (g == null) {
                        if (!z5) {
                            hashMap.put(operation11, Boolean.FALSE);
                            dVar3.a();
                        }
                        obj8 = obj8;
                        obj = obj5;
                        view = view13;
                        str3 = str8;
                        arrayList4 = arrayList16;
                        view2 = view12;
                        operation = operation10;
                    } else {
                        str3 = str8;
                        ArrayList<View> arrayList18 = new ArrayList<>();
                        obj = obj5;
                        j(arrayList18, operation11.c.mView);
                        if (z5) {
                            if (operation11 == operation8) {
                                arrayList18.removeAll(arrayList16);
                            } else {
                                arrayList18.removeAll(arrayList15);
                            }
                        }
                        if (arrayList18.isEmpty()) {
                            l0Var2.a(g, view13);
                            obj3 = obj8;
                            view = view13;
                            arrayList4 = arrayList16;
                            operation2 = operation11;
                            obj2 = g;
                            operation = operation10;
                        } else {
                            l0Var2.b(g, arrayList18);
                            obj3 = obj8;
                            operation2 = operation11;
                            view = view13;
                            operation = operation10;
                            l0Var2.r(g, g, arrayList18, null, null, null, null);
                            if (operation2.a == SpecialEffectsController.Operation.State.GONE) {
                                arrayList3.remove(operation2);
                                ArrayList<View> arrayList19 = new ArrayList<>(arrayList18);
                                arrayList19.remove(operation2.c.mView);
                                arrayList4 = arrayList16;
                                obj2 = g;
                                l0Var2.q(obj2, operation2.c.mView, arrayList19);
                                p.a(this.a, new i(this, arrayList18));
                            } else {
                                arrayList4 = arrayList16;
                                obj2 = g;
                            }
                        }
                        if (operation2.a == SpecialEffectsController.Operation.State.VISIBLE) {
                            arrayList17.addAll(arrayList18);
                            if (z4) {
                                l0Var2.s(obj2, rect3);
                            }
                            view2 = view12;
                        } else {
                            view2 = view12;
                            l0Var2.t(obj2, view2);
                        }
                        hashMap.put(operation2, Boolean.TRUE);
                        if (dVar3.d) {
                            obj8 = l0Var2.m(obj3, obj2, null);
                        } else {
                            obj7 = l0Var2.m(obj7, obj2, null);
                            obj8 = obj3;
                        }
                    }
                    operation9 = operation;
                }
                it8 = it8;
                operation10 = operation;
                view12 = view2;
                arrayList16 = arrayList4;
                str8 = str3;
                obj5 = obj;
                view13 = view;
            }
            String str9 = str8;
            Object l = l0Var2.l(obj8, obj7, obj5);
            Iterator it9 = arrayList12.iterator();
            while (it9.hasNext()) {
                d dVar4 = (d) it9.next();
                if (!dVar4.b()) {
                    Object obj9 = dVar4.c;
                    SpecialEffectsController.Operation operation12 = dVar4.a;
                    boolean z6 = obj5 != null && (operation12 == operation8 || operation12 == operation10);
                    if (obj9 != null || z6) {
                        ViewGroup viewGroup = this.a;
                        AtomicInteger atomicInteger3 = q.a;
                        if (!viewGroup.isLaidOut()) {
                            if (FragmentManager.R(2)) {
                                StringBuilder P03 = i0.d.a.a.a.P0("SpecialEffectsController: Container ");
                                P03.append(this.a);
                                P03.append(" has not been laid out. Completing operation ");
                                P03.append(operation12);
                                str2 = str9;
                                Log.v(str2, P03.toString());
                            } else {
                                str2 = str9;
                            }
                            dVar4.a();
                        } else {
                            str2 = str9;
                            l0Var2.u(dVar4.a.c, l, dVar4.b, new j(this, dVar4));
                        }
                    } else {
                        str2 = str9;
                    }
                    str9 = str2;
                }
            }
            str = str9;
            ViewGroup viewGroup2 = this.a;
            AtomicInteger atomicInteger4 = q.a;
            if (viewGroup2.isLaidOut()) {
                j0.q(arrayList17, 4);
                ArrayList<String> n = l0Var2.n(arrayList15);
                l0Var2.c(this.a, l);
                arrayList2 = arrayList3;
                l0Var2.v(this.a, arrayList16, arrayList15, n, aVar4);
                z2 = false;
                j0.q(arrayList17, 0);
                l0Var2.x(obj5, arrayList16, arrayList15);
                boolean containsValue = hashMap.containsValue(Boolean.TRUE);
                ViewGroup viewGroup3 = this.a;
                Context context = viewGroup3.getContext();
                ArrayList arrayList20 = new ArrayList();
                it = arrayList.iterator();
                while (it.hasNext()) {
                    C0089b bVar = (C0089b) it.next();
                    if (bVar.b()) {
                        bVar.a();
                    } else {
                        o c4 = bVar.c(context);
                        if (c4 == null) {
                            bVar.a();
                        } else {
                            Animator animator = c4.b;
                            if (animator == null) {
                                arrayList20.add(bVar);
                            } else {
                                SpecialEffectsController.Operation operation13 = bVar.a;
                                Fragment fragment = operation13.c;
                                if (Boolean.TRUE.equals(hashMap.get(operation13))) {
                                    if (FragmentManager.R(2)) {
                                        Log.v(str, "Ignoring Animator set on " + fragment + " as this Fragment was involved in a Transition.");
                                    }
                                    bVar.a();
                                } else {
                                    boolean z7 = operation13.a == SpecialEffectsController.Operation.State.GONE;
                                    if (z7) {
                                        arrayList2.remove(operation13);
                                    }
                                    View view14 = fragment.mView;
                                    viewGroup3.startViewTransition(view14);
                                    animator.addListener(new c(this, viewGroup3, view14, z7, operation13, bVar));
                                    animator.setTarget(view14);
                                    animator.start();
                                    bVar.b.b(new d(this, animator));
                                    z2 = true;
                                    it = it;
                                    hashMap = hashMap;
                                }
                            }
                        }
                    }
                }
                it2 = arrayList20.iterator();
                while (it2.hasNext()) {
                    C0089b bVar2 = (C0089b) it2.next();
                    SpecialEffectsController.Operation operation14 = bVar2.a;
                    Fragment fragment2 = operation14.c;
                    if (containsValue) {
                        if (FragmentManager.R(2)) {
                            Log.v(str, "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Transitions.");
                        }
                        bVar2.a();
                    } else if (z2) {
                        if (FragmentManager.R(2)) {
                            Log.v(str, "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Animators.");
                        }
                        bVar2.a();
                    } else {
                        View view15 = fragment2.mView;
                        o c5 = bVar2.c(context);
                        Objects.requireNonNull(c5);
                        Animation animation = c5.a;
                        Objects.requireNonNull(animation);
                        if (operation14.a != SpecialEffectsController.Operation.State.REMOVED) {
                            view15.startAnimation(animation);
                            bVar2.a();
                        } else {
                            viewGroup3.startViewTransition(view15);
                            p pVar = new p(animation, viewGroup3, view15);
                            pVar.setAnimationListener(new e(this, viewGroup3, view15, bVar2));
                            view15.startAnimation(pVar);
                        }
                        bVar2.b.b(new f(this, view15, viewGroup3, bVar2));
                    }
                }
                it3 = arrayList2.iterator();
                while (it3.hasNext()) {
                    SpecialEffectsController.Operation operation15 = (SpecialEffectsController.Operation) it3.next();
                    operation15.a.applyState(operation15.c.mView);
                }
                arrayList2.clear();
            }
        }
        z2 = false;
        arrayList2 = arrayList3;
        boolean containsValue2 = hashMap.containsValue(Boolean.TRUE);
        ViewGroup viewGroup32 = this.a;
        Context context2 = viewGroup32.getContext();
        ArrayList arrayList202 = new ArrayList();
        it = arrayList.iterator();
        while (it.hasNext()) {
        }
        it2 = arrayList202.iterator();
        while (it2.hasNext()) {
        }
        it3 = arrayList2.iterator();
        while (it3.hasNext()) {
        }
        arrayList2.clear();
    }

    public void j(ArrayList<View> arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!viewGroup.isTransitionGroup()) {
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt.getVisibility() == 0) {
                        j(arrayList, childAt);
                    }
                }
            } else if (!arrayList.contains(view)) {
                arrayList.add(viewGroup);
            }
        } else if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    public void k(Map<String, View> map, View view) {
        AtomicInteger atomicInteger = q.a;
        String transitionName = view.getTransitionName();
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    k(map, childAt);
                }
            }
        }
    }

    public void l(h0.f.a<String, View> aVar, Collection<String> collection) {
        Iterator it = ((g.b) aVar.entrySet()).iterator();
        while (true) {
            g.d dVar = (g.d) it;
            if (dVar.hasNext()) {
                dVar.next();
                AtomicInteger atomicInteger = q.a;
                if (!collection.contains(((View) dVar.getValue()).getTransitionName())) {
                    dVar.remove();
                }
            } else {
                return;
            }
        }
    }
}
