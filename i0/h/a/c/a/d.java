package i0.h.a.c.a;

import android.graphics.drawable.Drawable;
import android.util.Property;
import java.util.WeakHashMap;
/* compiled from: DrawableAlphaProperty.java */
/* loaded from: classes2.dex */
public class d extends Property<Drawable, Integer> {
    public static final Property<Drawable, Integer> a = new d();
    public final WeakHashMap<Drawable, Integer> b = new WeakHashMap<>();

    public d() {
        super(Integer.class, "drawableAlphaCompat");
    }

    @Override // android.util.Property
    public Integer get(Drawable drawable) {
        return Integer.valueOf(drawable.getAlpha());
    }

    @Override // android.util.Property
    public void set(Drawable drawable, Integer num) {
        drawable.setAlpha(num.intValue());
    }
}
