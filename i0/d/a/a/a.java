package i0.d.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import androidx.appcompat.app.AlertController;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.clubhouse.android.data.models.local.notification.ActionableNotification;
import com.clubhouse.android.ui.activity.ActivityViewModel;
import com.clubhouse.android.ui.channels.ChannelFragment;
import com.clubhouse.android.ui.clubs.ClubFragment;
import com.clubhouse.android.ui.clubs.HalfClubRulesArgs;
import com.instabug.library.analytics.model.Api;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.instabug.library.network.RequestResponse;
import com.pubnub.api.PubNubError;
import h0.b.a.d;
import h0.b0.v;
import h0.t.q;
import i0.e.b.g3.j.f0;
import i0.e.b.g3.l.k1;
import i0.j.f.p.h;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.security.spec.ECParameterSpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.d;
import m0.r.t.a.r.f.c.b;
import m0.r.t.a.r.m.z0.g;
import m0.r.t.a.r.m.z0.j;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import s0.a.a.n;
import s0.a.b.b0.o;
import s0.a.b.b0.p;
import s0.a.b.b0.s;
import s0.a.b.b0.u;
/* compiled from: outline */
/* loaded from: classes.dex */
public class a {
    public static boolean A(ECParameterSpec eCParameterSpec, BigInteger bigInteger) {
        return bigInteger.equals(eCParameterSpec.getCurve().getA());
    }

    public static String A0(StringBuilder sb, List list, char c) {
        sb.append(list);
        sb.append(c);
        return sb.toString();
    }

    public static boolean B(ECParameterSpec eCParameterSpec, BigInteger bigInteger) {
        return bigInteger.equals(eCParameterSpec.getCurve().getB());
    }

    public static String B0(StringBuilder sb, Map map, char c) {
        sb.append(map);
        sb.append(c);
        return sb.toString();
    }

    public static boolean C(ECParameterSpec eCParameterSpec, BigInteger bigInteger) {
        return bigInteger.equals(eCParameterSpec.getGenerator().getAffineX());
    }

    public static String C0(StringBuilder sb, boolean z, char c) {
        sb.append(z);
        sb.append(c);
        return sb.toString();
    }

    public static boolean D(ECParameterSpec eCParameterSpec, BigInteger bigInteger) {
        return bigInteger.equals(eCParameterSpec.getGenerator().getAffineY());
    }

    public static String D0(StringBuilder sb, boolean z, String str) {
        sb.append(z);
        sb.append(str);
        return sb.toString();
    }

    public static boolean E(b.C0267b bVar, int i, String str) {
        Boolean f = bVar.d(i);
        i.d(f, str);
        return f.booleanValue();
    }

    public static int E0(int i, int i2, int i3, s sVar, int i4, int i5) {
        return sVar.i(i + i2 + i3, i4) + i5;
    }

    public static int F(String str, int i, int i2) {
        return (str.hashCode() + i) * i2;
    }

    public static String F0(Field field, StringBuilder sb, String str) {
        sb.append(field.getName());
        sb.append(str);
        return sb.toString();
    }

    public static int G(ECParameterSpec eCParameterSpec) {
        return eCParameterSpec.getCurve().getField().getFieldSize();
    }

    public static String G0(d dVar, String str) {
        String name = h.l1(dVar).getName();
        i.d(name, str);
        return name;
    }

    public static int H(List list, int i, int i2) {
        return (list.hashCode() + i) * i2;
    }

    public static String H0(d dVar, StringBuilder sb, String str) {
        sb.append(dVar.e());
        sb.append(str);
        return sb.toString();
    }

    public static int I(Set set, int i, int i2) {
        return (set.hashCode() + i) * i2;
    }

    public static String I0(g gVar, StringBuilder sb) {
        sb.append(m.a(gVar.getClass()));
        return sb.toString();
    }

    public static long J(long j, long j2, long j3, long j4) {
        return (j * j2) + j3 + j4;
    }

