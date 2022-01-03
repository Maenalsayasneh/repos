package io.sentry.android.core.util;

import io.sentry.protocol.Device;
import org.jetbrains.annotations.ApiStatus;
@ApiStatus.Internal
/* loaded from: classes4.dex */
public final class DeviceOrientations {
    private DeviceOrientations() {
    }

    public static Device.DeviceOrientation getOrientation(int i) {
        if (i == 1) {
            return Device.DeviceOrientation.PORTRAIT;
        }
        if (i != 2) {
            return null;
        }
        return Device.DeviceOrientation.LANDSCAPE;
    }
}
