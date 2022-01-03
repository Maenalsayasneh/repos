package i0.h.a.a.i.s.i;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import com.google.android.datatransport.runtime.EventInternal;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.stripe.android.model.PaymentMethodOptionsParams;
import h0.b0.v;
import i0.h.a.a.b;
import i0.h.a.a.i.h;
import i0.h.a.a.i.t.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* compiled from: SQLiteEventStore.java */
/* loaded from: classes2.dex */
public class t implements c, i0.h.a.a.i.t.a {
    public static final i0.h.a.a.b c = new i0.h.a.a.b("proto");
    public final z d;
    public final i0.h.a.a.i.u.a q;
    public final i0.h.a.a.i.u.a x;
    public final d y;

    /* compiled from: SQLiteEventStore.java */
    /* loaded from: classes2.dex */
    public interface b<T, U> {
        U apply(T t);
    }

    /* compiled from: SQLiteEventStore.java */
    /* loaded from: classes2.dex */
    public static class c {
        public final String a;
        public final String b;

        public c(String str, String str2, a aVar) {
            this.a = str;
            this.b = str2;
        }
    }

    /* compiled from: SQLiteEventStore.java */
    /* loaded from: classes2.dex */
    public interface d<T> {
        T a();
    }

    public t(i0.h.a.a.i.u.a aVar, i0.h.a.a.i.u.a aVar2, d dVar, z zVar) {
        this.d = zVar;
        this.q = aVar;
        this.x = aVar2;
        this.y = dVar;
    }

    public static String k(Iterable<h> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<h> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(it.next().b());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public static <T> T l(Cursor cursor, b<Cursor, T> bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    @Override // i0.h.a.a.i.t.a
    public <T> T a(a.AbstractC0140a<T> aVar) {
        SQLiteDatabase b2 = b();
        i(new d(b2) { // from class: i0.h.a.a.i.s.i.m
            public final SQLiteDatabase a;

            {
                this.a = r1;
            }

            @Override // i0.h.a.a.i.s.i.t.d
            public Object a() {
                SQLiteDatabase sQLiteDatabase = this.a;
                b bVar = t.c;
                sQLiteDatabase.beginTransaction();
                return null;
            }
        }, n.a);
        try {
            T execute = aVar.execute();
            b2.setTransactionSuccessful();
            return execute;
        } finally {
            b2.endTransaction();
        }
    }

    public SQLiteDatabase b() {
        z zVar = this.d;
        zVar.getClass();
        return (SQLiteDatabase) i(new d(zVar) { // from class: i0.h.a.a.i.s.i.o
            public final z a;

            {
                this.a = r1;
            }

            @Override // i0.h.a.a.i.s.i.t.d
            public Object a() {
                return this.a.getWritableDatabase();
            }
        }, r.a);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.d.close();
    }

    public final Long e(SQLiteDatabase sQLiteDatabase, h hVar) {
        Long l;
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(hVar.b(), String.valueOf(i0.h.a.a.i.v.a.a(hVar.d()))));
        if (hVar.c() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(hVar.c(), 0));
        }
        Cursor query = sQLiteDatabase.query("transport_contexts", new String[]{InstabugDbContract.FeatureRequestEntry.COLUMN_ID}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null);
        try {
            if (!query.moveToNext()) {
                l = null;
            } else {
                l = Long.valueOf(query.getLong(0));
            }
            return l;
        } finally {
            query.close();
        }
    }

    public final <T> T f(b<SQLiteDatabase, T> bVar) {
        SQLiteDatabase b2 = b();
        b2.beginTransaction();
        try {
            T apply = bVar.apply(b2);
            b2.setTransactionSuccessful();
            return apply;
        } finally {
            b2.endTransaction();
        }
    }

    /* JADX WARN: Finally extract failed */
    @Override // i0.h.a.a.i.s.i.c
    public int g() {
        long a2 = this.q.a() - this.y.b();
        SQLiteDatabase b2 = b();
        b2.beginTransaction();
        try {
            Integer valueOf = Integer.valueOf(b2.delete("events", "timestamp_ms < ?", new String[]{String.valueOf(a2)}));
            b2.setTransactionSuccessful();
            b2.endTransaction();
            return valueOf.intValue();
        } catch (Throwable th) {
            b2.endTransaction();
            throw th;
        }
    }

