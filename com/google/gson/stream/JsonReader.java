package com.google.gson.stream;

import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import i0.d.a.a.a;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
/* loaded from: classes2.dex */
public class JsonReader implements Closeable {
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final char[] NON_EXECUTE_PREFIX = ")]}'\n".toCharArray();
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 17;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 15;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 16;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private final Reader in;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private int[] stack;
    private int stackSize;
    private boolean lenient = false;
    private final char[] buffer = new char[RecyclerView.b0.FLAG_ADAPTER_FULLUPDATE];
    private int pos = 0;
    private int limit = 0;
    private int lineNumber = 0;
    private int lineStart = 0;
    public int peeked = 0;
    private String[] pathNames = new String[32];
    private int[] pathIndices = new int[32];

    static {
        JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess() { // from class: com.google.gson.stream.JsonReader.1
            @Override // com.google.gson.internal.JsonReaderInternalAccess
            public void promoteNameToValue(JsonReader jsonReader) throws IOException {
                if (jsonReader instanceof JsonTreeReader) {
                    ((JsonTreeReader) jsonReader).promoteNameToValue();
                    return;
                }
                int i = jsonReader.peeked;
                if (i == 0) {
                    i = jsonReader.doPeek();
                }
                if (i == 13) {
                    jsonReader.peeked = 9;
                } else if (i == 12) {
                    jsonReader.peeked = 8;
                } else if (i == 14) {
                    jsonReader.peeked = 10;
                } else {
                    StringBuilder P0 = a.P0("Expected a name but was ");
                    P0.append(jsonReader.peek());
                    P0.append(jsonReader.locationString());
                    throw new IllegalStateException(P0.toString());
                }
            }
        };
    }

    public JsonReader(Reader reader) {
        int[] iArr = new int[32];
        this.stack = iArr;
        this.stackSize = 0;
        this.stackSize = 0 + 1;
        iArr[0] = 6;
        Objects.requireNonNull(reader, "in == null");
        this.in = reader;
    }

