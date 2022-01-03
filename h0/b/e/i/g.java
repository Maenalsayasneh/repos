package h0.b.e.i;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import h0.i.i.v;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* compiled from: MenuBuilder.java */
/* loaded from: classes.dex */
public class g implements h0.i.d.a.a {
    public static final int[] a = {1, 4, 5, 3, 2, 0};
    public final Context b;
    public final Resources c;
    public boolean d;
    public boolean e;
    public a f;
    public CharSequence n;
    public Drawable o;
    public View p;
    public i w;
    public boolean y;
    public int m = 0;
    public boolean q = false;
    public boolean r = false;
    public boolean s = false;
    public boolean t = false;
    public ArrayList<i> u = new ArrayList<>();
    public CopyOnWriteArrayList<WeakReference<m>> v = new CopyOnWriteArrayList<>();
    public boolean x = false;
    public ArrayList<i> g = new ArrayList<>();
    public ArrayList<i> h = new ArrayList<>();
    public boolean i = true;
    public ArrayList<i> j = new ArrayList<>();
    public ArrayList<i> k = new ArrayList<>();
    public boolean l = true;

    /* compiled from: MenuBuilder.java */
    /* loaded from: classes.dex */
    public interface a {
        boolean a(g gVar, MenuItem menuItem);

        void b(g gVar);
    }

    /* compiled from: MenuBuilder.java */
    /* loaded from: classes.dex */
    public interface b {
        boolean a(i iVar);
    }

