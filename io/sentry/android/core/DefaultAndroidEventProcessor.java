package io.sentry.android.core;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.DisplayMetrics;
import i0.d.a.a.a;
import io.sentry.DateUtils;
import io.sentry.EventProcessor;
import io.sentry.ILogger;
import io.sentry.SentryEvent;
import io.sentry.SentryLevel;
import io.sentry.android.core.DefaultAndroidEventProcessor;
import io.sentry.android.core.util.ConnectivityChecker;
import io.sentry.android.core.util.DeviceOrientations;
import io.sentry.android.core.util.MainThreadChecker;
import io.sentry.android.core.util.RootChecker;
import io.sentry.protocol.App;
import io.sentry.protocol.DebugImage;
import io.sentry.protocol.DebugMeta;
import io.sentry.protocol.Device;
import io.sentry.protocol.OperatingSystem;
import io.sentry.protocol.SentryThread;
import io.sentry.protocol.User;
import io.sentry.util.ApplyScopeUtils;
import io.sentry.util.Objects;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes4.dex */
public final class DefaultAndroidEventProcessor implements EventProcessor {
    public static final String ANDROID_ID = "androidId";
    public static final String EMULATOR = "emulator";
    public static final String KERNEL_VERSION = "kernelVersion";
    public static final String PROGUARD_UUID = "proGuardUuids";
    public static final String ROOTED = "rooted";
    public static final String SIDE_LOADED = "sideLoaded";
    private static final Date appStartTime = DateUtils.getCurrentDateTime();
    private final IBuildInfoProvider buildInfoProvider;
    public final Context context;
    public final Future<Map<String, Object>> contextData;
    private final ILogger logger;
    private final RootChecker rootChecker;

