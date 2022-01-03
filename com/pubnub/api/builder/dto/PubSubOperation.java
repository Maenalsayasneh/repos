package com.pubnub.api.builder.dto;
/* loaded from: classes2.dex */
public interface PubSubOperation {
    public static final PubSubOperation NO_OP = new NoOpOperation();
    public static final PubSubOperation DISCONNECT = new DisconnectOperation();
    public static final PubSubOperation STATUS_ANNOUNCED = new ConnectedStatusAnnouncedOperation();

    /* loaded from: classes2.dex */
    public static class ConnectedStatusAnnouncedOperation implements PubSubOperation {
        public boolean canEqual(Object obj) {
            return obj instanceof ConnectedStatusAnnouncedOperation;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return (obj instanceof ConnectedStatusAnnouncedOperation) && ((ConnectedStatusAnnouncedOperation) obj).canEqual(this);
        }

        public int hashCode() {
            return 1;
        }

        public String toString() {
            return "PubSubOperation.ConnectedStatusAnnouncedOperation()";
        }

        private ConnectedStatusAnnouncedOperation() {
        }
    }

    /* loaded from: classes2.dex */
    public static class DisconnectOperation implements PubSubOperation {
        public boolean canEqual(Object obj) {
            return obj instanceof DisconnectOperation;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return (obj instanceof DisconnectOperation) && ((DisconnectOperation) obj).canEqual(this);
        }

        public int hashCode() {
            return 1;
        }

        public String toString() {
            return "PubSubOperation.DisconnectOperation()";
        }

        private DisconnectOperation() {
        }
    }

    /* loaded from: classes2.dex */
    public static class NoOpOperation implements PubSubOperation {
        public boolean canEqual(Object obj) {
            return obj instanceof NoOpOperation;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return (obj instanceof NoOpOperation) && ((NoOpOperation) obj).canEqual(this);
        }

        public int hashCode() {
            return 1;
        }

        public String toString() {
            return "PubSubOperation.NoOpOperation()";
        }

        private NoOpOperation() {
        }
    }
}
