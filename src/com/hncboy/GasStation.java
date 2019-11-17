package com.hncboy;

/**
 * @author hncboy
 * @date 2019/11/17 14:59
 * @description 134.加油站
 *
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
 * 你从其中的一个加油站出发，开始时油箱为空。
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 *
 * 说明: 
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 *
 * 示例 1:
 * 输入:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * 输出: 3
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 *
 * 示例 2:
 * 输入:
 * gas  = [2,3,4]
 * cost = [3,4,3]
 * 输出: -1
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 */
public class GasStation {

    public static void main(String[] args) {
        GasStation g = new GasStation();
        int[] gas1 = {1, 2, 3, 4, 5};
        int[] cost1 = {3, 4, 5, 1, 2};
        int[] gas2 = {2, 3, 4};
        int[] cost2 = {3, 4, 3};
        System.out.println(g.canCompleteCircuit2(gas1, cost1));
        System.out.println(g.canCompleteCircuit2(gas2, cost2));
    }

    private int canCompleteCircuit2(int[] gas, int[] cost) {
        int total = 0;
        int sum = 0;
        int result = 0;
        for (int i = 0; i < gas.length; ++i) {
            // total 计算总油量-总消耗
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            // 当走完一段的路程油不够时，更换起始点为 i+1
            if (sum < 0) {
                result = i + 1;
                sum = 0;
            }
        }
        return (total < 0) ? -1 : result;
    }


    /**
     * 暴力法
     *
     * @param gas
     * @param cost
     * @return
     */
    private int canCompleteCircuit1(int[] gas, int[] cost) {
        int n = gas.length;

        for (int i = 0; i < n; i++) {
            int remainingGas = gas[i];
            for (int j = i + 1; j < i + n + 1; j++) {
                remainingGas -= cost[(j - 1) % n];
                if (remainingGas < 0) {
                    break;
                }
                remainingGas += gas[j % n];
            }
            if (remainingGas >= 0) {
                return i;
            }
        }
        return -1;
    }
}
