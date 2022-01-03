package com.theartofdev.edmodo.cropper;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.theartofdev.edmodo.cropper.CropImageView;
/* loaded from: classes4.dex */
public class CropImageOptions implements Parcelable {
    public static final Parcelable.Creator<CropImageOptions> CREATOR = new a();
    public int A2;
    public int B2;
    public int C2;
    public CropImageView.RequestSizeOptions D2;
    public boolean E2;
    public Rect F2;
    public int G2;
    public boolean H2;
    public boolean I2;
    public boolean J2;
    public int K2;
    public boolean L2;
    public boolean M2;
    public CharSequence N2;
    public int O2;
    public boolean Y1;
    public boolean Z1;
    public boolean a2;
    public boolean b2;
    public CropImageView.CropShape c;
    public int c2;
    public float d;
    public float d2;
    public boolean e2;
    public int f2;
    public int g2;
    public float h2;
    public int i2;
    public float j2;
    public float k2;
    public float l2;
    public int m2;
    public float n2;
    public int o2;
    public int p2;
    public float q;
    public int q2;
    public int r2;
    public int s2;
    public int t2;
    public int u2;
    public int v2;
    public CharSequence w2;
    public CropImageView.Guidelines x;
    public int x2;
    public CropImageView.ScaleType y;
    public Uri y2;
    public Bitmap.CompressFormat z2;

    /* loaded from: classes4.dex */
    public static class a implements Parcelable.Creator<CropImageOptions> {
        @Override // android.os.Parcelable.Creator
        public CropImageOptions createFromParcel(Parcel parcel) {
            return new CropImageOptions(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public CropImageOptions[] newArray(int i) {
            return new CropImageOptions[i];
        }
    }

    public CropImageOptions() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        this.c = CropImageView.CropShape.RECTANGLE;
        this.d = TypedValue.applyDimension(1, 3.0f, displayMetrics);
        this.q = TypedValue.applyDimension(1, 24.0f, displayMetrics);
        this.x = CropImageView.Guidelines.ON_TOUCH;
        this.y = CropImageView.ScaleType.FIT_CENTER;
        this.Y1 = true;
        this.Z1 = true;
        this.a2 = true;
        this.b2 = false;
        this.c2 = 4;
        this.d2 = 0.1f;
        this.e2 = false;
        this.f2 = 1;
        this.g2 = 1;
        this.h2 = TypedValue.applyDimension(1, 3.0f, displayMetrics);
        this.i2 = Color.argb(170, 255, 255, 255);
        this.j2 = TypedValue.applyDimension(1, 2.0f, displayMetrics);
        this.k2 = TypedValue.applyDimension(1, 5.0f, displayMetrics);
        this.l2 = TypedValue.applyDimension(1, 14.0f, displayMetrics);
        this.m2 = -1;
        this.n2 = TypedValue.applyDimension(1, 1.0f, displayMetrics);
        this.o2 = Color.argb(170, 255, 255, 255);
        this.p2 = Color.argb(119, 0, 0, 0);
        this.q2 = (int) TypedValue.applyDimension(1, 42.0f, displayMetrics);
        this.r2 = (int) TypedValue.applyDimension(1, 42.0f, displayMetrics);
        this.s2 = 40;
        this.t2 = 40;
        this.u2 = 99999;
        this.v2 = 99999;
        this.w2 = "";
        this.x2 = 0;
        this.y2 = Uri.EMPTY;
        this.z2 = Bitmap.CompressFormat.JPEG;
        this.A2 = 90;
        this.B2 = 0;
        this.C2 = 0;
        this.D2 = CropImageView.RequestSizeOptions.NONE;
        this.E2 = false;
        this.F2 = null;
        this.G2 = -1;
        this.H2 = true;
        this.I2 = true;
        this.J2 = false;
        this.K2 = 90;
        this.L2 = false;
        this.M2 = false;
        this.N2 = null;
        this.O2 = 0;
    }

