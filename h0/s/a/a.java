package h0.s.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
/* compiled from: LocalBroadcastManager.java */
/* loaded from: classes.dex */
public final class a {
    public static final Object a = new Object();
    public static a b;
    public final Context c;
    public final HashMap<BroadcastReceiver, ArrayList<c>> d = new HashMap<>();
    public final HashMap<String, ArrayList<c>> e = new HashMap<>();
    public final ArrayList<b> f = new ArrayList<>();
    public final Handler g;

    /* compiled from: LocalBroadcastManager.java */
    /* renamed from: h0.s.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class HandlerC0093a extends Handler {
        public HandlerC0093a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int size;
            b[] bVarArr;
            if (message.what != 1) {
                super.handleMessage(message);
                return;
            }
            a aVar = a.this;
            while (true) {
                synchronized (aVar.d) {
                    size = aVar.f.size();
                    if (size > 0) {
                        bVarArr = new b[size];
                        aVar.f.toArray(bVarArr);
                        aVar.f.clear();
                    } else {
                        return;
                    }
                }
                for (int i = 0; i < size; i++) {
                    b bVar = bVarArr[i];
                    int size2 = bVar.b.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        c cVar = bVar.b.get(i2);
                        if (!cVar.d) {
                            cVar.b.onReceive(aVar.c, bVar.a);
                        }
                    }
                }
            }
        }
    }

    /* compiled from: LocalBroadcastManager.java */
    /* loaded from: classes.dex */
    public static final class b {
        public final Intent a;
        public final ArrayList<c> b;

        public b(Intent intent, ArrayList<c> arrayList) {
            this.a = intent;
            this.b = arrayList;
        }
    }

    /* compiled from: LocalBroadcastManager.java */
    /* loaded from: classes.dex */
    public static final class c {
        public final IntentFilter a;
        public final BroadcastReceiver b;
        public boolean c;
        public boolean d;

        public c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.a = intentFilter;
            this.b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.b);
            sb.append(" filter=");
            sb.append(this.a);
            if (this.d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    public a(Context context) {
        this.c = context;
        this.g = new HandlerC0093a(context.getMainLooper());
    }

    public static a a(Context context) {
        a aVar;
        synchronized (a) {
            if (b == null) {
                b = new a(context.getApplicationContext());
            }
            aVar = b;
        }
        return aVar;
    }

    public void b(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.d) {
            c cVar = new c(intentFilter, broadcastReceiver);
            ArrayList<c> arrayList = this.d.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.d.put(broadcastReceiver, arrayList);
            }
            arrayList.add(cVar);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<c> arrayList2 = this.e.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.e.put(action, arrayList2);
                }
                arrayList2.add(cVar);
            }
        }
    }

    public boolean c(Intent intent) {
        String str;
        ArrayList<c> arrayList;
        String str2;
        int i;
        ArrayList arrayList2;
        synchronized (this.d) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.c.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<c> arrayList3 = this.e.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    Log.v("LocalBroadcastManager", "Action list: " + arrayList3);
                }
                ArrayList arrayList4 = null;
                int i2 = 0;
                while (i2 < arrayList3.size()) {
                    c cVar = arrayList3.get(i2);
                    if (z) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + cVar.a);
                    }
                    if (cVar.c) {
                        if (z) {
                            Log.v("LocalBroadcastManager", "  Filter's target already added");
                        }
                        i = i2;
                        arrayList = arrayList3;
                        str2 = action;
                        str = resolveTypeIfNeeded;
                        arrayList2 = arrayList4;
                    } else {
                        i = i2;
                        str2 = action;
                        arrayList2 = arrayList4;
                        arrayList = arrayList3;
                        str = resolveTypeIfNeeded;
                        int match = cVar.a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            arrayList4 = arrayList2 == null ? new ArrayList() : arrayList2;
                            arrayList4.add(cVar);
                            cVar.c = true;
                            i2 = i + 1;
                            action = str2;
                            arrayList3 = arrayList;
                            resolveTypeIfNeeded = str;
                        } else if (z) {
                            String str3 = match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : MessageExtension.FIELD_DATA : "action" : "category";
                            Log.v("LocalBroadcastManager", "  Filter did not match: " + str3);
                        }
                    }
                    arrayList4 = arrayList2;
                    i2 = i + 1;
                    action = str2;
                    arrayList3 = arrayList;
                    resolveTypeIfNeeded = str;
                }
                if (arrayList4 != null) {
                    for (int i3 = 0; i3 < arrayList4.size(); i3++) {
                        ((c) arrayList4.get(i3)).c = false;
                    }
                    this.f.add(new b(intent, arrayList4));
                    if (!this.g.hasMessages(1)) {
                        this.g.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void d(BroadcastReceiver broadcastReceiver) {
        synchronized (this.d) {
            ArrayList<c> remove = this.d.remove(broadcastReceiver);
            if (remove != null) {
                for (int size = remove.size() - 1; size >= 0; size--) {
                    c cVar = remove.get(size);
                    cVar.d = true;
                    for (int i = 0; i < cVar.a.countActions(); i++) {
                        String action = cVar.a.getAction(i);
                        ArrayList<c> arrayList = this.e.get(action);
                        if (arrayList != null) {
                            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                c cVar2 = arrayList.get(size2);
                                if (cVar2.b == broadcastReceiver) {
                                    cVar2.d = true;
                                    arrayList.remove(size2);
                                }
                            }
                            if (arrayList.size() <= 0) {
                                this.e.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }
}
