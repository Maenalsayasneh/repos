package com.instabug.library.util;

import androidx.annotation.Keep;
import java.util.concurrent.TimeUnit;
@Keep
/* loaded from: classes2.dex */
public final class TimeUtils {
    public static final long DAY_MILLIS = TimeUnit.DAYS.toMillis(1);

    private TimeUtils() {
    }

    public static long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static long currentTimeSeconds() {
        return System.currentTimeMillis() / 1000;
    }

    public static long elapsedTimeMillis(long j, long j2, TimeUnit timeUnit) {
        return timeUnit.toMillis(j2) - timeUnit.toMillis(j);
    }

    public static long monthToDays(int i) {
        return TimeUnit.DAYS.toDays(((long) i) * 30);
    }

    public static long monthToHours(int i) {
        return TimeUnit.DAYS.toHours(((long) i) * 30);
    }

    public static long monthToMillis(int i) {
        return TimeUnit.DAYS.toMillis(((long) i) * 30);
    }
}