    public void a() {
        if (this.c2 < 0) {
            throw new IllegalArgumentException("Cannot set max zoom to a number < 1");
        } else if (this.q >= 0.0f) {
            float f = this.d2;
            if (f < 0.0f || ((double) f) >= 0.5d) {
                throw new IllegalArgumentException("Cannot set initial crop window padding value to a number < 0 or >= 0.5");
            } else if (this.f2 <= 0) {
                throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
            } else if (this.g2 <= 0) {
                throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
            } else if (this.h2 < 0.0f) {
                throw new IllegalArgumentException("Cannot set line thickness value to a number less than 0.");
            } else if (this.j2 < 0.0f) {
                throw new IllegalArgumentException("Cannot set corner thickness value to a number less than 0.");
            } else if (this.n2 < 0.0f) {
                throw new IllegalArgumentException("Cannot set guidelines thickness value to a number less than 0.");
            } else if (this.r2 >= 0) {
                int i = this.s2;
                if (i >= 0) {
                    int i2 = this.t2;
                    if (i2 < 0) {
                        throw new IllegalArgumentException("Cannot set min crop result height value to a number < 0 ");
                    } else if (this.u2 < i) {
                        throw new IllegalArgumentException("Cannot set max crop result width to smaller value than min crop result width");
                    } else if (this.v2 < i2) {
                        throw new IllegalArgumentException("Cannot set max crop result height to smaller value than min crop result height");
                    } else if (this.B2 < 0) {
                        throw new IllegalArgumentException("Cannot set request width value to a number < 0 ");
                    } else if (this.C2 >= 0) {
                        int i3 = this.K2;
                        if (i3 < 0 || i3 > 360) {
                            throw new IllegalArgumentException("Cannot set rotation degrees value to a number < 0 or > 360");
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot set request height value to a number < 0 ");
                    }
                } else {
                    throw new IllegalArgumentException("Cannot set min crop result width value to a number < 0 ");
                }
            } else {
                throw new IllegalArgumentException("Cannot set min crop window height value to a number < 0 ");
            }
        } else {
            throw new IllegalArgumentException("Cannot set touch radius value to a number <= 0 ");
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.c.ordinal());
        parcel.writeFloat(this.d);
        parcel.writeFloat(this.q);
        parcel.writeInt(this.x.ordinal());
        parcel.writeInt(this.y.ordinal());
        parcel.writeByte(this.Y1 ? (byte) 1 : 0);
        parcel.writeByte(this.Z1 ? (byte) 1 : 0);
        parcel.writeByte(this.a2 ? (byte) 1 : 0);
        parcel.writeByte(this.b2 ? (byte) 1 : 0);
        parcel.writeInt(this.c2);
        parcel.writeFloat(this.d2);
        parcel.writeByte(this.e2 ? (byte) 1 : 0);
        parcel.writeInt(this.f2);
        parcel.writeInt(this.g2);
        parcel.writeFloat(this.h2);
        parcel.writeInt(this.i2);
        parcel.writeFloat(this.j2);
        parcel.writeFloat(this.k2);
        parcel.writeFloat(this.l2);
        parcel.writeInt(this.m2);
        parcel.writeFloat(this.n2);
        parcel.writeInt(this.o2);
        parcel.writeInt(this.p2);
        parcel.writeInt(this.q2);
        parcel.writeInt(this.r2);
        parcel.writeInt(this.s2);
        parcel.writeInt(this.t2);
        parcel.writeInt(this.u2);
        parcel.writeInt(this.v2);
        TextUtils.writeToParcel(this.w2, parcel, i);
        parcel.writeInt(this.x2);
        parcel.writeParcelable(this.y2, i);
        parcel.writeString(this.z2.name());
        parcel.writeInt(this.A2);
        parcel.writeInt(this.B2);
        parcel.writeInt(this.C2);
        parcel.writeInt(this.D2.ordinal());
        parcel.writeInt(this.E2 ? 1 : 0);
        parcel.writeParcelable(this.F2, i);
        parcel.writeInt(this.G2);
        parcel.writeByte(this.H2 ? (byte) 1 : 0);
        parcel.writeByte(this.I2 ? (byte) 1 : 0);
        parcel.writeByte(this.J2 ? (byte) 1 : 0);
        parcel.writeInt(this.K2);
        parcel.writeByte(this.L2 ? (byte) 1 : 0);
        parcel.writeByte(this.M2 ? (byte) 1 : 0);
        TextUtils.writeToParcel(this.N2, parcel, i);
        parcel.writeInt(this.O2);
    }

    public CropImageOptions(Parcel parcel) {
        this.c = CropImageView.CropShape.values()[parcel.readInt()];
        this.d = parcel.readFloat();
        this.q = parcel.readFloat();
        this.x = CropImageView.Guidelines.values()[parcel.readInt()];
        this.y = CropImageView.ScaleType.values()[parcel.readInt()];
        boolean z = true;
        this.Y1 = parcel.readByte() != 0;
        this.Z1 = parcel.readByte() != 0;
        this.a2 = parcel.readByte() != 0;
        this.b2 = parcel.readByte() != 0;
        this.c2 = parcel.readInt();
        this.d2 = parcel.readFloat();
        this.e2 = parcel.readByte() != 0;
        this.f2 = parcel.readInt();
        this.g2 = parcel.readInt();
        this.h2 = parcel.readFloat();
        this.i2 = parcel.readInt();
        this.j2 = parcel.readFloat();
        this.k2 = parcel.readFloat();
        this.l2 = parcel.readFloat();
        this.m2 = parcel.readInt();
        this.n2 = parcel.readFloat();
        this.o2 = parcel.readInt();
        this.p2 = parcel.readInt();
        this.q2 = parcel.readInt();
        this.r2 = parcel.readInt();
        this.s2 = parcel.readInt();
        this.t2 = parcel.readInt();
        this.u2 = parcel.readInt();
        this.v2 = parcel.readInt();
        this.w2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.x2 = parcel.readInt();
        this.y2 = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.z2 = Bitmap.CompressFormat.valueOf(parcel.readString());
        this.A2 = parcel.readInt();
        this.B2 = parcel.readInt();
        this.C2 = parcel.readInt();
        this.D2 = CropImageView.RequestSizeOptions.values()[parcel.readInt()];
        this.E2 = parcel.readByte() != 0;
        this.F2 = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
        this.G2 = parcel.readInt();
        this.H2 = parcel.readByte() != 0;
        this.I2 = parcel.readByte() != 0;
        this.J2 = parcel.readByte() != 0;
        this.K2 = parcel.readInt();
        this.L2 = parcel.readByte() != 0;
        this.M2 = parcel.readByte() == 0 ? false : z;
        this.N2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.O2 = parcel.readInt();
    }
}
