package utils;

import java.io.File;

/**
 * 文件操作工具类
 */
public class FileUtil {

    /**
     * 删除文件
     */
    public static boolean delFile(File file) {

        if (!file.exists())
            return false;

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                delFile(f);
            }
        }

        return file.delete();
    }

}
