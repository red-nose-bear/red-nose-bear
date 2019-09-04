package array;

/**
 * 在一个长度为n的数组里，所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * -----------------------
 * 思路：
 * 方法1：排序数组，遍历找到重复的数字 O(nlogn)
 * 方法2：hashMap O(n) O(n)
 * 方法3：遍历数组，若arr[index] != index, 则swap(arr[index], arr[arr[index]])，直到找到arr[index] = arr[arr[index]]的数字
 */

public class Duplicate {

    public int duplicate(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return -1;

        for (int i : numbers) {
            if (i > numbers.length - 1)
                return -1;
        }

        for (int i=0; i<numbers.length; i++) {
            while (i != numbers[i]) {
                if (numbers[i] == numbers[numbers[i]])
                    return numbers[i];
                swap(numbers, i, numbers[i]);
            }
        }
        return -1;
    }

    private void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,0,2,5,3,6,4,6};
        Duplicate duplicate = new Duplicate();
        int duplicate1 = duplicate.duplicate(arr);
        System.out.println(duplicate1);
    }

}
