package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2019/11/12 15:43
 * @description 133.克隆图
 *
 * 给定无向连通图中一个节点的引用，返回该图的深拷贝（克隆）。
 * 图中的每个节点都包含它的值 val（Int） 和其邻居的列表（list[Node]）。
 *
 *
 * 输入：
 * {"$id":"1","neighbors":
 * [{"$id":"2","neighbors":[{"$ref":"1"},
 * {"$id":"3","neighbors":[{"$ref":"2"},
 * {"$id":"4","neighbors":[{"$ref":"3"},
 * {"$ref":"1"}],"val":4}],"val":3}],"val":2},
 * {"$ref":"4"}],"val":1}
 *
 * 解释：
 * 节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
 * 节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
 * 节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
 * 节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
 *
 * 提示：
 * 节点数介于 1 到 100 之间。
 * 无向图是一个简单图，这意味着图中没有重复的边，也没有自环。
 * 由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点 q 也必须是节点 p 的邻居。
 * 必须将给定节点的拷贝作为对克隆图的引用返回。
 */
public class CloneGraph {

    public static void main(String[] args) {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        node1.neighbors = Arrays.asList(node2, node4);
        node2.neighbors = Arrays.asList(node1, node3);
        node3.neighbors = Arrays.asList(node2, node4);
        node4.neighbors = Arrays.asList(node1, node3);
        System.out.println(new CloneGraph().cloneGraph(node1));
    }

    /**
     * DFS
     *
     * @param node
     * @return
     */
    private Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        return cloneGraphHelper(node, new HashMap<>());
    }

    private Node cloneGraphHelper(Node node, HashMap<Integer, Node> map) {
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }

        // 构造新节点
        Node curr = new Node(node.val, new ArrayList<>());
        map.put(curr.val, curr);
        // 构造新节点的所有邻接节点
        for (Node temp : node.neighbors) {
            curr.neighbors.add(cloneGraphHelper(temp, map));
        }
        return curr;
    }

    /**
     * BFS
     *
     * @param node
     * @return
     */
    private Node cloneGraph2(Node node) {
        if (node == null) {
            return null;
        }

        // 用于存放节点值和对应的节点
        Map<Integer, Node> map = new HashMap<>();
        // 构造新节点插入 map
        map.put(node.val, new Node(node.val, new ArrayList<>()));

        Queue<Node> queue = new LinkedList<>();
        // 将第一个原始节点插入 queue
        queue.add(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            // 遍历当前节点的邻接节点
            for (Node temp : curr.neighbors) {
                // 如果该邻接节点未在 map 中
                if (!map.containsKey(temp.val)) {
                    // 将该节点插入 map
                    map.put(temp.val, new Node(temp.val, new ArrayList<>()));
                    // 将该节点插入 queue
                    queue.add(temp);
                }
                // 构造当前节点的邻接节点
                map.get(curr.val).neighbors.add(map.get(temp.val));
            }
        }
        return map.get(node.val);
    }

    private static class Node {
        public int val;
        List<Node> neighbors;

        Node() {
        }

        Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
