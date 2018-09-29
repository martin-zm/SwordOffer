package com.martinzqm.normal;

import com.martinzqm.entity.RandomListNode;

/**
 * @Author miao
 * @Description: 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * @Date 2018/8/27 13:33
 */
public class CloneComplexLinkedList33 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode oldIndex = pHead;
        RandomListNode newIndex = null;
        RandomListNode temp = null;
        RandomListNode result = null;

        // 第一步，复制链表节点放置到每个节点后面
        while (oldIndex != null) {
            temp = oldIndex.next;
            RandomListNode newNode = new RandomListNode(oldIndex.val);
            newNode.next = temp;
            oldIndex.next = newNode;
            if (result == null) {
                result = newNode;
            }
            oldIndex = temp;
        }

        // 第二步，根据原节点的random指针，给新节点的random赋值
        oldIndex = pHead;
        while (oldIndex != null) {
            if (oldIndex.random != null) {
                oldIndex.next.random = oldIndex.random.next;
            }
            oldIndex = oldIndex.next.next;
        }

        // 第三步，将新节点从原始链表中分离出来
        oldIndex = pHead;
        newIndex = result;
        while (newIndex != null) {
            oldIndex.next = newIndex.next;
            oldIndex = newIndex.next;
            newIndex.next = oldIndex.next;
            newIndex = oldIndex.next;
        }
        return result;
    }
}