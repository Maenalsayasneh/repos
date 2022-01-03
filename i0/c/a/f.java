package i0.c.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import androidx.recyclerview.widget.RecyclerView;
import com.amplitude.api.CursorWindowAllocationException;
import com.instabug.library.networkv2.request.Header;
import com.instabug.library.networkv2.request.RequestMethod;
import com.pubnub.api.vendor.FileEncryptionUtil;
import com.stripe.android.model.PaymentMethodOptionsParams;
import com.stripe.android.model.parsers.AccountRangeJsonParser;
import com.stripe.android.networking.AnalyticsRequestFactory;
import i0.c.c.b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import m0.n.b.i;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q0.b0;
import q0.e0;
import q0.f;
import q0.u;
/* compiled from: AmplitudeClient.java */
/* loaded from: classes.dex */
public class f {
    public static final String a = "i0.c.a.f";
    public long A;
    public long B;
    public boolean C;
    public int D;
    public String E;
    public String F;
    public AtomicBoolean G;
    public AtomicBoolean H;
    public String I;
    public s J;
    public s K;
    public Context b;
    public f.a c;
    public m d;
    public String e;
    public String f;
    public String g;
    public String h;
    public boolean i;
    public boolean j;
    public q k;
    public q l;
    public JSONObject m;
    public boolean n;
    public String o;
    public long p;
    public long q;
    public long r;
    public long s;
    public long t;
    public long u;
    public o v;
    public int w;
    public int x;
    public int y;
    public long z;

    /* compiled from: AmplitudeClient.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ String c;
        public final /* synthetic */ long d;
        public final /* synthetic */ long q;

        public a(String str, long j, long j2) {
            this.c = str;
            this.d = j;
            this.q = j2;
        }

