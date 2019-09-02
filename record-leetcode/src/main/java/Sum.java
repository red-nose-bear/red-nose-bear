/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */

public class Sum {

    /**
     * 利用短路和递归
     *
     * @param n
     * @return
     */
    public int sum(int n) {
        int res = n;
        boolean flag = n > 0 && (res += sum(n - 1)) > 0;
        return res;
    }

}
