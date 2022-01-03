package androidx.lifecycle;

import h0.q.o;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public abstract class Lifecycle {
    public AtomicReference<Object> a = new AtomicReference<>();

    /* loaded from: classes.dex */
    public enum Event {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        public static Event downFrom(State state) {
            int ordinal = state.ordinal();
            if (ordinal == 2) {
                return ON_DESTROY;
            }
            if (ordinal == 3) {
                return ON_STOP;
            }
            if (ordinal != 4) {
                return null;
            }
            return ON_PAUSE;
        }

        public static Event downTo(State state) {
            int ordinal = state.ordinal();
            if (ordinal == 0) {
                return ON_DESTROY;
            }
            if (ordinal == 2) {
                return ON_STOP;
            }
            if (ordinal != 3) {
                return null;
            }
            return ON_PAUSE;
        }

        public static Event upFrom(State state) {
            int ordinal = state.ordinal();
            if (ordinal == 1) {
                return ON_CREATE;
            }
            if (ordinal == 2) {
                return ON_START;
            }
            if (ordinal != 3) {
                return null;
            }
            return ON_RESUME;
        }

        public static Event upTo(State state) {
            int ordinal = state.ordinal();
            if (ordinal == 2) {
                return ON_CREATE;
            }
            if (ordinal == 3) {
                return ON_START;
            }
            if (ordinal != 4) {
                return null;
            }
            return ON_RESUME;
        }

        public State getTargetState() {
            int ordinal = ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal == 2) {
                        return State.RESUMED;
                    }
                    if (ordinal != 3) {
                        if (ordinal != 4) {
                            if (ordinal == 5) {
                                return State.DESTROYED;
                            }
                            throw new IllegalArgumentException(this + " has no target state");
                        }
                    }
                }
                return State.STARTED;
            }
            return State.CREATED;
        }
    }

    /* loaded from: classes.dex */
    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean isAtLeast(State state) {
            return compareTo(state) >= 0;
        }
    }

    public abstract void a(o oVar);

    public abstract void b(o oVar);
}
