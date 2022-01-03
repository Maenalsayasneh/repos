package com.clubhouse.android.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import androidx.lifecycle.Lifecycle;
import com.clubhouse.analytics.AmplitudeAnalytics;
import com.clubhouse.android.channels.ChannelComponentHandler;
import com.clubhouse.android.channels.mvi.ChannelControlModel;
import com.clubhouse.android.data.models.local.user.SourceLocation;
import com.clubhouse.android.data.repos.NotificationRepo;
import com.clubhouse.android.ui.clubs.ClubArgs;
import com.clubhouse.android.ui.events.HalfEventArgs;
import com.clubhouse.android.ui.profile.ProfileArgs;
import com.clubhouse.app.R;
import com.google.firebase.messaging.RemoteMessage;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import h0.b0.v;
import h0.q.c0;
import h0.q.o;
import i0.e.b.d3.k;
import i0.e.b.e3.b;
import i0.e.b.e3.d;
import i0.e.b.f3.i.a;
import i0.j.f.p.h;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.text.StringsKt__IndentKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.j.g;
import m0.n.a.l;
import m0.n.b.i;
import n0.a.f0;
import n0.a.g2.a0;
import n0.a.g2.q;
import n0.a.m0;
import n0.a.x;
import v0.a.a;
/* compiled from: PushListenerService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001@B\u0007¢\u0006\u0004\b?\u0010\nJ'\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\"\u0010:\u001a\u0002038\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006A"}, d2 = {"Lcom/clubhouse/android/notifications/PushListenerService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "Landroid/os/Bundle;", "", "", MessageExtension.FIELD_DATA, "j", "(Landroid/os/Bundle;Ljava/util/Map;)Landroid/os/Bundle;", "Lm0/i;", "onCreate", "()V", "token", "h", "(Ljava/lang/String;)V", "onDestroy", "Lcom/google/firebase/messaging/RemoteMessage;", "remoteMessage", "f", "(Lcom/google/firebase/messaging/RemoteMessage;)V", "Li0/e/a/a;", "e2", "Li0/e/a/a;", "getAnalytics", "()Li0/e/a/a;", "setAnalytics", "(Li0/e/a/a;)V", "analytics", "Ln0/a/g2/q;", "h2", "Ln0/a/g2/q;", "activeChatState", "Li0/e/a/b/a;", "d2", "Li0/e/a/b/a;", "getActionTrailRecorder", "()Li0/e/a/b/a;", "setActionTrailRecorder", "(Li0/e/a/b/a;)V", "actionTrailRecorder", "Ln0/a/x;", "i2", "Ln0/a/x;", "serviceJob", "Ln0/a/f0;", "j2", "Ln0/a/f0;", "serviceScope", "", "g2", "Z", "appInForeground", "Li0/e/b/f3/i/a;", "c2", "Li0/e/b/f3/i/a;", "getUserComponentHandler", "()Li0/e/b/f3/i/a;", "setUserComponentHandler", "(Li0/e/b/f3/i/a;)V", "userComponentHandler", "Lcom/clubhouse/android/data/repos/NotificationRepo;", "f2", "Lcom/clubhouse/android/data/repos/NotificationRepo;", "notificationRepo", "<init>", "Sound", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class PushListenerService extends b {
    public a c2;
    public i0.e.a.b.a d2;
    public i0.e.a.a e2;
    public NotificationRepo f2;
    public boolean g2;
    public final q<String> h2 = a0.a(null);
    public final x i2;
    public final f0 j2;

    /* compiled from: PushListenerService.kt */
    /* loaded from: classes3.dex */
    public enum Sound {
        CHIME_NOTIFICATION(R.raw.chime_notification, "chime_notification.wav");
        
        private final String fileName;
        private final int res;

        Sound(int i, String str) {
            this.res = i;
            this.fileName = str;
        }

        public final String getFileName() {
            return this.fileName;
        }

        public final int getRes() {
            return this.res;
        }
    }

    public PushListenerService() {
        x z = m0.r.t.a.r.m.a1.a.z(null, 1);
        this.i2 = z;
        this.j2 = m0.r.t.a.r.m.a1.a.h(m0.c.plus(z));
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x0369, code lost:
        if (r10.equals("1") == true) goto L_0x036d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0381, code lost:
        if (r10.equals("1") == true) goto L_0x0385;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0399, code lost:
        if (r10.equals("1") == true) goto L_0x039d;
     */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0759  */
    /* JADX WARN: Removed duplicated region for block: B:267:? A[RETURN, SYNTHETIC] */
    @Override // com.google.firebase.messaging.FirebaseMessagingService
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void f(RemoteMessage remoteMessage) {
        NotificationCompat.Builder builder;
        String str;
        Object obj;
        String str2;
        NotificationCompat.Builder builder2;
        Uri uri;
        NotificationAction notificationAction;
        String str3;
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        ChannelComponentHandler s;
        i0.e.b.z2.e.a aVar;
        ChannelControlModel d;
        StatusBarNotification statusBarNotification;
        CharSequence charSequence;
        boolean z4;
        List<NotificationCompat.MessagingStyle.Message> messages;
        List<NotificationCompat.MessagingStyle.Message> messages2;
        String tag;
        i.e(remoteMessage, "remoteMessage");
        a.b bVar = v0.a.a.d;
        bVar.d(i.k("Notification message received with data: ", remoteMessage.I0()), new Object[0]);
        i0.e.a.b.a aVar2 = this.d2;
        if (aVar2 != null) {
            Map<String, String> I0 = remoteMessage.I0();
            i.d(I0, "remoteMessage.data");
            boolean z5 = this.g2;
            i.e(I0, "payload");
            aVar2.a.a("notification_delivered", g.c0(g.R(I0, "aps"), new Pair("in_foreground", String.valueOf(z5))));
            Map<String, String> I02 = remoteMessage.I0();
            i.d(I02, "remoteMessage.data");
            if (!I02.isEmpty()) {
                Map<String, String> I03 = remoteMessage.I0();
                i.d(I03, "remoteMessage.data");
                String str4 = I03.get("action");
                NotificationAction notificationAction2 = NotificationAction.ExpireChannel;
                if (StringsKt__IndentKt.f(str4, notificationAction2.getAction(), true)) {
                    String str5 = I03.get(notificationAction2.getDataKey());
                    if (str5 != null) {
                        d dVar = d.a;
                        int notificationId = notificationAction2.getNotificationId();
                        i.e(this, "context");
                        NotificationManagerCompat.from(this).cancel(str5, notificationId);
                        return;
                    }
                    return;
                }
                NotificationAction notificationAction3 = NotificationAction.ExpireWaveChannel;
                if (StringsKt__IndentKt.f(str4, notificationAction3.getAction(), true)) {
                    String str6 = I03.get(notificationAction3.getDataKey());
                    if (str6 != null) {
                        d dVar2 = d.a;
                        int notificationId2 = notificationAction3.getNotificationId();
                        i.e(this, "context");
                        NotificationManagerCompat.from(this).cancel(str6, notificationId2);
                        return;
                    }
                    return;
                }
                String str7 = "";
                if (StringsKt__IndentKt.f(str4, NotificationAction.OpenChat.getAction(), true)) {
                    String str8 = I03.get("chat");
                    if (str8 != null) {
                        str7 = str8;
                    }
                    if (!this.g2 || !i.a(str7, this.h2.getValue())) {
                        i0.e.b.e3.a aVar3 = i0.e.b.e3.a.a;
                        NotificationCompat.Builder smallIcon = new NotificationCompat.Builder(this, i0.e.b.e3.a.d.a).setSmallIcon(R.drawable.ic_backchannel_notification);
                        i.d(smallIcon, "Builder(this, ClubhouseNotifications.MESSAGES.channelId)\n            .setSmallIcon(R.drawable.ic_backchannel_notification)");
                        h0.t.i iVar = new h0.t.i(this);
                        iVar.e(R.navigation.main_graph);
                        iVar.d(R.id.hallwayFragment);
                        Bundle a = new i0.e.b.g3.p.i(null, str7, null, null, 0, 29).a();
                        j(a, I03);
                        iVar.e = a;
                        iVar.b.putExtra("android-support-nav:controller:deepLinkExtras", a);
                        smallIcon.setContentIntent(iVar.a());
                        NotificationCompat.Builder priority = smallIcon.setAutoCancel(true).setCategory(NotificationCompat.CATEGORY_MESSAGE).setPriority(2);
                        i.d(priority, "Builder(this, ClubhouseNotifications.MESSAGES.channelId)\n            .setSmallIcon(R.drawable.ic_backchannel_notification)\n            .setDeeplinkForChat(this, chatId, data)\n            .setAutoCancel(true)\n            .setCategory(NotificationCompat.CATEGORY_MESSAGE)\n            .setPriority(NotificationCompat.PRIORITY_MAX)");
                        Person.Builder name = new Person.Builder().setName(I03.get(NotificationCompat.MessagingStyle.Message.KEY_SENDER));
                        String str9 = I03.get("image_url");
                        if (!(str9 == null || StringsKt__IndentKt.o(str9))) {
                            try {
                                Bitmap n = k.n(str9);
                                if (n != null) {
                                    PorterDuff.Mode mode = IconCompat.a;
                                    IconCompat iconCompat = new IconCompat(5);
                                    iconCompat.c = n;
                                    name.setIcon(iconCompat);
                                }
                            } catch (Exception e) {
                                v0.a.a.d.w(e, "Error in notification avatar", new Object[0]);
                            }
                        }
                        Person build = name.build();
                        i.d(build, "Builder()\n            .setName(data[\"sender\"])\n            .apply {\n                val imageUrl = data[\"image_url\"]\n                if (!imageUrl.isNullOrBlank()) {\n                    try {\n                        val circularLargeIcon = getCircularBitmapFromUrl(imageUrl)\n                        circularLargeIcon?.let {\n                            setIcon(IconCompat.createWithAdaptiveBitmap(it))\n                        }\n                    } catch (e: Exception) {\n                        Timber.w(e, \"Error in notification avatar\")\n                    }\n                }\n            }\n            .build()");
                        Object systemService = getSystemService("notification");
                        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                        StatusBarNotification[] activeNotifications = ((NotificationManager) systemService).getActiveNotifications();
                        i.d(activeNotifications, "context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager)\n            .activeNotifications");
                        int length = activeNotifications.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                statusBarNotification = null;
                                break;
                            }
                            statusBarNotification = activeNotifications[i2];
                            if ((statusBarNotification == null || (tag = statusBarNotification.getTag()) == null || !tag.equals(str7)) ? false : true) {
                                break;
                            }
                            i2++;
                        }
                        Notification notification = statusBarNotification == null ? null : statusBarNotification.getNotification();
                        if (notification == null) {
                            NotificationCompat.MessagingStyle addMessage = new NotificationCompat.MessagingStyle(build).addMessage(I03.get("body"), new Date().getTime(), build);
                            i.d(addMessage, "MessagingStyle(sender).addMessage(data[\"body\"], Date().time, sender)");
                            String str10 = I03.get("group_title");
                            if (!(str10 == null || StringsKt__IndentKt.o(str10))) {
                                addMessage.setConversationTitle(str10);
                                addMessage.setGroupConversation(true);
                            } else {
                                addMessage.setGroupConversation(false);
                            }
                            addMessage.setBuilder(priority);
                            NotificationManagerCompat.from(this).notify(str7, 6534, priority.build());
                            return;
                        }
                        NotificationCompat.MessagingStyle extractMessagingStyleFromNotification = NotificationCompat.MessagingStyle.extractMessagingStyleFromNotification(notification);
                        NotificationCompat.MessagingStyle messagingStyle = new NotificationCompat.MessagingStyle(build);
                        if (extractMessagingStyleFromNotification == null) {
                            charSequence = null;
                        } else {
                            charSequence = extractMessagingStyleFromNotification.getConversationTitle();
                        }
                        messagingStyle.setConversationTitle(charSequence);
                        if (extractMessagingStyleFromNotification == null) {
                            z4 = false;
                        } else {
                            z4 = extractMessagingStyleFromNotification.isGroupConversation();
                        }
                        messagingStyle.setGroupConversation(z4);
                        if (!(extractMessagingStyleFromNotification == null || (messages2 = extractMessagingStyleFromNotification.getMessages()) == null)) {
                            for (NotificationCompat.MessagingStyle.Message message : messages2) {
                                messagingStyle.addMessage(new NotificationCompat.MessagingStyle.Message(message.getText(), message.getTimestamp(), message.getPerson()));
                            }
                        }
                        messagingStyle.addMessage(new NotificationCompat.MessagingStyle.Message(I03.get("body"), new Date().getTime(), build));
                        priority.setStyle(messagingStyle).setNumber(((extractMessagingStyleFromNotification == null || (messages = extractMessagingStyleFromNotification.getMessages()) == null) ? 0 : messages.size()) + 1);
                        NotificationManagerCompat.from(this).notify(str7, 6534, priority.build());
                        return;
                    }
                    return;
                }
                Map<String, String> I04 = remoteMessage.I0();
                i.d(I04, "remoteMessage.data");
                String str11 = I04.get("action");
                String str12 = I04.get("sound");
                if (i.a(str12 == null ? null : Boolean.valueOf(!StringsKt__IndentKt.o(str12)), Boolean.TRUE)) {
                    i0.e.b.e3.a aVar4 = i0.e.b.e3.a.a;
                    builder = new NotificationCompat.Builder(this, i0.e.b.e3.a.c.a);
                } else {
                    i0.e.b.e3.a aVar5 = i0.e.b.e3.a.a;
                    builder = new NotificationCompat.Builder(this, i0.e.b.e3.a.e.a).setSilent(true);
                    i.d(builder, "{\n            NotificationCompat.Builder(this, ClubhouseNotifications.UPDATES_DEFAULT.channelId)\n                .setSilent(true)\n        }");
                }
                NotificationAction notificationAction4 = NotificationAction.OpenChannel;
                if (StringsKt__IndentKt.f(str11, notificationAction4.getAction(), true)) {
                    Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
                    i0.e.b.f3.i.a aVar6 = this.c2;
                    if (aVar6 != null) {
                        i0.e.b.h3.a.b bVar2 = aVar6.d;
                        if (!(bVar2 == null || (s = v.s(bVar2)) == null || (aVar = s.c) == null || (d = v.b0(aVar).d()) == null)) {
                            v.v2(d, new l<i0.e.b.z2.g.k, m0.i>() { // from class: com.clubhouse.android.notifications.PushListenerService$channelNotification$1$1
                                @Override // m0.n.a.l
                                public m0.i invoke(i0.e.b.z2.g.k kVar) {
                                    i0.e.b.z2.g.k kVar2 = kVar;
                                    i.e(kVar2, "it");
                                    Ref$BooleanRef.this.c = kVar2.m && kVar2.d.h();
                                    return m0.i.a;
                                }
                            });
                        }
                        String str13 = I04.get("invite_to_channel");
                        if (str13 == null) {
                            str2 = "remoteMessage.data";
                        } else {
                            str2 = "remoteMessage.data";
                            z = true;
                        }
                        z = false;
                        String str14 = I04.get("is_new_room");
                        if (str14 == null) {
                            obj = "sound";
                        } else {
                            obj = "sound";
                            z2 = true;
                        }
                        z2 = false;
                        String str15 = I04.get("is_welcome_room_for_self");
                        if (str15 == null) {
                            str = "Error in notification avatar";
                        } else {
                            str = "Error in notification avatar";
                            z3 = true;
                        }
                        z3 = false;
                        String str16 = I04.get("is_welcome_room_for_others");
                        boolean z6 = str16 != null && str16.equals("1");
                        if ((z2 || z || z3 || z6) && (!ref$BooleanRef.c || z3 || z)) {
                            String str17 = I04.get(notificationAction4.getDataKey());
                            if (str17 == null) {
                                bVar.d(i.k("Unhandled push notification with action: open_channel and data: ", I04), new Object[0]);
                            } else {
                                h0.t.i iVar2 = new h0.t.i(this);
                                iVar2.e(R.navigation.main_graph);
                                iVar2.d(R.id.hallwayFragment);
                                Bundle a2 = new i0.e.b.g3.p.i(str17, null, null, null, SourceLocation.REMOTE_NOTIFICATION.getCode(), 14).a();
                                j(a2, I04);
                                iVar2.e = a2;
                                iVar2.b.putExtra("android-support-nav:controller:deepLinkExtras", a2);
                                PendingIntent a3 = iVar2.a();
                                i.d(a3, "NavDeepLinkBuilder(this)\n                .setGraph(R.navigation.main_graph)\n                .setDestination(R.id.hallwayFragment)\n                .setArguments(\n                    HallwayFragmentArgs(\n                        channelId = channel,\n                        sourceLocation = SourceLocation.REMOTE_NOTIFICATION.code\n                    ).toBundle()\n                        .addNotificationDataExtra(data)\n                )\n                .createPendingIntent()");
                                builder2 = builder.setContentIntent(a3);
                                if (builder2 != null) {
                                    String str18 = I03.get("body");
                                    String str19 = str18 != null ? str18 : str7;
                                    String str20 = I03.get(InstabugDbContract.FeatureRequestEntry.COLUMN_TITLE);
                                    String str21 = I03.get("image_url");
                                    builder2.setContentText(str19);
                                    if (str20 != null) {
                                        builder2.setContentTitle(str20);
                                    }
                                    if (!(str21 == null || StringsKt__IndentKt.o(str21))) {
                                        try {
                                            Bitmap n2 = k.n(str21);
                                            if (n2 != null) {
                                                builder2.setLargeIcon(n2);
                                            }
                                        } catch (Exception e2) {
                                            v0.a.a.d.w(e2, str, new Object[0]);
                                        }
                                    }
                                    builder2.setSmallIcon(R.drawable.ic_hand_wave);
                                    builder2.setAutoCancel(true);
                                    NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle().bigText(str19);
                                    if (str20 != null) {
                                        builder2.setContentTitle(str20);
                                    }
                                    builder2.setStyle(bigText);
                                    Sound sound = Sound.CHIME_NOTIFICATION;
                                    if (StringsKt__IndentKt.f(I03.get(obj), sound.getFileName(), true)) {
                                        StringBuilder P0 = i0.d.a.a.a.P0("android.resource://");
                                        P0.append((Object) getPackageName());
                                        P0.append('/');
                                        P0.append(sound.getRes());
                                        uri = Uri.parse(P0.toString());
                                    } else {
                                        uri = null;
                                    }
                                    if (uri != null) {
                                        builder2.setSound(uri);
                                    }
                                    int i3 = 0;
                                    builder2.setPriority(0);
                                    Map<String, String> I05 = remoteMessage.I0();
                                    i.d(I05, str2);
                                    String str22 = I05.get("action");
                                    NotificationAction[] values = NotificationAction.values();
                                    while (true) {
                                        if (i3 >= 11) {
                                            notificationAction = null;
                                            break;
                                        }
                                        notificationAction = values[i3];
                                        if (StringsKt__IndentKt.f(str22, notificationAction.getAction(), true)) {
                                            break;
                                        }
                                        i3++;
                                    }
                                    if (notificationAction == null) {
                                        str3 = null;
                                    } else {
                                        str3 = notificationAction.getDataKey();
                                    }
                                    String str23 = I05.get(str3);
                                    if (notificationAction == null) {
                                        i = 3310;
                                    } else {
                                        i = notificationAction.getNotificationId();
                                    }
                                    d dVar3 = d.a;
                                    Notification build2 = builder2.build();
                                    i.d(build2, "builder.build()");
                                    i.e(this, "context");
                                    i.e(build2, "notification");
                                    NotificationManagerCompat.from(this).notify(str23, i, build2);
                                    return;
                                }
                                return;
                            }
                        }
                        builder2 = null;
                        if (builder2 != null) {
                        }
                    } else {
                        i.m("userComponentHandler");
                        throw null;
                    }
                } else {
                    str2 = "remoteMessage.data";
                    str = "Error in notification avatar";
                    obj = "sound";
                    NotificationAction notificationAction5 = NotificationAction.OpenWaveChannel;
                    if (StringsKt__IndentKt.f(str11, notificationAction5.getAction(), true)) {
                        if (!this.g2) {
                            String str24 = I04.get("from_user_profile_id");
                            if (str24 == null) {
                                StringBuilder P02 = i0.d.a.a.a.P0("Unhandled push notification with action: ");
                                P02.append(notificationAction5.getAction());
                                P02.append(" and data: ");
                                P02.append(I04);
                                bVar.d(P02.toString(), new Object[0]);
                            } else {
                                h0.t.i iVar3 = new h0.t.i(this);
                                iVar3.e(R.navigation.main_graph);
                                iVar3.d(R.id.hallwayFragment);
                                Bundle a4 = new i0.e.b.g3.p.i(null, null, str24, I04.get(notificationAction5.getDataKey()), SourceLocation.REMOTE_NOTIFICATION.getCode(), 3).a();
                                j(a4, I04);
                                iVar3.e = a4;
                                iVar3.b.putExtra("android-support-nav:controller:deepLinkExtras", a4);
                                PendingIntent a5 = iVar3.a();
                                i.d(a5, "NavDeepLinkBuilder(this)\n                .setGraph(R.navigation.main_graph)\n                .setDestination(R.id.hallwayFragment)\n                .setArguments(\n                    HallwayFragmentArgs(\n                        waveUserId = waveUserId,\n                        waveId = data[OpenWaveChannel.dataKey],\n                        sourceLocation = SourceLocation.REMOTE_NOTIFICATION.code\n                    ).toBundle()\n                        .addNotificationDataExtra(data)\n                )\n                .createPendingIntent()");
                                builder2 = builder.setContentIntent(a5);
                                if (builder2 != null) {
                                }
                            }
                        }
                        builder2 = null;
                        if (builder2 != null) {
                        }
                    } else {
                        NotificationAction notificationAction6 = NotificationAction.OpenClub;
                        if (StringsKt__IndentKt.f(str11, notificationAction6.getAction(), true)) {
                            String str25 = I04.get(notificationAction6.getDataKey());
                            if (str25 != null) {
                                h0.t.i iVar4 = new h0.t.i(this);
                                iVar4.e(R.navigation.main_graph);
                                iVar4.d(R.id.clubFragment);
                                ClubArgs clubArgs = new ClubArgs(StringsKt__IndentKt.S(str25), null, null, false, false, SourceLocation.REMOTE_NOTIFICATION, null, 94);
                                i.e(clubArgs, "arg");
                                Bundle bundle = new Bundle();
                                bundle.putParcelable("mavericks:arg", clubArgs);
                                j(bundle, I04);
                                iVar4.e = bundle;
                                iVar4.b.putExtra("android-support-nav:controller:deepLinkExtras", bundle);
                                PendingIntent a6 = iVar4.a();
                                i.d(a6, "NavDeepLinkBuilder(this)\n            .setGraph(R.navigation.main_graph)\n            .setDestination(R.id.clubFragment)\n            .setArguments(\n                mvArgs(\n                    ClubArgs(\n                        clubId = clubId.toIntOrNull(),\n                        source = SourceLocation.REMOTE_NOTIFICATION))\n                    .addNotificationDataExtra(data)\n            )\n            .createPendingIntent()");
                                builder2 = builder.setContentIntent(a6);
                                i.d(builder2, "builder.setContentIntent(launchIntent)");
                                if (builder2 != null) {
                                }
                            }
                            builder2 = null;
                            if (builder2 != null) {
                            }
                        } else {
                            if (StringsKt__IndentKt.f(str11, NotificationAction.OpenInvites.getAction(), true)) {
                                h0.t.i iVar5 = new h0.t.i(this);
                                iVar5.e(R.navigation.main_graph);
                                iVar5.d(R.id.invitesFragment);
                                Bundle bundle2 = new Bundle();
                                j(bundle2, I04);
                                iVar5.e = bundle2;
                                iVar5.b.putExtra("android-support-nav:controller:deepLinkExtras", bundle2);
                                PendingIntent a7 = iVar5.a();
                                i.d(a7, "NavDeepLinkBuilder(this)\n            .setGraph(R.navigation.main_graph)\n            .setDestination(R.id.invitesFragment)\n            .setArguments(Bundle().addNotificationDataExtra(data))\n            .createPendingIntent()");
                                builder2 = builder.setContentIntent(a7);
                                i.d(builder2, "builder.setContentIntent(launchIntent)");
                            } else {
                                NotificationAction notificationAction7 = NotificationAction.OpenEvent;
                                if (StringsKt__IndentKt.f(str11, notificationAction7.getAction(), true)) {
                                    String str26 = I04.get(notificationAction7.getDataKey());
                                    if (str26 != null) {
                                        h0.t.i iVar6 = new h0.t.i(this);
                                        iVar6.e(R.navigation.main_graph);
                                        iVar6.d(R.id.eventsFragment);
                                        HalfEventArgs halfEventArgs = new HalfEventArgs(null, StringsKt__IndentKt.S(str26), null, null, null, null, null, 125);
                                        i.e(halfEventArgs, "arg");
                                        Bundle bundle3 = new Bundle();
                                        bundle3.putParcelable("mavericks:arg", halfEventArgs);
                                        j(bundle3, I04);
                                        iVar6.e = bundle3;
                                        iVar6.b.putExtra("android-support-nav:controller:deepLinkExtras", bundle3);
                                        PendingIntent a8 = iVar6.a();
                                        i.d(a8, "NavDeepLinkBuilder(this)\n            .setGraph(R.navigation.main_graph)\n            .setDestination(R.id.eventsFragment)\n            .setArguments(\n                mvArgs(HalfEventArgs(eventId = eventId.toIntOrNull()))\n                    .addNotificationDataExtra(data)\n            )\n            .createPendingIntent()");
                                        builder2 = builder.setContentIntent(a8);
                                        i.d(builder2, "builder.setContentIntent(launchIntent)");
                                    }
                                    builder2 = null;
                                } else {
                                    NotificationAction notificationAction8 = NotificationAction.OpenProfile;
                                    if (StringsKt__IndentKt.f(str11, notificationAction8.getAction(), true)) {
                                        String str27 = I04.get(notificationAction8.getDataKey());
                                        if (str27 != null) {
                                            h0.t.i iVar7 = new h0.t.i(this);
                                            iVar7.e(R.navigation.main_graph);
                                            iVar7.d(R.id.profileFragment);
                                            ProfileArgs profileArgs = new ProfileArgs(StringsKt__IndentKt.S(str27), null, null, false, null, SourceLocation.REMOTE_NOTIFICATION, null, 94);
                                            i.e(profileArgs, "arg");
                                            Bundle bundle4 = new Bundle();
                                            bundle4.putParcelable("mavericks:arg", profileArgs);
                                            j(bundle4, I04);
                                            iVar7.e = bundle4;
                                            iVar7.b.putExtra("android-support-nav:controller:deepLinkExtras", bundle4);
                                            PendingIntent a9 = iVar7.a();
                                            i.d(a9, "NavDeepLinkBuilder(this)\n            .setGraph(R.navigation.main_graph)\n            .setDestination(R.id.profileFragment)\n            .setArguments(\n                mvArgs(ProfileArgs(userId = userId.toIntOrNull(),\n                    source = SourceLocation.REMOTE_NOTIFICATION))\n                    .addNotificationDataExtra(data)\n            )\n            .createPendingIntent()");
                                            builder2 = builder.setContentIntent(a9);
                                            i.d(builder2, "builder.setContentIntent(launchIntent)");
                                        }
                                        builder2 = null;
                                    } else {
                                        NotificationAction notificationAction9 = NotificationAction.OpenUrl;
                                        if (StringsKt__IndentKt.f(str11, notificationAction9.getAction(), true)) {
                                            String str28 = I04.get(notificationAction9.getDataKey());
                                            if (str28 != null) {
                                                builder2 = builder.setContentIntent(PendingIntent.getActivity(this, 0, new Intent("android.intent.action.VIEW", Uri.parse(str28)), 1073741824));
                                                i.d(builder2, "builder.setContentIntent(launchIntent)");
                                            }
                                            builder2 = null;
                                        } else {
                                            NotificationAction notificationAction10 = NotificationAction.OpenRecentPayments;
                                            if (StringsKt__IndentKt.f(str11, notificationAction10.getAction(), true)) {
                                                if (I04.get(notificationAction10.getDataKey()) != null) {
                                                    h0.t.i iVar8 = new h0.t.i(this);
                                                    iVar8.e(R.navigation.main_graph);
                                                    iVar8.d(R.id.recentPaymentsFragment);
                                                    PendingIntent a10 = iVar8.a();
                                                    i.d(a10, "NavDeepLinkBuilder(this)\n            .setGraph(R.navigation.main_graph)\n            .setDestination(R.id.recentPaymentsFragment)\n            .createPendingIntent()");
                                                    builder2 = builder.setContentIntent(a10);
                                                    i.d(builder2, "builder.setContentIntent(launchIntent)");
                                                }
                                                builder2 = null;
                                            } else {
                                                bVar.d("Unrecognized push notification action: " + ((Object) str11) + " with data:" + I04, new Object[0]);
                                                if (this.g2) {
                                                    i0.e.a.a aVar7 = this.e2;
                                                    if (aVar7 != null) {
                                                        if (str11 == null) {
                                                            str11 = str7;
                                                        }
                                                        ((AmplitudeAnalytics) aVar7).b("PushNotification-Foreground-UnhandledAction", i0.d.a.a.a.n1("action", str11));
                                                    } else {
                                                        i.m("analytics");
                                                        throw null;
                                                    }
                                                } else {
                                                    i0.e.a.a aVar8 = this.e2;
                                                    if (aVar8 != null) {
                                                        if (str11 == null) {
                                                            str11 = str7;
                                                        }
                                                        ((AmplitudeAnalytics) aVar8).b("PushNotification-Response-UnhandledAction", i0.d.a.a.a.n1("action", str11));
                                                    } else {
                                                        i.m("analytics");
                                                        throw null;
                                                    }
                                                }
                                                h0.t.i iVar9 = new h0.t.i(this);
                                                iVar9.e(R.navigation.main_graph);
                                                iVar9.d(R.id.hallwayFragment);
                                                Bundle a11 = new i0.e.b.g3.p.i(null, null, null, null, SourceLocation.REMOTE_NOTIFICATION.getCode(), 15).a();
                                                j(a11, I04);
                                                iVar9.e = a11;
                                                iVar9.b.putExtra("android-support-nav:controller:deepLinkExtras", a11);
                                                PendingIntent a12 = iVar9.a();
                                                i.d(a12, "NavDeepLinkBuilder(this)\n            .setGraph(R.navigation.main_graph)\n            .setDestination(R.id.hallwayFragment)\n            .setArguments(\n                HallwayFragmentArgs(\n                    sourceLocation = SourceLocation.REMOTE_NOTIFICATION.code\n                )\n                    .toBundle()\n                    .addNotificationDataExtra(data)\n            )\n            .createPendingIntent()");
                                                builder2 = builder.setContentIntent(a12);
                                                i.d(builder2, "builder.setContentIntent(launchIntent)");
                                            }
                                        }
                                    }
                                }
                            }
                            if (builder2 != null) {
                            }
                        }
                    }
                }
            }
        } else {
            i.m("actionTrailRecorder");
            throw null;
        }
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void h(String str) {
        i.e(str, "token");
        v0.a.a.d.d(i.k("Notification token refreshed: ", str), new Object[0]);
        NotificationRepo notificationRepo = this.f2;
        if (notificationRepo != null) {
            m0.r.t.a.r.m.a1.a.E2(this.j2, d.c, null, new PushListenerService$onNewToken$1$1(notificationRepo, d.a.a(this), str, null), 2, null);
        }
    }

    public final Bundle j(Bundle bundle, Map<String, String> map) {
        HashMap hashMap = new HashMap(map);
        hashMap.putAll(map);
        bundle.putSerializable("notification_data", hashMap);
        return bundle;
    }

    @Override // i0.e.b.e3.b, android.app.Service
    public void onCreate() {
        super.onCreate();
        i0.e.b.f3.i.a aVar = this.c2;
        if (aVar != null) {
            i0.e.b.h3.a.b bVar = aVar.d;
            if (bVar != null) {
                this.f2 = ((i0.e.b.c3.i.a) h.L0(bVar, i0.e.b.c3.i.a.class)).j();
                m0.r.t.a.r.m.a1.a.F2(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(((i0.e.c.g.a) h.L0(bVar, i0.e.c.g.a.class)).k().a, new PushListenerService$onCreate$1$1(this, null)), this.j2);
            }
            c0 c0Var = c0.c;
            c0Var.Z1.a(new o() { // from class: com.clubhouse.android.notifications.PushListenerService$onCreate$$inlined$observeForeground$1
                @h0.q.a0(Lifecycle.Event.ON_START)
                public final void onMoveToForeground() {
                    PushListenerService.this.g2 = true;
                }
            });
            c0Var.Z1.a(new o() { // from class: com.clubhouse.android.notifications.PushListenerService$onCreate$$inlined$observeBackground$1
                @h0.q.a0(Lifecycle.Event.ON_STOP)
                public final void onMoveToBackground() {
                    PushListenerService.this.g2 = false;
                }
            });
            return;
        }
        i.m("userComponentHandler");
        throw null;
    }

    @Override // i0.h.c.t.g, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        m0.r.t.a.r.m.a1.a.o0(this.i2, null, 1, null);
    }
}
