package com.martinzqm.algorithm.DynamicProcess;

/**
 * @author zhangmiao3
 * @Description:
 * @date 9:04 2018/7/2
 */
public class Test {
    public static void main(String[] args) {
//        System.out.println(new Test().checkPerfectNumber(28));

        String str = "  你好么 我好 得到 ";
        test(str);
//        System.out.println(str);
    }


    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        int result = 1;
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                result += i;
            }
        }
        return result == num;
    }

    public static void test(String str) {
        String[] strings = str.trim().split("\\s+");
        for (String s : strings) {
            System.out.println(s);
        }
    }



}
