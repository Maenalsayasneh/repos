package com.clubhouse.android.data.models.local;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.RecyclerView;
import com.clubhouse.android.data.models.local.club.ClubWithAdmin;
import com.clubhouse.android.data.models.local.user.UserInList;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.pubnub.api.endpoints.objects_api.utils.Include;
import j$.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import m0.n.b.f;
import m0.n.b.i;
import m0.n.b.m;
import n0.c.e;
import n0.c.j.c;
import n0.c.j.d;
import n0.c.k.e0;
import n0.c.k.g1;
import n0.c.k.h;
import n0.c.k.h0;
import n0.c.k.v;
import n0.c.k.v0;
/* compiled from: EventInClub.kt */
@e
/* loaded from: classes3.dex */
public final class EventInClub implements i0.e.b.b3.a.a.a, i0.e.b.b3.a.a.b, Parcelable {
    public final int Y1;
    public final String Z1;
    public final String a2;
    public final List<UserInList> b2;
    public final ClubWithAdmin c;
    public final OffsetDateTime c2;
    public final boolean d;
    public final boolean d2;
    public final String e2;
    public final String f2;
    public final boolean g2;
    public final Map<String, Object> h2;
    public final String i2;
    public final boolean q;
    public final Boolean x;
    public final String y;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<EventInClub> CREATOR = new b();

    /* compiled from: EventInClub.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/clubhouse/android/data/models/local/EventInClub$Companion;", "", "Lkotlinx/serialization/KSerializer;", "Lcom/clubhouse/android/data/models/local/EventInClub;", "serializer", "()Lkotlinx/serialization/KSerializer;", "<init>", "()V", "data_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class Companion {
        public Companion() {
        }

        public final KSerializer<EventInClub> serializer() {
            return a.a;
        }

        public Companion(f fVar) {
        }
    }

    /* compiled from: EventInClub.kt */
    /* loaded from: classes3.dex */
    public static final class a implements v<EventInClub> {
        public static final a a;
        public static final /* synthetic */ SerialDescriptor b;

