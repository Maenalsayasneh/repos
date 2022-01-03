package h0.i.j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.Editable;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.instabug.library.model.NetworkLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
/* compiled from: TextViewCompat.java */
/* loaded from: classes.dex */
public class d implements ActionMode.Callback {
    public final ActionMode.Callback a;
    public final TextView b;
    public Class<?> c;
    public Method d;
    public boolean e;
    public boolean f = false;

    public d(ActionMode.Callback callback, TextView textView) {
        this.a = callback;
        this.b = textView;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.a.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return this.a.onCreateActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        this.a.onDestroyActionMode(actionMode);
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00d1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x009f A[SYNTHETIC] */
    @Override // android.view.ActionMode.Callback
    /* Code decompiled incorrectly, please refer to instructions dump */
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        Method method;
        boolean z;
        String str;
        Context context = this.b.getContext();
        PackageManager packageManager = context.getPackageManager();
        if (!this.f) {
            this.f = true;
            try {
                Class<?> cls = Class.forName("com.android.internal.view.menu.MenuBuilder");
                this.c = cls;
                this.d = cls.getDeclaredMethod("removeItemAt", Integer.TYPE);
                this.e = true;
            } catch (ClassNotFoundException | NoSuchMethodException unused) {
                this.c = null;
                this.d = null;
                this.e = false;
            }
        }
        try {
            if (!this.e || !this.c.isInstance(menu)) {
                method = menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
            } else {
                method = this.d;
            }
            for (int size = menu.size() - 1; size >= 0; size--) {
                MenuItem item = menu.getItem(size);
                if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                    method.invoke(menu, Integer.valueOf(size));
                }
            }
            ArrayList arrayList = new ArrayList();
            if (context instanceof Activity) {
                for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(new Intent().setAction("android.intent.action.PROCESS_TEXT").setType(NetworkLog.PLAIN_TEXT), 0)) {
                    if (!context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                        ActivityInfo activityInfo = resolveInfo.activityInfo;
                        if (!activityInfo.exported || !((str = activityInfo.permission) == null || context.checkSelfPermission(str) == 0)) {
                            z = false;
                            if (!z) {
                                arrayList.add(resolveInfo);
                            }
                        }
                    }
                    z = true;
                    if (!z) {
                    }
                }
            }
            for (int i = 0; i < arrayList.size(); i++) {
                ResolveInfo resolveInfo2 = (ResolveInfo) arrayList.get(i);
                MenuItem add = menu.add(0, 0, i + 100, resolveInfo2.loadLabel(packageManager));
                TextView textView = this.b;
                Intent putExtra = new Intent().setAction("android.intent.action.PROCESS_TEXT").setType(NetworkLog.PLAIN_TEXT).putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !((textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled()));
                ActivityInfo activityInfo2 = resolveInfo2.activityInfo;
                add.setIntent(putExtra.setClassName(activityInfo2.packageName, activityInfo2.name)).setShowAsAction(1);
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
        }
        return this.a.onPrepareActionMode(actionMode, menu);
    }
}
