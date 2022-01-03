package i0.j.e.f1;

import com.instabug.library.model.StepType;
import com.instabug.library.visualusersteps.VisualUserStep;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;
/* compiled from: Parent.java */
/* loaded from: classes2.dex */
public class c {
    public final String a;
    public String b;
    public String c;
    public a d;
    public Deque<VisualUserStep> e = new LinkedBlockingDeque();
    public boolean f;

    /* compiled from: Parent.java */
    /* loaded from: classes2.dex */
    public static class a {
        public String a;
        public String b;

        public a(String str) {
            this.a = str;
        }
    }

    public c(String str, String str2, String str3) {
        this.b = str;
        this.c = str2;
        this.a = str3;
    }

    public void a(VisualUserStep visualUserStep) {
        this.e.add(visualUserStep);
        if (visualUserStep.getStepType() == null) {
            return;
        }
        if (visualUserStep.getStepType().equals(StepType.ACTIVITY_RESUMED) || visualUserStep.getStepType().equals(StepType.FRAGMENT_RESUMED)) {
            this.f = true;
        }
    }

    public VisualUserStep b() {
        Deque<VisualUserStep> deque = this.e;
        if (deque == null || deque.size() <= 0) {
            return null;
        }
        return this.e.peekLast();
    }
}
