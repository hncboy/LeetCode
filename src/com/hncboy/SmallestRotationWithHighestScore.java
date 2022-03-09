package com.hncboy;

/**
 * @author hncboy
 * @date 2022/3/9 7:58
 * 798.得分最高的最小轮调
 * 
 * 给你一个数组 nums，我们可以将它按一个非负整数 k 进行轮调，这样可以使数组变为 [nums[k], nums[k + 1], ... nums[nums.length - 1], nums[0], nums[1], ..., nums[k-1]] 的形式。
 * 此后，任何值小于或等于其索引的项都可以记作一分。
 *
 * 例如，数组为 nums = [2,4,1,3,0]，我们按 k = 2 进行轮调后，它将变成 [1,3,0,2,4]。这将记为 3 分，
 * 因为 1 > 0 [不计分]、3 > 1 [不计分]、0 <= 2 [计 1 分]、2 <= 3 [计 1 分]，4 <= 4 [计 1 分]。
 *
 * 在所有可能的轮调中，返回我们所能得到的最高分数对应的轮调下标 k 。如果有多个答案，返回满足条件的最小的下标 k 。
 *
 * 示例 1：
 * 输入：nums = [2,3,1,4,0]
 * 输出：3
 * 解释：
 * 下面列出了每个 k 的得分：
 * k = 0,  nums = [2,3,1,4,0],    score 2
 * k = 1,  nums = [3,1,4,0,2],    score 3
 * k = 2,  nums = [1,4,0,2,3],    score 3
 * k = 3,  nums = [4,0,2,3,1],    score 4
 * k = 4,  nums = [0,2,3,1,4],    score 3
 * 所以我们应当选择 k = 3，得分最高。
 *
 * 示例 2：
 * 输入：nums = [1,3,0,2,4]
 * 输出：0
 * 解释：
 * nums 无论怎么变化总是有 3 分。
 * 所以我们将选择最小的 k，即 0。
 * 
 * 提示：
 * 1 <= nums.length <= 105
 * 0 <= nums[i] < nums.length
 * 通过次数 2,842 提交次数 5,273
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-rotation-with-highest-score
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SmallestRotationWithHighestScore {

    public static void main(String[] args) {
        SmallestRotationWithHighestScore s = new SmallestRotationWithHighestScore();
        System.out.println(s.bestRotation(new int[]{2, 3, 1, 4, 0}));
        System.out.println(s.bestRotation(new int[]{1, 3, 0, 2, 4}));
    }

    public int bestRotation(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        // 当 k = (i - nums[i] + 1 + n) % n 时，此时 nums[i] 刚好不得分，统计此时不得分的情况
        for (int i = 0; i < n; i++) {
            count[(i - nums[i] + 1 + n) % n]++;
        }

        int minK = 0;
        // 遍历寻找最优的 k
        for (int i = 1; i < n; i++) {
            // 当 k+1 后，此时有一个元素开始得分了
            count[i] += count[i - 1] - 1;
            // 如果 k 此时不得分的数量少
            if (count[i] < count[minK]) {
                minK = i;
            }
        }
        return minK;
    }
}
