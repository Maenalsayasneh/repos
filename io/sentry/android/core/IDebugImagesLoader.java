package io.sentry.android.core;

import io.sentry.protocol.DebugImage;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;
@ApiStatus.Internal
/* loaded from: classes4.dex */
public interface IDebugImagesLoader {
    void clearDebugImages();

    List<DebugImage> loadDebugImages();
}
