package i0.j.e;

import com.instabug.library.internal.utils.stability.execution.ReturnableExecutable;
import java.lang.reflect.Method;
/* compiled from: ReflectionUtils.java */
/* loaded from: classes2.dex */
public final class d0 implements ReturnableExecutable<Method> {
    public final /* synthetic */ Class a;
    public final /* synthetic */ String b;

    public d0(Class cls, String str) {
        this.a = cls;
        this.b = str;
    }

    @Override // com.instabug.library.internal.utils.stability.execution.ReturnableExecutable
    public Method execute() throws Exception {
        Method[] declaredMethods = this.a.getDeclaredMethods();
        for (Method method : declaredMethods) {
            if (method.getName().equals(this.b)) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }
}
