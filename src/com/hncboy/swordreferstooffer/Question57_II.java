package com.hncboy.swordreferstooffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hncboy
 * @date 2020/3/6 0:21
 * @description 面试题 57 - II.和为s的连续正数序列
 *
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 *
 * 示例 2：
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * 限制：
 * 1 <= target <= 10^5
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question57_II {

    public static void main(String[] args) {
        Question57_II q = new Question57_II();
        System.out.println(Arrays.deepToString(q.findContinuousSequence(9)));
    }

    private int[][] findContinuousSequence(int target) {
        List<List<Integer>> ll = new ArrayList<>();
        int low = 1;
        int high = 2;
        while (low < high) {
            // 根据求和公式计算区间 [low,high] 内和
            int total = (low + high) * (high - low + 1) / 2;
            // 如果 [low,high] 内的结果等于目标结果
            if (total == target) {
                List<Integer> sub = new ArrayList<>();
                for (int i = low; i <= high; i++) {
                    sub.add(i);
                }
                ll.add(sub);
                low++;
            } else if (total < target) {
                high++;
            } else {
                low++;
            }
        }

        int[][] result = new int[ll.size()][];
        for (int i = 0; i < ll.size(); i++) {
            result[i] = new int[ll.get(i).size()];
            for (int j = 0; j < ll.get(i).size(); j++) {
                result[i][j] = ll.get(i).get(j);
            }
        }

        return result;
    }
}
