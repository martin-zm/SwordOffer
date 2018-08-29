package com.martinzqm.normal;

/**
 * @Author miao
 * @Description: 数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从0开始计数）是5，第13位是1，第19位是4，等等。
 * 请写一个函数求任意位对应的数字。
 * 解析：https://blog.csdn.net/m0_37862405/article/details/80341260
 * @Date 2018/8/29 9:45
 */
public class DigitsInSequence42 {
    public static int digitAtIndex(int index) {
        if (index < 0) {
            return -1;
        }
        // 当前位数，初始化为1表示个位数
        int digits = 1;
        while (true) {
            // 计算当前位数的数值个数，比如个位数有10个，十位数有90个，百位数有900个
            int digitNumbers = countOfNumbersFor(digits);
            // 计算当前位数总共有多少数字
            int countOfNumbers = digitNumbers * digits;
            if (index < countOfNumbers) {
                return digitAtIndex(index, digits);
            } else {
                // 在下一位中查找
                index -= countOfNumbers;
                ++digits;
            }
        }
    }

    public static int countOfNumbersFor(int digits) {
        if (digits == 1) {
            return 10;
        }
        int nums = (int) Math.pow(10, digits - 1);
        return nums * 9;
    }

    public static int digitAtIndex(int index, int digits) {
        // 找到具体数字
        int num = beginNumFor(digits) + index / digits;
        // 从右找到对应数字的位置
        int indexFromRight = digits - index % digits;
        // 去掉右边indexFromRight - 1个数字
        for (int i = 1; i < indexFromRight; ++i) {
            num /= 10;
        }
        // 求具体数字
        return num % 10;
    }

    // 找到对应位的开始数字
    public static int beginNumFor(int digits) {
        if (digits == 1) {
            return 0;
        }
        return (int) Math.pow(10, digits - 1);
    }
}
