package com.martinzqm.normal;

import java.util.ArrayList;

/**
 * @Author miao
 * @Description: 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串
 * abc,acb,bac,bca,cab和cba。
 * @Date 2018/8/28 8:29
 */
public class StringPermutation36 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str != null && str.length() > 0) {
            permutationRecursion(str.toCharArray(), 0, list);
        }
        return list;
    }

    public void permutationRecursion(char[] str, int begin, ArrayList<String> list) {
        if (begin == str.length) {
            String val = String.valueOf(str);
            if (!list.contains(val)) {
                list.add(val);
            }
        } else {
            for (int i = begin; i < str.length; ++i) {
                // 依次交换循环遍历
                swap(str, begin, i);
                permutationRecursion(str, begin + 1, list);
                // 还原第一个字符，方便后一次再做交换遍历
                swap(str, begin, i);
            }
        }
    }

    public void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}