package com.pubnub.api.models.consumer;
/* loaded from: classes2.dex */
public abstract class PNPage {
    public final String hash;

    /* loaded from: classes2.dex */
    public static class Next extends PNPage {
        public Next(String str) {
            super(str);
        }
    }

    /* loaded from: classes2.dex */
    public static class Previous extends PNPage {
        public Previous(String str) {
            super(str);
        }
    }

    public PNPage(String str) {
        this.hash = str;
    }

    public static Next next(String str) {
        return new Next(str);
    }

    public static Previous previous(String str) {
        return new Previous(str);
    }

    public String getHash() {
        return this.hash;
    }
}
