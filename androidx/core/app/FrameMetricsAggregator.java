package androidx.core.app;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class FrameMetricsAggregator {
    public static final int ANIMATION_DURATION = 256;
    public static final int ANIMATION_INDEX = 8;
    public static final int COMMAND_DURATION = 32;
    public static final int COMMAND_INDEX = 5;
    public static final int DELAY_DURATION = 128;
    public static final int DELAY_INDEX = 7;
    public static final int DRAW_DURATION = 8;
    public static final int DRAW_INDEX = 3;
    public static final int EVERY_DURATION = 511;
    public static final int INPUT_DURATION = 2;
    public static final int INPUT_INDEX = 1;
    private static final int LAST_INDEX = 8;
    public static final int LAYOUT_MEASURE_DURATION = 4;
    public static final int LAYOUT_MEASURE_INDEX = 2;
    public static final int SWAP_DURATION = 64;
    public static final int SWAP_INDEX = 6;
    public static final int SYNC_DURATION = 16;
    public static final int SYNC_INDEX = 4;
    public static final int TOTAL_DURATION = 1;
    public static final int TOTAL_INDEX = 0;
    private b mInstance;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface MetricType {
    }

    /* loaded from: classes.dex */
    public static class a extends b {
        public static HandlerThread a;
        public static Handler b;
        public int c;
        public SparseIntArray[] d = new SparseIntArray[9];
        public ArrayList<WeakReference<Activity>> e = new ArrayList<>();
        public Window.OnFrameMetricsAvailableListener f = new Window$OnFrameMetricsAvailableListenerC0003a();

        /* renamed from: androidx.core.app.FrameMetricsAggregator$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class Window$OnFrameMetricsAvailableListenerC0003a implements Window.OnFrameMetricsAvailableListener {
            public Window$OnFrameMetricsAvailableListenerC0003a() {
            }

            @Override // android.view.Window.OnFrameMetricsAvailableListener
            public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i) {
                a aVar = a.this;
                if ((aVar.c & 1) != 0) {
                    aVar.f(aVar.d[0], frameMetrics.getMetric(8));
                }
                a aVar2 = a.this;
                if ((aVar2.c & 2) != 0) {
                    aVar2.f(aVar2.d[1], frameMetrics.getMetric(1));
                }
                a aVar3 = a.this;
                if ((aVar3.c & 4) != 0) {
                    aVar3.f(aVar3.d[2], frameMetrics.getMetric(3));
                }
                a aVar4 = a.this;
                if ((aVar4.c & 8) != 0) {
                    aVar4.f(aVar4.d[3], frameMetrics.getMetric(4));
                }
                a aVar5 = a.this;
                if ((aVar5.c & 16) != 0) {
                    aVar5.f(aVar5.d[4], frameMetrics.getMetric(5));
                }
                a aVar6 = a.this;
                if ((aVar6.c & 64) != 0) {
                    aVar6.f(aVar6.d[6], frameMetrics.getMetric(7));
                }
                a aVar7 = a.this;
                if ((aVar7.c & 32) != 0) {
                    aVar7.f(aVar7.d[5], frameMetrics.getMetric(6));
                }
                a aVar8 = a.this;
                if ((aVar8.c & 128) != 0) {
                    aVar8.f(aVar8.d[7], frameMetrics.getMetric(0));
                }
                a aVar9 = a.this;
                if ((aVar9.c & 256) != 0) {
                    aVar9.f(aVar9.d[8], frameMetrics.getMetric(2));
                }
            }
        }

        public a(int i) {
            this.c = i;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.b
        public void a(Activity activity) {
            if (a == null) {
                HandlerThread handlerThread = new HandlerThread("FrameMetricsAggregator");
                a = handlerThread;
                handlerThread.start();
                b = new Handler(a.getLooper());
            }
            for (int i = 0; i <= 8; i++) {
                SparseIntArray[] sparseIntArrayArr = this.d;
                if (sparseIntArrayArr[i] == null && (this.c & (1 << i)) != 0) {
                    sparseIntArrayArr[i] = new SparseIntArray();
                }
            }
            activity.getWindow().addOnFrameMetricsAvailableListener(this.f, b);
            this.e.add(new WeakReference<>(activity));
        }

        @Override // androidx.core.app.FrameMetricsAggregator.b
        public SparseIntArray[] b() {
            return this.d;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.b
        public SparseIntArray[] c(Activity activity) {
            Iterator<WeakReference<Activity>> it = this.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WeakReference<Activity> next = it.next();
                if (next.get() == activity) {
                    this.e.remove(next);
                    break;
                }
            }
            activity.getWindow().removeOnFrameMetricsAvailableListener(this.f);
            return this.d;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.b
        public SparseIntArray[] d() {
            SparseIntArray[] sparseIntArrayArr = this.d;
            this.d = new SparseIntArray[9];
            return sparseIntArrayArr;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.b
        public SparseIntArray[] e() {
            for (int size = this.e.size() - 1; size >= 0; size--) {
                WeakReference<Activity> weakReference = this.e.get(size);
                Activity activity = weakReference.get();
                if (weakReference.get() != null) {
                    activity.getWindow().removeOnFrameMetricsAvailableListener(this.f);
                    this.e.remove(size);
                }
            }
            return this.d;
        }

        public void f(SparseIntArray sparseIntArray, long j) {
            if (sparseIntArray != null) {
                int i = (int) ((500000 + j) / 1000000);
                if (j >= 0) {
                    sparseIntArray.put(i, sparseIntArray.get(i) + 1);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public void a(Activity activity) {
            throw null;
        }

        public SparseIntArray[] b() {
            throw null;
        }

        public SparseIntArray[] c(Activity activity) {
            throw null;
        }

        public SparseIntArray[] d() {
            throw null;
        }

        public SparseIntArray[] e() {
            throw null;
        }
    }

    public FrameMetricsAggregator() {
        this(1);
    }

    public void add(Activity activity) {
        this.mInstance.a(activity);
    }

    public SparseIntArray[] getMetrics() {
        return this.mInstance.b();
    }

    public SparseIntArray[] remove(Activity activity) {
        return this.mInstance.c(activity);
    }

    public SparseIntArray[] reset() {
        return this.mInstance.d();
    }

    public SparseIntArray[] stop() {
        return this.mInstance.e();
    }

    public FrameMetricsAggregator(int i) {
        this.mInstance = new a(i);
    }
}
