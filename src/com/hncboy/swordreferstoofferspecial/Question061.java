package com.hncboy.swordreferstoofferspecial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hncboy
 * @date 2021/12/10 13:33
 * @description 剑指 Offer II 061.和最小的 k 个数对
 * 
 * 给定两个以升序排列的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 *
 * 示例 1:
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 *     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 *
 * 示例 2:
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 *      [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 *
 * 示例 3:
 * 输入: nums1 = [1,2], nums2 = [3], k = 3
 * 输出: [1,3],[2,3]
 * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 *
 * 提示:
 * 1 <= nums1.length, nums2.length <= 104
 * -109 <= nums1[i], nums2[i] <= 109
 * nums1, nums2 均为升序排列
 * 1 <= k <= 1000
 *
 * 注意：本题与主站 373 题相同 {@link com.hncboy.FindKPairsWithSmallestSums} ：https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/
 *
 * 通过次数 2,865 提交次数 5,324
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qn8gGX
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question061 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        // 取最小的 k
        k = Math.min(k, length1 * length2);
        List<List<Integer>> result = new ArrayList<>(k);

        // 用于统计 nums1 中的每个元素在 nums2 中走了多少步
        int[] steps = new int[length1];
        // num1 数组中的开始和结束下标
        int num1StartIndex = 0;
        int num1EndIndex = 0;

        while (result.size() < k) {
            // 计算下一步最小的一对值
            int nextStepMin = Integer.MAX_VALUE;
            // 下一步最小值时对应的 num1 数组中的下标
            int nextStepNum1Index = 0;
            // num1 中的每个数在 num2 中的位置都往前进一步，取所有情况的最小值
            for (int i = num1StartIndex; i <= num1EndIndex; i++) {
                // 计算前进一步后的值
                int stepValue = nums1[i] + nums2[steps[i]];
                if (stepValue < nextStepMin) {
                    nextStepMin = stepValue;
                    nextStepNum1Index = i;
                }
            }

            // 存入下一步的最小的一对值
            result.add(Arrays.asList(nums1[nextStepNum1Index], nums2[steps[nextStepNum1Index]]));

            // num1 中对应下标在 num2 中走过的距离 +1
            steps[nextStepNum1Index]++;

            // num1 中该下标已经走到 num2 最后一步了，则下次从该下标后面的位置开始
            if (steps[nextStepNum1Index] == length2) {
                num1StartIndex++;
            }

            // 如果该下标的值为 1，表示 num1 中有新的数被使用了一次，此时增加 num1 末尾的下标最大值
            if (steps[nextStepNum1Index] == 1) {
                num1EndIndex = Math.min(length1 - 1, num1EndIndex + 1);
            }
        }

        return result;
    }
}
