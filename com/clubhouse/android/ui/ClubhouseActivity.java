package com.clubhouse.android.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.clubhouse.analytics.AmplitudeAnalytics;
import com.clubhouse.android.shared.auth.UserManager;
import com.clubhouse.android.shared.update.UpdatesCoordinator;
import com.clubhouse.android.shared.update.UpdatesCoordinator$onActivityResult$1;
import com.clubhouse.app.R;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import h0.i.i.c0;
import h0.i.i.f0;
import h0.t.m;
import i0.e.a.b.a;
import i0.e.b.a3.f.e;
import i0.e.b.g3.d;
import i0.e.b.g3.g;
import i0.j.f.p.h;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import m0.n.b.i;
/* compiled from: ClubhouseActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b6\u00107J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ)\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u0015\u0010\nR\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010-\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00105\u001a\u00020.8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u00068"}, d2 = {"Lcom/clubhouse/android/ui/ClubhouseActivity;", "Lh0/b/a/e;", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", "", "requestCode", "resultCode", MessageExtension.FIELD_DATA, "onActivityResult", "(IILandroid/content/Intent;)V", "Landroid/net/Uri;", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "q0", "(Landroid/net/Uri;)V", "t0", "Lcom/clubhouse/android/shared/auth/UserManager;", "a2", "Lcom/clubhouse/android/shared/auth/UserManager;", "getUserManager", "()Lcom/clubhouse/android/shared/auth/UserManager;", "setUserManager", "(Lcom/clubhouse/android/shared/auth/UserManager;)V", "userManager", "Li0/e/a/b/a;", "Y1", "Li0/e/a/b/a;", "getActionTrailRecorder", "()Li0/e/a/b/a;", "setActionTrailRecorder", "(Li0/e/a/b/a;)V", "actionTrailRecorder", "Li0/e/a/a;", "Z1", "Li0/e/a/a;", "getAnalytics", "()Li0/e/a/a;", "setAnalytics", "(Li0/e/a/a;)V", "analytics", "Lcom/clubhouse/android/shared/update/UpdatesCoordinator;", "y", "Lcom/clubhouse/android/shared/update/UpdatesCoordinator;", "getUpdatesCoordinator", "()Lcom/clubhouse/android/shared/update/UpdatesCoordinator;", "setUpdatesCoordinator", "(Lcom/clubhouse/android/shared/update/UpdatesCoordinator;)V", "updatesCoordinator", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class ClubhouseActivity extends g {
    public static final /* synthetic */ int x = 0;
    public a Y1;
    public i0.e.a.a Z1;
    public UserManager a2;
    public UpdatesCoordinator y;

    @Override // h0.o.a.k, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        UpdatesCoordinator updatesCoordinator = this.y;
        if (updatesCoordinator != null) {
            if (i == 5566 && i2 != -1) {
                v0.a.a.d.w("Update flow cancelled or failed. Result code: " + i2 + ", data: " + intent, new Object[0]);
                m0.r.t.a.r.m.a1.a.E2(updatesCoordinator.d, null, null, new UpdatesCoordinator$onActivityResult$1(updatesCoordinator, null), 3, null);
            }
            super.onActivityResult(i, i2, intent);
            return;
        }
        i.m("updatesCoordinator");
        throw null;
    }

    @Override // h0.o.a.k, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_clubhouse);
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= 30) {
            window.setDecorFitsSystemWindows(false);
        } else {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1792);
        }
        f0 a = c0.a(getWindow(), getWindow().getDecorView());
        if (a != null) {
            a.a.a(true);
        }
        UserManager userManager = this.a2;
        if (userManager != null) {
            if (!userManager.c()) {
                q0(getIntent().getData());
                Intent intent = getIntent();
                intent.setData(null);
                intent.replaceExtras(Bundle.EMPTY);
                setIntent(intent);
            }
            t0(getIntent());
            Fragment I = getSupportFragmentManager().I(R.id.main_nav_host);
            Objects.requireNonNull(I, "null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment");
            NavController J0 = ((NavHostFragment) I).J0();
            m c = J0.f().c(R.navigation.main_graph);
            c.u(R.id.splashFragment);
            J0.o(c, null);
            ((ViewGroup) findViewById(R.id.activity_root)).setOnApplyWindowInsetsListener(d.a);
            return;
        }
        i.m("userManager");
        throw null;
    }

    @Override // h0.o.a.k, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        t0(intent);
        UserManager userManager = this.a2;
        Uri uri = null;
        if (userManager == null) {
            i.m("userManager");
            throw null;
        } else if (userManager.c()) {
            try {
                g0.a.b.b.a.E(this, R.id.main_nav_host).g(intent);
            } catch (Exception e) {
                v0.a.a.d.e(e);
            }
        } else {
            if (intent != null) {
                uri = intent.getData();
            }
            q0(uri);
        }
    }

    public final void q0(Uri uri) {
        if (uri != null && !uri.getPathSegments().contains("app")) {
            e.a(this, uri.toString());
        }
    }

    public final void t0(Intent intent) {
        Bundle bundleExtra;
        Serializable serializable;
        if (intent != null && (bundleExtra = intent.getBundleExtra("android-support-nav:controller:deepLinkExtras")) != null && (serializable = bundleExtra.getSerializable("notification_data")) != null) {
            HashMap hashMap = serializable instanceof HashMap ? (HashMap) serializable : null;
            if (hashMap != null) {
                a aVar = this.Y1;
                if (aVar != null) {
                    i.e(hashMap, "payload");
                    aVar.a.a("notification_opened", m0.j.g.R(hashMap, "aps"));
                    if (!h0.q.c0.c.Z1.c.isAtLeast(Lifecycle.State.STARTED)) {
                        String str = (String) hashMap.get("action");
                        i0.e.a.a aVar2 = this.Z1;
                        if (aVar2 != null) {
                            if (str == null) {
                                str = "unknown";
                            }
                            ((AmplitudeAnalytics) aVar2).b("PushNotification-Response", h.S2(new Pair("action", str)));
                            return;
                        }
                        i.m("analytics");
                        throw null;
                    }
                    return;
                }
                i.m("actionTrailRecorder");
                throw null;
            }
        }
    }
}
