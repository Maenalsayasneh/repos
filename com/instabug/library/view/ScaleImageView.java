package com.instabug.library.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes2.dex */
public class ScaleImageView extends ImageView implements View.OnTouchListener {
    private float MAX_SCALE;
    private boolean isScaling;
    private Context mContext;
    private GestureDetector mDetector;
    private int mHeight;
    private int mIntrinsicHeight;
    private int mIntrinsicWidth;
    private Matrix mMatrix;
    private final float[] mMatrixValues;
    private float mMinScale;
    private float mPrevDistance;
    private int mPrevMoveX;
    private int mPrevMoveY;
    private float mScale;
    private int mWidth;

    /* loaded from: classes2.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            ScaleImageView.this.maxZoomTo((int) motionEvent.getX(), (int) motionEvent.getY());
            ScaleImageView.this.cutting();
            return super.onDoubleTap(motionEvent);
        }
    }

    public ScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MAX_SCALE = 5.0f;
        this.mMatrixValues = new float[9];
        this.mContext = context;
        initialize();
    }

    private float dispDistance() {
        int i = this.mWidth;
        int i2 = this.mHeight;
        return (float) Math.sqrt((double) ((i2 * i2) + (i * i)));
    }

    private float distance(float f, float f2, float f3, float f4) {
        float f5 = f - f2;
        float f6 = f3 - f4;
        return (float) Math.sqrt((double) ((f6 * f6) + (f5 * f5)));
    }

    private void initialize() {
        setScaleType(ImageView.ScaleType.MATRIX);
        this.mMatrix = new Matrix();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            this.mIntrinsicWidth = drawable.getIntrinsicWidth();
            this.mIntrinsicHeight = drawable.getIntrinsicHeight();
            setOnTouchListener(this);
        }
        this.mDetector = new GestureDetector(this.mContext, new a());
    }

    public void cutting() {
        int scale = (int) (getScale() * ((float) this.mIntrinsicWidth));
        int scale2 = (int) (getScale() * ((float) this.mIntrinsicHeight));
        if (getTranslateX() < ((float) (-(scale - this.mWidth)))) {
            this.mMatrix.postTranslate(-((getTranslateX() + ((float) scale)) - ((float) this.mWidth)), 0.0f);
        }
        if (getTranslateX() > 0.0f) {
            this.mMatrix.postTranslate(-getTranslateX(), 0.0f);
        }
        if (getTranslateY() < ((float) (-(scale2 - this.mHeight)))) {
            this.mMatrix.postTranslate(0.0f, -((getTranslateY() + ((float) scale2)) - ((float) this.mHeight)));
        }
        if (getTranslateY() > 0.0f) {
            this.mMatrix.postTranslate(0.0f, -getTranslateY());
        }
        int i = this.mWidth;
        if (scale < i) {
            this.mMatrix.postTranslate(((float) (i - scale)) / 2.0f, 0.0f);
        }
        int i2 = this.mHeight;
        if (scale2 < i2) {
            this.mMatrix.postTranslate(0.0f, ((float) (i2 - scale2)) / 2.0f);
        }
        setImageMatrix(this.mMatrix);
    }

    public float getScale() {
        return getValue(this.mMatrix, 0);
    }

    public float getTranslateX() {
        return getValue(this.mMatrix, 2);
    }

    public float getTranslateY() {
        return getValue(this.mMatrix, 5);
    }

    public float getValue(Matrix matrix, int i) {
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[i];
    }

    public void maxZoomTo(int i, int i2) {
        if (this.mMinScale != getScale()) {
            float scale = getScale();
            float f = this.mMinScale;
            if (scale - f > 0.1f) {
                zoomTo(f / getScale(), i, i2);
                return;
            }
        }
        zoomTo(this.MAX_SCALE / getScale(), i, i2);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
        if (r2 != 262) goto L_0x00c1;
     */
    @Override // android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        int pointerCount = motionEvent.getPointerCount();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 5) {
                        if (action != 6) {
                            if (action != 261) {
                            }
                        }
                    }
                } else if (pointerCount >= 2 && this.isScaling) {
                    float distance = distance(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
                    this.mPrevDistance = distance;
                    float dispDistance = ((distance - this.mPrevDistance) / dispDistance()) + 1.0f;
                    zoomTo(dispDistance * dispDistance, this.mWidth / 2, this.mHeight / 2);
                    cutting();
                } else if (!this.isScaling) {
                    int x = this.mPrevMoveX - ((int) motionEvent.getX());
                    int y = this.mPrevMoveY - ((int) motionEvent.getY());
                    this.mPrevMoveX = (int) motionEvent.getX();
                    this.mPrevMoveY = (int) motionEvent.getY();
                    this.mMatrix.postTranslate((float) (-x), (float) (-y));
                    cutting();
                }
                return true;
            }
            if (motionEvent.getPointerCount() <= 1) {
                this.isScaling = false;
            }
            return true;
        }
        if (pointerCount >= 2) {
            this.mPrevDistance = distance(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
            this.isScaling = true;
        } else {
            this.mPrevMoveX = (int) motionEvent.getX();
            this.mPrevMoveY = (int) motionEvent.getY();
        }
        return true;
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int i, int i2, int i3, int i4) {
        int i5;
        int i6 = i3 - i;
        this.mWidth = i6;
        this.mHeight = i4 - i2;
        this.mMatrix.reset();
        float f = ((float) i6) / ((float) this.mIntrinsicWidth);
        this.mScale = f;
        float f2 = (float) this.mIntrinsicHeight;
        float f3 = (float) this.mHeight;
        int i7 = 0;
        if (f * f2 > f3) {
            float f4 = f3 / f2;
            this.mScale = f4;
            this.mMatrix.postScale(f4, f4);
            i5 = (i3 - this.mWidth) / 2;
        } else {
            this.mMatrix.postScale(f, f);
            i7 = (i4 - this.mHeight) / 2;
            i5 = 0;
        }
        this.mMatrix.postTranslate((float) i5, (float) i7);
        setImageMatrix(this.mMatrix);
        float f5 = this.mScale;
        this.mMinScale = f5;
        zoomTo(f5, this.mWidth / 2, this.mHeight / 2);
        cutting();
        return super.setFrame(i, i2, i3, i4);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        initialize();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        initialize();
    }

    public void zoomTo(float f, int i, int i2) {
        if (getScale() * f >= this.mMinScale) {
            if (f < 1.0f || getScale() * f <= this.MAX_SCALE) {
                this.mMatrix.postScale(f, f);
                Matrix matrix = this.mMatrix;
                float f2 = (float) this.mWidth;
                float f3 = (float) this.mHeight;
                matrix.postTranslate((-((f2 * f) - f2)) / 2.0f, (-((f3 * f) - f3)) / 2.0f);
                this.mMatrix.postTranslate(((float) (-(i - (this.mWidth / 2)))) * f, 0.0f);
                this.mMatrix.postTranslate(0.0f, ((float) (-(i2 - (this.mHeight / 2)))) * f);
                setImageMatrix(this.mMatrix);
            }
        }
    }

    public ScaleImageView(Context context) {
        super(context);
        this.MAX_SCALE = 5.0f;
        this.mMatrixValues = new float[9];
        this.mContext = context;
        initialize();
    }
}
