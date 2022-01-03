package com.clubhouse.android.ui.clubs.description;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.clubhouse.android.databinding.FragmentEditDescriptionBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.ui.clubs.description.EditClubDescriptionFragment;
import com.clubhouse.app.R;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import h0.b0.v;
import i0.b.b.i;
import i0.e.b.d3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import m0.n.b.m;
import m0.o.c;
import m0.r.k;
/* compiled from: EditClubDescriptionFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u00020\u000b8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0016\u001a\u00020\u00118B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/clubhouse/android/ui/clubs/description/EditClubDescriptionFragment;", "Lcom/clubhouse/android/core/ui/BaseExpandedBottomSheetFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lcom/clubhouse/android/databinding/FragmentEditDescriptionBinding;", "q2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "U0", "()Lcom/clubhouse/android/databinding/FragmentEditDescriptionBinding;", "binding", "Lcom/clubhouse/android/ui/clubs/description/EditClubDescriptionArgs;", "r2", "Lm0/o/c;", "getArgs", "()Lcom/clubhouse/android/ui/clubs/description/EditClubDescriptionArgs;", "args", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class EditClubDescriptionFragment extends Hilt_EditClubDescriptionFragment {
    public static final /* synthetic */ k<Object>[] p2 = {m.c(new PropertyReference1Impl(m.a(EditClubDescriptionFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentEditDescriptionBinding;")), m.c(new PropertyReference1Impl(m.a(EditClubDescriptionFragment.class), "args", "getArgs()Lcom/clubhouse/android/ui/clubs/description/EditClubDescriptionArgs;"))};
    public final FragmentViewBindingDelegate q2 = new FragmentViewBindingDelegate(FragmentEditDescriptionBinding.class, this);
    public final c r2 = new i();

    public EditClubDescriptionFragment() {
        super(R.layout.fragment_edit_description);
    }

    @Override // i0.b.b.q
    public void J() {
    }

    public final FragmentEditDescriptionBinding U0() {
        return (FragmentEditDescriptionBinding) this.q2.getValue(this, p2[0]);
    }

    @Override // com.clubhouse.android.core.ui.BaseBottomSheetFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m0.n.b.i.e(view, "view");
        super.onViewCreated(view, bundle);
        Resources resources = getResources();
        c cVar = this.r2;
        k<?>[] kVarArr = p2;
        String string = resources.getString(R.string.update_description_for, ((EditClubDescriptionArgs) cVar.getValue(this, kVarArr[1])).c);
        m0.n.b.i.d(string, "resources.getString(R.string.update_description_for, args.clubName)");
        U0().c.setText(string);
        U0().c.setContentDescription(string);
        String str = ((EditClubDescriptionArgs) this.r2.getValue(this, kVarArr[1])).d;
        if (str != null) {
            U0().a.setText(str);
        }
        EditText editText = U0().a;
        m0.n.b.i.d(editText, "binding.description");
        m0.n.b.i.e(editText, "<this>");
        editText.setOnTouchListener(h.c);
        U0().b.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.l.w2.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EditClubDescriptionFragment editClubDescriptionFragment = EditClubDescriptionFragment.this;
                k<Object>[] kVarArr2 = EditClubDescriptionFragment.p2;
                m0.n.b.i.e(editClubDescriptionFragment, "this$0");
                v.V1(editClubDescriptionFragment, InstabugDbContract.FeatureRequestEntry.COLUMN_DESCRIPTION, editClubDescriptionFragment.U0().a.getText().toString());
                editClubDescriptionFragment.dismiss();
            }
        });
    }
}
