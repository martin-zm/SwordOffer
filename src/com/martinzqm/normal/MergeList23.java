package com.martinzqm.normal;

import com.martinzqm.entity.ListNode;

/**
 * @Author miao
 * @Description: 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @Date 2018/8/25 19:45
 */
public class MergeList23 {
    // 递归解法
    public ListNode mergeListNoRecursion(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode mergeHead;
        if (list1.val < list2.val) {
            mergeHead = list1;
            mergeHead.next = mergeListNoRecursion(list1.next, list2);
        } else {
            mergeHead = list2;
            mergeHead.next = mergeListNoRecursion(list1, list2.next);
        }
        return mergeHead;
    }

    // 非递归解法
    public ListNode mergeListRecursion(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode head = new ListNode(0);
        ListNode pre = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                head.next = list1;
                head = head.next;
                list1 = list1.next;
            } else {
                head.next = list2;
                head = head.next;
                list2 = list2.next;
            }
        }
        while (list1 != null) {
            head.next = list1;
            head = head.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            head.next = list2;
            head = head.next;
            list2 = list2.next;
        }
        return pre.next;
    }
}