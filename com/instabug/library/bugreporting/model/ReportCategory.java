package com.instabug.library.bugreporting.model;
/* loaded from: classes2.dex */
public class ReportCategory {
    private int icon;
    private String label;

    private ReportCategory() {
    }

    public static ReportCategory getInstance() {
        return new ReportCategory();
    }

    public int getIcon() {
        return this.icon;
    }

    public String getLabel() {
        return this.label;
    }

    public void setIcon(int i) {
        this.icon = i;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public ReportCategory withIcon(int i) {
        this.icon = i;
        return this;
    }

    public ReportCategory withLabel(String str) {
        this.label = str;
        return this;
    }
}
