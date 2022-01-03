package com.theartofdev.edmodo.cropper;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import i0.p.a.a.e;
/* loaded from: classes4.dex */
public final class CropWindowMoveHandler {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final Type e;
    public final PointF f;

    /* loaded from: classes4.dex */
    public enum Type {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        CENTER
    }

    static {
        new Matrix();
    }

    public CropWindowMoveHandler(Type type, e eVar, float f, float f2) {
        float f3;
        float f4;
        float f5;
        PointF pointF = new PointF();
        this.f = pointF;
        this.e = type;
        this.a = eVar.d();
        this.b = eVar.c();
        this.c = eVar.b();
        this.d = eVar.a();
        RectF e = eVar.e();
        float f6 = 0.0f;
        switch (type.ordinal()) {
            case 0:
                f6 = e.left - f;
                f4 = e.top;
                f3 = f4 - f2;
                break;
            case 1:
                f6 = e.right - f;
                f4 = e.top;
                f3 = f4 - f2;
                break;
            case 2:
                f6 = e.left - f;
                f4 = e.bottom;
                f3 = f4 - f2;
                break;
            case 3:
                f6 = e.right - f;
                f4 = e.bottom;
                f3 = f4 - f2;
                break;
            case 4:
                f5 = e.left;
                f6 = f5 - f;
                f3 = 0.0f;
                break;
            case 5:
                f4 = e.top;
                f3 = f4 - f2;
                break;
            case 6:
                f5 = e.right;
                f6 = f5 - f;
                f3 = 0.0f;
                break;
            case 7:
                f4 = e.bottom;
                f3 = f4 - f2;
                break;
            case 8:
                f6 = e.centerX() - f;
                f4 = e.centerY();
                f3 = f4 - f2;
                break;
            default:
                f3 = 0.0f;
                break;
        }
        pointF.x = f6;
        pointF.y = f3;
    }

    public static float g(float f, float f2, float f3, float f4) {
        return (f3 - f) / (f4 - f2);
    }

    public final void a(RectF rectF, float f, RectF rectF2, int i, float f2, float f3, boolean z, boolean z2) {
        float f4 = (float) i;
        if (f > f4) {
            f = ((f - f4) / 1.05f) + f4;
            this.f.y -= (f - f4) / 1.1f;
        }
        float f5 = rectF2.bottom;
        if (f > f5) {
            this.f.y -= (f - f5) / 2.0f;
        }
        if (f5 - f < f2) {
            f = f5;
        }
        float f6 = rectF.top;
        float f7 = this.b;
        if (f - f6 < f7) {
            f = f6 + f7;
        }
        float f8 = this.d;
        if (f - f6 > f8) {
            f = f6 + f8;
        }
        if (f5 - f < f2) {
            f = f5;
        }
        if (f3 > 0.0f) {
            float f9 = (f - f6) * f3;
            float f10 = this.a;
            if (f9 < f10) {
                f = Math.min(f5, (f10 / f3) + f6);
                f9 = (f - rectF.top) * f3;
            }
            float f11 = this.c;
            if (f9 > f11) {
                f = Math.min(rectF2.bottom, (f11 / f3) + rectF.top);
                f9 = (f - rectF.top) * f3;
            }
            if (!z || !z2) {
                if (z) {
                    float f12 = rectF.right;
                    float f13 = rectF2.left;
                    if (f12 - f9 < f13) {
                        f = Math.min(rectF2.bottom, ((f12 - f13) / f3) + rectF.top);
                        f9 = (f - rectF.top) * f3;
                    }
                }
                if (z2) {
                    float f14 = rectF.left;
                    float f15 = rectF2.right;
                    if (f9 + f14 > f15) {
                        f = Math.min(f, Math.min(rectF2.bottom, ((f15 - f14) / f3) + rectF.top));
                    }
                }
            } else {
                f = Math.min(f, Math.min(rectF2.bottom, (rectF2.width() / f3) + rectF.top));
            }
        }
        rectF.bottom = f;
    }

    public final void b(RectF rectF, float f, RectF rectF2, float f2, float f3, boolean z, boolean z2) {
        if (f < 0.0f) {
            f /= 1.05f;
            this.f.x -= f / 1.1f;
        }
        float f4 = rectF2.left;
        if (f < f4) {
            this.f.x -= (f - f4) / 2.0f;
        }
        if (f - f4 < f2) {
            f = f4;
        }
        float f5 = rectF.right;
        float f6 = this.a;
        if (f5 - f < f6) {
            f = f5 - f6;
        }
        float f7 = this.c;
        if (f5 - f > f7) {
            f = f5 - f7;
        }
        if (f - f4 < f2) {
            f = f4;
        }
        if (f3 > 0.0f) {
            float f8 = (f5 - f) / f3;
            float f9 = this.b;
            if (f8 < f9) {
                f = Math.max(f4, f5 - (f9 * f3));
                f8 = (rectF.right - f) / f3;
            }
            float f10 = this.d;
            if (f8 > f10) {
                f = Math.max(rectF2.left, rectF.right - (f10 * f3));
                f8 = (rectF.right - f) / f3;
            }
            if (!z || !z2) {
                if (z) {
                    float f11 = rectF.bottom;
                    float f12 = rectF2.top;
                    if (f11 - f8 < f12) {
                        f = Math.max(rectF2.left, rectF.right - ((f11 - f12) * f3));
                        f8 = (rectF.right - f) / f3;
                    }
                }
                if (z2) {
                    float f13 = rectF.top;
                    float f14 = rectF2.bottom;
                    if (f8 + f13 > f14) {
                        f = Math.max(f, Math.max(rectF2.left, rectF.right - ((f14 - f13) * f3)));
                    }
                }
            } else {
                f = Math.max(f, Math.max(rectF2.left, rectF.right - (rectF2.height() * f3)));
            }
        }
        rectF.left = f;
    }

