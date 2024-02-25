package com.example.leetcodes.程序员面试金典;

import com.example.leetcodes.程序员面试金典.dto.ListNode;

/**
 * @author tanyuanfeng
 * @link https://leetcode.cn/problems/sum-lists-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 */
public class LeetCode25 {

    public static void main(String[] args) {
        int[] arrays1 = {7,1,6}; int[] arrays2 = {5,9,2};
//        int[] arrays1 = {6,1,7}; int[] arrays2 = {2,9,5};
//        int[] arrays1 = {0}; int[] arrays2 = {0};
//        int[] arrays1 = {}; int[] arrays2 = {};
//        int[] arrays1 = {9}; int[] arrays2 = {1,9,9,9,9,9,9,9,9,9};
        ListNode l1 = ListNode.initByArrays(arrays1);
        ListNode l2 = ListNode.initByArrays(arrays2);
        ListNode ret = addTwoNumbers(l1, l2);
        ListNode.showListNode(ret);
    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        // 双指针
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode newHead = new ListNode(0);
        ListNode node = newHead;
        int topVal = 0;
        while (node1 != null && node2 != null){
            int curVal = node1.getVal() + node2.getVal() + topVal;
            topVal = curVal / 10;
            int nodeVal = curVal % 10;
            ListNode curNode = new ListNode(nodeVal);
            node.setNext(curNode);
            node = curNode;
            node1 = node1.getNext();
            node2 = node2.getNext();
        }
        if (node1 != null || node2 != null){
            ListNode preNode = node1 == null ? node2 : node1;
            if (topVal == 0){
                node.setNext(preNode);
            }else {
                while (preNode != null){
                    int curVal = preNode.getVal() + topVal;
                    topVal = curVal / 10;
                    int nodeVal = curVal % 10;
                    ListNode curNode = new ListNode(nodeVal);
                    node.setNext(curNode);
                    node = curNode;
                    preNode = preNode.getNext();
                }
            }
        }
        if (topVal != 0){
            node.setNext(new ListNode(topVal));
        }
        return newHead.getNext() == null ? new ListNode(0) : newHead.getNext();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 双指针
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode newHead = new ListNode(0);
        ListNode node = newHead;
        int topVal = 0;
        while (node1 != null || node2 != null){
            if (topVal == 0 && (node1 == null || node2 == null)){
                // 当进位是0，且其中一个node为空，就可以中断链表相加
                node.setNext(node1 == null ? node2 : node1);
                break;
            }
            int val1 = node1 == null ? 0 : node1.getVal();
            int val2 = node2 == null ? 0 : node2.getVal();
            int curVal = val1 + val2 + topVal;
            topVal = curVal / 10;
            int nodeVal = curVal % 10;
            ListNode curNode = new ListNode(nodeVal);
            node.setNext(curNode);
            node = curNode;
            node1 = node1 != null ? node1.getNext() : null;
            node2 = node2 != null ? node2.getNext() : null;
        }
        if (topVal != 0){
            node.setNext(new ListNode(topVal));
        }
        return newHead.getNext() == null ? new ListNode(0) : newHead.getNext();
    }

    /**
     * 链表转整型 2 -> 1 -> 9，即912
     * @param head  链表头
     * @return  整型
     */
    public static int listNode2Int(ListNode head){
        if (head == null){
            return 0;
        }
        ListNode node = head;
        int tenNum = 1;
        int ret = 0;
        while (node != null){
            ret = tenNum * node.getVal() + ret;
            tenNum = tenNum * 10;
            node = node.getNext();
        }
        return ret;
    }

    /**
     * 整型转链表 912，即2 -> 1 -> 9
     * @param n 整型
     * @return  链表
     */
    public static ListNode int2ListNode(int n){
        if (n == 0){
            return new ListNode(0);
        }
        int tenPer = 1;
        ListNode head = null;
        ListNode node = head;
        while (n / tenPer != 0){
            int nodeVal = n / tenPer % 10;
            if (node == null){
                node = new ListNode(nodeVal);
                head = node;
            }else {
                ListNode curNode = new ListNode(nodeVal);
                node.setNext(curNode);
                node = curNode;
            }
            tenPer = tenPer * 10;
        }
        return head;
    }
}
