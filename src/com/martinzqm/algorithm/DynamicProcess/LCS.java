package com.martinzqm.algorithm.DynamicProcess;

/**
 * @author zhangmiao3
 * @Description: 最长公共子序列
 * @date 16:46 2018/7/7
 */
public class LCS {
    public static void main(String[] args) {

    }

    public static int longestCommonSubsequence(String A, String B) {
        int lengthA = A.length();
        int lengthB = B.length();

        if(lengthA == 0 || lengthB == 0) {
            return 0;
        }

        int[][] dp = new int[lengthA][lengthB];
        dp[0][0] = A.charAt(0) == B.charAt(0) ? 1 : 0;

        for (int i = 0; i < lengthA; ++i) {
            dp[i][0] = Math.max(dp[i-1][0], A.charAt(i) == B.charAt(0) ? 1 : 0);
        }

        for (int j = 0; j < lengthB; ++j) {
            dp[0][j] = Math.max(dp[0][j], A.charAt(0) == B.charAt(j) ? 1 : 0);
        }

        for (int i = 1; i < lengthA; ++i) {
            for (int j = 1; j < lengthB; ++j) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                if (A.charAt(i) == B.charAt(j)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
                }
            }
        }

        return dp[lengthA - 1][lengthB - 1];
    }
}
