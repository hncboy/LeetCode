package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2019/12/22 11:09
 * @description 1298.你能从盒子里获得的最大糖果数
 *
 * 给你 n 个盒子，每个盒子的格式为 [status, candies, keys, containedBoxes] ，其中：
 *
 * 状态字 status[i]：整数，如果 box[i] 是开的，那么是 1 ，否则是 0 。
 * 糖果数 candies[i]: 整数，表示 box[i] 中糖果的数目。
 * 钥匙 keys[i]：数组，表示你打开 box[i] 后，可以得到一些盒子的钥匙，每个元素分别为该钥匙对应盒子的下标。
 * 内含的盒子 containedBoxes[i]：整数，表示放在 box[i] 里的盒子所对应的下标。
 * 给你一个 initialBoxes 数组，表示你现在得到的盒子，你可以获得里面的糖果，也可以用盒子里的钥匙打开新的盒子，还可以继续探索从这个盒子里找到的其他盒子。
 * 请你按照上述规则，返回可以获得糖果的 最大数目 。
 */
public class MaximumCandiesYouCanGetFromBoxes {

    public static void main(String[] args) {
        MaximumCandiesYouCanGetFromBoxes m = new MaximumCandiesYouCanGetFromBoxes();
        int[] status1 = {1, 0, 1, 0};
        int[] candies1 = {7, 5, 4, 100};
        int[][] keys1 = {{}, {}, {1}, {}};
        int[][] containedBoxes1 = {{1, 2}, {3}, {}, {}};
        int[] initialBoxes1 = {0};
        System.out.println(m.maxCandies(status1, candies1, keys1, containedBoxes1, initialBoxes1));
    }

    private int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        // 判断盒子是否以及被拆开
        boolean[] visited = new boolean[status.length];
        Set<Integer> containBoxSet = new HashSet<>();
        Set<Integer> containKeySet = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        // 初始化盒子
        for (int box : initialBoxes) {
            containBoxSet.add(box);
            // 如果盒子可以直接打开就加入队列
            if (status[box] == 1) {
                queue.offer(box);
                visited[box] = true;
            }
        }

        int candy = 0;
        while (!queue.isEmpty()) {
            int currBox = queue.poll();
            candy += candies[currBox];

            // 遍历当前盒子内的钥匙
            for (int key : keys[currBox]) {
                containKeySet.add(key);
                // 如果盒子没有拆开过且有相应的钥匙
                if (!visited[key] && containBoxSet.contains(key)) {
                    queue.offer(key);
                    visited[key] = true;
                }
            }

            // 遍历当前盒子内的盒子
            for (int box : containedBoxes[currBox]) {
                containBoxSet.add(box);
                // 如果盒子没有拆开过且(有对应钥匙或盒子是打开的)
                if (!visited[box] && (containKeySet.contains(box) || status[box] == 1)) {
                    queue.offer(box);
                    visited[box] = true;
                }
            }
        }
        return candy;
    }
}
