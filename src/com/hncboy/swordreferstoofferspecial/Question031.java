package com.hncboy.swordreferstoofferspecial;

import java.util.HashMap;

/**
 * @author hncboy
 * @date 2021/11/20 16:39
 * @description 剑指 Offer II 031.最近最少使用缓存
 * 
 * 运用所掌握的数据结构，设计和实现一个  LRU (Least Recently Used，最近最少使用) 缓存机制 。
 *
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *  
 *
 * 示例：
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 *  
 *
 * 提示：
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 105
 * 最多调用 2 * 105 次 get 和 put
 *
 * 进阶：是否可以在 O(1) 时间复杂度内完成这两种操作？
 * 注意：本题与主站 146 题 {@link com.hncboy.LruCache} 相同：https://leetcode-cn.com/problems/lru-cache/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/OrIXps
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question031 {

    private static class LRUCache {

        /**
         * 用于快速查找值
         */
        private final HashMap<Integer, Node> map;

        /**
         * 双向链表
         */
        private final DoubleList cache;

        /**
         * 最大容量
         */
        private final int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            cache = new DoubleList();
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }

            // 获取 map 中的值
            int value = map.get(key).value;
            // 利用 put 方法把该数据提前
            put(key, value);
            return value;
        }

        public void put(int key, int val) {
            // 构建新节点
            Node node = new Node(key, val);

            // 如果 map 包含该值
            if (map.containsKey(key)) {
                // 删除旧的节点，新的插到头部
                cache.remove(map.get(key));
                // 讲新节点插入到头部
                cache.addFirst(node);
                // 更新 map 中对应的数据
                map.put(key, node);
                return;
            }

            // map 中不包含该值
            // 如果容量以及到达上限
            if (capacity == cache.size()) {
                // 删除链表尾节点
                Node last = cache.removeLast();
                map.remove(last.key);
            }

            // 将该节点添加到头部
            cache.addFirst(node);
            map.put(key, node);
        }

        private static class Node {

            public int key;
            public int value;

            public Node next;
            public Node prev;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private static class DoubleList {

            private Node head;
            private Node tail;
            private int size;

            /**
             * 在链表头部添加节点，时间复杂度 O(1)
             */
            public void addFirst(Node node) {
                if (head == null) {
                    head = tail = node;
                } else {
                    Node oldHead = head;
                    oldHead.prev = node;
                    node.next = oldHead;
                    head = node;
                }
                size++;
            }

            /**
             * 删除链表中的 node 节点，时间复杂度 O(1)
             */
            public void remove(Node node) {
                if (head == node && tail == node) {
                    // 只有一个节点且则直接删除
                    head = null;
                    tail = null;
                } else if (tail == node) {
                    // 删除尾节点
                    node.prev.next = null;
                    tail = node.prev;
                } else if (head == node) {
                    // 删除头节点
                    node.next.prev = null;
                    head = node.next;
                } else {
                    // 移除 node 节点
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
                size--;
            }

            /**
             * 删除链表中最后一个节点，并返回该节点，时间 O(1)
             */
            public Node removeLast() {
                Node node = tail;
                remove(tail);
                return node;
            }

            /**
             * 返回链表长度，时间 O(1)
             */
            public int size() {
                return size;
            }
        }
    }
}
