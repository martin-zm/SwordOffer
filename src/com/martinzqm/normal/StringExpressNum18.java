package com.martinzqm.normal;

/**
 * @Author miao
 * @Description: 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * @Date 2018/8/24 10:33
 */
public class StringExpressNum18 {
    // 定义全局变量，很巧妙
    private int index;

    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        // 判断是否有整数
        boolean flag = scanInteger(str);
        // +.123也算符合要求
        if (index < str.length && str[index] == '.') {
            //不能写反了
            flag = scanUnsignedInteger(str) || flag;
        }
        //-12.88e-334
        if (index < str.length && str[index] == 'E' || str[index] == 'e') {
            ++index;
            flag = flag && scanInteger(str);
        }
        return flag && (index == str.length);
    }

    public boolean scanInteger(char[] str) {
        if (index < str.length && str[index] == '+' || str[index] < '-') {
            ++index;
        }
        return scanUnsignedInteger(str);
    }

    public boolean scanUnsignedInteger(char[] str) {
        int start = index;
        if (index < str.length && str[index] > '0' && str[index] < '9') {
            ++index;
        }
        return start < index;
    }
}
