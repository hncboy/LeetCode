package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2021/11/17 8:57
 * @description 剑指 Offer II 028.展平多级双向链表
 * 
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。
 * 这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 * 给定位于列表第一级的头节点，请扁平化列表，即将这样的多级双向链表展平成普通的双向链表，使所有结点出现在单级双链表中。
 *
 *  
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * 输出：[1,2,3,7,8,11,12,9,10,4,5,6]
 *
 * 示例 2：
 * 输入：head = [1,2,null,3]
 * 输出：[1,3,2]
 * 解释：
 * 输入的多级列表如下图所示：
 *   1---2---NULL
 *   |
 *   3---NULL
 *
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 *  
 * 如何表示测试用例中的多级链表？
 * 以 示例 1 为例：
 *  1---2---3---4---5---6--NULL
 *          |
 *          7---8---9---10--NULL
 *              |
 *              11--12--NULL
 * 序列化其中的每一级之后：
 * [1,2,3,4,5,6,null]
 * [7,8,9,10,null]
 * [11,12,null]
 *
 * 为了将每一级都序列化到一起，我们需要每一级中添加值为 null 的元素，以表示没有节点连接到上一级的上级节点。
 * [1,2,3,4,5,6,null]
 * [null,null,7,8,9,10,null]
 * [null,11,12,null]
 * 合并所有序列化结果，并去除末尾的 null 。
 * [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 *  
 *
 * 提示：
 * 节点数目不超过 1000
 * 1 <= Node.val <= 10^5
 *
 * 注意：本题与主站 430 题 {@link com.hncboy.FlattenAMultilevelDoublyLinkedList}
 * 相同： https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/Qv1Da2
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question028 {

    public Node flatten(Node head) {
        // 定义哑节点
        Node dummy = new Node();
        dummy.next = head;

        // 从头开始遍历链表
        for (; head != null; head = head.next) {
            // 不存在子节点则继续遍历
            if (head.child == null) {
                continue;
            }

            // 定义原来 head 的 next 节点
            Node oldNext = head.next;

            // 获取到子节点
            Node child = head.child;
            // 将子节点指向 head 的 next 节点
            head.next = child;
            // 将子节点的 prev 节点指向 head 节点
            child.prev = head;
            // 将 head 节点的 child 节点置为 null
            head.child = null;

            // 找到刚拼接好的 child 链表的末尾
            Node newNext = head;
            while (newNext.next != null) {
                newNext = newNext.next;
            }

            // 将此时 head 新的 next 指针指向原来 next 节点
            newNext.next = oldNext;
            // 如果此时没有到达最后一个节点，则将 oldNext 节点指向 last 节点
            if (oldNext != null) {
                oldNext.prev = newNext;
            }
        }
        return dummy.next;
    }

    private static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
