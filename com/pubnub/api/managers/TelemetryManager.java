package com.pubnub.api.managers;

import androidx.core.app.NotificationCompat;
import com.pubnub.api.enums.PNOperationType;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes2.dex */
public class TelemetryManager {
    private static final int CLEAN_UP_INTERVAL = 1;
    private static final int CLEAN_UP_INTERVAL_MULTIPLIER = 1000;
    private static final double MAXIMUM_LATENCY_DATA_AGE = 60.0d;
    private static final int MAX_FRACTION_DIGITS = 3;
    private static final int TIMESTAMP_DIVIDER = 1000;
    private Timer timer;
    private NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
    private Map<String, List<Map<String, Double>>> latencies = new HashMap();

    /* renamed from: com.pubnub.api.managers.TelemetryManager$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$pubnub$api$enums$PNOperationType;

        static {
            PNOperationType.values();
            int[] iArr = new int[46];
            $SwitchMap$com$pubnub$api$enums$PNOperationType = iArr;
            try {
                iArr[PNOperationType.PNPublishOperation.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNHistoryOperation.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNFetchMessagesOperation.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNDeleteMessagesOperation.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNUnsubscribeOperation.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNWhereNowOperation.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNHereNowOperation.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNHeartbeatOperation.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNSetStateOperation.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNGetState.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNAddChannelsToGroupOperation.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNRemoveChannelsFromGroupOperation.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNChannelGroupsOperation.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNRemoveGroupOperation.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNChannelsForGroupOperation.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNPushNotificationEnabledChannelsOperation.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNAddPushNotificationsOnChannelsOperation.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNRemovePushNotificationsFromChannelsOperation.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNRemoveAllPushNotificationsOperation.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNAccessManagerAudit.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNAccessManagerGrant.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNMessageCountOperation.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNSignalOperation.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNSetUuidMetadataOperation.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNGetUuidMetadataOperation.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNGetAllUuidMetadataOperation.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNRemoveUuidMetadataOperation.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNSetChannelMetadataOperation.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNGetChannelMetadataOperation.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNGetAllChannelsMetadataOperation.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNRemoveChannelMetadataOperation.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNSetMembershipsOperation.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNGetMembershipsOperation.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNRemoveMembershipsOperation.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNManageMembershipsOperation.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNSetChannelMembersOperation.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNGetChannelMembersOperation.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNRemoveChannelMembersOperation.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNManageChannelMembersOperation.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNAccessManagerGrantToken.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNAddMessageAction.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNGetMessageActions.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNDeleteMessageAction.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                $SwitchMap$com$pubnub$api$enums$PNOperationType[PNOperationType.PNFileAction.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
        }
    }

    public TelemetryManager() {
        this.numberFormat.setMaximumFractionDigits(3);
        this.numberFormat.setRoundingMode(RoundingMode.HALF_UP);
        this.numberFormat.setGroupingUsed(false);
        startCleanUpTimer();
    }

    private static double averageLatencyFromData(List<Map<String, Double>> list) {
        double d = 0.0d;
        for (Map<String, Double> map : list) {
            d += map.get("l").doubleValue();
        }
        return d / ((double) list.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cleanUpTelemetryData() {
        double time = ((double) new Date().getTime()) / 1000.0d;
        Iterator it = new ArrayList(this.latencies.keySet()).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            ArrayList arrayList = new ArrayList();
            List<Map<String, Double>> list = this.latencies.get(str);
            for (Map<String, Double> map : list) {
                if (time - map.get("d").doubleValue() > MAXIMUM_LATENCY_DATA_AGE) {
                    arrayList.add(map);
                }
            }
            if (arrayList.size() > 0) {
                list.removeAll(arrayList);
            }
            if (list.size() == 0) {
                this.latencies.remove(str);
            }
        }
    }

    private static String endpointNameForOperation(PNOperationType pNOperationType) {
        switch (pNOperationType.ordinal()) {
            case 1:
            case 8:
            case 9:
            case 10:
            case 21:
            case 22:
                return "pres";
            case 2:
                return "pub";
            case 3:
                return "sig";
            case 4:
            case 5:
            case 6:
                return "hist";
            case 7:
                return "mc";
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return "cg";
            case 16:
            case 17:
            case 18:
            case 19:
                return "push";
            case 20:
            default:
                return NotificationCompat.MessagingStyle.Message.KEY_TIMESTAMP;
            case 23:
            case 24:
                return "pam";
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
                return "obj";
            case 41:
                return "pamv3";
            case 42:
            case 43:
            case 44:
                return "msga";
            case 45:
                return "file";
        }
    }

    private void startCleanUpTimer() {
        stopCleanUpTimer();
        Timer timer = new Timer("Telemetry Manager timer", true);
        this.timer = timer;
        timer.schedule(new TimerTask() { // from class: com.pubnub.api.managers.TelemetryManager.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                TelemetryManager.this.cleanUpTelemetryData();
            }
        }, 1000, 1000);
    }

    public synchronized Map<String, String> operationsLatency() {
        HashMap hashMap;
        hashMap = new HashMap();
        for (Map.Entry<String, List<Map<String, Double>>> entry : this.latencies.entrySet()) {
            String concat = "l_".concat(entry.getKey());
            double averageLatencyFromData = averageLatencyFromData(entry.getValue());
            if (averageLatencyFromData > 0.0d) {
                hashMap.put(concat, this.numberFormat.format(averageLatencyFromData));
            }
        }
        return hashMap;
    }

    public void stopCleanUpTimer() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.util.List] */
    public synchronized void storeLatency(long j, PNOperationType pNOperationType) {
        String endpointNameForOperation;
        if (!(pNOperationType == PNOperationType.PNSubscribeOperation || j <= 0 || (endpointNameForOperation = endpointNameForOperation(pNOperationType)) == null)) {
            double time = ((double) new Date().getTime()) / 1000.0d;
            List<Map<String, Double>> list = this.latencies.get(endpointNameForOperation);
            if (list == null) {
                list = new ArrayList<>();
                this.latencies.put(endpointNameForOperation, list);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("d", Double.valueOf(time));
            hashMap.put("l", Double.valueOf(((double) j) / 1000.0d));
            list.add(hashMap);
        }
    }
}
