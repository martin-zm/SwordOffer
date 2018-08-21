package com.martinzqm.DynamicProcess;

/**
 * @author zhangmiao3
 * @Description:
 * 给定数组arr，arr中所有的值都为整数且不重复。每个值代表一种面值的货币，
 * 每种货币有无数张，再给定一个整数aim代表要找的钱数，求换钱的方法有多少种。
 * 比如：
 * arr = [5, 10, 25, 1]，aim = 1000
 *
 * @date 14:23 2018/6/30
 */
public class ChangeMoneyCount {
    public static void main(String[] args) {
        int[] array = {5, 10 , 25, 1};
        System.out.println(coins4(array, 1000));
    }


    // 暴力搜索方法
    public static int coins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }
    public static int process1(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res = (aim == 0) ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; ++i) {
                res += process1(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }

    // 记忆搜索方法
    public static int coins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        // 定义一张表来记录计算过的值，从而避免重复计算
        // map[i][j] == 0 表示没有计算过
        // map[i][j] == -1 表示计算过，但是值为0
        // map[i][j] == a 表示计算过，值为a
        int[][] map = new int[arr.length + 1][aim + 1];
        return process2(arr, 0, aim, map);
    }
    public static int process2(int[] arr, int index, int aim, int[][] map) {
        int res = 0;
        if (index == arr.length) {
            res = (aim == 0) ? 1 : 0;
        } else {
            int mapValue = 0;
            for (int i = 0; arr[index] * i <= aim; ++i) {
                mapValue = map[index + 1][aim - arr[index] * i];
                if (mapValue != 0) {
                    res += mapValue == -1 ? 0 : mapValue;
                } else {
                    res += process2(arr, index + 1, aim - arr[index] * i, map);
                }
            }
        }
        map[index][aim] = res == 0 ? -1 : res;
        return res;
    }

    // 动态规划方法
    public static int coins3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        // dp[i][j]的含义是在使用arr[0..i]货币的情况下，组成钱数j有多少种方法
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; ++i) {
            dp[i][0] = 1;
        }
        for (int j = 0; j * arr[0] <= aim; j++) {
            dp[0][j * arr[0]] = 1;
        }
        for (int i = 1; i < arr.length; ++i) {
            for (int j = 1; j <= aim; ++j) {
                int num = 0;
                for (int k = 0; j - k * arr[i] >= 0; ++k) {
                    num += dp[i - 1][j - k * arr[i]];
                }
                dp[i][j] = num;
            }

        }
        return dp[arr.length - 1][aim];
    }

    // 动态规划方法优化
    public static int coins4(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        // dp[i][j]的含义是在使用arr[0..i]货币的情况下，组成钱数j有多少种方法
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; ++i) {
            dp[i][0] = 1;
        }
        for (int j = 0; j * arr[0] <= aim; j++) {
            dp[0][j * arr[0]] = 1;
        }
        for (int i = 1; i < arr.length; ++i) {
            for (int j = 1; j <= aim; ++j) {
                dp[i][j] = dp[i - 1][j] + (j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0);
            }
        }
        return dp[arr.length - 1][aim];
    }
}
