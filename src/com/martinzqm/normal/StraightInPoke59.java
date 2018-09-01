package com.martinzqm.normal;

import java.util.Arrays;

/**
 * @Author miao
 * @Description:  *面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，如果牌能组成顺子就输出true，否则就输出false。
 * 为了方便起见,你可以认为大小王是0。
 * @Date 2018/9/1 19:43
 */
public class StraightInPoke59 {
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        Arrays.sort(numbers);
        int numberOfZero = 0;
        // 统计0的数量
        for (int i = 0; i <= numbers.length; ++i) {
            if (numbers[i] == 0) {
                ++numberOfZero;
            }
        }
        // 统计间隔的数量
        int numberOfGap = 0;
        int small = numberOfZero;
        int big = small + 1;
        while (big < numbers.length) {
            // 有数据相同的数据则不是顺子
            if (numbers[small] == numbers[big]) {
                return false;
            }
            numberOfGap += numbers[big] - numbers[small] - 1;
            small = big;
            ++big;
        }
        return numberOfZero < numberOfGap ? false : true;
    }
}