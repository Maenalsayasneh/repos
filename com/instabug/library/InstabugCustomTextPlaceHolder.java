package com.instabug.library;

import android.util.Log;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.util.StringUtility;
import i0.j.e.c;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes2.dex */
public class InstabugCustomTextPlaceHolder {
    public static final int SUB_TITLE_CHAR_LIMIT = 75;
    public static final int TITLE_CHAR_LIMIT = 35;
    private final c delegate = new c();

    /* loaded from: classes2.dex */
    public enum Key {
        SHAKE_HINT,
        SWIPE_HINT,
        INVALID_EMAIL_MESSAGE,
        INVALID_COMMENT_MESSAGE,
        INVOCATION_HEADER,
        REPORT_BUG {
            @Override // com.instabug.library.InstabugCustomTextPlaceHolder.Key
            public int charLimit() {
                return 35;
            }
        },
        REPORT_FEEDBACK {
            @Override // com.instabug.library.InstabugCustomTextPlaceHolder.Key
            public int charLimit() {
                return 35;
            }
        },
        REPORT_QUESTION {
            @Override // com.instabug.library.InstabugCustomTextPlaceHolder.Key
            public int charLimit() {
                return 35;
            }
        },
        REQUEST_FEATURE {
            @Override // com.instabug.library.InstabugCustomTextPlaceHolder.Key
            public int charLimit() {
                return 35;
            }
        },
        REPORT_BUG_DESCRIPTION {
            @Override // com.instabug.library.InstabugCustomTextPlaceHolder.Key
            public int charLimit() {
                return 75;
            }
        },
        REPORT_FEEDBACK_DESCRIPTION {
            @Override // com.instabug.library.InstabugCustomTextPlaceHolder.Key
            public int charLimit() {
                return 75;
            }
        },
        REPORT_QUESTION_DESCRIPTION {
            @Override // com.instabug.library.InstabugCustomTextPlaceHolder.Key
            public int charLimit() {
                return 75;
            }
        },
        REQUEST_FEATURE_DESCRIPTION {
            @Override // com.instabug.library.InstabugCustomTextPlaceHolder.Key
            public int charLimit() {
                return 75;
            }
        },
        START_CHATS,
        EMAIL_FIELD_HINT,
        COMMENT_FIELD_HINT_FOR_BUG_REPORT,
        COMMENT_FIELD_HINT_FOR_FEEDBACK,
        COMMENT_FIELD_HINT_FOR_QUESTION,
        BUG_REPORT_HEADER,
        FEEDBACK_REPORT_HEADER,
        QUESTION_REPORT_HEADER,
        ADD_VOICE_MESSAGE,
        ADD_IMAGE_FROM_GALLERY,
        ADD_EXTRA_SCREENSHOT,
        CONVERSATIONS_LIST_TITLE,
        AUDIO_RECORDING_PERMISSION_DENIED,
        CONVERSATION_TEXT_FIELD_HINT,
        VOICE_MESSAGE_PRESS_AND_HOLD_TO_RECORD,
        VOICE_MESSAGE_RELEASE_TO_ATTACH,
        REPORT_SUCCESSFULLY_SENT,
        SUCCESS_DIALOG_HEADER,
        ADD_VIDEO,
        VIDEO_PLAYER_TITLE,
        FEATURES_REQUEST,
        FEATURES_REQUEST_ADD_FEATURE_TOAST,
        FEATURES_REQUEST_ADD_FEATURE_THANKS_MESSAGE,
        SURVEYS_WELCOME_SCREEN_TITLE,
        SURVEYS_WELCOME_SCREEN_SUBTITLE,
        SURVEYS_WELCOME_SCREEN_BUTTON,
        SURVEYS_CUSTOM_THANKS_TITLE,
        SURVEYS_CUSTOM_THANKS_SUBTITLE,
        SURVEYS_STORE_RATING_THANKS_TITLE,
        SURVEYS_STORE_RATING_THANKS_SUBTITLE,
        BETA_WELCOME_MESSAGE_WELCOME_STEP_TITLE,
        BETA_WELCOME_MESSAGE_WELCOME_STEP_CONTENT,
        BETA_WELCOME_MESSAGE_HOW_TO_REPORT_STEP_TITLE,
        BETA_WELCOME_MESSAGE_HOW_TO_REPORT_STEP_CONTENT,
        BETA_WELCOME_MESSAGE_FINISH_STEP_TITLE,
        BETA_WELCOME_MESSAGE_FINISH_STEP_CONTENT,
        LIVE_WELCOME_MESSAGE_TITLE,
        LIVE_WELCOME_MESSAGE_CONTENT,
        CHATS_TEAM_STRING_NAME,
        REPLIES_NOTIFICATION_DISMISS_BUTTON,
        REPLIES_NOTIFICATION_REPLY_BUTTON,
        REPORT_DISCARD_DIALOG_TITLE,
        REPORT_DISCARD_DIALOG_BODY,
        REPORT_DISCARD_DIALOG_NEGATIVE_ACTION,
        REPORT_DISCARD_DIALOG_POSITIVE_ACTION,
        REPORT_ADD_ATTACHMENT_HEADER,
        REPORT_REPRO_STEPS_DISCLAIMER_BODY,
        REPORT_REPRO_STEPS_DISCLAIMER_LINK,
        REPRO_STEPS_PROGRESS_DIALOG_BODY,
        REPRO_STEPS_LIST_HEADER,
        REPRO_STEPS_LIST_DESCRIPTION,
        REPRO_STEPS_LIST_EMPTY_STATE_DESCRIPTION;

        public int charLimit() {
            return -1;
        }
    }

    public String get(Key key) {
        return this.delegate.a.get(key);
    }

    public void set(Key key, String str) {
        c cVar = this.delegate;
        Objects.requireNonNull(cVar);
        com.instabug.library.internal.utils.a.a(key);
        Map<Key, String> map = cVar.a;
        if (key.charLimit() > -1 && str.length() > key.charLimit()) {
            StringBuilder P0 = i0.d.a.a.a.P0("The max ");
            P0.append(key.charLimit() == 35 ? InstabugDbContract.FeatureRequestEntry.COLUMN_TITLE : InstabugDbContract.FeatureRequestEntry.COLUMN_DESCRIPTION);
            P0.append(" length is ");
            P0.append(key.charLimit());
            P0.append(". Any extra characters will be trimmed.");
            Log.w("INSTABUG", P0.toString());
            str = StringUtility.ellipsize(str, key.charLimit());
        }
        map.put(key, str);
    }

    public void setPlaceHoldersMap(HashMap<Key, String> hashMap) {
        c cVar = this.delegate;
        cVar.a.clear();
        cVar.a.putAll(hashMap);
    }
}