        static {
            a aVar = new a();
            a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.clubhouse.android.data.models.local.EventInClub", aVar, 16);
            pluginGeneratedSerialDescriptor.i("club", false);
            pluginGeneratedSerialDescriptor.i("club_is_member", true);
            pluginGeneratedSerialDescriptor.i("club_is_invited", true);
            pluginGeneratedSerialDescriptor.i("is_attending", true);
            pluginGeneratedSerialDescriptor.i("club_invite_url", true);
            pluginGeneratedSerialDescriptor.i("event_id", true);
            pluginGeneratedSerialDescriptor.i(InstabugDbContract.FeatureRequestEntry.COLUMN_DESCRIPTION, true);
            pluginGeneratedSerialDescriptor.i("name", true);
            pluginGeneratedSerialDescriptor.i("hosts", true);
            pluginGeneratedSerialDescriptor.i("time_start", true);
            pluginGeneratedSerialDescriptor.i("is_member_only", true);
            pluginGeneratedSerialDescriptor.i("url", true);
            pluginGeneratedSerialDescriptor.i(Include.INCLUDE_CHANNEL_PARAM_VALUE, true);
            pluginGeneratedSerialDescriptor.i("is_expired", true);
            pluginGeneratedSerialDescriptor.i("logging_context", true);
            pluginGeneratedSerialDescriptor.i("reason", true);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // n0.c.k.v
        public KSerializer<?>[] childSerializers() {
            h hVar = h.b;
            g1 g1Var = g1.b;
            return new KSerializer[]{m0.r.t.a.r.m.a1.a.R1(ClubWithAdmin.a.a), hVar, hVar, m0.r.t.a.r.m.a1.a.R1(hVar), m0.r.t.a.r.m.a1.a.R1(g1Var), e0.b, m0.r.t.a.r.m.a1.a.R1(g1Var), m0.r.t.a.r.m.a1.a.R1(g1Var), m0.r.t.a.r.m.a1.a.R1(new n0.c.k.e(UserInList.a.a)), m0.r.t.a.r.m.a1.a.R1(new n0.c.a(m.a(OffsetDateTime.class), null, new KSerializer[0])), hVar, m0.r.t.a.r.m.a1.a.R1(g1Var), m0.r.t.a.r.m.a1.a.R1(g1Var), hVar, m0.r.t.a.r.m.a1.a.R1(new h0(g1Var, i0.e.b.b3.a.b.c.a.a)), m0.r.t.a.r.m.a1.a.R1(g1Var)};
        }

        @Override // n0.c.b
        public Object deserialize(Decoder decoder) {
            boolean z;
            boolean z2;
            int i;
            boolean z3;
            boolean z4;
            int i2;
            Object obj;
            Object obj2;
            Object obj3;
            Object obj4;
            Object obj5;
            Object obj6;
            Object obj7;
            Object obj8;
            Object obj9;
            Object obj10;
            Object obj11;
            Object obj12;
            int i3;
            int i4;
            Object obj13;
            int i5;
            Object obj14;
            Object obj15;
            i.e(decoder, "decoder");
            SerialDescriptor serialDescriptor = b;
            c c = decoder.c(serialDescriptor);
            boolean z5 = false;
            if (c.y()) {
                obj11 = c.v(serialDescriptor, 0, ClubWithAdmin.a.a, null);
                z4 = c.s(serialDescriptor, 1);
                z3 = c.s(serialDescriptor, 2);
                obj7 = c.v(serialDescriptor, 3, h.b, null);
                g1 g1Var = g1.b;
                obj10 = c.v(serialDescriptor, 4, g1Var, null);
                i = c.k(serialDescriptor, 5);
                obj3 = c.v(serialDescriptor, 6, g1Var, null);
                obj2 = c.v(serialDescriptor, 7, g1Var, null);
                obj9 = c.v(serialDescriptor, 8, new n0.c.k.e(UserInList.a.a), null);
                obj8 = c.v(serialDescriptor, 9, new n0.c.a(m.a(OffsetDateTime.class), null, new KSerializer[0]), null);
                z2 = c.s(serialDescriptor, 10);
                obj4 = c.v(serialDescriptor, 11, g1Var, null);
                obj = c.v(serialDescriptor, 12, g1Var, null);
                z = c.s(serialDescriptor, 13);
                obj5 = c.v(serialDescriptor, 14, new h0(g1Var, i0.e.b.b3.a.b.c.a.a), null);
                obj6 = c.v(serialDescriptor, 15, g1Var, null);
                i2 = 65535;
            } else {
                int i6 = 15;
                boolean z6 = false;
                boolean z7 = false;
                int i7 = 0;
                boolean z8 = false;
                boolean z9 = false;
                boolean z10 = true;
                Object obj16 = null;
                Object obj17 = null;
                Object obj18 = null;
                Object obj19 = null;
                obj6 = null;
                obj5 = null;
                obj4 = null;
                obj3 = null;
                obj2 = null;
                Object obj20 = null;
                Object obj21 = null;
                int i8 = 0;
                while (z10) {
                    int x = c.x(serialDescriptor);
                    switch (x) {
                        case -1:
                            obj14 = obj18;
                            obj15 = obj21;
                            z10 = z5;
                            break;
                        case 0:
                            obj14 = obj18;
                            obj15 = obj21;
                            z5 = false;
                            obj17 = c.v(serialDescriptor, 0, ClubWithAdmin.a.a, obj17);
                            i8 |= 1;
                            break;
                        case 1:
                            obj12 = obj18;
                            z8 = c.s(serialDescriptor, 1);
                            i3 = i8 | 2;
                            i8 = i3;
                            obj18 = obj12;
                            i6 = 15;
                            z5 = false;
                        case 2:
                            obj12 = obj18;
                            z9 = c.s(serialDescriptor, 2);
                            i3 = i8 | 4;
                            i8 = i3;
                            obj18 = obj12;
                            i6 = 15;
                            z5 = false;
                        case 3:
                            obj12 = obj18;
                            obj21 = c.v(serialDescriptor, 3, h.b, obj21);
                            i3 = i8 | 8;
                            i8 = i3;
                            obj18 = obj12;
                            i6 = 15;
                            z5 = false;
                        case 4:
                            obj12 = obj18;
                            obj19 = c.v(serialDescriptor, 4, g1.b, obj19);
                            i4 = i8 | 16;
                            i3 = i4;
                            i8 = i3;
                            obj18 = obj12;
                            i6 = 15;
                            z5 = false;
                        case 5:
                            obj13 = obj18;
                            i7 = c.k(serialDescriptor, 5);
                            i8 |= 32;
                            obj18 = obj13;
                            i6 = 15;
                            z5 = false;
                        case 6:
                            obj13 = obj18;
                            obj3 = c.v(serialDescriptor, 6, g1.b, obj3);
                            i8 |= 64;
                            obj18 = obj13;
                            i6 = 15;
                            z5 = false;
                        case 7:
                            obj13 = obj18;
                            obj2 = c.v(serialDescriptor, 7, g1.b, obj2);
                            i5 = i8 | 128;
                            i8 = i5;
                            obj18 = obj13;
                            i6 = 15;
                            z5 = false;
                        case 8:
                            obj13 = obj18;
                            obj20 = c.v(serialDescriptor, 8, new n0.c.k.e(UserInList.a.a), obj20);
                            i5 = i8 | 256;
                            i8 = i5;
                            obj18 = obj13;
                            i6 = 15;
                            z5 = false;
                        case 9:
                            obj12 = obj18;
                            obj16 = c.v(serialDescriptor, 9, new n0.c.a(m.a(OffsetDateTime.class), null, new KSerializer[0]), obj16);
                            i4 = i8 | 512;
                            i3 = i4;
                            i8 = i3;
                            obj18 = obj12;
                            i6 = 15;
                            z5 = false;
                        case 10:
                            z7 = c.s(serialDescriptor, 10);
                            i3 = i8 | RecyclerView.b0.FLAG_ADAPTER_FULLUPDATE;
                            obj12 = obj18;
                            i8 = i3;
                            obj18 = obj12;
                            i6 = 15;
                            z5 = false;
                        case 11:
                            obj4 = c.v(serialDescriptor, 11, g1.b, obj4);
                            i3 = i8 | 2048;
                            obj12 = obj18;
                            i8 = i3;
                            obj18 = obj12;
                            i6 = 15;
                            z5 = false;
                        case 12:
                            obj18 = c.v(serialDescriptor, 12, g1.b, obj18);
                            i3 = i8 | 4096;
                            obj12 = obj18;
                            i8 = i3;
                            obj18 = obj12;
                            i6 = 15;
                            z5 = false;
                        case 13:
                            z6 = c.s(serialDescriptor, 13);
                            i3 = i8 | 8192;
                            obj12 = obj18;
                            i8 = i3;
                            obj18 = obj12;
                            i6 = 15;
                            z5 = false;
                        case 14:
                            obj5 = c.v(serialDescriptor, 14, new h0(g1.b, i0.e.b.b3.a.b.c.a.a), obj5);
                            i3 = i8 | 16384;
                            obj12 = obj18;
                            i8 = i3;
                            obj18 = obj12;
                            i6 = 15;
                            z5 = false;
                        case 15:
                            obj6 = c.v(serialDescriptor, i6, g1.b, obj6);
                            i8 = 32768 | i8;
                            obj12 = obj18;
                            obj18 = obj12;
                            i6 = 15;
                            z5 = false;
                        default:
                            throw new UnknownFieldException(x);
                    }
                    obj21 = obj15;
                    obj18 = obj14;
                    i6 = 15;
                }
                obj8 = obj16;
                obj7 = obj21;
                obj11 = obj17;
                obj10 = obj19;
                i2 = i8;
                obj9 = obj20;
                i = i7;
                z4 = z8;
                z3 = z9;
                obj = obj18;
                z = z6;
                z2 = z7;
            }
            c.b(serialDescriptor);
            return new EventInClub(i2, (ClubWithAdmin) obj11, z4, z3, (Boolean) obj7, (String) obj10, i, (String) obj3, (String) obj2, (List) obj9, (OffsetDateTime) obj8, z2, (String) obj4, (String) obj, z, (Map) obj5, (String) obj6);
        }

        @Override // kotlinx.serialization.KSerializer, n0.c.f, n0.c.b
        public SerialDescriptor getDescriptor() {
            return b;
        }

        @Override // n0.c.f
        public void serialize(Encoder encoder, Object obj) {
            EventInClub eventInClub = (EventInClub) obj;
            i.e(encoder, "encoder");
            i.e(eventInClub, InstabugDbContract.UserAttributesEntry.COLUMN_VALUE);
            SerialDescriptor serialDescriptor = b;
            d c = encoder.c(serialDescriptor);
            i.e(eventInClub, "self");
            i.e(c, "output");
            i.e(serialDescriptor, "serialDesc");
            boolean z = false;
            c.l(serialDescriptor, 0, ClubWithAdmin.a.a, eventInClub.c);
            if (c.v(serialDescriptor, 1) || eventInClub.d) {
                c.r(serialDescriptor, 1, eventInClub.d);
            }
            if (c.v(serialDescriptor, 2) || eventInClub.q) {
                c.r(serialDescriptor, 2, eventInClub.q);
            }
            if (c.v(serialDescriptor, 3) || eventInClub.x != null) {
                c.l(serialDescriptor, 3, h.b, eventInClub.x);
            }
            if (c.v(serialDescriptor, 4) || eventInClub.y != null) {
                c.l(serialDescriptor, 4, g1.b, eventInClub.y);
            }
            if (c.v(serialDescriptor, 5) || eventInClub.Y1 != 0) {
                c.q(serialDescriptor, 5, eventInClub.Y1);
            }
            if (c.v(serialDescriptor, 6) || eventInClub.Z1 != null) {
                c.l(serialDescriptor, 6, g1.b, eventInClub.Z1);
            }
            if (c.v(serialDescriptor, 7) || eventInClub.a2 != null) {
                c.l(serialDescriptor, 7, g1.b, eventInClub.a2);
            }
            if (c.v(serialDescriptor, 8) || eventInClub.b2 != null) {
                c.l(serialDescriptor, 8, new n0.c.k.e(UserInList.a.a), eventInClub.b2);
            }
            if (c.v(serialDescriptor, 9) || eventInClub.c2 != null) {
                c.l(serialDescriptor, 9, new n0.c.a(m.a(OffsetDateTime.class), null, new KSerializer[0]), eventInClub.c2);
            }
            if (c.v(serialDescriptor, 10) || eventInClub.d2) {
                c.r(serialDescriptor, 10, eventInClub.d2);
            }
            if (c.v(serialDescriptor, 11) || eventInClub.e2 != null) {
                c.l(serialDescriptor, 11, g1.b, eventInClub.e2);
            }
            if (c.v(serialDescriptor, 12) || eventInClub.f2 != null) {
                c.l(serialDescriptor, 12, g1.b, eventInClub.f2);
            }
            if (c.v(serialDescriptor, 13) || eventInClub.g2) {
                c.r(serialDescriptor, 13, eventInClub.g2);
            }
            if (c.v(serialDescriptor, 14) || eventInClub.h2 != null) {
                c.l(serialDescriptor, 14, new h0(g1.b, i0.e.b.b3.a.b.c.a.a), eventInClub.h2);
            }
            if (c.v(serialDescriptor, 15) || eventInClub.i2 != null) {
                z = true;
            }
            if (z) {
                c.l(serialDescriptor, 15, g1.b, eventInClub.i2);
            }
            c.b(serialDescriptor);
        }

        @Override // n0.c.k.v
        public KSerializer<?>[] typeParametersSerializers() {
            return v0.a;
        }
    }

