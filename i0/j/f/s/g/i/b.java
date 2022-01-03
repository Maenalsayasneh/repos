package i0.j.f.s.g.i;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.util.AttrResolver;
import com.instabug.library.util.DrawableUtils;
import com.instabug.survey.R;
import java.util.ArrayList;
/* compiled from: SurveyMCQGridAdapter.java */
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    public final LayoutInflater c;
    public a d;
    public com.instabug.survey.models.b q;
    public int x;
    public Context y;

    /* compiled from: SurveyMCQGridAdapter.java */
    /* loaded from: classes2.dex */
    public interface a {
        void O(View view, String str);
    }

    /* compiled from: SurveyMCQGridAdapter.java */
    /* renamed from: i0.j.f.s.g.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0205b {
        public LinearLayout a;
        public TextView b;
        public ImageView c;

        public C0205b() {
        }

        public C0205b(a aVar) {
        }
    }

    public b(Activity activity, com.instabug.survey.models.b bVar, a aVar) {
        this.x = -1;
        this.y = activity;
        this.c = LayoutInflater.from(activity);
        this.q = bVar;
        if (bVar.x != null) {
            int i = 0;
            while (true) {
                if (i < bVar.x.size()) {
                    String str = bVar.y;
                    if (str != null && str.equals(bVar.x.get(i))) {
                        this.x = i;
                        break;
                    }
                    i++;
                } else {
                    break;
                }
            }
        }
        this.d = aVar;
    }

    /* renamed from: a */
    public String getItem(int i) {
        ArrayList<String> arrayList = this.q.x;
        if (arrayList == null) {
            return "null";
        }
        return arrayList.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<String> arrayList;
        com.instabug.survey.models.b bVar = this.q;
        if (bVar == null || (arrayList = bVar.x) == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return (long) i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        C0205b bVar;
        ArrayList<String> arrayList;
        if (view == null) {
            bVar = new C0205b(null);
            view2 = this.c.inflate(R.layout.instabug_survey_mcq_item, (ViewGroup) null);
            bVar.a = (LinearLayout) view2.findViewById(R.id.mcq_item);
            bVar.b = (TextView) view2.findViewById(R.id.survey_optional_answer_textview);
            bVar.c = (ImageView) view2.findViewById(R.id.selector_img);
            view2.setTag(bVar);
        } else {
            bVar = (C0205b) view.getTag();
            view2 = view;
        }
        ArrayList<String> arrayList2 = this.q.x;
        if (arrayList2 != null) {
            bVar.b.setText(arrayList2.get(i));
        }
        if (i == this.x) {
            if (Instabug.getTheme() == InstabugColorTheme.InstabugColorThemeLight) {
                DrawableUtils.setColor(bVar.a, h0.i.c.a.c(Instabug.getPrimaryColor(), 25));
            } else {
                DrawableUtils.setColor(bVar.a, h0.i.c.a.c(Instabug.getPrimaryColor(), 50));
            }
            bVar.b.setTextColor(AttrResolver.resolveAttributeColor(this.y, R.attr.instabug_survey_mcq_text_color_selected));
            bVar.c.setColorFilter(Instabug.getPrimaryColor());
            bVar.c.setImageResource(R.drawable.ibg_survey_ic_mcq_selected);
        } else {
            DrawableUtils.setColor(bVar.a, AttrResolver.resolveAttributeColor(this.y, R.attr.instabug_survey_mcq_unselected_bg));
            bVar.b.setTextColor(AttrResolver.resolveAttributeColor(this.y, R.attr.instabug_survey_mcq_text_color));
            bVar.c.setColorFilter(AttrResolver.resolveAttributeColor(this.y, R.attr.instabug_survey_mcq_radio_icon_color));
            bVar.c.setImageResource(R.drawable.ibg_survey_ic_mcq_unselected);
        }
        if (!(this.d == null || (arrayList = this.q.x) == null)) {
            bVar.b.setOnClickListener(new a(this, i, arrayList.get(i)));
            bVar.c.setOnClickListener(new a(this, i, this.q.x.get(i)));
        }
        return view2;
    }
}
