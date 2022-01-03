package org.bouncycastle.crypto;

import java.security.Permission;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class CryptoServicesPermission extends Permission {
    public final Set<String> c;

    public CryptoServicesPermission(String str) {
        super(str);
        HashSet hashSet = new HashSet();
        this.c = hashSet;
        hashSet.add(str);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        return (obj instanceof CryptoServicesPermission) && this.c.equals(((CryptoServicesPermission) obj).c);
    }

    @Override // java.security.Permission
    public String getActions() {
        return this.c.toString();
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.c.hashCode();
    }

    @Override // java.security.Permission
    public boolean implies(Permission permission) {
        if (!(permission instanceof CryptoServicesPermission)) {
            return false;
        }
        CryptoServicesPermission cryptoServicesPermission = (CryptoServicesPermission) permission;
        return getName().equals(cryptoServicesPermission.getName()) || this.c.containsAll(cryptoServicesPermission.c);
    }
}
