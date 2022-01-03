package io.sentry;

import java.lang.reflect.InvocationTargetException;
import org.jetbrains.annotations.ApiStatus;
@ApiStatus.Internal
/* loaded from: classes4.dex */
public final class OptionsContainer<T> {
    private final Class<T> clazz;

    private OptionsContainer(Class<T> cls) {
        this.clazz = cls;
    }

    public static <T> OptionsContainer<T> create(Class<T> cls) {
        return new OptionsContainer<>(cls);
    }

    public T createInstance() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return this.clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    }
}
