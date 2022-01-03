package i0.e.e.k.b;

import com.clubhouse.android.data.models.local.channel.ChannelInRoomWithAccess;
import com.clubhouse.android.data.models.local.user.SourceLocation;
import com.clubhouse.wave.data.models.local.ReceivedWave;
import com.clubhouse.wave.data.models.local.SentWave;
import java.util.List;
import m0.i;
import m0.l.c;
import n0.a.g2.d;
/* compiled from: WaveRepo.kt */
/* loaded from: classes2.dex */
public interface a {
    Object a(c<? super i> cVar);

    Object b(c<? super i> cVar);

    Object c(c<? super i> cVar);

    Object d(c<? super Boolean> cVar);

    d<ReceivedWave> e();

    d<Integer> f();

    d<Boolean> g(Integer num);

    d<String> h();

    Object i(int i, String str, SourceLocation sourceLocation, c<? super i> cVar);

    Object j(c<? super i> cVar);

    Object k(int i, c<? super ReceivedWave> cVar);

    Object l(int i, c<? super i> cVar);

    Object m(c<? super i> cVar);

    d<List<ReceivedWave>> n();

    d<List<SentWave>> o();

    Object p(int i, String str, SourceLocation sourceLocation, c<? super ChannelInRoomWithAccess> cVar);
}
