package com.martinzqm.normal;

/**
 * @Author miao
 * @Description: 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * @Date 2018/8/29 10:11
 */
public class PrintMinNumberInArrayPermutation43 {
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String pre, last;
        int temp;
        for (int i = 0; i < numbers.length; ++i) {
            for (int j = i + 1; j < numbers.length; ++j) {
                pre = numbers[i] + "" + numbers[j];
                last = numbers[j] + "" + numbers[i];
                if (pre.compareTo(last) > 0) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
            sb.append(numbers[i]);
        }
        return sb.toString();
    }
}