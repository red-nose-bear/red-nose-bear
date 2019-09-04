/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
 */
public class NumberOf1 {

    public int numberOf1(int n) {
        int flag = 1;
        int count = 0;
        while (flag != 0) {
            if ((flag & n) != 0)
                count++;
            flag = flag << 1;
        }
        return count;
    }

}
