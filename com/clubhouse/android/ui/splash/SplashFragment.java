package com.clubhouse.android.ui.splash;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.clubhouse.analytics.AmplitudeAnalytics;
import com.clubhouse.android.data.models.local.user.SourceLocation;
import com.clubhouse.android.shared.auth.UserManager;
import com.clubhouse.android.user.model.UserSelf;
import com.clubhouse.app.R;
import h0.b0.v;
import h0.t.j;
import h0.t.q;
import i0.e.a.b.a;
import i0.e.b.g3.y.a;
import i0.e.b.g3.y.b;
import kotlin.Metadata;
import m0.n.b.i;
/* compiled from: SplashFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/clubhouse/android/ui/splash/SplashFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "O0", "Li0/e/a/b/a;", "a2", "Li0/e/a/b/a;", "getActionTrailRecorder", "()Li0/e/a/b/a;", "setActionTrailRecorder", "(Li0/e/a/b/a;)V", "actionTrailRecorder", "Lcom/clubhouse/android/shared/auth/UserManager;", "Z1", "Lcom/clubhouse/android/shared/auth/UserManager;", "N0", "()Lcom/clubhouse/android/shared/auth/UserManager;", "setUserManager", "(Lcom/clubhouse/android/shared/auth/UserManager;)V", "userManager", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class SplashFragment extends Hilt_SplashFragment {
    public UserManager Z1;
    public a a2;

    public SplashFragment() {
        super(R.layout.fragment_splash);
    }

    @Override // i0.b.b.q
    public void J() {
    }

    public final UserManager N0() {
        UserManager userManager = this.Z1;
        if (userManager != null) {
            return userManager;
        }
        i.m("userManager");
        throw null;
    }

    public final void O0() {
        i.f(this, "$this$findNavController");
        NavController I0 = NavHostFragment.I0(this);
        i.b(I0, "NavHostFragment.findNavController(this)");
        Uri parse = Uri.parse("clubhouse://waitlist");
        I0.i(new j(parse, null, null), new q(false, R.id.splashFragment, true, -1, -1, -1, -1), null);
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.e(view, "view");
        super.onViewCreated(view, bundle);
        if (N0().c()) {
            UserSelf value = N0().d.getValue();
            boolean z = false;
            if (value != null && value.b()) {
                O0();
                return;
            }
            Bundle arguments = getArguments();
            i0.e.b.g3.y.a a = arguments == null ? null : a.C0123a.a(arguments);
            if (a != null && a.a) {
                z = true;
            }
            if (z) {
                ((AmplitudeAnalytics) v.l(this)).a("Onboarding-Done");
                i0.e.a.b.a aVar = this.a2;
                if (aVar != null) {
                    aVar.d(true);
                    v.a1(this, b.C0124b.a(b.a, a.b, null, null, null, SourceLocation.WELCOME_ROOM.getCode(), 14), null, 2);
                    return;
                }
                i.m("actionTrailRecorder");
                throw null;
            }
            v.a1(this, b.C0124b.a(b.a, null, null, null, null, 0, 31), null, 2);
        } else if (N0().h() != null) {
            O0();
        } else {
            v.a1(this, new h0.t.a(R.id.action_splashFragment_to_onboarding_graph), null, 2);
        }
    }
}
