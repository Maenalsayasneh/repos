package i0.n.c.a.e;

import com.sinch.verification.core.internal.VerificationStateStatus;
import m0.n.b.f;
import m0.n.b.i;
/* compiled from: VerificationState.kt */
/* loaded from: classes.dex */
public abstract class a {

    /* compiled from: VerificationState.kt */
    /* renamed from: i0.n.c.a.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0212a extends a {
        public static final C0212a a = new C0212a();

        public C0212a() {
            super(null);
        }
    }

    /* compiled from: VerificationState.kt */
    /* loaded from: classes.dex */
    public static final class b extends a {
        public final VerificationStateStatus a;
        public final i0.n.c.a.d.a.c b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(VerificationStateStatus verificationStateStatus, i0.n.c.a.d.a.c cVar) {
            super(null);
            i.e(verificationStateStatus, "status");
            this.a = verificationStateStatus;
            this.b = cVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return i.a(this.a, bVar.a) && i.a(this.b, bVar.b);
        }

        public int hashCode() {
            VerificationStateStatus verificationStateStatus = this.a;
            int i = 0;
            int hashCode = (verificationStateStatus != null ? verificationStateStatus.hashCode() : 0) * 31;
            i0.n.c.a.d.a.c cVar = this.b;
            if (cVar != null) {
                i = cVar.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            StringBuilder P0 = i0.d.a.a.a.P0("Initialization(status=");
            P0.append(this.a);
            P0.append(", initiationResponseData=");
            P0.append(this.b);
            P0.append(")");
            return P0.toString();
        }
    }

    /* compiled from: VerificationState.kt */
    /* loaded from: classes.dex */
    public static final class c extends a {
        public static final c a = new c();

        public c() {
            super(null);
        }
    }

    /* compiled from: VerificationState.kt */
    /* loaded from: classes.dex */
    public static final class d extends a {
        public final VerificationStateStatus a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(VerificationStateStatus verificationStateStatus) {
            super(null);
            i.e(verificationStateStatus, "status");
            this.a = verificationStateStatus;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof d) && i.a(this.a, ((d) obj).a);
            }
            return true;
        }

        public int hashCode() {
            VerificationStateStatus verificationStateStatus = this.a;
            if (verificationStateStatus != null) {
                return verificationStateStatus.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder P0 = i0.d.a.a.a.P0("Verification(status=");
            P0.append(this.a);
            P0.append(")");
            return P0.toString();
        }
    }

    public a(f fVar) {
    }
}
