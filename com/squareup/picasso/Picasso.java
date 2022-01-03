package com.squareup.picasso;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import i0.o.a.a;
import i0.o.a.b0;
import i0.o.a.f;
import i0.o.a.g;
import i0.o.a.h;
import i0.o.a.i;
import i0.o.a.k;
import i0.o.a.u;
import i0.o.a.v;
import i0.o.a.w;
import i0.o.a.x;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
/* loaded from: classes3.dex */
public class Picasso {
    public static final Handler a = new a(Looper.getMainLooper());
    @SuppressLint({"StaticFieldLeak"})
    public static volatile Picasso b = null;
    public final d d;
    public final b e;
    public final List<v> f;
    public final Context g;
    public final i h;
    public final i0.o.a.d i;
    public final x j;
    public final ReferenceQueue<Object> m;
    public boolean o;
    public volatile boolean p;
    public final c c = null;
    public final Bitmap.Config n = null;
    public final Map<Object, i0.o.a.a> k = new WeakHashMap();
    public final Map<ImageView, h> l = new WeakHashMap();

    /* loaded from: classes3.dex */
    public enum LoadedFrom {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(-65536);
        
        public final int debugColor;

        LoadedFrom(int i) {
            this.debugColor = i;
        }
    }

    /* loaded from: classes3.dex */
    public enum Priority {
        LOW,
        NORMAL,
        HIGH
    }

