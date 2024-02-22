package com.example.leetcodes.程序员面试金典;

import org.springframework.util.StringUtils;

import java.util.HashMap;

/**
 * @author tanyuanfeng
 * @link https://leetcode.cn/problems/check-permutation-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 */
public class LeetCode12 {

    public static void main(String[] args) {
        String s1 = "你爱我";
        String s2 = "我爱你";
        boolean ret = CheckPermutation(s1, s2);
        System.out.println("ret:"+ret);
    }

    public static boolean CheckPermutation(String s1, String s2) {
        if (StringUtils.isEmpty(s1) || StringUtils.isEmpty(s2) || s1.length() != s2.length()){
            return false;
        }
        // 1、用map来循环两个字符串
        HashMap<Character, Integer> map = new HashMap<>(s1.length());
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        for (char c : charArray1) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c)+1);
        }
        for (char c : charArray2) {
            if (map.get(c) == null || map.get(c) == 0){
                return false;
            }
            map.put(c, map.get(c)-1);
        }
        return true;
    }
}
