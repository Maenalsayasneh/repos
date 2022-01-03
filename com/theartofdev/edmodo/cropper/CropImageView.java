package com.theartofdev.edmodo.cropper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.theartofdev.edmodo.cropper.CropOverlayView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.UUID;
/* loaded from: classes4.dex */
public class CropImageView extends FrameLayout {
    public static final /* synthetic */ int c = 0;
    public RectF A2;
    public int B2;
    public boolean C2;
    public Uri D2;
    public WeakReference<i0.p.a.a.b> E2;
    public WeakReference<i0.p.a.a.a> F2;
    public final ProgressBar Y1;
    public i0.p.a.a.d b2;
    public Bitmap c2;
    public final ImageView d;
    public int d2;
    public int e2;
    public boolean f2;
    public boolean g2;
    public int h2;
    public int i2;
    public int j2;
    public ScaleType k2;
    public boolean l2;
    public boolean m2;
    public boolean n2;
    public boolean o2;
    public int p2;
    public final CropOverlayView q;
    public e q2;
    public d r2;
    public f s2;
    public g t2;
    public c u2;
    public Uri v2;
    public float y2;
    public float z2;
    public final Matrix x = new Matrix();
    public final Matrix y = new Matrix();
    public final float[] Z1 = new float[8];
    public final float[] a2 = new float[8];
    public int w2 = 1;
    public float x2 = 1.0f;

    /* loaded from: classes4.dex */
    public enum CropShape {
        RECTANGLE,
        OVAL
    }

    /* loaded from: classes4.dex */
    public enum Guidelines {
        OFF,
        ON_TOUCH,
        ON
    }

    /* loaded from: classes4.dex */
    public enum RequestSizeOptions {
        NONE,
        SAMPLING,
        RESIZE_INSIDE,
        RESIZE_FIT,
        RESIZE_EXACT
    }

    /* loaded from: classes4.dex */
    public enum ScaleType {
        FIT_CENTER,
        CENTER,
        CENTER_CROP,
        CENTER_INSIDE
    }

