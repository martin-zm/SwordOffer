package com.martinzqm.normal;

/**
 * @Author miao
 * @Description: 给定一个数字，按照如下规则翻译成字符串：0翻译成“a”，1翻译成“b”...25翻译成“z”。
 * 一个数字有多种翻译可能，例如12258一共有5种，分别是bccfi，bwfi，bczi，mcfi，mzi。
 * 实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * 解析：https://www.jianshu.com/p/80e1841909b7
 * @Date 2018/8/29 10:53
 */
public class TranslateNumbersToStrings44 {
    public static int getTranslationCount(int number){
        if (number < 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }
        return getTranslationCount(String.valueOf(number));
    }

    public static int getTranslationCount(String number) {
        int f1 = 0;
        int f2 = 1;
        int g = 0;
        int temp;
        for (int i = number.length() - 2; i >= 0; --i) {
            if (Integer.parseInt(number.charAt(i) + "" + number.charAt(i+1)) < 26) {
                g = 1;
            } else {
                g = 0;
            }
            // f(r-2) = f(r-1)+g(r-2,r-1)*f(r)
            // f(r)表示以r为开始（r最小取0）到最右端所组成的数字能够翻译成字符串的种数。
            temp = f2;
            f2 = f2 + g * f1;
            f1 = temp;
        }
        return f2;
    }

    public static void main(String[] args) {
        System.out.println(getTranslationCount(127));
    }
}