    /* compiled from: EventInClub.kt */
    /* loaded from: classes3.dex */
    public static final class b implements Parcelable.Creator<EventInClub> {
        @Override // android.os.Parcelable.Creator
        public EventInClub createFromParcel(Parcel parcel) {
            Boolean bool;
            ArrayList arrayList;
            LinkedHashMap linkedHashMap;
            i.e(parcel, "parcel");
            ClubWithAdmin createFromParcel = parcel.readInt() == 0 ? null : ClubWithAdmin.CREATOR.createFromParcel(parcel);
            boolean z = parcel.readInt() != 0;
            boolean z2 = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                bool = null;
            } else {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt2 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt2);
                int i = 0;
                while (i != readInt2) {
                    i = i0.d.a.a.a.n(UserInList.CREATOR, parcel, arrayList2, i, 1);
                }
                arrayList = arrayList2;
            }
            OffsetDateTime offsetDateTime = (OffsetDateTime) parcel.readSerializable();
            boolean z3 = parcel.readInt() != 0;
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            boolean z4 = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                linkedHashMap = null;
            } else {
                int readInt3 = parcel.readInt();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap(readInt3);
                int i2 = 0;
                while (i2 != readInt3) {
                    i2 = i0.d.a.a.a.y(EventInClub.class, parcel, linkedHashMap2, parcel.readString(), i2, 1);
                    linkedHashMap2 = linkedHashMap2;
                    readInt3 = readInt3;
                }
                linkedHashMap = linkedHashMap2;
            }
            return new EventInClub(createFromParcel, z, z2, bool, readString, readInt, readString2, readString3, arrayList, offsetDateTime, z3, readString4, readString5, z4, linkedHashMap, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public EventInClub[] newArray(int i) {
            return new EventInClub[i];
        }
    }

