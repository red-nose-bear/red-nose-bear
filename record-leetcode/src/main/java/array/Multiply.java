package array;

/**
 * 数组：
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * ------------------------
 * 思路：
 * B[i]的值可以看作下图的矩阵中每行的乘积。
 * 下三角用连乘可以很容求得，上三角，从下向上也是连乘。
 * 因此我们的思路就很清晰了，先算下三角中的连乘，即我们先算出B[i]中的一部分，然后倒过来按上三角中的分布规律，把另一部分也乘进去。
 * https://uploadfiles.nowcoder.com/images/20160829/841505_1472459965615_8640A8F86FB2AB3117629E2456D8C652
 * ------------------------
 */

public class Multiply {

    public int[] multiply(int[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1)
            return arr;

        int len = arr.length;
        int[] resArr = new int[len];

        // 先计算下三角
        resArr[0] = 1;
        for (int i = 1; i < len; i++) {
            resArr[i] = resArr[i-1] * arr[i-1];
        }

        // 再倒过来计算上三角
        int temp = 1;
        for (int i = len-2; i>=0; i--) {
            temp *= arr[i+1];
            resArr[i] *= temp;
        }
        return resArr;
    }

}
