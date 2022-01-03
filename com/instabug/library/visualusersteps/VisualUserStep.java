package com.instabug.library.visualusersteps;

import android.annotation.SuppressLint;
import com.instabug.library.model.StepType;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressFBWarnings({"NM_METHOD_NAMING_CONVENTION"})
/* loaded from: classes2.dex */
public class VisualUserStep implements Serializable {
    private static final String KEY_BUTTON_ICON = "button_icon";
    private static final String KEY_DATE = "date";
    private static final String KEY_EVENT_TYPE = "event_type";
    private static final String KEY_IS_CONTAIN_ICON = "is_contains";
    private static final String KEY_PARENT_SCREEN_ID = "parent_screen_identifier";
    private static final String KEY_SCREENSHOT_ID = "screenshot_identifier";
    private static final String KEY_SCREEN_ID = "screen_identifier";
    private static final String KEY_SCREEN_NAME = "screen_name";
    private static final String KEY_VIEW = "view";
    private static final String KEY_VIEW_ORIENTATION = "orientation";
    private String buttonIcon;
    private long date;
    private boolean isContainIcon;
    private String orientation;
    private String parentScreenId;
    private String screenId;
    private String screenName;
    private String screenshotId;
    private String stepType;
    private String view;

    /* loaded from: classes2.dex */
    public static final class b {
        public long a = System.currentTimeMillis();
        public boolean b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;

        public b(String str, a aVar) {
            this.j = str;
        }

        public VisualUserStep a() {
            return new VisualUserStep(this);
        }
    }

    public static b Builder(String str) {
        return new b(str, null);
    }

