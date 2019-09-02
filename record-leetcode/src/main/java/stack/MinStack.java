package stack;

import java.util.Stack;

/**
 * 栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））
 */
public class MinStack {

    private Stack<Integer> dataStack = new Stack();
    private Stack<Integer> miniStack = new Stack();

    public void push(int node) {
        dataStack.push(node);
        if (miniStack.isEmpty()) {
            miniStack.push(node);
        } else {
            if (miniStack.peek() > node)
                miniStack.push(node);
            else
                miniStack.push(miniStack.peek());
        }
    }

    public void pop() {
        if (dataStack.isEmpty())
            throw new RuntimeException("no elements!");

        dataStack.pop();
        miniStack.pop();
    }

    // 查看栈顶元素
    public int top() {
        return dataStack.peek();
    }

    public int min() {
        if (dataStack.isEmpty())
            throw new RuntimeException("no elements!");
        return miniStack.peek();
    }

}
