package com.hncboy;

/**
 * @author hncboy
 * @date 2019/12/20 15:37
 * @description 1051.高度检查器
 *
 * 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
 * 请你返回至少有多少个学生没有站在正确位置数量。
 * 该人数指的是：能让所有学生以 非递减 高度排列的必要移动人数。
 *
 * 示例：
 * 输入：[1,1,4,2,1,3]
 * 输出：3
 * 解释：
 * 高度为 4、3 和最后一个 1 的学生，没有站在正确的位置。
 *
 * 提示：
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 */
public class HeightChecker {

    public static void main(String[] args) {
        HeightChecker h = new HeightChecker();
        System.out.println(h.heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
    }

    private int heightChecker(int[] heights) {
        // 1 <= heights[i] <= 100
        int[] nums = new int[101];
        // 统计 heights 中每个元素的数量放入桶中，非递减的顺序放入
        for (int height : heights) {
            nums[height]++;
        }

        int count = 0;
        for (int i = 1, j = 0; i < nums.length; i++) {
            // 从桶中每次取出一个元素，直到成为空桶
            while (nums[i]-- > 0) {
                // 从桶中取出元素时就是非递减的方式，与 heights 中的元素比较，不一样的话 count++
                if (heights[j++] != i) {
                    count++;
                }
            }
        }

        return count;
    }
}
