package io.sentry;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public final class SentryValues<T> {
    private final List<T> values;

    public SentryValues(List<T> list) {
        this.values = list == null ? new ArrayList<>(0) : list;
    }

    public List<T> getValues() {
        return this.values;
    }
}
