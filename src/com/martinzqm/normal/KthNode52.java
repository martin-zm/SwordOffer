package com.martinzqm.normal;

import com.martinzqm.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author miao
 * @Description: 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * 解析： 中序遍历二叉树，得到的是排序数，直接取出来就可以了
 * @Date 2018/8/31 17:09
 */
public class KthNode52 {
    public TreeNode kthNode(TreeNode root, int k) {
        if (root == null) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        inOrder(root, list);
        if (list.size() < k) {
            return null;
        }
        return list.get(k - 1);
    }

    // 递归
    public void inOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }

    // 非递归
    public void inOrder2(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            curNode = stack.pop();
            list.add(curNode);
            curNode = curNode.right;
        }
    }
}
