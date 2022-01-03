package kotlin.reflect.jvm.internal.impl.load.java;

import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.pubnub.api.PubNubUtil;
import i0.j.f.p.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import m0.j.g;
import m0.n.b.f;
import m0.n.b.i;
import m0.r.t.a.r.g.d;
/* compiled from: SpecialGenericSignatures.kt */
/* loaded from: classes4.dex */
public class SpecialGenericSignatures {
    public static final a a = new a(null);
    public static final List<a.C0239a> b;
    public static final List<String> c;
    public static final Map<a.C0239a, TypeSafeBarrierDescription> d;
    public static final Map<String, TypeSafeBarrierDescription> e;
    public static final Set<d> f;
    public static final Set<String> g;
    public static final a.C0239a h;
    public static final Map<a.C0239a, d> i;
    public static final Map<String, d> j;
    public static final List<d> k;
    public static final Map<d, List<d>> l;

    /* compiled from: SpecialGenericSignatures.kt */
    /* loaded from: classes4.dex */
    public enum SpecialSignatureInfo {
        ONE_COLLECTION_PARAMETER("Ljava/util/Collection<+Ljava/lang/Object;>;", false),
        OBJECT_PARAMETER_NON_GENERIC(null, true),
        OBJECT_PARAMETER_GENERIC("Ljava/lang/Object;", true);
        
        private final boolean isObjectReplacedWithTypeParameter;
        private final String valueParametersSignature;

