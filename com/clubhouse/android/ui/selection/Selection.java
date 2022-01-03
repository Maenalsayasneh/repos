package com.clubhouse.android.ui.selection;

import android.os.Parcel;
import android.os.Parcelable;
import m0.n.b.i;
/* compiled from: SelectionFragment.kt */
/* loaded from: classes3.dex */
public class Selection implements Parcelable {
    public static final Parcelable.Creator<Selection> CREATOR = new a();
    public final int c;

    /* compiled from: SelectionFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a implements Parcelable.Creator<Selection> {
        @Override // android.os.Parcelable.Creator
        public Selection createFromParcel(Parcel parcel) {
            i.e(parcel, "parcel");
            return new Selection(parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public Selection[] newArray(int i) {
            return new Selection[i];
        }
    }

    public Selection(int i) {
        this.c = i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        i.e(parcel, "out");
        parcel.writeInt(this.c);
    }
}
