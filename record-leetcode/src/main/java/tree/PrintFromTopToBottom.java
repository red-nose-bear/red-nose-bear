package tree;

import tree.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 树 - 二叉树的广度优先遍历
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印
 * <p>
 * 思路：
 * 1. 准备一个队列和一个列表，先把树节点放入队尾
 * 2. 循环从队列头取内容，值放入列表中，若取出的节点仍有子节点，则将左右子结点放入队尾，循环此过程，直至队列为空
 */

public class PrintFromTopToBottom {

    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> resList = new ArrayList<>();
        if (root == null)
            return resList;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            resList.add(tempNode.val);
            if (tempNode.left != null)
                queue.offer(tempNode.left);
            if (tempNode.right != null)
                queue.offer(tempNode.right);
        }

        return resList;
    }

}
