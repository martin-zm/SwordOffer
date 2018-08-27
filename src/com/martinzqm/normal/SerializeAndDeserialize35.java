package com.martinzqm.normal;

import com.martinzqm.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author miao
 * @Description: 请实现两个函数，分别用来序列化和反序列化二叉树
 * # 代表null   ! 代表节点间隔符
 * @Date 2018/8/27 14:50
 */
public class SerializeAndDeserialize35 {
    // 序列化（前序遍历）
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        StringBuilder sb = new StringBuilder(root.val + "!");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }
    // 反序列化（前序遍历）
    public TreeNode deserialize(String str) {
        String[] strs = str.split("!");
        // 将数据依次插入到队列中
        Queue<String> queue = new LinkedList<String>();
        for (String s : strs) {
            queue.add(s);
        }
        return preOrder(queue);
    }

    // 前序遍历构造二叉树
    public TreeNode preOrder(Queue<String> queue) {
        String var = queue.poll();
        if ("#".equals(var)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(var));
        root.left = preOrder(queue);
        root.right = preOrder(queue);
        return root;
    }
}