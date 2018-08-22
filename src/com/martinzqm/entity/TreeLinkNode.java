package com.martinzqm.entity;

/**
 * @Author miao
 * @Description: 带父指针的二叉树节点
 * @Date 2018/8/22 7:01
 */
public class TreeLinkNode {
    public int val;
    public  TreeLinkNode left = null;
    public TreeLinkNode right = null;
    public TreeLinkNode next = null;

    public TreeLinkNode(int val) {
        this.val = val;
    }
}
