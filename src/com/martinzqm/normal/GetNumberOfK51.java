package com.martinzqm.normal;

/**
 * @Author miao
 * @Description: 统计一个数字在排序数组中出现的次数。
 * @Date 2018/8/31 16:48
 */
public class GetNumberOfK51 {
    public static int getNumberOfK(int[] array, int k) {
        int count = 0;
        if (array != null && array.length != 0) {
            int firstIndex = getFirstKIndex(array, 0, array.length - 1, k);
            int lastIndex = getLastKIndex(array, 0, array.length - 1, k);
            count = lastIndex - firstIndex + 1;
        }
        return count;
    }

    public static int getFirstKIndex(int[] array, int start, int end, int k) {
        if (start > end) {
            return -1;
        }
        int midIndex = (start + end) / 2;
        int midNum = array[midIndex];
        if (k == midNum) {
            if ((midIndex > 0 && array[midIndex - 1] != k) || midIndex == 0) {
                return midIndex;
            } else {
                end = midIndex - 1;
            }
        } else if (k < midNum) {
            end = midIndex - 1;
        } else {
            start = midIndex + 1;
        }
        return getFirstKIndex(array, start, end, k);
    }

    public static int getLastKIndex(int[] array, int start, int end, int k) {
        if (start > end) {
            return -1;
        }
        int midIndex = (start + end) / 2;
        int midNum = array[midIndex];
        if (k == midNum) {
            if ((midIndex < array.length - 1 && array[midIndex + 1] != k)
                    || midIndex == array.length - 1) {
                return midIndex;
            } else {
                start = midIndex + 1;
            }
        } else if (k < midNum) {
            end = midIndex - 1;
        } else {
            start = midIndex + 1;
        }
        return getLastKIndex(array, start, end, k);
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,3,3,4,4,4,5,6};
        System.out.println(getNumberOfK(array, 7));
    }
}