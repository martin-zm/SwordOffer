package com.martinzqm.normal;

/**
 * @Author miao
 * @Description: 题目：最长不含重复字符的子字符串。请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 假设字符串中只包含从’a’到’z’的字符。例如，在字符串中”arabcacfr”，最长非重复子字符串为”acfr”，长度为4。
 * 解析：
 * 主要思路：使用动态规划，记录当前字符之前的最长非重复子字符串长度f(i-1)，其中i为当前字符的位置。每次遍历当前字符时，分两种情况：
 * 1）若当前字符第一次出现，则最长非重复子字符串长度f(i) = f(i-1)+1。
 * 2）若当前字符不是第一次出现，则首先计算当前字符与它上次出现位置之间的距离d。若d大于f(i-1)，即说明前一个非重复子字符串中没有包含当前字符，
 * 则可以添加当前字符到前一个非重复子字符串中，所以，f(i) = f(i-1)+1。若d小于或等于f(i-1)，即说明前一个非重复子字符串中已经包含当前字符，
 * 则不可以添加当前字符，所以，f(i) = d。
 * @Date 2018/8/31 14:32
 */
public class LongestSingleSubstring46 {
    public static void main(String[] args) {
        System.out.println(longestSingleSubstring("arabcacfr"));
        System.out.println(longestSingleSubstring("bbb"));
    }

    public static int longestSingleSubstring(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int curLength = 0;
        int maxLength = 0;
        // 用来保存26个字母的位置
        int[] positions = new int[26];
        // 默认初始化为-1
        for (int i = 0; i < positions.length; ++i) {
            positions[i] = -1;
        }
        int position, distance;
        for (int j = 0; j < str.length(); ++j) {
            position = str.charAt(j) - 'a';
            if (positions[position] < 0) {
                ++curLength;
            } else {
                distance = j - positions[position];
                if (distance > curLength) {
                    ++curLength;
                } else {
                    curLength = distance;
                }
            }
            if (curLength > maxLength) {
                maxLength = curLength;
            }
            positions[position] = j;
        }
        return maxLength;
    }
}