package io.michaelrocks.libphonenumber.android.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class RegexCache {
    public LRUCache<String, Pattern> a;

    /* loaded from: classes4.dex */
    public static class LRUCache<K, V> {
        public LinkedHashMap<K, V> a;
        public int b;

        public LRUCache(int i) {
            this.b = i;
            this.a = new LinkedHashMap<K, V>(((i * 4) / 3) + 1, 0.75f, true) { // from class: io.michaelrocks.libphonenumber.android.internal.RegexCache.LRUCache.1
                @Override // java.util.LinkedHashMap
                public boolean removeEldestEntry(Map.Entry<K, V> entry) {
                    return size() > LRUCache.this.b;
                }
            };
        }
    }

    public RegexCache(int i) {
        this.a = new LRUCache<>(i);
    }

    public Pattern a(String str) {
        Pattern pattern;
        LRUCache<String, Pattern> lRUCache = this.a;
        synchronized (lRUCache) {
            pattern = lRUCache.a.get(str);
        }
        Pattern pattern2 = pattern;
        if (pattern2 == null) {
            pattern2 = Pattern.compile(str);
            LRUCache<String, Pattern> lRUCache2 = this.a;
            synchronized (lRUCache2) {
                lRUCache2.a.put(str, pattern2);
            }
        }
        return pattern2;
    }
}
