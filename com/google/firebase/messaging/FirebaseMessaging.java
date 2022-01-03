package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.messaging.FirebaseMessaging;
import h0.b0.v;
import i0.h.a.a.f;
import i0.h.a.b.m.e;
import i0.h.c.c;
import i0.h.c.n.b;
import i0.h.c.n.d;
import i0.h.c.r.g;
import i0.h.c.t.a0;
import i0.h.c.t.f0;
import i0.h.c.t.j0;
import i0.h.c.t.n0;
import i0.h.c.t.o;
import i0.h.c.t.o0;
import i0.h.c.t.s0;
import i0.h.c.t.u;
import i0.h.c.u.h;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes2.dex */
public class FirebaseMessaging {
    public static final long a = TimeUnit.HOURS.toSeconds(8);
    @SuppressLint({"StaticFieldLeak"})
    public static n0 b;
    @SuppressLint({"FirebaseUnknownNullness"})
    public static f c;
    public static ScheduledExecutorService d;
    public final c e;
    public final FirebaseInstanceIdInternal f;
    public final g g;
    public final Context h;
    public final a0 i;
    public final j0 j;
    public final a k;
    public final Executor l;
    public final i0.h.a.b.m.g<s0> m;
    public final f0 n;
    public boolean o = false;

    /* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    /* loaded from: classes2.dex */
    public class a {
        public final d a;
        public boolean b;
        public b<i0.h.c.a> c;
        public Boolean d;

        public a(d dVar) {
            this.a = dVar;
        }

        public synchronized void a() {
            if (!this.b) {
                Boolean c = c();
                this.d = c;
                if (c == null) {
                    u uVar = new u(this);
                    this.c = uVar;
                    this.a.a(i0.h.c.a.class, uVar);
                }
                this.b = true;
            }
        }

        public synchronized boolean b() {
            boolean z;
            a();
            Boolean bool = this.d;
            if (bool != null) {
                z = bool.booleanValue();
            } else {
                c cVar = FirebaseMessaging.this.e;
                cVar.a();
                i0.h.c.s.a aVar = cVar.j.get();
                synchronized (aVar) {
                    z = aVar.d;
                }
            }
            return z;
        }

        public final Boolean c() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            c cVar = FirebaseMessaging.this.e;
            cVar.a();
            Context context = cVar.d;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
    }

