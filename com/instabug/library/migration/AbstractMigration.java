package com.instabug.library.migration;

import android.content.Context;
import k0.b.l;
/* loaded from: classes2.dex */
public abstract class AbstractMigration {
    private String migrationId;

    public AbstractMigration(String str) {
        this.migrationId = str;
    }

    public abstract void doAfterMigration();

    public abstract void doPreMigration();

    public String getMigrationId() {
        return this.migrationId;
    }

    public abstract int getMigrationVersion();

    public abstract void initialize(Context context);

    public abstract l<AbstractMigration> migrate();

    public abstract boolean shouldMigrate();
}
