package com.example.leetcodes.程序员面试金典;

/**
 * @author tanyuanfeng
 * @link https://leetcode.cn/problems/one-away-lcci/description/?envType=study-plan-v2&envId=cracking-the-coding-interview
 */
public class LeetCode15 {

    public static void main(String[] args) {
//        String first = "adc"; String second = "ad";
//        String first = "pale"; String second = "ale"; // 增
//        String first = "pale"; String second = "palea"; // 删
//        String first = "pale"; String second = "pala"; // 改
//        String first = "pales"; String second = "pal";
//        String first = "horse"; String second = "ros";
        String first = "intention"; String second = "execution";
        boolean ret = oneEditAway(first, second);
        System.out.println("ret:"+ret);
    }

    public static boolean oneEditAway(String first, String second) {
        // 长度相差大于1，则肯定不符合
        if (Math.abs(first.length()-second.length()) > 1){
            return false;
        }
        // 若一模一样或包含则直接返回true
        if (first.contains(second) || second.contains(first)){
            return true;
        }
        // 接下来的情况是往中间[增删改]一条数据的情况 ==> 保持first >= second
        if (first.length() < second.length()){
            String temp = first;
            first = second;
            second = temp;
        }
        int index1 = 0;
        int index2 = 0;
        int difCount = 0;
        char[] charArray1 = first.toCharArray();
        char[] charArray2 = second.toCharArray();
        while (index1 < first.length()){
            if (charArray1[index1] != charArray2[index2]){
                difCount++;
                if (difCount > 1){
                    return false;
                }
                if(first.length() != second.length()) {
                    index1++;
                    continue;
                }
            }
            index1++;
            index2++;
        }

        return index1 == first.length();
    }

}
