package org.bouncycastle.jcajce.provider.config;

import java.util.Map;
import org.bouncycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import s0.a.a.n;
/* loaded from: classes4.dex */
public interface ConfigurableProvider {
    public static final String ACCEPTABLE_EC_CURVES = "acceptableEcCurves";
    public static final String ADDITIONAL_EC_PARAMETERS = "additionalEcParameters";
    public static final String DH_DEFAULT_PARAMS = "DhDefaultParams";
    public static final String EC_IMPLICITLY_CA = "ecImplicitlyCa";
    public static final String THREAD_LOCAL_DH_DEFAULT_PARAMS = "threadLocalDhDefaultParams";
    public static final String THREAD_LOCAL_EC_IMPLICITLY_CA = "threadLocalEcImplicitlyCa";

    void addAlgorithm(String str, String str2);

    void addAlgorithm(String str, n nVar, String str2);

    void addAttributes(String str, Map<String, String> map);

    void addKeyInfoConverter(n nVar, AsymmetricKeyInfoConverter asymmetricKeyInfoConverter);

    AsymmetricKeyInfoConverter getKeyInfoConverter(n nVar);

    boolean hasAlgorithm(String str, String str2);

    void setParameter(String str, Object obj);
}
