package com.example.leetcodes.程序员面试金典;

/**
 * @author tanyuanfeng
 * @link https://leetcode.cn/problems/string-to-url-lcci/description/?envType=study-plan-v2&envId=cracking-the-coding-interview
 */
public class LeetCode13 {

    public static void main(String[] args) {
        String s = "Mr John Smith    ";
        Integer len = 13;
        String ret = replaceSpaces(s, len);
        System.out.println("ret:"+ret);
    }

    public static String replaceSpaces(String S, int length) {
        // 方法一：暴力求解1-遍历str
        /*char[] charArray = S.toCharArray();
        StringBuffer strBuffer = new StringBuffer();
        int len = 0;
        for (char c : charArray) {
            if (' ' == c){
                strBuffer.append("%20");
            }else {
                strBuffer.append(c);
            }
            len++;
            if (len == length){
                break;
            }
        }
        return strBuffer.toString();*/
        // 方法二：暴力求解2-遍历长度
        char[] charArray = S.substring(0, length).toCharArray();
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = charArray[i];
            if(' ' == c){
                strBuilder.append("%20");
            }else {
                strBuilder.append(c);
            }
        }
        return strBuilder.toString();
    }
}
