package com.pubnub.api.models.consumer.objects_api.member;

import com.google.gson.annotations.JsonAdapter;
import com.pubnub.api.models.consumer.objects_api.util.CustomPayloadJsonInterceptor;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class PNUUID {
    private final UUIDId uuid;

    /* loaded from: classes2.dex */
    public static class JustUUID extends PNUUID {
        public JustUUID(UUIDId uUIDId) {
            super(uUIDId);
        }

        public boolean canEqual(Object obj) {
            return obj instanceof JustUUID;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return (obj instanceof JustUUID) && ((JustUUID) obj).canEqual(this) && super.equals(obj);
        }

        public int hashCode() {
            return super.hashCode();
        }
    }

    /* loaded from: classes2.dex */
    public static class UUIDId {
        private String id;

        public UUIDId(String str) {
            this.id = str;
        }

        public boolean canEqual(Object obj) {
            return obj instanceof UUIDId;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof UUIDId)) {
                return false;
            }
            UUIDId uUIDId = (UUIDId) obj;
            if (!uUIDId.canEqual(this)) {
                return false;
            }
            String id = getId();
            String id2 = uUIDId.getId();
            return id != null ? id.equals(id2) : id2 == null;
        }

        public String getId() {
            return this.id;
        }

        public int hashCode() {
            String id = getId();
            return 59 + (id == null ? 43 : id.hashCode());
        }
    }

    /* loaded from: classes2.dex */
    public static class UUIDWithCustom extends PNUUID {
        @JsonAdapter(CustomPayloadJsonInterceptor.class)
        private final Object custom;

        public UUIDWithCustom(UUIDId uUIDId, Object obj) {
            super(uUIDId);
            this.custom = obj;
        }

        public boolean canEqual(Object obj) {
            return obj instanceof UUIDWithCustom;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof UUIDWithCustom)) {
                return false;
            }
            UUIDWithCustom uUIDWithCustom = (UUIDWithCustom) obj;
            if (!uUIDWithCustom.canEqual(this) || !super.equals(obj)) {
                return false;
            }
            Object custom = getCustom();
            Object custom2 = uUIDWithCustom.getCustom();
            return custom != null ? custom.equals(custom2) : custom2 == null;
        }

        public Object getCustom() {
            return this.custom;
        }

        public int hashCode() {
            int hashCode = super.hashCode();
            Object custom = getCustom();
            return (hashCode * 59) + (custom == null ? 43 : custom.hashCode());
        }
    }

    public PNUUID(UUIDId uUIDId) {
        this.uuid = uUIDId;
    }

    public static PNUUID uuid(String str) {
        return new JustUUID(new UUIDId(str));
    }

    public static PNUUID uuidWithCustom(String str, Map<String, Object> map) {
        return new UUIDWithCustom(new UUIDId(str), new HashMap(map));
    }

    public UUIDId getUuid() {
        return this.uuid;
    }
}
