package com.martinzqm.normal;

/**
 * @Author miao
 * @Description: 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 * @Date 2018/8/31 16:06
 */
public class InversePairs49 {
    public int inversePairs(int [] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int length = A.length;
        int[] copy = new int[length];
        for (int i = 0; i < length; ++i) {
            copy[i] = A[i];
        }
        int count = inversePairsCore(A, copy, 0, length-1);
        return count;
    }

    public int inversePairsCore(int[] A, int[] copy, int start, int end) {
        if (start == end) {
            return 0;
        }
        int halfLength = (end - start) / 2;
        int left = inversePairsCore(copy, A, start, start + halfLength);
        int right = inversePairsCore(copy, A, start + halfLength + 1, end);
        int i = start + halfLength;
        int j = end;
        int indexCopy = end;
        int count = 0;
        while (i >= start && j >= start + halfLength + 1) {
            if (A[i] > A[j]) {
                copy[indexCopy--] = A[i-1];
                count += j - (start + halfLength);
                if (count > 1000000007) {
                    count %= 1000000007;
                }
            } else {
                copy[indexCopy--] = A[j--];
            }
        }
        for (; i >= start; --i) {
            copy[indexCopy--] = A[i--];
        }
        for (; j >= start + halfLength + 1; --j) {
            copy[indexCopy--] = A[j--];
        }
        return (left + right + count) % 1000000007;
    }
}