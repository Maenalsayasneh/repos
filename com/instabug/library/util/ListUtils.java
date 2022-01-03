package com.instabug.library.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class ListUtils {
    public static <T> T safeGet(List<T> list, int i) {
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public static <T> List<List<T>> split(List<T> list, int i) {
        if (list == null || list.isEmpty()) {
            return Collections.emptyList();
        }
        return split(list, Math.max(1, i), new ArrayList());
    }

    public static <T> List<T> toList(Collection<T> collection) {
        if (collection instanceof List) {
            return (List) collection;
        }
        return collection == null ? Collections.emptyList() : new ArrayList(collection);
    }

    private static <T> List<List<T>> split(List<T> list, int i, List<List<T>> list2) {
        if (list.size() > i) {
            list2.add(list.subList(0, i));
            return split(list.subList(i, list.size()), i, list2);
        }
        list2.add(list);
        return list2;
    }
}
