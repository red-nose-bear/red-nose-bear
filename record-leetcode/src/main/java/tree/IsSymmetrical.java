package tree;

import tree.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 树：对称二叉树
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */

public class IsSymmetrical {

    /**
     * 递归方式
     * @param pRoot
     * @return
     */
    boolean isSymmetrical_1(TreeNode pRoot) {
        if (pRoot == null)
            return true;
        return isSymmetrical_1(pRoot.left, pRoot.right);
    }

    private boolean isSymmetrical_1(TreeNode p1, TreeNode p2) {
        if (p1 == null && p2 == null)
            return true;
        if (p1 == null || p2 == null)
            return false;
        return p1.val == p2.val && isSymmetrical_1(p1.left, p2.right) && isSymmetrical_1(p1.right, p2.left);
    }

    /**
     * 非递归方式1 - DFS
     * 用栈
     * push时，要一对一对push
     * pop时，也要一对一对pop
     */
    boolean isSymmetrical_DFS(TreeNode pRoot) {
        if (pRoot == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(pRoot.left);
        stack.push(pRoot.right);
        while (!stack.isEmpty()) {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            if (right == null && left == null)
                continue;
            if (right == null || left == null)
                return false;
            if (right.val != left.val)
                return false;

            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }

    /**
     * 非递归方式2 - BFS
     * 用队列
     * @param pRoot
     * @return
     */
    boolean isSymmetrical_BFS(TreeNode pRoot) {
        if (pRoot == null)
            return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot.left);
        queue.offer(pRoot.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null)
                continue;
            if (left == null || right == null)
                return false;
            if (left.val != right.val)
                return false;

            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

}