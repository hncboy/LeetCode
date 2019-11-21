package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/21 8:45
 * @description 457.环形数组循环
 *
 * 给定一个含有正整数和负整数的环形数组 nums。 如果某个索引中的数 k 为正数，则向前移动 k 个索引。
 * 相反，如果是负数 (-k)，则向后移动 k 个索引。因为数组是环形的，
 * 所以可以假设最后一个元素的下一个元素是第一个元素，而第一个元素的前一个元素是最后一个元素。
 * 确定 nums 中是否存在循环（或周期）。循环必须在相同的索引处开始和结束并且循环长度 > 1。
 * 此外，一个循环中的所有运动都必须沿着同一方向进行。
 * 换句话说，一个循环中不能同时包括向前的运动和向后的运动。
 *
 * 示例 1：
 * 输入：[2,-1,1,2,2]
 * 输出：true
 * 解释：存在循环，按索引 0 -> 2 -> 3 -> 0 。循环长度为 3 。
 *
 * 示例 2：
 * 输入：[-1,2]
 * 输出：false
 * 解释：按索引 1 -> 1 -> 1 ... 的运动无法构成循环，因为循环的长度为 1 。根据定义，循环的长度必须大于 1 。
 *
 * 示例 3:
 * 输入：[-2,1,-1,-2,-2]
 * 输出：false
 * 解释：按索引 1 -> 2 -> 1 -> ... 的运动无法构成循环，因为按索引 1 -> 2 的运动是向前的运动，而按索引 2 -> 1 的运动是向后的运动。一个循环中的所有运动都必须沿着同一方向进行。
 *
 * 提示：
 * -1000 ≤ nums[i] ≤ 1000
 * nums[i] ≠ 0
 * 0 ≤ nums.length ≤ 5000
 */
public class CircularArrayLoop {

    public static void main(String[] args) {
        CircularArrayLoop c = new CircularArrayLoop();
        System.out.println(c.circularArrayLoop(new int[]{2, -1, 1, 2, 2}));
        System.out.println(c.circularArrayLoop(new int[]{-1, 2}));
        System.out.println(c.circularArrayLoop(new int[]{-2, 1, -1, -2, -2}));
        System.out.println(c.circularArrayLoop(new int[]{1, 2, 1, 2}));
    }

    private boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 0 无法进行循环
            if (nums[i] == 0) {
                continue;
            }

            int slow = i;
            int fast = i;
            while (true) {
                int lastSlow = slow;
                slow = (slow + nums[slow] + 5000 * n) % n;
                if (isCycle(nums, slow, lastSlow)) {
                    setZero(nums, i);
                    break;
                }

                int lastFast = fast;
                fast = (fast + nums[fast] + 5000 * n) % n;
                if (isCycle(nums, fast, lastFast)) {
                    setZero(nums, i);
                    break;
                }
                lastFast = fast;
                fast = (fast + nums[fast] + 5000 * n) % n;
                if (isCycle(nums, fast, lastFast)) {
                    setZero(nums, i);
                    break;
                }
                if (slow == fast) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断是否能够成循环
     *
     * @param nums
     * @param i
     * @param lastI
     * @return
     */
    private boolean isCycle(int[] nums, int i, int lastI) {
        // 前后两个数符号相等 && 非零 && 前后两数下标不相等
        return nums[lastI] * nums[i] < 0 || nums[i] == 0 || lastI == i;
    }

    /**
     * 将不可能构成循环的对应下标数置为 0
     *
     * @param nums
     * @param lastI
     */
    private void setZero(int[] nums, int lastI) {
        int n = nums.length;
        int i;
        while (true) {
            i = (lastI + nums[lastI] + 5000 * n) % n;
            if (isCycle(nums, i, lastI)) {
                nums[lastI] = 0;
                break;
            }
            nums[lastI] = 0;
            lastI = i;
        }
    }
}
