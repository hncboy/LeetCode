package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/25 16:15
 * @description 1144.递减元素使数组呈锯齿状
 * 
 * 给你一个整数数组nums，每次 操作会从中选择一个元素并 将该元素的值减少1。
 *
 * 如果符合下列情况之一，则数组A就是 锯齿数组：
 *
 * 每个偶数索引对应的元素都大于相邻的元素，即A[0] > A[1] < A[2] > A[3] < A[4] > ...
 * 或者，每个奇数索引对应的元素都大于相邻的元素，即A[0] < A[1] > A[2] < A[3] > A[4] < ...
 * 返回将数组nums转换为锯齿数组所需的最小操作次数。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：我们可以把 2 递减到 0，或把 3 递减到 1。
 * 
 * 示例 2：
 * 输入：nums = [9,6,1,6,2]
 * 输出：4
 *
 * 提示：
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 1000
 */
public class DecreaseElementsToMakeArrayZigzag {

    public static void main(String[] args) {
        DecreaseElementsToMakeArrayZigzag d = new DecreaseElementsToMakeArrayZigzag();
        System.out.println(d.movesToMakeZigzag(new int[]{1, 2, 3}));
        System.out.println(d.movesToMakeZigzag(new int[]{9, 6, 1, 6, 2}));
        System.out.println(d.movesToMakeZigzag(new int[]{7, 4, 8, 9, 7, 7, 5}));
    }

    public int movesToMakeZigzag(int[] nums) {
        int evenCount = getCount(nums.clone(), 0);
        if (evenCount == 0) {
            return 0;
        }
        return Math.min(evenCount, getCount(nums, 1));
    }

    /**
     * 跟相邻的元素比较
     *
     * @param nums
     * @param start 0 偶数索引大于相邻 1 奇数索引大于相邻
     * @return
     */
    private int getCount(int[] nums, int start) {
        int count = 0;
        for (int i = start; i < nums.length; i += 2) {
            // 如果前一个数大于等于该数，将前一个数的值修改为当前的数-1
            if (i - 1 >= 0 && nums[i] <= nums[i - 1]) {
                count += nums[i - 1] - nums[i] + 1;
                nums[i - 1] = nums[i] - 1;
            }
            // 如果后一个数大于等于该数，将后一个数的值修改为当前的数-1
            if (i + 1 < nums.length && nums[i] <= nums[i + 1]) {
                count += nums[i + 1] - nums[i] + 1;
                nums[i + 1] = nums[i] - 1;
            }
        }
        return count;
    }
}
