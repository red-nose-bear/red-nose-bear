package tree;

import tree.base.TreeNode;

/**
 * 树 - 二叉树的镜像
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */

public class MirrorTree {

    public void mirror(TreeNode root) {
        if (root == null)
            return;

        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;

        mirror(root.left);
        mirror(root.right);
    }

}
