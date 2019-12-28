package com.hncboy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2019/12/28 10:44
 * @description 382.��������ڵ�
 *
 * ����һ�����������ѡ�������һ���ڵ㣬��������Ӧ�Ľڵ�ֵ����֤ÿ���ڵ㱻ѡ�ĸ���һ����
 *
 * ����:
 * �������ʮ�ִ��ҳ���δ֪����ν��������⣿���ܷ�ʹ�ó������ռ临�Ӷ�ʵ�֣�
 *
 * ʾ��:
 * // ��ʼ��һ�������� [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 *
 * // getRandom()����Ӧ�������1,2,3�е�һ������֤ÿ��Ԫ�ر����صĸ�����ȡ�
 * solution.getRandom();
 */
public class LinkedListRandomNode {

    private List<Integer> list;

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        LinkedListRandomNode l = new LinkedListRandomNode(head);
        System.out.println(l.getRandom());
    }

    private LinkedListRandomNode(ListNode head) {
        list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
    }

    private int getRandom() {
        return list.get((int) (Math.random() * list.size()));
    }
}
