package com.instabug.library.ui.custom;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.util.TypedValue;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import i0.d.a.a.a;
/* loaded from: classes2.dex */
public class MaterialMenuDrawable extends Drawable implements MaterialMenu, Animatable {
    private static final float ARROW_BOT_LINE_ANGLE = 225.0f;
    private static final float ARROW_MID_LINE_ANGLE = 180.0f;
    private static final float ARROW_TOP_LINE_ANGLE = 135.0f;
    private static final int BASE_CIRCLE_RADIUS = 18;
    private static final int BASE_DRAWABLE_HEIGHT = 40;
    private static final int BASE_DRAWABLE_WIDTH = 40;
    private static final int BASE_ICON_WIDTH = 20;
    private static final float CHECK_BOTTOM_ANGLE = -90.0f;
    private static final float CHECK_MIDDLE_ANGLE = 135.0f;
    private static final int DEFAULT_CIRCLE_ALPHA = 200;
    public static final int DEFAULT_COLOR = -1;
    public static final int DEFAULT_SCALE = 1;
    public static final int DEFAULT_TRANSFORM_DURATION = 800;
    public static final boolean DEFAULT_VISIBLE = true;
    private static final float TRANSFORMATION_END = 2.0f;
    private static final float TRANSFORMATION_MID = 1.0f;
    private static final float TRANSFORMATION_START = 0.0f;
    private static final float X_BOT_LINE_ANGLE = -44.0f;
    private static final float X_ROTATION_ANGLE = 90.0f;
    private static final float X_TOP_LINE_ANGLE = 44.0f;
    private IconState animatingIconState;
    private AnimationState animationState;
    private Animator.AnimatorListener animatorListener;
    private final Paint circlePaint;
    private final float circleRadius;
    private IconState currentIconState;
    private final float dip1;
    private final float dip2;
    private final float dip3;
    private final float dip4;
    private final float dip8;
    private final float diph;
    private final int height;
    private final Paint iconPaint;
    private final float iconWidth;
    private final Object lock;
    private MaterialMenuState materialMenuState;
    private boolean rtlEnabled;
    private final float sidePadding;
    private final Stroke stroke;
    private final float strokeWidth;
    private final float topPadding;
    private ObjectAnimator transformation;
    private Property<MaterialMenuDrawable, Float> transformationProperty;
    private boolean transformationRunning;
    private float transformationValue;
    private boolean visible;
    private final int width;

    /* renamed from: com.instabug.library.ui.custom.MaterialMenuDrawable$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$instabug$library$ui$custom$MaterialMenuDrawable$AnimationState;
        public static final /* synthetic */ int[] $SwitchMap$com$instabug$library$ui$custom$MaterialMenuDrawable$IconState;
        public static final /* synthetic */ int[] $SwitchMap$com$instabug$library$ui$custom$MaterialMenuDrawable$Stroke;

