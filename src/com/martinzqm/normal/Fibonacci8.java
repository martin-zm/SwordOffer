package com.martinzqm.normal;

/**
 * @Author miao
 * @Description: 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * @Date 2018/8/22 7:26
 */
public class Fibonacci8 {
    // 递归
    public int solution1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return solution1(n - 1) + solution1(n - 2);
    }

    // 非递归
    public int solution2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int fib1 = 0;
        int fib2 = 1;
        int fib = 0;
        for (int i = 2; i <= n; ++i) {
            fib = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib;
        }
        return fib;
    }
}