package com.martinzqm.DynamicProcess;

/**
 * @author zhangmiao3
 * @Description: 矩阵的最小路径和
 * 给定一个矩阵m，从左上角开始每次只能向右或者向下走，最后到达右下角的为止，路径上所有的数字累加起来就是路径和，返回所有路径中的最小的路径和。
 * @date 14:53 2018/7/7
 */
public class MinimumPath {
    public static void main(String[] args) {
        int[][] arr =  {{1, 3, 5, 9},
                        {8, 1, 3, 4},
                        {5, 0, 6, 1},
                        {8, 8, 4, 0}};
        System.out.println(getMin(arr));
    }

    public static int getMin(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null || arr[0].length == 0) {
            return 0;
        }
        int rows = arr.length;
        int cols = arr[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < rows; ++i) {
            dp[i][0] =  arr[i][0] + dp[i-1][0];
        }
        for (int j = 1; j < cols; ++j) {
            dp[0][j] += arr[0][j] + dp[0][j-1];
        }
        for (int i = 1; i < rows; ++i) {
            for (int j = 1; j < cols; ++j) {
                dp[i][j] = arr[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[rows - 1][cols - 1];
    }
}
