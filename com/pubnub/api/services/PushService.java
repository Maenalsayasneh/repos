package com.pubnub.api.services;

import java.util.List;
import java.util.Map;
import t0.c0.f;
import t0.c0.s;
import t0.c0.u;
import t0.d;
/* loaded from: classes2.dex */
public interface PushService {
    @f("v1/push/sub-key/{subKey}/devices/{pushToken}")
    d<List<String>> listChannelsForDevice(@s("subKey") String str, @s("pushToken") String str2, @u Map<String, String> map);

    @f("v2/push/sub-key/{subKey}/devices-apns2/{deviceApns2}")
    d<List<String>> listChannelsForDeviceApns2(@s("subKey") String str, @s("deviceApns2") String str2, @u Map<String, String> map);

    @f("v1/push/sub-key/{subKey}/devices/{pushToken}")
    d<List<Object>> modifyChannelsForDevice(@s("subKey") String str, @s("pushToken") String str2, @u Map<String, String> map);

    @f("v2/push/sub-key/{subKey}/devices-apns2/{deviceApns2}")
    d<List<Object>> modifyChannelsForDeviceApns2(@s("subKey") String str, @s("deviceApns2") String str2, @u Map<String, String> map);

    @f("v1/push/sub-key/{subKey}/devices/{pushToken}/remove")
    d<List<Object>> removeAllChannelsForDevice(@s("subKey") String str, @s("pushToken") String str2, @u Map<String, String> map);

    @f("v2/push/sub-key/{subKey}/devices-apns2/{deviceApns2}/remove")
    d<List<Object>> removeAllChannelsForDeviceApns2(@s("subKey") String str, @s("deviceApns2") String str2, @u Map<String, String> map);
}
