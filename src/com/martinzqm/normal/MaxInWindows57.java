package com.martinzqm.normal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @Author miao
 * @Description: 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 *
 * {[2,3,4],2,6,2,5,1}，
 * {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}，
 * {2,3,4,2,6,[2,5,1]}。
 *
 * 思路：利用双端队列来维护
 * 保证队列队头是窗口的最大值，同时过期的值出队。
 * @Date 2018/8/31 19:43
 */
public class MaxInWindows57 {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || size <= 0) {
            return result;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < num.length; ++i) {
            if (deque.isEmpty() || num[i] < deque.peekLast()) {
                deque.offerLast(i);
            } else {
                // 保证队头数据最大
                while (!deque.isEmpty() && num[i] >= deque.peekLast()) {
                    deque.pollLast();
                }
                deque.offerLast(i);
            }
            // 过期下标出队
            while (i - deque.peekFirst() >= size) {
                deque.pollFirst();
            }
            if (i >= size - 1) {
                result.add(num[deque.peekFirst()]);
            }
        }
        return result;
    }
}