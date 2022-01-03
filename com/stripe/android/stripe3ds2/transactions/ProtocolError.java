package com.stripe.android.stripe3ds2.transactions;

import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.stripe.android.model.PaymentMethodOptionsParams;
import kotlin.Metadata;
/* compiled from: ProtocolError.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/stripe/android/stripe3ds2/transactions/ProtocolError;", "", "", InstabugDbContract.FeatureRequestEntry.COLUMN_DESCRIPTION, "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "", PaymentMethodOptionsParams.Blik.PARAM_CODE, "I", "getCode", "()I", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "InvalidMessageReceived", "UnsupportedMessageVersion", "RequiredDataElementMissing", "UnrecognizedCriticalMessageExtensions", "InvalidDataElementFormat", "InvalidTransactionId", "DataDecryptionFailure", "TransactionTimedout", "3ds2sdk_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public enum ProtocolError {
    InvalidMessageReceived(101, "Message is not AReq, ARes, CReq, CRes, PReq, PRes, RReq, or RRes"),
    UnsupportedMessageVersion(102, "Message Version Number received is not valid for the receiving component."),
    RequiredDataElementMissing(201, "A message element required as defined in Table A.1 is missing from the message."),
    UnrecognizedCriticalMessageExtensions(202, "Critical message extension not recognised."),
    InvalidDataElementFormat(203, "Data element not in the required format or value is invalid as defined in Table A.1"),
    InvalidTransactionId(301, "Transaction ID received is not valid for the receiving component."),
    DataDecryptionFailure(302, "Data could not be decrypted by the receiving system due to technical or other reason."),
    TransactionTimedout(402, "Transaction timed-out.");
    
    private final int code;
    private final String description;

    ProtocolError(int i, String str) {
        this.code = i;
        this.description = str;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getDescription() {
        return this.description;
    }
}