    public EventInClub(int i, ClubWithAdmin clubWithAdmin, boolean z, boolean z2, Boolean bool, String str, int i2, String str2, String str3, List list, OffsetDateTime offsetDateTime, boolean z3, String str4, String str5, boolean z4, Map map, String str6) {
        if (1 == (i & 1)) {
            this.c = clubWithAdmin;
            if ((i & 2) == 0) {
                this.d = false;
            } else {
                this.d = z;
            }
            if ((i & 4) == 0) {
                this.q = false;
            } else {
                this.q = z2;
            }
            if ((i & 8) == 0) {
                this.x = null;
            } else {
                this.x = bool;
            }
            if ((i & 16) == 0) {
                this.y = null;
            } else {
                this.y = str;
            }
            if ((i & 32) == 0) {
                this.Y1 = 0;
            } else {
                this.Y1 = i2;
            }
            if ((i & 64) == 0) {
                this.Z1 = null;
            } else {
                this.Z1 = str2;
            }
            if ((i & 128) == 0) {
                this.a2 = null;
            } else {
                this.a2 = str3;
            }
            if ((i & 256) == 0) {
                this.b2 = null;
            } else {
                this.b2 = list;
            }
            if ((i & 512) == 0) {
                this.c2 = null;
            } else {
                this.c2 = offsetDateTime;
            }
            if ((i & RecyclerView.b0.FLAG_ADAPTER_FULLUPDATE) == 0) {
                this.d2 = false;
            } else {
                this.d2 = z3;
            }
            if ((i & 2048) == 0) {
                this.e2 = null;
            } else {
                this.e2 = str4;
            }
            if ((i & 4096) == 0) {
                this.f2 = null;
            } else {
                this.f2 = str5;
            }
            if ((i & 8192) == 0) {
                this.g2 = false;
            } else {
                this.g2 = z4;
            }
            if ((i & 16384) == 0) {
                this.h2 = null;
            } else {
                this.h2 = map;
            }
            if ((i & 32768) == 0) {
                this.i2 = null;
            } else {
                this.i2 = str6;
            }
        } else {
            a aVar = a.a;
            m0.r.t.a.r.m.a1.a.W3(i, 1, a.b);
            throw null;
        }
    }

