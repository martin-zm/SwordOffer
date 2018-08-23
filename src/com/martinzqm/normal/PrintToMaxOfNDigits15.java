package com.martinzqm.normal;

/**
 * @Author miao
 * @Description: 输入数字n，按顺序打印出从1到最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数即999。
 * 注意：
 * 1、要考虑大数问题，用字符串来解决
 * 2、用全排列解决
 * @Date 2018/8/23 10:03
 */
public class PrintToMaxOfNDigits15 {
    public static void main(String[] args) {
        printToMaxOfDigits(3);
    }
    // 常规思路
    public static void printToMaxOfDigits(int n) {
        if (n <= 0) {
            System.out.println("输入不符合要求");
            return;
        }
        char[] number = new char[n];
        for (int i = 0; i < n; ++i) {
            number[i] = '0';
        }
        // 未溢出
        while (!increamentNumber(number)) {
            // 打印结果
            printNumber2(number);
        }
    }

    // 递归思路，认真理解下
    public static void printToMaxOfDigitsRecursion(int n) {
        if (n <= 0) {
            System.out.println("输入不符合要求");
            return;
        }
        char[] number = new char[n];
        for (int i = 0; i < n; ++i) {
            number[i] = '0';
        }
        for (int i = 0; i < 10; ++i) {
            number[0] = (char)(i + '0');
            printToMaxOfDigitsRecursionCore(number, n, 0);
        }
    }

    public static void printToMaxOfDigitsRecursionCore(char[] number, int n, int index) {
        if (index == n - 1) {
            printNumber1(number);
        }

        for (int i = 0; i < 10; ++i) {
            number[index + 1] = (char) (i + '0');
            printToMaxOfDigitsRecursionCore(number, n, index + 1);
        }
    }

    public static boolean increamentNumber(char[] number) {
        boolean isOverFlow = false;
        int carryBit = 0;
        int length = number.length;
        for (int i = length - 1; i >= 0; --i) {
            int num = number[i] - '0' + carryBit;
            if (i == length - 1) {
                ++num;
            }
            if (num >= 10) {
                if (i == 0) {
                    isOverFlow = true;
                } else {
                    num -= 10;
                    carryBit = 1;
                    number[i] = (char)(num + '0');
                }
            } else {
                number[i] = (char)(num + '0');
                break;
            }
        }
        return isOverFlow;
    }

    public static void printNumber1(char[] number) {
        int i = 0;
        // 找到第一个不为0的位置
        while (number[i++] == '0');
        --i;
        for (; i < number.length; ++i) {
            System.out.print(number[i]);
        }
        System.out.println();
    }

    public static void printNumber2(char[] number) {
        boolean isBeginning = true;
        int length = number.length;
        for (int i = 0; i < length; ++i) {
            // 开始位置第一个不为0的位置
            if (isBeginning && number[i] != '0') {
                isBeginning = false;
            }
            if (!isBeginning) {
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }
}
