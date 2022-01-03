package com.instabug.library.internal.video;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import com.instabug.library.InstabugState;
import com.instabug.library.InstabugStateProvider;
import com.instabug.library._InstabugActivity;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.AutoScreenRecordingEventBus;
import com.instabug.library.core.eventbus.CurrentActivityLifeCycleEventBus;
import com.instabug.library.core.eventbus.SessionStateEventBus;
import com.instabug.library.internal.InstabugMediaProjectionIntent;
import com.instabug.library.internal.video.ScreenRecordingService;
import com.instabug.library.model.session.SessionState;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.tracking.ActivityLifeCycleEvent;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import java.io.File;
import k0.b.y.d;
/* loaded from: classes2.dex */
public class InternalAutoScreenRecorderHelper implements ScreenRecordingContract {
    private static InternalAutoScreenRecorderHelper INSTANCE;
    private k0.b.w.a activityLifeCycleDisposable;
    private k0.b.w.a sessionDisposable;
    private boolean isCrashOccurred = false;
    private ScreenRecordingFileHolder fileHolder = new ScreenRecordingFileHolder();

    /* loaded from: classes2.dex */
    public class a implements d<SessionState> {
        public a() {
        }

        @Override // k0.b.y.d
        public void b(SessionState sessionState) throws Exception {
            if (sessionState == SessionState.FINISH && !InternalAutoScreenRecorderHelper.this.isCrashOccurred() && InternalAutoScreenRecorderHelper.this.isEnabled()) {
                AutoScreenRecordingEventBus.getInstance().post(ScreenRecordingService.Action.STOP_DELETE);
                SettingsManager.getInstance().setAutoScreenRecordingDenied(false);
                InternalAutoScreenRecorderHelper.this.unsubscribeFromSessionEvents();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d<ActivityLifeCycleEvent> {
        public b() {
        }

        @Override // k0.b.y.d
        public void b(ActivityLifeCycleEvent activityLifeCycleEvent) throws Exception {
            if (activityLifeCycleEvent == ActivityLifeCycleEvent.RESUMED && InternalAutoScreenRecorderHelper.this.isEnabled() && !SettingsManager.getInstance().isProcessingForeground()) {
                InternalAutoScreenRecorderHelper.this.subscribeToSessionEvents();
                new Handler().postDelayed(new i0.j.e.l0.m.a(), 700);
            }
        }
    }

    public InternalAutoScreenRecorderHelper() {
        subscribeToSessionEvents();
        subscribeToActivityLifeCycleEvents();
    }

    public static InternalAutoScreenRecorderHelper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new InternalAutoScreenRecorderHelper();
        }
        return INSTANCE;
    }

    public static Intent getStaticIntentData() {
        return InstabugMediaProjectionIntent.getMediaProjectionIntent();
    }

    public static int getStaticResultCode() {
        return InstabugMediaProjectionIntent.getStaticResultCode();
    }

    public static void setStaticIntentData(Intent intent) {
        InstabugMediaProjectionIntent.setMediaProjectionIntent(intent);
    }

    public static void setStaticResultCode(int i) {
        InstabugMediaProjectionIntent.setStaticResultCode(i);
    }

    private void subscribeToActivityLifeCycleEvents() {
        k0.b.w.a aVar = this.activityLifeCycleDisposable;
        if (aVar == null || aVar.isDisposed()) {
            this.activityLifeCycleDisposable = CurrentActivityLifeCycleEventBus.getInstance().subscribe(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void subscribeToSessionEvents() {
        k0.b.w.a aVar = this.sessionDisposable;
        if (aVar == null || aVar.isDisposed()) {
            this.sessionDisposable = SessionStateEventBus.getInstance().subscribe(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unsubscribeFromSessionEvents() {
        if (!this.sessionDisposable.isDisposed()) {
            this.sessionDisposable.dispose();
        }
    }

    @Override // com.instabug.library.internal.video.ScreenRecordingContract
    public void clear() {
        this.fileHolder.clear();
    }

    @Override // com.instabug.library.internal.video.ScreenRecordingContract
    public void delete() {
        this.fileHolder.delete();
    }

    @Override // com.instabug.library.internal.video.ScreenRecordingContract
    public Uri getAutoScreenRecordingFileUri() {
        return this.fileHolder.getAutoScreenRecordingFileUri();
    }

    public boolean isCrashOccurred() {
        return this.isCrashOccurred;
    }

    @Override // com.instabug.library.internal.video.ScreenRecordingContract
    public boolean isEnabled() {
        return SettingsManager.getInstance().autoScreenRecordingEnabled();
    }

    public void setAutoScreenRecordingFile(File file) {
        this.fileHolder.setAutoScreenRecordingFile(file);
    }

    public void setCrashOccurred(boolean z) {
        this.isCrashOccurred = z;
    }

    public void start() {
        Activity targetActivity;
        if (!SettingsManager.getInstance().isScreenCurrentlyRecorded() && !SettingsManager.getInstance().isAutoScreenRecordingDenied() && isEnabled() && (targetActivity = InstabugInternalTrackingDelegate.getInstance().getTargetActivity()) != null && !(targetActivity instanceof _InstabugActivity) && SettingsManager.getInstance().isAppOnForeground() && InstabugStateProvider.getInstance().getState() == InstabugState.ENABLED && !InstabugCore.isForegroundBusy()) {
            targetActivity.startActivity(new Intent(targetActivity, RequestPermissionActivity.class));
            targetActivity.overridePendingTransition(0, 0);
        }
    }
}
