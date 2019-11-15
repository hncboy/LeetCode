package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2019/11/14 18:39
 * @description 399.除法求值
 *
 * 出方程式 A / B = k, 其中 A 和 B 均为代表字符串的变量， k 是一个浮点型数字。
 * 根据已知方程式求解问题，并返回计算结果。如果结果不存在，则返回 -1.0。
 *
 * 示例 :
 * 给定 a / b = 2.0, b / c = 3.0
 * 问题: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? 
 * 返回 [6.0, 0.5, -1.0, 1.0, -1.0 ]
 *
 * 基于上述例子，输入如下：
 * equations(方程式) = [ ["a", "b"], ["b", "c"] ],
 * values(方程式结果) = [2.0, 3.0],
 * queries(问题方程式) = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 *
 * 输入总是有效的。你可以假设除法运算中不会出现除数为0的情况，且不存在任何矛盾的结果。
 */
public class EvaluateDivision {

    /**
     * key 为节点，value 为 key 的根节点
     */
    private Map<String, String> parents = new HashMap<>();

    /**
     * 存放 parents 中 value/key 的值，values 中的 key 和 parents 中的 key 一致
     */
    private Map<String, Double> values = new HashMap<>();

    public static void main(String[] args) {
        EvaluateDivision e = new EvaluateDivision();
        List<List<String>> equations = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("e", "f"), Arrays.asList("b", "e"));
        double[] values = new double[]{3.4, 1.4, 2.3};
        List<List<String>> queries = Arrays.asList(Arrays.asList("b", "a"), Arrays.asList("a", "f")
                , Arrays.asList("f", "f"), Arrays.asList("a", "c"), Arrays.asList("f", "e"));
        System.out.println(Arrays.toString(e.calcEquation(equations, values, queries)));
    }

    /**
     * Union-Find 并查集
     *
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    private double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        }

        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String c1 = queries.get(i).get(0);
            String c2 = queries.get(i).get(1);

            if (!parents.containsKey(c1) || !parents.containsKey(c2)) {
                results[i] = -1;
                continue;
            }

            if (c1.equals(c2)) {
                results[i] = 1;
                continue;
            }

            // 找到两个节点的父节点
            String p1 = find(c1);
            String p2 = find(c2);

            // 父节点不一样，则没有结果
            if (!p1.equals(p2)) {
                results[i] = -1;
                continue;
            }

            results[i] = calc(c2) / calc(c1);
        }
        return results;
    }

    /**
     * 连接 parent 和 child 的对应关系与值
     *
     * @param parent
     * @param child
     * @param value
     */
    private void union(String parent, String child, double value) {
        add(parent);
        add(child);

        String p1 = find(parent);
        String p2 = find(child);

        // 根节点是同一个的话就不用更新
        if (p1.equals(p2)) {
            return;
        }

        // 更新 p2 的根节点为 p1
        parents.put(p2, p1);
        // 更新 p1/p2 的值
        values.put(p2, value * (values.get(parent) / values.get(child)));
    }

    /**
     * 取出对应节点与父节点的比值
     * @param x
     * @return
     */
    private double calc(String x) {
        // 取出原始的值
        double v = values.get(x);
        // 遍历父节点，每次找到父节点，就乘以父节点的值，直到找到根节点
        while (!parents.get(x).equals(x)) {
            x = parents.get(x);
            v *= values.get(x);
        }
        return v;
    }

    /**
     * 找到 x 节点的根节点
     *
     * @param x
     * @return
     */
    private String find(String x) {
        while (!parents.get(x).equals(x)) {
            x = parents.get(x);
        }
        return x;
    }

    /**
     * 将新节点以及值插入 parents 和 values
     *
     * @param x
     */
    private void add(String x) {
        if (!parents.containsKey(x)) {
            parents.put(x, x);
            values.put(x, 1.0);
        }
    }
}