    /* renamed from: io.sentry.android.core.DefaultAndroidEventProcessor$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$io$sentry$android$core$util$ConnectivityChecker$Status;

        static {
            ConnectivityChecker.Status.values();
            int[] iArr = new int[4];
            $SwitchMap$io$sentry$android$core$util$ConnectivityChecker$Status = iArr;
            try {
                iArr[ConnectivityChecker.Status.NOT_CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$sentry$android$core$util$ConnectivityChecker$Status[ConnectivityChecker.Status.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private static /* synthetic */ void $closeResource(Throwable th, AutoCloseable autoCloseable) {
        if (th != null) {
            try {
                autoCloseable.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        } else {
            autoCloseable.close();
        }
    }

    public DefaultAndroidEventProcessor(Context context, ILogger iLogger, IBuildInfoProvider iBuildInfoProvider) {
        this(context, iLogger, iBuildInfoProvider, new RootChecker(context, iBuildInfoProvider, iLogger));
    }

    private String getAbi() {
        return Build.CPU_ABI;
    }

    private String getAbi2() {
        return Build.CPU_ABI2;
    }

    private String getAndroidId() {
        String string = Settings.Secure.getString(this.context.getContentResolver(), "android_id");
        if (string != null && !string.isEmpty() && !string.toLowerCase(Locale.ROOT).contentEquals("9774d56d682e549c")) {
            return string;
        }
        try {
            return Installation.id(this.context);
        } catch (RuntimeException e) {
            this.logger.log(SentryLevel.ERROR, "Could not generate device Id.", e);
            return null;
        }
    }

    private String getApplicationName() {
        try {
            ApplicationInfo applicationInfo = this.context.getApplicationInfo();
            int i = applicationInfo.labelRes;
            if (i != 0) {
                return this.context.getString(i);
            }
            CharSequence charSequence = applicationInfo.nonLocalizedLabel;
            if (charSequence != null) {
                return charSequence.toString();
            }
            return this.context.getPackageManager().getApplicationLabel(applicationInfo).toString();
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting application name.", e);
            return null;
        }
    }

    private int getAvailableBlocksDep(StatFs statFs) {
        return statFs.getAvailableBlocks();
    }

    private long getAvailableBlocksLong(StatFs statFs) {
        return statFs.getAvailableBlocksLong();
    }

    private Intent getBatteryIntent() {
        return this.context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    private Float getBatteryLevel(Intent intent) {
        try {
            int intExtra = intent.getIntExtra("level", -1);
            int intExtra2 = intent.getIntExtra("scale", -1);
            if (!(intExtra == -1 || intExtra2 == -1)) {
                return Float.valueOf((((float) intExtra) / ((float) intExtra2)) * 100.0f);
            }
            return null;
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting device battery level.", e);
            return null;
        }
    }

    private Float getBatteryTemperature(Intent intent) {
        try {
            int intExtra = intent.getIntExtra("temperature", -1);
            if (intExtra != -1) {
                return Float.valueOf(((float) intExtra) / 10.0f);
            }
            return null;
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting battery temperature.", e);
            return null;
        }
    }

    private int getBlockCountDep(StatFs statFs) {
        return statFs.getBlockCount();
    }

    private long getBlockCountLong(StatFs statFs) {
        return statFs.getBlockCountLong();
    }

    private int getBlockSizeDep(StatFs statFs) {
        return statFs.getBlockSize();
    }

    private long getBlockSizeLong(StatFs statFs) {
        return statFs.getBlockSizeLong();
    }

    private Date getBootTime() {
        try {
            return DateUtils.getDateTime(System.currentTimeMillis() - SystemClock.elapsedRealtime());
        } catch (IllegalArgumentException e) {
            this.logger.log(SentryLevel.ERROR, e, "Error getting the device's boot time.", new Object[0]);
            return null;
        }
    }

    private List<DebugImage> getDebugImages() {
        ArrayList arrayList = null;
        try {
            Object obj = this.contextData.get().get(PROGUARD_UUID);
            String[] strArr = obj != null ? (String[]) obj : null;
            if (!(strArr == null || strArr.length == 0)) {
                arrayList = new ArrayList();
                for (String str : strArr) {
                    DebugImage debugImage = new DebugImage();
                    debugImage.setType("proguard");
                    debugImage.setUuid(str);
                    arrayList.add(debugImage);
                }
            }
            return arrayList;
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting Proguard UUIDs.", e);
            return null;
        }
    }

    private Device getDevice() {
        Boolean bool;
        Device device = new Device();
        device.setName(getDeviceName());
        device.setManufacturer(Build.MANUFACTURER);
        device.setBrand(Build.BRAND);
        device.setFamily(getFamily());
        device.setModel(Build.MODEL);
        device.setModelId(Build.ID);
        setArchitectures(device);
        Intent batteryIntent = getBatteryIntent();
        if (batteryIntent != null) {
            device.setBatteryLevel(getBatteryLevel(batteryIntent));
            device.setCharging(isCharging(batteryIntent));
            device.setBatteryTemperature(getBatteryTemperature(batteryIntent));
        }
        int ordinal = ConnectivityChecker.getConnectionStatus(this.context, this.logger).ordinal();
        if (ordinal == 0) {
            bool = Boolean.TRUE;
        } else if (ordinal != 1) {
            bool = null;
        } else {
            bool = Boolean.FALSE;
        }
        device.setOnline(bool);
        device.setOrientation(getOrientation());
        try {
            Object obj = this.contextData.get().get(EMULATOR);
            if (obj != null) {
                device.setSimulator((Boolean) obj);
            }
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting emulator.", e);
        }
        ActivityManager.MemoryInfo memInfo = getMemInfo();
        if (memInfo != null) {
            device.setMemorySize(getMemorySize(memInfo));
            device.setFreeMemory(Long.valueOf(memInfo.availMem));
            device.setLowMemory(Boolean.valueOf(memInfo.lowMemory));
        }
        File externalFilesDir = this.context.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            StatFs statFs = new StatFs(externalFilesDir.getPath());
            device.setStorageSize(getTotalInternalStorage(statFs));
            device.setFreeStorage(getUnusedInternalStorage(statFs));
        }
        StatFs externalStorageStat = getExternalStorageStat(externalFilesDir);
        if (externalStorageStat != null) {
            device.setExternalStorageSize(getTotalExternalStorage(externalStorageStat));
            device.setExternalFreeStorage(getUnusedExternalStorage(externalStorageStat));
        }
        DisplayMetrics displayMetrics = getDisplayMetrics();
        if (displayMetrics != null) {
            device.setScreenWidthPixels(Integer.valueOf(displayMetrics.widthPixels));
            device.setScreenHeightPixels(Integer.valueOf(displayMetrics.heightPixels));
            device.setScreenDensity(Float.valueOf(displayMetrics.density));
            device.setScreenDpi(Integer.valueOf(displayMetrics.densityDpi));
        }
        device.setBootTime(getBootTime());
        device.setTimezone(getTimeZone());
        if (device.getId() == null) {
            device.setId(getDeviceId());
        }
        if (device.getLanguage() == null) {
            device.setLanguage(Locale.getDefault().toString());
        }
        if (device.getConnectionType() == null) {
            device.setConnectionType(ConnectivityChecker.getConnectionType(this.context, this.logger, this.buildInfoProvider));
        }
        return device;
    }

    private String getDeviceId() {
        try {
            Object obj = this.contextData.get().get(ANDROID_ID);
            if (obj != null) {
                return (String) obj;
            }
            return null;
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting androidId.", e);
            return null;
        }
    }

    private String getDeviceName() {
        return Settings.Global.getString(this.context.getContentResolver(), "device_name");
    }

    private DisplayMetrics getDisplayMetrics() {
        try {
            return this.context.getResources().getDisplayMetrics();
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting DisplayMetrics.", e);
            return null;
        }
    }

    private File[] getExternalFilesDirs() {
        return this.context.getExternalFilesDirs(null);
    }

    private File getExternalStorageDep(File file) {
        File[] externalFilesDirs = getExternalFilesDirs();
        if (externalFilesDirs != null) {
            String absolutePath = file != null ? file.getAbsolutePath() : null;
            for (File file2 : externalFilesDirs) {
                if (file2 != null && (absolutePath == null || absolutePath.isEmpty() || !file2.getAbsolutePath().contains(absolutePath))) {
                    return file2;
                }
            }
        } else {
            this.logger.log(SentryLevel.INFO, "Not possible to read getExternalFilesDirs", new Object[0]);
        }
        return null;
    }

    private StatFs getExternalStorageStat(File file) {
        if (!isExternalStorageMounted()) {
            File externalStorageDep = getExternalStorageDep(file);
            if (externalStorageDep != null) {
                return new StatFs(externalStorageDep.getPath());
            }
            this.logger.log(SentryLevel.INFO, "Not possible to read external files directory", new Object[0]);
            return null;
        }
        this.logger.log(SentryLevel.INFO, "External storage is not mounted or emulated.", new Object[0]);
        return null;
    }

    private String getFamily() {
        try {
            return Build.MODEL.split(" ", -1)[0];
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting device family.", e);
            return null;
        }
    }

    private String getKernelVersion() {
        String property = System.getProperty("os.version");
        File file = new File("/proc/version");
        if (!file.canRead()) {
            return property;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String readLine = bufferedReader.readLine();
            $closeResource(null, bufferedReader);
            return readLine;
        } catch (IOException e) {
            this.logger.log(SentryLevel.ERROR, "Exception while attempting to read kernel information", e);
            return property;
        }
    }

    private ActivityManager.MemoryInfo getMemInfo() {
        try {
            ActivityManager activityManager = (ActivityManager) this.context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo;
            }
            this.logger.log(SentryLevel.INFO, "Error getting MemoryInfo.", new Object[0]);
            return null;
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting MemoryInfo.", e);
            return null;
        }
    }

