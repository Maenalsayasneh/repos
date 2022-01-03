package i0.h.a.b.e;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;
/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
/* loaded from: classes2.dex */
public final class d implements DynamiteModule.a {
    @Override // com.google.android.gms.dynamite.DynamiteModule.a
    public final DynamiteModule.a.C0009a a(Context context, String str, DynamiteModule.a.b bVar) throws DynamiteModule.LoadingException {
        DynamiteModule.a.C0009a aVar = new DynamiteModule.a.C0009a();
        int a = bVar.a(context, str, true);
        aVar.b = a;
        if (a != 0) {
            aVar.c = 1;
        } else {
            int b = bVar.b(context, str);
            aVar.a = b;
            if (b != 0) {
                aVar.c = -1;
            }
        }
        return aVar;
    }
}
