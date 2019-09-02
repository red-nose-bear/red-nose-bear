package str;

import java.util.Stack;

/**
 * 字符串：反转单词序列
 * “student. a am I”。翻转后为“I am a student.”
 */

public class ReverseSentence {

    /**
     * 借助外部空间
     *
     * @param str
     * @return
     */
    public String reverseSentence_solution1(String str) {
        if (str == null || str.length() == 0 || "".equals(str.trim()))
            return str;
        Stack stack = new Stack();
        String[] splitArr = str.split(" ");
        for (String s : splitArr) {
            stack.push(s);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        return sb.toString().substring(0, str.length());
    }

    /**
     * 使用递归
     *
     * @param str
     * @return
     */
    public String reverseSentence_solution2(String str) {
        return str.lastIndexOf(" ") == -1 ? str : str.substring(str.lastIndexOf(" ") + 1) + " " + reverseSentence_solution2(str.substring(0, str.lastIndexOf(" ")));
    }

    /**
     * 先反转整个字符串，然后反转每个单词，根据空格确定单词的开始和结束
     *
     * @param str
     * @return
     */
    public String reverseSentence_solution3(String str) {
        if (str == null || str.length() == 0 || "".equals(str.trim()))
            return str;
        char[] charArr = str.toCharArray();
        resverStr(charArr, 0, str.length() - 1);
        int curBlankIndex = -1;
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == ' ') {
                resverStr(charArr, curBlankIndex + 1, i - 1);
                curBlankIndex = i;
            }
        }
        // 反转最后一个字符串
        resverStr(charArr, curBlankIndex + 1, charArr.length - 1);
        return new String(charArr);
    }

    private void resverStr(char[] charArr, int start, int end) {
        if (start < end) {
            char temp = charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = temp;

            resverStr(charArr, ++start, --end);
        }
    }

    public static void main(String[] args) {
        String a = "I am a student!";
        ReverseSentence reverseSentence = new ReverseSentence();
        String s = reverseSentence.reverseSentence_solution3(a);
        System.out.println(s);
    }
}