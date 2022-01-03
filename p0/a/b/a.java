package p0.a.b;

import java.net.HttpURLConnection;
/* compiled from: HttpURLConnectionRequestAdapter.java */
/* loaded from: classes4.dex */
public class a {
    public HttpURLConnection a;

    public a(HttpURLConnection httpURLConnection) {
        this.a = httpURLConnection;
    }

    public String a() {
        return this.a.getURL().toExternalForm();
    }
}
