package i0.h.a.c.c;

import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.badge.BadgeDrawable;
/* compiled from: BadgeUtils.java */
/* loaded from: classes2.dex */
public class a {
    public static void a(BadgeDrawable badgeDrawable, View view, FrameLayout frameLayout) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        badgeDrawable.setBounds(rect);
        badgeDrawable.m(view, null);
        if (badgeDrawable.g() != null) {
            badgeDrawable.g().setForeground(badgeDrawable);
        } else {
            view.getOverlay().add(badgeDrawable);
        }
    }

    public static void b(BadgeDrawable badgeDrawable, View view) {
        if (badgeDrawable != null) {
            if (badgeDrawable.g() != null) {
                badgeDrawable.g().setForeground(null);
            } else {
                view.getOverlay().remove(badgeDrawable);
            }
        }
    }
}
