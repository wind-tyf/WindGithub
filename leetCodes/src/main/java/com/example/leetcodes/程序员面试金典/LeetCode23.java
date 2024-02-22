package com.example.leetcodes.程序员面试金典;

import com.example.leetcodes.程序员面试金典.dto.ListNode;

/**
 * @author tanyuanfeng
 * @link https://leetcode.cn/problems/delete-middle-node-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 */
public class LeetCode23 {

    public static void main(String[] args) {
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
        deleteNode(node3);
        ListNode node = node1;
        while (node != null){
            System.out.println("show:"+node.getVal());
            node = node.getNext();
        }
    }

    public static void deleteNode(ListNode node) {
        // 用当前节点参数值替换掉下一个节点参数值，然后node的next指针指向next.next
        node.setVal(node.getNext().getVal());
        node.setNext(node.getNext().getNext());
    }
}
