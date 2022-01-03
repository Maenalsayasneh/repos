package m0.j;

import com.google.android.gms.recaptcha.RecaptchaActionType;
import i0.j.f.p.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt$elementAt$1;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.collections.EmptySet;
import m0.n.a.l;
import m0.n.b.i;
import m0.n.b.r;
import m0.n.b.s.b;
import m0.q.e;
import m0.r.t.a.r.m.a1.a;
/* compiled from: _ArraysJvm.kt */
/* loaded from: classes4.dex */
public class g extends e {
    public static final <K, V> V A(Map<K, ? extends V> map, K k) {
        i.e(map, "$this$getValue");
        i.e(map, "$this$getOrImplicitDefault");
        if (map instanceof q) {
            return (V) ((q) map).e(k);
        }
        V v = (V) map.get(k);
        if (v != null || map.containsKey(k)) {
            return v;
        }
        throw new NoSuchElementException("Key " + k + " is missing in the map.");
    }

    public static final <T> List<T> A0(Collection<? extends T> collection) {
        i.e(collection, "$this$toMutableList");
        return new ArrayList(collection);
    }

    public static final <T, A extends Appendable> A B(Iterable<? extends T> iterable, A a, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, l<? super T, ? extends CharSequence> lVar) {
        i.e(iterable, "$this$joinTo");
        i.e(a, "buffer");
        i.e(charSequence, "separator");
        i.e(charSequence2, "prefix");
        i.e(charSequence3, "postfix");
        i.e(charSequence4, "truncated");
        a.append(charSequence2);
        int i2 = 0;
        for (Object obj : iterable) {
            i2++;
            if (i2 > 1) {
                a.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            a.O(a, obj, lVar);
        }
        if (i >= 0 && i2 > i) {
            a.append(charSequence4);
        }
        a.append(charSequence3);
        return a;
    }

    public static final <K, V> Map<K, V> B0(Map<? extends K, ? extends V> map) {
        i.e(map, "$this$toMutableMap");
        return new LinkedHashMap(map);
    }

    public static /* synthetic */ Appendable C(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, l lVar, int i2) {
        B(iterable, appendable, (i2 & 2) != 0 ? ", " : charSequence, (i2 & 4) != 0 ? "" : charSequence2, (i2 & 8) != 0 ? "" : charSequence3, (i2 & 16) != 0 ? -1 : i, (i2 & 32) != 0 ? "..." : null, (i2 & 64) != 0 ? null : lVar);
        return appendable;
    }

    public static final <T> Set<T> C0(Iterable<? extends T> iterable) {
        i.e(iterable, "$this$toMutableSet");
        if (iterable instanceof Collection) {
            return new LinkedHashSet((Collection) iterable);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        s0(iterable, linkedHashSet);
        return linkedHashSet;
    }

    public static final <T> String D(Iterable<? extends T> iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, l<? super T, ? extends CharSequence> lVar) {
        i.e(iterable, "$this$joinToString");
        i.e(charSequence, "separator");
        i.e(charSequence2, "prefix");
        i.e(charSequence3, "postfix");
        i.e(charSequence4, "truncated");
        StringBuilder sb = new StringBuilder();
        B(iterable, sb, charSequence, charSequence2, charSequence3, i, charSequence4, lVar);
        String sb2 = sb.toString();
        i.d(sb2, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb2;
    }

    public static final <T> Set<T> D0(Iterable<? extends T> iterable) {
        i.e(iterable, "$this$toSet");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return EmptySet.c;
            }
            if (size != 1) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(h.R2(collection.size()));
                s0(iterable, linkedHashSet);
                return linkedHashSet;
            }
            return h.N3(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        s0(iterable, linkedHashSet2);
        LinkedHashSet linkedHashSet3 = linkedHashSet2;
        i.e(linkedHashSet3, "$this$optimizeReadOnlySet");
        int size2 = linkedHashSet3.size();
        if (size2 == 0) {
            return EmptySet.c;
        }
        if (size2 != 1) {
            return linkedHashSet3;
        }
        return h.N3(linkedHashSet3.iterator().next());
    }

    public static /* synthetic */ String E(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, l lVar, int i2) {
        if ((i2 & 1) != 0) {
            charSequence = ", ";
        }
        String str = (i2 & 2) != 0 ? "" : charSequence2;
        String str2 = (i2 & 4) != 0 ? "" : charSequence3;
        if ((i2 & 8) != 0) {
            i = -1;
        }
        return D(iterable, charSequence, str, str2, i, (i2 & 16) != 0 ? "..." : null, (i2 & 32) != 0 ? null : lVar);
    }

    public static final <T> Iterable<l<T>> E0(Iterable<? extends T> iterable) {
        i.e(iterable, "$this$withIndex");
        return new m(new m0.n.a.a<Iterator<? extends T>>(iterable) { // from class: kotlin.collections.CollectionsKt___CollectionsKt$withIndex$1
            public final /* synthetic */ Iterable c;

            {
                this.c = r1;
            }

            @Override // m0.n.a.a
            public Object invoke() {
                return this.c.iterator();
            }
        });
    }

    public static final <T> T F(Iterable<? extends T> iterable) {
        i.e(iterable, "$this$last");
        if (iterable instanceof List) {
            return (T) G((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T t = (T) it.next();
            while (it.hasNext()) {
                t = (T) it.next();
            }
            return t;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T, R> List<Pair<T, R>> F0(Iterable<? extends T> iterable, Iterable<? extends R> iterable2) {
        i.e(iterable, "$this$zip");
        i.e(iterable2, RecaptchaActionType.OTHER);
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(h.K(iterable, 10), h.K(iterable2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(new Pair(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static final <T> T G(List<? extends T> list) {
        i.e(list, "$this$last");
        if (!list.isEmpty()) {
            return (T) list.get(y(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> T H(Iterable<? extends T> iterable) {
        i.e(iterable, "$this$lastOrNull");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(list.size() - 1);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T t = (T) it.next();
        while (it.hasNext()) {
            t = (T) it.next();
        }
        return t;
    }

    public static final <T> T I(List<? extends T> list) {
        i.e(list, "$this$lastOrNull");
        if (list.isEmpty()) {
            return null;
        }
        return (T) list.get(list.size() - 1);
    }

    public static final <T> LinkedHashSet<T> J(T... tArr) {
        i.e(tArr, "elements");
        LinkedHashSet<T> linkedHashSet = new LinkedHashSet<>(h.R2(tArr.length));
        h.g4(tArr, linkedHashSet);
        return linkedHashSet;
    }

    public static final <T> List<T> K(T... tArr) {
        i.e(tArr, "elements");
        if (tArr.length > 0) {
            return d(tArr);
        }
        return EmptyList.c;
    }

    public static final <T> List<T> L(T t) {
        if (t != null) {
            return h.L2(t);
        }
        return EmptyList.c;
    }

    public static final <T> List<T> M(T... tArr) {
        i.e(tArr, "elements");
        i.e(tArr, "$this$filterNotNull");
        ArrayList arrayList = new ArrayList();
        i.e(tArr, "$this$filterNotNullTo");
        i.e(arrayList, "destination");
        for (T t : tArr) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static final <K, V> Map<K, V> N(Pair<? extends K, ? extends V>... pairArr) {
        i.e(pairArr, "pairs");
        if (pairArr.length <= 0) {
            return o();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(h.R2(pairArr.length));
        i.e(pairArr, "$this$toMap");
        i.e(linkedHashMap, "destination");
        f0(linkedHashMap, pairArr);
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Comparable, java.lang.Object] */
    /* JADX WARN: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static final <T extends Comparable<? super T>> T O(Iterable<? extends T> iterable) {
        i.e(iterable, "$this$maxOrNull");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T t = (T) ((Comparable) it.next());
        while (it.hasNext()) {
            ?? r1 = (Comparable) it.next();
            if (t.compareTo(r1) < 0) {
                t = r1;
            }
        }
        return t;
    }

    public static final <T> List<T> P(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        i.e(iterable, "$this$minus");
        i.e(iterable2, "elements");
        Collection V = h.V(iterable2, iterable);
        if (V.isEmpty()) {
            return v0(iterable);
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            if (!V.contains(obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final <T> List<T> Q(Iterable<? extends T> iterable, T t) {
        i.e(iterable, "$this$minus");
        ArrayList arrayList = new ArrayList(h.K(iterable, 10));
        boolean z = false;
        for (Object obj : iterable) {
            boolean z2 = true;
            if (!z && i.a(obj, t)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final <K, V> Map<K, V> R(Map<? extends K, ? extends V> map, K k) {
        i.e(map, "$this$minus");
        Map B0 = B0(map);
        B0.remove(k);
        return W(B0);
    }

    public static final <T> Set<T> S(Set<? extends T> set, Iterable<? extends T> iterable) {
        i.e(set, "$this$minus");
        i.e(iterable, "elements");
        Collection<?> V = h.V(iterable, set);
        if (V.isEmpty()) {
            return D0(set);
        }
        if (V instanceof Set) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (T t : set) {
                if (!V.contains(t)) {
                    linkedHashSet.add(t);
                }
            }
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(set);
        linkedHashSet2.removeAll(V);
        return linkedHashSet2;
    }

    public static final <T> Set<T> T(Set<? extends T> set, T t) {
        i.e(set, "$this$minus");
        LinkedHashSet linkedHashSet = new LinkedHashSet(h.R2(set.size()));
        boolean z = false;
        for (T t2 : set) {
            boolean z2 = true;
            if (!z && i.a(t2, t)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                linkedHashSet.add(t2);
            }
        }
        return linkedHashSet;
    }

    public static final <T> List<T> U(T... tArr) {
        i.e(tArr, "elements");
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new d(tArr, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> V(List<? extends T> list) {
        i.e(list, "$this$optimizeReadOnlyList");
        int size = list.size();
        if (size == 0) {
            return EmptyList.c;
        }
        if (size != 1) {
            return list;
        }
        return h.L2(list.get(0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> W(Map<K, ? extends V> map) {
        i.e(map, "$this$optimizeReadOnlyMap");
        int size = map.size();
        if (size == 0) {
            return o();
        }
        if (size != 1) {
            return map;
        }
        return h.o4(map);
    }

    public static final <T> List<T> X(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        i.e(iterable, "$this$plus");
        i.e(iterable2, "elements");
        if (iterable instanceof Collection) {
            return Z((Collection) iterable, iterable2);
        }
        ArrayList arrayList = new ArrayList();
        b(arrayList, iterable);
        b(arrayList, iterable2);
        return arrayList;
    }

    public static final <T> List<T> Y(Iterable<? extends T> iterable, T t) {
        i.e(iterable, "$this$plus");
        if (iterable instanceof Collection) {
            return a0((Collection) iterable, t);
        }
        ArrayList arrayList = new ArrayList();
        b(arrayList, iterable);
        arrayList.add(t);
        return arrayList;
    }

    public static final <T> List<T> Z(Collection<? extends T> collection, Iterable<? extends T> iterable) {
        i.e(collection, "$this$plus");
        i.e(iterable, "elements");
        if (iterable instanceof Collection) {
            Collection collection2 = (Collection) iterable;
            ArrayList arrayList = new ArrayList(collection2.size() + collection.size());
            arrayList.addAll(collection);
            arrayList.addAll(collection2);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(collection);
        b(arrayList2, iterable);
        return arrayList2;
    }

    public static final int a(List list, int i) {
        int y = y(list);
        if (i >= 0 && y >= i) {
            return y(list) - i;
        }
        StringBuilder Q0 = i0.d.a.a.a.Q0("Element index ", i, " must be in range [");
        Q0.append(new e(0, y(list)));
        Q0.append("].");
        throw new IndexOutOfBoundsException(Q0.toString());
    }

    public static final <T> List<T> a0(Collection<? extends T> collection, T t) {
        i.e(collection, "$this$plus");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t);
        return arrayList;
    }

    public static final <T> boolean b(Collection<? super T> collection, Iterable<? extends T> iterable) {
        i.e(collection, "$this$addAll");
        i.e(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z = false;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (collection.add((Object) it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static final <K, V> Map<K, V> b0(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2) {
        i.e(map, "$this$plus");
        i.e(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static final <T> ArrayList<T> c(T... tArr) {
        i.e(tArr, "elements");
        return tArr.length == 0 ? new ArrayList<>() : new ArrayList<>(new d(tArr, true));
    }

    public static final <K, V> Map<K, V> c0(Map<? extends K, ? extends V> map, Pair<? extends K, ? extends V> pair) {
        i.e(map, "$this$plus");
        i.e(pair, "pair");
        if (map.isEmpty()) {
            return h.S2(pair);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(pair.c, pair.d);
        return linkedHashMap;
    }

    public static final <T> List<T> d(T[] tArr) {
        i.e(tArr, "$this$asList");
        List<T> asList = Arrays.asList(tArr);
        i.d(asList, "ArraysUtilJVM.asList(this)");
        return asList;
    }

    public static final <T> Set<T> d0(Set<? extends T> set, Iterable<? extends T> iterable) {
        i.e(set, "$this$plus");
        i.e(iterable, "elements");
        i.e(iterable, "$this$collectionSizeOrNull");
        Integer valueOf = iterable instanceof Collection ? Integer.valueOf(((Collection) iterable).size()) : null;
        LinkedHashSet linkedHashSet = new LinkedHashSet(h.R2(valueOf != null ? set.size() + valueOf.intValue() : set.size() * 2));
        linkedHashSet.addAll(set);
        b(linkedHashSet, iterable);
        return linkedHashSet;
    }

    public static final <T> m0.s.h<T> e(Iterable<? extends T> iterable) {
        i.e(iterable, "$this$asSequence");
        return new j(iterable);
    }

    public static final <T> Set<T> e0(Set<? extends T> set, T t) {
        i.e(set, "$this$plus");
        LinkedHashSet linkedHashSet = new LinkedHashSet(h.R2(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t);
        return linkedHashSet;
    }

    public static final <T> boolean f(Iterable<? extends T> iterable, T t) {
        int i;
        i.e(iterable, "$this$contains");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(t);
        }
        i.e(iterable, "$this$indexOf");
        if (!(iterable instanceof List)) {
            Iterator<? extends T> it = iterable.iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                Object next = it.next();
                if (i2 < 0) {
                    r0();
                    throw null;
                } else if (i.a(t, next)) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
        } else {
            i = ((List) iterable).indexOf(t);
        }
        if (i >= 0) {
            return true;
        }
        return false;
    }

    public static final <K, V> void f0(Map<? super K, ? super V> map, Pair<? extends K, ? extends V>[] pairArr) {
        i.e(map, "$this$putAll");
        i.e(pairArr, "pairs");
        for (Pair<? extends K, ? extends V> pair : pairArr) {
            map.put((Object) pair.c, (Object) pair.d);
        }
    }

    public static final byte[] g(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        i.e(bArr, "$this$copyInto");
        i.e(bArr2, "destination");
        System.arraycopy(bArr, i2, bArr2, i, i3 - i2);
        return bArr2;
    }

    public static final <T> boolean g0(List<T> list, l<? super T, Boolean> lVar) {
        int i;
        i.e(list, "$this$removeAll");
        i.e(lVar, "predicate");
        boolean z = false;
        if (list instanceof RandomAccess) {
            int y = y(list);
            if (y >= 0) {
                int i2 = 0;
                i = 0;
                while (true) {
                    T t = list.get(i2);
                    if (!lVar.invoke(t).booleanValue()) {
                        if (i != i2) {
                            list.set(i, t);
                        }
                        i++;
                    }
                    if (i2 == y) {
                        break;
                    }
                    i2++;
                }
            } else {
                i = 0;
            }
            if (i < list.size()) {
                int y2 = y(list);
                if (y2 < i) {
                    return true;
                }
                while (true) {
                    list.remove(y2);
                    if (y2 == i) {
                        return true;
                    }
                    y2--;
                }
            }
        } else if (!(list instanceof m0.n.b.s.a) || (list instanceof b)) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (lVar.invoke(it.next()).booleanValue()) {
                    it.remove();
                    z = true;
                }
            }
        } else {
            r.e(list, "kotlin.collections.MutableIterable");
            throw null;
        }
        return z;
    }

    public static final <T> T[] h(T[] tArr, T[] tArr2, int i, int i2, int i3) {
        i.e(tArr, "$this$copyInto");
        i.e(tArr2, "destination");
        System.arraycopy(tArr, i2, tArr2, i, i3 - i2);
        return tArr2;
    }

    public static final <T> Set<T> h0(T... tArr) {
        i.e(tArr, "elements");
        if (tArr.length > 0) {
            return h.n4(tArr);
        }
        return EmptySet.c;
    }

    public static /* synthetic */ byte[] i(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = bArr.length;
        }
        g(bArr, bArr2, i, i2, i3);
        return bArr2;
    }

    public static final <T> T i0(Iterable<? extends T> iterable) {
        i.e(iterable, "$this$single");
        if (iterable instanceof List) {
            return (T) j0((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T t = (T) it.next();
            if (!it.hasNext()) {
                return t;
            }
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static /* synthetic */ Object[] j(Object[] objArr, Object[] objArr2, int i, int i2, int i3, int i4) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        h(objArr, objArr2, i, i2, i3);
        return objArr2;
    }

    public static final <T> T j0(List<? extends T> list) {
        i.e(list, "$this$single");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        } else if (size == 1) {
            return (T) list.get(0);
        } else {
            throw new IllegalArgumentException("List has more than one element.");
        }
    }

    public static final <T> T[] k(T[] tArr, int i, int i2) {
        i.e(tArr, "$this$copyOfRangeImpl");
        h.X(i2, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i, i2);
        i.d(tArr2, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return tArr2;
    }

    public static final <T> T k0(Iterable<? extends T> iterable) {
        i.e(iterable, "$this$singleOrNull");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.size() == 1) {
                return (T) list.get(0);
            }
            return null;
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T t = (T) it.next();
        if (it.hasNext()) {
            return null;
        }
        return t;
    }

    public static final <T> List<T> l(Iterable<? extends T> iterable, int i) {
        ArrayList arrayList;
        i.e(iterable, "$this$drop");
        int i2 = 0;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(i0.d.a.a.a.g0("Requested element count ", i, " is less than zero.").toString());
        } else if (i == 0) {
            return v0(iterable);
        } else {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                int size = collection.size() - i;
                if (size <= 0) {
                    return EmptyList.c;
                }
                if (size == 1) {
                    return h.L2(F(iterable));
                }
                arrayList = new ArrayList(size);
                if (iterable instanceof List) {
                    if (iterable instanceof RandomAccess) {
                        int size2 = collection.size();
                        while (i < size2) {
                            arrayList.add(((List) iterable).get(i));
                            i++;
                        }
                    } else {
                        ListIterator listIterator = ((List) iterable).listIterator(i);
                        while (listIterator.hasNext()) {
                            arrayList.add(listIterator.next());
                        }
                    }
                    return arrayList;
                }
            } else {
                arrayList = new ArrayList();
            }
            for (Object obj : iterable) {
                if (i2 >= i) {
                    arrayList.add(obj);
                } else {
                    i2++;
                }
            }
            return V(arrayList);
        }
    }

    public static final <T> T l0(List<? extends T> list) {
        i.e(list, "$this$singleOrNull");
        if (list.size() == 1) {
            return (T) list.get(0);
        }
        return null;
    }

    public static final <T> List<T> m(List<? extends T> list, int i) {
        i.e(list, "$this$dropLast");
        int i2 = 0;
        if (i >= 0) {
            int size = list.size() - i;
            if (size >= 0) {
                i2 = size;
            }
            return p0(list, i2);
        }
        throw new IllegalArgumentException(i0.d.a.a.a.g0("Requested element count ", i, " is less than zero.").toString());
    }

    public static final <T extends Comparable<? super T>> List<T> m0(Iterable<? extends T> iterable) {
        i.e(iterable, "$this$sorted");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return v0(iterable);
            }
            Object[] array = collection.toArray(new Comparable[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            Comparable[] comparableArr = (Comparable[]) array;
            i.e(comparableArr, "$this$sort");
            if (comparableArr.length > 1) {
                Arrays.sort(comparableArr);
            }
            return d(comparableArr);
        }
        List<T> z0 = z0(iterable);
        i.e(z0, "$this$sort");
        if (z0.size() > 1) {
            Collections.sort(z0);
        }
        return z0;
    }

    public static final <T> T n(Iterable<? extends T> iterable, int i) {
        i.e(iterable, "$this$elementAt");
        boolean z = iterable instanceof List;
        if (z) {
            return (T) ((List) iterable).get(i);
        }
        CollectionsKt___CollectionsKt$elementAt$1 collectionsKt___CollectionsKt$elementAt$1 = new l<Integer, T>(i) { // from class: kotlin.collections.CollectionsKt___CollectionsKt$elementAt$1
            public final /* synthetic */ int c;

            {
                this.c = r1;
            }

            @Override // m0.n.a.l
            public Object invoke(Integer num) {
                num.intValue();
                throw new IndexOutOfBoundsException(i0.d.a.a.a.s0(i0.d.a.a.a.P0("Collection doesn't contain element at index "), this.c, '.'));
            }
        };
        i.e(iterable, "$this$elementAtOrElse");
        i.e(collectionsKt___CollectionsKt$elementAt$1, "defaultValue");
        if (z) {
            List list = (List) iterable;
            if (i >= 0 && i <= y(list)) {
                return (T) list.get(i);
            }
            collectionsKt___CollectionsKt$elementAt$1.invoke(Integer.valueOf(i));
            throw null;
        } else if (i >= 0) {
            int i2 = 0;
            for (T t : iterable) {
                i2++;
                if (i == i2) {
                    return t;
                }
            }
            collectionsKt___CollectionsKt$elementAt$1.invoke(Integer.valueOf(i));
            throw null;
        } else {
            collectionsKt___CollectionsKt$elementAt$1.invoke(Integer.valueOf(i));
            throw null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> n0(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        i.e(iterable, "$this$sortedWith");
        i.e(comparator, "comparator");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return v0(iterable);
            }
            Object[] array = collection.toArray(new Object[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            i.e(array, "$this$sortWith");
            i.e(comparator, "comparator");
            if (array.length > 1) {
                Arrays.sort(array, comparator);
            }
            return d(array);
        }
        List<T> z0 = z0(iterable);
        h.U3(z0, comparator);
        return z0;
    }

    public static final <K, V> Map<K, V> o() {
        EmptyMap emptyMap = EmptyMap.c;
        Objects.requireNonNull(emptyMap, "null cannot be cast to non-null type kotlin.collections.Map<K, V>");
        return emptyMap;
    }

    public static final <T> Set<T> o0(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        i.e(iterable, "$this$subtract");
        i.e(iterable2, RecaptchaActionType.OTHER);
        Set<T> C0 = C0(iterable);
        i.e(C0, "$this$removeAll");
        i.e(iterable2, "elements");
        r.a(C0).removeAll(h.V(iterable2, C0));
        return C0;
    }

    public static final <T> void p(T[] tArr, T t, int i, int i2) {
        i.e(tArr, "$this$fill");
        Arrays.fill(tArr, i, i2, t);
    }

    public static final <T> List<T> p0(Iterable<? extends T> iterable, int i) {
        i.e(iterable, "$this$take");
        int i2 = 0;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(i0.d.a.a.a.g0("Requested element count ", i, " is less than zero.").toString());
        } else if (i == 0) {
            return EmptyList.c;
        } else {
            if (iterable instanceof Collection) {
                if (i >= ((Collection) iterable).size()) {
                    return v0(iterable);
                }
                if (i == 1) {
                    return h.L2(t(iterable));
                }
            }
            ArrayList arrayList = new ArrayList(i);
            Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
                i2++;
                if (i2 == i) {
                    break;
                }
            }
            return V(arrayList);
        }
    }

    public static /* synthetic */ void q(Object[] objArr, Object obj, int i, int i2, int i3) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        p(objArr, obj, i, i2);
    }

    public static final void q0() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static final <T> List<T> r(Iterable<? extends T> iterable, l<? super T, Boolean> lVar) {
        i.e(iterable, "$this$filter");
        i.e(lVar, "predicate");
        ArrayList arrayList = new ArrayList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object obj = (Object) it.next();
            if (lVar.invoke(obj).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final void r0() {
        throw new ArithmeticException("Index overflow has happened.");
    }

    public static final <T> List<T> s(Iterable<? extends T> iterable) {
        i.e(iterable, "$this$filterNotNull");
        ArrayList arrayList = new ArrayList();
        i.e(iterable, "$this$filterNotNullTo");
        i.e(arrayList, "destination");
        for (Object obj : iterable) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final <T, C extends Collection<? super T>> C s0(Iterable<? extends T> iterable, C c) {
        i.e(iterable, "$this$toCollection");
        i.e(c, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            c.add(it.next());
        }
        return c;
    }

    public static final <T> T t(Iterable<? extends T> iterable) {
        i.e(iterable, "$this$first");
        if (iterable instanceof List) {
            return (T) u((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return (T) it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> HashSet<T> t0(Iterable<? extends T> iterable) {
        i.e(iterable, "$this$toHashSet");
        HashSet<T> hashSet = new HashSet<>(h.R2(h.K(iterable, 12)));
        s0(iterable, hashSet);
        return hashSet;
    }

    public static final <T> T u(List<? extends T> list) {
        i.e(list, "$this$first");
        if (!list.isEmpty()) {
            return (T) list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final int[] u0(Collection<Integer> collection) {
        i.e(collection, "$this$toIntArray");
        int[] iArr = new int[collection.size()];
        int i = 0;
        for (Integer num : collection) {
            iArr[i] = num.intValue();
            i++;
        }
        return iArr;
    }

    public static final <T> T v(Iterable<? extends T> iterable) {
        i.e(iterable, "$this$firstOrNull");
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return (T) list.get(0);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        return (T) it.next();
    }

    public static final <T> List<T> v0(Iterable<? extends T> iterable) {
        i.e(iterable, "$this$toList");
        if (!(iterable instanceof Collection)) {
            return V(z0(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return EmptyList.c;
        }
        if (size != 1) {
            return A0(collection);
        }
        return h.L2(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final <T> T w(List<? extends T> list) {
        i.e(list, "$this$firstOrNull");
        if (list.isEmpty()) {
            return null;
        }
        return (T) list.get(0);
    }

    public static final <K, V> Map<K, V> w0(Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        i.e(iterable, "$this$toMap");
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return o();
        }
        if (size == 1) {
            return h.S2((Pair) ((List) iterable).get(0));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(h.R2(collection.size()));
        x0(iterable, linkedHashMap);
        return linkedHashMap;
    }

    public static final e x(Collection<?> collection) {
        i.e(collection, "$this$indices");
        return new e(0, collection.size() - 1);
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M x0(Iterable<? extends Pair<? extends K, ? extends V>> iterable, M m) {
        i.e(iterable, "$this$toMap");
        i.e(m, "destination");
        i.e(m, "$this$putAll");
        i.e(iterable, "pairs");
        Iterator<? extends Pair<? extends K, ? extends V>> it = iterable.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            m.put(pair.c, pair.d);
        }
        return m;
    }

    public static final <T> int y(List<? extends T> list) {
        i.e(list, "$this$lastIndex");
        return list.size() - 1;
    }

    public static final <K, V> Map<K, V> y0(Map<? extends K, ? extends V> map) {
        i.e(map, "$this$toMap");
        int size = map.size();
        if (size == 0) {
            return o();
        }
        if (size != 1) {
            return B0(map);
        }
        return h.o4(map);
    }

    public static final <T> T z(List<? extends T> list, int i) {
        i.e(list, "$this$getOrNull");
        if (i < 0 || i > y(list)) {
            return null;
        }
        return (T) list.get(i);
    }

    public static final <T> List<T> z0(Iterable<? extends T> iterable) {
        i.e(iterable, "$this$toMutableList");
        if (iterable instanceof Collection) {
            return A0((Collection) iterable);
        }
        ArrayList arrayList = new ArrayList();
        s0(iterable, arrayList);
        return arrayList;
    }
}
