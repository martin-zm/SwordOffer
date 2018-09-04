package com.martinzqm.normal;

import com.martinzqm.entity.ListNode;

/**
 * @Author miao
 * @Description: 删除链表节点
 * @Date 2018/8/24 8:53
 */
public class DeleteListNode16 {
    // 删除链表节点，在O(1)时间复杂度
    public void deleteNode(ListNode head, ListNode toBeDeleted) {
        if (head == null || toBeDeleted == null) {
            return;
        }
        // 要删除的节点不是尾节点
        if (toBeDeleted.next != null) {
            toBeDeleted.val = toBeDeleted.next.val;
            toBeDeleted.next = toBeDeleted.next.next;
        }
        // 是头节点同时也是尾节点
        else if (head == toBeDeleted) {
            head = null;
            toBeDeleted = null;
        }
        // 有多个节点，需要删除尾节点
        else {
            while (head.next != toBeDeleted) {
                head = head.next;
            }
            head.next = null;
        }
    }

    // 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
    // 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
    public ListNode deleteDuplication(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            // 判断当前节点是否和下一个节点相等
            if (cur.next != null && cur.val == cur.next.val) {
                int value = cur.val;
                // 连续判断节点相等，直到遇到一个不相等节点
                while (cur.next != null && cur.next.val == value) {
                    cur = cur.next;
                }
                // 头节点是要删除的节点
                if (pre == null) {
                    head = cur.next;
                } else {
                    pre.next = cur.next;
                }
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}