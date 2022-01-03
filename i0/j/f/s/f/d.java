package i0.j.f.s.f;

import android.app.Activity;
import android.view.View;
/* compiled from: CustomQuestionDialog.java */
/* loaded from: classes2.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ Activity c;

    public d(Activity activity) {
        this.c = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.c.finish();
    }
}
