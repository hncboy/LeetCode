package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2019/11/5 15:00
 * @description 725.分隔链表
 */
public class SplitLinkedListInParts {

    public static void main(String[] args) {
        SplitLinkedListInParts s = new SplitLinkedListInParts();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        System.out.println(Arrays.toString(s.splitListToParts(node, 5)));
    }

    private ListNode[] splitListToParts(ListNode root, int k) {
        int n = 0;
        for (ListNode p = root; p != null; p = p.next) {
            n++;
        }

        // 每个位置基本节点的数量
        int count = n / k;
        // 有一个多余节点的组数
        int group = n % k;

        ListNode[] result = new ListNode[k];
        ListNode curr = root;
        for (int i = 0; i < k; i++) {
            ListNode head = curr;
            // 统计每组中节点的数量，首先满足 group 的数量
            for (int j = 0; j < count + (i < group ? 1 : 0) - 1; j++) {
                if (curr != null) {
                    curr = curr.next;
                }
            }

            if (curr != null) {
                ListNode prev = curr;
                curr = curr.next;
                prev.next = null;
            }
            result[i] = head;
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
