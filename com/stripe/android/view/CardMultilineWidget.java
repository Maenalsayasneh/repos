package com.stripe.android.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.recaptcha.RecaptchaActionType;
import com.google.android.material.textfield.TextInputLayout;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.stripe.android.R;
import com.stripe.android.cards.CardNumber;
import com.stripe.android.databinding.CardMultilineWidgetBinding;
import com.stripe.android.model.Address;
import com.stripe.android.model.Card;
import com.stripe.android.model.CardBrand;
import com.stripe.android.model.CardParams;
import com.stripe.android.model.ExpirationDate;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.model.parsers.AccountRangeJsonParser;
import com.stripe.android.view.CardInputListener;
import com.stripe.android.view.CardMultilineWidget;
import com.stripe.android.view.CardValidCallback;
import com.stripe.android.view.PostalCodeEditText;
import com.stripe.android.view.StripeEditText;
import i0.d.a.a.a;
import i0.j.f.p.h;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.text.StringsKt__IndentKt;
import m0.j.g;
import m0.n.a.l;
import m0.n.b.f;
import m0.n.b.i;
import m0.o.b;
import m0.o.d;
import m0.r.k;
/* compiled from: CardMultilineWidget.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009a\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0002·\u0001\u0018\u0000 ö\u00012\u00020\u00012\u00020\u0002:\u0006÷\u0001ø\u0001ö\u0001B6\b\u0007\u0012\b\u0010ò\u0001\u001a\u00030ñ\u0001\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\t\b\u0002\u0010ó\u0001\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0006\bô\u0001\u0010õ\u0001J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\rJ\u000f\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\rJ\u000f\u0010\u0012\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\rJ!\u0010\u0016\u001a\u00020\u00052\b\b\u0001\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u001c\u0010\rJ\u000f\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\rJ\u0019\u0010 \u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0019\u0010$\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u0019\u0010.\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010*H\u0000¢\u0006\u0004\b,\u0010-J\r\u0010/\u001a\u00020\u0003¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0003H\u0016¢\u0006\u0004\b2\u0010\u0007J\u0019\u00105\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u00010&H\u0000¢\u0006\u0004\b4\u0010)J\u0017\u00107\u001a\u00020\u00052\b\u00106\u001a\u0004\u0018\u00010&¢\u0006\u0004\b7\u0010)J\u0019\u0010;\u001a\u00020\u00052\b\u00108\u001a\u0004\u0018\u00010\u0013H\u0000¢\u0006\u0004\b9\u0010:J\u0015\u0010<\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b<\u0010\u0007J\u0019\u0010>\u001a\u00020\u00052\b\u0010=\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b>\u0010)J#\u0010A\u001a\u00020\u00052\b\b\u0001\u0010?\u001a\u00020\u00132\b\b\u0001\u0010@\u001a\u00020\u0013H\u0016¢\u0006\u0004\bA\u0010BJ\u0019\u0010D\u001a\u00020\u00052\b\u0010C\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\bD\u0010)J\r\u0010E\u001a\u00020\u0003¢\u0006\u0004\bE\u00100J\u0019\u0010H\u001a\u00020\u00052\b\u0010G\u001a\u0004\u0018\u00010FH\u0016¢\u0006\u0004\bH\u0010IJ\u0019\u0010K\u001a\u00020\u00052\b\u0010J\u001a\u0004\u0018\u00010FH\u0016¢\u0006\u0004\bK\u0010IJ\u0019\u0010M\u001a\u00020\u00052\b\u0010L\u001a\u0004\u0018\u00010FH\u0016¢\u0006\u0004\bM\u0010IJ\u0019\u0010O\u001a\u00020\u00052\b\u0010N\u001a\u0004\u0018\u00010FH\u0016¢\u0006\u0004\bO\u0010IJ\u000f\u0010P\u001a\u00020\u0003H\u0016¢\u0006\u0004\bP\u00100J\u0017\u0010R\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0003H\u0016¢\u0006\u0004\bR\u0010\u0007R\u0016\u0010V\u001a\u00020S8@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0018\u0010W\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Y\u001a\u00020\u00138\u0002@\u0003X\u0083\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR+\u0010`\u001a\u00020\u00032\u0006\u0010[\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u00100\"\u0004\b_\u0010\u0007R+\u0010g\u001a\u00020a2\u0006\u0010[\u001a\u00020a8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bb\u0010]\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u001c\u0010i\u001a\u00020h8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010lR\u0018\u0010m\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR+\u0010r\u001a\u00020a2\u0006\u0010[\u001a\u00020a8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bo\u0010]\u001a\u0004\bp\u0010d\"\u0004\bq\u0010fR+\u0010v\u001a\u00020a2\u0006\u0010[\u001a\u00020a8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bs\u0010]\u001a\u0004\bt\u0010d\"\u0004\bu\u0010fR\u001e\u0010+\u001a\u0004\u0018\u00010w8V@\u0017X\u0097\u0004¢\u0006\f\u0012\u0004\bz\u0010\r\u001a\u0004\bx\u0010yR\u001c\u0010{\u001a\u00020\u00018\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~R\u0019\u0010\u0080\u0001\u001a\u00020\u007f8\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R!\u0010\u0086\u0001\u001a\n\u0012\u0005\u0012\u00030\u0083\u00010\u0082\u00018B@\u0002X\u0082\u0004¢\u0006\b\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\"\u0010\u0088\u0001\u001a\u00030\u0087\u00018\u0000@\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u0088\u0001\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001b\u0010\u008c\u0001\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0019\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008e\u00018F@\u0006¢\u0006\b\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R\"\u0010\u0093\u0001\u001a\u00030\u0092\u00018\u0000@\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R3\u0010\u009d\u0001\u001a\u00030\u0097\u00012\u0007\u0010[\u001a\u00030\u0097\u00018@@@X\u0080\u008e\u0002¢\u0006\u0017\n\u0005\b\u0098\u0001\u0010]\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001R\"\u0010\u009e\u0001\u001a\u00030\u0087\u00018\u0000@\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u009e\u0001\u0010\u0089\u0001\u001a\u0006\b\u009f\u0001\u0010\u008b\u0001R4\u0010¤\u0001\u001a\u0004\u0018\u00010\u00132\b\u0010[\u001a\u0004\u0018\u00010\u00138@@@X\u0080\u008e\u0002¢\u0006\u0016\n\u0005\b \u0001\u0010]\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0005\b£\u0001\u0010:R\u001c\u0010¨\u0001\u001a\u0005\u0018\u00010¥\u00018@@\u0000X\u0080\u0004¢\u0006\b\u001a\u0006\b¦\u0001\u0010§\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0004\u0010©\u0001R\u001c\u0010\u00ad\u0001\u001a\u0005\u0018\u00010ª\u00018V@\u0016X\u0096\u0004¢\u0006\b\u001a\u0006\b«\u0001\u0010¬\u0001R\"\u0010¯\u0001\u001a\u00030®\u00018\u0000@\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b¯\u0001\u0010°\u0001\u001a\u0006\b±\u0001\u0010²\u0001R3\u0010¶\u0001\u001a\u0004\u0018\u00010a2\b\u0010[\u001a\u0004\u0018\u00010a8@@@X\u0080\u008e\u0002¢\u0006\u0015\n\u0005\b³\u0001\u0010]\u001a\u0005\b´\u0001\u0010d\"\u0005\bµ\u0001\u0010fR\u001a\u0010¸\u0001\u001a\u00030·\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R'\u0010º\u0001\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bº\u0001\u0010©\u0001\u001a\u0005\b»\u0001\u00100\"\u0005\b¼\u0001\u0010\u0007R\"\u0010¾\u0001\u001a\u00030½\u00018\u0000@\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b¾\u0001\u0010¿\u0001\u001a\u0006\bÀ\u0001\u0010Á\u0001R\u001b\u0010Ä\u0001\u001a\u0004\u0018\u00010*8V@\u0016X\u0096\u0004¢\u0006\b\u001a\u0006\bÂ\u0001\u0010Ã\u0001R\u0019\u0010Ç\u0001\u001a\u00020\u00138C@\u0002X\u0082\u0004¢\u0006\b\u001a\u0006\bÅ\u0001\u0010Æ\u0001R\u0017\u0010P\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bP\u0010©\u0001R\"\u0010É\u0001\u001a\u00030È\u00018\u0000@\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\bÉ\u0001\u0010Ê\u0001\u001a\u0006\bË\u0001\u0010Ì\u0001R7\u0010Î\u0001\u001a\u00020\u00032\u0007\u0010Í\u0001\u001a\u00020\u00038\u0000@@X\u0081\u000e¢\u0006\u001d\n\u0006\bÎ\u0001\u0010©\u0001\u0012\u0005\bÑ\u0001\u0010\r\u001a\u0005\bÏ\u0001\u00100\"\u0005\bÐ\u0001\u0010\u0007R\u0019\u0010Ò\u0001\u001a\u00020S8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÒ\u0001\u0010Ó\u0001R\u001c\u0010×\u0001\u001a\u0005\u0018\u00010Ô\u00018V@\u0016X\u0096\u0004¢\u0006\b\u001a\u0006\bÕ\u0001\u0010Ö\u0001R#\u0010Ü\u0001\u001a\u0005\u0018\u00010Ø\u00018V@\u0017X\u0097\u0004¢\u0006\u000f\u0012\u0005\bÛ\u0001\u0010\r\u001a\u0006\bÙ\u0001\u0010Ú\u0001R\u0019\u0010Ý\u0001\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÝ\u0001\u0010©\u0001R!\u0010â\u0001\u001a\n\u0012\u0005\u0012\u00030ß\u00010Þ\u00018@@\u0000X\u0080\u0004¢\u0006\b\u001a\u0006\bà\u0001\u0010á\u0001R\"\u0010ã\u0001\u001a\u00030\u0087\u00018\u0000@\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\bã\u0001\u0010\u0089\u0001\u001a\u0006\bä\u0001\u0010\u008b\u0001R\u001a\u0010å\u0001\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bå\u0001\u0010XR\u0019\u0010é\u0001\u001a\u0005\u0018\u00010æ\u00018F@\u0006¢\u0006\b\u001a\u0006\bç\u0001\u0010è\u0001R!\u0010ë\u0001\u001a\n\u0012\u0005\u0012\u00030\u0087\u00010ê\u00018\u0002@\u0002X\u0082\u0004¢\u0006\b\n\u0006\bë\u0001\u0010ì\u0001R\u001c\u0010ð\u0001\u001a\u0005\u0018\u00010í\u00018B@\u0002X\u0082\u0004¢\u0006\b\u001a\u0006\bî\u0001\u0010ï\u0001¨\u0006ù\u0001"}, d2 = {"Lcom/stripe/android/view/CardMultilineWidget;", "Landroid/widget/LinearLayout;", "Lcom/stripe/android/view/CardWidget;", "", "shouldShowPostalCode", "Lm0/i;", "adjustViewForPostalCodeAttribute", "(Z)V", "Landroid/util/AttributeSet;", UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY, "checkAttributeSet", "(Landroid/util/AttributeSet;)V", "flipToCvcIconIfNotFinished", "()V", "initDeleteEmptyListeners", "initFocusChangeListeners", "initTextInputLayoutErrorHandlers", "updateBrandUi", "updateCvc", "", "iconResourceId", "shouldTint", "updateCardNumberIcon", "(IZ)V", "Landroid/graphics/drawable/Drawable;", "drawable", "updateCompoundDrawable", "(Landroid/graphics/drawable/Drawable;)V", "onAttachedToWindow", "clear", "Lcom/stripe/android/view/CardInputListener;", "listener", "setCardInputListener", "(Lcom/stripe/android/view/CardInputListener;)V", "Lcom/stripe/android/view/CardValidCallback;", "callback", "setCardValidCallback", "(Lcom/stripe/android/view/CardValidCallback;)V", "", "cardHint", "setCardHint", "(Ljava/lang/String;)V", "Lcom/stripe/android/model/PaymentMethodCreateParams$Card;", "card", "populate$payments_core_release", "(Lcom/stripe/android/model/PaymentMethodCreateParams$Card;)V", "populate", "validateAllFields", "()Z", "hasWindowFocus", "onWindowFocusChanged", "cvcPlaceholderText", "setCvcPlaceholderText$payments_core_release", "setCvcPlaceholderText", "cvcLabel", "setCvcLabel", "resId", "setCvcIcon$payments_core_release", "(Ljava/lang/Integer;)V", "setCvcIcon", "setShouldShowPostalCode", "cardNumber", "setCardNumber", "month", "year", "setExpiryDate", "(II)V", "cvcCode", "setCvcCode", "validateCardNumber", "Landroid/text/TextWatcher;", "cardNumberTextWatcher", "setCardNumberTextWatcher", "(Landroid/text/TextWatcher;)V", "expiryDateTextWatcher", "setExpiryDateTextWatcher", "cvcNumberTextWatcher", "setCvcNumberTextWatcher", "postalCodeTextWatcher", "setPostalCodeTextWatcher", "isEnabled", "enabled", "setEnabled", "Lcom/stripe/android/model/CardBrand;", "getBrand$payments_core_release", "()Lcom/stripe/android/model/CardBrand;", AccountRangeJsonParser.FIELD_BRAND, "customCvcLabel", "Ljava/lang/String;", "tintColorInt", "I", "<set-?>", "usZipCodeRequired$delegate", "Lm0/o/d;", "getUsZipCodeRequired", "setUsZipCodeRequired", "usZipCodeRequired", "Lcom/stripe/android/view/StripeEditText$ErrorMessageListener;", "expirationDateErrorListener$delegate", "getExpirationDateErrorListener$payments_core_release", "()Lcom/stripe/android/view/StripeEditText$ErrorMessageListener;", "setExpirationDateErrorListener$payments_core_release", "(Lcom/stripe/android/view/StripeEditText$ErrorMessageListener;)V", "expirationDateErrorListener", "Lcom/stripe/android/view/CvcEditText;", "cvcEditText", "Lcom/stripe/android/view/CvcEditText;", "getCvcEditText$payments_core_release", "()Lcom/stripe/android/view/CvcEditText;", "cardInputListener", "Lcom/stripe/android/view/CardInputListener;", "cvcErrorListener$delegate", "getCvcErrorListener$payments_core_release", "setCvcErrorListener$payments_core_release", "cvcErrorListener", "cardNumberErrorListener$delegate", "getCardNumberErrorListener$payments_core_release", "setCardNumberErrorListener$payments_core_release", "cardNumberErrorListener", "Lcom/stripe/android/model/Card;", "getCard", "()Lcom/stripe/android/model/Card;", "getCard$annotations", "secondRowLayout", "Landroid/widget/LinearLayout;", "getSecondRowLayout$payments_core_release", "()Landroid/widget/LinearLayout;", "Lcom/stripe/android/databinding/CardMultilineWidgetBinding;", "viewBinding", "Lcom/stripe/android/databinding/CardMultilineWidgetBinding;", "", "Lcom/stripe/android/view/StripeEditText;", "getAllFields", "()Ljava/util/Collection;", "allFields", "Lcom/google/android/material/textfield/TextInputLayout;", "expiryTextInputLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "getExpiryTextInputLayout$payments_core_release", "()Lcom/google/android/material/textfield/TextInputLayout;", "cardValidCallback", "Lcom/stripe/android/view/CardValidCallback;", "Lcom/stripe/android/model/PaymentMethod$BillingDetails;", "getPaymentMethodBillingDetails", "()Lcom/stripe/android/model/PaymentMethod$BillingDetails;", "paymentMethodBillingDetails", "Lcom/stripe/android/view/CardNumberEditText;", "cardNumberEditText", "Lcom/stripe/android/view/CardNumberEditText;", "getCardNumberEditText$payments_core_release", "()Lcom/stripe/android/view/CardNumberEditText;", "Lcom/stripe/android/view/CardMultilineWidget$CardBrandIconSupplier;", "cardBrandIconSupplier$delegate", "getCardBrandIconSupplier$payments_core_release", "()Lcom/stripe/android/view/CardMultilineWidget$CardBrandIconSupplier;", "setCardBrandIconSupplier$payments_core_release", "(Lcom/stripe/android/view/CardMultilineWidget$CardBrandIconSupplier;)V", "cardBrandIconSupplier", "postalInputLayout", "getPostalInputLayout$payments_core_release", "expirationDatePlaceholderRes$delegate", "getExpirationDatePlaceholderRes$payments_core_release", "()Ljava/lang/Integer;", "setExpirationDatePlaceholderRes$payments_core_release", "expirationDatePlaceholderRes", "Lcom/stripe/android/cards/CardNumber$Validated;", "getValidatedCardNumber$payments_core_release", "()Lcom/stripe/android/cards/CardNumber$Validated;", "validatedCardNumber", "Z", "Lcom/stripe/android/model/CardParams;", "getCardParams", "()Lcom/stripe/android/model/CardParams;", "cardParams", "Lcom/stripe/android/view/PostalCodeEditText;", "postalCodeEditText", "Lcom/stripe/android/view/PostalCodeEditText;", "getPostalCodeEditText$payments_core_release", "()Lcom/stripe/android/view/PostalCodeEditText;", "postalCodeErrorListener$delegate", "getPostalCodeErrorListener$payments_core_release", "setPostalCodeErrorListener$payments_core_release", "postalCodeErrorListener", "com/stripe/android/view/CardMultilineWidget$cardValidTextWatcher$1", "cardValidTextWatcher", "Lcom/stripe/android/view/CardMultilineWidget$cardValidTextWatcher$1;", "postalCodeRequired", "getPostalCodeRequired", "setPostalCodeRequired", "Lcom/stripe/android/view/CardNumberTextInputLayout;", "cardNumberTextInputLayout", "Lcom/stripe/android/view/CardNumberTextInputLayout;", "getCardNumberTextInputLayout$payments_core_release", "()Lcom/stripe/android/view/CardNumberTextInputLayout;", "getPaymentMethodCard", "()Lcom/stripe/android/model/PaymentMethodCreateParams$Card;", "paymentMethodCard", "getCvcHelperText", "()I", "cvcHelperText", "Lcom/stripe/android/view/ExpiryDateEditText;", "expiryDateEditText", "Lcom/stripe/android/view/ExpiryDateEditText;", "getExpiryDateEditText$payments_core_release", "()Lcom/stripe/android/view/ExpiryDateEditText;", InstabugDbContract.UserAttributesEntry.COLUMN_VALUE, "shouldShowErrorIcon", "getShouldShowErrorIcon$payments_core_release", "setShouldShowErrorIcon$payments_core_release", "getShouldShowErrorIcon$payments_core_release$annotations", "cardBrand", "Lcom/stripe/android/model/CardBrand;", "Lcom/stripe/android/model/PaymentMethodCreateParams;", "getPaymentMethodCreateParams", "()Lcom/stripe/android/model/PaymentMethodCreateParams;", "paymentMethodCreateParams", "Lcom/stripe/android/model/Card$Builder;", "getCardBuilder", "()Lcom/stripe/android/model/Card$Builder;", "getCardBuilder$annotations", "cardBuilder", "showCvcIconInCvcField", "", "Lcom/stripe/android/view/CardValidCallback$Fields;", "getInvalidFields$payments_core_release", "()Ljava/util/Set;", "invalidFields", "cvcInputLayout", "getCvcInputLayout$payments_core_release", "customCvcPlaceholderText", "Lcom/stripe/android/model/PaymentMethod$BillingDetails$Builder;", "getPaymentMethodBillingDetailsBuilder", "()Lcom/stripe/android/model/PaymentMethod$BillingDetails$Builder;", "paymentMethodBillingDetailsBuilder", "", "textInputLayouts", "Ljava/util/List;", "Lcom/stripe/android/model/ExpirationDate$Validated;", "getExpirationDate", "()Lcom/stripe/android/model/ExpirationDate$Validated;", "expirationDate", "Landroid/content/Context;", "context", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IZ)V", "Companion", "CardBrandIcon", "CardBrandIconSupplier", "payments-core_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public final class CardMultilineWidget extends LinearLayout implements CardWidget {
    @Deprecated
    private static final String CARD_MULTILINE_TOKEN = "CardMultilineView";
    private CardBrand cardBrand;
    private final d cardBrandIconSupplier$delegate;
    private CardInputListener cardInputListener;
    private final CardNumberEditText cardNumberEditText;
    private final d cardNumberErrorListener$delegate;
    private final CardNumberTextInputLayout cardNumberTextInputLayout;
    private CardValidCallback cardValidCallback;
    private final CardMultilineWidget$cardValidTextWatcher$1 cardValidTextWatcher;
    private String customCvcLabel;
    private String customCvcPlaceholderText;
    private final CvcEditText cvcEditText;
    private final d cvcErrorListener$delegate;
    private final TextInputLayout cvcInputLayout;
    private final d expirationDateErrorListener$delegate;
    private final d expirationDatePlaceholderRes$delegate;
    private final ExpiryDateEditText expiryDateEditText;
    private final TextInputLayout expiryTextInputLayout;
    private boolean isEnabled;
    private final PostalCodeEditText postalCodeEditText;
    private final d postalCodeErrorListener$delegate;
    private boolean postalCodeRequired;
    private final TextInputLayout postalInputLayout;
    private final LinearLayout secondRowLayout;
    private boolean shouldShowErrorIcon;
    private boolean shouldShowPostalCode;
    private boolean showCvcIconInCvcField;
    private final List<TextInputLayout> textInputLayouts;
    private final int tintColorInt;
    private final d usZipCodeRequired$delegate;
    private final CardMultilineWidgetBinding viewBinding;
    public static final /* synthetic */ k[] $$delegatedProperties = {a.o1(CardMultilineWidget.class, "usZipCodeRequired", "getUsZipCodeRequired()Z", 0), a.o1(CardMultilineWidget.class, "expirationDatePlaceholderRes", "getExpirationDatePlaceholderRes$payments_core_release()Ljava/lang/Integer;", 0), a.o1(CardMultilineWidget.class, "cardBrandIconSupplier", "getCardBrandIconSupplier$payments_core_release()Lcom/stripe/android/view/CardMultilineWidget$CardBrandIconSupplier;", 0), a.o1(CardMultilineWidget.class, "cardNumberErrorListener", "getCardNumberErrorListener$payments_core_release()Lcom/stripe/android/view/StripeEditText$ErrorMessageListener;", 0), a.o1(CardMultilineWidget.class, "expirationDateErrorListener", "getExpirationDateErrorListener$payments_core_release()Lcom/stripe/android/view/StripeEditText$ErrorMessageListener;", 0), a.o1(CardMultilineWidget.class, "cvcErrorListener", "getCvcErrorListener$payments_core_release()Lcom/stripe/android/view/StripeEditText$ErrorMessageListener;", 0), a.o1(CardMultilineWidget.class, "postalCodeErrorListener", "getPostalCodeErrorListener$payments_core_release()Lcom/stripe/android/view/StripeEditText$ErrorMessageListener;", 0)};
    private static final Companion Companion = new Companion(null);
    @Deprecated
    private static final CardBrandIconSupplier DEFAULT_CARD_BRAND_ICON_SUPPLIER = CardMultilineWidget$Companion$DEFAULT_CARD_BRAND_ICON_SUPPLIER$1.INSTANCE;

    /* compiled from: CardMultilineWidget.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\b\u0080\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0014\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/stripe/android/view/CardMultilineWidget$CardBrandIcon;", "", "", "component1", "()I", "", "component2", "()Z", "iconResourceId", "shouldTint", "copy", "(IZ)Lcom/stripe/android/view/CardMultilineWidget$CardBrandIcon;", "", "toString", "()Ljava/lang/String;", "hashCode", RecaptchaActionType.OTHER, "equals", "(Ljava/lang/Object;)Z", "Z", "getShouldTint", "I", "getIconResourceId", "<init>", "(IZ)V", "payments-core_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes4.dex */
    public static final class CardBrandIcon {
        private final int iconResourceId;
        private final boolean shouldTint;

        public CardBrandIcon(int i, boolean z) {
            this.iconResourceId = i;
            this.shouldTint = z;
        }

        public static /* synthetic */ CardBrandIcon copy$default(CardBrandIcon cardBrandIcon, int i, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = cardBrandIcon.iconResourceId;
            }
            if ((i2 & 2) != 0) {
                z = cardBrandIcon.shouldTint;
            }
            return cardBrandIcon.copy(i, z);
        }

        public final int component1() {
            return this.iconResourceId;
        }

        public final boolean component2() {
            return this.shouldTint;
        }

        public final CardBrandIcon copy(int i, boolean z) {
            return new CardBrandIcon(i, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CardBrandIcon)) {
                return false;
            }
            CardBrandIcon cardBrandIcon = (CardBrandIcon) obj;
            return this.iconResourceId == cardBrandIcon.iconResourceId && this.shouldTint == cardBrandIcon.shouldTint;
        }

        public final int getIconResourceId() {
            return this.iconResourceId;
        }

        public final boolean getShouldTint() {
            return this.shouldTint;
        }

        public int hashCode() {
            int hashCode = Integer.hashCode(this.iconResourceId) * 31;
            boolean z = this.shouldTint;
            if (z) {
                z = true;
            }
            int i = z ? 1 : 0;
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            return hashCode + i;
        }

        public String toString() {
            StringBuilder P0 = a.P0("CardBrandIcon(iconResourceId=");
            P0.append(this.iconResourceId);
            P0.append(", shouldTint=");
            return a.D0(P0, this.shouldTint, ")");
        }

        public /* synthetic */ CardBrandIcon(int i, boolean z, int i2, f fVar) {
            this(i, (i2 & 2) != 0 ? false : z);
        }
    }

    /* compiled from: CardMultilineWidget.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bà\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/view/CardMultilineWidget$CardBrandIconSupplier;", "", "Lcom/stripe/android/model/CardBrand;", "cardBrand", "Lcom/stripe/android/view/CardMultilineWidget$CardBrandIcon;", "get", "(Lcom/stripe/android/model/CardBrand;)Lcom/stripe/android/view/CardMultilineWidget$CardBrandIcon;", "payments-core_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes4.dex */
    public interface CardBrandIconSupplier {
        CardBrandIcon get(CardBrand cardBrand);
    }

    /* compiled from: CardMultilineWidget.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/stripe/android/view/CardMultilineWidget$Companion;", "", "", "CARD_MULTILINE_TOKEN", "Ljava/lang/String;", "Lcom/stripe/android/view/CardMultilineWidget$CardBrandIconSupplier;", "DEFAULT_CARD_BRAND_ICON_SUPPLIER", "Lcom/stripe/android/view/CardMultilineWidget$CardBrandIconSupplier;", "<init>", "()V", "payments-core_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public CardMultilineWidget(Context context) {
        this(context, null, 0, false, 14, null);
    }

    public CardMultilineWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, false, 12, null);
    }

    public CardMultilineWidget(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, false, 8, null);
    }

    public /* synthetic */ CardMultilineWidget(Context context, AttributeSet attributeSet, int i, boolean z, int i2, f fVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? true : z);
    }

    private final void adjustViewForPostalCodeAttribute(boolean z) {
        int i;
        if (z) {
            i = R.string.expiry_label_short;
        } else {
            i = R.string.acc_label_expiry_date;
        }
        this.expiryTextInputLayout.setHint(getResources().getString(i));
        int i2 = z ? R.id.et_postal_code : -1;
        this.cvcEditText.setNextFocusForwardId(i2);
        this.cvcEditText.setNextFocusDownId(i2);
        int i3 = 0;
        int i4 = z ? 0 : 8;
        this.postalInputLayout.setVisibility(i4);
        this.cvcEditText.setImeOptions(i4 == 8 ? 6 : 5);
        TextInputLayout textInputLayout = this.cvcInputLayout;
        ViewGroup.LayoutParams layoutParams = textInputLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        if (z) {
            i3 = getResources().getDimensionPixelSize(R.dimen.stripe_add_card_expiry_middle_margin);
        }
        layoutParams2.setMarginEnd(i3);
        textInputLayout.setLayoutParams(layoutParams2);
    }

    private final void checkAttributeSet(AttributeSet attributeSet) {
        Context context = getContext();
        i.d(context, "context");
        int[] iArr = R.styleable.CardElement;
        i.d(iArr, "R.styleable.CardElement");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        this.shouldShowPostalCode = obtainStyledAttributes.getBoolean(R.styleable.CardElement_shouldShowPostalCode, this.shouldShowPostalCode);
        this.postalCodeRequired = obtainStyledAttributes.getBoolean(R.styleable.CardElement_shouldRequirePostalCode, this.postalCodeRequired);
        setUsZipCodeRequired(obtainStyledAttributes.getBoolean(R.styleable.CardElement_shouldRequireUsZipCode, getUsZipCodeRequired()));
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void flipToCvcIconIfNotFinished() {
        if (!this.cardBrand.isMaxCvc(this.cvcEditText.getFieldText$payments_core_release())) {
            if (this.shouldShowErrorIcon) {
                updateCardNumberIcon(this.cardBrand.getErrorIcon(), false);
            } else {
                updateCardNumberIcon(this.cardBrand.getCvcIcon(), true);
            }
        }
    }

    private final Collection<StripeEditText> getAllFields() {
        return g.K(this.cardNumberEditText, this.expiryDateEditText, this.cvcEditText, this.postalCodeEditText);
    }

    public static /* synthetic */ void getCard$annotations() {
    }

    public static /* synthetic */ void getCardBuilder$annotations() {
    }

    private final int getCvcHelperText() {
        if (CardBrand.AmericanExpress == this.cardBrand) {
            return R.string.cvc_multiline_helper_amex;
        }
        return R.string.cvc_multiline_helper;
    }

    private final ExpirationDate.Validated getExpirationDate() {
        return this.expiryDateEditText.getValidatedDate();
    }

    public static /* synthetic */ void getShouldShowErrorIcon$payments_core_release$annotations() {
    }

    private final void initDeleteEmptyListeners() {
        this.expiryDateEditText.setDeleteEmptyListener(new BackUpFieldDeleteListener(this.cardNumberEditText));
        this.cvcEditText.setDeleteEmptyListener(new BackUpFieldDeleteListener(this.expiryDateEditText));
        this.postalCodeEditText.setDeleteEmptyListener(new BackUpFieldDeleteListener(this.cvcEditText));
    }

    private final void initFocusChangeListeners() {
        this.cardNumberEditText.getInternalFocusChangeListeners$payments_core_release().add(new View.OnFocusChangeListener() { // from class: com.stripe.android.view.CardMultilineWidget$initFocusChangeListeners$1
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                CardInputListener cardInputListener;
                if (z && (cardInputListener = CardMultilineWidget.this.cardInputListener) != null) {
                    cardInputListener.onFocusChange(CardInputListener.FocusField.CardNumber);
                }
            }
        });
        this.expiryDateEditText.getInternalFocusChangeListeners$payments_core_release().add(new View.OnFocusChangeListener() { // from class: com.stripe.android.view.CardMultilineWidget$initFocusChangeListeners$2
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                CardInputListener cardInputListener;
                if (z && (cardInputListener = CardMultilineWidget.this.cardInputListener) != null) {
                    cardInputListener.onFocusChange(CardInputListener.FocusField.ExpiryDate);
                }
            }
        });
        this.cvcEditText.getInternalFocusChangeListeners$payments_core_release().add(new View.OnFocusChangeListener() { // from class: com.stripe.android.view.CardMultilineWidget$initFocusChangeListeners$3
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    if (!CardMultilineWidget.this.showCvcIconInCvcField) {
                        CardMultilineWidget.this.flipToCvcIconIfNotFinished();
                    }
                    CardInputListener cardInputListener = CardMultilineWidget.this.cardInputListener;
                    if (cardInputListener != null) {
                        cardInputListener.onFocusChange(CardInputListener.FocusField.Cvc);
                        return;
                    }
                    return;
                }
                CardMultilineWidget.this.updateBrandUi();
            }
        });
        this.postalCodeEditText.getInternalFocusChangeListeners$payments_core_release().add(new View.OnFocusChangeListener() { // from class: com.stripe.android.view.CardMultilineWidget$initFocusChangeListeners$4
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                CardInputListener cardInputListener;
                if (CardMultilineWidget.this.shouldShowPostalCode && z && (cardInputListener = CardMultilineWidget.this.cardInputListener) != null) {
                    cardInputListener.onFocusChange(CardInputListener.FocusField.PostalCode);
                }
            }
        });
    }

    private final void initTextInputLayoutErrorHandlers() {
        this.cardNumberEditText.setErrorMessageListener(getCardNumberErrorListener$payments_core_release());
        this.expiryDateEditText.setErrorMessageListener(getExpirationDateErrorListener$payments_core_release());
        this.cvcEditText.setErrorMessageListener(getCvcErrorListener$payments_core_release());
        this.postalCodeEditText.setErrorMessageListener(getPostalCodeErrorListener$payments_core_release());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateBrandUi() {
        updateCvc();
        if (this.shouldShowErrorIcon) {
            updateCardNumberIcon(this.cardBrand.getErrorIcon(), false);
            return;
        }
        CardBrandIcon cardBrandIcon = getCardBrandIconSupplier$payments_core_release().get(this.cardBrand);
        updateCardNumberIcon(cardBrandIcon.getIconResourceId(), cardBrandIcon.getShouldTint());
    }

    private final void updateCardNumberIcon(int i, boolean z) {
        Drawable drawable = h0.i.b.a.getDrawable(getContext(), i);
        if (drawable != null) {
            if (z) {
                drawable.setTint(this.tintColorInt);
            }
            i.d(drawable, "if (shouldTint) {\n      …   icon\n                }");
            updateCompoundDrawable(drawable);
        }
    }

    private final void updateCompoundDrawable(Drawable drawable) {
        this.cardNumberEditText.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
    }

    private final void updateCvc() {
        this.cvcEditText.updateBrand$payments_core_release(this.cardBrand, this.customCvcLabel, this.customCvcPlaceholderText, this.cvcInputLayout);
    }

    @Override // com.stripe.android.view.CardWidget
    public void clear() {
        this.cardNumberEditText.setText("");
        this.expiryDateEditText.setText("");
        this.cvcEditText.setText("");
        this.postalCodeEditText.setText("");
        this.cardNumberEditText.setShouldShowError(false);
        this.expiryDateEditText.setShouldShowError(false);
        this.cvcEditText.setShouldShowError(false);
        this.postalCodeEditText.setShouldShowError(false);
        this.cardBrand = CardBrand.Unknown;
        updateBrandUi();
    }

    public final /* synthetic */ CardBrand getBrand$payments_core_release() {
        return this.cardBrand;
    }

    @Override // com.stripe.android.view.CardWidget
    public Card getCard() {
        Card.Builder cardBuilder = getCardBuilder();
        if (cardBuilder != null) {
            return cardBuilder.build();
        }
        return null;
    }

    public final CardBrandIconSupplier getCardBrandIconSupplier$payments_core_release() {
        return (CardBrandIconSupplier) this.cardBrandIconSupplier$delegate.getValue(this, $$delegatedProperties[2]);
    }

    @Override // com.stripe.android.view.CardWidget
    public Card.Builder getCardBuilder() {
        String str = null;
        if (!validateAllFields()) {
            setShouldShowErrorIcon$payments_core_release(true);
            return null;
        }
        setShouldShowErrorIcon$payments_core_release(false);
        ExpirationDate.Validated validatedDate = this.expiryDateEditText.getValidatedDate();
        if (validatedDate != null) {
            Editable text = this.cvcEditText.getText();
            String obj = text != null ? text.toString() : null;
            Editable text2 = this.postalCodeEditText.getText();
            String obj2 = text2 != null ? text2.toString() : null;
            if (!this.shouldShowPostalCode) {
                obj2 = null;
            }
            CardNumber.Validated validatedCardNumber$payments_core_release = getValidatedCardNumber$payments_core_release();
            if (validatedCardNumber$payments_core_release != null) {
                str = validatedCardNumber$payments_core_release.getValue$payments_core_release();
            }
            return new Card.Builder(str, Integer.valueOf(validatedDate.getMonth()), Integer.valueOf(validatedDate.getYear()), obj).addressZip(obj2).loggingTokens(h.N3(CARD_MULTILINE_TOKEN));
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final CardNumberEditText getCardNumberEditText$payments_core_release() {
        return this.cardNumberEditText;
    }

    public final StripeEditText.ErrorMessageListener getCardNumberErrorListener$payments_core_release() {
        return (StripeEditText.ErrorMessageListener) this.cardNumberErrorListener$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final CardNumberTextInputLayout getCardNumberTextInputLayout$payments_core_release() {
        return this.cardNumberTextInputLayout;
    }

    @Override // com.stripe.android.view.CardWidget
    public CardParams getCardParams() {
        boolean z = true;
        String str = null;
        if (!validateAllFields()) {
            setShouldShowErrorIcon$payments_core_release(true);
            return null;
        }
        setShouldShowErrorIcon$payments_core_release(false);
        ExpirationDate.Validated validatedDate = this.expiryDateEditText.getValidatedDate();
        if (validatedDate != null) {
            Editable text = this.cvcEditText.getText();
            String obj = text != null ? text.toString() : null;
            Editable text2 = this.postalCodeEditText.getText();
            String obj2 = text2 != null ? text2.toString() : null;
            if (!this.shouldShowPostalCode) {
                obj2 = null;
            }
            CardBrand brand$payments_core_release = getBrand$payments_core_release();
            Set N3 = h.N3(CARD_MULTILINE_TOKEN);
            CardNumber.Validated validatedCardNumber$payments_core_release = getValidatedCardNumber$payments_core_release();
            String value$payments_core_release = validatedCardNumber$payments_core_release != null ? validatedCardNumber$payments_core_release.getValue$payments_core_release() : null;
            if (value$payments_core_release == null) {
                value$payments_core_release = "";
            }
            int month = validatedDate.getMonth();
            int year = validatedDate.getYear();
            Address.Builder builder = new Address.Builder();
            if (obj2 != null && !StringsKt__IndentKt.o(obj2)) {
                z = false;
            }
            if (!z) {
                str = obj2;
            }
            return new CardParams(brand$payments_core_release, N3, value$payments_core_release, month, year, obj, null, builder.setPostalCode(str).build(), null, null, 832, null);
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final CvcEditText getCvcEditText$payments_core_release() {
        return this.cvcEditText;
    }

    public final StripeEditText.ErrorMessageListener getCvcErrorListener$payments_core_release() {
        return (StripeEditText.ErrorMessageListener) this.cvcErrorListener$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final TextInputLayout getCvcInputLayout$payments_core_release() {
        return this.cvcInputLayout;
    }

    public final StripeEditText.ErrorMessageListener getExpirationDateErrorListener$payments_core_release() {
        return (StripeEditText.ErrorMessageListener) this.expirationDateErrorListener$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final Integer getExpirationDatePlaceholderRes$payments_core_release() {
        return (Integer) this.expirationDatePlaceholderRes$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final ExpiryDateEditText getExpiryDateEditText$payments_core_release() {
        return this.expiryDateEditText;
    }

    public final TextInputLayout getExpiryTextInputLayout$payments_core_release() {
        return this.expiryTextInputLayout;
    }

    public final Set<CardValidCallback.Fields> getInvalidFields$payments_core_release() {
        CardValidCallback.Fields[] fieldsArr = new CardValidCallback.Fields[3];
        CardValidCallback.Fields fields = CardValidCallback.Fields.Number;
        boolean z = true;
        CardValidCallback.Fields fields2 = null;
        if (!(getValidatedCardNumber$payments_core_release() == null)) {
            fields = null;
        }
        fieldsArr[0] = fields;
        CardValidCallback.Fields fields3 = CardValidCallback.Fields.Expiry;
        if (!(getExpirationDate() == null)) {
            fields3 = null;
        }
        fieldsArr[1] = fields3;
        CardValidCallback.Fields fields4 = CardValidCallback.Fields.Cvc;
        if (this.cvcEditText.getCvc$payments_core_release() != null) {
            z = false;
        }
        if (z) {
            fields2 = fields4;
        }
        fieldsArr[2] = fields2;
        return g.D0(g.M(fieldsArr));
    }

    public final PaymentMethod.BillingDetails getPaymentMethodBillingDetails() {
        PaymentMethod.BillingDetails.Builder paymentMethodBillingDetailsBuilder = getPaymentMethodBillingDetailsBuilder();
        if (paymentMethodBillingDetailsBuilder != null) {
            return paymentMethodBillingDetailsBuilder.build();
        }
        return null;
    }

    public final PaymentMethod.BillingDetails.Builder getPaymentMethodBillingDetailsBuilder() {
        if (!this.shouldShowPostalCode || !validateAllFields()) {
            return null;
        }
        return new PaymentMethod.BillingDetails.Builder().setAddress(new Address.Builder().setPostalCode(this.postalCodeEditText.getPostalCode$payments_core_release()).build());
    }

    @Override // com.stripe.android.view.CardWidget
    public PaymentMethodCreateParams.Card getPaymentMethodCard() {
        CardParams cardParams = getCardParams();
        if (cardParams == null) {
            return null;
        }
        return new PaymentMethodCreateParams.Card(cardParams.getNumber$payments_core_release(), Integer.valueOf(cardParams.getExpMonth$payments_core_release()), Integer.valueOf(cardParams.getExpYear$payments_core_release()), cardParams.getCvc$payments_core_release(), null, cardParams.getAttribution$payments_core_release(), 16, null);
    }

    @Override // com.stripe.android.view.CardWidget
    public PaymentMethodCreateParams getPaymentMethodCreateParams() {
        PaymentMethodCreateParams.Card paymentMethodCard = getPaymentMethodCard();
        if (paymentMethodCard != null) {
            return PaymentMethodCreateParams.Companion.create$default(PaymentMethodCreateParams.Companion, paymentMethodCard, getPaymentMethodBillingDetails(), (Map) null, 4, (Object) null);
        }
        return null;
    }

    public final PostalCodeEditText getPostalCodeEditText$payments_core_release() {
        return this.postalCodeEditText;
    }

    public final StripeEditText.ErrorMessageListener getPostalCodeErrorListener$payments_core_release() {
        return (StripeEditText.ErrorMessageListener) this.postalCodeErrorListener$delegate.getValue(this, $$delegatedProperties[6]);
    }

    public final boolean getPostalCodeRequired() {
        return this.postalCodeRequired;
    }

    public final TextInputLayout getPostalInputLayout$payments_core_release() {
        return this.postalInputLayout;
    }

    public final LinearLayout getSecondRowLayout$payments_core_release() {
        return this.secondRowLayout;
    }

    public final boolean getShouldShowErrorIcon$payments_core_release() {
        return this.shouldShowErrorIcon;
    }

    public final boolean getUsZipCodeRequired() {
        return ((Boolean) this.usZipCodeRequired$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final CardNumber.Validated getValidatedCardNumber$payments_core_release() {
        return this.cardNumberEditText.getValidatedCardNumber$payments_core_release();
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return this.isEnabled;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.postalCodeEditText.setConfig$payments_core_release(PostalCodeEditText.Config.Global);
        this.cvcEditText.setHint((CharSequence) null);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            updateBrandUi();
        }
    }

    public final void populate$payments_core_release(PaymentMethodCreateParams.Card card) {
        if (card != null) {
            View findFocus = findFocus();
            this.cardNumberEditText.setText(card.getNumber$payments_core_release());
            this.cvcEditText.setText(card.getCvc$payments_core_release());
            this.expiryDateEditText.setText$payments_core_release(card.getExpiryMonth$payments_core_release(), card.getExpiryYear$payments_core_release());
            if (findFocus != null) {
                findFocus.requestFocus();
                return;
            }
            View findFocus2 = findFocus();
            if (findFocus2 != null) {
                findFocus2.clearFocus();
            }
        }
    }

    public final void setCardBrandIconSupplier$payments_core_release(CardBrandIconSupplier cardBrandIconSupplier) {
        i.e(cardBrandIconSupplier, "<set-?>");
        this.cardBrandIconSupplier$delegate.setValue(this, $$delegatedProperties[2], cardBrandIconSupplier);
    }

    @Override // com.stripe.android.view.CardWidget
    public void setCardHint(String str) {
        i.e(str, "cardHint");
        this.cardNumberTextInputLayout.setPlaceholderText(str);
    }

    @Override // com.stripe.android.view.CardWidget
    public void setCardInputListener(CardInputListener cardInputListener) {
        this.cardInputListener = cardInputListener;
    }

    @Override // com.stripe.android.view.CardWidget
    public void setCardNumber(String str) {
        this.cardNumberEditText.setText(str);
    }

    public final void setCardNumberErrorListener$payments_core_release(StripeEditText.ErrorMessageListener errorMessageListener) {
        i.e(errorMessageListener, "<set-?>");
        this.cardNumberErrorListener$delegate.setValue(this, $$delegatedProperties[3], errorMessageListener);
    }

    @Override // com.stripe.android.view.CardWidget
    public void setCardNumberTextWatcher(TextWatcher textWatcher) {
        this.cardNumberEditText.addTextChangedListener(textWatcher);
    }

    @Override // com.stripe.android.view.CardWidget
    public void setCardValidCallback(CardValidCallback cardValidCallback) {
        this.cardValidCallback = cardValidCallback;
        for (StripeEditText stripeEditText : getAllFields()) {
            stripeEditText.removeTextChangedListener(this.cardValidTextWatcher);
        }
        if (cardValidCallback != null) {
            for (StripeEditText stripeEditText2 : getAllFields()) {
                stripeEditText2.addTextChangedListener(this.cardValidTextWatcher);
            }
        }
        CardValidCallback cardValidCallback2 = this.cardValidCallback;
        if (cardValidCallback2 != null) {
            cardValidCallback2.onInputChanged(getInvalidFields$payments_core_release().isEmpty(), getInvalidFields$payments_core_release());
        }
    }

    @Override // com.stripe.android.view.CardWidget
    public void setCvcCode(String str) {
        this.cvcEditText.setText(str);
    }

    public final void setCvcErrorListener$payments_core_release(StripeEditText.ErrorMessageListener errorMessageListener) {
        i.e(errorMessageListener, "<set-?>");
        this.cvcErrorListener$delegate.setValue(this, $$delegatedProperties[5], errorMessageListener);
    }

    public final /* synthetic */ void setCvcIcon$payments_core_release(Integer num) {
        boolean z = false;
        if (num != null) {
            this.cvcInputLayout.setEndIconDrawable(num.intValue());
            this.cvcInputLayout.setEndIconMode(-1);
        } else {
            this.cvcInputLayout.setEndIconDrawable(0);
            this.cvcInputLayout.setEndIconMode(0);
        }
        if (num != null) {
            z = true;
        }
        this.showCvcIconInCvcField = z;
    }

    public final void setCvcLabel(String str) {
        this.customCvcLabel = str;
        updateCvc();
    }

    @Override // com.stripe.android.view.CardWidget
    public void setCvcNumberTextWatcher(TextWatcher textWatcher) {
        this.cvcEditText.addTextChangedListener(textWatcher);
    }

    public final void setCvcPlaceholderText$payments_core_release(String str) {
        this.customCvcPlaceholderText = str;
        updateCvc();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        for (TextInputLayout textInputLayout : this.textInputLayouts) {
            textInputLayout.setEnabled(z);
        }
        this.isEnabled = z;
    }

    public final void setExpirationDateErrorListener$payments_core_release(StripeEditText.ErrorMessageListener errorMessageListener) {
        i.e(errorMessageListener, "<set-?>");
        this.expirationDateErrorListener$delegate.setValue(this, $$delegatedProperties[4], errorMessageListener);
    }

    public final void setExpirationDatePlaceholderRes$payments_core_release(Integer num) {
        this.expirationDatePlaceholderRes$delegate.setValue(this, $$delegatedProperties[1], num);
    }

    @Override // com.stripe.android.view.CardWidget
    public void setExpiryDate(int i, int i2) {
        this.expiryDateEditText.setText(new ExpirationDate.Unvalidated(i, i2).getDisplayString());
    }

    @Override // com.stripe.android.view.CardWidget
    public void setExpiryDateTextWatcher(TextWatcher textWatcher) {
        this.expiryDateEditText.addTextChangedListener(textWatcher);
    }

    public final void setPostalCodeErrorListener$payments_core_release(StripeEditText.ErrorMessageListener errorMessageListener) {
        this.postalCodeErrorListener$delegate.setValue(this, $$delegatedProperties[6], errorMessageListener);
    }

    public final void setPostalCodeRequired(boolean z) {
        this.postalCodeRequired = z;
    }

    @Override // com.stripe.android.view.CardWidget
    public void setPostalCodeTextWatcher(TextWatcher textWatcher) {
        this.postalCodeEditText.addTextChangedListener(textWatcher);
    }

    public final void setShouldShowErrorIcon$payments_core_release(boolean z) {
        boolean z2 = this.shouldShowErrorIcon != z;
        this.shouldShowErrorIcon = z;
        if (z2) {
            updateBrandUi();
        }
    }

    public final void setShouldShowPostalCode(boolean z) {
        this.shouldShowPostalCode = z;
        adjustViewForPostalCodeAttribute(z);
    }

    public final void setUsZipCodeRequired(boolean z) {
        this.usZipCodeRequired$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    /*  JADX ERROR: IF instruction can be used only in fallback mode
        jadx.core.utils.exceptions.CodegenException: IF instruction can be used only in fallback mode
        	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:636)
        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:505)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:174)
        	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:173)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
        	at jadx.core.dex.regions.Region.generate(Region.java:35)
        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:270)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
        */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0076 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final boolean validateAllFields() {
        /*
            r8 = this;
            com.stripe.android.cards.CardNumber$Validated r0 = r8.getValidatedCardNumber$payments_core_release()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x000a
            r0 = r2
            goto L_0x000b
        L_0x000a:
            r0 = r1
        L_0x000b:
            com.stripe.android.model.ExpirationDate$Validated r3 = r8.getExpirationDate()
            if (r3 == 0) goto L_0x0013
            r3 = r2
            goto L_0x0014
        L_0x0013:
            r3 = r1
        L_0x0014:
            com.stripe.android.view.CvcEditText r4 = r8.cvcEditText
            com.stripe.android.cards.Cvc$Validated r4 = r4.getCvc$payments_core_release()
            if (r4 == 0) goto L_0x001e
            r4 = r2
            goto L_0x001f
        L_0x001e:
            r4 = r1
        L_0x001f:
            com.stripe.android.view.CardNumberEditText r5 = r8.cardNumberEditText
            r6 = r0 ^ 1
            r5.setShouldShowError(r6)
            com.stripe.android.view.ExpiryDateEditText r5 = r8.expiryDateEditText
            r6 = r3 ^ 1
            r5.setShouldShowError(r6)
            com.stripe.android.view.CvcEditText r5 = r8.cvcEditText
            r6 = r4 ^ 1
            r5.setShouldShowError(r6)
            com.stripe.android.view.PostalCodeEditText r5 = r8.postalCodeEditText
            boolean r6 = r8.postalCodeRequired
            if (r6 != 0) goto L_0x0040
            boolean r6 = r8.getUsZipCodeRequired()
            if (r6 == 0) goto L_0x0056
        L_0x0040:
            com.stripe.android.view.PostalCodeEditText r6 = r8.postalCodeEditText
            java.lang.String r6 = r6.getPostalCode$payments_core_release()
            if (r6 == 0) goto L_0x0051
            boolean r6 = kotlin.text.StringsKt__IndentKt.o(r6)
            if (r6 == 0) goto L_0x004f
            goto L_0x0051
        L_0x004f:
            r6 = r1
            goto L_0x0052
        L_0x0051:
            r6 = r2
        L_0x0052:
            if (r6 == 0) goto L_0x0056
            r6 = r2
            goto L_0x0057
        L_0x0056:
            r6 = r1
        L_0x0057:
            r5.setShouldShowError(r6)
            java.util.Collection r5 = r8.getAllFields()
            java.util.Iterator r5 = r5.iterator()
        L_0x0062:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0076
            java.lang.Object r6 = r5.next()
            r7 = r6
            com.stripe.android.view.StripeEditText r7 = (com.stripe.android.view.StripeEditText) r7
            boolean r7 = r7.getShouldShowError()
            if (r7 == 0) goto L_0x0062
            goto L_0x0077
        L_0x0076:
            r6 = 0
        L_0x0077:
            com.stripe.android.view.StripeEditText r6 = (com.stripe.android.view.StripeEditText) r6
            if (r6 == 0) goto L_0x007e
            r6.requestFocus()
        L_0x007e:
            if (r0 == 0) goto L_0x008d
            if (r3 == 0) goto L_0x008d
            if (r4 == 0) goto L_0x008d
            com.stripe.android.view.PostalCodeEditText r0 = r8.postalCodeEditText
            boolean r0 = r0.getShouldShowError()
            if (r0 != 0) goto L_0x008d
            r1 = r2
        L_0x008d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.view.CardMultilineWidget.validateAllFields():boolean");
    }

    public final boolean validateCardNumber() {
        boolean z = getValidatedCardNumber$payments_core_release() != null;
        this.cardNumberEditText.setShouldShowError(!z);
        return z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardMultilineWidget(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, i);
        i.e(context, "context");
        this.shouldShowPostalCode = z;
        CardMultilineWidgetBinding inflate = CardMultilineWidgetBinding.inflate(LayoutInflater.from(context), this);
        i.d(inflate, "CardMultilineWidgetBindi…text),\n        this\n    )");
        this.viewBinding = inflate;
        CardNumberEditText cardNumberEditText = inflate.etCardNumber;
        i.d(cardNumberEditText, "viewBinding.etCardNumber");
        this.cardNumberEditText = cardNumberEditText;
        ExpiryDateEditText expiryDateEditText = inflate.etExpiry;
        i.d(expiryDateEditText, "viewBinding.etExpiry");
        this.expiryDateEditText = expiryDateEditText;
        CvcEditText cvcEditText = inflate.etCvc;
        i.d(cvcEditText, "viewBinding.etCvc");
        this.cvcEditText = cvcEditText;
        PostalCodeEditText postalCodeEditText = inflate.etPostalCode;
        i.d(postalCodeEditText, "viewBinding.etPostalCode");
        this.postalCodeEditText = postalCodeEditText;
        LinearLayout linearLayout = inflate.secondRowLayout;
        i.d(linearLayout, "viewBinding.secondRowLayout");
        this.secondRowLayout = linearLayout;
        CardNumberTextInputLayout cardNumberTextInputLayout = inflate.tlCardNumber;
        i.d(cardNumberTextInputLayout, "viewBinding.tlCardNumber");
        this.cardNumberTextInputLayout = cardNumberTextInputLayout;
        TextInputLayout textInputLayout = inflate.tlExpiry;
        i.d(textInputLayout, "viewBinding.tlExpiry");
        this.expiryTextInputLayout = textInputLayout;
        TextInputLayout textInputLayout2 = inflate.tlCvc;
        i.d(textInputLayout2, "viewBinding.tlCvc");
        this.cvcInputLayout = textInputLayout2;
        TextInputLayout textInputLayout3 = inflate.tlPostalCode;
        i.d(textInputLayout3, "viewBinding.tlPostalCode");
        this.postalInputLayout = textInputLayout3;
        List<TextInputLayout> K = g.K(cardNumberTextInputLayout, textInputLayout, textInputLayout2, textInputLayout3);
        this.textInputLayouts = K;
        this.cardValidTextWatcher = new CardMultilineWidget$cardValidTextWatcher$1(this);
        this.cardBrand = CardBrand.Unknown;
        Boolean bool = Boolean.FALSE;
        this.usZipCodeRequired$delegate = new b<Boolean>(bool, bool, this) { // from class: com.stripe.android.view.CardMultilineWidget$$special$$inlined$observable$1
            public final /* synthetic */ Object $initialValue;
            public final /* synthetic */ CardMultilineWidget this$0;

            {
                this.$initialValue = r1;
                this.this$0 = r3;
            }

            @Override // m0.o.b
            public void afterChange(k<?> kVar, Boolean bool2, Boolean bool3) {
                i.e(kVar, "property");
                boolean booleanValue = bool3.booleanValue();
                bool2.booleanValue();
                if (booleanValue) {
                    this.this$0.getPostalCodeEditText$payments_core_release().setConfig$payments_core_release(PostalCodeEditText.Config.US);
                } else {
                    this.this$0.getPostalCodeEditText$payments_core_release().setConfig$payments_core_release(PostalCodeEditText.Config.Global);
                }
            }
        };
        Integer valueOf = Integer.valueOf(R.string.expiry_date_hint);
        this.expirationDatePlaceholderRes$delegate = new b<Integer>(valueOf, valueOf, this) { // from class: com.stripe.android.view.CardMultilineWidget$$special$$inlined$observable$2
            public final /* synthetic */ Object $initialValue;
            public final /* synthetic */ CardMultilineWidget this$0;

            {
                this.$initialValue = r1;
                this.this$0 = r3;
            }

            @Override // m0.o.b
            public void afterChange(k<?> kVar, Integer num, Integer num2) {
                String str;
                i.e(kVar, "property");
                Integer num3 = num2;
                TextInputLayout expiryTextInputLayout$payments_core_release = this.this$0.getExpiryTextInputLayout$payments_core_release();
                if (num3 != null) {
                    str = this.this$0.getResources().getString(num3.intValue());
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                }
                expiryTextInputLayout$payments_core_release.setPlaceholderText(str);
            }
        };
        CardBrandIconSupplier cardBrandIconSupplier = DEFAULT_CARD_BRAND_ICON_SUPPLIER;
        this.cardBrandIconSupplier$delegate = new b<CardBrandIconSupplier>(cardBrandIconSupplier, cardBrandIconSupplier, this) { // from class: com.stripe.android.view.CardMultilineWidget$$special$$inlined$observable$3
            public final /* synthetic */ Object $initialValue;
            public final /* synthetic */ CardMultilineWidget this$0;

            {
                this.$initialValue = r1;
                this.this$0 = r3;
            }

            @Override // m0.o.b
            public void afterChange(k<?> kVar, CardMultilineWidget.CardBrandIconSupplier cardBrandIconSupplier2, CardMultilineWidget.CardBrandIconSupplier cardBrandIconSupplier3) {
                i.e(kVar, "property");
                this.this$0.updateBrandUi();
            }
        };
        ErrorListener errorListener = new ErrorListener(cardNumberTextInputLayout);
        this.cardNumberErrorListener$delegate = new b<StripeEditText.ErrorMessageListener>(errorListener, errorListener, this) { // from class: com.stripe.android.view.CardMultilineWidget$$special$$inlined$observable$4
            public final /* synthetic */ Object $initialValue;
            public final /* synthetic */ CardMultilineWidget this$0;

            {
                this.$initialValue = r1;
                this.this$0 = r3;
            }

            @Override // m0.o.b
            public void afterChange(k<?> kVar, StripeEditText.ErrorMessageListener errorMessageListener, StripeEditText.ErrorMessageListener errorMessageListener2) {
                i.e(kVar, "property");
                this.this$0.getCardNumberEditText$payments_core_release().setErrorMessageListener(errorMessageListener2);
            }
        };
        ErrorListener errorListener2 = new ErrorListener(textInputLayout);
        this.expirationDateErrorListener$delegate = new b<StripeEditText.ErrorMessageListener>(errorListener2, errorListener2, this) { // from class: com.stripe.android.view.CardMultilineWidget$$special$$inlined$observable$5
            public final /* synthetic */ Object $initialValue;
            public final /* synthetic */ CardMultilineWidget this$0;

            {
                this.$initialValue = r1;
                this.this$0 = r3;
            }

            @Override // m0.o.b
            public void afterChange(k<?> kVar, StripeEditText.ErrorMessageListener errorMessageListener, StripeEditText.ErrorMessageListener errorMessageListener2) {
                i.e(kVar, "property");
                this.this$0.getExpiryDateEditText$payments_core_release().setErrorMessageListener(errorMessageListener2);
            }
        };
        ErrorListener errorListener3 = new ErrorListener(textInputLayout2);
        this.cvcErrorListener$delegate = new b<StripeEditText.ErrorMessageListener>(errorListener3, errorListener3, this) { // from class: com.stripe.android.view.CardMultilineWidget$$special$$inlined$observable$6
            public final /* synthetic */ Object $initialValue;
            public final /* synthetic */ CardMultilineWidget this$0;

            {
                this.$initialValue = r1;
                this.this$0 = r3;
            }

            @Override // m0.o.b
            public void afterChange(k<?> kVar, StripeEditText.ErrorMessageListener errorMessageListener, StripeEditText.ErrorMessageListener errorMessageListener2) {
                i.e(kVar, "property");
                this.this$0.getCvcEditText$payments_core_release().setErrorMessageListener(errorMessageListener2);
            }
        };
        ErrorListener errorListener4 = new ErrorListener(textInputLayout3);
        this.postalCodeErrorListener$delegate = new b<StripeEditText.ErrorMessageListener>(errorListener4, errorListener4, this) { // from class: com.stripe.android.view.CardMultilineWidget$$special$$inlined$observable$7
            public final /* synthetic */ Object $initialValue;
            public final /* synthetic */ CardMultilineWidget this$0;

            {
                this.$initialValue = r1;
                this.this$0 = r3;
            }

            @Override // m0.o.b
            public void afterChange(k<?> kVar, StripeEditText.ErrorMessageListener errorMessageListener, StripeEditText.ErrorMessageListener errorMessageListener2) {
                i.e(kVar, "property");
                this.this$0.getPostalCodeEditText$payments_core_release().setErrorMessageListener(errorMessageListener2);
            }
        };
        setOrientation(1);
        ColorStateList hintTextColors = cardNumberEditText.getHintTextColors();
        i.d(hintTextColors, "cardNumberEditText.hintTextColors");
        this.tintColorInt = hintTextColors.getDefaultColor();
        Iterator<T> it = K.iterator();
        while (true) {
            ColorStateList colorStateList = null;
            if (!it.hasNext()) {
                break;
            }
            TextInputLayout textInputLayout4 = (TextInputLayout) it.next();
            EditText editText = textInputLayout4.getEditText();
            if (editText != null) {
                colorStateList = editText.getHintTextColors();
            }
            textInputLayout4.setPlaceholderTextColor(colorStateList);
        }
        checkAttributeSet(attributeSet);
        initTextInputLayoutErrorHandlers();
        initFocusChangeListeners();
        initDeleteEmptyListeners();
        this.cardNumberEditText.setCompletionCallback$payments_core_release(new m0.n.a.a<m0.i>() { // from class: com.stripe.android.view.CardMultilineWidget.2
            @Override // m0.n.a.a
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CardMultilineWidget.this.getExpiryDateEditText$payments_core_release().requestFocus();
                CardInputListener cardInputListener = CardMultilineWidget.this.cardInputListener;
                if (cardInputListener != null) {
                    cardInputListener.onCardComplete();
                }
            }
        });
        this.cardNumberEditText.setBrandChangeCallback$payments_core_release(new l<CardBrand, m0.i>() { // from class: com.stripe.android.view.CardMultilineWidget.3
            @Override // m0.n.a.l
            public /* bridge */ /* synthetic */ m0.i invoke(CardBrand cardBrand) {
                invoke2(cardBrand);
                return m0.i.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CardBrand cardBrand) {
                i.e(cardBrand, AccountRangeJsonParser.FIELD_BRAND);
                CardMultilineWidget.this.cardBrand = cardBrand;
                CardMultilineWidget.this.updateBrandUi();
            }
        });
        this.expiryDateEditText.setCompletionCallback$payments_core_release(new m0.n.a.a<m0.i>() { // from class: com.stripe.android.view.CardMultilineWidget.4
            @Override // m0.n.a.a
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CardMultilineWidget.this.getCvcEditText$payments_core_release().requestFocus();
                CardInputListener cardInputListener = CardMultilineWidget.this.cardInputListener;
                if (cardInputListener != null) {
                    cardInputListener.onExpirationComplete();
                }
            }
        });
        this.cvcEditText.setAfterTextChangedListener(new StripeEditText.AfterTextChangedListener() { // from class: com.stripe.android.view.CardMultilineWidget.5
            @Override // com.stripe.android.view.StripeEditText.AfterTextChangedListener
            public final void onTextChanged(String str) {
                i.e(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                if (CardMultilineWidget.this.cardBrand.isMaxCvc(str)) {
                    CardMultilineWidget.this.updateBrandUi();
                    if (CardMultilineWidget.this.shouldShowPostalCode) {
                        CardMultilineWidget.this.getPostalCodeEditText$payments_core_release().requestFocus();
                    }
                    CardInputListener cardInputListener = CardMultilineWidget.this.cardInputListener;
                    if (cardInputListener != null) {
                        cardInputListener.onCvcComplete();
                    }
                } else if (!CardMultilineWidget.this.showCvcIconInCvcField) {
                    CardMultilineWidget.this.flipToCvcIconIfNotFinished();
                }
                CardMultilineWidget.this.getCvcEditText$payments_core_release().setShouldShowError(false);
            }
        });
        adjustViewForPostalCodeAttribute(this.shouldShowPostalCode);
        CardNumberEditText.updateLengthFilter$payments_core_release$default(this.cardNumberEditText, 0, 1, null);
        this.cardBrand = CardBrand.Unknown;
        updateBrandUi();
        for (StripeEditText stripeEditText : getAllFields()) {
            stripeEditText.addTextChangedListener(new TextWatcher() { // from class: com.stripe.android.view.CardMultilineWidget$$special$$inlined$forEach$lambda$1
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    CardMultilineWidget.this.setShouldShowErrorIcon$payments_core_release(false);
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }
            });
        }
        this.cardNumberEditText.setLoadingCallback$payments_core_release(new l<Boolean, m0.i>() { // from class: com.stripe.android.view.CardMultilineWidget.7
            @Override // m0.n.a.l
            public /* bridge */ /* synthetic */ m0.i invoke(Boolean bool2) {
                invoke(bool2.booleanValue());
                return m0.i.a;
            }

            public final void invoke(boolean z2) {
                CardMultilineWidget.this.getCardNumberTextInputLayout$payments_core_release().setLoading$payments_core_release(z2);
            }
        });
        this.isEnabled = true;
    }
}
