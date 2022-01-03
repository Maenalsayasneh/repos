package i0.j.e;

import com.instabug.library.internal.utils.stability.execution.ReturnableExecutable;
import java.lang.reflect.Field;
/* compiled from: ReflectionUtils.java */
/* loaded from: classes2.dex */
public final class b0 implements ReturnableExecutable<Field> {
    public final /* synthetic */ Class a;
    public final /* synthetic */ String b;

    public b0(Class cls, String str) {
        this.a = cls;
        this.b = str;
    }

    @Override // com.instabug.library.internal.utils.stability.execution.ReturnableExecutable
    public Field execute() throws Exception {
        Field declaredField = this.a.getDeclaredField(this.b);
        declaredField.setAccessible(true);
        return declaredField;
    }
}
