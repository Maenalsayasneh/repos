package com.fasterxml.jackson.databind.util;

import java.io.Serializable;
/* loaded from: classes2.dex */
public class ViewMatcher implements Serializable {
    public static final ViewMatcher c = new ViewMatcher();

    /* loaded from: classes2.dex */
    public static final class Multi extends ViewMatcher implements Serializable {
        public final Class<?>[] d;

        public Multi(Class<?>[] clsArr) {
            this.d = clsArr;
        }

        @Override // com.fasterxml.jackson.databind.util.ViewMatcher
        public boolean a(Class<?> cls) {
            int length = this.d.length;
            for (int i = 0; i < length; i++) {
                Class<?> cls2 = this.d[i];
                if (cls == cls2 || cls2.isAssignableFrom(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public static final class Single extends ViewMatcher {
        public final Class<?> d;

        public Single(Class<?> cls) {
            this.d = cls;
        }

        @Override // com.fasterxml.jackson.databind.util.ViewMatcher
        public boolean a(Class<?> cls) {
            Class<?> cls2 = this.d;
            return cls == cls2 || cls2.isAssignableFrom(cls);
        }
    }

    public boolean a(Class<?> cls) {
        return false;
    }
}
