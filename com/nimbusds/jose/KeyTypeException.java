package com.nimbusds.jose;

import java.security.Key;
/* loaded from: classes2.dex */
public class KeyTypeException extends KeyException {
    public KeyTypeException(Class<? extends Key> cls) {
        super("Invalid key: Must be an instance of " + cls);
    }
}
