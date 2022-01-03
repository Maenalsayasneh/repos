package com.stripe.android.stripe3ds2.transaction;

import kotlin.Metadata;
/* compiled from: ChallengeFlowOutcome.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeFlowOutcome;", "", "<init>", "(Ljava/lang/String;I)V", "CompleteSuccessful", "CompleteUnsuccessful", "Cancel", "Timeout", "ProtocolError", "RuntimeError", "3ds2sdk_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public enum ChallengeFlowOutcome {
    CompleteSuccessful,
    CompleteUnsuccessful,
    Cancel,
    Timeout,
    ProtocolError,
    RuntimeError
}
