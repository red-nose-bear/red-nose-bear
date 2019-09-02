/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * -----------------------
 * 思路：
 * 设置三个标志符分别记录“+/-”、“e/E”和“.”是否出现过。
 * 对于“+/-”： 允许出现在首位；不允许不在首位且它的前面不是“e/E”; 不允许在末尾
 * 对于“e/E”： 多个"e/E"不允许；“e/E”后面无数字不允许
 * 对于“.”： 不允许出现多个“.”；不允许在“e/E”后出现“.”
 * 同时，要保证其他字符均为 0-9 之间的数字
 * -----------------------
 */

public class IsNumeric {

    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0)
            return false;
        int len = str.length;
        // 两个标志位
        boolean eFlag = false, decimalPointFlag = false;
        int eIndex = -1;
        for (int i = 0; i < len; i++) {
            if (str[i] == '+' || str[i] == '-') {
                if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E')
                    return false;
                else if (i == len - 1)
                    return false;
            } else if (str[i] == 'E' || str[i] == 'e') {
                if (eFlag)
                    return false;
                else if (i == len - 1)
                    return false;
                eFlag = true;
                eIndex = i;
            } else if (str[i] == '.') {
                if (decimalPointFlag)
                    return false;
                else if (eFlag && i > eIndex)
                    return false;
                decimalPointFlag = true;
            } else if (str[i] > '9' || str[i] < '0') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsNumeric isNumeric = new IsNumeric();
        boolean numeric = isNumeric.isNumeric("213213e-".toCharArray());
        System.out.println(numeric);
    }

}
