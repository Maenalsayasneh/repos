package com.stripe.android.paymentsheet;

import android.content.res.ColorStateList;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import com.google.android.gms.recaptcha.RecaptchaActionType;
import com.stripe.android.paymentsheet.flowcontroller.FlowControllerFactory;
import com.stripe.android.paymentsheet.model.PaymentOption;
import i0.d.a.a.a;
import kotlin.Metadata;
import m0.n.b.f;
import m0.n.b.i;
/* compiled from: PaymentSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0004\u0018\u0019\u001a\u001bB\u0011\b\u0000\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fB\u0019\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u000e\u0010\u0014B\u0019\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u000e\u0010\u0017J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\n\u0010\bR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheet;", "", "", "paymentIntentClientSecret", "Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;", "configuration", "Lm0/i;", "presentWithPaymentIntent", "(Ljava/lang/String;Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;)V", "setupIntentClientSecret", "presentWithSetupIntent", "Lcom/stripe/android/paymentsheet/PaymentSheetLauncher;", "paymentSheetLauncher", "Lcom/stripe/android/paymentsheet/PaymentSheetLauncher;", "<init>", "(Lcom/stripe/android/paymentsheet/PaymentSheetLauncher;)V", "Landroidx/activity/ComponentActivity;", "activity", "Lcom/stripe/android/paymentsheet/PaymentSheetResultCallback;", "callback", "(Landroidx/activity/ComponentActivity;Lcom/stripe/android/paymentsheet/PaymentSheetResultCallback;)V", "Landroidx/fragment/app/Fragment;", "fragment", "(Landroidx/fragment/app/Fragment;Lcom/stripe/android/paymentsheet/PaymentSheetResultCallback;)V", "Configuration", "CustomerConfiguration", "FlowController", "GooglePayConfiguration", "payments-core_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes4.dex */
public final class PaymentSheet {
    private final PaymentSheetLauncher paymentSheetLauncher;

    /* compiled from: PaymentSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001B5\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b4\u00105J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ>\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0017J \u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\"\u0010#R\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010$\u001a\u0004\b%\u0010\u0004\"\u0004\b&\u0010'R$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010(\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010+R$\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010,\u001a\u0004\b-\u0010\u0007\"\u0004\b.\u0010/R$\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u00100\u001a\u0004\b1\u0010\n\"\u0004\b2\u00103¨\u00066"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Lcom/stripe/android/paymentsheet/PaymentSheet$CustomerConfiguration;", "component2", "()Lcom/stripe/android/paymentsheet/PaymentSheet$CustomerConfiguration;", "Lcom/stripe/android/paymentsheet/PaymentSheet$GooglePayConfiguration;", "component3", "()Lcom/stripe/android/paymentsheet/PaymentSheet$GooglePayConfiguration;", "Landroid/content/res/ColorStateList;", "component4", "()Landroid/content/res/ColorStateList;", "merchantDisplayName", "customer", "googlePay", "primaryButtonColor", "copy", "(Ljava/lang/String;Lcom/stripe/android/paymentsheet/PaymentSheet$CustomerConfiguration;Lcom/stripe/android/paymentsheet/PaymentSheet$GooglePayConfiguration;Landroid/content/res/ColorStateList;)Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;", "toString", "", "hashCode", "()I", "", RecaptchaActionType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lm0/i;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getMerchantDisplayName", "setMerchantDisplayName", "(Ljava/lang/String;)V", "Landroid/content/res/ColorStateList;", "getPrimaryButtonColor", "setPrimaryButtonColor", "(Landroid/content/res/ColorStateList;)V", "Lcom/stripe/android/paymentsheet/PaymentSheet$CustomerConfiguration;", "getCustomer", "setCustomer", "(Lcom/stripe/android/paymentsheet/PaymentSheet$CustomerConfiguration;)V", "Lcom/stripe/android/paymentsheet/PaymentSheet$GooglePayConfiguration;", "getGooglePay", "setGooglePay", "(Lcom/stripe/android/paymentsheet/PaymentSheet$GooglePayConfiguration;)V", "<init>", "(Ljava/lang/String;Lcom/stripe/android/paymentsheet/PaymentSheet$CustomerConfiguration;Lcom/stripe/android/paymentsheet/PaymentSheet$GooglePayConfiguration;Landroid/content/res/ColorStateList;)V", "payments-core_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes4.dex */
    public static final class Configuration implements Parcelable {
        public static final Parcelable.Creator<Configuration> CREATOR = new Creator();
        private CustomerConfiguration customer;
        private GooglePayConfiguration googlePay;
        private String merchantDisplayName;
        private ColorStateList primaryButtonColor;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        /* loaded from: classes4.dex */
        public static class Creator implements Parcelable.Creator<Configuration> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Configuration createFromParcel(Parcel parcel) {
                i.e(parcel, "in");
                String readString = parcel.readString();
                GooglePayConfiguration googlePayConfiguration = null;
                CustomerConfiguration createFromParcel = parcel.readInt() != 0 ? CustomerConfiguration.CREATOR.createFromParcel(parcel) : null;
                if (parcel.readInt() != 0) {
                    googlePayConfiguration = GooglePayConfiguration.CREATOR.createFromParcel(parcel);
                }
                return new Configuration(readString, createFromParcel, googlePayConfiguration, (ColorStateList) parcel.readParcelable(Configuration.class.getClassLoader()));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Configuration[] newArray(int i) {
                return new Configuration[i];
            }
        }

