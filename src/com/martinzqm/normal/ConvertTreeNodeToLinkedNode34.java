package com.martinzqm.normal;

import com.martinzqm.entity.TreeNode;

/**
 * @Author miao
 * @Description: 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @Date 2018/8/27 14:33
 */
public class ConvertTreeNodeToLinkedNode34 {
    // 头指针
    TreeNode leftHead = null;
    // 尾指针
    TreeNode rightHead = null;
    public TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        convert(pRootOfTree.left);
        if (rightHead == null) {
            leftHead = rightHead = pRootOfTree;
        } else {
            rightHead.right = pRootOfTree;
            pRootOfTree.left = rightHead;
            rightHead = pRootOfTree;
        }
        convert(pRootOfTree.right);
        return leftHead;
    }
}