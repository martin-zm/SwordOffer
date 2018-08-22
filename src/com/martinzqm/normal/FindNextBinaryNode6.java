package com.martinzqm.normal;

import com.martinzqm.entity.TreeLinkNode;

/**
 * @Author miao
 * @Description:
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * @Date 2018/8/22 7:00
 */
public class FindNextBinaryNode6 {
    public TreeLinkNode solution(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        TreeLinkNode next = null;
        // 如果当前节点有右节点，遍历到该右节点的最左边节点
        if (pNode.right != null) {
            TreeLinkNode right = pNode.right;
            while (right.left != null) {
                right = right.left;
            }
            next = right;
            // 如果当前节点没有右节点，向上遍历找到一个节点是其父节点左节点的节点即可
        } else {
            TreeLinkNode cur = pNode;
            TreeLinkNode parent = pNode.next;
            while (parent != null && cur == parent.right) {
                cur = parent;
                parent = parent.next;
            }
            next = parent;
        }
        return next;
    }
}
