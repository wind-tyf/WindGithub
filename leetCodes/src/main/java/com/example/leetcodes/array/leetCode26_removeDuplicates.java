package com.example.leetcodes.array;

public class leetCode26_removeDuplicates {

    public static void main(String[] args) {
        // 输入数组
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int k = solution(nums);
        System.out.println("result:"+k);
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i]+",");
        }
        System.out.println();
    }

    /**
     * 26. 删除有序数组中的重复项
     * 双指针版(优化版)
     * @param nums 待处理数组
     * @return 去重后的长度
     */
    public static int solution(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]){
                nums[++index] = nums[i];
            }
        }
        return index+1;
    }

    /**
     * 26. 删除有序数组中的重复项
     * 双数组版
     * @param nums 待处理数组
     * @return 去重后的长度
     */
    public static int solution_old(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int[] ret = new int[nums.length];
        ret[0] = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (ret[index] != nums[i]){
                ret[++index] = nums[i];
            }
        }
        for (int i = 0; i < ret.length; i++) {
            nums[i] = ret[i];
        }
        return index+1;
    }

}
