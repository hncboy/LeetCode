package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2021/11/17 9:19
 * @description 剑指 Offer II 029.排序的循环链表
 * 
 * 给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal ，使这个列表仍然是循环升序的。
 * 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
 * 如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
 * 如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。
 *
 * 示例 1：
 * 输入：head = [3,4,1], insertVal = 2
 * 输出：[3,4,1,2]
 * 解释：在上图中，有一个包含三个元素的循环有序列表，你获得值为 3 的节点的指针，我们需要向表中插入元素 2 。
 * 新插入的节点应该在 1 和 3 之间，插入之后，整个列表如上图所示，最后返回节点 3 。
 *
 * 示例 2：
 * 输入：head = [], insertVal = 1
 * 输出：[1]
 * 解释：列表为空（给定的节点是 null），创建一个循环有序列表并返回这个节点。
 *
 * 示例 3：
 * 输入：head = [1], insertVal = 0
 * 输出：[1,0]
 *
 * 提示：
 * 0 <= Number of Nodes <= 5 * 10^4
 * -10^6 <= Node.val <= 10^6
 * -10^6 <= insertVal <= 10^6
 *
 * 注意：本题与主站 708 题相同： https://leetcode-cn.com/problems/insert-into-a-sorted-circular-linked-list/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4ueAj6
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question029 {

    public Node insert(Node head, int insertVal) {
        // 定义新节点
        Node newNode = new Node(insertVal);

        // 链表为空
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        // 已经是排序循环链表
        Node prev = head;
        Node curr = head.next;
        Node max = head;
        Node min = head.next;

        do {
            // insertVal 刚好在 [prev.val,curr.val] 范围内，插进去直接返回
            if (prev.val <= insertVal && insertVal <= curr.val) {
                prev.next = newNode;
                newNode.next = curr;
                return head;
            }
            
            // 出现这种情况说明 prev.val 是最大值，curr.val 节点是最小值
            if (prev.val > curr.val) {
                max = prev;
                min = curr;
            }
            prev = prev.next;
            curr = curr.next;
        } while (prev != head);
        
        // 此时当前值需要插入最大值和最小值之间
        max.next = newNode;
        newNode.next = min;
        
        return head;
    }

    private static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}
