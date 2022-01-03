package com.instabug.survey.models;

import com.instabug.library.internal.storage.cache.Cacheable;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.ListUtils;
import com.instabug.library.util.TimeUtils;
import com.instabug.survey.f.c.a;
import com.instabug.survey.f.c.b;
import com.instabug.survey.f.c.c;
import com.instabug.survey.f.c.f;
import com.instabug.survey.f.c.g;
import com.instabug.survey.f.c.i;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import i0.j.f.m.e.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class Survey implements Cacheable, Serializable, a {
    private static final String HAS_RESPOND = "has_respond";
    private static final String KEY_ANSWERED = "answered";
    private static final String KEY_CONDITIONS_OPERATOR = "operator";
    private static final String KEY_CUSTOM_ATTRIBUTES = "custom_attributes";
    private static final String KEY_DISMISSED_AT = "dismissed_at";
    private static final String KEY_ID = "id";
    private static final String KEY_IS_CANCELLED = "is_cancelled";
    private static final String KEY_IS_GOOGLE_PLAY_APP_RATING = "app_rating";
    private static final String KEY_PAUSED = "paused";
    private static final String KEY_PUBLISHED = "published";
    private static final String KEY_QUESTIONS = "questions";
    private static final String KEY_SESSION_COUNTER = "session_counter";
    private static final String KEY_SHOULD_SHOW_AGAIN = "should_show_again";
    private static final String KEY_SHOW_AT = "show_at";
    private static final String KEY_SURVEY_EVENTS = "events";
    private static final String KEY_SURVEY_STATE = "survey_state";
    private static final String KEY_TARGET = "target";
    private static final String KEY_TARGET_AUDIENCE = "primitive_types";
    private static final String KEY_THANKS_LIST = "thanks_list";
    private static final String KEY_TITLE = "title";
    private static final String KEY_TOKEN = "token";
    private static final String KEY_TYPE = "type";
    private static final String KEY_USER_EVENTS = "user_events";
    private static final String KEY_WELCOME_SCREEN = "welcome_screen";
    private long id;
    private ArrayList<b> questions;
    private ArrayList<c> thankYouItems;
    private String title;
    private String token;
    private int type;
    private boolean paused = false;
    private boolean isGooglePlayAppRating = false;
    private b localization = new b();
    private i userInteraction = new i(0);

    public static List<Survey> fromJson(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray(KEY_PUBLISHED);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            Survey survey = new Survey();
            survey.fromJson(jSONObject2.toString());
            arrayList.add(survey);
        }
        return arrayList;
    }

    private String getCustomThankYouMessage() {
        c cVar;
        ArrayList<c> thankYouItems = getThankYouItems();
        if (thankYouItems.size() <= 0 || (cVar = (c) ListUtils.safeGet(thankYouItems, 0)) == null) {
            return null;
        }
        return cVar.q;
    }

    private String getCustomThankYouTitle() {
        c cVar;
        ArrayList<c> thankYouItems = getThankYouItems();
        if (thankYouItems.size() <= 0 || (cVar = (c) ListUtils.safeGet(thankYouItems, 0)) == null) {
            return null;
        }
        return cVar.d;
    }

    private int getNPSAnswerValue() {
        String str;
        try {
            b bVar = (b) ListUtils.safeGet(this.questions, 0);
            if (bVar == null || (str = bVar.y) == null) {
                return 0;
            }
            return Integer.parseInt(str);
        } catch (Exception e) {
            StringBuilder P0 = i0.d.a.a.a.P0("NPS score parsing failed du to: ");
            P0.append(e.getMessage());
            InstabugSDKLogger.e(this, P0.toString());
            return 0;
        }
    }

    private String getNPSThankYouMessage() {
        ArrayList<c> thankYouItems = getThankYouItems();
        if (thankYouItems.size() <= 0) {
            return null;
        }
        c cVar = (c) ListUtils.safeGet(thankYouItems, 0);
        c cVar2 = (c) ListUtils.safeGet(thankYouItems, 1);
        c cVar3 = (c) ListUtils.safeGet(thankYouItems, 2);
        if (isPromoter() && cVar != null) {
            return cVar.q;
        }
        if (isPassive() && cVar2 != null) {
            return cVar2.q;
        }
        if (!isDetractor() || cVar3 == null) {
            return null;
        }
        return cVar3.q;
    }

    private String getNPSThankYouTitle() {
        ArrayList<c> thankYouItems = getThankYouItems();
        if (thankYouItems.size() <= 0) {
            return null;
        }
        c cVar = (c) ListUtils.safeGet(thankYouItems, 0);
        c cVar2 = (c) ListUtils.safeGet(thankYouItems, 1);
        c cVar3 = (c) ListUtils.safeGet(thankYouItems, 2);
        if (isPromoter() && cVar != null) {
            return cVar.d;
        }
        if (isPassive() && cVar2 != null) {
            return cVar2.d;
        }
        if (!isDetractor() || cVar3 == null) {
            return null;
        }
        return cVar3.d;
    }

    public static List<Survey> getPausedSurveysFromJson(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray("paused");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            Survey survey = new Survey();
            survey.setId(jSONArray.getLong(i));
            survey.setPaused(true);
            arrayList.add(survey);
        }
        return arrayList;
    }

    private boolean hasNPSSubmitted() {
        ArrayList<com.instabug.survey.f.c.a> arrayList = this.userInteraction.q.x;
        if (arrayList == null) {
            return false;
        }
        Iterator<com.instabug.survey.f.c.a> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().c == a.EnumC0030a.SUBMIT) {
                return true;
            }
        }
        return false;
    }

    private boolean isDetractor() {
        return getNPSAnswerValue() <= 6;
    }

    private boolean isPassive() {
        return getNPSAnswerValue() > 6 && getNPSAnswerValue() <= 8;
    }

    private boolean isPromoter() {
        return getNPSAnswerValue() > 8;
    }

    private void setSessionCounter(int i) {
        this.userInteraction.e2 = i;
    }

    public void addRateEvent() {
        this.userInteraction.q.x.add(new com.instabug.survey.f.c.a(a.EnumC0030a.RATE, TimeUtils.currentTimeSeconds(), getAttemptCount()));
    }

    public void addShowEvent() {
        this.userInteraction.Z1 = TimeUtils.currentTimeSeconds();
        i iVar = this.userInteraction;
        iVar.b2++;
        a.EnumC0030a aVar = a.EnumC0030a.SHOW;
        long j = iVar.Z1;
        int i = iVar.c2 + 1;
        iVar.c2 = i;
        iVar.q.x.add(new com.instabug.survey.f.c.a(aVar, j, i));
    }

    public void clearAnswers() {
        Iterator<b> it = this.questions.iterator();
        while (it.hasNext()) {
            it.next().b(null);
        }
    }

    @Override // java.lang.Object
    @SuppressFBWarnings({"NP_METHOD_PARAMETER_TIGHTENS_ANNOTATION"})
    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Survey) && ((Survey) obj).getId() == getId()) {
            return true;
        }
        return false;
    }

    public int getAttemptCount() {
        return this.userInteraction.b2;
    }

    public String getConditionsOperator() {
        return this.userInteraction.q.Z1;
    }

    public ArrayList<c> getCustomAttributes() {
        return this.userInteraction.q.d;
    }

    public long getDismissedAt() {
        return this.userInteraction.Y1;
    }

    public int getEventIndex() {
        return this.userInteraction.c2;
    }

    public long getId() {
        return this.id;
    }

    public b getLocalization() {
        return this.localization;
    }

    public ArrayList<b> getQuestions() {
        return this.questions;
    }

    public String getRatingCTATitle() {
        if (!isAppStoreRatingEnabled()) {
            return null;
        }
        ArrayList<c> thankYouItems = getThankYouItems();
        if (thankYouItems.size() <= 0) {
            return null;
        }
        c cVar = (c) ListUtils.safeGet(thankYouItems, 0);
        c cVar2 = (c) ListUtils.safeGet(thankYouItems, 1);
        if (isPromoter() && cVar != null) {
            return cVar.x;
        }
        if (!isPassive() || cVar2 == null) {
            return null;
        }
        return cVar2.x;
    }

    public long getRespondedAt() {
        if (isLastEventDismiss()) {
            return 0;
        }
        ArrayList<com.instabug.survey.f.c.a> arrayList = this.userInteraction.q.x;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<com.instabug.survey.f.c.a> it = this.userInteraction.q.x.iterator();
            while (it.hasNext()) {
                com.instabug.survey.f.c.a next = it.next();
                if (next.c == a.EnumC0030a.SUBMIT) {
                    return next.d;
                }
            }
        }
        if (getQuestions() != null && getQuestions().size() > 0) {
            for (int size = getQuestions().size() - 1; size >= 0; size--) {
                if (getQuestions().get(size).Y1 > 0) {
                    return getQuestions().get(size).Y1;
                }
            }
        }
        return 0;
    }

    public b getSecondaryNegativeQuestion() {
        if (!isStoreRatingSurvey()) {
            return null;
        }
        if (isGooglePlayAppRating()) {
            return getQuestions().get(1);
        }
        return getQuestions().get(2);
    }

    public int getSessionCounter() {
        return this.userInteraction.e2;
    }

    public long getShownAt() {
        return this.userInteraction.Z1;
    }

    public ArrayList<com.instabug.survey.f.c.a> getSurveyEvents() {
        return this.userInteraction.q.x;
    }

    @Override // i0.j.f.m.e.a
    public long getSurveyId() {
        return this.id;
    }

    public f getSurveyState() {
        return this.userInteraction.g2;
    }

    public g getTarget() {
        return this.userInteraction.q;
    }

    public ArrayList<c> getTargetAudiences() {
        return this.userInteraction.q.c();
    }

    public ArrayList<c> getThankYouItems() {
        return this.thankYouItems;
    }

    public String getThankYouMessage() {
        return isNPSSurvey() ? getNPSThankYouMessage() : getCustomThankYouMessage();
    }

    public String getThankYouTitle() {
        return isNPSSurvey() ? getNPSThankYouTitle() : getCustomThankYouTitle();
    }

    public String getTitle() {
        return this.title;
    }

    public String getToken() {
        return this.token;
    }

    public int getType() {
        return this.type;
    }

    public String getTypeAsString() {
        int i = this.type;
        if (i == 0) {
            return "Custom";
        }
        if (i != 1) {
            return i != 2 ? "" : "StoreRating";
        }
        return "NPS";
    }

    public ArrayList<c> getUserEvents() {
        return this.userInteraction.q.q;
    }

    @Override // i0.j.f.m.e.a
    public i getUserInteraction() {
        return this.userInteraction;
    }

    public boolean hasPositiveNpsAnswer() {
        return isNPSSurvey() && (isPromoter() || isPassive());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return String.valueOf(getId()).hashCode();
    }

    public void incrementSessionCount() {
        i iVar = this.userInteraction;
        int i = iVar.e2 + 1;
        iVar.e2 = i;
        iVar.e2 = i;
    }

    public boolean isAnswered() {
        return this.userInteraction.y;
    }

    public boolean isAppStoreRatingEnabled() {
        ArrayList<c> thankYouItems = getThankYouItems();
        if (thankYouItems.size() > 0) {
            c cVar = (c) ListUtils.safeGet(thankYouItems, 0);
            c cVar2 = (c) ListUtils.safeGet(thankYouItems, 1);
            if (isPromoter() && cVar != null) {
                return cVar.y;
            }
            if (isPassive() && cVar2 != null) {
                return cVar2.y;
            }
        }
        return false;
    }

    public boolean isCancelled() {
        return this.userInteraction.a2;
    }

    public boolean isGooglePlayAppRating() {
        return this.isGooglePlayAppRating;
    }

    public boolean isLastEventDismiss() {
        ArrayList<com.instabug.survey.f.c.a> arrayList = this.userInteraction.q.x;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList<com.instabug.survey.f.c.a> arrayList2 = this.userInteraction.q.x;
            if (arrayList2.get(arrayList2.size() - 1).c == a.EnumC0030a.DISMISS) {
                return true;
            }
        }
        return false;
    }

    public boolean isLastEventSubmit() {
        ArrayList<com.instabug.survey.f.c.a> arrayList = this.userInteraction.q.x;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList<com.instabug.survey.f.c.a> arrayList2 = this.userInteraction.q.x;
            if (arrayList2.get(arrayList2.size() - 1).c == a.EnumC0030a.SUBMIT) {
                return true;
            }
        }
        return false;
    }

    public boolean isNPSSurvey() {
        return getType() == 1;
    }

    public boolean isOptInSurvey() {
        return getToken() != null && !String.valueOf(getToken()).equals("null");
    }

    public boolean isPaused() {
        return this.paused;
    }

    public boolean isStoreRatingSurvey() {
        return getType() == 2;
    }

    public void resetSessionsCounter() {
        this.userInteraction.e2 = 0;
    }

    public void resetUserAnswers() {
        Iterator<b> it = this.questions.iterator();
        while (it.hasNext()) {
            b next = it.next();
            next.y = null;
            next.Y1 = 0;
        }
    }

    public void resetUserInteractions() {
        g gVar = this.userInteraction.q;
        gVar.x = new ArrayList<>();
        i iVar = new i(0);
        this.userInteraction = iVar;
        iVar.q = gVar;
    }

    public void setAnswered(boolean z) {
        this.userInteraction.y = z;
    }

    public void setAttemptCount(int i) {
        this.userInteraction.b2 = i;
    }

    public void setCancelled(boolean z) {
        this.userInteraction.a2 = z;
    }

    public void setConditionsOperator(String str) {
        this.userInteraction.q.Z1 = str;
    }

    public void setCustomAttributes(ArrayList<c> arrayList) {
        this.userInteraction.q.d = arrayList;
    }

    public void setDismissed() {
        setSurveyState(f.READY_TO_SEND);
        if (!isNPSSurvey() || !hasPositiveNpsAnswer() || !hasNPSSubmitted()) {
            setShouldShowAgain(isOptInSurvey() || this.userInteraction.Y1 == 0);
            this.userInteraction.Y1 = TimeUtils.currentTimeSeconds();
            setCancelled(true);
            if (this.userInteraction.q.x.size() > 0) {
                ArrayList<com.instabug.survey.f.c.a> arrayList = this.userInteraction.q.x;
                if (arrayList.get(arrayList.size() - 1).c == a.EnumC0030a.DISMISS) {
                    return;
                }
            }
            this.userInteraction.q.x.add(new com.instabug.survey.f.c.a(a.EnumC0030a.DISMISS, this.userInteraction.Y1, getEventIndex()));
        }
    }

    public void setDismissedAt(long j) {
        this.userInteraction.Y1 = j;
    }

    public void setEventIndex(int i) {
        this.userInteraction.c2 = i;
    }

    public void setGooglePlayAppRating(boolean z) {
        this.isGooglePlayAppRating = z;
    }

    public Survey setId(long j) {
        this.id = j;
        return this;
    }

    public void setLocalization(b bVar) {
        this.localization = bVar;
    }

    public void setPaused(boolean z) {
        this.paused = z;
    }

    public void setQuestions(ArrayList<b> arrayList) {
        this.questions = arrayList;
    }

    public void setSessionCount(int i) {
        this.userInteraction.e2 = i;
    }

    public void setShouldShowAgain(boolean z) {
        this.userInteraction.f2 = z;
    }

    public void setShowAt(long j) {
        this.userInteraction.Z1 = j;
    }

    public void setSubmitted() {
        com.instabug.survey.f.c.a aVar;
        setCancelled(false);
        setAnswered(true);
        if (!isNPSSurvey() || !isAnswered() || !hasNPSSubmitted() || !hasPositiveNpsAnswer()) {
            com.instabug.survey.f.c.a aVar2 = new com.instabug.survey.f.c.a(a.EnumC0030a.SUBMIT, TimeUtils.currentTimeSeconds(), getEventIndex());
            if (isOptInSurvey()) {
                this.userInteraction.b2 = 0;
            }
            aVar = aVar2;
        } else {
            aVar = new com.instabug.survey.f.c.a(a.EnumC0030a.RATE, TimeUtils.currentTimeSeconds(), getEventIndex());
        }
        setSurveyState(f.READY_TO_SEND);
        g gVar = this.userInteraction.q;
        ArrayList<com.instabug.survey.f.c.a> arrayList = gVar.x;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList<com.instabug.survey.f.c.a> arrayList2 = gVar.x;
            a.EnumC0030a aVar3 = arrayList2.get(arrayList2.size() - 1).c;
            a.EnumC0030a aVar4 = a.EnumC0030a.SUBMIT;
            if (aVar3 == aVar4 && aVar.c == aVar4) {
                return;
            }
        }
        ArrayList<com.instabug.survey.f.c.a> arrayList3 = gVar.x;
        if (arrayList3 != null) {
            arrayList3.add(aVar);
        }
    }

    public void setSurveyEvents(ArrayList<com.instabug.survey.f.c.a> arrayList) {
        this.userInteraction.q.x = arrayList;
    }

    public void setSurveyState(f fVar) {
        this.userInteraction.g2 = fVar;
    }

    public void setTarget(g gVar) {
        this.userInteraction.q = gVar;
    }

    public void setTargetAudiences(ArrayList<c> arrayList) {
        this.userInteraction.q.c = arrayList;
    }

    public void setThankYouItems(ArrayList<c> arrayList) {
        this.thankYouItems = arrayList;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUserEvents(ArrayList<c> arrayList) {
        this.userInteraction.q.q = arrayList;
    }

    public void setUserInteraction(i iVar) {
        this.userInteraction = iVar;
    }

    public boolean shouldShow() {
        i iVar = this.userInteraction;
        g gVar = iVar.q;
        int i = gVar.Y1.c;
        return (i == 2) || (iVar.d2 ^ true) || (((i == 1) ^ true) && (((int) TimeUnit.SECONDS.toDays((System.currentTimeMillis() / 1000) - getShownAt())) >= gVar.Y1.a()));
    }

    public boolean shouldShowAgain() {
        return this.userInteraction.f2;
    }

    @Override // com.instabug.library.internal.storage.cache.Cacheable
    public String toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject put = jSONObject.put("id", this.id).put("type", this.type).put(KEY_IS_GOOGLE_PLAY_APP_RATING, this.isGooglePlayAppRating).put("title", this.title);
        String str = this.token;
        if (str == null) {
            str = "";
        }
        put.put(KEY_TOKEN, str).put("questions", b.c(this.questions)).put(KEY_TARGET, g.a(this.userInteraction.q)).put(KEY_SURVEY_EVENTS, com.instabug.survey.f.c.a.b(this.userInteraction.q.x)).put("answered", this.userInteraction.y).put(KEY_SHOW_AT, this.userInteraction.Z1).put("dismissed_at", getDismissedAt()).put(KEY_IS_CANCELLED, this.userInteraction.a2).put(KEY_SURVEY_STATE, getSurveyState().toString()).put(KEY_SHOULD_SHOW_AGAIN, shouldShowAgain()).put("thanks_list", c.b(this.thankYouItems)).put(KEY_SESSION_COUNTER, getSessionCounter());
        this.localization.d(jSONObject);
        return jSONObject.toString();
    }

    @Override // java.lang.Object
    public String toString() {
        try {
            return toJson();
        } catch (JSONException e) {
            InstabugSDKLogger.e("Survey", e.getMessage(), e);
            return super.toString();
        }
    }

    @Override // com.instabug.library.internal.storage.cache.Cacheable
    public void fromJson(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("id")) {
            setId(jSONObject.getLong("id"));
        }
        if (jSONObject.has("type")) {
            setType(jSONObject.getInt("type"));
        }
        if (jSONObject.has("title")) {
            setTitle(jSONObject.getString("title"));
        }
        if (jSONObject.has(KEY_TOKEN) && jSONObject.get(KEY_TOKEN) != JSONObject.NULL) {
            setToken(jSONObject.getString(KEY_TOKEN));
        }
        if (jSONObject.has(KEY_SURVEY_EVENTS)) {
            this.userInteraction.q.x = com.instabug.survey.f.c.a.a(jSONObject.getJSONArray(KEY_SURVEY_EVENTS));
        }
        if (jSONObject.has("questions")) {
            setQuestions(b.a(jSONObject.getJSONArray("questions")));
        }
        if (jSONObject.has(KEY_TARGET)) {
            this.userInteraction.q.fromJson(jSONObject.getJSONObject(KEY_TARGET).toString().replace("\\", ""));
        }
        if (jSONObject.has("answered")) {
            setAnswered(jSONObject.getBoolean("answered"));
        }
        if (jSONObject.has(KEY_IS_CANCELLED)) {
            setCancelled(jSONObject.getBoolean(KEY_IS_CANCELLED));
        }
        if (jSONObject.has(KEY_SURVEY_STATE)) {
            setSurveyState(f.valueOf(jSONObject.getString(KEY_SURVEY_STATE)));
        }
        if (jSONObject.has(KEY_SHOULD_SHOW_AGAIN)) {
            setShouldShowAgain(jSONObject.getBoolean(KEY_SHOULD_SHOW_AGAIN));
        }
        if (jSONObject.has(KEY_SESSION_COUNTER)) {
            setSessionCounter(jSONObject.getInt(KEY_SESSION_COUNTER));
        }
        if (jSONObject.has("dismissed_at")) {
            setDismissedAt((long) jSONObject.getInt("dismissed_at"));
        }
        if (jSONObject.has(KEY_SHOW_AT)) {
            setShowAt((long) jSONObject.getInt(KEY_SHOW_AT));
        }
        if (jSONObject.has("thanks_list")) {
            setThankYouItems(c.a(jSONObject.getJSONArray("thanks_list")));
        }
        this.localization.b(jSONObject);
        setGooglePlayAppRating(jSONObject.optBoolean(KEY_IS_GOOGLE_PLAY_APP_RATING, false));
    }
}
