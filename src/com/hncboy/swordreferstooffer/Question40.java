package com.hncboy.swordreferstooffer;

import java.util.*;

/**
 * @author hncboy
 * @date 2020/3/20 15:33
 * @description 剑指 Offer 40.最小的k个数
 *
 * 输入整数数组 arr ，找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * 限制：
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 */
public class Question40 {

    /**
     * 方法一
     * 采用快排的思想讯寻找以 k 为下标的切分点
     * 时间复杂度：O(n)
     */
    public int[] getLeastNumbers1(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] nums, int left, int right, int k) {
        int p = partition(nums, left, right);
        // 切分点为 k 就直接返回
        if (p == k) {
            return Arrays.copyOf(nums, p + 1);
        }

        // 根据当前切分点的位置决定切分左边还是有边
        return p > k ? quickSearch(nums, left, p - 1, k) : quickSearch(nums, p + 1, right, k);
    }

    /**
     * 以 nums[left] 为切分点
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] nums, int left, int right) {
        int i = left;
        int j = right + 1;
        // 切分点
        int num = nums[left];

        while (true) {
            while (++i <= right && nums[i] < num) {
            }
            while (--j >= left && nums[j] > num) {
            }
            // 此时 j 位置就是切分点 nums[left] 应该在的位置
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        // 交换 nums[j] 和 nums[left]
        swap(nums, left, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }

    /**
     * 方法二
     * 大根堆
     * 时间复杂度：O(nlogK)
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }

        // 重写比较器
        Queue<Integer> queue = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num : arr) {
            if (queue.size() < k) {
                queue.offer(num);
            } else if (num < queue.peek()) {
                queue.poll();
                queue.offer(num);
            }
        }

        // 返回堆中的元素
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;
    }

    /**
     * 方法三
     * 二叉搜索树
     * 时间复杂度：O(nlogK)
     */
    public int[] getLeastNumbers3(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }

        // key：数字, value：该数字出现的个数
        TreeMap<Integer, Integer> map = new TreeMap<>();
        // 统计当前存储了多少数字
        int count = 0;
        for (int num : arr) {
            if (count < k) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                count++;
                continue;
            }

            // 取出 map 中最大 key 的 entry
            Map.Entry<Integer, Integer> entry = map.lastEntry();
            // 如果该 entry 的 key 比 num 大
            if (entry.getKey() > num) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                // 如果该 entry 的 value 为 1，移除该 entry，否则直接 value-1
                if (entry.getValue() == 1) {
                    map.pollLastEntry();
                } else {
                    map.put(entry.getKey(), entry.getValue() - 1);
                }
            }
        }

        int[] result = new int[k];
        int i = 0;
        // 遍历 map 中的 entry
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 该数字出现的次数
            int n = entry.getValue();
            while (n-- > 0) {
                result[i++] = entry.getKey();
            }
        }
        return result;
    }

    /**
     * 方法四
     * 范围区间内直接计数排序
     * 时间复杂度：O(n)
     */
    public int[] getLeastNumbers4(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }

        // 统计每个数字出现的次数
        int[] count = new int[10001];
        for (int num : arr) {
            count[num]++;
        }

        int[] result = new int[k];
        // 遍历 count 中 num 出现的个数
        for (int num = 0, i = 0; num < count.length && i != k; num++) {
            while (count[num]-- > 0 && i < k) {
                result[i++] = num;
            }
        }
        return result;
    }
}