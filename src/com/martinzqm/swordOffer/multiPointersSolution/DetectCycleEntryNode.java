package com.martinzqm.swordOffer.multiPointersSolution;

import com.martinzqm.entity.ListNode;

/**
 * @author zhangmiao3
 * @Description:
 * 给定一个链表，如果链表中存在环，则返回到链表中环的起始节点，如果没有环，返回null。
 * 给出 -21->10->4->5, tail connects to node index 1，返回10
 * @date 11:25 2018/6/10
 */
public class DetectCycleEntryNode {

    public ListNode detectCycle(ListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        //找出碰撞处，将处于链表中LOOP_SIZE - k步的位置
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        //错误检查，没有碰撞处，也即没有环路
        if (fast == null || fast.next == null) {
            return null;
        }

        //将slow指向首部，fast指向碰撞处，两者距离环路初始位置k步，
        //若两者用相同的速度移动，则必然会在环路开始出碰撞在一起
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
