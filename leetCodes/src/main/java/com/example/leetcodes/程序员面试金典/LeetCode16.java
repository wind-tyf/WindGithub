package com.example.leetcodes.程序员面试金典;

/**
 * @author tanyuanfeng
 * @link https://leetcode.cn/problems/compress-string-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 */
public class LeetCode16 {

    public static void main(String[] args) {
//        String S = "aabcccccaaa";
        String S = "abbccd";
        String ret = compressString(S);
        System.out.println("ret:"+ret);
    }

    public static String compressString(String S) {
        if (S == null || S.length() == 0){
            return S;
        }
        char[] charArray = S.toCharArray();
        StringBuilder strBuilder = new StringBuilder();
        char s = charArray[0];
        int count = 1;
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] == s){
                count++;
            }else {
                strBuilder.append(s).append(count);
                // 更新s和count
                s = charArray[i];
                count = 1;
            }
        }
        strBuilder.append(s).append(count);
        // 比较压缩后的字符长度和原字符串长度
        return strBuilder.toString().length() >= S.length() ? S : strBuilder.toString();
    }
}
