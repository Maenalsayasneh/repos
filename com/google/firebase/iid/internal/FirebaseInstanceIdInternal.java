package com.google.firebase.iid.internal;

import i0.h.a.b.m.g;
import java.io.IOException;
/* compiled from: com.google.firebase:firebase-iid-interop@@17.1.0 */
/* loaded from: classes2.dex */
public interface FirebaseInstanceIdInternal {

    /* compiled from: com.google.firebase:firebase-iid-interop@@17.1.0 */
    /* loaded from: classes2.dex */
    public interface a {
        void a(String str);
    }

    void addNewTokenListener(a aVar);

    void deleteToken(String str, String str2) throws IOException;

    String getId();

    String getToken();

    g<String> getTokenTask();
}
