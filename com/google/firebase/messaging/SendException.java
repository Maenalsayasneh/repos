package com.google.firebase.messaging;

import java.util.Locale;
/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes2.dex */
public final class SendException extends Exception {
    public SendException(String str) {
        super(str);
        if (str != null) {
            String lowerCase = str.toLowerCase(Locale.US);
            switch (lowerCase.hashCode()) {
                case -1743242157:
                    if (lowerCase.equals("service_not_available")) {
                        return;
                    }
                    break;
                case -1290953729:
                    if (lowerCase.equals("toomanymessages")) {
                        return;
                    }
                    break;
                case -920906446:
                    if (lowerCase.equals("invalid_parameters")) {
                        return;
                    }
                    break;
                case -617027085:
                    if (lowerCase.equals("messagetoobig")) {
                        return;
                    }
                    break;
                case -95047692:
                    if (lowerCase.equals("missing_to")) {
                        return;
                    }
                    break;
            }
        }
    }
}
