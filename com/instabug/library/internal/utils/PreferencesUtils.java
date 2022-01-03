package com.instabug.library.internal.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes2.dex */
public class PreferencesUtils {
    private final Context context;
    private final String name;

    public PreferencesUtils(Context context, String str) {
        this.context = context;
        this.name = str;
    }

    public void delete(String str) {
        SharedPreferences.Editor edit = this.context.getSharedPreferences(this.name, 0).edit();
        edit.remove(str);
        edit.apply();
    }

    public void deleteAll() {
        SharedPreferences.Editor edit = this.context.getSharedPreferences(this.name, 0).edit();
        edit.clear();
        edit.apply();
    }

    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public long getLong(String str) {
        return getLong(str, 0);
    }

    public SharedPreferences getSharedPreferences() {
        return this.context.getSharedPreferences(this.name, 0);
    }

    public String getString(String str) {
        return getString(str, null);
    }

    public void saveOrUpdateBoolean(String str, boolean z) {
        SharedPreferences.Editor edit = this.context.getSharedPreferences(this.name, 0).edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public void saveOrUpdateInt(String str, int i) {
        SharedPreferences.Editor edit = this.context.getSharedPreferences(this.name, 0).edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public void saveOrUpdateLong(String str, long j) {
        SharedPreferences.Editor edit = this.context.getSharedPreferences(this.name, 0).edit();
        edit.putLong(str, j);
        edit.apply();
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void saveOrUpdateString(String str, String str2) {
        SharedPreferences.Editor edit = this.context.getSharedPreferences(this.name, 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public boolean getBoolean(String str, boolean z) {
        return this.context.getSharedPreferences(this.name, 0).getBoolean(str, z);
    }

    public int getInt(String str, int i) {
        return this.context.getSharedPreferences(this.name, 0).getInt(str, i);
    }

    public long getLong(String str, long j) {
        return this.context.getSharedPreferences(this.name, 0).getLong(str, j);
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public String getString(String str, String str2) {
        return this.context.getSharedPreferences(this.name, 0).getString(str, str2);
    }
}
