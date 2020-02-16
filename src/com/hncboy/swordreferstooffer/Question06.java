package com.hncboy.swordreferstooffer;

import java.util.*;

/**
 * @author hncboy
 * @date 2020/2/16 15:36
 * @description 面试题06.从尾到头打印链表
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 限制：
 * 0 <= 链表长度 <= 10000
 */
public class Question06 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        System.out.println(Arrays.toString(new Question06().reversePrint(head)));
    }

    private int[] reversePrint(ListNode head) {
        ListNode node = head;
        int count = 0;
        // 第一次遍历链表得到节点个数
        while (node != null) {
            node = node.next;
            count++;
        }

        // 第二次遍历链表填充数组
        int[] result = new int[count];
        while (head != null) {
            result[--count] = head.val;
            head = head.next;
        }

        return result;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
