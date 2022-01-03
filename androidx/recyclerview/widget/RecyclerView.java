package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.R;
import com.instabug.library.networkv2.connection.InstabugBaseConnectionManagerImpl;
import h0.i.i.g0.b;
import h0.v.a.a;
import h0.v.a.b0;
import h0.v.a.c0;
import h0.v.a.e;
import h0.v.a.j;
import h0.v.a.x;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements h0.i.i.h {
    public static final boolean DEBUG = false;
    public static final int DEFAULT_ORIENTATION = 1;
    public static final boolean DISPATCH_TEMP_DETACH = false;
    public static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    public static final int MAX_SCROLL_DURATION = 2000;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    public static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    public static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    public static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    public static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    public static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    public static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    public static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    public h0.v.a.x mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    public Adapter mAdapter;
    public h0.v.a.a mAdapterHelper;
    public boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private i mChildDrawingOrderCallback;
    public h0.v.a.e mChildHelper;
    public boolean mClipToPadding;
    public boolean mDataSetHasChangedAfterLayout;
    public boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private j mEdgeEffectFactory;
    public boolean mEnableFastScroller;
    public boolean mFirstLayoutComplete;
    public h0.v.a.j mGapWorker;
    public boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private r mInterceptingOnItemTouchListener;
    public boolean mIsAttached;
    public k mItemAnimator;
    private k.b mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    public final ArrayList<m> mItemDecorations;
    public boolean mItemsAddedOrRemoved;
    public boolean mItemsChanged;
    private int mLastAutoMeasureNonExactMeasuredHeight;
    private int mLastAutoMeasureNonExactMeasuredWidth;
    private boolean mLastAutoMeasureSkippedDueToExact;
    private int mLastTouchX;
    private int mLastTouchY;
    public n mLayout;
    private int mLayoutOrScrollCounter;
    public boolean mLayoutSuppressed;
    public boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final w mObserver;
    private List<p> mOnChildAttachStateListeners;
    private q mOnFlingListener;
    private final ArrayList<r> mOnItemTouchListeners;
    public final List<b0> mPendingAccessibilityImportanceChange;
    public SavedState mPendingSavedState;
    public boolean mPostedAnimatorRunner;
    public j.b mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    public final u mRecycler;
    public v mRecyclerListener;
    public final List<v> mRecyclerListeners;
    public final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private s mScrollListener;
    private List<s> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private h0.i.i.i mScrollingChildHelper;
    public final y mState;
    public final Rect mTempRect;
    private final Rect mTempRect2;
    public final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    public final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    public final a0 mViewFlinger;
    private final c0.b mViewInfoProcessCallback;
    public final c0 mViewInfoStore;
    private static final int[] NESTED_SCROLLING_ATTRS = {16843830};
    public static final boolean FORCE_INVALIDATE_DISPLAY_LIST = false;
    public static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC = true;
    public static final boolean POST_UPDATES_ON_ANIMATION = true;
    public static final boolean ALLOW_THREAD_GAP_WORK = true;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD = false;
    public static final Interpolator sQuinticInterpolator = new c();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mFirstLayoutComplete && !recyclerView.isLayoutRequested()) {
                RecyclerView recyclerView2 = RecyclerView.this;
                if (!recyclerView2.mIsAttached) {
                    recyclerView2.requestLayout();
                } else if (recyclerView2.mLayoutSuppressed) {
                    recyclerView2.mLayoutWasDefered = true;
                } else {
                    recyclerView2.consumePendingUpdateOperations();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class a0 implements Runnable {
        public int c;
        public int d;
        public OverScroller q;
        public Interpolator x;
        public boolean y = false;
        public boolean Y1 = false;

        public a0() {
            Interpolator interpolator = RecyclerView.sQuinticInterpolator;
            this.x = interpolator;
            this.q = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        public void a() {
            if (this.y) {
                this.Y1 = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            RecyclerView recyclerView = RecyclerView.this;
            AtomicInteger atomicInteger = h0.i.i.q.a;
            recyclerView.postOnAnimation(this);
        }

        public void b(int i, int i2, int i3, Interpolator interpolator) {
            if (i3 == Integer.MIN_VALUE) {
                int abs = Math.abs(i);
                int abs2 = Math.abs(i2);
                boolean z = abs > abs2;
                RecyclerView recyclerView = RecyclerView.this;
                int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
                if (!z) {
                    abs = abs2;
                }
                i3 = Math.min((int) (((((float) abs) / ((float) width)) + 1.0f) * 300.0f), (int) RecyclerView.MAX_SCROLL_DURATION);
            }
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.x != interpolator) {
                this.x = interpolator;
                this.q = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.d = 0;
            this.c = 0;
            RecyclerView.this.setScrollState(2);
            this.q.startScroll(0, 0, i, i2, i3);
            a();
        }

        public void c() {
            RecyclerView.this.removeCallbacks(this);
            this.q.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mLayout == null) {
                c();
                return;
            }
            this.Y1 = false;
            this.y = true;
            recyclerView.consumePendingUpdateOperations();
            OverScroller overScroller = this.q;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i3 = currX - this.c;
                int i4 = currY - this.d;
                this.c = currX;
                this.d = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.mReusableIntPair;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.dispatchNestedPreScroll(i3, i4, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.mReusableIntPair;
                    i3 -= iArr2[0];
                    i4 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.considerReleasingGlowsOnScroll(i3, i4);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.mAdapter != null) {
                    int[] iArr3 = recyclerView3.mReusableIntPair;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.scrollStep(i3, i4, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.mReusableIntPair;
                    i = iArr4[0];
                    i2 = iArr4[1];
                    i3 -= i;
                    i4 -= i2;
                    x xVar = recyclerView4.mLayout.mSmoothScroller;
                    if (xVar != null && !xVar.d && xVar.e) {
                        int b = recyclerView4.mState.b();
                        if (b == 0) {
                            xVar.d();
                        } else if (xVar.a >= b) {
                            xVar.a = b - 1;
                            xVar.b(i, i2);
                        } else {
                            xVar.b(i, i2);
                        }
                    }
                } else {
                    i2 = 0;
                    i = 0;
                }
                if (!RecyclerView.this.mItemDecorations.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.mReusableIntPair;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.dispatchNestedScroll(i, i2, i3, i4, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.mReusableIntPair;
                int i5 = i3 - iArr6[0];
                int i6 = i4 - iArr6[1];
                if (!(i == 0 && i2 == 0)) {
                    recyclerView6.dispatchOnScrolled(i, i2);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i5 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i6 != 0));
                RecyclerView recyclerView7 = RecyclerView.this;
                x xVar2 = recyclerView7.mLayout.mSmoothScroller;
                if ((xVar2 != null && xVar2.d) || !z) {
                    a();
                    RecyclerView recyclerView8 = RecyclerView.this;
                    h0.v.a.j jVar = recyclerView8.mGapWorker;
                    if (jVar != null) {
                        jVar.a(recyclerView8, i, i2);
                    }
                } else {
                    if (recyclerView7.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i7 = i5 < 0 ? -currVelocity : i5 > 0 ? currVelocity : 0;
                        if (i6 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i6 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.absorbGlows(i7, currVelocity);
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        j.b bVar = RecyclerView.this.mPrefetchRegistry;
                        int[] iArr7 = bVar.c;
                        if (iArr7 != null) {
                            Arrays.fill(iArr7, -1);
                        }
                        bVar.d = 0;
                    }
                }
            }
            x xVar3 = RecyclerView.this.mLayout.mSmoothScroller;
            if (xVar3 != null && xVar3.d) {
                xVar3.b(0, 0);
            }
            this.y = false;
            if (this.Y1) {
                RecyclerView.this.removeCallbacks(this);
                RecyclerView recyclerView9 = RecyclerView.this;
                AtomicInteger atomicInteger = h0.i.i.q.a;
                recyclerView9.postOnAnimation(this);
                return;
            }
            RecyclerView.this.setScrollState(0);
            RecyclerView.this.stopNestedScroll(1);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k kVar = RecyclerView.this.mItemAnimator;
            if (kVar != null) {
                kVar.runPendingAnimations();
            }
            RecyclerView.this.mPostedAnimatorRunner = false;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b0 {
        public static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        public static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        public static final int FLAG_BOUND = 1;
        public static final int FLAG_IGNORE = 128;
        public static final int FLAG_INVALID = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_NOT_RECYCLABLE = 16;
        public static final int FLAG_REMOVED = 8;
        public static final int FLAG_RETURNED_FROM_SCRAP = 32;
        public static final int FLAG_TMP_DETACHED = 256;
        public static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        public static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        public Adapter<? extends b0> mBindingAdapter;
        public int mFlags;
        public WeakReference<RecyclerView> mNestedRecyclerView;
        public RecyclerView mOwnerRecyclerView;
        public int mPosition = -1;
        public int mOldPosition = -1;
        public long mItemId = -1;
        public int mItemViewType = -1;
        public int mPreLayoutPosition = -1;
        public b0 mShadowedHolder = null;
        public b0 mShadowingHolder = null;
        public List<Object> mPayloads = null;
        public List<Object> mUnmodifiedPayloads = null;
        private int mIsRecyclableCount = 0;
        public u mScrapContainer = null;
        public boolean mInChangeScrap = false;
        private int mWasImportantForAccessibilityBeforeHidden = 0;
        public int mPendingAccessibilityState = -1;

        public b0(View view) {
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
            }
        }

        public void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(FLAG_ADAPTER_FULLUPDATE);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        public void addFlags(int i) {
            this.mFlags = i | this.mFlags;
        }

        public void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        public void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        public void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        public void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        public boolean doesTransientStatePreventRecycling() {
            if ((this.mFlags & 16) == 0) {
                View view = this.itemView;
                AtomicInteger atomicInteger = h0.i.i.q.a;
                if (view.hasTransientState()) {
                    return true;
                }
            }
            return false;
        }

        public void flagRemovedAndOffsetPosition(int i, int i2, boolean z) {
            addFlags(8);
            offsetPosition(i2, z);
            this.mPosition = i;
        }

        public final int getAbsoluteAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionInRecyclerView(this);
        }

        @Deprecated
        public final int getAdapterPosition() {
            return getBindingAdapterPosition();
        }

        public final Adapter<? extends b0> getBindingAdapter() {
            return this.mBindingAdapter;
        }

        public final int getBindingAdapterPosition() {
            RecyclerView recyclerView;
            Adapter adapter;
            int adapterPositionInRecyclerView;
            if (this.mBindingAdapter == null || (recyclerView = this.mOwnerRecyclerView) == null || (adapter = recyclerView.getAdapter()) == null || (adapterPositionInRecyclerView = this.mOwnerRecyclerView.getAdapterPositionInRecyclerView(this)) == -1) {
                return -1;
            }
            return adapter.findRelativeAdapterPositionIn(this.mBindingAdapter, this, adapterPositionInRecyclerView);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & FLAG_ADAPTER_FULLUPDATE) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            List<Object> list = this.mPayloads;
            if (list == null || list.size() == 0) {
                return FULLUPDATE_PAYLOADS;
            }
            return this.mUnmodifiedPayloads;
        }

        public boolean hasAnyOfTheFlags(int i) {
            return (i & this.mFlags) != 0;
        }

        public boolean isAdapterPositionUnknown() {
            return (this.mFlags & 512) != 0 || isInvalid();
        }

        public boolean isAttachedToTransitionOverlay() {
            return (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true;
        }

        public boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        public boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        public final boolean isRecyclable() {
            if ((this.mFlags & 16) == 0) {
                View view = this.itemView;
                AtomicInteger atomicInteger = h0.i.i.q.a;
                if (!view.hasTransientState()) {
                    return true;
                }
            }
            return false;
        }

        public boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        public boolean isScrap() {
            return this.mScrapContainer != null;
        }

        public boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        public boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }

        public boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        public void offsetPosition(int i, boolean z) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += i;
            }
            this.mPosition += i;
            if (this.itemView.getLayoutParams() != null) {
                ((o) this.itemView.getLayoutParams()).c = true;
            }
        }

        public void onEnteredHiddenState(RecyclerView recyclerView) {
            int i = this.mPendingAccessibilityState;
            if (i != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i;
            } else {
                View view = this.itemView;
                AtomicInteger atomicInteger = h0.i.i.q.a;
                this.mWasImportantForAccessibilityBeforeHidden = view.getImportantForAccessibility();
            }
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        public void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        public void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        public void setFlags(int i, int i2) {
            this.mFlags = (i & i2) | (this.mFlags & (~i2));
        }

        public final void setIsRecyclable(boolean z) {
            int i = this.mIsRecyclableCount;
            int i2 = z ? i - 1 : i + 1;
            this.mIsRecyclableCount = i2;
            if (i2 < 0) {
                this.mIsRecyclableCount = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && i2 == 1) {
                this.mFlags |= 16;
            } else if (z && i2 == 0) {
                this.mFlags &= -17;
            }
        }

        public void setScrapContainer(u uVar, boolean z) {
            this.mScrapContainer = uVar;
            this.mInChangeScrap = z;
        }

        public boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        public boolean shouldIgnore() {
            return (this.mFlags & 128) != 0;
        }

        public void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            StringBuilder S0 = i0.d.a.a.a.S0(getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName(), "{");
            S0.append(Integer.toHexString(hashCode()));
            S0.append(" position=");
            S0.append(this.mPosition);
            S0.append(" id=");
            S0.append(this.mItemId);
            S0.append(", oldPos=");
            S0.append(this.mOldPosition);
            S0.append(", pLpos:");
            S0.append(this.mPreLayoutPosition);
            StringBuilder sb = new StringBuilder(S0.toString());
            if (isScrap()) {
                sb.append(" scrap ");
                sb.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (needsUpdate()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                StringBuilder P0 = i0.d.a.a.a.P0(" not recyclable(");
                P0.append(this.mIsRecyclableCount);
                P0.append(")");
                sb.append(P0.toString());
            }
            if (isAdapterPositionUnknown()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public void unScrap() {
            this.mScrapContainer.n(this);
        }

        public boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }
    }

    /* loaded from: classes.dex */
    public class c implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* loaded from: classes.dex */
    public class d implements c0.b {
        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class e implements e.b {
        public e() {
        }

        public View a(int i) {
            return RecyclerView.this.getChildAt(i);
        }

        public int b() {
            return RecyclerView.this.getChildCount();
        }

        public void c(int i) {
            View childAt = RecyclerView.this.getChildAt(i);
            if (childAt != null) {
                RecyclerView.this.dispatchChildDetached(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i);
        }
    }

    /* loaded from: classes.dex */
    public class f implements a.AbstractC0099a {
        public f() {
        }

        public void a(a.b bVar) {
            int i = bVar.a;
            if (i == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mLayout.onItemsAdded(recyclerView, bVar.b, bVar.d);
            } else if (i == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.mLayout.onItemsRemoved(recyclerView2, bVar.b, bVar.d);
            } else if (i == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.mLayout.onItemsUpdated(recyclerView3, bVar.b, bVar.d, bVar.c);
            } else if (i == 8) {
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.mLayout.onItemsMoved(recyclerView4, bVar.b, bVar.d, 1);
            }
        }

        public b0 b(int i) {
            b0 findViewHolderForPosition = RecyclerView.this.findViewHolderForPosition(i, true);
            if (findViewHolderForPosition != null && !RecyclerView.this.mChildHelper.k(findViewHolderForPosition.itemView)) {
                return findViewHolderForPosition;
            }
            return null;
        }

        public void c(int i, int i2, Object obj) {
            RecyclerView.this.viewRangeUpdate(i, i2, obj);
            RecyclerView.this.mItemsChanged = true;
        }
    }

    /* loaded from: classes.dex */
    public static class g extends Observable<h> {
        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((h) ((Observable) this).mObservers.get(size)).a();
            }
        }

        public void c(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((h) ((Observable) this).mObservers.get(size)).e(i, i2, 1);
            }
        }

        public void d(int i, int i2, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((h) ((Observable) this).mObservers.get(size)).c(i, i2, obj);
            }
        }

        public void e(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((h) ((Observable) this).mObservers.get(size)).d(i, i2);
            }
        }

        public void f(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((h) ((Observable) this).mObservers.get(size)).f(i, i2);
            }
        }

        public void g() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((h) ((Observable) this).mObservers.get(size)).g();
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class h {
        public void a() {
        }

        public void b(int i, int i2) {
        }

        public void c(int i, int i2, Object obj) {
            b(i, i2);
        }

        public void d(int i, int i2) {
        }

        public void e(int i, int i2, int i3) {
        }

        public void f(int i, int i2) {
        }

        public void g() {
        }
    }

    /* loaded from: classes.dex */
    public interface i {
        int a(int i, int i2);
    }

    /* loaded from: classes.dex */
    public static class j {
        public EdgeEffect a(RecyclerView recyclerView) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* loaded from: classes.dex */
    public static abstract class k {
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_CHANGED = 2;
        public static final int FLAG_INVALIDATED = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_REMOVED = 8;
        private b mListener = null;
        private ArrayList<a> mFinishedListeners = new ArrayList<>();
        private long mAddDuration = 120;
        private long mRemoveDuration = 120;
        private long mMoveDuration = 250;
        private long mChangeDuration = 250;

        /* loaded from: classes.dex */
        public interface a {
            void a();
        }

        /* loaded from: classes.dex */
        public interface b {
        }

        /* loaded from: classes.dex */
        public static class c {
            public int a;
            public int b;
        }

        public static int buildAdapterChangeFlagsForAnimations(b0 b0Var) {
            int i = b0Var.mFlags & 14;
            if (b0Var.isInvalid()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int oldPosition = b0Var.getOldPosition();
            int absoluteAdapterPosition = b0Var.getAbsoluteAdapterPosition();
            return (oldPosition == -1 || absoluteAdapterPosition == -1 || oldPosition == absoluteAdapterPosition) ? i : i | 2048;
        }

        public abstract boolean animateAppearance(b0 b0Var, c cVar, c cVar2);

        public abstract boolean animateChange(b0 b0Var, b0 b0Var2, c cVar, c cVar2);

        public abstract boolean animateDisappearance(b0 b0Var, c cVar, c cVar2);

        public abstract boolean animatePersistence(b0 b0Var, c cVar, c cVar2);

        public abstract boolean canReuseUpdatedViewHolder(b0 b0Var);

        public boolean canReuseUpdatedViewHolder(b0 b0Var, List<Object> list) {
            return canReuseUpdatedViewHolder(b0Var);
        }

        public final void dispatchAnimationFinished(b0 b0Var) {
            onAnimationFinished(b0Var);
            b bVar = this.mListener;
            if (bVar != null) {
                l lVar = (l) bVar;
                Objects.requireNonNull(lVar);
                b0Var.setIsRecyclable(true);
                if (b0Var.mShadowedHolder != null && b0Var.mShadowingHolder == null) {
                    b0Var.mShadowedHolder = null;
                }
                b0Var.mShadowingHolder = null;
                if (!b0Var.shouldBeKeptAsChild() && !RecyclerView.this.removeAnimatingView(b0Var.itemView) && b0Var.isTmpDetached()) {
                    RecyclerView.this.removeDetachedView(b0Var.itemView, false);
                }
            }
        }

        public final void dispatchAnimationStarted(b0 b0Var) {
            onAnimationStarted(b0Var);
        }

        public final void dispatchAnimationsFinished() {
            int size = this.mFinishedListeners.size();
            for (int i = 0; i < size; i++) {
                this.mFinishedListeners.get(i).a();
            }
            this.mFinishedListeners.clear();
        }

        public abstract void endAnimation(b0 b0Var);

        public abstract void endAnimations();

        public long getAddDuration() {
            return this.mAddDuration;
        }

        public long getChangeDuration() {
            return this.mChangeDuration;
        }

        public long getMoveDuration() {
            return this.mMoveDuration;
        }

        public long getRemoveDuration() {
            return this.mRemoveDuration;
        }

        public abstract boolean isRunning();

        public final boolean isRunning(a aVar) {
            boolean isRunning = isRunning();
            if (aVar != null) {
                if (!isRunning) {
                    aVar.a();
                } else {
                    this.mFinishedListeners.add(aVar);
                }
            }
            return isRunning;
        }

        public c obtainHolderInfo() {
            return new c();
        }

        public void onAnimationFinished(b0 b0Var) {
        }

        public void onAnimationStarted(b0 b0Var) {
        }

        public c recordPostLayoutInformation(y yVar, b0 b0Var) {
            c obtainHolderInfo = obtainHolderInfo();
            Objects.requireNonNull(obtainHolderInfo);
            View view = b0Var.itemView;
            obtainHolderInfo.a = view.getLeft();
            obtainHolderInfo.b = view.getTop();
            view.getRight();
            view.getBottom();
            return obtainHolderInfo;
        }

        public c recordPreLayoutInformation(y yVar, b0 b0Var, int i, List<Object> list) {
            c obtainHolderInfo = obtainHolderInfo();
            Objects.requireNonNull(obtainHolderInfo);
            View view = b0Var.itemView;
            obtainHolderInfo.a = view.getLeft();
            obtainHolderInfo.b = view.getTop();
            view.getRight();
            view.getBottom();
            return obtainHolderInfo;
        }

        public abstract void runPendingAnimations();

        public void setAddDuration(long j) {
            this.mAddDuration = j;
        }

        public void setChangeDuration(long j) {
            this.mChangeDuration = j;
        }

        public void setListener(b bVar) {
            this.mListener = bVar;
        }

        public void setMoveDuration(long j) {
            this.mMoveDuration = j;
        }

        public void setRemoveDuration(long j) {
            this.mRemoveDuration = j;
        }
    }

    /* loaded from: classes.dex */
    public class l implements k.b {
        public l() {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class m {
        public void f(Rect rect, View view, RecyclerView recyclerView, y yVar) {
            ((o) view.getLayoutParams()).a();
            rect.set(0, 0, 0, 0);
        }

        public void g(Canvas canvas, RecyclerView recyclerView, y yVar) {
        }

        public void h(Canvas canvas, RecyclerView recyclerView, y yVar) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class n {
        public h0.v.a.e mChildHelper;
        private int mHeight;
        private int mHeightMode;
        public h0.v.a.b0 mHorizontalBoundCheck;
        private final b0.b mHorizontalBoundCheckCallback;
        public int mPrefetchMaxCountObserved;
        public boolean mPrefetchMaxObservedInInitialPrefetch;
        public RecyclerView mRecyclerView;
        public x mSmoothScroller;
        public h0.v.a.b0 mVerticalBoundCheck;
        private final b0.b mVerticalBoundCheckCallback;
        private int mWidth;
        private int mWidthMode;
        public boolean mRequestedSimpleAnimations = false;
        public boolean mIsAttachedToWindow = false;
        public boolean mAutoMeasure = false;
        private boolean mMeasurementCacheEnabled = true;
        private boolean mItemPrefetchEnabled = true;

        /* loaded from: classes.dex */
        public class a implements b0.b {
            public a() {
            }

            @Override // h0.v.a.b0.b
            public int a(View view) {
                return n.this.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((o) view.getLayoutParams())).leftMargin;
            }

            @Override // h0.v.a.b0.b
            public int b() {
                return n.this.getPaddingLeft();
            }

            @Override // h0.v.a.b0.b
            public int c() {
                return n.this.getWidth() - n.this.getPaddingRight();
            }

            @Override // h0.v.a.b0.b
            public View d(int i) {
                return n.this.getChildAt(i);
            }

            @Override // h0.v.a.b0.b
            public int e(View view) {
                return n.this.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((o) view.getLayoutParams())).rightMargin;
            }
        }

        /* loaded from: classes.dex */
        public class b implements b0.b {
            public b() {
            }

            @Override // h0.v.a.b0.b
            public int a(View view) {
                return n.this.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((o) view.getLayoutParams())).topMargin;
            }

            @Override // h0.v.a.b0.b
            public int b() {
                return n.this.getPaddingTop();
            }

            @Override // h0.v.a.b0.b
            public int c() {
                return n.this.getHeight() - n.this.getPaddingBottom();
            }

            @Override // h0.v.a.b0.b
            public View d(int i) {
                return n.this.getChildAt(i);
            }

            @Override // h0.v.a.b0.b
            public int e(View view) {
                return n.this.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((o) view.getLayoutParams())).bottomMargin;
            }
        }

        /* loaded from: classes.dex */
        public interface c {
        }

        /* loaded from: classes.dex */
        public static class d {
            public int a;
            public int b;
            public boolean c;
            public boolean d;
        }

        public n() {
            a aVar = new a();
            this.mHorizontalBoundCheckCallback = aVar;
            b bVar = new b();
            this.mVerticalBoundCheckCallback = bVar;
            this.mHorizontalBoundCheck = new h0.v.a.b0(aVar);
            this.mVerticalBoundCheck = new h0.v.a.b0(bVar);
        }

        private void addViewInt(View view, int i, boolean z) {
            b0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (z || childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.a(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.f(childViewHolderInt);
            }
            o oVar = (o) view.getLayoutParams();
            if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.mChildHelper.b(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.mRecyclerView) {
                int j = this.mChildHelper.j(view);
                if (i == -1) {
                    i = this.mChildHelper.e();
                }
                if (j == -1) {
                    StringBuilder P0 = i0.d.a.a.a.P0("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                    P0.append(this.mRecyclerView.indexOfChild(view));
                    throw new IllegalStateException(i0.d.a.a.a.S(this.mRecyclerView, P0));
                } else if (j != i) {
                    this.mRecyclerView.mLayout.moveView(j, i);
                }
            } else {
                this.mChildHelper.a(view, i, false);
                oVar.c = true;
                x xVar = this.mSmoothScroller;
                if (xVar != null && xVar.e && xVar.b.getChildLayoutPosition(view) == xVar.a) {
                    xVar.f = view;
                }
            }
            if (oVar.d) {
                childViewHolderInt.itemView.invalidate();
                oVar.d = false;
            }
        }

        public static int chooseSize(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        private void detachViewInternal(int i, View view) {
            this.mChildHelper.c(i);
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
            if (r3 >= 0) goto L_0x0011;
         */
        @Deprecated
        /* Code decompiled incorrectly, please refer to instructions dump */
        public static int getChildMeasureSpec(int i, int i2, int i3, boolean z) {
            int i4 = i - i2;
            int i5 = 0;
            int max = Math.max(0, i4);
            i5 = 1073741824;
            if (!z) {
                if (i3 < 0) {
                    if (i3 == -1) {
                        i3 = max;
                    } else {
                        if (i3 == -2) {
                            i5 = Integer.MIN_VALUE;
                            i3 = max;
                        }
                        i3 = 0;
                    }
                }
            }
            return View.MeasureSpec.makeMeasureSpec(i3, i5);
        }

        private int[] getChildRectangleOnScreenScrollAmount(View view, Rect rect) {
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width2 = rect.width() + left;
            int height2 = rect.height() + top;
            int i = left - paddingLeft;
            int min = Math.min(0, i);
            int i2 = top - paddingTop;
            int min2 = Math.min(0, i2);
            int i3 = width2 - width;
            int max = Math.max(0, i3);
            int max2 = Math.max(0, height2 - height);
            if (getLayoutDirection() != 1) {
                if (min == 0) {
                    min = Math.min(i, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i3);
            }
            if (min2 == 0) {
                min2 = Math.min(i2, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        public static d getProperties(Context context, AttributeSet attributeSet, int i, int i2) {
            d dVar = new d();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecyclerView, i, i2);
            dVar.a = obtainStyledAttributes.getInt(R.styleable.RecyclerView_android_orientation, 1);
            dVar.b = obtainStyledAttributes.getInt(R.styleable.RecyclerView_spanCount, 1);
            dVar.c = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_reverseLayout, false);
            dVar.d = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return dVar;
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            Rect rect = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(focusedChild, rect);
            if (rect.left - i >= width || rect.right - i <= paddingLeft || rect.top - i2 >= height || rect.bottom - i2 <= paddingTop) {
                return false;
            }
            return true;
        }

        private static boolean isMeasurementUpToDate(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        private void scrapOrRecycleView(u uVar, int i, View view) {
            b0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.shouldIgnore()) {
                if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || this.mRecyclerView.mAdapter.hasStableIds()) {
                    detachViewAt(i);
                    uVar.k(view);
                    this.mRecyclerView.mViewInfoStore.f(childViewHolderInt);
                    return;
                }
                removeViewAt(i);
                uVar.j(childViewHolderInt);
            }
        }

        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        public void addView(View view) {
            addView(view, -1);
        }

        public void assertInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertInLayoutOrScroll(str);
            }
        }

        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        public void attachView(View view, int i, o oVar) {
            b0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.a(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.f(childViewHolderInt);
            }
            this.mChildHelper.b(view, i, oVar, childViewHolderInt.isRemoved());
        }

        public void calculateItemDecorationsForChild(View view, Rect rect) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view));
            }
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(o oVar) {
            return oVar != null;
        }

        public void collectAdjacentPrefetchPositions(int i, int i2, y yVar, c cVar) {
        }

        public void collectInitialPrefetchPositions(int i, c cVar) {
        }

        public int computeHorizontalScrollExtent(y yVar) {
            return 0;
        }

        public int computeHorizontalScrollOffset(y yVar) {
            return 0;
        }

        public int computeHorizontalScrollRange(y yVar) {
            return 0;
        }

        public int computeVerticalScrollExtent(y yVar) {
            return 0;
        }

        public int computeVerticalScrollOffset(y yVar) {
            return 0;
        }

        public int computeVerticalScrollRange(y yVar) {
            return 0;
        }

        public void detachAndScrapAttachedViews(u uVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                scrapOrRecycleView(uVar, childCount, getChildAt(childCount));
            }
        }

        public void detachAndScrapView(View view, u uVar) {
            scrapOrRecycleView(uVar, this.mChildHelper.j(view), view);
        }

        public void detachAndScrapViewAt(int i, u uVar) {
            scrapOrRecycleView(uVar, i, getChildAt(i));
        }

        public void detachView(View view) {
            int j = this.mChildHelper.j(view);
            if (j >= 0) {
                detachViewInternal(j, view);
            }
        }

        public void detachViewAt(int i) {
            detachViewInternal(i, getChildAt(i));
        }

        public void dispatchAttachedToWindow(RecyclerView recyclerView) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(recyclerView);
        }

        public void dispatchDetachedFromWindow(RecyclerView recyclerView, u uVar) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(recyclerView, uVar);
        }

        public void endAnimation(View view) {
            k kVar = this.mRecyclerView.mItemAnimator;
            if (kVar != null) {
                kVar.endAnimation(RecyclerView.getChildViewHolderInt(view));
            }
        }

        public View findContainingItemView(View view) {
            View findContainingItemView;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (findContainingItemView = recyclerView.findContainingItemView(view)) == null || this.mChildHelper.c.contains(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        public View findViewByPosition(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                b0 childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.g || !childViewHolderInt.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        public abstract o generateDefaultLayoutParams();

        public o generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof o) {
                return new o((o) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new o((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new o(layoutParams);
        }

        public int getBaseline() {
            return -1;
        }

        public int getBottomDecorationHeight(View view) {
            return ((o) view.getLayoutParams()).b.bottom;
        }

        public View getChildAt(int i) {
            h0.v.a.e eVar = this.mChildHelper;
            if (eVar == null) {
                return null;
            }
            return ((e) eVar.a).a(eVar.f(i));
        }

        public int getChildCount() {
            h0.v.a.e eVar = this.mChildHelper;
            if (eVar != null) {
                return eVar.e();
            }
            return 0;
        }

        public boolean getClipToPadding() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.mClipToPadding;
        }

        public int getColumnCountForAccessibility(u uVar, y yVar) {
            return -1;
        }

        public int getDecoratedBottom(View view) {
            return getBottomDecorationHeight(view) + view.getBottom();
        }

        public void getDecoratedBoundsWithMargins(View view, Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public int getDecoratedLeft(View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedMeasuredHeight(View view) {
            Rect rect = ((o) view.getLayoutParams()).b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int getDecoratedMeasuredWidth(View view) {
            Rect rect = ((o) view.getLayoutParams()).b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedRight(View view) {
            return getRightDecorationWidth(view) + view.getRight();
        }

        public int getDecoratedTop(View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        public View getFocusedChild() {
            View focusedChild;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.mChildHelper.c.contains(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getItemCount() {
            RecyclerView recyclerView = this.mRecyclerView;
            Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public int getItemViewType(View view) {
            return RecyclerView.getChildViewHolderInt(view).getItemViewType();
        }

        public int getLayoutDirection() {
            RecyclerView recyclerView = this.mRecyclerView;
            AtomicInteger atomicInteger = h0.i.i.q.a;
            return recyclerView.getLayoutDirection();
        }

        public int getLeftDecorationWidth(View view) {
            return ((o) view.getLayoutParams()).b.left;
        }

        public int getMinimumHeight() {
            RecyclerView recyclerView = this.mRecyclerView;
            AtomicInteger atomicInteger = h0.i.i.q.a;
            return recyclerView.getMinimumHeight();
        }

        public int getMinimumWidth() {
            RecyclerView recyclerView = this.mRecyclerView;
            AtomicInteger atomicInteger = h0.i.i.q.a;
            return recyclerView.getMinimumWidth();
        }

        public int getPaddingBottom() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingEnd() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                return 0;
            }
            AtomicInteger atomicInteger = h0.i.i.q.a;
            return recyclerView.getPaddingEnd();
        }

        public int getPaddingLeft() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingStart() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                return 0;
            }
            AtomicInteger atomicInteger = h0.i.i.q.a;
            return recyclerView.getPaddingStart();
        }

        public int getPaddingTop() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPosition(View view) {
            return ((o) view.getLayoutParams()).a();
        }

        public int getRightDecorationWidth(View view) {
            return ((o) view.getLayoutParams()).b.right;
        }

        public int getRowCountForAccessibility(u uVar, y yVar) {
            return -1;
        }

        public int getSelectionModeForAccessibility(u uVar, y yVar) {
            return 0;
        }

        public int getTopDecorationHeight(View view) {
            return ((o) view.getLayoutParams()).b.top;
        }

        public void getTransformedBoundingBox(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((o) view.getLayoutParams()).b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (!(this.mRecyclerView == null || (matrix = view.getMatrix()) == null || matrix.isIdentity())) {
                RectF rectF = this.mRecyclerView.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        public boolean hasFlexibleChildInBothOrientations() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean hasFocus() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.hasFocus();
        }

        public void ignoreView(View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.mRecyclerView;
            if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
                throw new IllegalArgumentException(i0.d.a.a.a.S(this.mRecyclerView, i0.d.a.a.a.P0("View should be fully attached to be ignored")));
            }
            b0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.addFlags(128);
            this.mRecyclerView.mViewInfoStore.g(childViewHolderInt);
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public boolean isFocused() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.isFocused();
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        public boolean isLayoutHierarchical(u uVar, y yVar) {
            return false;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public boolean isSmoothScrolling() {
            x xVar = this.mSmoothScroller;
            return xVar != null && xVar.e;
        }

        public boolean isViewPartiallyVisible(View view, boolean z, boolean z2) {
            boolean z3 = this.mHorizontalBoundCheck.b(view, 24579) && this.mVerticalBoundCheck.b(view, 24579);
            return z ? z3 : !z3;
        }

        public void layoutDecorated(View view, int i, int i2, int i3, int i4) {
            Rect rect = ((o) view.getLayoutParams()).b;
            view.layout(i + rect.left, i2 + rect.top, i3 - rect.right, i4 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(View view, int i, int i2, int i3, int i4) {
            o oVar = (o) view.getLayoutParams();
            Rect rect = oVar.b;
            view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) oVar).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) oVar).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) oVar).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) oVar).bottomMargin);
        }

        public void measureChild(View view, int i, int i2) {
            o oVar = (o) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = itemDecorInsetsForChild.left + itemDecorInsetsForChild.right + i;
            int i4 = itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom + i2;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft() + i3, ((ViewGroup.MarginLayoutParams) oVar).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop() + i4, ((ViewGroup.MarginLayoutParams) oVar).height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, oVar)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void measureChildWithMargins(View view, int i, int i2) {
            o oVar = (o) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = itemDecorInsetsForChild.left + itemDecorInsetsForChild.right + i;
            int i4 = itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom + i2;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft() + ((ViewGroup.MarginLayoutParams) oVar).leftMargin + ((ViewGroup.MarginLayoutParams) oVar).rightMargin + i3, ((ViewGroup.MarginLayoutParams) oVar).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop() + ((ViewGroup.MarginLayoutParams) oVar).topMargin + ((ViewGroup.MarginLayoutParams) oVar).bottomMargin + i4, ((ViewGroup.MarginLayoutParams) oVar).height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, oVar)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void moveView(int i, int i2) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                detachViewAt(i);
                attachView(childAt, i2);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.mRecyclerView.toString());
        }

        public void offsetChildrenHorizontal(int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i);
            }
        }

        public void offsetChildrenVertical(int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i);
            }
        }

        public void onAdapterChanged(Adapter adapter, Adapter adapter2) {
        }

        public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        public void onDetachedFromWindow(RecyclerView recyclerView, u uVar) {
            onDetachedFromWindow(recyclerView);
        }

        public View onFocusSearchFailed(View view, int i, u uVar, y yVar) {
            return null;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityEvent(recyclerView.mRecycler, recyclerView.mState, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(h0.i.i.g0.b bVar) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityNodeInfo(recyclerView.mRecycler, recyclerView.mState, bVar);
        }

        public void onInitializeAccessibilityNodeInfoForItem(View view, h0.i.i.g0.b bVar) {
            b0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && !this.mChildHelper.k(childViewHolderInt.itemView)) {
                RecyclerView recyclerView = this.mRecyclerView;
                onInitializeAccessibilityNodeInfoForItem(recyclerView.mRecycler, recyclerView.mState, view, bVar);
            }
        }

        public void onInitializeAccessibilityNodeInfoForItem(u uVar, y yVar, View view, h0.i.i.g0.b bVar) {
        }

        public View onInterceptFocusSearch(View view, int i) {
            return null;
        }

        public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsChanged(RecyclerView recyclerView) {
        }

        public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
            onItemsUpdated(recyclerView, i, i2);
        }

        public void onLayoutChildren(u uVar, y yVar) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void onLayoutCompleted(y yVar) {
        }

        public void onMeasure(u uVar, y yVar, int i, int i2) {
            this.mRecyclerView.defaultOnMeasure(i, i2);
        }

        @Deprecated
        public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int i) {
        }

        public void onSmoothScrollerStopped(x xVar) {
            if (this.mSmoothScroller == xVar) {
                this.mSmoothScroller = null;
            }
        }

        public boolean performAccessibilityAction(int i, Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityAction(recyclerView.mRecycler, recyclerView.mState, i, bundle);
        }

        public boolean performAccessibilityActionForItem(View view, int i, Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityActionForItem(recyclerView.mRecycler, recyclerView.mState, view, i, bundle);
        }

        public boolean performAccessibilityActionForItem(u uVar, y yVar, View view, int i, Bundle bundle) {
            return false;
        }

        public void postOnAnimation(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                AtomicInteger atomicInteger = h0.i.i.q.a;
                recyclerView.postOnAnimation(runnable);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.mChildHelper.l(childCount);
            }
        }

        public void removeAndRecycleAllViews(u uVar) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                    removeAndRecycleViewAt(childCount, uVar);
                }
            }
        }

        public void removeAndRecycleScrapInt(u uVar) {
            int size = uVar.a.size();
            for (int i = size - 1; i >= 0; i--) {
                View view = uVar.a.get(i).itemView;
                b0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(view, false);
                    }
                    k kVar = this.mRecyclerView.mItemAnimator;
                    if (kVar != null) {
                        kVar.endAnimation(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    b0 childViewHolderInt2 = RecyclerView.getChildViewHolderInt(view);
                    childViewHolderInt2.mScrapContainer = null;
                    childViewHolderInt2.mInChangeScrap = false;
                    childViewHolderInt2.clearReturnedFromScrapFlag();
                    uVar.j(childViewHolderInt2);
                }
            }
            uVar.a.clear();
            ArrayList<b0> arrayList = uVar.b;
            if (arrayList != null) {
                arrayList.clear();
            }
            if (size > 0) {
                this.mRecyclerView.invalidate();
            }
        }

        public void removeAndRecycleView(View view, u uVar) {
            removeView(view);
            uVar.i(view);
        }

        public void removeAndRecycleViewAt(int i, u uVar) {
            View childAt = getChildAt(i);
            removeViewAt(i);
            uVar.i(childAt);
        }

        public boolean removeCallbacks(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void removeDetachedView(View view) {
            this.mRecyclerView.removeDetachedView(view, false);
        }

        public void removeView(View view) {
            h0.v.a.e eVar = this.mChildHelper;
            int indexOfChild = RecyclerView.this.indexOfChild(view);
            if (indexOfChild >= 0) {
                if (eVar.b.f(indexOfChild)) {
                    eVar.m(view);
                }
                ((e) eVar.a).c(indexOfChild);
            }
        }

        public void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                this.mChildHelper.l(i);
            }
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z, false);
        }

        public void requestLayout() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        public int scrollHorizontallyBy(int i, u uVar, y yVar) {
            return 0;
        }

        public void scrollToPosition(int i) {
        }

        public int scrollVerticallyBy(int i, u uVar, y yVar) {
            return 0;
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean z) {
            this.mAutoMeasure = z;
        }

        public void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public final void setItemPrefetchEnabled(boolean z) {
            if (z != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = z;
                this.mPrefetchMaxCountObserved = 0;
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.mRecycler.o();
                }
            }
        }

        public void setMeasureSpecs(int i, int i2) {
            this.mWidth = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.mWidthMode = mode;
            if (mode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mWidth = 0;
            }
            this.mHeight = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.mHeightMode = mode2;
            if (mode2 == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mHeight = 0;
            }
        }

        public void setMeasuredDimension(Rect rect, int i, int i2) {
            setMeasuredDimension(chooseSize(i, getPaddingRight() + getPaddingLeft() + rect.width(), getMinimumWidth()), chooseSize(i2, getPaddingBottom() + getPaddingTop() + rect.height(), getMinimumHeight()));
        }

        public void setMeasuredDimensionFromChildren(int i, int i2) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.defaultOnMeasure(i, i2);
                return;
            }
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MIN_VALUE;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                Rect rect = this.mRecyclerView.mTempRect;
                getDecoratedBoundsWithMargins(childAt, rect);
                int i8 = rect.left;
                if (i8 < i4) {
                    i4 = i8;
                }
                int i9 = rect.right;
                if (i9 > i3) {
                    i3 = i9;
                }
                int i10 = rect.top;
                if (i10 < i5) {
                    i5 = i10;
                }
                int i11 = rect.bottom;
                if (i11 > i6) {
                    i6 = i11;
                }
            }
            this.mRecyclerView.mTempRect.set(i4, i5, i3, i6);
            setMeasuredDimension(this.mRecyclerView.mTempRect, i, i2);
        }

        public void setMeasurementCacheEnabled(boolean z) {
            this.mMeasurementCacheEnabled = z;
        }

        public void setRecyclerView(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.mRecyclerView = recyclerView;
                this.mChildHelper = recyclerView.mChildHelper;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
        }

        public boolean shouldMeasureChild(View view, int i, int i2, o oVar) {
            return view.isLayoutRequested() || !this.mMeasurementCacheEnabled || !isMeasurementUpToDate(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) oVar).width) || !isMeasurementUpToDate(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) oVar).height);
        }

        public boolean shouldMeasureTwice() {
            return false;
        }

        public boolean shouldReMeasureChild(View view, int i, int i2, o oVar) {
            return !this.mMeasurementCacheEnabled || !isMeasurementUpToDate(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) oVar).width) || !isMeasurementUpToDate(view.getMeasuredHeight(), i2, ((ViewGroup.MarginLayoutParams) oVar).height);
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, y yVar, int i) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void startSmoothScroll(x xVar) {
            x xVar2 = this.mSmoothScroller;
            if (!(xVar2 == null || xVar == xVar2 || !xVar2.e)) {
                xVar2.d();
            }
            this.mSmoothScroller = xVar;
            RecyclerView recyclerView = this.mRecyclerView;
            Objects.requireNonNull(xVar);
            recyclerView.mViewFlinger.c();
            if (xVar.h) {
                StringBuilder P0 = i0.d.a.a.a.P0("An instance of ");
                P0.append(xVar.getClass().getSimpleName());
                P0.append(" was started more than once. Each instance of");
                P0.append(xVar.getClass().getSimpleName());
                P0.append(" is intended to only be used once. You should create a new instance for each use.");
                Log.w(RecyclerView.TAG, P0.toString());
            }
            xVar.b = recyclerView;
            xVar.c = this;
            int i = xVar.a;
            if (i != -1) {
                recyclerView.mState.a = i;
                xVar.e = true;
                xVar.d = true;
                xVar.f = recyclerView.mLayout.findViewByPosition(i);
                xVar.b.mViewFlinger.a();
                xVar.h = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        public void stopIgnoringView(View view) {
            b0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.stopIgnoring();
            childViewHolderInt.resetInternal();
            childViewHolderInt.addFlags(4);
        }

        public void stopSmoothScroller() {
            x xVar = this.mSmoothScroller;
            if (xVar != null) {
                xVar.d();
            }
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        public void addDisappearingView(View view, int i) {
            addViewInt(view, i, true);
        }

        public void addView(View view, int i) {
            addViewInt(view, i, false);
        }

        public void onInitializeAccessibilityEvent(u uVar, y yVar, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z = true;
                if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
                    z = false;
                }
                accessibilityEvent.setScrollable(z);
                Adapter adapter = this.mRecyclerView.mAdapter;
                if (adapter != null) {
                    accessibilityEvent.setItemCount(adapter.getItemCount());
                }
            }
        }

        public void onInitializeAccessibilityNodeInfo(u uVar, y yVar, h0.i.i.g0.b bVar) {
            if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
                bVar.b.addAction(8192);
                bVar.b.setScrollable(true);
            }
            if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
                bVar.b.addAction(4096);
                bVar.b.setScrollable(true);
            }
            bVar.i(b.C0077b.a(getRowCountForAccessibility(uVar, yVar), getColumnCountForAccessibility(uVar, yVar), isLayoutHierarchical(uVar, yVar), getSelectionModeForAccessibility(uVar, yVar)));
        }

        public boolean onRequestChildFocus(RecyclerView recyclerView, y yVar, View view, View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        public boolean performAccessibilityAction(u uVar, y yVar, int i, Bundle bundle) {
            int i2;
            int i3;
            int i4;
            int i5;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                return false;
            }
            if (i == 4096) {
                i4 = recyclerView.canScrollVertically(1) ? (getHeight() - getPaddingTop()) - getPaddingBottom() : 0;
                if (this.mRecyclerView.canScrollHorizontally(1)) {
                    i5 = (getWidth() - getPaddingLeft()) - getPaddingRight();
                    i2 = i4;
                    i3 = i5;
                }
                i2 = i4;
                i3 = 0;
            } else if (i != 8192) {
                i3 = 0;
                i2 = 0;
            } else {
                i4 = recyclerView.canScrollVertically(-1) ? -((getHeight() - getPaddingTop()) - getPaddingBottom()) : 0;
                if (this.mRecyclerView.canScrollHorizontally(-1)) {
                    i5 = -((getWidth() - getPaddingLeft()) - getPaddingRight());
                    i2 = i4;
                    i3 = i5;
                }
                i2 = i4;
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return false;
            }
            this.mRecyclerView.smoothScrollBy(i3, i2, null, Integer.MIN_VALUE, true);
            return true;
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] childRectangleOnScreenScrollAmount = getChildRectangleOnScreenScrollAmount(view, rect);
            int i = childRectangleOnScreenScrollAmount[0];
            int i2 = childRectangleOnScreenScrollAmount[1];
            if ((z2 && !isFocusedChildVisibleAfterScrolling(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.smoothScrollBy(i, i2);
            }
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0017, code lost:
            if (r5 == 1073741824) goto L_0x0020;
         */
        /* Code decompiled incorrectly, please refer to instructions dump */
        public static int getChildMeasureSpec(int i, int i2, int i3, int i4, boolean z) {
            int max = Math.max(0, i - i3);
            if (z) {
                if (i4 < 0) {
                    if (i4 == -1) {
                        if (i2 != Integer.MIN_VALUE) {
                            if (i2 != 0) {
                            }
                        }
                        i4 = max;
                    }
                    i2 = 0;
                    i4 = 0;
                }
                i2 = 1073741824;
            } else {
                if (i4 < 0) {
                    if (i4 != -1) {
                        if (i4 == -2) {
                            if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                                i4 = max;
                                i2 = Integer.MIN_VALUE;
                            } else {
                                i4 = max;
                                i2 = 0;
                            }
                        }
                        i2 = 0;
                        i4 = 0;
                    }
                    i4 = max;
                }
                i2 = 1073741824;
            }
            return View.MeasureSpec.makeMeasureSpec(i4, i2);
        }

        public void attachView(View view, int i) {
            attachView(view, i, (o) view.getLayoutParams());
        }

        public o generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new o(context, attributeSet);
        }

        public void setMeasuredDimension(int i, int i2) {
            this.mRecyclerView.setMeasuredDimension(i, i2);
        }

        public void attachView(View view) {
            attachView(view, -1);
        }
    }

    /* loaded from: classes.dex */
    public interface p {
        void b(View view);

        void d(View view);
    }

    /* loaded from: classes.dex */
    public static abstract class q {
    }

    /* loaded from: classes.dex */
    public interface r {
        void a(RecyclerView recyclerView, MotionEvent motionEvent);

        boolean c(RecyclerView recyclerView, MotionEvent motionEvent);

        void e(boolean z);
    }

    /* loaded from: classes.dex */
    public static abstract class s {
        public void a(RecyclerView recyclerView, int i) {
        }

        public void c(RecyclerView recyclerView, int i, int i2) {
        }
    }

    /* loaded from: classes.dex */
    public static class t {
        public SparseArray<a> a = new SparseArray<>();
        public int b = 0;

        /* loaded from: classes.dex */
        public static class a {
            public final ArrayList<b0> a = new ArrayList<>();
            public int b = 5;
            public long c = 0;
            public long d = 0;
        }

        public void a() {
            for (int i = 0; i < this.a.size(); i++) {
                this.a.valueAt(i).a.clear();
            }
        }

        public b0 b(int i) {
            a aVar = this.a.get(i);
            if (aVar == null || aVar.a.isEmpty()) {
                return null;
            }
            ArrayList<b0> arrayList = aVar.a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).isAttachedToTransitionOverlay()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        public final a c(int i) {
            a aVar = this.a.get(i);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.a.put(i, aVar2);
            return aVar2;
        }

        public void d(b0 b0Var) {
            int itemViewType = b0Var.getItemViewType();
            ArrayList<b0> arrayList = c(itemViewType).a;
            if (this.a.get(itemViewType).b > arrayList.size()) {
                b0Var.resetInternal();
                arrayList.add(b0Var);
            }
        }

        public long e(long j, long j2) {
            if (j == 0) {
                return j2;
            }
            return (j2 / 4) + ((j / 4) * 3);
        }
    }

    /* loaded from: classes.dex */
    public final class u {
        public final ArrayList<b0> a;
        public final List<b0> d;
        public t g;
        public ArrayList<b0> b = null;
        public final ArrayList<b0> c = new ArrayList<>();
        public int e = 2;
        public int f = 2;

        public u() {
            ArrayList<b0> arrayList = new ArrayList<>();
            this.a = arrayList;
            this.d = Collections.unmodifiableList(arrayList);
        }

        public void a(b0 b0Var, boolean z) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(b0Var);
            View view = b0Var.itemView;
            h0.v.a.x xVar = RecyclerView.this.mAccessibilityDelegate;
            if (xVar != null) {
                x.a aVar = xVar.b;
                h0.i.i.q.p(view, aVar instanceof x.a ? aVar.b.remove(view) : null);
            }
            if (z) {
                v vVar = RecyclerView.this.mRecyclerListener;
                if (vVar != null) {
                    vVar.a(b0Var);
                }
                int size = RecyclerView.this.mRecyclerListeners.size();
                for (int i = 0; i < size; i++) {
                    RecyclerView.this.mRecyclerListeners.get(i).a(b0Var);
                }
                Adapter adapter = RecyclerView.this.mAdapter;
                if (adapter != null) {
                    adapter.onViewRecycled(b0Var);
                }
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mState != null) {
                    recyclerView.mViewInfoStore.g(b0Var);
                }
            }
            b0Var.mBindingAdapter = null;
            b0Var.mOwnerRecyclerView = null;
            d().d(b0Var);
        }

        public void b() {
            this.a.clear();
            g();
        }

        public int c(int i) {
            if (i < 0 || i >= RecyclerView.this.mState.b()) {
                StringBuilder Q0 = i0.d.a.a.a.Q0("invalid position ", i, ". State item count is ");
                Q0.append(RecyclerView.this.mState.b());
                throw new IndexOutOfBoundsException(i0.d.a.a.a.S(RecyclerView.this, Q0));
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.mState.g) {
                return i;
            }
            return recyclerView.mAdapterHelper.f(i, 0);
        }

        public t d() {
            if (this.g == null) {
                this.g = new t();
            }
            return this.g;
        }

        public View e(int i) {
            return m(i, false, RecyclerView.FOREVER_NS).itemView;
        }

        public final void f(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    f((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        public void g() {
            for (int size = this.c.size() - 1; size >= 0; size--) {
                h(size);
            }
            this.c.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                j.b bVar = RecyclerView.this.mPrefetchRegistry;
                int[] iArr = bVar.c;
                if (iArr != null) {
                    Arrays.fill(iArr, -1);
                }
                bVar.d = 0;
            }
        }

        public void h(int i) {
            a(this.c.get(i), true);
            this.c.remove(i);
        }

        public void i(View view) {
            b0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            j(childViewHolderInt);
            if (RecyclerView.this.mItemAnimator != null && !childViewHolderInt.isRecyclable()) {
                RecyclerView.this.mItemAnimator.endAnimation(childViewHolderInt);
            }
        }

        public void j(b0 b0Var) {
            boolean z;
            boolean z2;
            boolean z3 = false;
            if (b0Var.isScrap() || b0Var.itemView.getParent() != null) {
                StringBuilder P0 = i0.d.a.a.a.P0("Scrapped or attached views may not be recycled. isScrap:");
                P0.append(b0Var.isScrap());
                P0.append(" isAttached:");
                if (b0Var.itemView.getParent() != null) {
                    z3 = true;
                }
                P0.append(z3);
                throw new IllegalArgumentException(i0.d.a.a.a.S(RecyclerView.this, P0));
            } else if (b0Var.isTmpDetached()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
                sb.append(b0Var);
                throw new IllegalArgumentException(i0.d.a.a.a.S(RecyclerView.this, sb));
            } else if (!b0Var.shouldIgnore()) {
                boolean doesTransientStatePreventRecycling = b0Var.doesTransientStatePreventRecycling();
                Adapter adapter = RecyclerView.this.mAdapter;
                if ((adapter != null && doesTransientStatePreventRecycling && adapter.onFailedToRecycleView(b0Var)) || b0Var.isRecyclable()) {
                    if (this.f <= 0 || b0Var.hasAnyOfTheFlags(526)) {
                        z2 = false;
                    } else {
                        int size = this.c.size();
                        if (size >= this.f && size > 0) {
                            h(0);
                            size--;
                        }
                        if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !RecyclerView.this.mPrefetchRegistry.c(b0Var.mPosition)) {
                            do {
                                size--;
                                if (size < 0) {
                                    break;
                                }
                            } while (RecyclerView.this.mPrefetchRegistry.c(this.c.get(size).mPosition));
                            size++;
                        }
                        this.c.add(size, b0Var);
                        z2 = true;
                    }
                    if (!z2) {
                        a(b0Var, true);
                        z3 = true;
                    }
                    z = z3;
                    z3 = z2;
                } else {
                    z = false;
                }
                RecyclerView.this.mViewInfoStore.g(b0Var);
                if (!z3 && !z && doesTransientStatePreventRecycling) {
                    b0Var.mBindingAdapter = null;
                    b0Var.mOwnerRecyclerView = null;
                }
            } else {
                throw new IllegalArgumentException(i0.d.a.a.a.S(RecyclerView.this, i0.d.a.a.a.P0("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.")));
            }
        }

        public void k(View view) {
            b0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.hasAnyOfTheFlags(12) && childViewHolderInt.isUpdated() && !RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (this.b == null) {
                    this.b = new ArrayList<>();
                }
                childViewHolderInt.setScrapContainer(this, true);
                this.b.add(childViewHolderInt);
            } else if (!childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved() || RecyclerView.this.mAdapter.hasStableIds()) {
                childViewHolderInt.setScrapContainer(this, false);
                this.a.add(childViewHolderInt);
            } else {
                throw new IllegalArgumentException(i0.d.a.a.a.S(RecyclerView.this, i0.d.a.a.a.P0("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.")));
            }
        }

        public final boolean l(b0 b0Var, int i, int i2, long j) {
            b0Var.mBindingAdapter = null;
            b0Var.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = b0Var.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != RecyclerView.FOREVER_NS) {
                long j2 = this.g.c(itemViewType).d;
                if (!(j2 == 0 || j2 + nanoTime < j)) {
                    return false;
                }
            }
            RecyclerView.this.mAdapter.bindViewHolder(b0Var, i);
            long nanoTime2 = RecyclerView.this.getNanoTime();
            t tVar = this.g;
            t.a c = tVar.c(b0Var.getItemViewType());
            c.d = tVar.e(c.d, nanoTime2 - nanoTime);
            if (RecyclerView.this.isAccessibilityEnabled()) {
                View view = b0Var.itemView;
                AtomicInteger atomicInteger = h0.i.i.q.a;
                if (view.getImportantForAccessibility() == 0) {
                    view.setImportantForAccessibility(1);
                }
                h0.v.a.x xVar = RecyclerView.this.mAccessibilityDelegate;
                if (xVar != null) {
                    x.a aVar = xVar.b;
                    if (aVar instanceof x.a) {
                        Objects.requireNonNull(aVar);
                        h0.i.i.a e = h0.i.i.q.e(view);
                        if (!(e == null || e == aVar)) {
                            aVar.b.put(view, e);
                        }
                    }
                    h0.i.i.q.p(view, aVar);
                }
            }
            if (RecyclerView.this.mState.g) {
                b0Var.mPreLayoutPosition = i2;
            }
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:125:0x0259  */
        /* JADX WARN: Removed duplicated region for block: B:195:0x03c5  */
        /* JADX WARN: Removed duplicated region for block: B:201:0x03e0  */
        /* JADX WARN: Removed duplicated region for block: B:204:0x0401  */
        /* JADX WARN: Removed duplicated region for block: B:209:0x0410  */
        /* JADX WARN: Removed duplicated region for block: B:217:0x043a  */
        /* JADX WARN: Removed duplicated region for block: B:218:0x0448  */
        /* JADX WARN: Removed duplicated region for block: B:224:0x0464 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0097  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x01c3  */
        /* Code decompiled incorrectly, please refer to instructions dump */
        public b0 m(int i, boolean z, long j) {
            b0 b0Var;
            boolean z2;
            b0 b0Var2;
            boolean z3;
            boolean z4;
            ViewGroup.LayoutParams layoutParams;
            o oVar;
            RecyclerView findNestedRecyclerView;
            b0 b0Var3;
            View view;
            boolean z5;
            int size;
            int f;
            if (i < 0 || i >= RecyclerView.this.mState.b()) {
                StringBuilder R0 = i0.d.a.a.a.R0("Invalid item position ", i, "(", i, "). Item count:");
                R0.append(RecyclerView.this.mState.b());
                throw new IndexOutOfBoundsException(i0.d.a.a.a.S(RecyclerView.this, R0));
            }
            boolean z6 = true;
            if (RecyclerView.this.mState.g) {
                ArrayList<b0> arrayList = this.b;
                if (!(arrayList == null || (size = arrayList.size()) == 0)) {
                    int i2 = 0;
                    while (true) {
                        if (i2 < size) {
                            b0Var = this.b.get(i2);
                            if (!b0Var.wasReturnedFromScrap() && b0Var.getLayoutPosition() == i) {
                                b0Var.addFlags(32);
                                break;
                            }
                            i2++;
                        } else if (RecyclerView.this.mAdapter.hasStableIds() && (f = RecyclerView.this.mAdapterHelper.f(i, 0)) > 0 && f < RecyclerView.this.mAdapter.getItemCount()) {
                            long itemId = RecyclerView.this.mAdapter.getItemId(f);
                            for (int i3 = 0; i3 < size; i3++) {
                                b0 b0Var4 = this.b.get(i3);
                                if (!b0Var4.wasReturnedFromScrap() && b0Var4.getItemId() == itemId) {
                                    b0Var4.addFlags(32);
                                    b0Var = b0Var4;
                                    break;
                                }
                            }
                        }
                    }
                    if (b0Var != null) {
                        z2 = true;
                        if (b0Var == null) {
                            int size2 = this.a.size();
                            for (int i4 = 0; i4 < size2; i4++) {
                                b0Var3 = this.a.get(i4);
                                if (!b0Var3.wasReturnedFromScrap() && b0Var3.getLayoutPosition() == i && !b0Var3.isInvalid() && (RecyclerView.this.mState.g || !b0Var3.isRemoved())) {
                                    b0Var3.addFlags(32);
                                    break;
                                }
                            }
                            if (!z) {
                                h0.v.a.e eVar = RecyclerView.this.mChildHelper;
                                int size3 = eVar.c.size();
                                int i5 = 0;
                                while (true) {
                                    if (i5 >= size3) {
                                        view = null;
                                        break;
                                    }
                                    view = eVar.c.get(i5);
                                    Objects.requireNonNull((e) eVar.a);
                                    b0 childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                                    if (!(childViewHolderInt.getLayoutPosition() != i || childViewHolderInt.isInvalid() || childViewHolderInt.isRemoved())) {
                                        break;
                                    }
                                    i5++;
                                }
                                if (view != null) {
                                    b0Var = RecyclerView.getChildViewHolderInt(view);
                                    h0.v.a.e eVar2 = RecyclerView.this.mChildHelper;
                                    int indexOfChild = RecyclerView.this.indexOfChild(view);
                                    if (indexOfChild < 0) {
                                        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
                                    } else if (eVar2.b.d(indexOfChild)) {
                                        eVar2.b.a(indexOfChild);
                                        eVar2.m(view);
                                        int j2 = RecyclerView.this.mChildHelper.j(view);
                                        if (j2 != -1) {
                                            RecyclerView.this.mChildHelper.c(j2);
                                            k(view);
                                            b0Var.addFlags(8224);
                                            if (b0Var != null) {
                                                if (b0Var.isRemoved()) {
                                                    z5 = RecyclerView.this.mState.g;
                                                } else {
                                                    int i6 = b0Var.mPosition;
                                                    if (i6 < 0 || i6 >= RecyclerView.this.mAdapter.getItemCount()) {
                                                        StringBuilder sb = new StringBuilder();
                                                        sb.append("Inconsistency detected. Invalid view holder adapter position");
                                                        sb.append(b0Var);
                                                        throw new IndexOutOfBoundsException(i0.d.a.a.a.S(RecyclerView.this, sb));
                                                    }
                                                    RecyclerView recyclerView = RecyclerView.this;
                                                    z5 = (recyclerView.mState.g || recyclerView.mAdapter.getItemViewType(b0Var.mPosition) == b0Var.getItemViewType()) && (!RecyclerView.this.mAdapter.hasStableIds() || b0Var.getItemId() == RecyclerView.this.mAdapter.getItemId(b0Var.mPosition));
                                                }
                                                if (!z5) {
                                                    if (!z) {
                                                        b0Var.addFlags(4);
                                                        if (b0Var.isScrap()) {
                                                            RecyclerView.this.removeDetachedView(b0Var.itemView, false);
                                                            b0Var.unScrap();
                                                        } else if (b0Var.wasReturnedFromScrap()) {
                                                            b0Var.clearReturnedFromScrapFlag();
                                                        }
                                                        j(b0Var);
                                                    }
                                                    b0Var = null;
                                                } else {
                                                    z2 = true;
                                                }
                                            }
                                        } else {
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append("layout index should not be -1 after unhiding a view:");
                                            sb2.append(b0Var);
                                            throw new IllegalStateException(i0.d.a.a.a.S(RecyclerView.this, sb2));
                                        }
                                    } else {
                                        throw new RuntimeException("trying to unhide a view that was not hidden" + view);
                                    }
                                }
                            }
                            int size4 = this.c.size();
                            for (int i7 = 0; i7 < size4; i7++) {
                                b0Var3 = this.c.get(i7);
                                if (!b0Var3.isInvalid() && b0Var3.getLayoutPosition() == i && !b0Var3.isAttachedToTransitionOverlay()) {
                                    if (!z) {
                                        this.c.remove(i7);
                                    }
                                    b0Var = b0Var3;
                                    if (b0Var != null) {
                                    }
                                }
                            }
                            b0Var = null;
                            if (b0Var != null) {
                            }
                        }
                        if (b0Var == null) {
                            int f2 = RecyclerView.this.mAdapterHelper.f(i, 0);
                            if (f2 < 0 || f2 >= RecyclerView.this.mAdapter.getItemCount()) {
                                StringBuilder R02 = i0.d.a.a.a.R0("Inconsistency detected. Invalid item position ", i, "(offset:", f2, ").state:");
                                R02.append(RecyclerView.this.mState.b());
                                throw new IndexOutOfBoundsException(i0.d.a.a.a.S(RecyclerView.this, R02));
                            }
                            int itemViewType = RecyclerView.this.mAdapter.getItemViewType(f2);
                            if (RecyclerView.this.mAdapter.hasStableIds()) {
                                long itemId2 = RecyclerView.this.mAdapter.getItemId(f2);
                                int size5 = this.a.size() - 1;
                                while (true) {
                                    if (size5 >= 0) {
                                        b0 b0Var5 = this.a.get(size5);
                                        if (b0Var5.getItemId() == itemId2 && !b0Var5.wasReturnedFromScrap()) {
                                            if (itemViewType == b0Var5.getItemViewType()) {
                                                b0Var5.addFlags(32);
                                                if (b0Var5.isRemoved() && !RecyclerView.this.mState.g) {
                                                    b0Var5.setFlags(2, 14);
                                                }
                                                b0Var = b0Var5;
                                            } else if (!z) {
                                                this.a.remove(size5);
                                                RecyclerView.this.removeDetachedView(b0Var5.itemView, false);
                                                b0 childViewHolderInt2 = RecyclerView.getChildViewHolderInt(b0Var5.itemView);
                                                childViewHolderInt2.mScrapContainer = null;
                                                childViewHolderInt2.mInChangeScrap = false;
                                                childViewHolderInt2.clearReturnedFromScrapFlag();
                                                j(childViewHolderInt2);
                                            }
                                        }
                                        size5--;
                                    } else {
                                        int size6 = this.c.size() - 1;
                                        while (true) {
                                            if (size6 < 0) {
                                                break;
                                            }
                                            b0 b0Var6 = this.c.get(size6);
                                            if (b0Var6.getItemId() == itemId2 && !b0Var6.isAttachedToTransitionOverlay()) {
                                                if (itemViewType == b0Var6.getItemViewType()) {
                                                    if (!z) {
                                                        this.c.remove(size6);
                                                    }
                                                    b0Var = b0Var6;
                                                } else if (!z) {
                                                    h(size6);
                                                    break;
                                                }
                                            }
                                            size6--;
                                        }
                                        b0Var = null;
                                    }
                                }
                                if (b0Var != null) {
                                    b0Var.mPosition = f2;
                                    z2 = true;
                                }
                            }
                            if (b0Var == null) {
                                b0 b = d().b(itemViewType);
                                if (b != null) {
                                    b.resetInternal();
                                    if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST) {
                                        View view2 = b.itemView;
                                        if (view2 instanceof ViewGroup) {
                                            f((ViewGroup) view2, false);
                                        }
                                    }
                                }
                                b0Var = b;
                            }
                            if (b0Var == null) {
                                long nanoTime = RecyclerView.this.getNanoTime();
                                if (j != RecyclerView.FOREVER_NS) {
                                    long j3 = this.g.c(itemViewType).c;
                                    if (!(j3 == 0 || j3 + nanoTime < j)) {
                                        return null;
                                    }
                                }
                                RecyclerView recyclerView2 = RecyclerView.this;
                                b0 createViewHolder = recyclerView2.mAdapter.createViewHolder(recyclerView2, itemViewType);
                                if (RecyclerView.ALLOW_THREAD_GAP_WORK && (findNestedRecyclerView = RecyclerView.findNestedRecyclerView(createViewHolder.itemView)) != null) {
                                    createViewHolder.mNestedRecyclerView = new WeakReference<>(findNestedRecyclerView);
                                }
                                long nanoTime2 = RecyclerView.this.getNanoTime();
                                t tVar = this.g;
                                long j4 = nanoTime2 - nanoTime;
                                t.a c = tVar.c(itemViewType);
                                c.c = tVar.e(c.c, j4);
                                z3 = z2;
                                b0Var2 = createViewHolder;
                                if (z3 && !RecyclerView.this.mState.g && b0Var2.hasAnyOfTheFlags(8192)) {
                                    b0Var2.setFlags(0, 8192);
                                    if (RecyclerView.this.mState.j) {
                                        RecyclerView recyclerView3 = RecyclerView.this;
                                        RecyclerView.this.recordAnimationInfoIfBouncedHiddenView(b0Var2, recyclerView3.mItemAnimator.recordPreLayoutInformation(recyclerView3.mState, b0Var2, k.buildAdapterChangeFlagsForAnimations(b0Var2) | 4096, b0Var2.getUnmodifiedPayloads()));
                                    }
                                }
                                if (!RecyclerView.this.mState.g && b0Var2.isBound()) {
                                    b0Var2.mPreLayoutPosition = i;
                                } else if (b0Var2.isBound() || b0Var2.needsUpdate() || b0Var2.isInvalid()) {
                                    z4 = l(b0Var2, RecyclerView.this.mAdapterHelper.f(i, 0), i, j);
                                    layoutParams = b0Var2.itemView.getLayoutParams();
                                    if (layoutParams != null) {
                                        oVar = (o) RecyclerView.this.generateDefaultLayoutParams();
                                        b0Var2.itemView.setLayoutParams(oVar);
                                    } else if (!RecyclerView.this.checkLayoutParams(layoutParams)) {
                                        oVar = (o) RecyclerView.this.generateLayoutParams(layoutParams);
                                        b0Var2.itemView.setLayoutParams(oVar);
                                    } else {
                                        oVar = (o) layoutParams;
                                    }
                                    oVar.a = b0Var2;
                                    if (z3 || !z4) {
                                        z6 = false;
                                    }
                                    oVar.d = z6;
                                    return b0Var2;
                                }
                                z4 = false;
                                layoutParams = b0Var2.itemView.getLayoutParams();
                                if (layoutParams != null) {
                                }
                                oVar.a = b0Var2;
                                if (z3) {
                                }
                                z6 = false;
                                oVar.d = z6;
                                return b0Var2;
                            }
                        }
                        z3 = z2;
                        b0Var2 = b0Var;
                        if (z3) {
                            b0Var2.setFlags(0, 8192);
                            if (RecyclerView.this.mState.j) {
                            }
                        }
                        if (!RecyclerView.this.mState.g) {
                        }
                        if (b0Var2.isBound()) {
                        }
                        z4 = l(b0Var2, RecyclerView.this.mAdapterHelper.f(i, 0), i, j);
                        layoutParams = b0Var2.itemView.getLayoutParams();
                        if (layoutParams != null) {
                        }
                        oVar.a = b0Var2;
                        if (z3) {
                        }
                        z6 = false;
                        oVar.d = z6;
                        return b0Var2;
                    }
                }
                b0Var = null;
                if (b0Var != null) {
                }
            } else {
                b0Var = null;
            }
            z2 = false;
            if (b0Var == null) {
            }
            if (b0Var == null) {
            }
            z3 = z2;
            b0Var2 = b0Var;
            if (z3) {
            }
            if (!RecyclerView.this.mState.g) {
            }
            if (b0Var2.isBound()) {
            }
            z4 = l(b0Var2, RecyclerView.this.mAdapterHelper.f(i, 0), i, j);
            layoutParams = b0Var2.itemView.getLayoutParams();
            if (layoutParams != null) {
            }
            oVar.a = b0Var2;
            if (z3) {
            }
            z6 = false;
            oVar.d = z6;
            return b0Var2;
        }

        public void n(b0 b0Var) {
            if (b0Var.mInChangeScrap) {
                this.b.remove(b0Var);
            } else {
                this.a.remove(b0Var);
            }
            b0Var.mScrapContainer = null;
            b0Var.mInChangeScrap = false;
            b0Var.clearReturnedFromScrapFlag();
        }

        public void o() {
            n nVar = RecyclerView.this.mLayout;
            this.f = this.e + (nVar != null ? nVar.mPrefetchMaxCountObserved : 0);
            for (int size = this.c.size() - 1; size >= 0 && this.c.size() > this.f; size--) {
                h(size);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface v {
        void a(b0 b0Var);
    }

    /* loaded from: classes.dex */
    public class w extends h {
        public w() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public void a() {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mState.f = true;
            recyclerView.processDataSetCompletelyChanged(true);
            if (!RecyclerView.this.mAdapterHelper.g()) {
                RecyclerView.this.requestLayout();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public void c(int i, int i2, Object obj) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            h0.v.a.a aVar = RecyclerView.this.mAdapterHelper;
            Objects.requireNonNull(aVar);
            boolean z = false;
            if (i2 >= 1) {
                aVar.b.add(aVar.h(4, i, i2, obj));
                aVar.f |= 4;
                if (aVar.b.size() == 1) {
                    z = true;
                }
            }
            if (z) {
                h();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public void d(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            h0.v.a.a aVar = RecyclerView.this.mAdapterHelper;
            Objects.requireNonNull(aVar);
            boolean z = false;
            if (i2 >= 1) {
                aVar.b.add(aVar.h(1, i, i2, null));
                aVar.f |= 1;
                if (aVar.b.size() == 1) {
                    z = true;
                }
            }
            if (z) {
                h();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public void e(int i, int i2, int i3) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            h0.v.a.a aVar = RecyclerView.this.mAdapterHelper;
            Objects.requireNonNull(aVar);
            boolean z = false;
            if (i != i2) {
                if (i3 == 1) {
                    aVar.b.add(aVar.h(8, i, i2, null));
                    aVar.f |= 8;
                    if (aVar.b.size() == 1) {
                        z = true;
                    }
                } else {
                    throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
                }
            }
            if (z) {
                h();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public void f(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            h0.v.a.a aVar = RecyclerView.this.mAdapterHelper;
            Objects.requireNonNull(aVar);
            boolean z = false;
            if (i2 >= 1) {
                aVar.b.add(aVar.h(2, i, i2, null));
                aVar.f |= 2;
                if (aVar.b.size() == 1) {
                    z = true;
                }
            }
            if (z) {
                h();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.h
        public void g() {
            Adapter adapter;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mPendingSavedState != null && (adapter = recyclerView.mAdapter) != null && adapter.canRestoreState()) {
                RecyclerView.this.requestLayout();
            }
        }

        public void h() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mHasFixedSize && recyclerView.mIsAttached) {
                    Runnable runnable = recyclerView.mUpdateChildViewsRunnable;
                    AtomicInteger atomicInteger = h0.i.i.q.a;
                    recyclerView.postOnAnimation(runnable);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.mAdapterUpdateDuringMeasure = true;
            recyclerView2.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class x {
        public RecyclerView b;
        public n c;
        public boolean d;
        public boolean e;
        public View f;
        public boolean h;
        public int a = -1;
        public final a g = new a(0, 0);

        /* loaded from: classes.dex */
        public static class a {
            public int a;
            public int b;
            public int d = -1;
            public boolean f = false;
            public int g = 0;
            public int c = Integer.MIN_VALUE;
            public Interpolator e = null;

            public a(int i, int i2) {
                this.a = i;
                this.b = i2;
            }

            public void a(RecyclerView recyclerView) {
                int i = this.d;
                if (i >= 0) {
                    this.d = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i);
                    this.f = false;
                } else if (this.f) {
                    Interpolator interpolator = this.e;
                    if (interpolator == null || this.c >= 1) {
                        int i2 = this.c;
                        if (i2 >= 1) {
                            recyclerView.mViewFlinger.b(this.a, this.b, i2, interpolator);
                            int i3 = this.g + 1;
                            this.g = i3;
                            if (i3 > 10) {
                                Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                            }
                            this.f = false;
                            return;
                        }
                        throw new IllegalStateException("Scroll duration must be a positive number");
                    }
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else {
                    this.g = 0;
                }
            }

            public void b(int i, int i2, int i3, Interpolator interpolator) {
                this.a = i;
                this.b = i2;
                this.c = i3;
                this.e = interpolator;
                this.f = true;
            }
        }

        /* loaded from: classes.dex */
        public interface b {
            PointF computeScrollVectorForPosition(int i);
        }

        public PointF a(int i) {
            n nVar = this.c;
            if (nVar instanceof b) {
                return ((b) nVar).computeScrollVectorForPosition(i);
            }
            StringBuilder P0 = i0.d.a.a.a.P0("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
            P0.append(b.class.getCanonicalName());
            Log.w(RecyclerView.TAG, P0.toString());
            return null;
        }

        public void b(int i, int i2) {
            PointF a2;
            RecyclerView recyclerView = this.b;
            if (this.a == -1 || recyclerView == null) {
                d();
            }
            if (this.d && this.f == null && this.c != null && (a2 = a(this.a)) != null) {
                float f = a2.x;
                if (!(f == 0.0f && a2.y == 0.0f)) {
                    recyclerView.scrollStep((int) Math.signum(f), (int) Math.signum(a2.y), null);
                }
            }
            boolean z = false;
            this.d = false;
            View view = this.f;
            if (view != null) {
                if (this.b.getChildLayoutPosition(view) == this.a) {
                    c(this.f, recyclerView.mState, this.g);
                    this.g.a(recyclerView);
                    d();
                } else {
                    Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.f = null;
                }
            }
            if (this.e) {
                y yVar = recyclerView.mState;
                a aVar = this.g;
                h0.v.a.p pVar = (h0.v.a.p) this;
                if (pVar.b.mLayout.getChildCount() == 0) {
                    pVar.d();
                } else {
                    int i3 = pVar.o;
                    int i4 = i3 - i;
                    if (i3 * i4 <= 0) {
                        i4 = 0;
                    }
                    pVar.o = i4;
                    int i5 = pVar.p;
                    int i6 = i5 - i2;
                    if (i5 * i6 <= 0) {
                        i6 = 0;
                    }
                    pVar.p = i6;
                    if (i4 == 0 && i6 == 0) {
                        PointF a3 = pVar.a(pVar.a);
                        if (a3 != null) {
                            float f2 = a3.x;
                            if (!(f2 == 0.0f && a3.y == 0.0f)) {
                                float f3 = a3.y;
                                float sqrt = (float) Math.sqrt((double) ((f3 * f3) + (f2 * f2)));
                                float f4 = a3.x / sqrt;
                                a3.x = f4;
                                float f5 = a3.y / sqrt;
                                a3.y = f5;
                                pVar.k = a3;
                                pVar.o = (int) (f4 * 10000.0f);
                                pVar.p = (int) (f5 * 10000.0f);
                                aVar.b((int) (((float) pVar.o) * 1.2f), (int) (((float) pVar.p) * 1.2f), (int) (((float) pVar.h(InstabugBaseConnectionManagerImpl.DEFAULT_READ_TIME_OUT)) * 1.2f), pVar.i);
                            }
                        }
                        aVar.d = pVar.a;
                        pVar.d();
                    }
                }
                a aVar2 = this.g;
                if (aVar2.d >= 0) {
                    z = true;
                }
                aVar2.a(recyclerView);
                if (z && this.e) {
                    this.d = true;
                    recyclerView.mViewFlinger.a();
                }
            }
        }

        public abstract void c(View view, y yVar, a aVar);

        public final void d() {
            if (this.e) {
                this.e = false;
                h0.v.a.p pVar = (h0.v.a.p) this;
                pVar.p = 0;
                pVar.o = 0;
                pVar.k = null;
                this.b.mState.a = -1;
                this.f = null;
                this.a = -1;
                this.d = false;
                this.c.onSmoothScrollerStopped(this);
                this.c = null;
                this.b = null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class y {
        public int a = -1;
        public int b = 0;
        public int c = 0;
        public int d = 1;
        public int e = 0;
        public boolean f = false;
        public boolean g = false;
        public boolean h = false;
        public boolean i = false;
        public boolean j = false;
        public boolean k = false;
        public int l;
        public long m;
        public int n;

        public void a(int i) {
            if ((this.d & i) == 0) {
                StringBuilder P0 = i0.d.a.a.a.P0("Layout state should be one of ");
                P0.append(Integer.toBinaryString(i));
                P0.append(" but it is ");
                P0.append(Integer.toBinaryString(this.d));
                throw new IllegalStateException(P0.toString());
            }
        }

        public int b() {
            if (this.g) {
                return this.b - this.c;
            }
            return this.e;
        }

        public String toString() {
            StringBuilder P0 = i0.d.a.a.a.P0("State{mTargetPosition=");
            P0.append(this.a);
            P0.append(", mData=");
            P0.append((Object) null);
            P0.append(", mItemCount=");
            P0.append(this.e);
            P0.append(", mIsMeasuring=");
            P0.append(this.i);
            P0.append(", mPreviousLayoutItemCount=");
            P0.append(this.b);
            P0.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
            P0.append(this.c);
            P0.append(", mStructureChanged=");
            P0.append(this.f);
            P0.append(", mInPreLayout=");
            P0.append(this.g);
            P0.append(", mRunSimpleAnimations=");
            P0.append(this.j);
            P0.append(", mRunPredictiveAnimations=");
            return i0.d.a.a.a.C0(P0, this.k, '}');
        }
    }

    /* loaded from: classes.dex */
    public static abstract class z {
    }

    static {
        Class<?> cls = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, cls, cls};
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    private void addAnimatingView(b0 b0Var) {
        View view = b0Var.itemView;
        boolean z2 = view.getParent() == this;
        this.mRecycler.n(getChildViewHolder(view));
        if (b0Var.isTmpDetached()) {
            this.mChildHelper.b(view, -1, view.getLayoutParams(), true);
        } else if (!z2) {
            this.mChildHelper.a(view, -1, true);
        } else {
            h0.v.a.e eVar = this.mChildHelper;
            int indexOfChild = RecyclerView.this.indexOfChild(view);
            if (indexOfChild >= 0) {
                eVar.b.h(indexOfChild);
                eVar.i(view);
                return;
            }
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    private void animateChange(b0 b0Var, b0 b0Var2, k.c cVar, k.c cVar2, boolean z2, boolean z3) {
        b0Var.setIsRecyclable(false);
        if (z2) {
            addAnimatingView(b0Var);
        }
        if (b0Var != b0Var2) {
            if (z3) {
                addAnimatingView(b0Var2);
            }
            b0Var.mShadowedHolder = b0Var2;
            addAnimatingView(b0Var);
            this.mRecycler.n(b0Var);
            b0Var2.setIsRecyclable(false);
            b0Var2.mShadowingHolder = b0Var;
        }
        if (this.mItemAnimator.animateChange(b0Var, b0Var2, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    public static void clearNestedRecyclerViewIfNotNested(b0 b0Var) {
        WeakReference<RecyclerView> weakReference = b0Var.mNestedRecyclerView;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView != b0Var.itemView) {
                    ViewParent parent = recyclerView.getParent();
                    recyclerView = parent instanceof View ? (View) parent : null;
                } else {
                    return;
                }
            }
            b0Var.mNestedRecyclerView = null;
        }
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i2, int i3) {
        ClassLoader classLoader;
        Constructor constructor;
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String fullClassName = getFullClassName(context, trim);
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = Class.forName(fullClassName, false, classLoader).asSubclass(n.class);
                    Object[] objArr = null;
                    try {
                        constructor = asSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
                    } catch (NoSuchMethodException e2) {
                        try {
                            constructor = asSubclass.getConstructor(new Class[0]);
                        } catch (NoSuchMethodException e3) {
                            e3.initCause(e2);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e3);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((n) constructor.newInstance(objArr));
                } catch (ClassCastException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e4);
                } catch (ClassNotFoundException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e5);
                } catch (IllegalAccessException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e6);
                } catch (InstantiationException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e7);
                } catch (InvocationTargetException e8) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e8);
                }
            }
        }
    }

    private boolean didChildRangeChange(int i2, int i3) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    private void dispatchContentChangedIfNecessary() {
        int i2 = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i2 != 0 && isAccessibilityEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            obtain.setContentChangeTypes(i2);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    private void dispatchLayoutStep1() {
        this.mState.a(1);
        fillRemainingScrollValues(this.mState);
        this.mState.i = false;
        startInterceptRequestLayout();
        c0 c0Var = this.mViewInfoStore;
        c0Var.a.clear();
        c0Var.b.c();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        y yVar = this.mState;
        yVar.h = yVar.j && this.mItemsChanged;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        yVar.g = yVar.k;
        yVar.e = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.j) {
            int e2 = this.mChildHelper.e();
            for (int i2 = 0; i2 < e2; i2++) {
                b0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i2));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    this.mViewInfoStore.c(childViewHolderInt, this.mItemAnimator.recordPreLayoutInformation(this.mState, childViewHolderInt, k.buildAdapterChangeFlagsForAnimations(childViewHolderInt), childViewHolderInt.getUnmodifiedPayloads()));
                    if (this.mState.h && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.b.o(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.k) {
            saveOldPositions();
            y yVar2 = this.mState;
            boolean z2 = yVar2.f;
            yVar2.f = false;
            this.mLayout.onLayoutChildren(this.mRecycler, yVar2);
            this.mState.f = z2;
            for (int i3 = 0; i3 < this.mChildHelper.e(); i3++) {
                b0 childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.d(i3));
                if (!childViewHolderInt2.shouldIgnore()) {
                    c0.a orDefault = this.mViewInfoStore.a.getOrDefault(childViewHolderInt2, null);
                    if (!((orDefault == null || (orDefault.b & 4) == 0) ? false : true)) {
                        int buildAdapterChangeFlagsForAnimations = k.buildAdapterChangeFlagsForAnimations(childViewHolderInt2);
                        boolean hasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(8192);
                        if (!hasAnyOfTheFlags) {
                            buildAdapterChangeFlagsForAnimations |= 4096;
                        }
                        k.c recordPreLayoutInformation = this.mItemAnimator.recordPreLayoutInformation(this.mState, childViewHolderInt2, buildAdapterChangeFlagsForAnimations, childViewHolderInt2.getUnmodifiedPayloads());
                        if (hasAnyOfTheFlags) {
                            recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, recordPreLayoutInformation);
                        } else {
                            c0 c0Var2 = this.mViewInfoStore;
                            c0.a orDefault2 = c0Var2.a.getOrDefault(childViewHolderInt2, null);
                            if (orDefault2 == null) {
                                orDefault2 = c0.a.a();
                                c0Var2.a.put(childViewHolderInt2, orDefault2);
                            }
                            orDefault2.b |= 2;
                            orDefault2.c = recordPreLayoutInformation;
                        }
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.d = 2;
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.a(6);
        this.mAdapterHelper.c();
        this.mState.e = this.mAdapter.getItemCount();
        this.mState.c = 0;
        if (this.mPendingSavedState != null && this.mAdapter.canRestoreState()) {
            Parcelable parcelable = this.mPendingSavedState.q;
            if (parcelable != null) {
                this.mLayout.onRestoreInstanceState(parcelable);
            }
            this.mPendingSavedState = null;
        }
        y yVar = this.mState;
        yVar.g = false;
        this.mLayout.onLayoutChildren(this.mRecycler, yVar);
        y yVar2 = this.mState;
        yVar2.f = false;
        yVar2.j = yVar2.j && this.mItemAnimator != null;
        yVar2.d = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        this.mState.a(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        y yVar = this.mState;
        yVar.d = 1;
        if (yVar.j) {
            for (int e2 = this.mChildHelper.e() - 1; e2 >= 0; e2--) {
                b0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(e2));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    k.c recordPostLayoutInformation = this.mItemAnimator.recordPostLayoutInformation(this.mState, childViewHolderInt);
                    b0 j2 = this.mViewInfoStore.b.j(changedHolderKey, null);
                    if (j2 == null || j2.shouldIgnore()) {
                        this.mViewInfoStore.b(childViewHolderInt, recordPostLayoutInformation);
                    } else {
                        boolean d2 = this.mViewInfoStore.d(j2);
                        boolean d3 = this.mViewInfoStore.d(childViewHolderInt);
                        if (!d2 || j2 != childViewHolderInt) {
                            k.c e3 = this.mViewInfoStore.e(j2, 4);
                            this.mViewInfoStore.b(childViewHolderInt, recordPostLayoutInformation);
                            k.c e4 = this.mViewInfoStore.e(childViewHolderInt, 8);
                            if (e3 == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, j2);
                            } else {
                                animateChange(j2, childViewHolderInt, e3, e4, d2, d3);
                            }
                        } else {
                            this.mViewInfoStore.b(childViewHolderInt, recordPostLayoutInformation);
                        }
                    }
                }
            }
            c0 c0Var = this.mViewInfoStore;
            c0.b bVar = this.mViewInfoProcessCallback;
            int i2 = c0Var.a.Z1;
            while (true) {
                i2--;
                if (i2 < 0) {
                    break;
                }
                b0 i3 = c0Var.a.i(i2);
                c0.a j3 = c0Var.a.j(i2);
                int i4 = j3.b;
                if ((i4 & 3) == 3) {
                    RecyclerView recyclerView = RecyclerView.this;
                    recyclerView.mLayout.removeAndRecycleView(i3.itemView, recyclerView.mRecycler);
                } else if ((i4 & 1) != 0) {
                    k.c cVar = j3.c;
                    if (cVar == null) {
                        RecyclerView recyclerView2 = RecyclerView.this;
                        recyclerView2.mLayout.removeAndRecycleView(i3.itemView, recyclerView2.mRecycler);
                    } else {
                        k.c cVar2 = j3.d;
                        d dVar = (d) bVar;
                        RecyclerView.this.mRecycler.n(i3);
                        RecyclerView.this.animateDisappearance(i3, cVar, cVar2);
                    }
                } else if ((i4 & 14) == 14) {
                    RecyclerView.this.animateAppearance(i3, j3.c, j3.d);
                } else if ((i4 & 12) == 12) {
                    k.c cVar3 = j3.c;
                    k.c cVar4 = j3.d;
                    d dVar2 = (d) bVar;
                    Objects.requireNonNull(dVar2);
                    i3.setIsRecyclable(false);
                    RecyclerView recyclerView3 = RecyclerView.this;
                    if (recyclerView3.mDataSetHasChangedAfterLayout) {
                        if (recyclerView3.mItemAnimator.animateChange(i3, i3, cVar3, cVar4)) {
                            RecyclerView.this.postAnimationRunner();
                        }
                    } else if (recyclerView3.mItemAnimator.animatePersistence(i3, cVar3, cVar4)) {
                        RecyclerView.this.postAnimationRunner();
                    }
                } else if ((i4 & 4) != 0) {
                    k.c cVar5 = j3.c;
                    d dVar3 = (d) bVar;
                    RecyclerView.this.mRecycler.n(i3);
                    RecyclerView.this.animateDisappearance(i3, cVar5, null);
                } else if ((i4 & 8) != 0) {
                    RecyclerView.this.animateAppearance(i3, j3.c, j3.d);
                }
                c0.a.b(j3);
            }
        }
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        y yVar2 = this.mState;
        yVar2.b = yVar2.e;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        yVar2.j = false;
        yVar2.k = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        ArrayList<b0> arrayList = this.mRecycler.b;
        if (arrayList != null) {
            arrayList.clear();
        }
        n nVar = this.mLayout;
        if (nVar.mPrefetchMaxObservedInInitialPrefetch) {
            nVar.mPrefetchMaxCountObserved = 0;
            nVar.mPrefetchMaxObservedInInitialPrefetch = false;
            this.mRecycler.o();
        }
        this.mLayout.onLayoutCompleted(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        c0 c0Var2 = this.mViewInfoStore;
        c0Var2.a.clear();
        c0Var2.b.c();
        int[] iArr = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(iArr[0], iArr[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        r rVar = this.mInterceptingOnItemTouchListener;
        if (rVar != null) {
            rVar.a(this, motionEvent);
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.mInterceptingOnItemTouchListener = null;
            }
            return true;
        } else if (motionEvent.getAction() == 0) {
            return false;
        } else {
            return findInterceptingOnItemTouchListener(motionEvent);
        }
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            r rVar = this.mOnItemTouchListeners.get(i2);
            if (rVar.c(this, motionEvent) && action != 3) {
                this.mInterceptingOnItemTouchListener = rVar;
                return true;
            }
        }
        return false;
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int e2 = this.mChildHelper.e();
        if (e2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < e2; i4++) {
            b0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i4));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i2) {
                    i2 = layoutPosition;
                }
                if (layoutPosition > i3) {
                    i3 = layoutPosition;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    public static RecyclerView findNestedRecyclerView(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView findNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i2));
            if (findNestedRecyclerView != null) {
                return findNestedRecyclerView;
            }
        }
        return null;
    }

    private View findNextViewToFocus() {
        b0 findViewHolderForAdapterPosition;
        y yVar = this.mState;
        int i2 = yVar.l;
        if (i2 == -1) {
            i2 = 0;
        }
        int b2 = yVar.b();
        for (int i3 = i2; i3 < b2; i3++) {
            b0 findViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i3);
            if (findViewHolderForAdapterPosition2 == null) {
                break;
            } else if (findViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition2.itemView;
            }
        }
        int min = Math.min(b2, i2);
        while (true) {
            min--;
            if (min < 0 || (findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(min)) == null) {
                return null;
            }
            if (findViewHolderForAdapterPosition.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition.itemView;
            }
        }
    }

    public static b0 getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((o) view.getLayoutParams()).a;
    }

    public static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        o oVar = (o) view.getLayoutParams();
        Rect rect2 = oVar.b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) oVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) oVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) oVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) oVar).bottomMargin);
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(".")) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + '.' + str;
        }
    }

    private h0.i.i.i getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new h0.i.i.i(this);
        }
        return this.mScrollingChildHelper;
    }

    private void handleMissingPreInfoForChangeError(long j2, b0 b0Var, b0 b0Var2) {
        int e2 = this.mChildHelper.e();
        for (int i2 = 0; i2 < e2; i2++) {
            b0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i2));
            if (childViewHolderInt != b0Var && getChangedHolderKey(childViewHolderInt) == j2) {
                Adapter adapter = this.mAdapter;
                if (adapter == null || !adapter.hasStableIds()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
                    sb.append(childViewHolderInt);
                    sb.append(" \n View Holder 2:");
                    sb.append(b0Var);
                    throw new IllegalStateException(i0.d.a.a.a.S(this, sb));
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
                sb2.append(childViewHolderInt);
                sb2.append(" \n View Holder 2:");
                sb2.append(b0Var);
                throw new IllegalStateException(i0.d.a.a.a.S(this, sb2));
            }
        }
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + b0Var2 + " cannot be found but it is necessary for " + b0Var + exceptionLabel());
    }

    private boolean hasUpdatedView() {
        int e2 = this.mChildHelper.e();
        for (int i2 = 0; i2 < e2; i2++) {
            b0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.d(i2));
            if (!(childViewHolderInt == null || childViewHolderInt.shouldIgnore() || !childViewHolderInt.isUpdated())) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void initAutofill() {
        AtomicInteger atomicInteger = h0.i.i.q.a;
        int i2 = Build.VERSION.SDK_INT;
        if ((i2 >= 26 ? getImportantForAutofill() : 0) == 0 && i2 >= 26) {
            setImportantForAutofill(8);
        }
    }

    private void initChildrenHelper() {
        this.mChildHelper = new h0.v.a.e(new e());
    }

    private boolean isPreferredNextFocus(View view, View view2, int i2) {
        int i3;
        if (view2 == null || view2 == this || view2 == view || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        char c2 = 65535;
        int i4 = this.mLayout.getLayoutDirection() == 1 ? -1 : 1;
        Rect rect = this.mTempRect;
        int i5 = rect.left;
        Rect rect2 = this.mTempRect2;
        int i6 = rect2.left;
        if ((i5 < i6 || rect.right <= i6) && rect.right < rect2.right) {
            i3 = 1;
        } else {
            int i7 = rect.right;
            int i8 = rect2.right;
            i3 = ((i7 > i8 || i5 >= i8) && i5 > i6) ? -1 : 0;
        }
        int i9 = rect.top;
        int i10 = rect2.top;
        if ((i9 < i10 || rect.bottom <= i10) && rect.bottom < rect2.bottom) {
            c2 = 1;
        } else {
            int i11 = rect.bottom;
            int i12 = rect2.bottom;
            if ((i11 <= i12 && i9 < i12) || i9 <= i10) {
                c2 = 0;
            }
        }
        if (i2 == 1) {
            return c2 < 0 || (c2 == 0 && i3 * i4 < 0);
        }
        if (i2 == 2) {
            return c2 > 0 || (c2 == 0 && i3 * i4 > 0);
        }
        if (i2 == 17) {
            return i3 < 0;
        }
        if (i2 == 33) {
            return c2 < 0;
        }
        if (i2 == 66) {
            return i3 > 0;
        }
        if (i2 == 130) {
            return c2 > 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid direction: ");
        sb.append(i2);
        throw new IllegalArgumentException(i0.d.a.a.a.S(this, sb));
    }

    private void nestedScrollByInternal(int i2, int i3, MotionEvent motionEvent, int i4) {
        n nVar = this.mLayout;
        if (nVar == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutSuppressed) {
            int[] iArr = this.mReusableIntPair;
            int i5 = 0;
            iArr[0] = 0;
            iArr[1] = 0;
            boolean canScrollHorizontally = nVar.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            int i6 = canScrollHorizontally ? 1 : 0;
            if (canScrollVertically) {
                i6 |= 2;
            }
            startNestedScroll(i6, i4);
            if (dispatchNestedPreScroll(canScrollHorizontally ? i2 : 0, canScrollVertically ? i3 : 0, this.mReusableIntPair, this.mScrollOffset, i4)) {
                int[] iArr2 = this.mReusableIntPair;
                i2 -= iArr2[0];
                i3 -= iArr2[1];
            }
            int i7 = canScrollHorizontally ? i2 : 0;
            if (canScrollVertically) {
                i5 = i3;
            }
            scrollByInternal(i7, i5, motionEvent, i4);
            h0.v.a.j jVar = this.mGapWorker;
            if (!(jVar == null || (i2 == 0 && i3 == 0))) {
                jVar.a(this, i2, i3);
            }
            stopNestedScroll(i4);
        }
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.mLastTouchX = x2;
            this.mInitialTouchX = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.mLastTouchY = y2;
            this.mInitialTouchY = y2;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        boolean z2;
        boolean z3 = false;
        if (this.mDataSetHasChangedAfterLayout) {
            h0.v.a.a aVar = this.mAdapterHelper;
            aVar.l(aVar.b);
            aVar.l(aVar.c);
            aVar.f = 0;
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.j();
        } else {
            this.mAdapterHelper.c();
        }
        boolean z4 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        this.mState.j = this.mFirstLayoutComplete && this.mItemAnimator != null && ((z2 = this.mDataSetHasChangedAfterLayout) || z4 || this.mLayout.mRequestedSimpleAnimations) && (!z2 || this.mAdapter.hasStableIds());
        y yVar = this.mState;
        if (yVar.j && z4 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled()) {
            z3 = true;
        }
        yVar.k = z3;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    private void pullGlows(float f2, float f3, float f4, float f5) {
        boolean z2;
        boolean z3 = true;
        if (f3 < 0.0f) {
            ensureLeftGlow();
            this.mLeftGlow.onPull((-f3) / ((float) getWidth()), 1.0f - (f4 / ((float) getHeight())));
        } else if (f3 > 0.0f) {
            ensureRightGlow();
            this.mRightGlow.onPull(f3 / ((float) getWidth()), f4 / ((float) getHeight()));
        } else {
            z2 = false;
            if (f5 >= 0.0f) {
                ensureTopGlow();
                this.mTopGlow.onPull((-f5) / ((float) getHeight()), f2 / ((float) getWidth()));
            } else if (f5 > 0.0f) {
                ensureBottomGlow();
                this.mBottomGlow.onPull(f5 / ((float) getHeight()), 1.0f - (f2 / ((float) getWidth())));
            } else {
                z3 = z2;
            }
            if (!z3 || f3 != 0.0f || f5 != 0.0f) {
                AtomicInteger atomicInteger = h0.i.i.q.a;
                postInvalidateOnAnimation();
            }
            return;
        }
        z2 = true;
        if (f5 >= 0.0f) {
        }
        if (!z3) {
        }
        AtomicInteger atomicInteger2 = h0.i.i.q.a;
        postInvalidateOnAnimation();
    }

    private void recoverFocusFromState() {
        View findViewById;
        if (this.mPreserveFocusAfterLayout && this.mAdapter != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                if (!isFocused()) {
                    View focusedChild = getFocusedChild();
                    if (!IGNORE_DETACHED_FOCUSED_CHILD || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                        if (!this.mChildHelper.k(focusedChild)) {
                            return;
                        }
                    } else if (this.mChildHelper.e() == 0) {
                        requestFocus();
                        return;
                    }
                }
                View view = null;
                b0 findViewHolderForItemId = (this.mState.m == -1 || !this.mAdapter.hasStableIds()) ? null : findViewHolderForItemId(this.mState.m);
                if (findViewHolderForItemId != null && !this.mChildHelper.k(findViewHolderForItemId.itemView) && findViewHolderForItemId.itemView.hasFocusable()) {
                    view = findViewHolderForItemId.itemView;
                } else if (this.mChildHelper.e() > 0) {
                    view = findNextViewToFocus();
                }
                if (view != null) {
                    int i2 = this.mState.n;
                    if (!(((long) i2) == -1 || (findViewById = view.findViewById(i2)) == null || !findViewById.isFocusable())) {
                        view = findViewById;
                    }
                    view.requestFocus();
                }
            }
        }
    }

    private void releaseGlows() {
        boolean z2;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z2 = this.mLeftGlow.isFinished();
        } else {
            z2 = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z2 |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z2 |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z2 |= this.mBottomGlow.isFinished();
        }
        if (z2) {
            AtomicInteger atomicInteger = h0.i.i.q.a;
            postInvalidateOnAnimation();
        }
    }

    private void requestChildOnScreen(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof o) {
            o oVar = (o) layoutParams;
            if (!oVar.c) {
                Rect rect = oVar.b;
                Rect rect2 = this.mTempRect;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        n nVar = this.mLayout;
        Rect rect3 = this.mTempRect;
        boolean z2 = true;
        boolean z3 = !this.mFirstLayoutComplete;
        if (view2 != null) {
            z2 = false;
        }
        nVar.requestChildRectangleOnScreen(this, view, rect3, z3, z2);
    }

    private void resetFocusInfo() {
        y yVar = this.mState;
        yVar.m = -1;
        yVar.l = -1;
        yVar.n = -1;
    }

    private void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void saveFocusInfo() {
        int i2;
        b0 b0Var = null;
        View focusedChild = (!this.mPreserveFocusAfterLayout || !hasFocus() || this.mAdapter == null) ? null : getFocusedChild();
        if (focusedChild != null) {
            b0Var = findContainingViewHolder(focusedChild);
        }
        if (b0Var == null) {
            resetFocusInfo();
            return;
        }
        this.mState.m = this.mAdapter.hasStableIds() ? b0Var.getItemId() : -1;
        y yVar = this.mState;
        if (this.mDataSetHasChangedAfterLayout) {
            i2 = -1;
        } else if (b0Var.isRemoved()) {
            i2 = b0Var.mOldPosition;
        } else {
            i2 = b0Var.getAbsoluteAdapterPosition();
        }
        yVar.l = i2;
        this.mState.n = getDeepestFocusedViewWithId(b0Var.itemView);
    }

    private void setAdapterInternal(Adapter adapter, boolean z2, boolean z3) {
        Adapter adapter2 = this.mAdapter;
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z2 || z3) {
            removeAndRecycleViews();
        }
        h0.v.a.a aVar = this.mAdapterHelper;
        aVar.l(aVar.b);
        aVar.l(aVar.c);
        aVar.f = 0;
        Adapter adapter3 = this.mAdapter;
        this.mAdapter = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.mObserver);
            adapter.onAttachedToRecyclerView(this);
        }
        n nVar = this.mLayout;
        if (nVar != null) {
            nVar.onAdapterChanged(adapter3, this.mAdapter);
        }
        u uVar = this.mRecycler;
        Adapter adapter4 = this.mAdapter;
        uVar.b();
        t d2 = uVar.d();
        Objects.requireNonNull(d2);
        if (adapter3 != null) {
            d2.b--;
        }
        if (!z2 && d2.b == 0) {
            d2.a();
        }
        if (adapter4 != null) {
            d2.b++;
        }
        this.mState.f = true;
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.c();
        n nVar = this.mLayout;
        if (nVar != null) {
            nVar.stopSmoothScroller();
        }
    }

    public void absorbGlows(int i2, int i3) {
        if (i2 < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i2);
            }
        }
        if (i3 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i3);
            }
        } else if (i3 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i3);
            }
        }
        if (i2 != 0 || i3 != 0) {
            AtomicInteger atomicInteger = h0.i.i.q.a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        n nVar = this.mLayout;
        if (nVar == null || !nVar.onAddFocusables(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    public void addItemDecoration(m mVar, int i2) {
        n nVar = this.mLayout;
        if (nVar != null) {
            nVar.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.mItemDecorations.add(mVar);
        } else {
            this.mItemDecorations.add(i2, mVar);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(p pVar) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(pVar);
    }

    public void addOnItemTouchListener(r rVar) {
        this.mOnItemTouchListeners.add(rVar);
    }

    public void addOnScrollListener(s sVar) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(sVar);
    }

    public void addRecyclerListener(v vVar) {
        g0.a.b.b.a.j(vVar != null, "'listener' arg cannot be null.");
        this.mRecyclerListeners.add(vVar);
    }

    public void animateAppearance(b0 b0Var, k.c cVar, k.c cVar2) {
        b0Var.setIsRecyclable(false);
        if (this.mItemAnimator.animateAppearance(b0Var, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    public void animateDisappearance(b0 b0Var, k.c cVar, k.c cVar2) {
        addAnimatingView(b0Var);
        b0Var.setIsRecyclable(false);
        if (this.mItemAnimator.animateDisappearance(b0Var, cVar, cVar2)) {
            postAnimationRunner();
        }
    }

    public void assertInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException(i0.d.a.a.a.S(this, i0.d.a.a.a.P0("Cannot call this method unless RecyclerView is computing a layout or scrolling")));
        }
        throw new IllegalStateException(i0.d.a.a.a.S(this, i0.d.a.a.a.P0(str)));
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException(i0.d.a.a.a.S(this, i0.d.a.a.a.P0("Cannot call this method while RecyclerView is computing a layout or scrolling")));
            }
            throw new IllegalStateException(str);
        } else if (this.mDispatchScrollCounter > 0) {
            Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(i0.d.a.a.a.S(this, i0.d.a.a.a.P0(""))));
        }
    }

    public boolean canReuseUpdatedViewHolder(b0 b0Var) {
        k kVar = this.mItemAnimator;
        return kVar == null || kVar.canReuseUpdatedViewHolder(b0Var, b0Var.getUnmodifiedPayloads());
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof o) && this.mLayout.checkLayoutParams((o) layoutParams);
    }

    public void clearOldPositions() {
        int h2 = this.mChildHelper.h();
        for (int i2 = 0; i2 < h2; i2++) {
            b0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i2));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        u uVar = this.mRecycler;
        int size = uVar.c.size();
        for (int i3 = 0; i3 < size; i3++) {
            uVar.c.get(i3).clearOldPosition();
        }
        int size2 = uVar.a.size();
        for (int i4 = 0; i4 < size2; i4++) {
            uVar.a.get(i4).clearOldPosition();
        }
        ArrayList<b0> arrayList = uVar.b;
        if (arrayList != null) {
            int size3 = arrayList.size();
            for (int i5 = 0; i5 < size3; i5++) {
                uVar.b.get(i5).clearOldPosition();
            }
        }
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<p> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List<s> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        n nVar = this.mLayout;
        if (nVar != null && nVar.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        n nVar = this.mLayout;
        if (nVar != null && nVar.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        n nVar = this.mLayout;
        if (nVar != null && nVar.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollRange(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        n nVar = this.mLayout;
        if (nVar != null && nVar.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        n nVar = this.mLayout;
        if (nVar != null && nVar.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        n nVar = this.mLayout;
        if (nVar != null && nVar.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollRange(this.mState);
        }
        return 0;
    }

    public void considerReleasingGlowsOnScroll(int i2, int i3) {
        boolean z2;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            z2 = false;
        } else {
            this.mLeftGlow.onRelease();
            z2 = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.mRightGlow.onRelease();
            z2 |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.mTopGlow.onRelease();
            z2 |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.mBottomGlow.onRelease();
            z2 |= this.mBottomGlow.isFinished();
        }
        if (z2) {
            AtomicInteger atomicInteger = h0.i.i.q.a;
            postInvalidateOnAnimation();
        }
    }

    public void consumePendingUpdateOperations() {
        if (!this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout) {
            int i2 = h0.i.e.f.a;
            Trace.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
            dispatchLayout();
            Trace.endSection();
        } else if (this.mAdapterHelper.g()) {
            h0.v.a.a aVar = this.mAdapterHelper;
            int i3 = aVar.f;
            boolean z2 = false;
            if ((i3 & 4) != 0) {
                if ((i3 & 11) != 0) {
                    z2 = true;
                }
                if (!z2) {
                    int i4 = h0.i.e.f.a;
                    Trace.beginSection(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
                    startInterceptRequestLayout();
                    onEnterLayoutOrScroll();
                    this.mAdapterHelper.j();
                    if (!this.mLayoutWasDefered) {
                        if (hasUpdatedView()) {
                            dispatchLayout();
                        } else {
                            this.mAdapterHelper.b();
                        }
                    }
                    stopInterceptRequestLayout(true);
                    onExitLayoutOrScroll();
                    Trace.endSection();
                    return;
                }
            }
            if (aVar.g()) {
                int i5 = h0.i.e.f.a;
                Trace.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                dispatchLayout();
                Trace.endSection();
            }
        }
    }

    public void defaultOnMeasure(int i2, int i3) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        AtomicInteger atomicInteger = h0.i.i.q.a;
        setMeasuredDimension(n.chooseSize(i2, paddingRight, getMinimumWidth()), n.chooseSize(i3, getPaddingBottom() + getPaddingTop(), getMinimumHeight()));
    }

    public void dispatchChildAttached(View view) {
        b0 childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        Adapter adapter = this.mAdapter;
        if (!(adapter == null || childViewHolderInt == null)) {
            adapter.onViewAttachedToWindow(childViewHolderInt);
        }
        List<p> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).d(view);
            }
        }
    }

    public void dispatchChildDetached(View view) {
        b0 childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        Adapter adapter = this.mAdapter;
        if (!(adapter == null || childViewHolderInt == null)) {
            adapter.onViewDetachedFromWindow(childViewHolderInt);
        }
        List<p> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).b(view);
            }
        }
    }

    public void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.w(TAG, "No adapter attached; skipping layout");
        } else if (this.mLayout == null) {
            Log.e(TAG, "No layout manager attached; skipping layout");
        } else {
            boolean z2 = false;
            this.mState.i = false;
            boolean z3 = this.mLastAutoMeasureSkippedDueToExact && !(this.mLastAutoMeasureNonExactMeasuredWidth == getWidth() && this.mLastAutoMeasureNonExactMeasuredHeight == getHeight());
            this.mLastAutoMeasureNonExactMeasuredWidth = 0;
            this.mLastAutoMeasureNonExactMeasuredHeight = 0;
            this.mLastAutoMeasureSkippedDueToExact = false;
            if (this.mState.d == 1) {
                dispatchLayoutStep1();
                this.mLayout.setExactMeasureSpecsFrom(this);
                dispatchLayoutStep2();
            } else {
                h0.v.a.a aVar = this.mAdapterHelper;
                if (!aVar.c.isEmpty() && !aVar.b.isEmpty()) {
                    z2 = true;
                }
                if (z2 || z3 || this.mLayout.getWidth() != getWidth() || this.mLayout.getHeight() != getHeight()) {
                    this.mLayout.setExactMeasureSpecsFrom(this);
                    dispatchLayoutStep2();
                } else {
                    this.mLayout.setExactMeasureSpecsFrom(this);
                }
            }
            dispatchLayoutStep3();
        }
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return getScrollingChildHelper().a(f2, f3, z2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().b(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i2, i3, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().d(i2, i3, i4, i5, iArr);
    }

    public void dispatchOnScrollStateChanged(int i2) {
        n nVar = this.mLayout;
        if (nVar != null) {
            nVar.onScrollStateChanged(i2);
        }
        onScrollStateChanged(i2);
        s sVar = this.mScrollListener;
        if (sVar != null) {
            sVar.a(this, i2);
        }
        List<s> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).a(this, i2);
            }
        }
    }

    public void dispatchOnScrolled(int i2, int i3) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i2, scrollY - i3);
        onScrolled(i2, i3);
        s sVar = this.mScrollListener;
        if (sVar != null) {
            sVar.c(this, i2, i3);
        }
        List<s> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).c(this, i2, i3);
            }
        }
        this.mDispatchScrollCounter--;
    }

    public void dispatchPendingImportantForAccessibilityChanges() {
        int i2;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            b0 b0Var = this.mPendingAccessibilityImportanceChange.get(size);
            if (b0Var.itemView.getParent() == this && !b0Var.shouldIgnore() && (i2 = b0Var.mPendingAccessibilityState) != -1) {
                View view = b0Var.itemView;
                AtomicInteger atomicInteger = h0.i.i.q.a;
                view.setImportantForAccessibility(i2);
                b0Var.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z2;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.mItemDecorations.get(i2).h(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        boolean z4 = true;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + paddingBottom), 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) paddingTop, (float) (-width));
            EdgeEffect edgeEffect6 = this.mRightGlow;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate((float) (getPaddingRight() + (-getWidth())), (float) (getPaddingBottom() + (-getHeight())));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 |= z3;
            canvas.restoreToCount(save4);
        }
        if (z2 || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.isRunning()) {
            z4 = z2;
        }
        if (z4) {
            AtomicInteger atomicInteger = h0.i.i.q.a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public void ensureBottomGlow() {
        if (this.mBottomGlow == null) {
            EdgeEffect a2 = this.mEdgeEffectFactory.a(this);
            this.mBottomGlow = a2;
            if (this.mClipToPadding) {
                a2.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                a2.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public void ensureLeftGlow() {
        if (this.mLeftGlow == null) {
            EdgeEffect a2 = this.mEdgeEffectFactory.a(this);
            this.mLeftGlow = a2;
            if (this.mClipToPadding) {
                a2.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                a2.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void ensureRightGlow() {
        if (this.mRightGlow == null) {
            EdgeEffect a2 = this.mEdgeEffectFactory.a(this);
            this.mRightGlow = a2;
            if (this.mClipToPadding) {
                a2.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                a2.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void ensureTopGlow() {
        if (this.mTopGlow == null) {
            EdgeEffect a2 = this.mEdgeEffectFactory.a(this);
            this.mTopGlow = a2;
            if (this.mClipToPadding) {
                a2.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                a2.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public String exceptionLabel() {
        StringBuilder P0 = i0.d.a.a.a.P0(" ");
        P0.append(super.toString());
        P0.append(", adapter:");
        P0.append(this.mAdapter);
        P0.append(", layout:");
        P0.append(this.mLayout);
        P0.append(", context:");
        P0.append(getContext());
        return P0.toString();
    }

    public final void fillRemainingScrollValues(y yVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.mViewFlinger.q;
            overScroller.getFinalX();
            overScroller.getCurrX();
            Objects.requireNonNull(yVar);
            overScroller.getFinalY();
            overScroller.getCurrY();
            return;
        }
        Objects.requireNonNull(yVar);
    }

    public View findChildViewUnder(float f2, float f3) {
        for (int e2 = this.mChildHelper.e() - 1; e2 >= 0; e2--) {
            View d2 = this.mChildHelper.d(e2);
            float translationX = d2.getTranslationX();
            float translationY = d2.getTranslationY();
            if (f2 >= ((float) d2.getLeft()) + translationX && f2 <= ((float) d2.getRight()) + translationX && f3 >= ((float) d2.getTop()) + translationY && f3 <= ((float) d2.getBottom()) + translationY) {
                return d2;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:?, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public View findContainingItemView(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = (View) parent;
            parent = view.getParent();
        }
        return null;
    }

    public b0 findContainingViewHolder(View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    public b0 findViewHolderForAdapterPosition(int i2) {
        b0 b0Var = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int h2 = this.mChildHelper.h();
        for (int i3 = 0; i3 < h2; i3++) {
            b0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i3));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionInRecyclerView(childViewHolderInt) == i2) {
                if (!this.mChildHelper.k(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                b0Var = childViewHolderInt;
            }
        }
        return b0Var;
    }

    public b0 findViewHolderForItemId(long j2) {
        Adapter adapter = this.mAdapter;
        b0 b0Var = null;
        if (adapter != null && adapter.hasStableIds()) {
            int h2 = this.mChildHelper.h();
            for (int i2 = 0; i2 < h2; i2++) {
                b0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i2));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j2) {
                    if (!this.mChildHelper.k(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    b0Var = childViewHolderInt;
                }
            }
        }
        return b0Var;
    }

    public b0 findViewHolderForLayoutPosition(int i2) {
        return findViewHolderForPosition(i2, false);
    }

    @Deprecated
    public b0 findViewHolderForPosition(int i2) {
        return findViewHolderForPosition(i2, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00a1 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public boolean fling(int i2, int i3) {
        boolean z2;
        int minFlingVelocity;
        boolean z3;
        x c2;
        int e2;
        n nVar = this.mLayout;
        if (nVar == null) {
            Log.e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.mLayoutSuppressed) {
            return false;
        } else {
            boolean canScrollHorizontally = nVar.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            int i4 = (!canScrollHorizontally || Math.abs(i2) < this.mMinFlingVelocity) ? 0 : i2;
            int i5 = (!canScrollVertically || Math.abs(i3) < this.mMinFlingVelocity) ? 0 : i3;
            if (i4 == 0 && i5 == 0) {
                return false;
            }
            float f2 = (float) i4;
            float f3 = (float) i5;
            if (!dispatchNestedPreFling(f2, f3)) {
                boolean z4 = canScrollHorizontally || canScrollVertically;
                dispatchNestedFling(f2, f3, z4);
                q qVar = this.mOnFlingListener;
                if (qVar != null) {
                    h0.v.a.z zVar = (h0.v.a.z) qVar;
                    n layoutManager = zVar.a.getLayoutManager();
                    if (!(layoutManager == null || zVar.a.getAdapter() == null || (Math.abs(i5) <= (minFlingVelocity = zVar.a.getMinFlingVelocity()) && Math.abs(i4) <= minFlingVelocity))) {
                        if (!(layoutManager instanceof x.b) || (c2 = zVar.c(layoutManager)) == null || (e2 = zVar.e(layoutManager, i4, i5)) == -1) {
                            z3 = false;
                        } else {
                            c2.a = e2;
                            layoutManager.startSmoothScroll(c2);
                            z3 = true;
                        }
                        if (z3) {
                            z2 = true;
                            if (z2) {
                                return true;
                            }
                        }
                    }
                    z2 = false;
                    if (z2) {
                    }
                }
                if (z4) {
                    int i6 = canScrollHorizontally ? 1 : 0;
                    if (canScrollVertically) {
                        i6 |= 2;
                    }
                    startNestedScroll(i6, 1);
                    int i7 = this.mMaxFlingVelocity;
                    int max = Math.max(-i7, Math.min(i4, i7));
                    int i8 = this.mMaxFlingVelocity;
                    int max2 = Math.max(-i8, Math.min(i5, i8));
                    a0 a0Var = this.mViewFlinger;
                    RecyclerView.this.setScrollState(2);
                    a0Var.d = 0;
                    a0Var.c = 0;
                    Interpolator interpolator = a0Var.x;
                    Interpolator interpolator2 = sQuinticInterpolator;
                    if (interpolator != interpolator2) {
                        a0Var.x = interpolator2;
                        a0Var.q = new OverScroller(RecyclerView.this.getContext(), interpolator2);
                    }
                    a0Var.q.fling(0, 0, max, max2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                    a0Var.a();
                    return true;
                }
            }
            return false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i2) {
        View view2;
        boolean z2;
        View onInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view, i2);
        if (onInterceptFocusSearch != null) {
            return onInterceptFocusSearch;
        }
        boolean z3 = true;
        boolean z4 = this.mAdapter != null && this.mLayout != null && !isComputingLayout() && !this.mLayoutSuppressed;
        FocusFinder instance = FocusFinder.getInstance();
        if (!z4 || !(i2 == 2 || i2 == 1)) {
            View findNextFocus = instance.findNextFocus(this, view, i2);
            if (findNextFocus != null || !z4) {
                view2 = findNextFocus;
            } else {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                view2 = this.mLayout.onFocusSearchFailed(view, i2, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
        } else {
            if (this.mLayout.canScrollVertically()) {
                int i3 = i2 == 2 ? 130 : 33;
                z2 = instance.findNextFocus(this, view, i3) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i2 = i3;
                }
            } else {
                z2 = false;
            }
            if (!z2 && this.mLayout.canScrollHorizontally()) {
                int i4 = (this.mLayout.getLayoutDirection() == 1) ^ (i2 == 2) ? 66 : 17;
                if (instance.findNextFocus(this, view, i4) != null) {
                    z3 = false;
                }
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i2 = i4;
                }
                z2 = z3;
            }
            if (z2) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.onFocusSearchFailed(view, i2, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            view2 = instance.findNextFocus(this, view, i2);
        }
        if (view2 == null || view2.hasFocusable()) {
            return isPreferredNextFocus(view, view2, i2) ? view2 : super.focusSearch(view, i2);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        }
        requestChildOnScreen(view2, null);
        return view;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        n nVar = this.mLayout;
        if (nVar != null) {
            return nVar.generateDefaultLayoutParams();
        }
        throw new IllegalStateException(i0.d.a.a.a.S(this, i0.d.a.a.a.P0("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        n nVar = this.mLayout;
        if (nVar != null) {
            return nVar.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException(i0.d.a.a.a.S(this, i0.d.a.a.a.P0("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public Adapter getAdapter() {
        return this.mAdapter;
    }

    public int getAdapterPositionInRecyclerView(b0 b0Var) {
        if (b0Var.hasAnyOfTheFlags(524) || !b0Var.isBound()) {
            return -1;
        }
        h0.v.a.a aVar = this.mAdapterHelper;
        int i2 = b0Var.mPosition;
        int size = aVar.b.size();
        for (int i3 = 0; i3 < size; i3++) {
            a.b bVar = aVar.b.get(i3);
            int i4 = bVar.a;
            if (i4 != 1) {
                if (i4 == 2) {
                    int i5 = bVar.b;
                    if (i5 <= i2) {
                        int i6 = bVar.d;
                        if (i5 + i6 > i2) {
                            return -1;
                        }
                        i2 -= i6;
                    } else {
                        continue;
                    }
                } else if (i4 == 8) {
                    int i7 = bVar.b;
                    if (i7 == i2) {
                        i2 = bVar.d;
                    } else {
                        if (i7 < i2) {
                            i2--;
                        }
                        if (bVar.d <= i2) {
                            i2++;
                        }
                    }
                }
            } else if (bVar.b <= i2) {
                i2 += bVar.d;
            }
        }
        return i2;
    }

    @Override // android.view.View
    public int getBaseline() {
        n nVar = this.mLayout;
        if (nVar != null) {
            return nVar.getBaseline();
        }
        return super.getBaseline();
    }

    public long getChangedHolderKey(b0 b0Var) {
        return this.mAdapter.hasStableIds() ? b0Var.getItemId() : (long) b0Var.mPosition;
    }

    public int getChildAdapterPosition(View view) {
        b0 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAbsoluteAdapterPosition();
        }
        return -1;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        i iVar = this.mChildDrawingOrderCallback;
        if (iVar == null) {
            return super.getChildDrawingOrder(i2, i3);
        }
        return iVar.a(i2, i3);
    }

    public long getChildItemId(View view) {
        b0 childViewHolderInt;
        Adapter adapter = this.mAdapter;
        if (adapter == null || !adapter.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1;
        }
        return childViewHolderInt.getItemId();
    }

    public int getChildLayoutPosition(View view) {
        b0 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public b0 getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return getChildViewHolderInt(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public h0.v.a.x getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    public j getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    public k getItemAnimator() {
        return this.mItemAnimator;
    }

    public Rect getItemDecorInsetsForChild(View view) {
        o oVar = (o) view.getLayoutParams();
        if (!oVar.c) {
            return oVar.b;
        }
        if (this.mState.g && (oVar.b() || oVar.a.isInvalid())) {
            return oVar.b;
        }
        Rect rect = oVar.b;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i2).f(this.mTempRect, view, this, this.mState);
            int i3 = rect.left;
            Rect rect2 = this.mTempRect;
            rect.left = i3 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        oVar.c = false;
        return rect;
    }

    public m getItemDecorationAt(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 >= 0 && i2 < itemDecorationCount) {
            return this.mItemDecorations.get(i2);
        }
        throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public n getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0;
    }

    public q getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public t getRecycledViewPool() {
        return this.mRecycler.d();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().g(0);
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.g();
    }

    public void initAdapterManager() {
        this.mAdapterHelper = new h0.v.a.a(new f());
    }

    public void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException(i0.d.a.a.a.S(this, i0.d.a.a.a.P0("Trying to set fast scroller without both required drawables.")));
        }
        Resources resources = getContext().getResources();
        new h0.v.a.i(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(R.dimen.fastscroll_margin));
    }

    public void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() != 0) {
            n nVar = this.mLayout;
            if (nVar != null) {
                nVar.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
            }
            markItemDecorInsetsDirty();
            requestLayout();
        }
    }

    public boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean isAnimating() {
        k kVar = this.mItemAnimator;
        return kVar != null && kVar.isRunning();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().d;
    }

    public void jumpToPositionForSmoothScroller(int i2) {
        if (this.mLayout != null) {
            setScrollState(2);
            this.mLayout.scrollToPosition(i2);
            awakenScrollBars();
        }
    }

    public void markItemDecorInsetsDirty() {
        int h2 = this.mChildHelper.h();
        for (int i2 = 0; i2 < h2; i2++) {
            ((o) this.mChildHelper.g(i2).getLayoutParams()).c = true;
        }
        u uVar = this.mRecycler;
        int size = uVar.c.size();
        for (int i3 = 0; i3 < size; i3++) {
            o oVar = (o) uVar.c.get(i3).itemView.getLayoutParams();
            if (oVar != null) {
                oVar.c = true;
            }
        }
    }

    public void markKnownViewsInvalid() {
        int h2 = this.mChildHelper.h();
        for (int i2 = 0; i2 < h2; i2++) {
            b0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i2));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        u uVar = this.mRecycler;
        int size = uVar.c.size();
        for (int i3 = 0; i3 < size; i3++) {
            b0 b0Var = uVar.c.get(i3);
            if (b0Var != null) {
                b0Var.addFlags(6);
                b0Var.addChangePayload(null);
            }
        }
        Adapter adapter = RecyclerView.this.mAdapter;
        if (adapter == null || !adapter.hasStableIds()) {
            uVar.g();
        }
    }

    public void nestedScrollBy(int i2, int i3) {
        nestedScrollByInternal(i2, i3, null, 1);
    }

    public void offsetChildrenHorizontal(int i2) {
        int e2 = this.mChildHelper.e();
        for (int i3 = 0; i3 < e2; i3++) {
            this.mChildHelper.d(i3).offsetLeftAndRight(i2);
        }
    }

    public void offsetChildrenVertical(int i2) {
        int e2 = this.mChildHelper.e();
        for (int i3 = 0; i3 < e2; i3++) {
            this.mChildHelper.d(i3).offsetTopAndBottom(i2);
        }
    }

    public void offsetPositionRecordsForInsert(int i2, int i3) {
        int h2 = this.mChildHelper.h();
        for (int i4 = 0; i4 < h2; i4++) {
            b0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i4));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i2) {
                childViewHolderInt.offsetPosition(i3, false);
                this.mState.f = true;
            }
        }
        u uVar = this.mRecycler;
        int size = uVar.c.size();
        for (int i5 = 0; i5 < size; i5++) {
            b0 b0Var = uVar.c.get(i5);
            if (b0Var != null && b0Var.mPosition >= i2) {
                b0Var.offsetPosition(i3, false);
            }
        }
        requestLayout();
    }

    public void offsetPositionRecordsForMove(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int h2 = this.mChildHelper.h();
        int i11 = -1;
        if (i2 < i3) {
            i6 = i2;
            i5 = i3;
            i4 = -1;
        } else {
            i5 = i2;
            i6 = i3;
            i4 = 1;
        }
        for (int i12 = 0; i12 < h2; i12++) {
            b0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i12));
            if (childViewHolderInt != null && (i10 = childViewHolderInt.mPosition) >= i6 && i10 <= i5) {
                if (i10 == i2) {
                    childViewHolderInt.offsetPosition(i3 - i2, false);
                } else {
                    childViewHolderInt.offsetPosition(i4, false);
                }
                this.mState.f = true;
            }
        }
        u uVar = this.mRecycler;
        if (i2 < i3) {
            i8 = i2;
            i7 = i3;
        } else {
            i7 = i2;
            i11 = 1;
            i8 = i3;
        }
        int size = uVar.c.size();
        for (int i13 = 0; i13 < size; i13++) {
            b0 b0Var = uVar.c.get(i13);
            if (b0Var != null && (i9 = b0Var.mPosition) >= i8 && i9 <= i7) {
                if (i9 == i2) {
                    b0Var.offsetPosition(i3 - i2, false);
                } else {
                    b0Var.offsetPosition(i11, false);
                }
            }
        }
        requestLayout();
    }

    public void offsetPositionRecordsForRemove(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int h2 = this.mChildHelper.h();
        for (int i5 = 0; i5 < h2; i5++) {
            b0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i5));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                int i6 = childViewHolderInt.mPosition;
                if (i6 >= i4) {
                    childViewHolderInt.offsetPosition(-i3, z2);
                    this.mState.f = true;
                } else if (i6 >= i2) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(i2 - 1, -i3, z2);
                    this.mState.f = true;
                }
            }
        }
        u uVar = this.mRecycler;
        int size = uVar.c.size();
        while (true) {
            size--;
            if (size >= 0) {
                b0 b0Var = uVar.c.get(size);
                if (b0Var != null) {
                    int i7 = b0Var.mPosition;
                    if (i7 >= i4) {
                        b0Var.offsetPosition(-i3, z2);
                    } else if (i7 >= i2) {
                        b0Var.addFlags(8);
                        uVar.h(size);
                    }
                }
            } else {
                requestLayout();
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        boolean z2 = true;
        this.mIsAttached = true;
        if (!this.mFirstLayoutComplete || isLayoutRequested()) {
            z2 = false;
        }
        this.mFirstLayoutComplete = z2;
        n nVar = this.mLayout;
        if (nVar != null) {
            nVar.dispatchAttachedToWindow(this);
        }
        this.mPostedAnimatorRunner = false;
        if (ALLOW_THREAD_GAP_WORK) {
            ThreadLocal<h0.v.a.j> threadLocal = h0.v.a.j.c;
            h0.v.a.j jVar = threadLocal.get();
            this.mGapWorker = jVar;
            if (jVar == null) {
                this.mGapWorker = new h0.v.a.j();
                AtomicInteger atomicInteger = h0.i.i.q.a;
                Display display = getDisplay();
                float f2 = 60.0f;
                if (!isInEditMode() && display != null) {
                    float refreshRate = display.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f2 = refreshRate;
                    }
                }
                h0.v.a.j jVar2 = this.mGapWorker;
                jVar2.y = (long) (1.0E9f / f2);
                threadLocal.set(jVar2);
            }
            this.mGapWorker.q.add(this);
        }
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        h0.v.a.j jVar;
        super.onDetachedFromWindow();
        k kVar = this.mItemAnimator;
        if (kVar != null) {
            kVar.endAnimations();
        }
        stopScroll();
        this.mIsAttached = false;
        n nVar = this.mLayout;
        if (nVar != null) {
            nVar.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        Objects.requireNonNull(this.mViewInfoStore);
        do {
        } while (c0.a.a.a() != null);
        if (ALLOW_THREAD_GAP_WORK && (jVar = this.mGapWorker) != null) {
            jVar.q.remove(this);
            this.mGapWorker = null;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mItemDecorations.get(i2).g(canvas, this, this.mState);
        }
    }

    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    public void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0068  */
    @Override // android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump */
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f2;
        float f3;
        if (this.mLayout != null && !this.mLayoutSuppressed && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f3 = this.mLayout.canScrollVertically() ? -motionEvent.getAxisValue(9) : 0.0f;
                if (this.mLayout.canScrollHorizontally()) {
                    f2 = motionEvent.getAxisValue(10);
                    if (f3 == 0.0f || f2 != 0.0f) {
                        nestedScrollByInternal((int) (f2 * this.mScaledHorizontalScrollFactor), (int) (f3 * this.mScaledVerticalScrollFactor), motionEvent, 1);
                    }
                }
                f2 = 0.0f;
                if (f3 == 0.0f) {
                }
                nestedScrollByInternal((int) (f2 * this.mScaledHorizontalScrollFactor), (int) (f3 * this.mScaledVerticalScrollFactor), motionEvent, 1);
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    float axisValue = motionEvent.getAxisValue(26);
                    if (this.mLayout.canScrollVertically()) {
                        f3 = -axisValue;
                        f2 = 0.0f;
                        if (f3 == 0.0f) {
                        }
                        nestedScrollByInternal((int) (f2 * this.mScaledHorizontalScrollFactor), (int) (f3 * this.mScaledVerticalScrollFactor), motionEvent, 1);
                    } else if (this.mLayout.canScrollHorizontally()) {
                        f2 = axisValue;
                        f3 = 0.0f;
                        if (f3 == 0.0f) {
                        }
                        nestedScrollByInternal((int) (f2 * this.mScaledHorizontalScrollFactor), (int) (f3 * this.mScaledVerticalScrollFactor), motionEvent, 1);
                    }
                }
                f3 = 0.0f;
                f2 = 0.0f;
                if (f3 == 0.0f) {
                }
                nestedScrollByInternal((int) (f2 * this.mScaledHorizontalScrollFactor), (int) (f3 * this.mScaledVerticalScrollFactor), motionEvent, 1);
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Object[] objArr;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(motionEvent)) {
            cancelScroll();
            return true;
        }
        n nVar = this.mLayout;
        if (nVar == null) {
            return false;
        }
        boolean canScrollHorizontally = nVar.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x2;
            this.mInitialTouchX = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y2;
            this.mInitialTouchY = y2;
            if (this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            if (canScrollVertically) {
                boolean z2 = canScrollHorizontally ? 1 : 0;
                char c2 = canScrollHorizontally ? 1 : 0;
                canScrollHorizontally = z2 | true;
            }
            int i2 = canScrollHorizontally ? 1 : 0;
            int i3 = canScrollHorizontally ? 1 : 0;
            int i4 = canScrollHorizontally ? 1 : 0;
            startNestedScroll(i2, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (findPointerIndex < 0) {
                StringBuilder P0 = i0.d.a.a.a.P0("Error processing scroll; pointer index for id ");
                P0.append(this.mScrollPointerId);
                P0.append(" not found. Did any MotionEvents get skipped?");
                Log.e(TAG, P0.toString());
                return false;
            }
            int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.mScrollState != 1) {
                int i5 = x3 - this.mInitialTouchX;
                int i6 = y3 - this.mInitialTouchY;
                if (!canScrollHorizontally || Math.abs(i5) <= this.mTouchSlop) {
                    objArr = null;
                } else {
                    this.mLastTouchX = x3;
                    objArr = 1;
                }
                if (canScrollVertically && Math.abs(i6) > this.mTouchSlop) {
                    this.mLastTouchY = y3;
                    objArr = 1;
                }
                if (objArr != null) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            cancelScroll();
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x4;
            this.mInitialTouchX = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y4;
            this.mInitialTouchY = y4;
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        if (this.mScrollState == 1) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6 = h0.i.e.f.a;
        Trace.beginSection(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        Trace.endSection();
        this.mFirstLayoutComplete = true;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        n nVar = this.mLayout;
        if (nVar == null) {
            defaultOnMeasure(i2, i3);
            return;
        }
        boolean z2 = false;
        if (nVar.isAutoMeasureEnabled()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.mLayout.onMeasure(this.mRecycler, this.mState, i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z2 = true;
            }
            this.mLastAutoMeasureSkippedDueToExact = z2;
            if (!z2 && this.mAdapter != null) {
                if (this.mState.d == 1) {
                    dispatchLayoutStep1();
                }
                this.mLayout.setMeasureSpecs(i2, i3);
                this.mState.i = true;
                dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(i2, i3);
                if (this.mLayout.shouldMeasureTwice()) {
                    this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.mState.i = true;
                    dispatchLayoutStep2();
                    this.mLayout.setMeasuredDimensionFromChildren(i2, i3);
                }
                this.mLastAutoMeasureNonExactMeasuredWidth = getMeasuredWidth();
                this.mLastAutoMeasureNonExactMeasuredHeight = getMeasuredHeight();
            }
        } else if (this.mHasFixedSize) {
            this.mLayout.onMeasure(this.mRecycler, this.mState, i2, i3);
        } else {
            if (this.mAdapterUpdateDuringMeasure) {
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                processAdapterUpdatesAndSetAnimationFlags();
                onExitLayoutOrScroll();
                y yVar = this.mState;
                if (yVar.k) {
                    yVar.g = true;
                } else {
                    this.mAdapterHelper.c();
                    this.mState.g = false;
                }
                this.mAdapterUpdateDuringMeasure = false;
                stopInterceptRequestLayout(false);
            } else if (this.mState.k) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            Adapter adapter = this.mAdapter;
            if (adapter != null) {
                this.mState.e = adapter.getItemCount();
            } else {
                this.mState.e = 0;
            }
            startInterceptRequestLayout();
            this.mLayout.onMeasure(this.mRecycler, this.mState, i2, i3);
            stopInterceptRequestLayout(false);
            this.mState.g = false;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.mPendingSavedState = savedState;
        super.onRestoreInstanceState(savedState.d);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.mPendingSavedState;
        if (savedState2 != null) {
            savedState.q = savedState2.q;
        } else {
            n nVar = this.mLayout;
            if (nVar != null) {
                savedState.q = nVar.onSaveInstanceState();
            } else {
                savedState.q = null;
            }
        }
        return savedState;
    }

    public void onScrollStateChanged(int i2) {
    }

    public void onScrolled(int i2, int i3) {
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4 || i3 != i5) {
            invalidateGlows();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f4  */
    @Override // android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Object[] objArr;
        boolean z2 = false;
        if (this.mLayoutSuppressed || this.mIgnoreMotionEventTillDown) {
            return false;
        }
        if (dispatchToOnItemTouchListeners(motionEvent)) {
            cancelScroll();
            return true;
        }
        n nVar = this.mLayout;
        if (nVar == null) {
            return false;
        }
        boolean canScrollHorizontally = nVar.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int[] iArr2 = this.mNestedOffsets;
        obtain.offsetLocation((float) iArr2[0], (float) iArr2[1]);
        if (actionMasked == 0) {
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x2;
            this.mInitialTouchX = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y2;
            this.mInitialTouchY = y2;
            if (canScrollVertically) {
                boolean z3 = canScrollHorizontally ? 1 : 0;
                char c2 = canScrollHorizontally ? 1 : 0;
                canScrollHorizontally = z3 | true;
            }
            int i2 = canScrollHorizontally ? 1 : 0;
            int i3 = canScrollHorizontally ? 1 : 0;
            int i4 = canScrollHorizontally ? 1 : 0;
            startNestedScroll(i2, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.addMovement(obtain);
            this.mVelocityTracker.computeCurrentVelocity(1000, (float) this.mMaxFlingVelocity);
            float f2 = canScrollHorizontally ? -this.mVelocityTracker.getXVelocity(this.mScrollPointerId) : 0.0f;
            float f3 = canScrollVertically ? -this.mVelocityTracker.getYVelocity(this.mScrollPointerId) : 0.0f;
            if ((f2 == 0.0f && f3 == 0.0f) || !fling((int) f2, (int) f3)) {
                setScrollState(0);
            }
            resetScroll();
            z2 = true;
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (findPointerIndex < 0) {
                StringBuilder P0 = i0.d.a.a.a.P0("Error processing scroll; pointer index for id ");
                P0.append(this.mScrollPointerId);
                P0.append(" not found. Did any MotionEvents get skipped?");
                Log.e(TAG, P0.toString());
                return false;
            }
            int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            int i5 = this.mLastTouchX - x3;
            int i6 = this.mLastTouchY - y3;
            if (this.mScrollState != 1) {
                if (canScrollHorizontally) {
                    if (i5 > 0) {
                        i5 = Math.max(0, i5 - this.mTouchSlop);
                    } else {
                        i5 = Math.min(0, i5 + this.mTouchSlop);
                    }
                    if (i5 != 0) {
                        objArr = 1;
                        if (canScrollVertically) {
                            if (i6 > 0) {
                                i6 = Math.max(0, i6 - this.mTouchSlop);
                            } else {
                                i6 = Math.min(0, i6 + this.mTouchSlop);
                            }
                            if (i6 != 0) {
                                objArr = 1;
                            }
                        }
                        if (objArr != null) {
                            setScrollState(1);
                        }
                    }
                }
                objArr = null;
                if (canScrollVertically) {
                }
                if (objArr != null) {
                }
            }
            int i7 = i5;
            int i8 = i6;
            if (this.mScrollState == 1) {
                int[] iArr3 = this.mReusableIntPair;
                iArr3[0] = 0;
                iArr3[1] = 0;
                if (dispatchNestedPreScroll(canScrollHorizontally ? i7 : 0, canScrollVertically ? i8 : 0, iArr3, this.mScrollOffset, 0)) {
                    int[] iArr4 = this.mReusableIntPair;
                    i7 -= iArr4[0];
                    i8 -= iArr4[1];
                    int[] iArr5 = this.mNestedOffsets;
                    int i9 = iArr5[0];
                    int[] iArr6 = this.mScrollOffset;
                    iArr5[0] = i9 + iArr6[0];
                    iArr5[1] = iArr5[1] + iArr6[1];
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                int[] iArr7 = this.mScrollOffset;
                this.mLastTouchX = x3 - iArr7[0];
                this.mLastTouchY = y3 - iArr7[1];
                if (scrollByInternal(canScrollHorizontally ? i7 : 0, canScrollVertically ? i8 : 0, motionEvent, 0)) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                h0.v.a.j jVar = this.mGapWorker;
                if (!(jVar == null || (i7 == 0 && i8 == 0))) {
                    jVar.a(this, i7, i8);
                }
            }
        } else if (actionMasked == 3) {
            cancelScroll();
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x4;
            this.mInitialTouchX = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y4;
            this.mInitialTouchY = y4;
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        if (!z2) {
            this.mVelocityTracker.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    public void postAnimationRunner() {
        if (!this.mPostedAnimatorRunner && this.mIsAttached) {
            Runnable runnable = this.mItemAnimatorRunner;
            AtomicInteger atomicInteger = h0.i.i.q.a;
            postOnAnimation(runnable);
            this.mPostedAnimatorRunner = true;
        }
    }

    public void processDataSetCompletelyChanged(boolean z2) {
        this.mDispatchItemsChangedEvent = z2 | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    public void recordAnimationInfoIfBouncedHiddenView(b0 b0Var, k.c cVar) {
        b0Var.setFlags(0, 8192);
        if (this.mState.h && b0Var.isUpdated() && !b0Var.isRemoved() && !b0Var.shouldIgnore()) {
            this.mViewInfoStore.b.o(getChangedHolderKey(b0Var), b0Var);
        }
        this.mViewInfoStore.c(b0Var, cVar);
    }

    public void removeAndRecycleViews() {
        k kVar = this.mItemAnimator;
        if (kVar != null) {
            kVar.endAnimations();
        }
        n nVar = this.mLayout;
        if (nVar != null) {
            nVar.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        }
        this.mRecycler.b();
    }

    public boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        h0.v.a.e eVar = this.mChildHelper;
        int indexOfChild = RecyclerView.this.indexOfChild(view);
        boolean z2 = true;
        if (indexOfChild == -1) {
            eVar.m(view);
        } else if (eVar.b.d(indexOfChild)) {
            eVar.b.f(indexOfChild);
            eVar.m(view);
            ((e) eVar.a).c(indexOfChild);
        } else {
            z2 = false;
        }
        if (z2) {
            b0 childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.n(childViewHolderInt);
            this.mRecycler.j(childViewHolderInt);
        }
        stopInterceptRequestLayout(!z2);
        return z2;
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z2) {
        b0 childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(childViewHolderInt);
                throw new IllegalArgumentException(i0.d.a.a.a.S(this, sb));
            }
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z2);
    }

    public void removeItemDecoration(m mVar) {
        n nVar = this.mLayout;
        if (nVar != null) {
            nVar.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(mVar);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeItemDecorationAt(int i2) {
        int itemDecorationCount = getItemDecorationCount();
        if (i2 < 0 || i2 >= itemDecorationCount) {
            throw new IndexOutOfBoundsException(i2 + " is an invalid index for size " + itemDecorationCount);
        }
        removeItemDecoration(getItemDecorationAt(i2));
    }

    public void removeOnChildAttachStateChangeListener(p pVar) {
        List<p> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.remove(pVar);
        }
    }

    public void removeOnItemTouchListener(r rVar) {
        this.mOnItemTouchListeners.remove(rVar);
        if (this.mInterceptingOnItemTouchListener == rVar) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(s sVar) {
        List<s> list = this.mScrollListeners;
        if (list != null) {
            list.remove(sVar);
        }
    }

    public void removeRecyclerListener(v vVar) {
        this.mRecyclerListeners.remove(vVar);
    }

    public void repositionShadowingViews() {
        b0 b0Var;
        int e2 = this.mChildHelper.e();
        for (int i2 = 0; i2 < e2; i2++) {
            View d2 = this.mChildHelper.d(i2);
            b0 childViewHolder = getChildViewHolder(d2);
            if (!(childViewHolder == null || (b0Var = childViewHolder.mShadowingHolder) == null)) {
                View view = b0Var.itemView;
                int left = d2.getLeft();
                int top = d2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.onRequestChildFocus(this, this.mState, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.mOnItemTouchListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mOnItemTouchListeners.get(i2).e(z2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    @Override // android.view.ViewParent, android.view.View
    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth != 0 || this.mLayoutSuppressed) {
            this.mLayoutWasDefered = true;
        } else {
            super.requestLayout();
        }
    }

    public void saveOldPositions() {
        int h2 = this.mChildHelper.h();
        for (int i2 = 0; i2 < h2; i2++) {
            b0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i2));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    @Override // android.view.View
    public void scrollBy(int i2, int i3) {
        n nVar = this.mLayout;
        if (nVar == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutSuppressed) {
            boolean canScrollHorizontally = nVar.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            if (canScrollHorizontally || canScrollVertically) {
                if (!canScrollHorizontally) {
                    i2 = 0;
                }
                if (!canScrollVertically) {
                    i3 = 0;
                }
                scrollByInternal(i2, i3, null, 0);
            }
        }
    }

    public boolean scrollByInternal(int i2, int i3, MotionEvent motionEvent, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            int[] iArr = this.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            scrollStep(i2, i3, iArr);
            int[] iArr2 = this.mReusableIntPair;
            int i9 = iArr2[0];
            int i10 = iArr2[1];
            i6 = i2 - i9;
            i5 = i3 - i10;
            i8 = i10;
            i7 = i9;
        } else {
            i8 = 0;
            i7 = 0;
            i6 = 0;
            i5 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.mReusableIntPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        dispatchNestedScroll(i7, i8, i6, i5, this.mScrollOffset, i4, iArr3);
        int[] iArr4 = this.mReusableIntPair;
        int i11 = i6 - iArr4[0];
        int i12 = i5 - iArr4[1];
        boolean z2 = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
        int i13 = this.mLastTouchX;
        int[] iArr5 = this.mScrollOffset;
        this.mLastTouchX = i13 - iArr5[0];
        this.mLastTouchY -= iArr5[1];
        int[] iArr6 = this.mNestedOffsets;
        iArr6[0] = iArr6[0] + iArr5[0];
        iArr6[1] = iArr6[1] + iArr5[1];
        if (getOverScrollMode() != 2) {
            if (motionEvent != null) {
                if (!((motionEvent.getSource() & 8194) == 8194)) {
                    pullGlows(motionEvent.getX(), (float) i11, motionEvent.getY(), (float) i12);
                }
            }
            considerReleasingGlowsOnScroll(i2, i3);
        }
        if (!(i7 == 0 && i8 == 0)) {
            dispatchOnScrolled(i7, i8);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z2 && i7 == 0 && i8 == 0) ? false : true;
    }

    public void scrollStep(int i2, int i3, int[] iArr) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        int i4 = h0.i.e.f.a;
        Trace.beginSection(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        int scrollHorizontallyBy = i2 != 0 ? this.mLayout.scrollHorizontallyBy(i2, this.mRecycler, this.mState) : 0;
        int scrollVerticallyBy = i3 != 0 ? this.mLayout.scrollVerticallyBy(i3, this.mRecycler, this.mState) : 0;
        Trace.endSection();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = scrollHorizontallyBy;
            iArr[1] = scrollVerticallyBy;
        }
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int i2) {
        if (!this.mLayoutSuppressed) {
            stopScroll();
            n nVar = this.mLayout;
            if (nVar == null) {
                Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            nVar.scrollToPosition(i2);
            awakenScrollBars();
        }
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!shouldDeferAccessibilityEvent(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(h0.v.a.x xVar) {
        this.mAccessibilityDelegate = xVar;
        h0.i.i.q.p(this, xVar);
    }

    public void setAdapter(Adapter adapter) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(i iVar) {
        if (iVar != this.mChildDrawingOrderCallback) {
            this.mChildDrawingOrderCallback = iVar;
            setChildrenDrawingOrderEnabled(iVar != null);
        }
    }

    public boolean setChildImportantForAccessibilityInternal(b0 b0Var, int i2) {
        if (isComputingLayout()) {
            b0Var.mPendingAccessibilityState = i2;
            this.mPendingAccessibilityImportanceChange.add(b0Var);
            return false;
        }
        View view = b0Var.itemView;
        AtomicInteger atomicInteger = h0.i.i.q.a;
        view.setImportantForAccessibility(i2);
        return true;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z2) {
        if (z2 != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z2;
        super.setClipToPadding(z2);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(j jVar) {
        Objects.requireNonNull(jVar);
        this.mEdgeEffectFactory = jVar;
        invalidateGlows();
    }

    public void setHasFixedSize(boolean z2) {
        this.mHasFixedSize = z2;
    }

    public void setItemAnimator(k kVar) {
        k kVar2 = this.mItemAnimator;
        if (kVar2 != null) {
            kVar2.endAnimations();
            this.mItemAnimator.setListener(null);
        }
        this.mItemAnimator = kVar;
        if (kVar != null) {
            kVar.setListener(this.mItemAnimatorListener);
        }
    }

    public void setItemViewCacheSize(int i2) {
        u uVar = this.mRecycler;
        uVar.e = i2;
        uVar.o();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z2) {
        suppressLayout(z2);
    }

    public void setLayoutManager(n nVar) {
        if (nVar != this.mLayout) {
            stopScroll();
            if (this.mLayout != null) {
                k kVar = this.mItemAnimator;
                if (kVar != null) {
                    kVar.endAnimations();
                }
                this.mLayout.removeAndRecycleAllViews(this.mRecycler);
                this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
                this.mRecycler.b();
                if (this.mIsAttached) {
                    this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
                }
                this.mLayout.setRecyclerView(null);
                this.mLayout = null;
            } else {
                this.mRecycler.b();
            }
            h0.v.a.e eVar = this.mChildHelper;
            e.a aVar = eVar.b;
            aVar.a = 0;
            e.a aVar2 = aVar.b;
            if (aVar2 != null) {
                aVar2.g();
            }
            int size = eVar.c.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                e eVar2 = (e) eVar.a;
                Objects.requireNonNull(eVar2);
                b0 childViewHolderInt = getChildViewHolderInt(eVar.c.get(size));
                if (childViewHolderInt != null) {
                    childViewHolderInt.onLeftHiddenState(RecyclerView.this);
                }
                eVar.c.remove(size);
            }
            e eVar3 = (e) eVar.a;
            int b2 = eVar3.b();
            for (int i2 = 0; i2 < b2; i2++) {
                View a2 = eVar3.a(i2);
                RecyclerView.this.dispatchChildDetached(a2);
                a2.clearAnimation();
            }
            RecyclerView.this.removeAllViews();
            this.mLayout = nVar;
            if (nVar != null) {
                if (nVar.mRecyclerView == null) {
                    nVar.setRecyclerView(this);
                    if (this.mIsAttached) {
                        this.mLayout.dispatchAttachedToWindow(this);
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("LayoutManager ");
                    sb.append(nVar);
                    sb.append(" is already attached to a RecyclerView:");
                    throw new IllegalArgumentException(i0.d.a.a.a.S(nVar.mRecyclerView, sb));
                }
            }
            this.mRecycler.o();
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition == null) {
            super.setLayoutTransition(null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z2) {
        h0.i.i.i scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.d) {
            View view = scrollingChildHelper.c;
            AtomicInteger atomicInteger = h0.i.i.q.a;
            view.stopNestedScroll();
        }
        scrollingChildHelper.d = z2;
    }

    public void setOnFlingListener(q qVar) {
        this.mOnFlingListener = qVar;
    }

    @Deprecated
    public void setOnScrollListener(s sVar) {
        this.mScrollListener = sVar;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.mPreserveFocusAfterLayout = z2;
    }

    public void setRecycledViewPool(t tVar) {
        u uVar = this.mRecycler;
        t tVar2 = uVar.g;
        if (tVar2 != null) {
            tVar2.b--;
        }
        uVar.g = tVar;
        if (tVar != null && RecyclerView.this.getAdapter() != null) {
            uVar.g.b++;
        }
    }

    @Deprecated
    public void setRecyclerListener(v vVar) {
        this.mRecyclerListener = vVar;
    }

    public void setScrollState(int i2) {
        if (i2 != this.mScrollState) {
            this.mScrollState = i2;
            if (i2 != 2) {
                stopScrollersInternal();
            }
            dispatchOnScrollStateChanged(i2);
        }
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 != 1) {
                Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
            } else {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(z zVar) {
        Objects.requireNonNull(this.mRecycler);
    }

    public boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int i2 = 0;
        if (!isComputingLayout()) {
            return false;
        }
        int contentChangeTypes = accessibilityEvent != null ? accessibilityEvent.getContentChangeTypes() : 0;
        if (contentChangeTypes != 0) {
            i2 = contentChangeTypes;
        }
        this.mEatenAccessibilityChangeFlags |= i2;
        return true;
    }

    public void smoothScrollBy(int i2, int i3) {
        smoothScrollBy(i2, i3, null);
    }

    public void smoothScrollToPosition(int i2) {
        if (!this.mLayoutSuppressed) {
            n nVar = this.mLayout;
            if (nVar == null) {
                Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                nVar.smoothScrollToPosition(this, this.mState, i2);
            }
        }
    }

    public void startInterceptRequestLayout() {
        int i2 = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = i2;
        if (i2 == 1 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().h(i2, 0);
    }

    public void stopInterceptRequestLayout(boolean z2) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z2 && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z2 && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        getScrollingChildHelper().i(0);
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z2) {
        if (z2 != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (!z2) {
                this.mLayoutSuppressed = false;
                if (!(!this.mLayoutWasDefered || this.mLayout == null || this.mAdapter == null)) {
                    requestLayout();
                }
                this.mLayoutWasDefered = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.mLayoutSuppressed = true;
            this.mIgnoreMotionEventTillDown = true;
            stopScroll();
        }
    }

    public void swapAdapter(Adapter adapter, boolean z2) {
        setLayoutFrozen(false);
        setAdapterInternal(adapter, true, z2);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public void viewRangeUpdate(int i2, int i3, Object obj) {
        int i4;
        int i5;
        int h2 = this.mChildHelper.h();
        int i6 = i3 + i2;
        for (int i7 = 0; i7 < h2; i7++) {
            View g2 = this.mChildHelper.g(i7);
            b0 childViewHolderInt = getChildViewHolderInt(g2);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && (i5 = childViewHolderInt.mPosition) >= i2 && i5 < i6) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((o) g2.getLayoutParams()).c = true;
            }
        }
        u uVar = this.mRecycler;
        int size = uVar.c.size();
        while (true) {
            size--;
            if (size >= 0) {
                b0 b0Var = uVar.c.get(size);
                if (b0Var != null && (i4 = b0Var.mPosition) >= i2 && i4 < i6) {
                    b0Var.addFlags(2);
                    uVar.h(size);
                }
            } else {
                return;
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Adapter<VH extends b0> {
        private final g mObservable = new g();
        private boolean mHasStableIds = false;
        private StateRestorationPolicy mStateRestorationPolicy = StateRestorationPolicy.ALLOW;

        /* loaded from: classes.dex */
        public enum StateRestorationPolicy {
            ALLOW,
            PREVENT_WHEN_EMPTY,
            PREVENT
        }

        public final void bindViewHolder(VH vh, int i) {
            boolean z = vh.mBindingAdapter == null;
            if (z) {
                vh.mPosition = i;
                if (hasStableIds()) {
                    vh.mItemId = getItemId(i);
                }
                vh.setFlags(1, 519);
                int i2 = h0.i.e.f.a;
                Trace.beginSection(RecyclerView.TRACE_BIND_VIEW_TAG);
            }
            vh.mBindingAdapter = this;
            onBindViewHolder(vh, i, vh.getUnmodifiedPayloads());
            if (z) {
                vh.clearPayload();
                ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
                if (layoutParams instanceof o) {
                    ((o) layoutParams).c = true;
                }
                int i3 = h0.i.e.f.a;
                Trace.endSection();
            }
        }

        public boolean canRestoreState() {
            int ordinal = this.mStateRestorationPolicy.ordinal();
            return ordinal != 1 ? ordinal != 2 : getItemCount() > 0;
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i) {
            try {
                int i2 = h0.i.e.f.a;
                Trace.beginSection(RecyclerView.TRACE_CREATE_VIEW_TAG);
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i);
                if (onCreateViewHolder.itemView.getParent() == null) {
                    onCreateViewHolder.mItemViewType = i;
                    Trace.endSection();
                    return onCreateViewHolder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } catch (Throwable th) {
                int i3 = h0.i.e.f.a;
                Trace.endSection();
                throw th;
            }
        }

        public int findRelativeAdapterPositionIn(Adapter<? extends b0> adapter, b0 b0Var, int i) {
            if (adapter == this) {
                return i;
            }
            return -1;
        }

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public final StateRestorationPolicy getStateRestorationPolicy() {
            return this.mStateRestorationPolicy;
        }

        public final boolean hasObservers() {
            return this.mObservable.a();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.b();
        }

        public final void notifyItemChanged(int i) {
            this.mObservable.d(i, 1, null);
        }

        public final void notifyItemInserted(int i) {
            this.mObservable.e(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.mObservable.c(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.mObservable.d(i, i2, null);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.mObservable.e(i, i2);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.mObservable.f(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.mObservable.f(i, 1);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh, int i);

        public void onBindViewHolder(VH vh, int i, List<Object> list) {
            onBindViewHolder(vh, i);
        }

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }

        public void registerAdapterDataObserver(h hVar) {
            this.mObservable.registerObserver(hVar);
        }

        public void setHasStableIds(boolean z) {
            if (!hasObservers()) {
                this.mHasStableIds = z;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void setStateRestorationPolicy(StateRestorationPolicy stateRestorationPolicy) {
            this.mStateRestorationPolicy = stateRestorationPolicy;
            this.mObservable.g();
        }

        public void unregisterAdapterDataObserver(h hVar) {
            this.mObservable.unregisterObserver(hVar);
        }

        public final void notifyItemChanged(int i, Object obj) {
            this.mObservable.d(i, 1, obj);
        }

        public final void notifyItemRangeChanged(int i, int i2, Object obj) {
            this.mObservable.d(i, i2, obj);
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.recyclerViewStyle);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().e(i2, i3, i4, i5, iArr, i6, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0036 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public b0 findViewHolderForPosition(int i2, boolean z2) {
        int h2 = this.mChildHelper.h();
        b0 b0Var = null;
        for (int i3 = 0; i3 < h2; i3++) {
            b0 childViewHolderInt = getChildViewHolderInt(this.mChildHelper.g(i3));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved()) {
                if (z2) {
                    if (childViewHolderInt.mPosition != i2) {
                        continue;
                    }
                    if (this.mChildHelper.k(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    b0Var = childViewHolderInt;
                } else {
                    if (childViewHolderInt.getLayoutPosition() != i2) {
                        continue;
                    }
                    if (this.mChildHelper.k(childViewHolderInt.itemView)) {
                    }
                }
            }
        }
        return b0Var;
    }

    public void onExitLayoutOrScroll(boolean z2) {
        int i2 = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = i2;
        if (i2 < 1) {
            this.mLayoutOrScrollCounter = 0;
            if (z2) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    public void smoothScrollBy(int i2, int i3, Interpolator interpolator) {
        smoothScrollBy(i2, i3, interpolator, Integer.MIN_VALUE);
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public Parcelable q;

        /* loaded from: classes.dex */
        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.q = parcel.readParcelable(classLoader == null ? n.class.getClassLoader() : classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.d, i);
            parcel.writeParcelable(this.q, 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        float f2;
        float f3;
        this.mObserver = new w();
        this.mRecycler = new u();
        this.mViewInfoStore = new c0();
        this.mUpdateChildViewsRunnable = new a();
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mRecyclerListeners = new ArrayList();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new j();
        this.mItemAnimator = new h0.v.a.f();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new a0();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new j.b() : null;
        this.mState = new y();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new l();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new b();
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mViewInfoProcessCallback = new d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        Method method = h0.i.i.v.a;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            f2 = viewConfiguration.getScaledHorizontalScrollFactor();
        } else {
            f2 = h0.i.i.v.a(viewConfiguration, context);
        }
        this.mScaledHorizontalScrollFactor = f2;
        if (i3 >= 26) {
            f3 = viewConfiguration.getScaledVerticalScrollFactor();
        } else {
            f3 = h0.i.i.v.a(viewConfiguration, context);
        }
        this.mScaledVerticalScrollFactor = f3;
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.setListener(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        AtomicInteger atomicInteger = h0.i.i.q.a;
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new h0.v.a.x(this));
        int[] iArr = R.styleable.RecyclerView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        h0.i.i.q.o(this, context, iArr, attributeSet, obtainStyledAttributes, i2, 0);
        String string = obtainStyledAttributes.getString(R.styleable.RecyclerView_layoutManager);
        if (obtainStyledAttributes.getInt(R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.mClipToPadding = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_android_clipToPadding, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_fastScrollEnabled, false);
        this.mEnableFastScroller = z2;
        if (z2) {
            initFastScroller((StateListDrawable) obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        obtainStyledAttributes.recycle();
        createLayoutManager(context, string, attributeSet, i2, 0);
        int[] iArr2 = NESTED_SCROLLING_ATTRS;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i2, 0);
        h0.i.i.q.o(this, context, iArr2, attributeSet, obtainStyledAttributes2, i2, 0);
        boolean z3 = obtainStyledAttributes2.getBoolean(0, true);
        obtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z3);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().c(i2, i3, iArr, iArr2, i4);
    }

    public boolean hasNestedScrollingParent(int i2) {
        return getScrollingChildHelper().f(i2) != null;
    }

    public void smoothScrollBy(int i2, int i3, Interpolator interpolator, int i4) {
        smoothScrollBy(i2, i3, interpolator, i4, false);
    }

    public boolean startNestedScroll(int i2, int i3) {
        return getScrollingChildHelper().h(i2, i3);
    }

    public void stopNestedScroll(int i2) {
        getScrollingChildHelper().i(i2);
    }

    /* loaded from: classes.dex */
    public static class o extends ViewGroup.MarginLayoutParams {
        public b0 a;
        public final Rect b = new Rect();
        public boolean c = true;
        public boolean d = false;

        public o(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int a() {
            return this.a.getLayoutPosition();
        }

        public boolean b() {
            return this.a.isUpdated();
        }

        public boolean c() {
            return this.a.isRemoved();
        }

        public o(int i, int i2) {
            super(i, i2);
        }

        public o(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public o(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public o(o oVar) {
            super((ViewGroup.LayoutParams) oVar);
        }
    }

    public final void dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        getScrollingChildHelper().e(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        n nVar = this.mLayout;
        if (nVar != null) {
            return nVar.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException(i0.d.a.a.a.S(this, i0.d.a.a.a.P0("RecyclerView has no LayoutManager")));
    }

    public void smoothScrollBy(int i2, int i3, Interpolator interpolator, int i4, boolean z2) {
        n nVar = this.mLayout;
        if (nVar == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.mLayoutSuppressed) {
            int i5 = 0;
            if (!nVar.canScrollHorizontally()) {
                i2 = 0;
            }
            if (!this.mLayout.canScrollVertically()) {
                i3 = 0;
            }
            if (i2 != 0 || i3 != 0) {
                if (i4 == Integer.MIN_VALUE || i4 > 0) {
                    if (z2) {
                        if (i2 != 0) {
                            i5 = 1;
                        }
                        if (i3 != 0) {
                            i5 |= 2;
                        }
                        startNestedScroll(i5, 1);
                    }
                    this.mViewFlinger.b(i2, i3, i4, interpolator);
                    return;
                }
                scrollBy(i2, i3);
            }
        }
    }

    public void addItemDecoration(m mVar) {
        addItemDecoration(mVar, -1);
    }
}
