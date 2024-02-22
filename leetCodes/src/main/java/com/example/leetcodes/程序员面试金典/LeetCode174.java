package com.example.leetcodes.程序员面试金典;

/**
 * @author tanyuanfeng
 * @link https://leetcode.cn/problems/missing-number-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 */
public class LeetCode174 {

    public static void main(String[] args) {
//        int[] nums = {3,0,1};
        int[] nums = {9,6,4,2,3,5,7,0,1};
        int ret = missingNumber(nums);
        System.out.println("ret:"+ret);
    }

    public static int missingNumber(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        // 1、计算nums的总和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 2、计算等差数列的总和
        int sumS = (nums.length+1)*nums.length/2;
        // 3、计算两个数的差值即可
        return sumS - sum;
    }
}
