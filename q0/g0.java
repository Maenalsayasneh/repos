package q0;

import com.stripe.android.model.PaymentMethod;
import i0.d.a.a.a;
import java.net.InetSocketAddress;
import java.net.Proxy;
import m0.n.b.i;
/* compiled from: Route.kt */
/* loaded from: classes4.dex */
public final class g0 {
    public final a a;
    public final Proxy b;
    public final InetSocketAddress c;

    public g0(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        i.e(aVar, PaymentMethod.BillingDetails.PARAM_ADDRESS);
        i.e(proxy, "proxy");
        i.e(inetSocketAddress, "socketAddress");
        this.a = aVar;
        this.b = proxy;
        this.c = inetSocketAddress;
    }

    public final boolean a() {
        return this.a.f != null && this.b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (obj instanceof g0) {
            g0 g0Var = (g0) obj;
            if (i.a(g0Var.a, this.a) && i.a(g0Var.b, this.b) && i.a(g0Var.c, this.c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.b.hashCode();
        return this.c.hashCode() + ((hashCode + ((this.a.hashCode() + 527) * 31)) * 31);
    }

    public String toString() {
        StringBuilder P0 = a.P0("Route{");
        P0.append(this.c);
        P0.append('}');
        return P0.toString();
    }
}
