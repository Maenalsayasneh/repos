package io.sentry.protocol;

import io.sentry.IUnknownPropertiesConsumer;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;
/* loaded from: classes4.dex */
public final class Message implements IUnknownPropertiesConsumer {
    private String formatted;
    private String message;
    private List<String> params;
    private Map<String, Object> unknown;

    @Override // io.sentry.IUnknownPropertiesConsumer
    @ApiStatus.Internal
    public void acceptUnknownProperties(Map<String, Object> map) {
        this.unknown = map;
    }

    public String getFormatted() {
        return this.formatted;
    }

    public String getMessage() {
        return this.message;
    }

    public List<String> getParams() {
        return this.params;
    }

    public void setFormatted(String str) {
        this.formatted = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setParams(List<String> list) {
        this.params = list;
    }
}