    private void checkLenient() throws IOException {
        if (!this.lenient) {
            throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void consumeNonExecutePrefix() throws IOException {
        nextNonWhitespace(true);
        int i = this.pos - 1;
        this.pos = i;
        char[] cArr = NON_EXECUTE_PREFIX;
        if (i + cArr.length <= this.limit || fillBuffer(cArr.length)) {
            int i2 = 0;
            while (true) {
                char[] cArr2 = NON_EXECUTE_PREFIX;
                if (i2 >= cArr2.length) {
                    this.pos += cArr2.length;
                    return;
                } else if (this.buffer[this.pos + i2] == cArr2[i2]) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    private boolean fillBuffer(int i) throws IOException {
        int i2;
        int i3;
        char[] cArr = this.buffer;
        int i4 = this.lineStart;
        int i5 = this.pos;
        this.lineStart = i4 - i5;
        int i6 = this.limit;
        if (i6 != i5) {
            int i7 = i6 - i5;
            this.limit = i7;
            System.arraycopy(cArr, i5, cArr, 0, i7);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            Reader reader = this.in;
            int i8 = this.limit;
            int read = reader.read(cArr, i8, cArr.length - i8);
            if (read == -1) {
                return false;
            }
            i2 = this.limit + read;
            this.limit = i2;
            if (this.lineNumber == 0 && (i3 = this.lineStart) == 0 && i2 > 0 && cArr[0] == 65279) {
                this.pos++;
                this.lineStart = i3 + 1;
                i++;
                continue;
            }
        } while (i2 < i);
        return true;
    }

    private boolean isLiteral(char c) throws IOException {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (!(c == '/' || c == '=')) {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        checkLenient();
        return false;
    }

    private int nextNonWhitespace(boolean z) throws IOException {
        char[] cArr = this.buffer;
        int i = this.pos;
        int i2 = this.limit;
        while (true) {
            if (i == i2) {
                this.pos = i;
                if (fillBuffer(1)) {
                    i = this.pos;
                    i2 = this.limit;
                } else if (!z) {
                    return -1;
                } else {
                    StringBuilder P0 = a.P0("End of input");
                    P0.append(locationString());
                    throw new EOFException(P0.toString());
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.lineNumber++;
                this.lineStart = i3;
            } else if (!(c == ' ' || c == '\r' || c == '\t')) {
                if (c == '/') {
                    this.pos = i3;
                    if (i3 == i2) {
                        this.pos = i3 - 1;
                        boolean fillBuffer = fillBuffer(2);
                        this.pos++;
                        if (!fillBuffer) {
                            return c;
                        }
                    }
                    checkLenient();
                    int i4 = this.pos;
                    char c2 = cArr[i4];
                    if (c2 == '*') {
                        this.pos = i4 + 1;
                        if (skipTo("*/")) {
                            i = this.pos + 2;
                            i2 = this.limit;
                        } else {
                            throw syntaxError("Unterminated comment");
                        }
                    } else if (c2 != '/') {
                        return c;
                    } else {
                        this.pos = i4 + 1;
                        skipToEndOfLine();
                        i = this.pos;
                        i2 = this.limit;
                    }
                } else if (c == '#') {
                    this.pos = i3;
                    checkLenient();
                    skipToEndOfLine();
                    i = this.pos;
                    i2 = this.limit;
                } else {
                    this.pos = i3;
                    return c;
                }
            }
            i = i3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
        if (r1 != null) goto L_0x006c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r2) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
        r1.append(r0, r2, r2 - r2);
        r9.pos = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    private String nextQuotedValue(char c) throws IOException {
        char[] cArr = this.buffer;
        StringBuilder sb = null;
        do {
            int i = this.pos;
            int i2 = this.limit;
            while (true) {
                while (i < i2) {
                    int i3 = i + 1;
                    char c2 = cArr[i];
                    if (c2 == c) {
                        this.pos = i3;
                        int i4 = (i3 - i) - 1;
                        if (sb == null) {
                            return new String(cArr, i, i4);
                        }
                        sb.append(cArr, i, i4);
                        return sb.toString();
                    } else if (c2 == '\\') {
                        this.pos = i3;
                        int i5 = (i3 - i) - 1;
                        if (sb == null) {
                            sb = new StringBuilder(Math.max((i5 + 1) * 2, 16));
                        }
                        sb.append(cArr, i, i5);
                        sb.append(readEscapeCharacter());
                        i = this.pos;
                        i2 = this.limit;
                    } else {
                        if (c2 == '\n') {
                            this.lineNumber++;
                            this.lineStart = i3;
                        }
                        i = i3;
                    }
                }
                break;
            }
        } while (fillBuffer(1));
        throw syntaxError("Unterminated string");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
        checkLenient();
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008a  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    private String nextUnquotedValue() throws IOException {
        String str;
        int i = 0;
        StringBuilder sb = null;
        do {
            int i2 = 0;
            while (true) {
                int i3 = this.pos;
                if (i3 + i2 < this.limit) {
                    char c = this.buffer[i3 + i2];
                    if (!(c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ')) {
                        if (c != '#') {
                            if (c != ',') {
                                if (!(c == '/' || c == '=')) {
                                    if (!(c == '{' || c == '}' || c == ':')) {
                                        if (c != ';') {
                                            switch (c) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i2++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (i2 >= this.buffer.length) {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i2, 16));
                    }
                    sb.append(this.buffer, this.pos, i2);
                    this.pos += i2;
                } else if (fillBuffer(i2 + 1)) {
                }
            }
            i = i2;
            if (sb != null) {
                str = new String(this.buffer, this.pos, i);
            } else {
                sb.append(this.buffer, this.pos, i);
                str = sb.toString();
            }
            this.pos += i;
            return str;
        } while (fillBuffer(1));
        if (sb != null) {
        }
        this.pos += i;
        return str;
    }

    private int peekKeyword() throws IOException {
        String str;
        String str2;
        int i;
        char c = this.buffer[this.pos];
        if (c == 't' || c == 'T') {
            i = 5;
            str2 = "true";
            str = "TRUE";
        } else if (c == 'f' || c == 'F') {
            i = 6;
            str2 = "false";
            str = "FALSE";
        } else if (c != 'n' && c != 'N') {
            return 0;
        } else {
            i = 7;
            str2 = "null";
            str = "NULL";
        }
        int length = str2.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.pos + i2 >= this.limit && !fillBuffer(i2 + 1)) {
                return 0;
            }
            char c2 = this.buffer[this.pos + i2];
            if (!(c2 == str2.charAt(i2) || c2 == str.charAt(i2))) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || fillBuffer(length + 1)) && isLiteral(this.buffer[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.peeked = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0091, code lost:
        if (isLiteral(r14) != false) goto L_0x00c9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0093, code lost:
        if (r9 != 2) goto L_0x00b7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0095, code lost:
        if (r10 == false) goto L_0x00b7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x009b, code lost:
        if (r11 != Long.MIN_VALUE) goto L_0x009f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x009d, code lost:
        if (r13 == false) goto L_0x00b7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a3, code lost:
        if (r11 != 0) goto L_0x00a7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00a5, code lost:
        if (r13 != false) goto L_0x00b7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a7, code lost:
        if (r13 == false) goto L_0x00aa;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00aa, code lost:
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00ab, code lost:
        r18.peekedLong = r11;
        r18.pos += r8;
        r18.peeked = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00b6, code lost:
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00b7, code lost:
        if (r9 == 2) goto L_0x00c2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ba, code lost:
        if (r9 == 4) goto L_0x00c2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00bd, code lost:
        if (r9 != 7) goto L_0x00c0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00c0, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00c2, code lost:
        r18.peekedNumberLength = r8;
        r18.peeked = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00c8, code lost:
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00c9, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    private int peekNumber() throws IOException {
        char[] cArr = this.buffer;
        int i = this.pos;
        int i2 = this.limit;
        int i3 = 0;
        boolean z = true;
        int i4 = 0;
        char c = 0;
        boolean z2 = false;
        long j = 0;
        while (true) {
            if (i + i4 == i2) {
                if (i4 == cArr.length) {
                    return i3;
                }
                if (!fillBuffer(i4 + 1)) {
                    break;
                }
                i = this.pos;
                i2 = this.limit;
            }
            char c2 = cArr[i + i4];
            char c3 = 3;
            if (c2 != '+') {
                if (c2 == 'E' || c2 == 'e') {
                    i3 = 0;
                    if (c != 2 && c != 4) {
                        return 0;
                    }
                    c = 5;
                } else if (c2 == '-') {
                    c3 = 6;
                    i3 = 0;
                    if (c == 0) {
                        c = 1;
                        z2 = true;
                    } else if (c != 5) {
                        return 0;
                    }
                } else if (c2 == '.') {
                    i3 = 0;
                    if (c != 2) {
                        return 0;
                    }
                } else if (c2 < '0' || c2 > '9') {
                    break;
                } else {
                    if (c == 1 || c == 0) {
                        j = (long) (-(c2 - '0'));
                        c = 2;
                    } else if (c == 2) {
                        if (j == 0) {
                            return 0;
                        }
                        long j2 = (10 * j) - ((long) (c2 - '0'));
                        int i5 = (j > MIN_INCOMPLETE_INTEGER ? 1 : (j == MIN_INCOMPLETE_INTEGER ? 0 : -1));
                        z &= i5 > 0 || (i5 == 0 && j2 < j);
                        j = j2;
                    } else if (c == 3) {
                        i3 = 0;
                        c = 4;
                    } else if (c == 5 || c == 6) {
                        i3 = 0;
                        c = 7;
                    }
                    i3 = 0;
                }
                i4++;
            } else {
                c3 = 6;
                i3 = 0;
                if (c != 5) {
                    return 0;
                }
            }
            c = c3;
            i4++;
        }
    }

    private void push(int i) {
        int i2 = this.stackSize;
        int[] iArr = this.stack;
        if (i2 == iArr.length) {
            int i3 = i2 * 2;
            this.stack = Arrays.copyOf(iArr, i3);
            this.pathIndices = Arrays.copyOf(this.pathIndices, i3);
            this.pathNames = (String[]) Arrays.copyOf(this.pathNames, i3);
        }
        int[] iArr2 = this.stack;
        int i4 = this.stackSize;
        this.stackSize = i4 + 1;
        iArr2[i4] = i;
    }

    private char readEscapeCharacter() throws IOException {
        int i;
        int i2;
        if (this.pos != this.limit || fillBuffer(1)) {
            char[] cArr = this.buffer;
            int i3 = this.pos;
            int i4 = i3 + 1;
            this.pos = i4;
            char c = cArr[i3];
            if (c == '\n') {
                this.lineNumber++;
                this.lineStart = i4;
            } else if (!(c == '\"' || c == '\'' || c == '/' || c == '\\')) {
                if (c == 'b') {
                    return '\b';
                }
                if (c == 'f') {
                    return '\f';
                }
                if (c == 'n') {
                    return '\n';
                }
                if (c == 'r') {
                    return '\r';
                }
                if (c == 't') {
                    return '\t';
                }
                if (c != 'u') {
                    throw syntaxError("Invalid escape sequence");
                } else if (i4 + 4 <= this.limit || fillBuffer(4)) {
                    char c2 = 0;
                    int i5 = this.pos;
                    int i6 = i5 + 4;
                    while (i5 < i6) {
                        char c3 = this.buffer[i5];
                        char c4 = (char) (c2 << 4);
                        if (c3 < '0' || c3 > '9') {
                            if (c3 >= 'a' && c3 <= 'f') {
                                i2 = c3 - 'a';
                            } else if (c3 < 'A' || c3 > 'F') {
                                StringBuilder P0 = a.P0("\\u");
                                P0.append(new String(this.buffer, this.pos, 4));
                                throw new NumberFormatException(P0.toString());
                            } else {
                                i2 = c3 - 'A';
                            }
                            i = i2 + 10;
                        } else {
                            i = c3 - '0';
                        }
                        c2 = (char) (i + c4);
                        i5++;
                    }
                    this.pos += 4;
                    return c2;
                } else {
                    throw syntaxError("Unterminated escape sequence");
                }
            }
            return c;
        }
        throw syntaxError("Unterminated escape sequence");
    }

    private void skipQuotedValue(char c) throws IOException {
        char[] cArr = this.buffer;
        do {
            int i = this.pos;
            int i2 = this.limit;
            while (i < i2) {
                int i3 = i + 1;
                char c2 = cArr[i];
                if (c2 == c) {
                    this.pos = i3;
                    return;
                } else if (c2 == '\\') {
                    this.pos = i3;
                    readEscapeCharacter();
                    i = this.pos;
                    i2 = this.limit;
                } else {
                    if (c2 == '\n') {
                        this.lineNumber++;
                        this.lineStart = i3;
                    }
                    i = i3;
                }
            }
            this.pos = i;
        } while (fillBuffer(1));
        throw syntaxError("Unterminated string");
    }

    private boolean skipTo(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.pos + length > this.limit && !fillBuffer(length)) {
                return false;
            }
            char[] cArr = this.buffer;
            int i = this.pos;
            if (cArr[i] == '\n') {
                this.lineNumber++;
                this.lineStart = i + 1;
            } else {
                for (int i2 = 0; i2 < length; i2++) {
                    if (this.buffer[this.pos + i2] != str.charAt(i2)) {
                        break;
                    }
                }
                return true;
            }
            this.pos++;
        }
    }

    private void skipToEndOfLine() throws IOException {
        char c;
        do {
            if (this.pos < this.limit || fillBuffer(1)) {
                char[] cArr = this.buffer;
                int i = this.pos;
                int i2 = i + 1;
                this.pos = i2;
                c = cArr[i];
                if (c == '\n') {
                    this.lineNumber++;
                    this.lineStart = i2;
                    return;
                }
            } else {
                return;
            }
        } while (c != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
        checkLenient();
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    private void skipUnquotedValue() throws IOException {
        do {
            int i = 0;
            while (true) {
                int i2 = this.pos;
                if (i2 + i < this.limit) {
                    char c = this.buffer[i2 + i];
                    if (!(c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ')) {
                        if (c != '#') {
                            if (c != ',') {
                                if (!(c == '/' || c == '=')) {
                                    if (!(c == '{' || c == '}' || c == ':')) {
                                        if (c != ';') {
                                            switch (c) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    this.pos = i2 + i;
                }
            }
            this.pos += i;
            return;
        } while (fillBuffer(1));
    }

    private IOException syntaxError(String str) throws IOException {
        StringBuilder P0 = a.P0(str);
        P0.append(locationString());
        throw new MalformedJsonException(P0.toString());
    }

    public void beginArray() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 3) {
            push(1);
            this.pathIndices[this.stackSize - 1] = 0;
            this.peeked = 0;
            return;
        }
        StringBuilder P0 = a.P0("Expected BEGIN_ARRAY but was ");
        P0.append(peek());
        P0.append(locationString());
        throw new IllegalStateException(P0.toString());
    }

    public void beginObject() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 1) {
            push(3);
            this.peeked = 0;
            return;
        }
        StringBuilder P0 = a.P0("Expected BEGIN_OBJECT but was ");
        P0.append(peek());
        P0.append(locationString());
        throw new IllegalStateException(P0.toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.peeked = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.in.close();
    }

    public int doPeek() throws IOException {
        int nextNonWhitespace;
        int[] iArr = this.stack;
        int i = this.stackSize;
        int i2 = iArr[i - 1];
        if (i2 == 1) {
            iArr[i - 1] = 2;
        } else if (i2 == 2) {
            int nextNonWhitespace2 = nextNonWhitespace(true);
            if (nextNonWhitespace2 != 44) {
                if (nextNonWhitespace2 == 59) {
                    checkLenient();
                } else if (nextNonWhitespace2 == 93) {
                    this.peeked = 4;
                    return 4;
                } else {
                    throw syntaxError("Unterminated array");
                }
            }
        } else if (i2 == 3 || i2 == 5) {
            iArr[i - 1] = 4;
            if (i2 == 5 && (nextNonWhitespace = nextNonWhitespace(true)) != 44) {
                if (nextNonWhitespace == 59) {
                    checkLenient();
                } else if (nextNonWhitespace == 125) {
                    this.peeked = 2;
                    return 2;
                } else {
                    throw syntaxError("Unterminated object");
                }
            }
            int nextNonWhitespace3 = nextNonWhitespace(true);
            if (nextNonWhitespace3 == 34) {
                this.peeked = 13;
                return 13;
            } else if (nextNonWhitespace3 == 39) {
                checkLenient();
                this.peeked = 12;
                return 12;
            } else if (nextNonWhitespace3 != 125) {
                checkLenient();
                this.pos--;
                if (isLiteral((char) nextNonWhitespace3)) {
                    this.peeked = 14;
                    return 14;
                }
                throw syntaxError("Expected name");
            } else if (i2 != 5) {
                this.peeked = 2;
                return 2;
            } else {
                throw syntaxError("Expected name");
            }
        } else if (i2 == 4) {
            iArr[i - 1] = 5;
            int nextNonWhitespace4 = nextNonWhitespace(true);
            if (nextNonWhitespace4 != 58) {
                if (nextNonWhitespace4 == 61) {
                    checkLenient();
                    if (this.pos < this.limit || fillBuffer(1)) {
                        char[] cArr = this.buffer;
                        int i3 = this.pos;
                        if (cArr[i3] == '>') {
                            this.pos = i3 + 1;
                        }
                    }
                } else {
                    throw syntaxError("Expected ':'");
                }
            }
        } else if (i2 == 6) {
            if (this.lenient) {
                consumeNonExecutePrefix();
            }
            this.stack[this.stackSize - 1] = 7;
        } else if (i2 == 7) {
            if (nextNonWhitespace(false) == -1) {
                this.peeked = 17;
                return 17;
            }
            checkLenient();
            this.pos--;
        } else if (i2 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int nextNonWhitespace5 = nextNonWhitespace(true);
        if (nextNonWhitespace5 == 34) {
            this.peeked = 9;
            return 9;
        } else if (nextNonWhitespace5 != 39) {
            if (!(nextNonWhitespace5 == 44 || nextNonWhitespace5 == 59)) {
                if (nextNonWhitespace5 == 91) {
                    this.peeked = 3;
                    return 3;
                } else if (nextNonWhitespace5 != 93) {
                    if (nextNonWhitespace5 != 123) {
                        this.pos--;
                        int peekKeyword = peekKeyword();
                        if (peekKeyword != 0) {
                            return peekKeyword;
                        }
                        int peekNumber = peekNumber();
                        if (peekNumber != 0) {
                            return peekNumber;
                        }
                        if (isLiteral(this.buffer[this.pos])) {
                            checkLenient();
                            this.peeked = 10;
                            return 10;
                        }
                        throw syntaxError("Expected value");
                    }
                    this.peeked = 1;
                    return 1;
                } else if (i2 == 1) {
                    this.peeked = 4;
                    return 4;
                }
            }
            if (i2 == 1 || i2 == 2) {
                checkLenient();
                this.pos--;
                this.peeked = 7;
                return 7;
            }
            throw syntaxError("Unexpected value");
        } else {
            checkLenient();
            this.peeked = 8;
            return 8;
        }
    }

    public void endArray() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 4) {
            int i2 = this.stackSize - 1;
            this.stackSize = i2;
            int[] iArr = this.pathIndices;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.peeked = 0;
            return;
        }
        StringBuilder P0 = a.P0("Expected END_ARRAY but was ");
        P0.append(peek());
        P0.append(locationString());
        throw new IllegalStateException(P0.toString());
    }

    public void endObject() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 2) {
            int i2 = this.stackSize - 1;
            this.stackSize = i2;
            this.pathNames[i2] = null;
            int[] iArr = this.pathIndices;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.peeked = 0;
            return;
        }
        StringBuilder P0 = a.P0("Expected END_OBJECT but was ");
        P0.append(peek());
        P0.append(locationString());
        throw new IllegalStateException(P0.toString());
    }

    public String getPath() {
        StringBuilder N0 = a.N0('$');
        int i = this.stackSize;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.stack[i2];
            if (i3 == 1 || i3 == 2) {
                N0.append('[');
                N0.append(this.pathIndices[i2]);
                N0.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                N0.append('.');
                String[] strArr = this.pathNames;
                if (strArr[i2] != null) {
                    N0.append(strArr[i2]);
                }
            }
        }
        return N0.toString();
    }

    public boolean hasNext() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public final boolean isLenient() {
        return this.lenient;
    }

    public String locationString() {
        StringBuilder R0 = a.R0(" at line ", this.lineNumber + 1, " column ", (this.pos - this.lineStart) + 1, " path ");
        R0.append(getPath());
        return R0.toString();
    }

    public boolean nextBoolean() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 5) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            StringBuilder P0 = a.P0("Expected a boolean but was ");
            P0.append(peek());
            P0.append(locationString());
            throw new IllegalStateException(P0.toString());
        }
    }

    public double nextDouble() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return (double) this.peekedLong;
        }
        if (i == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i == 8 || i == 9) {
            this.peekedString = nextQuotedValue(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.peekedString = nextUnquotedValue();
        } else if (i != 11) {
            StringBuilder P0 = a.P0("Expected a double but was ");
            P0.append(peek());
            P0.append(locationString());
            throw new IllegalStateException(P0.toString());
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        if (this.lenient || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return parseDouble;
        }
        throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + locationString());
    }

    public int nextInt() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 15) {
            long j = this.peekedLong;
            int i2 = (int) j;
            if (j == ((long) i2)) {
                this.peeked = 0;
                int[] iArr = this.pathIndices;
                int i3 = this.stackSize - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            StringBuilder P0 = a.P0("Expected an int but was ");
            P0.append(this.peekedLong);
            P0.append(locationString());
            throw new NumberFormatException(P0.toString());
        }
        if (i == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.peekedString = nextUnquotedValue();
            } else {
                this.peekedString = nextQuotedValue(i == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i4 = this.stackSize - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else {
            StringBuilder P02 = a.P0("Expected an int but was ");
            P02.append(peek());
            P02.append(locationString());
            throw new IllegalStateException(P02.toString());
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        int i5 = (int) parseDouble;
        if (((double) i5) == parseDouble) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr3 = this.pathIndices;
            int i6 = this.stackSize - 1;
            iArr3[i6] = iArr3[i6] + 1;
            return i5;
        }
        StringBuilder P03 = a.P0("Expected an int but was ");
        P03.append(this.peekedString);
        P03.append(locationString());
        throw new NumberFormatException(P03.toString());
    }

    public long nextLong() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.peekedLong;
        }
        if (i == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.peekedString = nextUnquotedValue();
            } else {
                this.peekedString = nextQuotedValue(i == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i3 = this.stackSize - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else {
            StringBuilder P0 = a.P0("Expected a long but was ");
            P0.append(peek());
            P0.append(locationString());
            throw new IllegalStateException(P0.toString());
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        long j = (long) parseDouble;
        if (((double) j) == parseDouble) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr3 = this.pathIndices;
            int i4 = this.stackSize - 1;
            iArr3[i4] = iArr3[i4] + 1;
            return j;
        }
        StringBuilder P02 = a.P0("Expected a long but was ");
        P02.append(this.peekedString);
        P02.append(locationString());
        throw new NumberFormatException(P02.toString());
    }

    public String nextName() throws IOException {
        String str;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 14) {
            str = nextUnquotedValue();
        } else if (i == 12) {
            str = nextQuotedValue('\'');
        } else if (i == 13) {
            str = nextQuotedValue('\"');
        } else {
            StringBuilder P0 = a.P0("Expected a name but was ");
            P0.append(peek());
            P0.append(locationString());
            throw new IllegalStateException(P0.toString());
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = str;
        return str;
    }

    public void nextNull() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 7) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        StringBuilder P0 = a.P0("Expected null but was ");
        P0.append(peek());
        P0.append(locationString());
        throw new IllegalStateException(P0.toString());
    }

    public String nextString() throws IOException {
        String str;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 10) {
            str = nextUnquotedValue();
        } else if (i == 8) {
            str = nextQuotedValue('\'');
        } else if (i == 9) {
            str = nextQuotedValue('\"');
        } else if (i == 11) {
            str = this.peekedString;
            this.peekedString = null;
        } else if (i == 15) {
            str = Long.toString(this.peekedLong);
        } else if (i == 16) {
            str = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            StringBuilder P0 = a.P0("Expected a string but was ");
            P0.append(peek());
            P0.append(locationString());
            throw new IllegalStateException(P0.toString());
        }
        this.peeked = 0;
        int[] iArr = this.pathIndices;
        int i2 = this.stackSize - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public JsonToken peek() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        switch (i) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void setLenient(boolean z) {
        this.lenient = z;
    }

    public void skipValue() throws IOException {
        int i = 0;
        do {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            if (i2 == 3) {
                push(1);
            } else if (i2 == 1) {
                push(3);
            } else {
                if (i2 == 4) {
                    this.stackSize--;
                } else if (i2 == 2) {
                    this.stackSize--;
                } else {
                    if (i2 == 14 || i2 == 10) {
                        skipUnquotedValue();
                    } else if (i2 == 8 || i2 == 12) {
                        skipQuotedValue('\'');
                    } else if (i2 == 9 || i2 == 13) {
                        skipQuotedValue('\"');
                    } else if (i2 == 16) {
                        this.pos += this.peekedNumberLength;
                    }
                    this.peeked = 0;
                }
                i--;
                this.peeked = 0;
            }
            i++;
            this.peeked = 0;
        } while (i != 0);
        int[] iArr = this.pathIndices;
        int i3 = this.stackSize;
        int i4 = i3 - 1;
        iArr[i4] = iArr[i4] + 1;
        this.pathNames[i3 - 1] = "null";
    }

    @Override // java.lang.Object
    public String toString() {
        return getClass().getSimpleName() + locationString();
    }
}
