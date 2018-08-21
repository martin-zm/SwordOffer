package com.martinzqm.swordOffer.multiPointersSolution;

import java.util.ArrayList;

/**
 * @author zhangmiao3
 * @Description: 题目描述:
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 * @date 10:12 2018/6/10
 */
public class TwoSum {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        //定义两个指针，利用数组有序的特点
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] + array[right] == sum) {
                list.add(array[left]);
                list.add(array[right]);
                break;
            } else if (sum < array[left] + array[right]) {
                --right;
            } else {
                ++left;
            }
        }
        return list;
    }
}
