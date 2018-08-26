package com.martinzqm.algorithm.Greedy;

/**
 * @Author miao
 * @Description: 假设1元、5元、10元、20元、50元、100元的纸币分别有c0, c1, c2, c3, c4, c5张。
 * 现在要用这些钱来支付K元，至少要用多少张纸币？用贪心算法的思想。每一次都取尽可能币值大的纸币
 * @Date 2018/8/25 9:41
 */
public class GiveChange {
    public int giveChange(int money) {
        // 该数组为不同种类币值
        int[] value = { 1, 5, 10, 20, 50, 100};
        // 各个币种拥有个数
        int[] count = { 3, 2, 1, 0, 3, 5};
        int N = 6;
        int result = 0;
        for (int i = N - 1; i >= 0; i--) {
            int num = Math.min((money / value[i]), count[i]);
            money = money - value[i] * num;
            if (num > 0) {
                // 可以把值打印下
                System.out.println(num + "张" + value[i] + "元");
                result += num;
            }
        }
        if (money > 0) {
            return -1;
        }
        return result;
    }
}
