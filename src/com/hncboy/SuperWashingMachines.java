package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2021/9/29 9:08
 * @description 517.超级洗衣机
 * 
 * 假设有 n 台超级洗衣机放在同一排上。开始的时候，每台洗衣机内可能有一定量的衣服，也可能是空的。
 * 在每一步操作中，你可以选择任意 m (1 <= m <= n) 台洗衣机，与此同时将每台洗衣机的一件衣服送到相邻的一台洗衣机。
 * 给定一个整数数组 machines 代表从左至右每台洗衣机中的衣物数量，请给出能让所有洗衣机中剩下的衣物的数量相等的 最少的操作步数 。
 * 如果不能使每台洗衣机中衣物的数量相等，则返回 -1 。
 *
 * 示例 1：
 * 输入：machines = [1,0,5]
 * 输出：3
 * 解释：
 * 第一步:    1     0 <-- 5    =>    1     1     4
 * 第二步:    1 <-- 1 <-- 4    =>    2     1     3    
 * 第三步:    2     1 <-- 3    =>    2     2     2   
 * 
 * 示例 2：
 * 输入：machines = [0,3,0]
 * 输出：2
 * 解释：
 * 第一步:    0 <-- 3     0    =>    1     2     0    
 * 第二步:    1     2 --> 0    =>    1     1     1     
 * 
 * 示例 3：
 * 输入：machines = [0,2,0]
 * 输出：-1
 * 解释：
 * 不可能让所有三个洗衣机同时剩下相同数量的衣物。
 *
 * 提示：
 * 1 <= n <= 104
 * 0 <= machines[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/super-washing-machines
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SuperWashingMachines {

    public static void main(String[] args) {
        SuperWashingMachines s = new SuperWashingMachines();
        System.out.println(s.findMinMoves(new int[]{1, 0, 5}) == 3);
        System.out.println(s.findMinMoves(new int[]{0, 3, 0}) == 2);
        System.out.println(s.findMinMoves(new int[]{0, 2, 0}) == -1);
    }

    private int findMinMoves(int[] machines) {
        int total = Arrays.stream(machines).sum();
        int n = machines.length;
        // 不能被平分返回 -1
        if (total % n != 0) {
            return -1;
        }

        int average = total / n;
        int result = 0;
        int sum = 0;

        // 遍历每台洗衣机的衣服数量
        for (int i = 0; i < n; i++) {
            // 计算第 i 个洗衣机需要移动的衣服数量
            machines[i] -= average;
            // 计算从 0 到 i 个洗衣机总共需要移动的衣服数量
            sum += machines[i];
            // sum <= 0 表示后面的洗衣机需要往前面 i 个洗衣机转移 |sum| 数量的衣服
            // sum > 0 表示前面的 i 个洗衣机需要往后面转移 sum 数量的衣服
            // 如果当前洗衣机需要移动的衣服数量大于前 i 个洗衣机需要移动衣服数量的绝对值，则只需要当前洗衣机往两侧移出衣服
            result = Math.max(result, Math.max(Math.abs(sum), machines[i]));
        }
        return result;
    }
}
