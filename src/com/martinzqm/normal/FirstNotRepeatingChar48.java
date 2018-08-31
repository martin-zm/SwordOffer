package com.martinzqm.normal;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author miao
 * @Description: 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
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