package com.martinzqm.swordOffer.multiPointersSolution;

import java.util.ArrayList;

/**
 * @author zhangmiao3
 * @Description:
 * 输入一个正数 s，打印出所有和为 s 的连续正数序列（至少两个数）。
 * 例如输入 15，由于 1+2+3+4+5 = 4+5+6 ＝ 7+8 = 15，
 * 所以结果打出 3 个连续序列 1～5、4～6 和 7～8。
 * @date 10:24 2018/6/10
 */
public class ContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int left = 1;
        int right = 2;
        while (left < right) {
            //求和通式
            int curSum = (left + right) * (right - left + 1) / 2;
            if (curSum < sum) {
                ++right;
            } else if (curSum > sum) {
                ++left;
            } else {
                result.add(continuousNum(left, right));
                ++right;
            }
        }
        return result;
    }

    //返回left到right之间的连续整数
    public ArrayList<Integer> continuousNum(int left, int right) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; ++i) {
            result.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        ContinuousSequence continuousSequence = new ContinuousSequence();
        ArrayList<ArrayList<Integer>> arrayLists = continuousSequence.FindContinuousSequence(100);
        for (ArrayList<Integer> list : arrayLists) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
