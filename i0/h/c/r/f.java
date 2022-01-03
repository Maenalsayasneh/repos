package i0.h.c.r;

import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.TokenResult;
import com.instabug.library.networkv2.request.Header;
import com.instabug.library.networkv2.request.RequestMethod;
import h0.b0.v;
import i0.h.a.b.m.g;
import i0.h.c.c;
import i0.h.c.r.p.a;
import i0.h.c.r.p.b;
import i0.h.c.r.p.c;
import i0.h.c.r.q.b;
import i0.h.c.u.h;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: FirebaseInstallations.java */
/* loaded from: classes2.dex */
public class f implements g {
    public static final Object a = new Object();
    public static final ThreadFactory b = new a();
    public final c c;
    public final i0.h.c.r.q.c d;
    public final PersistedInstallation e;
    public final n f;
    public final b g;
    public final l h;
    public final ExecutorService j;
    public final ExecutorService k;
    public String l;
    public final Object i = new Object();
    public Set<i0.h.c.r.o.a> m = new HashSet();
    public final List<m> n = new ArrayList();

    /* compiled from: FirebaseInstallations.java */
    /* loaded from: classes2.dex */
    public class a implements ThreadFactory {
        public final AtomicInteger c = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", Integer.valueOf(this.c.getAndIncrement())));
        }
    }

    public f(c cVar, i0.h.c.q.b<h> bVar, i0.h.c.q.b<HeartBeatInfo> bVar2) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        ThreadFactory threadFactory = b;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 30, timeUnit, linkedBlockingQueue, threadFactory);
        cVar.a();
        i0.h.c.r.q.c cVar2 = new i0.h.c.r.q.c(cVar.d, bVar, bVar2);
        PersistedInstallation persistedInstallation = new PersistedInstallation(cVar);
        n c = n.c();
        b bVar3 = new b(cVar);
        l lVar = new l();
        this.c = cVar;
        this.d = cVar2;
        this.e = persistedInstallation;
        this.f = c;
        this.g = bVar3;
        this.h = lVar;
        this.j = threadPoolExecutor;
        this.k = new ThreadPoolExecutor(0, 1, 30, timeUnit, new LinkedBlockingQueue(), threadFactory);
    }

    public static f f(c cVar) {
        v.u(true, "Null is not a valid value of FirebaseApp.");
        cVar.a();
        return (f) cVar.g.a(g.class);
    }

    @Override // i0.h.c.r.g
    public g<k> a(boolean z) {
        h();
        i0.h.a.b.m.h hVar = new i0.h.a.b.m.h();
        i iVar = new i(this.f, hVar);
        synchronized (this.i) {
            this.n.add(iVar);
        }
        g gVar = hVar.a;
        this.j.execute(new Runnable(this, z) { // from class: i0.h.c.r.d
            public final f c;
            public final boolean d;

            {
                this.c = r1;
                this.d = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = this.c;
                boolean z2 = this.d;
                Object obj = f.a;
                fVar.b(z2);
            }
        });
        return gVar;
    }

    public final void b(boolean z) {
        i0.h.c.r.p.c b2;
        synchronized (a) {
            c cVar = this.c;
            cVar.a();
            b a2 = b.a(cVar.d, "generatefid.lock");
            b2 = this.e.b();
            if (b2.i()) {
                String i = i(b2);
                PersistedInstallation persistedInstallation = this.e;
                a.b bVar = (a.b) b2.k();
                bVar.a = i;
                bVar.b(PersistedInstallation.RegistrationStatus.UNREGISTERED);
                b2 = bVar.a();
                persistedInstallation.a(b2);
            }
            if (a2 != null) {
                a2.b();
            }
        }
        if (z) {
            a.b bVar2 = (a.b) b2.k();
            bVar2.c = null;
            b2 = bVar2.a();
        }
        l(b2);
        this.k.execute(new Runnable(this, z) { // from class: i0.h.c.r.e
            public final f c;
            public final boolean d;

            {
                this.c = r1;
                this.d = r2;
            }

            /* JADX WARN: Removed duplicated region for block: B:70:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /* Code decompiled incorrectly, please refer to instructions dump */
            public void run() {
                i0.h.c.r.p.c b3;
                i0.h.c.r.p.c cVar2;
                f fVar = this.c;
                boolean z2 = this.d;
                Object obj = f.a;
                Objects.requireNonNull(fVar);
                Object obj2 = f.a;
                synchronized (obj2) {
                    c cVar3 = fVar.c;
                    cVar3.a();
                    b a3 = b.a(cVar3.d, "generatefid.lock");
                    b3 = fVar.e.b();
                    if (a3 != null) {
                        a3.b();
                    }
                }
                try {
                    if (!b3.h()) {
                        if (!(b3.f() == PersistedInstallation.RegistrationStatus.UNREGISTERED)) {
                            if (z2 || fVar.f.d(b3)) {
                                cVar2 = fVar.c(b3);
                                synchronized (obj2) {
                                    c cVar4 = fVar.c;
                                    cVar4.a();
                                    b a4 = b.a(cVar4.d, "generatefid.lock");
                                    fVar.e.a(cVar2);
                                    if (a4 != null) {
                                        a4.b();
                                    }
                                }
                                synchronized (fVar) {
                                    if (fVar.m.size() != 0 && !b3.c().equals(cVar2.c())) {
                                        for (i0.h.c.r.o.a aVar : fVar.m) {
                                            aVar.a(cVar2.c());
                                        }
                                    }
                                }
                                if (cVar2.j()) {
                                    String str = ((a) cVar2).b;
                                    synchronized (fVar) {
                                        fVar.l = str;
                                    }
                                }
                                if (cVar2.h()) {
                                    fVar.k(new FirebaseInstallationsException(FirebaseInstallationsException.Status.BAD_CONFIG));
                                    return;
                                } else if (cVar2.i()) {
                                    fVar.k(new IOException("Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."));
                                    return;
                                } else {
                                    fVar.l(cVar2);
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                    }
                    cVar2 = fVar.j(b3);
                    synchronized (obj2) {
                    }
                } catch (FirebaseInstallationsException e) {
                    fVar.k(e);
                }
            }
        });
    }

    public final i0.h.c.r.p.c c(i0.h.c.r.p.c cVar) throws FirebaseInstallationsException {
        int responseCode;
        TokenResult f;
        i0.h.c.r.q.c cVar2 = this.d;
        String d = d();
        i0.h.c.r.p.a aVar = (i0.h.c.r.p.a) cVar;
        String str = aVar.b;
        String g = g();
        String str2 = aVar.e;
        if (cVar2.f.a()) {
            URL a2 = cVar2.a(String.format("projects/%s/installations/%s/authTokens:generate", g, str));
            for (int i = 0; i <= 1; i++) {
                HttpURLConnection c = cVar2.c(a2, d);
                try {
                    c.setRequestMethod(RequestMethod.POST);
                    c.addRequestProperty(Header.AUTHORIZATION, "FIS_v2 " + str2);
                    c.setDoOutput(true);
                    cVar2.h(c);
                    responseCode = c.getResponseCode();
                    cVar2.f.b(responseCode);
                } catch (IOException | AssertionError unused) {
                } catch (Throwable th) {
                    c.disconnect();
                    throw th;
                }
                if (responseCode >= 200 && responseCode < 300) {
                    f = cVar2.f(c);
                } else {
                    i0.h.c.r.q.c.b(c, null, d, g);
                    if (!(responseCode == 401 || responseCode == 404)) {
                        if (responseCode == 429) {
                            throw new FirebaseInstallationsException("Firebase servers have received too many requests from this client in a short period of time. Please try again later.", FirebaseInstallationsException.Status.TOO_MANY_REQUESTS);
                        } else if (responseCode < 500 || responseCode >= 600) {
                            Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                            b.C0164b bVar = (b.C0164b) TokenResult.a();
                            bVar.c = TokenResult.ResponseCode.BAD_CONFIG;
                            f = bVar.a();
                        } else {
                            c.disconnect();
                        }
                    }
                    b.C0164b bVar2 = (b.C0164b) TokenResult.a();
                    bVar2.c = TokenResult.ResponseCode.AUTH_ERROR;
                    f = bVar2.a();
                }
                c.disconnect();
                i0.h.c.r.q.b bVar3 = (i0.h.c.r.q.b) f;
                int ordinal = bVar3.c.ordinal();
                if (ordinal == 0) {
                    String str3 = bVar3.a;
                    long j = bVar3.b;
                    long b2 = this.f.b();
                    a.b bVar4 = (a.b) cVar.k();
                    bVar4.c = str3;
                    bVar4.e = Long.valueOf(j);
                    bVar4.f = Long.valueOf(b2);
                    return bVar4.a();
                } else if (ordinal == 1) {
                    a.b bVar5 = (a.b) cVar.k();
                    bVar5.g = "BAD CONFIG";
                    bVar5.b(PersistedInstallation.RegistrationStatus.REGISTER_ERROR);
                    return bVar5.a();
                } else if (ordinal == 2) {
                    synchronized (this) {
                        this.l = null;
                    }
                    c.a k = cVar.k();
                    k.b(PersistedInstallation.RegistrationStatus.NOT_GENERATED);
                    return k.a();
                } else {
                    throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
                }
            }
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
    }

    public String d() {
        i0.h.c.c cVar = this.c;
        cVar.a();
        return cVar.f.a;
    }

    public String e() {
        i0.h.c.c cVar = this.c;
        cVar.a();
        return cVar.f.b;
    }

    public String g() {
        i0.h.c.c cVar = this.c;
        cVar.a();
        return cVar.f.g;
    }

    @Override // i0.h.c.r.g
    public g<String> getId() {
        String str;
        h();
        synchronized (this) {
            str = this.l;
        }
        if (str != null) {
            return i0.h.a.b.c.m.b.H(str);
        }
        i0.h.a.b.m.h hVar = new i0.h.a.b.m.h();
        j jVar = new j(hVar);
        synchronized (this.i) {
            this.n.add(jVar);
        }
        g gVar = hVar.a;
        this.j.execute(new Runnable(this) { // from class: i0.h.c.r.c
            public final f c;

            {
                this.c = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = this.c;
                Object obj = f.a;
                fVar.b(false);
            }
        });
        return gVar;
    }

    public final void h() {
        v.y(e(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        v.y(g(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        v.y(d(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        String e = e();
        Pattern pattern = n.b;
        v.u(e.contains(":"), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        v.u(n.b.matcher(d()).matches(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001c, code lost:
        if ("[DEFAULT]".equals(r0.e) != false) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final String i(i0.h.c.r.p.c cVar) {
        String string;
        i0.h.c.c cVar2 = this.c;
        cVar2.a();
        if (!cVar2.e.equals("CHIME_ANDROID_SDK")) {
            i0.h.c.c cVar3 = this.c;
            cVar3.a();
        }
        if (((i0.h.c.r.p.a) cVar).c == PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION) {
            i0.h.c.r.p.b bVar = this.g;
            synchronized (bVar.b) {
                synchronized (bVar.b) {
                    string = bVar.b.getString("|S|id", null);
                }
                if (string == null) {
                    string = bVar.a();
                }
            }
            return TextUtils.isEmpty(string) ? this.h.a() : string;
        }
        return this.h.a();
    }

    /* JADX WARN: Finally extract failed */
    public final i0.h.c.r.p.c j(i0.h.c.r.p.c cVar) throws FirebaseInstallationsException {
        int responseCode;
        InstallationResponse e;
        i0.h.c.r.p.a aVar = (i0.h.c.r.p.a) cVar;
        String str = aVar.b;
        String str2 = null;
        if (str != null && str.length() == 11) {
            i0.h.c.r.p.b bVar = this.g;
            synchronized (bVar.b) {
                String[] strArr = i0.h.c.r.p.b.a;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str3 = strArr[i];
                    String string = bVar.b.getString("|T|" + bVar.c + "|" + str3, null);
                    if (string == null || string.isEmpty()) {
                        i++;
                    } else if (string.startsWith("{")) {
                        try {
                            str2 = new JSONObject(string).getString("token");
                        } catch (JSONException unused) {
                        }
                    } else {
                        str2 = string;
                    }
                }
            }
        }
        i0.h.c.r.q.c cVar2 = this.d;
        String d = d();
        String str4 = aVar.b;
        String g = g();
        String e2 = e();
        if (cVar2.f.a()) {
            URL a2 = cVar2.a(String.format("projects/%s/installations", g));
            for (int i2 = 0; i2 <= 1; i2++) {
                HttpURLConnection c = cVar2.c(a2, d);
                try {
                    try {
                        c.setRequestMethod(RequestMethod.POST);
                        c.setDoOutput(true);
                        if (str2 != null) {
                            c.addRequestProperty("x-goog-fis-android-iid-migration-auth", str2);
                        }
                        cVar2.g(c, str4, e2);
                        responseCode = c.getResponseCode();
                        cVar2.f.b(responseCode);
                    } catch (Throwable th) {
                        c.disconnect();
                        throw th;
                    }
                } catch (IOException | AssertionError unused2) {
                }
                if (responseCode >= 200 && responseCode < 300) {
                    e = cVar2.e(c);
                    c.disconnect();
                } else {
                    i0.h.c.r.q.c.b(c, e2, d, g);
                    if (responseCode == 429) {
                        throw new FirebaseInstallationsException("Firebase servers have received too many requests from this client in a short period of time. Please try again later.", FirebaseInstallationsException.Status.TOO_MANY_REQUESTS);
                    } else if (responseCode < 500 || responseCode >= 600) {
                        Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
                        i0.h.c.r.q.a aVar2 = new i0.h.c.r.q.a(null, null, null, null, InstallationResponse.ResponseCode.BAD_CONFIG, null);
                        c.disconnect();
                        e = aVar2;
                    } else {
                        c.disconnect();
                    }
                }
                i0.h.c.r.q.a aVar3 = (i0.h.c.r.q.a) e;
                int ordinal = aVar3.e.ordinal();
                if (ordinal == 0) {
                    String str5 = aVar3.b;
                    String str6 = aVar3.c;
                    long b2 = this.f.b();
                    String c2 = aVar3.d.c();
                    long d2 = aVar3.d.d();
                    a.b bVar2 = (a.b) cVar.k();
                    bVar2.a = str5;
                    bVar2.b(PersistedInstallation.RegistrationStatus.REGISTERED);
                    bVar2.c = c2;
                    bVar2.d = str6;
                    bVar2.e = Long.valueOf(d2);
                    bVar2.f = Long.valueOf(b2);
                    return bVar2.a();
                } else if (ordinal == 1) {
                    a.b bVar3 = (a.b) cVar.k();
                    bVar3.g = "BAD CONFIG";
                    bVar3.b(PersistedInstallation.RegistrationStatus.REGISTER_ERROR);
                    return bVar3.a();
                } else {
                    throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
                }
            }
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
    }

    public final void k(Exception exc) {
        synchronized (this.i) {
            Iterator<m> it = this.n.iterator();
            while (it.hasNext()) {
                if (it.next().a(exc)) {
                    it.remove();
                }
            }
        }
    }

    public final void l(i0.h.c.r.p.c cVar) {
        synchronized (this.i) {
            Iterator<m> it = this.n.iterator();
            while (it.hasNext()) {
                if (it.next().b(cVar)) {
                    it.remove();
                }
            }
        }
    }
}
