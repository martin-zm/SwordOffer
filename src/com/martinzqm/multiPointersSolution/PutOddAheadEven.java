package com.martinzqm.multiPointersSolution;

/**
 * @author zhangmiao3
 * @Description: 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @date 10:00 2018/6/5
 */
public class PutOddAheadEven {
    //利用额外空间
    /*
    public void reOrderArray(int [] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int length = array.length;
        int[] arrayTemp = new int[length];
        for (int i = 0; i < length; i++) {
            arrayTemp[i] = array[i];
        }

        int j = 0;
        for (int i = 0; i < length && j < length; i++) {
            if ((arrayTemp[i] & 0x01) == 1) {
                array[j++] = arrayTemp[i];
            }
        }

        for (int i = 0; i < length && j < length; i++) {
            if ((arrayTemp[i] & 0x01) == 0) {
                array[j++] = arrayTemp[i];
            }
        }
    }
    */


    //利用插入排序的思想
    public void reOrderArray(int [] array) {
        int length = array.length;
        int j = 0;
        for (int i = 1; i < length; i++) {
            if ((array[i] & 0x01) == 1) {
                int temp = array[i];
                for (j = i - 1; j >= 0 && (array[j] & 0x01) == 0; j--) {
                    array[j+1] = array[j];
                }
                array[j+1] = temp;
            }
        }
    }

    /*
    //双指针思想(无法保证顺序)
    public void reOrderArray(int [] array) {
        int length = array.length;
        //定义两个指针
        int p = -1;
        int q = length;
        while (p < q) {
            while (p < q && isOdd(array[++p]));
            while (p < q && !isOdd(array[--q]));
            swap(array, p, q);
        }
    }

    public boolean isOdd(int num) {
        if (num % 2 == 0) {
            return false;
        }
        return true;
    }

    public void swap(int [] array, int p, int q) {
        int temp = 0;
        temp = array[p];
        array[p] = array[q];
        array[q] = temp;
    }
    */
}
