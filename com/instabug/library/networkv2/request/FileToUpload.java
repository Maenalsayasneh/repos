package com.instabug.library.networkv2.request;
/* loaded from: classes2.dex */
public class FileToUpload {
    private final String fileName;
    private final String filePartName;
    private final String filePath;
    private final String fileType;

    public FileToUpload(String str, String str2, String str3, String str4) {
        this.filePartName = str;
        this.fileName = str2;
        this.filePath = str3;
        this.fileType = str4;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePartName() {
        return this.filePartName;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public String getFileType() {
        return this.fileType;
    }
}