    /* loaded from: classes4.dex */
    public class a implements CropOverlayView.b {
        public a() {
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public final Rect Y1;
        public final int Z1;
        public final int a2;
        public final Uri c;
        public final Uri d;
        public final Exception q;
        public final float[] x;
        public final Rect y;

        public b(Bitmap bitmap, Uri uri, Bitmap bitmap2, Uri uri2, Exception exc, float[] fArr, Rect rect, Rect rect2, int i, int i2) {
            this.c = uri;
            this.d = uri2;
            this.q = exc;
            this.x = fArr;
            this.y = rect;
            this.Y1 = rect2;
            this.Z1 = i;
            this.a2 = i2;
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(Rect rect);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(Rect rect);
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a();
    }

    /* loaded from: classes4.dex */
    public interface g {
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Bundle bundleExtra;
        this.l2 = false;
        this.m2 = true;
        this.n2 = true;
        this.o2 = true;
        CropImageOptions cropImageOptions = null;
        Intent intent = context instanceof Activity ? ((Activity) context).getIntent() : null;
        if (!(intent == null || (bundleExtra = intent.getBundleExtra("CROP_IMAGE_EXTRA_BUNDLE")) == null)) {
            cropImageOptions = (CropImageOptions) bundleExtra.getParcelable("CROP_IMAGE_EXTRA_OPTIONS");
        }
        if (cropImageOptions == null) {
            cropImageOptions = new CropImageOptions();
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CropImageView, 0, 0);
                try {
                    int i = R.styleable.CropImageView_cropFixAspectRatio;
                    cropImageOptions.e2 = obtainStyledAttributes.getBoolean(i, cropImageOptions.e2);
                    int i2 = R.styleable.CropImageView_cropAspectRatioX;
                    cropImageOptions.f2 = obtainStyledAttributes.getInteger(i2, cropImageOptions.f2);
                    cropImageOptions.g2 = obtainStyledAttributes.getInteger(R.styleable.CropImageView_cropAspectRatioY, cropImageOptions.g2);
                    cropImageOptions.y = ScaleType.values()[obtainStyledAttributes.getInt(R.styleable.CropImageView_cropScaleType, cropImageOptions.y.ordinal())];
                    cropImageOptions.a2 = obtainStyledAttributes.getBoolean(R.styleable.CropImageView_cropAutoZoomEnabled, cropImageOptions.a2);
                    cropImageOptions.b2 = obtainStyledAttributes.getBoolean(R.styleable.CropImageView_cropMultiTouchEnabled, cropImageOptions.b2);
                    cropImageOptions.c2 = obtainStyledAttributes.getInteger(R.styleable.CropImageView_cropMaxZoom, cropImageOptions.c2);
                    cropImageOptions.c = CropShape.values()[obtainStyledAttributes.getInt(R.styleable.CropImageView_cropShape, cropImageOptions.c.ordinal())];
                    cropImageOptions.x = Guidelines.values()[obtainStyledAttributes.getInt(R.styleable.CropImageView_cropGuidelines, cropImageOptions.x.ordinal())];
                    cropImageOptions.d = obtainStyledAttributes.getDimension(R.styleable.CropImageView_cropSnapRadius, cropImageOptions.d);
                    cropImageOptions.q = obtainStyledAttributes.getDimension(R.styleable.CropImageView_cropTouchRadius, cropImageOptions.q);
                    cropImageOptions.d2 = obtainStyledAttributes.getFloat(R.styleable.CropImageView_cropInitialCropWindowPaddingRatio, cropImageOptions.d2);
                    cropImageOptions.h2 = obtainStyledAttributes.getDimension(R.styleable.CropImageView_cropBorderLineThickness, cropImageOptions.h2);
                    cropImageOptions.i2 = obtainStyledAttributes.getInteger(R.styleable.CropImageView_cropBorderLineColor, cropImageOptions.i2);
                    int i3 = R.styleable.CropImageView_cropBorderCornerThickness;
                    cropImageOptions.j2 = obtainStyledAttributes.getDimension(i3, cropImageOptions.j2);
                    cropImageOptions.k2 = obtainStyledAttributes.getDimension(R.styleable.CropImageView_cropBorderCornerOffset, cropImageOptions.k2);
                    cropImageOptions.l2 = obtainStyledAttributes.getDimension(R.styleable.CropImageView_cropBorderCornerLength, cropImageOptions.l2);
                    cropImageOptions.m2 = obtainStyledAttributes.getInteger(R.styleable.CropImageView_cropBorderCornerColor, cropImageOptions.m2);
                    cropImageOptions.n2 = obtainStyledAttributes.getDimension(R.styleable.CropImageView_cropGuidelinesThickness, cropImageOptions.n2);
                    cropImageOptions.o2 = obtainStyledAttributes.getInteger(R.styleable.CropImageView_cropGuidelinesColor, cropImageOptions.o2);
                    cropImageOptions.p2 = obtainStyledAttributes.getInteger(R.styleable.CropImageView_cropBackgroundColor, cropImageOptions.p2);
                    cropImageOptions.Y1 = obtainStyledAttributes.getBoolean(R.styleable.CropImageView_cropShowCropOverlay, this.m2);
                    cropImageOptions.Z1 = obtainStyledAttributes.getBoolean(R.styleable.CropImageView_cropShowProgressBar, this.n2);
                    cropImageOptions.j2 = obtainStyledAttributes.getDimension(i3, cropImageOptions.j2);
                    cropImageOptions.q2 = (int) obtainStyledAttributes.getDimension(R.styleable.CropImageView_cropMinCropWindowWidth, (float) cropImageOptions.q2);
                    cropImageOptions.r2 = (int) obtainStyledAttributes.getDimension(R.styleable.CropImageView_cropMinCropWindowHeight, (float) cropImageOptions.r2);
                    cropImageOptions.s2 = (int) obtainStyledAttributes.getFloat(R.styleable.CropImageView_cropMinCropResultWidthPX, (float) cropImageOptions.s2);
                    cropImageOptions.t2 = (int) obtainStyledAttributes.getFloat(R.styleable.CropImageView_cropMinCropResultHeightPX, (float) cropImageOptions.t2);
                    cropImageOptions.u2 = (int) obtainStyledAttributes.getFloat(R.styleable.CropImageView_cropMaxCropResultWidthPX, (float) cropImageOptions.u2);
                    cropImageOptions.v2 = (int) obtainStyledAttributes.getFloat(R.styleable.CropImageView_cropMaxCropResultHeightPX, (float) cropImageOptions.v2);
                    int i4 = R.styleable.CropImageView_cropFlipHorizontally;
                    cropImageOptions.L2 = obtainStyledAttributes.getBoolean(i4, cropImageOptions.L2);
                    cropImageOptions.M2 = obtainStyledAttributes.getBoolean(i4, cropImageOptions.M2);
                    this.l2 = obtainStyledAttributes.getBoolean(R.styleable.CropImageView_cropSaveBitmapToInstanceState, this.l2);
                    if (obtainStyledAttributes.hasValue(i2) && obtainStyledAttributes.hasValue(i2) && !obtainStyledAttributes.hasValue(i)) {
                        cropImageOptions.e2 = true;
                    }
                } finally {
                    obtainStyledAttributes.recycle();
                }
            }
        }
        cropImageOptions.a();
        this.k2 = cropImageOptions.y;
        this.o2 = cropImageOptions.a2;
        this.p2 = cropImageOptions.c2;
        this.m2 = cropImageOptions.Y1;
        this.n2 = cropImageOptions.Z1;
        this.f2 = cropImageOptions.L2;
        this.g2 = cropImageOptions.M2;
        View inflate = LayoutInflater.from(context).inflate(R.layout.crop_image_view, (ViewGroup) this, true);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.ImageView_image);
        this.d = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        CropOverlayView cropOverlayView = (CropOverlayView) inflate.findViewById(R.id.CropOverlayView);
        this.q = cropOverlayView;
        cropOverlayView.setCropWindowChangeListener(new a());
        cropOverlayView.setInitialAttributeValues(cropImageOptions);
        this.Y1 = (ProgressBar) inflate.findViewById(R.id.CropProgressBar);
        h();
    }

    public final void a(float f2, float f3, boolean z, boolean z2) {
        float f4;
        if (this.c2 != null) {
            float f5 = 0.0f;
            if (f2 > 0.0f && f3 > 0.0f) {
                this.x.invert(this.y);
                RectF cropWindowRect = this.q.getCropWindowRect();
                this.y.mapRect(cropWindowRect);
                this.x.reset();
                this.x.postTranslate((f2 - ((float) this.c2.getWidth())) / 2.0f, (f3 - ((float) this.c2.getHeight())) / 2.0f);
                d();
                int i = this.e2;
                if (i > 0) {
                    this.x.postRotate((float) i, i0.p.a.a.c.m(this.Z1), i0.p.a.a.c.n(this.Z1));
                    d();
                }
                float min = Math.min(f2 / i0.p.a.a.c.t(this.Z1), f3 / i0.p.a.a.c.p(this.Z1));
                ScaleType scaleType = this.k2;
                if (scaleType == ScaleType.FIT_CENTER || ((scaleType == ScaleType.CENTER_INSIDE && min < 1.0f) || (min > 1.0f && this.o2))) {
                    this.x.postScale(min, min, i0.p.a.a.c.m(this.Z1), i0.p.a.a.c.n(this.Z1));
                    d();
                }
                float f6 = this.f2 ? -this.x2 : this.x2;
                float f7 = this.g2 ? -this.x2 : this.x2;
                this.x.postScale(f6, f7, i0.p.a.a.c.m(this.Z1), i0.p.a.a.c.n(this.Z1));
                d();
                this.x.mapRect(cropWindowRect);
                if (z) {
                    if (f2 > i0.p.a.a.c.t(this.Z1)) {
                        f4 = 0.0f;
                    } else {
                        f4 = Math.max(Math.min((f2 / 2.0f) - cropWindowRect.centerX(), -i0.p.a.a.c.q(this.Z1)), ((float) getWidth()) - i0.p.a.a.c.r(this.Z1)) / f6;
                    }
                    this.y2 = f4;
                    if (f3 <= i0.p.a.a.c.p(this.Z1)) {
                        f5 = Math.max(Math.min((f3 / 2.0f) - cropWindowRect.centerY(), -i0.p.a.a.c.s(this.Z1)), ((float) getHeight()) - i0.p.a.a.c.l(this.Z1)) / f7;
                    }
                    this.z2 = f5;
                } else {
                    this.y2 = Math.min(Math.max(this.y2 * f6, -cropWindowRect.left), (-cropWindowRect.right) + f2) / f6;
                    this.z2 = Math.min(Math.max(this.z2 * f7, -cropWindowRect.top), (-cropWindowRect.bottom) + f3) / f7;
                }
                this.x.postTranslate(this.y2 * f6, this.z2 * f7);
                cropWindowRect.offset(this.y2 * f6, this.z2 * f7);
                this.q.setCropWindowRect(cropWindowRect);
                d();
                this.q.invalidate();
                if (z2) {
                    i0.p.a.a.d dVar = this.b2;
                    float[] fArr = this.Z1;
                    Matrix matrix = this.x;
                    System.arraycopy(fArr, 0, dVar.x, 0, 8);
                    dVar.Y1.set(dVar.d.getCropWindowRect());
                    matrix.getValues(dVar.a2);
                    this.d.startAnimation(this.b2);
                } else {
                    this.d.setImageMatrix(this.x);
                }
                j(false);
            }
        }
    }

    public final void b() {
        Bitmap bitmap = this.c2;
        if (bitmap != null && (this.j2 > 0 || this.v2 != null)) {
            bitmap.recycle();
        }
        this.c2 = null;
        this.j2 = 0;
        this.v2 = null;
        this.w2 = 1;
        this.e2 = 0;
        this.x2 = 1.0f;
        this.y2 = 0.0f;
        this.z2 = 0.0f;
        this.x.reset();
        this.D2 = null;
        this.d.setImageBitmap(null);
        g();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d7  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void c(boolean z, boolean z2) {
        float f2;
        int width = getWidth();
        int height = getHeight();
        if (this.c2 != null && width > 0 && height > 0) {
            RectF cropWindowRect = this.q.getCropWindowRect();
            if (!z) {
                float f3 = 1.0f;
                if (this.o2 || this.x2 > 1.0f) {
                    if (this.x2 < ((float) this.p2)) {
                        float f4 = (float) width;
                        if (cropWindowRect.width() < f4 * 0.5f) {
                            float f5 = (float) height;
                            if (cropWindowRect.height() < 0.5f * f5) {
                                f2 = Math.min((float) this.p2, Math.min(f4 / ((cropWindowRect.width() / this.x2) / 0.64f), f5 / ((cropWindowRect.height() / this.x2) / 0.64f)));
                                if (this.x2 > 1.0f) {
                                    float f6 = (float) width;
                                    if (cropWindowRect.width() > f6 * 0.65f || cropWindowRect.height() > ((float) height) * 0.65f) {
                                        f2 = Math.max(1.0f, Math.min(f6 / ((cropWindowRect.width() / this.x2) / 0.51f), ((float) height) / ((cropWindowRect.height() / this.x2) / 0.51f)));
                                    }
                                }
                                if (this.o2) {
                                    f3 = f2;
                                }
                                if (f3 > 0.0f && f3 != this.x2) {
                                    if (z2) {
                                        if (this.b2 == null) {
                                            this.b2 = new i0.p.a.a.d(this.d, this.q);
                                        }
                                        i0.p.a.a.d dVar = this.b2;
                                        float[] fArr = this.Z1;
                                        Matrix matrix = this.x;
                                        dVar.reset();
                                        System.arraycopy(fArr, 0, dVar.q, 0, 8);
                                        dVar.y.set(dVar.d.getCropWindowRect());
                                        matrix.getValues(dVar.Z1);
                                    }
                                    this.x2 = f3;
                                    a((float) width, (float) height, true, z2);
                                }
                            }
                        }
                    }
                    f2 = 0.0f;
                    if (this.x2 > 1.0f) {
                    }
                    if (this.o2) {
                    }
                    if (f3 > 0.0f) {
                        if (z2) {
                        }
                        this.x2 = f3;
                        a((float) width, (float) height, true, z2);
                    }
                }
            } else if (cropWindowRect.left < 0.0f || cropWindowRect.top < 0.0f || cropWindowRect.right > ((float) width) || cropWindowRect.bottom > ((float) height)) {
                a((float) width, (float) height, false, false);
            }
            f fVar = this.s2;
            if (fVar != null && !z) {
                fVar.a();
            }
        }
    }

    public final void d() {
        float[] fArr = this.Z1;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = (float) this.c2.getWidth();
        float[] fArr2 = this.Z1;
        fArr2[3] = 0.0f;
        fArr2[4] = (float) this.c2.getWidth();
        this.Z1[5] = (float) this.c2.getHeight();
        float[] fArr3 = this.Z1;
        fArr3[6] = 0.0f;
        fArr3[7] = (float) this.c2.getHeight();
        this.x.mapPoints(this.Z1);
        float[] fArr4 = this.a2;
        fArr4[0] = 0.0f;
        fArr4[1] = 0.0f;
        fArr4[2] = 100.0f;
        fArr4[3] = 0.0f;
        fArr4[4] = 100.0f;
        fArr4[5] = 100.0f;
        fArr4[6] = 0.0f;
        fArr4[7] = 100.0f;
        this.x.mapPoints(fArr4);
    }

    public void e(int i) {
        int i2;
        if (this.c2 != null) {
            if (i < 0) {
                i2 = (i % 360) + 360;
            } else {
                i2 = i % 360;
            }
            CropOverlayView cropOverlayView = this.q;
            boolean z = !cropOverlayView.n2 && ((i2 > 45 && i2 < 135) || (i2 > 215 && i2 < 305));
            RectF rectF = i0.p.a.a.c.c;
            rectF.set(cropOverlayView.getCropWindowRect());
            float height = (z ? rectF.height() : rectF.width()) / 2.0f;
            float width = (z ? rectF.width() : rectF.height()) / 2.0f;
            if (z) {
                boolean z2 = this.f2;
                this.f2 = this.g2;
                this.g2 = z2;
            }
            this.x.invert(this.y);
            float[] fArr = i0.p.a.a.c.d;
            fArr[0] = rectF.centerX();
            fArr[1] = rectF.centerY();
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 1.0f;
            fArr[5] = 0.0f;
            this.y.mapPoints(fArr);
            this.e2 = (this.e2 + i2) % 360;
            a((float) getWidth(), (float) getHeight(), true, false);
            Matrix matrix = this.x;
            float[] fArr2 = i0.p.a.a.c.e;
            matrix.mapPoints(fArr2, fArr);
            float sqrt = (float) (((double) this.x2) / Math.sqrt(Math.pow((double) (fArr2[5] - fArr2[3]), 2.0d) + Math.pow((double) (fArr2[4] - fArr2[2]), 2.0d)));
            this.x2 = sqrt;
            this.x2 = Math.max(sqrt, 1.0f);
            a((float) getWidth(), (float) getHeight(), true, false);
            this.x.mapPoints(fArr2, fArr);
            double sqrt2 = Math.sqrt(Math.pow((double) (fArr2[5] - fArr2[3]), 2.0d) + Math.pow((double) (fArr2[4] - fArr2[2]), 2.0d));
            float f2 = (float) (((double) height) * sqrt2);
            float f3 = (float) (((double) width) * sqrt2);
            rectF.set(fArr2[0] - f2, fArr2[1] - f3, fArr2[0] + f2, fArr2[1] + f3);
            this.q.h();
            this.q.setCropWindowRect(rectF);
            a((float) getWidth(), (float) getHeight(), true, false);
            c(false, false);
            CropOverlayView cropOverlayView2 = this.q;
            RectF cropWindowRect = cropOverlayView2.getCropWindowRect();
            cropOverlayView2.d(cropWindowRect);
            cropOverlayView2.q.a.set(cropWindowRect);
        }
    }

    public final void f(Bitmap bitmap, int i, Uri uri, int i2, int i3) {
        Bitmap bitmap2 = this.c2;
        if (bitmap2 == null || !bitmap2.equals(bitmap)) {
            this.d.clearAnimation();
            b();
            this.c2 = bitmap;
            this.d.setImageBitmap(bitmap);
            this.v2 = uri;
            this.j2 = i;
            this.w2 = i2;
            this.e2 = i3;
            a((float) getWidth(), (float) getHeight(), true, false);
            CropOverlayView cropOverlayView = this.q;
            if (cropOverlayView != null) {
                cropOverlayView.h();
                g();
            }
        }
    }

    public final void g() {
        CropOverlayView cropOverlayView = this.q;
        if (cropOverlayView != null) {
            cropOverlayView.setVisibility((!this.m2 || this.c2 == null) ? 4 : 0);
        }
    }

    public Pair<Integer, Integer> getAspectRatio() {
        return new Pair<>(Integer.valueOf(this.q.getAspectRatioX()), Integer.valueOf(this.q.getAspectRatioY()));
    }

    public float[] getCropPoints() {
        RectF cropWindowRect = this.q.getCropWindowRect();
        float[] fArr = new float[8];
        float f2 = cropWindowRect.left;
        fArr[0] = f2;
        float f3 = cropWindowRect.top;
        fArr[1] = f3;
        float f4 = cropWindowRect.right;
        fArr[2] = f4;
        fArr[3] = f3;
        fArr[4] = f4;
        float f5 = cropWindowRect.bottom;
        fArr[5] = f5;
        fArr[6] = f2;
        fArr[7] = f5;
        this.x.invert(this.y);
        this.y.mapPoints(fArr);
        for (int i = 0; i < 8; i++) {
            fArr[i] = fArr[i] * ((float) this.w2);
        }
        return fArr;
    }

    public Rect getCropRect() {
        int i = this.w2;
        Bitmap bitmap = this.c2;
        if (bitmap == null) {
            return null;
        }
        float[] cropPoints = getCropPoints();
        int width = bitmap.getWidth() * i;
        int height = i * bitmap.getHeight();
        CropOverlayView cropOverlayView = this.q;
        return i0.p.a.a.c.o(cropPoints, width, height, cropOverlayView.n2, cropOverlayView.getAspectRatioX(), this.q.getAspectRatioY());
    }

    public CropShape getCropShape() {
        return this.q.getCropShape();
    }

    public RectF getCropWindowRect() {
        CropOverlayView cropOverlayView = this.q;
        if (cropOverlayView == null) {
            return null;
        }
        return cropOverlayView.getCropWindowRect();
    }

    public Bitmap getCroppedImage() {
        Bitmap bitmap;
        int i;
        RequestSizeOptions requestSizeOptions = RequestSizeOptions.NONE;
        if (this.c2 == null) {
            return null;
        }
        this.d.clearAnimation();
        if (this.v2 == null || (this.w2 <= 1 && requestSizeOptions != RequestSizeOptions.SAMPLING)) {
            i = 0;
            Bitmap bitmap2 = this.c2;
            float[] cropPoints = getCropPoints();
            int i2 = this.e2;
            CropOverlayView cropOverlayView = this.q;
            bitmap = i0.p.a.a.c.e(bitmap2, cropPoints, i2, cropOverlayView.n2, cropOverlayView.getAspectRatioX(), this.q.getAspectRatioY(), this.f2, this.g2).a;
        } else {
            int width = this.c2.getWidth() * this.w2;
            int height = this.c2.getHeight() * this.w2;
            Context context = getContext();
            Uri uri = this.v2;
            float[] cropPoints2 = getCropPoints();
            int i3 = this.e2;
            CropOverlayView cropOverlayView2 = this.q;
            i = 0;
            bitmap = i0.p.a.a.c.c(context, uri, cropPoints2, i3, width, height, cropOverlayView2.n2, cropOverlayView2.getAspectRatioX(), this.q.getAspectRatioY(), 0, 0, this.f2, this.g2).a;
        }
        return i0.p.a.a.c.u(bitmap, 0, i, requestSizeOptions);
    }

    public void getCroppedImageAsync() {
        RequestSizeOptions requestSizeOptions = RequestSizeOptions.NONE;
        if (this.u2 != null) {
            i(0, 0, requestSizeOptions, null, null, 0);
            return;
        }
        throw new IllegalArgumentException("mOnCropImageCompleteListener is not set");
    }

    public Guidelines getGuidelines() {
        return this.q.getGuidelines();
    }

    public int getImageResource() {
        return this.j2;
    }

    public Uri getImageUri() {
        return this.v2;
    }

    public int getMaxZoom() {
        return this.p2;
    }

    public int getRotatedDegrees() {
        return this.e2;
    }

    public ScaleType getScaleType() {
        return this.k2;
    }

    public Rect getWholeImageRect() {
        int i = this.w2;
        Bitmap bitmap = this.c2;
        if (bitmap == null) {
            return null;
        }
        return new Rect(0, 0, bitmap.getWidth() * i, bitmap.getHeight() * i);
    }

    public final void h() {
        int i = 0;
        boolean z = this.n2 && ((this.c2 == null && this.E2 != null) || this.F2 != null);
        ProgressBar progressBar = this.Y1;
        if (!z) {
            i = 4;
        }
        progressBar.setVisibility(i);
    }

    public void i(int i, int i2, RequestSizeOptions requestSizeOptions, Uri uri, Bitmap.CompressFormat compressFormat, int i3) {
        CropImageView cropImageView;
        Bitmap bitmap = this.c2;
        if (bitmap != null) {
            this.d.clearAnimation();
            WeakReference<i0.p.a.a.a> weakReference = this.F2;
            i0.p.a.a.a aVar = weakReference != null ? weakReference.get() : null;
            if (aVar != null) {
                aVar.cancel(true);
            }
            RequestSizeOptions requestSizeOptions2 = RequestSizeOptions.NONE;
            int i4 = requestSizeOptions != requestSizeOptions2 ? i : 0;
            int i5 = requestSizeOptions != requestSizeOptions2 ? i2 : 0;
            int width = bitmap.getWidth() * this.w2;
            int height = bitmap.getHeight();
            int i6 = this.w2;
            int i7 = height * i6;
            if (this.v2 == null || (i6 <= 1 && requestSizeOptions != RequestSizeOptions.SAMPLING)) {
                float[] cropPoints = getCropPoints();
                int i8 = this.e2;
                CropOverlayView cropOverlayView = this.q;
                cropImageView = this;
                cropImageView.F2 = new WeakReference<>(new i0.p.a.a.a(this, bitmap, cropPoints, i8, cropOverlayView.n2, cropOverlayView.getAspectRatioX(), this.q.getAspectRatioY(), i4, i5, this.f2, this.g2, requestSizeOptions, uri, compressFormat, i3));
            } else {
                Uri uri2 = this.v2;
                float[] cropPoints2 = getCropPoints();
                int i9 = this.e2;
                CropOverlayView cropOverlayView2 = this.q;
                this.F2 = new WeakReference<>(new i0.p.a.a.a(this, uri2, cropPoints2, i9, width, i7, cropOverlayView2.n2, cropOverlayView2.getAspectRatioX(), this.q.getAspectRatioY(), i4, i5, this.f2, this.g2, requestSizeOptions, uri, compressFormat, i3));
                cropImageView = this;
            }
            cropImageView.F2.get().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            h();
        }
    }

    public final void j(boolean z) {
        if (this.c2 != null && !z) {
            float t = (((float) this.w2) * 100.0f) / i0.p.a.a.c.t(this.a2);
            float p = (((float) this.w2) * 100.0f) / i0.p.a.a.c.p(this.a2);
            i0.p.a.a.e eVar = this.q.q;
            eVar.e = (float) getWidth();
            eVar.f = (float) getHeight();
            eVar.k = t;
            eVar.l = p;
        }
        this.q.i(z ? null : this.Z1, getWidth(), getHeight());
    }

    @Override // android.widget.FrameLayout, android.view.View, android.view.ViewGroup
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.h2 <= 0 || this.i2 <= 0) {
            j(true);
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = this.h2;
        layoutParams.height = this.i2;
        setLayoutParams(layoutParams);
        if (this.c2 != null) {
            float f2 = (float) (i3 - i);
            float f3 = (float) (i4 - i2);
            a(f2, f3, true, false);
            if (this.A2 != null) {
                int i5 = this.B2;
                if (i5 != this.d2) {
                    this.e2 = i5;
                    a(f2, f3, true, false);
                }
                this.x.mapRect(this.A2);
                this.q.setCropWindowRect(this.A2);
                c(false, false);
                CropOverlayView cropOverlayView = this.q;
                RectF cropWindowRect = cropOverlayView.getCropWindowRect();
                cropOverlayView.d(cropWindowRect);
                cropOverlayView.q.a.set(cropWindowRect);
                this.A2 = null;
            } else if (this.C2) {
                this.C2 = false;
                c(false, false);
            }
        } else {
            j(true);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        Bitmap bitmap = this.c2;
        if (bitmap != null) {
            if (size2 == 0) {
                size2 = bitmap.getHeight();
            }
            double width = size < this.c2.getWidth() ? ((double) size) / ((double) this.c2.getWidth()) : Double.POSITIVE_INFINITY;
            double height = size2 < this.c2.getHeight() ? ((double) size2) / ((double) this.c2.getHeight()) : Double.POSITIVE_INFINITY;
            if (width == Double.POSITIVE_INFINITY && height == Double.POSITIVE_INFINITY) {
                i4 = this.c2.getWidth();
                i3 = this.c2.getHeight();
            } else if (width <= height) {
                i3 = (int) (((double) this.c2.getHeight()) * width);
                i4 = size;
            } else {
                i4 = (int) (((double) this.c2.getWidth()) * height);
                i3 = size2;
            }
            if (mode != 1073741824) {
                size = mode == Integer.MIN_VALUE ? Math.min(i4, size) : i4;
            }
            if (mode2 != 1073741824) {
                size2 = mode2 == Integer.MIN_VALUE ? Math.min(i3, size2) : i3;
            }
            this.h2 = size;
            this.i2 = size2;
            setMeasuredDimension(size, size2);
            return;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            if (this.E2 == null && this.v2 == null && this.c2 == null && this.j2 == 0) {
                Uri uri = (Uri) bundle.getParcelable("LOADED_IMAGE_URI");
                if (uri != null) {
                    String string = bundle.getString("LOADED_IMAGE_STATE_BITMAP_KEY");
                    if (string != null) {
                        Pair<String, WeakReference<Bitmap>> pair = i0.p.a.a.c.g;
                        Bitmap bitmap = (pair == null || !((String) pair.first).equals(string)) ? null : (Bitmap) ((WeakReference) i0.p.a.a.c.g.second).get();
                        i0.p.a.a.c.g = null;
                        if (bitmap != null && !bitmap.isRecycled()) {
                            f(bitmap, 0, uri, bundle.getInt("LOADED_SAMPLE_SIZE"), 0);
                        }
                    }
                    if (this.v2 == null) {
                        setImageUriAsync(uri);
                    }
                } else {
                    int i = bundle.getInt("LOADED_IMAGE_RESOURCE");
                    if (i > 0) {
                        setImageResource(i);
                    } else {
                        Uri uri2 = (Uri) bundle.getParcelable("LOADING_IMAGE_URI");
                        if (uri2 != null) {
                            setImageUriAsync(uri2);
                        }
                    }
                }
                int i2 = bundle.getInt("DEGREES_ROTATED");
                this.B2 = i2;
                this.e2 = i2;
                Rect rect = (Rect) bundle.getParcelable("INITIAL_CROP_RECT");
                if (rect != null && (rect.width() > 0 || rect.height() > 0)) {
                    this.q.setInitialCropWindowRect(rect);
                }
                RectF rectF = (RectF) bundle.getParcelable("CROP_WINDOW_RECT");
                if (rectF != null && (rectF.width() > 0.0f || rectF.height() > 0.0f)) {
                    this.A2 = rectF;
                }
                this.q.setCropShape(CropShape.valueOf(bundle.getString("CROP_SHAPE")));
                this.o2 = bundle.getBoolean("CROP_AUTO_ZOOM_ENABLED");
                this.p2 = bundle.getInt("CROP_MAX_ZOOM");
                this.f2 = bundle.getBoolean("CROP_FLIP_HORIZONTALLY");
                this.g2 = bundle.getBoolean("CROP_FLIP_VERTICALLY");
            }
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        i0.p.a.a.b bVar;
        boolean z = true;
        if (this.v2 == null && this.c2 == null && this.j2 < 1) {
            return super.onSaveInstanceState();
        }
        Bundle bundle = new Bundle();
        Uri uri = this.v2;
        if (this.l2 && uri == null && this.j2 < 1) {
            Context context = getContext();
            Bitmap bitmap = this.c2;
            Uri uri2 = this.D2;
            Rect rect = i0.p.a.a.c.a;
            try {
                if (uri2 == null) {
                    uri2 = Uri.fromFile(File.createTempFile("aic_state_store_temp", ".jpg", context.getCacheDir()));
                } else if (new File(uri2.getPath()).exists()) {
                    z = false;
                }
                if (z) {
                    i0.p.a.a.c.v(context, bitmap, uri2, Bitmap.CompressFormat.JPEG, 95);
                }
                uri = uri2;
            } catch (Exception e2) {
                Log.w("AIC", "Failed to write bitmap to temp file for image-cropper save instance state", e2);
                uri = null;
            }
            this.D2 = uri;
        }
        if (!(uri == null || this.c2 == null)) {
            String uuid = UUID.randomUUID().toString();
            i0.p.a.a.c.g = new Pair<>(uuid, new WeakReference(this.c2));
            bundle.putString("LOADED_IMAGE_STATE_BITMAP_KEY", uuid);
        }
        WeakReference<i0.p.a.a.b> weakReference = this.E2;
        if (!(weakReference == null || (bVar = weakReference.get()) == null)) {
            bundle.putParcelable("LOADING_IMAGE_URI", bVar.b);
        }
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putParcelable("LOADED_IMAGE_URI", uri);
        bundle.putInt("LOADED_IMAGE_RESOURCE", this.j2);
        bundle.putInt("LOADED_SAMPLE_SIZE", this.w2);
        bundle.putInt("DEGREES_ROTATED", this.e2);
        bundle.putParcelable("INITIAL_CROP_RECT", this.q.getInitialCropWindowRect());
        RectF rectF = i0.p.a.a.c.c;
        rectF.set(this.q.getCropWindowRect());
        this.x.invert(this.y);
        this.y.mapRect(rectF);
        bundle.putParcelable("CROP_WINDOW_RECT", rectF);
        bundle.putString("CROP_SHAPE", this.q.getCropShape().name());
        bundle.putBoolean("CROP_AUTO_ZOOM_ENABLED", this.o2);
        bundle.putInt("CROP_MAX_ZOOM", this.p2);
        bundle.putBoolean("CROP_FLIP_HORIZONTALLY", this.f2);
        bundle.putBoolean("CROP_FLIP_VERTICALLY", this.g2);
        return bundle;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.C2 = i3 > 0 && i4 > 0;
    }

    public void setAutoZoomEnabled(boolean z) {
        if (this.o2 != z) {
            this.o2 = z;
            c(false, false);
            this.q.invalidate();
        }
    }

    public void setCropRect(Rect rect) {
        this.q.setInitialCropWindowRect(rect);
    }

    public void setCropShape(CropShape cropShape) {
        this.q.setCropShape(cropShape);
    }

    public void setFixedAspectRatio(boolean z) {
        this.q.setFixedAspectRatio(z);
    }

    public void setFlippedHorizontally(boolean z) {
        if (this.f2 != z) {
            this.f2 = z;
            a((float) getWidth(), (float) getHeight(), true, false);
        }
    }

    public void setFlippedVertically(boolean z) {
        if (this.g2 != z) {
            this.g2 = z;
            a((float) getWidth(), (float) getHeight(), true, false);
        }
    }

    public void setGuidelines(Guidelines guidelines) {
        this.q.setGuidelines(guidelines);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.q.setInitialCropWindowRect(null);
        f(bitmap, 0, null, 1, 0);
    }

    public void setImageResource(int i) {
        if (i != 0) {
            this.q.setInitialCropWindowRect(null);
            f(BitmapFactory.decodeResource(getResources(), i), i, null, 1, 0);
        }
    }

    public void setImageUriAsync(Uri uri) {
        if (uri != null) {
            WeakReference<i0.p.a.a.b> weakReference = this.E2;
            i0.p.a.a.b bVar = weakReference != null ? weakReference.get() : null;
            if (bVar != null) {
                bVar.cancel(true);
            }
            b();
            this.A2 = null;
            this.B2 = 0;
            this.q.setInitialCropWindowRect(null);
            WeakReference<i0.p.a.a.b> weakReference2 = new WeakReference<>(new i0.p.a.a.b(this, uri));
            this.E2 = weakReference2;
            weakReference2.get().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            h();
        }
    }

    public void setMaxZoom(int i) {
        if (this.p2 != i && i > 0) {
            this.p2 = i;
            c(false, false);
            this.q.invalidate();
        }
    }

    public void setMultiTouchEnabled(boolean z) {
        if (this.q.j(z)) {
            c(false, false);
            this.q.invalidate();
        }
    }

    public void setOnCropImageCompleteListener(c cVar) {
        this.u2 = cVar;
    }

    public void setOnCropWindowChangedListener(f fVar) {
        this.s2 = fVar;
    }

    public void setOnSetCropOverlayMovedListener(d dVar) {
        this.r2 = dVar;
    }

    public void setOnSetCropOverlayReleasedListener(e eVar) {
        this.q2 = eVar;
    }

    public void setOnSetImageUriCompleteListener(g gVar) {
        this.t2 = gVar;
    }

    public void setRotatedDegrees(int i) {
        int i2 = this.e2;
        if (i2 != i) {
            e(i - i2);
        }
    }

    public void setSaveBitmapToInstanceState(boolean z) {
        this.l2 = z;
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType != this.k2) {
            this.k2 = scaleType;
            this.x2 = 1.0f;
            this.z2 = 0.0f;
            this.y2 = 0.0f;
            this.q.h();
            requestLayout();
        }
    }

    public void setShowCropOverlay(boolean z) {
        if (this.m2 != z) {
            this.m2 = z;
            g();
        }
    }

    public void setShowProgressBar(boolean z) {
        if (this.n2 != z) {
            this.n2 = z;
            h();
        }
    }

    public void setSnapRadius(float f2) {
        if (f2 >= 0.0f) {
            this.q.setSnapRadius(f2);
        }
    }
}