        static {
            IconState.values();
            int[] iArr = new int[4];
            $SwitchMap$com$instabug$library$ui$custom$MaterialMenuDrawable$IconState = iArr;
            try {
                iArr[IconState.BURGER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$instabug$library$ui$custom$MaterialMenuDrawable$IconState[IconState.ARROW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$instabug$library$ui$custom$MaterialMenuDrawable$IconState[IconState.X.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$instabug$library$ui$custom$MaterialMenuDrawable$IconState[IconState.CHECK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            Stroke.values();
            int[] iArr2 = new int[3];
            $SwitchMap$com$instabug$library$ui$custom$MaterialMenuDrawable$Stroke = iArr2;
            try {
                iArr2[Stroke.REGULAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$instabug$library$ui$custom$MaterialMenuDrawable$Stroke[Stroke.THIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$instabug$library$ui$custom$MaterialMenuDrawable$Stroke[Stroke.EXTRA_THIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            AnimationState.values();
            int[] iArr3 = new int[6];
            $SwitchMap$com$instabug$library$ui$custom$MaterialMenuDrawable$AnimationState = iArr3;
            try {
                iArr3[AnimationState.BURGER_ARROW.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$instabug$library$ui$custom$MaterialMenuDrawable$AnimationState[AnimationState.BURGER_X.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$instabug$library$ui$custom$MaterialMenuDrawable$AnimationState[AnimationState.ARROW_X.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$instabug$library$ui$custom$MaterialMenuDrawable$AnimationState[AnimationState.ARROW_CHECK.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$instabug$library$ui$custom$MaterialMenuDrawable$AnimationState[AnimationState.BURGER_CHECK.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$instabug$library$ui$custom$MaterialMenuDrawable$AnimationState[AnimationState.X_CHECK.ordinal()] = 6;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum AnimationState {
        BURGER_ARROW,
        BURGER_X,
        ARROW_X,
        ARROW_CHECK,
        BURGER_CHECK,
        X_CHECK;

        @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
        public IconState getFirstState() {
            int ordinal = ordinal();
            if (ordinal == 0) {
                return IconState.BURGER;
            }
            if (ordinal == 1) {
                return IconState.BURGER;
            }
            if (ordinal == 2) {
                return IconState.ARROW;
            }
            if (ordinal == 3) {
                return IconState.ARROW;
            }
            if (ordinal == 4) {
                return IconState.BURGER;
            }
            if (ordinal != 5) {
                return null;
            }
            return IconState.X;
        }

        @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
        public IconState getSecondState() {
            int ordinal = ordinal();
            if (ordinal == 0) {
                return IconState.ARROW;
            }
            if (ordinal == 1) {
                return IconState.X;
            }
            if (ordinal == 2) {
                return IconState.X;
            }
            if (ordinal == 3) {
                return IconState.CHECK;
            }
            if (ordinal == 4) {
                return IconState.CHECK;
            }
            if (ordinal != 5) {
                return null;
            }
            return IconState.CHECK;
        }
    }

    /* loaded from: classes2.dex */
    public enum IconState {
        BURGER,
        ARROW,
        X,
        CHECK
    }

    /* loaded from: classes2.dex */
    public final class MaterialMenuState extends Drawable.ConstantState {
        private int changingConfigurations;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.changingConfigurations;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            MaterialMenuDrawable materialMenuDrawable = new MaterialMenuDrawable(MaterialMenuDrawable.this.circlePaint.getColor(), MaterialMenuDrawable.this.stroke, MaterialMenuDrawable.this.transformation.getDuration(), MaterialMenuDrawable.this.width, MaterialMenuDrawable.this.height, MaterialMenuDrawable.this.iconWidth, MaterialMenuDrawable.this.circleRadius, MaterialMenuDrawable.this.strokeWidth, MaterialMenuDrawable.this.dip1);
            materialMenuDrawable.setIconState(MaterialMenuDrawable.this.animatingIconState != null ? MaterialMenuDrawable.this.animatingIconState : MaterialMenuDrawable.this.currentIconState);
            materialMenuDrawable.setVisible(MaterialMenuDrawable.this.visible);
            materialMenuDrawable.setRTLEnabled(MaterialMenuDrawable.this.rtlEnabled);
            return materialMenuDrawable;
        }

        private MaterialMenuState() {
        }
    }

    /* loaded from: classes2.dex */
    public enum Stroke {
        REGULAR(3),
        THIN(2),
        EXTRA_THIN(1);
        
        private final int strokeWidth;

        Stroke(int i) {
            this.strokeWidth = i;
        }

        public static Stroke valueOf(int i) {
            if (i == 1) {
                return EXTRA_THIN;
            }
            if (i == 2) {
                return THIN;
            }
            if (i != 3) {
                return THIN;
            }
            return REGULAR;
        }
    }

    public static float dpToPx(Resources resources, float f) {
        return TypedValue.applyDimension(1, f, resources.getDisplayMetrics());
    }

    private void drawBottomLine(Canvas canvas, float f) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        canvas.restore();
        canvas.save();
        float f12 = (float) this.width;
        float f13 = (this.dip3 / TRANSFORMATION_END) + (f12 / TRANSFORMATION_END);
        float f14 = (((float) this.height) - this.topPadding) - this.dip2;
        float f15 = this.sidePadding;
        float f16 = f12 - f15;
        int ordinal = this.animationState.ordinal();
        float f17 = TRANSFORMATION_START;
        if (ordinal != 0) {
            if (ordinal == 1) {
                float f18 = isMorphingForward() ? f * CHECK_BOTTOM_ANGLE : X_ROTATION_ANGLE * f;
                float f19 = f * X_BOT_LINE_ANGLE;
                f3 = this.sidePadding + this.dip4;
                float f20 = ((float) this.height) - this.topPadding;
                float f21 = this.dip3;
                f2 = f20 - f21;
                f6 = (f21 * f) + f15;
                f4 = f16;
                f5 = f18;
                f17 = f19;
            } else if (ordinal != 2) {
                if (ordinal == 3) {
                    f10 = (f * CHECK_BOTTOM_ANGLE) + 135.0f;
                    float f22 = ((float) this.width) / TRANSFORMATION_END;
                    float f23 = this.dip3 * f;
                    f9 = (((float) this.height) / TRANSFORMATION_END) - f23;
                    f11 = f16 - resolveStrokeModifier(TRANSFORMATION_MID);
                    f6 = ((this.dip4 + this.dip1) * f) + this.dip3 + f15;
                    f8 = f22 + f23;
                } else if (ordinal == 4) {
                    float f24 = ((float) this.width) / TRANSFORMATION_END;
                    float f25 = this.dip3 * f;
                    float f26 = (this.dip8 * f) + f15;
                    f4 = f16 - resolveStrokeModifier(f);
                    f6 = f26;
                    f5 = 0.0f;
                    f17 = 45.0f * f;
                    f3 = f24 + f25;
                    f2 = (((float) this.height) / TRANSFORMATION_END) - f25;
                } else if (ordinal != 5) {
                    f4 = f16;
                    f6 = f15;
                    f5 = 0.0f;
                    f3 = 0.0f;
                    f2 = 0.0f;
                } else {
                    float f27 = TRANSFORMATION_MID - f;
                    f17 = f27 * CHECK_BOTTOM_ANGLE;
                    f10 = (89.0f * f) + X_BOT_LINE_ANGLE;
                    float f28 = this.sidePadding;
                    float f29 = this.dip4;
                    float f30 = ((float) this.width) / TRANSFORMATION_END;
                    float f31 = this.dip3;
                    f8 = ((((f30 + f31) - f28) - f29) * f) + f28 + f29;
                    float f32 = (float) this.height;
                    float f33 = this.topPadding;
                    float f34 = (((f32 / TRANSFORMATION_END) + f33) - f32) * f;
                    f6 = (this.dip8 - ((f29 + this.dip1) * f27)) + f15;
                    f11 = f16 - resolveStrokeModifier(f27);
                    f9 = f34 + ((f32 - f33) - f31);
                }
                f17 = f10;
                f2 = f9;
                f3 = f8;
                f7 = f17;
                f4 = f11;
            } else {
                f17 = (181.0f * f) + 135.0f;
                float f35 = f * CHECK_BOTTOM_ANGLE;
                float f36 = ((float) this.width) / TRANSFORMATION_END;
                float f37 = f36 + (((this.sidePadding + this.dip4) - f36) * f);
                float f38 = ((float) this.height) / TRANSFORMATION_END;
                float a = a.a(f38 - this.topPadding, this.dip3, f, f38);
                float resolveStrokeModifier = f16 - resolveStrokeModifier(f);
                f6 = f15 + this.dip3;
                f4 = resolveStrokeModifier;
                f5 = f35;
                f3 = f37;
                f2 = a;
            }
            canvas.rotate(f17, f3, f2);
            canvas.rotate(f5, f13, f14);
            canvas.drawLine(f6, f14, f4, f14, this.iconPaint);
        }
        float a2 = isMorphingForward() ? f * 135.0f : a.a(TRANSFORMATION_MID, f, ARROW_BOT_LINE_ANGLE, 135.0f);
        float f39 = (float) this.width;
        f3 = f39 / TRANSFORMATION_END;
        f2 = ((float) this.height) / TRANSFORMATION_END;
        float resolveStrokeModifier2 = (f39 - this.sidePadding) - resolveStrokeModifier(f);
        f6 = (this.dip3 * f) + this.sidePadding;
        f4 = resolveStrokeModifier2;
        f7 = 0.0f;
        f17 = a2;
        f5 = f7;
        canvas.rotate(f17, f3, f2);
        canvas.rotate(f5, f13, f14);
        canvas.drawLine(f6, f14, f4, f14, this.iconPaint);
    }

    private void drawMiddleLine(Canvas canvas, float f) {
        float f2;
        int i;
        float f3;
        float f4;
        int i2;
        float f5;
        float f6;
        float f7;
        float f8;
        canvas.restore();
        canvas.save();
        float f9 = (float) this.width;
        float f10 = f9 / TRANSFORMATION_END;
        float f11 = this.sidePadding;
        float f12 = ((this.dip3 / TRANSFORMATION_END) * 5.0f) + this.topPadding;
        float f13 = f9 - f11;
        int ordinal = this.animationState.ordinal();
        float f14 = TRANSFORMATION_START;
        if (ordinal != 0) {
            if (ordinal == 1) {
                i2 = (int) ((TRANSFORMATION_MID - f) * 255.0f);
            } else if (ordinal != 2) {
                if (ordinal == 3) {
                    f5 = isMorphingForward() ? 135.0f * f : 135.0f - ((TRANSFORMATION_MID - f) * 135.0f);
                    float f15 = this.dip3;
                    f6 = (((f15 / TRANSFORMATION_END) + this.dip4) - ((TRANSFORMATION_MID - f) * this.dip2)) + f11;
                    f4 = (f * this.dip1) + f13;
                    f7 = (((float) this.width) / TRANSFORMATION_END) + f15;
                    f8 = this.diph;
                } else if (ordinal == 4) {
                    f5 = 135.0f * f;
                    float f16 = this.dip4;
                    float f17 = this.dip3;
                    f6 = (((f17 / TRANSFORMATION_END) + f16) * f) + f11;
                    f4 = (f * this.dip1) + f13;
                    f7 = (((float) this.width) / TRANSFORMATION_END) + f17;
                    f8 = this.diph;
                } else if (ordinal == 5) {
                    i = (int) (255.0f * f);
                    f14 = f * 135.0f;
                    float f18 = this.dip4;
                    float f19 = this.dip3;
                    float f20 = (((f19 / TRANSFORMATION_END) + f18) * f) + f11;
                    float f21 = (f * this.dip1) + f13;
                    f3 = (((float) this.width) / TRANSFORMATION_END) + f19 + this.diph;
                    f11 = f20;
                    f2 = f21;
                    this.iconPaint.setAlpha(i);
                    canvas.rotate(f14, f3, f10);
                    canvas.drawLine(f11, f12, f2, f12, this.iconPaint);
                    this.iconPaint.setAlpha(255);
                }
                f11 = f6;
                f3 = f7 + f8;
                f14 = f5;
                f2 = f4;
                i = 255;
                this.iconPaint.setAlpha(i);
                canvas.rotate(f14, f3, f10);
                canvas.drawLine(f11, f12, f2, f12, this.iconPaint);
                this.iconPaint.setAlpha(255);
            } else {
                float f22 = TRANSFORMATION_MID - f;
                i2 = (int) (255.0f * f22);
                f11 += f22 * this.dip2;
            }
            i = i2;
            f2 = f13;
            f3 = f10;
            this.iconPaint.setAlpha(i);
            canvas.rotate(f14, f3, f10);
            canvas.drawLine(f11, f12, f2, f12, this.iconPaint);
            this.iconPaint.setAlpha(255);
        }
        f14 = isMorphingForward() ? ARROW_MID_LINE_ANGLE * f : a.a(TRANSFORMATION_MID, f, ARROW_MID_LINE_ANGLE, ARROW_MID_LINE_ANGLE);
        f13 -= (f * resolveStrokeModifier(f)) / TRANSFORMATION_END;
        f4 = f13;
        f3 = f10;
        f2 = f4;
        i = 255;
        this.iconPaint.setAlpha(i);
        canvas.rotate(f14, f3, f10);
        canvas.drawLine(f11, f12, f2, f12, this.iconPaint);
        this.iconPaint.setAlpha(255);
    }

    private void drawTopLine(Canvas canvas, float f) {
        float f2;
        float f3;
        int i;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        canvas.save();
        float f11 = (float) this.width;
        float f12 = (this.dip3 / TRANSFORMATION_END) + (f11 / TRANSFORMATION_END);
        float f13 = this.topPadding + this.dip2;
        float f14 = this.sidePadding;
        float f15 = f11 - f14;
        int ordinal = this.animationState.ordinal();
        float f16 = X_TOP_LINE_ANGLE;
        float f17 = X_ROTATION_ANGLE;
        float f18 = TRANSFORMATION_START;
        if (ordinal != 0) {
            if (ordinal == 1) {
                f9 = f * X_TOP_LINE_ANGLE;
                f8 = f * X_ROTATION_ANGLE;
                f6 = this.sidePadding + this.dip4;
                float f19 = this.topPadding;
                float f20 = this.dip3;
                f10 = f19 + f20;
                f7 = f14 + (f20 * f);
            } else if (ordinal != 2) {
                if (ordinal == 3) {
                    int i2 = (int) ((TRANSFORMATION_MID - f) * 255.0f);
                    float f21 = ((float) this.width) / TRANSFORMATION_END;
                    float f22 = ((float) this.height) / TRANSFORMATION_END;
                    float resolveStrokeModifier = f15 - resolveStrokeModifier(TRANSFORMATION_MID);
                    f4 = f14 + this.dip3;
                    f3 = resolveStrokeModifier;
                    f17 = 0.0f;
                    i = i2;
                    f18 = f21;
                    f2 = f22;
                    f16 = 225.0f;
                } else if (ordinal == 4) {
                    i = (int) ((TRANSFORMATION_MID - f) * 255.0f);
                    f3 = f15;
                    f16 = 0.0f;
                    f17 = 0.0f;
                    f4 = f14;
                    f2 = 0.0f;
                } else if (ordinal != 5) {
                    f3 = f15;
                    f4 = f14;
                    i = 255;
                    f2 = 0.0f;
                    f16 = 0.0f;
                    f17 = 0.0f;
                } else {
                    f18 = this.sidePadding + this.dip4;
                    float f23 = this.topPadding;
                    float f24 = this.dip3;
                    f2 = f23 + f24;
                    float f25 = TRANSFORMATION_MID - f;
                    f3 = (f24 - (f24 * f25)) + f15;
                    f4 = f14 + f24;
                    i = (int) (f25 * 255.0f);
                }
                this.iconPaint.setAlpha(i);
                canvas.rotate(f16, f18, f2);
                canvas.rotate(f17, f12, f13);
                canvas.drawLine(f4, f13, f3, f13, this.iconPaint);
                this.iconPaint.setAlpha(255);
            } else {
                f9 = (-181.0f * f) + ARROW_BOT_LINE_ANGLE;
                f8 = f * X_ROTATION_ANGLE;
                float f26 = ((float) this.width) / TRANSFORMATION_END;
                f6 = (((this.sidePadding + this.dip4) - f26) * f) + f26;
                float f27 = ((float) this.height) / TRANSFORMATION_END;
                f10 = (((this.topPadding + this.dip3) - f27) * f) + f27;
                f15 -= resolveStrokeModifier(f);
                f7 = f14 + this.dip3;
            }
            f5 = f10;
            f17 = f8;
            f16 = f9;
        } else {
            float a = isMorphingForward() ? f * ARROW_BOT_LINE_ANGLE : a.a(TRANSFORMATION_MID, f, 135.0f, ARROW_BOT_LINE_ANGLE);
            float f28 = ((float) this.width) / TRANSFORMATION_END;
            float f29 = ((float) this.height) / TRANSFORMATION_END;
            f15 -= resolveStrokeModifier(f);
            f7 = f14 + (this.dip3 * f);
            f6 = f28;
            f16 = a;
            f5 = f29;
            f17 = 0.0f;
        }
        f3 = f15;
        f4 = f7;
        i = 255;
        f2 = f5;
        f18 = f6;
        this.iconPaint.setAlpha(i);
        canvas.rotate(f16, f18, f2);
        canvas.rotate(f17, f12, f13);
        canvas.drawLine(f4, f13, f3, f13, this.iconPaint);
        this.iconPaint.setAlpha(255);
    }

    private void initAnimations(int i) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, this.transformationProperty, TRANSFORMATION_START);
        this.transformation = ofFloat;
        ofFloat.setInterpolator(new DecelerateInterpolator(3.0f));
        this.transformation.setDuration((long) i);
        this.transformation.addListener(new AnimatorListenerAdapter() { // from class: com.instabug.library.ui.custom.MaterialMenuDrawable.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                MaterialMenuDrawable.this.transformationRunning = false;
                MaterialMenuDrawable materialMenuDrawable = MaterialMenuDrawable.this;
                materialMenuDrawable.setIconState(materialMenuDrawable.animatingIconState);
            }
        });
    }

    private void initPaint(int i) {
        this.iconPaint.setAntiAlias(true);
        this.iconPaint.setStyle(Paint.Style.STROKE);
        this.iconPaint.setStrokeWidth(this.strokeWidth);
        this.iconPaint.setColor(i);
        this.circlePaint.setAntiAlias(true);
        this.circlePaint.setStyle(Paint.Style.FILL);
        this.circlePaint.setColor(i);
        this.circlePaint.setAlpha(200);
        setBounds(0, 0, this.width, this.height);
    }

    private boolean isMorphingForward() {
        return this.transformationValue <= TRANSFORMATION_MID;
    }

    private float resolveStrokeModifier(float f) {
        float f2;
        int i = AnonymousClass3.$SwitchMap$com$instabug$library$ui$custom$MaterialMenuDrawable$Stroke[this.stroke.ordinal()];
        if (i == 1) {
            AnimationState animationState = this.animationState;
            if (animationState == AnimationState.ARROW_X || animationState == AnimationState.X_CHECK) {
                float f3 = this.dip3;
                return f3 - (f * f3);
            }
            f2 = this.dip3;
        } else if (i == 2) {
            AnimationState animationState2 = this.animationState;
            if (animationState2 != AnimationState.ARROW_X && animationState2 != AnimationState.X_CHECK) {
                return (this.dip3 + this.diph) * f;
            }
            float f4 = this.dip3 + this.diph;
            return f4 - (f * f4);
        } else if (i != 3) {
            return TRANSFORMATION_START;
        } else {
            AnimationState animationState3 = this.animationState;
            if (animationState3 == AnimationState.ARROW_X || animationState3 == AnimationState.X_CHECK) {
                return this.dip4 - ((this.dip3 + this.dip1) * f);
            }
            f2 = this.dip4;
        }
        return f * f2;
    }

    private boolean resolveTransformation() {
        IconState iconState = this.currentIconState;
        IconState iconState2 = IconState.BURGER;
        boolean z = iconState == iconState2;
        IconState iconState3 = IconState.ARROW;
        boolean z2 = iconState == iconState3;
        IconState iconState4 = IconState.X;
        boolean z3 = iconState == iconState4;
        IconState iconState5 = IconState.CHECK;
        boolean z4 = iconState == iconState5;
        IconState iconState6 = this.animatingIconState;
        boolean z5 = iconState6 == iconState2;
        boolean z6 = iconState6 == iconState3;
        boolean z7 = iconState6 == iconState4;
        boolean z8 = iconState6 == iconState5;
        if ((z && z6) || (z2 && z5)) {
            this.animationState = AnimationState.BURGER_ARROW;
            return z;
        } else if ((z2 && z7) || (z3 && z6)) {
            this.animationState = AnimationState.ARROW_X;
            return z2;
        } else if ((z && z7) || (z3 && z5)) {
            this.animationState = AnimationState.BURGER_X;
            return z;
        } else if ((z2 && z8) || (z4 && z6)) {
            this.animationState = AnimationState.ARROW_CHECK;
            return z2;
        } else if ((z && z8) || (z4 && z5)) {
            this.animationState = AnimationState.BURGER_CHECK;
            return z;
        } else if ((!z3 || !z8) && (!z4 || !z7)) {
            throw new IllegalStateException(String.format("Animating from %s to %s is not supported", this.currentIconState, this.animatingIconState));
        } else {
            this.animationState = AnimationState.X_CHECK;
            return z3;
        }
    }

    @Override // com.instabug.library.ui.custom.MaterialMenu
    public void animateIconState(IconState iconState) {
        synchronized (this.lock) {
            if (this.transformationRunning) {
                this.transformation.end();
            }
            this.animatingIconState = iconState;
            start();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        synchronized (this.lock) {
            if (this.visible) {
                float f = this.transformationValue;
                if (f > TRANSFORMATION_MID) {
                    f = TRANSFORMATION_END - f;
                }
                if (this.rtlEnabled) {
                    canvas.save();
                    canvas.scale(-1.0f, TRANSFORMATION_MID, TRANSFORMATION_START, TRANSFORMATION_START);
                    canvas.translate((float) (-getIntrinsicWidth()), TRANSFORMATION_START);
                }
                drawTopLine(canvas, f);
                drawMiddleLine(canvas, f);
                drawBottomLine(canvas, f);
                if (this.rtlEnabled) {
                    canvas.restore();
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        this.materialMenuState.changingConfigurations = getChangingConfigurations();
        return this.materialMenuState;
    }

    @Override // com.instabug.library.ui.custom.MaterialMenu
    public IconState getIconState() {
        IconState iconState;
        synchronized (this.lock) {
            iconState = this.currentIconState;
        }
        return iconState;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.height;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.width;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public Float getTransformationValue() {
        Float valueOf;
        synchronized (this.lock) {
            valueOf = Float.valueOf(this.transformationValue);
        }
        return valueOf;
    }

    public boolean isDrawableVisible() {
        return this.visible;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        boolean z;
        synchronized (this.lock) {
            z = this.transformationRunning;
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.materialMenuState = new MaterialMenuState();
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.iconPaint.setAlpha(i);
    }

    @Override // com.instabug.library.ui.custom.MaterialMenu
    public void setAnimationListener(Animator.AnimatorListener animatorListener) {
        Animator.AnimatorListener animatorListener2 = this.animatorListener;
        if (animatorListener2 != null) {
            this.transformation.removeListener(animatorListener2);
        }
        if (animatorListener != null) {
            this.transformation.addListener(animatorListener);
        }
        this.animatorListener = animatorListener;
    }

    @Override // com.instabug.library.ui.custom.MaterialMenu
    public void setColor(int i) {
        this.iconPaint.setColor(i);
        this.circlePaint.setColor(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void setColorFilter(ColorFilter colorFilter) {
        this.iconPaint.setColorFilter(colorFilter);
    }

    @Override // com.instabug.library.ui.custom.MaterialMenu
    public void setIconState(IconState iconState) {
        synchronized (this.lock) {
            if (this.transformationRunning) {
                this.transformation.cancel();
                this.transformationRunning = false;
            }
            if (!(iconState == null || this.currentIconState == iconState)) {
                int ordinal = iconState.ordinal();
                if (ordinal == 0) {
                    this.animationState = AnimationState.BURGER_ARROW;
                    this.transformationValue = TRANSFORMATION_START;
                } else if (ordinal == 1) {
                    this.animationState = AnimationState.BURGER_ARROW;
                    this.transformationValue = TRANSFORMATION_MID;
                } else if (ordinal == 2) {
                    this.animationState = AnimationState.BURGER_X;
                    this.transformationValue = TRANSFORMATION_MID;
                } else if (ordinal == 3) {
                    this.animationState = AnimationState.BURGER_CHECK;
                    this.transformationValue = TRANSFORMATION_MID;
                }
                this.currentIconState = iconState;
                invalidateSelf();
            }
        }
    }

    @Override // com.instabug.library.ui.custom.MaterialMenu
    public void setInterpolator(Interpolator interpolator) {
        this.transformation.setInterpolator(interpolator);
    }

    @Override // com.instabug.library.ui.custom.MaterialMenu
    public void setRTLEnabled(boolean z) {
        this.rtlEnabled = z;
        invalidateSelf();
    }

    @Override // com.instabug.library.ui.custom.MaterialMenu
    public void setTransformationDuration(int i) {
        this.transformation.setDuration((long) i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
        r0 = r7.getFirstState();
     */
    @Override // com.instabug.library.ui.custom.MaterialMenu
    /* Code decompiled incorrectly, please refer to instructions dump */
    public IconState setTransformationOffset(AnimationState animationState, float f) {
        int i;
        IconState iconState;
        boolean z = true;
        if (f < TRANSFORMATION_START || f > TRANSFORMATION_END) {
            throw new IllegalArgumentException(String.format("Value must be between %s and %s", Float.valueOf((float) TRANSFORMATION_START), Float.valueOf((float) TRANSFORMATION_END)));
        }
        synchronized (this.lock) {
            this.animationState = animationState;
            if (f >= TRANSFORMATION_MID && i != 0) {
                z = false;
            }
            IconState iconState2 = animationState.getSecondState();
            this.currentIconState = iconState2;
            this.animatingIconState = z ? animationState.getSecondState() : animationState.getFirstState();
            setTransformationValue(Float.valueOf(f));
            iconState = this.currentIconState;
        }
        return iconState;
    }

    public void setTransformationValue(Float f) {
        synchronized (this.lock) {
            this.transformationValue = f.floatValue();
            invalidateSelf();
        }
    }

    @Override // com.instabug.library.ui.custom.MaterialMenu
    public void setVisible(boolean z) {
        this.visible = z;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        synchronized (this.lock) {
            if (!this.transformationRunning) {
                IconState iconState = this.animatingIconState;
                if (!(iconState == null || iconState == this.currentIconState)) {
                    this.transformationRunning = true;
                    boolean resolveTransformation = resolveTransformation();
                    ObjectAnimator objectAnimator = this.transformation;
                    float[] fArr = new float[2];
                    float f = TRANSFORMATION_MID;
                    fArr[0] = resolveTransformation ? TRANSFORMATION_START : 1.0f;
                    if (!resolveTransformation) {
                        f = TRANSFORMATION_END;
                    }
                    fArr[1] = f;
                    objectAnimator.setFloatValues(fArr);
                    this.transformation.start();
                }
                invalidateSelf();
            }
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        synchronized (this.lock) {
            if (!isRunning() || !this.transformation.isRunning()) {
                this.transformationRunning = false;
                invalidateSelf();
            } else {
                this.transformation.end();
            }
        }
    }

    public MaterialMenuDrawable(Context context, int i, Stroke stroke) {
        this(context, i, stroke, 1, DEFAULT_TRANSFORM_DURATION);
    }

    public MaterialMenuDrawable(Context context, int i, Stroke stroke, int i2) {
        this(context, i, stroke, 1, i2);
    }

    public MaterialMenuDrawable(Context context, int i, Stroke stroke, int i2, int i3) {
        this.lock = new Object();
        this.iconPaint = new Paint();
        this.circlePaint = new Paint();
        this.transformationValue = TRANSFORMATION_START;
        this.transformationRunning = false;
        this.currentIconState = IconState.BURGER;
        this.animationState = AnimationState.BURGER_ARROW;
        this.transformationProperty = new Property<MaterialMenuDrawable, Float>(Float.class, "transformation") { // from class: com.instabug.library.ui.custom.MaterialMenuDrawable.1
            public Float get(MaterialMenuDrawable materialMenuDrawable) {
                return materialMenuDrawable.getTransformationValue();
            }

            public void set(MaterialMenuDrawable materialMenuDrawable, Float f) {
                materialMenuDrawable.setTransformationValue(f);
            }
        };
        Resources resources = context.getResources();
        float f = (float) i2;
        float dpToPx = dpToPx(resources, TRANSFORMATION_MID) * f;
        this.dip1 = dpToPx;
        this.dip2 = dpToPx(resources, TRANSFORMATION_END) * f;
        float dpToPx2 = dpToPx(resources, 3.0f) * f;
        this.dip3 = dpToPx2;
        this.dip4 = dpToPx(resources, 4.0f) * f;
        this.dip8 = dpToPx(resources, 8.0f) * f;
        this.diph = dpToPx / TRANSFORMATION_END;
        this.stroke = stroke;
        this.visible = true;
        int dpToPx3 = (int) (dpToPx(resources, 40.0f) * f);
        this.width = dpToPx3;
        int dpToPx4 = (int) (dpToPx(resources, 40.0f) * f);
        this.height = dpToPx4;
        float dpToPx5 = dpToPx(resources, 20.0f) * f;
        this.iconWidth = dpToPx5;
        this.circleRadius = dpToPx(resources, 18.0f) * f;
        this.strokeWidth = dpToPx(resources, (float) stroke.strokeWidth) * f;
        this.sidePadding = (((float) dpToPx3) - dpToPx5) / TRANSFORMATION_END;
        this.topPadding = (((float) dpToPx4) - (dpToPx2 * 5.0f)) / TRANSFORMATION_END;
        initPaint(i);
        initAnimations(i3);
        this.materialMenuState = new MaterialMenuState();
    }

    private MaterialMenuDrawable(int i, Stroke stroke, long j, int i2, int i3, float f, float f2, float f3, float f4) {
        this.lock = new Object();
        this.iconPaint = new Paint();
        this.circlePaint = new Paint();
        this.transformationValue = TRANSFORMATION_START;
        this.transformationRunning = false;
        this.currentIconState = IconState.BURGER;
        this.animationState = AnimationState.BURGER_ARROW;
        this.transformationProperty = new Property<MaterialMenuDrawable, Float>(Float.class, "transformation") { // from class: com.instabug.library.ui.custom.MaterialMenuDrawable.1
            public Float get(MaterialMenuDrawable materialMenuDrawable) {
                return materialMenuDrawable.getTransformationValue();
            }

            public void set(MaterialMenuDrawable materialMenuDrawable, Float f5) {
                materialMenuDrawable.setTransformationValue(f5);
            }
        };
        this.dip1 = f4;
        this.dip2 = f4 * TRANSFORMATION_END;
        float f5 = 3.0f * f4;
        this.dip3 = f5;
        this.dip4 = 4.0f * f4;
        this.dip8 = 8.0f * f4;
        this.diph = f4 / TRANSFORMATION_END;
        this.stroke = stroke;
        this.width = i2;
        this.height = i3;
        this.iconWidth = f;
        this.circleRadius = f2;
        this.strokeWidth = f3;
        this.sidePadding = (((float) i2) - f) / TRANSFORMATION_END;
        this.topPadding = (((float) i3) - (f5 * 5.0f)) / TRANSFORMATION_END;
        initPaint(i);
        initAnimations((int) j);
        this.materialMenuState = new MaterialMenuState();
    }
}
