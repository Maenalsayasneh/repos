package com.instabug.library.ui.custom.pagerindicator;
/* loaded from: classes2.dex */
public interface SelectionIndicator {
    int getNumberOfItems();

    int getSelectedItemIndex();

    int getTransitionDuration();

    boolean isVisible();

    void setNumberOfItems(int i);

    void setSelectedItem(int i, boolean z);

    void setTransitionDuration(int i);

    void setVisibility(boolean z);
}
