package com.instabug.library.internal.b;

import com.instabug.library.util.TimeUtils;
/* compiled from: RetentionContract.java */
@Deprecated
/* loaded from: classes2.dex */
public enum f {
    USER_DATA {
        private static final int PERIOD_IN_MONTHS = 6;

        @Override // com.instabug.library.internal.b.f
        public long a() {
            return 100;
        }

        @Override // com.instabug.library.internal.b.f
        public long b() {
            return TimeUtils.monthToMillis(6);
        }
    };
    
    public static final long VALUE_UNDEFINED = -1;

    public long a() {
        return -1;
    }

    public long b() {
        return -1;
    }
}
