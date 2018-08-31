package com.martinzqm.normal;

import java.util.ArrayList;

/**
 * @Author miao
 * @Description: 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * @Date 2018/8/31 18:43
 */
public class FindNumbersWithSum55 {
    public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] + array[right] == sum) {
                list.add(array[left]);
                list.add(array[right]);
                return list;
            } else if (array[left] + array[right] < sum) {
                ++left;
            } else {
                --right;
            }
        }
        return list;
    }

    /** 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
        但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
        没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
        现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int left = 1;
        int right = 2;
        while (left < right) {
            int curSum = (left + right) * (right - left + 1) / 2;
            if (curSum == sum) {
                result.add(sequenceList(left, right));
                ++right;
            } else if (curSum < sum) {
                ++right;
            } else {
                ++left;
            }
        }
        return result;
    }

    public ArrayList<Integer> sequenceList(int left, int right) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = left; i <= right; ++i) {
            list.add(i);
        }
        return list;
    }
}