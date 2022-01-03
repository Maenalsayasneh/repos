package i0.j.f.s.g.i;

import android.view.View;
/* compiled from: SurveyMCQGridAdapter.java */
/* loaded from: classes2.dex */
public class a implements View.OnClickListener {
    public final /* synthetic */ int c;
    public final /* synthetic */ String d;
    public final /* synthetic */ b q;

    public a(b bVar, int i, String str) {
        this.q = bVar;
        this.c = i;
        this.d = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar = this.q;
        bVar.x = this.c;
        bVar.notifyDataSetChanged();
        this.q.d.O(view, this.d);
    }
}
