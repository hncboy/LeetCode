package com.hncboy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2021/10/16 15:45
 * @description 282.给表达式添加运算符
 *
 * 给定一个仅包含数字 0-9 的字符串 num 和一个目标值整数 target ，在 num 的数字之间添加 二元 运算符（不是一元）+、- 或 * ，返回所有能够得到目标值的表达式。
 *
 * 示例 1:
 * 输入: num = "123", target = 6
 * 输出: ["1+2+3", "1*2*3"]
 *
 * 示例 2:
 * 输入: num = "232", target = 8
 * 输出: ["2*3+2", "2+3*2"]
 *
 * 示例 3:
 * 输入: num = "105", target = 5
 * 输出: ["1*0+5","10-5"]
 *
 * 示例 4:
 * 输入: num = "00", target = 0
 * 输出: ["0+0", "0-0", "0*0"]
 *
 * 示例 5:
 * 输入: num = "3456237490", target = 9191
 * 输出: []
 *
 * 提示：
 * 1 <= num.length <= 10
 * num 仅含数字
 * -231 <= target <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/expression-add-operators
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ExpressionAddOperators {

    public static void main(String[] args) {
        ExpressionAddOperators e = new ExpressionAddOperators();
        System.out.println(e.addOperators("123", 6));
        System.out.println(e.addOperators("232", 8));
        System.out.println(e.addOperators("105", 5));
        System.out.println(e.addOperators("00", 0));
        System.out.println(e.addOperators("3456237490", 9191));
    }

    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();

        // 如果字符串的值超过了整数的最大值，则直接返回空
        if (Long.parseLong(num) > Integer.MAX_VALUE) {
            return result;
        }

        // 将字符串转为字符数组
        char[] nums = num.toCharArray();

        // 存放数字和二元运算符组成的路径
        char[] path = new char[nums.length * 2 - 1];
        long val = 0;

        // 遍历所有的字符
        for (int i = 0; i < nums.length; i++) {
            val = val * 10 + nums[i] - '0';
            path[i] = nums[i];

            addOperators(result, target, nums, path, 0, val, i + 1, i + 1);

            // 如果 val 是 0，则直接结束循环，0 作为单独一位在上方已经计算完毕，而且在数字为多位的情况下，不允许以 0 开头
            if (val == 0) {
                break;
            }
        }

        return result;
    }

    /**
     * 添加运算符并计算
     *
     * @param result     结果集
     * @param target     目标值
     * @param nums       字符数组
     * @param path       路径数组
     * @param leftValue  左边表达式的值
     * @param rightValue 左边表达式的值
     * @param numsIndex  字符的下标
     * @param pathIndex  路径的下标
     */
    private void addOperators(List<String> result, int target, char[] nums, char[] path, long leftValue, long rightValue, int numsIndex, int pathIndex) {
        // 当前数字的下标达到了最大长度
        if (numsIndex == nums.length) {
            // 如果左边的值加上右边的值等于目标值，则将对应的路径转为字符串存入结果集
            if (leftValue + rightValue == target) {
                result.add(new String(path, 0, pathIndex));
            }
            return;
        }

        // 当前数字的值或者连续的中间没有表达式的数字的值
        long val = 0;
        // 路径中数字的下标
        int j = pathIndex + 1;

        // 从当前数字的下标开始遍历
        for (int i = numsIndex; i < nums.length; i++) {
            // 统计连续的数字得出的值
            val = val * 10 + nums[i] - '0';
            // 连续的字符在路径数组中的显示
            path[j++] = nums[i];

            path[pathIndex] = '+';
            addOperators(result, target, nums, path, leftValue + rightValue, val, i + 1, j);

            path[pathIndex] = '-';
            addOperators(result, target, nums, path, leftValue + rightValue, -val, i + 1, j);

            path[pathIndex] = '*';
            addOperators(result, target, nums, path, leftValue, rightValue * val, i + 1, j);

            // 去掉前缀的 0
            if (nums[numsIndex] == '0') {
                return;
            }
        }
    }
}
