package array;

/**
 * 统计一个数字在排序数组中出现的次数
 * <p>
 * 思路：
 * 题中提到排序数组，则可以用二分法
 * 1. 直接用二分法，找到K，然后向前顺序查找到第一个K的位置，向后顺序查找到最后一个K的位置，这样时间复杂度为O(n)，不可取
 * 2. 一直使用二分法找到第一个K的位置和最后一个K的位置
 *
 * 二分查找法可用递归可用循环
 * 递归方式：方法头进行判断 if(start > end) return
 * 循环方式：用while循环 while(start <= end)
 */

public class GetNumberOfK {

    public int getNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0)
            return 0;
        int firstIndex = getFirstIndexOfKWithRecursiveFun(array, 0, array.length - 1, k);
        int lastIndex = getLastIndexOfKWithRecursiveFun(array, 0, array.length - 1, k);
        return firstIndex == -1 ? 0 : lastIndex - firstIndex + 1;
    }

    private int getFirstIndexOfKWithRecursiveFun(int[] array, int start, int end, int k) {
        if (start > end)
            return -1;
        int mid = (end + start) / 2;
        if (array[mid] > k)
            end = mid - 1;
        else if (array[mid] < k)
            start = mid + 1;
        else if (mid > 0 && array[mid - 1] == k)
            end = mid - 1;
        else
            return mid;
        return getFirstIndexOfKWithRecursiveFun(array, start, end, k);
    }

    private int getLastIndexOfKWithRecursiveFun(int[] array, int start, int end, int k) {
        if (start > end)
            return -1;
        int mid = (end + start) / 2;
        if (array[mid] > k)
            end = mid - 1;
        else if (array[mid] < k)
            start = mid + 1;
        else if (mid + 1 < array.length && array[mid + 1] == k)
            start = mid + 1;
        else
            return mid;
        return getLastIndexOfKWithRecursiveFun(array, start, end, k);
    }

    private int getFirstIndexOfKWithCircleFun(int[] array, int start, int end, int k) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] > k)
                end = mid - 1;
            else if (array[mid] < k)
                start = mid + 1;
            else if (mid > 0 && array[mid - 1] == k)
                end = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    private int getLastIndexOfKWithCircleFun(int[] array, int start, int end, int k) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (array[mid] > k)
                end = mid - 1;
            else if (array[mid] < k)
                start = mid + 1;
            else if (mid + 1 < array.length && array[mid + 1] == k)
                start = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 3};
        GetNumberOfK getNumberOfK = new GetNumberOfK();
        getNumberOfK.getNumberOfK(array, 3);
    }

}
