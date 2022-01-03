package j$.time.format;
/* loaded from: classes5.dex */
public enum l {
    NORMAL,
    ALWAYS,
    NEVER,
    NOT_NEGATIVE,
    EXCEEDS_PAD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k(boolean z, boolean z2, boolean z3) {
        int ordinal = ordinal();
        if (ordinal == 0) {
            return !z || !z2;
        }
        if (ordinal == 1 || ordinal == 4) {
            return true;
        }
        return !z2 && !z3;
    }
}
