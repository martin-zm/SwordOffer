package com.martinzqm.normal;

/**
 * @Author miao
 * @Description:
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * 思路：倒序，从后往前处理
 * @Date 2018/8/21 10:03
 */
public class ReplaceSpace3 {
    public String solution(StringBuffer str) {
        int spaceCount = 0;
        int oldLength = str.length();
        for (int i = 0; i < oldLength; ++i) {
            if (str.charAt(i) == ' ') {
                ++spaceCount;
            }
        }
        int newLength = oldLength + 2 * spaceCount;
        str.setLength(newLength);
        int newIndex = newLength - 1;
        for (int i = oldLength - 1; i >= 0; --i) {
            if (str.charAt(i) == ' ') {
                str.setCharAt(newIndex--, '0');
                str.setCharAt(newIndex--, '2');
                str.setCharAt(newIndex--, '%');
            } else {
                str.setCharAt(newIndex--, str.charAt(i));
            }
        }
        return str.toString();
    }
}