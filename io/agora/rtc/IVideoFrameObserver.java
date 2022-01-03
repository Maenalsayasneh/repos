package io.agora.rtc;

import i0.d.a.a.a;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public abstract class IVideoFrameObserver {
    public static final int FRAME_TYPE_RGBA = 2;
    public static final int FRAME_TYPE_YUV420 = 0;
    public static final int FRAME_TYPE_YUV422 = 1;
    public static final int POSITION_POST_CAPTURER = 1;
    public static final int POSITION_PRE_ENCODER = 4;
    public static final int POSITION_PRE_RENDERER = 2;

    /* loaded from: classes4.dex */
    public static class VideoFrame {
        public int avsync_type;
        public int height;
        public long renderTimeMs;
        public int rotation;
        public int type;
        public ByteBuffer uBuffer;
        public int uStride;
        public ByteBuffer vBuffer;
        public int vStride;
        public int width;
        public ByteBuffer yBuffer;
        public int yStride;

        public VideoFrame(int i, int i2, int i3, int i4, int i5, int i6, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i7, long j, int i8) {
            this.type = i;
            this.width = i2;
            this.height = i3;
            this.yStride = i4;
            this.uStride = i5;
            this.vStride = i6;
            this.yBuffer = byteBuffer;
            this.uBuffer = byteBuffer2;
            this.vBuffer = byteBuffer3;
            this.rotation = i7;
            this.renderTimeMs = j;
            this.avsync_type = i8;
        }

        public String toString() {
            String str;
            String str2;
            StringBuilder P0 = a.P0("VideoFrame{type=");
            P0.append(this.type);
            P0.append(", width=");
            P0.append(this.width);
            P0.append(", height=");
            P0.append(this.height);
            P0.append(", yStride=");
            P0.append(this.yStride);
            P0.append(", uStride=");
            P0.append(this.uStride);
            P0.append(", vStride=");
            P0.append(this.vStride);
            P0.append(", yBuffer=");
            ByteBuffer byteBuffer = this.yBuffer;
            String str3 = "null";
            if (byteBuffer == null) {
                str = str3;
            } else {
                str = byteBuffer.toString();
            }
            P0.append(str);
            P0.append(", uBuffer=");
            ByteBuffer byteBuffer2 = this.uBuffer;
            if (byteBuffer2 == null) {
                str2 = str3;
            } else {
                str2 = byteBuffer2.toString();
            }
            P0.append(str2);
            P0.append(", vBuffer=");
            ByteBuffer byteBuffer3 = this.vBuffer;
            if (byteBuffer3 != null) {
                str3 = byteBuffer3.toString();
            }
            P0.append(str3);
            P0.append(", rotation=");
            P0.append(this.rotation);
            P0.append(", renderTimeMs=");
            P0.append(this.renderTimeMs);
            P0.append(", avsync_type=");
            return a.s0(P0, this.avsync_type, '}');
        }
    }

    public boolean getMirrorApplied() {
        return false;
    }

    public int getObservedFramePosition() {
        return 3;
    }

    public boolean getRotationApplied() {
        return false;
    }

    public int getVideoFormatPreference() {
        return 0;
    }

    public boolean isMultipleChannelFrameWanted() {
        return false;
    }

    public abstract boolean onCaptureVideoFrame(VideoFrame videoFrame);

    public boolean onPreEncodeVideoFrame(VideoFrame videoFrame) {
        return true;
    }

    public abstract boolean onRenderVideoFrame(int i, VideoFrame videoFrame);

    public boolean onRenderVideoFrameEx(String str, int i, VideoFrame videoFrame) {
        return true;
    }
}
