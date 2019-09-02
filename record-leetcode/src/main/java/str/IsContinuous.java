package str;

import java.util.Arrays;

/**
 * 字符串：扑克牌顺子
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,
 * 如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,
 * 并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 * <p>
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子， 即这5张牌是不是连续的。2～10为数字本身， A为1。 J为11、Q为12、 为13。小王可以看成任意数字。
 * <p>
 * 解题思路
 * 我们可以把5张牌看成由5个数字组成的数组。大、小王是特殊的数字，我们不妨把它们都定义为0，这样就能和其他扑克牌区分开来了。
 * 接下来我们分析怎样判断5个数字是不是连续的，最直观的方法是把数组排序。值得注意的是，由于0可以当成任意数字，我们可以用0去补满数组中的空缺。
 * 如果排序之后的数组不是连续的，即相邻的两个数字相隔若干个数字，但只要我们有足够的0可以补满这两个数字的空缺，这个数组实际上还是连续的。
 * 举个例子，数组排序之后为{0，1，3，4，5}在1和3之间空缺了一个2，刚好我们有一个0，也就是我们可以把它当成2去填补这个空缺。
 * 于是我们需要做3 件事情： 首先把数组排序，再统计数组中0 的个数，最后统计排序之后的数组中相邻数字之间的空缺总数。如果空缺的总数小于或者等于0 的个数，那么这个数组就是连续的：反之则不连续。
 * 最后，我们还需要注意一点： 如果数组中的非0 数字重复出现，则该数组不是连续的。换成扑克牌的描述方式就是如果一副牌里含有对子，则不可能是顺子。
 * ---------------------
 */

public class IsContinuous {
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length != 5)
            return false;
        // 1. 排序
        Arrays.sort(numbers);
        // 2. 统计 0 的个数
        int numberOfZero = 0;
        for(int i=0; i<numbers.length; i++) {
            if (numbers[i] == 0)
                numberOfZero++;
        }
        if (numberOfZero > 4)
            return false;
        // 3. 遍历数组，查看是否有相同的数字，统计空缺的个数
        int numberOfGap = 0;
        int indexOfSmall = numberOfZero;
        int indexOfBig = numberOfZero + 1;
        while (indexOfBig < numbers.length) {
            if (numbers[indexOfSmall] == numbers[indexOfBig])
                return false;
            numberOfGap += numbers[indexOfBig] - numbers[indexOfSmall] > 1 ? numbers[indexOfBig] - numbers[indexOfSmall] - 1 : 0;
            indexOfSmall++;
            indexOfBig++;
        }

        return numberOfZero >= numberOfGap;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,5,4};
        IsContinuous isContinuous = new IsContinuous();
        boolean continuous = isContinuous.isContinuous(arr);
        System.out.println(continuous);
    }
}