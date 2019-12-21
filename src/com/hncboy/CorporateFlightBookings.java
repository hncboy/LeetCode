package com.hncboy;

import java.util.Arrays;

/**
 * @author hncboy
 * @date 2019/12/21 12:10
 * @description 1109.航班预订统计
 *
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 * 我们这儿有一份航班预订表，表中第 i 条预订记录 bookings[i] = [i, j, k] 
 * 意味着我们在从 i 到 j 的每个航班上预订了 k 个座位。
 * 请你返回一个长度为 n 的数组 answer，按航班编号顺序返回每个航班上预订的座位数。
 *
 * 示例：
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 *
 * 提示：
 * 1 <= bookings.length <= 20000
 * 1 <= bookings[i][0] <= bookings[i][1] <= n <= 20000
 * 1 <= bookings[i][2] <= 10000
 */
public class CorporateFlightBookings {

    public static void main(String[] args) {
        CorporateFlightBookings c = new CorporateFlightBookings();
        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        System.out.println(Arrays.toString(c.corpFlightBookings(bookings, 5)));
    }

    private int[] corpFlightBookings(int[][] bookings, int n) {
        int[] counters = new int[n];
        for (int[] booking : bookings) {
            // 计算该编号航班出发点的人数
            counters[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                // 减去该编号航班下飞机的人数
                counters[booking[1]] -= booking[2];
            }
        }

        // 统计上一天和当天的总人数
        for (int i = 1; i < n; ++i) {
            counters[i] += counters[i - 1];
        }

        return counters;
    }
}
