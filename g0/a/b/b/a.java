package g0.a.b.b;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Process;
import android.os.StrictMode;
import android.os.Trace;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.Property;
import android.util.Size;
import android.util.SizeF;
import android.util.TypedValue;
import android.util.Xml;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.activity.OnBackPressedDispatcher;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.app.AppOpsManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.CoroutineLiveData;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2;
import androidx.navigation.NavController;
import androidx.navigation.R;
import androidx.navigation.fragment.NavHostFragment;
import androidx.paging.CachedPagingDataKt$cachedIn$$inlined$map$1;
import androidx.paging.CachedPagingDataKt$cachedIn$$inlined$map$2;
import androidx.paging.CachedPagingDataKt$cachedIn$1;
import androidx.paging.CachedPagingDataKt$cachedIn$multicastedFlow$2;
import androidx.paging.CachedPagingDataKt$cachedIn$multicastedFlow$4;
import androidx.paging.CachedPagingDataKt$cachedIn$multicastedFlow$5;
import androidx.paging.DiffingChangePayload;
import androidx.paging.FlowExtKt$simpleRunningReduce$1;
import androidx.paging.PageEvent;
import androidx.paging.PagingDataTransforms$filter$$inlined$transform$1;
import androidx.paging.PagingDataTransforms$insertHeaderItem$1;
import androidx.paging.PagingDataTransforms$map$$inlined$transform$1;
import androidx.paging.SeparatorState;
import androidx.paging.SeparatorsKt$insertEventSeparators$$inlined$map$1;
import androidx.paging.SeparatorsKt$insertEventSeparators$separatorState$1;
import androidx.paging.SeparatorsKt$insertInternalSeparators$1;
import androidx.paging.SimpleChannelFlowKt$simpleChannelFlow$1;
import androidx.paging.TerminalSeparatorType;
import androidx.recyclerview.widget.RecyclerView;
import com.instabug.library.model.StepType;
import com.instabug.library.network.RequestResponse;
import g0.a.b.b.a;
import h0.b.f.d1;
import h0.b.f.z0;
import h0.g.a.h.e;
import h0.g.a.h.g;
import h0.g.a.h.k.m;
import h0.i.b.d.b;
import h0.i.b.d.f;
import h0.i.g.b;
import h0.i.i.j;
import h0.i.i.k;
import h0.i.j.d;
import h0.q.j0;
import h0.q.k0;
import h0.q.l0;
import h0.q.m0;
import h0.q.n0;
import h0.q.w;
import h0.u.c0;
import h0.u.n;
import h0.u.o;
import h0.v.a.g;
import h0.v.a.r;
import h0.v.a.v;
import i0.j.f.p.h;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import kotlin.Pair;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1;
import m0.l.c;
import m0.l.e;
import m0.n.a.l;
import m0.n.a.p;
import m0.n.a.q;
import m0.n.b.i;
import n0.a.d0;
import n0.a.f0;
import n0.a.g2.s;
import n0.a.m0;
import n0.a.x;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: MediaDescriptionCompatApi21.java */
/* loaded from: classes.dex */
public class a {
    public static Field a;
    public static boolean b;
    public static Class<?> c;
    public static boolean d;
    public static Field e;
    public static boolean f;
    public static Field g;
    public static boolean h;
    public static long i;
    public static Method j;

    public static <X> LiveData<X> A(LiveData<X> liveData) {
        w wVar = new w();
        wVar.a(liveData, new j0(wVar));
        return wVar;
    }

