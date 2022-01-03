package com.clubhouse.android.data.models.local.channel;

import i0.e.b.b3.a.b.c.f;
import n0.c.e;
/* compiled from: Message.kt */
@e(with = f.class)
/* loaded from: classes3.dex */
public enum MessageType {
    Unknown("unknown", false, 2, null),
    JoinChannel("join_channel", true),
    LeaveChannel("leave_channel", true),
    AddSpeaker("add_speaker", true),
    RemoveSpeaker("remove_speaker", true),
    EndChannel("end_channel", false, 2, null),
    MakeChannelPublic("make_channel_public", false, 2, null),
    MakeChannelSocial("make_channel_social", false, 2, null),
    RejectWelcomeChannel("reject_welcome_channel", false, 2, null),
    MadeModerator("make_moderator", true),
    ChangeHandraiseSettings("change_handraise_settings", false, 2, null),
    RaiseHand("raise_hands", false, 2, null),
    UnraiseHand("unraise_hands", false, 2, null),
    InviteSpeaker("invite_speaker", false, 2, null),
    UninviteSpeaker("uninvite_speaker", false, 2, null),
    RejectSpeakerInvite("reject_speaker_invite", false, 2, null),
    AcceptSpeakerInvite("accept_speaker_invite", false, 2, null),
    RemoveFromChannel("remove_from_channel", false, 2, null),
    MuteSpeaker("mute_speaker", false, 2, null),
    InviteToNewChannel("invite_to_new_channel", false, 2, null),
    AcceptNewChannelInvite("accept_new_channel_invite", false, 2, null),
    RejectNewChannelInvite("reject_new_channel_invite", false, 2, null),
    CancelNewChannelInvite("cancel_new_channel_invite", false, 2, null),
    ClipsSettingsChanged("clips_settings_changed", false, 2, null);
    
    private final String action;
    private final boolean shouldBatch;

    MessageType(String str, boolean z) {
        this.action = str;
        this.shouldBatch = z;
    }

    public final String getAction() {
        return this.action;
    }

    public final boolean getShouldBatch() {
        return this.shouldBatch;
    }

    /* synthetic */ MessageType(String str, boolean z, int i, m0.n.b.f fVar) {
        this(str, (i & 2) != 0 ? false : z);
    }
}
