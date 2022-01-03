package com.pubnub.api.models.consumer.access_manager.v3;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import i0.d.a.a.a;
import java.util.Map;
import java.util.Objects;
import lombok.NonNull;
@JsonIgnoreProperties(ignoreUnknown = true)
/* loaded from: classes2.dex */
public class PNToken {
    private final String authorizedUUID;
    @NonNull
    private final PNTokenResources patterns;
    @NonNull
    private final PNTokenResources resources;
    private final long timestamp;
    private final long ttl;
    private final int version;

    /* loaded from: classes2.dex */
    public static class PNResourcePermissions {
        private final boolean delete;
        private final boolean get;
        private final boolean join;
        private final boolean manage;
        private final boolean read;
        private final boolean update;
        private final boolean write;

        public PNResourcePermissions(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
            this.read = z;
            this.write = z2;
            this.manage = z3;
            this.delete = z4;
            this.get = z5;
            this.update = z6;
            this.join = z7;
        }

        @JsonCreator
        public static PNResourcePermissions of(int i) {
            return new PNResourcePermissions((i & 1) != 0, (i & 2) != 0, (i & 4) != 0, (i & 8) != 0, (i & 32) != 0, (i & 64) != 0, (i & 128) != 0);
        }

        public boolean canEqual(Object obj) {
            return obj instanceof PNResourcePermissions;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof PNResourcePermissions)) {
                return false;
            }
            PNResourcePermissions pNResourcePermissions = (PNResourcePermissions) obj;
            return pNResourcePermissions.canEqual(this) && isRead() == pNResourcePermissions.isRead() && isWrite() == pNResourcePermissions.isWrite() && isManage() == pNResourcePermissions.isManage() && isDelete() == pNResourcePermissions.isDelete() && isGet() == pNResourcePermissions.isGet() && isUpdate() == pNResourcePermissions.isUpdate() && isJoin() == pNResourcePermissions.isJoin();
        }

        public int hashCode() {
            int i = 79;
            int i2 = ((((((((((((isRead() ? 79 : 97) + 59) * 59) + (isWrite() ? 79 : 97)) * 59) + (isManage() ? 79 : 97)) * 59) + (isDelete() ? 79 : 97)) * 59) + (isGet() ? 79 : 97)) * 59) + (isUpdate() ? 79 : 97)) * 59;
            if (!isJoin()) {
                i = 97;
            }
            return i2 + i;
        }

        public boolean isDelete() {
            return this.delete;
        }

        public boolean isGet() {
            return this.get;
        }

        public boolean isJoin() {
            return this.join;
        }

        public boolean isManage() {
            return this.manage;
        }

        public boolean isRead() {
            return this.read;
        }

        public boolean isUpdate() {
            return this.update;
        }

        public boolean isWrite() {
            return this.write;
        }

        public String toString() {
            StringBuilder P0 = a.P0("PNToken.PNResourcePermissions(read=");
            P0.append(isRead());
            P0.append(", write=");
            P0.append(isWrite());
            P0.append(", manage=");
            P0.append(isManage());
            P0.append(", delete=");
            P0.append(isDelete());
            P0.append(", get=");
            P0.append(isGet());
            P0.append(", update=");
            P0.append(isUpdate());
            P0.append(", join=");
            P0.append(isJoin());
            P0.append(")");
            return P0.toString();
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    /* loaded from: classes2.dex */
    public static class PNTokenResources {
        @NonNull
        private final Map<String, PNResourcePermissions> channelGroups;
        @NonNull
        private final Map<String, PNResourcePermissions> channels;
        @NonNull
        private final Map<String, PNResourcePermissions> uuids;

        public PNTokenResources(@NonNull Map<String, PNResourcePermissions> map, @NonNull Map<String, PNResourcePermissions> map2, @NonNull Map<String, PNResourcePermissions> map3) {
            Objects.requireNonNull(map, "channels is marked @NonNull but is null");
            Objects.requireNonNull(map2, "channelGroups is marked @NonNull but is null");
            Objects.requireNonNull(map3, "uuids is marked @NonNull but is null");
            this.channels = map;
            this.channelGroups = map2;
            this.uuids = map3;
        }

        @JsonCreator
        public static PNTokenResources of(@JsonProperty("chan") Map<String, PNResourcePermissions> map, @JsonProperty("grp") Map<String, PNResourcePermissions> map2, @JsonProperty("uuid") Map<String, PNResourcePermissions> map3) {
            return new PNTokenResources(map, map2, map3);
        }

        public boolean canEqual(Object obj) {
            return obj instanceof PNTokenResources;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof PNTokenResources)) {
                return false;
            }
            PNTokenResources pNTokenResources = (PNTokenResources) obj;
            if (!pNTokenResources.canEqual(this)) {
                return false;
            }
            Map<String, PNResourcePermissions> channels = getChannels();
            Map<String, PNResourcePermissions> channels2 = pNTokenResources.getChannels();
            if (channels != null ? !channels.equals(channels2) : channels2 != null) {
                return false;
            }
            Map<String, PNResourcePermissions> channelGroups = getChannelGroups();
            Map<String, PNResourcePermissions> channelGroups2 = pNTokenResources.getChannelGroups();
            if (channelGroups != null ? !channelGroups.equals(channelGroups2) : channelGroups2 != null) {
                return false;
            }
            Map<String, PNResourcePermissions> uuids = getUuids();
            Map<String, PNResourcePermissions> uuids2 = pNTokenResources.getUuids();
            return uuids != null ? uuids.equals(uuids2) : uuids2 == null;
        }

        @NonNull
        public Map<String, PNResourcePermissions> getChannelGroups() {
            return this.channelGroups;
        }

        @NonNull
        public Map<String, PNResourcePermissions> getChannels() {
            return this.channels;
        }

        @NonNull
        public Map<String, PNResourcePermissions> getUuids() {
            return this.uuids;
        }

        public int hashCode() {
            Map<String, PNResourcePermissions> channels = getChannels();
            int i = 43;
            int hashCode = channels == null ? 43 : channels.hashCode();
            Map<String, PNResourcePermissions> channelGroups = getChannelGroups();
            int hashCode2 = ((hashCode + 59) * 59) + (channelGroups == null ? 43 : channelGroups.hashCode());
            Map<String, PNResourcePermissions> uuids = getUuids();
            int i2 = hashCode2 * 59;
            if (uuids != null) {
                i = uuids.hashCode();
            }
            return i2 + i;
        }

        public String toString() {
            StringBuilder P0 = a.P0("PNToken.PNTokenResources(channels=");
            P0.append(getChannels());
            P0.append(", channelGroups=");
            P0.append(getChannelGroups());
            P0.append(", uuids=");
            P0.append(getUuids());
            P0.append(")");
            return P0.toString();
        }
    }

    public PNToken(int i, long j, long j2, String str, @NonNull PNTokenResources pNTokenResources, @NonNull PNTokenResources pNTokenResources2) {
        Objects.requireNonNull(pNTokenResources, "resources is marked @NonNull but is null");
        Objects.requireNonNull(pNTokenResources2, "patterns is marked @NonNull but is null");
        this.version = i;
        this.timestamp = j;
        this.ttl = j2;
        this.authorizedUUID = str;
        this.resources = pNTokenResources;
        this.patterns = pNTokenResources2;
    }

    @JsonCreator
    public static PNToken of(@JsonProperty("v") int i, @JsonProperty("t") long j, @JsonProperty("ttl") long j2, @JsonProperty("res") PNTokenResources pNTokenResources, @JsonProperty("pat") PNTokenResources pNTokenResources2, @JsonProperty("uuid") String str) {
        return new PNToken(i, j, j2, str, pNTokenResources, pNTokenResources2);
    }

    public boolean canEqual(Object obj) {
        return obj instanceof PNToken;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PNToken)) {
            return false;
        }
        PNToken pNToken = (PNToken) obj;
        if (!pNToken.canEqual(this) || getVersion() != pNToken.getVersion() || getTimestamp() != pNToken.getTimestamp() || getTtl() != pNToken.getTtl()) {
            return false;
        }
        String authorizedUUID = getAuthorizedUUID();
        String authorizedUUID2 = pNToken.getAuthorizedUUID();
        if (authorizedUUID != null ? !authorizedUUID.equals(authorizedUUID2) : authorizedUUID2 != null) {
            return false;
        }
        PNTokenResources resources = getResources();
        PNTokenResources resources2 = pNToken.getResources();
        if (resources != null ? !resources.equals(resources2) : resources2 != null) {
            return false;
        }
        PNTokenResources patterns = getPatterns();
        PNTokenResources patterns2 = pNToken.getPatterns();
        return patterns != null ? patterns.equals(patterns2) : patterns2 == null;
    }

    public String getAuthorizedUUID() {
        return this.authorizedUUID;
    }

    @NonNull
    public PNTokenResources getPatterns() {
        return this.patterns;
    }

    @NonNull
    public PNTokenResources getResources() {
        return this.resources;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public long getTtl() {
        return this.ttl;
    }

    public int getVersion() {
        return this.version;
    }

    public int hashCode() {
        long timestamp = getTimestamp();
        int version = ((getVersion() + 59) * 59) + ((int) (timestamp ^ (timestamp >>> 32)));
        long ttl = getTtl();
        int i = (version * 59) + ((int) (ttl ^ (ttl >>> 32)));
        String authorizedUUID = getAuthorizedUUID();
        int i2 = 43;
        int hashCode = (i * 59) + (authorizedUUID == null ? 43 : authorizedUUID.hashCode());
        PNTokenResources resources = getResources();
        int hashCode2 = (hashCode * 59) + (resources == null ? 43 : resources.hashCode());
        PNTokenResources patterns = getPatterns();
        int i3 = hashCode2 * 59;
        if (patterns != null) {
            i2 = patterns.hashCode();
        }
        return i3 + i2;
    }

    public String toString() {
        StringBuilder P0 = a.P0("PNToken(version=");
        P0.append(getVersion());
        P0.append(", timestamp=");
        P0.append(getTimestamp());
        P0.append(", ttl=");
        P0.append(getTtl());
        P0.append(", authorizedUUID=");
        P0.append(getAuthorizedUUID());
        P0.append(", resources=");
        P0.append(getResources());
        P0.append(", patterns=");
        P0.append(getPatterns());
        P0.append(")");
        return P0.toString();
    }
}
