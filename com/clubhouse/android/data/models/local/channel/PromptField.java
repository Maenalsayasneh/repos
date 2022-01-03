package com.clubhouse.android.data.models.local.channel;

import i0.e.b.b3.a.a.c.c;
import n0.c.e;
/* compiled from: PromptField.kt */
@e(with = c.class)
/* loaded from: classes3.dex */
public enum PromptField {
    BIO("bio"),
    PHOTO("photo");
    
    private final String value;

    PromptField(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
