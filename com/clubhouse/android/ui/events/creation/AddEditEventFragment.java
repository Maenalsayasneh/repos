package com.clubhouse.android.ui.events.creation;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.airbnb.epoxy.EpoxyRecyclerView;
import com.clubhouse.android.data.models.local.user.UserInList;
import com.clubhouse.android.databinding.FragmentAddEditEventBinding;
import com.clubhouse.android.shared.FragmentViewBindingDelegate;
import com.clubhouse.android.ui.creation.ChooseUsersFragment;
import com.clubhouse.android.ui.events.creation.AddEditEventFragment;
import com.clubhouse.android.ui.events.creation.AddEditEventFragment$initHostClub$1$1;
import com.clubhouse.android.ui.events.creation.AddEditEventFragment$showDeleteEventConfirmation$1;
import com.clubhouse.app.R;
import h0.b0.v;
import h0.q.p;
import h0.q.q;
import i0.b.a.o;
import i0.b.b.g;
import i0.b.b.h;
import i0.b.b.x;
import i0.e.b.g3.o.w0.k0;
import i0.e.b.g3.o.w0.t;
import i0.e.b.g3.o.w0.u;
import i0.e.b.g3.o.w0.w;
import j$.time.OffsetDateTime;
import j$.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import m0.c;
import m0.n.a.l;
import m0.n.b.i;
import m0.n.b.m;
import m0.r.d;
import m0.r.k;
/* compiled from: AddEditEventFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001e\u0010\u000bJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000f\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u000bR\u001d\u0010\u0017\u001a\u00020\u00128B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001d\u001a\u00020\u00188B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/clubhouse/android/ui/events/creation/AddEditEventFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Lcom/clubhouse/android/ui/creation/ChooseUsersFragment$a;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "", "Lcom/clubhouse/android/data/models/local/user/UserInList;", "selectedUsers", "v", "(Ljava/util/List;)V", "onPause", "Lcom/clubhouse/android/databinding/FragmentAddEditEventBinding;", "a2", "Lcom/clubhouse/android/shared/FragmentViewBindingDelegate;", "N0", "()Lcom/clubhouse/android/databinding/FragmentAddEditEventBinding;", "binding", "Lcom/clubhouse/android/ui/events/creation/AddEditEventViewModel;", "b2", "Lm0/c;", "O0", "()Lcom/clubhouse/android/ui/events/creation/AddEditEventViewModel;", "viewModel", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class AddEditEventFragment extends Hilt_AddEditEventFragment implements ChooseUsersFragment.a {
    public static final /* synthetic */ k<Object>[] Z1 = {m.c(new PropertyReference1Impl(m.a(AddEditEventFragment.class), "binding", "getBinding()Lcom/clubhouse/android/databinding/FragmentAddEditEventBinding;")), m.c(new PropertyReference1Impl(m.a(AddEditEventFragment.class), "viewModel", "getViewModel()Lcom/clubhouse/android/ui/events/creation/AddEditEventViewModel;"))};
    public final FragmentViewBindingDelegate a2 = new FragmentViewBindingDelegate(FragmentAddEditEventBinding.class, this);
    public final c b2;

    /* compiled from: ViewModelDelegateProvider.kt */
    /* loaded from: classes3.dex */
    public static final class a extends h<AddEditEventFragment, AddEditEventViewModel> {
        public final /* synthetic */ d a;
        public final /* synthetic */ l b;
        public final /* synthetic */ d c;

        public a(d dVar, boolean z, l lVar, d dVar2) {
            this.a = dVar;
            this.b = lVar;
            this.c = dVar2;
        }

        @Override // i0.b.b.h
        public c<AddEditEventViewModel> a(AddEditEventFragment addEditEventFragment, k kVar) {
            AddEditEventFragment addEditEventFragment2 = addEditEventFragment;
            i.e(addEditEventFragment2, "thisRef");
            i.e(kVar, "property");
            return g.a.b(addEditEventFragment2, kVar, this.a, new AddEditEventFragment$special$$inlined$fragmentViewModel$default$2$1(this), m.a(w.class), false, this.b);
        }
    }

    public AddEditEventFragment() {
        super(R.layout.fragment_add_edit_event);
        d a2 = m.a(AddEditEventViewModel.class);
        this.b2 = new a(a2, false, new l<i0.b.b.k<AddEditEventViewModel, w>, AddEditEventViewModel>(a2, a2) { // from class: com.clubhouse.android.ui.events.creation.AddEditEventFragment$special$$inlined$fragmentViewModel$default$1
            public final /* synthetic */ d d;
            public final /* synthetic */ d q;

            {
                this.d = r2;
                this.q = r3;
            }

            /* JADX WARN: Type inference failed for: r15v9, types: [com.clubhouse.android.ui.events.creation.AddEditEventViewModel, com.airbnb.mvrx.MavericksViewModel] */
            @Override // m0.n.a.l
            public AddEditEventViewModel invoke(i0.b.b.k<AddEditEventViewModel, w> kVar) {
                i0.b.b.k<AddEditEventViewModel, w> kVar2 = kVar;
                i.e(kVar2, "stateFactory");
                x xVar = x.a;
                Class l1 = i0.j.f.p.h.l1(this.d);
                h0.o.a.k requireActivity = Fragment.this.requireActivity();
                i.d(requireActivity, "requireActivity()");
                i0.b.b.d dVar = new i0.b.b.d(requireActivity, v.a(Fragment.this), Fragment.this, null, null, 24);
                String name = i0.j.f.p.h.l1(this.q).getName();
                i.d(name, "viewModelClass.java.name");
                return x.a(xVar, l1, w.class, dVar, name, false, kVar2, 16);
            }
        }, a2).a(this, Z1[1]);
    }

    @Override // i0.b.b.q
    public void J() {
        v.v2(O0(), new l<w, m0.i>() { // from class: com.clubhouse.android.ui.events.creation.AddEditEventFragment$invalidate$1
            @Override // m0.n.a.l
            public m0.i invoke(w wVar) {
                String str;
                String str2;
                ZonedDateTime zonedDateTime;
                w wVar2 = wVar;
                i.e(wVar2, "state");
                if (wVar2.q) {
                    AddEditEventFragment addEditEventFragment = AddEditEventFragment.this;
                    k<Object>[] kVarArr = AddEditEventFragment.Z1;
                    addEditEventFragment.N0().x.setText(AddEditEventFragment.this.getResources().getString(R.string.edit_event));
                    AddEditEventFragment.this.N0().w.setText(AddEditEventFragment.this.getResources().getString(R.string.save));
                    Button button = AddEditEventFragment.this.N0().h;
                    i.d(button, "binding.eventDelete");
                    i0.e.b.d3.k.K(button);
                } else {
                    AddEditEventFragment addEditEventFragment2 = AddEditEventFragment.this;
                    k<Object>[] kVarArr2 = AddEditEventFragment.Z1;
                    addEditEventFragment2.N0().x.setText(AddEditEventFragment.this.getResources().getString(R.string.new_event));
                    AddEditEventFragment.this.N0().w.setText(AddEditEventFragment.this.getResources().getString(R.string.publish));
                    Button button2 = AddEditEventFragment.this.N0().h;
                    i.d(button2, "binding.eventDelete");
                    i0.e.b.d3.k.p(button2);
                }
                AddEditEventFragment.this.N0().w.setEnabled(wVar2.r);
                AddEditEventFragment.this.N0().c.g();
                boolean z = true;
                if (wVar2.h) {
                    CalendarView calendarView = AddEditEventFragment.this.N0().f;
                    i.d(calendarView, "binding.eventDatePicker");
                    if ((calendarView.getVisibility() == 8) && wVar2.g != null) {
                        AddEditEventFragment.this.N0().f.setDate(v.m2(wVar2.g));
                        CalendarView calendarView2 = AddEditEventFragment.this.N0().f;
                        AddEditEventFragment addEditEventFragment3 = AddEditEventFragment.this;
                        Objects.requireNonNull(addEditEventFragment3);
                        calendarView2.setOnDateChangeListener(new i0.e.b.g3.o.w0.g(addEditEventFragment3));
                    }
                }
                View view = AddEditEventFragment.this.N0().g;
                i.d(view, "binding.eventDatePickerDivider");
                i0.e.b.d3.k.L(view, Boolean.valueOf(wVar2.h));
                CalendarView calendarView3 = AddEditEventFragment.this.N0().f;
                i.d(calendarView3, "binding.eventDatePicker");
                i0.e.b.d3.k.L(calendarView3, Boolean.valueOf(wVar2.h));
                TextView textView = AddEditEventFragment.this.N0().d;
                Resources resources = AddEditEventFragment.this.getResources();
                boolean z2 = wVar2.h;
                int i = R.color.clubhouse_green;
                textView.setTextColor(resources.getColor(z2 ? R.color.clubhouse_green : R.color.clubhouse_eggshell_dark));
                OffsetDateTime offsetDateTime = wVar2.g;
                String str3 = null;
                if (offsetDateTime == null) {
                    str = null;
                } else {
                    Context requireContext = AddEditEventFragment.this.requireContext();
                    i.d(requireContext, "requireContext()");
                    str = v.J1(offsetDateTime, requireContext);
                }
                AddEditEventFragment.this.N0().d.setText(str);
                if (wVar2.i) {
                    TimePicker timePicker = AddEditEventFragment.this.N0().o;
                    i.d(timePicker, "binding.eventTimePicker");
                    if (timePicker.getVisibility() == 8) {
                        OffsetDateTime offsetDateTime2 = wVar2.g;
                        if (offsetDateTime2 == null) {
                            zonedDateTime = null;
                        } else {
                            zonedDateTime = v.m(offsetDateTime2);
                        }
                        AddEditEventFragment.this.N0().o.setCurrentHour(Integer.valueOf(zonedDateTime == null ? 0 : zonedDateTime.getHour()));
                        AddEditEventFragment.this.N0().o.setCurrentMinute(Integer.valueOf(zonedDateTime == null ? 0 : zonedDateTime.getMinute()));
                    }
                }
                View view2 = AddEditEventFragment.this.N0().p;
                i.d(view2, "binding.eventTimePickerDivider");
                i0.e.b.d3.k.L(view2, Boolean.valueOf(wVar2.i));
                TimePicker timePicker2 = AddEditEventFragment.this.N0().o;
                i.d(timePicker2, "binding.eventTimePicker");
                i0.e.b.d3.k.L(timePicker2, Boolean.valueOf(wVar2.i));
                TextView textView2 = AddEditEventFragment.this.N0().l;
                Resources resources2 = AddEditEventFragment.this.getResources();
                if (!wVar2.i) {
                    i = R.color.clubhouse_eggshell_dark;
                }
                textView2.setTextColor(resources2.getColor(i));
                OffsetDateTime offsetDateTime3 = wVar2.g;
                if (offsetDateTime3 == null) {
                    str2 = null;
                } else {
                    str2 = v.L1(offsetDateTime3);
                }
                AddEditEventFragment.this.N0().l.setText(str2);
                AddEditEventFragment.this.N0().v.setChecked(wVar2.k);
                AddEditEventFragment.this.N0().v.setOnCheckedChangeListener(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0227: INVOKE  
                      (wrap: androidx.appcompat.widget.SwitchCompat : 0x021e: IGET  (r0v37 androidx.appcompat.widget.SwitchCompat A[REMOVE]) = 
                      (wrap: com.clubhouse.android.databinding.FragmentAddEditEventBinding : 0x021a: INVOKE  (r0v36 com.clubhouse.android.databinding.FragmentAddEditEventBinding A[REMOVE]) = 
                      (wrap: com.clubhouse.android.ui.events.creation.AddEditEventFragment : 0x0218: IGET  (r0v35 com.clubhouse.android.ui.events.creation.AddEditEventFragment A[REMOVE]) = (r9v0 'this' com.clubhouse.android.ui.events.creation.AddEditEventFragment$invalidate$1 A[IMMUTABLE_TYPE, THIS]) com.clubhouse.android.ui.events.creation.AddEditEventFragment$invalidate$1.c com.clubhouse.android.ui.events.creation.AddEditEventFragment)
                     type: VIRTUAL call: com.clubhouse.android.ui.events.creation.AddEditEventFragment.N0():com.clubhouse.android.databinding.FragmentAddEditEventBinding)
                     com.clubhouse.android.databinding.FragmentAddEditEventBinding.v androidx.appcompat.widget.SwitchCompat)
                      (wrap: i0.e.b.g3.o.w0.k : 0x0224: CONSTRUCTOR  (r5v10 i0.e.b.g3.o.w0.k A[REMOVE]) = 
                      (wrap: com.clubhouse.android.ui.events.creation.AddEditEventFragment : 0x0220: IGET  (r1v15 com.clubhouse.android.ui.events.creation.AddEditEventFragment A[REMOVE]) = (r9v0 'this' com.clubhouse.android.ui.events.creation.AddEditEventFragment$invalidate$1 A[IMMUTABLE_TYPE, THIS]) com.clubhouse.android.ui.events.creation.AddEditEventFragment$invalidate$1.c com.clubhouse.android.ui.events.creation.AddEditEventFragment)
                     call: i0.e.b.g3.o.w0.k.<init>(com.clubhouse.android.ui.events.creation.AddEditEventFragment):void type: CONSTRUCTOR)
                     type: VIRTUAL call: android.widget.CompoundButton.setOnCheckedChangeListener(android.widget.CompoundButton$OnCheckedChangeListener):void in method: com.clubhouse.android.ui.events.creation.AddEditEventFragment$invalidate$1.invoke(i0.e.b.g3.o.w0.w):m0.i, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:270)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: i0.e.b.g3.o.w0.k, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:974)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:799)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                    	... 15 more
                    */
                /*
                // Method dump skipped, instructions count: 666
                */
                throw new UnsupportedOperationException("Method not decompiled: com.clubhouse.android.ui.events.creation.AddEditEventFragment$invalidate$1.invoke(java.lang.Object):java.lang.Object");
            }
        });
    }

    public final FragmentAddEditEventBinding N0() {
        return (FragmentAddEditEventBinding) this.a2.getValue(this, Z1[0]);
    }

    public final AddEditEventViewModel O0() {
        return (AddEditEventViewModel) this.b2.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        v.x0(this);
        super.onPause();
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.e(view, "view");
        super.onViewCreated(view, bundle);
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(O0().l, new AddEditEventFragment$onViewCreated$1(this, null));
        p viewLifecycleOwner = getViewLifecycleOwner();
        i.d(viewLifecycleOwner, "viewLifecycleOwner");
        m0.r.t.a.r.m.a1.a.F2(flowKt__TransformKt$onEach$$inlined$unsafeTransform$1, q.a(viewLifecycleOwner));
        N0().b.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.o.w0.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AddEditEventFragment addEditEventFragment = AddEditEventFragment.this;
                k<Object>[] kVarArr = AddEditEventFragment.Z1;
                i.e(addEditEventFragment, "this$0");
                i.e(addEditEventFragment, "<this>");
                v.c1(addEditEventFragment);
            }
        });
        TextView textView = N0().w;
        i.d(textView, "binding.publish");
        p viewLifecycleOwner2 = getViewLifecycleOwner();
        i.d(viewLifecycleOwner2, "viewLifecycleOwner");
        i0.e.b.d3.k.H(textView, q.a(viewLifecycleOwner2), new View.OnClickListener() { // from class: i0.e.b.g3.o.w0.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AddEditEventFragment addEditEventFragment = AddEditEventFragment.this;
                k<Object>[] kVarArr = AddEditEventFragment.Z1;
                i.e(addEditEventFragment, "this$0");
                v.x0(addEditEventFragment);
                v.v2(addEditEventFragment.O0(), 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0015: INVOKE  
                      (wrap: com.clubhouse.android.ui.events.creation.AddEditEventViewModel : 0x000c: INVOKE  (r0v2 com.clubhouse.android.ui.events.creation.AddEditEventViewModel A[REMOVE]) = (r3v1 'addEditEventFragment' com.clubhouse.android.ui.events.creation.AddEditEventFragment) type: VIRTUAL call: com.clubhouse.android.ui.events.creation.AddEditEventFragment.O0():com.clubhouse.android.ui.events.creation.AddEditEventViewModel)
                      (wrap: com.clubhouse.android.ui.events.creation.AddEditEventFragment$publishEvent$1 : 0x0012: CONSTRUCTOR  (r1v0 com.clubhouse.android.ui.events.creation.AddEditEventFragment$publishEvent$1 A[REMOVE]) = (r3v1 'addEditEventFragment' com.clubhouse.android.ui.events.creation.AddEditEventFragment) call: com.clubhouse.android.ui.events.creation.AddEditEventFragment$publishEvent$1.<init>(com.clubhouse.android.ui.events.creation.AddEditEventFragment):void type: CONSTRUCTOR)
                     type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: i0.e.b.g3.o.w0.c.onClick(android.view.View):void, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:270)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.events.creation.AddEditEventFragment$publishEvent$1, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:974)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:799)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                    	... 15 more
                    */
                /*
                    this = this;
                    com.clubhouse.android.ui.events.creation.AddEditEventFragment r3 = com.clubhouse.android.ui.events.creation.AddEditEventFragment.this
                    m0.r.k<java.lang.Object>[] r0 = com.clubhouse.android.ui.events.creation.AddEditEventFragment.Z1
                    java.lang.String r0 = "this$0"
                    m0.n.b.i.e(r3, r0)
                    h0.b0.v.x0(r3)
                    com.clubhouse.android.ui.events.creation.AddEditEventViewModel r0 = r3.O0()
                    com.clubhouse.android.ui.events.creation.AddEditEventFragment$publishEvent$1 r1 = new com.clubhouse.android.ui.events.creation.AddEditEventFragment$publishEvent$1
                    r1.<init>(r3)
                    h0.b0.v.v2(r0, r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.o.w0.c.onClick(android.view.View):void");
            }
        });
        i0.e.b.g3.o.w0.a aVar = new View.OnClickListener() { // from class: i0.e.b.g3.o.w0.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AddEditEventFragment addEditEventFragment = AddEditEventFragment.this;
                k<Object>[] kVarArr = AddEditEventFragment.Z1;
                i.e(addEditEventFragment, "this$0");
                addEditEventFragment.O0().p(i0.a);
                v.x0(addEditEventFragment);
            }
        };
        N0().d.setOnClickListener(aVar);
        N0().e.setOnClickListener(aVar);
        i0.e.b.g3.o.w0.i iVar = new View.OnClickListener() { // from class: i0.e.b.g3.o.w0.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AddEditEventFragment addEditEventFragment = AddEditEventFragment.this;
                k<Object>[] kVarArr = AddEditEventFragment.Z1;
                m0.n.b.i.e(addEditEventFragment, "this$0");
                addEditEventFragment.O0().p(j0.a);
                v.x0(addEditEventFragment);
            }
        };
        N0().l.setOnClickListener(iVar);
        N0().n.setOnClickListener(iVar);
        N0().f.setDate(System.currentTimeMillis(), false, true);
        N0().f.setOnDateChangeListener(new i0.e.b.g3.o.w0.g(this));
        N0().o.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() { // from class: i0.e.b.g3.o.w0.j
            @Override // android.widget.TimePicker.OnTimeChangedListener
            public final void onTimeChanged(TimePicker timePicker, int i, int i2) {
                AddEditEventFragment addEditEventFragment = AddEditEventFragment.this;
                k<Object>[] kVarArr = AddEditEventFragment.Z1;
                i.e(addEditEventFragment, "this$0");
                v.v2(addEditEventFragment.O0(), 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: INVOKE  
                      (wrap: com.clubhouse.android.ui.events.creation.AddEditEventViewModel : 0x0009: INVOKE  (r0v2 com.clubhouse.android.ui.events.creation.AddEditEventViewModel A[REMOVE]) = (r3v1 'addEditEventFragment' com.clubhouse.android.ui.events.creation.AddEditEventFragment) type: VIRTUAL call: com.clubhouse.android.ui.events.creation.AddEditEventFragment.O0():com.clubhouse.android.ui.events.creation.AddEditEventViewModel)
                      (wrap: com.clubhouse.android.ui.events.creation.AddEditEventFragment$createTimeChangedListener$1$1 : 0x000f: CONSTRUCTOR  (r1v0 com.clubhouse.android.ui.events.creation.AddEditEventFragment$createTimeChangedListener$1$1 A[REMOVE]) = 
                      (r4v0 'i' int)
                      (r5v0 'i2' int)
                      (r3v1 'addEditEventFragment' com.clubhouse.android.ui.events.creation.AddEditEventFragment)
                     call: com.clubhouse.android.ui.events.creation.AddEditEventFragment$createTimeChangedListener$1$1.<init>(int, int, com.clubhouse.android.ui.events.creation.AddEditEventFragment):void type: CONSTRUCTOR)
                     type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: i0.e.b.g3.o.w0.j.onTimeChanged(android.widget.TimePicker, int, int):void, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:270)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.events.creation.AddEditEventFragment$createTimeChangedListener$1$1, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:974)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:799)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                    	... 15 more
                    */
                /*
                    this = this;
                    com.clubhouse.android.ui.events.creation.AddEditEventFragment r3 = com.clubhouse.android.ui.events.creation.AddEditEventFragment.this
                    m0.r.k<java.lang.Object>[] r0 = com.clubhouse.android.ui.events.creation.AddEditEventFragment.Z1
                    java.lang.String r0 = "this$0"
                    m0.n.b.i.e(r3, r0)
                    com.clubhouse.android.ui.events.creation.AddEditEventViewModel r0 = r3.O0()
                    com.clubhouse.android.ui.events.creation.AddEditEventFragment$createTimeChangedListener$1$1 r1 = new com.clubhouse.android.ui.events.creation.AddEditEventFragment$createTimeChangedListener$1$1
                    r1.<init>(r4, r5, r3)
                    h0.b0.v.v2(r0, r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.o.w0.j.onTimeChanged(android.widget.TimePicker, int, int):void");
            }
        });
        EditText editText = N0().k;
        i.d(editText, "binding.eventName");
        editText.addTextChangedListener(new u(this));
        v.v2(O0(), new l<w, m0.i>() { // from class: com.clubhouse.android.ui.events.creation.AddEditEventFragment$initName$2
            @Override // m0.n.a.l
            public m0.i invoke(w wVar) {
                w wVar2 = wVar;
                i.e(wVar2, "state");
                String str = wVar2.d;
                if (str == null) {
                    return null;
                }
                AddEditEventFragment addEditEventFragment = AddEditEventFragment.this;
                k<Object>[] kVarArr = AddEditEventFragment.Z1;
                addEditEventFragment.N0().k.setText(str);
                return m0.i.a;
            }
        });
        N0().a.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.o.w0.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AddEditEventFragment addEditEventFragment = AddEditEventFragment.this;
                k<Object>[] kVarArr = AddEditEventFragment.Z1;
                i.e(addEditEventFragment, "this$0");
                v.v2(addEditEventFragment.O0(), 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: INVOKE  
                      (wrap: com.clubhouse.android.ui.events.creation.AddEditEventViewModel : 0x0009: INVOKE  (r0v2 com.clubhouse.android.ui.events.creation.AddEditEventViewModel A[REMOVE]) = (r3v1 'addEditEventFragment' com.clubhouse.android.ui.events.creation.AddEditEventFragment) type: VIRTUAL call: com.clubhouse.android.ui.events.creation.AddEditEventFragment.O0():com.clubhouse.android.ui.events.creation.AddEditEventViewModel)
                      (wrap: com.clubhouse.android.ui.events.creation.AddEditEventFragment$initCoHosts$1$1 : 0x000f: CONSTRUCTOR  (r1v0 com.clubhouse.android.ui.events.creation.AddEditEventFragment$initCoHosts$1$1 A[REMOVE]) = (r3v1 'addEditEventFragment' com.clubhouse.android.ui.events.creation.AddEditEventFragment) call: com.clubhouse.android.ui.events.creation.AddEditEventFragment$initCoHosts$1$1.<init>(com.clubhouse.android.ui.events.creation.AddEditEventFragment):void type: CONSTRUCTOR)
                     type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: i0.e.b.g3.o.w0.p.onClick(android.view.View):void, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:270)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.events.creation.AddEditEventFragment$initCoHosts$1$1, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:974)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:799)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                    	... 15 more
                    */
                /*
                    this = this;
                    com.clubhouse.android.ui.events.creation.AddEditEventFragment r3 = com.clubhouse.android.ui.events.creation.AddEditEventFragment.this
                    m0.r.k<java.lang.Object>[] r0 = com.clubhouse.android.ui.events.creation.AddEditEventFragment.Z1
                    java.lang.String r0 = "this$0"
                    m0.n.b.i.e(r3, r0)
                    com.clubhouse.android.ui.events.creation.AddEditEventViewModel r0 = r3.O0()
                    com.clubhouse.android.ui.events.creation.AddEditEventFragment$initCoHosts$1$1 r1 = new com.clubhouse.android.ui.events.creation.AddEditEventFragment$initCoHosts$1$1
                    r1.<init>(r3)
                    h0.b0.v.v2(r0, r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.o.w0.p.onClick(android.view.View):void");
            }
        });
        N0().c.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        EpoxyRecyclerView epoxyRecyclerView = N0().c;
        i.d(epoxyRecyclerView, "binding.coHostsList");
        i0.e.b.d3.k.E(epoxyRecyclerView, new l<o, m0.i>() { // from class: com.clubhouse.android.ui.events.creation.AddEditEventFragment$initCoHosts$2
            @Override // m0.n.a.l
            public m0.i invoke(o oVar) {
                o oVar2 = oVar;
                i.e(oVar2, "$this$safeWithModels");
                AddEditEventFragment addEditEventFragment = AddEditEventFragment.this;
                k<Object>[] kVarArr = AddEditEventFragment.Z1;
                v.v2(addEditEventFragment.O0(), 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0014: INVOKE  
                      (wrap: com.clubhouse.android.ui.events.creation.AddEditEventViewModel : 0x000b: INVOKE  (r1v1 com.clubhouse.android.ui.events.creation.AddEditEventViewModel A[REMOVE]) = (r0v1 'addEditEventFragment' com.clubhouse.android.ui.events.creation.AddEditEventFragment) type: VIRTUAL call: com.clubhouse.android.ui.events.creation.AddEditEventFragment.O0():com.clubhouse.android.ui.events.creation.AddEditEventViewModel)
                      (wrap: com.clubhouse.android.ui.events.creation.AddEditEventFragment$buildCoHostsModels$1 : 0x0011: CONSTRUCTOR  (r2v0 com.clubhouse.android.ui.events.creation.AddEditEventFragment$buildCoHostsModels$1 A[REMOVE]) = (r4v1 'oVar2' i0.b.a.o), (r0v1 'addEditEventFragment' com.clubhouse.android.ui.events.creation.AddEditEventFragment) call: com.clubhouse.android.ui.events.creation.AddEditEventFragment$buildCoHostsModels$1.<init>(i0.b.a.o, com.clubhouse.android.ui.events.creation.AddEditEventFragment):void type: CONSTRUCTOR)
                     type: STATIC call: h0.b0.v.v2(com.airbnb.mvrx.MavericksViewModel, m0.n.a.l):java.lang.Object in method: com.clubhouse.android.ui.events.creation.AddEditEventFragment$initCoHosts$2.invoke(i0.b.a.o):m0.i, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:270)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.events.creation.AddEditEventFragment$buildCoHostsModels$1, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:974)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:799)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                    	... 15 more
                    */
                /*
                    this = this;
                    i0.b.a.o r4 = (i0.b.a.o) r4
                    java.lang.String r0 = "$this$safeWithModels"
                    m0.n.b.i.e(r4, r0)
                    com.clubhouse.android.ui.events.creation.AddEditEventFragment r0 = com.clubhouse.android.ui.events.creation.AddEditEventFragment.this
                    m0.r.k<java.lang.Object>[] r1 = com.clubhouse.android.ui.events.creation.AddEditEventFragment.Z1
                    com.clubhouse.android.ui.events.creation.AddEditEventViewModel r1 = r0.O0()
                    com.clubhouse.android.ui.events.creation.AddEditEventFragment$buildCoHostsModels$1 r2 = new com.clubhouse.android.ui.events.creation.AddEditEventFragment$buildCoHostsModels$1
                    r2.<init>(r4, r0)
                    h0.b0.v.v2(r1, r2)
                    m0.i r4 = m0.i.a
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.clubhouse.android.ui.events.creation.AddEditEventFragment$initCoHosts$2.invoke(java.lang.Object):java.lang.Object");
            }
        });
        N0().s.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.o.w0.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AddEditEventFragment addEditEventFragment = AddEditEventFragment.this;
                k<Object>[] kVarArr = AddEditEventFragment.Z1;
                i.e(addEditEventFragment, "this$0");
                v.G(addEditEventFragment, AddEditEventFragment$initHostClub$1$1.c);
            }
        });
        EditText editText2 = N0().i;
        i.d(editText2, "binding.eventDescription");
        editText2.addTextChangedListener(new t(this));
        N0().i.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: i0.e.b.g3.o.w0.e
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z) {
                AddEditEventFragment addEditEventFragment = AddEditEventFragment.this;
                k<Object>[] kVarArr = AddEditEventFragment.Z1;
                i.e(addEditEventFragment, "this$0");
                if (z) {
                    addEditEventFragment.O0().p(e0.a);
                }
            }
        });
        TextView textView2 = N0().j;
        i.d(textView2, "binding.eventDescriptionRemaining");
        v.v2(O0(), new AddEditEventFragment$updateRemainingDescription$1("", textView2, this));
        v.v2(O0(), new l<w, m0.i>() { // from class: com.clubhouse.android.ui.events.creation.AddEditEventFragment$initDescription$3
            @Override // m0.n.a.l
            public m0.i invoke(w wVar) {
                w wVar2 = wVar;
                i.e(wVar2, "state");
                String str = wVar2.e;
                if (str == null) {
                    return null;
                }
                AddEditEventFragment addEditEventFragment = AddEditEventFragment.this;
                k<Object>[] kVarArr = AddEditEventFragment.Z1;
                addEditEventFragment.N0().i.setText(str);
                return m0.i.a;
            }
        });
        N0().h.setOnClickListener(new View.OnClickListener() { // from class: i0.e.b.g3.o.w0.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AddEditEventFragment addEditEventFragment = AddEditEventFragment.this;
                k<Object>[] kVarArr = AddEditEventFragment.Z1;
                i.e(addEditEventFragment, "this$0");
                AddEditEventFragment$showDeleteEventConfirmation$1 addEditEventFragment$showDeleteEventConfirmation$1 = 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: CONSTRUCTOR  (r0v2 'addEditEventFragment$showDeleteEventConfirmation$1' com.clubhouse.android.ui.events.creation.AddEditEventFragment$showDeleteEventConfirmation$1) = (r4v1 'addEditEventFragment' com.clubhouse.android.ui.events.creation.AddEditEventFragment) call: com.clubhouse.android.ui.events.creation.AddEditEventFragment$showDeleteEventConfirmation$1.<init>(com.clubhouse.android.ui.events.creation.AddEditEventFragment):void type: CONSTRUCTOR in method: i0.e.b.g3.o.w0.d.onClick(android.view.View):void, file: classes3.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:270)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.clubhouse.android.ui.events.creation.AddEditEventFragment$showDeleteEventConfirmation$1, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                    	... 15 more
                    */
                /*
                    this = this;
                    com.clubhouse.android.ui.events.creation.AddEditEventFragment r4 = com.clubhouse.android.ui.events.creation.AddEditEventFragment.this
                    m0.r.k<java.lang.Object>[] r0 = com.clubhouse.android.ui.events.creation.AddEditEventFragment.Z1
                    java.lang.String r0 = "this$0"
                    m0.n.b.i.e(r4, r0)
                    com.clubhouse.android.ui.events.creation.AddEditEventFragment$showDeleteEventConfirmation$1 r0 = new com.clubhouse.android.ui.events.creation.AddEditEventFragment$showDeleteEventConfirmation$1
                    r0.<init>(r4)
                    java.lang.String r1 = "<this>"
                    m0.n.b.i.e(r4, r1)
                    java.lang.String r1 = "f"
                    m0.n.b.i.e(r0, r1)
                    h0.b.a.d$a r1 = new h0.b.a.d$a
                    android.content.Context r4 = r4.requireContext()
                    int r2 = com.clubhouse.core.ui.R.style.Clubhouse_AlertDialog_Rounded
                    r1.<init>(r4, r2)
                    r0.invoke(r1)
                    r1.g()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: i0.e.b.g3.o.w0.d.onClick(android.view.View):void");
            }
        });
    }

    @Override // com.clubhouse.android.ui.creation.ChooseUsersFragment.a
    public void v(List<UserInList> list) {
        i.e(list, "selectedUsers");
        O0().p(new k0(list));
    }
}
