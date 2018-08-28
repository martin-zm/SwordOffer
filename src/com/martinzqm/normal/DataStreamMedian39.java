package com.martinzqm.normal;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author miao
 * @Description: 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 *
 * 思路：使用一个大顶堆和一个小顶堆。
 * 当下标是偶数时候，存放在小顶堆中。
 * 当下标是奇数时候，存放在大顶堆中。
 * 同时保证小顶堆的堆顶最小值大于大顶堆的堆顶最大值
 *
 * @Date 2018/8/28 10:09
 */
public class DataStreamMedian39 {
    int count = 0;
    // 定义大顶堆
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    // 定义小顶堆
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public void insert(int num) {
        ++count;
        // 如果是偶数下标
        if ((count & 1) == 0) {
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            minHeap.offer(num);
        } else {
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }

    public double getMedian() {
        if (count == 0) {
            throw new RuntimeException("no available number!");
        }
        double result;
        if ((count & 1) == 0) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}