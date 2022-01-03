package com.instabug.library.model.session;

import androidx.annotation.Keep;
import java.util.Collections;
import java.util.List;
import java.util.Map;
@Keep
/* loaded from: classes2.dex */
public class SessionsBatchDTO {
    private final Map<String, Object> commonKeys;
    private final List<SessionRemoteEntity> sessions;

    public SessionsBatchDTO(Map<String, Object> map, List<SessionRemoteEntity> list) {
        this.commonKeys = map;
        this.sessions = list;
    }

    public Map<String, Object> getCommonKeys() {
        return Collections.unmodifiableMap(this.commonKeys);
    }

    public List<SessionRemoteEntity> getSessions() {
        return Collections.unmodifiableList(this.sessions);
    }
}