    public static ArrayList<VisualUserStep> fromJson(JSONArray jSONArray) throws JSONException {
        ArrayList<VisualUserStep> arrayList = new ArrayList<>();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(fromJsonObject(jSONArray.getJSONObject(i)));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b9, code lost:
        if (r15.equals("landscape") == false) goto L_0x00c4;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c9  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static VisualUserStep fromJsonObject(JSONObject jSONObject) throws JSONException {
        String upperCase = (!jSONObject.has(KEY_EVENT_TYPE) || JSONObject.NULL.toString().equals(jSONObject.getString(KEY_EVENT_TYPE))) ? StepType.UNKNOWN : jSONObject.getString(KEY_EVENT_TYPE).toUpperCase();
        String str = null;
        String string = jSONObject.has("screen_name") ? jSONObject.getString("screen_name") : null;
        String string2 = jSONObject.has(KEY_SCREEN_ID) ? jSONObject.getString(KEY_SCREEN_ID) : null;
        String string3 = jSONObject.has(KEY_SCREENSHOT_ID) ? jSONObject.getString(KEY_SCREENSHOT_ID) : null;
        String string4 = jSONObject.has("date") ? jSONObject.getString("date") : null;
        String string5 = jSONObject.has(KEY_PARENT_SCREEN_ID) ? jSONObject.getString(KEY_PARENT_SCREEN_ID) : null;
        char c = 0;
        boolean z = jSONObject.has(KEY_IS_CONTAIN_ICON) ? jSONObject.getBoolean(KEY_IS_CONTAIN_ICON) : false;
        String string6 = jSONObject.has(KEY_BUTTON_ICON) ? jSONObject.getString(KEY_BUTTON_ICON) : null;
        String string7 = jSONObject.has(KEY_VIEW) ? jSONObject.getString(KEY_VIEW) : null;
        if (jSONObject.has("orientation")) {
            String string8 = jSONObject.getString("orientation");
            int hashCode = string8.hashCode();
            if (hashCode != 729267099) {
                if (hashCode == 1430647483) {
                }
                c = 65535;
                str = c != 0 ? "portrait" : "landscape";
            } else {
                if (string8.equals("portrait")) {
                    c = 2;
                    if (c != 0) {
                    }
                }
                c = 65535;
                if (c != 0) {
                }
            }
        }
        if (string7 == null) {
            string7 = "";
        }
        b Builder = Builder(upperCase);
        Builder.d = string;
        Builder.e = string3;
        if (string4 == null) {
            string4 = "0";
        }
        Builder.a = Long.parseLong(string4);
        Builder.c = string5;
        Builder.g = string7;
        Builder.h = str;
        Builder.f = string2;
        Builder.b = z;
        Builder.i = string6;
        return Builder.a();
    }

    private String getButtonIcon() {
        return this.buttonIcon;
    }

    private boolean isContainIcon() {
        return this.isContainIcon;
    }

    private void setScreenName(String str) {
        this.screenName = str;
    }

    private void setStepType(String str) {
        this.stepType = str;
    }

    public static String toJsonString(ArrayList<VisualUserStep> arrayList) {
        JSONArray jSONArray = new JSONArray();
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<VisualUserStep> it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJson());
            }
        }
        return jSONArray.toString();
    }

    public long getDate() {
        return this.date;
    }

    public String getParentScreenId() {
        return this.parentScreenId;
    }

    public String getScreenId() {
        return this.screenId;
    }

    public String getScreenName() {
        return this.screenName;
    }

    public String getScreenshotId() {
        return this.screenshotId;
    }

    public String getStepType() {
        return this.stepType;
    }

    public String getView() {
        return this.view;
    }

    public String getViewOrientation() {
        return this.orientation;
    }

    public boolean hasScreenshot() {
        return this.screenshotId != null;
    }

    public void setButtonIcon(String str) {
        this.buttonIcon = str;
    }

    public void setContainIcon(boolean z) {
        this.isContainIcon = z;
    }

    public void setDate(long j) {
        this.date = j;
    }

    public void setParentScreenId(String str) {
        this.parentScreenId = str;
    }

    public void setScreenId(String str) {
        this.screenId = str;
    }

    public void setScreenshotId(String str) {
        this.screenshotId = str;
    }

    public void setView(String str) {
        this.view = str;
    }

    public void setViewOrientation(String str) {
        this.orientation = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0049 A[Catch: JSONException -> 0x00f4, TryCatch #0 {JSONException -> 0x00f4, blocks: (B:3:0x0007, B:6:0x000f, B:9:0x001a, B:10:0x001f, B:11:0x0021, B:13:0x0026, B:15:0x002c, B:18:0x0037, B:19:0x003c, B:20:0x003e, B:22:0x0043, B:24:0x0049, B:27:0x0054, B:28:0x0059, B:29:0x005b, B:31:0x0060, B:33:0x0066, B:36:0x0071, B:37:0x0076, B:38:0x0078, B:40:0x007d, B:42:0x0083, B:45:0x0090, B:46:0x0099, B:47:0x009b, B:49:0x00a0, B:51:0x00a9, B:53:0x00af, B:56:0x00ba, B:57:0x00bf, B:58:0x00c1, B:60:0x00c6, B:62:0x00cc, B:65:0x00d7, B:66:0x00dc, B:67:0x00de, B:69:0x00e3, B:71:0x00ec), top: B:75:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0066 A[Catch: JSONException -> 0x00f4, TryCatch #0 {JSONException -> 0x00f4, blocks: (B:3:0x0007, B:6:0x000f, B:9:0x001a, B:10:0x001f, B:11:0x0021, B:13:0x0026, B:15:0x002c, B:18:0x0037, B:19:0x003c, B:20:0x003e, B:22:0x0043, B:24:0x0049, B:27:0x0054, B:28:0x0059, B:29:0x005b, B:31:0x0060, B:33:0x0066, B:36:0x0071, B:37:0x0076, B:38:0x0078, B:40:0x007d, B:42:0x0083, B:45:0x0090, B:46:0x0099, B:47:0x009b, B:49:0x00a0, B:51:0x00a9, B:53:0x00af, B:56:0x00ba, B:57:0x00bf, B:58:0x00c1, B:60:0x00c6, B:62:0x00cc, B:65:0x00d7, B:66:0x00dc, B:67:0x00de, B:69:0x00e3, B:71:0x00ec), top: B:75:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0083 A[Catch: JSONException -> 0x00f4, TryCatch #0 {JSONException -> 0x00f4, blocks: (B:3:0x0007, B:6:0x000f, B:9:0x001a, B:10:0x001f, B:11:0x0021, B:13:0x0026, B:15:0x002c, B:18:0x0037, B:19:0x003c, B:20:0x003e, B:22:0x0043, B:24:0x0049, B:27:0x0054, B:28:0x0059, B:29:0x005b, B:31:0x0060, B:33:0x0066, B:36:0x0071, B:37:0x0076, B:38:0x0078, B:40:0x007d, B:42:0x0083, B:45:0x0090, B:46:0x0099, B:47:0x009b, B:49:0x00a0, B:51:0x00a9, B:53:0x00af, B:56:0x00ba, B:57:0x00bf, B:58:0x00c1, B:60:0x00c6, B:62:0x00cc, B:65:0x00d7, B:66:0x00dc, B:67:0x00de, B:69:0x00e3, B:71:0x00ec), top: B:75:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00af A[Catch: JSONException -> 0x00f4, TryCatch #0 {JSONException -> 0x00f4, blocks: (B:3:0x0007, B:6:0x000f, B:9:0x001a, B:10:0x001f, B:11:0x0021, B:13:0x0026, B:15:0x002c, B:18:0x0037, B:19:0x003c, B:20:0x003e, B:22:0x0043, B:24:0x0049, B:27:0x0054, B:28:0x0059, B:29:0x005b, B:31:0x0060, B:33:0x0066, B:36:0x0071, B:37:0x0076, B:38:0x0078, B:40:0x007d, B:42:0x0083, B:45:0x0090, B:46:0x0099, B:47:0x009b, B:49:0x00a0, B:51:0x00a9, B:53:0x00af, B:56:0x00ba, B:57:0x00bf, B:58:0x00c1, B:60:0x00c6, B:62:0x00cc, B:65:0x00d7, B:66:0x00dc, B:67:0x00de, B:69:0x00e3, B:71:0x00ec), top: B:75:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00cc A[Catch: JSONException -> 0x00f4, TryCatch #0 {JSONException -> 0x00f4, blocks: (B:3:0x0007, B:6:0x000f, B:9:0x001a, B:10:0x001f, B:11:0x0021, B:13:0x0026, B:15:0x002c, B:18:0x0037, B:19:0x003c, B:20:0x003e, B:22:0x0043, B:24:0x0049, B:27:0x0054, B:28:0x0059, B:29:0x005b, B:31:0x0060, B:33:0x0066, B:36:0x0071, B:37:0x0076, B:38:0x0078, B:40:0x007d, B:42:0x0083, B:45:0x0090, B:46:0x0099, B:47:0x009b, B:49:0x00a0, B:51:0x00a9, B:53:0x00af, B:56:0x00ba, B:57:0x00bf, B:58:0x00c1, B:60:0x00c6, B:62:0x00cc, B:65:0x00d7, B:66:0x00dc, B:67:0x00de, B:69:0x00e3, B:71:0x00ec), top: B:75:0x0007 }] */
    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    /* Code decompiled incorrectly, please refer to instructions dump */
    public JSONObject toJson() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        JSONObject jSONObject = new JSONObject();
        try {
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (getParentScreenId() != null && !getParentScreenId().equals("null")) {
            obj = getParentScreenId();
            jSONObject.put(KEY_PARENT_SCREEN_ID, obj);
            if (getScreenName() != null && !getScreenName().equals("null")) {
                obj2 = getScreenName();
                jSONObject.put("screen_name", obj2);
                if (getScreenshotId() != null && !getScreenshotId().equals("null")) {
                    obj3 = getScreenshotId();
                    jSONObject.put(KEY_SCREENSHOT_ID, obj3);
                    if (getScreenId() != null && !getScreenId().equals("null")) {
                        obj4 = getScreenId();
                        jSONObject.put(KEY_SCREEN_ID, obj4);
                        if (getStepType() != null && !getStepType().equals(StepType.UNKNOWN)) {
                            obj5 = getStepType().toLowerCase();
                            jSONObject.put(KEY_EVENT_TYPE, obj5);
                            jSONObject.put("date", getDate());
                            if (getView() != null && !getView().equals("null")) {
                                obj6 = getView();
                                jSONObject.put(KEY_VIEW, obj6);
                                if (getViewOrientation() != null && !getViewOrientation().equals("null")) {
                                    obj7 = getViewOrientation();
                                    jSONObject.put("orientation", obj7);
                                    jSONObject.put(KEY_IS_CONTAIN_ICON, isContainIcon());
                                    jSONObject.put(KEY_BUTTON_ICON, getButtonIcon());
                                    return jSONObject;
                                }
                                obj7 = JSONObject.NULL;
                                jSONObject.put("orientation", obj7);
                                jSONObject.put(KEY_IS_CONTAIN_ICON, isContainIcon());
                                jSONObject.put(KEY_BUTTON_ICON, getButtonIcon());
                                return jSONObject;
                            }
                            obj6 = JSONObject.NULL;
                            jSONObject.put(KEY_VIEW, obj6);
                            if (getViewOrientation() != null) {
                                obj7 = getViewOrientation();
                                jSONObject.put("orientation", obj7);
                                jSONObject.put(KEY_IS_CONTAIN_ICON, isContainIcon());
                                jSONObject.put(KEY_BUTTON_ICON, getButtonIcon());
                                return jSONObject;
                            }
                            obj7 = JSONObject.NULL;
                            jSONObject.put("orientation", obj7);
                            jSONObject.put(KEY_IS_CONTAIN_ICON, isContainIcon());
                            jSONObject.put(KEY_BUTTON_ICON, getButtonIcon());
                            return jSONObject;
                        }
                        obj5 = JSONObject.NULL;
                        jSONObject.put(KEY_EVENT_TYPE, obj5);
                        jSONObject.put("date", getDate());
                        if (getView() != null) {
                            obj6 = getView();
                            jSONObject.put(KEY_VIEW, obj6);
                            if (getViewOrientation() != null) {
                            }
                            obj7 = JSONObject.NULL;
                            jSONObject.put("orientation", obj7);
                            jSONObject.put(KEY_IS_CONTAIN_ICON, isContainIcon());
                            jSONObject.put(KEY_BUTTON_ICON, getButtonIcon());
                            return jSONObject;
                        }
                        obj6 = JSONObject.NULL;
                        jSONObject.put(KEY_VIEW, obj6);
                        if (getViewOrientation() != null) {
                        }
                        obj7 = JSONObject.NULL;
                        jSONObject.put("orientation", obj7);
                        jSONObject.put(KEY_IS_CONTAIN_ICON, isContainIcon());
                        jSONObject.put(KEY_BUTTON_ICON, getButtonIcon());
                        return jSONObject;
                    }
                    obj4 = JSONObject.NULL;
                    jSONObject.put(KEY_SCREEN_ID, obj4);
                    if (getStepType() != null) {
                        obj5 = getStepType().toLowerCase();
                        jSONObject.put(KEY_EVENT_TYPE, obj5);
                        jSONObject.put("date", getDate());
                        if (getView() != null) {
                        }
                        obj6 = JSONObject.NULL;
                        jSONObject.put(KEY_VIEW, obj6);
                        if (getViewOrientation() != null) {
                        }
                        obj7 = JSONObject.NULL;
                        jSONObject.put("orientation", obj7);
                        jSONObject.put(KEY_IS_CONTAIN_ICON, isContainIcon());
                        jSONObject.put(KEY_BUTTON_ICON, getButtonIcon());
                        return jSONObject;
                    }
                    obj5 = JSONObject.NULL;
                    jSONObject.put(KEY_EVENT_TYPE, obj5);
                    jSONObject.put("date", getDate());
                    if (getView() != null) {
                    }
                    obj6 = JSONObject.NULL;
                    jSONObject.put(KEY_VIEW, obj6);
                    if (getViewOrientation() != null) {
                    }
                    obj7 = JSONObject.NULL;
                    jSONObject.put("orientation", obj7);
                    jSONObject.put(KEY_IS_CONTAIN_ICON, isContainIcon());
                    jSONObject.put(KEY_BUTTON_ICON, getButtonIcon());
                    return jSONObject;
                }
                obj3 = JSONObject.NULL;
                jSONObject.put(KEY_SCREENSHOT_ID, obj3);
                if (getScreenId() != null) {
                    obj4 = getScreenId();
                    jSONObject.put(KEY_SCREEN_ID, obj4);
                    if (getStepType() != null) {
                    }
                    obj5 = JSONObject.NULL;
                    jSONObject.put(KEY_EVENT_TYPE, obj5);
                    jSONObject.put("date", getDate());
                    if (getView() != null) {
                    }
                    obj6 = JSONObject.NULL;
                    jSONObject.put(KEY_VIEW, obj6);
                    if (getViewOrientation() != null) {
                    }
                    obj7 = JSONObject.NULL;
                    jSONObject.put("orientation", obj7);
                    jSONObject.put(KEY_IS_CONTAIN_ICON, isContainIcon());
                    jSONObject.put(KEY_BUTTON_ICON, getButtonIcon());
                    return jSONObject;
                }
                obj4 = JSONObject.NULL;
                jSONObject.put(KEY_SCREEN_ID, obj4);
                if (getStepType() != null) {
                }
                obj5 = JSONObject.NULL;
                jSONObject.put(KEY_EVENT_TYPE, obj5);
                jSONObject.put("date", getDate());
                if (getView() != null) {
                }
                obj6 = JSONObject.NULL;
                jSONObject.put(KEY_VIEW, obj6);
                if (getViewOrientation() != null) {
                }
                obj7 = JSONObject.NULL;
                jSONObject.put("orientation", obj7);
                jSONObject.put(KEY_IS_CONTAIN_ICON, isContainIcon());
                jSONObject.put(KEY_BUTTON_ICON, getButtonIcon());
                return jSONObject;
            }
            obj2 = JSONObject.NULL;
            jSONObject.put("screen_name", obj2);
            if (getScreenshotId() != null) {
                obj3 = getScreenshotId();
                jSONObject.put(KEY_SCREENSHOT_ID, obj3);
                if (getScreenId() != null) {
                }
                obj4 = JSONObject.NULL;
                jSONObject.put(KEY_SCREEN_ID, obj4);
                if (getStepType() != null) {
                }
                obj5 = JSONObject.NULL;
                jSONObject.put(KEY_EVENT_TYPE, obj5);
                jSONObject.put("date", getDate());
                if (getView() != null) {
                }
                obj6 = JSONObject.NULL;
                jSONObject.put(KEY_VIEW, obj6);
                if (getViewOrientation() != null) {
                }
                obj7 = JSONObject.NULL;
                jSONObject.put("orientation", obj7);
                jSONObject.put(KEY_IS_CONTAIN_ICON, isContainIcon());
                jSONObject.put(KEY_BUTTON_ICON, getButtonIcon());
                return jSONObject;
            }
            obj3 = JSONObject.NULL;
            jSONObject.put(KEY_SCREENSHOT_ID, obj3);
            if (getScreenId() != null) {
            }
            obj4 = JSONObject.NULL;
            jSONObject.put(KEY_SCREEN_ID, obj4);
            if (getStepType() != null) {
            }
            obj5 = JSONObject.NULL;
            jSONObject.put(KEY_EVENT_TYPE, obj5);
            jSONObject.put("date", getDate());
            if (getView() != null) {
            }
            obj6 = JSONObject.NULL;
            jSONObject.put(KEY_VIEW, obj6);
            if (getViewOrientation() != null) {
            }
            obj7 = JSONObject.NULL;
            jSONObject.put("orientation", obj7);
            jSONObject.put(KEY_IS_CONTAIN_ICON, isContainIcon());
            jSONObject.put(KEY_BUTTON_ICON, getButtonIcon());
            return jSONObject;
        }
        obj = JSONObject.NULL;
        jSONObject.put(KEY_PARENT_SCREEN_ID, obj);
        if (getScreenName() != null) {
            obj2 = getScreenName();
            jSONObject.put("screen_name", obj2);
            if (getScreenshotId() != null) {
            }
            obj3 = JSONObject.NULL;
            jSONObject.put(KEY_SCREENSHOT_ID, obj3);
            if (getScreenId() != null) {
            }
            obj4 = JSONObject.NULL;
            jSONObject.put(KEY_SCREEN_ID, obj4);
            if (getStepType() != null) {
            }
            obj5 = JSONObject.NULL;
            jSONObject.put(KEY_EVENT_TYPE, obj5);
            jSONObject.put("date", getDate());
            if (getView() != null) {
            }
            obj6 = JSONObject.NULL;
            jSONObject.put(KEY_VIEW, obj6);
            if (getViewOrientation() != null) {
            }
            obj7 = JSONObject.NULL;
            jSONObject.put("orientation", obj7);
            jSONObject.put(KEY_IS_CONTAIN_ICON, isContainIcon());
            jSONObject.put(KEY_BUTTON_ICON, getButtonIcon());
            return jSONObject;
        }
        obj2 = JSONObject.NULL;
        jSONObject.put("screen_name", obj2);
        if (getScreenshotId() != null) {
        }
        obj3 = JSONObject.NULL;
        jSONObject.put(KEY_SCREENSHOT_ID, obj3);
        if (getScreenId() != null) {
        }
        obj4 = JSONObject.NULL;
        jSONObject.put(KEY_SCREEN_ID, obj4);
        if (getStepType() != null) {
        }
        obj5 = JSONObject.NULL;
        jSONObject.put(KEY_EVENT_TYPE, obj5);
        jSONObject.put("date", getDate());
        if (getView() != null) {
        }
        obj6 = JSONObject.NULL;
        jSONObject.put(KEY_VIEW, obj6);
        if (getViewOrientation() != null) {
        }
        obj7 = JSONObject.NULL;
        jSONObject.put("orientation", obj7);
        jSONObject.put(KEY_IS_CONTAIN_ICON, isContainIcon());
        jSONObject.put(KEY_BUTTON_ICON, getButtonIcon());
        return jSONObject;
    }

    @Override // java.lang.Object
    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public String toString() {
        StringBuilder P0 = i0.d.a.a.a.P0("VisualUserStep{parentScreenId='");
        i0.d.a.a.a.r(P0, this.parentScreenId, '\'', ", screenName='");
        i0.d.a.a.a.r(P0, this.screenName, '\'', ", screenshotId='");
        i0.d.a.a.a.r(P0, this.screenshotId, '\'', ", screenId='");
        i0.d.a.a.a.r(P0, this.screenId, '\'', ", eventType='");
        i0.d.a.a.a.r(P0, this.stepType, '\'', ", date=");
        P0.append(this.date);
        P0.append(", view='");
        P0.append(this.view);
        P0.append('\'');
        P0.append('}');
        return P0.toString();
    }

    private VisualUserStep(b bVar) {
        this.stepType = StepType.UNKNOWN;
        setParentScreenId(bVar.c);
        setScreenName(bVar.d);
        setScreenshotId(bVar.e);
        setScreenId(bVar.f);
        setStepType(bVar.j);
        setDate(bVar.a);
        setView(bVar.g);
        setViewOrientation(bVar.h);
        setButtonIcon(bVar.i);
        setContainIcon(bVar.b);
    }
}
