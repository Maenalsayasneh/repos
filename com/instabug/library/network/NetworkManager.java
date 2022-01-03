package com.instabug.library.network;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Base64;
import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.model.NetworkLog;
import com.instabug.library.network.Request;
import com.instabug.library.network.authorization.NetworkOfficer;
import com.instabug.library.networkv2.request.Header;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import com.pubnub.api.vendor.FileEncryptionUtil;
import i0.j.e.v0.d;
import i0.j.e.z;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.plugins.RxJavaPlugins;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.zip.GZIPOutputStream;
import k0.b.l;
import k0.b.m;
import k0.b.n;
import org.json.HTTP;
import org.json.JSONException;
/* loaded from: classes2.dex */
public class NetworkManager implements i0.j.e.v0.a {
    public static final String APP_TOKEN = "application_token";
    private static final int DEFAULT_CONNECTION_TIME_OUT = 15000;
    private static final int DEFAULT_READ_TIME_OUT = 10000;
    public static final String TAG = "NetworkManager";
    public static final String UUID = "uuid";
    private OnDoRequestListener onDoRequestListener;

    /* loaded from: classes2.dex */
    public interface OnDoRequestListener {
        void onComplete();

        void onRequestStarted(Request request);

        void onStart();
    }

    /* loaded from: classes2.dex */
    public enum RequestType {
        NORMAL,
        MULTI_PART,
        FILE_DOWNLOAD
    }

    /* loaded from: classes2.dex */
    public class a implements n<RequestResponse> {
        public final /* synthetic */ Request a;

        public a(Request request) {
            this.a = request;
        }

