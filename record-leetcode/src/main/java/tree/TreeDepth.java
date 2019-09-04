package tree;

import tree.base.TreeNode;

import java.util.*;


/**
 * 树：二叉树的深度，递归思维，按层次遍历
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */

public class TreeDepth {

    public int treeDepth(TreeNode root) {
        if (root == null)
            return 0;

        List<Integer> list = new ArrayList<>();
        List<TreeNode> path = new ArrayList<>();
        findPathDepth(list, root, path);
        Optional<Integer> max = list.stream().max(Comparator.comparing(Integer::intValue));
        return max.get();
    }

    private void findPathDepth(List<Integer> list, TreeNode root, List<TreeNode> path) {
        if (root == null)
            return;
        path.add(root);
        if (root.left == null && root.right == null)
            list.add(path.size());

        findPathDepth(list, root.left, path);
        findPathDepth(list, root.right, path);
        path.remove(path.size() - 1);
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public int treeDepth_solution1(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(1 + treeDepth_solution1(root.left), 1 + treeDepth_solution1(root.right));
    }

    /**
     * 二叉树的按层次遍历 - 用到队列
     *
     * @param root
     * @return
     */
    public int treeDepth_solution2(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);
        int pollCount = 0, depth = 0, needPollCount = 1;
        while (!treeNodeQueue.isEmpty()) {
            TreeNode pollNode = treeNodeQueue.poll();
            pollCount++;
            if (pollNode.left != null)
                treeNodeQueue.offer(pollNode.left);
            if (pollNode.right != null)
                treeNodeQueue.offer(pollNode.right);

            if (pollCount == needPollCount) {
                pollCount = 0;
                depth++;
                needPollCount = treeNodeQueue.size();
            }
        }
        return depth;
    }
}
