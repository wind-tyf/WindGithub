package com.example.leetcodes.程序员面试金典.dto;

/**
 * @author tanyuanfeng
 */
public class ListNode {

    int val;
    ListNode next;
    public ListNode(int x) { val = x; }

    public ListNode setNext(ListNode next) {
        this.next = next;
        return this;
    }

    public ListNode getNext() {
        return next;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    /**
     * 给定数组初始化一个链表
     * @param arrays    给定数组
     * @return  初始化后的链表头
     */
    public static ListNode initByArrays(int[] arrays){
        if (arrays.length == 0){
            return null;
        }
        ListNode node = new ListNode(arrays[0]);
        ListNode head = node;
        for (int i = 1; i < arrays.length; i++) {
            ListNode listNode = new ListNode(arrays[i]);
            node.setNext(listNode);
            node = listNode;
        }
        return head;
    }

    /**
     * 输出链表全部节点数据
     * @param head  链表头
     */
    public static void showListNode(ListNode head){
        ListNode node = head;
        System.out.print("show:");
        while (node != null){
            System.out.print(node.getVal()+",");
            node = node.getNext();
        }
        System.out.println();
    }
}
