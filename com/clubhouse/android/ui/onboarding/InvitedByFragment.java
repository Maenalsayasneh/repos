package com.clubhouse.android.ui.onboarding;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.clubhouse.android.databinding.FragmentInvitedByBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.shared.ui.AvatarView;
import com.clubhouse.android.ui.onboarding.InvitedByFragment;
import com.clubhouse.android.ui.onboarding.InvitedByFragment$onViewCreated$1$1;
import com.clubhouse.app.R;
import h0.b0.v;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.d.a.a.a;
import i0.e.b.g3.r.h1;
import i0.e.b.g3.r.k1;
import i0.e.b.g3.r.l1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.PropertyReference1Impl;
import m0.c;
import m0.n.a.l;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
/* compiled from: InvitedByFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0017\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u00020\u000b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0016\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/clubhouse/android/ui/onboarding/InvitedByFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lcom/clubhouse/android/databinding/FragmentInvitedByBinding;", "a2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "getBinding", "()Lcom/clubhouse/android/databinding/FragmentInvitedByBinding;", "binding", "Li0/e/b/g3/r/l1;", "b2", "Lm0/c;", "getViewModel", "()Li0/e/b/g3/r/l1;", "viewModel", "<init>", "BundleInfo", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class InvitedByFragment extends Hilt_InvitedByFragment {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(InvitedByFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentInvitedByBinding;")), m.c(new PropertyReference1Impl(m.a(InvitedByFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/onboarding/InvitedByViewModel;"))};
    public final FragmentViewBindingDelegate a2 = new FragmentViewBindingDelegate(FragmentInvitedByBinding.class, this);
    public final c b2;

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<InvitedByFragment, l1> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<l1> a(InvitedByFragment invitedByFragment, k kVar) {
            InvitedByFragment invitedByFragment2 = invitedByFragment;
            i.e(invitedByFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(invitedByFragment2, kVar, this.a, new InvitedByFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(k1.class), false, this.b);
        }
    }

    public InvitedByFragment() {
        super(R.layout.fragment_invited_by);
        d a2 = m.a(l1.class);
        this.b2 = new a(a2, false, new l<i0.b.b.k<l1, k1>, l1>(a2, a2) { // from class: com.clubhouse.android.ui.onboarding.InvitedByFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [i0.e.b.g3.r.l1, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.l
            public l1 invoke(i0.b.b.k<l1, k1> kVar) {
                i0.b.b.k<l1, k1> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, k1.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, Z1[1]);
    }

    public static final void N0(InvitedByFragment invitedByFragment, FragmentInvitedByBinding fragmentInvitedByBinding, String str, String str2) {
        Objects.requireNonNull(invitedByFragment);
        TextView textView = fragmentInvitedByBinding.b;
        Resources resources = invitedByFragment.getResources();
        i.d(resources, "resources");
        Object[] objArr = {str};
        ArrayList i1 = i0.d.a.a.a.i1(resources, "<this>", objArr, "rawArgs", 1);
        for (int i = 0; i < 1; i++) {
            Object obj = objArr[i];
            if (obj instanceof String) {
                String str3 = (String) obj;
                obj = i0.d.a.a.a.p0(str3, "<this>", str3, 63);
            }
            i1.add(obj);
        }
        String string = resources.getString(R.string.invited_by_club_name);
        i.d(string, "getString(id)");
        Object[] array = i1.toArray(new Object[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        Object[] copyOf = Arrays.copyOf(array, array.length);
        String format = String.format(string, Arrays.copyOf(copyOf, copyOf.length));
        i.d(format, "java.lang.String.format(format, *args)");
        Spanned fromHtml = Html.fromHtml(format, 63);
        i.d(fromHtml, "fromHtml(\n            String.format(getString(id), *args.toTypedArray()),\n            HtmlCompat.FROM_HTML_MODE_COMPACT\n        )");
        textView.setText(fromHtml);
        fragmentInvitedByBinding.a.setText(AvatarView.c.a(str));
        fragmentInvitedByBinding.a.setSquareness(0.88f);
        AvatarView avatarView = fragmentInvitedByBinding.a;
        i.d(avatarView, "inviterImage");
        v.Q0(avatarView, str2);
    }

    public static final FragmentInvitedByBinding O0(InvitedByFragment invitedByFragment) {
        return (FragmentInvitedByBinding) invitedByFragment.a2.getValue(invitedByFragment, Z1[0]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2((l1) this.b2.getValue(), new l<k1, m0.i>() { // from class: com.clubhouse.android.ui.onboarding.InvitedByFragment$invalidate$1
            @Override // m0.n.a.l
            public m0.i invoke(k1 k1Var) {
                CharSequence charSequence;
                k1 k1Var2 = k1Var;
                i.e(k1Var2, "state");
                TextView textView = InvitedByFragment.O0(InvitedByFragment.this).d;
                h1 h1Var = k1Var2.a;
                int i = 0;
                if (h1Var instanceof h1.c) {
                    charSequence = InvitedByFragment.this.getText(R.string.welcome_set_up_profile);
                } else if (h1Var instanceof h1.d) {
                    Resources resources = InvitedByFragment.this.getResources();
                    i.d(resources, "resources");
                    Object[] objArr = {((h1.d) k1Var2.a).a};
                    ArrayList i1 = a.i1(resources, "<this>", objArr, "rawArgs", 1);
                    int i2 = 0;
                    for (int i3 = 1; i2 < i3; i3 = 1) {
                        Object obj = objArr[i2];
                        if (obj instanceof String) {
                            String str = (String) obj;
                            obj = a.p0(str, "<this>", str, 63);
                        }
                        i1.add(obj);
                        i2++;
                    }
                    String string = resources.getString(R.string.welcome_inviter_name);
                    i.d(string, "getString(id)");
                    Object[] array = i1.toArray(new Object[0]);
                    Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                    Object[] copyOf = Arrays.copyOf(array, array.length);
                    charSequence = a.L(copyOf, copyOf.length, string, "java.lang.String.format(format, *args)", 63, "fromHtml(\n            String.format(getString(id), *args.toTypedArray()),\n            HtmlCompat.FROM_HTML_MODE_COMPACT\n        )");
                } else if (h1Var instanceof h1.a) {
                    Resources resources2 = InvitedByFragment.this.getResources();
                    i.d(resources2, "resources");
                    Object[] objArr2 = {((h1.a) k1Var2.a).a};
                    ArrayList i12 = a.i1(resources2, "<this>", objArr2, "rawArgs", 1);
                    int i4 = 0;
                    for (int i5 = 1; i4 < i5; i5 = 1) {
                        Object obj2 = objArr2[i4];
                        if (obj2 instanceof String) {
                            String str2 = (String) obj2;
                            obj2 = a.p0(str2, "<this>", str2, 63);
                        }
                        i12.add(obj2);
                        i4++;
                    }
                    String string2 = resources2.getString(R.string.welcome_inviter_club);
                    i.d(string2, "getString(id)");
                    Object[] array2 = i12.toArray(new Object[0]);
                    Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
                    Object[] copyOf2 = Arrays.copyOf(array2, array2.length);
                    charSequence = a.L(copyOf2, copyOf2.length, string2, "java.lang.String.format(format, *args)", 63, "fromHtml(\n            String.format(getString(id), *args.toTypedArray()),\n            HtmlCompat.FROM_HTML_MODE_COMPACT\n        )");
                } else if (h1Var instanceof h1.b) {
                    Resources resources3 = InvitedByFragment.this.getResources();
                    i.d(resources3, "resources");
                    h1.b bVar = (h1.b) k1Var2.a;
                    Object[] objArr3 = {bVar.a, bVar.b};
                    ArrayList i13 = a.i1(resources3, "<this>", objArr3, "rawArgs", 2);
                    int i6 = 0;
                    for (int i7 = 2; i6 < i7; i7 = 2) {
                        Object obj3 = objArr3[i6];
                        if (obj3 instanceof String) {
                            String str3 = (String) obj3;
                            obj3 = a.p0(str3, "<this>", str3, 63);
                        }
                        i13.add(obj3);
                        i6++;
                    }
                    String string3 = resources3.getString(R.string.welcome_inviter_club_name);
                    i.d(string3, "getString(id)");
                    Object[] array3 = i13.toArray(new Object[0]);
                    Objects.requireNonNull(array3, "null cannot be cast to non-null type kotlin.Array<T>");
                    Object[] copyOf3 = Arrays.copyOf(array3, array3.length);
                    charSequence = a.L(copyOf3, copyOf3.length, string3, "java.lang.String.format(format, *args)", 63, "fromHtml(\n            String.format(getString(id), *args.toTypedArray()),\n            HtmlCompat.FROM_HTML_MODE_COMPACT\n        )");
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                textView.setText(charSequence);
                AvatarView avatarView = InvitedByFragment.O0(InvitedByFragment.this).a;
                i.d(avatarView, "binding.inviterImage");
                h1 h1Var2 = k1Var2.a;
                h1.c cVar = h1.c.a;
                avatarView.setVisibility(i.a(h1Var2, cVar) ^ true ? 0 : 8);
                TextView textView2 = InvitedByFragment.O0(InvitedByFragment.this).b;
                i.d(textView2, "binding.inviterName");
                if (!(!i.a(k1Var2.a, cVar))) {
                    i = 8;
                }
                textView2.setVisibility(i);
                h1 h1Var3 = k1Var2.a;
                if (h1Var3 instanceof h1.d) {
                    String str4 = ((h1.d) h1Var3).a;
                    InvitedByFragment.O0(InvitedByFragment.this).b.setText(str4);
                    InvitedByFragment.O0(InvitedByFragment.this).a.setText(AvatarView.c.a(str4));
                    AvatarView avatarView2 = InvitedByFragment.O0(InvitedByFragment.this).a;
                    i.d(avatarView2, "binding.inviterImage");
                    v.Q0(avatarView2, ((h1.d) k1Var2.a).b);
                } else if (h1Var3 instanceof h1.a) {
                    InvitedByFragment invitedByFragment = InvitedByFragment.this;
                    FragmentInvitedByBinding O0 = InvitedByFragment.O0(invitedByFragment);
                    h1.a aVar = (h1.a) k1Var2.a;
                    InvitedByFragment.N0(invitedByFragment, O0, aVar.a, aVar.b);
                } else if (h1Var3 instanceof h1.b) {
                    InvitedByFragment invitedByFragment2 = InvitedByFragment.this;
                    FragmentInvitedByBinding O02 = InvitedByFragment.O0(invitedByFragment2);
                    h1.b bVar2 = (h1.b) k1Var2.a;
                    InvitedByFragment.N0(invitedByFragment2, O02, bVar2.b, bVar2.c);
                }
                return m0.i.a;
            }
        });
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.e(view, "view");
        super.onViewCreated(view, bundle);
        ((FragmentInvitedByBinding) this.a2.getValue(this, Z1[0])).c.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.r.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                InvitedByFragment invitedByFragment = InvitedByFragment.this;
                k<Object>[] kVarArr = InvitedByFragment.Z1;
                i.e(invitedByFragment, "this$0");
                v.a1(invitedByFragment, (h0.t.l) v.v2((l1) invitedByFragment.b2.getValue(), InvitedByFragment$onViewCreated$1$1.c), null, 2);
            }
        });
    }

    /* compiled from: InvitedByFragment.kt */
    /* loaded from: classes3.dex */
    public static final class BundleInfo implements Parcelable {
        public static final Parcelable.Creator<BundleInfo> CREATOR = new a();
        public final String c;
        public final String d;
        public final String q;
        public final String x;

        /* compiled from: InvitedByFragment.kt */
        /* loaded from: classes3.dex */
        public static final class a implements Parcelable.Creator<BundleInfo> {
            @Override // android.os.Parcelable.Creator
            public BundleInfo createFromParcel(Parcel parcel) {
                i.e(parcel, "parcel");
                return new BundleInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            public BundleInfo[] newArray(int i) {
                return new BundleInfo[i];
            }
        }

        public BundleInfo(String str, String str2, String str3, String str4) {
            this.c = str;
            this.d = str2;
            this.q = str3;
            this.x = str4;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BundleInfo)) {
                return false;
            }
            BundleInfo bundleInfo = (BundleInfo) obj;
            return i.a(this.c, bundleInfo.c) && i.a(this.d, bundleInfo.d) && i.a(this.q, bundleInfo.q) && i.a(this.x, bundleInfo.x);
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.c;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.d;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.q;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.x;
            if (str4 != null) {
                i = str4.hashCode();
            }
            return hashCode3 + i;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder P0 = i0.d.a.a.a.P0("BundleInfo(inviterName=");
            P0.append((Object) this.c);
            P0.append(", inviterPhotoUrl=");
            P0.append((Object) this.d);
            P0.append(", clubName=");
            P0.append((Object) this.q);
            P0.append(", clubPhotoUrl=");
            return i0.d.a.a.a.w0(P0, this.x, ')');
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            i.e(parcel, "out");
            parcel.writeString(this.c);
            parcel.writeString(this.d);
            parcel.writeString(this.q);
            parcel.writeString(this.x);
        }

        public BundleInfo() {
            this(null, null, null, null);
        }
    }
}
