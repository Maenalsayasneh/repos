package i0.j.e.w0;

import com.instabug.library.networkv2.request.Header;
import com.pubnub.api.vendor.FileEncryptionUtil;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
/* compiled from: Multipart.java */
/* loaded from: classes2.dex */
public class a {
    public final String a;
    public OutputStream b;
    public PrintWriter c;

    public a(HttpURLConnection httpURLConnection) throws IOException {
        StringBuilder P0 = i0.d.a.a.a.P0("===");
        P0.append(System.currentTimeMillis());
        P0.append("===");
        String sb = P0.toString();
        this.a = sb;
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setChunkedStreamingMode(1048576);
        httpURLConnection.setRequestProperty(Header.CONTENT_TYPE, "multipart/form-data; boundary=" + sb);
        this.b = httpURLConnection.getOutputStream();
        PrintWriter printWriter = new PrintWriter((Writer) new OutputStreamWriter(this.b, FileEncryptionUtil.ENCODING_UTF_8), true);
        this.c = printWriter;
        printWriter.close();
    }
}