    @Override // i0.h.a.a.i.s.i.c
    public void h(Iterable<h> iterable) {
        if (iterable.iterator().hasNext()) {
            StringBuilder P0 = i0.d.a.a.a.P0("DELETE FROM events WHERE _id in ");
            P0.append(k(iterable));
            b().compileStatement(P0.toString()).execute();
        }
    }

    public final <T> T i(d<T> dVar, b<Throwable, T> bVar) {
        long a2 = this.x.a();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e) {
                if (this.x.a() >= ((long) this.y.a()) + a2) {
                    return bVar.apply(e);
                }
                SystemClock.sleep(50);
            }
        }
    }

    @Override // i0.h.a.a.i.s.i.c
    public h j0(h hVar, EventInternal eventInternal) {
        v.T("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", hVar.d(), eventInternal.getTransportName(), hVar.b());
        long longValue = ((Long) f(new b(this, hVar, eventInternal) { // from class: i0.h.a.a.i.s.i.s
            public final t a;
            public final h b;
            public final EventInternal c;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // i0.h.a.a.i.s.i.t.b
            public Object apply(Object obj) {
                long j;
                t tVar = this.a;
                h hVar2 = this.b;
                EventInternal eventInternal2 = this.c;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                b bVar = t.c;
                if (tVar.b().compileStatement("PRAGMA page_size").simpleQueryForLong() * tVar.b().compileStatement("PRAGMA page_count").simpleQueryForLong() >= tVar.y.e()) {
                    return -1L;
                }
                Long e = tVar.e(sQLiteDatabase, hVar2);
                if (e != null) {
                    j = e.longValue();
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("backend_name", hVar2.b());
                    contentValues.put("priority", Integer.valueOf(i0.h.a.a.i.v.a.a(hVar2.d())));
                    contentValues.put("next_request_ms", (Integer) 0);
                    if (hVar2.c() != null) {
                        contentValues.put(NotificationCompat.MessagingStyle.Message.KEY_EXTRAS_BUNDLE, Base64.encodeToString(hVar2.c(), 0));
                    }
                    j = sQLiteDatabase.insert("transport_contexts", null, contentValues);
                }
                int d2 = tVar.y.d();
                byte[] bArr = eventInternal2.getEncodedPayload().b;
                boolean z = bArr.length <= d2;
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("context_id", Long.valueOf(j));
                contentValues2.put("transport_name", eventInternal2.getTransportName());
                contentValues2.put("timestamp_ms", Long.valueOf(eventInternal2.getEventMillis()));
                contentValues2.put("uptime_ms", Long.valueOf(eventInternal2.getUptimeMillis()));
                contentValues2.put("payload_encoding", eventInternal2.getEncodedPayload().a.a);
                contentValues2.put(PaymentMethodOptionsParams.Blik.PARAM_CODE, eventInternal2.getCode());
                contentValues2.put("num_attempts", (Integer) 0);
                contentValues2.put("inline", Boolean.valueOf(z));
                contentValues2.put("payload", z ? bArr : new byte[0]);
                long insert = sQLiteDatabase.insert("events", null, contentValues2);
                if (!z) {
                    int ceil = (int) Math.ceil(((double) bArr.length) / ((double) d2));
                    for (int i = 1; i <= ceil; i++) {
                        byte[] copyOfRange = Arrays.copyOfRange(bArr, (i - 1) * d2, Math.min(i * d2, bArr.length));
                        ContentValues contentValues3 = new ContentValues();
                        contentValues3.put("event_id", Long.valueOf(insert));
                        contentValues3.put("sequence_num", Integer.valueOf(i));
                        contentValues3.put("bytes", copyOfRange);
                        sQLiteDatabase.insert("event_payloads", null, contentValues3);
                    }
                }
                for (Map.Entry<String, String> entry : eventInternal2.getMetadata().entrySet()) {
                    ContentValues contentValues4 = new ContentValues();
                    contentValues4.put("event_id", Long.valueOf(insert));
                    contentValues4.put("name", entry.getKey());
                    contentValues4.put(InstabugDbContract.UserAttributesEntry.COLUMN_VALUE, entry.getValue());
                    sQLiteDatabase.insert("event_metadata", null, contentValues4);
                }
                return Long.valueOf(insert);
            }
        })).longValue();
        if (longValue < 1) {
            return null;
        }
        return new b(longValue, hVar, eventInternal);
    }

    /* JADX WARN: Finally extract failed */
    @Override // i0.h.a.a.i.s.i.c
    public long o0(h hVar) {
        Long l;
        Cursor rawQuery = b().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{hVar.b(), String.valueOf(i0.h.a.a.i.v.a.a(hVar.d()))});
        try {
            if (rawQuery.moveToNext()) {
                l = Long.valueOf(rawQuery.getLong(0));
            } else {
                l = 0L;
            }
            rawQuery.close();
            return l.longValue();
        } catch (Throwable th) {
            rawQuery.close();
            throw th;
        }
    }

    @Override // i0.h.a.a.i.s.i.c
    public Iterable<h> p(h hVar) {
        return (Iterable) f(new b(this, hVar) { // from class: i0.h.a.a.i.s.i.j
            public final t a;
            public final h b;

            {
                this.a = r1;
                this.b = r2;
            }

            /* JADX WARN: Finally extract failed */
            @Override // i0.h.a.a.i.s.i.t.b
            public Object apply(Object obj) {
                t tVar = this.a;
                h hVar2 = this.b;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                b bVar = t.c;
                Objects.requireNonNull(tVar);
                ArrayList arrayList = new ArrayList();
                Long e = tVar.e(sQLiteDatabase, hVar2);
                if (e != null) {
                    t.l(sQLiteDatabase.query("events", new String[]{InstabugDbContract.FeatureRequestEntry.COLUMN_ID, "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", PaymentMethodOptionsParams.Blik.PARAM_CODE, "inline"}, "context_id = ?", new String[]{e.toString()}, null, null, null, String.valueOf(tVar.y.c())), 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0050: INVOKE  
                          (wrap: android.database.Cursor : 0x0047: INVOKE  (r2v20 android.database.Cursor A[REMOVE]) = 
                          (r15v1 'sQLiteDatabase' android.database.sqlite.SQLiteDatabase)
                          ("events")
                          (wrap: java.lang.String[] : 0x0029: FILLED_NEW_ARRAY  (r4v8 java.lang.String[] A[REMOVE]) = 
                          (wrap: java.lang.String : ?: SGET   com.instabug.library.internal.storage.cache.db.InstabugDbContract.FeatureRequestEntry.COLUMN_ID java.lang.String)
                          ("transport_name")
                          ("timestamp_ms")
                          ("uptime_ms")
                          ("payload_encoding")
                          ("payload")
                          (wrap: java.lang.String : ?: SGET   com.stripe.android.model.PaymentMethodOptionsParams.Blik.PARAM_CODE java.lang.String)
                          ("inline")
                         elemType: java.lang.String)
                          ("context_id = ?")
                          (wrap: java.lang.String[] : ?: FILLED_NEW_ARRAY  (r6v2 java.lang.String[] A[REMOVE]) = 
                          (wrap: java.lang.String : 0x002f: INVOKE  (r2v1 'e' java.lang.Long) type: VIRTUAL call: java.lang.Long.toString():java.lang.String)
                         elemType: java.lang.String)
                          (null java.lang.String)
                          (null java.lang.String)
                          (null java.lang.String)
                          (wrap: java.lang.String : 0x003e: INVOKE  (r10v1 java.lang.String A[REMOVE]) = 
                          (wrap: int : 0x003a: INVOKE  (r2v18 int A[REMOVE]) = 
                          (wrap: i0.h.a.a.i.s.i.d : 0x0038: IGET  (r2v17 i0.h.a.a.i.s.i.d A[REMOVE]) = (r0v0 'tVar' i0.h.a.a.i.s.i.t) i0.h.a.a.i.s.i.t.y i0.h.a.a.i.s.i.d)
                         type: VIRTUAL call: i0.h.a.a.i.s.i.d.c():int)
                         type: STATIC call: java.lang.String.valueOf(int):java.lang.String)
                         type: VIRTUAL call: android.database.sqlite.SQLiteDatabase.query(java.lang.String, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String, java.lang.String, java.lang.String, java.lang.String):android.database.Cursor)
                          (wrap: i0.h.a.a.i.s.i.k : 0x004d: CONSTRUCTOR  (r3v20 i0.h.a.a.i.s.i.k A[REMOVE]) = (r0v0 'tVar' i0.h.a.a.i.s.i.t), (r11v0 'arrayList' java.util.ArrayList), (r1v0 'hVar2' i0.h.a.a.i.h) call: i0.h.a.a.i.s.i.k.<init>(i0.h.a.a.i.s.i.t, java.util.List, i0.h.a.a.i.h):void type: CONSTRUCTOR)
                         type: STATIC call: i0.h.a.a.i.s.i.t.l(android.database.Cursor, i0.h.a.a.i.s.i.t$b):java.lang.Object in method: i0.h.a.a.i.s.i.j.apply(java.lang.Object):java.lang.Object, file: classes2.dex
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
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:270)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: i0.h.a.a.i.s.i.k, state: NOT_LOADED
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
                        	... 21 more
                        */
                    /*
                    // Method dump skipped, instructions count: 320
                    */
                    throw new UnsupportedOperationException("Method not decompiled: i0.h.a.a.i.s.i.j.apply(java.lang.Object):java.lang.Object");
                }
            });
        }

        @Override // i0.h.a.a.i.s.i.c
        public void s(h hVar, long j) {
            f(new b(j, hVar) { // from class: i0.h.a.a.i.s.i.i
                public final long a;
                public final h b;

                {
                    this.a = r1;
                    this.b = r3;
                }

                @Override // i0.h.a.a.i.s.i.t.b
                public Object apply(Object obj) {
                    long j2 = this.a;
                    h hVar2 = this.b;
                    SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                    b bVar = t.c;
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("next_request_ms", Long.valueOf(j2));
                    if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{hVar2.b(), String.valueOf(i0.h.a.a.i.v.a.a(hVar2.d()))}) < 1) {
                        contentValues.put("backend_name", hVar2.b());
                        contentValues.put("priority", Integer.valueOf(i0.h.a.a.i.v.a.a(hVar2.d())));
                        sQLiteDatabase.insert("transport_contexts", null, contentValues);
                    }
                    return null;
                }
            });
        }

        /* JADX WARN: Finally extract failed */
        @Override // i0.h.a.a.i.s.i.c
        public boolean t0(h hVar) {
            Boolean bool;
            SQLiteDatabase b2 = b();
            b2.beginTransaction();
            try {
                Long e = e(b2, hVar);
                if (e == null) {
                    bool = Boolean.FALSE;
                } else {
                    bool = (Boolean) l(b().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{e.toString()}), q.a);
                }
                b2.setTransactionSuccessful();
                b2.endTransaction();
                return bool.booleanValue();
            } catch (Throwable th) {
                b2.endTransaction();
                throw th;
            }
        }

        @Override // i0.h.a.a.i.s.i.c
        public Iterable<h> x() {
            SQLiteDatabase b2 = b();
            b2.beginTransaction();
            try {
                List list = (List) l(b2.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), p.a);
                b2.setTransactionSuccessful();
                return list;
            } finally {
                b2.endTransaction();
            }
        }

        @Override // i0.h.a.a.i.s.i.c
        public void x0(Iterable<h> iterable) {
            if (iterable.iterator().hasNext()) {
                StringBuilder P0 = i0.d.a.a.a.P0("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in ");
                P0.append(k(iterable));
                String sb = P0.toString();
                SQLiteDatabase b2 = b();
                b2.beginTransaction();
                try {
                    b2.compileStatement(sb).execute();
                    b2.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
                    b2.setTransactionSuccessful();
                } finally {
                    b2.endTransaction();
                }
            }
        }
    }
