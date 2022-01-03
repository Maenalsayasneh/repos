package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import m0.n.b.f;
import n0.c.e;
/* compiled from: JsonElement.kt */
@e(with = JsonElementSerializer.class)
/* loaded from: classes4.dex */
public abstract class JsonElement {
    public static final Companion Companion = new Companion(null);

    /* compiled from: JsonElement.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lkotlinx/serialization/json/JsonElement$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/json/JsonElement;", "serializer", "()Lkotlinx/serialization/KSerializer;", "<init>", "()V", "kotlinx-serialization-json"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes4.dex */
    public static final class Companion {
        public Companion() {
        }

        public final KSerializer<JsonElement> serializer() {
            return JsonElementSerializer.b;
        }

        public Companion(f fVar) {
        }
    }

    public JsonElement() {
    }

    public JsonElement(f fVar) {
    }
}
