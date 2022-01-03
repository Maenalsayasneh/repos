package i0.h.c.r.p;

import com.google.auto.value.AutoValue;
import com.google.firebase.installations.local.PersistedInstallation;
import java.util.Objects;
/* compiled from: PersistedInstallationEntry.java */
@AutoValue
/* loaded from: classes2.dex */
public abstract class c {
    public static final /* synthetic */ int a = 0;

    /* compiled from: PersistedInstallationEntry.java */
    @AutoValue.Builder
    /* loaded from: classes2.dex */
    public static abstract class a {
        public abstract c a();

        public abstract a b(PersistedInstallation.RegistrationStatus registrationStatus);
    }

    static {
        Long l = 0L;
        Objects.requireNonNull(PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION, "Null registrationStatus");
        String str = l == null ? " expiresInSecs" : "";
        if (l == null) {
            str = i0.d.a.a.a.n0(str, " tokenCreationEpochInSecs");
        }
        if (str.isEmpty()) {
            l.longValue();
            l.longValue();
            return;
        }
        throw new IllegalStateException(i0.d.a.a.a.n0("Missing required properties:", str));
    }

    public abstract String a();

    public abstract long b();

    public abstract String c();

    public abstract String d();

    public abstract String e();

    public abstract PersistedInstallation.RegistrationStatus f();

    public abstract long g();

    public boolean h() {
        return f() == PersistedInstallation.RegistrationStatus.REGISTER_ERROR;
    }

    public boolean i() {
        PersistedInstallation.RegistrationStatus registrationStatus = ((a) this).c;
        return registrationStatus == PersistedInstallation.RegistrationStatus.NOT_GENERATED || registrationStatus == PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION;
    }

    public boolean j() {
        return f() == PersistedInstallation.RegistrationStatus.REGISTERED;
    }

    public abstract a k();
}
