package i0.j.e.l0.b.k;

import com.instabug.library.util.TimeUtils;
import i0.j.e.l0.b.j.e;
import java.io.File;
/* compiled from: FileRecord.java */
/* loaded from: classes2.dex */
public class f implements e<File> {
    public final File a;

    public f(File file) {
        this.a = file;
    }

    public long a() {
        return TimeUtils.currentTimeMillis() - this.a.lastModified();
    }
}
