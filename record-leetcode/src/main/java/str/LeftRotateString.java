package str;

/**
 * 字符串
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */

public class LeftRotateString {

    /**
     * 截取要左移的部分，将剩下部分和要左移的部分连接起来
     *
     * @param str
     * @param n
     * @return
     */
    public String leftRotateString_solution1(String str, int n) {
        if (str == null || n < 1 || str.length() == 0 || str.length() == 1)
            return str;

        int move = n % str.length();
        if (move == 0)
            return str;

        String tail = str.substring(0, move);
        String head = str.substring(move);
        return head + tail;
    }

    /**
     * 将str叠加，然后从后移数的位置开始截取原字符串长度len即可；
     *
     * @param str
     * @param n
     * @return
     */
    public String leftRotateString_solution2(String str, int n) {
        if (str == null || n < 1 || str.length() == 0 || str.length() == 1)
            return str;

        int move = n % str.length();
        if (move == 0)
            return str;

        String temp = str + str;
        return temp.substring(n, str.length() + n);
//        return temp.substring(move, str.length());
    }

    /**
     * 这道题考的核心是应聘者是不是可以灵活利用字符串翻转。假设字符串abcdef，n=3，设X=abc，Y=def，所以字符串可以表示成XY，如题干，问如何求得YX。
     * 假设X的翻转为XT，XT=cba，同理YT=fed，那么YX=(XTYT)T，三次翻转后可得结果。
     *
     * @param str
     * @param n
     * @return
     */
    public String leftRotateString_solution3(String str, int n) {
        if (str == null || n < 1 || str.length() == 0 || str.length() == 1)
            return str;

        int move = n % str.length();
        if (move == 0)
            return str;
        char[] charArray = str.toCharArray();
        reverse(charArray, 0, n - 1);
        reverse(charArray, n, str.length() - 1);
        reverse(charArray, 0, str.length() - 1);
        return new String(charArray);
    }

    private void reverse(char[] charArray, int start, int end) {
        char tempChar;
        while (start < end) {
            tempChar = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = tempChar;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {

    }

}