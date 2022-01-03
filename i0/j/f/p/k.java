package i0.j.f.p;

import android.widget.TextView;
/* compiled from: TextSizeCalculator.java */
/* loaded from: classes2.dex */
public final class k implements Runnable {
    public final /* synthetic */ TextView c;

    public k(TextView textView) {
        this.c = textView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.c.getLineCount() > 2) {
            this.c.setTextSize(2, 16.0f);
            this.c.setLineSpacing(1.0f, 1.1f);
            this.c.setMaxLines(2);
        } else if (this.c.getLineCount() > 1) {
            this.c.setTextSize(2, 17.0f);
            this.c.setLineSpacing(1.0f, 1.1f);
            this.c.setMaxLines(2);
        }
    }
}
