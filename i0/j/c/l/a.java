package i0.j.c.l;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.net.Uri;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.instabug.chat.settings.AttachmentTypesState;
import com.instabug.chat.ui.ChatActivity;
import com.instabug.crash.c.a;
import com.instabug.featuresrequest.R;
import com.instabug.library.Instabug;
import com.instabug.library.core.plugin.Plugin;
import com.instabug.library.core.plugin.PluginPromptOption;
import com.instabug.library.instacapture.screenshot.FieldHelper;
import com.instabug.library.instacapture.screenshot.RootViewInfo;
import com.instabug.library.internal.storage.AttachmentManager;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.internal.storage.cache.AttachmentsDbHelper;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.instabug.library.internal.storage.operation.DeleteUriDiskOperation;
import com.instabug.library.internal.storage.operation.ReadStateFromFileDiskOperation;
import com.instabug.library.invocation.InstabugInvocationEvent;
import com.instabug.library.invocation.InvocationManager;
import com.instabug.library.model.Attachment;
import com.instabug.library.model.State;
import com.instabug.library.network.Request;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.StringUtility;
import com.pubnub.api.builder.PubNubErrorBuilder;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import i0.j.d.f.b;
import i0.j.e.b.c.c;
import i0.j.e.l0.k.a.b.b.d;
import i0.j.e.l0.k.a.b.b.e;
import i0.j.e.l0.k.a.b.b.f;
import i0.j.e.l0.k.a.b.b.g;
import i0.j.e.l0.k.a.b.b.h;
import i0.j.e.l0.k.a.b.b.i;
import i0.j.e.l0.k.a.b.b.j;
import i0.j.e.l0.k.a.b.b.k;
import i0.j.e.l0.k.a.b.b.l;
import i0.j.e.l0.k.a.b.b.m;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: ChatSettings.java */
/* loaded from: classes2.dex */
public class a {
    public static List<c> a;
    public static List<c> b;

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static void A(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        if (adapter != null) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), Integer.MIN_VALUE);
            int i = 0;
            for (int i2 = 0; i2 < adapter.getCount(); i2++) {
                View view = adapter.getView(i2, null, listView);
                view.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, 0));
                i += view.getMeasuredHeight();
            }
            ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
            layoutParams.height = ((adapter.getCount() - 1) * listView.getDividerHeight()) + i;
            listView.setLayoutParams(layoutParams);
            listView.requestLayout();
        }
    }

    public static void B(TextView textView, String str, String str2, String str3, boolean z, Runnable runnable) {
        if (textView.getTag() == null) {
            textView.setTag(textView.getText());
        }
        if (str.length() < 170) {
            textView.setText(str);
            return;
        }
        if (z) {
            String str4 = str.substring(0, 170) + "... " + str2;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str4);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Instabug.getPrimaryColor()), str4.length() - str2.length(), str4.length(), 33);
            spannableStringBuilder.setSpan(new b(textView, str, str2, str3, z, runnable), str4.length() - str2.length(), str4.length(), 33);
            textView.setText(spannableStringBuilder);
        } else {
            String o02 = i0.d.a.a.a.o0(str, " ", str3);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(o02);
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(Instabug.getPrimaryColor()), o02.length() - str3.length(), o02.length(), 33);
            spannableStringBuilder2.setSpan(new i0.j.d.f.c(textView, str, str2, str3, z, runnable), o02.length() - str3.length(), o02.length(), 33);
            textView.setText(spannableStringBuilder2);
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @SuppressFBWarnings({"RV_RETURN_VALUE_IGNORED_BAD_PRACTICE"})
    public static synchronized void C(com.instabug.crash.c.a aVar) {
        synchronized (a.class) {
            for (Attachment attachment : aVar.x) {
                if (!(attachment.getLocalPath() == null || attachment.getName() == null)) {
                    new File(attachment.getLocalPath()).delete();
                    if (attachment.getId() != -1) {
                        AttachmentsDbHelper.delete(attachment.getId());
                    } else {
                        AttachmentsDbHelper.delete(attachment.getName(), aVar.c);
                    }
                }
            }
        }
    }

    public static synchronized void D(String str, ContentValues contentValues) {
        synchronized (a.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            String[] strArr = {str};
            openDatabase.beginTransaction();
            openDatabase.update(InstabugDbContract.CrashEntry.TABLE_NAME, contentValues, "crash_id=? ", strArr);
            openDatabase.setTransactionSuccessful();
            openDatabase.endTransaction();
            openDatabase.close();
        }
    }

    public static String E(String str) {
        return StringUtility.trimString(str, 20);
    }

    public static synchronized void F(String str) {
        synchronized (a.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            String[] strArr = {str};
            openDatabase.beginTransaction();
            openDatabase.delete(InstabugDbContract.CrashEntry.TABLE_NAME, "crash_id=? ", strArr);
            openDatabase.setTransactionSuccessful();
            openDatabase.endTransaction();
            openDatabase.close();
        }
    }

    public static int G(String str, String str2) {
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        int i = 0;
        String[] strArr = {str, str2};
        Cursor cursor = null;
        try {
            cursor = openDatabase.query(InstabugDbContract.UserEventEntry.TABLE_NAME, new String[]{InstabugDbContract.UserEventEntry.COLUMN_EVENT_LOGGING_COUNT}, "event_identifier = ? AND uuid = ? ", strArr, null, null, null);
            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToFirst();
                i = cursor.getInt(cursor.getColumnIndex(InstabugDbContract.UserEventEntry.COLUMN_EVENT_LOGGING_COUNT));
            }
            return i;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            openDatabase.close();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x00f7 A[Catch: all -> 0x0100, TRY_ENTER, TryCatch #1 {, blocks: (B:4:0x0003, B:45:0x00cc, B:47:0x00d1, B:58:0x00ea, B:60:0x00ef, B:65:0x00f7, B:67:0x00fc, B:68:0x00ff), top: B:71:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00fc A[Catch: all -> 0x0100, TryCatch #1 {, blocks: (B:4:0x0003, B:45:0x00cc, B:47:0x00d1, B:58:0x00ea, B:60:0x00ef, B:65:0x00f7, B:67:0x00fc, B:68:0x00ff), top: B:71:0x0003 }] */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static synchronized long H(com.instabug.crash.c.a aVar) {
        Cursor cursor;
        Exception e;
        int i;
        com.instabug.crash.c.a aVar2;
        String string;
        synchronized (a.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            Cursor cursor2 = null;
            try {
                Cursor query = openDatabase.query(InstabugDbContract.CrashEntry.TABLE_NAME, null, null, null, null, null, null, null);
                if (query != null) {
                    try {
                        int count = query.getCount();
                        query.close();
                        Cursor cursor3 = null;
                        i = count;
                        while (i >= 100) {
                            try {
                                cursor3 = openDatabase.query(InstabugDbContract.CrashEntry.TABLE_NAME, null, null, null, null, null, "crash_id ASC", "1");
                                if (cursor3 != null) {
                                    if (cursor3.moveToFirst()) {
                                        a.EnumC0020a aVar3 = a.EnumC0020a.NOT_AVAILABLE;
                                        string = cursor3.getString(cursor3.getColumnIndex(InstabugDbContract.CrashEntry.COLUMN_ID));
                                        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(AttachmentsDbHelper.retrieve(string, openDatabase));
                                        x(Uri.parse(cursor3.getString(cursor3.getColumnIndex("state"))));
                                        synchronized (a.class) {
                                            Iterator it = copyOnWriteArrayList.iterator();
                                            while (it.hasNext()) {
                                                Attachment attachment = (Attachment) it.next();
                                                if (!(attachment.getLocalPath() == null || attachment.getName() == null)) {
                                                    new File(attachment.getLocalPath()).delete();
                                                    if (attachment.getId() != -1) {
                                                        AttachmentsDbHelper.delete(attachment.getId());
                                                    } else {
                                                        AttachmentsDbHelper.delete(attachment.getName(), string);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i--;
                                }
                            } catch (Exception e2) {
                                e = e2;
                                cursor2 = cursor3;
                                cursor = cursor2;
                                cursor2 = query;
                                try {
                                    InstabugSDKLogger.e("CrashReportsDbHelper", "trimAndInsert throwed an error: ", e);
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return -1;
                                } catch (Throwable th) {
                                    th = th;
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                cursor2 = cursor3;
                                cursor = cursor2;
                                cursor2 = query;
                                if (cursor2 != null) {
                                }
                                if (cursor != null) {
                                }
                                throw th;
                            }
                        }
                        aVar2 = aVar;
                        cursor2 = cursor3;
                    } catch (Exception e3) {
                        e = e3;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } else {
                    aVar2 = aVar;
                }
                long c = c(aVar2, openDatabase);
                if (query != null) {
                    query.close();
                }
                if (cursor2 != null) {
                    cursor2.close();
                }
                return c;
            } catch (Exception e4) {
                e = e4;
                cursor = null;
            } catch (Throwable th4) {
                th = th4;
                cursor = null;
            }
        }
        F(string);
        i--;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:11:0x0077
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1148)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1019)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    public static void I(com.google.android.material.textfield.TextInputLayout r5, int r6) {
        /*
            java.lang.Class r0 = r5.getClass()     // Catch: Exception -> 0x0077
            java.lang.String r1 = "mFocusedTextColor"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r1)     // Catch: Exception -> 0x0077
            r1 = 1
            r0.setAccessible(r1)     // Catch: Exception -> 0x0077
            int[][] r2 = new int[r1]     // Catch: Exception -> 0x0077
            r3 = 0
            int[] r4 = new int[r3]     // Catch: Exception -> 0x0077
            r2[r3] = r4     // Catch: Exception -> 0x0077
            int[] r4 = new int[r1]     // Catch: Exception -> 0x0077
            r4[r3] = r6     // Catch: Exception -> 0x0077
            android.content.res.ColorStateList r6 = new android.content.res.ColorStateList     // Catch: Exception -> 0x0077
            r6.<init>(r2, r4)     // Catch: Exception -> 0x0077
            r0.set(r5, r6)     // Catch: Exception -> 0x0077
            java.lang.Class r6 = r5.getClass()     // Catch: Exception -> 0x0077
            java.lang.String r0 = "updateLabelState"
            java.lang.Class[] r2 = new java.lang.Class[r1]     // Catch: Exception -> 0x0077
            java.lang.Class r4 = java.lang.Boolean.TYPE     // Catch: Exception -> 0x0077
            r2[r3] = r4     // Catch: Exception -> 0x0077
            java.lang.reflect.Method r6 = r6.getDeclaredMethod(r0, r2)     // Catch: Exception -> 0x0077
            r6.setAccessible(r1)     // Catch: Exception -> 0x0077
            java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch: Exception -> 0x0077
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch: Exception -> 0x0077
            r0[r3] = r2     // Catch: Exception -> 0x0077
            r6.invoke(r5, r0)     // Catch: Exception -> 0x0077
            android.content.Context r6 = com.instabug.library.Instabug.getApplicationContext()     // Catch: Exception -> 0x0077
            if (r6 != 0) goto L_0x0044
            return
        L_0x0044:
            android.content.Context r6 = com.instabug.library.Instabug.getApplicationContext()     // Catch: Exception -> 0x0077
            int r0 = com.instabug.featuresrequest.R.color.ib_fr_add_comment_error     // Catch: Exception -> 0x0077
            int r6 = h0.i.b.a.getColor(r6, r0)     // Catch: Exception -> 0x0077
            java.lang.Class<com.google.android.material.textfield.TextInputLayout> r0 = com.google.android.material.textfield.TextInputLayout.class
            java.lang.String r2 = "mErrorView"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r2)     // Catch: Exception -> 0x0072
            r0.setAccessible(r1)     // Catch: Exception -> 0x0072
            java.lang.Object r5 = r0.get(r5)     // Catch: Exception -> 0x0072
            android.widget.TextView r5 = (android.widget.TextView) r5     // Catch: Exception -> 0x0072
            java.lang.Class<android.widget.TextView> r0 = android.widget.TextView.class
            java.lang.String r2 = "mCurTextColor"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r2)     // Catch: Exception -> 0x0072
            r0.setAccessible(r1)     // Catch: Exception -> 0x0072
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: Exception -> 0x0072
            r0.set(r5, r6)     // Catch: Exception -> 0x0072
            goto L_0x007b
        L_0x0072:
            r5 = move-exception
            r5.printStackTrace()     // Catch: Exception -> 0x0077
            goto L_0x007b
        L_0x0077:
            r5 = move-exception
            r5.printStackTrace()
        L_0x007b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i0.j.c.l.a.I(com.google.android.material.textfield.TextInputLayout, int):void");
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static ContentValues J(String str, int i, String str2, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("event_identifier", str);
        contentValues.put(InstabugDbContract.UserEventEntry.COLUMN_EVENT_LOGGING_COUNT, Integer.valueOf(i));
        contentValues.put("uuid", str2);
        contentValues.put("is_anonymous", Boolean.valueOf(z));
        return contentValues;
    }

    public static boolean K(String str) {
        return str.contains(Request.BASE_URL) || str.contains("https://api-apm.instabug.com/api/sdk/v3");
    }

    public static void L(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        int i3 = 0;
        switch (i) {
            case 12:
                i0.j.e.l0.k.a.b.b.b[] bVarArr = {new i0.j.e.l0.k.a.b.b.c(), new d(), new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m()};
                if (bVarArr.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length = bVarArr.length;
                while (i3 < length) {
                    bVarArr[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 13:
            case 16:
            default:
                u(sQLiteDatabase, i, i2);
                return;
            case 14:
                i0.j.e.l0.k.a.b.b.b[] bVarArr2 = {new d(), new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m()};
                if (bVarArr2.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length2 = bVarArr2.length;
                while (i3 < length2) {
                    bVarArr2[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 15:
                i0.j.e.l0.k.a.b.b.b[] bVarArr3 = {new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m()};
                if (bVarArr3.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length3 = bVarArr3.length;
                while (i3 < length3) {
                    bVarArr3[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 17:
                i0.j.e.l0.k.a.b.b.b[] bVarArr4 = {new f(), new g(), new h(), new i(), new j(), new k(), new l(), new m()};
                if (bVarArr4.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length4 = bVarArr4.length;
                while (i3 < length4) {
                    bVarArr4[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 18:
                i0.j.e.l0.k.a.b.b.b[] bVarArr5 = {new g(), new h(), new i(), new j(), new k(), new l(), new m()};
                if (bVarArr5.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length5 = bVarArr5.length;
                while (i3 < length5) {
                    bVarArr5[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 19:
                i0.j.e.l0.k.a.b.b.b[] bVarArr6 = {new h(), new i(), new j(), new k(), new l(), new m()};
                if (bVarArr6.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length6 = bVarArr6.length;
                while (i3 < length6) {
                    bVarArr6[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 20:
                i0.j.e.l0.k.a.b.b.b[] bVarArr7 = {new i(), new j(), new k(), new l(), new m()};
                if (bVarArr7.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length7 = bVarArr7.length;
                while (i3 < length7) {
                    bVarArr7[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 21:
                i0.j.e.l0.k.a.b.b.b[] bVarArr8 = {new j(), new k(), new l(), new m()};
                if (bVarArr8.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length8 = bVarArr8.length;
                while (i3 < length8) {
                    bVarArr8[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 22:
                i0.j.e.l0.k.a.b.b.b[] bVarArr9 = {new k(), new l(), new m()};
                if (bVarArr9.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length9 = bVarArr9.length;
                while (i3 < length9) {
                    bVarArr9[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 23:
                i0.j.e.l0.k.a.b.b.b[] bVarArr10 = {new l(), new m()};
                if (bVarArr10.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length10 = bVarArr10.length;
                while (i3 < length10) {
                    bVarArr10[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 24:
                new m().a(sQLiteDatabase);
                return;
        }
    }

    public static void M(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i == 12) {
            i0.j.e.l0.k.a.b.b.b[] bVarArr = {new i0.j.e.l0.k.a.b.b.c(), new d()};
            if (bVarArr.length == 0) {
                i0.d.a.a.a.g(sQLiteDatabase);
                return;
            }
            for (i0.j.e.l0.k.a.b.b.b bVar : bVarArr) {
                bVar.a(sQLiteDatabase);
            }
        } else if (i != 14) {
            u(sQLiteDatabase, i, i2);
        } else {
            sQLiteDatabase.execSQL("ALTER TABLE user_attributes_table ADD COLUMN type INTEGER DEFAULT 0");
        }
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public static long N() {
        return c.a().b.getLong("ibc_ttl", 60);
    }

    public static void O(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        int i3 = 0;
        if (i == 12) {
            i0.j.e.l0.k.a.b.b.b[] bVarArr = {new i0.j.e.l0.k.a.b.b.c(), new d(), new e()};
            if (bVarArr.length == 0) {
                i0.d.a.a.a.g(sQLiteDatabase);
                return;
            }
            int length = bVarArr.length;
            while (i3 < length) {
                bVarArr[i3].a(sQLiteDatabase);
                i3++;
            }
        } else if (i == 14) {
            i0.j.e.l0.k.a.b.b.b[] bVarArr2 = {new d(), new e()};
            if (bVarArr2.length == 0) {
                i0.d.a.a.a.g(sQLiteDatabase);
                return;
            }
            int length2 = bVarArr2.length;
            while (i3 < length2) {
                bVarArr2[i3].a(sQLiteDatabase);
                i3++;
            }
        } else if (i != 15) {
            u(sQLiteDatabase, i, i2);
        }
    }

    public static void P(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        int i3 = 0;
        if (i == 12) {
            i0.j.e.l0.k.a.b.b.b[] bVarArr = {new i0.j.e.l0.k.a.b.b.c(), new d(), new e(), new f()};
            if (bVarArr.length == 0) {
                i0.d.a.a.a.g(sQLiteDatabase);
                return;
            }
            int length = bVarArr.length;
            while (i3 < length) {
                bVarArr[i3].a(sQLiteDatabase);
                i3++;
            }
        } else if (i == 17) {
            new f().a(sQLiteDatabase);
        } else if (i == 14) {
            i0.j.e.l0.k.a.b.b.b[] bVarArr2 = {new d(), new e(), new f()};
            if (bVarArr2.length == 0) {
                i0.d.a.a.a.g(sQLiteDatabase);
                return;
            }
            int length2 = bVarArr2.length;
            while (i3 < length2) {
                bVarArr2[i3].a(sQLiteDatabase);
                i3++;
            }
        } else if (i != 15) {
            u(sQLiteDatabase, i, i2);
        } else {
            i0.j.e.l0.k.a.b.b.b[] bVarArr3 = {new e(), new f()};
            if (bVarArr3.length == 0) {
                i0.d.a.a.a.g(sQLiteDatabase);
                return;
            }
            int length3 = bVarArr3.length;
            while (i3 < length3) {
                bVarArr3[i3].a(sQLiteDatabase);
                i3++;
            }
        }
    }

    public static void Q(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        int i3 = 0;
        switch (i) {
            case 12:
                i0.j.e.l0.k.a.b.b.b[] bVarArr = {new i0.j.e.l0.k.a.b.b.c(), new d(), new e(), new f(), new g()};
                if (bVarArr.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length = bVarArr.length;
                while (i3 < length) {
                    bVarArr[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 13:
            case 16:
            default:
                u(sQLiteDatabase, i, i2);
                return;
            case 14:
                i0.j.e.l0.k.a.b.b.b[] bVarArr2 = {new d(), new e(), new f(), new g()};
                if (bVarArr2.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length2 = bVarArr2.length;
                while (i3 < length2) {
                    bVarArr2[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 15:
                i0.j.e.l0.k.a.b.b.b[] bVarArr3 = {new e(), new f(), new g()};
                if (bVarArr3.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length3 = bVarArr3.length;
                while (i3 < length3) {
                    bVarArr3[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 17:
                i0.j.e.l0.k.a.b.b.b[] bVarArr4 = {new f(), new g()};
                if (bVarArr4.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length4 = bVarArr4.length;
                while (i3 < length4) {
                    bVarArr4[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 18:
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS session_table_temp ( session_id TEXT,started_at INTEGER,duration INTEGER,user_events TEXT,user_attributes TEXT,user_events_keys TEXT,user_attributes_keys TEXT,user_email TEXT,uuid TEXT,user_name TEXT,os TEXT,app_token TEXT,device TEXT,sdk_version TEXT,app_version TEXT,crash_reporting_enabled INTEGER,users_page_enabled INTEGER,sync_status INTEGER )");
                sQLiteDatabase.execSQL("INSERT INTO session_table_temp SELECT session_id,started_at,duration,user_events,user_attributes,user_events_keys,user_attributes_keys,user_email,uuid,user_name,os,app_token,device,sdk_version,app_version,crash_reporting_enabled,users_page_enabled,sync_status FROM " + InstabugDbContract.SessionEntry.TABLE_NAME);
                sQLiteDatabase.execSQL(InstabugDbContract.SessionEntry.DROP_TABLE);
                sQLiteDatabase.execSQL("ALTER TABLE session_table_temp RENAME TO session_table");
                return;
        }
    }

    public static void R(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        int i3 = 0;
        switch (i) {
            case 12:
                i0.j.e.l0.k.a.b.b.b[] bVarArr = {new i0.j.e.l0.k.a.b.b.c(), new d(), new e(), new f(), new g(), new h()};
                if (bVarArr.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length = bVarArr.length;
                while (i3 < length) {
                    bVarArr[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 13:
            case 16:
            default:
                u(sQLiteDatabase, i, i2);
                return;
            case 14:
                i0.j.e.l0.k.a.b.b.b[] bVarArr2 = {new d(), new e(), new f(), new g(), new h()};
                if (bVarArr2.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length2 = bVarArr2.length;
                while (i3 < length2) {
                    bVarArr2[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 15:
                i0.j.e.l0.k.a.b.b.b[] bVarArr3 = {new e(), new f(), new g(), new h()};
                if (bVarArr3.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length3 = bVarArr3.length;
                while (i3 < length3) {
                    bVarArr3[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 17:
                i0.j.e.l0.k.a.b.b.b[] bVarArr4 = {new f(), new g(), new h()};
                if (bVarArr4.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length4 = bVarArr4.length;
                while (i3 < length4) {
                    bVarArr4[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 18:
                i0.j.e.l0.k.a.b.b.b[] bVarArr5 = {new g(), new h()};
                if (bVarArr5.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length5 = bVarArr5.length;
                while (i3 < length5) {
                    bVarArr5[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 19:
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS session_table_temp ( session_id TEXT,started_at INTEGER,duration INTEGER,user_events TEXT,user_attributes TEXT,user_events_keys TEXT,user_attributes_keys TEXT,user_email TEXT,uuid TEXT,user_name TEXT,os TEXT,app_token TEXT,device TEXT,sdk_version TEXT,app_version TEXT,crash_reporting_enabled INTEGER,users_page_enabled INTEGER,sync_status INTEGER )");
                sQLiteDatabase.execSQL("INSERT INTO session_table_temp SELECT session_id,started_at,duration,user_events,user_attributes,user_events_keys,user_attributes_keys,user_email,uuid,user_name,os,app_token,device,sdk_version,app_version,crash_reporting_enabled,users_page_enabled,sync_status FROM " + InstabugDbContract.SessionEntry.TABLE_NAME);
                sQLiteDatabase.execSQL(InstabugDbContract.SessionEntry.DROP_TABLE);
                sQLiteDatabase.execSQL("ALTER TABLE session_table_temp RENAME TO session_table");
                return;
        }
    }

    public static void S(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        int i3 = 0;
        switch (i) {
            case 12:
                i0.j.e.l0.k.a.b.b.b[] bVarArr = {new i0.j.e.l0.k.a.b.b.c(), new d(), new e(), new f(), new g(), new h(), new i()};
                if (bVarArr.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length = bVarArr.length;
                while (i3 < length) {
                    bVarArr[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 13:
            case 16:
            default:
                u(sQLiteDatabase, i, i2);
                return;
            case 14:
                i0.j.e.l0.k.a.b.b.b[] bVarArr2 = {new d(), new e(), new f(), new g(), new h(), new i()};
                if (bVarArr2.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length2 = bVarArr2.length;
                while (i3 < length2) {
                    bVarArr2[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 15:
                i0.j.e.l0.k.a.b.b.b[] bVarArr3 = {new e(), new f(), new g(), new h(), new i()};
                if (bVarArr3.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length3 = bVarArr3.length;
                while (i3 < length3) {
                    bVarArr3[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 17:
                i0.j.e.l0.k.a.b.b.b[] bVarArr4 = {new f(), new g(), new h(), new i()};
                if (bVarArr4.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length4 = bVarArr4.length;
                while (i3 < length4) {
                    bVarArr4[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 18:
                i0.j.e.l0.k.a.b.b.b[] bVarArr5 = {new g(), new h(), new i()};
                if (bVarArr5.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length5 = bVarArr5.length;
                while (i3 < length5) {
                    bVarArr5[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 19:
                i0.j.e.l0.k.a.b.b.b[] bVarArr6 = {new h(), new i()};
                if (bVarArr6.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length6 = bVarArr6.length;
                while (i3 < length6) {
                    bVarArr6[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 20:
                InstabugSDKLogger.d("IBG_MIGRATION", "migration 20_21");
                if (Instabug.getApplicationContext() != null) {
                    if (sQLiteDatabase != null) {
                        InstabugSDKLogger.d("IBG_MIGRATION", "clearBugsAndCrashesTables");
                        sQLiteDatabase.execSQL(InstabugDbContract.CrashEntry.DELETE_ALL);
                        sQLiteDatabase.execSQL(InstabugDbContract.BugEntry.DELETE_ALL);
                    }
                    Context applicationContext = Instabug.getApplicationContext();
                    InstabugSDKLogger.d("IBG_MIGRATION", "clearInstabugAttachmentDirectory started");
                    File attachmentDirectory = AttachmentManager.getAttachmentDirectory(applicationContext);
                    if (attachmentDirectory != null) {
                        AttachmentManager.deleteRecursive(attachmentDirectory);
                        InstabugSDKLogger.d("IBG_MIGRATION", "clearInstabugAttachmentDirectory finished");
                        return;
                    }
                    return;
                }
                return;
        }
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public static boolean T() {
        return c.a().b.getBoolean("ibc_notification_sound", false);
    }

    public static void U(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        int i3 = 0;
        switch (i) {
            case 12:
                i0.j.e.l0.k.a.b.b.b[] bVarArr = {new i0.j.e.l0.k.a.b.b.c(), new d(), new e(), new f(), new g(), new h(), new i(), new j()};
                if (bVarArr.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length = bVarArr.length;
                while (i3 < length) {
                    bVarArr[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 13:
            case 16:
            default:
                u(sQLiteDatabase, i, i2);
                return;
            case 14:
                i0.j.e.l0.k.a.b.b.b[] bVarArr2 = {new d(), new e(), new f(), new g(), new h(), new i(), new j()};
                if (bVarArr2.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length2 = bVarArr2.length;
                while (i3 < length2) {
                    bVarArr2[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 15:
                i0.j.e.l0.k.a.b.b.b[] bVarArr3 = {new e(), new f(), new g(), new h(), new i(), new j()};
                if (bVarArr3.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length3 = bVarArr3.length;
                while (i3 < length3) {
                    bVarArr3[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 17:
                i0.j.e.l0.k.a.b.b.b[] bVarArr4 = {new f(), new g(), new h(), new i(), new j()};
                if (bVarArr4.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length4 = bVarArr4.length;
                while (i3 < length4) {
                    bVarArr4[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 18:
                i0.j.e.l0.k.a.b.b.b[] bVarArr5 = {new g(), new h(), new i(), new j()};
                if (bVarArr5.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length5 = bVarArr5.length;
                while (i3 < length5) {
                    bVarArr5[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 19:
                i0.j.e.l0.k.a.b.b.b[] bVarArr6 = {new h(), new i(), new j()};
                if (bVarArr6.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length6 = bVarArr6.length;
                while (i3 < length6) {
                    bVarArr6[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 20:
                i0.j.e.l0.k.a.b.b.b[] bVarArr7 = {new i(), new j()};
                if (bVarArr7.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length7 = bVarArr7.length;
                while (i3 < length7) {
                    bVarArr7[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 21:
                sQLiteDatabase.execSQL(InstabugDbContract.AnrEntry.CREATE_TABLE);
                return;
        }
    }

    public static void V(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        int i3 = 0;
        switch (i) {
            case 12:
                i0.j.e.l0.k.a.b.b.b[] bVarArr = {new i0.j.e.l0.k.a.b.b.c(), new d(), new e(), new f(), new g(), new h(), new i(), new j(), new k()};
                if (bVarArr.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length = bVarArr.length;
                while (i3 < length) {
                    bVarArr[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 13:
            case 16:
            default:
                u(sQLiteDatabase, i, i2);
                return;
            case 14:
                i0.j.e.l0.k.a.b.b.b[] bVarArr2 = {new d(), new e(), new f(), new g(), new h(), new i(), new j(), new k()};
                if (bVarArr2.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length2 = bVarArr2.length;
                while (i3 < length2) {
                    bVarArr2[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 15:
                i0.j.e.l0.k.a.b.b.b[] bVarArr3 = {new e(), new f(), new g(), new h(), new i(), new j(), new k()};
                if (bVarArr3.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length3 = bVarArr3.length;
                while (i3 < length3) {
                    bVarArr3[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 17:
                i0.j.e.l0.k.a.b.b.b[] bVarArr4 = {new f(), new g(), new h(), new i(), new j(), new k()};
                if (bVarArr4.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length4 = bVarArr4.length;
                while (i3 < length4) {
                    bVarArr4[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 18:
                i0.j.e.l0.k.a.b.b.b[] bVarArr5 = {new g(), new h(), new i(), new j(), new k()};
                if (bVarArr5.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length5 = bVarArr5.length;
                while (i3 < length5) {
                    bVarArr5[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 19:
                i0.j.e.l0.k.a.b.b.b[] bVarArr6 = {new h(), new i(), new j(), new k()};
                if (bVarArr6.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length6 = bVarArr6.length;
                while (i3 < length6) {
                    bVarArr6[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 20:
                i0.j.e.l0.k.a.b.b.b[] bVarArr7 = {new i(), new j(), new k()};
                if (bVarArr7.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length7 = bVarArr7.length;
                while (i3 < length7) {
                    bVarArr7[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 21:
                i0.j.e.l0.k.a.b.b.b[] bVarArr8 = {new j(), new k()};
                if (bVarArr8.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length8 = bVarArr8.length;
                while (i3 < length8) {
                    bVarArr8[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 22:
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS surveys_table_temp ( survey_id INTEGER PRIMARY KEY,survey_type INTEGER,in_app_rating INTEGER,survey_title TEXT,survey_token TEXT,conditions_operator TEXT,answered INTEGER,dismissed_at INTEGER,shown_at INTEGER,isCancelled INTEGER,attemptCount INTEGER,eventIndex INTEGER,shouldShowAgain INTEGER,paused INTEGER,sessionCounter INTEGER,questions TEXT,thanks_list TEXT,targetAudiences TEXT,customAttributes TEXT,userEvents TEXT,surveyState TEXT,surveyTargeting TEXT,surveyTriggerEvent TEXT,isLocalized BOOLEAN,currentLocale TEXT,supportedLocales TEXT)");
                sQLiteDatabase.execSQL("INSERT INTO surveys_table_temp SELECT survey_id,survey_type,in_app_rating,survey_title,survey_token,conditions_operator,answered,dismissed_at,shown_at,isCancelled,attemptCount,eventIndex,shouldShowAgain,paused,sessionCounter,questions,thanks_list,targetAudiences,customAttributes,userEvents,surveyState,surveyTargeting,surveyTriggerEvent,isLocalized,supportedLocales,currentLocale FROM " + InstabugDbContract.SurveyEntry.TABLE_NAME);
                sQLiteDatabase.execSQL(InstabugDbContract.SurveyEntry.DROP_TABLE);
                sQLiteDatabase.execSQL("ALTER TABLE surveys_table_temp RENAME TO surveys_table");
                return;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static void W(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        int i3 = 0;
        switch (i) {
            case 12:
                i0.j.e.l0.k.a.b.b.b[] bVarArr = {new i0.j.e.l0.k.a.b.b.c(), new d(), new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l()};
                if (bVarArr.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length = bVarArr.length;
                while (i3 < length) {
                    bVarArr[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 14:
                i0.j.e.l0.k.a.b.b.b[] bVarArr2 = {new d(), new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l()};
                if (bVarArr2.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length2 = bVarArr2.length;
                while (i3 < length2) {
                    bVarArr2[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 15:
                i0.j.e.l0.k.a.b.b.b[] bVarArr3 = {new e(), new f(), new g(), new h(), new i(), new j(), new k(), new l()};
                if (bVarArr3.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length3 = bVarArr3.length;
                while (i3 < length3) {
                    bVarArr3[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 17:
                i0.j.e.l0.k.a.b.b.b[] bVarArr4 = {new f(), new g(), new h(), new i(), new j(), new k(), new l()};
                if (bVarArr4.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length4 = bVarArr4.length;
                while (i3 < length4) {
                    bVarArr4[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 18:
                i0.j.e.l0.k.a.b.b.b[] bVarArr5 = {new g(), new h(), new i(), new j(), new k(), new l()};
                if (bVarArr5.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length5 = bVarArr5.length;
                while (i3 < length5) {
                    bVarArr5[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 19:
                i0.j.e.l0.k.a.b.b.b[] bVarArr6 = {new h(), new i(), new j(), new k(), new l()};
                if (bVarArr6.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length6 = bVarArr6.length;
                while (i3 < length6) {
                    bVarArr6[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 20:
                i0.j.e.l0.k.a.b.b.b[] bVarArr7 = {new i(), new j(), new k(), new l()};
                if (bVarArr7.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length7 = bVarArr7.length;
                while (i3 < length7) {
                    bVarArr7[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 21:
                i0.j.e.l0.k.a.b.b.b[] bVarArr8 = {new j(), new k(), new l()};
                if (bVarArr8.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length8 = bVarArr8.length;
                while (i3 < length8) {
                    bVarArr8[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 22:
                i0.j.e.l0.k.a.b.b.b[] bVarArr9 = {new k(), new l()};
                if (bVarArr9.length == 0) {
                    i0.d.a.a.a.g(sQLiteDatabase);
                    return;
                }
                int length9 = bVarArr9.length;
                while (i3 < length9) {
                    bVarArr9[i3].a(sQLiteDatabase);
                    i3++;
                }
                return;
            case 23:
                sQLiteDatabase.execSQL(InstabugDbContract.ExperimentsEntry.CREATE_TABLE_QUERY);
                break;
        }
        u(sQLiteDatabase, i, i2);
    }

    public static double a(PointF pointF, PointF pointF2, PointF pointF3) {
        double[] dArr = {(double) pointF.x, (double) pointF.y};
        double[] dArr2 = {(double) pointF2.x, (double) pointF2.y};
        double[] dArr3 = {(double) pointF3.x, (double) pointF3.y};
        double[] dArr4 = {dArr2[0] - dArr[0], dArr2[1] - dArr[1]};
        double[] dArr5 = {dArr3[0] - dArr[0], dArr3[1] - dArr[1]};
        double d = (dArr4[0] * dArr5[1]) - (dArr4[1] * dArr5[0]);
        double d2 = dArr[0] - dArr2[0];
        double d3 = dArr[1] - dArr2[1];
        return Math.abs(d / Math.sqrt((d3 * d3) + (d2 * d2)));
    }

    public static float b(float f, float f2, float f3, float f4) {
        return (float) Math.toDegrees(Math.atan2((double) (f2 - f4), (double) (f - f3)));
    }

    public static synchronized long c(com.instabug.crash.c.a aVar, SQLiteDatabaseWrapper sQLiteDatabaseWrapper) {
        long insert;
        synchronized (a.class) {
            sQLiteDatabaseWrapper.beginTransaction();
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(InstabugDbContract.CrashEntry.COLUMN_CRASH_MESSAGE, aVar.q);
                contentValues.put(InstabugDbContract.CrashEntry.COLUMN_CRASH_STATE, aVar.Y1.name());
                contentValues.put(InstabugDbContract.CrashEntry.COLUMN_HANDLED, Boolean.valueOf(aVar.Z1));
                State state = aVar.y;
                if (!(state == null || state.getUri() == null)) {
                    contentValues.put("state", aVar.y.getUri().toString());
                }
                contentValues.put("temporary_server_token", aVar.d);
                contentValues.put(InstabugDbContract.CrashEntry.COLUMN_ID, aVar.c);
                for (Attachment attachment : aVar.x) {
                    long insert2 = AttachmentsDbHelper.insert(attachment, aVar.c);
                    if (insert2 != -1) {
                        attachment.setId(insert2);
                    }
                }
                insert = sQLiteDatabaseWrapper.insert(InstabugDbContract.CrashEntry.TABLE_NAME, null, contentValues);
                sQLiteDatabaseWrapper.setTransactionSuccessful();
                sQLiteDatabaseWrapper.endTransaction();
                sQLiteDatabaseWrapper.close();
            } catch (Exception e) {
                InstabugSDKLogger.e("CrashReportsDbHelper", "insertcrash throwed an error: ", e);
                sQLiteDatabaseWrapper.endTransaction();
                sQLiteDatabaseWrapper.close();
                return -1;
            }
        }
        return insert;
    }

    /* JADX WARN: Finally extract failed */
    public static long d(String str, int i, String str2, boolean z) {
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        try {
            ContentValues J = J(str, i, str2, z);
            openDatabase.beginTransaction();
            long insertWithOnConflict = openDatabase.insertWithOnConflict(InstabugDbContract.UserEventEntry.TABLE_NAME, null, J);
            openDatabase.setTransactionSuccessful();
            openDatabase.endTransaction();
            openDatabase.close();
            if (insertWithOnConflict < 1) {
                openDatabase = DatabaseManager.getInstance().openDatabase();
                String[] strArr = {str, str2};
                try {
                    openDatabase.beginTransaction();
                    insertWithOnConflict = (long) openDatabase.update(InstabugDbContract.UserEventEntry.TABLE_NAME, J(str, i, str2, z), "event_identifier=? AND uuid=?", strArr);
                    openDatabase.setTransactionSuccessful();
                } catch (Throwable th) {
                    throw th;
                }
            }
            return insertWithOnConflict;
        } finally {
            openDatabase.endTransaction();
            openDatabase.close();
        }
    }

    public static Intent e(Context context) {
        Intent intent = new Intent(context, ChatActivity.class);
        intent.putExtra("chat_process", 160);
        intent.addFlags(65536);
        intent.addFlags(268435456);
        return intent;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static Intent f(Context context, String str) {
        Intent intent = new Intent(context, ChatActivity.class);
        intent.putExtra("chat_process", PubNubErrorBuilder.PNERR_MESSAGE_TIMETOKEN_MISSING);
        intent.putExtra("chat_number", str);
        intent.addFlags(65536);
        intent.addFlags(268435456);
        return intent;
    }

    public static Bitmap g(Activity activity, Bitmap bitmap) {
        if (activity == null) {
            return bitmap;
        }
        List<RootViewInfo> rootViews = FieldHelper.getRootViews(activity, null);
        if (rootViews != null && !rootViews.isEmpty()) {
            try {
                Canvas canvas = new Canvas(bitmap);
                for (RootViewInfo rootViewInfo : rootViews) {
                    if (rootViewInfo.isDialog()) {
                        w(canvas, rootViewInfo);
                    }
                }
                for (RootViewInfo rootViewInfo2 : rootViews) {
                    if (rootViewInfo2.isDialog()) {
                        canvas.drawColor(Color.argb((int) (rootViewInfo2.getLayoutParams().dimAmount * 255.0f), 0, 0, 0));
                        w(canvas, rootViewInfo2);
                    }
                }
                return bitmap;
            } catch (Exception e) {
                InstabugSDKLogger.e("DialogUiRenderer", e.getMessage() != null ? e.getMessage() : "Something went wrong while getting root views", e);
            }
        }
        return bitmap;
    }

    public static Bitmap h(Bitmap bitmap, int i, Context context) {
        Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
        RenderScript create = RenderScript.create(context);
        Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
        Allocation createTyped = Allocation.createTyped(create, createFromBitmap.getType());
        ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
        create2.setRadius((float) i);
        create2.setInput(createFromBitmap);
        create2.forEach(createTyped);
        createTyped.copyTo(copy);
        return copy;
    }

    public static PointF i(float f, float f2, float f3, PointF pointF) {
        double d = (((double) f3) * 3.141592653589793d) / 180.0d;
        double sin = Math.sin(d);
        double cos = Math.cos(d);
        float f4 = pointF.x - f;
        pointF.x = f4;
        float f5 = pointF.y - f2;
        pointF.y = f5;
        double d2 = (double) f4;
        double d3 = (double) f5;
        pointF.x = ((float) ((d2 * cos) - (d3 * sin))) + f;
        pointF.y = ((float) ((d3 * cos) + (d2 * sin))) + f2;
        return pointF;
    }

    public static PointF j(float f, float f2, PointF pointF) {
        PointF pointF2 = new PointF();
        s(f, f2, pointF, pointF2);
        return pointF2;
    }

    public static PointF k(PointF pointF, PointF pointF2) {
        PointF pointF3 = new PointF();
        pointF3.x = (pointF.x + pointF2.x) / 2.0f;
        pointF3.y = (pointF.y + pointF2.y) / 2.0f;
        return pointF3;
    }

    public static AttachmentTypesState l() {
        return b.a().b;
    }

    public static PluginPromptOption m(@PluginPromptOption.PromptOptionIdentifier int i, boolean z) {
        ArrayList arrayList;
        synchronized (i0.j.e.y.b.a.b) {
            arrayList = new ArrayList();
            if (i0.j.e.y.b.a.b("getPluginOptions()")) {
                for (Plugin plugin : i0.j.e.y.b.a.a) {
                    InstabugSDKLogger.v(i0.j.e.y.b.a.class, "plugin: " + plugin.toString());
                    ArrayList<PluginPromptOption> pluginOptions = plugin.getPluginOptions(z);
                    if (pluginOptions != null) {
                        arrayList.addAll(pluginOptions);
                    }
                }
                Collections.sort(arrayList, new PluginPromptOption.a());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            PluginPromptOption pluginPromptOption = (PluginPromptOption) it.next();
            if (pluginPromptOption.getPromptOptionIdentifier() == i) {
                return pluginPromptOption;
            }
        }
        return null;
    }

    public static String n(Context context, long j) {
        Date date = new Date(j);
        DateFormat dateInstance = DateFormat.getDateInstance(2);
        if (!Locale.getDefault().getISO3Language().equals(Locale.ENGLISH.getISO3Language())) {
            return dateInstance.format(date);
        }
        Date date2 = new Date();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long seconds = timeUnit.toSeconds(date2.getTime() - date.getTime());
        long minutes = timeUnit.toMinutes(date2.getTime() - date.getTime());
        long hours = timeUnit.toHours(date2.getTime() - date.getTime());
        long days = timeUnit.toDays(date2.getTime() - date.getTime());
        if (seconds < 60) {
            return context.getString(R.string.feature_request_str_just_now);
        }
        if (minutes < 60) {
            return context.getResources().getQuantityString(R.plurals.instabug_feature_rq_str_minutes_ago, (int) minutes, Long.valueOf(minutes));
        }
        if (hours < 24) {
            return context.getResources().getQuantityString(R.plurals.instabug_feature_rq_str_hours_ago, (int) hours, Long.valueOf(hours));
        }
        if (days < 7) {
            return context.getResources().getQuantityString(R.plurals.instabug_feature_rq_str_days_ago, (int) days, Long.valueOf(days));
        }
        return dateInstance.format(date);
    }

    public static String o(String str) {
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.getDefault());
        DecimalFormatSymbols decimalFormatSymbols = decimalFormat.getDecimalFormatSymbols();
        decimalFormatSymbols.setGroupingSeparator(',');
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        return decimalFormat.format((long) Integer.parseInt(str));
    }

    public static String p(Field field, boolean z) {
        i0.j.e.l0.a.c cVar = (i0.j.e.l0.a.c) field.getAnnotation(i0.j.e.l0.a.c.class);
        if (cVar == null) {
            return field.getName();
        }
        if (z) {
            return cVar.name();
        }
        return cVar.alternate().isEmpty() ? cVar.name() : cVar.alternate();
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00ef, code lost:
        if (r12 == null) goto L_0x0101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00fc, code lost:
        if (r12 == null) goto L_0x0101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00fe, code lost:
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0101, code lost:
        r1.close();
     */
    @SuppressFBWarnings({"REC_CATCH_EXCEPTION"})
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static synchronized List<com.instabug.crash.c.a> q(Context context) {
        ArrayList arrayList;
        synchronized (a.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            arrayList = new ArrayList();
            Cursor cursor = null;
            try {
                cursor = openDatabase.query(InstabugDbContract.CrashEntry.TABLE_NAME, null, null, null, null, null, "crash_id ASC", null);
                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        com.instabug.crash.c.a aVar = new com.instabug.crash.c.a();
                        aVar.c = cursor.getString(cursor.getColumnIndex(InstabugDbContract.CrashEntry.COLUMN_ID));
                        aVar.q = cursor.getString(cursor.getColumnIndex(InstabugDbContract.CrashEntry.COLUMN_CRASH_MESSAGE));
                        aVar.Z1 = cursor.getInt(cursor.getColumnIndex(InstabugDbContract.CrashEntry.COLUMN_HANDLED)) != 0;
                        int i = cursor.getInt(cursor.getColumnIndex(InstabugDbContract.CrashEntry.COLUMN_RETRY_COUNT));
                        aVar.b(AttachmentsDbHelper.retrieve(aVar.c, openDatabase));
                        int columnIndex = cursor.getColumnIndex("state");
                        State state = new State();
                        Uri parse = Uri.parse(cursor.getString(columnIndex));
                        if (parse != null) {
                            state.setUri(parse);
                            i++;
                            try {
                                state.fromJson(DiskUtils.with(context).readOperation(new ReadStateFromFileDiskOperation(parse)).execute());
                                aVar.y = state;
                            } catch (OutOfMemoryError e) {
                                InstabugSDKLogger.e("CrashReportsDbHelper", "retrieving crash state throws OOM", e);
                                if (i >= 3) {
                                    x(parse);
                                    C(aVar);
                                    F(aVar.c);
                                }
                            }
                        }
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(InstabugDbContract.CrashEntry.COLUMN_RETRY_COUNT, Integer.valueOf(i));
                        D(aVar.c, contentValues);
                        aVar.a2 = i;
                        aVar.Y1 = (a.EnumC0020a) Enum.valueOf(a.EnumC0020a.class, cursor.getString(cursor.getColumnIndex(InstabugDbContract.CrashEntry.COLUMN_CRASH_STATE)));
                        aVar.d = cursor.getString(cursor.getColumnIndex("temporary_server_token"));
                        arrayList.add(aVar);
                    } while (cursor.moveToNext());
                }
            } catch (Exception e2) {
                InstabugSDKLogger.e("CrashReportsDbHelper", "retrieve: ", e2);
            }
        }
        return arrayList;
    }

    public static JSONObject r(Throwable th, String str) {
        JSONObject jSONObject = new JSONObject();
        if (th == null) {
            return jSONObject;
        }
        try {
            String name = th.getClass().getName();
            if (str != null) {
                name = name + "-" + str;
            }
            jSONObject.put("name", name);
            StackTraceElement stackTraceElement = null;
            if (th.getStackTrace() != null && th.getStackTrace().length > 0) {
                stackTraceElement = th.getStackTrace()[0];
            }
            if (stackTraceElement == null || stackTraceElement.getFileName() == null) {
                InstabugSDKLogger.w("ExceptionFormatter", "Incomplete crash stacktrace, if you're using Proguard, add the following line to your configuration file to have file name and line number in your crash report:");
                InstabugSDKLogger.w("ExceptionFormatter", "-keepattributes SourceFile,LineNumberTable");
            } else {
                jSONObject.put("location", stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber());
            }
            jSONObject.put("exception", th.toString());
            if (th.getMessage() != null) {
                jSONObject.put(InstabugDbContract.BugEntry.COLUMN_MESSAGE, th.getMessage());
            }
            StringBuilder sb = new StringBuilder(th.toString());
            sb.append("\n");
            StackTraceElement[] stackTrace = th.getStackTrace();
            for (StackTraceElement stackTraceElement2 : stackTrace) {
                sb.append("\t at ");
                sb.append(stackTraceElement2.toString());
                sb.append("\n");
            }
            jSONObject.put("stackTrace", sb.toString());
            if (th.getCause() != null) {
                jSONObject.put("cause", r(th.getCause(), str));
            }
        } catch (JSONException e) {
            InstabugSDKLogger.e("ExceptionFormatter", e.getMessage() != null ? e.getMessage() : "Json exception while creating formatted exception", e);
        }
        return jSONObject;
    }

    public static void s(float f, float f2, PointF pointF, PointF pointF2) {
        double d = (double) f;
        double d2 = (((double) f2) * 3.141592653589793d) / 180.0d;
        pointF2.x = ((float) (Math.cos(d2) * d)) + pointF.x;
        pointF2.y = ((float) (Math.sin(d2) * d)) + pointF.y;
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public static void t(long j) {
        c.a().b.edit().putLong("ibc_last_chat_time", j).apply();
    }

    public static void u(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        InstabugSDKLogger.i("MigrationEngine", i0.d.a.a.a.j0("Did not migrate from v", i, " to v", i2, ". Falling back to destructive migration"));
        new i0.j.e.l0.k.a.b.b.a().a(sQLiteDatabase);
    }

    public static void v(Canvas canvas, PointF pointF, PointF pointF2, Paint paint) {
        canvas.drawLine(pointF.x, pointF.y, pointF2.x, pointF2.y, paint);
    }

    public static void w(Canvas canvas, RootViewInfo rootViewInfo) {
        View view = rootViewInfo.getView();
        if (view.getWidth() != 0 && view.getHeight() != 0) {
            canvas.save();
            canvas.translate((float) rootViewInfo.getRect().left, (float) rootViewInfo.getRect().top);
            rootViewInfo.getView().draw(canvas);
            canvas.restore();
        }
    }

    public static void x(Uri uri) {
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext != null) {
            try {
                DiskUtils.with(applicationContext).deleteOperation(new DeleteUriDiskOperation(uri)).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void y(MotionEvent motionEvent) {
        if (Instabug.isEnabled()) {
            InstabugInvocationEvent[] currentInstabugInvocationEvents = InvocationManager.getInstance().getCurrentInstabugInvocationEvents();
            int length = currentInstabugInvocationEvents.length;
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (currentInstabugInvocationEvents[i] == InstabugInvocationEvent.TWO_FINGER_SWIPE_LEFT) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                InvocationManager.getInstance().handle(motionEvent);
            }
            if (motionEvent != null) {
                InstabugInternalTrackingDelegate.getInstance().trackTouchEvent(motionEvent);
            }
        }
    }

    public static void z(View view, int i) {
        if (view != null) {
            Drawable background = view.getBackground();
            if (background instanceof ShapeDrawable) {
                ((ShapeDrawable) background).getPaint().setColor(i);
            } else if (background instanceof GradientDrawable) {
                ((GradientDrawable) background).setColor(i);
            } else if (background instanceof ColorDrawable) {
                ((ColorDrawable) background).setColor(i);
            }
        }
    }
}
