package tree;

/**
 * 树：二叉树的下一个节点
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * ------------------
 * 思路：
 * 中序遍历：左 -> 根 -> 右
 * 分三种情况：
 * - 如果当前节点为空，直接返回空；
 * - 如果当前节点有右子树，则返回右子树的最左子树；
 * - 如果当前节点没有右子树，再分两种情况：
 * * * 看看当前节点是不是它的父节点的左子树，如果是，则返回它的父节点；
 * * * 如果当前节点不是它的父节点的左子树，则把父节点赋给当前节点，再判断当前节点是不是它的父节点的左子树，直到当前节点是它的父节点的左子树，返回它的父节点。
 * 图：https://uploadfiles.nowcoder.com/files/20171225/773262_1514198075109_20151104234034251
 */

public class GetNext {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null)
            return null;
        if (pNode.right != null) { // 当前节点有右子树，则下一个节点是其右子树的最左节点
            TreeLinkNode tempNode = pNode.right;
            while (tempNode.left != null) {
                tempNode = tempNode.left;
            }
            return tempNode;
        } else {
            TreeLinkNode root = pNode.next;
            while (root != null && root.left != pNode) {
                pNode = root;
                root = pNode.next;
            }
            return root;
        }
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null; // 指向父节点

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
