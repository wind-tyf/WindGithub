package com.example.leetcodes.程序员面试金典;

/**
 * @author tanyuanfeng
 * @link https://leetcode.cn/problems/is-unique-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 */
public class LeetCode11 {

    public static void main(String[] args) {
        String str = "leetcode";
//        String str = "abc";
        boolean unique = isUnique(str);
        System.out.println("ret:"+unique);
    }

    public static boolean isUnique(String astr) {
        // 方法一：用set实现
        /*Set<Character> uniqueSet = new HashSet<>();
        char[] charArray = astr.toCharArray();
        for (char str : charArray){
            if(uniqueSet.contains(str)){
                return false;
            }
            uniqueSet.add(str);
        }
        return true;*/
        // 方法二：用26个数组字母下标
        char[] charArray = astr.toCharArray();
        char[] uniqueCharArray = new char[26];
        for (char str : charArray) {
            if (1 == uniqueCharArray[str%97]){
                return false;
            }
            uniqueCharArray[str%97] = 1;
        }
        return true;
    }
}
