package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import i0.d.a.a.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class ConstraintAttribute {
    public boolean a;
    public String b;
    public AttributeType c;
    public int d;
    public float e;
    public String f;
    public boolean g;
    public int h;

    /* loaded from: classes.dex */
    public enum AttributeType {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    public ConstraintAttribute(String str, AttributeType attributeType, Object obj, boolean z) {
        this.a = false;
        this.b = str;
        this.c = attributeType;
        this.a = z;
        i(obj);
    }

    public static int a(int i) {
        int i2 = (i & (~(i >> 31))) - 255;
        return (i2 & (i2 >> 31)) + 255;
    }

    public static void f(Context context, XmlPullParser xmlPullParser, HashMap<String, ConstraintAttribute> hashMap) {
        Object obj;
        AttributeType attributeType;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.CustomAttribute);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj2 = null;
        AttributeType attributeType2 = null;
        boolean z = false;
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == R.styleable.CustomAttribute_attributeName) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == R.styleable.CustomAttribute_methodName) {
                str = obtainStyledAttributes.getString(index);
                z = true;
            } else if (index == R.styleable.CustomAttribute_customBoolean) {
                obj2 = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                attributeType2 = AttributeType.BOOLEAN_TYPE;
            } else {
                if (index == R.styleable.CustomAttribute_customColorValue) {
                    attributeType = AttributeType.COLOR_TYPE;
                    obj = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.CustomAttribute_customColorDrawableValue) {
                    attributeType = AttributeType.COLOR_DRAWABLE_TYPE;
                    obj = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.CustomAttribute_customPixelDimension) {
                    attributeType = AttributeType.DIMENSION_TYPE;
                    obj = Float.valueOf(TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                } else if (index == R.styleable.CustomAttribute_customDimension) {
                    attributeType = AttributeType.DIMENSION_TYPE;
                    obj = Float.valueOf(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.CustomAttribute_customFloatValue) {
                    attributeType = AttributeType.FLOAT_TYPE;
                    obj = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                } else if (index == R.styleable.CustomAttribute_customIntegerValue) {
                    attributeType = AttributeType.INT_TYPE;
                    obj = Integer.valueOf(obtainStyledAttributes.getInteger(index, -1));
                } else if (index == R.styleable.CustomAttribute_customStringValue) {
                    attributeType = AttributeType.STRING_TYPE;
                    obj = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.CustomAttribute_customReference) {
                    attributeType = AttributeType.REFERENCE_TYPE;
                    int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                    if (resourceId == -1) {
                        resourceId = obtainStyledAttributes.getInt(index, -1);
                    }
                    obj = Integer.valueOf(resourceId);
                }
                attributeType2 = attributeType;
                obj2 = obj;
            }
        }
        if (!(str == null || obj2 == null)) {
            hashMap.put(str, new ConstraintAttribute(str, attributeType2, obj2, z));
        }
        obtainStyledAttributes.recycle();
    }

    public static void g(View view, HashMap<String, ConstraintAttribute> hashMap) {
        Class<?> cls = view.getClass();
        for (String str : hashMap.keySet()) {
            ConstraintAttribute constraintAttribute = hashMap.get(str);
            String n02 = !constraintAttribute.a ? a.n0("set", str) : str;
            try {
                switch (constraintAttribute.c.ordinal()) {
                    case 0:
                        cls.getMethod(n02, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.d));
                        break;
                    case 1:
                        cls.getMethod(n02, Float.TYPE).invoke(view, Float.valueOf(constraintAttribute.e));
                        break;
                    case 2:
                        cls.getMethod(n02, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.h));
                        break;
                    case 3:
                        Method method = cls.getMethod(n02, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(constraintAttribute.h);
                        method.invoke(view, colorDrawable);
                        break;
                    case 4:
                        cls.getMethod(n02, CharSequence.class).invoke(view, constraintAttribute.f);
                        break;
                    case 5:
                        cls.getMethod(n02, Boolean.TYPE).invoke(view, Boolean.valueOf(constraintAttribute.g));
                        break;
                    case 6:
                        cls.getMethod(n02, Float.TYPE).invoke(view, Float.valueOf(constraintAttribute.e));
                        break;
                    case 7:
                        cls.getMethod(n02, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.d));
                        break;
                }
            } catch (IllegalAccessException e) {
                StringBuilder T0 = a.T0(" Custom Attribute \"", str, "\" not found on ");
                T0.append(cls.getName());
                Log.e("TransitionLayout", T0.toString());
                e.printStackTrace();
            } catch (NoSuchMethodException e2) {
                Log.e("TransitionLayout", e2.getMessage());
                Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                StringBuilder sb = new StringBuilder();
                sb.append(cls.getName());
                sb.append(" must have a method ");
                sb.append(n02);
                Log.e("TransitionLayout", sb.toString());
            } catch (InvocationTargetException e3) {
                StringBuilder T02 = a.T0(" Custom Attribute \"", str, "\" not found on ");
                T02.append(cls.getName());
                Log.e("TransitionLayout", T02.toString());
                e3.printStackTrace();
            }
        }
    }

    public float b() {
        switch (this.c.ordinal()) {
            case 0:
                return (float) this.d;
            case 1:
                return this.e;
            case 2:
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
                throw new RuntimeException("Cannot interpolate String");
            case 5:
                return this.g ? 1.0f : 0.0f;
            case 6:
                return this.e;
            default:
                return Float.NaN;
        }
    }

    public void c(float[] fArr) {
        switch (this.c.ordinal()) {
            case 0:
                fArr[0] = (float) this.d;
                return;
            case 1:
                fArr[0] = this.e;
                return;
            case 2:
            case 3:
                int i = this.h;
                float pow = (float) Math.pow((double) (((float) ((i >> 16) & 255)) / 255.0f), 2.2d);
                float pow2 = (float) Math.pow((double) (((float) ((i >> 8) & 255)) / 255.0f), 2.2d);
                fArr[0] = pow;
                fArr[1] = pow2;
                fArr[2] = (float) Math.pow((double) (((float) (i & 255)) / 255.0f), 2.2d);
                fArr[3] = ((float) ((i >> 24) & 255)) / 255.0f;
                return;
            case 4:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 5:
                fArr[0] = this.g ? 1.0f : 0.0f;
                return;
            case 6:
                fArr[0] = this.e;
                return;
            default:
                return;
        }
    }

    public boolean d() {
        int ordinal = this.c.ordinal();
        return (ordinal == 4 || ordinal == 5 || ordinal == 7) ? false : true;
    }

    public int e() {
        int ordinal = this.c.ordinal();
        return (ordinal == 2 || ordinal == 3) ? 4 : 1;
    }

    public void h(View view, float[] fArr) {
        Class<?> cls = view.getClass();
        StringBuilder P0 = a.P0("set");
        P0.append(this.b);
        String sb = P0.toString();
        try {
            boolean z = true;
            switch (this.c.ordinal()) {
                case 0:
                    cls.getMethod(sb, Integer.TYPE).invoke(view, Integer.valueOf((int) fArr[0]));
                    return;
                case 1:
                    cls.getMethod(sb, Float.TYPE).invoke(view, Float.valueOf(fArr[0]));
                    return;
                case 2:
                    cls.getMethod(sb, Integer.TYPE).invoke(view, Integer.valueOf((a((int) (((float) Math.pow((double) fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (a((int) (fArr[3] * 255.0f)) << 24) | (a((int) (((float) Math.pow((double) fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | a((int) (((float) Math.pow((double) fArr[2], 0.45454545454545453d)) * 255.0f))));
                    return;
                case 3:
                    Method method = cls.getMethod(sb, Drawable.class);
                    int a = a((int) (((float) Math.pow((double) fArr[0], 0.45454545454545453d)) * 255.0f));
                    int a2 = a((int) (((float) Math.pow((double) fArr[1], 0.45454545454545453d)) * 255.0f));
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor((a << 16) | (a((int) (fArr[3] * 255.0f)) << 24) | (a2 << 8) | a((int) (((float) Math.pow((double) fArr[2], 0.45454545454545453d)) * 255.0f)));
                    method.invoke(view, colorDrawable);
                    return;
                case 4:
                    throw new RuntimeException("unable to interpolate strings " + this.b);
                case 5:
                    Method method2 = cls.getMethod(sb, Boolean.TYPE);
                    Object[] objArr = new Object[1];
                    if (fArr[0] <= 0.5f) {
                        z = false;
                    }
                    objArr[0] = Boolean.valueOf(z);
                    method2.invoke(view, objArr);
                    return;
                case 6:
                    cls.getMethod(sb, Float.TYPE).invoke(view, Float.valueOf(fArr[0]));
                    return;
                default:
                    return;
            }
        } catch (IllegalAccessException e) {
            StringBuilder T0 = a.T0("cannot access method ", sb, " on View \"");
            T0.append(g0.a.b.b.a.O(view));
            T0.append("\"");
            Log.e("TransitionLayout", T0.toString());
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            StringBuilder T02 = a.T0("no method ", sb, " on View \"");
            T02.append(g0.a.b.b.a.O(view));
            T02.append("\"");
            Log.e("TransitionLayout", T02.toString());
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    public void i(Object obj) {
        switch (this.c.ordinal()) {
            case 0:
            case 7:
                this.d = ((Integer) obj).intValue();
                return;
            case 1:
                this.e = ((Float) obj).floatValue();
                return;
            case 2:
            case 3:
                this.h = ((Integer) obj).intValue();
                return;
            case 4:
                this.f = (String) obj;
                return;
            case 5:
                this.g = ((Boolean) obj).booleanValue();
                return;
            case 6:
                this.e = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }

    public ConstraintAttribute(ConstraintAttribute constraintAttribute, Object obj) {
        this.a = false;
        this.b = constraintAttribute.b;
        this.c = constraintAttribute.c;
        i(obj);
    }
}
