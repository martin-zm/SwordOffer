package com.martinzqm.normal;

import com.martinzqm.entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author miao
 * @Description:
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @Date 2018/8/21 10:30
 */
public class ReConstructBinaryTree5 {
    public TreeNode solution(int [] pre, int [] in) {
        if (pre == null || in == null) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; ++i) {
            map.put(in[i], i);
        }

        return helpConstruct(pre, 0, pre.length, in, 0, in.length, map);
    }

    public TreeNode helpConstruct(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        // 定位中序遍历中节点分界点的位置
        int index = map.get(pre[preStart]);
        root.left = helpConstruct(pre, preStart + 1, preStart + index - inStart, in, inStart, index -1, map);
        root.right = helpConstruct(pre, preStart + index - inStart + 1, preEnd, in, index + 1, inEnd, map);
        return root;
    }
}
