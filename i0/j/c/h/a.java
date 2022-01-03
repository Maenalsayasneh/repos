package i0.j.c.h;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import com.instabug.chat.R;
import com.instabug.library.PresentationManager;
import com.instabug.library.core.eventbus.CurrentActivityLifeCycleEventBus;
import com.instabug.library.core.eventbus.InstabugStateEventBus;
import com.instabug.library.tracking.ActivityLifeCycleEvent;
import com.instabug.library.ui.custom.CircularImageView;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.ScreenUtility;
import com.instabug.library.util.threading.PoolProvider;
/* compiled from: NotificationBarInvoker.java */
@SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
/* loaded from: classes2.dex */
public class a {
    public View a;
    public boolean b = false;
    public boolean c;
    public boolean d;
    public i0.j.c.f.b e;
    public e f;

    /* compiled from: NotificationBarInvoker.java */
    /* renamed from: i0.j.c.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0176a extends d {
        public C0176a() {
            super(a.this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.a.setVisibility(4);
        }
    }

    /* compiled from: NotificationBarInvoker.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            ActivityLifeCycleEvent.values();
            int[] iArr = new int[6];
            a = iArr;
            try {
                iArr[ActivityLifeCycleEvent.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ActivityLifeCycleEvent.PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: NotificationBarInvoker.java */
    /* loaded from: classes2.dex */
    public class c extends f {
        public final /* synthetic */ Activity c;
        public final /* synthetic */ i0.j.c.f.b d;

        public c(Activity activity, i0.j.c.f.b bVar) {
            this.c = activity;
            this.d = bVar;
        }
    }

    /* compiled from: NotificationBarInvoker.java */
    /* loaded from: classes2.dex */
    public class d implements Animator.AnimatorListener {
        public d(a aVar) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* compiled from: NotificationBarInvoker.java */
    /* loaded from: classes2.dex */
    public interface e {
    }

    /* compiled from: NotificationBarInvoker.java */
    /* loaded from: classes2.dex */
    public abstract class f implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            c cVar = (c) this;
            a.this.a.setY((float) ScreenUtility.getScreenHeight(cVar.c));
            a.c(a.this, cVar.c, cVar.d);
        }
    }

    public a() {
        CurrentActivityLifeCycleEventBus.getInstance().subscribe(new c(this));
        InstabugStateEventBus.getInstance().subscribe(new d(this));
    }

    public static void b(a aVar, Activity activity) {
        if (aVar.c) {
            aVar.d = true;
            return;
        }
        activity.runOnUiThread(new b(aVar, activity));
        if (i0.j.c.l.c.a().b.getBoolean("ibc_in_app_notification_sound", false)) {
            l.a().e(activity);
        }
    }

    public static void c(a aVar, Activity activity, i0.j.c.f.b bVar) {
        CircularImageView circularImageView = (CircularImageView) aVar.a.findViewById(R.id.senderAvatarImageView);
        activity.runOnUiThread(new j(aVar, activity, circularImageView, bVar));
        if (bVar.c != null) {
            PoolProvider.postIOTask(new k(aVar, bVar, activity, circularImageView));
        }
    }

    public void a(Activity activity, i0.j.c.f.b bVar, e eVar) {
        this.e = bVar;
        this.f = eVar;
        c cVar = new c(activity, bVar);
        View findViewById = activity.findViewById(R.id.instabug_in_app_notification);
        if (findViewById != null) {
            this.a = findViewById;
            c(this, activity, bVar);
        } else {
            d(false);
            LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService("layout_inflater");
            if (layoutInflater == null) {
                InstabugSDKLogger.e(this, "Unable to inflate the InAppNotifications view due to null Inflater");
            } else {
                View inflate = layoutInflater.inflate(R.layout.instabug_lyt_notification, (ViewGroup) null);
                this.a = inflate;
                inflate.setVisibility(4);
                this.a.setOnClickListener(new e());
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 80;
                Resources resources = activity.getResources();
                if (ScreenUtility.isLandscape(activity) && ScreenUtility.hasNavBar(activity.getApplicationContext())) {
                    int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
                    if (rotation == 1) {
                        layoutParams.rightMargin = ScreenUtility.getNavigationBarWidth(resources);
                    } else if (rotation == 3) {
                        layoutParams.leftMargin = ScreenUtility.getNavigationBarWidth(resources);
                    }
                }
                this.a.setLayoutParams(layoutParams);
                activity.runOnUiThread(new f(this, activity, layoutParams, cVar));
                activity.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new g(this, activity));
            }
        }
        ((Button) this.a.findViewById(R.id.replyButton)).setOnClickListener(new h(this));
        ((Button) this.a.findViewById(R.id.dismissButton)).setOnClickListener(new i(this));
    }

    public final void d(boolean z) {
        View view;
        if (this.b && (view = this.a) != null) {
            int screenHeight = ScreenUtility.getScreenHeight((Activity) view.getContext());
            if (z) {
                this.a.animate().y((float) screenHeight).setListener(new C0176a()).start();
            } else {
                this.a.setY((float) screenHeight);
                this.a.setVisibility(4);
            }
            this.b = false;
            this.d = false;
            PresentationManager.getInstance().setNotificationShowing(false);
        }
    }
}
