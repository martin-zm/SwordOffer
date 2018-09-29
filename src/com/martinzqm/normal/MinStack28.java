package com.martinzqm.normal;

import java.util.Stack;

/**
 * @Author miao
 * @Description: 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * @Date 2018/8/26 12:12
 */
public class MinStack28 {
    private Stack<Integer> stack1 = new Stack<>();
    /**
     * 存放栈中曾经出现过的最小值
     */
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int val) {
        stack1.push(val);
        if (stack2.isEmpty() || val <= stack2.peek()) {
            stack2.push(val);
        }
    }
    public void pop() {
        if (stack1.pop() == stack2.peek()) {
            stack2.pop();
        }
    }
    public int top() {
        return stack1.peek();
    }
    public int min() {
        return stack2.peek();
    }
}