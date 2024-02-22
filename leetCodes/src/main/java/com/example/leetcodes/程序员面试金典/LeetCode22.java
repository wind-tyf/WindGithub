package com.example.leetcodes.程序员面试金典;

import com.example.leetcodes.程序员面试金典.dto.ListNode;

/**
 * @author tanyuanfeng
 * @link https://leetcode.cn/problems/kth-node-from-end-of-list-lcci/description/?envType=study-plan-v2&envId=cracking-the-coding-interview
 */
public class LeetCode22 {

    public static void main(String[] args) {
        /**
         * 输入： 1->2->3->4->5 和 k = 2
         * 输出： 4
         */
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode head = node1;
        head.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        int k = 1;
        int ret = kthToLast(head, k);
        System.out.println("ret:"+ret);
    }

    public static int kthToLast(ListNode head, int k) {
        // 双指针
        ListNode sNode = head;
        ListNode eNode = head;
        while (k-- > 1){
            eNode = eNode.getNext();
        }
        while (eNode.getNext() != null){
            sNode = sNode.getNext();
            eNode = eNode.getNext();
        }
        return sNode.getVal();
    }
}
