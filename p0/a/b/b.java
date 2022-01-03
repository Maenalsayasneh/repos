package p0.a.b;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
/* compiled from: HttpURLConnectionResponseAdapter.java */
/* loaded from: classes4.dex */
public class b {
    public HttpURLConnection a;

    public b(HttpURLConnection httpURLConnection) {
        this.a = httpURLConnection;
    }

    public InputStream a() throws IOException {
        try {
            return this.a.getInputStream();
        } catch (IOException unused) {
            return this.a.getErrorStream();
        }
    }
}
