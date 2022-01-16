package com.hncboy;

import java.util.Random;

/**
 * @author hncboy
 * @date 2019/12/28 10:44
 * 382.��������ڵ�
 *
 * ����һ�����������ѡ�������һ���ڵ㣬��������Ӧ�Ľڵ�ֵ��ÿ���ڵ� ��ѡ�еĸ���һ�� ��
 *
 * ʵ�� Solution �ࣺ
 * Solution(ListNode head) ʹ�����������ʼ������
 * int getRandom() �����������ѡ��һ���ڵ㲢���ظýڵ��ֵ�����������нڵ㱻ѡ�еĸ�����ȡ�
 *
 * ʾ����
 * ����
 * ["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
 * [[[1, 2, 3]], [], [], [], [], []]
 * ���
 * [null, 1, 3, 2, 2, 3]
 * ����
 * Solution solution = new Solution([1, 2, 3]);
 * solution.getRandom(); // ���� 1
 * solution.getRandom(); // ���� 3
 * solution.getRandom(); // ���� 2
 * solution.getRandom(); // ���� 2
 * solution.getRandom(); // ���� 3
 * // getRandom() ����Ӧ������� 1��2��3�е�һ����ÿ��Ԫ�ر����صĸ�����ȡ�
 *
 * ��ʾ��
 * �����еĽڵ����ڷ�Χ [1, 104] ��
 * -104 <= Node.val <= 104
 * ������� getRandom ���� 104 ��
 *
 * ���ף�
 * �������ǳ����ҳ���δ֪������ô����
 * ���ܷ��ڲ�ʹ�ö���ռ������½�������⣿
 * ͨ������ 26,092 �ύ���� 38,282
 */
public class LinkedListRandomNode {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Solution s = new Solution(head);
        System.out.println(s.getRandom());
    }

    private static class Solution {

        private final ListNode head;
        private final Random random;

        public Solution(ListNode head) {
            this.head = head;
            random = new Random();
        }

        public int getRandom() {
            int i = 1;
            int result = 0;
            for (ListNode node = head; node != null; node = node.next) {
                if (random.nextInt(i) == 0) {
                    result = node.val;
                }
                i++;
            }
            return result;
        }
    }
}
