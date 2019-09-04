package tree;

import tree.base.TreeNode;

/**
 * 树
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8） 中，按结点数值大小顺序第三小结点的值为4。
 * -------------------
 * 思路：二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序。所以，按照中序遍历顺序找到第k个结点就是结果。
 * -------------------
 */

public class KthNodeOfBinarySearchTree {

    private TreeNode resNode = null;
    private int count = 0;

    TreeNode KthNode(TreeNode pRoot, int k) {
        inOrder(pRoot, k);
        return resNode;
    }

    private void inOrder(TreeNode pRoot, int k) {
        if (pRoot == null)
            return;
        inOrder(pRoot.left, k);
        count++;
        if (count == k)
            resNode = pRoot;
        inOrder(pRoot.right, k);
    }

}