        /* JADX WARN: Removed duplicated region for block: B:57:0x01d1  */
        /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        /* Code decompiled incorrectly, please refer to instructions dump */
        public void run() {
            IOException e;
            AssertionError e2;
            Exception e3;
            e0 execute;
            String string;
            f fVar = f.this;
            f.a aVar = fVar.c;
            String str = this.c;
            long j = this.d;
            long j2 = this.q;
            Objects.requireNonNull(fVar);
            StringBuilder sb = new StringBuilder();
            String str2 = "";
            sb.append(str2);
            sb.append(System.currentTimeMillis());
            String sb2 = sb.toString();
            try {
                byte[] digest = new i0.c.b.a().digest(("2" + fVar.e + str + sb2).getBytes(FileEncryptionUtil.ENCODING_UTF_8));
                char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
                char[] cArr2 = new char[digest.length * 2];
                for (int i = 0; i < digest.length; i++) {
                    int i2 = digest[i] & 255;
                    int i3 = i * 2;
                    cArr2[i3] = cArr[i2 >>> 4];
                    cArr2[i3 + 1] = cArr[i2 & 15];
                }
                str2 = new String(cArr2);
            } catch (UnsupportedEncodingException e4) {
                k.a.a(f.a, e4.toString());
            }
            u.a aVar2 = new u.a();
            aVar2.a("v", "2");
            aVar2.a(PaymentMethodOptionsParams.WeChatPay.PARAM_CLIENT, fVar.e);
            aVar2.a("e", str);
            aVar2.a("upload_time", sb2);
            aVar2.a("checksum", str2);
            u uVar = new u(aVar2.a, aVar2.b);
            try {
                b0.a aVar3 = new b0.a();
                aVar3.h(fVar.I);
                i.e(uVar, "body");
                aVar3.e(RequestMethod.POST, uVar);
                if (!r.d(null)) {
                    aVar3.a(Header.AUTHORIZATION, "Bearer null");
                }
                boolean z = true;
                try {
                    try {
                        execute = aVar.newCall(aVar3.b()).execute();
                        string = execute.a2.string();
                    } catch (ConnectException | UnknownHostException unused) {
                    }
                } catch (IOException e5) {
                    e = e5;
                    z = false;
                } catch (AssertionError e6) {
                    e2 = e6;
                    z = false;
                } catch (Exception e7) {
                    e3 = e7;
                    z = false;
                }
                if (string.equals("success")) {
                    try {
                        fVar.J.a(new g(fVar, j, j2));
                    } catch (AssertionError e8) {
                        e2 = e8;
                        k.a.b(f.a, "Exception:", e2);
                    } catch (ConnectException | UnknownHostException unused2) {
                    } catch (IOException e9) {
                        e = e9;
                        k.a.a(f.a, e.toString());
                    } catch (Exception e10) {
                        e3 = e10;
                        k.a.b(f.a, "Exception:", e3);
                    }
                    if (z) {
                        fVar.H.set(false);
                        return;
                    }
                    return;
                }
                if (string.equals("invalid_api_key")) {
                    k.a.a(f.a, "Invalid API key, make sure your API key is correct in initialize()");
                } else if (string.equals("bad_checksum")) {
                    k.a.c(f.a, "Bad checksum, post request was mangled in transit, will attempt to reupload later");
                } else if (string.equals("request_db_write_failed")) {
                    k.a.c(f.a, "Couldn't write to request database on server, will attempt to reupload later");
                } else if (execute.y == 413) {
                    if (fVar.C && fVar.D == 1) {
                        if (j >= 0) {
                            fVar.d.N(j);
                        }
                        if (j2 >= 0) {
                            fVar.d.T(j2);
                        }
                    }
                    fVar.C = true;
                    fVar.D = (int) Math.ceil(((double) Math.min((int) fVar.d.l(), fVar.D)) / 2.0d);
                    k.a.c(f.a, "Request too large, will decrease size and attempt to reupload");
                    fVar.J.a(new h(fVar));
                } else {
                    k kVar = k.a;
                    String str3 = f.a;
                    kVar.c(str3, "Upload failed, " + string + ", will attempt to reupload later");
                }
                z = false;
                if (z) {
                }
            } catch (IllegalArgumentException e11) {
                k.a.a(f.a, e11.toString());
                fVar.H.set(false);
            }
        }
    }

    /* compiled from: AmplitudeClient.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ JSONObject Y1;
        public final /* synthetic */ long Z1;
        public final /* synthetic */ boolean a2;
        public final /* synthetic */ String c;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ JSONObject q;
        public final /* synthetic */ JSONObject x;
        public final /* synthetic */ JSONObject y;

        public b(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5, long j, boolean z) {
            this.c = str;
            this.d = jSONObject;
            this.q = jSONObject2;
            this.x = jSONObject3;
            this.y = jSONObject4;
            this.Y1 = jSONObject5;
            this.Z1 = j;
            this.a2 = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!r.d(f.this.e)) {
                f.this.g(this.c, this.d, this.q, this.x, this.y, this.Y1, this.Z1, this.a2);
            }
        }
    }

    public f() {
        this(null);
    }

    public static void k(SharedPreferences sharedPreferences, String str, long j, m mVar, String str2) {
        if (mVar.v(str2) == null) {
            mVar.H(str2, Long.valueOf(sharedPreferences.getLong(str, j)));
            sharedPreferences.edit().remove(str).apply();
        }
    }

    public static void l(SharedPreferences sharedPreferences, String str, String str2, m mVar, String str3) {
        if (r.d(mVar.C(str3))) {
            String string = sharedPreferences.getString(str, null);
            if (!r.d(string)) {
                mVar.I(str3, string);
                sharedPreferences.edit().remove(str).apply();
            }
        }
    }

    public static boolean u(Context context) {
        String str;
        try {
            str = l.class.getPackage().getName();
        } catch (Exception unused) {
            str = "com.amplitude.api";
        }
        try {
            if ("com.amplitude.api".equals(str)) {
                return false;
            }
            String str2 = str + "." + context.getPackageName();
            SharedPreferences sharedPreferences = context.getSharedPreferences(str2, 0);
            if (sharedPreferences.getAll().size() == 0) {
                return false;
            }
            String str3 = "com.amplitude.api." + context.getPackageName();
            SharedPreferences.Editor edit = context.getSharedPreferences(str3, 0).edit();
            if (sharedPreferences.contains(str + ".previousSessionId")) {
                edit.putLong("com.amplitude.api.previousSessionId", sharedPreferences.getLong(str + ".previousSessionId", -1));
            }
            if (sharedPreferences.contains(str + ".deviceId")) {
                edit.putString("com.amplitude.api.deviceId", sharedPreferences.getString(str + ".deviceId", null));
            }
            if (sharedPreferences.contains(str + ".userId")) {
                edit.putString("com.amplitude.api.userId", sharedPreferences.getString(str + ".userId", null));
            }
            if (sharedPreferences.contains(str + ".optOut")) {
                edit.putBoolean("com.amplitude.api.optOut", sharedPreferences.getBoolean(str + ".optOut", false));
            }
            edit.apply();
            sharedPreferences.edit().clear().apply();
            k kVar = k.a;
            String str4 = a;
            String str5 = "Upgraded shared preferences from " + str2 + " to " + str3;
            if (kVar.b && kVar.c <= 4) {
                Log.i(str4, str5);
            }
            return true;
        } catch (Exception e) {
            k.a.b(a, "Error upgrading shared preferences", e);
            return false;
        }
    }

    public static boolean v(Context context) {
        m i = m.i(context, null);
        String C = i.C(AnalyticsRequestFactory.FIELD_DEVICE_ID);
        Long v = i.v("previous_session_id");
        Long v2 = i.v("last_event_time");
        if (!r.d(C) && v != null && v2 != null) {
            return true;
        }
        StringBuilder S0 = i0.d.a.a.a.S0("com.amplitude.api", ".");
        S0.append(context.getPackageName());
        SharedPreferences sharedPreferences = context.getSharedPreferences(S0.toString(), 0);
        l(sharedPreferences, "com.amplitude.api.deviceId", null, i, AnalyticsRequestFactory.FIELD_DEVICE_ID);
        k(sharedPreferences, "com.amplitude.api.lastEventTime", -1, i, "last_event_time");
        k(sharedPreferences, "com.amplitude.api.lastEventId", -1, i, "last_event_id");
        k(sharedPreferences, "com.amplitude.api.lastIdentifyId", -1, i, "last_identify_id");
        k(sharedPreferences, "com.amplitude.api.previousSessionId", -1, i, "previous_session_id");
        l(sharedPreferences, "com.amplitude.api.userId", null, i, "user_id");
        if (i.v("opt_out") != null) {
            return true;
        }
        i.H("opt_out", Long.valueOf(sharedPreferences.getBoolean("com.amplitude.api.optOut", false) ? 1 : 0));
        sharedPreferences.edit().remove("com.amplitude.api.optOut").apply();
        return true;
    }

    public synchronized boolean a(String str) {
        if (this.b == null) {
            k kVar = k.a;
            String str2 = a;
            kVar.a(str2, "context cannot be null, set context with initialize() before calling " + str);
            return false;
        } else if (!r.d(this.e)) {
            return true;
        } else {
            k kVar2 = k.a;
            String str3 = a;
            kVar2.a(str3, "apiKey cannot be null or empty, set apiKey with initialize() before calling " + str);
            return false;
        }
    }

    public final long b(String str, long j) {
        Long v = this.d.v(str);
        return v == null ? j : v.longValue();
    }

    public void c(p pVar) {
        if (pVar.b.length() != 0 && a("identify()")) {
            i("$identify", null, null, pVar.b, null, null, System.currentTimeMillis(), false);
        }
    }

    public final boolean d() {
        return this.p >= 0;
    }

    public final String e() {
        HashSet hashSet = new HashSet();
        hashSet.add("");
        hashSet.add("9774d56d682e549c");
        hashSet.add("unknown");
        hashSet.add("000000000000000");
        hashSet.add("Android");
        hashSet.add("DEFACE");
        hashSet.add("00000000-0000-0000-0000-000000000000");
        String C = this.d.C(AnalyticsRequestFactory.FIELD_DEVICE_ID);
        String string = r.c(this.b, this.f).getString(AnalyticsRequestFactory.FIELD_DEVICE_ID, null);
        if (!r.d(C) && !hashSet.contains(C)) {
            if (!C.equals(string)) {
                o(C);
            }
            return C;
        } else if (r.d(string) || hashSet.contains(string)) {
            StringBuilder sb = new StringBuilder();
            String str = o.a;
            sb.append(UUID.randomUUID().toString());
            sb.append("R");
            String sb2 = sb.toString();
            o(sb2);
            return sb2;
        } else {
            o(string);
            return string;
        }
    }

    public synchronized f f(Context context, String str, String str2, String str3, f.a aVar) {
        if (context == null) {
            k.a.a(a, "Argument context cannot be null in initialize()");
            return this;
        } else if (r.d(str)) {
            k.a.a(a, "Argument apiKey cannot be null or blank in initialize()");
            return this;
        } else {
            Context applicationContext = context.getApplicationContext();
            this.b = applicationContext;
            this.e = str;
            this.d = m.i(applicationContext, this.f);
            if (r.d(str3)) {
                str3 = "Android";
            }
            this.o = str3;
            n(new Runnable(context, aVar, str2, this) { // from class: i0.c.a.a
                public final /* synthetic */ Context d;
                public final /* synthetic */ f.a q;
                public final /* synthetic */ String x;
                public final /* synthetic */ f y;

                {
                    this.d = r2;
                    this.q = r3;
                    this.x = r4;
                    this.y = r5;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    f fVar = f.this;
                    Context context2 = this.d;
                    f.a aVar2 = this.q;
                    String str4 = this.x;
                    f fVar2 = this.y;
                    if (!fVar.i) {
                        try {
                            if (fVar.f.equals("$default_instance")) {
                                f.u(context2);
                                f.v(context2);
                            }
                            if (aVar2 == null) {
                                b bVar = c.a;
                                Object obj = i0.c.c.a.a;
                                if (!(bVar instanceof i0.c.c.a)) {
                                    bVar = new i0.c.c.a(bVar);
                                }
                                fVar.c = 
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0036: IPUT  
                                      (wrap: i0.c.a.b : 0x0033: CONSTRUCTOR  (r7v10 i0.c.a.b A[REMOVE]) = (r2v9 'bVar' i0.c.c.b) call: i0.c.a.b.<init>(i0.c.c.b):void type: CONSTRUCTOR)
                                      (r0v0 'fVar' i0.c.a.f)
                                     i0.c.a.f.c q0.f$a in method: i0.c.a.a.run():void, file: classes.dex
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
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:301)
                                    	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:122)
                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
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
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: i0.c.a.b, state: NOT_LOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:447)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                                    	... 33 more
                                    */
                                /*
                                    this = this;
                                    i0.c.a.f r0 = i0.c.a.f.this
                                    android.content.Context r1 = r11.d
                                    q0.f$a r2 = r11.q
                                    java.lang.String r3 = r11.x
                                    i0.c.a.f r4 = r11.y
                                    boolean r5 = r0.i
                                    if (r5 != 0) goto L_0x00d3
                                    r5 = 0
                                    r6 = 1
                                    java.lang.String r7 = r0.f     // Catch: CursorWindowAllocationException -> 0x00ba
                                    java.lang.String r8 = "$default_instance"
                                    boolean r7 = r7.equals(r8)     // Catch: CursorWindowAllocationException -> 0x00ba
                                    if (r7 == 0) goto L_0x0020
                                    i0.c.a.f.u(r1)     // Catch: CursorWindowAllocationException -> 0x00ba
                                    i0.c.a.f.v(r1)     // Catch: CursorWindowAllocationException -> 0x00ba
                                L_0x0020:
                                    if (r2 != 0) goto L_0x0039
                                    i0.c.a.c r2 = i0.c.a.c.a     // Catch: CursorWindowAllocationException -> 0x00ba
                                    java.lang.Object r7 = i0.c.c.a.a     // Catch: CursorWindowAllocationException -> 0x00ba
                                    boolean r7 = r2 instanceof i0.c.c.a     // Catch: CursorWindowAllocationException -> 0x00ba
                                    if (r7 == 0) goto L_0x002b
                                    goto L_0x0031
                                L_0x002b:
                                    i0.c.c.a r7 = new i0.c.c.a     // Catch: CursorWindowAllocationException -> 0x00ba
                                    r7.<init>(r2)     // Catch: CursorWindowAllocationException -> 0x00ba
                                    r2 = r7
                                L_0x0031:
                                    i0.c.a.b r7 = new i0.c.a.b     // Catch: CursorWindowAllocationException -> 0x00ba
                                    r7.<init>(r2)     // Catch: CursorWindowAllocationException -> 0x00ba
                                    r0.c = r7     // Catch: CursorWindowAllocationException -> 0x00ba
                                    goto L_0x003b
                                L_0x0039:
                                    r0.c = r2     // Catch: CursorWindowAllocationException -> 0x00ba
                                L_0x003b:
                                    i0.c.a.o r2 = new i0.c.a.o     // Catch: CursorWindowAllocationException -> 0x00ba
                                    boolean r7 = r0.n     // Catch: CursorWindowAllocationException -> 0x00ba
                                    r2.<init>(r1, r7)     // Catch: CursorWindowAllocationException -> 0x00ba
                                    r0.v = r2     // Catch: CursorWindowAllocationException -> 0x00ba
                                    java.lang.String r1 = r0.e()     // Catch: CursorWindowAllocationException -> 0x00ba
                                    r0.h = r1     // Catch: CursorWindowAllocationException -> 0x00ba
                                    i0.c.a.o r1 = r0.v     // Catch: CursorWindowAllocationException -> 0x00ba
                                    r1.b()     // Catch: CursorWindowAllocationException -> 0x00ba
                                    java.lang.String r1 = "user_id"
                                    if (r3 == 0) goto L_0x005b
                                    r4.g = r3     // Catch: CursorWindowAllocationException -> 0x00ba
                                    i0.c.a.m r2 = r0.d     // Catch: CursorWindowAllocationException -> 0x00ba
                                    r2.I(r1, r3)     // Catch: CursorWindowAllocationException -> 0x00ba
                                    goto L_0x0063
                                L_0x005b:
                                    i0.c.a.m r2 = r0.d     // Catch: CursorWindowAllocationException -> 0x00ba
                                    java.lang.String r1 = r2.C(r1)     // Catch: CursorWindowAllocationException -> 0x00ba
                                    r4.g = r1     // Catch: CursorWindowAllocationException -> 0x00ba
                                L_0x0063:
                                    i0.c.a.m r1 = r0.d     // Catch: CursorWindowAllocationException -> 0x00ba
                                    java.lang.String r2 = "opt_out"
                                    java.lang.Long r1 = r1.v(r2)     // Catch: CursorWindowAllocationException -> 0x00ba
                                    if (r1 == 0) goto L_0x0079
                                    long r1 = r1.longValue()     // Catch: CursorWindowAllocationException -> 0x00ba
                                    r7 = 1
                                    int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
                                    if (r1 != 0) goto L_0x0079
                                    r1 = r6
                                    goto L_0x007a
                                L_0x0079:
                                    r1 = r5
                                L_0x007a:
                                    r0.j = r1     // Catch: CursorWindowAllocationException -> 0x00ba
                                    java.lang.String r1 = "previous_session_id"
                                    r2 = -1
                                    long r7 = r0.b(r1, r2)     // Catch: CursorWindowAllocationException -> 0x00ba
                                    r0.u = r7     // Catch: CursorWindowAllocationException -> 0x00ba
                                    r9 = 0
                                    int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                                    if (r1 < 0) goto L_0x008e
                                    r0.p = r7     // Catch: CursorWindowAllocationException -> 0x00ba
                                L_0x008e:
                                    java.lang.String r1 = "sequence_number"
                                    long r7 = r0.b(r1, r9)     // Catch: CursorWindowAllocationException -> 0x00ba
                                    r0.q = r7     // Catch: CursorWindowAllocationException -> 0x00ba
                                    java.lang.String r1 = "last_event_id"
                                    long r7 = r0.b(r1, r2)     // Catch: CursorWindowAllocationException -> 0x00ba
                                    r0.r = r7     // Catch: CursorWindowAllocationException -> 0x00ba
                                    java.lang.String r1 = "last_identify_id"
                                    long r7 = r0.b(r1, r2)     // Catch: CursorWindowAllocationException -> 0x00ba
                                    r0.s = r7     // Catch: CursorWindowAllocationException -> 0x00ba
                                    java.lang.String r1 = "last_event_time"
                                    long r1 = r0.b(r1, r2)     // Catch: CursorWindowAllocationException -> 0x00ba
                                    r0.t = r1     // Catch: CursorWindowAllocationException -> 0x00ba
                                    i0.c.a.m r1 = r0.d     // Catch: CursorWindowAllocationException -> 0x00ba
                                    i0.c.a.i r2 = new i0.c.a.i     // Catch: CursorWindowAllocationException -> 0x00ba
                                    r2.<init>(r0, r4)     // Catch: CursorWindowAllocationException -> 0x00ba
                                    r1.Y1 = r2     // Catch: CursorWindowAllocationException -> 0x00ba
                                    r0.i = r6     // Catch: CursorWindowAllocationException -> 0x00ba
                                    goto L_0x00d3
                                L_0x00ba:
                                    r0 = move-exception
                                    i0.c.a.k r1 = i0.c.a.k.a
                                    java.lang.String r2 = i0.c.a.f.a
                                    java.lang.Object[] r3 = new java.lang.Object[r6]
                                    java.lang.String r0 = r0.getMessage()
                                    r3[r5] = r0
                                    java.lang.String r0 = "Failed to initialize Amplitude SDK due to: %s"
                                    java.lang.String r0 = java.lang.String.format(r0, r3)
                                    r1.a(r2, r0)
                                    r0 = 0
                                    r4.e = r0
                                L_0x00d3:
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: i0.c.a.a.run():void");
                            }
                        });
                        return this;
                    }
                }

                public long g(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5, long j, boolean z) {
                    long j2;
                    Object obj;
                    long j3;
                    Object obj2;
                    Object obj3;
                    Object obj4;
                    Location d;
                    k kVar = k.a;
                    String str2 = a;
                    String n02 = i0.d.a.a.a.n0("Logged event to Amplitude: ", str);
                    if (kVar.b && kVar.c <= 3) {
                        Log.d(str2, n02);
                    }
                    long j4 = -1;
                    if (this.j) {
                        return -1;
                    }
                    if (!z) {
                        if (d()) {
                            if (j - this.t < this.B) {
                                m(j);
                            } else {
                                q(j);
                                m(j);
                            }
                            j4 = -1;
                        } else {
                            if (j - this.t < this.B) {
                                long j5 = this.u;
                                if (j5 == -1) {
                                    q(j);
                                    m(j);
                                } else {
                                    q(j5);
                                    m(j);
                                }
                                j4 = -1;
                            } else {
                                j4 = -1;
                                q(j);
                                m(j);
                            }
                        }
                    }
                    JSONObject jSONObject6 = new JSONObject();
                    if (str == null) {
                        try {
                            obj = JSONObject.NULL;
                            j2 = j4;
                        } catch (JSONException e) {
                            e = e;
                            j2 = j4;
                            k.a.a(a, String.format("JSON Serialization of event type %s failed, skipping: %s", str, e.toString()));
                            return j2;
                        }
                    } else {
                        j2 = j4;
                        obj = str;
                    }
                    try {
                        jSONObject6.put("event_type", obj);
                        jSONObject6.put("timestamp", j);
                        Object obj5 = this.g;
                        if (obj5 == null) {
                            obj5 = JSONObject.NULL;
                        }
                        jSONObject6.put("user_id", obj5);
                        Object obj6 = this.h;
                        if (obj6 == null) {
                            obj6 = JSONObject.NULL;
                        }
                        jSONObject6.put(AnalyticsRequestFactory.FIELD_DEVICE_ID, obj6);
                        if (z) {
                            j3 = j2;
                        } else {
                            j3 = this.p;
                        }
                        jSONObject6.put("session_id", j3);
                        jSONObject6.put("uuid", UUID.randomUUID().toString());
                        long j6 = this.q + 1;
                        this.q = j6;
                        this.d.H("sequence_number", Long.valueOf(j6));
                        jSONObject6.put("sequence_number", this.q);
                        if (!this.l.c.contains("version_name")) {
                            Object obj7 = this.v.b().c;
                            if (obj7 == null) {
                                obj7 = JSONObject.NULL;
                            }
                            jSONObject6.put("version_name", obj7);
                        }
                        if (!this.l.c.contains(AnalyticsRequestFactory.FIELD_OS_NAME)) {
                            Object obj8 = this.v.b().d;
                            if (obj8 == null) {
                                obj8 = JSONObject.NULL;
                            }
                            jSONObject6.put(AnalyticsRequestFactory.FIELD_OS_NAME, obj8);
                        }
                        if (!this.l.c.contains(AnalyticsRequestFactory.FIELD_OS_VERSION)) {
                            Object obj9 = this.v.b().e;
                            if (obj9 == null) {
                                obj9 = JSONObject.NULL;
                            }
                            jSONObject6.put(AnalyticsRequestFactory.FIELD_OS_VERSION, obj9);
                        }
                        if (!this.l.c.contains("api_level")) {
                            Object valueOf = Integer.valueOf(Build.VERSION.SDK_INT);
                            if (valueOf == null) {
                                valueOf = JSONObject.NULL;
                            }
                            jSONObject6.put("api_level", valueOf);
                        }
                        if (!this.l.c.contains("device_brand")) {
                            Object obj10 = this.v.b().f;
                            if (obj10 == null) {
                                obj10 = JSONObject.NULL;
                            }
                            jSONObject6.put("device_brand", obj10);
                        }
                        if (!this.l.c.contains("device_manufacturer")) {
                            Object obj11 = this.v.b().g;
                            if (obj11 == null) {
                                obj11 = JSONObject.NULL;
                            }
                            jSONObject6.put("device_manufacturer", obj11);
                        }
                        if (!this.l.c.contains("device_model")) {
                            Object obj12 = this.v.b().h;
                            if (obj12 == null) {
                                obj12 = JSONObject.NULL;
                            }
                            jSONObject6.put("device_model", obj12);
                        }
                        if (!this.l.c.contains("carrier")) {
                            Object obj13 = this.v.b().i;
                            if (obj13 == null) {
                                obj13 = JSONObject.NULL;
                            }
                            jSONObject6.put("carrier", obj13);
                        }
                        if (!this.l.c.contains(AccountRangeJsonParser.FIELD_COUNTRY)) {
                            Object obj14 = this.v.b().b;
                            if (obj14 == null) {
                                obj14 = JSONObject.NULL;
                            }
                            jSONObject6.put(AccountRangeJsonParser.FIELD_COUNTRY, obj14);
                        }
                        if (!this.l.c.contains("language")) {
                            Object obj15 = this.v.b().j;
                            if (obj15 == null) {
                                obj15 = JSONObject.NULL;
                            }
                            jSONObject6.put("language", obj15);
                        }
                        if (!this.l.c.contains("platform")) {
                            jSONObject6.put("platform", this.o);
                        }
                        JSONObject jSONObject7 = new JSONObject();
                        String str3 = this.E;
                        if (str3 == null) {
                            str3 = "unknown-library";
                        }
                        jSONObject7.put("name", str3);
                        String str4 = this.F;
                        if (str4 == null) {
                            str4 = "unknown-version";
                        }
                        jSONObject7.put("version", str4);
                        jSONObject6.put("library", jSONObject7);
                        JSONObject jSONObject8 = jSONObject2 == null ? new JSONObject() : jSONObject2;
                        JSONObject jSONObject9 = this.m;
                        if (jSONObject9 != null && jSONObject9.length() > 0) {
                            jSONObject8.put("tracking_options", this.m);
                        }
                        if ((!this.l.c.contains("lat_lng")) && (d = this.v.d()) != null) {
                            JSONObject jSONObject10 = new JSONObject();
                            jSONObject10.put("lat", d.getLatitude());
                            jSONObject10.put("lng", d.getLongitude());
                            jSONObject8.put("location", jSONObject10);
                        }
                        if ((!this.l.c.contains("adid")) && this.v.a() != null) {
                            jSONObject8.put("androidADID", this.v.a());
                        }
                        jSONObject8.put("limit_ad_tracking", this.v.b().k);
                        jSONObject8.put("gps_enabled", this.v.b().l);
                        jSONObject6.put("api_properties", jSONObject8);
                        if (jSONObject == null) {
                            obj2 = new JSONObject();
                        } else {
                            obj2 = s(jSONObject);
                        }
                        jSONObject6.put("event_properties", obj2);
                        if (jSONObject3 == null) {
                            obj3 = new JSONObject();
                        } else {
                            obj3 = s(jSONObject3);
                        }
                        jSONObject6.put("user_properties", obj3);
                        jSONObject6.put("groups", jSONObject4 == null ? new JSONObject() : s(jSONObject4));
                        if (jSONObject5 == null) {
                            obj4 = new JSONObject();
                        } else {
                            obj4 = s(jSONObject5);
                        }
                        jSONObject6.put("group_properties", obj4);
                        return p(str, jSONObject6);
                    } catch (JSONException e2) {
                        e = e2;
                        k.a.a(a, String.format("JSON Serialization of event type %s failed, skipping: %s", str, e.toString()));
                        return j2;
                    }
                }

                public void h(String str, JSONObject jSONObject) {
                    boolean z;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (r.d(str)) {
                        k.a.a(a, "Argument eventType cannot be null or blank in logEvent()");
                        z = false;
                    } else {
                        z = a("logEvent()");
                    }
                    if (z) {
                        i(str, jSONObject, null, null, null, null, currentTimeMillis, false);
                    }
                }

                public void i(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5, long j, boolean z) {
                    n(new b(str, jSONObject != null ? r.b(jSONObject) : jSONObject, null, jSONObject3 != null ? r.b(jSONObject3) : jSONObject3, jSONObject4 != null ? r.b(jSONObject4) : jSONObject4, null, j, z));
                }

                public Pair<Pair<Long, Long>, JSONArray> j(List<JSONObject> list, List<JSONObject> list2, long j) throws JSONException {
                    long j2;
                    long j3;
                    JSONArray jSONArray = new JSONArray();
                    long j4 = -1;
                    long j5 = -1;
                    while (true) {
                        if (((long) jSONArray.length()) >= j) {
                            break;
                        }
                        boolean isEmpty = list.isEmpty();
                        boolean isEmpty2 = list2.isEmpty();
                        if (isEmpty && isEmpty2) {
                            k.a.c(a, String.format("mergeEventsAndIdentifys: number of events and identifys less than expected by %d", Long.valueOf(j - ((long) jSONArray.length()))));
                            break;
                        }
                        if (isEmpty2) {
                            JSONObject remove = list.remove(0);
                            j2 = remove.getLong("event_id");
                            jSONArray.put(remove);
                        } else {
                            if (isEmpty) {
                                JSONObject remove2 = list2.remove(0);
                                j3 = remove2.getLong("event_id");
                                jSONArray.put(remove2);
                            } else if (!list.get(0).has("sequence_number") || list.get(0).getLong("sequence_number") < list2.get(0).getLong("sequence_number")) {
                                JSONObject remove3 = list.remove(0);
                                j2 = remove3.getLong("event_id");
                                jSONArray.put(remove3);
                            } else {
                                JSONObject remove4 = list2.remove(0);
                                j3 = remove4.getLong("event_id");
                                jSONArray.put(remove4);
                            }
                            j5 = j3;
                        }
                        j4 = j2;
                    }
                    return new Pair<>(new Pair(Long.valueOf(j4), Long.valueOf(j5)), jSONArray);
                }

                public void m(long j) {
                    if (d()) {
                        this.t = j;
                        this.d.H("last_event_time", Long.valueOf(j));
                    }
                }

                public void n(Runnable runnable) {
                    Thread currentThread = Thread.currentThread();
                    s sVar = this.J;
                    if (currentThread != sVar) {
                        sVar.b();
                        sVar.c.post(runnable);
                        return;
                    }
                    runnable.run();
                }

                public final void o(String str) {
                    this.d.I(AnalyticsRequestFactory.FIELD_DEVICE_ID, str);
                    SharedPreferences.Editor edit = r.c(this.b, this.f).edit();
                    edit.putString(AnalyticsRequestFactory.FIELD_DEVICE_ID, str);
                    edit.apply();
                }

                public long p(String str, JSONObject jSONObject) {
                    long n;
                    long w;
                    long a2;
                    long a3;
                    String jSONObject2 = jSONObject.toString();
                    if (r.d(jSONObject2)) {
                        k.a.a(a, String.format("Detected empty event string for event type %s, skipping", str));
                        return -1;
                    }
                    if (str.equals("$identify") || str.equals("$groupidentify")) {
                        m mVar = this.d;
                        synchronized (mVar) {
                            a2 = mVar.a("identifys", jSONObject2);
                        }
                        this.s = a2;
                        this.s = a2;
                        this.d.H("last_identify_id", Long.valueOf(a2));
                    } else {
                        m mVar2 = this.d;
                        synchronized (mVar2) {
                            a3 = mVar2.a("events", jSONObject2);
                        }
                        this.r = a3;
                        this.r = a3;
                        this.d.H("last_event_id", Long.valueOf(a3));
                    }
                    int min = Math.min(Math.max(1, this.y / 10), 20);
                    if (this.d.l() > ((long) this.y)) {
                        m mVar3 = this.d;
                        long j = (long) min;
                        synchronized (mVar3) {
                            w = mVar3.w("events", j);
                        }
                        synchronized (mVar3) {
                            mVar3.Q("events", w);
                        }
                    }
                    m mVar4 = this.d;
                    synchronized (mVar4) {
                        n = mVar4.n("identifys");
                    }
                    if (n > ((long) this.y)) {
                        m mVar5 = this.d;
                        mVar5.U(mVar5.y((long) min));
                    }
                    long z = this.d.z();
                    long j2 = (long) this.w;
                    if (z % j2 != 0 || z < j2) {
                        long j3 = this.z;
                        if (!this.G.getAndSet(true)) {
                            s sVar = this.J;
                            e eVar = new e(this);
                            sVar.b();
                            sVar.c.postDelayed(eVar, j3);
                        }
                    } else {
                        t(false);
                    }
                    return (str.equals("$identify") || str.equals("$groupidentify")) ? this.s : this.r;
                }

                public final void q(long j) {
                    this.p = j;
                    this.u = j;
                    this.d.H("previous_session_id", Long.valueOf(j));
                }

                public JSONArray r(JSONArray jSONArray) throws JSONException {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        Object obj = jSONArray.get(i);
                        if (obj.getClass().equals(String.class)) {
                            String str = (String) obj;
                            if (str.length() > 1024) {
                                str = str.substring(0, RecyclerView.b0.FLAG_ADAPTER_FULLUPDATE);
                            }
                            jSONArray.put(i, str);
                        } else if (obj.getClass().equals(JSONObject.class)) {
                            jSONArray.put(i, s((JSONObject) obj));
                        } else if (obj.getClass().equals(JSONArray.class)) {
                            jSONArray.put(i, r((JSONArray) obj));
                        }
                    }
                    return jSONArray;
                }

                public JSONObject s(JSONObject jSONObject) {
                    Object obj;
                    if (jSONObject.length() > 1000) {
                        k.a.c(a, "Warning: too many properties (more than 1000), ignoring");
                        return new JSONObject();
                    }
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        try {
                            obj = jSONObject.get(next);
                        } catch (JSONException e) {
                            k.a.a(a, e.toString());
                        }
                        if (!next.equals("$receipt") && !next.equals("$receiptSig")) {
                            if (obj.getClass().equals(String.class)) {
                                String str = (String) obj;
                                if (str.length() > 1024) {
                                    str = str.substring(0, RecyclerView.b0.FLAG_ADAPTER_FULLUPDATE);
                                }
                                jSONObject.put(next, str);
                            } else if (obj.getClass().equals(JSONObject.class)) {
                                jSONObject.put(next, s((JSONObject) obj));
                            } else if (obj.getClass().equals(JSONArray.class)) {
                                jSONObject.put(next, r((JSONArray) obj));
                            }
                        }
                        jSONObject.put(next, obj);
                    }
                    return jSONObject;
                }

                public void t(boolean z) {
                    List<JSONObject> q;
                    List<JSONObject> q2;
                    if (!this.j && !this.H.getAndSet(true)) {
                        long min = Math.min((long) (z ? this.D : this.x), this.d.z());
                        if (min <= 0) {
                            this.H.set(false);
                            return;
                        }
                        try {
                            m mVar = this.d;
                            long j = this.r;
                            synchronized (mVar) {
                                q = mVar.q("events", j, min);
                            }
                            m mVar2 = this.d;
                            long j2 = this.s;
                            synchronized (mVar2) {
                                q2 = mVar2.q("identifys", j2, min);
                            }
                            Pair<Pair<Long, Long>, JSONArray> j3 = j(q, q2, min);
                            if (((JSONArray) j3.second).length() == 0) {
                                this.H.set(false);
                                return;
                            }
                            long longValue = ((Long) ((Pair) j3.first).first).longValue();
                            long longValue2 = ((Long) ((Pair) j3.first).second).longValue();
                            String jSONArray = ((JSONArray) j3.second).toString();
                            s sVar = this.K;
                            a aVar = new a(jSONArray, longValue, longValue2);
                            sVar.b();
                            sVar.c.post(aVar);
                        } catch (CursorWindowAllocationException e) {
                            this.H.set(false);
                            k.a.a(a, String.format("Caught Cursor window exception during event upload, deferring upload: %s", e.getMessage()));
                        } catch (JSONException e2) {
                            this.H.set(false);
                            k.a.a(a, e2.toString());
                        }
                    }
                }

                public f(String str) {
                    this.i = false;
                    this.j = false;
                    q qVar = new q();
                    this.k = qVar;
                    q qVar2 = new q();
                    for (String str2 : qVar.c) {
                        qVar2.c.add(str2);
                    }
                    this.l = qVar2;
                    JSONObject jSONObject = new JSONObject();
                    if (!qVar2.c.isEmpty()) {
                        String[] strArr = q.b;
                        for (String str3 : strArr) {
                            if (qVar2.c.contains(str3)) {
                                try {
                                    jSONObject.put(str3, false);
                                } catch (JSONException e) {
                                    k.a.a(q.a, e.toString());
                                }
                            }
                        }
                    }
                    this.m = jSONObject;
                    this.n = true;
                    this.p = -1;
                    this.q = 0;
                    this.r = -1;
                    this.s = -1;
                    this.t = -1;
                    this.u = -1;
                    this.w = 30;
                    this.x = 50;
                    this.y = 1000;
                    this.z = 30000;
                    this.A = 300000;
                    this.B = 1800000;
                    this.C = false;
                    this.D = 50;
                    this.E = "amplitude-android";
                    this.F = "2.31.0";
                    this.G = new AtomicBoolean(false);
                    this.H = new AtomicBoolean(false);
                    this.I = "https://api2.amplitude.com/";
                    this.J = new s("logThread");
                    this.K = new s("httpThread");
                    this.f = r.e(str);
                    this.J.start();
                    this.K.start();
                }
            }
