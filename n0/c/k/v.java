package n0.c.k;

import kotlinx.serialization.KSerializer;
/* compiled from: PluginHelperInterfaces.kt */
/* loaded from: classes4.dex */
public interface v<T> extends KSerializer<T> {
    KSerializer<?>[] childSerializers();

    KSerializer<?>[] typeParametersSerializers();
}