        public Configuration(String str) {
            this(str, null, null, null, 14, null);
        }

        public Configuration(String str, CustomerConfiguration customerConfiguration) {
            this(str, customerConfiguration, null, null, 12, null);
        }

        public Configuration(String str, CustomerConfiguration customerConfiguration, GooglePayConfiguration googlePayConfiguration) {
            this(str, customerConfiguration, googlePayConfiguration, null, 8, null);
        }

        public Configuration(String str, CustomerConfiguration customerConfiguration, GooglePayConfiguration googlePayConfiguration, ColorStateList colorStateList) {
            i.e(str, "merchantDisplayName");
            this.merchantDisplayName = str;
            this.customer = customerConfiguration;
            this.googlePay = googlePayConfiguration;
            this.primaryButtonColor = colorStateList;
        }

        public static /* synthetic */ Configuration copy$default(Configuration configuration, String str, CustomerConfiguration customerConfiguration, GooglePayConfiguration googlePayConfiguration, ColorStateList colorStateList, int i, Object obj) {
            if ((i & 1) != 0) {
                str = configuration.merchantDisplayName;
            }
            if ((i & 2) != 0) {
                customerConfiguration = configuration.customer;
            }
            if ((i & 4) != 0) {
                googlePayConfiguration = configuration.googlePay;
            }
            if ((i & 8) != 0) {
                colorStateList = configuration.primaryButtonColor;
            }
            return configuration.copy(str, customerConfiguration, googlePayConfiguration, colorStateList);
        }

        public final String component1() {
            return this.merchantDisplayName;
        }

        public final CustomerConfiguration component2() {
            return this.customer;
        }

        public final GooglePayConfiguration component3() {
            return this.googlePay;
        }

        public final ColorStateList component4() {
            return this.primaryButtonColor;
        }

