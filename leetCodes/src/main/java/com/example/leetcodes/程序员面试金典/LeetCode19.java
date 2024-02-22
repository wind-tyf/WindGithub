package com.example.leetcodes.程序员面试金典;

/**
 * @author tanyuanfeng
 * @link https://leetcode.cn/problems/string-rotation-lcci/description/?envType=study-plan-v2&envId=cracking-the-coding-interview
 */
public class LeetCode19 {

    public static void main(String[] args) {
//        String s1 = "waterbottle"; String s2 = "erbottlewat";
//        String s1 = "aa"; String s2 = "aba";
//        String s1 = "aaaac"; String s2 = "aaaca";
        String s1 = "aba"; String s2 = "bab";
//        String s1 = ""; String s2 = "";
        boolean ret = isFlipedString(s1, s2);
        System.out.println("ret:"+ret);
    }

    public static boolean isFlipedString(String s1, String s2) {
        // 方法一：暴力求解
        /*if (s1.length() != s2.length()){
            return false;
        }
        if (s1.length() == 0){
            return true;
        }
        int len = s1.length();
        char[] charArray1 = s1.toCharArray();
        char[] charArray2 = s2.toCharArray();
        // 提取s1第一个字符
        char char1S = charArray1[0];
        // 遍历s2
        for (int i = 0; i < charArray2.length; i++) {
            // 找到和s1第一个字符匹配的位置
            if (char1S == charArray2[i]){
                boolean pickCheck = (s2.substring(i,len) + s2.substring(0, i)).equals(s1);
                if(pickCheck){
                    return true;
                }
            }
        }
        return false;*/
        // 方法二：基于KMP算法的contains函数
        return s1.length() == s2.length() && (s1+s1).contains(s2);
    }
}
