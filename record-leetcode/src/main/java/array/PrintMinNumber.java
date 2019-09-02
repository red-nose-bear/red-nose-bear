package array;

/**
 * 数组：思维，排序，字符串的字典序
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */

public class PrintMinNumber {

    public String printMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            throw new RuntimeException("非法输入");

        int len = numbers.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                String ab = numbers[i] + "" + numbers[j];
                String ba = numbers[j] + "" + numbers[i];
                if (ab.compareTo(ba) > 0) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
            sb.append(numbers[i]);
        }

        return sb.toString();
    }

}