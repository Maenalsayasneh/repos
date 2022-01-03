package com.instabug.library;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.instabug.library.Feature;
import com.instabug.library.analytics.AnalyticsWrapper;
import com.instabug.library.analytics.model.Api;
import com.instabug.library.apichecker.APIChecker;
import com.instabug.library.apichecker.ReturnableRunnable;
import com.instabug.library.apichecker.VoidRunnable;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventPublisher;
import com.instabug.library.core.plugin.Plugin;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.userAttribute.UserAttributeCacheManager;
import com.instabug.library.internal.video.InternalScreenRecordHelper;
import com.instabug.library.invocation.InstabugInvocationEvent;
import com.instabug.library.invocation.InvocationManager;
import com.instabug.library.invocation.InvocationSettings;
import com.instabug.library.invocation.util.InstabugFloatingButtonEdge;
import com.instabug.library.logging.InstabugUserEventLogger;
import com.instabug.library.model.Report;
import com.instabug.library.model.StepType;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.ui.onboarding.WelcomeMessage;
import com.instabug.library.user.UserEventParam;
import com.instabug.library.util.InstabugDeprecationLogger;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.StringUtility;
import com.instabug.library.util.filters.Filters;
import com.instabug.library.util.threading.PoolProvider;
import com.instabug.library.visualusersteps.State;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
/* loaded from: classes2.dex */
public class Instabug {
    private static volatile Instabug INSTANCE = null;
    private static final String TAG = "Instabug";
    private i0.j.e.i delegate;

    @SuppressFBWarnings({"URF_UNREAD_FIELD"})
    /* loaded from: classes2.dex */
    public static class Builder {
        private static boolean isBuildCalled = false;
        private Feature.State anrDefaultState;
        private Application application;
        private Context applicationContext;
        private String applicationToken;
        private boolean bugPromptOptionEnable;
        private boolean chatPromptOptionEnable;
        private boolean commentFieldRequired;
        private Feature.State consoleLogState;
        private Feature.State crashReportingState;
        private List<Integer> deprecatedMethodsToBeLogedAfterBuild;
        private boolean emailFieldRequired;
        private boolean emailFieldVisibility;
        private boolean feedbackPromptOptionEnable;
        private int floatingButtonOffsetFromTop;
        private Feature.State inAppMessagingState;
        private InstabugFloatingButtonEdge instabugFloatingButtonEdge;
        private InstabugInvocationEvent[] instabugInvocationEvents;
        private Feature.State instabugLogState;
        private int instabugStatusBarColor;
        private boolean introMessageEnabled;
        private boolean isSurveysAutoShowing;
        private Feature.State pushNotificationState;
        private State reproStepsState;
        private int shakingThreshold;
        private boolean shouldPlaySounds;
        private boolean successDialogEnabled;
        private Feature.State surveysState;
        private Feature.State trackingUserStepsState;
        private Feature.State userDataState;
        private Feature.State userEventsState;
        private Feature.State viewHierarchyState;

        /* loaded from: classes2.dex */
        public class a extends HandlerThread {
            public final /* synthetic */ i0.j.e.i c;
            public final /* synthetic */ boolean d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, i0.j.e.i iVar, boolean z) {
                super(str);
                this.c = iVar;
                this.d = z;
            }

            @Override // android.os.HandlerThread
            @SuppressLint({"STRICT_MODE_VIOLATION"})
            public void onLooperPrepared() {
                try {
                    i0.j.e.i iVar = this.c;
                    Context unused = Builder.this.applicationContext;
                    iVar.f();
                    this.c.d(this.d ? InstabugState.ENABLED : InstabugState.DISABLED);
                    this.c.k();
                    InvocationManager.getInstance().getCurrentInvocationSettings().setFloatingButtonEdge(Builder.this.instabugFloatingButtonEdge);
                    InvocationManager.getInstance().notifyPrimaryColorChanged();
                    InvocationManager.getInstance().setInstabugInvocationEvent(Builder.this.instabugInvocationEvents);
                    if (Builder.this.floatingButtonOffsetFromTop != -1) {
                        InvocationManager.getInstance().getCurrentInvocationSettings().setFloatingButtonOffsetFromTop(Builder.this.floatingButtonOffsetFromTop);
                    }
                    SDKCoreEventPublisher.post(new SDKCoreEvent("sdk_state", "built"));
                    Builder.this.logFeaturesStates(Boolean.valueOf(this.d));
                    InstabugSDKLogger.i(Instabug.TAG, "Built");
                } catch (Exception e) {
                    InstabugSDKLogger.e(Instabug.TAG, e.getMessage(), e);
                }
            }
        }

        public Builder(Application application, String str) {
            this(application, str, InstabugInvocationEvent.SHAKE);
        }

