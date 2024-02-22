package com.example.leetcodes.程序员面试金典;

import com.example.leetcodes.程序员面试金典.dto.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tanyuanfeng
 * @link https://leetcode.cn/problems/palindrome-linked-list-lcci/description/?envType=study-plan-v2&envId=cracking-the-coding-interview
 */
public class LeetCode26 {

    public static void main(String[] args) {
        int[] nums = {1,2,2,1};
//        int[] nums = {1,2};
//        int[] nums = {1};
//        int[] nums = {1,0,1};
//        int[] nums = {1,0,0};
        ListNode head = ListNode.initByArrays(nums);
        boolean ret = isPalindrome(head);
        System.out.println("ret:"+ret);
    }

    public static boolean isPalindrome(ListNode head) {
        // 方法一：转为数组
        // 1、先统计链表长度
        ListNode node = head;
        int len = 0;
        while (node != null){
            len++;
            node = node.getNext();
        }
        // 2、存储前半段内容，并移动到中间位置
        int subLen = len/2;
        int[] subNums = new int[subLen];
        node = head;
        for (int i = 0; i < subLen; i++) {
            subNums[i] = node.getVal();
            node = node.getNext();
        }
        // 3、链表往后遍历，数组往前遍历
        if (len % 2 == 1){
            node = node.getNext();
        }
        while (node != null){
            if (node.getVal() != subNums[--subLen]){
                return false;
            }
            node = node.getNext();
        }
        return true;
    }
}
