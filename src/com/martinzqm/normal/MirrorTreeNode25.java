package com.martinzqm.normal;

import com.martinzqm.entity.TreeNode;

/**
 * @Author miao
 * @Description: 操作给定的二叉树，将其变换为源二叉树的镜像。
 * @Date 2018/8/25 20:56
 */
public class MirrorTreeNode25 {
    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        TreeNode temp = null;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) {
            mirror(root.left);
        }
        if (root.right != null) {
            mirror(root.right);
        }
    }
}