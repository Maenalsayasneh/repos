package io.agora.rtc.internal;

import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public interface IMarshallable {
    void marshall(ByteBuffer byteBuffer);

    byte[] marshall();

    void unmarshall(ByteBuffer byteBuffer);

    void unmarshall(byte[] bArr);
}
