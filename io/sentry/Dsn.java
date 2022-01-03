package io.sentry;

import io.sentry.exception.InvalidDsnException;
import java.net.URI;
/* loaded from: classes4.dex */
public final class Dsn {
    private final String path;
    private final String projectId;
    private final String publicKey;
    private final String secretKey;
    private final URI sentryUri;

    public Dsn(String str) throws InvalidDsnException {
        try {
            URI normalize = new URI(str).normalize();
            String userInfo = normalize.getUserInfo();
            if (userInfo == null || userInfo.isEmpty()) {
                throw new IllegalArgumentException("Invalid DSN: No public key provided.");
            }
            String[] split = userInfo.split(":", -1);
            String str2 = split[0];
            this.publicKey = str2;
            if (str2 == null || str2.isEmpty()) {
                throw new IllegalArgumentException("Invalid DSN: No public key provided.");
            }
            this.secretKey = split.length > 1 ? split[1] : null;
            String path = normalize.getPath();
            path = path.endsWith("/") ? path.substring(0, path.length() - 1) : path;
            int lastIndexOf = path.lastIndexOf("/") + 1;
            String substring = path.substring(0, lastIndexOf);
            if (!substring.endsWith("/")) {
                substring = substring + "/";
            }
            this.path = substring;
            String substring2 = path.substring(lastIndexOf);
            this.projectId = substring2;
            if (!substring2.isEmpty()) {
                this.sentryUri = new URI(normalize.getScheme(), null, normalize.getHost(), normalize.getPort(), substring + "api/" + substring2, null, null);
                return;
            }
            throw new IllegalArgumentException("Invalid DSN: A Project Id is required.");
        } catch (Exception e) {
            throw new InvalidDsnException(str, e);
        }
    }

    public String getPath() {
        return this.path;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public String getPublicKey() {
        return this.publicKey;
    }

    public String getSecretKey() {
        return this.secretKey;
    }

    public URI getSentryUri() {
        return this.sentryUri;
    }
}
