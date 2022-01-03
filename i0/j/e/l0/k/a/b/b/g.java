package i0.j.e.l0.k.a.b.b;

import android.database.sqlite.SQLiteDatabase;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
/* compiled from: Migration_18_19.java */
/* loaded from: classes2.dex */
public class g implements b {
    @Override // i0.j.e.l0.k.a.b.b.b
    public void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS session_table_temp ( session_id TEXT,started_at INTEGER,duration INTEGER,user_events TEXT,user_attributes TEXT,user_events_keys TEXT,user_attributes_keys TEXT,user_email TEXT,uuid TEXT,user_name TEXT,os TEXT,app_token TEXT,device TEXT,sdk_version TEXT,app_version TEXT,crash_reporting_enabled INTEGER,users_page_enabled INTEGER,sync_status INTEGER )");
        sQLiteDatabase.execSQL("INSERT INTO session_table_temp SELECT session_id,started_at,duration,user_events,user_attributes,user_events_keys,user_attributes_keys,user_email,uuid,user_name,os,app_token,device,sdk_version,app_version,crash_reporting_enabled,users_page_enabled,sync_status FROM " + InstabugDbContract.SessionEntry.TABLE_NAME);
        sQLiteDatabase.execSQL(InstabugDbContract.SessionEntry.DROP_TABLE);
        sQLiteDatabase.execSQL("ALTER TABLE session_table_temp RENAME TO session_table");
    }
}
