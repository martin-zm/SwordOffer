package com.martinzqm.normal;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author miao
 * @Description: 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * @Date 2018/8/31 15:33
 */
public class FirstNotRepeatingChar48 {
    public int firstNotRepeatingChar(String str) {
        if (str == null) {
            return -1;
        }
        char[] charArray = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < charArray.length; ++i) {
            if (map.containsKey(charArray[i])) {
                map.put(charArray[i], map.get(charArray[i]) + 1);
            } else {
                map.put(charArray[i], 1);
            }
        }
        for (int j = 0; j < charArray.length; ++j) {
            if (1 == map.get(charArray[j])) {
                return j;
            }
        }
        return -1;
    }
}