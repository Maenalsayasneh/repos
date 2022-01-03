package k0.b;

import i0.j.f.p.h;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableDebounceTimed;
import io.reactivex.internal.operators.observable.ObservableFlatMap;
import io.reactivex.internal.operators.observable.ObservableFlatMapCompletableCompletable;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import io.reactivex.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import k0.b.y.d;
import k0.b.z.b.a;
import k0.b.z.b.b;
import k0.b.z.c.c;
import k0.b.z.e.c.e;
import k0.b.z.e.c.f;
import k0.b.z.e.c.g;
import k0.b.z.e.c.i;
import k0.b.z.e.c.m;
import k0.b.z.e.c.o;
/* compiled from: Observable.java */
/* loaded from: classes4.dex */
public abstract class l<T> implements o<T> {
    public static <T> l<T> g() {
        return RxJavaPlugins.onAssembly(e.c);
    }

    public static <T> l<T> h(Throwable th) {
        return RxJavaPlugins.onAssembly(new f(new a.i(th)));
    }

    public static <T> l<T> m(Iterable<? extends T> iterable) {
        Objects.requireNonNull(iterable, "source is null");
        return RxJavaPlugins.onAssembly(new i(iterable));
    }

    public static l<Long> n(long j, TimeUnit timeUnit) {
        q a = k0.b.d0.a.a();
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(a, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableInterval(Math.max(0L, j), Math.max(0L, j), timeUnit, a));
    }

    public static <T> l<T> o(T t) {
        Objects.requireNonNull(t, "item is null");
        return RxJavaPlugins.onAssembly(new k0.b.z.e.c.l(t));
    }

    public static <T> l<T> q(Iterable<? extends o<? extends T>> iterable) {
        Objects.requireNonNull(iterable, "source is null");
        return RxJavaPlugins.onAssembly(new i(iterable)).j(a.a);
    }

    public static <T> l<T> r(Iterable<? extends o<? extends T>> iterable, int i) {
        l onAssembly = RxJavaPlugins.onAssembly(new i(iterable));
        k0.b.y.e<Object, Object> eVar = a.a;
        Objects.requireNonNull(onAssembly);
        return onAssembly.k(eVar, false, i, f.a);
    }

    @Override // k0.b.o
    public final void c(p<? super T> pVar) {
        Objects.requireNonNull(pVar, "observer is null");
        try {
            p<? super T> onSubscribe = RxJavaPlugins.onSubscribe(this, pVar);
            Objects.requireNonNull(onSubscribe, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            u(onSubscribe);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            h.c4(th);
            RxJavaPlugins.onError(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final <R> l<R> d(k0.b.y.e<? super T, ? extends o<? extends R>> eVar) {
        b.a(2, "prefetch");
        if (!(this instanceof c)) {
            return RxJavaPlugins.onAssembly(new ObservableConcatMap(this, eVar, 2, ErrorMode.IMMEDIATE));
        }
        Object call = ((c) this).call();
        if (call == null) {
            return g();
        }
        return RxJavaPlugins.onAssembly(new o(call, eVar));
    }

    public final l<T> e(long j, TimeUnit timeUnit) {
        q a = k0.b.d0.a.a();
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(a, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableDebounceTimed(this, j, timeUnit, a));
    }

    public final l<T> f(d<? super T> dVar, d<? super Throwable> dVar2, k0.b.y.a aVar, k0.b.y.a aVar2) {
        Objects.requireNonNull(dVar, "onNext is null");
        Objects.requireNonNull(dVar2, "onError is null");
        Objects.requireNonNull(aVar, "onComplete is null");
        Objects.requireNonNull(aVar2, "onAfterTerminate is null");
        return RxJavaPlugins.onAssembly(new k0.b.z.e.c.c(this, dVar, dVar2, aVar, aVar2));
    }

    public final l<T> i(k0.b.y.f<? super T> fVar) {
        return RxJavaPlugins.onAssembly(new g(this, fVar));
    }

    public final <R> l<R> j(k0.b.y.e<? super T, ? extends o<? extends R>> eVar) {
        return k(eVar, false, Integer.MAX_VALUE, f.a);
    }

    public final <R> l<R> k(k0.b.y.e<? super T, ? extends o<? extends R>> eVar, boolean z, int i, int i2) {
        Objects.requireNonNull(eVar, "mapper is null");
        b.a(i, "maxConcurrency");
        b.a(i2, "bufferSize");
        if (!(this instanceof c)) {
            return RxJavaPlugins.onAssembly(new ObservableFlatMap(this, eVar, z, i, i2));
        }
        Object call = ((c) this).call();
        if (call == null) {
            return g();
        }
        return RxJavaPlugins.onAssembly(new o(call, eVar));
    }

    public final a l(k0.b.y.e<? super T, ? extends e> eVar) {
        return RxJavaPlugins.onAssembly(new ObservableFlatMapCompletableCompletable(this, eVar, false));
    }

    public final <R> l<R> p(k0.b.y.e<? super T, ? extends R> eVar) {
        return RxJavaPlugins.onAssembly(new m(this, eVar));
    }

    public final l<T> s(q qVar) {
        int i = f.a;
        Objects.requireNonNull(qVar, "scheduler is null");
        b.a(i, "bufferSize");
        return RxJavaPlugins.onAssembly(new ObservableObserveOn(this, qVar, false, i));
    }

    public final k0.b.w.a t(d<? super T> dVar, d<? super Throwable> dVar2, k0.b.y.a aVar, d<? super k0.b.w.a> dVar3) {
        Objects.requireNonNull(dVar, "onNext is null");
        Objects.requireNonNull(dVar2, "onError is null");
        LambdaObserver lambdaObserver = new LambdaObserver(dVar, dVar2, aVar, dVar3);
        c(lambdaObserver);
        return lambdaObserver;
    }

    public abstract void u(p<? super T> pVar);

    public final l<T> v(q qVar) {
        Objects.requireNonNull(qVar, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableSubscribeOn(this, qVar));
    }
}
