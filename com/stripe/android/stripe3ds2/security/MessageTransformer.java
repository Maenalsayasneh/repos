package com.stripe.android.stripe3ds2.security;

import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.nimbusds.jose.JOSEException;
import com.stripe.android.stripe3ds2.transactions.ChallengeResponseParseException;
import java.io.Serializable;
import java.text.ParseException;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: MessageTransformer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stripe/android/stripe3ds2/security/MessageTransformer;", "Ljava/io/Serializable;", "Lorg/json/JSONObject;", "challengeRequest", "Ljavax/crypto/SecretKey;", "secretKey", "", "encrypt", "(Lorg/json/JSONObject;Ljavax/crypto/SecretKey;)Ljava/lang/String;", InstabugDbContract.BugEntry.COLUMN_MESSAGE, "decrypt", "(Ljava/lang/String;Ljavax/crypto/SecretKey;)Lorg/json/JSONObject;", "3ds2sdk_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public interface MessageTransformer extends Serializable {
    JSONObject decrypt(String str, SecretKey secretKey) throws ParseException, JOSEException, JSONException, ChallengeResponseParseException;

    String encrypt(JSONObject jSONObject, SecretKey secretKey) throws JSONException, JOSEException;
}
