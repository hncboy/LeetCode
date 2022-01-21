package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2022/1/21 8:52
 * 1345.跳跃游戏 IV
 *
 * 给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。
 * 每一步，你可以从下标 i 跳到下标：
 * i + 1 满足：i + 1 < arr.length
 * i - 1 满足：i - 1 >= 0
 * j 满足：arr[i] == arr[j] 且 i != j
 * 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。
 * 注意：任何时候你都不能跳到数组外面。
 *
 * 示例 1：
 * 输入：arr = [100,-23,-23,404,100,23,23,23,3,404]
 * 输出：3
 * 解释：那你需要跳跃 3 次，下标依次为 0 --> 4 --> 3 --> 9 。下标 9 为数组的最后一个元素的下标。
 *
 * 示例 2：
 * 输入：arr = [7]
 * 输出：0
 * 解释：一开始就在最后一个元素处，所以你不需要跳跃。
 *
 * 示例 3：
 * 输入：arr = [7,6,9,6,9,6,9,7]
 * 输出：1
 * 解释：你可以直接从下标 0 处跳到下标 7 处，也就是数组的最后一个元素处。
 *
 * 示例 4：
 * 输入：arr = [6,1,9]
 * 输出：2
 *
 * 示例 5：
 * 输入：arr = [11,22,7,7,7,7,7,7,7,22,13]
 * 输出：3
 *
 * 提示：
 * 1 <= arr.length <= 5 * 10^4
 * -10^8 <= arr[i] <= 10^8
 * 通过次数 8,355 提交次数 20,965
 */
public class JumpGameIv {

    public static void main(String[] args) {
        JumpGameIv jumpGameIv = new JumpGameIv();
        System.out.println(jumpGameIv.minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));
    }

    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> idxSameValue = new HashMap<>();
        // 遍历所有元素，将值作为 key，值出现的下标作为 value
        for (int i = 0; i < n; i++) {
            idxSameValue.putIfAbsent(arr[i], new ArrayList<>());
            idxSameValue.get(arr[i]).add(i);
        }

        // 记录访问过的下标
        Set<Integer> visitedIndex = new HashSet<>();
        visitedIndex.add(0);

        Queue<int[]> queue = new ArrayDeque<>();
        // int[] [0]]为当前访问的下标，[1]为当前已经走了多少步
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] idxStep = queue.poll();
            int idx = idxStep[0];
            int step = idxStep[1];

            // 访问到最后一个下标
            if (idx == n - 1) {
                return step;
            }

            // 获取当前下标对应的值
            int value = arr[idx];
            step++;

            // 条件一
            // 判断当前下标所在的值是否有重复的
            if (idxSameValue.containsKey(value)) {
                // 遍历重复所在的下标
                for (int i : idxSameValue.get(value)) {
                    // 如果没有访问过，则添加到队列
                    if (visitedIndex.add(i)) {
                        queue.offer(new int[]{i, step});
                    }
                }
                idxSameValue.remove(value);
            }

            // 条件二，移动到 i+1 位置
            if (idx + 1 < n && visitedIndex.add(idx + 1)) {
                queue.offer(new int[]{idx + 1, step});
            }

            // 条件三，移动到 i-1 位置
            if (idx - 1 >= 0 && visitedIndex.add(idx - 1)) {
                queue.offer(new int[]{idx - 1, step});
            }
        }
        return -1;
    }
}
