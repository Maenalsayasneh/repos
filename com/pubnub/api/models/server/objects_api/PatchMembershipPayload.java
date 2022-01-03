package com.pubnub.api.models.server.objects_api;

import com.pubnub.api.models.consumer.objects_api.membership.PNChannelMembership;
import java.util.Collection;
/* loaded from: classes2.dex */
public class PatchMembershipPayload {
    private Collection<PNChannelMembership> delete;
    private Collection<PNChannelMembership> set;

    public PatchMembershipPayload(Collection<PNChannelMembership> collection, Collection<PNChannelMembership> collection2) {
        this.set = collection;
        this.delete = collection2;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof PatchMembershipPayload;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PatchMembershipPayload)) {
            return false;
        }
        PatchMembershipPayload patchMembershipPayload = (PatchMembershipPayload) obj;
        if (!patchMembershipPayload.canEqual(this)) {
            return false;
        }
        Collection<PNChannelMembership> set = getSet();
        Collection<PNChannelMembership> set2 = patchMembershipPayload.getSet();
        if (set != null ? !set.equals(set2) : set2 != null) {
            return false;
        }
        Collection<PNChannelMembership> delete = getDelete();
        Collection<PNChannelMembership> delete2 = patchMembershipPayload.getDelete();
        return delete != null ? delete.equals(delete2) : delete2 == null;
    }

    public Collection<PNChannelMembership> getDelete() {
        return this.delete;
    }

    public Collection<PNChannelMembership> getSet() {
        return this.set;
    }

    public int hashCode() {
        Collection<PNChannelMembership> set = getSet();
        int i = 43;
        int hashCode = set == null ? 43 : set.hashCode();
        Collection<PNChannelMembership> delete = getDelete();
        int i2 = (hashCode + 59) * 59;
        if (delete != null) {
            i = delete.hashCode();
        }
        return i2 + i;
    }
}
