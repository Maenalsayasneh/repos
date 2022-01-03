package com.instabug.featuresrequest.d;

import com.instabug.library.internal.storage.cache.Cacheable;
import java.io.Serializable;
/* compiled from: TimelineObject.java */
/* loaded from: classes2.dex */
public abstract class f implements Cacheable, Serializable {
    public a c = a.COMMENT;
    public long d;

    /* compiled from: TimelineObject.java */
    /* loaded from: classes2.dex */
    public enum a {
        COMMENT("comment"),
        STATUS_CHANE("state_change");
        
        private final String type;

        a(String str) {
            this.type = str;
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return this.type;
        }
    }
}