        public final Configuration copy(String str, CustomerConfiguration customerConfiguration, GooglePayConfiguration googlePayConfiguration, ColorStateList colorStateList) {
            i.e(str, "merchantDisplayName");
            return new Configuration(str, customerConfiguration, googlePayConfiguration, colorStateList);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Configuration)) {
                return false;
            }
            Configuration configuration = (Configuration) obj;
            return i.a(this.merchantDisplayName, configuration.merchantDisplayName) && i.a(this.customer, configuration.customer) && i.a(this.googlePay, configuration.googlePay) && i.a(this.primaryButtonColor, configuration.primaryButtonColor);
        }

        public final CustomerConfiguration getCustomer() {
            return this.customer;
        }

        public final GooglePayConfiguration getGooglePay() {
            return this.googlePay;
        }

        public final String getMerchantDisplayName() {
            return this.merchantDisplayName;
        }

        public final ColorStateList getPrimaryButtonColor() {
            return this.primaryButtonColor;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.merchantDisplayName;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            CustomerConfiguration customerConfiguration = this.customer;
            int hashCode2 = (hashCode + (customerConfiguration != null ? customerConfiguration.hashCode() : 0)) * 31;
            GooglePayConfiguration googlePayConfiguration = this.googlePay;
            int hashCode3 = (hashCode2 + (googlePayConfiguration != null ? googlePayConfiguration.hashCode() : 0)) * 31;
            ColorStateList colorStateList = this.primaryButtonColor;
            if (colorStateList != null) {
                i = colorStateList.hashCode();
            }
            return hashCode3 + i;
        }

        public final void setCustomer(CustomerConfiguration customerConfiguration) {
            this.customer = customerConfiguration;
        }

        public final void setGooglePay(GooglePayConfiguration googlePayConfiguration) {
            this.googlePay = googlePayConfiguration;
        }

        public final void setMerchantDisplayName(String str) {
            i.e(str, "<set-?>");
            this.merchantDisplayName = str;
        }

        public final void setPrimaryButtonColor(ColorStateList colorStateList) {
            this.primaryButtonColor = colorStateList;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder P0 = a.P0("Configuration(merchantDisplayName=");
            P0.append(this.merchantDisplayName);
            P0.append(", customer=");
            P0.append(this.customer);
            P0.append(", googlePay=");
            P0.append(this.googlePay);
            P0.append(", primaryButtonColor=");
            P0.append(this.primaryButtonColor);
            P0.append(")");
            return P0.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            i.e(parcel, "parcel");
            parcel.writeString(this.merchantDisplayName);
            CustomerConfiguration customerConfiguration = this.customer;
            if (customerConfiguration != null) {
                parcel.writeInt(1);
                customerConfiguration.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            GooglePayConfiguration googlePayConfiguration = this.googlePay;
            if (googlePayConfiguration != null) {
                parcel.writeInt(1);
                googlePayConfiguration.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeParcelable(this.primaryButtonColor, i);
        }

        public /* synthetic */ Configuration(String str, CustomerConfiguration customerConfiguration, GooglePayConfiguration googlePayConfiguration, ColorStateList colorStateList, int i, f fVar) {
            this(str, (i & 2) != 0 ? null : customerConfiguration, (i & 4) != 0 ? null : googlePayConfiguration, (i & 8) != 0 ? null : colorStateList);
        }
    }

    /* compiled from: PaymentSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0013\u0010\rJ \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001c\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheet$CustomerConfiguration;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "id", "ephemeralKeySecret", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/stripe/android/paymentsheet/PaymentSheet$CustomerConfiguration;", "toString", "", "hashCode", "()I", "", RecaptchaActionType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lm0/i;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getEphemeralKeySecret", "getId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "payments-core_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes4.dex */
    public static final class CustomerConfiguration implements Parcelable {
        public static final Parcelable.Creator<CustomerConfiguration> CREATOR = new Creator();
        private final String ephemeralKeySecret;
        private final String id;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        /* loaded from: classes4.dex */
        public static class Creator implements Parcelable.Creator<CustomerConfiguration> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final CustomerConfiguration createFromParcel(Parcel parcel) {
                i.e(parcel, "in");
                return new CustomerConfiguration(parcel.readString(), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final CustomerConfiguration[] newArray(int i) {
                return new CustomerConfiguration[i];
            }
        }

        public CustomerConfiguration(String str, String str2) {
            i.e(str, "id");
            i.e(str2, "ephemeralKeySecret");
            this.id = str;
            this.ephemeralKeySecret = str2;
        }

        public static /* synthetic */ CustomerConfiguration copy$default(CustomerConfiguration customerConfiguration, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = customerConfiguration.id;
            }
            if ((i & 2) != 0) {
                str2 = customerConfiguration.ephemeralKeySecret;
            }
            return customerConfiguration.copy(str, str2);
        }

        public final String component1() {
            return this.id;
        }

        public final String component2() {
            return this.ephemeralKeySecret;
        }

        public final CustomerConfiguration copy(String str, String str2) {
            i.e(str, "id");
            i.e(str2, "ephemeralKeySecret");
            return new CustomerConfiguration(str, str2);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CustomerConfiguration)) {
                return false;
            }
            CustomerConfiguration customerConfiguration = (CustomerConfiguration) obj;
            return i.a(this.id, customerConfiguration.id) && i.a(this.ephemeralKeySecret, customerConfiguration.ephemeralKeySecret);
        }

        public final String getEphemeralKeySecret() {
            return this.ephemeralKeySecret;
        }

        public final String getId() {
            return this.id;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.id;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.ephemeralKeySecret;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder P0 = a.P0("CustomerConfiguration(id=");
            P0.append(this.id);
            P0.append(", ephemeralKeySecret=");
            return a.y0(P0, this.ephemeralKeySecret, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            i.e(parcel, "parcel");
            parcel.writeString(this.id);
            parcel.writeString(this.ephemeralKeySecret);
        }
    }

    /* compiled from: PaymentSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u0000 \u00132\u00020\u0001:\u0003\u0013\u0014\u0015J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ+\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\f\u0010\nJ\u0011\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\bH&¢\u0006\u0004\b\u0012\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController;", "", "", "paymentIntentClientSecret", "Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;", "configuration", "Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController$ConfigCallback;", "callback", "Lm0/i;", "configureWithPaymentIntent", "(Ljava/lang/String;Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController$ConfigCallback;)V", "setupIntentClientSecret", "configureWithSetupIntent", "Lcom/stripe/android/paymentsheet/model/PaymentOption;", "getPaymentOption", "()Lcom/stripe/android/paymentsheet/model/PaymentOption;", "presentPaymentOptions", "()V", "confirm", "Companion", "ConfigCallback", "Result", "payments-core_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes4.dex */
    public interface FlowController {
        public static final Companion Companion = Companion.$$INSTANCE;

        /* compiled from: PaymentSheet.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController$ConfigCallback;", "", "", "success", "", "error", "Lm0/i;", "onConfigured", "(ZLjava/lang/Throwable;)V", "payments-core_release"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes4.dex */
        public interface ConfigCallback {
            void onConfigured(boolean z, Throwable th);
        }

        /* compiled from: PaymentSheet.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        /* loaded from: classes4.dex */
        public static final class DefaultImpls {
            public static /* synthetic */ void configureWithPaymentIntent$default(FlowController flowController, String str, Configuration configuration, ConfigCallback configCallback, int i, Object obj) {
                if (obj == null) {
                    if ((i & 2) != 0) {
                        configuration = null;
                    }
                    flowController.configureWithPaymentIntent(str, configuration, configCallback);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: configureWithPaymentIntent");
            }

            public static /* synthetic */ void configureWithSetupIntent$default(FlowController flowController, String str, Configuration configuration, ConfigCallback configCallback, int i, Object obj) {
                if (obj == null) {
                    if ((i & 2) != 0) {
                        configuration = null;
                    }
                    flowController.configureWithSetupIntent(str, configuration, configCallback);
                    return;
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: configureWithSetupIntent");
            }
        }

        /* compiled from: PaymentSheet.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController$Result;", "", "<init>", "()V", "Failure", "Success", "Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController$Result$Success;", "Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController$Result$Failure;", "payments-core_release"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes4.dex */
        public static abstract class Result {

            /* compiled from: PaymentSheet.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController$Result$Failure;", "Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController$Result;", "", "error", "Ljava/lang/Throwable;", "getError", "()Ljava/lang/Throwable;", "<init>", "(Ljava/lang/Throwable;)V", "payments-core_release"}, k = 1, mv = {1, 4, 2})
            /* loaded from: classes4.dex */
            public static final class Failure extends Result {
                private final Throwable error;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Failure(Throwable th) {
                    super(null);
                    i.e(th, "error");
                    this.error = th;
                }

                public final Throwable getError() {
                    return this.error;
                }
            }

            /* compiled from: PaymentSheet.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController$Result$Success;", "Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController$Result;", "<init>", "()V", "payments-core_release"}, k = 1, mv = {1, 4, 2})
            /* loaded from: classes4.dex */
            public static final class Success extends Result {
                public static final Success INSTANCE = new Success();

                private Success() {
                    super(null);
                }
            }

            private Result() {
            }

            public /* synthetic */ Result(f fVar) {
                this();
            }
        }

        static FlowController create(ComponentActivity componentActivity, PaymentOptionCallback paymentOptionCallback, PaymentSheetResultCallback paymentSheetResultCallback) {
            return Companion.create(componentActivity, paymentOptionCallback, paymentSheetResultCallback);
        }

        static FlowController create(Fragment fragment, PaymentOptionCallback paymentOptionCallback, PaymentSheetResultCallback paymentSheetResultCallback) {
            return Companion.create(fragment, paymentOptionCallback, paymentSheetResultCallback);
        }

        void configureWithPaymentIntent(String str, Configuration configuration, ConfigCallback configCallback);

        void configureWithSetupIntent(String str, Configuration configuration, ConfigCallback configCallback);

        void confirm();

        PaymentOption getPaymentOption();

        void presentPaymentOptions();

        /* compiled from: PaymentSheet.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ'\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController$Companion;", "", "Landroidx/activity/ComponentActivity;", "activity", "Lcom/stripe/android/paymentsheet/PaymentOptionCallback;", "paymentOptionCallback", "Lcom/stripe/android/paymentsheet/PaymentSheetResultCallback;", "paymentResultCallback", "Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController;", "create", "(Landroidx/activity/ComponentActivity;Lcom/stripe/android/paymentsheet/PaymentOptionCallback;Lcom/stripe/android/paymentsheet/PaymentSheetResultCallback;)Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController;", "Landroidx/fragment/app/Fragment;", "fragment", "(Landroidx/fragment/app/Fragment;Lcom/stripe/android/paymentsheet/PaymentOptionCallback;Lcom/stripe/android/paymentsheet/PaymentSheetResultCallback;)Lcom/stripe/android/paymentsheet/PaymentSheet$FlowController;", "<init>", "()V", "payments-core_release"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes4.dex */
        public static final class Companion {
            public static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            public final FlowController create(ComponentActivity componentActivity, PaymentOptionCallback paymentOptionCallback, PaymentSheetResultCallback paymentSheetResultCallback) {
                i.e(componentActivity, "activity");
                i.e(paymentOptionCallback, "paymentOptionCallback");
                i.e(paymentSheetResultCallback, "paymentResultCallback");
                return new FlowControllerFactory(componentActivity, paymentOptionCallback, paymentSheetResultCallback).create();
            }

            public final FlowController create(Fragment fragment, PaymentOptionCallback paymentOptionCallback, PaymentSheetResultCallback paymentSheetResultCallback) {
                i.e(fragment, "fragment");
                i.e(paymentOptionCallback, "paymentOptionCallback");
                i.e(paymentSheetResultCallback, "paymentResultCallback");
                return new FlowControllerFactory(fragment, paymentOptionCallback, paymentSheetResultCallback).create();
            }
        }
    }

    /* compiled from: PaymentSheet.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\"B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u000fJ \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\u001f\u0010\u0007¨\u0006#"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheet$GooglePayConfiguration;", "Landroid/os/Parcelable;", "Lcom/stripe/android/paymentsheet/PaymentSheet$GooglePayConfiguration$Environment;", "component1", "()Lcom/stripe/android/paymentsheet/PaymentSheet$GooglePayConfiguration$Environment;", "", "component2", "()Ljava/lang/String;", "environment", "countryCode", "copy", "(Lcom/stripe/android/paymentsheet/PaymentSheet$GooglePayConfiguration$Environment;Ljava/lang/String;)Lcom/stripe/android/paymentsheet/PaymentSheet$GooglePayConfiguration;", "toString", "", "hashCode", "()I", "", RecaptchaActionType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lm0/i;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/stripe/android/paymentsheet/PaymentSheet$GooglePayConfiguration$Environment;", "getEnvironment", "Ljava/lang/String;", "getCountryCode", "<init>", "(Lcom/stripe/android/paymentsheet/PaymentSheet$GooglePayConfiguration$Environment;Ljava/lang/String;)V", "Environment", "payments-core_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes4.dex */
    public static final class GooglePayConfiguration implements Parcelable {
        public static final Parcelable.Creator<GooglePayConfiguration> CREATOR = new Creator();
        private final String countryCode;
        private final Environment environment;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        /* loaded from: classes4.dex */
        public static class Creator implements Parcelable.Creator<GooglePayConfiguration> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final GooglePayConfiguration createFromParcel(Parcel parcel) {
                i.e(parcel, "in");
                return new GooglePayConfiguration((Environment) Enum.valueOf(Environment.class, parcel.readString()), parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final GooglePayConfiguration[] newArray(int i) {
                return new GooglePayConfiguration[i];
            }
        }

        /* compiled from: PaymentSheet.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheet$GooglePayConfiguration$Environment;", "", "<init>", "(Ljava/lang/String;I)V", "Production", "Test", "payments-core_release"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes4.dex */
        public enum Environment {
            Production,
            Test
        }

        public GooglePayConfiguration(Environment environment, String str) {
            i.e(environment, "environment");
            i.e(str, "countryCode");
            this.environment = environment;
            this.countryCode = str;
        }

        public static /* synthetic */ GooglePayConfiguration copy$default(GooglePayConfiguration googlePayConfiguration, Environment environment, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                environment = googlePayConfiguration.environment;
            }
            if ((i & 2) != 0) {
                str = googlePayConfiguration.countryCode;
            }
            return googlePayConfiguration.copy(environment, str);
        }

        public final Environment component1() {
            return this.environment;
        }

        public final String component2() {
            return this.countryCode;
        }

        public final GooglePayConfiguration copy(Environment environment, String str) {
            i.e(environment, "environment");
            i.e(str, "countryCode");
            return new GooglePayConfiguration(environment, str);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GooglePayConfiguration)) {
                return false;
            }
            GooglePayConfiguration googlePayConfiguration = (GooglePayConfiguration) obj;
            return i.a(this.environment, googlePayConfiguration.environment) && i.a(this.countryCode, googlePayConfiguration.countryCode);
        }

        public final String getCountryCode() {
            return this.countryCode;
        }

        public final Environment getEnvironment() {
            return this.environment;
        }

        @Override // java.lang.Object
        public int hashCode() {
            Environment environment = this.environment;
            int i = 0;
            int hashCode = (environment != null ? environment.hashCode() : 0) * 31;
            String str = this.countryCode;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode + i;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder P0 = a.P0("GooglePayConfiguration(environment=");
            P0.append(this.environment);
            P0.append(", countryCode=");
            return a.y0(P0, this.countryCode, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            i.e(parcel, "parcel");
            parcel.writeString(this.environment.name());
            parcel.writeString(this.countryCode);
        }
    }

    public PaymentSheet(PaymentSheetLauncher paymentSheetLauncher) {
        i.e(paymentSheetLauncher, "paymentSheetLauncher");
        this.paymentSheetLauncher = paymentSheetLauncher;
    }

    public static /* synthetic */ void presentWithPaymentIntent$default(PaymentSheet paymentSheet, String str, Configuration configuration, int i, Object obj) {
        if ((i & 2) != 0) {
            configuration = null;
        }
        paymentSheet.presentWithPaymentIntent(str, configuration);
    }

    public static /* synthetic */ void presentWithSetupIntent$default(PaymentSheet paymentSheet, String str, Configuration configuration, int i, Object obj) {
        if ((i & 2) != 0) {
            configuration = null;
        }
        paymentSheet.presentWithSetupIntent(str, configuration);
    }

    public final void presentWithPaymentIntent(String str) {
        presentWithPaymentIntent$default(this, str, null, 2, null);
    }

    public final void presentWithPaymentIntent(String str, Configuration configuration) {
        i.e(str, "paymentIntentClientSecret");
        this.paymentSheetLauncher.presentWithPaymentIntent(str, configuration);
    }

    public final void presentWithSetupIntent(String str) {
        presentWithSetupIntent$default(this, str, null, 2, null);
    }

    public final void presentWithSetupIntent(String str, Configuration configuration) {
        i.e(str, "setupIntentClientSecret");
        this.paymentSheetLauncher.presentWithSetupIntent(str, configuration);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaymentSheet(ComponentActivity componentActivity, PaymentSheetResultCallback paymentSheetResultCallback) {
        this(new DefaultPaymentSheetLauncher(componentActivity, paymentSheetResultCallback));
        i.e(componentActivity, "activity");
        i.e(paymentSheetResultCallback, "callback");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaymentSheet(Fragment fragment, PaymentSheetResultCallback paymentSheetResultCallback) {
        this(new DefaultPaymentSheetLauncher(fragment, paymentSheetResultCallback));
        i.e(fragment, "fragment");
        i.e(paymentSheetResultCallback, "callback");
    }
}
