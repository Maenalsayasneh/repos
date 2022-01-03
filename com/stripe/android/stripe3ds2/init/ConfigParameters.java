package com.stripe.android.stripe3ds2.init;

import com.stripe.android.stripe3ds2.exceptions.InvalidInputException;
import kotlin.Metadata;
/* compiled from: ConfigParameters.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J+\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lcom/stripe/android/stripe3ds2/init/ConfigParameters;", "", "", "groupName", "paramName", "paramValue", "Lm0/i;", "addParam", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getParamValue", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "removeParam", "3ds2sdk_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public interface ConfigParameters {
    void addParam(String str, String str2, String str3) throws InvalidInputException;

    String getParamValue(String str, String str2) throws InvalidInputException;

    String removeParam(String str, String str2) throws InvalidInputException;
}
