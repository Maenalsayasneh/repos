package i0.i;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.hbb20.CountryCodePicker;
import com.hbb20.R;
import i0.g.a.c;
import java.util.ArrayList;
import java.util.List;
/* compiled from: CountryCodeAdapter.java */
/* loaded from: classes2.dex */
public class h extends RecyclerView.Adapter<a> implements c {
    public List<a> a;
    public List<a> b;
    public TextView c;
    public CountryCodePicker d;
    public LayoutInflater e;
    public EditText f;
    public Dialog g;
    public Context h;
    public RelativeLayout i;
    public ImageView j;
    public int k = 0;

    /* compiled from: CountryCodeAdapter.java */
    /* loaded from: classes2.dex */
    public class a extends RecyclerView.b0 {
        public RelativeLayout a;
        public TextView b;
        public TextView c;
        public ImageView d;
        public LinearLayout e;
        public View f;

        public a(View view) {
            super(view);
            RelativeLayout relativeLayout = (RelativeLayout) view;
            this.a = relativeLayout;
            this.b = (TextView) relativeLayout.findViewById(R.id.textView_countryName);
            this.c = (TextView) this.a.findViewById(R.id.textView_code);
            this.d = (ImageView) this.a.findViewById(R.id.image_flag);
            this.e = (LinearLayout) this.a.findViewById(R.id.linear_flag_holder);
            this.f = this.a.findViewById(R.id.preferenceDivider);
            if (h.this.d.getDialogTextColor() != 0) {
                this.b.setTextColor(h.this.d.getDialogTextColor());
                this.c.setTextColor(h.this.d.getDialogTextColor());
                this.f.setBackgroundColor(h.this.d.getDialogTextColor());
            }
            try {
                if (h.this.d.getDialogTypeFace() == null) {
                    return;
                }
                if (h.this.d.getDialogTypeFaceStyle() != -99) {
                    this.c.setTypeface(h.this.d.getDialogTypeFace(), h.this.d.getDialogTypeFaceStyle());
                    this.b.setTypeface(h.this.d.getDialogTypeFace(), h.this.d.getDialogTypeFaceStyle());
                    return;
                }
                this.c.setTypeface(h.this.d.getDialogTypeFace());
                this.b.setTypeface(h.this.d.getDialogTypeFace());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public h(Context context, List<a> list, CountryCodePicker countryCodePicker, RelativeLayout relativeLayout, EditText editText, TextView textView, Dialog dialog, ImageView imageView) {
        this.a = null;
        this.b = null;
        this.h = context;
        this.b = list;
        this.d = countryCodePicker;
        this.g = dialog;
        this.c = textView;
        this.f = editText;
        this.i = relativeLayout;
        this.j = imageView;
        this.e = LayoutInflater.from(context);
        this.a = b("");
        if (this.d.z2) {
            this.j.setVisibility(8);
            EditText editText2 = this.f;
            if (editText2 != null) {
                editText2.addTextChangedListener(new e(this));
                this.f.setOnEditorActionListener(new f(this));
            }
            this.j.setOnClickListener(new d(this));
            return;
        }
        this.i.setVisibility(8);
    }

    @Override // i0.g.a.c
    public String a(int i) {
        a aVar = this.a.get(i);
        if (this.k > i) {
            return "★";
        }
        return aVar != null ? aVar.a2.substring(0, 1) : "☺";
    }

    public final List<a> b(String str) {
        ArrayList arrayList = new ArrayList();
        this.k = 0;
        List<a> list = this.d.Q2;
        if (list != null && list.size() > 0) {
            for (a aVar : this.d.Q2) {
                if (aVar.r(str)) {
                    arrayList.add(aVar);
                    this.k++;
                }
            }
            if (arrayList.size() > 0) {
                arrayList.add(null);
                this.k++;
            }
        }
        for (a aVar2 : this.b) {
            if (aVar2.r(str)) {
                arrayList.add(aVar2);
            }
        }
        return arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(a aVar, int i) {
        a aVar2 = aVar;
        a aVar3 = this.a.get(i);
        if (aVar3 != null) {
            aVar2.f.setVisibility(8);
            aVar2.b.setVisibility(0);
            aVar2.c.setVisibility(0);
            if (h.this.d.t2) {
                aVar2.c.setVisibility(0);
            } else {
                aVar2.c.setVisibility(8);
            }
            String str = "";
            if (h.this.d.getCcpDialogShowFlag() && h.this.d.G2) {
                StringBuilder P0 = i0.d.a.a.a.P0(str);
                P0.append(a.l(aVar3));
                P0.append("   ");
                str = P0.toString();
            }
            StringBuilder P02 = i0.d.a.a.a.P0(str);
            P02.append(aVar3.a2);
            String sb = P02.toString();
            if (h.this.d.getCcpDialogShowNameCode()) {
                StringBuilder S0 = i0.d.a.a.a.S0(sb, " (");
                S0.append(aVar3.Y1.toUpperCase());
                S0.append(")");
                sb = S0.toString();
            }
            aVar2.b.setText(sb);
            TextView textView = aVar2.c;
            StringBuilder P03 = i0.d.a.a.a.P0("+");
            P03.append(aVar3.Z1);
            textView.setText(P03.toString());
            if (!h.this.d.getCcpDialogShowFlag() || h.this.d.G2) {
                aVar2.e.setVisibility(8);
            } else {
                aVar2.e.setVisibility(0);
                aVar2.d.setImageResource(aVar3.n());
            }
        } else {
            aVar2.f.setVisibility(0);
            aVar2.b.setVisibility(8);
            aVar2.c.setVisibility(8);
            aVar2.e.setVisibility(8);
        }
        if (this.a.size() <= i || this.a.get(i) == null) {
            aVar2.a.setOnClickListener(null);
        } else {
            aVar2.a.setOnClickListener(new g(this, i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(this.e.inflate(R.layout.layout_recycler_country_tile, viewGroup, false));
    }
}
