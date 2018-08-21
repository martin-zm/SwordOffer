package com.martinzqm.swordOffer.multiPointersSolution;

/**
 * @author zhangmiao3
 * @Description: 空格替换
 * 设计一种方法，将一个字符串中的所有空格替换成 %20 。你可以假设该字符串有足够的空间来加入新的字符，且你得到的是“真实的”字符长度。
 * 你的程序还需要返回被替换后的字符串的长度。
 * 样例
 * 对于字符串"Mr John Smith", 长度为 13
 * 替换空格之后，参数中的字符串需要变为"Mr%20John%20Smith"，并且把新长度 17 作为结果返回。
 * 挑战
 * 在原字符串(字符数组)中完成替换，不适用额外空间
 * @date 20:56 2018/6/4
 */
public class ReplaceBlank {
    /*
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    //暴力解法
    public int replaceBlank(char[] string, int length) {
        int newLength = length;
        // write your code here
        for (int i = 0; i < newLength; ++i) {
            if (string[i] == ' ') {
                newLength = newLength + 2;
                // 数据后移两位
                for (int j = newLength - 1; j >= i + 3; --j) {
                    string[j] = string[j - 2];
                }
                string[i] = '%';
                string[i + 1] = '2';
                string[i + 2] = '0';
                i += 2;
            }
        }
        return newLength;
    }

    /*
    // 双指针解法
    public int replaceBlank(char[] string, int length) {

        int countSpace = 0;
        for (int i = 0; i < length; ++i) {
            if (string[i] == ' ') {
                ++countSpace;
            }
        }
        int newLength = length + 2 * countSpace;
        int j = newLength - 1;
        for (int i = length - 1; i >= 0; --i) {
            if (string[i] == ' ') {
                string[j--] = '0';
                string[j--] = '2';
                string[j--] = '%';
            } else {
                string[j] = string[i];
                --j;
            }
        }
        return newLength;
    }
    */
}
