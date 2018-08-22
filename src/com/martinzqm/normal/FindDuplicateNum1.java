package com.martinzqm.normal;

import com.martinzqm.util.Util;

/**
 * @author zhangmiao3
 * @Description:
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 *
 * 注意条件，所有数字都在0到n-1范围内
 * 时间：O(n) :  虽然有两层循环，但是所有数字最多只需要交换两次就能达到要求
 * 空间：O(1)
 * @date 09:27 2018/8/21
 */
public class FindDuplicateNum1 {
    public boolean solution(int[] nums, int[] result) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        int length = nums.length;
        for (int i = 0; i < length; ++i) {
            if (nums[i] < 0 || nums[i] > length - 1) {
                result[0] = -1;
                return false;
            }
        }
        for (int i = 0; i < length; ++i) {
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) {
                    result[0] = nums[i];
                    return true;
                }
                Util.swap(nums[i], nums[nums[i]]);
            }
        }
        return false;
    }
}
