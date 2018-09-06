package com.martinzqm.normal;

import com.martinzqm.entity.TreeNode;

import java.util.ArrayList;

/**
 * @Author miao
 * @Description: 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 * @Date 2018/8/27 13:10
 */
public class FindPathInTree32 {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        if (root != null) {
            int curSum = 0;
            ArrayList<Integer> list = new ArrayList<>();
            result = findPath(root, curSum, list, target);
        }
        return result;
    }

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int curSum, ArrayList<Integer> list, int target) {
        curSum += root.val;
        list.add(root.val);
        boolean isLeaf = (root.left == null) && (root.right == null);
        if (isLeaf && curSum == target) {
            result.add(list);
        }
        if (root.left != null) {
            findPath(root.left, curSum, list, target);
        }
        if (root.right != null) {
            findPath(root.right, curSum, list, target);
        }
        // 都会有的一个回退操作
        list.remove(list.size() - 1);
        return result;
    }
}