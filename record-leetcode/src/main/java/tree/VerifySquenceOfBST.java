package tree;

/**
 * 树 - 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * 思路：
 * 什么是二叉搜索树？也就是二叉排序树：是空树 或者 满足左子树节点小于根节点 右子树大于根
 * 后序遍历：左右根 最后一个数是根节点
 * 遍历序列 找到第一个大于root的位置 该位置左边为左子树 右边为右子树
 * 遍历右子树 若发现有小于root的值 直接返回false
 * 分别判断左子树和右子树是否仍是二叉搜索树
 * 一般关于二叉树的题目 ：可以考虑递归 因为左右子树都是类似的操作
 * 5 7 6 9 11 10 8
 * 1.先root=8 左子树 5 7 6 右子树9 11 10
 * 2. 对左子树 5 7 6 、、6变成左子树的根节点 5 7
 * 3. 右子树的判断也是一样的
 */
public class VerifySquenceOfBST {

    public boolean verifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;

        return isAfterOrderOfBST(sequence, 0, sequence.length - 1);

    }

    private boolean isAfterOrderOfBST(int[] sequence, int start, int rootIndex) {
        if (start >= rootIndex)
            return true;
        int i = rootIndex;
        // 从后开始查找
        while (i > start && sequence[i - 1] > sequence[rootIndex]) {
            i--;
        }
        // 左子树必须都小于根节点的值
        for (int j = start; j <= i - 1; j++) {
            if (sequence[j] > sequence[rootIndex])
                return false;
        }

        return isAfterOrderOfBST(sequence, start, i - 1) && isAfterOrderOfBST(sequence, i, rootIndex - 1);
    }

}
