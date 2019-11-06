package com.hncboy;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author hncboy
 * @date 2019/11/6 9:38
 * @description 1019.链表中的下一个更大节点
 *
 * 给出一个以头节点 head 作为第一个节点的链表。
 * 链表中的节点分别编号为：node_1, node_2, node_3, ... 。
 *
 * 每个节点都可能有下一个更大值（next larger value）：
 * 对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，
 * 而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
 * 返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 *
 * 注意：在下面的示例中，诸如 [2,1,5] 这样的输入（不是输出）是链表的序列化表示，
 * 其头节点的值为 2，第二个节点值为 1，第三个节点值为 5 。
 *
 * 示例 1：
 * 输入：[2,1,5]
 * 输出：[5,5,0]
 *
 * 示例 2：
 * 输入：[2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 *
 * 示例 3：
 * 输入：[1,7,5,1,9,2,5,1]
 * 输出：[7,9,9,9,0,5,0,0]
 *
 * 提示：
 * 对于链表中的每个节点，1 <= node.val <= 10^9
 * 给定列表的长度在 [0, 10000] 范围内
 */
public class NextGreaterNodeInLinkedList {

    public static void main(String[] args) {
        NextGreaterNodeInLinkedList n = new NextGreaterNodeInLinkedList();

        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(1);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(2);
        node2.next = new ListNode(7);
        node2.next.next = new ListNode(4);
        node2.next.next.next = new ListNode(3);
        node2.next.next.next.next = new ListNode(5);

        System.out.println(Arrays.toString(n.nextLargerNodes(node1)));
        System.out.println(Arrays.toString(n.nextLargerNodes(node2)));
    }

    private int[] nextLargerNodes(ListNode head) {
        Stack<Integer> input = new Stack<>();
        for (ListNode p = head; p != null; p = p.next) {
            input.add(p.val);
        }

        // 存放比当前数大的数
        Stack<Integer> help = new Stack<>();
        int[] result = new int[input.size()];
        for (int i = input.size() - 1; i >= 0; i--) {
            // help 栈中的值小于 input 栈中的值的话，弹出 help 栈中值
            // 也就是说选择比当前值大的最近的那个数
            while (!help.isEmpty() && input.peek() >= help.peek()) {
                help.pop();
            }

            // 如果没有比当前数大的数，该位置值为 0，否则取该值
            if (help.isEmpty()) {
                result[i] = 0;
            } else {
                result[i] = help.peek();
            }
            // 将 input 栈中的值弹出并放入 help 栈
            help.push(input.pop());
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
