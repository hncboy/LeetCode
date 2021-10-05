package com.hncboy.swordreferstooffer;

/**
 * @author hncboy
 * @date 2021/10/4 12:18
 * @description 剑指 Offer 35.复杂链表的复制
 * {@link com.hncboy.CopyListWithRandomPointer}
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 *
 *
 * 示例 1：
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * 示例 2：
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 *
 * 示例 3：
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 *
 * 示例 4：
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 * 
 * 提示：
 * -10000 <= Node.val <= 10000
 * Node.random为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 *
 * 注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question35 {

    /**
     * 实现链表的深拷贝
     * @param head
     * @return
     */
    private Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        Node curr = head;
        // 1.遍历所有节点，拷贝新节点到旧节点的下一个节点，使链表按旧新旧新的顺序交替
        while (curr != null) {
            // 构建新节点，该节点的值为当前旧节点的值
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            // 当前旧节点移动到下一个旧节点
            curr = copy.next;
        }

        // 2.遍历所有节点，通过旧节点的 random 节点去更新新节点的 random 节点
        curr = head;
        while (curr != null) {
            // 获取新节点
            Node copy = curr.next;
            // 新节点的 random 为旧节点 random 节点的下一个节点，因为旧新节点交替
            copy.random = curr.random == null ? null : curr.random.next;
            // 当前旧节点指向新节点的下一个节点，也就是下一个旧节点
            curr = copy.next;
        }

        // 3.拆分新旧链表
        // 旧节点头部
        curr = head;
        // 新节点头部
        Node clone = head.next;
        // 在所有节点中除去旧节点
        while (curr.next != null) {
            // 获取旧节点的下一个节点，新节点
            Node next = curr.next;
            // 新节点指向新节点
            curr.next = curr.next.next;
            // 旧节点的下一个节点
            curr = next;
        }
        return clone;
    }

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}