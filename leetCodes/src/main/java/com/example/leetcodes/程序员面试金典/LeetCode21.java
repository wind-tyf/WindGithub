package com.example.leetcodes.程序员面试金典;

import com.example.leetcodes.程序员面试金典.dto.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author tanyuanfeng
 * @link https://leetcode.cn/problems/remove-duplicate-node-lcci/description/?envType=study-plan-v2&envId=cracking-the-coding-interview
 */
public class LeetCode21 {

    public static void main(String[] args) {
//        int[] arrays = {1,2,3,3,2,1};
//        int[] arrays = {1, 1, 1, 1, 2};
//        int[] arrays = {};
        int[] arrays = {17, 23, 15, 30, 21, 5, 20, 14, 5, 9, 22, 6, 22, 20, 14, 12, 4, 21, 27, 5, 4, 21, 27, 0, 14, 21, 17, 27, 6, 12, 28, 17, 29, 8, 17, 13, 7, 26, 7, 31, 27, 8, 31, 19, 5, 23, 9, 0, 22, 0, 26, 30, 14, 10, 6, 8, 16, 24, 15, 21, 2, 3, 5, 15};
        ListNode head = ListNode.initByArrays(arrays);
        removeDuplicateNodes(head);
        ListNode.showListNode(head);
    }

    /**
     * 移除重复节点
     * @param head
     * @return
     */
    public static ListNode removeDuplicateNodes(ListNode head) {
        if (head == null){
            return head;
        }
        Set<Integer> set = new HashSet<>();
        ListNode node = head;
        set.add(node.getVal());
        while (node != null && node.getNext() != null){
            if (set.contains(node.getNext().getVal())){
                // 移除
                node.setNext(node.getNext().getNext());
            }else {
                set.add(node.getNext().getVal());
                node = node.getNext();
            }
        }
        return head;
    }

    public static ListNode removeDuplicateNodesOld(ListNode head) {
        if (head == null){
            return head;
        }
        int minVal = head.getVal();
        ListNode node = head;
        while (node != null && node.getNext() != null){
            if (minVal >= node.getNext().getVal()){
                // 下一个节点值小于等于当前值，则移除下一个节点
                node.setNext(node.getNext().getNext());
            }else {
                // 否则用下一个节点数据更新指针和参数值
                node = node.getNext();
                minVal = node.getVal();
            }
        }
        return head;
    }
}