        @Override // k0.b.n
        public void a(m<RequestResponse> mVar) {
            if (NetworkManager.this.onDoRequestListener != null) {
                NetworkManager.this.onDoRequestListener.onStart();
            }
            try {
                InstabugSDKLogger.d("NetworkManager", "Request Url: " + this.a.getRequestUrl());
                HttpURLConnection httpURLConnection = null;
                int[] iArr = b.a;
                int i = iArr[this.a.getRequestType().ordinal()];
                if (i == 1) {
                    httpURLConnection = NetworkManager.this.connectWithNormalType(this.a);
                } else if (i == 2) {
                    httpURLConnection = NetworkManager.this.connectWithFileDownloadType(this.a);
                } else if (i == 3) {
                    httpURLConnection = NetworkManager.this.connectWithMultiPartType(this.a);
                }
                if (httpURLConnection != null) {
                    if (httpURLConnection.getResponseCode() >= 400) {
                        NetworkManager.this.handleServerConnectionError(httpURLConnection);
                    }
                    InstabugSDKLogger.d("NetworkManager", "Network request completed successfully");
                    int i2 = iArr[this.a.getRequestType().ordinal()];
                    if (i2 == 1) {
                        ((ObservableCreate.CreateEmitter) mVar).b(NetworkManager.this.handleRequestResponse(httpURLConnection));
                    } else if (i2 == 2) {
                        ((ObservableCreate.CreateEmitter) mVar).b(NetworkManager.this.handleFileDownloadRequestResponse(this.a, httpURLConnection));
                    } else if (i2 == 3) {
                        ((ObservableCreate.CreateEmitter) mVar).b(NetworkManager.this.handleMultipartRequestResponse(httpURLConnection));
                    }
                }
                if (NetworkManager.this.onDoRequestListener != null) {
                    NetworkManager.this.onDoRequestListener.onComplete();
                }
                ((ObservableCreate.CreateEmitter) mVar).a();
            } catch (Exception e) {
                try {
                    ((ObservableCreate.CreateEmitter) mVar).c(e);
                } catch (Exception unused) {
                    StringBuilder P0 = i0.d.a.a.a.P0("Request got error: ");
                    P0.append(this.a.getRequestUrl());
                    InstabugSDKLogger.e("NetworkManager", P0.toString(), e);
                }
            } catch (UnsatisfiedLinkError e2) {
                InstabugSDKLogger.e("NetworkManager", e2.getMessage(), e2);
                try {
                    ((ObservableCreate.CreateEmitter) mVar).c(e2);
                } catch (Exception unused2) {
                    StringBuilder P02 = i0.d.a.a.a.P0("Request got error: ");
                    P02.append(this.a.getRequestUrl());
                    InstabugSDKLogger.e("NetworkManager", P02.toString(), e2);
                }
                InstabugCore.setTemporaryDisabled();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            RequestType.values();
            int[] iArr = new int[3];
            a = iArr;
            try {
                iArr[RequestType.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RequestType.FILE_DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RequestType.MULTI_PART.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HttpURLConnection connectWithFileDownloadType(Request request) throws Exception {
        StringBuilder P0 = i0.d.a.a.a.P0("Connect to: ");
        P0.append(request.getRequestUrl());
        P0.append(" with fileDownload type");
        InstabugSDKLogger.d("NetworkManager", P0.toString());
        return connectWithNormalType(request);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"RESOURCE_LEAK"})
    public HttpURLConnection connectWithMultiPartType(Request request) throws Exception {
        FileInputStream fileInputStream;
        Throwable th;
        StringBuilder P0 = i0.d.a.a.a.P0("Connect to: ");
        P0.append(request.getRequestUrl());
        P0.append(" with multiPart type");
        InstabugSDKLogger.d("NetworkManager", P0.toString());
        HttpURLConnection buildConnection = buildConnection(request);
        if (request.getRequestMethod() != null) {
            buildConnection.setRequestMethod(request.getRequestMethod().toString());
        }
        buildConnection.setRequestProperty(Header.CONNECTION, "Keep-Alive");
        buildConnection.setRequestProperty(Header.CACHE_CONTROL, "no-cache");
        buildConnection.setRequestProperty(Header.CONTENT_ENCODING, "");
        d dVar = new d(buildConnection);
        Iterator<Request.RequestParameter> it = request.getRequestBodyParameters().iterator();
        while (it.hasNext()) {
            Request.RequestParameter next = it.next();
            String key = next.getKey();
            String obj = next.getValue().toString();
            dVar.c.append((CharSequence) "--").append((CharSequence) dVar.a).append((CharSequence) HTTP.CRLF);
            dVar.c.append((CharSequence) "Content-Disposition: form-data; name=\"").append((CharSequence) key).append((CharSequence) "\"").append((CharSequence) HTTP.CRLF);
            dVar.c.append((CharSequence) HTTP.CRLF);
            dVar.c.append((CharSequence) obj).append((CharSequence) HTTP.CRLF);
            dVar.c.flush();
        }
        Request.FileToUpload fileToUpload = request.getFileToUpload();
        if (fileToUpload != null) {
            String filePartName = fileToUpload.getFilePartName();
            File file = new File(fileToUpload.getFilePath());
            String fileName = fileToUpload.getFileName();
            String fileType = fileToUpload.getFileType();
            dVar.c.append((CharSequence) "--").append((CharSequence) dVar.a).append((CharSequence) HTTP.CRLF);
            dVar.c.append((CharSequence) "Content-Disposition: file; name=\"").append((CharSequence) filePartName).append((CharSequence) "\"; filename=\"").append((CharSequence) fileName).append((CharSequence) "\"").append((CharSequence) HTTP.CRLF);
            dVar.c.append((CharSequence) "Content-Type: ").append((CharSequence) fileType).append((CharSequence) HTTP.CRLF);
            dVar.c.append((CharSequence) HTTP.CRLF);
            dVar.c.flush();
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
            try {
                byte[] bArr = new byte[1048576];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        dVar.b.write(bArr, 0, read);
                    } else {
                        try {
                            break;
                        } catch (IOException e) {
                            if (e.getMessage() != null) {
                                InstabugSDKLogger.e(dVar, e.getMessage(), e);
                            }
                        }
                    }
                }
                dVar.b.flush();
                fileInputStream.close();
                dVar.c.append((CharSequence) HTTP.CRLF);
                dVar.c.flush();
            } catch (Throwable th3) {
                th = th3;
                try {
                    dVar.b.flush();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                } catch (IOException e2) {
                    if (e2.getMessage() != null) {
                        InstabugSDKLogger.e(dVar, e2.getMessage(), e2);
                    }
                }
                throw th;
            }
        }
        dVar.c.append((CharSequence) HTTP.CRLF).flush();
        dVar.c.append((CharSequence) "--").append((CharSequence) dVar.a).append((CharSequence) "--").append((CharSequence) HTTP.CRLF);
        dVar.c.close();
        return buildConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HttpURLConnection connectWithNormalType(Request request) throws Exception {
        StringBuilder P0 = i0.d.a.a.a.P0("Connect to: ");
        P0.append(request.getRequestUrl());
        P0.append(" with normal type");
        InstabugSDKLogger.d("NetworkManager", P0.toString());
        HttpURLConnection buildConnection = buildConnection(request);
        setURLConnectionDefaultTimeOut(buildConnection);
        if (request.getRequestMethod() != null) {
            buildConnection.setRequestMethod(request.getRequestMethod().toString());
        }
        if (request.getRequestMethod() == Request.RequestMethod.Post || request.getRequestMethod() == Request.RequestMethod.put) {
            buildConnection.setDoOutput(true);
            writeRequestBody(buildConnection.getOutputStream(), request.getRequestBody());
        }
        return buildConnection;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: SSATransform
        jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 1, insn: 0x006f: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:34:0x006f
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVarsInBlock(SSATransform.java:171)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:143)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:60)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    @android.annotation.SuppressLint({"RESOURCE_LEAK"})
    private java.lang.String convertStreamToString(
    /*  JADX ERROR: JadxRuntimeException in pass: SSATransform
        jadx.core.utils.exceptions.JadxRuntimeException: Not initialized variable reg: 1, insn: 0x006f: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:34:0x006f
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVarsInBlock(SSATransform.java:171)
        	at jadx.core.dex.visitors.ssa.SSATransform.renameVariables(SSATransform.java:143)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:60)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r7v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:228)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:198)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:151)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:364)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:270)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */

    private void copyStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        while (true) {
            int read = inputStream.read();
            if (read != -1) {
                outputStream.write(read);
            } else {
                return;
            }
        }
    }

    private Map<String, String> getHeaderFields(HttpURLConnection httpURLConnection) {
        HashMap hashMap = new HashMap();
        for (String str : httpURLConnection.getHeaderFields().keySet()) {
            hashMap.put(str, httpURLConnection.getHeaderField(str));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"RESOURCE_LEAK"})
    public RequestResponse handleFileDownloadRequestResponse(Request request, HttpURLConnection httpURLConnection) throws IOException {
        RequestResponse requestResponse = new RequestResponse();
        int responseCode = httpURLConnection.getResponseCode();
        requestResponse.setResponseCode(responseCode);
        requestResponse.setHeaders(getHeaderFields(httpURLConnection));
        InstabugSDKLogger.d("NetworkManager", "File downloader request response code: " + responseCode);
        File downloadedFile = request.getDownloadedFile();
        if (downloadedFile != null) {
            copyStream(httpURLConnection.getInputStream(), new FileOutputStream(downloadedFile));
            requestResponse.setResponseBody(downloadedFile);
            InstabugSDKLogger.addVerboseLog("NetworkManager", "File downloader request response: " + downloadedFile.getPath());
        } else {
            requestResponse.setResponseBody(null);
            InstabugSDKLogger.addVerboseLog("NetworkManager", "File downloader request response is null");
        }
        httpURLConnection.disconnect();
        return requestResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RequestResponse handleMultipartRequestResponse(HttpURLConnection httpURLConnection) throws IOException {
        return handleRequestResponse(httpURLConnection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RequestResponse handleRequestResponse(HttpURLConnection httpURLConnection) throws IOException {
        RequestResponse requestResponse = new RequestResponse();
        int responseCode = httpURLConnection.getResponseCode();
        requestResponse.setResponseCode(responseCode);
        requestResponse.setHeaders(getHeaderFields(httpURLConnection));
        InstabugSDKLogger.d("NetworkManager", "Request response code: " + responseCode);
        String convertStreamToString = convertStreamToString(httpURLConnection.getInputStream());
        requestResponse.setResponseBody(convertStreamToString);
        InstabugSDKLogger.addVerboseLog("NetworkManager", "Request response: " + convertStreamToString);
        httpURLConnection.disconnect();
        return requestResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleServerConnectionError(HttpURLConnection httpURLConnection) throws IOException {
        InputStream errorStream = httpURLConnection.getErrorStream();
        try {
            if (httpURLConnection.getURL() != null && isInstabugRequest(httpURLConnection.getURL().toString())) {
                InstabugSDKLogger.e("NetworkManager", "Network request got error");
                InstabugSDKLogger.e("NetworkManager", "Error getting Network request response of: " + httpURLConnection.getURL().toString() + " : " + convertStreamToString(errorStream));
            }
        } catch (OutOfMemoryError e) {
            InstabugSDKLogger.e("NetworkManager", e.getMessage(), e);
        }
    }

    private boolean isAuthorizationEnabled() {
        z j = z.j();
        com.instabug.library.a aVar = com.instabug.library.a.BE_DISABLE_SIGNING;
        return j.i(aVar) && z.j().a(aVar) != Feature.State.DISABLED;
    }

    public static boolean isOnline(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            if (activeNetworkInfo.isConnectedOrConnecting()) {
                return true;
            }
            return false;
        } catch (SecurityException e) {
            StringBuilder P0 = i0.d.a.a.a.P0("Could not read network state. To enable please add the following line in your AndroidManifest.xml <uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\"/>\n");
            P0.append(e.getMessage());
            InstabugSDKLogger.w("NetworkManager", P0.toString());
            return false;
        } catch (Exception e2) {
            InstabugSDKLogger.e("NetworkManager", "Something went wrong while checking network state", e2);
            return false;
        }
    }

    private HttpURLConnection setURLConnectionDefaultTimeOut(HttpURLConnection httpURLConnection) {
        return setURLConnectionTimeOut(httpURLConnection, 10000, 15000);
    }

    private void writeRequestBody(OutputStream outputStream, String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes(Charset.forName("UTF8")));
        gZIPOutputStream.close();
        outputStream.write(byteArrayOutputStream.toByteArray());
        byteArrayOutputStream.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c2, code lost:
        if (r9.isEmpty() != false) goto L_0x00cf;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d6, code lost:
        if (r9.isEmpty() != false) goto L_0x00e6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d8, code lost:
        r8.append(r9);
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0110  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public HttpURLConnection buildConnection(Request request) throws Exception, UnsatisfiedLinkError {
        String str;
        String sb;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(request.getRequestUrl()).openConnection();
        httpURLConnection.setRequestProperty(Header.CONTENT_TYPE, NetworkLog.JSON);
        httpURLConnection.setRequestProperty(Header.ACCEPT_CHARSET, FileEncryptionUtil.ENCODING_UTF_8);
        httpURLConnection.setRequestProperty(Header.CONTENT_ENCODING, "gzip");
        if (isAuthorizationEnabled() && isAuthorizationRequired(request)) {
            int i = NetworkOfficer.a;
            String uuid = UUID.randomUUID().toString();
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder sb2 = new StringBuilder("amx ");
            sb2.append(uuid);
            sb2.append(":");
            String clientId = NetworkOfficer.getClientId();
            String str2 = "";
            StringBuilder sb3 = new StringBuilder(str2);
            if (request.getRequestMethod() != null) {
                sb3.append(request.getRequestMethod().toString());
            }
            sb3.append(i0.j.e.v0.b.a.a(request.getRequestUrl()));
            sb3.append(clientId);
            sb3.append(uuid);
            if ((request.getRequestMethod() == Request.RequestMethod.Post || request.getRequestMethod() == Request.RequestMethod.put) && request.getRequestBody() != null) {
                str = null;
                if (!request.isMultiPartRequest()) {
                    try {
                    } catch (IOException e) {
                        InstabugSDKLogger.e(NetworkOfficer.class.getSimpleName(), "get singature base string", e);
                    }
                    if (request.getRequestBody() != null && !request.getRequestBody().isEmpty()) {
                        str2 = i0.j.e.v0.b.a.d(Base64.encodeToString(i0.j.e.v0.b.a.c(request.getRequestBody()), 2));
                        if (str2 != null) {
                        }
                        str2 = null;
                    }
                }
                InstabugSDKLogger.e(NetworkOfficer.class.getSimpleName(), "failed to hash body");
                if (str != null) {
                    sb2.append(i0.j.e.v0.b.a.b(NetworkOfficer.getAppSecret(), str));
                }
                sb2.append(":");
                sb2.append(clientId);
                sb2.append(":");
                sb2.append(currentTimeMillis);
                sb = sb2.toString();
                if (!sb.isEmpty()) {
                    httpURLConnection.setRequestProperty(Header.AUTHORIZATION, sb);
                }
            }
            sb3.append(currentTimeMillis);
            str = sb3.toString();
            if (str != null) {
            }
            sb2.append(":");
            sb2.append(clientId);
            sb2.append(":");
            sb2.append(currentTimeMillis);
            sb = sb2.toString();
            if (!sb.isEmpty()) {
            }
        }
        Iterator<Request.RequestParameter> it = request.getHeaders().iterator();
        while (it.hasNext()) {
            Request.RequestParameter next = it.next();
            if (next.getValue() != null) {
                httpURLConnection.setRequestProperty(next.getKey(), (String) next.getValue());
            }
        }
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    public Request buildRequest(Context context, Request.Endpoint endpoint, Request.RequestMethod requestMethod) throws JSONException {
        return buildRequest(context, endpoint, requestMethod, RequestType.NORMAL);
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public Request buildRequestWithoutUUID(Context context, Request.Endpoint endpoint, Request.RequestMethod requestMethod) throws JSONException {
        Request request = new Request(endpoint, RequestType.NORMAL);
        request.setRequestMethod(requestMethod);
        request.addParameter("application_token", SettingsManager.getInstance().getAppToken());
        return request;
    }

    @Override // i0.j.e.v0.a
    public l<RequestResponse> doRequest(Request request) {
        OnDoRequestListener onDoRequestListener = this.onDoRequestListener;
        if (onDoRequestListener != null) {
            onDoRequestListener.onRequestStarted(request);
        }
        return RxJavaPlugins.onAssembly(new ObservableCreate(new a(request)));
    }

    public boolean isAuthorizationRequired(Request request) {
        return isInstabugRequest(request) && !isFeatureRequest(request);
    }

    public boolean isFeatureRequest(Request request) {
        if (request.getRequestMethod() == null || request.getEndpoint() == null || !request.getRequestMethod().equals(Request.RequestMethod.Get) || !request.getEndpoint().contains(Request.Endpoint.APP_SETTINGS.toString())) {
            return false;
        }
        return true;
    }

    public boolean isInstabugRequest(Request request) {
        return request.getRequestUrl().contains(Request.BASE_URL);
    }

    public void setOnDoRequestListener(OnDoRequestListener onDoRequestListener) {
        this.onDoRequestListener = onDoRequestListener;
    }

    public HttpURLConnection setURLConnectionTimeOut(HttpURLConnection httpURLConnection, int i, int i2) {
        httpURLConnection.setReadTimeout(i);
        httpURLConnection.setConnectTimeout(i2);
        return httpURLConnection;
    }

    private boolean isInstabugRequest(String str) {
        if (str != null) {
            return str.startsWith(Request.BASE_URL);
        }
        return false;
    }

    public Request buildRequest(Context context, Request.Endpoint endpoint, Request.RequestMethod requestMethod, RequestType requestType) throws JSONException {
        Request request = new Request(endpoint, requestType);
        request.setRequestMethod(requestMethod);
        return buildRequest(context, request);
    }

    public Request buildRequest(Context context, String str, Request.RequestMethod requestMethod) throws JSONException {
        return buildRequest(context, str, requestMethod, RequestType.NORMAL);
    }

    public Request buildRequest(Context context, String str, Request.RequestMethod requestMethod, RequestType requestType) throws JSONException {
        Request request = new Request(str, requestType);
        request.setRequestMethod(requestMethod);
        return buildRequest(context, request);
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    private Request buildRequest(Context context, Request request) throws JSONException {
        request.addParameter("application_token", SettingsManager.getInstance().getAppToken());
        request.addParameter("uuid", i0.j.e.c1.b.C());
        return request;
    }
}
