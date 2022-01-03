package h0.j.a;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import h0.j.a.b;
/* compiled from: CursorAdapter.java */
/* loaded from: classes.dex */
public abstract class a extends BaseAdapter implements Filterable, b.a {
    public C0080a Y1;
    public DataSetObserver Z1;
    public b a2;
    public boolean c;
    public boolean d;
    public Cursor q;
    public Context x;
    public int y;

    /* compiled from: CursorAdapter.java */
    /* renamed from: h0.j.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0080a extends ContentObserver {
        public C0080a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Cursor cursor;
            a aVar = a.this;
            if (aVar.d && (cursor = aVar.q) != null && !cursor.isClosed()) {
                aVar.c = aVar.q.requery();
            }
        }
    }

    /* compiled from: CursorAdapter.java */
    /* loaded from: classes.dex */
    public class b extends DataSetObserver {
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.c = true;
            aVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            a aVar = a.this;
            aVar.c = false;
            aVar.notifyDataSetInvalidated();
        }
    }

    public a(Context context, Cursor cursor, boolean z) {
        boolean z2 = true;
        boolean z3 = z ? true : true;
        if (z3 && true) {
            z3 |= true;
            this.d = true;
        } else {
            this.d = false;
        }
        z2 = cursor == null ? false : z2;
        this.q = cursor;
        this.c = z2;
        this.x = context;
        this.y = z2 ? cursor.getColumnIndexOrThrow(InstabugDbContract.FeatureRequestEntry.COLUMN_ID) : -1;
        if (z3 & true) {
            this.Y1 = new C0080a();
            this.Z1 = new b();
        } else {
            this.Y1 = null;
            this.Z1 = null;
        }
        if (z2) {
            C0080a aVar = this.Y1;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.Z1;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract void a(View view, Context context, Cursor cursor);

    public void b(Cursor cursor) {
        Cursor cursor2 = this.q;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                C0080a aVar = this.Y1;
                if (aVar != null) {
                    cursor2.unregisterContentObserver(aVar);
                }
                DataSetObserver dataSetObserver = this.Z1;
                if (dataSetObserver != null) {
                    cursor2.unregisterDataSetObserver(dataSetObserver);
                }
            }
            this.q = cursor;
            if (cursor != null) {
                C0080a aVar2 = this.Y1;
                if (aVar2 != null) {
                    cursor.registerContentObserver(aVar2);
                }
                DataSetObserver dataSetObserver2 = this.Z1;
                if (dataSetObserver2 != null) {
                    cursor.registerDataSetObserver(dataSetObserver2);
                }
                this.y = cursor.getColumnIndexOrThrow(InstabugDbContract.FeatureRequestEntry.COLUMN_ID);
                this.c = true;
                notifyDataSetChanged();
            } else {
                this.y = -1;
                this.c = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public abstract CharSequence c(Cursor cursor);

    public abstract View d(Context context, Cursor cursor, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.c || (cursor = this.q) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.c) {
            return null;
        }
        this.q.moveToPosition(i);
        if (view == null) {
            c cVar = (c) this;
            view = cVar.d2.inflate(cVar.c2, viewGroup, false);
        }
        a(view, this.x, this.q);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.a2 == null) {
            this.a2 = new b(this);
        }
        return this.a2;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Cursor cursor;
        if (!this.c || (cursor = this.q) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.q;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        Cursor cursor;
        if (!this.c || (cursor = this.q) == null || !cursor.moveToPosition(i)) {
            return 0;
        }
        return this.q.getLong(this.y);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.c) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.q.moveToPosition(i)) {
            if (view == null) {
                view = d(this.x, this.q, viewGroup);
            }
            a(view, this.x, this.q);
            return view;
        } else {
            throw new IllegalStateException(i0.d.a.a.a.e0("couldn't move cursor to position ", i));
        }
    }
}
