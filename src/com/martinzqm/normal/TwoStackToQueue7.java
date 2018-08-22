package com.martinzqm.normal;

import java.util.Stack;

/**
 * @Author miao
 * @Description: 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @Date 2018/8/22 7:20
 */
public class TwoStackToQueue7 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push (int val) {
        stack1.push(val);
    }

    // 注意：当stack2为空时候，一定要将stack1中的数据全部转移到stack2中
    public int pop () {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
