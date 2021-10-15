package com.hncboy.swordreferstooffer;

/**
 * @author hncboy
 * @date 2021/10/15 14:34
 * @description 剑指 Offer 45.把数组排成最小的数
 * 
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * 示例 1:
 * 输入: [10,2]
 * 输出: "102"
 *
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *
 * 提示:
 * 0 < nums.length <= 100
 * 
 * 说明:
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question45 {

    public String minNumber(int[] nums) {
        String[] array = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = String.valueOf(nums[i]);
        }

        // 数学问题，具体证明看力扣，通过快排进行排序
        quickSort(array, 0, array.length - 1);

        StringBuilder result = new StringBuilder();
        for (String s : array) {
            result.append(s);
        }
        return result.toString();
    }

    public void quickSort(String[] array, int low, int high) {
        if (low < high) {
            int middle = getMiddle(array, low, high);
            quickSort(array, low, middle - 1);
            quickSort(array, middle + 1, high);
        }
    }

    public int getMiddle(String[] array, int low, int high) {
        // 数组的第一个数为基准元素
        String base = array[low];
        while (low < high) {
            // 从后向前找比基准小的数
            while (low < high && (array[high] + base).compareTo(base + array[high]) >= 0) {
                high--;
            }
            // 把比基准小的数移到低端
            array[low] = array[high];

            // 从前向后找比基准大的数
            while (low < high && (array[low] + base).compareTo(base + array[low]) <= 0) {
                low++;
            }
            // 把比基准大的数移到高端
            array[high] = array[low];
        }
        array[low] = base;
        return low;
    }
}