    public static String J0(j jVar, StringBuilder sb) {
        sb.append(m.a(jVar.getClass()));
        return sb.toString();
    }

    public static Intent K(String str, String str2, String str3, String str4) {
        Intent intent = new Intent(str);
        intent.setType(str2);
        intent.putExtra(str3, str4);
        return intent;
    }

    public static String K0(s0.a.a.s sVar, StringBuilder sb) {
        sb.append(sVar.size());
        return sb.toString();
    }

    public static Spanned L(Object[] objArr, int i, String str, String str2, int i2, String str3) {
        String format = String.format(str, Arrays.copyOf(objArr, i));
        i.d(format, str2);
        Spanned fromHtml = Html.fromHtml(format, i2);
        i.d(fromHtml, str3);
        return fromHtml;
    }

    public static String L0(s0.a.b.i iVar, StringBuilder sb) {
        sb.append(iVar.getClass().getName());
        return sb.toString();
    }

    public static int M(int i, int i2, int i3) {
        return (Integer.hashCode(i) + i2) * i3;
    }

    public static String M0(ConfigurableProvider configurableProvider, String str, String str2, String str3, String str4) {
        configurableProvider.addAlgorithm(str, str2);
        return str3 + str4;
    }

    public static Api.Parameter N(String str) {
        return new Api.Parameter().setName(str);
    }

    public static StringBuilder N0(char c) {
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        return sb;
    }

    public static Api.Parameter O(String str, Class cls) {
        return new Api.Parameter().setName(str).setType(cls);
    }

    public static int O0(int i, int i2, int i3, u uVar, int i4, int i5) {
        return uVar.i(i + i2 + i3, i4) + i5;
    }

    public static PubNubError P(int i, String str) {
        return PubNubError.builder().errorCode(i).message(str).build();
    }

    public static StringBuilder P0(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static String Q(int i, String str, int i2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        return sb.toString();
    }

    public static StringBuilder Q0(String str, int i, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    public static String R(int i, StringBuilder sb) {
        sb.append(Integer.toHexString(i));
        return sb.toString();
    }

    public static StringBuilder R0(String str, int i, String str2, int i2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i);
        sb.append(str2);
        sb.append(i2);
        sb.append(str3);
        return sb;
    }

    public static String S(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.exceptionLabel());
        return sb.toString();
    }

