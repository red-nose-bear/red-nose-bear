package array;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
 * 考点：寻找规律，代码规范
 * 每圈开始打印的第一个数的行列坐标值一定相同;
 * 能继续循环打印的条件是：colLength > startX * 2 && rowLength > startY * 2;
 * 如何打印一圈？
 * 1. 从左到右打印一行 （该步必需）
 * 2. 从上到下打印一列 （终止行号 > 起始行号）
 * 3. 从右到左打印一行 （终止行号 > 起始行号 && 终止列号大于起始列号）
 * 4. 从下到上打印一列 （至少有3行两列，终止行号 >= 起始行号+2 && 终止列号 > 起始列号）
 */

public class PrintMatrix {

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null)
            throw new RuntimeException("输入非法！");

        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<>();

        int start = 0;
        while (rowLength > start * 2 && colLength > start * 2) {
            printMatrixInCircle(start, rowLength, colLength, matrix, res);
            start++;
        }

        return res;
    }

    private void printMatrixInCircle(int start, int rowLength, int colLength, int[][] matrix, ArrayList<Integer> res) {
        int endX = colLength - 1 - start;
        int endY = rowLength - 1 - start;

        // 1. 从左到右 - 必需
        for (int cur = start; cur <= endX; cur++)
            res.add(matrix[start][cur]);

        // 2. 从上到下 - 终止行号 > 起始行号
        if (endY > start)
            for (int cur = start + 1; cur <= endY; cur++)
                res.add(matrix[cur][endX]);

        // 3. 从右到左 - 终止行号 > 起始行号 && 终止列号 > 起始列号
        if (endY > start && endX > start)
            for (int cur = endX - 1; cur >= start; cur--)
                res.add(matrix[endY][cur]);

        // 4. 从下向上 - 至少3行2列，终止行号>start+1 && 终止列号 > 起始列号
        if (endY > start + 1 && endX > start)
            for (int cur = endY - 1; cur > start; cur--)
                res.add(matrix[cur][start]);
    }

}
