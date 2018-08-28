package com.martinzqm.normal;

/**
 * @Author miao
 * @Description: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 思路：利用一个变量来计数，如果碰到相同的数据则计数加一，否则计数减一，计数为0，则重新开始计数
 * @Date 2018/8/28 9:16
 */
public class MoreThanHalfNum37 {
    public int moreThanHalfNum(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int result = array[0];
        int count = 1;
        for (int i = 0; i < array.length; ++i) {
            if (count == 0) {
                result = array[i];
                count = 1;
            }
            if (result == array[i]) {
                ++count;
            } else {
                --count;
            }
        }
        if (!checkHalf(array, result)) {
            return 0;
        } else {
            return result;
        }
    }

    public boolean checkHalf(int[] array, int result) {
        if (array == null || array.length == 0) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == result) {
                ++count;
            }
        }
        if (count > (array.length >> 1)) {
            return true;
        } else {
            return false;
        }
    }
}
