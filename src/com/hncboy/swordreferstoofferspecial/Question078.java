package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2022/1/12 9:11
 * 剑指 Offer II 078.合并排序链表
 *
 * 给定一个链表数组，每个链表都已经按升序排列。
 * 请将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * 示例 2：
 * 输入：lists = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：lists = [[]]
 * 输出：[]
 *
 * 提示：
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 *
 * 注意：本题与主站 23 题 {@link com.hncboy.MergeKSortedLists}相同： https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * 通过次数 5,865 提交次数 9,122
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/vvXgSW
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question078 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return solve(lists, 0, lists.length - 1);
    }

    private ListNode solve(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }

        int mid = (left + right) / 2;
        // 合并左右两个链表
        return merge(solve(lists, left, mid), solve(lists, mid + 1, right));
    }

    private ListNode merge(ListNode leftNode, ListNode rightNode) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (leftNode != null && rightNode != null) {
            if (leftNode.val < rightNode.val) {
                curr.next = leftNode;
                leftNode = leftNode.next;
            } else {
                curr.next = rightNode;
                rightNode = rightNode.next;
            }

            curr = curr.next;
        }

        curr.next = leftNode != null ? leftNode : rightNode;
        return dummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
