package com.clubhouse.android.channels;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import com.clubhouse.android.channels.analytics.LeaveReason;
import com.clubhouse.android.data.models.local.channel.Channel;
import com.clubhouse.android.data.models.local.channel.ChannelInRoom;
import h0.q.q;
import i0.e.b.f3.i.a;
import i0.e.b.h3.a.b;
import i0.e.b.z2.c;
import i0.j.f.p.h;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.i;
import n0.a.g2.d;
import n0.a.g2.e;
/* compiled from: ChannelService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/clubhouse/android/channels/ChannelService;", "Lh0/q/t;", "Lm0/i;", "onCreate", "()V", "onDestroy", "Landroid/content/Intent;", "rootIntent", "onTaskRemoved", "(Landroid/content/Intent;)V", "Li0/e/b/f3/i/a;", "Y1", "Li0/e/b/f3/i/a;", "getUserComponentHandler", "()Li0/e/b/f3/i/a;", "setUserComponentHandler", "(Li0/e/b/f3/i/a;)V", "userComponentHandler", "Lcom/clubhouse/android/channels/ChannelBroadcastReceiver;", "Z1", "Lcom/clubhouse/android/channels/ChannelBroadcastReceiver;", "getBroadcastReceiver", "()Lcom/clubhouse/android/channels/ChannelBroadcastReceiver;", "setBroadcastReceiver", "(Lcom/clubhouse/android/channels/ChannelBroadcastReceiver;)V", "broadcastReceiver", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class ChannelService extends c {
    public static final /* synthetic */ int y = 0;
    public a Y1;
    public ChannelBroadcastReceiver Z1;

    @Override // i0.e.b.z2.c, h0.q.t, android.app.Service
    public void onCreate() {
        super.onCreate();
        a aVar = this.Y1;
        if (aVar != null) {
            b bVar = aVar.d;
            if (bVar != null) {
                m0.r.t.a.r.m.a1.a.F2(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new d<Channel>() { // from class: com.clubhouse.android.channels.ChannelService$onCreate$lambda-1$$inlined$filter$1
                    @Override // n0.a.g2.d
                    public Object collect(final e<? super Channel> eVar, m0.l.c cVar) {
                        Object collect = d.this.collect(new e<Channel>() { // from class: com.clubhouse.android.channels.ChannelService$onCreate$lambda-1$$inlined$filter$1.2
                            /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
                            /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
                            @Override // n0.a.g2.e
                            /* Code decompiled incorrectly, please refer to instructions dump */
                            public Object emit(Channel channel, m0.l.c cVar2) {
                                AnonymousClass1 r02;
                                int i;
                                if (cVar2 instanceof AnonymousClass1) {
                                    r02 = (AnonymousClass1) cVar2;
                                    int i2 = r02.d;
                                    if ((i2 & Integer.MIN_VALUE) != 0) {
                                        r02.d = i2 - Integer.MIN_VALUE;
                                        Object obj = r02.c;
                                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                        i = r02.d;
                                        if (i != 0) {
                                            h.d4(obj);
                                            e eVar2 = e.this;
                                            if (Boolean.valueOf(channel instanceof ChannelInRoom).booleanValue()) {
                                                r02.d = 1;
                                                if (eVar2.emit(channel, r02) == coroutineSingletons) {
                                                    return coroutineSingletons;
                                                }
                                            }
                                        } else if (i == 1) {
                                            h.d4(obj);
                                        } else {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        return i.a;
                                    }
                                }
                                r02 = new ContinuationImpl(cVar2) { // from class: com.clubhouse.android.channels.ChannelService$onCreate$lambda-1$.inlined.filter.1.2.1
                                    public /* synthetic */ Object c;
                                    public int d;

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj2) {
                                        this.c = obj2;
                                        this.d |= Integer.MIN_VALUE;
                                        return AnonymousClass2.this.emit(null, this);
                                    }
                                };
                                Object obj2 = r02.c;
                                CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                                i = r02.d;
                                if (i != 0) {
                                }
                                return i.a;
                            }
                        }, cVar);
                        if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                            return collect;
                        }
                        return i.a;
                    }
                }, new ChannelService$onCreate$1$2(this, null)), q.a(this));
            }
            ChannelBroadcastReceiver channelBroadcastReceiver = this.Z1;
            if (channelBroadcastReceiver != null) {
                registerReceiver(channelBroadcastReceiver, new IntentFilter("CHANNEL_ACTION"));
            } else {
                m0.n.b.i.m("broadcastReceiver");
                throw null;
            }
        } else {
            m0.n.b.i.m("userComponentHandler");
            throw null;
        }
    }

    @Override // h0.q.t, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ChannelBroadcastReceiver channelBroadcastReceiver = this.Z1;
        if (channelBroadcastReceiver != null) {
            unregisterReceiver(channelBroadcastReceiver);
        } else {
            m0.n.b.i.m("broadcastReceiver");
            throw null;
        }
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        Intent intent2 = new Intent(this, ChannelBroadcastReceiver.class);
        intent2.setAction("CHANNEL_ACTION");
        PendingIntent.getBroadcast(this, 0, intent2, 0).send(LeaveReason.TASK_REMOVED.ordinal());
    }
}
