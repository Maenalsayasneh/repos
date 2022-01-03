package com.fasterxml.jackson.databind.util;

import i0.f.a.c.t.i;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class LRUMap<K, V> implements i<K, V>, Serializable {
    public final transient int c;
    public final transient ConcurrentHashMap<K, V> d;

    public LRUMap(int i, int i2) {
        this.d = new ConcurrentHashMap<>(i, 0.8f, 4);
        this.c = i2;
    }

    public V a(K k, V v) {
        if (this.d.size() >= this.c) {
            synchronized (this) {
                if (this.d.size() >= this.c) {
                    this.d.clear();
                }
            }
        }
        return this.d.put(k, v);
    }

    @Override // i0.f.a.c.t.i
    public V get(Object obj) {
        return this.d.get(obj);
    }

    @Override // i0.f.a.c.t.i
    public V putIfAbsent(K k, V v) {
        if (this.d.size() >= this.c) {
            synchronized (this) {
                if (this.d.size() >= this.c) {
                    this.d.clear();
                }
            }
        }
        return this.d.putIfAbsent(k, v);
    }
}
