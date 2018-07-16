package com.martinzqm.DynamicProcess;

/**
 * @author zhangmiao3
 * @Description: 台阶问题 *
 * 题目：有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。为了防止溢出，请将结果Mod 1000000007
 * @date 14:12 2018/7/7
 */
public class JumpStep {

    public static void main(String[] args) {
//        System.out.println(jumpStep1(10));
        System.out.println(jumpStep3(10));
    }

    // 暴力递归方法
    public static int jumpStep1(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        return jumpStep1(n - 1) + jumpStep1(n - 2);
    }

    // 直接遍历
    public static int jumpStep2(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        // 当前值
        int pre = 1;
        // 前一个值
        int res = 2;
        int temp = 0;

        for (int i = 3; i <= n; ++i) {
            temp = res;
            res = res + pre;
            pre = temp;
        }

        return res;
    }

    // 动态规划方法
    public static int jumpStep3(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }

        int[] res = new int[n + 1];
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i <= n; ++i) {
            res[i] = res[i-1] + res[i-2];
        }
        return res[n];
    }

}
