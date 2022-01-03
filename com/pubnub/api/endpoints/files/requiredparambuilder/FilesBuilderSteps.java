package com.pubnub.api.endpoints.files.requiredparambuilder;

import com.pubnub.api.endpoints.BuilderSteps;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public interface FilesBuilderSteps extends BuilderSteps {

    /* loaded from: classes2.dex */
    public interface FileIdStep<T> {
        T fileId(String str);
    }

    /* loaded from: classes2.dex */
    public interface FileNameStep<T> {
        T fileName(String str);
    }

    /* loaded from: classes2.dex */
    public interface InputStreamStep<T> {
        T inputStream(InputStream inputStream) throws IOException;
    }
}
