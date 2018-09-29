package com.martinzqm.normal;

/**
 * @Author miao
 * @Description: 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * @Date 2018/8/23 9:31
 */
public class Power14 {
    private boolean isValidInput;

    // 关键是考虑细节
    public double pow(double base, int exponent) {
        // 考虑底数为0.0，指数小于0的情况
        if (equals(base, 0.0) && exponent < 0) {
            isValidInput = false;
            return 0.0;
        }
        int n = Math.abs(exponent);
        double result = powWithPositive(base, n);
        if (exponent > 0) {
            return result;
        } else {
            return 1.0 / result;
        }
    }

    // double类型数据判断是否相等
    public boolean equals(double a, double b) {
        if (a - b > (- 0.000000001) && (a - b) < 0.000000001) {
            return true;
        } else {
            return false;
        }
    }

    // 整数次幂
    public double powWithPositive(double base, int n) {
        double result = 1.0;
        for (int i = 1; i <= n; ++i) {
            result *= base;
        }
        return result;
    }
}