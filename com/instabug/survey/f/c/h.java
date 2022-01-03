package com.instabug.survey.f.c;

import com.instabug.library.networkv2.connection.InstabugBaseConnectionManagerImpl;
import java.io.Serializable;
/* compiled from: Trigger.java */
/* loaded from: classes2.dex */
public class h implements Serializable {
    public int d;
    public String q;
    public int c = 0;
    public int x = InstabugBaseConnectionManagerImpl.DEFAULT_READ_TIME_OUT;

    public String a() {
        String str = this.q;
        return str == null ? "" : str;
    }
}
