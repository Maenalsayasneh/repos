package h0.w.k;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* compiled from: CopyLock.java */
/* loaded from: classes.dex */
public class a {
    public static final Map<String, Lock> a = new HashMap();
    public final File b;
    public final Lock c;
    public final boolean d;
    public FileChannel e;

    public a(String str, File file, boolean z) {
        Lock lock;
        File file2 = new File(file, i0.d.a.a.a.n0(str, ".lck"));
        this.b = file2;
        String absolutePath = file2.getAbsolutePath();
        Map<String, Lock> map = a;
        synchronized (map) {
            lock = map.get(absolutePath);
            if (lock == null) {
                lock = new ReentrantLock();
                map.put(absolutePath, lock);
            }
        }
        this.c = lock;
        this.d = z;
    }

    public void a() {
        FileChannel fileChannel = this.e;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
        }
        this.c.unlock();
    }
}
