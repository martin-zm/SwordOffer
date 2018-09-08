package com.martinzqm.normal;

import java.util.LinkedList;

/**
 * @Author miao
 * @Description: 题目：0，1，，，，，n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈中删除第m个数字。
 * 求出这个圆圈里剩下的最后一个数字.
 * @Date 2018/9/1 20:25
 */
public class LastRemainingInCircle60 {
    // 利用循环链表来解
    public int lastRemaining(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            list.add(i);
        }
        int delete = 0;
        while (list.size() > 1) {
            delete = (delete + m - 1) % n;
            list.remove(delete);
        }
        return list.size() == 1 ? list.get(0) : -1;
    }

    // 找规律来解决
    // f(n, m) = 0   n = 1
    // f(n, m) = (f(n-1, m) + m) % n;
    public int lastRemaining1(int n, int m) {
        if (n < 1 || m < 1)
            return -1;
        int last = 0;
        for (int i = 2; i <= n; ++ i) {
            last = (last + m) % i;
        }
        return last;
    }

}
