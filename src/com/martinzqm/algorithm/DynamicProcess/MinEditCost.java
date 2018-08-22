package com.martinzqm.algorithm.DynamicProcess;

/**
 * @author zhangmiao3
 * @Description: 最小编辑代价
 * @date 9:55 2018/7/8
 */
public class MinEditCost {
    public static void main(String[] args) {
        // str1="abc",str2=adc",ic=5,dc=3,rc=2
        System.out.println(getMinEditCost("abc", 3, "adc", 3,
                5, 3, 100));
    }

    public static int getMinEditCost(String str1, int m, String str2, int n,
                                     int ic, int dc, int rc) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        // 第一列
        for (int i = 1; i <= m; ++i) {
            dp[i][0] = i * dc;
        }
        // 第一行
        for (int j = 1; j <= n; ++j) {
            dp[0][j] = j * ic;
        }
        // dp[i][j]
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                int temp = Math.min(dp[i - 1][j] + dc, dp[i][j - 1] + ic);
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = Math.min(temp, dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.min(temp, dp[i - 1][j - 1] + rc);
                }
            }
        }
        return dp[m][n];
    }
}
