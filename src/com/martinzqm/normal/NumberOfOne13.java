package com.martinzqm.normal;

/**
 * @Author miao
 * @Description: 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @Date 2018/8/23 9:18
 */
public class NumberOfOne13 {
    // 定义一个标志位，左移然后进行与运算
    public int solution1(int n) {
        int flag = 1;
        int count = 0;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    // 巧妙运算：有多少1就能进行多少次这样的运算
    public int solution2(int n) {
       int count = 0;
       while (n != 0) {
           count++;
           n = n & (n - 1);
       }
       return count;
    }
}