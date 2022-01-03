package com.pubnub.api.services;

import java.util.List;
import java.util.Map;
import t0.c0.a;
import t0.c0.f;
import t0.c0.k;
import t0.c0.o;
import t0.c0.s;
import t0.c0.u;
import t0.d;
/* loaded from: classes2.dex */
public interface PublishService {
    @f("publish/{pubKey}/{subKey}/0/{channel}/0/{message}")
    d<List<Object>> publish(@s("pubKey") String str, @s("subKey") String str2, @s("channel") String str3, @s(encoded = true, value = "message") String str4, @u(encoded = true) Map<String, String> map);

    @k({"Content-Type: application/json; charset=UTF-8"})
    @o("publish/{pubKey}/{subKey}/0/{channel}/0")
    d<List<Object>> publishWithPost(@s("pubKey") String str, @s("subKey") String str2, @s("channel") String str3, @a Object obj, @u(encoded = true) Map<String, String> map);
}
