package com.instabug.library.internal.media;

import android.media.MediaPlayer;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes2.dex */
public class AudioPlayer {
    public static final String TAG = "AudioPlayer";
    private String filePath;
    private MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener onCompletionListener;
    private e onGetDurationListener;
    private final Map<String, OnStopListener> onStopListeners = new HashMap();

    /* loaded from: classes2.dex */
    public static abstract class OnStopListener {
        private String filePath;

        public OnStopListener(String str) {
            this.filePath = str;
        }

        public String getFilePath() {
            return this.filePath;
        }

        public abstract void onStop();
    }

    /* loaded from: classes2.dex */
    public class a implements MediaPlayer.OnPreparedListener {
        public final /* synthetic */ d a;

        public a(d dVar) {
            this.a = dVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            AudioPlayer.this.doAction(this.a);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements MediaPlayer.OnCompletionListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            AudioPlayer.this.notifyOnStopListeners();
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            d.values();
            int[] iArr = new int[3];
            a = iArr;
            try {
                iArr[d.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[d.GET_DURATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum d {
        START,
        PAUSE,
        GET_DURATION
    }

    /* loaded from: classes2.dex */
    public interface e {
        void e(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAction(d dVar) {
        e eVar;
        MediaPlayer mediaPlayer;
        int i = c.a[dVar.ordinal()];
        if (i == 1) {
            MediaPlayer mediaPlayer2 = this.mediaPlayer;
            if (mediaPlayer2 != null && !mediaPlayer2.isPlaying()) {
                this.mediaPlayer.start();
            }
        } else if (i == 2) {
            MediaPlayer mediaPlayer3 = this.mediaPlayer;
            if (mediaPlayer3 != null && mediaPlayer3.isPlaying()) {
                this.mediaPlayer.pause();
            }
        } else if (i == 3 && (eVar = this.onGetDurationListener) != null && (mediaPlayer = this.mediaPlayer) != null) {
            eVar.e(mediaPlayer.getDuration());
        }
    }

    public static String getFormattedDurationText(long j) {
        int i = (int) (j / 3600000);
        int i2 = (int) ((j % 3600000) / 60000);
        int i3 = (int) ((j % 60000) / 1000);
        if (i > 0) {
            return String.format(Locale.getDefault(), "%02d:%02d:%02d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        }
        return String.format(Locale.getDefault(), "%02d:%02d", Integer.valueOf(i2), Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnStopListeners() {
        for (OnStopListener onStopListener : this.onStopListeners.values()) {
            onStopListener.onStop();
        }
    }

    private void prepare(d dVar) {
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.mediaPlayer = mediaPlayer;
            String str = this.filePath;
            if (str != null) {
                mediaPlayer.setDataSource(str);
            }
            this.mediaPlayer.setOnPreparedListener(new a(dVar));
            this.mediaPlayer.prepareAsync();
            MediaPlayer.OnCompletionListener onCompletionListener = this.onCompletionListener;
            if (onCompletionListener != null) {
                this.mediaPlayer.setOnCompletionListener(onCompletionListener);
            }
        } catch (IOException e2) {
            InstabugSDKLogger.e(TAG, "Playing audio file failed", e2);
        }
    }

    private void stream(String str, d dVar) {
        if (str == null) {
            InstabugSDKLogger.e(TAG, "Audio file path can not be null");
        } else if (str.equals(this.filePath)) {
            doAction(dVar);
        } else {
            this.filePath = str;
            prepare(dVar);
        }
    }

    public void addOnStopListener(OnStopListener onStopListener) {
        this.onStopListeners.put(onStopListener.getFilePath(), onStopListener);
        if (this.onCompletionListener == null) {
            b bVar = new b();
            this.onCompletionListener = bVar;
            MediaPlayer mediaPlayer = this.mediaPlayer;
            if (mediaPlayer != null) {
                mediaPlayer.setOnCompletionListener(bVar);
            }
        }
    }

    public void getDurationAsync(String str, e eVar) {
        stream(str, d.GET_DURATION);
        this.onGetDurationListener = eVar;
    }

    public void pause() {
        notifyOnStopListeners();
        doAction(d.PAUSE);
    }

    public void release() {
        this.filePath = null;
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.mediaPlayer.stop();
            }
            this.mediaPlayer.release();
            this.mediaPlayer = null;
        }
    }

    public void start(String str) {
        pause();
        stream(str, d.START);
    }
}
