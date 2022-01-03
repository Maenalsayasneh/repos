package com.instabug.library.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import com.instabug.library.R;
/* loaded from: classes2.dex */
public class AttrResolver {
    public static int getBackgroundColor(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.instabug_background_color, typedValue, true);
        return typedValue.data;
    }

    public static int getColor(Context context, int i) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i});
        int color = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        return color;
    }

    public static int getDialogItemTextColor(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.instabug_dialog_item_text_color, typedValue, true);
        return typedValue.data;
    }

    public static int getDividerColor(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.instabug_divider_color, typedValue, true);
        return typedValue.data;
    }

    public static int getDrawableResourceId(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public static int getTintingColor(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.instabug_theme_tinting_color, typedValue, true);
        return typedValue.data;
    }

    public static int resolveAttributeColor(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.data;
    }
}
