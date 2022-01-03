package com.pubnub.api.models.server.objects_api;

import com.pubnub.api.models.consumer.objects_api.member.PNUUID;
import java.util.Collection;
/* loaded from: classes2.dex */
public class PatchMemberPayload {
    private Collection<PNUUID> delete;
    private Collection<PNUUID> set;

    public PatchMemberPayload(Collection<PNUUID> collection, Collection<PNUUID> collection2) {
        this.set = collection;
        this.delete = collection2;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof PatchMemberPayload;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PatchMemberPayload)) {
            return false;
        }
        PatchMemberPayload patchMemberPayload = (PatchMemberPayload) obj;
        if (!patchMemberPayload.canEqual(this)) {
            return false;
        }
        Collection<PNUUID> set = getSet();
        Collection<PNUUID> set2 = patchMemberPayload.getSet();
        if (set != null ? !set.equals(set2) : set2 != null) {
            return false;
        }
        Collection<PNUUID> delete = getDelete();
        Collection<PNUUID> delete2 = patchMemberPayload.getDelete();
        return delete != null ? delete.equals(delete2) : delete2 == null;
    }

    public Collection<PNUUID> getDelete() {
        return this.delete;
    }

    public Collection<PNUUID> getSet() {
        return this.set;
    }

    public int hashCode() {
        Collection<PNUUID> set = getSet();
        int i = 43;
        int hashCode = set == null ? 43 : set.hashCode();
        Collection<PNUUID> delete = getDelete();
        int i2 = (hashCode + 59) * 59;
        if (delete != null) {
            i = delete.hashCode();
        }
        return i2 + i;
    }
}
