package com.hncboy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hncboy
 * @date 2019/12/6 10:54
 * @description 954.二倍数对数组
 *
 * 给定一个长度为偶数的整数数组 A，只有对 A 进行重组后可以满足 “对于每个 0 <= i < len(A) / 2，
 * 都有 A[2 * i + 1] = 2 * A[2 * i]” 时，返回 true；否则，返回 false。
 *
 * 示例 1：
 * 输入：[3,1,3,6]
 * 输出：false
 *
 * 示例 2：
 * 输入：[2,1,2,6]
 * 输出：false
 *
 * 示例 3：
 * 输入：[4,-2,2,-4]
 * 输出：true
 * 解释：我们可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
 *
 * 示例 4：
 * 输入：[1,2,4,16,8,4]
 * 输出：false
 *
 * 提示：
 * 0 <= A.length <= 30000
 * A.length 为偶数
 * -100000 <= A[i] <= 100000
 */
public class ArrayOfDoubledPairs {

    public static void main(String[] args) {
        ArrayOfDoubledPairs a = new ArrayOfDoubledPairs();
        System.out.println(a.canReorderDoubled2(new int[]{3, 1, 3, 6}));
        System.out.println(a.canReorderDoubled2(new int[]{2, 1, 2, 6}));
        System.out.println(a.canReorderDoubled2(new int[]{4, -2, 2, -4}));
        System.out.println(a.canReorderDoubled2(new int[]{1, 2, 4, 16, 8, 4}));
    }

    private boolean canReorderDoubled2(int[] A) {
        // -100000 <= A[i] <= 100000
        int[] count = new int[200001];
        // 0-100000 存 负数+100000 的值
        // 100001-200001 存 正数+10000 的值
        for (int a : A) {
            count[a + 100000] += 1;
        }

        for (int i = 1; i <= 100000; i++) {
            // 正数
            if (count[100000 + i] > 0) {
                if (count[100000 + i * 2] < count[100000 + i]) {
                    return false;
                }
                count[100000 + i * 2] -= count[100000 + i];
            }

            // 负数
            if (count[100000 - i] > 0) {
                if (count[100000 - i * 2] < count[100000 - i]) {
                    return false;
                }
                count[100000 - i * 2] -= count[100000 - i];
            }
        }

        return true;
    }


    private boolean canReorderDoubled1(int[] A) {
        Arrays.sort(A);
        Map<Integer, Integer> map = new HashMap<>();
        // 将所有数及出现的次数存入 hash 表
        for (int a : A) {
            if (a != 0) {
                map.put(a, map.getOrDefault(a, 0) + 1);
            }
        }

        for (int a : A) {
            if (a != 0 && map.get(a) > 0) {
                int target = a * 2;
                if (a < 0) {
                    // 排序之后小于0的数如果是奇数，那么找不到比他小2倍的数
                    if ((a & 1) == 1) {
                        return false;
                    }
                    // 负数要除2
                    target = a / 2;
                }
                // 一个数两倍的个数一定要大于该数的个数
                if (map.getOrDefault(target, 0) < map.get(a)) {
                    return false;
                }
                // 两倍数的个数-当前数的个数
                map.put(target, map.get(target) - map.get(a));
                map.put(a, 0);
            }
        }
        return true;
    }
}
