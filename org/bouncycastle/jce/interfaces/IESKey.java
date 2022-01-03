package org.bouncycastle.jce.interfaces;

import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
/* loaded from: classes4.dex */
public interface IESKey extends Key {
    PublicKey K();

    PrivateKey S();
}