    public g(Context context) {
        boolean z;
        boolean z2 = false;
        this.b = context;
        Resources resources = context.getResources();
        this.c = resources;
        if (resources.getConfiguration().keyboard != 1) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            Method method = v.a;
            if (Build.VERSION.SDK_INT >= 28) {
                z = viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
            } else {
                Resources resources2 = context.getResources();
                int identifier = resources2.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
                z = identifier != 0 && resources2.getBoolean(identifier);
            }
            if (z) {
                z2 = true;
            }
        }
        this.e = z2;
    }

    public MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        int i4;
        int i5 = (-65536 & i3) >> 16;
        if (i5 >= 0) {
            int[] iArr = a;
            if (i5 < iArr.length) {
                int i6 = (iArr[i5] << 16) | (65535 & i3);
                i iVar = new i(this, i, i2, i3, i6, charSequence, this.m);
                ArrayList<i> arrayList = this.g;
                int size = arrayList.size();
                while (true) {
                    size--;
                    if (size >= 0) {
                        if (arrayList.get(size).d <= i6) {
                            i4 = size + 1;
                            break;
                        }
                    } else {
                        i4 = 0;
                        break;
                    }
                }
                arrayList.add(i4, iVar);
                q(true);
                return iVar;
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        int i5;
        PackageManager packageManager = this.b.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i6 = 0; i6 < size; i6++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i6);
            int i7 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i7 < 0 ? intent : intentArr[i7]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            i iVar = (i) a(i, i2, i3, resolveInfo.loadLabel(packageManager));
            iVar.setIcon(resolveInfo.loadIcon(packageManager));
            iVar.setIntent(intent2);
            if (menuItemArr != null && (i5 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i5] = iVar;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public void b(m mVar, Context context) {
        this.v.add(new WeakReference<>(mVar));
        mVar.i(context, this);
        this.l = true;
    }

    public final void c(boolean z) {
        if (!this.t) {
            this.t = true;
            Iterator<WeakReference<m>> it = this.v.iterator();
            while (it.hasNext()) {
                WeakReference<m> next = it.next();
                m mVar = next.get();
                if (mVar == null) {
                    this.v.remove(next);
                } else {
                    mVar.c(this, z);
                }
            }
            this.t = false;
        }
    }

    @Override // android.view.Menu
    public void clear() {
        i iVar = this.w;
        if (iVar != null) {
            d(iVar);
        }
        this.g.clear();
        q(true);
    }

    public void clearHeader() {
        this.o = null;
        this.n = null;
        this.p = null;
        q(false);
    }

    @Override // android.view.Menu
    public void close() {
        c(true);
    }

    public boolean d(i iVar) {
        boolean z = false;
        if (!this.v.isEmpty() && this.w == iVar) {
            z();
            Iterator<WeakReference<m>> it = this.v.iterator();
            while (it.hasNext()) {
                WeakReference<m> next = it.next();
                m mVar = next.get();
                if (mVar == null) {
                    this.v.remove(next);
                } else {
                    z = mVar.f(this, iVar);
                    if (z) {
                        break;
                    }
                }
            }
            y();
            if (z) {
                this.w = null;
            }
        }
        return z;
    }

    public boolean e(g gVar, MenuItem menuItem) {
        a aVar = this.f;
        return aVar != null && aVar.a(gVar, menuItem);
    }

    public boolean f(i iVar) {
        boolean z = false;
        if (this.v.isEmpty()) {
            return false;
        }
        z();
        Iterator<WeakReference<m>> it = this.v.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar = next.get();
            if (mVar == null) {
                this.v.remove(next);
            } else {
                z = mVar.g(this, iVar);
                if (z) {
                    break;
                }
            }
        }
        y();
        if (z) {
            this.w = iVar;
        }
        return z;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        MenuItem findItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = this.g.get(i2);
            if (iVar.a == i) {
                return iVar;
            }
            if (iVar.hasSubMenu() && (findItem = iVar.o.findItem(i)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public i g(int i, KeyEvent keyEvent) {
        char c;
        ArrayList<i> arrayList = this.u;
        arrayList.clear();
        h(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean n = n();
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = arrayList.get(i2);
            if (n) {
                c = iVar.j;
            } else {
                c = iVar.h;
            }
            char[] cArr = keyData.meta;
            if ((c == cArr[0] && (metaState & 2) == 0) || ((c == cArr[2] && (metaState & 2) != 0) || (n && c == '\b' && i == 67))) {
                return iVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.g.get(i);
    }

    public void h(List<i> list, int i, KeyEvent keyEvent) {
        char c;
        int i2;
        boolean n = n();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.g.size();
            for (int i3 = 0; i3 < size; i3++) {
                i iVar = this.g.get(i3);
                if (iVar.hasSubMenu()) {
                    iVar.o.h(list, i, keyEvent);
                }
                if (n) {
                    c = iVar.j;
                } else {
                    c = iVar.h;
                }
                if (n) {
                    i2 = iVar.k;
                } else {
                    i2 = iVar.i;
                }
                if (((modifiers & 69647) == (i2 & 69647)) && c != 0) {
                    char[] cArr = keyData.meta;
                    if ((c == cArr[0] || c == cArr[2] || (n && c == '\b' && i == 67)) && iVar.isEnabled()) {
                        list.add(iVar);
                    }
                }
            }
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.y) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.g.get(i).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public void i() {
        ArrayList<i> l = l();
        if (this.l) {
            Iterator<WeakReference<m>> it = this.v.iterator();
            boolean z = false;
            while (it.hasNext()) {
                WeakReference<m> next = it.next();
                m mVar = next.get();
                if (mVar == null) {
                    this.v.remove(next);
                } else {
                    z |= mVar.e();
                }
            }
            if (z) {
                this.j.clear();
                this.k.clear();
                int size = l.size();
                for (int i = 0; i < size; i++) {
                    i iVar = l.get(i);
                    if (iVar.g()) {
                        this.j.add(iVar);
                    } else {
                        this.k.add(iVar);
                    }
                }
            } else {
                this.j.clear();
                this.k.clear();
                this.k.addAll(l());
            }
            this.l = false;
        }
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return g(i, keyEvent) != null;
    }

    public String j() {
        return "android:menu:actionviewstates";
    }

    public g k() {
        return this;
    }

    public ArrayList<i> l() {
        if (!this.i) {
            return this.h;
        }
        this.h.clear();
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            i iVar = this.g.get(i);
            if (iVar.isVisible()) {
                this.h.add(iVar);
            }
        }
        this.i = false;
        this.l = true;
        return this.h;
    }

    public boolean m() {
        return this.x;
    }

    public boolean n() {
        return this.d;
    }

    public boolean o() {
        return this.e;
    }

    public void p() {
        this.l = true;
        q(true);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return r(findItem(i), i2);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        i g = g(i, keyEvent);
        boolean s = g != null ? s(g, null, i2) : false;
        if ((i2 & 2) != 0) {
            c(true);
        }
        return s;
    }

    public void q(boolean z) {
        if (!this.q) {
            if (z) {
                this.i = true;
                this.l = true;
            }
            if (!this.v.isEmpty()) {
                z();
                Iterator<WeakReference<m>> it = this.v.iterator();
                while (it.hasNext()) {
                    WeakReference<m> next = it.next();
                    m mVar = next.get();
                    if (mVar == null) {
                        this.v.remove(next);
                    } else {
                        mVar.d(z);
                    }
                }
                y();
                return;
            }
            return;
        }
        this.r = true;
        if (z) {
            this.s = true;
        }
    }

    public boolean r(MenuItem menuItem, int i) {
        return s(menuItem, null, i);
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        int size = size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (this.g.get(i2).b == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 >= 0) {
            int size2 = this.g.size() - i2;
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i3 >= size2 || this.g.get(i2).b != i) {
                    break;
                }
                t(i2, false);
                i3 = i4;
            }
            q(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        int size = size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (this.g.get(i2).a == i) {
                break;
            } else {
                i2++;
            }
        }
        t(i2, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public boolean s(MenuItem menuItem, m mVar, int i) {
        boolean z;
        i iVar = (i) menuItem;
        boolean z2 = false;
        if (iVar == null || !iVar.isEnabled()) {
            return false;
        }
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = iVar.p;
        if (onMenuItemClickListener == null || !onMenuItemClickListener.onMenuItemClick(iVar)) {
            g gVar = iVar.n;
            if (!gVar.e(gVar, iVar)) {
                Intent intent = iVar.g;
                if (intent != null) {
                    try {
                        iVar.n.b.startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
                    }
                }
                h0.i.i.b bVar = iVar.A;
                if (bVar == null || !bVar.e()) {
                    z = false;
                    h0.i.i.b bVar2 = iVar.A;
                    boolean z3 = bVar2 == null && bVar2.a();
                    if (!iVar.f()) {
                        z |= iVar.expandActionView();
                        if (z) {
                            c(true);
                        }
                    } else if (iVar.hasSubMenu() || z3) {
                        if ((i & 4) == 0) {
                            c(false);
                        }
                        if (!iVar.hasSubMenu()) {
                            r rVar = new r(this.b, this, iVar);
                            iVar.o = rVar;
                            rVar.setHeaderTitle(iVar.e);
                        }
                        r rVar2 = iVar.o;
                        if (z3) {
                            bVar2.f(rVar2);
                        }
                        if (!this.v.isEmpty()) {
                            if (mVar != null) {
                                z2 = mVar.k(rVar2);
                            }
                            Iterator<WeakReference<m>> it = this.v.iterator();
                            while (it.hasNext()) {
                                WeakReference<m> next = it.next();
                                m mVar2 = next.get();
                                if (mVar2 == null) {
                                    this.v.remove(next);
                                } else if (!z2) {
                                    z2 = mVar2.k(rVar2);
                                }
                            }
                        }
                        z |= z2;
                        if (!z) {
                            c(true);
                        }
                    } else if ((i & 1) == 0) {
                        c(true);
                    }
                    return z;
                }
            }
        }
        z = true;
        h0.i.i.b bVar22 = iVar.A;
        if (bVar22 == null) {
        }
        if (!iVar.f()) {
        }
        return z;
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.g.size();
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = this.g.get(i2);
            if (iVar.b == i) {
                iVar.x = (iVar.x & -5) | (z2 ? 4 : 0);
                iVar.setCheckable(z);
            }
        }
    }

    @Override // h0.i.d.a.a, android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.x = z;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        int size = this.g.size();
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = this.g.get(i2);
            if (iVar.b == i) {
                iVar.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        int size = this.g.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = this.g.get(i2);
            if (iVar.b == i && iVar.l(z)) {
                z2 = true;
            }
        }
        if (z2) {
            q(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.d = z;
        q(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.g.size();
    }

    public final void t(int i, boolean z) {
        if (i >= 0 && i < this.g.size()) {
            this.g.remove(i);
            if (z) {
                q(true);
            }
        }
    }

    public void u(m mVar) {
        Iterator<WeakReference<m>> it = this.v.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar2 = next.get();
            if (mVar2 == null || mVar2 == mVar) {
                this.v.remove(next);
            }
        }
    }

    public void v(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(j());
            int size = size();
            for (int i = 0; i < size; i++) {
                MenuItem item = getItem(i);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((r) item.getSubMenu()).v(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0 && (findItem = findItem(i2)) != null) {
                findItem.expandActionView();
            }
        }
    }

    public void w(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((r) item.getSubMenu()).w(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(j(), sparseArray);
        }
    }

    public final void x(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources resources = this.c;
        if (view != null) {
            this.p = view;
            this.n = null;
            this.o = null;
        } else {
            if (i > 0) {
                this.n = resources.getText(i);
            } else if (charSequence != null) {
                this.n = charSequence;
            }
            if (i2 > 0) {
                this.o = h0.i.b.a.getDrawable(this.b, i2);
            } else if (drawable != null) {
                this.o = drawable;
            }
            this.p = null;
        }
        q(false);
    }

    public void y() {
        this.q = false;
        if (this.r) {
            this.r = false;
            q(this.s);
        }
    }

    public void z() {
        if (!this.q) {
            this.q = true;
            this.r = false;
            this.s = false;
        }
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return a(0, 0, 0, this.c.getString(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.c.getString(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        i iVar = (i) a(i, i2, i3, charSequence);
        r rVar = new r(this.b, this, iVar);
        iVar.o = rVar;
        rVar.setHeaderTitle(iVar.e);
        return rVar;
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(i, i2, i3, this.c.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.c.getString(i4));
    }
}
