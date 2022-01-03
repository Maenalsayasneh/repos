package androidx.work.impl;

import androidx.room.RoomDatabase;
import h0.g0.r.s.b;
import h0.g0.r.s.e;
import h0.g0.r.s.h;
import h0.g0.r.s.k;
import h0.g0.r.s.m;
import h0.g0.r.s.p;
import h0.g0.r.s.s;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public abstract class WorkDatabase extends RoomDatabase {
    public static final long j = TimeUnit.DAYS.toMillis(1);
    public static final /* synthetic */ int k = 0;

    public abstract b l();

    public abstract e m();

    public abstract h n();

    public abstract k o();

    public abstract m p();

    public abstract p q();

    public abstract s r();
}
