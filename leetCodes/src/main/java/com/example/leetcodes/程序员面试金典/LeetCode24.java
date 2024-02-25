package com.example.leetcodes.程序员面试金典;

import com.example.leetcodes.程序员面试金典.dto.ListNode;

/**
 * @author tanyuanfeng
 * @link https://leetcode.cn/problems/partition-list-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 */
public class LeetCode24 {

    public static void main(String[] args) {
//        int[] arrays = {1,4,3,2,5,2}; int x = 3;
        int[] arrays = {2,1}; int x = 2;
        ListNode head = ListNode.initByArrays(arrays);
        ListNode partition = partition(head, x);
        ListNode.showListNode(partition);
    }

    public static ListNode partition(ListNode head, int x) {
        // 当链表为空或者个数为1时，直接返回
        if (head == null || head.getNext() == null){
            return head;
        }
        // 新建四个临时节点
        ListNode newNodeHead = new ListNode(0);
        ListNode newNodeMid = new ListNode(0);
        ListNode newHeadMove = newNodeHead;
        ListNode newMidMove = newNodeMid;
        ListNode node = head;
        while (node != null){
            if (node.getVal() < x){
                newHeadMove.setNext(node);
                newHeadMove = node;
            } else {
                newMidMove.setNext(node);
                newMidMove = node;
            }
            node = node.getNext();
        }
        newHeadMove.setNext(newNodeMid.getNext());
        newMidMove.setNext(null);
        return newNodeHead.getNext();
    }
}
