package array;

/**
 * 数组：异或运算
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字
 * <p>
 * 思路：
 * https://www.cnblogs.com/youxin/p/3349834.html
 */

public class FindNumsAppearOnce {

    public void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || array.length < 2)
            return;

        // 利用异或运算，得到这两个只出现一次的数字的异或结果
        int temp = 0;
        for (int i = 0; i < array.length; i++)
            temp ^= array[i];

        // 得到异或结果二进制码中第一个为1的下标
        int indexOfFirst1 = getIndexOfFirst1(temp);

        // 根据 indexOfFirst1 将 array 分为两个数组
        num1[0] = 0;
        num2[0] = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] >> indexOfFirst1 & 1) == 1)
                num1[0] ^= array[i];
            else
                num2[0] ^= array[i];
        }
    }

    private int getIndexOfFirst1(int temp) {
        int indexOfFirst1 = 0;
        int tempVal = 1 & temp;
        while (tempVal != 1) {
            tempVal = 1 & (temp >> 1);
            indexOfFirst1++;
        }
        return indexOfFirst1;
    }

}
