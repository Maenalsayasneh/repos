package com.clubhouse.android;

import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationManagerCompat;
import com.airbnb.mvrx.DefaultViewModelDelegateFactory;
import com.airbnb.mvrx.navigation.DefaultNavigationViewModelDelegateFactory;
import com.clubhouse.android.notifications.ClubhouseDeprecatedNotifications;
import com.clubhouse.android.notifications.PushListenerService;
import com.clubhouse.android.shared.auth.UserManager;
import com.clubhouse.android.shared.preferences.Key;
import com.clubhouse.android.user.model.UserSelf;
import com.clubhouse.app.R;
import h0.g0.a;
import h0.m.a.e;
import i0.b.a.n;
import i0.b.a.o;
import i0.b.b.g;
import i0.b.b.k0;
import i0.b.b.u;
import i0.e.a.b.b;
import i0.e.b.e3.d;
import i0.e.b.f3.i.c;
import i0.e.b.y2;
import io.sentry.android.core.SentryAndroid;
import java.util.Objects;
import kotlin.Metadata;
import m0.n.b.i;
/* compiled from: ClubhouseApplication.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0019\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/clubhouse/android/ClubhouseApplication;", "Landroid/app/Application;", "Lh0/g0/a$b;", "Lm0/i;", "onCreate", "()V", "Lh0/g0/a;", "a", "()Lh0/g0/a;", "Li0/e/a/b/b;", "x", "Li0/e/a/b/b;", "getWorkerFactory", "()Li0/e/a/b/b;", "setWorkerFactory", "(Li0/e/a/b/b;)V", "workerFactory", "Lcom/clubhouse/android/shared/auth/UserManager;", "q", "Lcom/clubhouse/android/shared/auth/UserManager;", "getUserManager", "()Lcom/clubhouse/android/shared/auth/UserManager;", "setUserManager", "(Lcom/clubhouse/android/shared/auth/UserManager;)V", "userManager", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class ClubhouseApplication extends y2 implements a.b {
    public static final /* synthetic */ int d = 0;
    public UserManager q;
    public b x;

    @Override // h0.g0.a.b
    public a a() {
        a.C0066a aVar = new a.C0066a();
        b bVar = this.x;
        if (bVar != null) {
            aVar.a = bVar;
            a aVar2 = new a(aVar);
            i.d(aVar2, "Builder()\n            .setWorkerFactory(workerFactory)\n            .build()");
            return aVar2;
        }
        i.m("workerFactory");
        throw null;
    }

    @Override // i0.e.b.y2, android.app.Application
    public void onCreate() {
        UserSelf userSelf;
        super.onCreate();
        SentryAndroid.init(this, i0.e.b.a.a);
        k0 defaultNavigationViewModelDelegateFactory = new DefaultNavigationViewModelDelegateFactory(null, 1);
        g.b = new u(false, null, null, null, 14);
        if (defaultNavigationViewModelDelegateFactory == null) {
            defaultNavigationViewModelDelegateFactory = g.a;
            if (!(defaultNavigationViewModelDelegateFactory instanceof DefaultViewModelDelegateFactory)) {
                defaultNavigationViewModelDelegateFactory = new DefaultViewModelDelegateFactory();
            }
        }
        g.a = defaultNavigationViewModelDelegateFactory;
        UserManager userManager = this.q;
        if (userManager != null) {
            c cVar = userManager.a;
            synchronized (cVar) {
                if (cVar.b == null) {
                    i0.e.b.f3.k.b bVar = cVar.a;
                    Objects.requireNonNull(bVar);
                    cVar.b = bVar.l(Key.LOGGED_IN_USER);
                }
                userSelf = cVar.b;
            }
            if (userSelf != null) {
                userManager.e(userSelf);
            }
            e eVar = new e(getApplicationContext(), new h0.i.f.e("com.google.android.gms.fonts", "com.google.android.gms", "Noto Color Emoji Compat", (int) R.array.com_google_android_gms_fonts_certs));
            if (h0.m.a.a.b == null) {
                synchronized (h0.m.a.a.a) {
                    if (h0.m.a.a.b == null) {
                        h0.m.a.a.b = new h0.m.a.a(eVar);
                    }
                }
            }
            h0.m.a.a aVar = h0.m.a.a.b;
            o.setGlobalDuplicateFilteringDefault(true);
            o.defaultDiffingHandler = n.b();
            o.defaultModelBuildingHandler = n.b();
            d dVar = d.a;
            i.e(this, "context");
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationManagerCompat from = NotificationManagerCompat.from(this);
                i.d(from, "from(context)");
                ClubhouseDeprecatedNotifications[] values = ClubhouseDeprecatedNotifications.values();
                for (int i = 0; i < 13; i++) {
                    from.deleteNotificationChannel(values[i].getChannelId());
                }
                for (i0.e.b.e3.c cVar2 : d.b) {
                    NotificationChannel notificationChannel = new NotificationChannel(cVar2.a, getString(cVar2.b), cVar2.c);
                    i0.e.b.e3.a aVar2 = i0.e.b.e3.a.a;
                    if (i.a(cVar2, i0.e.b.e3.a.c) || i.a(cVar2, i0.e.b.e3.a.d)) {
                        AudioAttributes build = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
                        StringBuilder P0 = i0.d.a.a.a.P0("android.resource://");
                        P0.append((Object) getPackageName());
                        P0.append('/');
                        P0.append(PushListenerService.Sound.CHIME_NOTIFICATION.getRes());
                        notificationChannel.setSound(Uri.parse(P0.toString()), build);
                        notificationChannel.enableVibration(true);
                    }
                    from.createNotificationChannel(notificationChannel);
                }
                return;
            }
            return;
        }
        i.m("userManager");
        throw null;
    }
}
