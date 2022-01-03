package i0.h.a.b.d;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RecentlyNonNull;
/* compiled from: com.google.android.gms:play-services-basement@@17.5.0 */
/* loaded from: classes2.dex */
public interface c {
    void b();

    void c();

    void e(@RecentlyNonNull Bundle bundle);

    void f();

    void g();

    void i(@RecentlyNonNull Bundle bundle);

    void j(@RecentlyNonNull Activity activity, @RecentlyNonNull Bundle bundle, @RecentlyNonNull Bundle bundle2);

    @RecentlyNonNull
    View k(@RecentlyNonNull LayoutInflater layoutInflater, @RecentlyNonNull ViewGroup viewGroup, @RecentlyNonNull Bundle bundle);

    void onLowMemory();

    void onStart();

    void onStop();
}
