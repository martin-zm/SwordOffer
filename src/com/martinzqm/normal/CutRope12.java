package com.martinzqm.normal;

/**
 * @Author miao
 * @Description: 给定一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],…,k[m]。请问k[0]* k[1] * … *k[m]可能的最大乘积是多少？
 * @Date 2018/8/23 6:35
 */
public class CutRope12 {
    public int cutRope(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int[] f = new int[length + 1];
        // 定义绳子长度
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        f[3] = 3;
        for (int i = 4; i <= length; ++i) {
            int max = 0;
            for (int j = 1; j <= i / 2; ++j) {
                int num = f[j] * f[i-j];
                if (max < num) {
                    max = num;
                }
                f[i] = num;
            }
        }
        return f[length];
    }
}
