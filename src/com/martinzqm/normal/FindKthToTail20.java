package com.martinzqm.normal;

import com.martinzqm.entity.ListNode;

/**
 * @Author miao
 * @Description: 输入一个链表，输出该链表中倒数第k个结点。
 * @Date 2018/8/24 9:37
 */
public class FindKthToTail20 {
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode phead1 = head;
        ListNode phead2 = head;
        // 计数
        ListNode pcount = head;
        if (head == null) {
            return null;
        }
        int count = 0;
        while (pcount != null) {
            ++count;
            pcount = pcount.next;
        }
        if (k > count) {
            return null;
        }
        for (int i = 1; i <= k; ++i) {
            phead2 = phead2.next;
        }
        while (phead2 != null) {
            phead1 = phead1.next;
            phead2 = phead2.next;
        }
        return phead1;
    }
}