        private void logDeprecatedApis() {
            for (Integer num : this.deprecatedMethodsToBeLogedAfterBuild) {
                InstabugDeprecationLogger.getInstance().log(num.intValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void logFeaturesStates(Boolean bool) {
            StringBuilder P0 = i0.d.a.a.a.P0("User data feature state is set to ");
            P0.append(this.userDataState);
            InstabugSDKLogger.v(this, P0.toString());
            InstabugSDKLogger.v(this, "Console log feature state is set to " + this.consoleLogState);
            InstabugSDKLogger.v(this, "Instabug logs feature state is set to " + this.instabugLogState);
            InstabugSDKLogger.v(this, "Crash reporting feature state is set to " + this.crashReportingState);
            InstabugSDKLogger.v(this, "In-App messaging feature state is set to" + this.inAppMessagingState);
            InstabugSDKLogger.v(this, "Push notification feature state is set to " + this.pushNotificationState);
            InstabugSDKLogger.v(this, "Tracking user steps feature state is set to " + this.trackingUserStepsState);
            InstabugSDKLogger.v(this, "Repro steps feature state is set to " + this.reproStepsState);
            InstabugSDKLogger.v(this, "View hierarchy feature state is set to " + this.viewHierarchyState);
            InstabugSDKLogger.v(this, "Surveys feature state is set to " + this.surveysState);
            InstabugSDKLogger.v(this, "User events feature state is set to " + this.userEventsState);
            InstabugSDKLogger.v(this, "Instabug overall state is set to " + bool);
        }

        private void setFeaturesStates(Boolean bool) {
            i0.j.e.z.j().d(Feature.USER_DATA, this.userDataState);
            i0.j.e.z.j().d(Feature.INSTABUG_LOGS, this.instabugLogState);
            i0.j.e.z.j().d(Feature.CONSOLE_LOGS, this.consoleLogState);
            i0.j.e.z.j().d(Feature.CRASH_REPORTING, this.crashReportingState);
            i0.j.e.z.j().d(Feature.IN_APP_MESSAGING, this.inAppMessagingState);
            i0.j.e.z.j().d(Feature.PUSH_NOTIFICATION, this.pushNotificationState);
            i0.j.e.z.j().d(Feature.TRACK_USER_STEPS, this.trackingUserStepsState);
            Instabug.setReproStepsState(this.reproStepsState);
            i0.j.e.z.j().d(Feature.VIEW_HIERARCHY_V2, this.viewHierarchyState);
            i0.j.e.z.j().d(Feature.SURVEYS, this.surveysState);
            i0.j.e.z.j().d(Feature.USER_EVENTS, this.userEventsState);
            i0.j.e.z.j().d(Feature.ANR_REPORTING, this.anrDefaultState);
            i0.j.e.z.j().d(Feature.INSTABUG, bool.booleanValue() ? Feature.State.ENABLED : Feature.State.DISABLED);
        }

        public Instabug build() {
            if (isBuildCalled) {
                return Instabug.INSTANCE;
            }
            isBuildCalled = true;
            if (Instabug.isBuilt()) {
                if (InternalScreenRecordHelper.getInstance().isRecording()) {
                    InternalScreenRecordHelper.getInstance().cancel();
                }
                Instabug.disable();
            }
            return build(Feature.State.ENABLED);
        }

        public Builder setConsoleLogState(Feature.State state) {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.Builder().setConsoleLogState", new Api.Parameter().setName("state").setType(Feature.State.class).setValue(state));
            this.consoleLogState = state;
            return this;
        }

        public Builder setInAppMessagingState(Feature.State state) {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.Builder().setInAppMessagingState", new Api.Parameter().setName("state").setType(Feature.State.class).setValue(state));
            this.inAppMessagingState = state;
            return this;
        }

        public Builder setInstabugLogState(Feature.State state) {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.Builder().setInstabugLogState", new Api.Parameter().setName("state").setType(Feature.State.class).setValue(state));
            this.instabugLogState = state;
            return this;
        }

        public Builder setInvocationEvents(InstabugInvocationEvent... instabugInvocationEventArr) {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.Builder().setInvocationEvents", i0.d.a.a.a.O("instabugInvocationEvent", InstabugInvocationEvent.class).setValue(TextUtils.join(InstabugDbContract.COMMA_SEP, instabugInvocationEventArr)));
            this.instabugInvocationEvents = instabugInvocationEventArr;
            return this;
        }

        public Builder setReproStepsState(State state) {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.Builder().setReproStepsState", new Api.Parameter().setName("state").setType(State.class).setValue(state));
            this.reproStepsState = state;
            return this;
        }

        public Builder setTrackingUserStepsState(Feature.State state) {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.Builder().setTrackingUserStepsState", new Api.Parameter().setName("state").setType(Feature.State.class).setValue(state));
            this.trackingUserStepsState = state;
            return this;
        }

        public Builder setUserDataState(Feature.State state) {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.Builder().setUserDataState", new Api.Parameter().setName("state").setType(Feature.State.class).setValue(state));
            this.userDataState = state;
            return this;
        }

        public Builder setUserEventsState(Feature.State state) {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.Builder().setUserEventsState", new Api.Parameter().setName("state").setType(Feature.State.class).setValue(state));
            this.userEventsState = state;
            return this;
        }

        public Builder setViewHierarchyState(Feature.State state) {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.Builder().setViewHierarchyState", new Api.Parameter().setName("state").setType(Feature.State.class).setValue(state));
            this.viewHierarchyState = state;
            return this;
        }

        public Builder(Application application, String str, InstabugInvocationEvent... instabugInvocationEventArr) {
            this(application.getApplicationContext(), str, instabugInvocationEventArr);
            this.application = application;
        }

        public Builder(Context context, String str, InstabugInvocationEvent... instabugInvocationEventArr) {
            this.instabugStatusBarColor = -3815737;
            this.instabugInvocationEvents = new InstabugInvocationEvent[]{InstabugInvocationEvent.SHAKE};
            Feature.State state = i0.j.e.z.c;
            this.userDataState = state;
            this.consoleLogState = state;
            this.instabugLogState = state;
            this.inAppMessagingState = state;
            this.crashReportingState = state;
            this.pushNotificationState = state;
            this.trackingUserStepsState = state;
            this.reproStepsState = State.ENABLED;
            this.viewHierarchyState = Feature.State.DISABLED;
            this.surveysState = state;
            this.userEventsState = state;
            this.anrDefaultState = state;
            this.emailFieldRequired = true;
            this.emailFieldVisibility = true;
            this.commentFieldRequired = false;
            this.introMessageEnabled = true;
            this.shouldPlaySounds = false;
            this.successDialogEnabled = true;
            this.instabugFloatingButtonEdge = InstabugFloatingButtonEdge.RIGHT;
            this.shakingThreshold = InvocationSettings.SHAKE_DEFAULT_THRESHOLD;
            this.floatingButtonOffsetFromTop = -1;
            this.isSurveysAutoShowing = true;
            this.chatPromptOptionEnable = true;
            this.bugPromptOptionEnable = true;
            this.feedbackPromptOptionEnable = true;
            this.deprecatedMethodsToBeLogedAfterBuild = new ArrayList();
            this.applicationContext = context;
            this.instabugInvocationEvents = instabugInvocationEventArr;
            this.applicationToken = str;
        }

        public Instabug build(Feature.State state) {
            Application application = this.application;
            if (application == null) {
                return null;
            }
            i0.j.e.i iVar = new i0.j.e.i(application);
            Instabug unused = Instabug.INSTANCE = new Instabug(iVar, null);
            InstabugSDKLogger.initLogger(this.applicationContext);
            boolean z = state == Feature.State.ENABLED;
            setFeaturesStates(Boolean.valueOf(z));
            iVar.d(InstabugState.BUILDING);
            logDeprecatedApis();
            String appToken = SettingsManager.getInstance().getAppToken();
            String str = this.applicationToken;
            if (!(str == null || appToken == null || str.equals(appToken))) {
                i0.j.e.c1.b.H();
            }
            SettingsManager.getInstance().setAppToken(this.applicationToken);
            Context context = this.applicationContext;
            synchronized (i0.j.e.y.b.a.b) {
                if (i0.j.e.y.b.a.a == null) {
                    i0.j.e.y.b.a.a = new ArrayList();
                    String[] strArr = {"com.instabug.crash.CrashPlugin", "com.instabug.survey.SurveyPlugin", "com.instabug.chat.ChatPlugin", "com.instabug.bug.BugPlugin", "com.instabug.featuresrequest.FeaturesRequestPlugin", "com.instabug.apm.APMPlugin"};
                    for (int i = 0; i < 6; i++) {
                        String str2 = strArr[i];
                        try {
                            Plugin plugin = (Plugin) Class.forName(str2).newInstance();
                            plugin.init(context);
                            i0.j.e.y.b.a.a.add(plugin);
                            InstabugSDKLogger.d(i0.j.e.y.b.a.class, "pluginClassPath: " + str2);
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                            InstabugSDKLogger.e(i0.j.e.y.b.a.class, "Can't get: " + str2);
                        } catch (IllegalAccessException e2) {
                            e2.printStackTrace();
                        } catch (InstantiationException e3) {
                            e3.printStackTrace();
                        }
                    }
                }
            }
            SettingsManager instance = SettingsManager.getInstance();
            synchronized (i0.j.e.i0.class) {
                if (i0.j.e.i0.a == null) {
                    i0.j.e.i0.a = new i0.j.e.i0(instance);
                }
            }
            a aVar = new a("Sdk start thread", iVar, z);
            aVar.setPriority(10);
            aVar.start();
            return Instabug.INSTANCE;
        }
    }

    /* loaded from: classes2.dex */
    public static class a implements VoidRunnable {
        public final /* synthetic */ Feature.State a;

        public a(Feature.State state) {
            this.a = state;
        }

        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            if (this.a == null) {
                InstabugSDKLogger.w(Instabug.TAG, "state object passed to Instabug.setTrackingUserStepsState() is null");
                return;
            }
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.setTrackingUserStepsState", i0.d.a.a.a.O("state", Feature.State.class).setValue(this.a));
            i0.j.e.z.j().d(Feature.TRACK_USER_STEPS, this.a);
            InstabugSDKLogger.i(Instabug.TAG, "setTrackingUserStepsState: " + this.a.name());
        }
    }

    /* loaded from: classes2.dex */
    public static class a0 implements VoidRunnable {
        public final /* synthetic */ List a;

        public a0(List list) {
            this.a = list;
        }

        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() throws Exception {
            AnalyticsWrapper.getInstance().catchApiUsageAsync("Instabug.addExperiments", i0.d.a.a.a.O("addExperiments", List.class).setValue(this.a));
            i0.j.e.i iVar = Instabug.getInstance().delegate;
            List<String> list = this.a;
            Objects.requireNonNull(iVar);
            i0.j.e.o0.d.a.d().c(list);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements ReturnableRunnable<String> {
        @Override // com.instabug.library.apichecker.ReturnableRunnable
        public String run() throws Exception {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.getUserEmail", new Api.Parameter[0]);
            InstabugSDKLogger.i(Instabug.TAG, "getUserEmail");
            return i0.j.e.c1.b.v();
        }
    }

    /* loaded from: classes2.dex */
    public static class b0 implements VoidRunnable {
        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.resetTags", new Api.Parameter[0]);
            SettingsManager.getInstance().resetTags();
            InstabugSDKLogger.i(Instabug.TAG, "resetTags");
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements VoidRunnable {
        public final /* synthetic */ State a;

        public c(State state) {
            this.a = state;
        }

        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            State state = this.a;
            if (state == null) {
                InstabugSDKLogger.w(Instabug.TAG, "reproStepsState object passed to Instabug.setReproStepsState() is null");
                return;
            }
            if (state == State.ENABLED) {
                i0.j.e.z.j().d(Feature.REPRO_STEPS, Feature.State.ENABLED);
                SettingsManager.getInstance().setReproStepsScreenshotEnabled(true);
            } else if (state == State.ENABLED_WITH_NO_SCREENSHOTS) {
                i0.j.e.z.j().d(Feature.REPRO_STEPS, Feature.State.ENABLED);
                SettingsManager.getInstance().setReproStepsScreenshotEnabled(false);
            } else if (state == State.DISABLED) {
                i0.j.e.z.j().d(Feature.REPRO_STEPS, Feature.State.DISABLED);
            }
            StringBuilder P0 = i0.d.a.a.a.P0("setReproStepsState: ");
            P0.append(this.a.name());
            InstabugSDKLogger.i(Instabug.TAG, P0.toString());
        }
    }

    /* loaded from: classes2.dex */
    public static class c0 implements VoidRunnable {
        public final /* synthetic */ List a;

        public c0(List list) {
            this.a = list;
        }

        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() throws Exception {
            AnalyticsWrapper.getInstance().catchApiUsageAsync("Instabug.removeExperiments", i0.d.a.a.a.O("removeExperiments", List.class).setValue(this.a));
            i0.j.e.i iVar = Instabug.getInstance().delegate;
            List<String> list = this.a;
            Objects.requireNonNull(iVar);
            i0.j.e.o0.d.a.d().i(list);
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements ReturnableRunnable<String> {
        @Override // com.instabug.library.apichecker.ReturnableRunnable
        public String run() throws Exception {
            return SettingsManager.getInstance().getAppToken();
        }
    }

    /* loaded from: classes2.dex */
    public static class d0 implements VoidRunnable {
        public final /* synthetic */ InstabugCustomTextPlaceHolder a;

        public d0(InstabugCustomTextPlaceHolder instabugCustomTextPlaceHolder) {
            this.a = instabugCustomTextPlaceHolder;
        }

        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            if (this.a == null) {
                InstabugSDKLogger.w(Instabug.TAG, "instabugCustomTextPlaceHolder object passed to Instabug.setCustomTextPlaceHolders() is null");
                return;
            }
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.setCustomTextPlaceHolders", i0.d.a.a.a.O("instabugCustomTextPlaceHolder", InstabugCustomTextPlaceHolder.class));
            SettingsManager.getInstance().setCustomPlaceHolders(this.a);
        }
    }

    /* loaded from: classes2.dex */
    public static class e implements VoidRunnable {
        public final /* synthetic */ InstabugColorTheme a;

        public e(InstabugColorTheme instabugColorTheme) {
            this.a = instabugColorTheme;
        }

        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.setColorTheme", i0.d.a.a.a.O("instabugTheme", InstabugColorTheme.class).setValue(this.a));
            SettingsManager.getInstance().setTheme(this.a);
            int i = g0.a[this.a.ordinal()];
            if (i == 1) {
                SettingsManager.getInstance().setPrimaryColor(-9580554);
                SettingsManager.getInstance().setStatusBarColor(-16119286);
            } else if (i == 2) {
                SettingsManager.getInstance().setPrimaryColor(-15893761);
                SettingsManager.getInstance().setStatusBarColor(-3815737);
            }
            StringBuilder P0 = i0.d.a.a.a.P0("setColorTheme: ");
            P0.append(this.a.name());
            InstabugSDKLogger.i(Instabug.TAG, P0.toString());
        }
    }

    /* loaded from: classes2.dex */
    public static class e0 implements VoidRunnable {
        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() throws Exception {
            AnalyticsWrapper.getInstance().catchApiUsageAsync("Instabug.clearAllExperiments", new Api.Parameter[0]);
            Objects.requireNonNull(Instabug.getInstance().delegate);
            i0.j.e.o0.d.a.d().a();
        }
    }

    /* loaded from: classes2.dex */
    public static class f implements VoidRunnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public f(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.identifyUser", i0.d.a.a.a.O("username", String.class), i0.d.a.a.a.N("email"));
            if (Instabug.getApplicationContext() != null) {
                Context applicationContext = Instabug.getApplicationContext();
                String str = this.a;
                String str2 = this.b;
                if (applicationContext == null) {
                    InstabugSDKLogger.w("UserManager", "Context passed to identify is null");
                } else if (str2 == null || str2.trim().isEmpty()) {
                    InstabugSDKLogger.w("UserManager", "Empty email, Can't identify user");
                } else {
                    String trim = str2.trim();
                    if (!i0.j.e.c1.b.G() || !SettingsManager.getInstance().getIdentifiedUserEmail().equalsIgnoreCase(trim)) {
                        if (i0.j.e.c1.b.G()) {
                            i0.j.e.c1.b.H();
                        }
                        i0.j.e.c1.b.B(trim);
                        i0.j.e.c1.b.D(str);
                        i0.j.e.c1.b.z(str);
                        i0.j.e.c1.b.w(trim);
                        SettingsManager instance = SettingsManager.getInstance();
                        StringBuilder P0 = i0.d.a.a.a.P0(trim);
                        P0.append(SettingsManager.getInstance().getAppToken());
                        instance.setMD5Uuid(i0.j.e.c1.b.c(P0.toString()));
                        i0.j.e.c1.b.i(applicationContext);
                    }
                }
                StringBuilder P02 = i0.d.a.a.a.P0("identifyUser username: ");
                P02.append(this.a);
                P02.append(" email");
                P02.append(this.b);
                InstabugSDKLogger.i(Instabug.TAG, P02.toString());
                return;
            }
            InstabugSDKLogger.e(Instabug.TAG, "identifyUser failed to execute due to null app context");
        }
    }

    /* loaded from: classes2.dex */
    public static class f0 implements ReturnableRunnable<HashMap<String, String>> {
        @Override // com.instabug.library.apichecker.ReturnableRunnable
        public HashMap<String, String> run() throws Exception {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.getAllUserAttributes", new Api.Parameter[0]);
            InstabugSDKLogger.i(Instabug.TAG, "getAllUserAttributes");
            if (Instabug.getInstance() == null) {
                return new HashMap<>();
            }
            Objects.requireNonNull(Instabug.getInstance().delegate);
            return (HashMap) Filters.applyOn(UserAttributeCacheManager.retrieveAll()).apply(new i0.j.e.d1.d.b()).thenGet();
        }
    }

    /* loaded from: classes2.dex */
    public static class g implements VoidRunnable {
        public final /* synthetic */ String a;

        public g(String str) {
            this.a = str;
        }

        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.logUserEvent", i0.d.a.a.a.O("eventIdentifier", String.class));
            InstabugUserEventLogger.getInstance().logUserEvent(this.a, new UserEventParam[0]);
            InstabugSDKLogger.i(Instabug.TAG, "logUserEvent");
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class g0 {
        public static final /* synthetic */ int[] a;

        static {
            InstabugColorTheme.values();
            int[] iArr = new int[2];
            a = iArr;
            try {
                iArr[InstabugColorTheme.InstabugColorThemeDark.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[InstabugColorTheme.InstabugColorThemeLight.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class h implements VoidRunnable {
        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.logoutUser", new Api.Parameter[0]);
            i0.j.e.c1.b.H();
            InstabugSDKLogger.i(Instabug.TAG, "logoutUser");
        }
    }

    /* loaded from: classes2.dex */
    public static class h0 implements VoidRunnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public h0(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.setUserAttribute", i0.d.a.a.a.O(InstabugDbContract.UserAttributesEntry.COLUMN_KEY, String.class), i0.d.a.a.a.O(InstabugDbContract.UserAttributesEntry.COLUMN_VALUE, String.class));
            if (Instabug.getInstance() != null) {
                i0.j.e.i iVar = Instabug.getInstance().delegate;
                String str = this.a;
                String str2 = this.b;
                Objects.requireNonNull(iVar);
                PoolProvider.getUserActionsExecutor().execute(new i0.j.e.p(str, str2));
            }
            InstabugSDKLogger.i(Instabug.TAG, "setUserAttribute");
        }
    }

    /* loaded from: classes2.dex */
    public static class i implements VoidRunnable {

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            @Override // java.lang.Runnable
            public void run() {
                if (Instabug.getInstance() != null) {
                    Instabug.getInstance().delegate.k();
                }
                InstabugSDKLogger.i(Instabug.TAG, "enable");
                AnalyticsWrapper.getInstance().catchApiUsage("enable", new Api.Parameter[0]);
            }
        }

        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            if (Instabug.getInstance() != null) {
                Instabug.getInstance().delegate.g(Feature.State.ENABLED);
            }
            PoolProvider.postIOTaskWithCheck(new a());
        }
    }

    /* loaded from: classes2.dex */
    public static class i0 implements ReturnableRunnable<InstabugColorTheme> {
        @Override // com.instabug.library.apichecker.ReturnableRunnable
        public InstabugColorTheme run() throws Exception {
            return SettingsManager.getInstance().getTheme();
        }
    }

    /* loaded from: classes2.dex */
    public static class j implements VoidRunnable {
        public final /* synthetic */ Report.OnReportCreatedListener a;

        public j(Report.OnReportCreatedListener onReportCreatedListener) {
            this.a = onReportCreatedListener;
        }

        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.onReportSubmitHandler", i0.d.a.a.a.O("listener", Report.OnReportCreatedListener.class));
            SettingsManager.getInstance().setOnReportCreatedListener(this.a);
            InstabugSDKLogger.i(Instabug.TAG, "onReportSubmitHandler");
        }
    }

    /* loaded from: classes2.dex */
    public static class j0 implements ReturnableRunnable<String> {
        public final /* synthetic */ String a;

        public j0(String str) {
            this.a = str;
        }

        @Override // com.instabug.library.apichecker.ReturnableRunnable
        public String run() throws Exception {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.getUserAttribute", i0.d.a.a.a.O(InstabugDbContract.UserAttributesEntry.COLUMN_KEY, String.class));
            InstabugSDKLogger.i(Instabug.TAG, "getUserAttribute");
            if (Instabug.getInstance() == null) {
                return null;
            }
            i0.j.e.i iVar = Instabug.getInstance().delegate;
            String str = this.a;
            Objects.requireNonNull(iVar);
            return (String) Filters.applyOn(str).apply(new i0.j.e.d1.d.a()).thenDoReturn(new i0.j.e.d1.d.g());
        }
    }

    /* loaded from: classes2.dex */
    public static class k implements VoidRunnable {
        public final /* synthetic */ int a;

        public k(int i) {
            this.a = i;
        }

        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.setAutoScreenRecordingDuration", i0.d.a.a.a.O("maxDuration", Integer.class).setValue(Integer.valueOf(this.a)));
            SettingsManager.getInstance().setAutoScreenRecordingDuration(this.a);
            InstabugSDKLogger.i(Instabug.TAG, "setAutoScreenRecordingDuration: " + this.a);
        }
    }

    /* loaded from: classes2.dex */
    public static class k0 implements VoidRunnable {
        public final /* synthetic */ Uri a;
        public final /* synthetic */ String b;

        public k0(Uri uri, String str) {
            this.a = uri;
            this.b = str;
        }

        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            if (this.a == null) {
                InstabugSDKLogger.w(Instabug.TAG, "fileUri object passed to Instabug.addFileAttachment() is null");
            } else if (this.b == null) {
                InstabugSDKLogger.w(Instabug.TAG, "fileNameWithExtension object passed to Instabug.addFileAttachment() is null");
            } else {
                AnalyticsWrapper.getInstance().catchLoggingApiUsage("addFileAttachment", i0.d.a.a.a.O("fileUri", Uri.class), i0.d.a.a.a.O("fileNameWithExtension", String.class));
                SettingsManager.getInstance().addExtraAttachmentFile(this.a, this.b);
                InstabugSDKLogger.i(Instabug.TAG, "addFileAttachment uriFile");
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class l implements VoidRunnable {
        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            AnalyticsWrapper.getInstance().catchApiUsage("disable", new Api.Parameter[0]);
            if (Instabug.getInstance() != null) {
                Instabug.getInstance().delegate.l();
            }
            InstabugSDKLogger.i(Instabug.TAG, "disable");
        }
    }

    /* loaded from: classes2.dex */
    public static class l0 implements VoidRunnable {
        public final /* synthetic */ String a;

        public l0(String str) {
            this.a = str;
        }

        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.removeUserAttribute", i0.d.a.a.a.O(InstabugDbContract.UserAttributesEntry.COLUMN_KEY, String.class));
            if (Instabug.getInstance() != null) {
                i0.j.e.i iVar = Instabug.getInstance().delegate;
                String str = this.a;
                Objects.requireNonNull(iVar);
                PoolProvider.getUserActionsExecutor().execute(new i0.j.e.q(str));
            }
            InstabugSDKLogger.i(Instabug.TAG, "removeUserAttribute");
        }
    }

    /* loaded from: classes2.dex */
    public static class m implements VoidRunnable {
        public final /* synthetic */ int a;

        public m(int i) {
            this.a = i;
        }

        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.setPrimaryColor", i0.d.a.a.a.N("primaryColorValue").setType(Integer.TYPE).setValue(String.valueOf(this.a)));
            SettingsManager.getInstance().setPrimaryColor(this.a);
            InstabugSDKLogger.i(Instabug.TAG, "setPrimaryColor");
        }
    }

    /* loaded from: classes2.dex */
    public static class m0 implements VoidRunnable {
        public final /* synthetic */ byte[] a;
        public final /* synthetic */ String b;

        public m0(byte[] bArr, String str) {
            this.a = bArr;
            this.b = str;
        }

        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            if (this.a == null) {
                InstabugSDKLogger.w(Instabug.TAG, "data object passed to Instabug.addFileAttachment() is null");
            } else if (this.b == null) {
                InstabugSDKLogger.w(Instabug.TAG, "fileNameWithExtension object passed to Instabug.addFileAttachment() is null");
            } else {
                AnalyticsWrapper.getInstance().catchLoggingApiUsage("addFileAttachment", i0.d.a.a.a.O(MessageExtension.FIELD_DATA, Uri.class), i0.d.a.a.a.O("fileNameWithExtension", String.class));
                SettingsManager.getInstance().addExtraAttachmentFile(this.a, this.b);
                InstabugSDKLogger.i(Instabug.TAG, "addFileAttachment bytes");
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class n implements VoidRunnable {
        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            if (Instabug.getInstance() != null) {
                i0.j.e.i iVar = Instabug.getInstance().delegate;
                if (iVar.m().equals(InstabugState.ENABLED)) {
                    InstabugSDKLogger.d("InstabugDelegate", "Pausing Instabug SDK functionality temporary");
                    iVar.d(InstabugState.DISABLED);
                    PoolProvider.postMainThreadTask(new i0.j.e.n(iVar));
                }
            }
            InstabugSDKLogger.i(Instabug.TAG, "pauseSdk");
        }
    }

    /* loaded from: classes2.dex */
    public static class n0 implements VoidRunnable {
        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.clearAllUserAttributes", new Api.Parameter[0]);
            if (Instabug.getInstance() != null) {
                Objects.requireNonNull(Instabug.getInstance().delegate);
                PoolProvider.getUserActionsExecutor().execute(new i0.j.e.r());
            }
            InstabugSDKLogger.i(Instabug.TAG, "clearAllUserAttributes");
        }
    }

    /* loaded from: classes2.dex */
    public static class o implements VoidRunnable {
        public final /* synthetic */ Feature.State a;

        public o(Feature.State state) {
            this.a = state;
        }

        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            if (this.a != null) {
                AnalyticsWrapper.getInstance().catchApiUsage("Instabug.setAutoScreenRecordingAudioCapturingEnabled", i0.d.a.a.a.O("asrAudioCapturingEnabled", Feature.State.class).setValue(this.a.name()));
                SettingsManager.getInstance().setAutoScreenRecordingAudioCapturingState(this.a);
                InstabugSDKLogger.i(Instabug.TAG, "setAutoScreenRecordingAudioCapturingEnabled: " + this.a.name());
            }
            InstabugSDKLogger.w(Instabug.TAG, "isASRAudioEnabled object passed to Instabug.setAutoScreenRecordingAudioCapturingEnabled() is null");
        }
    }

