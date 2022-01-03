package com.instabug.library.invocation.invocationdialog;

import com.instabug.library.core.plugin.PluginPromptOption;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class InstabugDialogItem implements Serializable {
    private int badgeCount;
    private String description;
    private int identifier;
    private boolean isInitialScreenshotRequired;
    private int order;
    private InstabugDialogItem parent;
    private int resDrawable;
    private ArrayList<InstabugDialogItem> subItems;
    private String title;

    public InstabugDialogItem() {
    }

    public int getBadgeCount() {
        return this.badgeCount;
    }

    public String getDescription() {
        return this.description;
    }

    @PluginPromptOption.PromptOptionIdentifier
    public int getIdentifier() {
        return this.identifier;
    }

    public int getOrder() {
        return this.order;
    }

    public InstabugDialogItem getParent() {
        return this.parent;
    }

    public int getResDrawable() {
        return this.resDrawable;
    }

    public ArrayList<InstabugDialogItem> getSubItems() {
        return this.subItems;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isInitialScreenshotRequired() {
        return this.isInitialScreenshotRequired;
    }

    public void setBadge(int i) {
        this.badgeCount = i;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setIdentifier(@PluginPromptOption.PromptOptionIdentifier int i) {
        this.identifier = i;
    }

    public void setInitialScreenshotRequired(boolean z) {
        this.isInitialScreenshotRequired = z;
    }

    public void setOrder(int i) {
        this.order = i;
    }

    public void setParent(InstabugDialogItem instabugDialogItem) {
        if (instabugDialogItem != null) {
            this.parent = instabugDialogItem;
        }
    }

    public void setResDrawable(int i) {
        this.resDrawable = i;
    }

    public void setSubItems(ArrayList<InstabugDialogItem> arrayList) {
        this.subItems = arrayList;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public InstabugDialogItem(String str, int i, int i2, boolean z) {
        this.title = str;
        this.badgeCount = i;
        this.resDrawable = i2;
        this.isInitialScreenshotRequired = z;
    }
}
