package com.martinzqm.multiPointersSolution;

/**
 * @author zhangmiao3
 * @Description: 4. 丑数 II
 * 设计一个算法，找出只含素因子2，3，5 的第 n 小的数。 *
 * 符合条件的数如：1, 2, 3, 4, 5, 6, 8, 9, 10, 12... *
 *
 * 样例
 * 如果n = 9， 返回 10
 *
 * 挑战
 * 要求时间复杂度为O(nlogn)或者O(n)
 * @date 9:20 2018/6/6
 */
public class UglyNumber {
    /*
    //通用做法超时
    public int nthUglyNumber(int n) {
        int foundCount = 0;
        int num = 1;
        while (true) {
            if (isUglyNumber(num)) {
                ++foundCount;
            }
            if (foundCount == n) {
                break;
            }
            ++num;
        }
        return num;
    }

    public boolean isUglyNumber(int num) {
        if (num == 0) {
            return false;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1 ? true : false;
    }
    */
    //利用三个指针来操作
    public int nthUglyNumber(int n) {
        int[] uglyNumber = new int[n];
        uglyNumber[0] = 1;
        int nextIndext = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        while (nextIndext < n) {
            int min = minInThreeNumbers(uglyNumber[p2] * 2, uglyNumber[p3] * 3, uglyNumber[p5] * 5);
            uglyNumber[nextIndext] = min;
            while (uglyNumber[p2] * 2 <= min) {
                ++p2;
            }
            while (uglyNumber[p3] * 3 <= min) {
                ++p3;
            }
            while (uglyNumber[p5] * 5 <= min) {
                ++p5;
            }
            ++nextIndext;
        }
        return uglyNumber[n - 1];
    }

    public int minInThreeNumbers(int a, int b, int c) {
        int temp = a < b ? a : b;
        return c < temp ? c : temp;
    }
}
