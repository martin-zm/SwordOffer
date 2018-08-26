package com.martinzqm.normal;

/**
 * @Author miao
 * @Description:
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * @Date 2018/8/24 11:16
 */
public class RegularExpression17 {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        int startIndex = 0;
        int patternIndex = 0;
        return matchCore(str, startIndex, pattern, patternIndex);
    }

    public boolean matchCore(char[] str, int startIndex, char[] pattern, int patternIndex) {
        if (startIndex == str.length && patternIndex == pattern.length) {
            return true;
        }
        if (startIndex != str.length && patternIndex == pattern.length) {
            return false;
        }
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if (startIndex != str.length && str[startIndex] == pattern[patternIndex]
            || startIndex != str.length && pattern[patternIndex] == '.') {
                return matchCore(str, startIndex, pattern, patternIndex + 2)
                        || matchCore(str, startIndex + 1, pattern, patternIndex + 2)
                        || matchCore(str, startIndex + 1, pattern, patternIndex);
            } else {
                matchCore(str, startIndex, pattern, patternIndex + 2);
            }
        }
        if (startIndex != str.length && str[startIndex] == pattern[patternIndex]
                || startIndex != str.length && pattern[patternIndex] == '.') {
            return matchCore(str, startIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }
}