package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/26 17:24
 * @description 142.�������� II
 * 
 * ����һ��������������ʼ�뻷�ĵ�һ���ڵ㡣��������޻����򷵻�null��
 * Ϊ�˱�ʾ���������еĻ�������ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ���� ��� pos �� -1�����ڸ�������û�л���
 * ˵�����������޸ĸ���������
 *
 * ʾ�� 1��
 * ���룺head = [3,2,0,-4], pos = 1
 * �����tail connects to node index 1
 * ���ͣ���������һ��������β�����ӵ��ڶ����ڵ㡣
 *
 * ʾ��2��
 * ���룺head = [1,2], pos = 0
 * �����tail connects to node index 0
 * ���ͣ���������һ��������β�����ӵ���һ���ڵ㡣
 *
 * ʾ�� 3��
 * ���룺head = [1], pos = -1
 * �����no cycle
 * ���ͣ�������û�л���
 */
public class LinkedListCycleII {

    public static void main(String[] args) {
        LinkedListCycleII l = new LinkedListCycleII();
        ListNode head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);
        head1.next.next.next.next = head1.next;
        System.out.println(l.detectCycle(head1));
    }

    private ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // ����ָ�룬�������л�
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

        // ��ָ���ͷ��ʼ��������ʱ����Ϊ�������
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
