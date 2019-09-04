package str;

/**
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * -------------
 * 思路
 * 利用 ascll 码进行计算
 * 注意点：
 * 1. 首位为数字 ‘-’ ‘+’都合法
 * 2. 超出int范围的情况
 */

public class StrToInt {

    public int strToInt(String str) {
        if (str == null || "".equals(str.trim()))
            return 0;

        char[] charArray = str.toCharArray();
        int flag = charArray[0] == '-' ? 1 : (charArray[0] == '+' ? 2 : 0);
        int start = flag > 0 ? 1 : 0;
        long res = 0;
        while (start < charArray.length) {
            if (charArray[start] > '9' || charArray[start] < '0')
                return 0;
            res = res * 10 + (charArray[start] - '0');
            start++;
        }
        res = flag == 1 ? -1 * (int) res : (int) res;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
            throw new RuntimeException("输入非法");

        return (int) res;
    }

    public static void main(String[] args) {
        StrToInt strToInt = new StrToInt();
        System.out.println(strToInt.strToInt("123"));
    }

}