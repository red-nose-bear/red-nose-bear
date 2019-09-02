package tree;

import tree.base.TreeNode;

/**
 * 树：平衡二叉树，二叉树的后序遍历
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 平衡二叉树定义：一棵空树或它的任意节点的左右两个子树的高度差的绝对值均不超过1
 * https://blog.csdn.net/K346K346/article/details/51085501
 */

public class IsBalancedBinaryTree {

    /**
     * 直接递归求每棵树的深度，但是子树会被遍历多次
     */
    public boolean isBalanced_solution1(TreeNode root) {
        if (root == null)
            return true;
        int leftDepth = getDepthOfTree(root.left);
        int rightDepth = getDepthOfTree(root.right);
        return Math.abs(leftDepth - rightDepth) <= 1 && isBalanced_solution1(root.left) && isBalanced_solution1(root.right);
    }

    private int getDepthOfTree(TreeNode node) {
        if (node == null)
            return 0;
        int left = getDepthOfTree(node.left);
        int right = getDepthOfTree(node.right);
        return left > right ? left + 1 : right + 1;
    }

    /**
     * 后序遍历方式，每个节点最多遍历一次，若发现子节点不是平衡二叉树则立即返回
     * ################### 没看懂 ###################
     */
    public boolean IsBalanced_Solution2(TreeNode root) {
        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode root) {
        System.out.println("root: " + root);
        if (root == null) return 0;
        int left = getDepth(root.left);
        System.out.println("left: " + left);
        if (left == -1) return -1;
        int right = getDepth(root.right);
        System.out.println("right: " + right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node0 = new TreeNode(0);
        root.left = node5;
        root.right = node4;
        node4.left = node1;
        node5.left = node3;
        node5.right = node2;
        node3.left = node0;
        node0.left = new TreeNode(-1);

        IsBalancedBinaryTree instance = new IsBalancedBinaryTree();
        System.out.println(instance.IsBalanced_Solution2(root));
    }
}
