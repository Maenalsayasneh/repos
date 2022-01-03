package com.clubhouse.android.ui.onboarding;

import android.os.Bundle;
import android.view.View;
import com.afollestad.assent.AssentResult;
import com.afollestad.assent.Permission;
import com.clubhouse.analytics.AmplitudeAnalytics;
import com.clubhouse.android.data.models.local.user.SourceLocation;
import com.clubhouse.android.data.repos.OnboardingRepo;
import com.clubhouse.app.R;
import h0.b0.v;
import i0.a.a.b;
import kotlin.Metadata;
import m0.n.a.l;
import m0.n.b.i;
/* compiled from: ContactsPermissionFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/clubhouse/android/ui/onboarding/ContactsPermissionFragment;", "Lcom/clubhouse/android/core/ui/BaseFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "Lm0/i;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "J", "()V", "Lcom/clubhouse/android/data/repos/OnboardingRepo;", "Z1", "Lcom/clubhouse/android/data/repos/OnboardingRepo;", "getOnboardingRepo", "()Lcom/clubhouse/android/data/repos/OnboardingRepo;", "setOnboardingRepo", "(Lcom/clubhouse/android/data/repos/OnboardingRepo;)V", "onboardingRepo", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class ContactsPermissionFragment extends Hilt_ContactsPermissionFragment {
    public OnboardingRepo Z1;

    public ContactsPermissionFragment() {
        super(R.layout.fragment_contacts_permission);
    }

    @Override // i0.b.b.q
    public void J() {
    }

    @Override // com.clubhouse.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.e(view, "view");
        super.onViewCreated(view, bundle);
        ((AmplitudeAnalytics) v.l(this)).a("Onboarding-ContactPermissions-Start");
        b.a(this, new Permission[]{Permission.READ_CONTACTS}, 0, null, new l<AssentResult, m0.i>() { // from class: com.clubhouse.android.ui.onboarding.ContactsPermissionFragment$onViewCreated$1
            @Override // m0.n.a.l
            public m0.i invoke(AssentResult assentResult) {
                AssentResult assentResult2 = assentResult;
                i.e(assentResult2, "it");
                if (assentResult2.b().contains(Permission.READ_CONTACTS)) {
                    ((AmplitudeAnalytics) v.l(ContactsPermissionFragment.this)).a("Onboarding-Permissions-Contacts-Granted");
                    ContactsPermissionFragment contactsPermissionFragment = ContactsPermissionFragment.this;
                    OnboardingRepo onboardingRepo = contactsPermissionFragment.Z1;
                    if (onboardingRepo != null) {
                        v.b1(contactsPermissionFragment, onboardingRepo.h(SourceLocation.UNKNOWN));
                    } else {
                        i.m("onboardingRepo");
                        throw null;
                    }
                } else {
                    ((AmplitudeAnalytics) v.l(ContactsPermissionFragment.this)).a("Onboarding-Permissions-Contacts-Rejected");
                    ContactsPermissionFragment contactsPermissionFragment2 = ContactsPermissionFragment.this;
                    OnboardingRepo onboardingRepo2 = contactsPermissionFragment2.Z1;
                    if (onboardingRepo2 != null) {
                        v.b1(contactsPermissionFragment2, onboardingRepo2.h(SourceLocation.ONBOARDING_FRIENDS));
                    } else {
                        i.m("onboardingRepo");
                        throw null;
                    }
                }
                ((AmplitudeAnalytics) v.l(ContactsPermissionFragment.this)).a("Onboarding-Permissions-Contacts-Done");
                return m0.i.a;
            }
        }, 6);
    }
}
