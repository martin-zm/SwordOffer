package com.martinzqm.normal;

import java.util.ArrayList;

/**
 * @Author miao
 * @Description:
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 解析：一定画图
 * @Date 2018/8/26 11:02
 */
public class PrintMatrix27 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int start = 0;
        while (row > 2 * start && column > 2 * start) {
            printCircleMatrix(matrix, row, column, start, result);
            ++start;
        }
        return result;
    }

    public void printCircleMatrix(int [][] matrix, int row, int column,
                                  int start, ArrayList<Integer> result) {
        int endX = column - 1 - start;
        int endY = row - 1 - start;
        // 第一步，向右移动
        for (int i = start; i <= endX; ++i) {
            result.add(matrix[start][i]);
        }
        // 第二部，向下移动
        if (endY > start) {
            for (int i = start + 1; i <= endY; ++i) {
                result.add(matrix[i][endX]);
            }
        }
        // 第三步，向左移动
        if (endY > start && endX > start) {
            for (int i = endX - 1; i >= start; --i) {
                result.add(matrix[endY][i]);
            }
        }
        // 第四步，向上移动
        if (endY > start + 1 && endX > start) {
            for (int i = endY - 1; i >= start; ++i) {
                result.add(matrix[i][start]);
            }
        }
    }
}
