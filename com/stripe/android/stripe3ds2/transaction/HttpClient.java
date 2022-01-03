package com.stripe.android.stripe3ds2.transaction;

import com.stripe.android.stripe3ds2.exceptions.SDKRuntimeException;
import java.io.InputStream;
import kotlin.Metadata;
import m0.l.c;
/* compiled from: HttpClient.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/HttpClient;", "", "Ljava/io/InputStream;", "doGetRequest", "(Lm0/l/c;)Ljava/lang/Object;", "", "requestBody", "contentType", "Lcom/stripe/android/stripe3ds2/transaction/HttpResponse;", "doPostRequest", "(Ljava/lang/String;Ljava/lang/String;Lm0/l/c;)Ljava/lang/Object;", "3ds2sdk_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public interface HttpClient {
    Object doGetRequest(c<? super InputStream> cVar);

    Object doPostRequest(String str, String str2, c<? super HttpResponse> cVar) throws SDKRuntimeException;
}
