package h0.i.b.d;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R;
import java.io.IOException;
import java.lang.reflect.Array;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: ColorStateListInflaterCompat.java */
/* loaded from: classes.dex */
public final class a {
    public static final ThreadLocal<TypedValue> a = new ThreadLocal<>();

    public static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0110  */
    /* JADX WARN: Type inference failed for: r9v16, types: [java.lang.Object[], java.lang.Object] */
    /* JADX WARN: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static ColorStateList b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        TypedArray typedArray;
        int i;
        int i2;
        int attributeCount;
        int i3;
        int i4;
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            boolean z = true;
            int depth2 = xmlPullParser.getDepth() + 1;
            int[][] iArr = new int[20];
            int[] iArr2 = new int[20];
            int i5 = 0;
            while (true) {
                int next = xmlPullParser.next();
                if (next == z || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                    break;
                }
                if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                    int[] iArr3 = R.styleable.ColorStateListItem;
                    if (theme == null) {
                        typedArray = resources.obtainAttributes(attributeSet, iArr3);
                    } else {
                        typedArray = theme.obtainStyledAttributes(attributeSet, iArr3, 0, 0);
                    }
                    int i6 = R.styleable.ColorStateListItem_android_color;
                    int resourceId = typedArray.getResourceId(i6, -1);
                    if (resourceId != -1) {
                        ThreadLocal<TypedValue> threadLocal = a;
                        TypedValue typedValue = threadLocal.get();
                        if (typedValue == null) {
                            typedValue = new TypedValue();
                            threadLocal.set(typedValue);
                        }
                        resources.getValue(resourceId, typedValue, z);
                        int i7 = typedValue.type;
                        if (!((i7 < 28 || i7 > 31) ? false : z)) {
                            try {
                                i = a(resources, resources.getXml(resourceId), theme).getDefaultColor();
                            } catch (Exception unused) {
                                i = typedArray.getColor(R.styleable.ColorStateListItem_android_color, -65281);
                            }
                            float f = 1.0f;
                            i2 = R.styleable.ColorStateListItem_android_alpha;
                            if (!typedArray.hasValue(i2)) {
                                f = typedArray.getFloat(i2, 1.0f);
                            } else {
                                int i8 = R.styleable.ColorStateListItem_alpha;
                                if (typedArray.hasValue(i8)) {
                                    f = typedArray.getFloat(i8, 1.0f);
                                }
                            }
                            typedArray.recycle();
                            attributeCount = attributeSet.getAttributeCount();
                            int[] iArr4 = new int[attributeCount];
                            int i9 = 0;
                            for (i3 = 0; i3 < attributeCount; i3++) {
                                int attributeNameResource = attributeSet.getAttributeNameResource(i3);
                                if (!(attributeNameResource == 16843173 || attributeNameResource == 16843551 || attributeNameResource == R.attr.alpha)) {
                                    int i10 = i9 + 1;
                                    if (!attributeSet.getAttributeBooleanValue(i3, false)) {
                                        attributeNameResource = -attributeNameResource;
                                    }
                                    iArr4[i9] = attributeNameResource;
                                    i9 = i10;
                                }
                            }
                            int[] trimStateSet = StateSet.trimStateSet(iArr4, i9);
                            int round = (Math.round(((float) Color.alpha(i)) * f) << 24) | (i & 16777215);
                            i4 = i5 + 1;
                            int i11 = 8;
                            if (i4 > iArr2.length) {
                                int[] iArr5 = new int[i5 <= 4 ? 8 : i5 * 2];
                                System.arraycopy(iArr2, 0, iArr5, 0, i5);
                                iArr2 = iArr5;
                            }
                            iArr2[i5] = round;
                            if (i4 > iArr.length) {
                                Class<?> componentType = iArr.getClass().getComponentType();
                                if (i5 > 4) {
                                    i11 = i5 * 2;
                                }
                                ?? r9 = (Object[]) Array.newInstance(componentType, i11);
                                System.arraycopy(iArr, 0, r9, 0, i5);
                                iArr = r9;
                            }
                            iArr[i5] = trimStateSet;
                            iArr = iArr;
                            i5 = i4;
                        }
                    }
                    i = typedArray.getColor(i6, -65281);
                    float f2 = 1.0f;
                    i2 = R.styleable.ColorStateListItem_android_alpha;
                    if (!typedArray.hasValue(i2)) {
                    }
                    typedArray.recycle();
                    attributeCount = attributeSet.getAttributeCount();
                    int[] iArr42 = new int[attributeCount];
                    int i92 = 0;
                    while (i3 < attributeCount) {
                    }
                    int[] trimStateSet2 = StateSet.trimStateSet(iArr42, i92);
                    int round2 = (Math.round(((float) Color.alpha(i)) * f2) << 24) | (i & 16777215);
                    i4 = i5 + 1;
                    int i112 = 8;
                    if (i4 > iArr2.length) {
                    }
                    iArr2[i5] = round2;
                    if (i4 > iArr.length) {
                    }
                    iArr[i5] = trimStateSet2;
                    iArr = iArr;
                    i5 = i4;
                }
                z = true;
            }
            int[] iArr6 = new int[i5];
            int[][] iArr7 = new int[i5];
            System.arraycopy(iArr2, 0, iArr6, 0, i5);
            System.arraycopy(iArr, 0, iArr7, 0, i5);
            return new ColorStateList(iArr7, iArr6);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }
}
