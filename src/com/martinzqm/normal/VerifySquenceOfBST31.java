package com.martinzqm.normal;

/**
 * @Author miao
 * @Description: 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * @Date 2018/8/27 11:01
 */
public class VerifySquenceOfBST31 {
    public boolean verifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        return verifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    public boolean verifySquenceOfBST(int [] sequence, int start, int root) {
        if (start >= root) {
            return true;
        }
        int i = start;
        for (; i < root; ++i) {
            if (sequence[i] > sequence[root]) {
                break;
            }
        }
        int j = i;
        for (; j < root; ++j) {
            if (sequence[j] < sequence[root]) {
                return false;
            }
        }
        return verifySquenceOfBST(sequence, start, i - 1) && verifySquenceOfBST(sequence, i, root - 1);
    }
}
