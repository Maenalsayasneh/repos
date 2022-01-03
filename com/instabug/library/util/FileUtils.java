package com.instabug.library.util;

import android.content.Intent;
import android.net.Uri;
import android.webkit.URLUtil;
import com.instabug.library.model.NetworkLog;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes2.dex */
public final class FileUtils {
    private static final char EXTENSION_SEPARATOR = '.';
    public static final String FLAG_ENCRYPTED = "_e";
    private static final int NOT_FOUND = -1;
    private static final char UNIX_SEPARATOR = '/';

    /* loaded from: classes2.dex */
    public static class a implements Comparator<File> {
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return Double.compare((double) file.lastModified(), (double) file2.lastModified());
        }
    }

    private static Intent appropriateIntent(Uri uri, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        if (str.equalsIgnoreCase("doc") || str.equalsIgnoreCase("docx")) {
            intent.setDataAndType(uri, "application/msword");
        } else if (str.equalsIgnoreCase("pdf")) {
            intent.setDataAndType(uri, "application/pdf");
        } else if (str.equalsIgnoreCase("ppt") || str.equalsIgnoreCase("pptx")) {
            intent.setDataAndType(uri, "application/vnd.ms-powerpoint");
        } else if (str.equalsIgnoreCase("xls") || str.equalsIgnoreCase("xlsx")) {
            intent.setDataAndType(uri, "application/vnd.ms-excel");
        } else if (str.equalsIgnoreCase("zip") || str.equalsIgnoreCase("rar")) {
            intent.setDataAndType(uri, "application/x-wav");
        } else if (str.equalsIgnoreCase("rtf")) {
            intent.setDataAndType(uri, "application/rtf");
        } else if (str.equalsIgnoreCase("wav") || str.equalsIgnoreCase("mp3")) {
            intent.setDataAndType(uri, "audio/x-wav");
        } else if (str.equalsIgnoreCase("gif")) {
            intent.setDataAndType(uri, "image/gif");
        } else if (str.equalsIgnoreCase("jpg") || str.equalsIgnoreCase("jpeg") || str.equalsIgnoreCase("png")) {
            intent.setDataAndType(uri, "image/jpeg");
        } else if (str.equalsIgnoreCase("txt")) {
            intent.setDataAndType(uri, NetworkLog.PLAIN_TEXT);
        } else if (str.equalsIgnoreCase("3gp") || str.equalsIgnoreCase("mpg") || str.equalsIgnoreCase("mpeg") || str.equalsIgnoreCase("mpe") || str.equalsIgnoreCase("mp4") || str.equalsIgnoreCase("avi")) {
            intent.setDataAndType(uri, "video/*");
        } else {
            intent.setDataAndType(uri, "*/*");
        }
        intent.addFlags(268435456);
        return intent;
    }

    public static String getExtension(File file) {
        return getExtension(file.getAbsolutePath());
    }

    public static File getFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file;
        }
        return null;
    }

    public static int getFileType(File file) {
        if (file.isDirectory()) {
            return 2;
        }
        String absolutePath = file.getAbsolutePath();
        if (getIndexOfExtension(absolutePath) == -1) {
            return -1;
        }
        return getTypeFromExtension(absolutePath);
    }

    public static Intent getFileViewerIntent(String str) {
        if (URLUtil.isNetworkUrl(str)) {
            return new Intent("android.intent.action.VIEW", Uri.parse(str));
        }
        return appropriateIntent(Uri.fromFile(new File(str)), getExtension(str));
    }

    public static int getIndexOfExtension(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (str.lastIndexOf(47) > lastIndexOf) {
            return -1;
        }
        return lastIndexOf;
    }

    public static String getPathWithDecryptedFlag(String str) {
        return str.replace(FLAG_ENCRYPTED, "");
    }

    public static String getPathWithEncryptedFlag(String str) {
        int indexOfExtension = getIndexOfExtension(str);
        return indexOfExtension != -1 ? String.format("%s%s%s", str.substring(0, indexOfExtension), FLAG_ENCRYPTED, str.substring(indexOfExtension)) : "";
    }

    public static long getSize(File file) {
        int i;
        if (!file.exists()) {
            return 0;
        }
        long length = file.length();
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            int i2 = 0;
            while (true) {
                if (listFiles == null) {
                    i = 0;
                } else {
                    i = listFiles.length;
                }
                if (i2 >= i) {
                    break;
                }
                length += getSize(listFiles[i2]);
                i2++;
            }
        }
        return length;
    }

    private static int getTypeFromExtension(String str) {
        String extension = getExtension(str);
        if (isVideoExtension(extension)) {
            return 0;
        }
        return isImageExtension(extension) ? 1 : -1;
    }

    private static boolean isCacheExtension(String str) {
        return str.equalsIgnoreCase("cache");
    }

    public static boolean isCacheFile(File file) {
        if (!file.isFile()) {
            return false;
        }
        return isCacheExtension(getExtension(file.getAbsolutePath()));
    }

    public static boolean isEncryptedFile(String str) {
        return str.substring(0, getIndexOfExtension(str)).endsWith(FLAG_ENCRYPTED);
    }

    public static boolean isFileRelatedToBugOrCrashReport(String str) {
        return str.contains("vusf") || str.contains("view-hierarchy-images") || (str.contains("bug_") && str.endsWith("_.jpg")) || ((str.contains("view_hierarchy_attachment_") && str.endsWith(".zip")) || (str.contains("usersteps_") && str.endsWith(".zip")));
    }

    public static boolean isImageExtension(String str) {
        return str.equalsIgnoreCase("jpeg") || str.equalsIgnoreCase("gif") || str.equalsIgnoreCase("png") || str.equalsIgnoreCase("bmp") || str.equalsIgnoreCase("jpg") || str.equalsIgnoreCase("webp");
    }

    public static boolean isImageFile(File file) {
        if (!file.isFile()) {
            return false;
        }
        return isImageExtension(getExtension(file));
    }

    public static boolean isReproStepFile(String str) {
        return (str.contains("step") || str.contains("icon")) && str.endsWith(".png") && !str.contains("usersteps_") && !str.endsWith(".zip");
    }

    private static boolean isTextExtension(String str) {
        return str.equalsIgnoreCase("txt");
    }

    public static boolean isTextFile(File file) {
        if (!file.isFile()) {
            return false;
        }
        return isTextExtension(getExtension(file.getAbsolutePath()));
    }

    public static boolean isVideoExtension(String str) {
        return str.equalsIgnoreCase("mp4") || str.equalsIgnoreCase("avi") || str.equalsIgnoreCase("mpg") || str.equalsIgnoreCase("3gp") || str.equalsIgnoreCase("3gpp") || str.equalsIgnoreCase("ts") || str.equalsIgnoreCase("AAC") || str.equalsIgnoreCase("webm") || str.equalsIgnoreCase("mkv");
    }

    public static boolean isVideoFile(File file) {
        if (!file.isFile()) {
            return false;
        }
        return isVideoExtension(getExtension(file));
    }

    public static void sortByLastModifiedAsc(List<File> list) {
        Collections.sort(list, new a());
    }

    public static String getExtension(String str) {
        int indexOfExtension = getIndexOfExtension(str);
        if (indexOfExtension == -1) {
            return "";
        }
        return str.substring(indexOfExtension + 1);
    }
}
