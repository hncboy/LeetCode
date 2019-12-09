package com.hncboy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hncboy
 * @date 2019/12/9 10:38
 * @description 138.复制带随机指针的链表
 *
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的深拷贝。 
 *
 * 示例：
 * 输入：
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 * 解释：
 * 节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
 * 节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。
 *
 * 提示：
 * 你必须返回给定头的拷贝作为对克隆列表的引用。
 */
public class CopyListWithRandomPointer {

    private Map<Node, Node> visitedNode = new HashMap<>();

    public static void main(String[] args) {
        CopyListWithRandomPointer c = new CopyListWithRandomPointer();
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(2, null, null);
        Node node3 = new Node(3, null, null);
        Node node4 = new Node(4, null, null);
        Node node5 = new Node(5, null, null);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1.random = node3;

        System.out.println(c.copyRandomList2(node1));
    }

    private Node copyRandomList2(Node head) {
        if (head == null) {
            return head;
        }

        Node curr = head;
        // 遍历所有节点，拷贝新节点到旧节点的下一个节点，使链表按旧新旧新的顺序交替
        while (curr != null) {
            // 构建新节点，该节点的值为当前旧节点的值，下一个节点为旧节点的下一个节点
            Node copy = new Node(curr.val, curr.next, null);
            // 获取当前旧节点的下一个旧节点
            Node next = curr.next;
            // 将当前旧节点的下一个节点指向新节点
            curr.next = copy;
            // 当前旧节点移动到下一个旧节点
            curr = next;
        }

        curr = head;
        // 遍历所有节点，通过旧节点的 random 节点去更新新节点的 random 节点
        while (curr != null) {
            // 获取新节点
            Node copy = curr.next;
            // 新节点的 random 为旧节点 random 节点的下一个节点，因为旧新节点交替
            copy.random = curr.random == null ? null : curr.random.next;
            // 当前旧节点指向新节点的下一个节点，也就是下一个旧节点
            curr = copy.next;
        }

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

    /**
     * map 递归拷贝
     *
     * @param head
     * @return
     */
    private Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        if (visitedNode.containsKey(head)) {
            return visitedNode.get(head);
        }

        Node node = new Node(head.val, null, null);
        visitedNode.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }

    private static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
