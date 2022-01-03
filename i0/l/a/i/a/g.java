package i0.l.a.i.a;

import java.io.IOException;
/* compiled from: JStylerObj.java */
/* loaded from: classes2.dex */
public class g {
    public static final e a = new e(null);
    public static final f b = new f(null);
    public static final d c = new d(null);
    public static final c d = new c(null);
    public static final b e = new b(null);

    /* compiled from: JStylerObj.java */
    /* loaded from: classes2.dex */
    public static class b implements h {
        public b(a aVar) {
        }

        @Override // i0.l.a.i.a.g.h
        public void a(String str, Appendable appendable) {
            try {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (charAt == '\f') {
                        appendable.append("\\f");
                    } else if (charAt == '\r') {
                        appendable.append("\\r");
                    } else if (charAt == '\"') {
                        appendable.append("\\\"");
                    } else if (charAt == '/') {
                        appendable.append("\\/");
                    } else if (charAt != '\\') {
                        switch (charAt) {
                            case '\b':
                                appendable.append("\\b");
                                continue;
                            case '\t':
                                appendable.append("\\t");
                                continue;
                            case '\n':
                                appendable.append("\\n");
                                continue;
                            default:
                                if ((charAt < 0 || charAt > 31) && ((charAt < 127 || charAt > 159) && (charAt < 8192 || charAt > 8447))) {
                                    appendable.append(charAt);
                                    break;
                                } else {
                                    appendable.append("\\u");
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> '\f') & 15));
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> '\b') & 15));
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> 4) & 15));
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> 0) & 15));
                                    continue;
                                }
                                break;
                        }
                    } else {
                        appendable.append("\\\\");
                    }
                }
            } catch (IOException unused) {
                throw new RuntimeException("Impossible Error");
            }
        }
    }

    /* compiled from: JStylerObj.java */
    /* loaded from: classes2.dex */
    public static class c implements h {
        public c(a aVar) {
        }

        @Override // i0.l.a.i.a.g.h
        public void a(String str, Appendable appendable) {
            try {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (charAt == '\f') {
                        appendable.append("\\f");
                    } else if (charAt == '\r') {
                        appendable.append("\\r");
                    } else if (charAt == '\"') {
                        appendable.append("\\\"");
                    } else if (charAt != '\\') {
                        switch (charAt) {
                            case '\b':
                                appendable.append("\\b");
                                continue;
                            case '\t':
                                appendable.append("\\t");
                                continue;
                            case '\n':
                                appendable.append("\\n");
                                continue;
                            default:
                                if ((charAt < 0 || charAt > 31) && ((charAt < 127 || charAt > 159) && (charAt < 8192 || charAt > 8447))) {
                                    appendable.append(charAt);
                                    break;
                                } else {
                                    appendable.append("\\u");
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> '\f') & 15));
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> '\b') & 15));
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> 4) & 15));
                                    appendable.append("0123456789ABCDEF".charAt((charAt >> 0) & 15));
                                    continue;
                                }
                        }
                    } else {
                        appendable.append("\\\\");
                    }
                }
            } catch (IOException unused) {
                throw new RuntimeException("Impossible Exeption");
            }
        }
    }

    /* compiled from: JStylerObj.java */
    /* loaded from: classes2.dex */
    public static class d implements AbstractC0208g {
        public d(a aVar) {
        }

        /* JADX WARN: Code restructure failed: missing block: B:48:0x0078, code lost:
            if (r3 == '.') goto L_0x007a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x007a, code lost:
            r7 = r7 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x007c, code lost:
            if (r7 >= r1) goto L_0x0086;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x007e, code lost:
            r3 = r10.charAt(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0082, code lost:
            if (r3 < '0') goto L_0x0086;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x0084, code lost:
            if (r3 <= '9') goto L_0x007a;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x0086, code lost:
            if (r7 != r1) goto L_0x0089;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0088, code lost:
            return true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x008b, code lost:
            if (r3 == 'E') goto L_0x0091;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x008f, code lost:
            if (r3 != 'e') goto L_0x00a5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x0091, code lost:
            r7 = r7 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x0093, code lost:
            if (r7 != r1) goto L_0x0096;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x0095, code lost:
            return false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0096, code lost:
            r3 = r10.charAt(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x009c, code lost:
            if (r3 == '+') goto L_0x00a0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x009e, code lost:
            if (r3 != '-') goto L_0x00a5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x00a0, code lost:
            r7 = r7 + 1;
            r10.charAt(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00a5, code lost:
            if (r7 != r1) goto L_0x00a8;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00a7, code lost:
            return false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x00a8, code lost:
            if (r7 >= r1) goto L_0x00b6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x00aa, code lost:
            r3 = r10.charAt(r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x00ae, code lost:
            if (r3 < '0') goto L_0x00b6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x00b0, code lost:
            if (r3 <= '9') goto L_0x00b3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x00b3, code lost:
            r7 = r7 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:74:0x00b6, code lost:
            if (r7 != r1) goto L_0x00b9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x00b8, code lost:
            return true;
         */
        @Override // i0.l.a.i.a.g.AbstractC0208g
        /* Code decompiled incorrectly, please refer to instructions dump */
        public boolean a(String str) {
            if (str == null) {
                return false;
            }
            int length = str.length();
            if (length == 0 || str.trim() != str) {
                return true;
            }
            char charAt = str.charAt(0);
            if (g.b(charAt) || g.c(charAt)) {
                return true;
            }
            for (int i = 1; i < length; i++) {
                char charAt2 = str.charAt(i);
                if ((charAt2 == '}' || charAt2 == ']' || charAt2 == ',' || charAt2 == ':') || g.c(charAt2)) {
                    return true;
                }
            }
            if (g.a(str)) {
                return true;
            }
            char charAt3 = str.charAt(0);
            if ((charAt3 >= '0' && charAt3 <= '9') || charAt3 == '-') {
                int i2 = 1;
                while (i2 < length) {
                    charAt3 = str.charAt(i2);
                    if (charAt3 < '0' || charAt3 > '9') {
                        break;
                    }
                    i2++;
                }
                if (i2 == length) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: JStylerObj.java */
    /* loaded from: classes2.dex */
    public static class e implements AbstractC0208g {
        public e(a aVar) {
        }

        @Override // i0.l.a.i.a.g.AbstractC0208g
        public boolean a(String str) {
            if (str == null) {
                return false;
            }
            int length = str.length();
            if (length == 0 || str.trim() != str) {
                return true;
            }
            char charAt = str.charAt(0);
            if ((charAt >= '0' && charAt <= '9') || charAt == '-') {
                return true;
            }
            for (int i = 0; i < length; i++) {
                char charAt2 = str.charAt(i);
                if ((charAt2 == '\r' || charAt2 == '\n' || charAt2 == '\t' || charAt2 == ' ') || g.b(charAt2)) {
                    return true;
                }
                if ((charAt2 == '\b' || charAt2 == '\f' || charAt2 == '\n') || g.c(charAt2)) {
                    return true;
                }
            }
            return g.a(str);
        }
    }

    /* compiled from: JStylerObj.java */
    /* loaded from: classes2.dex */
    public static class f implements AbstractC0208g {
        public f(a aVar) {
        }

        @Override // i0.l.a.i.a.g.AbstractC0208g
        public boolean a(String str) {
            return true;
        }
    }

    /* compiled from: JStylerObj.java */
    /* renamed from: i0.l.a.i.a.g$g  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface AbstractC0208g {
        boolean a(String str);
    }

    /* compiled from: JStylerObj.java */
    /* loaded from: classes2.dex */
    public interface h {
        void a(String str, Appendable appendable);
    }

    public static boolean a(String str) {
        if (str.length() < 3) {
            return false;
        }
        char charAt = str.charAt(0);
        if (charAt == 'n') {
            return str.equals("null");
        }
        if (charAt == 't') {
            return str.equals("true");
        }
        if (charAt == 'f') {
            return str.equals("false");
        }
        if (charAt == 'N') {
            return str.equals("NaN");
        }
        return false;
    }

    public static boolean b(char c2) {
        return c2 == '{' || c2 == '[' || c2 == ',' || c2 == '}' || c2 == ']' || c2 == ':' || c2 == '\'' || c2 == '\"';
    }

    public static boolean c(char c2) {
        return (c2 >= 0 && c2 <= 31) || (c2 >= 127 && c2 <= 159) || (c2 >= 8192 && c2 <= 8447);
    }
}
