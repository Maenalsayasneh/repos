package com.instabug.library.model.common;
/* loaded from: classes2.dex */
public interface Session {
    String getAppVersion();

    String getId();

    String getOs();

    long getStartNanoTime();

    long getStartTimestampMicros();

    String getUuid();
}