    /* loaded from: classes3.dex */
    public static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 3) {
                if (i == 8) {
                    List list = (List) message.obj;
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        i0.o.a.c cVar = (i0.o.a.c) list.get(i2);
                        Picasso picasso = cVar.Y1;
                        Objects.requireNonNull(picasso);
                        i0.o.a.a aVar = cVar.h2;
                        List<i0.o.a.a> list2 = cVar.i2;
                        boolean z = true;
                        boolean z2 = list2 != null && !list2.isEmpty();
                        if (aVar == null && !z2) {
                            z = false;
                        }
                        if (z) {
                            Uri uri = cVar.d2.d;
                            Exception exc = cVar.m2;
                            Bitmap bitmap = cVar.j2;
                            LoadedFrom loadedFrom = cVar.l2;
                            if (aVar != null) {
                                picasso.c(bitmap, loadedFrom, aVar, exc);
                            }
                            if (z2) {
                                int size2 = list2.size();
                                for (int i3 = 0; i3 < size2; i3++) {
                                    picasso.c(bitmap, loadedFrom, list2.get(i3), exc);
                                }
                            }
                            c cVar2 = picasso.c;
                            if (!(cVar2 == null || exc == null)) {
                                cVar2.a(picasso, uri, exc);
                            }
                        }
                    }
                } else if (i == 13) {
                    List list3 = (List) message.obj;
                    int size3 = list3.size();
                    for (int i4 = 0; i4 < size3; i4++) {
                        i0.o.a.a aVar2 = (i0.o.a.a) list3.get(i4);
                        Picasso picasso2 = aVar2.a;
                        Objects.requireNonNull(picasso2);
                        Bitmap f = MemoryPolicy.shouldReadFromMemoryCache(aVar2.e) ? picasso2.f(aVar2.i) : null;
                        if (f != null) {
                            LoadedFrom loadedFrom2 = LoadedFrom.MEMORY;
                            picasso2.c(f, loadedFrom2, aVar2, null);
                            if (picasso2.p) {
                                b0.f("Main", "completed", aVar2.b.b(), "from " + loadedFrom2);
                            }
                        } else {
                            picasso2.d(aVar2);
                            if (picasso2.p) {
                                b0.f("Main", "resumed", aVar2.b.b(), "");
                            }
                        }
                    }
                } else {
                    StringBuilder P0 = i0.d.a.a.a.P0("Unknown handler message received: ");
                    P0.append(message.what);
                    throw new AssertionError(P0.toString());
                }
            } else {
                i0.o.a.a aVar3 = (i0.o.a.a) message.obj;
                if (aVar3.a.p) {
                    b0.f("Main", "canceled", aVar3.b.b(), "target got garbage collected");
                }
                aVar3.a.a(aVar3.d());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends Thread {
        public final ReferenceQueue<Object> c;
        public final Handler d;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public final /* synthetic */ Exception c;

            public a(b bVar, Exception exc) {
                this.c = exc;
            }

            @Override // java.lang.Runnable
            public void run() {
                throw new RuntimeException(this.c);
            }
        }

        public b(ReferenceQueue<Object> referenceQueue, Handler handler) {
            this.c = referenceQueue;
            this.d = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    a.C0218a aVar = (a.C0218a) this.c.remove(1000);
                    Message obtainMessage = this.d.obtainMessage();
                    if (aVar != null) {
                        obtainMessage.what = 3;
                        obtainMessage.obj = aVar.a;
                        this.d.sendMessage(obtainMessage);
                    } else {
                        obtainMessage.recycle();
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e) {
                    this.d.post(new a(this, e));
                    return;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(Picasso picasso, Uri uri, Exception exc);
    }

    /* loaded from: classes3.dex */
    public interface d {
        public static final d a = new a();

        /* loaded from: classes3.dex */
        public static class a implements d {
        }
    }

    public Picasso(Context context, i iVar, i0.o.a.d dVar, c cVar, d dVar2, List<v> list, x xVar, Bitmap.Config config, boolean z, boolean z2) {
        this.g = context;
        this.h = iVar;
        this.i = dVar;
        this.d = dVar2;
        ArrayList arrayList = new ArrayList(7);
        arrayList.add(new w(context));
        arrayList.add(new f(context));
        arrayList.add(new MediaStoreRequestHandler(context));
        arrayList.add(new g(context));
        arrayList.add(new i0.o.a.b(context));
        arrayList.add(new k(context));
        arrayList.add(new NetworkRequestHandler(iVar.d, xVar));
        this.f = Collections.unmodifiableList(arrayList);
        this.j = xVar;
        this.o = z;
        this.p = z2;
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        this.m = referenceQueue;
        b bVar = new b(referenceQueue, a);
        this.e = bVar;
        bVar.start();
    }

    public void a(Object obj) {
        h remove;
        if (b0.e()) {
            i0.o.a.a remove2 = this.k.remove(obj);
            if (remove2 != null) {
                remove2.a();
                Handler handler = this.h.i;
                handler.sendMessage(handler.obtainMessage(2, remove2));
            }
            if ((obj instanceof ImageView) && (remove = this.l.remove((ImageView) obj)) != null) {
                Objects.requireNonNull(remove.c);
                remove.q = null;
                ImageView imageView = remove.d.get();
                if (imageView != null) {
                    remove.d.clear();
                    imageView.removeOnAttachStateChangeListener(remove);
                    ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.removeOnPreDrawListener(remove);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("Method call should happen from the main thread.");
    }

    public void b(ImageView imageView) {
        a(imageView);
    }

    public final void c(Bitmap bitmap, LoadedFrom loadedFrom, i0.o.a.a aVar, Exception exc) {
        if (!aVar.l) {
            if (!aVar.k) {
                this.k.remove(aVar.d());
            }
            if (bitmap == null) {
                aVar.c(exc);
                if (this.p) {
                    b0.f("Main", "errored", aVar.b.b(), exc.getMessage());
                }
            } else if (loadedFrom != null) {
                aVar.b(bitmap, loadedFrom);
                if (this.p) {
                    String b2 = aVar.b.b();
                    b0.f("Main", "completed", b2, "from " + loadedFrom);
                }
            } else {
                throw new AssertionError("LoadedFrom cannot be null.");
            }
        }
    }

    public void d(i0.o.a.a aVar) {
        Object d2 = aVar.d();
        if (!(d2 == null || this.k.get(d2) == aVar)) {
            a(d2);
            this.k.put(d2, aVar);
        }
        Handler handler = this.h.i;
        handler.sendMessage(handler.obtainMessage(1, aVar));
    }

    public u e(String str) {
        if (str == null) {
            return new u(this, null, 0);
        }
        if (str.trim().length() != 0) {
            return new u(this, Uri.parse(str), 0);
        }
        throw new IllegalArgumentException("Path must not be empty.");
    }

    public Bitmap f(String str) {
        Bitmap bitmap = this.i.get(str);
        if (bitmap != null) {
            this.j.c.sendEmptyMessage(0);
        } else {
            this.j.c.sendEmptyMessage(1);
        }
        return bitmap;
    }
}
