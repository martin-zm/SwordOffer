package com.martinzqm.normal;

/**
 * @Author miao
 * @Description: 假设有一个数组，它的第i个元素是一支给定的股票在第i天的价格。
 * 如果你最多只允许完成一次交易(例如,一次买卖股票),设计一个算法来找出最大利润。
 * 样例:
 * 给出一个数组样例 [3,2,3,1,2], 返回 1
 * @Date 2018/8/31 19:16
 */
public class StocksMaxProfit61  {
    public int stockMaxProfit(int[] array) {
        // 保存当天股票之前的最低值
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 1; i < array.length; ++i) {
            if (array[i-1] < min) {
                min = array[i-1];
            }
            int profit = array[i] - min;
            if(profit > max) {
                max = profit;
            }
        }
        return max;
    }
}
