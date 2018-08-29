package com.martinzqm.normal;

import com.martinzqm.entity.ListNode;

/**
 * @Author miao
 * @Description: 输入两个链表，找出它们的第一个公共结点
 * @Date 2018/8/28 16:25
 */
public class FindFirstCommonNode50 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int length1 = getListLength(pHead1);
        int length2 = getListLength(pHead2);
        int diffLength = Math.abs(length1 - length2);
        ListNode longHead = pHead1;
        ListNode shortHead = pHead2;
        if (length1 < length2) {
            longHead = pHead2;
            shortHead = pHead1;
        }
        for (int i = 1; i < diffLength; ++i) {
            longHead = longHead.next;
        }
        while (longHead != null && shortHead != null && longHead.val != shortHead.val) {
            longHead = longHead.next;
            shortHead = shortHead.next;
        }
        return shortHead;
    }

    public int getListLength(ListNode pHead) {
        int count = 0;
        while (pHead != null) {
            ++count;
            pHead = pHead.next;
        }
        return count;
    }
}