    public FirebaseMessaging(c cVar, FirebaseInstanceIdInternal firebaseInstanceIdInternal, i0.h.c.q.b<h> bVar, i0.h.c.q.b<HeartBeatInfo> bVar2, g gVar, f fVar, d dVar) {
        cVar.a();
        f0 f0Var = new f0(cVar.d);
        a0 a0Var = new a0(cVar, f0Var, bVar, bVar2, gVar);
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new i0.h.a.b.c.m.f.a("Firebase-Messaging-Task"));
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new i0.h.a.b.c.m.f.a("Firebase-Messaging-Init"));
        c = fVar;
        this.e = cVar;
        this.f = firebaseInstanceIdInternal;
        this.g = gVar;
        this.k = new a(dVar);
        cVar.a();
        Context context = cVar.d;
        this.h = context;
        this.n = f0Var;
        this.i = a0Var;
        this.j = new j0(newSingleThreadExecutor);
        this.l = scheduledThreadPoolExecutor;
        if (firebaseInstanceIdInternal != null) {
            firebaseInstanceIdInternal.addNewTokenListener(new FirebaseInstanceIdInternal.a(this) { // from class: i0.h.c.t.p
                public final FirebaseMessaging a;

                {
                    this.a = r1;
                }

                @Override // com.google.firebase.iid.internal.FirebaseInstanceIdInternal.a
                public void a(String str) {
                    this.a.e(str);
                }
            });
        }
        synchronized (FirebaseMessaging.class) {
            if (b == null) {
                b = new n0(context);
            }
        }
        scheduledThreadPoolExecutor.execute(new Runnable(this) { // from class: i0.h.c.t.q
            public final FirebaseMessaging c;

            {
                this.c = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                FirebaseMessaging firebaseMessaging = this.c;
                if (firebaseMessaging.k.b()) {
                    firebaseMessaging.g();
                }
            }
        });
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor2 = new ScheduledThreadPoolExecutor(1, new i0.h.a.b.c.m.f.a("Firebase-Messaging-Topics-Io"));
        int i = s0.b;
        i0.h.a.b.m.g<s0> u = i0.h.a.b.c.m.b.u(scheduledThreadPoolExecutor2, new Callable(context, scheduledThreadPoolExecutor2, this, gVar, f0Var, a0Var) { // from class: i0.h.c.t.r0
            public final a0 Y1;
            public final Context c;
            public final ScheduledExecutorService d;
            public final FirebaseMessaging q;
            public final g x;
            public final f0 y;

            {
                this.c = r1;
                this.d = r2;
                this.q = r3;
                this.x = r4;
                this.y = r5;
                this.Y1 = r6;
            }

            @Override // java.util.concurrent.Callable
            public Object call() {
                q0 q0Var;
                Context context2 = this.c;
                ScheduledExecutorService scheduledExecutorService = this.d;
                FirebaseMessaging firebaseMessaging = this.q;
                g gVar2 = this.x;
                f0 f0Var2 = this.y;
                a0 a0Var2 = this.Y1;
                synchronized (q0.class) {
                    WeakReference<q0> weakReference = q0.a;
                    q0Var = weakReference != null ? weakReference.get() : null;
                    if (q0Var == null) {
                        SharedPreferences sharedPreferences = context2.getSharedPreferences("com.google.android.gms.appid", 0);
                        q0 q0Var2 = new q0(sharedPreferences, scheduledExecutorService);
                        synchronized (q0Var2) {
                            q0Var2.c = m0.a(sharedPreferences, "topic_operation_queue", scheduledExecutorService);
                        }
                        q0.a = new WeakReference<>(q0Var2);
                        q0Var = q0Var2;
                    }
                }
                return new s0(firebaseMessaging, gVar2, f0Var2, q0Var, a0Var2, context2, scheduledExecutorService);
            }
        });
        this.m = u;
        u.e(new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new i0.h.a.b.c.m.f.a("Firebase-Messaging-Trigger-Topics-Io")), new e(this) { // from class: i0.h.c.t.r
            public final FirebaseMessaging a;

            {
                this.a = r1;
            }

            @Override // i0.h.a.b.m.e
            public void onSuccess(Object obj) {
                boolean z;
                s0 s0Var = (s0) obj;
                if (this.a.k.b()) {
                    if (s0Var.k.a() != null) {
                        synchronized (s0Var) {
                            z = s0Var.j;
                        }
                        if (!z) {
                            s0Var.g(0);
                        }
                    }
                }
            }
        });
    }

    @Keep
    public static synchronized FirebaseMessaging getInstance(c cVar) {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            cVar.a();
            firebaseMessaging = (FirebaseMessaging) cVar.g.a(FirebaseMessaging.class);
            v.A(firebaseMessaging, "Firebase Messaging component is not present");
        }
        return firebaseMessaging;
    }

    public String a() throws IOException {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.f;
        if (firebaseInstanceIdInternal != null) {
            try {
                return (String) i0.h.a.b.c.m.b.j(firebaseInstanceIdInternal.getTokenTask());
            } catch (InterruptedException | ExecutionException e) {
                throw new IOException(e);
            }
        } else {
            n0.a d2 = d();
            if (!i(d2)) {
                return d2.b;
            }
            String b2 = f0.b(this.e);
            try {
                String str = (String) i0.h.a.b.c.m.b.j(this.g.getId().h(Executors.newSingleThreadExecutor(new i0.h.a.b.c.m.f.a("Firebase-Messaging-Network-Io")), new i0.h.a.b.m.a(this, b2) { // from class: i0.h.c.t.t
                    public final FirebaseMessaging a;
                    public final String b;

                    {
                        this.a = r1;
                        this.b = r2;
                    }

                    @Override // i0.h.a.b.m.a
                    public Object a(i0.h.a.b.m.g gVar) {
                        i0.h.a.b.m.g<String> gVar2;
                        String str2;
                        FirebaseMessaging firebaseMessaging = this.a;
                        String str3 = this.b;
                        j0 j0Var = firebaseMessaging.j;
                        synchronized (j0Var) {
                            gVar2 = j0Var.b.get(str3);
                            if (gVar2 == null) {
                                if (Log.isLoggable("FirebaseMessaging", 3)) {
                                    String valueOf = String.valueOf(str3);
                                    if (valueOf.length() != 0) {
                                        str2 = "Making new request for: ".concat(valueOf);
                                    } else {
                                        str2 = new String("Making new request for: ");
                                    }
                                    Log.d("FirebaseMessaging", str2);
                                }
                                a0 a0Var = firebaseMessaging.i;
                                gVar2 = a0Var.a(a0Var.b((String) gVar.j(), f0.b(a0Var.a), "*", new Bundle())).h(j0Var.a, 
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x007e: INVOKE  (r3v9 'gVar2' i0.h.a.b.m.g<java.lang.String>) = 
                                      (wrap: i0.h.a.b.m.g<java.lang.String> : 0x0073: INVOKE  (r7v5 i0.h.a.b.m.g<java.lang.String> A[REMOVE]) = 
                                      (r0v1 'a0Var' i0.h.c.t.a0)
                                      (wrap: i0.h.a.b.m.g<android.os.Bundle> : 0x006f: INVOKE  (r7v4 i0.h.a.b.m.g<android.os.Bundle> A[REMOVE]) = 
                                      (r0v1 'a0Var' i0.h.c.t.a0)
                                      (wrap: java.lang.String : 0x0060: CHECK_CAST (r7v3 java.lang.String A[REMOVE]) = (java.lang.String) (wrap: java.lang.Object : 0x005c: INVOKE  (r7v2 java.lang.Object A[REMOVE]) = (r7v0 'gVar' i0.h.a.b.m.g) type: VIRTUAL call: i0.h.a.b.m.g.j():java.lang.Object))
                                      (wrap: java.lang.String : 0x0064: INVOKE  (r3v7 java.lang.String A[REMOVE]) = (wrap: i0.h.c.c : 0x0062: IGET  (r3v6 i0.h.c.c A[REMOVE]) = (r0v1 'a0Var' i0.h.c.t.a0) i0.h.c.t.a0.a i0.h.c.c) type: STATIC call: i0.h.c.t.f0.b(i0.h.c.c):java.lang.String)
                                      ("*")
                                      (wrap: android.os.Bundle : 0x006a: CONSTRUCTOR  (r4v1 android.os.Bundle A[REMOVE]) =  call: android.os.Bundle.<init>():void type: CONSTRUCTOR)
                                     type: VIRTUAL call: i0.h.c.t.a0.b(java.lang.String, java.lang.String, java.lang.String, android.os.Bundle):i0.h.a.b.m.g)
                                     type: VIRTUAL call: i0.h.c.t.a0.a(i0.h.a.b.m.g):i0.h.a.b.m.g)
                                      (wrap: java.util.concurrent.Executor : 0x0077: IGET  (r0v2 java.util.concurrent.Executor A[REMOVE]) = (r2v0 'j0Var' i0.h.c.t.j0) i0.h.c.t.j0.a java.util.concurrent.Executor)
                                      (wrap: i0.h.c.t.i0 : 0x007b: CONSTRUCTOR  (r3v8 i0.h.c.t.i0 A[REMOVE]) = (r2v0 'j0Var' i0.h.c.t.j0), (r1v0 'str3' java.lang.String) call: i0.h.c.t.i0.<init>(i0.h.c.t.j0, java.lang.String):void type: CONSTRUCTOR)
                                     type: VIRTUAL call: i0.h.a.b.m.g.h(java.util.concurrent.Executor, i0.h.a.b.m.a):i0.h.a.b.m.g in method: i0.h.c.t.t.a(i0.h.a.b.m.g):java.lang.Object, file: classes2.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:122)
                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                                    	at jadx.core.codegen.RegionGen.makeSynchronizedRegion(RegionGen.java:239)
                                    	at jadx.core.dex.regions.SynchronizedRegion.generate(SynchronizedRegion.java:44)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:270)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: i0.h.c.t.i0, state: NOT_LOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:974)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:799)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                                    	... 29 more
                                    */
                                /*
                                    this = this;
                                    com.google.firebase.messaging.FirebaseMessaging r0 = r6.a
                                    java.lang.String r1 = r6.b
                                    i0.h.c.t.j0 r2 = r0.j
                                    monitor-enter(r2)
                                    java.util.Map<java.lang.String, i0.h.a.b.m.g<java.lang.String>> r3 = r2.b     // Catch: all -> 0x0089
                                    java.lang.Object r3 = r3.get(r1)     // Catch: all -> 0x0089
                                    i0.h.a.b.m.g r3 = (i0.h.a.b.m.g) r3     // Catch: all -> 0x0089
                                    r4 = 3
                                    if (r3 == 0) goto L_0x0037
                                    java.lang.String r7 = "FirebaseMessaging"
                                    boolean r7 = android.util.Log.isLoggable(r7, r4)     // Catch: all -> 0x0089
                                    if (r7 == 0) goto L_0x0035
                                    java.lang.String r7 = java.lang.String.valueOf(r1)     // Catch: all -> 0x0089
                                    java.lang.String r0 = "Joining ongoing request for: "
                                    int r1 = r7.length()     // Catch: all -> 0x0089
                                    if (r1 == 0) goto L_0x002b
                                    java.lang.String r7 = r0.concat(r7)     // Catch: all -> 0x0089
                                    goto L_0x0030
                                L_0x002b:
                                    java.lang.String r7 = new java.lang.String     // Catch: all -> 0x0089
                                    r7.<init>(r0)     // Catch: all -> 0x0089
                                L_0x0030:
                                    java.lang.String r0 = "FirebaseMessaging"
                                    android.util.Log.d(r0, r7)     // Catch: all -> 0x0089
                                L_0x0035:
                                    monitor-exit(r2)
                                    goto L_0x0088
                                L_0x0037:
                                    java.lang.String r3 = "FirebaseMessaging"
                                    boolean r3 = android.util.Log.isLoggable(r3, r4)     // Catch: all -> 0x0089
                                    if (r3 == 0) goto L_0x005a
                                    java.lang.String r3 = java.lang.String.valueOf(r1)     // Catch: all -> 0x0089
                                    java.lang.String r4 = "Making new request for: "
                                    int r5 = r3.length()     // Catch: all -> 0x0089
                                    if (r5 == 0) goto L_0x0050
                                    java.lang.String r3 = r4.concat(r3)     // Catch: all -> 0x0089
                                    goto L_0x0055
                                L_0x0050:
                                    java.lang.String r3 = new java.lang.String     // Catch: all -> 0x0089
                                    r3.<init>(r4)     // Catch: all -> 0x0089
                                L_0x0055:
                                    java.lang.String r4 = "FirebaseMessaging"
                                    android.util.Log.d(r4, r3)     // Catch: all -> 0x0089
                                L_0x005a:
                                    i0.h.c.t.a0 r0 = r0.i     // Catch: all -> 0x0089
                                    java.lang.Object r7 = r7.j()     // Catch: all -> 0x0089
                                    java.lang.String r7 = (java.lang.String) r7     // Catch: all -> 0x0089
                                    i0.h.c.c r3 = r0.a     // Catch: all -> 0x0089
                                    java.lang.String r3 = i0.h.c.t.f0.b(r3)     // Catch: all -> 0x0089
                                    android.os.Bundle r4 = new android.os.Bundle     // Catch: all -> 0x0089
                                    r4.<init>()     // Catch: all -> 0x0089
                                    java.lang.String r5 = "*"
                                    i0.h.a.b.m.g r7 = r0.b(r7, r3, r5, r4)     // Catch: all -> 0x0089
                                    i0.h.a.b.m.g r7 = r0.a(r7)     // Catch: all -> 0x0089
                                    java.util.concurrent.Executor r0 = r2.a     // Catch: all -> 0x0089
                                    i0.h.c.t.i0 r3 = new i0.h.c.t.i0     // Catch: all -> 0x0089
                                    r3.<init>(r2, r1)     // Catch: all -> 0x0089
                                    i0.h.a.b.m.g r3 = r7.h(r0, r3)     // Catch: all -> 0x0089
                                    java.util.Map<java.lang.String, i0.h.a.b.m.g<java.lang.String>> r7 = r2.b     // Catch: all -> 0x0089
                                    r7.put(r1, r3)     // Catch: all -> 0x0089
                                    monitor-exit(r2)
                                L_0x0088:
                                    return r3
                                L_0x0089:
                                    r7 = move-exception
                                    monitor-exit(r2)
                                    throw r7
                                */
                                throw new UnsupportedOperationException("Method not decompiled: i0.h.c.t.t.a(i0.h.a.b.m.g):java.lang.Object");
                            }
                        }));
                        b.b(c(), b2, str, this.n.a());
                        if (d2 == null || !str.equals(d2.b)) {
                            e(str);
                        }
                        return str;
                    } catch (InterruptedException | ExecutionException e2) {
                        throw new IOException(e2);
                    }
                }
            }

            public void b(Runnable runnable, long j) {
                synchronized (FirebaseMessaging.class) {
                    if (d == null) {
                        d = new ScheduledThreadPoolExecutor(1, new i0.h.a.b.c.m.f.a("TAG"));
                    }
                    d.schedule(runnable, j, TimeUnit.SECONDS);
                }
            }

            public final String c() {
                c cVar = this.e;
                cVar.a();
                if ("[DEFAULT]".equals(cVar.e)) {
                    return "";
                }
                return this.e.c();
            }

            public n0.a d() {
                n0.a b2;
                n0 n0Var = b;
                String c2 = c();
                String b3 = f0.b(this.e);
                synchronized (n0Var) {
                    b2 = n0.a.b(n0Var.a.getString(n0Var.a(c2, b3), null));
                }
                return b2;
            }

            public final void e(String str) {
                String str2;
                c cVar = this.e;
                cVar.a();
                if ("[DEFAULT]".equals(cVar.e)) {
                    if (Log.isLoggable("FirebaseMessaging", 3)) {
                        c cVar2 = this.e;
                        cVar2.a();
                        String valueOf = String.valueOf(cVar2.e);
                        if (valueOf.length() != 0) {
                            str2 = "Invoking onNewToken for app: ".concat(valueOf);
                        } else {
                            str2 = new String("Invoking onNewToken for app: ");
                        }
                        Log.d("FirebaseMessaging", str2);
                    }
                    Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
                    intent.putExtra("token", str);
                    new o(this.h).b(intent);
                }
            }

            public synchronized void f(boolean z) {
                this.o = z;
            }

            public final void g() {
                FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.f;
                if (firebaseInstanceIdInternal != null) {
                    firebaseInstanceIdInternal.getToken();
                } else if (i(d())) {
                    synchronized (this) {
                        if (!this.o) {
                            h(0);
                        }
                    }
                }
            }

            public synchronized void h(long j) {
                b(new o0(this, Math.min(Math.max(30L, j + j), a)), j);
                this.o = true;
            }

            public boolean i(n0.a aVar) {
                if (aVar != null) {
                    if (!(System.currentTimeMillis() > aVar.d + n0.a.a || !this.n.a().equals(aVar.c))) {
                        return false;
                    }
                }
                return true;
            }
        }
