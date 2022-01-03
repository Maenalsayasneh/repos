package io.sentry.config;

import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public interface PropertiesProvider {
    default Boolean getBooleanProperty(String str) {
        String property = getProperty(str);
        if (property != null) {
            return Boolean.valueOf(property);
        }
        return null;
    }

    default Double getDoubleProperty(String str) {
        String property = getProperty(str);
        if (property != null) {
            return Double.valueOf(property);
        }
        return null;
    }

    default List<String> getList(String str) {
        String property = getProperty(str);
        return property != null ? Arrays.asList(property.split(InstabugDbContract.COMMA_SEP)) : Collections.emptyList();
    }

    Map<String, String> getMap(String str);

    String getProperty(String str);

    default String getProperty(String str, String str2) {
        String property = getProperty(str);
        return property != null ? property : str2;
    }
}