    /* loaded from: classes2.dex */
    public static class o0 implements VoidRunnable {
        public final /* synthetic */ WelcomeMessage.State a;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AnalyticsWrapper.getInstance().catchApiUsage("Instabug.showWelcomeMessage", i0.d.a.a.a.O("WelcomeMessageState", String.class).setValue(o0.this.a.toString()));
                SettingsManager.getInstance().setWelcomeMessageState(o0.this.a);
                InstabugSDKLogger.i(Instabug.TAG, "setWelcomeMessageState: " + o0.this.a.name());
            }
        }

        public o0(WelcomeMessage.State state) {
            this.a = state;
        }

        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            if (this.a == null) {
                InstabugSDKLogger.w(Instabug.TAG, "welcomeMessageState object passed to Instabug.setWelcomeMessageState() is null");
            } else {
                PoolProvider.postIOTaskWithCheck(new a());
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class p implements VoidRunnable {
        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            if (Instabug.getInstance() != null) {
                i0.j.e.i iVar = Instabug.getInstance().delegate;
                Objects.requireNonNull(iVar);
                InstabugSDKLogger.d("InstabugDelegate", "Resuming Instabug SDK functionality temporary");
                iVar.d(InstabugState.ENABLED);
                PoolProvider.postMainThreadTask(new i0.j.e.o(iVar));
            }
            InstabugSDKLogger.i(Instabug.TAG, "pauseSdk");
        }
    }

    /* loaded from: classes2.dex */
    public static class p0 implements VoidRunnable {
        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            AnalyticsWrapper.getInstance().catchLoggingApiUsage("clearFileAttachment", new Api.Parameter[0]);
            SettingsManager.getInstance().clearExtraAttachmentFiles();
            InstabugSDKLogger.i(Instabug.TAG, "clearFileAttachment");
        }
    }

    /* loaded from: classes2.dex */
    public static class q implements VoidRunnable {
        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.show", new Api.Parameter[0]);
            InvocationManager.getInstance().show();
            InstabugSDKLogger.i(Instabug.TAG, "show");
        }
    }

    /* loaded from: classes2.dex */
    public static class q0 implements ReturnableRunnable<String> {
        @Override // com.instabug.library.apichecker.ReturnableRunnable
        public String run() throws Exception {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.getUserData", new Api.Parameter[0]);
            InstabugSDKLogger.i(Instabug.TAG, "getUserData");
            return SettingsManager.getInstance().getUserData();
        }
    }

    /* loaded from: classes2.dex */
    public static class r implements VoidRunnable {
        public final /* synthetic */ Locale a;

        public r(Locale locale) {
            this.a = locale;
        }

        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            if (this.a == null) {
                InstabugSDKLogger.w(Instabug.TAG, "locale object passed to Instabug.setLocale is null");
                return;
            }
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.setLocale", i0.d.a.a.a.O(com.instabug.library.model.State.KEY_LOCALE, Locale.class).setValue(this.a));
            if (Instabug.getInstance() != null) {
                i0.j.e.i iVar = Instabug.getInstance().delegate;
                Locale locale = this.a;
                Objects.requireNonNull(iVar);
                Locale instabugLocale = SettingsManager.getInstance().getInstabugLocale(iVar.i());
                if (!instabugLocale.equals(locale)) {
                    SettingsManager.getInstance().setInstabugLocale(locale);
                    synchronized (i0.j.e.y.b.a.b) {
                        if (i0.j.e.y.b.a.b("notifyPluginsLocaleChanged()")) {
                            for (Plugin plugin : i0.j.e.y.b.a.a) {
                                plugin.onLocaleChanged(instabugLocale, locale);
                            }
                        }
                    }
                }
            }
            InstabugSDKLogger.i(Instabug.TAG, "setLocale");
        }
    }

    /* loaded from: classes2.dex */
    public static class r0 implements ReturnableRunnable<Integer> {
        @Override // com.instabug.library.apichecker.ReturnableRunnable
        public Integer run() throws Exception {
            return Integer.valueOf(SettingsManager.getInstance().getPrimaryColor());
        }
    }

    /* loaded from: classes2.dex */
    public static class s implements VoidRunnable {
        public final /* synthetic */ View[] a;

        public s(View[] viewArr) {
            this.a = viewArr;
        }

        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            AnalyticsWrapper.getInstance().catchDeprecatedApiUsage("setViewsAsPrivate", new Api.Parameter[0]);
            if (!(Instabug.getInstance() == null || Instabug.getInstance().delegate == null)) {
                i0.j.e.i iVar = Instabug.getInstance().delegate;
                View[] viewArr = this.a;
                Objects.requireNonNull(iVar);
                InstabugDeprecationLogger.getInstance().log("Instabug.setViewsAsPrivate() has been deprecated, and while it is still function, it will be completely removed in a future release. for more details about this API's replacement, check the docs here: https://docs.instabug.com/docs/android-repro-steps#section-private-views");
                SettingsManager.getInstance().addPrivateViews(viewArr);
            }
            InstabugSDKLogger.i(Instabug.TAG, "setViewsAsPrivate");
        }
    }

    /* loaded from: classes2.dex */
    public static class s0 implements VoidRunnable {
        public final /* synthetic */ String a;

        public s0(String str) {
            this.a = str;
        }

        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.setUserData", i0.d.a.a.a.O("userData", String.class));
            if (i0.j.e.z.j().h(Feature.USER_DATA) == Feature.State.ENABLED) {
                SettingsManager.getInstance().setUserData(StringUtility.trimString(this.a, 1000));
                InstabugSDKLogger.i(Instabug.TAG, "setUserData");
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class t implements ReturnableRunnable<Locale> {
        public final /* synthetic */ Context a;

        public t(Context context) {
            this.a = context;
        }

        @Override // com.instabug.library.apichecker.ReturnableRunnable
        public Locale run() throws Exception {
            return SettingsManager.getInstance().getInstabugLocale(this.a);
        }
    }

    /* loaded from: classes2.dex */
    public static class t0 implements VoidRunnable {
        public final /* synthetic */ WelcomeMessage.State a;

        public t0(WelcomeMessage.State state) {
            this.a = state;
        }

        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            if (this.a == null) {
                InstabugSDKLogger.w(Instabug.TAG, "welcomeMessageState object passed to Instabug.showWelcomeMessage() is null");
                return;
            }
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.showWelcomeMessage", i0.d.a.a.a.O("showWelcomeMessage", String.class).setValue(this.a.toString()));
            if (!InstabugCore.isForegroundBusy() && Instabug.getInstance() != null) {
                Instabug.getInstance().delegate.e(this.a);
            }
            StringBuilder P0 = i0.d.a.a.a.P0("showWelcomeMessage: ");
            P0.append(this.a.name());
            InstabugSDKLogger.i(Instabug.TAG, P0.toString());
        }
    }

    /* loaded from: classes2.dex */
    public static class u implements VoidRunnable {
        public final /* synthetic */ View[] a;

        public u(View[] viewArr) {
            this.a = viewArr;
        }

        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.addPrivateViews", new Api.Parameter[0]);
            if (!(Instabug.getInstance() == null || Instabug.getInstance().delegate == null)) {
                i0.j.e.i iVar = Instabug.getInstance().delegate;
                View[] viewArr = this.a;
                Objects.requireNonNull(iVar);
                SettingsManager.getInstance().addPrivateViews(viewArr);
            }
            InstabugSDKLogger.i(Instabug.TAG, "addPrivateViews");
        }
    }

    /* loaded from: classes2.dex */
    public static class u0 implements VoidRunnable {
        public final /* synthetic */ Feature.State a;

        public u0(Feature.State state) {
            this.a = state;
        }

        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            if (this.a == null) {
                InstabugSDKLogger.w(Instabug.TAG, "state object passed to Instabug.setViewHierarchyState() is null");
                return;
            }
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.setViewHierarchyState", i0.d.a.a.a.O("state", Feature.State.class).setValue(this.a));
            i0.j.e.z.j().d(Feature.VIEW_HIERARCHY_V2, this.a);
            InstabugSDKLogger.i(Instabug.TAG, "setViewHierarchyState: " + this.a.name());
        }
    }

    /* loaded from: classes2.dex */
    public static class v implements VoidRunnable {
        public final /* synthetic */ boolean a;

        public v(boolean z) {
            this.a = z;
        }

        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.setDebugEnabled", i0.d.a.a.a.N("isDebugEnabled").setType(Boolean.TYPE).setValue(Boolean.valueOf(this.a)));
            SettingsManager.getInstance().setDebugEnabled(this.a);
            InstabugSDKLogger.i(Instabug.TAG, "setDebugEnabled " + this.a);
        }
    }

    /* loaded from: classes2.dex */
    public static class v0 implements VoidRunnable {
        public final /* synthetic */ int a;

        public v0(int i) {
            this.a = i;
        }

        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            AnalyticsWrapper.getInstance().catchDeprecatedApiUsage("setAutoScreenRecordingMaxDuration", i0.d.a.a.a.O("setAutoScreenRecordingMaxDuration", Boolean.class).setValue(String.valueOf(this.a)));
            SettingsManager.getInstance().setAutoScreenRecordingMaxDuration(this.a);
            Log.e(Instabug.class.getName(), "AutoScreen recording is disabled please contact support for further details.");
            InstabugSDKLogger.i(Instabug.TAG, "setAutoScreenRecordingMaxDuration " + this.a);
        }
    }

    /* loaded from: classes2.dex */
    public static class w implements VoidRunnable {
        public final /* synthetic */ View[] a;

        public w(View[] viewArr) {
            this.a = viewArr;
        }

        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.removePrivateViews", new Api.Parameter[0]);
            if (!(Instabug.getInstance() == null || Instabug.getInstance().delegate == null)) {
                i0.j.e.i iVar = Instabug.getInstance().delegate;
                View[] viewArr = this.a;
                Objects.requireNonNull(iVar);
                SettingsManager.getInstance().removePrivateViews(viewArr);
            }
            InstabugSDKLogger.i(Instabug.TAG, "removePrivateViews");
        }
    }

    /* loaded from: classes2.dex */
    public static class w0 implements VoidRunnable {
        public final /* synthetic */ Feature.State a;

        public w0(Feature.State state) {
            this.a = state;
        }

        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            if (this.a == null) {
                InstabugSDKLogger.w(Instabug.TAG, "state object passed to Instabug.setSessionProfilerState() is null");
                return;
            }
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.setSessionProfilerState", i0.d.a.a.a.O("state", Feature.State.class).setValue(this.a));
            if (Instabug.getInstance() != null) {
                i0.j.e.i iVar = Instabug.getInstance().delegate;
                Feature.State state = this.a;
                Objects.requireNonNull(iVar);
                i0.j.e.z.j().d(Feature.SESSION_PROFILER, state);
                if (state != Feature.State.ENABLED || !Instabug.isEnabled()) {
                    i0.j.e.u0.b.c().b();
                } else {
                    i0.j.e.u0.b.c().a();
                }
            }
            StringBuilder P0 = i0.d.a.a.a.P0("setSessionProfilerState: ");
            P0.append(this.a.name());
            InstabugSDKLogger.i(Instabug.TAG, P0.toString());
        }
    }

    /* loaded from: classes2.dex */
    public static class x implements VoidRunnable {
        public final /* synthetic */ String[] a;

        public x(String[] strArr) {
            this.a = strArr;
        }

        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.addTags", new Api.Parameter[0]);
            SettingsManager.getInstance().addTags(StringUtility.trimStrings(this.a));
            InstabugSDKLogger.i(Instabug.TAG, "addTags");
        }
    }

    /* loaded from: classes2.dex */
    public static class y implements VoidRunnable {
        @Override // com.instabug.library.apichecker.VoidRunnable
        public void run() {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.disableInternal", new Api.Parameter[0]);
            if (Instabug.getInstance() != null) {
                Instabug.getInstance().delegate.l();
                InstabugSDKLogger.i(Instabug.TAG, "disable");
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class z implements ReturnableRunnable<ArrayList<String>> {
        @Override // com.instabug.library.apichecker.ReturnableRunnable
        public ArrayList<String> run() throws Exception {
            AnalyticsWrapper.getInstance().catchApiUsage("Instabug.getTags", new Api.Parameter[0]);
            return SettingsManager.getInstance().getTags();
        }
    }

    public /* synthetic */ Instabug(i0.j.e.i iVar, v vVar) {
        this(iVar);
    }

    public static void addExperiments(List<String> list) {
        APIChecker.checkAndRun("Instabug.addExperiments", new a0(list));
    }

    public static void addFileAttachment(Uri uri, String str) {
        APIChecker.checkAndRun("Instabug.addFileAttachment", new k0(uri, str));
    }

    public static void addPrivateViews(View... viewArr) {
        APIChecker.checkAndRun("Instabug.addPrivateViews", new u(viewArr));
    }

    public static void addTags(String... strArr) {
        APIChecker.checkAndRun("Instabug.addTags", new x(strArr));
    }

    public static void clearAllExperiments() {
        APIChecker.checkAndRun("Instabug.clearAllExperiments", new e0());
    }

    public static void clearAllUserAttributes() {
        APIChecker.checkAndRun("Instabug.clearAllUserAttributes", new n0());
    }

    public static void clearFileAttachment() {
        APIChecker.checkAndRun("Instabug.clearFileAttachment", new p0());
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static synchronized void disable() {
        synchronized (Instabug.class) {
            APIChecker.checkAndRun("Instabug.disable", new l());
        }
    }

    private static void disableInternal() {
        APIChecker.checkAndRun("Instabug.disableInternal", new y());
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static synchronized void enable() {
        synchronized (Instabug.class) {
            APIChecker.checkBuilt("Instabug.enable", new i());
        }
    }

    public static HashMap<String, String> getAllUserAttributes() {
        return (HashMap) APIChecker.checkAndGet("Instabug.getAllUserAttributes", new f0(), null);
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public static String getAppToken() {
        return (String) APIChecker.checkAndGet("Instabug.getAppToken", new d(), null);
    }

    public static Context getApplicationContext() {
        if (getInstance() != null) {
            return getInstance().delegate.i();
        }
        return null;
    }

    public static Date getFirstRunAt() {
        return SettingsManager.getInstance().getFirstRunAt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Instabug getInstance() {
        i0.j.e.l0.d.a aVar;
        Application application;
        if (!(INSTANCE != null || (aVar = i0.j.e.l0.d.a.a) == null || (application = aVar.b) == null)) {
            INSTANCE = new Instabug(new i0.j.e.i(application));
        }
        return INSTANCE;
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public static Locale getLocale(Context context) {
        return (Locale) APIChecker.checkAndGet("Instabug.getLocale", new t(context), Locale.getDefault());
    }

    @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
    public static int getPrimaryColor() {
        return ((Integer) APIChecker.checkAndGet("Instabug.getPrimaryColor", new r0(), 0)).intValue();
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public static ArrayList<String> getTags() {
        return (ArrayList) APIChecker.checkAndGet("Instabug.getTags", new z(), null);
    }

    @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
    public static InstabugColorTheme getTheme() {
        return (InstabugColorTheme) APIChecker.checkAndGet("Instabug.getTheme", new i0(), InstabugColorTheme.InstabugColorThemeLight);
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public static String getUserAttribute(String str) {
        return (String) APIChecker.checkAndGet("Instabug.getUserAttribute", new j0(str), null);
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public static String getUserData() {
        return (String) APIChecker.checkAndGet("Instabug.getUserData", new q0(), "");
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public static String getUserEmail() {
        return (String) APIChecker.checkAndGet("Instabug.getUserEmail", new b(), "");
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static void identifyUser(String str, String str2) {
        APIChecker.checkAndRun("Instabug.identifyUser", new f(str, str2));
    }

    public static boolean isAppOnForeground() {
        return SettingsManager.getInstance().isAppOnForeground();
    }

    public static boolean isBuilding() {
        return InstabugStateProvider.getInstance().getState() == InstabugState.BUILDING;
    }

    public static boolean isBuilt() {
        return (INSTANCE == null || InstabugStateProvider.getInstance().getState() == InstabugState.NOT_BUILT) ? false : true;
    }

    public static boolean isEnabled() {
        if (!isBuilt()) {
            return false;
        }
        i0.j.e.z j2 = i0.j.e.z.j();
        Feature feature = Feature.INSTABUG;
        if (!j2.i(feature) || i0.j.e.z.j().h(feature) != Feature.State.ENABLED) {
            return false;
        }
        return true;
    }

    public static void logUserEvent(String str) {
        APIChecker.checkAndRun("Instabug.logUserEvent", new g(str));
    }

    public static void logoutUser() {
        APIChecker.checkAndRun("Instabug.logoutUser", new h());
    }

    public static void onReportSubmitHandler(Report.OnReportCreatedListener onReportCreatedListener) {
        APIChecker.checkAndRun("Instabug.onReportSubmitHandler", new j(onReportCreatedListener));
    }

    public static void pauseSdk() {
        APIChecker.checkAndRun("Instabug.pauseSdk", new n());
    }

    public static void removeExperiments(List<String> list) {
        APIChecker.checkAndRun("Instabug.removeExperiments", new c0(list));
    }

    public static void removePrivateViews(View... viewArr) {
        APIChecker.checkAndRun("Instabug.removePrivateViews", new w(viewArr));
    }

    public static void removeUserAttribute(String str) {
        APIChecker.checkAndRun("Instabug.removeUserAttribute", new l0(str));
    }

    private static void reportScreenChange(Bitmap bitmap, String str) {
        if (!isBuilt()) {
            Log.i(TAG, "reportScreenChange() was called before building the SDK");
        } else if (getInstance() == null || getInstance().delegate == null) {
            Log.i(TAG, "reportScreenChange() was called but Instabug is null");
        } else {
            if (bitmap != null) {
                AnalyticsWrapper.getInstance().catchDeprecatedApiUsage("screenshot", new Api.Parameter().setName("screenshot").setType(Bitmap.class).setValue(bitmap));
            }
            AnalyticsWrapper.getInstance().catchDeprecatedApiUsage("screenName", new Api.Parameter().setName("screenName").setType(String.class).setValue(str));
            Objects.requireNonNull(getInstance().delegate);
            i0.j.e.f1.n k2 = i0.j.e.f1.n.k();
            Objects.requireNonNull(k2);
            if (!InstabugCore.isForegroundBusy()) {
                if (str != null && !str.isEmpty()) {
                    k2.e(str, StepType.ACTIVITY_RESUMED);
                }
                if (SettingsManager.getInstance().isReproStepsScreenshotEnabled()) {
                    if (bitmap != null) {
                        i0.j.e.f1.c l2 = k2.l();
                        InstabugInternalTrackingDelegate instance = InstabugInternalTrackingDelegate.getInstance();
                        if (!(instance == null || instance.getTargetActivity() == null || l2 == null)) {
                            PoolProvider.postIOTask(new i0.j.e.f1.o(bitmap, instance.getTargetActivity(), l2));
                        }
                    } else if (k2.l() != null) {
                        k2.b(k2.l());
                    }
                }
            }
            i0.j.e.a1.e.c().d = str;
            SDKCoreEventPublisher.post(new SDKCoreEvent("cross_platform_state_screen_changed", str));
        }
    }

    public static void resetTags() {
        APIChecker.checkAndRun("Instabug.resetTags", new b0());
    }

    public static void resumeSdk() {
        APIChecker.checkAndRun("Instabug.resumeSdk", new p());
    }

    public static void setAutoScreenRecordingAudioCapturingEnabled(Feature.State state) {
        APIChecker.checkAndRun("Instabug.setAutoScreenRecordingAudioCapturingEnabled", new o(state));
    }

    public static void setAutoScreenRecordingDuration(int i2) {
        APIChecker.checkAndRun("Instabug.setAutoScreenRecordingDuration", new k(i2));
    }

    @Deprecated
    public static void setAutoScreenRecordingMaxDuration(int i2) {
        APIChecker.checkAndRun("Instabug.setAutoScreenRecordingMaxDuration", new v0(i2));
    }

    public static void setColorTheme(InstabugColorTheme instabugColorTheme) {
        APIChecker.checkAndRun("Instabug.setColorTheme", new e(instabugColorTheme));
    }

    private static void setCurrentPlatform(@Platform int i2) {
        SettingsManager.getInstance().setCurrentPlatform(i2);
    }

    public static void setCustomTextPlaceHolders(InstabugCustomTextPlaceHolder instabugCustomTextPlaceHolder) {
        APIChecker.checkAndRun("Instabug.setCustomTextPlaceHolders", new d0(instabugCustomTextPlaceHolder));
    }

    public static void setDebugEnabled(boolean z2) {
        APIChecker.checkAndRun("Instabug.setDebugEnabled", new v(z2));
    }

    public static void setLocale(Locale locale) {
        APIChecker.checkAndRun("Instabug.setLocale", new r(locale));
    }

    public static void setPrimaryColor(int i2) {
        APIChecker.checkAndRun("Instabug.setPrimaryColor", new m(i2));
    }

    public static void setReproStepsState(State state) {
        APIChecker.checkAndRun("Instabug.setReproStepsState", new c(state));
    }

    public static void setSessionProfilerState(Feature.State state) {
        APIChecker.checkAndRun("Instabug.setSessionProfilerState", new w0(state));
    }

    public static void setTrackingUserStepsState(Feature.State state) {
        APIChecker.checkAndRun("Instabug.setTrackingUserStepsState", new a(state));
    }

    public static void setUserAttribute(String str, String str2) {
        APIChecker.checkAndRun("Instabug.setUserAttribute", new h0(str, str2));
    }

    public static void setUserData(String str) {
        APIChecker.checkAndRun("Instabug.setUserData", new s0(str));
    }

    @Deprecated
    public static void setViewHierarchyState(Feature.State state) {
        APIChecker.checkAndRun("Instabug.setViewHierarchyState", new u0(state));
    }

    @Deprecated
    public static void setViewsAsPrivate(View... viewArr) {
        APIChecker.checkAndRun("Instabug.setViewsAsPrivate", new s(viewArr));
    }

    public static void setWelcomeMessageState(WelcomeMessage.State state) {
        APIChecker.checkAndRun("Instabug.setWelcomeMessageState", new o0(state));
    }

    public static void show() {
        APIChecker.checkAndRun("Instabug.show", new q());
    }

    public static void showWelcomeMessage(WelcomeMessage.State state) {
        APIChecker.checkAndRun("Instabug.showWelcomeMessage", new t0(state));
    }

    private Instabug(i0.j.e.i iVar) {
        this.delegate = iVar;
    }

    public static void addFileAttachment(byte[] bArr, String str) {
        APIChecker.checkAndRun("Instabug.addFileAttachment", new m0(bArr, str));
    }
}
