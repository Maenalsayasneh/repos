package com.clubhouse.android.shared;

import com.clubhouse.android.shared.preferences.Key;
import i0.e.b.f3.k.a;
import i0.e.b.f3.k.b;
import i0.j.f.p.h;
import java.util.List;
import java.util.Objects;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import m0.j.g;
import m0.l.c;
import m0.n.b.i;
import n0.a.g2.a0;
import n0.a.g2.d;
import n0.a.g2.e;
import n0.a.g2.q;
import n0.a.g2.z;
/* compiled from: FeatureFlags.kt */
/* loaded from: classes3.dex */
public final class FeatureFlags {
    public final b a;
    public z<? extends List<String>> b;

    public FeatureFlags(b bVar) {
        i.e(bVar, "userPreferences");
        this.a = bVar;
        q a = a0.a(EmptyList.c);
        this.b = a;
        Objects.requireNonNull(bVar);
        a.setValue(g.v0(a.d(bVar, Key.FEATURE_FLAGS, null, 2, null)));
    }

    public final boolean a(Flag flag) {
        i.e(flag, "flag");
        return ((List) this.b.getValue()).contains(flag.getKey());
    }

    public final d<Boolean> b(Flag flag) {
        i.e(flag, "flag");
        return m0.r.t.a.r.m.a1.a.f1(new d<Boolean>(flag) { // from class: com.clubhouse.android.shared.FeatureFlags$observeEnabled$$inlined$map$1
            public final /* synthetic */ Flag d;

            {
                this.d = r2;
            }

            @Override // n0.a.g2.d
            public Object collect(final e<? super Boolean> eVar, c cVar) {
                d dVar = d.this;
                final Flag flag2 = this.d;
                Object collect = dVar.collect(new e<List<? extends String>>() { // from class: com.clubhouse.android.shared.FeatureFlags$observeEnabled$$inlined$map$1.2
                    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
                    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
                    @Override // n0.a.g2.e
                    /* Code decompiled incorrectly, please refer to instructions dump */
                    public Object emit(List<? extends String> list, c cVar2) {
                        AnonymousClass1 r02;
                        int i;
                        if (cVar2 instanceof AnonymousClass1) {
                            r02 = (AnonymousClass1) cVar2;
                            int i2 = r02.d;
                            if ((i2 & Integer.MIN_VALUE) != 0) {
                                r02.d = i2 - Integer.MIN_VALUE;
                                Object obj = r02.c;
                                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                i = r02.d;
                                if (i != 0) {
                                    h.d4(obj);
                                    e eVar2 = e.this;
                                    Boolean valueOf = Boolean.valueOf(list.contains(flag2.getKey()));
                                    r02.d = 1;
                                    if (eVar2.emit(valueOf, r02) == coroutineSingletons) {
                                        return coroutineSingletons;
                                    }
                                } else if (i == 1) {
                                    h.d4(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                return m0.i.a;
                            }
                        }
                        r02 = new ContinuationImpl(cVar2) { // from class: com.clubhouse.android.shared.FeatureFlags$observeEnabled$.inlined.map.1.2.1
                            public /* synthetic */ Object c;
                            public int d;

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj2) {
                                this.c = obj2;
                                this.d |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        };
                        Object obj2 = r02.c;
                        CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                        i = r02.d;
                        if (i != 0) {
                        }
                        return m0.i.a;
                    }
                }, cVar);
                if (collect == CoroutineSingletons.COROUTINE_SUSPENDED) {
                    return collect;
                }
                return m0.i.a;
            }
        });
    }
}
