package i0.j.f.s.e;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
/* compiled from: GesturesHandler.java */
/* loaded from: classes2.dex */
public class b {
    public static boolean a = false;
    public static float b = -1.0f;
    public static int c = -1;
    public static float d;
    public static float e;
    public static AbstractC0204b f;

    /* compiled from: GesturesHandler.java */
    /* loaded from: classes2.dex */
    public static class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ View a;

        public a(View view) {
            this.a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            layoutParams.height = intValue;
            this.a.setLayoutParams(layoutParams);
        }
    }

    /* compiled from: GesturesHandler.java */
    /* renamed from: i0.j.f.s.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface AbstractC0204b {
        void a();

        void g();
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static void a(MotionEvent motionEvent, boolean z, boolean z2, AbstractC0204b bVar, View view, ViewGroup.LayoutParams layoutParams) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            boolean z3 = false;
            boolean z4 = true;
            if (actionMasked == 1) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                float f2 = d;
                float f3 = e;
                float abs = Math.abs(f2 - x);
                float f4 = (float) 5;
                if ((abs <= f4 && Math.abs(f3 - y) <= f4) && z && !a && !z2) {
                    bVar.a();
                    a = true;
                    c = -1;
                    z3 = true;
                }
                if (!a) {
                    if (z) {
                        int i2 = c;
                        int i3 = layoutParams.height;
                        if (i2 == i3 || i2 <= i3) {
                            if (i2 != i3 && i2 < i3) {
                                if (((float) i3) / ((float) i2) <= 1.4f) {
                                    b(view, i3, i2);
                                } else if (!z2) {
                                    bVar.a();
                                    c = -1;
                                }
                                if (!z4) {
                                    c = -1;
                                    return;
                                }
                                return;
                            }
                        } else if (((float) i3) / ((float) i2) < 0.7f) {
                            a = true;
                            bVar.g();
                            c = -1;
                        } else {
                            b(view, i3, i2);
                            if (!z4) {
                            }
                        }
                    } else {
                        int i4 = c;
                        int i5 = layoutParams.height;
                        if (i4 != i5 && i4 > i5) {
                            b(view, i5, i4);
                            if (!z4) {
                            }
                        }
                    }
                }
                z4 = z3;
                if (!z4) {
                }
            } else if (actionMasked == 2) {
                if (z2) {
                    if (b < motionEvent.getRawY()) {
                        layoutParams.height = (int) (((float) layoutParams.height) - (motionEvent.getRawY() - b));
                        view.setLayoutParams(layoutParams);
                        b = motionEvent.getRawY();
                    } else if (b > motionEvent.getRawY() && (i = layoutParams.height) < c) {
                        layoutParams.height = (int) ((b - motionEvent.getRawY()) + ((float) i));
                        view.setLayoutParams(layoutParams);
                        b = motionEvent.getRawY();
                    }
                } else if (z) {
                    if (b < motionEvent.getRawY()) {
                        layoutParams.height = (int) (((float) layoutParams.height) - (motionEvent.getRawY() - b));
                        view.setLayoutParams(layoutParams);
                        b = motionEvent.getRawY();
                    } else if (b > motionEvent.getRawY()) {
                        layoutParams.height = (int) ((b - motionEvent.getRawY()) + ((float) layoutParams.height));
                        view.setLayoutParams(layoutParams);
                        b = motionEvent.getRawY();
                    }
                } else if (b < motionEvent.getRawY()) {
                    layoutParams.height = (int) (((float) layoutParams.height) - (motionEvent.getRawY() - b));
                    view.setLayoutParams(layoutParams);
                    b = motionEvent.getRawY();
                } else if (b > motionEvent.getRawY()) {
                    int i6 = layoutParams.height;
                    if (i6 < c) {
                        layoutParams.height = (int) ((b - motionEvent.getRawY()) + ((float) i6));
                        view.setLayoutParams(layoutParams);
                    }
                    b = motionEvent.getRawY();
                }
                if (z) {
                    if (((float) layoutParams.height) / ((float) c) <= 2.0f) {
                        a = false;
                    } else if (!z2) {
                        bVar.a();
                        a = false;
                    }
                } else if (((float) layoutParams.height) / ((float) c) < 0.7f) {
                    a = true;
                    bVar.g();
                    c = -1;
                } else {
                    a = false;
                }
            }
        } else {
            d = motionEvent.getX();
            e = motionEvent.getY();
            b = motionEvent.getRawY();
        }
    }

    public static void b(View view, int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
        ofInt.addUpdateListener(new a(view));
        ofInt.setDuration(300L);
        ofInt.start();
    }

    public static void c(View view, MotionEvent motionEvent, boolean z, boolean z2, AbstractC0204b bVar) {
        View view2;
        if (f == null) {
            f = bVar;
        }
        if (z) {
            view2 = (View) view.getParent();
        } else {
            view2 = (View) view.getParent().getParent().getParent().getParent();
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (c == -1) {
            c = layoutParams.height;
        }
        a(motionEvent, z, z2, bVar, view2, layoutParams);
    }
}
