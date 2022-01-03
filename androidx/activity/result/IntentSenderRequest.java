package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class IntentSenderRequest implements Parcelable {
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new a();
    public final IntentSender c;
    public final Intent d;
    public final int q;
    public final int x;

    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<IntentSenderRequest> {
        @Override // android.os.Parcelable.Creator
        public IntentSenderRequest createFromParcel(Parcel parcel) {
            return new IntentSenderRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public IntentSenderRequest[] newArray(int i) {
            return new IntentSenderRequest[i];
        }
    }

    public IntentSenderRequest(IntentSender intentSender, Intent intent, int i, int i2) {
        this.c = intentSender;
        this.d = intent;
        this.q = i;
        this.x = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.c, i);
        parcel.writeParcelable(this.d, i);
        parcel.writeInt(this.q);
        parcel.writeInt(this.x);
    }

    public IntentSenderRequest(Parcel parcel) {
        this.c = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.d = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.q = parcel.readInt();
        this.x = parcel.readInt();
    }
}
