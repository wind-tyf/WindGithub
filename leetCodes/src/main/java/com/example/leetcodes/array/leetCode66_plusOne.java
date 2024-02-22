package com.example.leetcodes.array;

public class leetCode66_plusOne {

    public static void main(String[] args) {
        int[] digits = {8,9,9,9};
        int[] ret = plusOne(digits);
        for (int digit : ret) {
            System.out.print(digit+",");
        }
        System.out.println();
    }

    /**
     * 66. 加一
     * @param digits
     * @return
     */
    public static int[] plusOne_old(int[] digits) {
        int index = digits.length-1;
        digits[index]++;
        if (digits[index] < 10){
            // 当最后一位数+1还是小于10，直接返回即可
            return digits;
        }
        // 当最后一位数+1 >= 10, 则需要进位
        for (int i = index; i > 0; i--) {
            if (digits[i] >= 10){
                int t = digits[i];
                digits[i] = t % 10;
                digits[i-1] = digits[i-1] + (t / 10);
            }
        }
        // digits[0]+1 >= 10, 即需要位数+1，数组长度+1
        if (digits[0] >= 10){
            int[] nums = new int[digits.length+1];
            nums[0] = digits[0] / 10;
            nums[1] = digits[0] % 10;
            for (int i = 2; i < nums.length; i++) {
                // 把digits数组除第一位外的全部
                nums[i] = digits[i-1];
            }
            return nums;
        }
        return digits;
    }

    public static int[] plusOne(int[] digits) {
        int index = digits.length-1;
        digits[index]++;
        if (digits[index] < 10){
            // 当最后一位数+1还是小于10，直接返回即可
            return digits;
        }
        // 当最后一位数+1 >= 10, 则需要进位
        for (int i = index; i > 0; i--) {
            if (digits[i] >= 10){
                int t = digits[i];
                digits[i] = t % 10;
                digits[i-1] = digits[i-1] + (t / 10);
            }
        }
        if (digits[0] >= 10){
            int[] nums = new int[digits.length+1];
            nums[0] = 1;
            return nums;
        }
        return digits;
    }
}
