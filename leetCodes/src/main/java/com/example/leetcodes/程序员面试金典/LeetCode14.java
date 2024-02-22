package com.example.leetcodes.程序员面试金典;

import java.util.HashMap;

/**
 * @author tanyuanfeng
 * @link https://leetcode.cn/problems/palindrome-permutation-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 */
public class LeetCode14 {

    public static void main(String[] args) {
        String s = "tactcoa";
        boolean ret = canPermutePalindrome(s);
        System.out.println("ret:"+ret);
    }

    public static boolean canPermutePalindrome(String s) {
        char[] charArray = s.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : charArray) {
            if (hashMap.get(c) == null || hashMap.get(c) == 0){
                hashMap.put(c, 1);
            }else {
                hashMap.put(c, hashMap.get(c)-1);
            }
        }
        // 方法一：只剩下一个value值为1/全部为0，则为回文串
        int hasOne = 0;
        for (Integer value : hashMap.values()) {
            if (value < 0){
                return false;
            }
            if (value.equals(1)){
                hasOne++;
            }
        }
        return hasOne == 0 || hasOne == 1;
    }
}
