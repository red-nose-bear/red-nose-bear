/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方
 * 考点：代码的鲁棒性，快速幂算法
 */

public class Power {

    public double power(double base, int exponent) {
        /**
         * 考虑的情况：
         * 1. base=0，exponent=0 无意义
         * 2. base=0， exponent<0 不可以
         * 3. base != 0， exponent=0 返回1
         * 4. 其他情况
         *      先按照指数为正的情况用快速幂方法计算值，返回结果时判断指数正负返回对应的值
         *
         * 快速幂算法：
         *      a^n 可以用 a, a^2, a^4, a^8, ......, a^2k 中的值相乘得到
         *      幂在电脑中是用二进制表示的，如13表达为二进制1101 = 2^0 + 2^2 + 2^3
         */

        if (base == 0 && exponent == 0)
            throw new RuntimeException("0的0次方无意义！");
        if (base == 0 && exponent < 0)
            throw new RuntimeException("输入非法，0不可以做分母！");
        if (exponent == 0)
            return 1;

        double cur = base, res = 1;
        int e = exponent;
        if (exponent < 0)
            e *= -1;
        while (e != 0) {
            if ((e & 1) == 1)
                res *= cur;
            cur *= cur;
            e = e >> 1;
        }
        return exponent > 0 ? res : 1/res;
    }

}
