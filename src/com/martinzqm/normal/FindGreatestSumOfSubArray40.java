package com.martinzqm.normal;

/**
 * @Author miao
 * @Description: HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 *
 * 思路：依次累加，如果当前和小于等于0，则重新开始计算。
 * 表明从第一个数字开始的数组会小于，从新的数字开始的数组和。
 * @Date 2018/8/28 10:33
 */
public class FindGreatestSumOfSubArray40 {
    public int findGreatestSumOfSubArray(int[] array) {
        int cursum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; ++i) {
            if (cursum <= 0) {
                cursum = array[i];
            } else {
                cursum += array[i];
            }
            if (cursum > max) {
                max = array[i];
            }
        }
        return max;
    }
}