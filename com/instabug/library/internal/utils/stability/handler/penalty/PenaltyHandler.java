package com.instabug.library.internal.utils.stability.handler.penalty;
/* loaded from: classes2.dex */
public interface PenaltyHandler {
    int getPenaltyType();

    void handle(Exception exc);
}
