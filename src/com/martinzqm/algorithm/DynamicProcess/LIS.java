package com.martinzqm.algorithm.DynamicProcess;

/**
 * @author zhangmiao3
 * @Description: 最长递增子序列问题
 * @date 16:12 2018/7/7
 */
public class LIS {
    public static void main(String[] args) {

    }

    public int longestIncreasingSubsequence(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
