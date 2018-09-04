package com.martinzqm.normal;

/**
 * @Author miao
 * @Description: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 利用插入排序思想
 * @Date 2018/8/24 9:49
 */
public class OddAheadEven19 {
    public void reOrderArray(int [] array) {
        int length = array.length;
        int j = 0;
        for (int i = 1; i < length; ++i) {
            if ((array[i] & 0x01) == 1) {
                int temp = array[i];
                for (j = i - 1; j >= 0 && ((array[j] & 0x01) == 0); --j) {
                    array[j + 1] = array[j];
                }
                array[j + 1] = temp;
            }
        }
    }
}