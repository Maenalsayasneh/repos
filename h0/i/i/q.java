package h0.i.i;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.R;
import h0.i.i.a;
import h0.i.i.g0.b;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ViewCompat.java */
@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public class q {
    public static Field c;
    public static final AtomicInteger a = new AtomicInteger(1);
    public static WeakHashMap<View, y> b = null;
    public static boolean d = false;
    public static final int[] e = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
    public static final o f = new a();

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public class a implements o {
        @Override // h0.i.i.o
        public c onReceiveContent(c cVar) {
            return cVar;
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public static class c {

        /* compiled from: ViewCompat.java */
        /* loaded from: classes.dex */
        public class a implements View.OnApplyWindowInsetsListener {
            public d0 a = null;
            public final /* synthetic */ View b;
            public final /* synthetic */ m c;

            public a(View view, m mVar) {
                this.b = view;
                this.c = mVar;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                d0 k = d0.k(windowInsets, view);
                int i = Build.VERSION.SDK_INT;
                if (i < 30) {
                    c.a(windowInsets, this.b);
                    if (k.equals(this.a)) {
                        return this.c.a(view, k).i();
                    }
                }
                this.a = k;
                d0 a = this.c.a(view, k);
                if (i >= 30) {
                    return a.i();
                }
                AtomicInteger atomicInteger = q.a;
                view.requestApplyInsets();
                return a.i();
            }
        }

        public static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        public static d0 b(View view, d0 d0Var, Rect rect) {
            WindowInsets i = d0Var.i();
            if (i != null) {
                return d0.k(view.computeSystemWindowInsets(i, rect), view);
            }
            rect.setEmpty();
            return d0Var;
        }

        public static void c(View view, m mVar) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(R.id.tag_on_apply_window_listener, mVar);
            }
            if (mVar == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, mVar));
            }
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public static class d {
        public static d0 a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            d0 k = d0.k(rootWindowInsets, null);
            k.b.p(k);
            k.b.d(view.getRootView());
            return k;
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public static class e {
        public static void a(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
        }
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public interface f {
        boolean a(View view, KeyEvent keyEvent);
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public static class g {
        public static final ArrayList<WeakReference<View>> a = new ArrayList<>();
        public WeakHashMap<View, Boolean> b = null;
        public SparseArray<WeakReference<View>> c = null;
        public WeakReference<KeyEvent> d = null;

        public final View a(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.b;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View a2 = a(viewGroup.getChildAt(childCount), keyEvent);
                        if (a2 != null) {
                            return a2;
                        }
                    }
                }
                if (b(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        public final boolean b(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((f) arrayList.get(size)).a(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }
    }

    static {
        new WeakHashMap();
    }

    public static int a(View view, CharSequence charSequence, h0.i.i.g0.d dVar) {
        int i;
        List<b.a> h = h(view);
        int i2 = 0;
        while (true) {
            if (i2 >= h.size()) {
                int i3 = 0;
                int i4 = -1;
                while (true) {
                    int[] iArr = e;
                    if (i3 >= iArr.length || i4 != -1) {
                        break;
                    }
                    int i5 = iArr[i3];
                    boolean z = true;
                    for (int i6 = 0; i6 < h.size(); i6++) {
                        z &= h.get(i6).a() != i5;
                    }
                    if (z) {
                        i4 = i5;
                    }
                    i3++;
                }
                i = i4;
            } else if (TextUtils.equals(charSequence, h.get(i2).b())) {
                i = h.get(i2).a();
                break;
            } else {
                i2++;
            }
        }
        if (i != -1) {
            b.a aVar = new b.a(null, i, charSequence, dVar, null);
            i(view);
            m(aVar.a(), view);
            h(view).add(aVar);
            j(view, 0);
        }
        return i;
    }

    public static y b(View view) {
        if (b == null) {
            b = new WeakHashMap<>();
        }
        y yVar = b.get(view);
        if (yVar != null) {
            return yVar;
        }
        y yVar2 = new y(view);
        b.put(view, yVar2);
        return yVar2;
    }

    public static d0 c(View view, d0 d0Var) {
        WindowInsets i = d0Var.i();
        if (i != null) {
            WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(i);
            if (!dispatchApplyWindowInsets.equals(i)) {
                return d0.k(dispatchApplyWindowInsets, view);
            }
        }
        return d0Var;
    }

    public static boolean d(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList<WeakReference<View>> arrayList = g.a;
        int i = R.id.tag_unhandled_key_event_manager;
        g gVar = (g) view.getTag(i);
        if (gVar == null) {
            gVar = new g();
            view.setTag(i, gVar);
        }
        if (keyEvent.getAction() == 0) {
            WeakHashMap<View, Boolean> weakHashMap = gVar.b;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList2 = g.a;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    if (gVar.b == null) {
                        gVar.b = new WeakHashMap<>();
                    }
                    int size = arrayList2.size();
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        ArrayList<WeakReference<View>> arrayList3 = g.a;
                        View view2 = arrayList3.get(size).get();
                        if (view2 == null) {
                            arrayList3.remove(size);
                        } else {
                            gVar.b.put(view2, Boolean.TRUE);
                            for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                gVar.b.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }
        View a2 = gVar.a(view, keyEvent);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (a2 != null && !KeyEvent.isModifierKey(keyCode)) {
                if (gVar.c == null) {
                    gVar.c = new SparseArray<>();
                }
                gVar.c.put(keyCode, new WeakReference<>(a2));
            }
        }
        if (a2 != null) {
            return true;
        }
        return false;
    }

    public static a e(View view) {
        View.AccessibilityDelegate f2 = f(view);
        if (f2 == null) {
            return null;
        }
        if (f2 instanceof a.C0076a) {
            return ((a.C0076a) f2).a;
        }
        return new a(f2);
    }

    public static View.AccessibilityDelegate f(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return view.getAccessibilityDelegate();
        }
        if (d) {
            return null;
        }
        if (c == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                c = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                d = true;
                return null;
            }
        }
        try {
            Object obj = c.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            d = true;
            return null;
        }
    }

    public static CharSequence g(View view) {
        return new s(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28).d(view);
    }

    public static List<b.a> h(View view) {
        int i = R.id.tag_accessibility_actions;
        ArrayList arrayList = (ArrayList) view.getTag(i);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(i, arrayList2);
        return arrayList2;
    }

    public static a i(View view) {
        a e2 = e(view);
        if (e2 == null) {
            e2 = new a();
        }
        p(view, e2);
        return e2;
    }

    public static void j(View view, int i) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = g(view) != null && view.getVisibility() == 0;
            int i2 = 32;
            if (view.getAccessibilityLiveRegion() != 0 || z) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                if (!z) {
                    i2 = 2048;
                }
                obtain.setEventType(i2);
                obtain.setContentChangeTypes(i);
                if (z) {
                    obtain.getText().add(g(view));
                    if (view.getImportantForAccessibility() == 0) {
                        view.setImportantForAccessibility(1);
                    }
                    ViewParent parent = view.getParent();
                    while (true) {
                        if (!(parent instanceof View)) {
                            break;
                        } else if (((View) parent).getImportantForAccessibility() == 4) {
                            view.setImportantForAccessibility(2);
                            break;
                        } else {
                            parent = parent.getParent();
                        }
                    }
                }
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (i == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                obtain2.setContentChangeTypes(i);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(g(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
            } else if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                } catch (AbstractMethodError e2) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
                }
            }
        }
    }

    public static d0 k(View view, d0 d0Var) {
        WindowInsets i = d0Var.i();
        if (i != null) {
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(i);
            if (!onApplyWindowInsets.equals(i)) {
                return d0.k(onApplyWindowInsets, view);
            }
        }
        return d0Var;
    }

    public static c l(View view, c cVar) {
        o oVar;
        o oVar2;
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + cVar + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        n nVar = (n) view.getTag(R.id.tag_on_receive_content_listener);
        if (nVar != null) {
            c a2 = nVar.a(view, cVar);
            if (a2 == null) {
                return null;
            }
            if (view instanceof o) {
                oVar2 = (o) view;
            } else {
                oVar2 = f;
            }
            return oVar2.onReceiveContent(a2);
        }
        if (view instanceof o) {
            oVar = (o) view;
        } else {
            oVar = f;
        }
        return oVar.onReceiveContent(cVar);
    }

    public static void m(int i, View view) {
        List<b.a> h = h(view);
        for (int i2 = 0; i2 < h.size(); i2++) {
            if (h.get(i2).a() == i) {
                h.remove(i2);
                return;
            }
        }
    }

    public static void n(View view, b.a aVar, CharSequence charSequence, h0.i.i.g0.d dVar) {
        b.a aVar2 = new b.a(null, aVar.j, null, dVar, aVar.k);
        i(view);
        m(aVar2.a(), view);
        h(view).add(aVar2);
        j(view, 0);
    }

    public static void o(View view, @SuppressLint({"ContextFirst"}) Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            e.a(view, context, iArr, attributeSet, typedArray, i, i2);
        }
    }

    public static void p(View view, a aVar) {
        View.AccessibilityDelegate accessibilityDelegate;
        if (aVar == null && (f(view) instanceof a.C0076a)) {
            aVar = new a();
        }
        if (aVar == null) {
            accessibilityDelegate = null;
        } else {
            accessibilityDelegate = aVar.getBridge();
        }
        view.setAccessibilityDelegate(accessibilityDelegate);
    }

    /* compiled from: ViewCompat.java */
    /* loaded from: classes.dex */
    public static abstract class b<T> {
        public final int a;
        public final Class<T> b;
        public final int c;
        public final int d;

        public b(int i, Class<T> cls, int i2) {
            this.a = i;
            this.b = cls;
            this.d = 0;
            this.c = i2;
        }

        public boolean a(Boolean bool, Boolean bool2) {
            boolean z;
            boolean booleanValue = bool == null ? false : bool.booleanValue();
            if (bool2 == null) {
                z = false;
            } else {
                z = bool2.booleanValue();
            }
            if (booleanValue == z) {
                return true;
            }
            return false;
        }

        public abstract T b(View view);

        public abstract void c(View view, T t);

        public T d(View view) {
            if (Build.VERSION.SDK_INT >= this.c) {
                return b(view);
            }
            T t = (T) view.getTag(this.a);
            if (this.b.isInstance(t)) {
                return t;
            }
            return null;
        }

        public void e(View view, T t) {
            if (Build.VERSION.SDK_INT >= this.c) {
                c(view, t);
            } else if (f(d(view), t)) {
                q.i(view);
                view.setTag(this.a, t);
                q.j(view, this.d);
            }
        }

        public abstract boolean f(T t, T t2);

        public b(int i, Class<T> cls, int i2, int i3) {
            this.a = i;
            this.b = cls;
            this.d = i2;
            this.c = i3;
        }
    }
}
