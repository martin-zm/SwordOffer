package com.martinzqm.normal;

/**
 * @Author miao
 * @Description: 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * @Date 2018/8/31 19:25
 */
public class ReverseSentence56 {
    public static String reverseSentence(String s) {
        if (s.trim().equals("")) {
            return s;
        }
        s = s.trim();
        String rs = reverse(s);
        String[] stringArray = rs.split("\\s");
        for (int i = 0; i < stringArray.length; ++i) {
            stringArray[i] = reverse(stringArray[i]);
        }
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < stringArray.length - 1; ++j) {
            result.append(stringArray[j] + " ");
        }
        result.append(stringArray[stringArray.length - 1]);
        return result.toString();
    }

    public static String reverse(String s) {
        if (s == null) {
            return null;
        }
        char temp;
        char[] chars = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseSentence("I am a studnet."));
    }
}