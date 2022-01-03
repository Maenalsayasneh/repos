package com.fasterxml.jackson.core.util;

import com.instabug.library.settings.SettingsManager;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public final class InternCache extends ConcurrentHashMap<String, String> {
    public static final InternCache c = new InternCache();
    public final Object d = new Object();

    public InternCache() {
        super(SettingsManager.MAX_ASR_DURATION_IN_SECONDS, 0.8f, 4);
    }

    public String a(String str) {
        String str2 = get(str);
        if (str2 != null) {
            return str2;
        }
        if (size() >= 180) {
            synchronized (this.d) {
                if (size() >= 180) {
                    clear();
                }
            }
        }
        String intern = str.intern();
        put(intern, intern);
        return intern;
    }
}
