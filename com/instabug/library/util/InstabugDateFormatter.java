package com.instabug.library.util;

import android.content.Context;
import android.text.format.DateFormat;
import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes2.dex */
public class InstabugDateFormatter {
    public static Date convertUnixTimeToDate(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        return instance.getTime();
    }

    public static String convertUnixTimeToFormattedDate(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(convertUnixTimeToDate(j));
    }

    public static String formatConversationLastMessageDate(long j) {
        return new SimpleDateFormat("dd MMM", Locale.US).format(Long.valueOf(j * 1000));
    }

    public static String formatMessageDate(Context context, long j) {
        return new SimpleDateFormat(DateFormat.is24HourFormat(context) ? "dd-MMM HH:mm" : "dd-MMM hh:mm a", Locale.getDefault()).format(Long.valueOf(j * 1000));
    }

    public static String formatUTCDate(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j * 1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(instance.getTime());
    }

    public static String getCurrentDateAsString() {
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(instance.getTime());
    }

    public static long getCurrentUTCTimeStampInMiliSeconds() {
        return System.currentTimeMillis();
    }

    public static long getCurrentUTCTimeStampInSeconds() {
        return System.currentTimeMillis() / 1000;
    }

    public static Date getDate(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        try {
            return simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date getStandardizedDate(Date date) {
        return new Date(date.getTime());
    }

    public static String convertUnixTimeToFormattedDate(long j, String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(convertUnixTimeToDate(j));
    }
}
