package com.martinzqm.multiPointersSolution;

/**
 * @author zhangmiao3
 * @Description: 逆序对
 * 在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。给你一个数组，求出这个数组中逆序对的总数。
 * 概括：如果a[i] > a[j] 且 i < j， a[i] 和 a[j] 构成一个逆序对。
 *
 * 样例
 * 序列 [2, 4, 1, 3, 5] 中，有 3 个逆序对 (2, 1), (4, 1), (4, 3)，则返回 3。
 * @date 9:13 2018/6/8
 */
public class ReversePairs {
    /*
    // 通用解法
    public long reversePairs(int[] A) {
        long count = 0;
        int length = A.length;
        if (length == 1) {
            return count;
        }
        for (int i = 0; i < length - 1; ++i) {
            for (int j = i + 1; j < length; ++j) {
                if (A[i] > A[j]) {
                    ++count;
                }
            }
        }
        return count;
    }
    */
    // 利用归并排序思想
    public long reversePairs(int[] A) {
        if (A == null || A.length == 0)    {
            return 0;
        }
        int length = A.length;
        int[] copyArray = new int[length];
        for (int i = 0; i < length; ++i) {
            copyArray[i] = A[i];
        }
        return reversePairsCore(A, copyArray, 0, length - 1);
    }

    public long reversePairsCore(int[] A, int[] copyArray, int start, int end) {
        if (start == end) {
            return 0;
        }
        int half = (end - start) / 2;
        //注意Array和A的顺序调换了
        long left = reversePairsCore(copyArray, A, start, start + half);
        long right = reversePairsCore(copyArray, A, start + half + 1, end);
        int i = start + half;
        int j = end;
        int copyIndex = end;
        long count = 0;
        while (i >= start && j >= start + half + 1) {
            if (A[i] > A[j]) {
                copyArray[copyIndex--] = A[i--];
                count += j - (start + half);
            } else {
                copyArray[copyIndex--] = A[j--];
            }
        }
        while (i >= start) {
            copyArray[copyIndex--] = A[i--];
        }

        while (j >= start + half + 1) {
            copyArray[copyIndex--] = A[j--];
        }

        return count + left + right;
    }
}
