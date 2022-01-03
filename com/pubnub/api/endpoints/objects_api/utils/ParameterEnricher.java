package com.pubnub.api.endpoints.objects_api.utils;

import com.pubnub.api.PubNubException;
import java.util.Map;
/* loaded from: classes2.dex */
public interface ParameterEnricher {
    Map<String, String> enrichParameters(Map<String, String> map);

    default void validateParameters() throws PubNubException {
    }
}
