package com.pubnub.api.endpoints.objects_api.utils;

import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
/* loaded from: classes2.dex */
public class PNSortKey {
    private final Dir dir;
    private final Key key;

    /* loaded from: classes2.dex */
    public enum Dir {
        ASC("asc"),
        DESC("desc");
        
        private final String dir;

        Dir(String str) {
            this.dir = str;
        }

        public String getDir() {
            return this.dir;
        }
    }

    /* loaded from: classes2.dex */
    public enum Key {
        ID("id"),
        NAME("name"),
        UPDATED(SDKCoreEvent.Feature.VALUE_UPDATED);
        
        private final String fieldName;

        Key(String str) {
            this.fieldName = str;
        }

        public String getFieldName() {
            return this.fieldName;
        }
    }

    private PNSortKey(Key key, Dir dir) {
        this.key = key;
        this.dir = dir;
    }

    public static PNSortKey asc(Key key) {
        return new PNSortKey(key, Dir.ASC);
    }

    public static PNSortKey desc(Key key) {
        return new PNSortKey(key, Dir.DESC);
    }

    public static PNSortKey of(Key key, Dir dir) {
        return new PNSortKey(key, dir);
    }

    public Dir getDir() {
        return this.dir;
    }

    public Key getKey() {
        return this.key;
    }

    public String toSortParameter() {
        return this.key.fieldName + ":" + this.dir.dir;
    }

    public static PNSortKey of(Key key) {
        return new PNSortKey(key, Dir.ASC);
    }
}
