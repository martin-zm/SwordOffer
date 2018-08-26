package com.martinzqm.normal;

import com.martinzqm.entity.ListNode;

/**
 * @Author miao
 * @Description: 输入一个链表，反转链表后，输出新链表的表头。
 * @Date 2018/8/25 19:36
 */
public class ReverseList22 {
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
