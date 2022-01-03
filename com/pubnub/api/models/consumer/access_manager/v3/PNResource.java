package com.pubnub.api.models.consumer.access_manager.v3;
/* loaded from: classes2.dex */
public abstract class PNResource<T> {
    public boolean create;
    public boolean delete;
    public boolean get;
    public boolean join;
    public boolean manage;
    public boolean read;
    public String resourceName;
    public String resourcePattern;
    public boolean update;
    public boolean write;

    /* JADX WARN: Multi-variable type inference failed */
    public T create() {
        this.create = true;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T delete() {
        this.delete = true;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T get() {
        this.get = true;
        return this;
    }

    public String getId() {
        if (isPatternResource()) {
            return this.resourcePattern;
        }
        return this.resourceName;
    }

    public boolean isCreate() {
        return this.create;
    }

    public boolean isDelete() {
        return this.delete;
    }

    public boolean isGet() {
        return this.get;
    }

    public boolean isJoin() {
        return this.join;
    }

    public boolean isManage() {
        return this.manage;
    }

    public boolean isPatternResource() {
        return this.resourcePattern != null;
    }

    public boolean isRead() {
        return this.read;
    }

    public boolean isUpdate() {
        return this.update;
    }

    public boolean isWrite() {
        return this.write;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T join() {
        this.join = true;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T manage() {
        this.manage = true;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T read() {
        this.read = true;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T update() {
        this.update = true;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T write() {
        this.write = true;
        return this;
    }
}
