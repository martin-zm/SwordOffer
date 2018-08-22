package com.martinzqm.normal;

/**
 * @Author miao
 * @Description:
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 * @Date 2018/8/21 9:56
 */
public class FindNumInTwoDimentionArray2 {
    public boolean solution(int[][] nums, int target) {
        int row = 0;
        int column = nums[0].length - 1;
        while (row < nums.length && column > -1) {
            if (target == nums[row][column]) {
                return true;
            } else if (target < nums[row][column]) {
                --column;
            } else {
                ++row;
            }
        }
        return false;
    }

}
