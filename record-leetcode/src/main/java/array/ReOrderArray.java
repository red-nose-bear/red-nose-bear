package array;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变
 */
public class ReOrderArray {
    public void reOrderArray(int[] array) {
        if (array == null || array.length == 0)
            return;
        int len = array.length;
        for (int i = 1; i < len; i++) {
            int moveNum = array[i];
            int j = i - 1;
            for (; j >= 0 && isOddNum(moveNum); j--) {
                if (!isOddNum(array[j]))
                    array[j + 1] = array[j];
                else
                    break;
            }
            array[j + 1] = moveNum;
        }
    }

    private boolean isOddNum(int moveNum) {
        if (moveNum % 2 == 0)
            return false;
        return true;
    }
}
