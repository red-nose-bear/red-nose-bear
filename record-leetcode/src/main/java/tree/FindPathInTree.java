package tree;

import tree.base.TreeNode;

import java.util.ArrayList;

/**
 * 树 - 二叉树中和为某值的路径
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 * <p>
 * 思路：
 * 确定路径必须先从根节点遍历，则为二叉树的前序遍历
 * 在遍历过程中要保存遍历过的节点，以便遍历过程中回退到根节点；
 * 一定要遍历到叶节点才算是一条路径
 */

public class FindPathInTree {

    public ArrayList<ArrayList<Integer>> findPathInTree(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        if (root == null)
            return resList;
        // 用来记录路径
        ArrayList<Integer> path = new ArrayList<>();
        return findPath(root, target, path, resList);
    }

    private ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> resList) {
        if (root == null)
            return resList;

        // 每遍历到一个顶点，就加入到路径中，且调整target的值
        path.add(root.val);
        target -= root.val;

        // 路径上各节点值之和为target
        if (target == 0 && root.left == null && root.right == null)
            resList.add(new ArrayList<>(path));

        // 递归遍历
        findPath(root.left, target, path, resList);
        findPath(root.right, target, path, resList);

        /**
         * 该路径不满足条件，回退到上一个根节点
         * 回退到上一个根节点时，target无需加上回退节点的值，因为递归栈的环境会被保存
         * 每次递归时，当前变量的值都会重新拷贝一份儿，进入到下次遍历中。也就是说，当前遍历过程中的各个变量值，会被保存到当前的环境中。当前遍历结束，各个变量被销毁，不会影响到回退的遍历。即遍历压栈是将当前环境压栈。
         */
        path.remove(path.size() - 1);

        return resList;
    }

}
