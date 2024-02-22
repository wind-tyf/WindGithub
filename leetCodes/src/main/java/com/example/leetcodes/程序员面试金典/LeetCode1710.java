package com.example.leetcodes.程序员面试金典;

import java.util.HashMap;

/**
 * @author tanyuanfeng
 * @link https://leetcode.cn/problems/find-majority-element-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 */
public class LeetCode1710 {

    public static void main(String[] args) {
        int[] nums = {1,2,5,9,5,9,5,5,5};
//        int[] nums = {3,2};
//        int[] nums = {3,2,3};
//        int[] nums = {2,2,1,1,1,2,2};
//        int[] nums = {2,2,1,1,1,1,2,2};
//        int[] nums = {1};
        int ret = majorityElement(nums);
        System.out.println("ret:"+ret);
    }


    public static int majorityElement(int[] nums) {
        // 摩尔投票算法
        int candidate = -1;
        int count = 0;
        for (int num : nums) {
            // 当count=0时，candidate=num
            if (count == 0){
                candidate = num;
            }
            // 当下一个数与candidate相同则+1
            if (candidate == num){
                count++;
            }else {
                // 不相同则-1(相当于抵消)
                count--;
            }
        }
        // 重新计数【之所以要再遍历一次，是因为当不存在主要元素时，candidate不一定是主要元素】
        count = 0;
        for (int num : nums) {
            if (num == candidate){
                count++;
            }
        }
        return count*2 > nums.length ? candidate : -1;
    }

    public static int majorityElement1(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int subLen = nums.length / 2;
        for (int num : nums) {
            if (map.get(num) == null){
                map.put(num, 1);
            }else {
                map.put(num, map.get(num)+1);
                if (map.get(num) > subLen){
                    return num;
                }
            }
        }
        return -1;
    }
}
