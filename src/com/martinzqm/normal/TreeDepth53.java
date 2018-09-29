package com.martinzqm.normal;

import com.martinzqm.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author miao
 * @Description: 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 非递归：可以按层次遍历
 * @Date 2018/8/31 18:07
 */
public class TreeDepth53 {
    // 递归
    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        return left > right ? left+1 : right+1;
    }

    // 非递归
    public int treeDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int length = queue.size();
            ++level;
            while (length > 0) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                --length;
            }
        }
        return level;
    }
}