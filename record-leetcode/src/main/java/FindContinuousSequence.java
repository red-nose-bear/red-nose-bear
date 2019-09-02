import java.util.ArrayList;

/**
 * 和为S的连续正数序列
 * 题目: 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * <p>
 * 输出描述：输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * <p>
 * 题目重点：正数序列，连续的，序列中至少包含两个数
 */

public class FindContinuousSequence {

    /**
     * 暴力解法
     * 只有在sum/2及之前的数字中能找到满足条件的解，在这个范围中列举出所有的解。O(n^2)
     *
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();

        // 只有sum>=3时才有解
        if (sum < 3)
            return resList;
        for (int i = 1; i <= sum / 2; i++) {
            for (int len = 2; ; len++) {
                int curSum = getSum(i, len);
                if (sum == curSum)
                    // 保存满足条件的结果
                    saveResult(resList, i, len);
                if (curSum > sum)
                    break;
            }
        }

        return resList;
    }

    private void saveResult(ArrayList<ArrayList<Integer>> resList, int start, int len) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = start; i < start + len; i++) {
            list.add(i);
        }
        resList.add(list);
    }

    private int getSum(int start, int len) {
        int end = start + len - 1;
        // 连续正数序列之和
        return (start + end) * len / 2;
    }

    /**
     * 滑动窗口方式解决
     * 设置前后指针，当和<S时，右指针右滑；当和>S时，左指针右滑
     *
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> findContinuousSequence_slidingWindow(int sum) {
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();

        // 只有sum>=3时才有解
        if (sum < 3)
            return resList;

        int left = 1, right = 2;
        while (left < right) {
            int curSum = (left + right) * (right - left + 1) / 2;
            if (curSum == sum) {
                saveResult(resList, left, right - left + 1);
                left++;
            } else if (curSum < sum)
                right++;
            else
                left++;
        }

        return resList;
    }
}
