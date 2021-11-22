package com.hncboy.swordreferstoofferspecial;

/**
 * @author hncboy
 * @date 2021/11/22 9:31
 * @description 剑指 Offer II 038.每日温度
 * 
 * 请根据每日 气温 列表 temperatures ，重新生成一个列表，要求其对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 示例 1:
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 *
 * 示例 2:
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 *
 * 示例 3:
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 *
 * 提示：
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 *  
 *
 * 注意：本题与主站 739 题 {@link com.hncboy.DailyTemperatures}
 * 相同： https://leetcode-cn.com/problems/daily-temperatures/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/iIQa4I
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question038 {

    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];

        // 从右向左遍历
        for (int i = length - 2; i >= 0; i--) {
            // j+=result[j]是利用已经有的结果进行跳跃，找到比 temperatures[j] 更大的温度
            for (int j = i + 1; j < length; j += result[j]) {
                // 如果找到比当前温度大的，则直接赋值
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                }

                // 表示后面已经没有更大的温度了，此时下标 i 所在的值也应该是 0
                if (result[j] == 0) {
                    result[i] = 0;
                    break;
                }
            }
        }
        return result;
    }
}
