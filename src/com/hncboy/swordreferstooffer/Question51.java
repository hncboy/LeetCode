package com.hncboy.swordreferstooffer;

/**
 * @author hncboy
 * @date 2021/10/24 13:25
 * @description 剑指 Offer 51.数组中的逆序对
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 *
 * 示例 1:
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 * 限制：
 * 0 <= 数组长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question51 {

    public static void main(String[] args) {
        Question51 q = new Question51();
        System.out.println(q.reversePairs(new int[]{7, 5, 6, 4}));
    }

    public int reversePairs(int[] nums) {
        int length = nums.length;

        // 数组长度小于 2，不会有逆序对
        if (length < 2) {
            return 0;
        }

        int[] temp = new int[length];
        return reversePairs(nums, 0, length - 1, temp);
    }

    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return 0;
        }

        // 划分为 [left,mid] 和 [mid+1,right] 两个区间
        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs(nums, left, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, right, temp);

        // 如果数组已经有序，则无需排序
        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }

        // 合并 [left,mid] 和 [mid+1,right] 两个区间，并返回逆序对的数量
        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        // 逆序对的数量相加
        return leftPairs + rightPairs + crossPairs;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        // 用于存放原区间内的数字
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        // i 表示 [left, mid] 区间的指针
        int i = left;
        // j 表示 [mid+1, right] 区间的指针
        int j = mid + 1;

        int count = 0;
        // 对两个有序区间的数进行归并
        for (int k = left; k <= right; k++) {
            // 如果左区间遍历完毕，则说明剩下的右区间的值都是大于左区间的，直接赋给 nums[k]
            if (i == mid + 1) {
                nums[k] = temp[j++];
                continue;
            }

            // 如果右区间遍历完毕，则说明剩下的左区间的值都是大于右区间的，直接赋给 nums[k]
            if (j == right + 1) {
                nums[k] = temp[i++];
                continue;
            }

            // 如果当前的值是右区间的更大，则把左区间的值赋给 nums[k]
            if (temp[i] <= temp[j]) {
                nums[k] = temp[i++];
                continue;
            }

            // 如果当前的值是左区间的更大，则把右区间的值赋给 nums[k]
            nums[k] = temp[j++];

            // 此时满足逆序对的情况
            // 此时逆序对的数量为左区简单 [i, mid] 以及当前右区间的 temp[j]
            count += (mid - i + 1);
        }
        return count;
    }
}
