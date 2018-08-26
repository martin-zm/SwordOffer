package com.martinzqm.algorithm.Greedy;

/**
 * @Author miao
 * @Description:
 * 题目：在一条环路上有 N 个加油站，其中第 i 个加油站有汽油gas[i]，并且
 * 从第_i_个加油站前往第_i_+1个加油站需要消耗汽油cost[i]。
 * 你有一辆油箱容量无限大的汽车，现在要从某一个加油站出发绕环路一周，一开始油箱为空。
 * 求可环绕环路一周时出发的加油站的编号，若不存在环绕一周的方案，则返回-1。
 *
 * 样例：
 * 现在有4个加油站，汽油量gas[i]=[1, 1, 3, 1]，环路旅行时消耗的汽油量cost[i]=[2, 2, 1, 1]。则出发的加油站的编号为2。 *
 * 挑战
 * O(n)时间  和  O(1)额外空间
 * @Date 2018/8/26 8:54
 */
public class GasStation {
    // 解析：将序列连续相加，如果小于0了，就丢弃重新开始，total>0 是判断是否可行的唯一标准
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int cur = 0;
        int total = 0;
        int start = 0;
        for (int i = 0; i < gas.length; ++i) {
            cur += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (cur < 0) {
                cur = 0;
                start = i + 1;
            }
        }
        if (total >= 0) {
            return start;
        } else {
            return -1;
        }
    }
}
