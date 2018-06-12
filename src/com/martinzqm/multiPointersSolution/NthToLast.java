package com.martinzqm.multiPointersSolution;

/**
 * @author zhangmiao3
 * @Description: 166. 链表倒数第n个节点
 * 找到单链表倒数第n个节点，保证链表中节点的最少数量为n。
 * 样例：
 * 给出链表 3->2->1->5->null和n = 2，返回倒数第二个节点的值1.
 * @date 8:55 2018/6/6
 */
public class NthToLast {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    /*
    //普通解法，遍历两次，计算出要走的步长
    public ListNode nthToLast(ListNode head, int n) {
        // write your code here
        if (head == null || n <= 0) {
            return null;
        }
        ListNode p = head;
        int count = 0;
        while (p != null) {
            ++count;
            p = p.next;
        }
        p = head;
        int step = count - n;
        for (int i = 1; i <= step; ++i) {
            p = p.next;
        }
        return p;
    }
    */

    //双指针解法，利用错位
    public ListNode nthToLast(ListNode head, int n) {
        if (head == null || n <= 0) {
            return null;
        }
        ListNode p = head;
        ListNode q = head;
        for (int i = 1; i <= n; ++i) {
            p = p.next;
        }
        while (p != null) {
            p = p.next;
            q = q.next;
        }
        return q;
    }
}
