package com.pubnub.api.managers;
/* loaded from: classes2.dex */
public class PublishSequenceManager {
    private int maxSequence;
    private int nextSequence;

    public PublishSequenceManager(int i) {
        this.maxSequence = i;
    }

    public synchronized int getNextSequence() {
        int i = this.maxSequence;
        int i2 = this.nextSequence;
        if (i == i2) {
            this.nextSequence = 1;
        } else {
            this.nextSequence = i2 + 1;
        }
        return this.nextSequence;
    }
}
