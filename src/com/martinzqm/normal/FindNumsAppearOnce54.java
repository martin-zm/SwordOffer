package com.martinzqm.normal;

/**
 * @Author miao
 * @Description: 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。
 * 请写程序找出这两个只出现一次的数字。
 * @Date 2018/8/31 18:22
 */
public class FindNumsAppearOnce54 {
    // num1,num2分别为长度为1的数组。传出参数
    // 将num1, num2设置为返回结果
    public static void FindNumsAppearOnce(int [] array, int[] num1 , int[] num2) {
        if (array == null || array.length < 2) {
            return;
        }
        int result = 0;
        for (int i = 0; i < array.length; ++i) {
            result ^= array[i];
        }
        int indexOfFirstOne = findFirstOneIndex(result);

        // 通过某一位是否为1将数组分割成为两个部分
        for(int j = 0; j < array.length; ++j) {
            if (isIndexOfOne(array[j], indexOfFirstOne)) {
                num1[0] ^= array[j];
            } else {
                num2[0] ^= array[j];
            }
        }
    }

    // 找到数字对应的二进制数中第一个1的位置
    public static int findFirstOneIndex(int result) {
        int index = 1;
        while ((result & 1) == 0) {
            result = result >> 1;
            ++index;
        }
        return index;
    }

    // 二进制数中某一位是否为1
    public static boolean isIndexOfOne(int num, int index) {
        while (index > 1) {
            num = num >> 1;
            --index;
        }
        return (num & 1) == 1;
    }

    public static void main(String[] args) {
        int[] array = {2,4,3,6,3,2,5,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce(array, num1, num2);
        System.out.println(num1[0] + " ," + num2[0]);
    }
}