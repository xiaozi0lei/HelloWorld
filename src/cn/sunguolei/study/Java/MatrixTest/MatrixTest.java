package src.cn.sunguolei.study.Java.MatrixTest;

import java.util.ArrayList;

/**
 * @author GuoLei Sun
 * Date: 2019/9/11 10:09 AM
 */
public class MatrixTest {

    public static void main(String[] args) {
        System.out.println(printMatrix(4, 5));
        System.out.println(printMatrix(6, 7));
    }

    private static ArrayList<Integer> printMatrix(int matrixHeight, int matrixWidth) {
        // 生成矩阵，矩阵是一个二维数组
        int[][] matrix = new int[matrixWidth][matrixHeight];
        // 初始化矩阵第一个值为 1
        int counter = 1;
        // 遍历第一维，即 行数
        for (int i = 0; i < matrixWidth; i++) {
            // 遍历第二维，即 列数
            for (int j = 0; j < matrixHeight; j++) {
                // 为每一个位置赋值
                matrix[i][j] = counter;
                // 输出空格，格式化
                System.out.print(counter + " ");
                // 矩阵值为连续的数值
                counter++;
            }
            // 每一行输出完毕后，进入下一行
            System.out.println();
        }

        // 顺时针打印，用列表存放顺时针读取的每一个数值
        ArrayList<Integer> res = new ArrayList<>();
        // 如果行或者列的长度为 0 ，则二维数组为空，直接返回空列表
        if (matrix.length == 0 || matrix[0].length == 0) return res;
        // 计算矩阵的左右上下各个边距的值
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;

        // 当遍历时 顶部 没有抵达矩阵递减的 底部 ，同时 左边距数值 没有抵达矩阵递减的 右边距
        // 任何边距数值相等时，表示遍历已经完成
        while (top <= bottom && left <= right) {
            // 将 横行 各数值加入到列表中
            // 从左到右 完整一行
            for (int i = left; i <= right; i++) {
                // 从左到右横行的 x 值为 top 值，为固定值，y 值为从 left 自增至 right，递增值
                res.add(matrix[top][i]);
            }
            // 将 最右侧 竖行 各数值加入到列表中
            // 去掉最上面的一个值，从上到下各数值
            for (int i = top + 1; i <= bottom; i++) {
                // 从上到下竖行的 x 值为 top+1 值递增至bottom(top值在正序横行时已经加入到列表)，y 值为固定的 right 值
                res.add(matrix[i][right]);
            }
            // 如果遍历到最后只剩一个横行，则 top = bottom，此时正向横行遍历已经将值加入，不再需要反向遍历
            if (top < bottom) {
                // 将反向横行 各数值加入到列表
                // 去掉最右边的一个值，从右往左各数值
                for (int i = right - 1; i >= left; i--) {
                    // 从右到左横行的 x 值为 bottom 固定值，y 值为 right-1 递减到 left 之间的值
                    res.add(matrix[bottom][i]);
                }
            }
            // 如果遍历到最后只剩一个竖行，则 top < bottom, left = right，此时正向竖列遍历已经将值加入，不再需要反向遍历
            if (left < right) {
                // 将反向竖列 各数值加入到列表
                // 去掉最下边、最上边各一个值，从下到上各数值
                for (int i = bottom - 1; i >= top + 1; i--) {
                    // 从下到上竖列的 x 值从bottom-1递减至top+1，y 值固定为 left 不变
                    res.add(matrix[i][left]);
                }
            }
            // top 往下走，数值增大，bottom 往上走，数值减小，left往右走，数值增大，right 往左走，数值减小
            top++;
            bottom--;
            left++;
            right--;
        }
        return res;
    }
}
