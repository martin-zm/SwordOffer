package com.martinzqm.normal;

import com.martinzqm.entity.ListNode;

import java.util.ArrayList;

/**
 * @Author miao
 * @Description:
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * 思路：
 * 1、链表反转再遍历
 * 2、用栈实现
 * @Date 2018/8/21 10:18
 */
public class PrintListFromTailToHead4 {
    public ArrayList<Integer> solution(ListNode head) {
        ArrayList<Integer> result = new ArrayList<>();
        ListNode pre = null;
        ListNode cur = head;
        // 链表反转
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        while (pre != null) {
            result.add(pre.val);
            pre = pre.next;
        }
        return result;
    }
}