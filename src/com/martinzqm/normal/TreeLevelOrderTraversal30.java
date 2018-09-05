package com.martinzqm.normal;

import com.martinzqm.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author miao
 * @Description:
 * @Date 2018/8/26 12:40
 */
public class TreeLevelOrderTraversal30 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode temp = queue.pop();
            result.add(temp.val);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        return result;
    }
}