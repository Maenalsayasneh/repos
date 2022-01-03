package com.clubhouse.android.ui.creation;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import com.airbnb.epoxy.EpoxyRecyclerView;
import com.clubhouse.android.channels.model.AudienceType;
import com.clubhouse.android.data.models.local.club.ClubWithAdmin;
import com.clubhouse.android.data.models.local.user.UserInList;
import com.clubhouse.android.data.models.remote.response.GetCreateChannelTargetsResponse;
import com.clubhouse.android.databinding.CreateChannelBinding;
import com.clubhouse.android.databinding.CreateChannelEventCellBinding;
import com.clubhouse.android.databinding.FragmentCreateChannelBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.ui.creation.ChooseUsersFragment;
import com.clubhouse.android.ui.creation.CreateChannelFragment;
import com.clubhouse.android.ui.creation.CreateChannelFragment$onViewCreated$3$1;
import com.clubhouse.android.ui.creation.TopicDialogFragment;
import com.clubhouse.app.R;
import h0.b0.g;
import h0.b0.v;
import h0.q.p;
import h0.q.q;
import i0.b.a.o;
import i0.b.b.x;
import i0.e.b.g3.n.t;
import i0.e.b.z2.f.a;
import i0.j.f.p.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import m0.c;
import m0.n.a.l;
import m0.n.b.f;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
/* compiled from: CreateChannelFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001.B\u0007¢\u0006\u0004\b,\u0010\u000bJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000f\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0016\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001c\u001a\u00020\u00178B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010!\u001a\u00020\u001d8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010 R\u001d\u0010&\u001a\u00020\"8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0019\u001a\u0004\b$\u0010%R\u001d\u0010+\u001a\u00020'8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0019\u001a\u0004\b)\u0010*¨\u0006/"}, d2 = {"Lcom/clubhouse/android/ui/creation/CreateChannelFragment;", "Lcom/clubhouse/android/core/ui/BaseBottomSheetFragment;", "Lcom/clubhouse/android/ui/creation/ChooseUsersFragment$a;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "", "Lcom/clubhouse/android/data/models/local/user/UserInList;", "selectedUsers", "v", "(Ljava/util/List;)V", "Lcom/clubhouse/android/databinding/FragmentCreateChannelBinding;", "s2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "getRootBinding", "()Lcom/clubhouse/android/databinding/FragmentCreateChannelBinding;", "rootBinding", "Lcom/clubhouse/android/databinding/CreateChannelEventCellBinding;", "u2", "Lm0/c;", "V0", "()Lcom/clubhouse/android/databinding/CreateChannelEventCellBinding;", "eventBinding", "Lcom/clubhouse/android/ui/creation/CreateChannelViewModel;", "r2", "W0", "()Lcom/clubhouse/android/ui/creation/CreateChannelViewModel;", "viewModel", "Lh0/b0/g;", "v2", "getDefaultScene", "()Lh0/b0/g;", "defaultScene", "Lcom/clubhouse/android/databinding/CreateChannelBinding;", "t2", "U0", "()Lcom/clubhouse/android/databinding/CreateChannelBinding;", "binding", "<init>", "p2", "a", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class CreateChannelFragment extends Hilt_CreateChannelFragment implements ChooseUsersFragment.a {
    public static final a p2 = new a(null);
    public static final /* synthetic */ k<Object>[] q2;
    public final c r2;
    public final FragmentViewBindingDelegate s2 = new FragmentViewBindingDelegate(FragmentCreateChannelBinding.class, this);
    public final c t2 = h.H2(new m0.n.a.a<CreateChannelBinding>() { // from class: com.clubhouse.android.ui.creation.CreateChannelFragment$binding$2
        @Override // m0.n.a.a
        public CreateChannelBinding invoke() {
            return CreateChannelBinding.inflate(CreateChannelFragment.this.getLayoutInflater());
        }
    });
    public final c u2 = h.H2(new m0.n.a.a<CreateChannelEventCellBinding>() { // from class: com.clubhouse.android.ui.creation.CreateChannelFragment$eventBinding$2
        @Override // m0.n.a.a
        public CreateChannelEventCellBinding invoke() {
            return CreateChannelEventCellBinding.inflate(CreateChannelFragment.this.getLayoutInflater());
        }
    });
    public final c v2 = h.H2(new m0.n.a.a<g>() { // from class: com.clubhouse.android.ui.creation.CreateChannelFragment$defaultScene$2
        @Override // m0.n.a.a
        public g invoke() {
            CreateChannelFragment createChannelFragment = CreateChannelFragment.this;
            return new g(((FragmentCreateChannelBinding) createChannelFragment.s2.getValue(createChannelFragment, CreateChannelFragment.q2[1])).a, CreateChannelFragment.this.U0().a);
        }
    });

    /* compiled from: CreateChannelFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a(f fVar) {
        }
    }

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class b extends i0.b.b.h<CreateChannelFragment, CreateChannelViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public b(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<CreateChannelViewModel> a(CreateChannelFragment createChannelFragment, k kVar) {
            CreateChannelFragment createChannelFragment2 = createChannelFragment;
            i.e(createChannelFragment2, "thisRef");
            i.e(kVar, "property");
            return i0.b.b.g.a.b(createChannelFragment2, kVar, this.a, new CreateChannelFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(t.class), false, this.b);
        }
    }

    static {
        k<Object>[] kVarArr = new k[5];
        kVarArr[0] = m.c(new PropertyReference1Impl(m.a(CreateChannelFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/creation/CreateChannelViewModel;"));
        kVarArr[1] = m.c(new PropertyReference1Impl(m.a(CreateChannelFragment.class), "rootBinding", "getRootBinding()Lcom/clubhouse/android/databinding/FragmentCreateChannelBinding;"));
        q2 = kVarArr;
    }

    public CreateChannelFragment() {
        super(R.layout.fragment_create_channel);
        d a2 = m.a(CreateChannelViewModel.class);
        this.r2 = new b(a2, false, new l<i0.b.b.k<CreateChannelViewModel, t>, CreateChannelViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.creation.CreateChannelFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.clubhouse.android.ui.creation.CreateChannelViewModel, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.l
            public CreateChannelViewModel invoke(i0.b.b.k<CreateChannelViewModel, t> kVar) {
                i0.b.b.k<CreateChannelViewModel, t> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, t.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, q2[0]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(W0(), new l<t, m0.i>() { // from class: com.clubhouse.android.ui.creation.CreateChannelFragment$invalidate$1
            /* JADX WARN: Removed duplicated region for block: B:104:0x029c  */
            /* JADX WARN: Removed duplicated region for block: B:105:0x02a9  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0058  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x0098  */
            /* JADX WARN: Removed duplicated region for block: B:37:0x00da  */
            /* JADX WARN: Removed duplicated region for block: B:44:0x011c  */
            /* JADX WARN: Removed duplicated region for block: B:60:0x015e  */
            /* JADX WARN: Removed duplicated region for block: B:67:0x01a0  */
            /* JADX WARN: Removed duplicated region for block: B:81:0x01df  */
            /* JADX WARN: Removed duplicated region for block: B:89:0x022f  */
            @Override // m0.n.a.l
            /* Code decompiled incorrectly, please refer to instructions dump */
            public m0.i invoke(t tVar) {
                boolean z;
                CharSequence charSequence;
                String str;
                String str2;
                boolean z2;
                boolean z3;
                int i;
                boolean z4;
                int i2;
                boolean z5;
                t tVar2 = tVar;
                i.e(tVar2, "state");
                CreateChannelFragment createChannelFragment = CreateChannelFragment.this;
                CreateChannelFragment.a aVar = CreateChannelFragment.p2;
                createChannelFragment.U0().c.g();
                TextView textView = CreateChannelFragment.this.U0().f;
                Resources resources = CreateChannelFragment.this.getResources();
                i.d(resources, "resources");
                i.e(tVar2, "<this>");
                i.e(resources, "resources");
                a aVar2 = tVar2.c;
                int i3 = 0;
                if (aVar2 == AudienceType.Closed) {
                    String str3 = tVar2.e;
                    if (str3 != null) {
                        if (str3.length() > 0) {
                            z5 = true;
                            if (!z5) {
                                Object[] objArr = {tVar2.e};
                                ArrayList i1 = i0.d.a.a.a.i1(resources, "<this>", objArr, "rawArgs", 1);
                                for (int i4 = 1; i3 < i4; i4 = 1) {
                                    Object obj = objArr[i3];
                                    if (obj instanceof String) {
                                        String str4 = (String) obj;
                                        obj = i0.d.a.a.a.p0(str4, "<this>", str4, 63);
                                    }
                                    i1.add(obj);
                                    i3++;
                                }
                                String string = resources.getString(R.string.channel_explanation_closed_with_title);
                                i.d(string, "getString(id)");
                                Object[] array = i1.toArray(new Object[0]);
                                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                                Object[] copyOf = Arrays.copyOf(array, array.length);
                                charSequence = i0.d.a.a.a.L(copyOf, copyOf.length, string, "java.lang.String.format(format, *args)", 63, "fromHtml(\n            String.format(getString(id), *args.toTypedArray()),\n            HtmlCompat.FROM_HTML_MODE_COMPACT\n        )");
                            } else {
                                ArrayList i12 = i0.d.a.a.a.i1(resources, "<this>", new Object[0], "rawArgs", 0);
                                String string2 = resources.getString(R.string.channel_explanation_closed);
                                i.d(string2, "getString(id)");
                                Object[] array2 = i12.toArray(new Object[0]);
                                Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
                                Object[] copyOf2 = Arrays.copyOf(array2, array2.length);
                                charSequence = i0.d.a.a.a.L(copyOf2, copyOf2.length, string2, "java.lang.String.format(format, *args)", 63, "fromHtml(\n            String.format(getString(id), *args.toTypedArray()),\n            HtmlCompat.FROM_HTML_MODE_COMPACT\n        )");
                            }
                        }
                    }
                    z5 = false;
                    if (!z5) {
                    }
                } else if (aVar2 == AudienceType.Open) {
                    String str5 = tVar2.e;
                    if (str5 == null) {
                        i2 = 1;
                    } else {
                        z4 = true;
                        if (str5.length() > 0) {
                            i2 = 1;
                            if (!z4) {
                                Object[] objArr2 = new Object[i2];
                                objArr2[0] = tVar2.e;
                                ArrayList i13 = i0.d.a.a.a.i1(resources, "<this>", objArr2, "rawArgs", i2);
                                int i5 = 0;
                                while (i5 < i2) {
                                    Object obj2 = objArr2[i5];
                                    if (obj2 instanceof String) {
                                        String str6 = (String) obj2;
                                        obj2 = i0.d.a.a.a.p0(str6, "<this>", str6, 63);
                                    }
                                    i13.add(obj2);
                                    i5++;
                                    i2 = 1;
                                }
                                String string3 = resources.getString(R.string.channel_explanation_open_with_title);
                                i.d(string3, "getString(id)");
                                Object[] array3 = i13.toArray(new Object[0]);
                                Objects.requireNonNull(array3, "null cannot be cast to non-null type kotlin.Array<T>");
                                Object[] copyOf3 = Arrays.copyOf(array3, array3.length);
                                charSequence = i0.d.a.a.a.L(copyOf3, copyOf3.length, string3, "java.lang.String.format(format, *args)", 63, "fromHtml(\n            String.format(getString(id), *args.toTypedArray()),\n            HtmlCompat.FROM_HTML_MODE_COMPACT\n        )");
                            } else {
                                ArrayList i14 = i0.d.a.a.a.i1(resources, "<this>", new Object[0], "rawArgs", 0);
                                String string4 = resources.getString(R.string.channel_explanation_open);
                                i.d(string4, "getString(id)");
                                Object[] array4 = i14.toArray(new Object[0]);
                                Objects.requireNonNull(array4, "null cannot be cast to non-null type kotlin.Array<T>");
                                Object[] copyOf4 = Arrays.copyOf(array4, array4.length);
                                charSequence = i0.d.a.a.a.L(copyOf4, copyOf4.length, string4, "java.lang.String.format(format, *args)", 63, "fromHtml(\n            String.format(getString(id), *args.toTypedArray()),\n            HtmlCompat.FROM_HTML_MODE_COMPACT\n        )");
                            }
                        } else {
                            i2 = 1;
                        }
                    }
                    z4 = false;
                    if (!z4) {
                    }
                } else if (aVar2 == AudienceType.Social) {
                    String str7 = tVar2.e;
                    if (str7 == null) {
                        i = 1;
                    } else {
                        z3 = true;
                        if (str7.length() > 0) {
                            i = 1;
                            if (!z3) {
                                Object[] objArr3 = new Object[i];
                                objArr3[0] = tVar2.e;
                                ArrayList i15 = i0.d.a.a.a.i1(resources, "<this>", objArr3, "rawArgs", i);
                                int i6 = 0;
                                while (i6 < i) {
                                    Object obj3 = objArr3[i6];
                                    if (obj3 instanceof String) {
                                        String str8 = (String) obj3;
                                        obj3 = i0.d.a.a.a.p0(str8, "<this>", str8, 63);
                                    }
                                    i15.add(obj3);
                                    i6++;
                                    i = 1;
                                }
                                String string5 = resources.getString(R.string.channel_explanation_social_with_title);
                                i.d(string5, "getString(id)");
                                Object[] array5 = i15.toArray(new Object[0]);
                                Objects.requireNonNull(array5, "null cannot be cast to non-null type kotlin.Array<T>");
                                Object[] copyOf5 = Arrays.copyOf(array5, array5.length);
                                charSequence = i0.d.a.a.a.L(copyOf5, copyOf5.length, string5, "java.lang.String.format(format, *args)", 63, "fromHtml(\n            String.format(getString(id), *args.toTypedArray()),\n            HtmlCompat.FROM_HTML_MODE_COMPACT\n        )");
                            } else {
                                ArrayList i16 = i0.d.a.a.a.i1(resources, "<this>", new Object[0], "rawArgs", 0);
                                String string6 = resources.getString(R.string.channel_explanation_social);
                                i.d(string6, "getString(id)");
                                Object[] array6 = i16.toArray(new Object[0]);
                                Objects.requireNonNull(array6, "null cannot be cast to non-null type kotlin.Array<T>");
                                Object[] copyOf6 = Arrays.copyOf(array6, array6.length);
                                charSequence = i0.d.a.a.a.L(copyOf6, copyOf6.length, string6, "java.lang.String.format(format, *args)", 63, "fromHtml(\n            String.format(getString(id), *args.toTypedArray()),\n            HtmlCompat.FROM_HTML_MODE_COMPACT\n        )");
                            }
                        } else {
                            i = 1;
                        }
                    }
                    z3 = false;
                    if (!z3) {
                    }
                } else {
                    if (aVar2 instanceof i0.e.b.z2.f.d) {
                        String str9 = tVar2.e;
                        if (str9 != null) {
                            if (str9.length() > 0) {
                                z2 = true;
                                if (!z2) {
                                    Object[] objArr4 = {((i0.e.b.z2.f.d) tVar2.c).c.getName(), tVar2.e};
                                    ArrayList i17 = i0.d.a.a.a.i1(resources, "<this>", objArr4, "rawArgs", 2);
                                    int i7 = 0;
                                    for (int i8 = 2; i7 < i8; i8 = 2) {
                                        Object obj4 = objArr4[i7];
                                        if (obj4 instanceof String) {
                                            String str10 = (String) obj4;
                                            obj4 = i0.d.a.a.a.p0(str10, "<this>", str10, 63);
                                        }
                                        i17.add(obj4);
                                        i7++;
                                    }
                                    String string7 = resources.getString(R.string.channel_explanation_club_with_title);
                                    i.d(string7, "getString(id)");
                                    Object[] array7 = i17.toArray(new Object[0]);
                                    Objects.requireNonNull(array7, "null cannot be cast to non-null type kotlin.Array<T>");
                                    Object[] copyOf7 = Arrays.copyOf(array7, array7.length);
                                    charSequence = i0.d.a.a.a.L(copyOf7, copyOf7.length, string7, "java.lang.String.format(format, *args)", 63, "fromHtml(\n            String.format(getString(id), *args.toTypedArray()),\n            HtmlCompat.FROM_HTML_MODE_COMPACT\n        )");
                                } else {
                                    Object[] objArr5 = {((i0.e.b.z2.f.d) tVar2.c).c.getName()};
                                    ArrayList i18 = i0.d.a.a.a.i1(resources, "<this>", objArr5, "rawArgs", 1);
                                    int i9 = 0;
                                    for (int i10 = 1; i9 < i10; i10 = 1) {
                                        Object obj5 = objArr5[i9];
                                        if (obj5 instanceof String) {
                                            String str11 = (String) obj5;
                                            obj5 = i0.d.a.a.a.p0(str11, "<this>", str11, 63);
                                        }
                                        i18.add(obj5);
                                        i9++;
                                    }
                                    String string8 = resources.getString(R.string.channel_explanation_club);
                                    i.d(string8, "getString(id)");
                                    z = false;
                                    Object[] array8 = i18.toArray(new Object[0]);
                                    Objects.requireNonNull(array8, "null cannot be cast to non-null type kotlin.Array<T>");
                                    Object[] copyOf8 = Arrays.copyOf(array8, array8.length);
                                    charSequence = i0.d.a.a.a.L(copyOf8, copyOf8.length, string8, "java.lang.String.format(format, *args)", 63, "fromHtml(\n            String.format(getString(id), *args.toTypedArray()),\n            HtmlCompat.FROM_HTML_MODE_COMPACT\n        )");
                                }
                            }
                        }
                        z2 = false;
                        if (!z2) {
                        }
                    } else {
                        z = false;
                        charSequence = "";
                    }
                    textView.setText(charSequence);
                    Button button = CreateChannelFragment.this.U0().b;
                    CreateChannelFragment createChannelFragment2 = CreateChannelFragment.this;
                    Objects.requireNonNull(createChannelFragment2);
                    str = tVar2.e;
                    if (!((str != null || str.length() == 0) ? true : z)) {
                        str2 = createChannelFragment2.getString(R.string.add_a_title_button_label);
                        i.d(str2, "getString(R.string.add_a_title_button_label)");
                    } else {
                        str2 = createChannelFragment2.getString(R.string.edit_title);
                        i.d(str2, "getString(R.string.edit_title)");
                    }
                    button.setText(str2);
                    if (tVar2.c == AudienceType.Closed || (!tVar2.d.isEmpty())) {
                        z = true;
                    }
                    Button button2 = CreateChannelFragment.this.U0().e;
                    i.d(button2, "binding.createButton");
                    i0.e.b.d3.k.L(button2, Boolean.valueOf(z));
                    Button button3 = CreateChannelFragment.this.U0().d;
                    i.d(button3, "binding.choosePeopleButton");
                    i0.e.b.d3.k.L(button3, Boolean.valueOf(!z));
                    return m0.i.a;
                }
                z = false;
                textView.setText(charSequence);
                Button button4 = CreateChannelFragment.this.U0().b;
                CreateChannelFragment createChannelFragment22 = CreateChannelFragment.this;
                Objects.requireNonNull(createChannelFragment22);
                str = tVar2.e;
                if (!((str != null || str.length() == 0) ? true : z)) {
                }
                button4.setText(str2);
                if (tVar2.c == AudienceType.Closed) {
                }
                z = true;
                Button button22 = CreateChannelFragment.this.U0().e;
                i.d(button22, "binding.createButton");
                i0.e.b.d3.k.L(button22, Boolean.valueOf(z));
                Button button32 = CreateChannelFragment.this.U0().d;
                i.d(button32, "binding.choosePeopleButton");
                i0.e.b.d3.k.L(button32, Boolean.valueOf(!z));
                return m0.i.a;
            }
        });
    }

    public final CreateChannelBinding U0() {
        return (CreateChannelBinding) this.t2.getValue();
    }

    public final CreateChannelEventCellBinding V0() {
        return (CreateChannelEventCellBinding) this.u2.getValue();
    }

    public final CreateChannelViewModel W0() {
        return (CreateChannelViewModel) this.r2.getValue();
    }

    @Override // com.clubhouse.android.core.ui.BaseBottomSheetFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.e(view, "view");
        super.onViewCreated(view, bundle);
        v.U1(this);
        U0().c.setLayoutManager(new GridLayoutManager(getContext(), 3));
        EpoxyRecyclerView epoxyRecyclerView = U0().c;
        i.d(epoxyRecyclerView, "binding.channelAudienceList");
        i0.e.b.d3.k.D(epoxyRecyclerView, this, new l<o, m0.i>() { // from class: com.clubhouse.android.ui.creation.CreateChannelFragment$buildModels$1
            @Override // m0.n.a.l
            public m0.i invoke(o oVar) {
                final o oVar2 = oVar;
                i.e(oVar2, "$this$null");
                CreateChannelFragment createChannelFragment = CreateChannelFragment.this;
                CreateChannelFragment.a aVar = CreateChannelFragment.p2;
                CreateChannelViewModel W0 = createChannelFragment.W0();
                final CreateChannelFragment createChannelFragment2 = CreateChannelFragment.this;
                v.v2(W0, new l<t, m0.i>() { // from class: com.clubhouse.android.ui.creation.CreateChannelFragment$buildModels$1.1
                    @Override // m0.n.a.l
                    public m0.i invoke(t tVar) {
                        List<ClubWithAdmin> list;
                        t tVar2 = tVar;
                        i.e(tVar2, "state");
                        List<AudienceType> K = m0.j.g.K(AudienceType.Open, AudienceType.Social, AudienceType.Closed);
                        o oVar3 = o.this;
                        CreateChannelFragment createChannelFragment3 = createChannelFragment2;
                        for (AudienceType audienceType : K) {
                            i0.e.b.g3.n.x.c cVar = new i0.e.b.g3.n.x.c();
                            cVar.Q(new Number[]{Integer.valueOf(audienceType.ordinal())});
                            cVar.S(createChannelFragment3.getString(audienceType.getTitle()));
                            cVar.N(audienceType.getIcon());
                            cVar.R(tVar2.c == audienceType);
                            cVar.L(new i0.e.b.g3.n.g(createChannelFragment3, audienceType));
                            oVar3.add(cVar);
                        }
                        GetCreateChannelTargetsResponse a2 = tVar2.b.a();
                        if (!(a2 == null || (list = a2.a) == null)) {
                            ArrayList arrayList = new ArrayList(h.K(list, 10));
                            for (ClubWithAdmin clubWithAdmin : list) {
                                arrayList.add(new i0.e.b.z2.f.d(clubWithAdmin));
                            }
                            o oVar4 = o.this;
                            CreateChannelFragment createChannelFragment4 = createChannelFragment2;
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                i0.e.b.z2.f.d dVar = (i0.e.b.z2.f.d) it.next();
                                i0.e.b.g3.n.x.c cVar2 = new i0.e.b.g3.n.x.c();
                                cVar2.P(i.k("club", Integer.valueOf(dVar.c.getId())));
                                cVar2.S(dVar.c.getName());
                                cVar2.O(dVar.c.b());
                                cVar2.R(i.a(tVar2.c, dVar));
                                cVar2.M(createChannelFragment4.getString(R.string.cd_club_name, dVar.c.getName()));
                                cVar2.L(new i0.e.b.g3.n.h(createChannelFragment4, dVar));
                                oVar4.add(cVar2);
                            }
                        }
                        return m0.i.a;
                    }
                });
                return m0.i.a;
            }
        });
        Button button = U0().e;
        i.d(button, "binding.createButton");
        p viewLifecycleOwner = getViewLifecycleOwner();
        i.d(viewLifecycleOwner, "viewLifecycleOwner");
        i0.e.b.d3.k.H(button, q.a(viewLifecycleOwner), new View.OnClickListener() { // from class: i0.e.b.g3.n.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CreateChannelFragment createChannelFragment = CreateChannelFragment.this;
                CreateChannelFragment.a aVar = CreateChannelFragment.p2;
                m0.n.b.i.e(createChannelFragment, "this$0");
                v.v2(createChannelFragment.W0(), 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: INVOKE  
                      (wrap: com.clubhouse.android.ui.creation.CreateChannelViewModel : 0x0009: INVOKE  (r0v2 com.clubhouse.android.ui.creation.CreateChannelViewModel A[REMOVE]) = (r3v1 'createChannelFragment' com.clubhouse.android.ui.creation.CreateChannelFragment) type: VIRTUAL call: com.clubhouse.android.ui.creation.CreateChannelFragment.W0():com.clubhouse.android.ui.creation.CreateChannelViewModel)
                      (wrap: com.clubhouse.android.ui.creation.CreateChannelFragment$showStartRoomConfirmationIfNecessary$1 : 0x000f: CONSTRUCTOR  (r1v0 com.clubhouse.android.ui.creation.CreateChannelFragment$showStartRoomConfirmationIfNecessary$1 A[REMOVE]) = (r3v1 'createChannelFragment' com.clubhouse.android.ui.creation.CreateChannelFragment) call: com.clubhouse.android.ui.creation.CreateChannelFragment$showStartRoomConfirmationIfNecessary$1.<init>(com.clubhouse.android.ui.creation.CreateChannelFragment):void type: CONSTRUCTOR)
                     type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: i0.e.b.g3.n.i.onClick(android.view.View):void, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:270)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.creation.CreateChannelFragment$showStartRoomConfirmationIfNecessary$1, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:974)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:799)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                    	... 15 more
                    */
                /*
                    this = this;
                    com.clubhouse.android.ui.creation.CreateChannelFragment r3 = com.clubhouse.android.ui.creation.CreateChannelFragment.this
                    com.clubhouse.android.ui.creation.CreateChannelFragment$a r0 = com.clubhouse.android.ui.creation.CreateChannelFragment.p2
                    java.lang.String r0 = "this$0"
                    m0.n.b.i.e(r3, r0)
                    com.clubhouse.android.ui.creation.CreateChannelViewModel r0 = r3.W0()
                    com.clubhouse.android.ui.creation.CreateChannelFragment$showStartRoomConfirmationIfNecessary$1 r1 = new com.clubhouse.android.ui.creation.CreateChannelFragment$showStartRoomConfirmationIfNecessary$1
                    r1.<init>(r3)
                    h0.b0.v.v2(r0, r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.n.i.onClick(android.view.View):void");
            }
        });
        Button button2 = U0().b;
        i.d(button2, "binding.addTopicButton");
        p viewLifecycleOwner2 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner2, "viewLifecycleOwner");
        i0.e.b.d3.k.H(button2, q.a(viewLifecycleOwner2), new View.OnClickListener() { // from class: i0.e.b.g3.n.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CreateChannelFragment createChannelFragment = CreateChannelFragment.this;
                CreateChannelFragment.a aVar = CreateChannelFragment.p2;
                i.e(createChannelFragment, "this$0");
                new TopicDialogFragment().P0(createChannelFragment.getChildFragmentManager(), null);
            }
        });
        Button button3 = U0().d;
        i.d(button3, "binding.choosePeopleButton");
        p viewLifecycleOwner3 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner3, "viewLifecycleOwner");
        i0.e.b.d3.k.H(button3, q.a(viewLifecycleOwner3), new View.OnClickListener() { // from class: i0.e.b.g3.n.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CreateChannelFragment createChannelFragment = CreateChannelFragment.this;
                CreateChannelFragment.a aVar = CreateChannelFragment.p2;
                i.e(createChannelFragment, "this$0");
                v.G(createChannelFragment, CreateChannelFragment$onViewCreated$3$1.c);
            }
        });
        v.h1(this, W0(), CreateChannelFragment$onViewCreated$4.c, null, new CreateChannelFragment$onViewCreated$5(this, null), new CreateChannelFragment$onViewCreated$6(this, null), 2, null);
        v.h1(this, W0(), CreateChannelFragment$onViewCreated$7.c, null, new CreateChannelFragment$onViewCreated$8(this, null), new CreateChannelFragment$onViewCreated$9(this, null), 2, null);
    }

    @Override // com.clubhouse.android.ui.creation.ChooseUsersFragment.a
    public void v(List<UserInList> list) {
        i.e(list, "selectedUsers");
        W0().p(new i0.e.b.g3.n.o(list));
    }
}
