package com.instabug.library.util;

import i0.d.a.a.a;
/* loaded from: classes2.dex */
public final class URLUtil {
    public static String resolve(String str) {
        return (str == null || str.startsWith("https://") || str.startsWith("http://")) ? str : a.n0("http://", str);
    }
}
