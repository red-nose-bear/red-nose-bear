package utils.mail;

import java.util.regex.Pattern;

/**
 * 郵箱工具類
 */
public class EmailUtil {

    /**
     * 邮箱格式是否正确
     */
    public static boolean isEmail(String email) {
        return Pattern.compile("\\w+@{1}\\w+\\.{1}\\w+").matcher(email).matches();
    }
}
