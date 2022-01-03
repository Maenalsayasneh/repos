package i0.j.b.r.a.a;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
/* compiled from: AsteriskPasswordTransformationMethod.java */
/* loaded from: classes2.dex */
public class a extends PasswordTransformationMethod {

    /* compiled from: AsteriskPasswordTransformationMethod.java */
    /* renamed from: i0.j.b.r.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0173a implements CharSequence {
        public CharSequence c;

        public C0173a(CharSequence charSequence) {
            this.c = charSequence;
        }

        @Override // java.lang.CharSequence
        public char charAt(int i) {
            return '*';
        }

        @Override // java.lang.CharSequence
        public int length() {
            return this.c.length();
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int i, int i2) {
            return this.c.subSequence(i, i2);
        }
    }

    @Override // android.text.method.PasswordTransformationMethod, android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        return new C0173a(charSequence);
    }
}
