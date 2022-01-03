package h0.i.i.h0;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;
/* compiled from: InputContentInfoCompat.java */
/* loaded from: classes.dex */
public final class e {
    public final c a;

    /* compiled from: InputContentInfoCompat.java */
    /* loaded from: classes.dex */
    public static final class b implements c {
        public final Uri a;
        public final ClipDescription b;
        public final Uri c;

        public b(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.a = uri;
            this.b = clipDescription;
            this.c = uri2;
        }

        @Override // h0.i.i.h0.e.c
        public Uri a() {
            return this.a;
        }

        @Override // h0.i.i.h0.e.c
        public void b() {
        }

        @Override // h0.i.i.h0.e.c
        public Uri c() {
            return this.c;
        }

        @Override // h0.i.i.h0.e.c
        public Object d() {
            return null;
        }

        @Override // h0.i.i.h0.e.c
        public ClipDescription getDescription() {
            return this.b;
        }
    }

    /* compiled from: InputContentInfoCompat.java */
    /* loaded from: classes.dex */
    public interface c {
        Uri a();

        void b();

        Uri c();

        Object d();

        ClipDescription getDescription();
    }

    public e(c cVar) {
        this.a = cVar;
    }

    /* compiled from: InputContentInfoCompat.java */
    /* loaded from: classes.dex */
    public static final class a implements c {
        public final InputContentInfo a;

        public a(Object obj) {
            this.a = (InputContentInfo) obj;
        }

        @Override // h0.i.i.h0.e.c
        public Uri a() {
            return this.a.getContentUri();
        }

        @Override // h0.i.i.h0.e.c
        public void b() {
            this.a.requestPermission();
        }

        @Override // h0.i.i.h0.e.c
        public Uri c() {
            return this.a.getLinkUri();
        }

        @Override // h0.i.i.h0.e.c
        public Object d() {
            return this.a;
        }

        @Override // h0.i.i.h0.e.c
        public ClipDescription getDescription() {
            return this.a.getDescription();
        }

        public a(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.a = new InputContentInfo(uri, clipDescription, uri2);
        }
    }
}
