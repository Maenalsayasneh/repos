package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.support.annotation.NonNull;
import i0.h.a.b.c.m.b;
import i0.h.a.d.a.b.d0;
import i0.h.a.d.a.b.r0;
import i0.h.a.d.a.b.v;
/* loaded from: classes2.dex */
public abstract class AssetPackState {
    public static AssetPackState b(@NonNull String str, int i, int i2, long j, long j2, double d, int i3) {
        return new d0(str, i, i2, j, j2, (int) Math.rint(100.0d * d), i3);
    }

    public static AssetPackState d(Bundle bundle, String str, r0 r0Var, v vVar) {
        double doubleValue;
        int a = vVar.a(bundle.getInt(b.F("status", str)), str);
        int i = bundle.getInt(b.F("error_code", str));
        long j = bundle.getLong(b.F("bytes_downloaded", str));
        long j2 = bundle.getLong(b.F("total_bytes_to_download", str));
        synchronized (r0Var) {
            Double d = r0Var.a.get(str);
            doubleValue = d == null ? 0.0d : d.doubleValue();
        }
        long j3 = bundle.getLong(b.F("pack_version", str));
        long j4 = bundle.getLong(b.F("pack_base_version", str));
        int i2 = 1;
        if (a == 4 && j4 != 0 && j4 != j3) {
            i2 = 2;
        }
        return b(str, a, i, j, j2, doubleValue, i2);
    }

    public abstract int a();

    public abstract long c();

    public abstract int e();

    public abstract String f();

    public abstract int g();

    public abstract long h();

    public abstract int i();
}
