package tree;

import com.alibaba.fastjson.JSON;
import tree.base.TreeNode;

import java.util.*;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */

public class PrintTree {

    /**
     * 用到了Collections.reverse()当数据量大时很低效
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        if (pRoot == null)
            return resList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int countOfEachLevel = 1;
        int count = 0;
        boolean flag = true;
        List<Integer> tempList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            TreeNode pollNode = queue.poll();
            if (flag)
                tempList.add(pollNode.val);
            else
                stack.push(pollNode.val);
            count++;
            if (pollNode.left != null)
                queue.offer(pollNode.left);
            if (pollNode.right != null)
                queue.offer(pollNode.right);

            if (count == countOfEachLevel) {
                // 该层已遍历完
                while (!stack.isEmpty()) {
                    tempList.add(stack.pop());
                }
                resList.add(new ArrayList<>(tempList));
                tempList.clear();
                flag = !flag;
                count = 0;
                countOfEachLevel = queue.size();
            }
        }
        return resList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode n6 = new TreeNode(6);
        TreeNode n10 = new TreeNode(10);
        TreeNode n5 = new TreeNode(5);
        TreeNode n7 = new TreeNode(7);
        TreeNode n9 = new TreeNode(9);
        TreeNode n11 = new TreeNode(11);
        root.left = n6;
        root.right = n10;
        n6.left = n5;
        n6.right = n7;
        n10.left = n9;
        n10.right = n11;
        PrintTree printTree = new PrintTree();
        ArrayList<ArrayList<Integer>> print = printTree.Print(root);
        System.out.println(JSON.toJSONString(print));
    }

}