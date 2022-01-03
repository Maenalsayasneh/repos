package kotlin.reflect.jvm.internal.impl.metadata;

import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
/* loaded from: classes4.dex */
public enum ProtoBuf$Visibility implements Internal.a {
    INTERNAL(0, 0),
    PRIVATE(1, 1),
    PROTECTED(2, 2),
    PUBLIC(3, 3),
    PRIVATE_TO_THIS(4, 4),
    LOCAL(5, 5);
    
    private static Internal.b<ProtoBuf$Visibility> internalValueMap = new a();
    private final int value;

    /* loaded from: classes4.dex */
    public static class a implements Internal.b<ProtoBuf$Visibility> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.b
        public ProtoBuf$Visibility a(int i) {
            return ProtoBuf$Visibility.valueOf(i);
        }
    }

    ProtoBuf$Visibility(int i, int i2) {
        this.value = i2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.a
    public final int getNumber() {
        return this.value;
    }

    public static ProtoBuf$Visibility valueOf(int i) {
        if (i == 0) {
            return INTERNAL;
        }
        if (i == 1) {
            return PRIVATE;
        }
        if (i == 2) {
            return PROTECTED;
        }
        if (i == 3) {
            return PUBLIC;
        }
        if (i == 4) {
            return PRIVATE_TO_THIS;
        }
        if (i != 5) {
            return null;
        }
        return LOCAL;
    }
}
