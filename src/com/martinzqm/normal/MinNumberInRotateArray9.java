package com.martinzqm.normal;

/**
 * @Author miao
 * @Description: 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @Date 2018/8/22 7:47
 */
public class MinNumberInRotateArray9 {
    public int solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int index1 = 0;
        int index2 = array.length - 1;
        int midIndex = index1;

        while (array[index1] >= array[index2]) {
            if (index2 - index1 == 1) {
                midIndex = index2;
                break;
            }
            midIndex = (index1 + index2) / 2;
            if (array[index1] == array[index2] && array[index1] == array[midIndex]) {
                return minInOrder(array, index1, index2);
            }
            if (array[midIndex] >= array[index1]) {
                index1 = midIndex;
            }
            if (array[midIndex] <= array[index2]) {
                index2 = midIndex;
            }
        }
        return array[midIndex];

    }

    public int minInOrder(int[] array, int index1, int index2) {
        int min = array[index1];
        for (int i = index1 + 1; i <= index2; ++i) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}

