package tree;


import tree.base.TreeNode;

/**
 * 树 - 二叉搜索树转为双向列表 中序遍历
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向
 * https://blog.csdn.net/jsqfengbao/article/details/47333515
 * <p>
 * 递归调用时会保存栈的变量信息，所以要公共修改的内容最好放在堆中
 */

public class ConvertBinarySearchTreeToList {

    private TreeNode head = null;
    private TreeNode realHead = null;

    public TreeNode convert(TreeNode pRootOfTree) {
        convertSub(pRootOfTree);
        return realHead;
    }

    private void convertSub(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return;
        convertSub(pRootOfTree.left);

        if (head == null) {
            head = pRootOfTree;
            realHead = pRootOfTree;
        } else {
            pRootOfTree.left = head;
            head.right = pRootOfTree;
            head = pRootOfTree;
        }

        convertSub(pRootOfTree.right);
    }

}
