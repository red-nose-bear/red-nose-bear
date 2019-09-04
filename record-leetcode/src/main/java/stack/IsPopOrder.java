package stack;

import java.util.Stack;

/**
 * 栈 - 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * <p>
 * 思路：
 * 借助一个栈，将压入序列中的数逐个压入栈中，每压入一个数就和弹出序列的值比对，相同则弹出
 */

public class IsPopOrder {

    public boolean isPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null || pushA.length == 0 || popA.length == 0 || pushA.length != popA.length)
            throw new RuntimeException("非法输入");

        Stack<Integer> stack = new Stack<>();
        int popAIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[popAIndex]) {
                stack.pop();
                popAIndex++;
            }
        }

        return stack.isEmpty();
    }

}