    public static StringBuilder S0(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    public static String T(ChannelFragment channelFragment, int i, String str) {
        String string = channelFragment.getResources().getString(i);
        i.d(string, str);
        return string;
    }

    public static StringBuilder T0(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static String U(RequestResponse requestResponse, StringBuilder sb) {
        sb.append(requestResponse.getResponseCode());
        return sb.toString();
    }

    public static StringBuilder U0(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        sb.append(str5);
        return sb;
    }

    public static String V(IOException iOException, StringBuilder sb) {
        sb.append(iOException.getMessage());
        return sb.toString();
    }

    public static StringBuilder V0(String str, String str2, ConfigurableProvider configurableProvider, String str3, String str4) {
        configurableProvider.addAlgorithm(str3, str + str2);
        StringBuilder sb = new StringBuilder();
        sb.append(str4);
        return sb;
    }

    public static String W(Class cls, StringBuilder sb) {
        sb.append(cls.getName());
        return sb.toString();
    }

    public static StringBuilder W0(String str, g gVar, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(gVar);
        sb.append(str2);
        return sb;
    }

    public static int X(int i, int i2, int i3, int i4) {
        return i + i2 + i3 + i4;
    }

    public static StringBuilder X0(String str, j jVar, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(jVar);
        sb.append(str2);
        return sb;
    }

    public static String Y(Class cls, StringBuilder sb, String str) {
        sb.append(cls.getName());
        sb.append(str);
        return sb.toString();
    }

    public static StringBuilder Y0(StringBuilder sb, String str, String str2, ConfigurableProvider configurableProvider, String str3) {
        sb.append(str);
        sb.append(str2);
        configurableProvider.addAlgorithm(str3, sb.toString());
        return new StringBuilder();
    }

    public static String Z(Class cls, StringBuilder sb, String str, String str2) {
        sb.append(cls.getSimpleName());
        sb.append(str);
        sb.append(cls.getSimpleName());
        sb.append(str2);
        return sb.toString();
    }

    public static int Z0(int i, int i2, s sVar, int i3, int i4) {
        return sVar.i(i + i2, i3) + i4;
    }

    public static float a(float f, float f2, float f3, float f4) {
        return ((f - f2) * f3) + f4;
    }

    public static String a0(Exception exc, StringBuilder sb) {
        sb.append(exc.getMessage());
        return sb.toString();
    }

    public static StringBuilder a1(StringBuilder sb, String str, ConfigurableProvider configurableProvider, String str2, String str3) {
        sb.append(str);
        configurableProvider.addAlgorithm(sb.toString(), str2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str3);
        return sb2;
    }

    public static float b(RectF rectF, float f, float f2) {
        return (rectF.height() * f) + f2;
    }

    public static String b0(Exception exc, StringBuilder sb) {
        sb.append(exc.toString());
        return sb.toString();
    }

    public static StringBuilder b1(StringBuilder sb, String str, ConfigurableProvider configurableProvider, String str2, String str3) {
        sb.append(str);
        configurableProvider.addAlgorithm(str2, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str3);
        return sb2;
    }

    public static int c(long j, BigInteger bigInteger) {
        return bigInteger.mod(BigInteger.valueOf(j)).intValue();
    }

    public static String c0(Object obj, StringBuilder sb) {
        sb.append(obj.getClass().getName());
        return sb.toString();
    }

    public static StringBuilder c1(StringBuilder sb, String str, ConfigurableProvider configurableProvider, String str2, n nVar) {
        sb.append(str);
        configurableProvider.addAlgorithm(str2, nVar, sb.toString());
        return new StringBuilder();
    }

    public static void d(int i, StringBuilder sb, String str) {
        sb.append(Integer.toHexString(i));
        sb.append(str);
    }

    public static String d0(Object obj, StringBuilder sb, String str) {
        sb.append(obj.getClass().getName());
        sb.append(str);
        return sb.toString();
    }

    public static StringBuilder d1(StringBuilder sb, n nVar, ConfigurableProvider configurableProvider, String str, String str2) {
        sb.append(nVar);
        configurableProvider.addAlgorithm(sb.toString(), str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        return sb2;
    }

    public static void e(Context context, int i, Intent intent) {
        context.startActivity(Intent.createChooser(intent, context.getString(i)));
    }

    public static String e0(String str, int i) {
        return str + i;
    }

    public static StringBuilder e1(ConfigurableProvider configurableProvider, String str, String str2, String str3) {
        configurableProvider.addAlgorithm(str, str2);
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        return sb;
    }

    public static void f(SharedPreferences sharedPreferences, String str, boolean z) {
        sharedPreferences.edit().putBoolean(str, z).apply();
    }

    public static String f0(String str, int i, int i2) {
        return str.substring(str.indexOf(i) + i2);
    }

    public static StringBuilder f1(ConfigurableProvider configurableProvider, String str, String str2, String str3, String str4) {
        configurableProvider.addAlgorithm(str, str2);
        configurableProvider.addAlgorithm(str3, str4);
        return new StringBuilder();
    }

    public static void g(SQLiteDatabase sQLiteDatabase) {
        new i0.j.e.l0.k.a.b.b.a().a(sQLiteDatabase);
    }

    public static String g0(String str, int i, String str2) {
        return str + i + str2;
    }

    public static StringBuilder g1(ConfigurableProvider configurableProvider, String str, n nVar, String str2, String str3) {
        configurableProvider.addAlgorithm(str, nVar, str2);
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        return sb;
    }

    public static void h(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String str4) {
        sQLiteDatabase.execSQL(str);
        sQLiteDatabase.execSQL(str2);
        sQLiteDatabase.execSQL(str3);
        sQLiteDatabase.execSQL(str4);
    }

    public static String h0(String str, int i, String str2, int i2) {
        return str + i + str2 + i2;
    }

    public static ArrayList h1(int i, HashMap hashMap, ArrayList arrayList, int i2, String str) {
        hashMap.put(Integer.valueOf(i), arrayList);
        ArrayList arrayList2 = new ArrayList(i2);
        arrayList2.add(str);
        return arrayList2;
    }

    public static void i(Parcel parcel, int i, Integer num) {
        parcel.writeInt(i);
        parcel.writeInt(num.intValue());
    }

    public static int i0(int i, int i2, int i3, o oVar, int i4) {
        return oVar.l(i + i2 + i3, i4);
    }

    public static ArrayList i1(Resources resources, String str, Object[] objArr, String str2, int i) {
        i.e(resources, str);
        i.e(objArr, str2);
        return new ArrayList(i);
    }

    public static void j(d.a aVar, String str, int i, int i2) {
        i.e(aVar, str);
        AlertController.b bVar = aVar.a;
        bVar.d = bVar.a.getText(i);
        AlertController.b bVar2 = aVar.a;
        bVar2.f = bVar2.a.getText(i2);
    }

    public static String j0(String str, int i, String str2, int i2, String str3) {
        return str + i + str2 + i2 + str3;
    }

    public static ArrayList j1(ArrayList arrayList, String str, int i, HashMap hashMap, ArrayList arrayList2, int i2) {
        arrayList.add(str);
        hashMap.put(Integer.valueOf(i), arrayList2);
        return new ArrayList(i2);
    }

    public static void k(Fragment fragment, StringBuilder sb, String str) {
        sb.append(fragment.getClass().getSimpleName());
        sb.append(str);
    }

    public static String k0(String str, long j) {
        return str + j;
    }

    public static int k1(int i, int i2, u uVar, int i3, int i4) {
        return uVar.i(i + i2, i3) + i4;
    }

    public static void l(ActionableNotification actionableNotification, ActivityViewModel activityViewModel) {
        activityViewModel.p(new f0(actionableNotification));
    }

    public static String l0(String str, long j, String str2) {
        return str + j + str2;
    }

    public static Iterator l1(Parcel parcel, int i, Map map) {
        parcel.writeInt(i);
        parcel.writeInt(map.size());
        return map.entrySet().iterator();
    }

    public static void m(HalfClubRulesArgs halfClubRulesArgs, String str, HalfClubRulesArgs halfClubRulesArgs2, ClubFragment clubFragment, q qVar, int i) {
        i.e(halfClubRulesArgs, str);
        v.a1(clubFragment, new k1(halfClubRulesArgs2), qVar, i);
    }

    public static String m0(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static Map m1(String str, Integer num) {
        return h.S2(new Pair(str, num));
    }

    public static int n(Parcelable.Creator creator, Parcel parcel, ArrayList arrayList, int i, int i2) {
        arrayList.add(creator.createFromParcel(parcel));
        return i + i2;
    }

    public static String n0(String str, String str2) {
        return str + str2;
    }

    public static Map n1(String str, String str2) {
        return h.S2(new Pair(str, str2));
    }

    public static void o(DatabaseManager databaseManager, String str) {
        SQLiteDatabaseWrapper openDatabase = databaseManager.openDatabase();
        openDatabase.execSQL(str);
        openDatabase.close();
    }

    public static String o0(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static m0.r.j o1(Class cls, String str, String str2, int i) {
        return m.b(new MutablePropertyReference1Impl(cls, str, str2, i));
    }

    public static void p(Class cls, StringBuilder sb, String str) {
        sb.append(cls.getName());
        sb.append(str);
    }

    public static String p0(String str, String str2, String str3, int i) {
        i.e(str, str2);
        return Html.fromHtml(str3, i).toString();
    }

    public static ProtoBuf$Type p1(ProtoBuf$Type protoBuf$Type, ProtoBuf$Type protoBuf$Type2) {
        ProtoBuf$Type.b F = ProtoBuf$Type.F(protoBuf$Type);
        F.j(protoBuf$Type2);
        return F.m();
    }

    public static void q(String str, String str2, ConfigurableProvider configurableProvider, String str3, n nVar) {
        configurableProvider.addAlgorithm(str3, nVar, str + str2);
    }

    public static String q0(String str, Type type) {
        return str + type;
    }

    public static n q1(String str) {
        return new n(str).E();
    }

    public static void r(StringBuilder sb, String str, char c, String str2) {
        sb.append(str);
        sb.append(c);
        sb.append(str2);
    }

    public static String r0(String str, n nVar, String str2) {
        return str + nVar + str2;
    }

    public static n r1(n nVar, n nVar2, String str) {
        Objects.requireNonNull(nVar);
        return new n(nVar2, str);
    }

    public static void s(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
    }

    public static String s0(StringBuilder sb, int i, char c) {
        sb.append(i);
        sb.append(c);
        return sb.toString();
    }

    public static s0.a.e.b.g s1(s0.a.e.b.g gVar, s0.a.e.b.g gVar2, s0.a.e.b.g gVar3) {
        return gVar.o().a(gVar2).a(gVar3);
    }

    public static void t(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        Log.w(str4, sb.toString());
    }

    public static int t0(int i, int i2, int i3, p pVar, int i4, int i5) {
        return pVar.m(i + i2 + i3, i4) + i5;
    }

    public static void t1(int i, int i2, n nVar, HashMap hashMap, Integer num) {
        hashMap.put(num, new s0.a.f.b.h.o(i, i2, nVar));
    }

    public static void u(StringBuilder sb, String str, String str2, ConfigurableProvider configurableProvider, String str3) {
        sb.append(str);
        sb.append(str2);
        configurableProvider.addAlgorithm(str3, sb.toString());
    }

    public static String u0(StringBuilder sb, int i, String str) {
        sb.append(i);
        sb.append(str);
        return sb.toString();
    }

    public static void u1(int i, String str, HashMap hashMap, String str2) {
        hashMap.put(str2, new s0.a.f.b.h.a(i, str));
    }

    public static void v(StringBuilder sb, String str, ConfigurableProvider configurableProvider, String str2) {
        sb.append(str);
        configurableProvider.addAlgorithm(str2, sb.toString());
    }

    public static String v0(StringBuilder sb, Integer num, char c) {
        sb.append(num);
        sb.append(c);
        return sb.toString();
    }

    public static void w(StringBuilder sb, n nVar, ConfigurableProvider configurableProvider, String str) {
        sb.append(nVar);
        configurableProvider.addAlgorithm(sb.toString(), str);
    }

    public static String w0(StringBuilder sb, String str, char c) {
        sb.append((Object) str);
        sb.append(c);
        return sb.toString();
    }

    public static void x(HashSet hashSet, String str, String str2, String str3, String str4) {
        hashSet.add(str);
        hashSet.add(str2);
        hashSet.add(str3);
        hashSet.add(str4);
    }

    public static String x0(StringBuilder sb, String str, char c) {
        sb.append(str);
        sb.append(c);
        return sb.toString();
    }

    public static int y(Class cls, Parcel parcel, LinkedHashMap linkedHashMap, String str, int i, int i2) {
        linkedHashMap.put(str, parcel.readValue(cls.getClassLoader()));
        return i + i2;
    }

    public static String y0(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static boolean z(Method method, String str, String str2) {
        i.d(method, str);
        return i.a(method.getName(), str2);
    }

    public static String z0(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }
}
