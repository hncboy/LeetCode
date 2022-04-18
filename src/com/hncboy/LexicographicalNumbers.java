package com.hncboy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hncboy
 * @date 2022/4/18 9:50
 * 386.字典序排数
 * 
 * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 *
 * 示例 1：
 * 输入：n = 13
 * 输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
 *
 * 示例 2：
 * 输入：n = 2
 * 输出：[1,2]
 *  
 * 提示：
 * 1 <= n <= 5 * 104
 * 通过次数 34,811 提交次数 45,774
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lexicographical-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LexicographicalNumbers {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        int number = 1;
        for (int i = 0; i < n; i++) {
            result.add(number);
            if (number * 10 <= n) {
                number *= 10;
            } else {
                while (number % 10 == 9 || number + 1 > n) {
                    number /= 10;
                }
                number++;
            }
        }
        return result;
    }
}