    public static void A0(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i2 = 1;
        while (i2 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i2++;
            } else if (next == 3) {
                i2--;
            }
        }
    }

    public static final <T> h0.u.w<T> B(h0.u.w<T> wVar, p<? super T, ? super c<? super Boolean>, ? extends Object> pVar) {
        i.e(wVar, "$this$filter");
        i.e(pVar, "predicate");
        return new h0.u.w<>(new PagingDataTransforms$filter$$inlined$transform$1(wVar.d, pVar), wVar.e);
    }

    public static List<byte[]> B0(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }

    public static m C(ConstraintWidget constraintWidget, int i2, ArrayList<m> arrayList, m mVar) {
        int i3;
        int i4;
        if (i2 == 0) {
            i3 = constraintWidget.K0;
        } else {
            i3 = constraintWidget.L0;
        }
        int i5 = 0;
        if (i3 != -1 && (mVar == null || i3 != mVar.c)) {
            int i6 = 0;
            while (true) {
                if (i6 >= arrayList.size()) {
                    break;
                }
                m mVar2 = arrayList.get(i6);
                if (mVar2.c == i3) {
                    if (mVar != null) {
                        mVar.d(i2, mVar2);
                        arrayList.remove(mVar);
                    }
                    mVar = mVar2;
                } else {
                    i6++;
                }
            }
        } else if (i3 != -1) {
            return mVar;
        }
        if (mVar == null) {
            if (constraintWidget instanceof g) {
                g gVar = (g) constraintWidget;
                int i7 = 0;
                while (true) {
                    if (i7 >= gVar.N0) {
                        i4 = -1;
                        break;
                    }
                    ConstraintWidget constraintWidget2 = gVar.M0[i7];
                    if ((i2 == 0 && (i4 = constraintWidget2.K0) != -1) || (i2 == 1 && (i4 = constraintWidget2.L0) != -1)) {
                        break;
                    }
                    i7++;
                }
                if (i4 != -1) {
                    int i8 = 0;
                    while (true) {
                        if (i8 >= arrayList.size()) {
                            break;
                        }
                        m mVar3 = arrayList.get(i8);
                        if (mVar3.c == i4) {
                            mVar = mVar3;
                            break;
                        }
                        i8++;
                    }
                }
            }
            if (mVar == null) {
                mVar = new m(i2);
            }
            arrayList.add(mVar);
        }
        if (mVar.a(constraintWidget)) {
            if (constraintWidget instanceof e) {
                e eVar = (e) constraintWidget;
                ConstraintAnchor constraintAnchor = eVar.P0;
                if (eVar.Q0 == 0) {
                    i5 = 1;
                }
                constraintAnchor.c(i5, arrayList, mVar);
            }
            if (i2 == 0) {
                constraintWidget.K0 = mVar.c;
                constraintWidget.K.c(i2, arrayList, mVar);
                constraintWidget.M.c(i2, arrayList, mVar);
            } else {
                constraintWidget.L0 = mVar.c;
                constraintWidget.L.c(i2, arrayList, mVar);
                constraintWidget.O.c(i2, arrayList, mVar);
                constraintWidget.N.c(i2, arrayList, mVar);
            }
            constraintWidget.R.c(i2, arrayList, mVar);
        }
        return mVar;
    }

    public static final int C0(o<?> oVar, n nVar, o<?> oVar2, int i2) {
        int a2;
        i.e(oVar, "$this$transformAnchorIndex");
        i.e(nVar, "diffResult");
        i.e(oVar2, "newList");
        if (!nVar.b) {
            return m0.q.i.c(i2, m0.q.i.f(0, oVar2.e()));
        }
        int b2 = i2 - oVar.b();
        int a3 = oVar.a();
        if (b2 >= 0 && a3 > b2) {
            for (int i3 = 0; i3 <= 29; i3++) {
                int i4 = i3 / 2;
                int i5 = 1;
                if (i3 % 2 == 1) {
                    i5 = -1;
                }
                int i6 = (i4 * i5) + b2;
                if (i6 >= 0 && i6 < oVar.a() && (a2 = nVar.a.a(i6)) != -1) {
                    return oVar2.b() + a2;
                }
            }
        }
        return m0.q.i.c(i2, m0.q.i.f(0, oVar2.e()));
    }

    public static m D(ArrayList<m> arrayList, int i2) {
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            m mVar = arrayList.get(i3);
            if (i2 == mVar.c) {
                return mVar;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T D0(Drawable drawable) {
        return drawable instanceof h0.i.c.m.a ? (T) ((h0.i.c.m.a) drawable).b() : drawable;
    }

    public static final NavController E(Activity activity, int i2) {
        i.f(activity, "$this$findNavController");
        NavController H = H(ActivityCompat.requireViewById(activity, i2));
        if (H != null) {
            i.b(H, "Navigation.findNavController(this, viewId)");
            return H;
        }
        throw new IllegalStateException("Activity " + activity + " does not have a NavController set on " + i2);
    }

    public static boolean E0(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, ConstraintWidget.DimensionBehaviour dimensionBehaviour3, ConstraintWidget.DimensionBehaviour dimensionBehaviour4) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour6;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.FIXED;
        return (dimensionBehaviour3 == dimensionBehaviour7 || dimensionBehaviour3 == (dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour != dimensionBehaviour6)) || (dimensionBehaviour4 == dimensionBehaviour7 || dimensionBehaviour4 == (dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour2 != dimensionBehaviour5));
    }

    public static NavController F(View view) {
        NavController H = H(view);
        if (H != null) {
            return H;
        }
        throw new IllegalStateException("View " + view + " does not have a NavController set");
    }

    public static final <T> Object F0(Lifecycle lifecycle, Lifecycle.State state, p<? super f0, ? super c<? super T>, ? extends Object> pVar, c<? super T> cVar) {
        d0 d0Var = m0.a;
        return m0.r.t.a.r.m.a1.a.k4(n0.a.h2.o.c.T(), new PausingDispatcherKt$whenStateAtLeast$2(lifecycle, state, pVar, null), cVar);
    }

    public static final NavController G(Fragment fragment) {
        i.f(fragment, "$this$findNavController");
        NavController I0 = NavHostFragment.I0(fragment);
        i.b(I0, "NavHostFragment.findNavController(this)");
        return I0;
    }

    public static ActionMode.Callback G0(TextView textView, ActionMode.Callback callback) {
        int i2 = Build.VERSION.SDK_INT;
        return (i2 < 26 || i2 > 27 || (callback instanceof d) || callback == null) ? callback : new d(callback, textView);
    }

    public static NavController H(View view) {
        NavController navController;
        while (view != null) {
            Object tag = view.getTag(R.id.nav_controller_view_tag);
            if (tag instanceof WeakReference) {
                navController = (NavController) ((WeakReference) tag).get();
            } else {
                navController = tag instanceof NavController ? (NavController) tag : null;
            }
            if (navController != null) {
                return navController;
            }
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    public static void I(Object obj) {
        if (!d) {
            try {
                c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e2) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e2);
            }
            d = true;
        }
        Class<?> cls = c;
        if (cls != null) {
            if (!f) {
                try {
                    Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                    e = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e3) {
                    Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e3);
                }
                f = true;
            }
            Field field = e;
            if (field != null) {
                LongSparseArray longSparseArray = null;
                try {
                    longSparseArray = (LongSparseArray) field.get(obj);
                } catch (IllegalAccessException e4) {
                    Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e4);
                }
                if (longSparseArray != null) {
                    longSparseArray.clear();
                }
            }
        }
    }

    public static int J(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        return cursor.getColumnIndexOrThrow("`" + str + "`");
    }

    public static String K() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder P0 = i0.d.a.a.a.P0(".(");
        P0.append(stackTraceElement.getFileName());
        P0.append(":");
        P0.append(stackTraceElement.getLineNumber());
        P0.append(") ");
        P0.append(stackTraceElement.getMethodName());
        P0.append("()");
        return P0.toString();
    }

    public static h0.i.e.c L(Configuration configuration) {
        return h0.i.e.c.c(configuration.getLocales());
    }

    public static String M() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        StringBuilder P0 = i0.d.a.a.a.P0(".(");
        P0.append(stackTraceElement.getFileName());
        P0.append(":");
        P0.append(stackTraceElement.getLineNumber());
        P0.append(")");
        return P0.toString();
    }

    public static String N(Context context, int i2) {
        if (i2 == -1) {
            return StepType.UNKNOWN;
        }
        try {
            return context.getResources().getResourceEntryName(i2);
        } catch (Exception unused) {
            return i0.d.a.a.a.e0("?", i2);
        }
    }

    public static String O(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return StepType.UNKNOWN;
        }
    }

    public static b P(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i2, int i3) {
        b bVar;
        if (U(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i2, typedValue);
            int i4 = typedValue.type;
            if (i4 >= 28 && i4 <= 31) {
                return new b(null, null, typedValue.data);
            }
            try {
                bVar = b.a(typedArray.getResources(), typedArray.getResourceId(i2, 0), theme);
            } catch (Exception e2) {
                Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e2);
                bVar = null;
            }
            if (bVar != null) {
                return bVar;
            }
        }
        return new b(null, null, i3);
    }

    public static String Q(MotionLayout motionLayout, int i2) {
        if (i2 == -1) {
            return "UNDEFINED";
        }
        return motionLayout.getContext().getResources().getResourceEntryName(i2);
    }

    public static File R(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        StringBuilder P0 = i0.d.a.a.a.P0(".font");
        P0.append(Process.myPid());
        P0.append("-");
        P0.append(Process.myTid());
        P0.append("-");
        String sb = P0.toString();
        for (int i2 = 0; i2 < 100; i2++) {
            File file = new File(cacheDir, i0.d.a.a.a.e0(sb, i2));
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }

    public static b.a S(TextView textView) {
        TextDirectionHeuristic textDirectionHeuristic;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return new b.a(textView.getTextMetricsParams());
        }
        TextPaint textPaint = new TextPaint(textView.getPaint());
        TextDirectionHeuristic textDirectionHeuristic2 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        int breakStrategy = textView.getBreakStrategy();
        int hyphenationFrequency = textView.getHyphenationFrequency();
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
        } else {
            boolean z = false;
            if (i2 < 28 || (textView.getInputType() & 15) != 3) {
                if (textView.getLayoutDirection() == 1) {
                    z = true;
                }
                switch (textView.getTextDirection()) {
                    case 2:
                        textDirectionHeuristic = TextDirectionHeuristics.ANYRTL_LTR;
                        break;
                    case 3:
                        textDirectionHeuristic = TextDirectionHeuristics.LTR;
                        break;
                    case 4:
                        textDirectionHeuristic = TextDirectionHeuristics.RTL;
                        break;
                    case 5:
                        textDirectionHeuristic = TextDirectionHeuristics.LOCALE;
                        break;
                    case 6:
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                        break;
                    case 7:
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                        break;
                    default:
                        if (!z) {
                            textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                            break;
                        } else {
                            textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                            break;
                        }
                }
            } else {
                byte directionality = Character.getDirectionality(DecimalFormatSymbols.getInstance(textView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
                if (directionality == 1 || directionality == 2) {
                    textDirectionHeuristic = TextDirectionHeuristics.RTL;
                } else {
                    textDirectionHeuristic = TextDirectionHeuristics.LTR;
                }
            }
        }
        return new b.a(textPaint, textDirectionHeuristic, breakStrategy, hyphenationFrequency);
    }

    public static final f0 T(k0 k0Var) {
        i.e(k0Var, "$this$viewModelScope");
        f0 f0Var = (f0) k0Var.getTag("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY");
        if (f0Var != null) {
            return f0Var;
        }
        x z = m0.r.t.a.r.m.a1.a.z(null, 1);
        d0 d0Var = m0.a;
        Object tagIfAbsent = k0Var.setTagIfAbsent("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY", new h0.q.e(e.a.C0244a.d((JobSupport) z, n0.a.h2.o.c.T())));
        i.d(tagIfAbsent, "setTagIfAbsent(\n        …Main.immediate)\n        )");
        return (f0) tagIfAbsent;
    }

    public static boolean U(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static int V(int i2) {
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2) {
            return 1;
        }
        if (i2 == 4) {
            return 2;
        }
        if (i2 == 8) {
            return 3;
        }
        if (i2 == 16) {
            return 4;
        }
        if (i2 == 32) {
            return 5;
        }
        if (i2 == 64) {
            return 6;
        }
        if (i2 == 128) {
            return 7;
        }
        if (i2 == 256) {
            return 8;
        }
        throw new IllegalArgumentException(i0.d.a.a.a.e0("type needs to be >= FIRST and <= LAST, type=", i2));
    }

    public static h0.u.w W(h0.u.w wVar, TerminalSeparatorType terminalSeparatorType, Object obj, int i2) {
        TerminalSeparatorType terminalSeparatorType2 = (i2 & 1) != 0 ? TerminalSeparatorType.FULLY_COMPLETE : null;
        i.e(wVar, "$this$insertHeaderItem");
        i.e(terminalSeparatorType2, "terminalSeparatorType");
        i.e(obj, "item");
        PagingDataTransforms$insertHeaderItem$1 pagingDataTransforms$insertHeaderItem$1 = new PagingDataTransforms$insertHeaderItem$1(obj, null);
        i.e(wVar, "$this$insertSeparators");
        i.e(terminalSeparatorType2, "terminalSeparatorType");
        i.e(pagingDataTransforms$insertHeaderItem$1, "generator");
        n0.a.g2.d<PageEvent<T>> dVar = wVar.d;
        i.e(dVar, "$this$insertEventSeparators");
        i.e(terminalSeparatorType2, "terminalSeparatorType");
        i.e(pagingDataTransforms$insertHeaderItem$1, "generator");
        return new h0.u.w(new SeparatorsKt$insertEventSeparators$$inlined$map$1(dVar, new SeparatorState(terminalSeparatorType2, new SeparatorsKt$insertEventSeparators$separatorState$1(pagingDataTransforms$insertHeaderItem$1, null))), wVar.e);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e9  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static final <R, T extends R> Object X(h0.u.f0<T> f0Var, q<? super T, ? super T, ? super c<? super R>, ? extends Object> qVar, c<? super h0.u.f0<R>> cVar) {
        SeparatorsKt$insertInternalSeparators$1 separatorsKt$insertInternalSeparators$1;
        int i2;
        int i3;
        SeparatorsKt$insertInternalSeparators$1 separatorsKt$insertInternalSeparators$12;
        q<? super T, ? super T, ? super c<? super R>, ? extends Object> qVar2;
        int i4;
        CoroutineSingletons coroutineSingletons;
        ArrayList arrayList;
        ArrayList arrayList2;
        h0.u.f0<T> f0Var2;
        Integer num;
        if (cVar instanceof SeparatorsKt$insertInternalSeparators$1) {
            separatorsKt$insertInternalSeparators$1 = (SeparatorsKt$insertInternalSeparators$1) cVar;
            int i5 = separatorsKt$insertInternalSeparators$1.d;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                separatorsKt$insertInternalSeparators$1.d = i5 - Integer.MIN_VALUE;
                Object obj = separatorsKt$insertInternalSeparators$1.c;
                CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                i2 = separatorsKt$insertInternalSeparators$1.d;
                if (i2 != 0) {
                    h.d4(obj);
                    if (f0Var.d.isEmpty()) {
                        return f0Var;
                    }
                    int size = f0Var.d.size() + 4;
                    ArrayList arrayList3 = new ArrayList(size);
                    arrayList = new ArrayList(size);
                    arrayList3.add(m0.j.g.u(f0Var.d));
                    List<Integer> list = f0Var.f;
                    arrayList.add(new Integer((list == null || (num = (Integer) m0.j.g.u(list)) == null) ? 0 : num.intValue()));
                    i3 = f0Var.d.size();
                    arrayList2 = arrayList3;
                    coroutineSingletons = coroutineSingletons2;
                    separatorsKt$insertInternalSeparators$12 = separatorsKt$insertInternalSeparators$1;
                    qVar2 = qVar;
                    f0Var2 = f0Var;
                    i4 = 1;
                    if (i4 < i3) {
                    }
                } else if (i2 == 1) {
                    i3 = separatorsKt$insertInternalSeparators$1.b2;
                    int i6 = separatorsKt$insertInternalSeparators$1.a2;
                    Object obj2 = separatorsKt$insertInternalSeparators$1.Z1;
                    ArrayList arrayList4 = (ArrayList) separatorsKt$insertInternalSeparators$1.Y1;
                    ArrayList arrayList5 = (ArrayList) separatorsKt$insertInternalSeparators$1.y;
                    qVar2 = (q) separatorsKt$insertInternalSeparators$1.x;
                    h0.u.f0<T> f0Var3 = (h0.u.f0) separatorsKt$insertInternalSeparators$1.q;
                    h.d4(obj);
                    separatorsKt$insertInternalSeparators$12 = separatorsKt$insertInternalSeparators$1;
                    CoroutineSingletons coroutineSingletons3 = coroutineSingletons2;
                    if (obj != null) {
                        arrayList5.add(obj);
                        arrayList4.add(new Integer(i6));
                    }
                    arrayList5.add(obj2);
                    arrayList4.add(new Integer(i6));
                    i4 = i6 + 1;
                    coroutineSingletons = coroutineSingletons3;
                    arrayList = arrayList4;
                    arrayList2 = arrayList5;
                    f0Var2 = f0Var3;
                    if (i4 < i3) {
                        Object obj3 = f0Var2.d.get(i4);
                        separatorsKt$insertInternalSeparators$12.q = f0Var2;
                        separatorsKt$insertInternalSeparators$12.x = qVar2;
                        separatorsKt$insertInternalSeparators$12.y = arrayList2;
                        separatorsKt$insertInternalSeparators$12.Y1 = arrayList;
                        separatorsKt$insertInternalSeparators$12.Z1 = obj3;
                        separatorsKt$insertInternalSeparators$12.a2 = i4;
                        separatorsKt$insertInternalSeparators$12.b2 = i3;
                        separatorsKt$insertInternalSeparators$12.d = 1;
                        Object invoke = qVar2.invoke((T) f0Var2.d.get(i4 - 1), obj3, separatorsKt$insertInternalSeparators$12);
                        if (invoke == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                        f0Var3 = f0Var2;
                        i6 = i4;
                        obj = invoke;
                        coroutineSingletons3 = coroutineSingletons;
                        obj2 = obj3;
                        arrayList5 = arrayList2;
                        arrayList4 = arrayList;
                        if (obj != null) {
                        }
                        arrayList5.add(obj2);
                        arrayList4.add(new Integer(i6));
                        i4 = i6 + 1;
                        coroutineSingletons = coroutineSingletons3;
                        arrayList = arrayList4;
                        arrayList2 = arrayList5;
                        f0Var2 = f0Var3;
                        if (i4 < i3) {
                            return arrayList2.size() == f0Var2.d.size() ? f0Var2 : new h0.u.f0(f0Var2.c, arrayList2, f0Var2.e, arrayList);
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        separatorsKt$insertInternalSeparators$1 = new ContinuationImpl(cVar) { // from class: androidx.paging.SeparatorsKt$insertInternalSeparators$1
            public Object Y1;
            public Object Z1;
            public int a2;
            public int b2;
            public /* synthetic */ Object c;
            public int d;
            public Object q;
            public Object x;
            public Object y;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj4) {
                this.c = obj4;
                this.d |= Integer.MIN_VALUE;
                return a.X(null, null, this);
            }
        };
        Object obj4 = separatorsKt$insertInternalSeparators$1.c;
        CoroutineSingletons coroutineSingletons22 = CoroutineSingletons.COROUTINE_SUSPENDED;
        i2 = separatorsKt$insertInternalSeparators$1.d;
        if (i2 != 0) {
        }
    }

    public static boolean Y(Rect rect, Rect rect2, int i2) {
        if (i2 == 17) {
            int i3 = rect.right;
            int i4 = rect2.right;
            return (i3 > i4 || rect.left >= i4) && rect.left > rect2.left;
        } else if (i2 == 33) {
            int i5 = rect.bottom;
            int i6 = rect2.bottom;
            return (i5 > i6 || rect.top >= i6) && rect.top > rect2.top;
        } else if (i2 == 66) {
            int i7 = rect.left;
            int i8 = rect2.left;
            return (i7 < i8 || rect.right <= i8) && rect.right < rect2.right;
        } else if (i2 == 130) {
            int i9 = rect.top;
            int i10 = rect2.top;
            return (i9 < i10 || rect.bottom <= i10) && rect.bottom < rect2.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    @SuppressLint({"NewApi"})
    public static boolean Z() {
        try {
            if (j == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        try {
            if (j == null) {
                i = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                j = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) j.invoke(null, Long.valueOf(i))).booleanValue();
        } catch (Exception e2) {
            if (e2 instanceof InvocationTargetException) {
                Throwable cause = e2.getCause();
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                throw new RuntimeException(cause);
            }
            Log.v("Trace", "Unable to call isTagEnabled via reflection", e2);
            return false;
        }
    }

    public static h0.a.b a(OnBackPressedDispatcher onBackPressedDispatcher, h0.q.p pVar, boolean z, l lVar, int i2) {
        if ((i2 & 1) != 0) {
            pVar = null;
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        i.e(onBackPressedDispatcher, "$this$addCallback");
        i.e(lVar, "onBackPressed");
        h0.a.c cVar = new h0.a.c(lVar, z, z);
        if (pVar != null) {
            onBackPressedDispatcher.a(pVar, cVar);
        } else {
            onBackPressedDispatcher.b.add(cVar);
            cVar.b.add(new OnBackPressedDispatcher.a(cVar));
        }
        return cVar;
    }

    public static LiveData a0(m0.l.e eVar, long j2, p pVar, int i2) {
        EmptyCoroutineContext emptyCoroutineContext = (i2 & 1) != 0 ? EmptyCoroutineContext.c : null;
        if ((i2 & 2) != 0) {
            j2 = 5000;
        }
        i.e(emptyCoroutineContext, "context");
        i.e(pVar, "block");
        return new CoroutineLiveData(emptyCoroutineContext, j2, pVar);
    }

    public static final <R, T extends R> void b(List<h0.u.f0<R>> list, R r, h0.u.f0<T> f0Var, h0.u.f0<T> f0Var2, int i2, int i3) {
        i.e(list, "$this$addSeparatorPage");
        int[] iArr = null;
        int[] iArr2 = f0Var != null ? f0Var.c : null;
        if (f0Var2 != null) {
            iArr = f0Var2.c;
        }
        if (iArr2 != null && iArr != null) {
            i.e(iArr2, "$this$plus");
            i.e(iArr, "elements");
            int length = iArr2.length;
            int length2 = iArr.length;
            int[] copyOf = Arrays.copyOf(iArr2, length + length2);
            System.arraycopy(iArr, 0, copyOf, length, length2);
            i.d(copyOf, "result");
            i.e(copyOf, "$this$distinct");
            i.e(copyOf, "$this$toMutableSet");
            LinkedHashSet linkedHashSet = new LinkedHashSet(h.R2(copyOf.length));
            i.e(copyOf, "$this$toCollection");
            i.e(linkedHashSet, "destination");
            for (int i4 : copyOf) {
                linkedHashSet.add(Integer.valueOf(i4));
            }
            iArr2 = m0.j.g.u0(m0.j.g.m0(m0.j.g.v0(linkedHashSet)));
        } else if (iArr2 == null && iArr != null) {
            iArr2 = iArr;
        } else if (iArr2 == null || iArr != null) {
            throw new IllegalArgumentException("Separator page expected adjacentPageBefore or adjacentPageAfter, but both were null.");
        }
        i.e(list, "$this$addSeparatorPage");
        i.e(iArr2, "originalPageOffsets");
        if (r != null) {
            list.add(q0(r, iArr2, i2, i3));
        }
    }

    public static h0.o.a.o b0(Context context, Fragment fragment, boolean z, boolean z2) {
        int i2;
        int i3;
        int nextTransition = fragment.getNextTransition();
        if (z2) {
            if (z) {
                i2 = fragment.getPopEnterAnim();
            } else {
                i2 = fragment.getPopExitAnim();
            }
        } else if (z) {
            i2 = fragment.getEnterAnim();
        } else {
            i2 = fragment.getExitAnim();
        }
        boolean z3 = false;
        fragment.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            int i4 = androidx.fragment.R.id.visible_removing_fragment_view_tag;
            if (viewGroup.getTag(i4) != null) {
                fragment.mContainer.setTag(i4, null);
            }
        }
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z, i2);
        if (onCreateAnimation != null) {
            return new h0.o.a.o(onCreateAnimation);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z, i2);
        if (onCreateAnimator != null) {
            return new h0.o.a.o(onCreateAnimator);
        }
        if (i2 == 0 && nextTransition != 0) {
            if (nextTransition != 4097) {
                i3 = nextTransition != 4099 ? nextTransition != 8194 ? -1 : z ? androidx.fragment.R.animator.fragment_close_enter : androidx.fragment.R.animator.fragment_close_exit : z ? androidx.fragment.R.animator.fragment_fade_enter : androidx.fragment.R.animator.fragment_fade_exit;
            } else {
                i3 = z ? androidx.fragment.R.animator.fragment_open_enter : androidx.fragment.R.animator.fragment_open_exit;
            }
            i2 = i3;
        }
        if (i2 != 0) {
            boolean equals = "anim".equals(context.getResources().getResourceTypeName(i2));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(context, i2);
                    if (loadAnimation != null) {
                        return new h0.o.a.o(loadAnimation);
                    }
                    z3 = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            }
            if (!z3) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(context, i2);
                    if (loadAnimator != null) {
                        return new h0.o.a.o(loadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, i2);
                        if (loadAnimation2 != null) {
                            return new h0.o.a.o(loadAnimation2);
                        }
                    } else {
                        throw e3;
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x01eb, code lost:
        if (r5 == r6) goto L_0x0200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x01fe, code lost:
        if (r5 == 2) goto L_0x0200;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0200, code lost:
        r22 = r21;
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0206, code lost:
        r22 = r21;
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x02df, code lost:
        if (r3[r16].f.d == r6) goto L_0x02e3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x014c, code lost:
        if (r4[r2].f.d == r5) goto L_0x0150;
     */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0498 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0502 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0592  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x05f1  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x05f3  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x05ff A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:350:0x0612  */
    /* JADX WARN: Removed duplicated region for block: B:393:0x06ce  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x070a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:406:0x0716  */
    /* JADX WARN: Removed duplicated region for block: B:407:0x0718  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x0723  */
    /* JADX WARN: Removed duplicated region for block: B:411:0x0726  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x072c  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x072f  */
    /* JADX WARN: Removed duplicated region for block: B:417:0x0733  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x0742  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x0745  */
    /* JADX WARN: Removed duplicated region for block: B:425:0x074b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:435:0x0768 A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0155  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static void c(h0.g.a.h.c cVar, h0.g.a.d dVar, ArrayList<ConstraintWidget> arrayList, int i2) {
        int i3;
        h0.g.a.h.b[] bVarArr;
        int i4;
        int i5;
        boolean z;
        int i6;
        h0.g.a.h.b[] bVarArr2;
        int i7;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        ArrayList<ConstraintWidget> arrayList2;
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        ConstraintAnchor constraintAnchor;
        ConstraintWidget constraintWidget3;
        int i8;
        ConstraintAnchor constraintAnchor2;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        int i9;
        ConstraintWidget constraintWidget4;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        ConstraintAnchor constraintAnchor5;
        ConstraintWidget constraintWidget5;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        ConstraintAnchor constraintAnchor6;
        ConstraintWidget constraintWidget6;
        int i10;
        ConstraintWidget constraintWidget7;
        ConstraintWidget constraintWidget8;
        ConstraintWidget constraintWidget9;
        ConstraintWidget constraintWidget10;
        SolverVariable solverVariable5;
        ConstraintAnchor constraintAnchor7;
        float f2;
        int size;
        int i11;
        ArrayList<ConstraintWidget> arrayList3;
        int i12;
        ConstraintWidget constraintWidget11;
        float f3;
        int i13;
        boolean z6;
        h0.g.a.h.b[] bVarArr3;
        ConstraintWidget constraintWidget12;
        ConstraintWidget constraintWidget13;
        ConstraintWidget constraintWidget14;
        int i14;
        int i15;
        int i16;
        boolean z7;
        ConstraintAnchor constraintAnchor8;
        ConstraintWidget constraintWidget15;
        int i17;
        h0.g.a.h.c cVar2 = cVar;
        ArrayList<ConstraintWidget> arrayList4 = arrayList;
        int i18 = 2;
        if (i2 == 0) {
            int i19 = cVar2.V0;
            bVarArr = cVar2.Y0;
            i4 = i19;
            i3 = 0;
        } else {
            int i20 = cVar2.W0;
            bVarArr = cVar2.X0;
            i4 = i20;
            i3 = 2;
        }
        int i21 = 0;
        while (i21 < i4) {
            h0.g.a.h.b bVar = bVarArr[i21];
            SolverVariable solverVariable6 = null;
            int i22 = 8;
            int i23 = 1;
            if (!bVar.t) {
                int i24 = bVar.o * i18;
                ConstraintWidget constraintWidget16 = bVar.a;
                ConstraintWidget constraintWidget17 = constraintWidget16;
                boolean z8 = false;
                while (!z8) {
                    bVar.i += i23;
                    ConstraintWidget[] constraintWidgetArr = constraintWidget16.H0;
                    int i25 = bVar.o;
                    constraintWidgetArr[i25] = null;
                    constraintWidget16.G0[i25] = null;
                    if (constraintWidget16.f8o0 != i22) {
                        bVar.l += i23;
                        ConstraintWidget.DimensionBehaviour p = constraintWidget16.p(i25);
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (p != dimensionBehaviour) {
                            int i26 = bVar.m;
                            int i27 = bVar.o;
                            if (i27 == 0) {
                                i17 = constraintWidget16.w();
                            } else {
                                i17 = i27 == i23 ? constraintWidget16.q() : 0;
                            }
                            bVar.m = i26 + i17;
                        }
                        int e2 = constraintWidget16.S[i24].e() + bVar.m;
                        bVar.m = e2;
                        int i28 = i24 + 1;
                        bVar.m = constraintWidget16.S[i28].e() + e2;
                        int e3 = constraintWidget16.S[i24].e() + bVar.n;
                        bVar.n = e3;
                        bVar.n = constraintWidget16.S[i28].e() + e3;
                        if (bVar.b == null) {
                            bVar.b = constraintWidget16;
                        }
                        bVar.d = constraintWidget16;
                        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget16.V;
                        int i29 = bVar.o;
                        if (dimensionBehaviourArr[i29] == dimensionBehaviour) {
                            int[] iArr = constraintWidget16.s;
                            if (iArr[i29] != 0) {
                                z7 = z8;
                                if (!(iArr[i29] == 3 || iArr[i29] == 2)) {
                                    i16 = i21;
                                    int i30 = bVar.o;
                                    if (constraintWidget17 != constraintWidget16) {
                                        constraintWidget17.H0[bVar.o] = constraintWidget16;
                                    }
                                    constraintAnchor8 = constraintWidget16.S[i24 + 1].f;
                                    if (constraintAnchor8 != null) {
                                        constraintWidget15 = constraintAnchor8.d;
                                        ConstraintAnchor[] constraintAnchorArr = constraintWidget15.S;
                                        if (constraintAnchorArr[i24].f != null) {
                                        }
                                    }
                                    constraintWidget15 = null;
                                    if (constraintWidget15 != null) {
                                        z8 = z7;
                                    } else {
                                        constraintWidget15 = constraintWidget16;
                                        z8 = true;
                                    }
                                    constraintWidget17 = constraintWidget16;
                                    i21 = i16;
                                    i23 = 1;
                                    i22 = 8;
                                    constraintWidget16 = constraintWidget15;
                                }
                            } else {
                                z7 = z8;
                            }
                            bVar.j++;
                            float[] fArr = constraintWidget16.F0;
                            float f4 = fArr[i29];
                            if (f4 > 0.0f) {
                                i16 = i21;
                                bVar.k += fArr[i29];
                            } else {
                                i16 = i21;
                            }
                            if (constraintWidget16.f8o0 != 8 && dimensionBehaviourArr[i29] == dimensionBehaviour && (iArr[i29] == 0 || iArr[i29] == 3)) {
                                if (f4 < 0.0f) {
                                    bVar.q = true;
                                } else {
                                    bVar.r = true;
                                }
                                if (bVar.h == null) {
                                    bVar.h = new ArrayList<>();
                                }
                                bVar.h.add(constraintWidget16);
                            }
                            if (bVar.f == null) {
                                bVar.f = constraintWidget16;
                            }
                            ConstraintWidget constraintWidget18 = bVar.g;
                            if (constraintWidget18 != null) {
                                constraintWidget18.G0[bVar.o] = constraintWidget16;
                            }
                            bVar.g = constraintWidget16;
                            int i302 = bVar.o;
                            if (constraintWidget17 != constraintWidget16) {
                            }
                            constraintAnchor8 = constraintWidget16.S[i24 + 1].f;
                            if (constraintAnchor8 != null) {
                            }
                            constraintWidget15 = null;
                            if (constraintWidget15 != null) {
                            }
                            constraintWidget17 = constraintWidget16;
                            i21 = i16;
                            i23 = 1;
                            i22 = 8;
                            constraintWidget16 = constraintWidget15;
                        }
                    }
                    z7 = z8;
                    i16 = i21;
                    if (constraintWidget17 != constraintWidget16) {
                    }
                    constraintAnchor8 = constraintWidget16.S[i24 + 1].f;
                    if (constraintAnchor8 != null) {
                    }
                    constraintWidget15 = null;
                    if (constraintWidget15 != null) {
                    }
                    constraintWidget17 = constraintWidget16;
                    i21 = i16;
                    i23 = 1;
                    i22 = 8;
                    constraintWidget16 = constraintWidget15;
                }
                i5 = i21;
                ConstraintWidget constraintWidget19 = bVar.b;
                if (constraintWidget19 != null) {
                    bVar.m -= constraintWidget19.S[i24].e();
                }
                ConstraintWidget constraintWidget20 = bVar.d;
                if (constraintWidget20 != null) {
                    bVar.m -= constraintWidget20.S[i24 + 1].e();
                }
                bVar.c = constraintWidget16;
                if (bVar.o != 0 || !bVar.p) {
                    bVar.e = bVar.a;
                } else {
                    bVar.e = constraintWidget16;
                }
                bVar.s = bVar.r && bVar.q;
                z = true;
            } else {
                i5 = i21;
                z = true;
            }
            bVar.t = z;
            if (arrayList4 == null || arrayList4.contains(bVar.a)) {
                ConstraintWidget constraintWidget21 = bVar.a;
                ConstraintWidget constraintWidget22 = bVar.c;
                ConstraintWidget constraintWidget23 = bVar.b;
                ConstraintWidget constraintWidget24 = bVar.d;
                ConstraintWidget constraintWidget25 = bVar.e;
                float f5 = bVar.k;
                boolean z9 = cVar2.V[i2] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (i2 == 0) {
                    int i31 = constraintWidget25.B0;
                    boolean z10 = i31 == 0;
                    if (i31 == 1) {
                        z3 = true;
                        i15 = 2;
                    } else {
                        i15 = 2;
                        z3 = false;
                    }
                    z2 = z10;
                } else {
                    int i32 = constraintWidget25.C0;
                    z2 = i32 == 0;
                    z3 = i32 == 1;
                }
                ConstraintWidget constraintWidget26 = constraintWidget21;
                boolean z11 = false;
                while (!z11) {
                    ConstraintAnchor constraintAnchor9 = constraintWidget26.S[i3];
                    int i33 = z5 ? 1 : 4;
                    int e4 = constraintAnchor9.e();
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget26.V[i2];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour2 == dimensionBehaviour3 && constraintWidget26.s[i2] == 0) {
                        i13 = i4;
                        z6 = true;
                    } else {
                        i13 = i4;
                        z6 = false;
                    }
                    ConstraintAnchor constraintAnchor10 = constraintAnchor9.f;
                    if (!(constraintAnchor10 == null || constraintWidget26 == constraintWidget21)) {
                        e4 = constraintAnchor10.e() + e4;
                    }
                    if (!z5 || constraintWidget26 == constraintWidget21 || constraintWidget26 == constraintWidget23) {
                        bVarArr3 = bVarArr;
                    } else {
                        bVarArr3 = bVarArr;
                        i33 = 8;
                    }
                    ConstraintAnchor constraintAnchor11 = constraintAnchor9.f;
                    if (constraintAnchor11 != null) {
                        if (constraintWidget26 == constraintWidget23) {
                            constraintWidget13 = constraintWidget25;
                            constraintWidget12 = constraintWidget21;
                            dVar.f(constraintAnchor9.i, constraintAnchor11.i, e4, 6);
                        } else {
                            constraintWidget13 = constraintWidget25;
                            constraintWidget12 = constraintWidget21;
                            dVar.f(constraintAnchor9.i, constraintAnchor11.i, e4, 8);
                        }
                        if (z6 && !z5) {
                            i33 = 5;
                        }
                        dVar.d(constraintAnchor9.i, constraintAnchor9.f.i, e4, (constraintWidget26 != constraintWidget23 || !z5 || !constraintWidget26.U[i2]) ? i33 : 5);
                    } else {
                        constraintWidget13 = constraintWidget25;
                        constraintWidget12 = constraintWidget21;
                    }
                    if (z9) {
                        if (constraintWidget26.f8o0 == 8 || constraintWidget26.V[i2] != dimensionBehaviour3) {
                            i14 = 0;
                        } else {
                            ConstraintAnchor[] constraintAnchorArr2 = constraintWidget26.S;
                            i14 = 0;
                            dVar.f(constraintAnchorArr2[i3 + 1].i, constraintAnchorArr2[i3].i, 0, 5);
                        }
                        dVar.f(constraintWidget26.S[i3].i, cVar2.S[i3].i, i14, 8);
                    }
                    ConstraintAnchor constraintAnchor12 = constraintWidget26.S[i3 + 1].f;
                    if (constraintAnchor12 != null) {
                        constraintWidget14 = constraintAnchor12.d;
                        ConstraintAnchor[] constraintAnchorArr3 = constraintWidget14.S;
                        if (constraintAnchorArr3[i3].f != null) {
                        }
                    }
                    constraintWidget14 = null;
                    if (constraintWidget14 != null) {
                        constraintWidget26 = constraintWidget14;
                        z11 = z11;
                    } else {
                        z11 = true;
                    }
                    bVarArr = bVarArr3;
                    i4 = i13;
                    constraintWidget25 = constraintWidget13;
                    constraintWidget21 = constraintWidget12;
                }
                i6 = i4;
                bVarArr2 = bVarArr;
                if (constraintWidget24 != null) {
                    int i34 = i3 + 1;
                    if (constraintWidget22.S[i34].f != null) {
                        ConstraintAnchor constraintAnchor13 = constraintWidget24.S[i34];
                        if ((constraintWidget24.V[i2] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget24.s[i2] == 0) && !z5) {
                            ConstraintAnchor constraintAnchor14 = constraintAnchor13.f;
                            if (constraintAnchor14.d == cVar2) {
                                dVar.d(constraintAnchor13.i, constraintAnchor14.i, -constraintAnchor13.e(), 5);
                                dVar.g(constraintAnchor13.i, constraintWidget22.S[i34].f.i, -constraintAnchor13.e(), 6);
                                if (z9) {
                                    int i35 = i3 + 1;
                                    SolverVariable solverVariable7 = cVar2.S[i35].i;
                                    ConstraintAnchor[] constraintAnchorArr4 = constraintWidget22.S;
                                    dVar.f(solverVariable7, constraintAnchorArr4[i35].i, constraintAnchorArr4[i35].e(), 8);
                                }
                                arrayList2 = bVar.h;
                                if (arrayList2 != null && (size = arrayList2.size()) > 1) {
                                    float f6 = (bVar.q || bVar.s) ? f5 : (float) bVar.j;
                                    ConstraintWidget constraintWidget27 = null;
                                    float f7 = 0.0f;
                                    i11 = 0;
                                    while (i11 < size) {
                                        ConstraintWidget constraintWidget28 = arrayList2.get(i11);
                                        float f8 = constraintWidget28.F0[i2];
                                        if (f8 < 0.0f) {
                                            if (bVar.s) {
                                                ConstraintAnchor[] constraintAnchorArr5 = constraintWidget28.S;
                                                dVar.d(constraintAnchorArr5[i3 + 1].i, constraintAnchorArr5[i3].i, 0, 4);
                                                arrayList3 = arrayList2;
                                                i12 = size;
                                                i11++;
                                                size = i12;
                                                arrayList2 = arrayList3;
                                            } else {
                                                f8 = 1.0f;
                                            }
                                        }
                                        int i36 = (f8 > 0.0f ? 1 : (f8 == 0.0f ? 0 : -1));
                                        if (i36 == 0) {
                                            ConstraintAnchor[] constraintAnchorArr6 = constraintWidget28.S;
                                            dVar.d(constraintAnchorArr6[i3 + 1].i, constraintAnchorArr6[i3].i, 0, 8);
                                            arrayList3 = arrayList2;
                                            i12 = size;
                                            i11++;
                                            size = i12;
                                            arrayList2 = arrayList3;
                                        } else {
                                            if (constraintWidget27 != null) {
                                                ConstraintAnchor[] constraintAnchorArr7 = constraintWidget27.S;
                                                SolverVariable solverVariable8 = constraintAnchorArr7[i3].i;
                                                int i37 = i3 + 1;
                                                SolverVariable solverVariable9 = constraintAnchorArr7[i37].i;
                                                ConstraintAnchor[] constraintAnchorArr8 = constraintWidget28.S;
                                                arrayList3 = arrayList2;
                                                SolverVariable solverVariable10 = constraintAnchorArr8[i3].i;
                                                SolverVariable solverVariable11 = constraintAnchorArr8[i37].i;
                                                i12 = size;
                                                h0.g.a.b m = dVar.m();
                                                constraintWidget11 = constraintWidget28;
                                                m.b = 0.0f;
                                                if (f6 == 0.0f || f7 == f8) {
                                                    f3 = f8;
                                                    m.d.d(solverVariable8, 1.0f);
                                                    m.d.d(solverVariable9, -1.0f);
                                                    m.d.d(solverVariable11, 1.0f);
                                                    m.d.d(solverVariable10, -1.0f);
                                                } else {
                                                    if (f7 == 0.0f) {
                                                        m.d.d(solverVariable8, 1.0f);
                                                        m.d.d(solverVariable9, -1.0f);
                                                    } else if (i36 == 0) {
                                                        m.d.d(solverVariable10, 1.0f);
                                                        m.d.d(solverVariable11, -1.0f);
                                                    } else {
                                                        float f9 = (f7 / f6) / (f8 / f6);
                                                        f3 = f8;
                                                        m.d.d(solverVariable8, 1.0f);
                                                        m.d.d(solverVariable9, -1.0f);
                                                        m.d.d(solverVariable11, f9);
                                                        m.d.d(solverVariable10, -f9);
                                                    }
                                                    f3 = f8;
                                                }
                                                dVar.c(m);
                                            } else {
                                                arrayList3 = arrayList2;
                                                i12 = size;
                                                f3 = f8;
                                                constraintWidget11 = constraintWidget28;
                                            }
                                            f7 = f3;
                                            constraintWidget27 = constraintWidget11;
                                            i11++;
                                            size = i12;
                                            arrayList2 = arrayList3;
                                        }
                                    }
                                }
                                if (constraintWidget23 != null || (constraintWidget23 != constraintWidget24 && !z5)) {
                                    constraintWidget = constraintWidget24;
                                    constraintWidget2 = constraintWidget23;
                                    i9 = i5;
                                    if (z4 || constraintWidget2 == null) {
                                        i7 = i9;
                                        if (z3 && constraintWidget2 != null) {
                                            int i38 = bVar.j;
                                            boolean z12 = i38 <= 0 && bVar.i == i38;
                                            constraintWidget4 = constraintWidget2;
                                            ConstraintWidget constraintWidget29 = constraintWidget4;
                                            while (constraintWidget4 != null) {
                                                ConstraintWidget constraintWidget30 = constraintWidget4.H0[i2];
                                                while (constraintWidget30 != null && constraintWidget30.f8o0 == 8) {
                                                    constraintWidget30 = constraintWidget30.H0[i2];
                                                }
                                                if (constraintWidget4 == constraintWidget2 || constraintWidget4 == constraintWidget || constraintWidget30 == null) {
                                                    constraintWidget5 = constraintWidget30;
                                                } else {
                                                    ConstraintWidget constraintWidget31 = constraintWidget30 == constraintWidget ? null : constraintWidget30;
                                                    ConstraintAnchor constraintAnchor15 = constraintWidget4.S[i3];
                                                    SolverVariable solverVariable12 = constraintAnchor15.i;
                                                    int i39 = i3 + 1;
                                                    SolverVariable solverVariable13 = constraintWidget29.S[i39].i;
                                                    int e5 = constraintAnchor15.e();
                                                    int e6 = constraintWidget4.S[i39].e();
                                                    if (constraintWidget31 != null) {
                                                        constraintAnchor6 = constraintWidget31.S[i3];
                                                        solverVariable4 = constraintAnchor6.i;
                                                        ConstraintAnchor constraintAnchor16 = constraintAnchor6.f;
                                                        solverVariable3 = constraintAnchor16 != null ? constraintAnchor16.i : null;
                                                    } else {
                                                        constraintAnchor6 = constraintWidget.S[i3];
                                                        solverVariable4 = constraintAnchor6 != null ? constraintAnchor6.i : null;
                                                        solverVariable3 = constraintWidget4.S[i39].i;
                                                    }
                                                    int e7 = constraintAnchor6 != null ? constraintAnchor6.e() + e6 : e6;
                                                    int e8 = constraintWidget29.S[i39].e() + e5;
                                                    int i40 = z12 ? 8 : 4;
                                                    if (solverVariable12 == null || solverVariable13 == null || solverVariable4 == null || solverVariable3 == null) {
                                                        constraintWidget6 = constraintWidget31;
                                                    } else {
                                                        constraintWidget6 = constraintWidget31;
                                                        dVar.b(solverVariable12, solverVariable13, e8, 0.5f, solverVariable4, solverVariable3, e7, i40);
                                                    }
                                                    constraintWidget5 = constraintWidget6;
                                                }
                                                if (constraintWidget4.f8o0 != 8) {
                                                    constraintWidget29 = constraintWidget4;
                                                }
                                                constraintWidget4 = constraintWidget5;
                                            }
                                            ConstraintAnchor constraintAnchor17 = constraintWidget2.S[i3];
                                            constraintAnchor3 = constraintWidget21.S[i3].f;
                                            int i41 = i3 + 1;
                                            constraintAnchor4 = constraintWidget.S[i41];
                                            constraintAnchor5 = constraintWidget22.S[i41].f;
                                            if (constraintAnchor3 != null) {
                                                if (constraintWidget2 != constraintWidget) {
                                                    dVar.d(constraintAnchor17.i, constraintAnchor3.i, constraintAnchor17.e(), 5);
                                                } else if (constraintAnchor5 != null) {
                                                    dVar.b(constraintAnchor17.i, constraintAnchor3.i, constraintAnchor17.e(), 0.5f, constraintAnchor4.i, constraintAnchor5.i, constraintAnchor4.e(), 5);
                                                }
                                            }
                                            if (!(constraintAnchor5 == null || constraintWidget2 == constraintWidget)) {
                                                dVar.d(constraintAnchor4.i, constraintAnchor5.i, -constraintAnchor4.e(), 5);
                                            }
                                        }
                                        if (!((z4 && !z3) || constraintWidget2 == null || constraintWidget2 == constraintWidget)) {
                                            ConstraintAnchor[] constraintAnchorArr9 = constraintWidget2.S;
                                            constraintAnchor = constraintAnchorArr9[i3];
                                            constraintWidget3 = constraintWidget != null ? constraintWidget2 : constraintWidget;
                                            i8 = i3 + 1;
                                            constraintAnchor2 = constraintWidget3.S[i8];
                                            ConstraintAnchor constraintAnchor18 = constraintAnchor.f;
                                            solverVariable = constraintAnchor18 == null ? constraintAnchor18.i : null;
                                            ConstraintAnchor constraintAnchor19 = constraintAnchor2.f;
                                            SolverVariable solverVariable14 = constraintAnchor19 == null ? constraintAnchor19.i : null;
                                            if (constraintWidget22 == constraintWidget3) {
                                                ConstraintAnchor constraintAnchor20 = constraintWidget22.S[i8].f;
                                                if (constraintAnchor20 != null) {
                                                    solverVariable6 = constraintAnchor20.i;
                                                }
                                                solverVariable2 = solverVariable6;
                                            } else {
                                                solverVariable2 = solverVariable14;
                                            }
                                            if (constraintWidget2 == constraintWidget3) {
                                                constraintAnchor = constraintAnchorArr9[i3];
                                                constraintAnchor2 = constraintAnchorArr9[i8];
                                            }
                                            if (solverVariable != null && solverVariable2 != null) {
                                                dVar.b(constraintAnchor.i, solverVariable, constraintAnchor.e(), 0.5f, solverVariable2, constraintAnchor2.i, constraintWidget3.S[i8].e(), 5);
                                            }
                                        }
                                    } else {
                                        int i42 = bVar.j;
                                        boolean z13 = i42 > 0 && bVar.i == i42;
                                        ConstraintWidget constraintWidget32 = constraintWidget2;
                                        ConstraintWidget constraintWidget33 = constraintWidget32;
                                        while (constraintWidget33 != null) {
                                            ConstraintWidget constraintWidget34 = constraintWidget33.H0[i2];
                                            while (constraintWidget34 != null && constraintWidget34.f8o0 == 8) {
                                                constraintWidget34 = constraintWidget34.H0[i2];
                                            }
                                            if (constraintWidget34 != null || constraintWidget33 == constraintWidget) {
                                                ConstraintAnchor constraintAnchor21 = constraintWidget33.S[i3];
                                                SolverVariable solverVariable15 = constraintAnchor21.i;
                                                ConstraintAnchor constraintAnchor22 = constraintAnchor21.f;
                                                SolverVariable solverVariable16 = constraintAnchor22 != null ? constraintAnchor22.i : null;
                                                if (constraintWidget32 != constraintWidget33) {
                                                    solverVariable16 = constraintWidget32.S[i3 + 1].i;
                                                } else if (constraintWidget33 == constraintWidget2) {
                                                    ConstraintAnchor[] constraintAnchorArr10 = constraintWidget21.S;
                                                    solverVariable16 = constraintAnchorArr10[i3].f != null ? constraintAnchorArr10[i3].f.i : null;
                                                }
                                                int e9 = constraintAnchor21.e();
                                                int i43 = i3 + 1;
                                                int e10 = constraintWidget33.S[i43].e();
                                                if (constraintWidget34 != null) {
                                                    constraintAnchor7 = constraintWidget34.S[i3];
                                                    solverVariable5 = constraintAnchor7.i;
                                                } else {
                                                    constraintAnchor7 = constraintWidget22.S[i43].f;
                                                    if (constraintAnchor7 != null) {
                                                        solverVariable5 = constraintAnchor7.i;
                                                    } else {
                                                        constraintWidget10 = constraintWidget34;
                                                        solverVariable5 = null;
                                                        SolverVariable solverVariable17 = constraintWidget33.S[i43].i;
                                                        if (constraintAnchor7 != null) {
                                                            e10 += constraintAnchor7.e();
                                                        }
                                                        int e11 = constraintWidget32.S[i43].e() + e9;
                                                        if (solverVariable15 != null || solverVariable16 == null || solverVariable5 == null || solverVariable17 == null) {
                                                            i10 = i9;
                                                            constraintWidget9 = constraintWidget10;
                                                            constraintWidget7 = constraintWidget32;
                                                        } else {
                                                            if (constraintWidget33 == constraintWidget2) {
                                                                e11 = constraintWidget2.S[i3].e();
                                                            }
                                                            i10 = i9;
                                                            constraintWidget9 = constraintWidget10;
                                                            constraintWidget7 = constraintWidget32;
                                                            constraintWidget8 = constraintWidget33;
                                                            dVar.b(solverVariable15, solverVariable16, e11, 0.5f, solverVariable5, solverVariable17, constraintWidget33 == constraintWidget ? constraintWidget.S[i43].e() : e10, z13 ? 8 : 5);
                                                            constraintWidget32 = constraintWidget8.f8o0 == 8 ? constraintWidget8 : constraintWidget7;
                                                            constraintWidget33 = constraintWidget9;
                                                            i9 = i10;
                                                        }
                                                    }
                                                }
                                                constraintWidget10 = constraintWidget34;
                                                SolverVariable solverVariable172 = constraintWidget33.S[i43].i;
                                                if (constraintAnchor7 != null) {
                                                }
                                                int e112 = constraintWidget32.S[i43].e() + e9;
                                                if (solverVariable15 != null) {
                                                }
                                                i10 = i9;
                                                constraintWidget9 = constraintWidget10;
                                                constraintWidget7 = constraintWidget32;
                                            } else {
                                                constraintWidget9 = constraintWidget34;
                                                constraintWidget7 = constraintWidget32;
                                                i10 = i9;
                                            }
                                            constraintWidget8 = constraintWidget33;
                                            if (constraintWidget8.f8o0 == 8) {
                                            }
                                            constraintWidget33 = constraintWidget9;
                                            i9 = i10;
                                        }
                                    }
                                } else {
                                    ConstraintAnchor constraintAnchor23 = constraintWidget21.S[i3];
                                    int i44 = i3 + 1;
                                    ConstraintAnchor constraintAnchor24 = constraintWidget22.S[i44];
                                    ConstraintAnchor constraintAnchor25 = constraintAnchor23.f;
                                    SolverVariable solverVariable18 = constraintAnchor25 != null ? constraintAnchor25.i : null;
                                    ConstraintAnchor constraintAnchor26 = constraintAnchor24.f;
                                    SolverVariable solverVariable19 = constraintAnchor26 != null ? constraintAnchor26.i : null;
                                    ConstraintAnchor constraintAnchor27 = constraintWidget23.S[i3];
                                    if (constraintWidget24 != null) {
                                        constraintAnchor24 = constraintWidget24.S[i44];
                                    }
                                    if (solverVariable18 == null || solverVariable19 == null) {
                                        constraintWidget = constraintWidget24;
                                        constraintWidget2 = constraintWidget23;
                                        i9 = i5;
                                    } else {
                                        if (i2 == 0) {
                                            f2 = constraintWidget25.f4k0;
                                        } else {
                                            f2 = constraintWidget25.f5l0;
                                        }
                                        constraintWidget = constraintWidget24;
                                        constraintWidget2 = constraintWidget23;
                                        i9 = i5;
                                        dVar.b(constraintAnchor27.i, solverVariable18, constraintAnchor27.e(), f2, solverVariable19, constraintAnchor24.i, constraintAnchor24.e(), 7);
                                    }
                                }
                                i7 = i9;
                                if (z4) {
                                }
                                ConstraintAnchor[] constraintAnchorArr92 = constraintWidget2.S;
                                constraintAnchor = constraintAnchorArr92[i3];
                                if (constraintWidget != null) {
                                }
                                i8 = i3 + 1;
                                constraintAnchor2 = constraintWidget3.S[i8];
                                ConstraintAnchor constraintAnchor182 = constraintAnchor.f;
                                if (constraintAnchor182 == null) {
                                }
                                ConstraintAnchor constraintAnchor192 = constraintAnchor2.f;
                                if (constraintAnchor192 == null) {
                                }
                                if (constraintWidget22 == constraintWidget3) {
                                }
                                if (constraintWidget2 == constraintWidget3) {
                                }
                                if (solverVariable != null) {
                                    dVar.b(constraintAnchor.i, solverVariable, constraintAnchor.e(), 0.5f, solverVariable2, constraintAnchor2.i, constraintWidget3.S[i8].e(), 5);
                                }
                            }
                        }
                        if (z5) {
                            ConstraintAnchor constraintAnchor28 = constraintAnchor13.f;
                            if (constraintAnchor28.d == cVar2) {
                                dVar.d(constraintAnchor13.i, constraintAnchor28.i, -constraintAnchor13.e(), 4);
                            }
                        }
                        dVar.g(constraintAnchor13.i, constraintWidget22.S[i34].f.i, -constraintAnchor13.e(), 6);
                        if (z9) {
                        }
                        arrayList2 = bVar.h;
                        if (arrayList2 != null) {
                            if (bVar.q) {
                            }
                            ConstraintWidget constraintWidget272 = null;
                            float f72 = 0.0f;
                            i11 = 0;
                            while (i11 < size) {
                            }
                        }
                        if (constraintWidget23 != null) {
                        }
                        constraintWidget = constraintWidget24;
                        constraintWidget2 = constraintWidget23;
                        i9 = i5;
                        if (z4) {
                        }
                        i7 = i9;
                        if (z3) {
                            int i382 = bVar.j;
                            if (i382 <= 0) {
                            }
                            constraintWidget4 = constraintWidget2;
                            ConstraintWidget constraintWidget292 = constraintWidget4;
                            while (constraintWidget4 != null) {
                            }
                            ConstraintAnchor constraintAnchor172 = constraintWidget2.S[i3];
                            constraintAnchor3 = constraintWidget21.S[i3].f;
                            int i412 = i3 + 1;
                            constraintAnchor4 = constraintWidget.S[i412];
                            constraintAnchor5 = constraintWidget22.S[i412].f;
                            if (constraintAnchor3 != null) {
                            }
                            if (constraintAnchor5 == null) {
                                dVar.d(constraintAnchor4.i, constraintAnchor5.i, -constraintAnchor4.e(), 5);
                            }
                        }
                        if (z4) {
                        }
                        ConstraintAnchor[] constraintAnchorArr922 = constraintWidget2.S;
                        constraintAnchor = constraintAnchorArr922[i3];
                        if (constraintWidget != null) {
                        }
                        i8 = i3 + 1;
                        constraintAnchor2 = constraintWidget3.S[i8];
                        ConstraintAnchor constraintAnchor1822 = constraintAnchor.f;
                        if (constraintAnchor1822 == null) {
                        }
                        ConstraintAnchor constraintAnchor1922 = constraintAnchor2.f;
                        if (constraintAnchor1922 == null) {
                        }
                        if (constraintWidget22 == constraintWidget3) {
                        }
                        if (constraintWidget2 == constraintWidget3) {
                        }
                        if (solverVariable != null) {
                        }
                    }
                }
                if (z9) {
                }
                arrayList2 = bVar.h;
                if (arrayList2 != null) {
                }
                if (constraintWidget23 != null) {
                }
                constraintWidget = constraintWidget24;
                constraintWidget2 = constraintWidget23;
                i9 = i5;
                if (z4) {
                }
                i7 = i9;
                if (z3) {
                }
                if (z4) {
                }
                ConstraintAnchor[] constraintAnchorArr9222 = constraintWidget2.S;
                constraintAnchor = constraintAnchorArr9222[i3];
                if (constraintWidget != null) {
                }
                i8 = i3 + 1;
                constraintAnchor2 = constraintWidget3.S[i8];
                ConstraintAnchor constraintAnchor18222 = constraintAnchor.f;
                if (constraintAnchor18222 == null) {
                }
                ConstraintAnchor constraintAnchor19222 = constraintAnchor2.f;
                if (constraintAnchor19222 == null) {
                }
                if (constraintWidget22 == constraintWidget3) {
                }
                if (constraintWidget2 == constraintWidget3) {
                }
                if (solverVariable != null) {
                }
            } else {
                i6 = i4;
                bVarArr2 = bVarArr;
                i7 = i5;
            }
            i21 = i7 + 1;
            i18 = 2;
            cVar2 = cVar;
            arrayList4 = arrayList;
            bVarArr = bVarArr2;
            i4 = i6;
        }
    }

    public static int c0(int i2, Rect rect, Rect rect2) {
        int i3;
        int i4;
        if (i2 == 17) {
            i4 = rect.left;
            i3 = rect2.right;
        } else if (i2 == 33) {
            i4 = rect.top;
            i3 = rect2.bottom;
        } else if (i2 == 66) {
            i4 = rect2.left;
            i3 = rect.right;
        } else if (i2 == 130) {
            i4 = rect2.top;
            i3 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return Math.max(0, i4 - i3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
        if (r10.bottom <= r12.top) goto L_0x0043;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
        if (r10.right <= r12.left) goto L_0x0043;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003a, code lost:
        if (r10.top >= r12.bottom) goto L_0x0043;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r10.left >= r12.right) goto L_0x0043;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
        r7 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static boolean d(int i2, Rect rect, Rect rect2, Rect rect3) {
        boolean z;
        int i3;
        int i4;
        boolean e2 = e(i2, rect, rect2);
        if (e(i2, rect, rect3) || !e2) {
            return false;
        }
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
        }
        if (!z || i2 == 17 || i2 == 66) {
            return true;
        }
        int c0 = c0(i2, rect, rect2);
        if (i2 == 17) {
            i4 = rect.left;
            i3 = rect3.left;
        } else if (i2 == 33) {
            i4 = rect.top;
            i3 = rect3.top;
        } else if (i2 == 66) {
            i4 = rect3.right;
            i3 = rect.right;
        } else if (i2 == 130) {
            i4 = rect3.bottom;
            i3 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return c0 < Math.max(1, i4 - i3);
    }

    public static final <T, R> h0.u.w<R> d0(h0.u.w<T> wVar, p<? super T, ? super c<? super R>, ? extends Object> pVar) {
        i.e(wVar, "$this$map");
        i.e(pVar, "transform");
        return new h0.u.w<>(new PagingDataTransforms$map$$inlined$transform$1(wVar.d, pVar), wVar.e);
    }

    public static boolean e(int i2, Rect rect, Rect rect2) {
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    public static void e0(Intent intent, ArrayList<Uri> arrayList) {
        ClipData clipData = new ClipData(null, new String[]{intent.getType()}, new ClipData.Item(intent.getCharSequenceExtra("android.intent.extra.TEXT"), intent.getStringExtra("android.intent.extra.HTML_TEXT"), null, arrayList.get(0)));
        int size = arrayList.size();
        for (int i2 = 1; i2 < size; i2++) {
            clipData.addItem(new ClipData.Item(arrayList.get(i2)));
        }
        intent.setClipData(clipData);
        intent.addFlags(1);
    }

    public static void f(Object obj, StringBuilder sb) {
        int lastIndexOf;
        if (obj == null) {
            sb.append("null");
            return;
        }
        String simpleName = obj.getClass().getSimpleName();
        if (simpleName.length() <= 0 && (lastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
            simpleName = simpleName.substring(lastIndexOf + 1);
        }
        sb.append(simpleName);
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
    }

    public static int f0(int i2, Rect rect, Rect rect2) {
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
        }
        return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
    }

    public static final Bundle g(Pair<String, ? extends Object>... pairArr) {
        i.e(pairArr, "pairs");
        Bundle bundle = new Bundle(pairArr.length);
        for (Pair<String, ? extends Object> pair : pairArr) {
            String str = pair.c;
            B b2 = pair.d;
            if (b2 == 0) {
                bundle.putString(str, null);
            } else if (b2 instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) b2).booleanValue());
            } else if (b2 instanceof Byte) {
                bundle.putByte(str, ((Number) b2).byteValue());
            } else if (b2 instanceof Character) {
                bundle.putChar(str, ((Character) b2).charValue());
            } else if (b2 instanceof Double) {
                bundle.putDouble(str, ((Number) b2).doubleValue());
            } else if (b2 instanceof Float) {
                bundle.putFloat(str, ((Number) b2).floatValue());
            } else if (b2 instanceof Integer) {
                bundle.putInt(str, ((Number) b2).intValue());
            } else if (b2 instanceof Long) {
                bundle.putLong(str, ((Number) b2).longValue());
            } else if (b2 instanceof Short) {
                bundle.putShort(str, ((Number) b2).shortValue());
            } else if (b2 instanceof Bundle) {
                bundle.putBundle(str, (Bundle) b2);
            } else if (b2 instanceof CharSequence) {
                bundle.putCharSequence(str, (CharSequence) b2);
            } else if (b2 instanceof Parcelable) {
                bundle.putParcelable(str, (Parcelable) b2);
            } else if (b2 instanceof boolean[]) {
                bundle.putBooleanArray(str, (boolean[]) b2);
            } else if (b2 instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) b2);
            } else if (b2 instanceof char[]) {
                bundle.putCharArray(str, (char[]) b2);
            } else if (b2 instanceof double[]) {
                bundle.putDoubleArray(str, (double[]) b2);
            } else if (b2 instanceof float[]) {
                bundle.putFloatArray(str, (float[]) b2);
            } else if (b2 instanceof int[]) {
                bundle.putIntArray(str, (int[]) b2);
            } else if (b2 instanceof long[]) {
                bundle.putLongArray(str, (long[]) b2);
            } else if (b2 instanceof short[]) {
                bundle.putShortArray(str, (short[]) b2);
            } else if (b2 instanceof Object[]) {
                Class<?> componentType = b2.getClass().getComponentType();
                i.c(componentType);
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    bundle.putParcelableArray(str, (Parcelable[]) b2);
                } else if (String.class.isAssignableFrom(componentType)) {
                    bundle.putStringArray(str, (String[]) b2);
                } else if (CharSequence.class.isAssignableFrom(componentType)) {
                    bundle.putCharSequenceArray(str, (CharSequence[]) b2);
                } else if (Serializable.class.isAssignableFrom(componentType)) {
                    bundle.putSerializable(str, (Serializable) b2);
                } else {
                    throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + str + '\"');
                }
            } else if (b2 instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) b2);
            } else if (b2 instanceof IBinder) {
                bundle.putBinder(str, (IBinder) b2);
            } else if (b2 instanceof Size) {
                bundle.putSize(str, (Size) b2);
            } else if (b2 instanceof SizeF) {
                bundle.putSizeF(str, (SizeF) b2);
            } else {
                throw new IllegalArgumentException("Illegal value type " + b2.getClass().getCanonicalName() + " for key \"" + str + '\"');
            }
        }
        return bundle;
    }

    public static ByteBuffer g0(Context context, CancellationSignal cancellationSignal, Uri uri) {
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
            try {
                FileChannel channel = fileInputStream.getChannel();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
                fileInputStream.close();
                openFileDescriptor.close();
                return map;
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public static final <T> n0.a.g2.d<h0.u.w<T>> h(n0.a.g2.d<h0.u.w<T>> dVar, f0 f0Var) {
        i.e(dVar, "$this$cachedIn");
        i.e(f0Var, "scope");
        i.e(dVar, "$this$cachedIn");
        i.e(f0Var, "scope");
        CachedPagingDataKt$cachedIn$$inlined$map$1 cachedPagingDataKt$cachedIn$$inlined$map$1 = new CachedPagingDataKt$cachedIn$$inlined$map$1(dVar, f0Var);
        CachedPagingDataKt$cachedIn$multicastedFlow$2 cachedPagingDataKt$cachedIn$multicastedFlow$2 = new CachedPagingDataKt$cachedIn$multicastedFlow$2(null);
        Object obj = h0.u.g.a;
        i.e(cachedPagingDataKt$cachedIn$$inlined$map$1, "$this$simpleRunningReduce");
        i.e(cachedPagingDataKt$cachedIn$multicastedFlow$2, "operation");
        return (n0.a.g2.d<T>) new h0.u.i0.c(f0Var, 1, new FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(new FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(new CachedPagingDataKt$cachedIn$multicastedFlow$4(null, null), new CachedPagingDataKt$cachedIn$$inlined$map$2(new s(new FlowExtKt$simpleRunningReduce$1(cachedPagingDataKt$cachedIn$$inlined$map$1, cachedPagingDataKt$cachedIn$multicastedFlow$2, null)))), new CachedPagingDataKt$cachedIn$multicastedFlow$5(null, null)), false, new CachedPagingDataKt$cachedIn$1(null), true, 8).b;
    }

    public static TypedArray h0(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static boolean i(h0.i.c.d[] dVarArr, h0.i.c.d[] dVarArr2) {
        if (dVarArr == null || dVarArr2 == null || dVarArr.length != dVarArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < dVarArr.length; i2++) {
            if (!(dVarArr[i2].a == dVarArr2[i2].a && dVarArr[i2].b.length == dVarArr2[i2].b.length)) {
                return false;
            }
        }
        return true;
    }

    public static <T> ObjectAnimator i0(T t, Property<T, PointF> property, Path path) {
        return ObjectAnimator.ofObject(t, property, (TypeConverter) null, path);
    }

    public static void j(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static InputConnection j0(InputConnection inputConnection, EditorInfo editorInfo, View view) {
        if (inputConnection != null && editorInfo.hintText == null) {
            ViewParent parent = view.getParent();
            while (true) {
                if (!(parent instanceof View)) {
                    break;
                } else if (parent instanceof d1) {
                    editorInfo.hintText = ((d1) parent).a();
                    break;
                } else {
                    parent = parent.getParent();
                }
            }
        }
        return inputConnection;
    }

    public static int k(int i2) {
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalArgumentException();
    }

    public static boolean k0(ViewParent viewParent, View view, float f2, float f3, boolean z) {
        try {
            return viewParent.onNestedFling(view, f2, f3, z);
        } catch (AbstractMethodError e2) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e2);
            return false;
        }
    }

    public static int l(int i2, String str) {
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalArgumentException(str);
    }

    public static boolean l0(ViewParent viewParent, View view, float f2, float f3) {
        try {
            return viewParent.onNestedPreFling(view, f2, f3);
        } catch (AbstractMethodError e2) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e2);
            return false;
        }
    }

    public static <T> T m(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void m0(ViewParent viewParent, View view, int i2, int i3, int[] iArr, int i4) {
        if (viewParent instanceof j) {
            ((j) viewParent).o(view, i2, i3, iArr, i4);
        } else if (i4 == 0) {
            try {
                viewParent.onNestedPreScroll(view, i2, i3, iArr);
            } catch (AbstractMethodError e2) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e2);
            }
        }
    }

    public static int n(Context context, String str) {
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        String packageName = context.getPackageName();
        if (context.checkPermission(str, myPid, myUid) == -1) {
            return -1;
        }
        String permissionToOp = AppOpsManagerCompat.permissionToOp(str);
        if (permissionToOp != null) {
            if (packageName == null) {
                String[] packagesForUid = context.getPackageManager().getPackagesForUid(myUid);
                if (packagesForUid == null || packagesForUid.length <= 0) {
                    return -1;
                }
                packageName = packagesForUid[0];
            }
            if (AppOpsManagerCompat.noteProxyOpNoThrow(context, permissionToOp, packageName) != 0) {
                return -2;
            }
        }
        return 0;
    }

    public static void n0(ViewParent viewParent, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        if (viewParent instanceof k) {
            ((k) viewParent).e(view, i2, i3, i4, i5, i6, iArr);
            return;
        }
        iArr[0] = iArr[0] + i4;
        iArr[1] = iArr[1] + i5;
        if (viewParent instanceof j) {
            ((j) viewParent).k(view, i2, i3, i4, i5, i6);
        } else if (i6 == 0) {
            try {
                viewParent.onNestedScroll(view, i2, i3, i4, i5);
            } catch (AbstractMethodError e2) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e2);
            }
        }
    }

    public static int o(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    public static h0.i.b.d.c o0(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            xmlPullParser.require(2, null, "font-family");
            if (xmlPullParser.getName().equals("font-family")) {
                TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), androidx.core.R.styleable.FontFamily);
                String string = obtainAttributes.getString(androidx.core.R.styleable.FontFamily_fontProviderAuthority);
                String string2 = obtainAttributes.getString(androidx.core.R.styleable.FontFamily_fontProviderPackage);
                String string3 = obtainAttributes.getString(androidx.core.R.styleable.FontFamily_fontProviderQuery);
                int resourceId = obtainAttributes.getResourceId(androidx.core.R.styleable.FontFamily_fontProviderCerts, 0);
                int integer = obtainAttributes.getInteger(androidx.core.R.styleable.FontFamily_fontProviderFetchStrategy, 1);
                int integer2 = obtainAttributes.getInteger(androidx.core.R.styleable.FontFamily_fontProviderFetchTimeout, 500);
                String string4 = obtainAttributes.getString(androidx.core.R.styleable.FontFamily_fontProviderSystemFontFamily);
                obtainAttributes.recycle();
                if (string == null || string2 == null || string3 == null) {
                    ArrayList arrayList = new ArrayList();
                    while (xmlPullParser.next() != 3) {
                        if (xmlPullParser.getEventType() == 2) {
                            if (xmlPullParser.getName().equals("font")) {
                                TypedArray obtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), androidx.core.R.styleable.FontFamilyFont);
                                int i2 = androidx.core.R.styleable.FontFamilyFont_fontWeight;
                                if (!obtainAttributes2.hasValue(i2)) {
                                    i2 = androidx.core.R.styleable.FontFamilyFont_android_fontWeight;
                                }
                                int i3 = obtainAttributes2.getInt(i2, RequestResponse.HttpStatusCode._4xx.BAD_REQUEST);
                                int i4 = androidx.core.R.styleable.FontFamilyFont_fontStyle;
                                if (!obtainAttributes2.hasValue(i4)) {
                                    i4 = androidx.core.R.styleable.FontFamilyFont_android_fontStyle;
                                }
                                boolean z = 1 == obtainAttributes2.getInt(i4, 0);
                                int i5 = androidx.core.R.styleable.FontFamilyFont_ttcIndex;
                                if (!obtainAttributes2.hasValue(i5)) {
                                    i5 = androidx.core.R.styleable.FontFamilyFont_android_ttcIndex;
                                }
                                int i6 = androidx.core.R.styleable.FontFamilyFont_fontVariationSettings;
                                if (!obtainAttributes2.hasValue(i6)) {
                                    i6 = androidx.core.R.styleable.FontFamilyFont_android_fontVariationSettings;
                                }
                                String string5 = obtainAttributes2.getString(i6);
                                int i7 = obtainAttributes2.getInt(i5, 0);
                                int i8 = androidx.core.R.styleable.FontFamilyFont_font;
                                if (!obtainAttributes2.hasValue(i8)) {
                                    i8 = androidx.core.R.styleable.FontFamilyFont_android_font;
                                }
                                int resourceId2 = obtainAttributes2.getResourceId(i8, 0);
                                String string6 = obtainAttributes2.getString(i8);
                                obtainAttributes2.recycle();
                                while (xmlPullParser.next() != 3) {
                                    A0(xmlPullParser);
                                }
                                arrayList.add(new h0.i.b.d.e(string6, i3, z, string5, i7, resourceId2));
                            } else {
                                A0(xmlPullParser);
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        return null;
                    }
                    return new h0.i.b.d.d((h0.i.b.d.e[]) arrayList.toArray(new h0.i.b.d.e[arrayList.size()]));
                }
                while (xmlPullParser.next() != 3) {
                    A0(xmlPullParser);
                }
                return new f(new h0.i.f.e(string, string2, string3, p0(resources, resourceId)), integer, integer2, string4);
            }
            A0(xmlPullParser);
            return null;
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static final <T> n p(o<T> oVar, o<T> oVar2, g.e<T> eVar) {
        boolean z;
        i.e(oVar, "$this$computeDiff");
        i.e(oVar2, "newList");
        i.e(eVar, "diffCallback");
        h0.u.p pVar = new h0.u.p(oVar, oVar2, eVar, oVar.a(), oVar2.a());
        boolean z2 = true;
        g.d a2 = h0.v.a.g.a(pVar, true);
        i.d(a2, "DiffUtil.calculateDiff(\n…    },\n        true\n    )");
        m0.q.e f2 = m0.q.i.f(0, oVar.a());
        if (!(f2 instanceof Collection) || !((Collection) f2).isEmpty()) {
            Iterator<Integer> it = f2.iterator();
            while (it.hasNext()) {
                if (a2.a(((m0.j.o) it).a()) != -1) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
        }
        z2 = false;
        return new n(a2, z2);
    }

    public static List<List<byte[]>> p0(Resources resources, int i2) {
        if (i2 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i2);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (obtainTypedArray.getType(0) == 1) {
                for (int i3 = 0; i3 < obtainTypedArray.length(); i3++) {
                    int resourceId = obtainTypedArray.getResourceId(i3, 0);
                    if (resourceId != 0) {
                        arrayList.add(B0(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(B0(resources.getStringArray(i2)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    public static int q(RecyclerView.y yVar, v vVar, View view, View view2, RecyclerView.n nVar, boolean z) {
        if (nVar.getChildCount() == 0 || yVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(nVar.getPosition(view) - nVar.getPosition(view2)) + 1;
        }
        return Math.min(vVar.l(), vVar.b(view2) - vVar.e(view));
    }

    public static final <T> h0.u.f0<T> q0(T t, int[] iArr, int i2, int i3) {
        i.e(t, "separator");
        i.e(iArr, "originalPageOffsets");
        return new h0.u.f0<>(iArr, h.L2(t), i2, h.L2(Integer.valueOf(i3)));
    }

    public static int r(RecyclerView.y yVar, v vVar, View view, View view2, RecyclerView.n nVar, boolean z, boolean z2) {
        int i2;
        if (nVar.getChildCount() == 0 || yVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(nVar.getPosition(view), nVar.getPosition(view2));
        int max = Math.max(nVar.getPosition(view), nVar.getPosition(view2));
        if (z2) {
            i2 = Math.max(0, (yVar.b() - max) - 1);
        } else {
            i2 = Math.max(0, min);
        }
        if (!z) {
            return i2;
        }
        return Math.round((((float) i2) * (((float) Math.abs(vVar.b(view2) - vVar.e(view))) / ((float) (Math.abs(nVar.getPosition(view) - nVar.getPosition(view2)) + 1)))) + ((float) (vVar.k() - vVar.e(view))));
    }

    public static void r0(TextView textView, int i2) {
        int i3;
        k(i2);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setFirstBaselineToTopHeight(i2);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (textView.getIncludeFontPadding()) {
            i3 = fontMetricsInt.top;
        } else {
            i3 = fontMetricsInt.ascent;
        }
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), i2 + i3, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static int s(RecyclerView.y yVar, v vVar, View view, View view2, RecyclerView.n nVar, boolean z) {
        if (nVar.getChildCount() == 0 || yVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return yVar.b();
        }
        return (int) ((((float) (vVar.b(view2) - vVar.e(view))) / ((float) (Math.abs(nVar.getPosition(view) - nVar.getPosition(view2)) + 1))) * ((float) yVar.b()));
    }

    public static void s0(TextView textView, int i2) {
        int i3;
        k(i2);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (textView.getIncludeFontPadding()) {
            i3 = fontMetricsInt.bottom;
        } else {
            i3 = fontMetricsInt.descent;
        }
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i2 - i3);
        }
    }

    public static float[] t(float[] fArr, int i2, int i3) {
        if (i2 <= i3) {
            int length = fArr.length;
            if (i2 < 0 || i2 > length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i4 = i3 - i2;
            int min = Math.min(i4, length - i2);
            float[] fArr2 = new float[i4];
            System.arraycopy(fArr, i2, fArr2, 0, min);
            return fArr2;
        }
        throw new IllegalArgumentException();
    }

    public static void t0(TextView textView, int i2) {
        k(i2);
        int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
        if (i2 != fontMetricsInt) {
            textView.setLineSpacing((float) (i2 - fontMetricsInt), 1.0f);
        }
    }

    public static boolean u(File file, Resources resources, int i2) {
        InputStream inputStream;
        Throwable th;
        try {
            inputStream = resources.openRawResource(i2);
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
        try {
            boolean v = v(file, inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            return v;
        } catch (Throwable th3) {
            th = th3;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public static void u0(TextView textView, h0.i.g.b bVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            Objects.requireNonNull(bVar);
            textView.setText((CharSequence) null);
            return;
        }
        b.a S = S(textView);
        Objects.requireNonNull(bVar);
        S.a(null);
        throw null;
    }

    public static boolean v(File file, InputStream inputStream) {
        Throwable th;
        IOException e2;
        FileOutputStream fileOutputStream;
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, false);
            } catch (IOException e3) {
                e2 = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            byte[] bArr = new byte[RecyclerView.b0.FLAG_ADAPTER_FULLUPDATE];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            try {
                fileOutputStream.close();
            } catch (IOException unused) {
            }
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            return true;
        } catch (IOException e4) {
            e2 = e4;
            fileOutputStream2 = fileOutputStream;
            Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e2.getMessage());
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused2) {
                }
            }
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused3) {
                }
            }
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            throw th;
        }
    }

    public static void v0(Drawable drawable, int i2) {
        drawable.setTint(i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x008a, code lost:
        if (r13 == 0) goto L_0x008c;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0097 A[Catch: NumberFormatException -> 0x00bc, LOOP:3: B:26:0x006c->B:46:0x0097, LOOP_END, TryCatch #0 {NumberFormatException -> 0x00bc, blocks: (B:23:0x0059, B:26:0x006c, B:28:0x0072, B:33:0x0080, B:46:0x0097, B:48:0x009c, B:51:0x00ac, B:53:0x00b1), top: B:68:0x0059 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009c A[Catch: NumberFormatException -> 0x00bc, TryCatch #0 {NumberFormatException -> 0x00bc, blocks: (B:23:0x0059, B:26:0x006c, B:28:0x0072, B:33:0x0080, B:46:0x0097, B:48:0x009c, B:51:0x00ac, B:53:0x00b1), top: B:68:0x0059 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ac A[Catch: NumberFormatException -> 0x00bc, TryCatch #0 {NumberFormatException -> 0x00bc, blocks: (B:23:0x0059, B:26:0x006c, B:28:0x0072, B:33:0x0080, B:46:0x0097, B:48:0x009c, B:51:0x00ac, B:53:0x00b1), top: B:68:0x0059 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0096 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static h0.i.c.d[] w(String str) {
        String trim;
        float[] fArr;
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i3 < str.length()) {
            while (i3 < str.length()) {
                char charAt = str.charAt(i3);
                if ((charAt - 'Z') * (charAt - 'A') > 0) {
                    if ((charAt - 'z') * (charAt - 'a') > 0) {
                        continue;
                        i3++;
                    }
                }
                if (!(charAt == 'e' || charAt == 'E')) {
                    trim = str.substring(i2, i3).trim();
                    if (trim.length() > 0) {
                        if (trim.charAt(i4) == 'z' || trim.charAt(i4) == 'Z') {
                            fArr = new float[i4];
                        } else {
                            try {
                                float[] fArr2 = new float[trim.length()];
                                int length = trim.length();
                                int i5 = 1;
                                int i6 = i4;
                                while (i5 < length) {
                                    int i7 = i4;
                                    int i8 = i7;
                                    int i9 = i8;
                                    int i10 = i5;
                                    while (i10 < trim.length()) {
                                        char charAt2 = trim.charAt(i10);
                                        if (charAt2 != ' ') {
                                            if (charAt2 == 'E' || charAt2 == 'e') {
                                                i9 = 1;
                                                if (i4 != 0) {
                                                    if (i5 < i10) {
                                                        fArr2[i6] = Float.parseFloat(trim.substring(i5, i10));
                                                        i6++;
                                                    }
                                                    if (i7 != 0) {
                                                        i10++;
                                                    }
                                                    i5 = i10;
                                                    i4 = 0;
                                                } else {
                                                    i10++;
                                                }
                                            } else {
                                                switch (charAt2) {
                                                    case '-':
                                                        if (i10 != i5) {
                                                        }
                                                        break;
                                                    case '.':
                                                        if (i8 == 0) {
                                                            i8 = 1;
                                                            break;
                                                        }
                                                        i7 = 1;
                                                        break;
                                                }
                                                i9 = 0;
                                                if (i4 != 0) {
                                                }
                                            }
                                        }
                                        i4 = 1;
                                        i9 = 0;
                                        if (i4 != 0) {
                                        }
                                    }
                                    if (i5 < i10) {
                                    }
                                    if (i7 != 0) {
                                    }
                                    i5 = i10;
                                    i4 = 0;
                                }
                                fArr = t(fArr2, i4, i6);
                                i4 = 0;
                            } catch (NumberFormatException e2) {
                                throw new RuntimeException(i0.d.a.a.a.o0("error in parsing \"", trim, "\""), e2);
                            }
                        }
                        arrayList.add(new h0.i.c.d(trim.charAt(i4), fArr));
                    }
                    i3++;
                    i4 = 0;
                    i2 = i3;
                }
                i3++;
            }
            trim = str.substring(i2, i3).trim();
            if (trim.length() > 0) {
            }
            i3++;
            i4 = 0;
            i2 = i3;
        }
        if (i3 - i2 == 1 && i2 < str.length()) {
            arrayList.add(new h0.i.c.d(str.charAt(i2), new float[0]));
        }
        return (h0.i.c.d[]) arrayList.toArray(new h0.i.c.d[arrayList.size()]);
    }

    public static void w0(Drawable drawable, ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    public static final <VM extends k0> m0.c<VM> x(Fragment fragment, m0.r.d<VM> dVar, m0.n.a.a<? extends n0> aVar, m0.n.a.a<? extends m0.b> aVar2) {
        i.e(fragment, "$this$createViewModelLazy");
        i.e(dVar, "viewModelClass");
        i.e(aVar, "storeProducer");
        if (aVar2 == null) {
            aVar2 = new m0.n.a.a<m0.b>() { // from class: androidx.fragment.app.FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1
                @Override // m0.n.a.a
                public m0.b invoke() {
                    return Fragment.this.getDefaultViewModelProviderFactory();
                }
            };
        }
        return new l0(dVar, aVar, aVar2);
    }

    public static void x0(Drawable drawable, PorterDuff.Mode mode) {
        drawable.setTintMode(mode);
    }

    public static h0.i.c.d[] y(h0.i.c.d[] dVarArr) {
        if (dVarArr == null) {
            return null;
        }
        h0.i.c.d[] dVarArr2 = new h0.i.c.d[dVarArr.length];
        for (int i2 = 0; i2 < dVarArr.length; i2++) {
            dVarArr2[i2] = new h0.i.c.d(dVarArr[i2]);
        }
        return dVarArr2;
    }

    public static void y0(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
            return;
        }
        z0 z0Var = z0.c;
        if (z0Var != null && z0Var.q == view) {
            z0.c(null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            z0 z0Var2 = z0.d;
            if (z0Var2 != null && z0Var2.q == view) {
                z0Var2.b();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new z0(view, charSequence);
    }

    public static final <T> void z(o<T> oVar, r rVar, o<T> oVar2, n nVar) {
        i.e(oVar, "$this$dispatchDiff");
        i.e(rVar, "callback");
        i.e(oVar2, "newList");
        i.e(nVar, "diffResult");
        if (nVar.b) {
            i.e(oVar, "oldList");
            i.e(oVar2, "newList");
            i.e(rVar, "callback");
            i.e(nVar, "diffResult");
            h0.u.q qVar = new h0.u.q(oVar, oVar2, rVar);
            nVar.a.b(qVar);
            int min = Math.min(qVar.f.b(), qVar.a);
            int b2 = qVar.g.b() - qVar.a;
            boolean z = false;
            if (b2 > 0) {
                if (min > 0) {
                    qVar.h.d(0, min, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
                }
                qVar.h.a(0, b2);
            } else if (b2 < 0) {
                qVar.h.b(0, -b2);
                int i2 = min + b2;
                if (i2 > 0) {
                    qVar.h.d(0, i2, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
                }
            }
            qVar.a = qVar.g.b();
            int min2 = Math.min(qVar.f.c(), qVar.b);
            int c2 = qVar.g.c();
            int i3 = qVar.b;
            int i4 = c2 - i3;
            int i5 = qVar.a + qVar.c + i3;
            int i6 = i5 - min2;
            if (i6 != qVar.f.e() - min2) {
                z = true;
            }
            if (i4 > 0) {
                qVar.h.a(i5, i4);
            } else if (i4 < 0) {
                qVar.h.b(i5 + i4, -i4);
                min2 += i4;
            }
            if (min2 > 0 && z) {
                qVar.h.d(i6, min2, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
            }
            qVar.b = qVar.g.c();
            return;
        }
        i.e(rVar, "callback");
        i.e(oVar, "oldList");
        i.e(oVar2, "newList");
        int max = Math.max(oVar.b(), oVar2.b());
        int min3 = Math.min(oVar.a() + oVar.b(), oVar2.a() + oVar2.b());
        int i7 = min3 - max;
        if (i7 > 0) {
            rVar.b(max, i7);
            rVar.a(max, i7);
        }
        int min4 = Math.min(max, min3);
        int max2 = Math.max(max, min3);
        int b3 = oVar.b();
        int e2 = oVar2.e();
        if (b3 > e2) {
            b3 = e2;
        }
        int a2 = oVar.a() + oVar.b();
        int e3 = oVar2.e();
        if (a2 > e3) {
            a2 = e3;
        }
        DiffingChangePayload diffingChangePayload = DiffingChangePayload.ITEM_TO_PLACEHOLDER;
        int i8 = min4 - b3;
        if (i8 > 0) {
            rVar.d(b3, i8, diffingChangePayload);
        }
        int i9 = a2 - max2;
        if (i9 > 0) {
            rVar.d(max2, i9, diffingChangePayload);
        }
        int b4 = oVar2.b();
        int e4 = oVar.e();
        if (b4 > e4) {
            b4 = e4;
        }
        int a3 = oVar2.a() + oVar2.b();
        int e5 = oVar.e();
        if (a3 > e5) {
            a3 = e5;
        }
        DiffingChangePayload diffingChangePayload2 = DiffingChangePayload.PLACEHOLDER_TO_ITEM;
        int i10 = min4 - b4;
        if (i10 > 0) {
            rVar.d(b4, i10, diffingChangePayload2);
        }
        int i11 = a3 - max2;
        if (i11 > 0) {
            rVar.d(max2, i11, diffingChangePayload2);
        }
        int e6 = oVar2.e() - oVar.e();
        if (e6 > 0) {
            rVar.a(oVar.e(), e6);
        } else if (e6 < 0) {
            rVar.b(oVar.e() + e6, -e6);
        }
    }

    public static final <T> n0.a.g2.d<T> z0(p<? super c0<T>, ? super c<? super m0.i>, ? extends Object> pVar) {
        i.e(pVar, "block");
        return m0.r.t.a.r.m.a1.a.d0(new s(new SimpleChannelFlowKt$simpleChannelFlow$1(pVar, null)), -2, null, 2, null);
    }
}
