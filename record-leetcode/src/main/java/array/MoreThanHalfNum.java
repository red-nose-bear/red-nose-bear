package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0
 */

public class MoreThanHalfNum {

    /**
     * 方法1：借助hashMap，时间复杂度O(n)，空间复杂度O(n)
     */
    public int MoreThanHalfNum_Solution1(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            int temp = map.get(i) == null ? 0 : map.get(i);
            map.put(i, temp + 1);
        }
        int flag = array.length / 2;
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            if (map.get(key) > flag)
                return key;
        }
        return 0;
    }

    /**
     * 方法二：将数组排序，若存在这样的值，数组中间的值即为所求，遍历数组，看该值出现次数
     * 时间复杂度O(nlogn)
     */
    public int MoreThanHalfNum_Solution2(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        Arrays.sort(array);
        int half = array.length / 2;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == array[half])
                count++;
        }
        if (count > half)
            return array[half];
        else
            return 0;
    }

    /**
     * 方法三：设置两个值，记录数组值和该值出现的次数，遍历数组，值重复出现则次数+1，值发生变化则次数-1
     * 时间复杂度O(n)，空间复杂度O(1)   为最优解
     */
    public int MoreThanHalfNum_Solution3(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        int count = 1;
        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] == res)
                count++;
            else
                count--;

            if (count == 0) {
                count = 1;
                res = array[i];
            }
        }
        count = 0;
        for (int i : array) {
            if (i == res)
                count++;
        }
        return count > array.length / 2 ? res : 0;
    }

}