    public final void c(RectF rectF, RectF rectF2, float f) {
        rectF.inset((rectF.width() - (rectF.height() * f)) / 2.0f, 0.0f);
        float f2 = rectF.left;
        float f3 = rectF2.left;
        if (f2 < f3) {
            rectF.offset(f3 - f2, 0.0f);
        }
        float f4 = rectF.right;
        float f5 = rectF2.right;
        if (f4 > f5) {
            rectF.offset(f5 - f4, 0.0f);
        }
    }

    public final void d(RectF rectF, float f, RectF rectF2, int i, float f2, float f3, boolean z, boolean z2) {
        float f4 = (float) i;
        if (f > f4) {
            f = ((f - f4) / 1.05f) + f4;
            this.f.x -= (f - f4) / 1.1f;
        }
        float f5 = rectF2.right;
        if (f > f5) {
            this.f.x -= (f - f5) / 2.0f;
        }
        if (f5 - f < f2) {
            f = f5;
        }
        float f6 = rectF.left;
        float f7 = this.a;
        if (f - f6 < f7) {
            f = f6 + f7;
        }
        float f8 = this.c;
        if (f - f6 > f8) {
            f = f6 + f8;
        }
        if (f5 - f < f2) {
            f = f5;
        }
        if (f3 > 0.0f) {
            float f9 = (f - f6) / f3;
            float f10 = this.b;
            if (f9 < f10) {
                f = Math.min(f5, (f10 * f3) + f6);
                f9 = (f - rectF.left) / f3;
            }
            float f11 = this.d;
            if (f9 > f11) {
                f = Math.min(rectF2.right, (f11 * f3) + rectF.left);
                f9 = (f - rectF.left) / f3;
            }
            if (!z || !z2) {
                if (z) {
                    float f12 = rectF.bottom;
                    float f13 = rectF2.top;
                    if (f12 - f9 < f13) {
                        f = Math.min(rectF2.right, ((f12 - f13) * f3) + rectF.left);
                        f9 = (f - rectF.left) / f3;
                    }
                }
                if (z2) {
                    float f14 = rectF.top;
                    float f15 = rectF2.bottom;
                    if (f9 + f14 > f15) {
                        f = Math.min(f, Math.min(rectF2.right, ((f15 - f14) * f3) + rectF.left));
                    }
                }
            } else {
                f = Math.min(f, Math.min(rectF2.right, (rectF2.height() * f3) + rectF.left));
            }
        }
        rectF.right = f;
    }

    public final void e(RectF rectF, float f, RectF rectF2, float f2, float f3, boolean z, boolean z2) {
        if (f < 0.0f) {
            f /= 1.05f;
            this.f.y -= f / 1.1f;
        }
        float f4 = rectF2.top;
        if (f < f4) {
            this.f.y -= (f - f4) / 2.0f;
        }
        if (f - f4 < f2) {
            f = f4;
        }
        float f5 = rectF.bottom;
        float f6 = this.b;
        if (f5 - f < f6) {
            f = f5 - f6;
        }
        float f7 = this.d;
        if (f5 - f > f7) {
            f = f5 - f7;
        }
        if (f - f4 < f2) {
            f = f4;
        }
        if (f3 > 0.0f) {
            float f8 = (f5 - f) * f3;
            float f9 = this.a;
            if (f8 < f9) {
                f = Math.max(f4, f5 - (f9 / f3));
                f8 = (rectF.bottom - f) * f3;
            }
            float f10 = this.c;
            if (f8 > f10) {
                f = Math.max(rectF2.top, rectF.bottom - (f10 / f3));
                f8 = (rectF.bottom - f) * f3;
            }
            if (!z || !z2) {
                if (z) {
                    float f11 = rectF.right;
                    float f12 = rectF2.left;
                    if (f11 - f8 < f12) {
                        f = Math.max(rectF2.top, rectF.bottom - ((f11 - f12) / f3));
                        f8 = (rectF.bottom - f) * f3;
                    }
                }
                if (z2) {
                    float f13 = rectF.left;
                    float f14 = rectF2.right;
                    if (f8 + f13 > f14) {
                        f = Math.max(f, Math.max(rectF2.top, rectF.bottom - ((f14 - f13) / f3)));
                    }
                }
            } else {
                f = Math.max(f, Math.max(rectF2.top, rectF.bottom - (rectF2.width() / f3)));
            }
        }
        rectF.top = f;
    }

    public final void f(RectF rectF, RectF rectF2, float f) {
        rectF.inset(0.0f, (rectF.height() - (rectF.width() / f)) / 2.0f);
        float f2 = rectF.top;
        float f3 = rectF2.top;
        if (f2 < f3) {
            rectF.offset(0.0f, f3 - f2);
        }
        float f4 = rectF.bottom;
        float f5 = rectF2.bottom;
        if (f4 > f5) {
            rectF.offset(0.0f, f5 - f4);
        }
    }
}
