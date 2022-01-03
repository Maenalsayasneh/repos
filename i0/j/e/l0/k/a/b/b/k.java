package i0.j.e.l0.k.a.b.b;

import android.database.sqlite.SQLiteDatabase;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
/* compiled from: Migration_22_23.java */
/* loaded from: classes2.dex */
public class k implements b {
    @Override // i0.j.e.l0.k.a.b.b.b
    public void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS surveys_table_temp ( survey_id INTEGER PRIMARY KEY,survey_type INTEGER,in_app_rating INTEGER,survey_title TEXT,survey_token TEXT,conditions_operator TEXT,answered INTEGER,dismissed_at INTEGER,shown_at INTEGER,isCancelled INTEGER,attemptCount INTEGER,eventIndex INTEGER,shouldShowAgain INTEGER,paused INTEGER,sessionCounter INTEGER,questions TEXT,thanks_list TEXT,targetAudiences TEXT,customAttributes TEXT,userEvents TEXT,surveyState TEXT,surveyTargeting TEXT,surveyTriggerEvent TEXT,isLocalized BOOLEAN,currentLocale TEXT,supportedLocales TEXT)");
        sQLiteDatabase.execSQL("INSERT INTO surveys_table_temp SELECT survey_id,survey_type,in_app_rating,survey_title,survey_token,conditions_operator,answered,dismissed_at,shown_at,isCancelled,attemptCount,eventIndex,shouldShowAgain,paused,sessionCounter,questions,thanks_list,targetAudiences,customAttributes,userEvents,surveyState,surveyTargeting,surveyTriggerEvent,isLocalized,supportedLocales,currentLocale FROM " + InstabugDbContract.SurveyEntry.TABLE_NAME);
        sQLiteDatabase.execSQL(InstabugDbContract.SurveyEntry.DROP_TABLE);
        sQLiteDatabase.execSQL("ALTER TABLE surveys_table_temp RENAME TO surveys_table");
    }
}