    public static EventInClub d(EventInClub eventInClub, ClubWithAdmin clubWithAdmin, boolean z, boolean z2, Boolean bool, String str, int i, String str2, String str3, List list, OffsetDateTime offsetDateTime, boolean z3, String str4, String str5, boolean z4, Map map, String str6, int i2) {
        ClubWithAdmin clubWithAdmin2 = (i2 & 1) != 0 ? eventInClub.c : clubWithAdmin;
        boolean z5 = (i2 & 2) != 0 ? eventInClub.d : z;
        boolean z6 = (i2 & 4) != 0 ? eventInClub.q : z2;
        Boolean bool2 = (i2 & 8) != 0 ? eventInClub.x : bool;
        String str7 = (i2 & 16) != 0 ? eventInClub.y : null;
        int i3 = (i2 & 32) != 0 ? eventInClub.Y1 : i;
        String str8 = (i2 & 64) != 0 ? eventInClub.Z1 : str2;
        String str9 = (i2 & 128) != 0 ? eventInClub.a2 : str3;
        List<UserInList> list2 = (i2 & 256) != 0 ? eventInClub.b2 : null;
        OffsetDateTime offsetDateTime2 = (i2 & 512) != 0 ? eventInClub.c2 : offsetDateTime;
        boolean z7 = (i2 & RecyclerView.b0.FLAG_ADAPTER_FULLUPDATE) != 0 ? eventInClub.d2 : z3;
        String str10 = (i2 & 2048) != 0 ? eventInClub.e2 : null;
        String str11 = (i2 & 4096) != 0 ? eventInClub.f2 : null;
        boolean z8 = (i2 & 8192) != 0 ? eventInClub.g2 : z4;
        Map<String, Object> map2 = (i2 & 16384) != 0 ? eventInClub.h2 : null;
        String str12 = (i2 & 32768) != 0 ? eventInClub.i2 : null;
        Objects.requireNonNull(eventInClub);
        return new EventInClub(clubWithAdmin2, z5, z6, bool2, str7, i3, str8, str9, list2, offsetDateTime2, z7, str10, str11, z8, map2, str12);
    }

