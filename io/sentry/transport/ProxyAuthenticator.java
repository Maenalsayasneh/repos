package io.sentry.transport;

import io.sentry.util.Objects;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
/* loaded from: classes4.dex */
public final class ProxyAuthenticator extends Authenticator {
    private final String password;
    private final String user;

    public ProxyAuthenticator(String str, String str2) {
        this.user = (String) Objects.requireNonNull(str, "user is required");
        this.password = (String) Objects.requireNonNull(str2, "password is required");
    }

    public String getPassword() {
        return this.password;
    }

    @Override // java.net.Authenticator
    public PasswordAuthentication getPasswordAuthentication() {
        if (getRequestorType() == Authenticator.RequestorType.PROXY) {
            return new PasswordAuthentication(this.user, this.password.toCharArray());
        }
        return null;
    }

    public String getUser() {
        return this.user;
    }
}
