package i0.h.a.a.i.s.i;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Arrays;
import java.util.List;
/* compiled from: SchemaManager.java */
/* loaded from: classes2.dex */
public final class z extends SQLiteOpenHelper {
    public static final List<a> c = Arrays.asList(v.a, w.a, x.a, y.a);
    public final int d;
    public boolean q = false;

    /* compiled from: SchemaManager.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a(SQLiteDatabase sQLiteDatabase);
    }

    public z(Context context, String str, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.d = i;
    }

    public final void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        List<a> list = c;
        if (i2 <= list.size()) {
            while (i < i2) {
                c.get(i).a(sQLiteDatabase);
                i++;
            }
            return;
        }
        StringBuilder R0 = i0.d.a.a.a.R0("Migration from ", i, " to ", i2, " was requested, but cannot be performed. Only ");
        R0.append(list.size());
        R0.append(" migrations are provided");
        throw new IllegalArgumentException(R0.toString());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.q = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        int i = this.d;
        if (!this.q) {
            onConfigure(sQLiteDatabase);
        }
        a(sQLiteDatabase, 0, i);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        i0.d.a.a.a.h(sQLiteDatabase, "DROP TABLE events", "DROP TABLE event_metadata", "DROP TABLE transport_contexts", "DROP TABLE IF EXISTS event_payloads");
        if (!this.q) {
            onConfigure(sQLiteDatabase);
        }
        a(sQLiteDatabase, 0, i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        if (!this.q) {
            onConfigure(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (!this.q) {
            onConfigure(sQLiteDatabase);
        }
        a(sQLiteDatabase, i, i2);
    }
}
