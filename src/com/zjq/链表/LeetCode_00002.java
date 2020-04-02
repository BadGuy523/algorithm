package com.zjq.链表;

import java.util.List;

/**
 * @description: LeetCode题2
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author: BadGuy
 * @date: 2020-04-02 13:36
 **/
public class LeetCode_00002 {

    //就是模拟多位数的竖式运算
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode resultNode = result;
        int overInt = 0;
        while (l1 != null || l2 != null) {
            result.next = new ListNode(((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + overInt) % 10);
            overInt = ((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + overInt) / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            result = result.next;
        }
        if (overInt > 0) {
            result.next = new ListNode(overInt);
        }
        return resultNode.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node4.next = node5;
        node5.next = node6;
        LeetCode_00002  leetCode_00002 = new LeetCode_00002();
        System.out.println(leetCode_00002.addTwoNumbers(node1,node4));
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
