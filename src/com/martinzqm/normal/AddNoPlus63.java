package com.martinzqm.normal;

/**
 * @Author miao
 * @Description: 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * @Date 2018/8/31 19:01
 */
public class AddNoPlus63 {
    public int add(int num1, int num2) {
        int sum = 0;
        while (num2 != 0) {
            // 无进位求和
            sum = num1 ^ num2;
            // 求进位
            int carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }
        return sum;
    }
}