        SpecialSignatureInfo(String str, boolean z) {
            this.valueParametersSignature = str;
            this.isObjectReplacedWithTypeParameter = z;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: SpecialGenericSignatures.kt */
    /* loaded from: classes4.dex */
    public static final class TypeSafeBarrierDescription extends Enum<TypeSafeBarrierDescription> {
        private static final /* synthetic */ TypeSafeBarrierDescription[] $VALUES;
        public static final TypeSafeBarrierDescription FALSE;
        public static final TypeSafeBarrierDescription INDEX;
        public static final TypeSafeBarrierDescription MAP_GET_OR_DEFAULT;
        public static final TypeSafeBarrierDescription NULL;
        private final Object defaultValue;

        /* compiled from: SpecialGenericSignatures.kt */
        /* loaded from: classes4.dex */
        public static final class MAP_GET_OR_DEFAULT extends TypeSafeBarrierDescription {
            public MAP_GET_OR_DEFAULT(String str, int i) {
                super(str, i, null, null);
            }
        }

        static {
            TypeSafeBarrierDescription typeSafeBarrierDescription = new TypeSafeBarrierDescription("NULL", 0, null);
            NULL = typeSafeBarrierDescription;
            TypeSafeBarrierDescription typeSafeBarrierDescription2 = new TypeSafeBarrierDescription("INDEX", 1, -1);
            INDEX = typeSafeBarrierDescription2;
            TypeSafeBarrierDescription typeSafeBarrierDescription3 = new TypeSafeBarrierDescription("FALSE", 2, Boolean.FALSE);
            FALSE = typeSafeBarrierDescription3;
            MAP_GET_OR_DEFAULT map_get_or_default = new MAP_GET_OR_DEFAULT("MAP_GET_OR_DEFAULT", 3);
            MAP_GET_OR_DEFAULT = map_get_or_default;
            $VALUES = new TypeSafeBarrierDescription[]{typeSafeBarrierDescription, typeSafeBarrierDescription2, typeSafeBarrierDescription3, map_get_or_default};
        }

        private TypeSafeBarrierDescription(String str, int i, Object obj) {
            this.defaultValue = obj;
        }

        public /* synthetic */ TypeSafeBarrierDescription(String str, int i, Object obj, f fVar) {
            this(str, i, obj);
        }

        public static TypeSafeBarrierDescription valueOf(String str) {
            i.e(str, InstabugDbContract.UserAttributesEntry.COLUMN_VALUE);
            return (TypeSafeBarrierDescription) Enum.valueOf(TypeSafeBarrierDescription.class, str);
        }

        public static TypeSafeBarrierDescription[] values() {
            TypeSafeBarrierDescription[] typeSafeBarrierDescriptionArr = $VALUES;
            TypeSafeBarrierDescription[] typeSafeBarrierDescriptionArr2 = new TypeSafeBarrierDescription[typeSafeBarrierDescriptionArr.length];
            System.arraycopy(typeSafeBarrierDescriptionArr, 0, typeSafeBarrierDescriptionArr2, 0, typeSafeBarrierDescriptionArr.length);
            return typeSafeBarrierDescriptionArr2;
        }
    }

    /* compiled from: SpecialGenericSignatures.kt */
    /* loaded from: classes4.dex */
    public static final class a {

        /* compiled from: SpecialGenericSignatures.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C0239a {
            public final d a;
            public final String b;

            public C0239a(d dVar, String str) {
                i.e(dVar, "name");
                i.e(str, PubNubUtil.SIGNATURE_QUERY_PARAM_NAME);
                this.a = dVar;
                this.b = str;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0239a)) {
                    return false;
                }
                C0239a aVar = (C0239a) obj;
                return i.a(this.a, aVar.a) && i.a(this.b, aVar.b);
            }

            public int hashCode() {
                return this.b.hashCode() + (this.a.hashCode() * 31);
            }

            public String toString() {
                StringBuilder P0 = i0.d.a.a.a.P0("NameAndSignature(name=");
                P0.append(this.a);
                P0.append(", signature=");
                return i0.d.a.a.a.x0(P0, this.b, ')');
            }
        }

        public a(f fVar) {
        }

        public static final C0239a a(a aVar, String str, String str2, String str3, String str4) {
            Objects.requireNonNull(aVar);
            d g = d.g(str2);
            i.d(g, "identifier(name)");
            String str5 = str2 + '(' + str3 + ')' + str4;
            i.e(str, "internalName");
            i.e(str5, "jvmDescriptor");
            return new C0239a(g, str + '.' + str5);
        }
    }

    static {
        Set<String> h02 = g.h0("containsAll", "removeAll", "retainAll");
        ArrayList arrayList = new ArrayList(h.K(h02, 10));
        for (String str : h02) {
            a aVar = a;
            String desc = JvmPrimitiveType.BOOLEAN.getDesc();
            i.d(desc, "BOOLEAN.desc");
            arrayList.add(a.a(aVar, "java/util/Collection", str, "Ljava/util/Collection;", desc));
        }
        b = arrayList;
        ArrayList arrayList2 = new ArrayList(h.K(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((a.C0239a) it.next()).b);
        }
        c = arrayList2;
        List<a.C0239a> list = b;
        ArrayList arrayList3 = new ArrayList(h.K(list, 10));
        for (a.C0239a aVar2 : list) {
            arrayList3.add(aVar2.a.b());
        }
        a aVar3 = a;
        i.e("Collection", "name");
        String k2 = i.k("java/util/", "Collection");
        JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.BOOLEAN;
        String desc2 = jvmPrimitiveType.getDesc();
        i.d(desc2, "BOOLEAN.desc");
        a.C0239a a2 = a.a(aVar3, k2, "contains", "Ljava/lang/Object;", desc2);
        TypeSafeBarrierDescription typeSafeBarrierDescription = TypeSafeBarrierDescription.FALSE;
        i.e("Collection", "name");
        String k3 = i.k("java/util/", "Collection");
        String desc3 = jvmPrimitiveType.getDesc();
        i.d(desc3, "BOOLEAN.desc");
        i.e("Map", "name");
        String k4 = i.k("java/util/", "Map");
        String desc4 = jvmPrimitiveType.getDesc();
        i.d(desc4, "BOOLEAN.desc");
        i.e("Map", "name");
        String k5 = i.k("java/util/", "Map");
        String desc5 = jvmPrimitiveType.getDesc();
        i.d(desc5, "BOOLEAN.desc");
        i.e("Map", "name");
        String k6 = i.k("java/util/", "Map");
        String desc6 = jvmPrimitiveType.getDesc();
        i.d(desc6, "BOOLEAN.desc");
        i.e("Map", "name");
        i.e("Map", "name");
        a.C0239a a3 = a.a(aVar3, i.k("java/util/", "Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;");
        TypeSafeBarrierDescription typeSafeBarrierDescription2 = TypeSafeBarrierDescription.NULL;
        i.e("Map", "name");
        i.e("List", "name");
        String k7 = i.k("java/util/", "List");
        JvmPrimitiveType jvmPrimitiveType2 = JvmPrimitiveType.INT;
        String desc7 = jvmPrimitiveType2.getDesc();
        i.d(desc7, "INT.desc");
        a.C0239a a4 = a.a(aVar3, k7, "indexOf", "Ljava/lang/Object;", desc7);
        TypeSafeBarrierDescription typeSafeBarrierDescription3 = TypeSafeBarrierDescription.INDEX;
        i.e("List", "name");
        String k8 = i.k("java/util/", "List");
        String desc8 = jvmPrimitiveType2.getDesc();
        i.d(desc8, "INT.desc");
        Map<a.C0239a, TypeSafeBarrierDescription> N = g.N(new Pair(a2, typeSafeBarrierDescription), new Pair(a.a(aVar3, k3, "remove", "Ljava/lang/Object;", desc3), typeSafeBarrierDescription), new Pair(a.a(aVar3, k4, "containsKey", "Ljava/lang/Object;", desc4), typeSafeBarrierDescription), new Pair(a.a(aVar3, k5, "containsValue", "Ljava/lang/Object;", desc5), typeSafeBarrierDescription), new Pair(a.a(aVar3, k6, "remove", "Ljava/lang/Object;Ljava/lang/Object;", desc6), typeSafeBarrierDescription), new Pair(a.a(aVar3, i.k("java/util/", "Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.MAP_GET_OR_DEFAULT), new Pair(a3, typeSafeBarrierDescription2), new Pair(a.a(aVar3, i.k("java/util/", "Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), typeSafeBarrierDescription2), new Pair(a4, typeSafeBarrierDescription3), new Pair(a.a(aVar3, k8, "lastIndexOf", "Ljava/lang/Object;", desc8), typeSafeBarrierDescription3));
        d = N;
        LinkedHashMap linkedHashMap = new LinkedHashMap(h.R2(N.size()));
        Iterator<T> it2 = N.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            linkedHashMap.put(((a.C0239a) entry.getKey()).b, entry.getValue());
        }
        e = linkedHashMap;
        Set<a.C0239a> d0 = g.d0(d.keySet(), b);
        ArrayList arrayList4 = new ArrayList(h.K(d0, 10));
        for (a.C0239a aVar4 : d0) {
            arrayList4.add(aVar4.a);
        }
        f = g.D0(arrayList4);
        ArrayList arrayList5 = new ArrayList(h.K(d0, 10));
        for (a.C0239a aVar5 : d0) {
            arrayList5.add(aVar5.b);
        }
        g = g.D0(arrayList5);
        a aVar6 = a;
        JvmPrimitiveType jvmPrimitiveType3 = JvmPrimitiveType.INT;
        String desc9 = jvmPrimitiveType3.getDesc();
        i.d(desc9, "INT.desc");
        a.C0239a a5 = a.a(aVar6, "java/util/List", "removeAt", desc9, "Ljava/lang/Object;");
        h = a5;
        i.e("Number", "name");
        String k9 = i.k("java/lang/", "Number");
        String desc10 = JvmPrimitiveType.BYTE.getDesc();
        i.d(desc10, "BYTE.desc");
        i.e("Number", "name");
        String k10 = i.k("java/lang/", "Number");
        String desc11 = JvmPrimitiveType.SHORT.getDesc();
        i.d(desc11, "SHORT.desc");
        i.e("Number", "name");
        String k11 = i.k("java/lang/", "Number");
        String desc12 = jvmPrimitiveType3.getDesc();
        i.d(desc12, "INT.desc");
        i.e("Number", "name");
        String k12 = i.k("java/lang/", "Number");
        String desc13 = JvmPrimitiveType.LONG.getDesc();
        i.d(desc13, "LONG.desc");
        i.e("Number", "name");
        String k13 = i.k("java/lang/", "Number");
        String desc14 = JvmPrimitiveType.FLOAT.getDesc();
        i.d(desc14, "FLOAT.desc");
        i.e("Number", "name");
        String k14 = i.k("java/lang/", "Number");
        String desc15 = JvmPrimitiveType.DOUBLE.getDesc();
        i.d(desc15, "DOUBLE.desc");
        i.e("CharSequence", "name");
        String k15 = i.k("java/lang/", "CharSequence");
        String desc16 = jvmPrimitiveType3.getDesc();
        i.d(desc16, "INT.desc");
        String desc17 = JvmPrimitiveType.CHAR.getDesc();
        i.d(desc17, "CHAR.desc");
        Map<a.C0239a, d> N2 = g.N(new Pair(a.a(aVar6, k9, "toByte", "", desc10), d.g("byteValue")), new Pair(a.a(aVar6, k10, "toShort", "", desc11), d.g("shortValue")), new Pair(a.a(aVar6, k11, "toInt", "", desc12), d.g("intValue")), new Pair(a.a(aVar6, k12, "toLong", "", desc13), d.g("longValue")), new Pair(a.a(aVar6, k13, "toFloat", "", desc14), d.g("floatValue")), new Pair(a.a(aVar6, k14, "toDouble", "", desc15), d.g("doubleValue")), new Pair(a5, d.g("remove")), new Pair(a.a(aVar6, k15, "get", desc16, desc17), d.g("charAt")));
        i = N2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(h.R2(N2.size()));
        Iterator<T> it3 = N2.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it3.next();
            linkedHashMap2.put(((a.C0239a) entry2.getKey()).b, entry2.getValue());
        }
        j = linkedHashMap2;
        Set<a.C0239a> keySet = i.keySet();
        ArrayList arrayList6 = new ArrayList(h.K(keySet, 10));
        for (a.C0239a aVar7 : keySet) {
            arrayList6.add(aVar7.a);
        }
        k = arrayList6;
        Set<Map.Entry<a.C0239a, d>> entrySet = i.entrySet();
        ArrayList arrayList7 = new ArrayList(h.K(entrySet, 10));
        Iterator<T> it4 = entrySet.iterator();
        while (it4.hasNext()) {
            Map.Entry entry3 = (Map.Entry) it4.next();
            arrayList7.add(new Pair(((a.C0239a) entry3.getKey()).a, entry3.getValue()));
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        Iterator it5 = arrayList7.iterator();
        while (it5.hasNext()) {
            Pair pair = (Pair) it5.next();
            d dVar = (d) pair.d;
            Object obj = linkedHashMap3.get(dVar);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap3.put(dVar, obj);
            }
            ((List) obj).add((d) pair.c);
        }
        l = linkedHashMap3;
    }
}
