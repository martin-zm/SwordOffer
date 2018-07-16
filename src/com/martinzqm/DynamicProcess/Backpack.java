package com.martinzqm.DynamicProcess;

/**
 * @author zhangmiao3
 * @Description: 背包问题
 * 一个背包有一定的承重W,有N件物品,每件都有自己的价值,记录在数组v中,也都有自己的重量,记录在数组w中,
 * 每件物品只能选择要装入背包还是不装入背包,要求在不超过背包承重的前提下,选出物品的总价值最大。
 * @date 17:39 2018/7/7
 */
public class Backpack {
    public static void main(String[] args) {

    }

    public static int backpack(int[] w, int[] v, int W, int N) {
        int[][] dp = new int[N+1][W+1];
        for (int i = 1 ; i <= N; ++i) {
            for (int j = 1; j <= W; ++j) {
                if (j >= w[i-1]) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i-1]] + v[i-1]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][W];
    }

}
