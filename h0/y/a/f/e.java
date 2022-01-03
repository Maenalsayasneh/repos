package h0.y.a.f;

import android.database.sqlite.SQLiteProgram;
import h0.y.a.d;
/* compiled from: FrameworkSQLiteProgram.java */
/* loaded from: classes.dex */
public class e implements d {
    public final SQLiteProgram c;

    public e(SQLiteProgram sQLiteProgram) {
        this.c = sQLiteProgram;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.c.close();
    }
}
