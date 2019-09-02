package array;

import java.util.ArrayList;

/**
 * 数组
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的
 * 输出描述：对应每个测试案例，输出两个数，小的先输出
 */
·

public class FindNumbersWithSum {

    /**
     * 暴力解法
     *
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> resList = new ArrayList<>();
        if (array == null || array.length < 2)
            return resList;

        int temp = Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (i != j && array[i] + array[j] == sum) {
                    list.add(array[i]);
                    list.add(array[j]);
                    temp = temp > array[i] * array[j] ? array[i] * array[j] : temp;
                }
            }
        }
        for (int i = 0; i < list.size(); ) {
            Integer temp1 = list.get(i++);
            Integer temp2 = list.get(i++);
            if (temp1 * temp2 == temp) {
                resList.add(temp1 > temp2 ? temp2 : temp1);
                resList.add(temp1 > temp2 ? temp1 : temp2);
                break;
            }
        }
        return resList;
    }

    /**
     * 设置前后指针start，end
     * array[start] + array[end] == sum 得到结果(递增排序的数组，相差越远乘积越小)
     * array[start] + array[end] > sum  end--
     * array[start] + array[end] < sum  start++
     *
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> findNumbersWithSum_solution(int[] array, int sum) {
        ArrayList<Integer> resList = new ArrayList<>();
        if (array == null || array.length < 2)
            return resList;

        int start = 0, end = array.length - 1;
        while (start < end) {
            int curSum = array[start] + array[end];
            if (curSum == sum) {
                resList.add(array[start]);
                resList.add(array[end]);
                break;
            } else if (curSum > sum)
                end--;
            else
                start++;
        }
        return resList;
    }
}
