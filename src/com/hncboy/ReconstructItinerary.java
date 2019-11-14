package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2019/11/14 10:19
 * @description 332.重新安排行程
 *
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，
 * 对该行程进行重新规划排序。所有这些机票都属于一个从JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 出发。
 *
 * 说明:
 * 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。
 * 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 *
 * 示例 1:
 * 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 *
 * 示例 2:
 * 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 */
public class ReconstructItinerary {

    public static void main(String[] args) {
        ReconstructItinerary r = new ReconstructItinerary();
        List<List<String>> tickets1 = Arrays.asList(Arrays.asList("MUC", "LHR"),
                Arrays.asList("JFK", "MUC"), Arrays.asList("SFO", "SJC"), Arrays.asList("LHR", "SFO"));
        List<List<String>> tickets2 = Arrays.asList(Arrays.asList("JFK", "SFO"),
                Arrays.asList("JFK", "ATL"), Arrays.asList("SFO", "ATL"), Arrays.asList("ATL", "JFK"), Arrays.asList("ATL", "SFO"));
        System.out.println(r.findItinerary(tickets1));
        System.out.println(r.findItinerary(tickets2));
    }

    private List<String> findItinerary(List<List<String>> tickets) {
        // key 存放起始站，value 优先队列里存放能到达的终点站，且按字典序排序
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            // 从 graph 中取出对应的起始站队列，如果没有的话，就新建一个空队列存入
            PriorityQueue<String> queue = graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>());
            // 添加对应的终点站到队列中
            queue.add(ticket.get(1));
        }

        // 涉及到数据的插入，用链表性能高
        List<String> result = new LinkedList<>();
        dfs(graph, result);
        return result;
    }

    /**
     * dfs 遍历整个图
     *
     * @param graph
     * @param result
     */
    private void dfs(Map<String, PriorityQueue<String>> graph, List<String> result) {
        Stack<String> stack = new Stack<>();
        // 插入起始站 JFK
        stack.push("JFK");

        // 从起始站遍历
        while (!stack.isEmpty()) {
            PriorityQueue<String> queue;
            // 从 graph 中取出对应起始站能到达的终点站队列并且终点站不为空
            while ((queue = graph.get(stack.peek())) != null && queue.size() > 0) {
                // 将优先队列中字典排序在前的终点站弹出并插入栈，遍历这个循环，以刚插入的终点站作为起始站
                stack.push(queue.poll());
            }
            // 遇到起始站能到达的终点站为空，也就是该起始站作为终点时，结束上面的循环，将该终点站插入到链表的最后一个位置作为终点站
            // 将遍历完成后的栈依次弹出插入链表
            result.add(0, stack.pop());
        }
    }
}
