package com.martinzqm.entity;

/**
 * @Author miao
 * @Description: 增加随机指针的链表节点
 * @Date 2018/8/27 13:34
 */
public class RandomListNode {
    public int val;
    public RandomListNode next = null;
    public RandomListNode random = null;

    public RandomListNode(int val) {
        this.val = val;
    }
}
