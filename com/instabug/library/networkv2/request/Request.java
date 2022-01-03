package com.instabug.library.networkv2.request;

import android.net.Uri;
import android.os.Build;
import com.instabug.library.model.State;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.DeviceStateProvider;
import com.instabug.library.util.InstabugSDKLogger;
import i0.d.a.a.a;
import i0.j.e.c1.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class Request {
    private static final String APP_TOKEN = "application_token";
    private static final String SHORTEN_APP_TOKEN = "at";
    private static final String SHORTEN_UUID = "uid";
    private static final String TAG = "Request";
    private static final String UUID = "uuid";
    private final List<RequestParameter> bodyParameters;
    private final File downloadedFile;
    private final String endPoint;
    private final FileToUpload fileToUpload;
    private final List<RequestParameter<String>> headers;
    private final String requestMethod;
    private final int requestType;
    private final String requestUrl;
    private final boolean shorten;
    private final List<RequestParameter> urlParameters;
    private final String appTokenValue = SettingsManager.getInstance().getAppToken();
    private final String uuidValue = b.C();
    private final String sdkVersionValue = DeviceStateProvider.getSdkVersion();

    /* loaded from: classes2.dex */
    public static class Builder {
        private ArrayList<RequestParameter> bodyParameters;
        private File downloadedFile;
        private String endpoint;
        private FileToUpload fileToUpload;
        private ArrayList<RequestParameter<String>> headers;
        private String method;
        private String requestUrl;
        private boolean shorten;
        private int type = -1;
        private ArrayList<RequestParameter> urlParameters;

        public Builder() {
            addHeader(new RequestParameter<>("IBG-OS", "android"));
            addHeader(new RequestParameter<>("IBG-OS-VERSION", Build.VERSION.RELEASE));
            addHeader(new RequestParameter<>(Header.SDK_VERSION, DeviceStateProvider.getSdkVersion()));
        }

        private Builder addBodyParameter(RequestParameter requestParameter) {
            if (this.bodyParameters == null) {
                this.bodyParameters = new ArrayList<>();
            }
            this.bodyParameters.add(requestParameter);
            return this;
        }

        private Builder addUrlParameter(RequestParameter requestParameter) {
            if (this.urlParameters == null) {
                this.urlParameters = new ArrayList<>();
            }
            this.urlParameters.add(requestParameter);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Builder setBodyParameter(List<RequestParameter> list) {
            if (this.bodyParameters == null) {
                this.bodyParameters = new ArrayList<>();
            }
            this.bodyParameters = new ArrayList<>(list);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Builder setUrlParameter(List<RequestParameter> list) {
            if (this.urlParameters == null) {
                this.urlParameters = new ArrayList<>();
            }
            this.urlParameters = new ArrayList<>(list);
            return this;
        }

        public Builder addHeader(RequestParameter<String> requestParameter) {
            if (this.headers == null) {
                this.headers = new ArrayList<>();
            }
            this.headers.add(requestParameter);
            return this;
        }

        public Builder addParameter(RequestParameter requestParameter) {
            String str = this.method;
            if (str != null) {
                if (str.equals(RequestMethod.GET) || this.method.equals(RequestMethod.DELETE)) {
                    addUrlParameter(requestParameter);
                } else {
                    addBodyParameter(requestParameter);
                }
            }
            return this;
        }

        public Request build() {
            return new Request(this);
        }

        public Builder endpoint(String str) {
            this.endpoint = str;
            return this;
        }

        public Builder fileToDownload(File file) {
            this.downloadedFile = file;
            return this;
        }

        public Builder fileToUpload(FileToUpload fileToUpload) {
            this.fileToUpload = fileToUpload;
            return this;
        }

        public Builder method(String str) {
            this.method = str;
            return this;
        }

        public Builder setHeaders(List<RequestParameter<String>> list) {
            if (list == null) {
                list = new ArrayList<>();
            }
            this.headers = new ArrayList<>(list);
            return this;
        }

        public Builder setParameter(List<RequestParameter> list) {
            String str = this.method;
            if (str != null) {
                if (str.equals(RequestMethod.GET) || this.method.equals(RequestMethod.DELETE)) {
                    setUrlParameter(list);
                } else {
                    setBodyParameter(list);
                }
            }
            return this;
        }

        public Builder shorten(boolean z) {
            this.shorten = z;
            return this;
        }

        public Builder type(int i) {
            this.type = i;
            return this;
        }

        public Builder url(String str) {
            this.requestUrl = str;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public interface Callbacks<T, K extends Throwable> {
        void onFailed(K k);

        void onSucceeded(T t);
    }

    public Request(Builder builder) {
        String str;
        int i;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        String str2 = builder.endpoint;
        this.endPoint = str2;
        if (builder.requestUrl != null) {
            str = builder.requestUrl;
        } else {
            str = a.n0(com.instabug.library.network.Request.BASE_URL, str2);
        }
        this.requestUrl = str;
        if (builder.type != -1) {
            i = builder.type;
        } else {
            i = 1;
        }
        this.requestType = i;
        this.requestMethod = builder.method;
        this.fileToUpload = builder.fileToUpload;
        this.downloadedFile = builder.downloadedFile;
        boolean z = builder.shorten;
        this.shorten = z;
        if (builder.urlParameters != null) {
            arrayList = builder.urlParameters;
        } else {
            arrayList = new ArrayList();
        }
        this.urlParameters = arrayList;
        if (builder.bodyParameters != null) {
            arrayList2 = builder.bodyParameters;
        } else {
            arrayList2 = new ArrayList();
        }
        this.bodyParameters = arrayList2;
        if (builder.headers != null) {
            arrayList3 = builder.headers;
        } else {
            arrayList3 = new ArrayList();
        }
        this.headers = arrayList3;
        handleBaseParams(z);
    }

    private void addBodyParameter(RequestParameter requestParameter) {
        this.bodyParameters.add(requestParameter);
    }

    private void addParameter(RequestParameter requestParameter) {
        String str = this.requestMethod;
        if (str == null) {
            return;
        }
        if (str.equals(RequestMethod.GET) || this.requestMethod.equals(RequestMethod.DELETE)) {
            addUrlParameter(requestParameter);
        } else {
            addBodyParameter(requestParameter);
        }
    }

    private void addUrlParameter(RequestParameter requestParameter) {
        this.urlParameters.add(requestParameter);
    }

    private String getUrlEncodedParameters() {
        Uri.Builder builder = new Uri.Builder();
        for (RequestParameter requestParameter : this.urlParameters) {
            builder.appendQueryParameter(requestParameter.getKey(), requestParameter.getValue().toString());
        }
        return builder.toString();
    }

    private void handleBaseParams(boolean z) {
        this.headers.add(new RequestParameter<>(Header.SDK_VERSION, this.sdkVersionValue));
        if (!z) {
            String str = this.appTokenValue;
            if (str != null) {
                addParameter(new RequestParameter("application_token", str));
                return;
            }
            return;
        }
        String str2 = this.appTokenValue;
        if (str2 != null) {
            addParameter(new RequestParameter(SHORTEN_APP_TOKEN, str2));
        }
    }

    public Builder builder() {
        return new Builder().endpoint(this.endPoint).url(this.requestUrl).method(this.requestMethod).type(this.requestType).shorten(this.shorten).fileToUpload(this.fileToUpload).fileToDownload(this.downloadedFile).setBodyParameter(this.bodyParameters).setUrlParameter(this.urlParameters).setHeaders(this.headers);
    }

    public File getDownloadedFile() {
        return this.downloadedFile;
    }

    public String getEndpoint() {
        return this.endPoint;
    }

    public FileToUpload getFileToUpload() {
        return this.fileToUpload;
    }

    public List<RequestParameter<String>> getHeaders() {
        return Collections.unmodifiableList(this.headers);
    }

    public String getRequestBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (RequestParameter requestParameter : getRequestBodyParameters()) {
                jSONObject.put(requestParameter.getKey(), requestParameter.getValue());
            }
            return jSONObject.toString();
        } catch (OutOfMemoryError | JSONException e) {
            System.gc();
            InstabugSDKLogger.e(TAG, "OOM Exception trying to remove large logs...", e);
            e.printStackTrace();
            try {
                jSONObject.remove(State.KEY_CONSOLE_LOG);
                jSONObject.remove(State.KEY_INSTABUG_LOG);
                jSONObject.remove(State.KEY_NETWORK_LOGS);
                return jSONObject.toString();
            } catch (OutOfMemoryError e2) {
                InstabugSDKLogger.e(TAG, "Failed to resolve OOM, returning empty request body", e);
                e2.printStackTrace();
                return "{}";
            }
        }
    }

    public List<RequestParameter> getRequestBodyParameters() {
        return Collections.unmodifiableList(this.bodyParameters);
    }

    public String getRequestMethod() {
        String str = this.requestMethod;
        return str == null ? RequestMethod.GET : str;
    }

    public int getRequestType() {
        return this.requestType;
    }

    public String getRequestUrl() {
        if (getUrlEncodedParameters().isEmpty()) {
            return this.requestUrl;
        }
        return this.requestUrl + getUrlEncodedParameters();
    }

    public List<RequestParameter> getRequestUrlParameters() {
        return Collections.unmodifiableList(this.urlParameters);
    }

    public boolean isMultiPartRequest() {
        return this.fileToUpload != null;
    }

    public String toString() {
        String str = this.requestMethod;
        if (str == null || !str.equals(RequestMethod.GET)) {
            StringBuilder P0 = a.P0("Url: ");
            P0.append(getRequestUrl());
            P0.append(" | Method: ");
            P0.append(this.requestMethod);
            P0.append(" | Body: ");
            P0.append(getRequestBody());
            return P0.toString();
        }
        StringBuilder P02 = a.P0("Url: ");
        P02.append(getRequestUrl());
        P02.append(" | Method: ");
        P02.append(this.requestMethod);
        return P02.toString();
    }
}
