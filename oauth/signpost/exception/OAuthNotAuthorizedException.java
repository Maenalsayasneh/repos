package oauth.signpost.exception;
/* loaded from: classes4.dex */
public class OAuthNotAuthorizedException extends OAuthException {
    public OAuthNotAuthorizedException() {
        super("Authorization failed (server replied with a 401). This can happen if the consumer key was not correct or the signatures did not match.");
    }

    public OAuthNotAuthorizedException(String str) {
        super("Authorization failed (server replied with a 401). This can happen if the consumer key was not correct or the signatures did not match.");
    }
}
