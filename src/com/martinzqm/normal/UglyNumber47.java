package com.martinzqm.normal;

/**
 * @Author miao
 * @Description: 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * @Date 2018/8/31 15:16
 */
public class UglyNumber47 {
    public static int getNUglyNumber(int index) {
        if (index <= 0) {
            return 0;
        }
        // 初始化丑数数组
        int[] uglyArray = new int[index];
        uglyArray[0] = 1;

        int indexOfNextUgly = 1;

        int indexOfMultiply2 = 0;
        int indexOfMultiply3 = 0;
        int indexOfMultiply5 = 0;

        while (indexOfNextUgly < index) {
            int min = min(uglyArray[indexOfMultiply2] * 2, uglyArray[indexOfMultiply3] * 3, uglyArray[indexOfMultiply5] * 5);
            uglyArray[indexOfNextUgly] = min;
            while (uglyArray[indexOfMultiply2] * 2 <= min) {
                ++indexOfMultiply2;
            }
            while (uglyArray[indexOfMultiply3] * 3 <= min) {
                ++indexOfMultiply3;
            }
            while (uglyArray[indexOfMultiply5] * 5 <= min) {
                ++indexOfMultiply5;
            }
            ++indexOfNextUgly;
        }
        return uglyArray[index - 1];
    }

    public static int min(int a, int b, int c) {
        int minTemp = a < b ? a : b;
        return minTemp < c ? minTemp : c;
    }

    public static void main(String[] args) {
        System.out.println(getNUglyNumber(20));
    }
}
