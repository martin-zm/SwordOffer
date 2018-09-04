package com.martinzqm.normal;

/**
 * @Author miao
 * @Description: 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * @Date 2018/8/23 6:04
 */
public class RobotMovingCount11 {
    public int movingCount(int threshold, int rows, int cols) {
        boolean[] isVisited = new boolean[rows * cols];
        int count = movingCountCore(threshold, rows, cols, 0, 0, isVisited);
        return count;
    }

    // 核心回溯法
    public int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] isVisited) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, isVisited)) {
            isVisited[row * cols + col] = true;
            count = 1 + movingCountCore(threshold, rows, cols, row - 1, col, isVisited)
                    + movingCountCore(threshold, rows, cols, row + 1, col, isVisited)
                    + movingCountCore(threshold, rows, cols, row, col - 1, isVisited)
                    + movingCountCore(threshold, rows, cols, row, col + 1, isVisited);
        }
        return count;
    }

    // 检查某一方格是否满足要求
    public boolean check(int threshold, int rows, int cols, int row, int col, boolean[] isVisited) {
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && getDigitSum(row) + getDigitSum(col) <= threshold
                && isVisited[row * cols + col] == false) {
            return true;
        } else {
            return false;
        }
    }

    // 获取位数和
    public int getDigitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}