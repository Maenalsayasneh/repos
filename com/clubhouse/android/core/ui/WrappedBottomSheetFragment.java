package com.clubhouse.android.core.ui;

import android.os.Bundle;
import android.view.View;
import com.clubhouse.android.core.R;
import h0.o.a.a;
import i0.b.b.i;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import m0.n.b.m;
import m0.o.c;
import m0.r.k;
/* compiled from: WrappedBottomSheetFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\u00020\u000b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/clubhouse/android/core/ui/WrappedBottomSheetFragment;", "Lcom/clubhouse/android/core/ui/BaseExpandedBottomSheetFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lcom/clubhouse/android/core/ui/WrappedBottomSheetArgs;", "q2", "Lm0/o/c;", "getArgs", "()Lcom/clubhouse/android/core/ui/WrappedBottomSheetArgs;", "args", "<init>", "core-ui_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class WrappedBottomSheetFragment extends Hilt_WrappedBottomSheetFragment {
    public static final /* synthetic */ k<Object>[] p2 = {m.c(new PropertyReference1Impl(m.a(WrappedBottomSheetFragment.class), "args", "getArgs()Lcom/clubhouse/android/core/ui/WrappedBottomSheetArgs;"))};
    public final c q2 = new i();

    public WrappedBottomSheetFragment() {
        super(R.layout.fragment_dialog_container);
    }

    @Override // i0.b.b.q
    public void J() {
    }

    @Override // com.clubhouse.android.core.ui.BaseBottomSheetFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m0.n.b.i.e(view, "view");
        super.onViewCreated(view, bundle);
        a aVar = new a(getChildFragmentManager());
        m0.n.b.i.d(aVar, "childFragmentManager.beginTransaction()");
        int i = R.id.parent_fragment_container;
        c cVar = this.q2;
        k<?>[] kVarArr = p2;
        aVar.p(i, ((WrappedBottomSheetArgs) cVar.getValue(this, kVarArr[0])).c, ((WrappedBottomSheetArgs) this.q2.getValue(this, kVarArr[0])).d);
        aVar.h();
    }
}