    private Long getMemorySize(ActivityManager.MemoryInfo memoryInfo) {
        return Long.valueOf(memoryInfo.totalMem);
    }

    private OperatingSystem getOperatingSystem() {
        OperatingSystem operatingSystem = new OperatingSystem();
        operatingSystem.setName("Android");
        operatingSystem.setVersion(Build.VERSION.RELEASE);
        operatingSystem.setBuild(Build.DISPLAY);
        try {
            Object obj = this.contextData.get().get(KERNEL_VERSION);
            if (obj != null) {
                operatingSystem.setKernelVersion((String) obj);
            }
            Object obj2 = this.contextData.get().get(ROOTED);
            if (obj2 != null) {
                operatingSystem.setRooted((Boolean) obj2);
            }
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting OperatingSystem.", e);
        }
        return operatingSystem;
    }

    private Device.DeviceOrientation getOrientation() {
        Device.DeviceOrientation deviceOrientation;
        Exception e;
        try {
            deviceOrientation = DeviceOrientations.getOrientation(this.context.getResources().getConfiguration().orientation);
            if (deviceOrientation == null) {
                try {
                    this.logger.log(SentryLevel.INFO, "No device orientation available (ORIENTATION_SQUARE|ORIENTATION_UNDEFINED)", new Object[0]);
                    return null;
                } catch (Exception e2) {
                    e = e2;
                    this.logger.log(SentryLevel.ERROR, "Error getting device orientation.", e);
                    return deviceOrientation;
                }
            }
        } catch (Exception e3) {
            e = e3;
            deviceOrientation = null;
        }
        return deviceOrientation;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Throwable, java.lang.String[]] */
    private String[] getProguardUUIDs() {
        String property;
        th = 0;
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(this.context.getAssets().open("sentry-debug-meta.properties"));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream);
                property = properties.getProperty("io.sentry.ProguardUuids");
            } finally {
                try {
                    throw th;
                } finally {
                }
            }
        } catch (FileNotFoundException unused) {
            this.logger.log(SentryLevel.INFO, "sentry-debug-meta.properties file was not found.", new Object[0]);
        } catch (IOException e) {
            this.logger.log(SentryLevel.ERROR, "Error getting Proguard UUIDs.", e);
        } catch (RuntimeException e2) {
            this.logger.log(SentryLevel.ERROR, "sentry-debug-meta.properties file is malformed.", e2);
        }
        if (property == null || property.isEmpty()) {
            this.logger.log(SentryLevel.INFO, "io.sentry.ProguardUuids property was not found or it is invalid.", new Object[0]);
            return th;
        }
        String[] split = property.split("\\|", -1);
        for (String str : split) {
            this.logger.log(SentryLevel.DEBUG, "Proguard UUID found: %s", str);
        }
        return split;
    }

    private Map<String, String> getSideLoadedInfo() {
        String str;
        try {
            PackageInfo packageInfo = ContextUtils.getPackageInfo(this.context, this.logger);
            PackageManager packageManager = this.context.getPackageManager();
            if (!(packageInfo == null || packageManager == null)) {
                str = packageInfo.packageName;
                try {
                    String installerPackageName = packageManager.getInstallerPackageName(str);
                    HashMap hashMap = new HashMap();
                    if (installerPackageName != null) {
                        hashMap.put("isSideLoaded", "false");
                        hashMap.put("installerStore", installerPackageName);
                    } else {
                        hashMap.put("isSideLoaded", "true");
                    }
                    return hashMap;
                } catch (IllegalArgumentException unused) {
                    this.logger.log(SentryLevel.DEBUG, "%s package isn't installed.", str);
                    return null;
                }
            }
        } catch (IllegalArgumentException unused2) {
            str = null;
        }
        return null;
    }

    private TimeZone getTimeZone() {
        LocaleList locales = this.context.getResources().getConfiguration().getLocales();
        if (!locales.isEmpty()) {
            return Calendar.getInstance(locales.get(0)).getTimeZone();
        }
        return Calendar.getInstance().getTimeZone();
    }

    private Long getTotalExternalStorage(StatFs statFs) {
        try {
            return Long.valueOf(getBlockCountLong(statFs) * getBlockSizeLong(statFs));
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting total external storage amount.", e);
            return null;
        }
    }

    private Long getTotalInternalStorage(StatFs statFs) {
        try {
            return Long.valueOf(getBlockCountLong(statFs) * getBlockSizeLong(statFs));
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting total internal storage amount.", e);
            return null;
        }
    }

    private Long getUnusedExternalStorage(StatFs statFs) {
        try {
            return Long.valueOf(getAvailableBlocksLong(statFs) * getBlockSizeLong(statFs));
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting unused external storage amount.", e);
            return null;
        }
    }

    private Long getUnusedInternalStorage(StatFs statFs) {
        try {
            return Long.valueOf(getAvailableBlocksLong(statFs) * getBlockSizeLong(statFs));
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting unused internal storage amount.", e);
            return null;
        }
    }

    private Boolean isCharging(Intent intent) {
        try {
            int intExtra = intent.getIntExtra("plugged", -1);
            boolean z = true;
            if (!(intExtra == 1 || intExtra == 2)) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting device charging state.", e);
            return null;
        }
    }

    private Boolean isEmulator() {
        boolean z;
        try {
            if (!Build.BRAND.startsWith("generic") || !Build.DEVICE.startsWith("generic")) {
                String str = Build.FINGERPRINT;
                if (!str.startsWith("generic") && !str.startsWith("unknown")) {
                    String str2 = Build.HARDWARE;
                    if (!str2.contains("goldfish") && !str2.contains("ranchu")) {
                        String str3 = Build.MODEL;
                        if (!str3.contains("google_sdk") && !str3.contains("Emulator") && !str3.contains("Android SDK built for x86") && !Build.MANUFACTURER.contains("Genymotion")) {
                            String str4 = Build.PRODUCT;
                            if (!str4.contains("sdk_google") && !str4.contains("google_sdk") && !str4.contains("sdk") && !str4.contains("sdk_x86") && !str4.contains("vbox86p") && !str4.contains(EMULATOR) && !str4.contains("simulator")) {
                                z = false;
                                return Boolean.valueOf(z);
                            }
                        }
                    }
                }
            }
            z = true;
            return Boolean.valueOf(z);
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error checking whether application is running in an emulator.", e);
            return null;
        }
    }

    private boolean isExternalStorageMounted() {
        String externalStorageState = Environment.getExternalStorageState();
        return ("mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState)) && !Environment.isExternalStorageEmulated();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: loadContextData */
    public Map<String, Object> a() {
        HashMap hashMap = new HashMap();
        String[] proguardUUIDs = getProguardUUIDs();
        if (proguardUUIDs != null) {
            hashMap.put(PROGUARD_UUID, proguardUUIDs);
        }
        hashMap.put(ROOTED, Boolean.valueOf(this.rootChecker.isDeviceRooted()));
        String androidId = getAndroidId();
        if (androidId != null) {
            hashMap.put(ANDROID_ID, androidId);
        }
        String kernelVersion = getKernelVersion();
        if (kernelVersion != null) {
            hashMap.put(KERNEL_VERSION, kernelVersion);
        }
        hashMap.put(EMULATOR, isEmulator());
        Map<String, String> sideLoadedInfo = getSideLoadedInfo();
        if (sideLoadedInfo != null) {
            hashMap.put(SIDE_LOADED, sideLoadedInfo);
        }
        return hashMap;
    }

    private void mergeDebugImages(SentryEvent sentryEvent) {
        List<DebugImage> debugImages = getDebugImages();
        if (debugImages != null) {
            DebugMeta debugMeta = sentryEvent.getDebugMeta();
            if (debugMeta == null) {
                debugMeta = new DebugMeta();
            }
            if (debugMeta.getImages() == null) {
                debugMeta.setImages(debugImages);
            } else {
                debugMeta.getImages().addAll(debugImages);
            }
            sentryEvent.setDebugMeta(debugMeta);
        }
    }

    private void mergeOS(SentryEvent sentryEvent) {
        String str;
        OperatingSystem operatingSystem = sentryEvent.getContexts().getOperatingSystem();
        sentryEvent.getContexts().setOperatingSystem(getOperatingSystem());
        if (operatingSystem != null) {
            String name = operatingSystem.getName();
            if (name == null || name.isEmpty()) {
                str = "os_1";
            } else {
                StringBuilder P0 = a.P0("os_");
                P0.append(name.trim().toLowerCase(Locale.ROOT));
                str = P0.toString();
            }
            sentryEvent.getContexts().put(str, operatingSystem);
        }
    }

    private void processNonCachedEvent(SentryEvent sentryEvent) {
        App app = sentryEvent.getContexts().getApp();
        if (app == null) {
            app = new App();
        }
        setAppExtras(app);
        mergeDebugImages(sentryEvent);
        PackageInfo packageInfo = ContextUtils.getPackageInfo(this.context, this.logger);
        if (packageInfo != null) {
            String versionCode = ContextUtils.getVersionCode(packageInfo);
            if (sentryEvent.getDist() == null) {
                sentryEvent.setDist(versionCode);
            }
            setAppPackageInfo(app, packageInfo);
        }
        sentryEvent.getContexts().setApp(app);
        if (sentryEvent.getThreads() != null) {
            for (SentryThread sentryThread : sentryEvent.getThreads()) {
                sentryThread.setCurrent(Boolean.valueOf(MainThreadChecker.isMainThread(sentryThread)));
            }
        }
    }

    private void setAppExtras(App app) {
        app.setAppName(getApplicationName());
        app.setAppStartTime(appStartTime);
    }

    private void setAppPackageInfo(App app, PackageInfo packageInfo) {
        app.setAppIdentifier(packageInfo.packageName);
        app.setAppVersion(packageInfo.versionName);
        app.setAppBuild(ContextUtils.getVersionCode(packageInfo));
    }

    private void setArchitectures(Device device) {
        device.setArchs(Build.SUPPORTED_ABIS);
    }

    private void setSideLoadedInfo(SentryEvent sentryEvent) {
        try {
            Object obj = this.contextData.get().get(SIDE_LOADED);
            if (obj instanceof Map) {
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    sentryEvent.setTag((String) entry.getKey(), (String) entry.getValue());
                }
            }
        } catch (Exception e) {
            this.logger.log(SentryLevel.ERROR, "Error getting side loaded info.", e);
        }
    }

    public User getDefaultUser() {
        User user = new User();
        user.setId(getDeviceId());
        return user;
    }

    @Override // io.sentry.EventProcessor
    public SentryEvent process(SentryEvent sentryEvent, Object obj) {
        if (ApplyScopeUtils.shouldApplyScopeData(obj)) {
            processNonCachedEvent(sentryEvent);
        } else {
            this.logger.log(SentryLevel.DEBUG, "Event was cached so not applying data relevant to the current app execution/version: %s", sentryEvent.getEventId());
        }
        User user = sentryEvent.getUser();
        if (user == null) {
            sentryEvent.setUser(getDefaultUser());
        } else if (user.getId() == null) {
            user.setId(getDeviceId());
        }
        if (sentryEvent.getContexts().getDevice() == null) {
            sentryEvent.getContexts().setDevice(getDevice());
        }
        mergeOS(sentryEvent);
        setSideLoadedInfo(sentryEvent);
        return sentryEvent;
    }

    public DefaultAndroidEventProcessor(Context context, ILogger iLogger, IBuildInfoProvider iBuildInfoProvider, RootChecker rootChecker) {
        this.context = (Context) Objects.requireNonNull(context, "The application context is required.");
        this.logger = (ILogger) Objects.requireNonNull(iLogger, "The Logger is required.");
        this.buildInfoProvider = (IBuildInfoProvider) Objects.requireNonNull(iBuildInfoProvider, "The BuildInfoProvider is required.");
        this.rootChecker = (RootChecker) Objects.requireNonNull(rootChecker, "The RootChecker is required.");
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.contextData = newSingleThreadExecutor.submit(new Callable() { // from class: k0.c.w.a.h
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DefaultAndroidEventProcessor.this.a();
            }
        });
        newSingleThreadExecutor.shutdown();
    }
}
