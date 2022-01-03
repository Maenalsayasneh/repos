package com.clubhouse.android.data.models.local.user;

import i0.e.b.b3.a.b.c.h;
import java.util.NoSuchElementException;
import m0.n.b.f;
import n0.c.e;
/* compiled from: SourceLocation.kt */
@e(with = h.class)
/* loaded from: classes3.dex */
public enum SourceLocation {
    UNKNOWN(-1),
    ONBOARDING_FRIENDS(1),
    ONBOARDING_SUGGESTED(2),
    SUGGESTED(3),
    PROFILE(4),
    CHANNEL(5),
    LIST(6),
    BULLETIN(7),
    CLUB(8),
    SEARCH(9),
    ACTIONABLE_NOTIFICATION(10),
    SUGGESTED_SIMILAR(11),
    WELCOME_ROOM(12),
    EXPLORE(13),
    HALLWAY(14),
    URL(15),
    REMOTE_NOTIFICATION(16),
    ACTIVITY(17),
    SIDE_ROOM(18),
    BUDDY_LIST(19),
    SUGGESTED_SPEAKERS(20),
    RECENT_CHANNELS_SPEAKERS(21),
    BACKCHANNEL(24),
    BULLETIN_EVENT(25),
    WAVE(26),
    IN_APP_TOAST(27),
    ONBOARDING_TOPICS(28),
    ONBOARDING_CLUBS(29);
    
    public static final a Companion = new a(null);
    private final int code;

    /* compiled from: SourceLocation.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a(f fVar) {
        }

        public final SourceLocation a(int i) {
            SourceLocation[] values = SourceLocation.values();
            for (int i2 = 0; i2 < 28; i2++) {
                SourceLocation sourceLocation = values[i2];
                if (sourceLocation.getCode() == i) {
                    return sourceLocation;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
    }

    SourceLocation(int i) {
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }
}
