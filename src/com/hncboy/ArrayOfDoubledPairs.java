package com.hncboy;

import java.util.*;

/**
 * @author hncboy
 * @date 2019/12/6 10:54
 * 954.二倍数对数组
 * 
 * 给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，
 * 都有 arr[2 * i + 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。
 *
 * 示例 1：
 * 输入：arr = [3,1,3,6]
 * 输出：false
 *
 * 示例 2：
 * 输入：arr = [2,1,2,6]
 * 输出：false
 *
 * 示例 3：
 * 输入：arr = [4,-2,2,-4]
 * 输出：true
 * 解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
 *  
 * 提示：
 * 0 <= arr.length <= 3 * 104
 * arr.length 是偶数
 * -105 <= arr[i] <= 105
 * 通过次数 20,571 提交次数 55,818
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/array-of-doubled-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ArrayOfDoubledPairs {

    public static void main(String[] args) {
        ArrayOfDoubledPairs a = new ArrayOfDoubledPairs();
        System.out.println(a.canReorderDoubled(new int[]{3, 1, 3, 6}));
        System.out.println(a.canReorderDoubled(new int[]{2, 1, 2, 6}));
        System.out.println(a.canReorderDoubled(new int[]{4, -2, 2, -4}));
        System.out.println(a.canReorderDoubled(new int[]{1, 2, 4, 16, 8, 4}));
    }

    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : arr) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }
        if (cnt.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }

        List<Integer> vals = new ArrayList<>(cnt.keySet());
        vals.sort(Comparator.comparingInt(Math::abs));

        for (int x : vals) {
            if (cnt.getOrDefault(2 * x, 0) < cnt.get(x)) { // 无法找到足够的 2x 与 x 配对
                return false;
            }
            cnt.put(2 * x, cnt.getOrDefault(2 * x, 0) - cnt.get(x));
        }
        return true;
    }
}