    @Override // i0.e.b.b3.a.a.b
    public String a() {
        return this.i2;
    }

    @Override // i0.e.b.b3.a.a.b
    public Map<String, Object> c() {
        return this.h2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EventInClub)) {
            return false;
        }
        EventInClub eventInClub = (EventInClub) obj;
        return i.a(this.c, eventInClub.c) && this.d == eventInClub.d && this.q == eventInClub.q && i.a(this.x, eventInClub.x) && i.a(this.y, eventInClub.y) && this.Y1 == eventInClub.Y1 && i.a(this.Z1, eventInClub.Z1) && i.a(this.a2, eventInClub.a2) && i.a(this.b2, eventInClub.b2) && i.a(this.c2, eventInClub.c2) && this.d2 == eventInClub.d2 && i.a(this.e2, eventInClub.e2) && i.a(this.f2, eventInClub.f2) && this.g2 == eventInClub.g2 && i.a(this.h2, eventInClub.h2) && i.a(this.i2, eventInClub.i2);
    }

    @Override // i0.e.b.b3.a.a.a
    public int getId() {
        return this.Y1;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        ClubWithAdmin clubWithAdmin = this.c;
        int i9 = 0;
        int hashCode = (clubWithAdmin == null ? 0 : clubWithAdmin.hashCode()) * 31;
        boolean z = this.d;
        int i10 = 1;
        if (z) {
            z = true;
        }
        int i11 = z ? 1 : 0;
        int i12 = z ? 1 : 0;
        int i13 = z ? 1 : 0;
        int i14 = (hashCode + i11) * 31;
        boolean z2 = this.q;
        if (z2) {
            z2 = true;
        }
        int i15 = z2 ? 1 : 0;
        int i16 = z2 ? 1 : 0;
        int i17 = z2 ? 1 : 0;
        int i18 = (i14 + i15) * 31;
        Boolean bool = this.x;
        if (bool == null) {
            i = 0;
        } else {
            i = bool.hashCode();
        }
        int i19 = (i18 + i) * 31;
        String str = this.y;
        int M = i0.d.a.a.a.M(this.Y1, (i19 + (str == null ? 0 : str.hashCode())) * 31, 31);
        String str2 = this.Z1;
        if (str2 == null) {
            i2 = 0;
        } else {
            i2 = str2.hashCode();
        }
        int i20 = (M + i2) * 31;
        String str3 = this.a2;
        if (str3 == null) {
            i3 = 0;
        } else {
            i3 = str3.hashCode();
        }
        int i21 = (i20 + i3) * 31;
        List<UserInList> list = this.b2;
        if (list == null) {
            i4 = 0;
        } else {
            i4 = list.hashCode();
        }
        int i22 = (i21 + i4) * 31;
        OffsetDateTime offsetDateTime = this.c2;
        if (offsetDateTime == null) {
            i5 = 0;
        } else {
            i5 = offsetDateTime.hashCode();
        }
        int i23 = (i22 + i5) * 31;
        boolean z3 = this.d2;
        if (z3) {
            z3 = true;
        }
        int i24 = z3 ? 1 : 0;
        int i25 = z3 ? 1 : 0;
        int i26 = z3 ? 1 : 0;
        int i27 = (i23 + i24) * 31;
        String str4 = this.e2;
        if (str4 == null) {
            i6 = 0;
        } else {
            i6 = str4.hashCode();
        }
        int i28 = (i27 + i6) * 31;
        String str5 = this.f2;
        if (str5 == null) {
            i7 = 0;
        } else {
            i7 = str5.hashCode();
        }
        int i29 = (i28 + i7) * 31;
        boolean z4 = this.g2;
        if (!z4) {
            i10 = z4 ? 1 : 0;
        }
        int i30 = (i29 + i10) * 31;
        Map<String, Object> map = this.h2;
        if (map == null) {
            i8 = 0;
        } else {
            i8 = map.hashCode();
        }
        int i31 = (i30 + i8) * 31;
        String str6 = this.i2;
        if (str6 != null) {
            i9 = str6.hashCode();
        }
        return i31 + i9;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder P0 = i0.d.a.a.a.P0("EventInClub(club=");
        P0.append(this.c);
        P0.append(", clubIsMember=");
        P0.append(this.d);
        P0.append(", clubIsInvited=");
        P0.append(this.q);
        P0.append(", isAttending=");
        P0.append(this.x);
        P0.append(", clubInviteUrl=");
        P0.append((Object) this.y);
        P0.append(", id=");
        P0.append(this.Y1);
        P0.append(", description=");
        P0.append((Object) this.Z1);
        P0.append(", name=");
        P0.append((Object) this.a2);
        P0.append(", hosts=");
        P0.append(this.b2);
        P0.append(", timeStart=");
        P0.append(this.c2);
        P0.append(", isMemberOnly=");
        P0.append(this.d2);
        P0.append(", url=");
        P0.append((Object) this.e2);
        P0.append(", channel=");
        P0.append((Object) this.f2);
        P0.append(", isExpired=");
        P0.append(this.g2);
        P0.append(", loggingContext=");
        P0.append(this.h2);
        P0.append(", reason=");
        return i0.d.a.a.a.w0(P0, this.i2, ')');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        i.e(parcel, "out");
        ClubWithAdmin clubWithAdmin = this.c;
        if (clubWithAdmin == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            clubWithAdmin.writeToParcel(parcel, i);
        }
        parcel.writeInt(this.d ? 1 : 0);
        parcel.writeInt(this.q ? 1 : 0);
        Boolean bool = this.x;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.y);
        parcel.writeInt(this.Y1);
        parcel.writeString(this.Z1);
        parcel.writeString(this.a2);
        List<UserInList> list = this.b2;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (UserInList userInList : list) {
                userInList.writeToParcel(parcel, i);
            }
        }
        parcel.writeSerializable(this.c2);
        parcel.writeInt(this.d2 ? 1 : 0);
        parcel.writeString(this.e2);
        parcel.writeString(this.f2);
        parcel.writeInt(this.g2 ? 1 : 0);
        Map<String, Object> map = this.h2;
        if (map == null) {
            parcel.writeInt(0);
        } else {
            Iterator l1 = i0.d.a.a.a.l1(parcel, 1, map);
            while (l1.hasNext()) {
                Map.Entry entry = (Map.Entry) l1.next();
                parcel.writeString((String) entry.getKey());
                parcel.writeValue(entry.getValue());
            }
        }
        parcel.writeString(this.i2);
    }

    public EventInClub(ClubWithAdmin clubWithAdmin, boolean z, boolean z2, Boolean bool, String str, int i, String str2, String str3, List<UserInList> list, OffsetDateTime offsetDateTime, boolean z3, String str4, String str5, boolean z4, Map<String, ? extends Object> map, String str6) {
        this.c = clubWithAdmin;
        this.d = z;
        this.q = z2;
        this.x = bool;
        this.y = str;
        this.Y1 = i;
        this.Z1 = str2;
        this.a2 = str3;
        this.b2 = list;
        this.c2 = offsetDateTime;
        this.d2 = z3;
        this.e2 = str4;
        this.f2 = str5;
        this.g2 = z4;
        this.h2 = map;
        this.i2 = str6;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EventInClub(ClubWithAdmin clubWithAdmin, boolean z, boolean z2, Boolean bool, String str, int i, String str2, String str3, List list, OffsetDateTime offsetDateTime, boolean z3, String str4, String str5, boolean z4, Map map, String str6, int i2) {
        this(clubWithAdmin, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? false : z2, null, null, (i2 & 32) != 0 ? 0 : i, null, null, null, null, (i2 & RecyclerView.b0.FLAG_ADAPTER_FULLUPDATE) != 0 ? false : z3, null, null, (i2 & 8192) != 0 ? false : z4, null, null);
        int i3 = i2 & 8;
        int i4 = i2 & 16;
        int i5 = i2 & 64;
        int i6 = i2 & 128;
        int i7 = i2 & 256;
        int i8 = i2 & 512;
        int i9 = i2 & 2048;
        int i10 = i2 & 4096;
        int i11 = i2 & 16384;
        int i12 = i2 & 32768;
    }
}
