package s0.a.f.b.h;

import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class v extends ObjectInputStream {
    public static final Set c;
    public final Class d;
    public boolean q = false;

    static {
        HashSet hashSet = new HashSet();
        c = hashSet;
        hashSet.add("java.util.TreeMap");
        hashSet.add("java.lang.Integer");
        hashSet.add("java.lang.Number");
        hashSet.add("org.bouncycastle.pqc.crypto.xmss.BDS");
        hashSet.add("java.util.ArrayList");
        hashSet.add("org.bouncycastle.pqc.crypto.xmss.XMSSNode");
        hashSet.add("[B");
        hashSet.add("java.util.LinkedList");
        hashSet.add("java.util.Stack");
        hashSet.add("java.util.Vector");
        hashSet.add("[Ljava.lang.Object;");
        hashSet.add("org.bouncycastle.pqc.crypto.xmss.BDSTreeHash");
    }

    public v(Class cls, InputStream inputStream) throws IOException {
        super(inputStream);
        this.d = cls;
    }

    @Override // java.io.ObjectInputStream
    public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws IOException, ClassNotFoundException {
        if (!this.q) {
            if (objectStreamClass.getName().equals(this.d.getName())) {
                this.q = true;
            } else {
                throw new InvalidClassException("unexpected class: ", objectStreamClass.getName());
            }
        } else if (!c.contains(objectStreamClass.getName())) {
            throw new InvalidClassException("unexpected class: ", objectStreamClass.getName());
        }
        return super.resolveClass(objectStreamClass);
    }
}
