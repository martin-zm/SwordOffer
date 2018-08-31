package com.martinzqm.normal;

/**
 * @Author miao
 * @Description: 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @Date 2018/8/31 19:07
 */
public class SumSolution62 {
    public static int sum(int n) {
        int sum = n;
        boolean b = ((n > 0) && (sum += sum(n - 1)) > 0);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sum(100));
    }
}
