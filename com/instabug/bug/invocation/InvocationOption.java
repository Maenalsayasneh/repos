package com.instabug.bug.invocation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.SOURCE)
@Deprecated
/* loaded from: classes2.dex */
public @interface InvocationOption {
    public static final int COMMENT_FIELD_REQUIRED = 8;
    public static final int DISABLE_POST_SENDING_DIALOG = 16;
    public static final int EMAIL_FIELD_HIDDEN = 2;
    public static final int EMAIL_FIELD_OPTIONAL = 4;
}
