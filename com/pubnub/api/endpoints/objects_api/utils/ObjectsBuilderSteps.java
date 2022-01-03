package com.pubnub.api.endpoints.objects_api.utils;

import com.pubnub.api.endpoints.BuilderSteps;
import com.pubnub.api.models.consumer.objects_api.member.PNUUID;
import com.pubnub.api.models.consumer.objects_api.membership.PNChannelMembership;
import java.util.Collection;
/* loaded from: classes2.dex */
public interface ObjectsBuilderSteps extends BuilderSteps {

    /* loaded from: classes2.dex */
    public interface ChannelMembershipsStep<T> {
        T channelMemberships(Collection<PNChannelMembership> collection);
    }

    /* loaded from: classes2.dex */
    public interface RemoveOrSetStep<T, E> {

        /* loaded from: classes2.dex */
        public interface RemoveStep<T, E> {
            T remove(Collection<E> collection);
        }

        /* loaded from: classes2.dex */
        public interface SetStep<T, E> {
            T set(Collection<E> collection);
        }

        SetStep<T, E> remove(Collection<E> collection);

        RemoveStep<T, E> set(Collection<E> collection);
    }

    /* loaded from: classes2.dex */
    public interface UUIDsStep<T> {
        T uuids(Collection<PNUUID> collection);
    }
}
